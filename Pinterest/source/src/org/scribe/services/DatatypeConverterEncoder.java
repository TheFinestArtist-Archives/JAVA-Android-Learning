// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;

import javax.xml.bind.DatatypeConverter;

// Referenced classes of package org.scribe.services:
//            Base64Encoder

public class DatatypeConverterEncoder extends Base64Encoder
{

    public DatatypeConverterEncoder()
    {
    }

    public String encode(byte abyte0[])
    {
        return DatatypeConverter.printBase64Binary(abyte0);
    }

    public String getType()
    {
        return "DatatypeConverter";
    }
}
