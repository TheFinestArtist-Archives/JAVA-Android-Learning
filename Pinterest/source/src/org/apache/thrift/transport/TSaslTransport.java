// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.UnsupportedEncodingException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport, TMemoryInputTransport, TTransportException, TFramedTransport

abstract class TSaslTransport extends TTransport
{

    static final boolean $assertionsDisabled;
    protected static final int DEFAULT_MAX_LENGTH = 0x7fffffff;
    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TSaslTransport);
    protected static final int MECHANISM_NAME_BYTES = 1;
    protected static final int PAYLOAD_LENGTH_BYTES = 4;
    protected static final int STATUS_BYTES = 1;
    private final byte messageHeader[];
    private TMemoryInputTransport readBuffer;
    private SaslParticipant sasl;
    private boolean shouldWrap;
    protected TTransport underlyingTransport;
    private final TByteArrayOutputStream writeBuffer;

    protected TSaslTransport(SaslClient saslclient, TTransport ttransport)
    {
        shouldWrap = false;
        readBuffer = new TMemoryInputTransport();
        writeBuffer = new TByteArrayOutputStream(1024);
        messageHeader = new byte[5];
        sasl = new SaslParticipant(saslclient);
        underlyingTransport = ttransport;
    }

    protected TSaslTransport(TTransport ttransport)
    {
        shouldWrap = false;
        readBuffer = new TMemoryInputTransport();
        writeBuffer = new TByteArrayOutputStream(1024);
        messageHeader = new byte[5];
        underlyingTransport = ttransport;
    }

    private void readFrame()
    {
        int i = readLength();
        if (i < 0)
        {
            throw new TTransportException((new StringBuilder("Read a negative frame size (")).append(i).append(")!").toString());
        }
        byte abyte1[] = new byte[i];
        LOGGER.debug("{}: reading data length: {}", getRole(), Integer.valueOf(i));
        underlyingTransport.readAll(abyte1, 0, i);
        byte abyte0[] = abyte1;
        if (shouldWrap)
        {
            abyte0 = sasl.unwrap(abyte1, 0, i);
            LOGGER.debug("data length after unwrap: {}", Integer.valueOf(abyte0.length));
        }
        readBuffer.reset(abyte0);
    }

    public void close()
    {
        underlyingTransport.close();
        try
        {
            sasl.dispose();
            return;
        }
        catch (SaslException saslexception)
        {
            return;
        }
    }

    public void flush()
    {
        byte abyte1[] = writeBuffer.get();
        int j = writeBuffer.len();
        writeBuffer.reset();
        int i = j;
        byte abyte0[] = abyte1;
        if (shouldWrap)
        {
            LOGGER.debug("data length before wrap: {}", Integer.valueOf(j));
            try
            {
                abyte0 = sasl.wrap(abyte1, 0, j);
            }
            catch (SaslException saslexception)
            {
                throw new TTransportException(saslexception);
            }
            i = abyte0.length;
        }
        LOGGER.debug("writing data length: {}", Integer.valueOf(i));
        writeLength(i);
        underlyingTransport.write(abyte0, 0, i);
        underlyingTransport.flush();
    }

    protected abstract SaslRole getRole();

    public SaslClient getSaslClient()
    {
        return sasl.saslClient;
    }

    public SaslServer getSaslServer()
    {
        return sasl.saslServer;
    }

    public TTransport getUnderlyingTransport()
    {
        return underlyingTransport;
    }

    protected abstract void handleSaslStartMessage();

    public boolean isOpen()
    {
        return underlyingTransport.isOpen() && sasl != null && sasl.isComplete();
    }

    public void open()
    {
        LOGGER.debug("opening transport {}", this);
        if (sasl != null && sasl.isComplete())
        {
            throw new TTransportException("SASL transport already open");
        }
        if (!underlyingTransport.isOpen())
        {
            underlyingTransport.open();
        }
        handleSaslStartMessage();
        LOGGER.debug("{}: Start message handled", getRole());
        Object obj = null;
_L14:
        if (sasl.isComplete()) goto _L2; else goto _L1
_L1:
        obj = receiveSaslMessage();
        if (((SaslResponse) (obj)).status != NegotiationStatus.COMPLETE && ((SaslResponse) (obj)).status != NegotiationStatus.OK)
        {
            throw new TTransportException((new StringBuilder("Expected COMPLETE or OK, got ")).append(((SaslResponse) (obj)).status).toString());
        }
          goto _L3
        obj;
        LOGGER.error("SASL negotiation failure", ((Throwable) (obj)));
        sendAndThrowMessage(NegotiationStatus.BAD, ((SaslException) (obj)).getMessage());
        underlyingTransport.close();
_L10:
        obj = (String)sasl.getNegotiatedProperty("javax.security.sasl.qop");
        if (obj != null && !((String) (obj)).equalsIgnoreCase("auth"))
        {
            shouldWrap = true;
        }
        return;
_L3:
        byte abyte0[] = sasl.evaluateChallengeOrResponse(((SaslResponse) (obj)).payload);
        if (((SaslResponse) (obj)).status != NegotiationStatus.COMPLETE || getRole() != SaslRole.CLIENT) goto _L5; else goto _L4
_L4:
        LOGGER.debug("{}: All done!", getRole());
_L2:
        LOGGER.debug("{}: Main negotiation loop complete", getRole());
        if (!$assertionsDisabled && !sasl.isComplete())
        {
            throw new AssertionError();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!sasl.isComplete()) goto _L7; else goto _L6
_L6:
        NegotiationStatus negotiationstatus = NegotiationStatus.COMPLETE;
_L8:
        sendSaslMessage(negotiationstatus, abyte0);
        continue; /* Loop/switch isn't completed */
_L7:
        negotiationstatus = NegotiationStatus.OK;
          goto _L8
        if (getRole() != SaslRole.CLIENT) goto _L10; else goto _L9
_L9:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((SaslResponse) (obj)).status != NegotiationStatus.OK) goto _L10; else goto _L11
_L11:
        LOGGER.debug("{}: SASL Client receiving last message", getRole());
        obj = receiveSaslMessage();
        if (((SaslResponse) (obj)).status == NegotiationStatus.COMPLETE) goto _L10; else goto _L12
_L12:
        throw new TTransportException((new StringBuilder("Expected SASL COMPLETE, but got ")).append(((SaslResponse) (obj)).status).toString());
        Exception exception;
        exception;
        underlyingTransport.close();
        throw exception;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (!isOpen())
        {
            throw new TTransportException("SASL authentication not complete");
        }
        int k = readBuffer.read(abyte0, i, j);
        if (k > 0)
        {
            return k;
        }
        try
        {
            readFrame();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(abyte0);
        }
        return readBuffer.read(abyte0, i, j);
    }

    protected int readLength()
    {
        byte abyte0[] = new byte[4];
        underlyingTransport.readAll(abyte0, 0, 4);
        return EncodingUtils.decodeBigEndian(abyte0);
    }

    protected SaslResponse receiveSaslMessage()
    {
        underlyingTransport.readAll(messageHeader, 0, messageHeader.length);
        byte byte0 = messageHeader[0];
        byte abyte0[] = new byte[EncodingUtils.decodeBigEndian(messageHeader, 1)];
        underlyingTransport.readAll(abyte0, 0, abyte0.length);
        NegotiationStatus negotiationstatus = NegotiationStatus.byValue(byte0);
        if (negotiationstatus == null)
        {
            sendAndThrowMessage(NegotiationStatus.ERROR, (new StringBuilder("Invalid status ")).append(byte0).toString());
        } else
        if (negotiationstatus == NegotiationStatus.BAD || negotiationstatus == NegotiationStatus.ERROR)
        {
            try
            {
                String s = new String(abyte0, "UTF-8");
                throw new TTransportException((new StringBuilder("Peer indicated failure: ")).append(s).toString());
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new TTransportException(unsupportedencodingexception);
            }
        }
        if (LOGGER.isDebugEnabled())
        {
            LOGGER.debug((new StringBuilder()).append(getRole()).append(": Received message with status {} and payload length {}").toString(), negotiationstatus, Integer.valueOf(abyte0.length));
        }
        return new SaslResponse(negotiationstatus, abyte0);
    }

    protected void sendAndThrowMessage(NegotiationStatus negotiationstatus, String s)
    {
        try
        {
            sendSaslMessage(negotiationstatus, s.getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (NegotiationStatus negotiationstatus)
        {
            LOGGER.warn("Could not send failure response", negotiationstatus);
            s = (new StringBuilder()).append(s).append("\nAlso, could not send response: ").append(negotiationstatus.toString()).toString();
        }
        throw new TTransportException(s);
    }

    protected void sendSaslMessage(NegotiationStatus negotiationstatus, byte abyte0[])
    {
        byte abyte1[] = abyte0;
        if (abyte0 == null)
        {
            abyte1 = new byte[0];
        }
        messageHeader[0] = negotiationstatus.getValue();
        EncodingUtils.encodeBigEndian(abyte1.length, messageHeader, 1);
        if (LOGGER.isDebugEnabled())
        {
            LOGGER.debug((new StringBuilder()).append(getRole()).append(": Writing message with status {} and payload length {}").toString(), negotiationstatus, Integer.valueOf(abyte1.length));
        }
        underlyingTransport.write(messageHeader);
        underlyingTransport.write(abyte1);
        underlyingTransport.flush();
    }

    protected void setSaslServer(SaslServer saslserver)
    {
        sasl = new SaslParticipant(saslserver);
    }

    public void write(byte abyte0[], int i, int j)
    {
        if (!isOpen())
        {
            throw new TTransportException("SASL authentication not complete");
        } else
        {
            writeBuffer.write(abyte0, i, j);
            return;
        }
    }

    protected void writeLength(int i)
    {
        byte abyte0[] = new byte[4];
        TFramedTransport.encodeFrameSize(i, abyte0);
        underlyingTransport.write(abyte0);
    }

    static 
    {
        boolean flag;
        if (!org/apache/thrift/transport/TSaslTransport.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private class SaslParticipant
    {

        public SaslClient saslClient;
        public SaslServer saslServer;

        public void dispose()
        {
            if (saslClient != null)
            {
                saslClient.dispose();
                return;
            } else
            {
                saslServer.dispose();
                return;
            }
        }

        public byte[] evaluateChallengeOrResponse(byte abyte0[])
        {
            if (saslClient != null)
            {
                return saslClient.evaluateChallenge(abyte0);
            } else
            {
                return saslServer.evaluateResponse(abyte0);
            }
        }

        public Object getNegotiatedProperty(String s)
        {
            if (saslClient != null)
            {
                return saslClient.getNegotiatedProperty(s);
            } else
            {
                return saslServer.getNegotiatedProperty(s);
            }
        }

        public boolean isComplete()
        {
            if (saslClient != null)
            {
                return saslClient.isComplete();
            } else
            {
                return saslServer.isComplete();
            }
        }

        public byte[] unwrap(byte abyte0[], int i, int j)
        {
            if (saslClient != null)
            {
                return saslClient.unwrap(abyte0, i, j);
            } else
            {
                return saslServer.unwrap(abyte0, i, j);
            }
        }

        public byte[] wrap(byte abyte0[], int i, int j)
        {
            if (saslClient != null)
            {
                return saslClient.wrap(abyte0, i, j);
            } else
            {
                return saslServer.wrap(abyte0, i, j);
            }
        }

        public SaslParticipant(SaslClient saslclient)
        {
            saslClient = saslclient;
        }

        public SaslParticipant(SaslServer saslserver)
        {
            saslServer = saslserver;
        }
    }


    private class SaslResponse
    {

        public byte payload[];
        public NegotiationStatus status;

        public SaslResponse(NegotiationStatus negotiationstatus, byte abyte0[])
        {
            status = negotiationstatus;
            payload = abyte0;
        }
    }


    private class NegotiationStatus extends Enum
    {

        private static final NegotiationStatus $VALUES[];
        public static final NegotiationStatus BAD;
        public static final NegotiationStatus COMPLETE;
        public static final NegotiationStatus ERROR;
        public static final NegotiationStatus OK;
        public static final NegotiationStatus START;
        private static final Map reverseMap;
        private final byte value;

        public static NegotiationStatus byValue(byte byte0)
        {
            return (NegotiationStatus)reverseMap.get(Byte.valueOf(byte0));
        }

        public static NegotiationStatus valueOf(String s)
        {
            return (NegotiationStatus)Enum.valueOf(org/apache/thrift/transport/TSaslTransport$NegotiationStatus, s);
        }

        public static NegotiationStatus[] values()
        {
            return (NegotiationStatus[])$VALUES.clone();
        }

        public final byte getValue()
        {
            return value;
        }

        static 
        {
            int i = 0;
            START = new NegotiationStatus("START", 0, (byte)1);
            OK = new NegotiationStatus("OK", 1, (byte)2);
            BAD = new NegotiationStatus("BAD", 2, (byte)3);
            ERROR = new NegotiationStatus("ERROR", 3, (byte)4);
            COMPLETE = new NegotiationStatus("COMPLETE", 4, (byte)5);
            $VALUES = (new NegotiationStatus[] {
                START, OK, BAD, ERROR, COMPLETE
            });
            reverseMap = new HashMap();
            NegotiationStatus anegotiationstatus[] = (NegotiationStatus[])org/apache/thrift/transport/TSaslTransport$NegotiationStatus.getEnumConstants();
            for (int j = anegotiationstatus.length; i < j; i++)
            {
                NegotiationStatus negotiationstatus = anegotiationstatus[i];
                reverseMap.put(Byte.valueOf(negotiationstatus.getValue()), negotiationstatus);
            }

        }

        private NegotiationStatus(String s, int i, byte byte0)
        {
            super(s, i);
            value = byte0;
        }
    }


    private class SaslRole extends Enum
    {

        private static final SaslRole $VALUES[];
        public static final SaslRole CLIENT;
        public static final SaslRole SERVER;

        public static SaslRole valueOf(String s)
        {
            return (SaslRole)Enum.valueOf(org/apache/thrift/transport/TSaslTransport$SaslRole, s);
        }

        public static SaslRole[] values()
        {
            return (SaslRole[])$VALUES.clone();
        }

        static 
        {
            SERVER = new SaslRole("SERVER", 0);
            CLIENT = new SaslRole("CLIENT", 1);
            $VALUES = (new SaslRole[] {
                SERVER, CLIENT
            });
        }

        private SaslRole(String s, int i)
        {
            super(s, i);
        }
    }

}
