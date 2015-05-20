// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import android.app.AlertDialog;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import crittercism.android.at;
import crittercism.android.ax;
import crittercism.android.ay;
import crittercism.android.az;
import crittercism.android.ba;
import crittercism.android.bb;
import crittercism.android.bq;
import crittercism.android.bu;
import crittercism.android.bx;
import crittercism.android.c;
import crittercism.android.cs;
import crittercism.android.cy;
import crittercism.android.d;
import crittercism.android.dg;
import crittercism.android.di;
import crittercism.android.dk;
import crittercism.android.dm;
import crittercism.android.f;
import crittercism.android.h;
import crittercism.android.i;
import java.io.File;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

// Referenced classes of package com.crittercism.app:
//            CrittercismConfig, CritterRateMyAppButtons

public class Crittercism
{

    private Crittercism()
    {
    }

    public static AlertDialog generateRateMyAppAlertDialog(Context context)
    {
        String s;
        Object obj;
        ay ay1;
        try
        {
            ay1 = ay.r();
            obj = ay1.f.b();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        s = ((di) (obj)).f;
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = ((di) (obj)).g;
_L4:
        context = ay1.a(context, ((String) (obj)), s);
        return context;
_L2:
        s = null;
          goto _L3
        obj = null;
          goto _L4
    }

    public static AlertDialog generateRateMyAppAlertDialog(Context context, String s, String s1)
    {
        try
        {
            context = ay.r().a(context, s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static void initialize(Context context, String s)
    {
        com/crittercism/app/Crittercism;
        JVM INSTR monitorenter ;
        initialize(context, s, new CrittercismConfig());
        com/crittercism/app/Crittercism;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void initialize(Context context, String s, CrittercismConfig crittercismconfig)
    {
        com/crittercism/app/Crittercism;
        JVM INSTR monitorenter ;
        if (!s.contains("CRITTERCISM_APP_ID")) goto _L2; else goto _L1
_L1:
        Log.e("Crittercism", "ERROR: Crittercism will not work unless you enter a valid Crittercism App ID. Check your settings page to find the ID.");
_L8:
        com/crittercism/app/Crittercism;
        JVM INSTR monitorexit ;
        return;
_L2:
        boolean flag = ay.r().b;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        ay ay1;
        ay1 = ay.r();
        Log.i("CrittercismInstance", "Initializing Crittercism...");
        ay1.d = s;
        ay1.v = new az(crittercismconfig);
        ay1.c = context;
        ay1.s = new at(ay1.c, ay1.v);
        ay1.u = context.getPackageName();
        ay1.x = new dg(context);
        bq.a(ay1.s);
        bq.a(ay1.c);
        bq.a(new bu());
        bq.a(new bb(ay1.c, ay1.v));
        if (!h.a(ay1.c).exists() && ay1.v.isOptmzEnabled()) goto _L4; else goto _L3
_L3:
        ay1.o = new cs(ay1.v, context, ay1, ay1, ay1);
        ay1.e = Thread.getDefaultUncaughtExceptionHandler();
        if (!(ay1.e instanceof ax))
        {
            Thread.setDefaultUncaughtExceptionHandler(new ax(ay1.e));
        }
        (new dm(ay1.o)).start();
        ay1.b = true;
        continue; /* Loop/switch isn't completed */
        context;
        (new StringBuilder("Exception in init > getInstance().initialize(..): ")).append(context.getClass().getName());
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        context;
        com/crittercism/app/Crittercism;
        JVM INSTR monitorexit ;
        throw context;
_L4:
        ay1.w.a(ay1.v.getOptmzBlackListURLPatterns());
        ay1.w.b(ay1.v.getPreserveQueryStringPatterns());
        s = new c(ay1.c);
        s = new i(ay1.w, s);
        ay1.p = new f(ay1, new URL((new StringBuilder()).append(ay1.v.b()).append("/api/apm/network").toString()));
        ay1.w.a(ay1.p);
        ay1.w.a(ay1);
        (new dm(ay1.p, "OPTMZ")).start();
        ay1.t = s.a();
_L6:
        (new StringBuilder("installedApm = ")).append(ay1.t);
        if (true) goto _L3; else goto _L5
_L5:
        s;
        (new StringBuilder("Exception in startApm: ")).append(s.getClass().getName());
          goto _L6
        context;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void leaveBreadcrumb(String s)
    {
        if (!ay.r().b)
        {
            Log.w("Crittercism", "Crittercism not initialized yet.  Returning.");
            return;
        }
        if (s == null)
        {
            ay ay1;
            try
            {
                Log.w("Crittercism", "Cannot leave null breadcrumb");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            break MISSING_BLOCK_LABEL_80;
        }
        ay1 = ay.r();
        s = new crittercism.android.ay._cls6(ay1, new bx(s));
        if (!ay1.o.a(s))
        {
            ay1.r.execute(s);
            return;
        }
    }

    public static void logHandledException(Throwable throwable)
    {
        try
        {
            if (!ay.r().f.d())
            {
                ay.r().a(throwable);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throw throwable;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return;
        }
    }

    public static void performRateMyAppButtonAction(CritterRateMyAppButtons critterratemyappbuttons)
    {
        ay ay1;
        String s;
        int j;
        try
        {
            if (ay.r().f.d())
            {
                Log.w("Crittercism", "User has opted out of crittercism.  performRateMyAppButtonAction exiting.");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (CritterRateMyAppButtons critterratemyappbuttons)
        {
            throw critterratemyappbuttons;
        }
        // Misplaced declaration of an exception variable
        catch (CritterRateMyAppButtons critterratemyappbuttons)
        {
            return;
        }
        ay1 = ay.r();
        if (android.os.Build.VERSION.SDK_INT < 5)
        {
            Log.w("Crittercism", "Rate my app not supported below api level 5");
            return;
        }
        s = ay1.t();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        Log.e("Crittercism", "Cannot create proper URI to open app market.  Returning null.");
        return;
        j = crittercism.android.ay._cls4.a[critterratemyappbuttons.ordinal()];
        j;
        JVM INSTR tableswitch 1 2: default 96
    //                   1 97
    //                   2 114;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        ay1.a(s);
        return;
        critterratemyappbuttons;
        Log.w("Crittercism", "performRateMyAppButtonAction(CritterRateMyAppButtons.YES) failed.  Email support@crittercism.com.");
        return;
_L3:
        try
        {
            ay1.s();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CritterRateMyAppButtons critterratemyappbuttons) { }
        Log.w("Crittercism", "performRateMyAppButtonAction(CritterRateMyAppButtons.NO) failed.  Email support@crittercism.com.");
        return;
    }

    public static void sendAppLoadData()
    {
        ay ay1;
        if (!ay.r().v.delaySendingAppLoad())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (ay.r().f.d())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        ay1 = ay.r();
        if (!ay1.v.delaySendingAppLoad())
        {
            Log.w("CrittercismInstance", "CrittercismConfig instance not set to delay sending app loads.");
            return;
        }
        try
        {
            crittercism.android.ay._cls1 _lcls1 = new crittercism.android.ay._cls1(ay1);
            if (!ay1.o.a(_lcls1))
            {
                ay1.r.execute(_lcls1);
                return;
            }
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable) { }
        break MISSING_BLOCK_LABEL_93;
        Log.i("Crittercism", "sendAppLoadData() will only send data to Crittercism if \"delaySendingAppLoad\" is set to true in the configuration settings you include in the init call.");
        return;
    }

    public static void setMetadata(JSONObject jsonobject)
    {
        if (!ay.r().b)
        {
            Log.w("Crittercism", "Crittercism not initialized yet.  Returning.");
            return;
        }
        try
        {
            ay ay1 = ay.r();
            jsonobject = new crittercism.android.ay._cls2(ay1, jsonobject);
            if (!ay1.o.a(jsonobject))
            {
                ay1.q.execute(jsonobject);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw jsonobject;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        return;
    }

    public static void setOptOutStatus(boolean flag)
    {
        if (!ay.r().b)
        {
            Log.w("Crittercism", "Crittercism not initialized yet.  Returning.");
            return;
        }
        try
        {
            ay ay1 = ay.r();
            cy cy1 = new cy(ay1.c, ay1, flag);
            if (!ay1.o.a(cy1))
            {
                ay1.r.execute(cy1);
                return;
            }
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable) { }
        return;
    }

    public static void setUsername(String s)
    {
        if (!ay.r().b)
        {
            Log.w("Crittercism", "Crittercism not initialized yet.  Returning.");
            return;
        }
        try
        {
            ay ay1 = ay.r();
            s = new crittercism.android.ay._cls3(ay1, s);
            if (!ay1.o.a(s))
            {
                ay1.q.execute(s);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        return;
    }

    public static void updateLocation(Location location)
    {
        if (!ay.r().b)
        {
            Log.w("Crittercism", "Crittercism not initialized yet.  Returning.");
            return;
        }
        if (location == null)
        {
            Log.w("Crittercism", "Cannot leave null location");
            return;
        } else
        {
            ba.a(location);
            return;
        }
    }
}
