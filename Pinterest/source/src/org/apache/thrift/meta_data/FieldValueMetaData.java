// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.meta_data;

import java.io.Serializable;

public class FieldValueMetaData
    implements Serializable
{

    private final boolean isBinary;
    private final boolean isTypedefType;
    public final byte type;
    private final String typedefName;

    public FieldValueMetaData(byte byte0)
    {
        this(byte0, false);
    }

    public FieldValueMetaData(byte byte0, String s)
    {
        type = byte0;
        isTypedefType = true;
        typedefName = s;
        isBinary = false;
    }

    public FieldValueMetaData(byte byte0, boolean flag)
    {
        type = byte0;
        isTypedefType = false;
        typedefName = null;
        isBinary = flag;
    }

    public String getTypedefName()
    {
        return typedefName;
    }

    public boolean isBinary()
    {
        return isBinary;
    }

    public boolean isContainer()
    {
        return type == 15 || type == 13 || type == 14;
    }

    public boolean isStruct()
    {
        return type == 12;
    }

    public boolean isTypedef()
    {
        return isTypedefType;
    }
}
