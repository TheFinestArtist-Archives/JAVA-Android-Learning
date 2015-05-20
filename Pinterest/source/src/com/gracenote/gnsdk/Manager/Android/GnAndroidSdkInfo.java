// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager.Android;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.IGnSdkInfo;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jni.manager.GnsdkManager;

// Referenced classes of package com.gracenote.gnsdk.Manager.Android:
//            GnApplicationContext

public class GnAndroidSdkInfo
    implements IGnSdkInfo
{

    private volatile String a;
    private volatile boolean b;
    private Context c;

    public GnAndroidSdkInfo()
    {
        a = null;
        b = false;
        if (GnSdk.f() != null)
        {
            c = GnSdk.f().a;
            return;
        } else
        {
            c = null;
            return;
        }
    }

    static String a()
    {
        return b();
    }

    static String a(GnAndroidSdkInfo gnandroidsdkinfo, String s)
    {
        gnandroidsdkinfo.a = s;
        return s;
    }

    private static String a(String s)
    {
        Object obj;
        int i;
        int j;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).reset();
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            j = s.length;
            obj = new StringBuilder(j << 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append(Character.forDigit((s[i] & 0xf0) >> 4, 16));
        ((StringBuilder) (obj)).append(Character.forDigit(s[i] & 0xf, 16));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_39;
_L1:
        s = ((StringBuilder) (obj)).toString();
        return s;
    }

    static boolean a(GnAndroidSdkInfo gnandroidsdkinfo)
    {
        gnandroidsdkinfo.b = true;
        return true;
    }

    private static String b()
    {
        Object obj;
        obj = Class.forName("android.app.ActivityThread");
        Method method = ((Class) (obj)).getDeclaredMethod("currentApplication", new Class[0]);
        method.setAccessible(true);
        obj = (Application)method.invoke(obj, new Object[0]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj = android.provider.Settings.Secure.getString(((Application) (obj)).getContentResolver(), "android_id");
        return ((String) (obj));
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public String getMFG()
    {
        return Build.MANUFACTURER;
    }

    public String getOS()
    {
        return (new StringBuilder("Android ")).append(android.os.Build.VERSION.RELEASE).toString();
    }

    public String getSDK()
    {
        return (new StringBuilder("Entourage SDK ")).append(GnsdkManager.gnsdk_manager_get_product_version()).toString();
    }

    public String getUID()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        if (c == null) goto _L4; else goto _L3
_L3:
        Context context = c;
        String s = null;
        if (context != null)
        {
            s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        a = s;
_L2:
        int i = 24 - a.length();
        Object obj = a;
        String s1;
        Object obj1;
        if (i > 0)
        {
            obj = a(a).substring(0, i);
            obj = (new StringBuilder()).append(a).append(((String) (obj))).toString();
        } else
        if (i < 0)
        {
            obj = a.substring(0, 24);
        }
        s1 = a((new StringBuilder()).append(((String) (obj))).append("gnsdk_client").toString()).substring(0, 8);
        return (new StringBuilder()).append(((String) (obj))).append(s1).toString();
_L4:
        a = b();
        if (a != null) goto _L2; else goto _L5
_L5:
        obj = new Object();
        (new Handler(Looper.getMainLooper())).post(new _cls1(obj));
        obj;
        JVM INSTR monitorenter ;
        while (!b) 
        {
            obj.wait(1000L);
        }
        break MISSING_BLOCK_LABEL_212;
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
        obj;
        JVM INSTR monitorexit ;
          goto _L2
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private class _cls1
        implements Runnable
    {

        final Object a;
        final GnAndroidSdkInfo b;

        public void run()
        {
            synchronized (a)
            {
                GnAndroidSdkInfo.a(b, GnAndroidSdkInfo.a());
                GnAndroidSdkInfo.a(b);
                a.notifyAll();
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls1(Object obj)
        {
            b = GnAndroidSdkInfo.this;
            a = obj;
            super();
        }
    }

}
