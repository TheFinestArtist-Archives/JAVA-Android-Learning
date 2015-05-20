// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.FpCache;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.StorageSqlite.GnStorageSqlite;
import com.gracenote.gnsdk.StorageSqlite.GnStorageSqliteModule;
import java.io.File;
import jni.lookup_fplocal.GnsdkLookupFpLocal;
import jni.manager.GnsdkErrors;

// Referenced classes of package com.gracenote.gnsdk.FpCache:
//            GnFpCacheModule

public class GnFpCache
{

    public GnFpCache()
    {
        GnSdk.a(new GnStorageSqliteModule());
        GnSdk.a(new GnFpCacheModule());
    }

    public static void a(String s, String s1)
    {
        new GnStorageSqlite();
        File file = new File(s1);
        if (!file.isDirectory())
        {
            throw new GnException("Invalid folder path");
        }
        if (!file.canWrite())
        {
            throw new GnException("No write permissions on this directory");
        }
        GnException.a(GnsdkLookupFpLocal.gnsdk_lookup_fplocal_storage_location_set(s, s1));
        GnStorageSqlite.a();
_L1:
        return;
        s;
        if (GnsdkErrors.g == GnsdkErrors.a(s.a()))
        {
            GnStorageSqlite.b(s1);
            return;
        }
          goto _L1
    }
}
