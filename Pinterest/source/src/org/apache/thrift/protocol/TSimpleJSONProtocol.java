// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Stack;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TField, TMessage, 
//            TSet, TList, TMap

public class TSimpleJSONProtocol extends TProtocol
{

    private static final TField ANONYMOUS_FIELD = new TField();
    private static final TStruct ANONYMOUS_STRUCT = new TStruct();
    public static final byte COLON[] = {
        58
    };
    public static final byte COMMA[] = {
        44
    };
    private static final TList EMPTY_LIST = new TList();
    private static final TMap EMPTY_MAP = new TMap();
    private static final TMessage EMPTY_MESSAGE = new TMessage();
    private static final TSet EMPTY_SET = new TSet();
    public static final byte LBRACE[] = {
        123
    };
    public static final byte LBRACKET[] = {
        91
    };
    public static final char QUOTE = 34;
    public static final byte RBRACE[] = {
        125
    };
    public static final byte RBRACKET[] = {
        93
    };
    protected final Context BASE_CONTEXT = new Context();
    protected Stack writeContextStack_;
    protected Context writeContext_;

    public TSimpleJSONProtocol(TTransport ttransport)
    {
        super(ttransport);
        writeContextStack_ = new Stack();
        writeContext_ = BASE_CONTEXT;
    }

    public void _writeStringData(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
            trans_.write(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    protected void popWriteContext()
    {
        writeContext_ = (Context)writeContextStack_.pop();
    }

    protected void pushWriteContext(Context context)
    {
        writeContextStack_.push(writeContext_);
        writeContext_ = context;
    }

    public ByteBuffer readBinary()
    {
        return ByteBuffer.wrap(new byte[0]);
    }

    public boolean readBool()
    {
        return readByte() == 1;
    }

    public byte readByte()
    {
        return 0;
    }

    public double readDouble()
    {
        return 0.0D;
    }

    public TField readFieldBegin()
    {
        return ANONYMOUS_FIELD;
    }

    public void readFieldEnd()
    {
    }

    public short readI16()
    {
        return 0;
    }

    public int readI32()
    {
        return 0;
    }

    public long readI64()
    {
        return 0L;
    }

    public TList readListBegin()
    {
        return EMPTY_LIST;
    }

    public void readListEnd()
    {
    }

    public TMap readMapBegin()
    {
        return EMPTY_MAP;
    }

    public void readMapEnd()
    {
    }

    public TMessage readMessageBegin()
    {
        return EMPTY_MESSAGE;
    }

    public void readMessageEnd()
    {
    }

    public TSet readSetBegin()
    {
        return EMPTY_SET;
    }

    public void readSetEnd()
    {
    }

    public String readString()
    {
        return "";
    }

    public String readStringBody(int i)
    {
        return "";
    }

    public TStruct readStructBegin()
    {
        return ANONYMOUS_STRUCT;
    }

    public void readStructEnd()
    {
    }

    public void writeBinary(ByteBuffer bytebuffer)
    {
        try
        {
            writeString(new String(bytebuffer.array(), bytebuffer.position() + bytebuffer.arrayOffset(), bytebuffer.limit() - bytebuffer.position() - bytebuffer.arrayOffset(), "UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void writeBool(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        writeByte(byte0);
    }

    public void writeByte(byte byte0)
    {
        writeI32(byte0);
    }

    public void writeDouble(double d)
    {
        writeContext_.write();
        _writeStringData(Double.toString(d));
    }

    public void writeFieldBegin(TField tfield)
    {
        writeString(tfield.name);
    }

    public void writeFieldEnd()
    {
    }

    public void writeFieldStop()
    {
    }

    public void writeI16(short word0)
    {
        writeI32(word0);
    }

    public void writeI32(int i)
    {
        writeContext_.write();
        _writeStringData(Integer.toString(i));
    }

    public void writeI64(long l)
    {
        writeContext_.write();
        _writeStringData(Long.toString(l));
    }

    public void writeListBegin(TList tlist)
    {
        writeContext_.write();
        trans_.write(LBRACKET);
        pushWriteContext(new ListContext());
    }

    public void writeListEnd()
    {
        popWriteContext();
        trans_.write(RBRACKET);
    }

    public void writeMapBegin(TMap tmap)
    {
        writeContext_.write();
        trans_.write(LBRACE);
        pushWriteContext(new StructContext());
    }

    public void writeMapEnd()
    {
        popWriteContext();
        trans_.write(RBRACE);
    }

    public void writeMessageBegin(TMessage tmessage)
    {
        trans_.write(LBRACKET);
        pushWriteContext(new ListContext());
        writeString(tmessage.name);
        writeByte(tmessage.type);
        writeI32(tmessage.seqid);
    }

    public void writeMessageEnd()
    {
        popWriteContext();
        trans_.write(RBRACKET);
    }

    public void writeSetBegin(TSet tset)
    {
        writeContext_.write();
        trans_.write(LBRACKET);
        pushWriteContext(new ListContext());
    }

    public void writeSetEnd()
    {
        popWriteContext();
        trans_.write(RBRACKET);
    }

    public void writeString(String s)
    {
        StringBuffer stringbuffer;
        int i;
        int k;
        writeContext_.write();
        k = s.length();
        stringbuffer = new StringBuffer(k + 16);
        stringbuffer.append('"');
        i = 0;
_L9:
        char c;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 7: default 116
    //                   8: 193
    //                   9: 261
    //                   10: 227
    //                   12: 210
    //                   13: 244
    //                   34: 171
    //                   92: 171;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L2:
        break; /* Loop/switch isn't completed */
_L7:
        stringbuffer.append('\\');
        stringbuffer.append(c);
_L10:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        stringbuffer.append('\\');
        stringbuffer.append('b');
          goto _L10
_L5:
        stringbuffer.append('\\');
        stringbuffer.append('f');
          goto _L10
_L4:
        stringbuffer.append('\\');
        stringbuffer.append('n');
          goto _L10
_L6:
        stringbuffer.append('\\');
        stringbuffer.append('r');
          goto _L10
_L3:
        stringbuffer.append('\\');
        stringbuffer.append('t');
          goto _L10
_L1:
        if (c >= ' ')
        {
            break MISSING_BLOCK_LABEL_288;
        }
        String s1 = Integer.toHexString(c);
        stringbuffer.append('\\');
        stringbuffer.append('u');
        for (int j = 4; j > s1.length(); j--)
        {
            stringbuffer.append('0');
        }

        stringbuffer.append(s1);
        break; /* Loop/switch isn't completed */
        stringbuffer.append(c);
          goto _L10
        stringbuffer.append('"');
        _writeStringData(stringbuffer.toString());
        return;
    }

    public void writeStructBegin(TStruct tstruct)
    {
        writeContext_.write();
        trans_.write(LBRACE);
        pushWriteContext(new StructContext());
    }

    public void writeStructEnd()
    {
        popWriteContext();
        trans_.write(RBRACE);
    }


    private class Context
    {

        final TSimpleJSONProtocol this$0;

        protected void write()
        {
        }

        protected Context()
        {
            this$0 = TSimpleJSONProtocol.this;
            super();
        }
    }


    private class ListContext extends Context
    {

        protected boolean first_;
        final TSimpleJSONProtocol this$0;

        protected void write()
        {
            if (first_)
            {
                first_ = false;
                return;
            } else
            {
                trans_.write(TSimpleJSONProtocol.COMMA);
                return;
            }
        }

        protected ListContext()
        {
            this$0 = TSimpleJSONProtocol.this;
            super();
            first_ = true;
        }
    }


    private class StructContext extends Context
    {

        protected boolean colon_;
        protected boolean first_;
        final TSimpleJSONProtocol this$0;

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
                    abyte0 = TSimpleJSONProtocol.COLON;
                } else
                {
                    abyte0 = TSimpleJSONProtocol.COMMA;
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

        protected StructContext()
        {
            this$0 = TSimpleJSONProtocol.this;
            super();
            first_ = true;
            colon_ = true;
        }
    }

}
