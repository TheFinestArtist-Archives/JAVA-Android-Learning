// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


public final class TMessage
{

    public final String name;
    public final int seqid;
    public final byte type;

    public TMessage()
    {
        this("", (byte)0, 0);
    }

    public TMessage(String s, byte byte0, int i)
    {
        name = s;
        type = byte0;
        seqid = i;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof TMessage)
        {
            return equals((TMessage)obj);
        } else
        {
            return false;
        }
    }

    public final boolean equals(TMessage tmessage)
    {
        return name.equals(tmessage.name) && type == tmessage.type && seqid == tmessage.seqid;
    }

    public final String toString()
    {
        return (new StringBuilder("<TMessage name:'")).append(name).append("' type: ").append(type).append(" seqid:").append(seqid).append(">").toString();
    }
}
