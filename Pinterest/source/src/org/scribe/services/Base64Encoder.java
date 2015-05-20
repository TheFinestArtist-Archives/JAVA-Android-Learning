// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;


// Referenced classes of package org.scribe.services:
//            CommonsEncoder, DatatypeConverterEncoder

public abstract class Base64Encoder
{

    private static Base64Encoder instance;

    public Base64Encoder()
    {
    }

    private static Base64Encoder createEncoderInstance()
    {
        if (CommonsEncoder.isPresent())
        {
            return new CommonsEncoder();
        } else
        {
            return new DatatypeConverterEncoder();
        }
    }

    public static Base64Encoder getInstance()
    {
        org/scribe/services/Base64Encoder;
        JVM INSTR monitorenter ;
        Base64Encoder base64encoder;
        if (instance == null)
        {
            instance = createEncoderInstance();
        }
        base64encoder = instance;
        org/scribe/services/Base64Encoder;
        JVM INSTR monitorexit ;
        return base64encoder;
        Exception exception;
        exception;
        throw exception;
    }

    public static String type()
    {
        return getInstance().getType();
    }

    public abstract String encode(byte abyte0[]);

    public abstract String getType();
}
