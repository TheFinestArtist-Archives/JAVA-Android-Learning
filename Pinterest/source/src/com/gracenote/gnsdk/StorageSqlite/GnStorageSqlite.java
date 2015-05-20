// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.StorageSqlite;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import java.io.File;
import jni.manager.GnsdkErrors;
import jni.storage_sqlite.GnsdkStorageSqlite;

// Referenced classes of package com.gracenote.gnsdk.StorageSqlite:
//            GnStorageSqliteModule

public class GnStorageSqlite
{

    public GnStorageSqlite()
    {
        GnSdk.a(new GnStorageSqliteModule());
    }

    public static String a()
    {
        String as[] = new String[1];
        GnException.a(GnsdkStorageSqlite.gnsdk_storage_sqlite_option_get("gnsdk_storage_sqlite_storage_temp_folder", as));
        return as[0];
    }

    public static void a(String s)
    {
        File file = new File(s);
        if (!file.isDirectory())
        {
            throw new GnException("Invalid folder path");
        }
        if (!file.canWrite())
        {
            throw new GnException("No write permissions on this directory");
        }
        a("gnsdk_storage_sqlite_storage_folder", s);
        a();
_L1:
        return;
        GnException gnexception;
        gnexception;
        if (GnsdkErrors.g == GnsdkErrors.a(gnexception.a()))
        {
            b(s);
            return;
        }
          goto _L1
    }

    private static void a(String s, String s1)
    {
        GnException.a(GnsdkStorageSqlite.gnsdk_storage_sqlite_option_set(s, s1));
    }

    public static void b(String s)
    {
        File file = new File(s);
        if (!file.isDirectory())
        {
            throw new GnException("Invalid folder path");
        }
        if (!file.canWrite())
        {
            throw new GnException("No write permissions on this directory");
        } else
        {
            a("gnsdk_storage_sqlite_storage_temp_folder", s);
            return;
        }
    }
}
