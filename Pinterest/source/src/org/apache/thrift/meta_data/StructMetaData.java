// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.meta_data;


// Referenced classes of package org.apache.thrift.meta_data:
//            FieldValueMetaData

public class StructMetaData extends FieldValueMetaData
{

    public final Class structClass;

    public StructMetaData(byte byte0, Class class1)
    {
        super(byte0);
        structClass = class1;
    }
}
