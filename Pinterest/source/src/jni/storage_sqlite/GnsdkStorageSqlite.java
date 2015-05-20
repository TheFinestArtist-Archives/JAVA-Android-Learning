// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jni.storage_sqlite;


public class GnsdkStorageSqlite
{

    public static native int gnsdk_storage_sqlite_initialize(byte abyte0[]);

    public static native int gnsdk_storage_sqlite_option_get(String s, String as[]);

    public static native int gnsdk_storage_sqlite_option_set(String s, String s1);

    public static native int gnsdk_storage_sqlite_shutdown();
}
