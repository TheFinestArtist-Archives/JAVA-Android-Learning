// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jni.acr;

import jni.manager.GnsdkHandle;

public class GnsdkAcr
{

    public static native int gnsdk_acr_initialize(byte abyte0[]);

    public static native int gnsdk_acr_query_create(byte abyte0[], gnsdk_acr_callbacks_t gnsdk_acr_callbacks_t, byte abyte1[], GnsdkHandle gnsdkhandle);

    public static native int gnsdk_acr_query_init_audio_stream(byte abyte0[], int i, int j, int k, int l);

    public static native int gnsdk_acr_query_option_get(byte abyte0[], String s, String as[]);

    public static native int gnsdk_acr_query_option_set(byte abyte0[], String s, String s1);

    public static native int gnsdk_acr_query_release(byte abyte0[], gnsdk_acr_callbacks_t gnsdk_acr_callbacks_t);

    public static native int gnsdk_acr_query_write_audio_data(byte abyte0[], byte abyte1[], int i, long l);

    public static native int gnsdk_acr_shutdown();
}
