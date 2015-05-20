// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.StorageSqlite;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.IGnModule;
import jni.manager.GnsdkHandle;
import jni.storage_sqlite.GnsdkStorageSqlite;

public final class GnStorageSqliteModule
    implements IGnModule
{

    public com.gracenote.gnsdk.Metadata.GnTypes.SDK a;

    public GnStorageSqliteModule()
    {
        a = com.gracenote.gnsdk.Metadata.GnTypes.SDK.a;
        a = com.gracenote.gnsdk.Metadata.GnTypes.SDK.m;
    }

    public final com.gracenote.gnsdk.Metadata.GnTypes.SDK getSDK()
    {
        return a;
    }

    public final void initialize()
    {
        GnException.a(GnsdkStorageSqlite.gnsdk_storage_sqlite_initialize(GnSdk.d().a));
    }

    public final void shutdown()
    {
        GnException.a(GnsdkStorageSqlite.gnsdk_storage_sqlite_shutdown());
    }
}
