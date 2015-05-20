// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CrittercismNDK
{

    private static final String LIBNAME = "libcrittercism-ndk.so";
    private static final int LIBRARY_VERSION = 2;
    private static boolean isNdkInstalled = false;

    public CrittercismNDK()
    {
    }

    public static native boolean checkLibraryVersion(int i);

    public static boolean copyLibFromAssets(Context context, File file)
    {
        if (file.exists())
        {
            return true;
        }
        byte abyte0[];
        file.getParentFile().mkdirs();
        file = new FileOutputStream(file);
        context = getJarredLibFileStream(context);
        abyte0 = new byte[8192];
_L1:
        int i = context.read(abyte0);
label0:
        {
            if (i < 0)
            {
                break label0;
            }
            try
            {
                file.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("Crittercism", (new StringBuilder("Could not install breakpad library: ")).append(context.toString()).toString());
                return false;
            }
        }
          goto _L1
        context.close();
        file.close();
        return true;
    }

    public static boolean doNdkSharedLibrariesExist(Context context)
    {
        try
        {
            getJarredLibFileStream(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static File getInstalledLibraryFile(Context context)
    {
        context = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/com.crittercism/lib/").toString();
        return new File((new StringBuilder()).append(context).append("libcrittercism-ndk.so").toString());
    }

    public static InputStream getJarredLibFileStream(Context context)
    {
        String s = "armeabi";
        if (System.getProperty("os.arch").contains("v7"))
        {
            s = (new StringBuilder()).append("armeabi").append("-v7a").toString();
        }
        return context.getAssets().open((new StringBuilder()).append(s).append("/libcrittercism-ndk.so").toString());
    }

    public static native boolean installNdk(String s);

    public static void installNdkLib(Context context, String s)
    {
        boolean flag = true;
        s = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/").append(s).toString();
        if (doNdkSharedLibrariesExist(context))
        {
            flag = loadLibraryFromAssets(context);
        } else
        {
            try
            {
                System.loadLibrary("crittercism-ndk");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                flag = false;
            }
        }
        if (flag) goto _L2; else goto _L1
_L1:
        Log.e("Crittercism", "Could not load native crash library");
_L4:
        return;
_L2:
        if (!installNdk(s)) goto _L4; else goto _L3
_L3:
        context = new File(s);
        context.getAbsolutePath();
        context.mkdirs();
        isNdkInstalled = true;
        return;
        context;
    }

    public static boolean isNdkCrashReportingInstalled()
    {
        return isNdkInstalled;
    }

    public static boolean loadLibraryFromAssets(Context context)
    {
        File file = getInstalledLibraryFile(context);
        if (copyLibFromAssets(context, file)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        try
        {
            System.load(file.getAbsolutePath());
            flag = checkLibraryVersion(2);
        }
        catch (Throwable throwable)
        {
            flag = false;
        }
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!copyLibFromAssets(context, file))
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            System.load(file.getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Crittercism", (new StringBuilder("Unable to load breakpad")).append(context.toString()).toString());
            return false;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

}
