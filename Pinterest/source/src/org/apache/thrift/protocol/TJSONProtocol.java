// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Stack;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TProtocolException, TBase64Utils, 
//            TField, TList, TMap, TMessage, 
//            TSet

public class TJSONProtocol extends TProtocol
{

    private static final TStruct ANONYMOUS_STRUCT = new TStruct();
    private static final byte BACKSLASH[] = {
        92
    };
    private static final byte COLON[] = {
        58
    };
    private static final byte COMMA[] = {
        44
    };
    private static final int DEF_STRING_SIZE = 16;
    private static final String ESCAPE_CHARS = "\"\\bfnrt";
    private static final byte ESCAPE_CHAR_VALS[] = {
        34, 92, 8, 12, 10, 13, 9
    };
    private static final byte ESCSEQ[] = {
        92, 117, 48, 48
    };
    private static final byte JSON_CHAR_TABLE[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 98, 116, 
        110, 0, 102, 114, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 1, 1, 34, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1
    };
    private static final byte LBRACE[] = {
        123
    };
    private static final byte LBRACKET[] = {
        91
    };
    private static final byte NAME_BOOL[] = {
        116, 102
    };
    private static final byte NAME_BYTE[] = {
        105, 56
    };
    private static final byte NAME_DOUBLE[] = {
        100, 98, 108
    };
    private static final byte NAME_I16[] = {
        105, 49, 54
    };
    private static final byte NAME_I32[] = {
        105, 51, 50
    };
    private static final byte NAME_I64[] = {
        105, 54, 52
    };
    private static final byte NAME_LIST[] = {
        108, 115, 116
    };
    private static final byte NAME_MAP[] = {
        109, 97, 112
    };
    private static final byte NAME_SET[] = {
        115, 101, 116
    };
    private static final byte NAME_STRING[] = {
        115, 116, 114
    };
    private static final byte NAME_STRUCT[] = {
        114, 101, 99
    };
    private static final byte QUOTE[] = {
        34
    };
    private static final byte RBRACE[] = {
        125
    };
    private static final byte RBRACKET[] = {
        93
    };
    private static final long VERSION = 1L;
    private static final byte ZERO[] = {
        48
    };
    private Stack contextStack_;
    private JSONBaseContext context_;
    private LookaheadReader reader_;
    private byte tmpbuf_[];

    public TJSONProtocol(TTransport ttransport)
    {
        super(ttransport);
        contextStack_ = new Stack();
        context_ = new JSONBaseContext();
        reader_ = new LookaheadReader();
        tmpbuf_ = new byte[4];
    }

    private static final byte getTypeIDForTypeName(byte abyte0[])
    {
        byte byte0;
        boolean flag;
        flag = false;
        byte0 = flag;
        if (abyte0.length <= 1) goto _L2; else goto _L1
_L1:
        abyte0[0];
        JVM INSTR lookupswitch 7: default 80
    //                   100: 97
    //                   105: 102
    //                   108: 180
    //                   109: 186
    //                   114: 192
    //                   115: 198
    //                   116: 228;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_228;
_L3:
        byte0 = flag;
_L2:
        if (byte0 == 0)
        {
            throw new TProtocolException(5, "Unrecognized type");
        } else
        {
            return byte0;
        }
_L4:
        byte0 = 4;
          goto _L2
_L5:
        switch (abyte0[1])
        {
        case 50: // '2'
        case 52: // '4'
        case 53: // '5'
        case 55: // '7'
        default:
            byte0 = flag;
            break;

        case 49: // '1'
            byte0 = 6;
            break;

        case 56: // '8'
            byte0 = 3;
            break;

        case 51: // '3'
            byte0 = 8;
            break;

        case 54: // '6'
            byte0 = 10;
            break;
        }
        if (true) goto _L2; else goto _L11
_L11:
_L6:
        byte0 = 15;
          goto _L2
_L7:
        byte0 = 13;
          goto _L2
_L8:
        byte0 = 12;
          goto _L2
_L9:
        if (abyte0[1] == 116)
        {
            byte0 = 11;
        } else
        {
            byte0 = flag;
            if (abyte0[1] == 101)
            {
                byte0 = 14;
            }
        }
          goto _L2
        byte0 = 2;
          goto _L2
    }

    private static final byte[] getTypeNameForTypeID(byte byte0)
    {
        switch (byte0)
        {
        case 5: // '\005'
        case 7: // '\007'
        case 9: // '\t'
        default:
            throw new TProtocolException(5, "Unrecognized type");

        case 2: // '\002'
            return NAME_BOOL;

        case 3: // '\003'
            return NAME_BYTE;

        case 6: // '\006'
            return NAME_I16;

        case 8: // '\b'
            return NAME_I32;

        case 10: // '\n'
            return NAME_I64;

        case 4: // '\004'
            return NAME_DOUBLE;

        case 11: // '\013'
            return NAME_STRING;

        case 12: // '\f'
            return NAME_STRUCT;

        case 13: // '\r'
            return NAME_MAP;

        case 14: // '\016'
            return NAME_SET;

        case 15: // '\017'
            return NAME_LIST;
        }
    }

    private static final byte hexChar(byte byte0)
    {
        byte0 &= 0xf;
        if (byte0 < 10)
        {
            return (byte)((char)byte0 + 48);
        } else
        {
            return (byte)((char)(byte0 - 10) + 97);
        }
    }

    private static final byte hexVal(byte byte0)
    {
        if (byte0 >= 48 && byte0 <= 57)
        {
            return (byte)((char)byte0 - 48);
        }
        if (byte0 >= 97 && byte0 <= 102)
        {
            return (byte)(((char)byte0 - 97) + 10);
        } else
        {
            throw new TProtocolException(1, "Expected hex character");
        }
    }

    private boolean isJSONNumeric(byte byte0)
    {
        switch (byte0)
        {
        default:
            return false;

        case 43: // '+'
        case 45: // '-'
        case 46: // '.'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 69: // 'E'
        case 101: // 'e'
            return true;
        }
    }

    private void popContext()
    {
        context_ = (JSONBaseContext)contextStack_.pop();
    }

    private void pushContext(JSONBaseContext jsonbasecontext)
    {
        contextStack_.push(context_);
        context_ = jsonbasecontext;
    }

    private void readJSONArrayEnd()
    {
        readJSONSyntaxChar(RBRACKET);
        popContext();
    }

    private void readJSONArrayStart()
    {
        context_.read();
        readJSONSyntaxChar(LBRACKET);
        pushContext(new JSONListContext());
    }

    private byte[] readJSONBase64()
    {
        TByteArrayOutputStream tbytearrayoutputstream = readJSONString(false);
        byte abyte0[] = tbytearrayoutputstream.get();
        int j = tbytearrayoutputstream.len();
        int k = 0;
        int i;
        for (i = 0; j >= 4; i += 3)
        {
            TBase64Utils.decode(abyte0, k, 4, abyte0, i);
            k += 4;
            j -= 4;
        }

        int l = i;
        if (j > 1)
        {
            TBase64Utils.decode(abyte0, k, j, abyte0, i);
            l = i + (j - 1);
        }
        byte abyte1[] = new byte[l];
        System.arraycopy(abyte0, 0, abyte1, 0, l);
        return abyte1;
    }

    private double readJSONDouble()
    {
        double d;
        context_.read();
        if (reader_.peek() != QUOTE[0])
        {
            break MISSING_BLOCK_LABEL_98;
        }
        TByteArrayOutputStream tbytearrayoutputstream = readJSONString(true);
        double d1;
        try
        {
            d1 = Double.valueOf(tbytearrayoutputstream.toString("UTF-8")).doubleValue();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        d = d1;
        if (context_.escapeNum())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        d = d1;
        if (Double.isNaN(d1))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        d = d1;
        if (!Double.isInfinite(d1))
        {
            throw new TProtocolException(1, "Numeric data unexpectedly quoted");
        }
        break MISSING_BLOCK_LABEL_126;
        if (context_.escapeNum())
        {
            readJSONSyntaxChar(QUOTE);
        }
        try
        {
            d = Double.valueOf(readJSONNumericChars()).doubleValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new TProtocolException(1, "Bad data encounted in numeric data");
        }
        return d;
    }

    private long readJSONInteger()
    {
        context_.read();
        if (context_.escapeNum())
        {
            readJSONSyntaxChar(QUOTE);
        }
        String s = readJSONNumericChars();
        if (context_.escapeNum())
        {
            readJSONSyntaxChar(QUOTE);
        }
        long l;
        try
        {
            l = Long.valueOf(s).longValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new TProtocolException(1, "Bad data encounted in numeric data");
        }
        return l;
    }

    private String readJSONNumericChars()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (; isJSONNumeric(reader_.peek()); stringbuilder.append((char)reader_.read())) { }
        return stringbuilder.toString();
    }

    private void readJSONObjectEnd()
    {
        readJSONSyntaxChar(RBRACE);
        popContext();
    }

    private void readJSONObjectStart()
    {
        context_.read();
        readJSONSyntaxChar(LBRACE);
        pushContext(new JSONPairContext());
    }

    private TByteArrayOutputStream readJSONString(boolean flag)
    {
        TByteArrayOutputStream tbytearrayoutputstream = new TByteArrayOutputStream(16);
        if (!flag)
        {
            context_.read();
        }
        readJSONSyntaxChar(QUOTE);
        do
        {
            byte byte0 = reader_.read();
            if (byte0 != QUOTE[0])
            {
                int i = byte0;
                if (byte0 == ESCSEQ[0])
                {
                    i = reader_.read();
                    if (i == ESCSEQ[1])
                    {
                        readJSONSyntaxChar(ZERO);
                        readJSONSyntaxChar(ZERO);
                        trans_.readAll(tmpbuf_, 0, 2);
                        i = (byte)((hexVal(tmpbuf_[0]) << 4) + hexVal(tmpbuf_[1]));
                    } else
                    {
                        i = "\"\\bfnrt".indexOf(i);
                        if (i == -1)
                        {
                            throw new TProtocolException(1, "Expected control char");
                        }
                        i = ESCAPE_CHAR_VALS[i];
                    }
                }
                tbytearrayoutputstream.write(i);
            } else
            {
                return tbytearrayoutputstream;
            }
        } while (true);
    }

    private void writeJSONArrayEnd()
    {
        popContext();
        trans_.write(RBRACKET);
    }

    private void writeJSONArrayStart()
    {
        context_.write();
        trans_.write(LBRACKET);
        pushContext(new JSONListContext());
    }

    private void writeJSONBase64(byte abyte0[], int i, int j)
    {
        context_.write();
        trans_.write(QUOTE);
        for (; j >= 3; j -= 3)
        {
            TBase64Utils.encode(abyte0, i, 3, tmpbuf_, 0);
            trans_.write(tmpbuf_, 0, 4);
            i += 3;
        }

        if (j > 0)
        {
            TBase64Utils.encode(abyte0, i, j, tmpbuf_, 0);
            trans_.write(tmpbuf_, 0, j + 1);
        }
        trans_.write(QUOTE);
    }

    private void writeJSONDouble(double d)
    {
        byte abyte0[];
        boolean flag1;
        flag1 = false;
        context_.write();
        abyte0 = Double.toString(d);
        abyte0.charAt(0);
        JVM INSTR lookupswitch 3: default 56
    //                   45: 136
    //                   73: 130
    //                   78: 130;
           goto _L1 _L2 _L3 _L3
_L1:
        boolean flag = false;
_L8:
        if (flag) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (!context_.escapeNum()) goto _L6; else goto _L5
_L5:
        flag = true;
_L6:
        if (flag)
        {
            trans_.write(QUOTE);
        }
        try
        {
            abyte0 = abyte0.getBytes("UTF-8");
            trans_.write(abyte0, 0, abyte0.length);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        if (flag)
        {
            trans_.write(QUOTE);
        }
        return;
_L3:
        flag = true;
        break; /* Loop/switch isn't completed */
_L2:
        if (abyte0.charAt(1) != 'I')
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L1; else goto _L9
_L9:
    }

    private void writeJSONInteger(long l)
    {
        context_.write();
        String s = Long.toString(l);
        boolean flag = context_.escapeNum();
        if (flag)
        {
            trans_.write(QUOTE);
        }
        try
        {
            byte abyte0[] = s.getBytes("UTF-8");
            trans_.write(abyte0);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        if (flag)
        {
            trans_.write(QUOTE);
        }
    }

    private void writeJSONObjectEnd()
    {
        popContext();
        trans_.write(RBRACE);
    }

    private void writeJSONObjectStart()
    {
        context_.write();
        trans_.write(LBRACE);
        pushContext(new JSONPairContext());
    }

    private void writeJSONString(byte abyte0[])
    {
        context_.write();
        trans_.write(QUOTE);
        int j = abyte0.length;
        int i = 0;
        while (i < j) 
        {
            if ((abyte0[i] & 0xff) >= 48)
            {
                if (abyte0[i] == BACKSLASH[0])
                {
                    trans_.write(BACKSLASH);
                    trans_.write(BACKSLASH);
                } else
                {
                    trans_.write(abyte0, i, 1);
                }
            } else
            {
                tmpbuf_[0] = JSON_CHAR_TABLE[abyte0[i]];
                if (tmpbuf_[0] == 1)
                {
                    trans_.write(abyte0, i, 1);
                } else
                if (tmpbuf_[0] > 1)
                {
                    trans_.write(BACKSLASH);
                    trans_.write(tmpbuf_, 0, 1);
                } else
                {
                    trans_.write(ESCSEQ);
                    tmpbuf_[0] = hexChar((byte)(abyte0[i] >> 4));
                    tmpbuf_[1] = hexChar(abyte0[i]);
                    trans_.write(tmpbuf_, 0, 2);
                }
            }
            i++;
        }
        trans_.write(QUOTE);
    }

    public ByteBuffer readBinary()
    {
        return ByteBuffer.wrap(readJSONBase64());
    }

    public boolean readBool()
    {
        return readJSONInteger() != 0L;
    }

    public byte readByte()
    {
        return (byte)(int)readJSONInteger();
    }

    public double readDouble()
    {
        return readJSONDouble();
    }

    public TField readFieldBegin()
    {
        short word0 = 0;
        byte byte0;
        if (reader_.peek() == RBRACE[0])
        {
            byte0 = 0;
        } else
        {
            word0 = (short)(int)readJSONInteger();
            readJSONObjectStart();
            byte0 = getTypeIDForTypeName(readJSONString(false).get());
        }
        return new TField("", byte0, word0);
    }

    public void readFieldEnd()
    {
        readJSONObjectEnd();
    }

    public short readI16()
    {
        return (short)(int)readJSONInteger();
    }

    public int readI32()
    {
        return (int)readJSONInteger();
    }

    public long readI64()
    {
        return readJSONInteger();
    }

    protected void readJSONSyntaxChar(byte abyte0[])
    {
        byte byte0 = reader_.read();
        if (byte0 != abyte0[0])
        {
            throw new TProtocolException(1, (new StringBuilder("Unexpected character:")).append((char)byte0).toString());
        } else
        {
            return;
        }
    }

    public TList readListBegin()
    {
        readJSONArrayStart();
        return new TList(getTypeIDForTypeName(readJSONString(false).get()), (int)readJSONInteger());
    }

    public void readListEnd()
    {
        readJSONArrayEnd();
    }

    public TMap readMapBegin()
    {
        readJSONArrayStart();
        byte byte0 = getTypeIDForTypeName(readJSONString(false).get());
        byte byte1 = getTypeIDForTypeName(readJSONString(false).get());
        int i = (int)readJSONInteger();
        readJSONObjectStart();
        return new TMap(byte0, byte1, i);
    }

    public void readMapEnd()
    {
        readJSONObjectEnd();
        readJSONArrayEnd();
    }

    public TMessage readMessageBegin()
    {
        readJSONArrayStart();
        if (readJSONInteger() != 1L)
        {
            throw new TProtocolException(4, "Message contained bad version.");
        }
        String s;
        try
        {
            s = readJSONString(false).toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        return new TMessage(s, (byte)(int)readJSONInteger(), (int)readJSONInteger());
    }

    public void readMessageEnd()
    {
        readJSONArrayEnd();
    }

    public TSet readSetBegin()
    {
        readJSONArrayStart();
        return new TSet(getTypeIDForTypeName(readJSONString(false).get()), (int)readJSONInteger());
    }

    public void readSetEnd()
    {
        readJSONArrayEnd();
    }

    public String readString()
    {
        String s;
        try
        {
            s = readJSONString(false).toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        return s;
    }

    public TStruct readStructBegin()
    {
        readJSONObjectStart();
        return ANONYMOUS_STRUCT;
    }

    public void readStructEnd()
    {
        readJSONObjectEnd();
    }

    public void reset()
    {
        contextStack_.clear();
        context_ = new JSONBaseContext();
        reader_ = new LookaheadReader();
    }

    public void writeBinary(ByteBuffer bytebuffer)
    {
        writeJSONBase64(bytebuffer.array(), bytebuffer.position() + bytebuffer.arrayOffset(), bytebuffer.limit() - bytebuffer.position() - bytebuffer.arrayOffset());
    }

    public void writeBool(boolean flag)
    {
        long l;
        if (flag)
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        writeJSONInteger(l);
    }

    public void writeByte(byte byte0)
    {
        writeJSONInteger(byte0);
    }

    public void writeDouble(double d)
    {
        writeJSONDouble(d);
    }

    public void writeFieldBegin(TField tfield)
    {
        writeJSONInteger(tfield.id);
        writeJSONObjectStart();
        writeJSONString(getTypeNameForTypeID(tfield.type));
    }

    public void writeFieldEnd()
    {
        writeJSONObjectEnd();
    }

    public void writeFieldStop()
    {
    }

    public void writeI16(short word0)
    {
        writeJSONInteger(word0);
    }

    public void writeI32(int i)
    {
        writeJSONInteger(i);
    }

    public void writeI64(long l)
    {
        writeJSONInteger(l);
    }

    public void writeListBegin(TList tlist)
    {
        writeJSONArrayStart();
        writeJSONString(getTypeNameForTypeID(tlist.elemType));
        writeJSONInteger(tlist.size);
    }

    public void writeListEnd()
    {
        writeJSONArrayEnd();
    }

    public void writeMapBegin(TMap tmap)
    {
        writeJSONArrayStart();
        writeJSONString(getTypeNameForTypeID(tmap.keyType));
        writeJSONString(getTypeNameForTypeID(tmap.valueType));
        writeJSONInteger(tmap.size);
        writeJSONObjectStart();
    }

    public void writeMapEnd()
    {
        writeJSONObjectEnd();
        writeJSONArrayEnd();
    }

    public void writeMessageBegin(TMessage tmessage)
    {
        writeJSONArrayStart();
        writeJSONInteger(1L);
        try
        {
            writeJSONString(tmessage.name.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (TMessage tmessage)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        writeJSONInteger(tmessage.type);
        writeJSONInteger(tmessage.seqid);
    }

    public void writeMessageEnd()
    {
        writeJSONArrayEnd();
    }

    public void writeSetBegin(TSet tset)
    {
        writeJSONArrayStart();
        writeJSONString(getTypeNameForTypeID(tset.elemType));
        writeJSONInteger(tset.size);
    }

    public void writeSetEnd()
    {
        writeJSONArrayEnd();
    }

    public void writeString(String s)
    {
        try
        {
            writeJSONString(s.getBytes("UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void writeStructBegin(TStruct tstruct)
    {
        writeJSONObjectStart();
    }

    public void writeStructEnd()
    {
        writeJSONObjectEnd();
    }




    private class JSONBaseContext
    {

        final TJSONProtocol this$0;

        protected boolean escapeNum()
        {
            return false;
        }

        protected void read()
        {
        }

        protected void write()
        {
        }

        protected JSONBaseContext()
        {
            this$0 = TJSONProtocol.this;
            super();
        }
    }


    private class LookaheadReader
    {

        private byte data_[];
        private boolean hasData_;
        final TJSONProtocol this$0;

        protected byte peek()
        {
            if (!hasData_)
            {
                trans_.readAll(data_, 0, 1);
            }
            hasData_ = true;
            return data_[0];
        }

        protected byte read()
        {
            if (hasData_)
            {
                hasData_ = false;
            } else
            {
                trans_.readAll(data_, 0, 1);
            }
            return data_[0];
        }

        protected LookaheadReader()
        {
            this$0 = TJSONProtocol.this;
            super();
            data_ = new byte[1];
        }
    }


    private class JSONListContext extends JSONBaseContext
    {

        private boolean first_;
        final TJSONProtocol this$0;

        protected void read()
        {
            if (first_)
            {
                first_ = false;
                return;
            } else
            {
                readJSONSyntaxChar(TJSONProtocol.COMMA);
                return;
            }
        }

        protected void write()
        {
            if (first_)
            {
                first_ = false;
                return;
            } else
            {
                trans_.write(TJSONProtocol.COMMA);
                return;
            }
        }

        protected JSONListContext()
        {
            this$0 = TJSONProtocol.this;
            super();
            first_ = true;
        }
    }


    private class JSONPairContext extends JSONBaseContext
    {

        private boolean colon_;
        private boolean first_;
        final TJSONProtocol this$0;

        protected boolean escapeNum()
        {
            return colon_;
        }

        protected void read()
        {
            boolean flag;
            if (first_)
            {
                first_ = false;
                flag = true;
            } else
            {
                TJSONProtocol tjsonprotocol = TJSONProtocol.this;
                byte abyte0[];
                if (colon_)
                {
                    abyte0 = TJSONProtocol.COLON;
                } else
                {
                    abyte0 = TJSONProtocol.COMMA;
                }
                tjsonprotocol.readJSONSyntaxChar(abyte0);
                if (!colon_)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            colon_ = flag;
        }

        protected void write()
        {
            boolean flag;
            if (first_)
            {
                first_ = false;
                flag = true;
            } else
            {
                TTransport ttransport = trans_;
                byte abyte0[];
                if (colon_)
                {
                    abyte0 = TJSONProtocol.COLON;
                } else
                {
                    abyte0 = TJSONProtocol.COMMA;
                }
                ttransport.write(abyte0);
                if (!colon_)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            colon_ = flag;
        }

        protected JSONPairContext()
        {
            this$0 = TJSONProtocol.this;
            super();
            first_ = true;
            colon_ = true;
        }
    }

}
