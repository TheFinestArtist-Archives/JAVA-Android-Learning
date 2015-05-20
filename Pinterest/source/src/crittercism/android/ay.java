// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Referenced classes of package crittercism.android:
//            au, av, aw, e, 
//            dk, ck, dn, az, 
//            d, cs, h, f, 
//            di, dm, dg, dj, 
//            bj, bi, dd, db, 
//            da, at, b

public final class ay
    implements au, av, aw, e
{

    static ay a;
    public boolean b;
    public Context c;
    public String d;
    public Thread.UncaughtExceptionHandler e;
    public dk f;
    bj g;
    bj h;
    bj i;
    bj j;
    bj k;
    bj l;
    bj m;
    ck n;
    public cs o;
    public f p;
    public ExecutorService q;
    public ExecutorService r;
    public at s;
    public boolean t;
    public String u;
    public az v;
    public d w;
    public dg x;

    private ay()
    {
        b = false;
        c = null;
        d = null;
        f = new dk();
        n = new ck();
        o = null;
        p = null;
        q = Executors.newCachedThreadPool(new dn());
        r = Executors.newSingleThreadExecutor(new dn());
        t = false;
        u = "";
        v = new az();
        w = new d(r);
    }

    public static ay r()
    {
        if (a == null)
        {
            a = new ay();
        }
        return a;
    }

    private String u()
    {
        try
        {
            if (u == null || u.equals(""))
            {
                u = c.getPackageName();
            }
        }
        catch (Exception exception)
        {
            Log.w("CrittercismInstance", "Call to getPackageName() failed.  Please contact us at support@crittercism.com.");
            u = new String();
        }
        return u;
    }

    public final AlertDialog a(Context context, String s1, String s2)
    {
        boolean flag = false;
        if (f.d())
        {
            Log.e("CrittercismInstance", "User has opted out of crittercism.  generateRateMyAppAlertDialog returning null.");
        } else
        if (!(context instanceof Activity))
        {
            Log.e("CrittercismInstance", "Context object must be an instance of Activity for AlertDialog to form correctly.  generateRateMyAppAlertDialog returning null.");
        } else
        if (s2 == null || s2 != null && s2.length() == 0)
        {
            Log.e("CrittercismInstance", "Message has to be a non-empty string.  generateRateMyAppAlertDialog returning null.");
        } else
        if (android.os.Build.VERSION.SDK_INT < 5)
        {
            Log.e("Crittercism", "Rate my app not supported below api level 5");
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            return null;
        }
        String s3 = t();
        if (s3 == null)
        {
            Log.e("Crittercism", "Cannot create proper URI to open app market.  Returning null.");
            return null;
        }
        context = new android.app.AlertDialog.Builder(context);
        context.setTitle(s1).setMessage(s2);
        try
        {
            context = context.create();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Crittercism", "Failed to create AlertDialog instance from AlertDialog.Builder.  Did you remember to call Looper.prepare() before calling Crittercism.generateRateMyAppAlertDialog()?");
            return null;
        }
        context.setButton(-1, "Yes", new _cls10(s3));
        context.setButton(-2, "No", new _cls11());
        context.setButton(-3, "Maybe Later", new _cls12());
        return context;
    }

    public final String a()
    {
        if (b)
        {
            return d;
        } else
        {
            return new String();
        }
    }

    public final String a(String s1, String s2)
    {
        Object obj = null;
        SharedPreferences sharedpreferences = c.getSharedPreferences(s1, 0);
        s1 = obj;
        if (sharedpreferences != null)
        {
            s1 = sharedpreferences.getString(s2, null);
        }
        return s1;
    }

    public final void a(b b1)
    {
        b1 = new _cls7(b1);
        if (!o.a(b1))
        {
            r.execute(b1);
        }
    }

    public final void a(h h1)
    {
        while (!t || !v.isOptmzEnabled() || !h1.a || h1.c) 
        {
            return;
        }
        Log.i("Crittercism", "Enabling OPTMZ");
        p.a(h1.d, TimeUnit.SECONDS);
        p.a();
    }

    public final void a(String s1)
    {
        f.b().b = true;
        (new dm(new _cls8())).start();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(0x10000000);
        intent.setData(Uri.parse(s1));
        c.startActivity(intent);
    }

    public final void a(String s1, String s2, int i1)
    {
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            s1 = s1.edit();
            if (s1 != null)
            {
                s1.remove(s2);
                s1.putInt(s2, i1);
                s1.commit();
            }
        }
    }

    public final void a(String s1, String s2, String s3)
    {
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            s1 = s1.edit();
            if (s1 != null)
            {
                s1.remove(s2);
                s1.putString(s2, s3);
                s1.commit();
            }
        }
    }

    public final void a(String s1, String s2, boolean flag)
    {
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            s1 = s1.edit();
            if (s1 != null)
            {
                s1.remove(s2);
                s1.putBoolean(s2, flag);
                s1.commit();
            }
        }
    }

    public final void a(Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        throwable = new _cls5(throwable, Thread.currentThread().getId());
        if (!o.a(throwable))
        {
            r.execute(throwable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        throwable;
        throw throwable;
    }

    public final int b(String s1, String s2)
    {
        int i1 = 0;
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            i1 = s1.getInt(s2, 0);
        }
        return i1;
    }

    public final String b()
    {
        return (new bq.c()).a;
    }

    public final String c()
    {
        String s1 = "";
        if (x != null)
        {
            s1 = x.a();
        }
        return s1;
    }

    public final boolean c(String s1, String s2)
    {
        boolean flag = false;
        s1 = c.getSharedPreferences(s1, 0);
        if (s1 != null)
        {
            flag = s1.getBoolean(s2, false);
        }
        return flag;
    }

    public final int d()
    {
        int i1 = -1;
        if (f != null)
        {
            i1 = Integer.valueOf(f.c().a).intValue();
        }
        return i1;
    }

    public final String e()
    {
        return (new bq.f()).a;
    }

    public final String f()
    {
        return "Android";
    }

    public final String g()
    {
        return Build.MODEL;
    }

    public final String h()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public final dk i()
    {
        return f;
    }

    public final bj j()
    {
        return g;
    }

    public final bj k()
    {
        return h;
    }

    public final bj l()
    {
        return i;
    }

    public final bj m()
    {
        return j;
    }

    public final bj n()
    {
        return k;
    }

    public final bj o()
    {
        return m;
    }

    public final bj p()
    {
        return l;
    }

    public final void q()
    {
        k = new bj(c, bi.e);
        l = new bj(c, bi.g);
        m = new bj(c, bi.f);
        g = new bj(c, bi.a);
        h = new bj(c, bi.b);
        i = new bj(c, bi.c);
        j = new bj(c, bi.d);
    }

    public final void s()
    {
        f.b().b = true;
        (new dm(new _cls9())).start();
    }

    public final String t()
    {
label0:
        {
            PackageManager packagemanager = c.getPackageManager();
            String s1 = u();
            Object obj1 = null;
            Object obj = obj1;
            if (s1 != null)
            {
                obj = obj1;
                if (s1.length() > 0)
                {
                    obj = dd.a(packagemanager.getInstallerPackageName(s1));
                    if (obj == null)
                    {
                        break label0;
                    }
                    obj = ((db) (obj)).a(s1).a();
                }
            }
            return ((String) (obj));
        }
        Log.w("Crittercism", "Could not find app market for this app.  Will try rate-my-app test target in config.");
        return v.getRateMyAppTestTarget();
    }

    private class _cls10
        implements android.content.DialogInterface.OnClickListener
    {

        final String a;
        final ay b;

        public final void onClick(DialogInterface dialoginterface, int i1)
        {
            try
            {
                ay.r().a(a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (DialogInterface dialoginterface)
            {
                Log.w("CrittercismInstance", "YES button failed.  Email support@crittercism.com.");
            }
        }

        _cls10(String s1)
        {
            b = ay.this;
            a = s1;
            super();
        }
    }


    private class _cls11
        implements android.content.DialogInterface.OnClickListener
    {

        final ay a;

        public final void onClick(DialogInterface dialoginterface, int i1)
        {
            try
            {
                ay.r().s();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (DialogInterface dialoginterface)
            {
                Log.w("CrittercismInstance", "NO button failed.  Email support@crittercism.com.");
            }
        }

        _cls11()
        {
            a = ay.this;
            super();
        }
    }


    private class _cls12
        implements android.content.DialogInterface.OnClickListener
    {

        final ay a;

        public final void onClick(DialogInterface dialoginterface, int i1)
        {
            try
            {
                ay.r();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (DialogInterface dialoginterface)
            {
                Log.w("CrittercismInstance", "MAYBE LATER button failed.  Email support@crittercism.com.");
            }
        }

        _cls12()
        {
            a = ay.this;
            super();
        }
    }


    private class _cls7 extends cv
    {

        final b a;
        final ay b;

        public final void a()
        {
            b.m.a(a);
        }

        _cls7(b b1)
        {
            b = ay.this;
            a = b1;
            super();
        }
    }


    private class _cls8 extends cv
    {

        final ay a;

        public final void a()
        {
            a.f.b().a(ay.a, cf.h.a(), cf.h.b());
        }

        _cls8()
        {
            a = ay.this;
            super();
        }
    }


    private class _cls5 extends cv
    {

        final Throwable a;
        final long b;
        final ay c;

        public final void a()
        {
            bc bc1;
            if (!c.f.d())
            {
                if (c.h.a(bc1 = new bc(a, b, bc.a.b, c.k, c.l, c.m)) && c.n.a())
                {
                    cr cr1 = new cr(c.c, ay.a);
                    cr1.a(c.h, new cn.a(), c.v.a());
                    cr1.a(c.o, c.q);
                    c.n.b();
                    return;
                }
            }
        }

        _cls5(Throwable throwable, long l1)
        {
            c = ay.this;
            a = throwable;
            b = l1;
            super();
        }
    }


    private class _cls9 extends cv
    {

        final ay a;

        public final void a()
        {
            a.f.b().a(ay.a, cf.h.a(), cf.h.b());
        }

        _cls9()
        {
            a = ay.this;
            super();
        }
    }

}
