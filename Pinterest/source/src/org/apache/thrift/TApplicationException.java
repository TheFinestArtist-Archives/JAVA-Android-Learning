// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package org.apache.thrift:
//            TException

public class TApplicationException extends TException
{

    public static final int BAD_SEQUENCE_ID = 4;
    public static final int INTERNAL_ERROR = 6;
    public static final int INVALID_MESSAGE_TYPE = 2;
    public static final int INVALID_PROTOCOL = 9;
    public static final int INVALID_TRANSFORM = 8;
    private static final TField MESSAGE_FIELD = new TField("message", (byte)11, (short)1);
    public static final int MISSING_RESULT = 5;
    public static final int PROTOCOL_ERROR = 7;
    private static final TStruct TAPPLICATION_EXCEPTION_STRUCT = new TStruct("TApplicationException");
    private static final TField TYPE_FIELD = new TField("type", (byte)8, (short)2);
    public static final int UNKNOWN = 0;
    public static final int UNKNOWN_METHOD = 1;
    public static final int UNSUPPORTED_CLIENT_TYPE = 10;
    public static final int WRONG_METHOD_NAME = 3;
    private static final long serialVersionUID = 1L;
    protected int type_;

    public TApplicationException()
    {
        type_ = 0;
    }

    public TApplicationException(int i)
    {
        type_ = 0;
        type_ = i;
    }

    public TApplicationException(int i, String s)
    {
        super(s);
        type_ = 0;
        type_ = i;
    }

    public TApplicationException(String s)
    {
        super(s);
        type_ = 0;
    }

    public static TApplicationException read(TProtocol tprotocol)
    {
        String s;
        int i;
        tprotocol.readStructBegin();
        s = null;
        i = 0;
_L2:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        switch (tfield.id)
        {
        default:
            TProtocolUtil.skip(tprotocol, tfield.type);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_91;
        }
_L3:
        tprotocol.readFieldEnd();
        if (true) goto _L2; else goto _L1
_L1:
        if (tfield.type == 11)
        {
            s = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        if (tfield.type == 8)
        {
            i = tprotocol.readI32();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        return new TApplicationException(i, s);
    }

    public int getType()
    {
        return type_;
    }

    public void write(TProtocol tprotocol)
    {
        tprotocol.writeStructBegin(TAPPLICATION_EXCEPTION_STRUCT);
        if (getMessage() != null)
        {
            tprotocol.writeFieldBegin(MESSAGE_FIELD);
            tprotocol.writeString(getMessage());
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(TYPE_FIELD);
        tprotocol.writeI32(type_);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

}
