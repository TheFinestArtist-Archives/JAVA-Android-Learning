// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


public class TField
{

    public final short id;
    public final String name;
    public final byte type;

    public TField()
    {
        this("", (byte)0, (short)0);
    }

    public TField(String s, byte byte0, short word0)
    {
        name = s;
        type = byte0;
        id = word0;
    }

    public boolean equals(TField tfield)
    {
        return type == tfield.type && id == tfield.id;
    }

    public String toString()
    {
        return (new StringBuilder("<TField name:'")).append(name).append("' type:").append(type).append(" field-id:").append(id).append(">").toString();
    }
}
