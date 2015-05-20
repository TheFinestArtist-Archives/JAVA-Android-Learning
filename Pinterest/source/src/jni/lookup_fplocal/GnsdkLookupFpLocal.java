// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jni.lookup_fplocal;


public class GnsdkLookupFpLocal
{

    public static native int gnsdk_lookup_fplocal_initialize(byte abyte0[]);

    public static native int gnsdk_lookup_fplocal_shutdown();

    public static native int gnsdk_lookup_fplocal_storage_location_set(String s, String s1);
}
