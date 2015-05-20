// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.meta_data;


// Referenced classes of package org.apache.thrift.meta_data:
//            FieldValueMetaData

public class MapMetaData extends FieldValueMetaData
{

    public final FieldValueMetaData keyMetaData;
    public final FieldValueMetaData valueMetaData;

    public MapMetaData(byte byte0, FieldValueMetaData fieldvaluemetadata, FieldValueMetaData fieldvaluemetadata1)
    {
        super(byte0);
        keyMetaData = fieldvaluemetadata;
        valueMetaData = fieldvaluemetadata1;
    }
}
