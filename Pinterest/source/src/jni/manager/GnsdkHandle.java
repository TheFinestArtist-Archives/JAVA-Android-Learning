// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jni.manager;


public class GnsdkHandle
{

    public byte a[];

    public GnsdkHandle()
    {
    }

    public GnsdkHandle(byte abyte0[])
    {
        a(abyte0);
    }

    private void a(byte abyte0[])
    {
        a = new byte[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            a[i] = abyte0[i];
        }

    }
}
