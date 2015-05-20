// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import com.crittercism.app.CrittercismNDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package crittercism.android:
//            cv, az, ay, dg, 
//            cu, au, dk, bj, 
//            bi, h, av, bq, 
//            bw, de, bx, bd, 
//            cr, aw

public final class cs extends cv
{

    private ConditionVariable a;
    private az b;
    private Context c;
    private av d;
    private aw e;
    private au f;
    private List g;
    private boolean h;
    private boolean i;
    private Exception j;

    public cs(az az1, Context context, av av1, aw aw, au au1)
    {
        a = new ConditionVariable();
        g = new ArrayList();
        h = false;
        j = null;
        b = az1;
        c = context;
        d = av1;
        e = aw;
        f = au1;
        i = false;
    }

    private void a(File file)
    {
        if (file.getAbsolutePath().contains("com.crittercism"))
        {
            if (file.isDirectory())
            {
                File afile[] = file.listFiles();
                int l = afile.length;
                for (int k = 0; k < l; k++)
                {
                    a(afile[k]);
                }

            }
            if (file.delete())
            {
                (new StringBuilder("Deleted ")).append(file.getName());
                return;
            }
        }
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        h = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = h;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private File e()
    {
        Object obj;
        int k;
        k = 0;
        obj = new File((new StringBuilder()).append(c.getFilesDir().getAbsolutePath()).append("/").append(b.getNativeDumpPath()).toString());
        if (((File) (obj)).exists() && ((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((obj = ((File) (obj)).listFiles()) != null)
        {
            if (obj.length != 1)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = obj[0];
            ((File) (obj)).isFile();
            if (((File) (obj)).isFile())
            {
                return ((File) (obj));
            }
        }
        continue; /* Loop/switch isn't completed */
        if (obj.length <= 1) goto _L1; else goto _L3
_L3:
        int l = obj.length;
        while (k < l) 
        {
            File file = obj[k];
            file.isFile();
            file.delete();
            k++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void a()
    {
        File file1;
        File file = new File((new StringBuilder()).append(c.getFilesDir().getAbsolutePath()).append("/com.crittercism/pending").toString());
        if (!file.exists() || file.isDirectory())
        {
            a(file);
        }
        ay.r().x.a();
        (new cu(c, f, e)).run();
        i = f.i().d();
        file1 = e();
        if (!i) goto _L2; else goto _L1
_L1:
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        if (file1.exists())
        {
            file1.isFile();
        }
        (new bj(c, bi.a)).a();
        (new bj(c, bi.b)).a();
        (new bj(c, bi.c)).a();
        (new bj(c, bi.d)).a();
        (new bj(c, bi.e)).a();
        (new bj(c, bi.g)).a();
        (new bj(c, bi.f)).a();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        file1.delete();
        crittercism.android.h.b(c);
_L14:
        c();
        for (Iterator iterator = g.iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
        break MISSING_BLOCK_LABEL_876;
        Object obj;
        obj;
        (new StringBuilder("Exception in run(): ")).append(((Exception) (obj)).getMessage());
        j = ((Exception) (obj));
        a.open();
        return;
_L2:
        Object obj1;
        Object obj2;
        obj2 = c;
        obj1 = new h(((Context) (obj2)));
        obj2 = ((Context) (obj2)).getSharedPreferences("com.crittercism.optmz.config", 0);
        if (!((SharedPreferences) (obj2)).contains("interval")) goto _L4; else goto _L3
_L3:
        obj1.d = ((SharedPreferences) (obj2)).getInt("interval", 10);
        if (!((SharedPreferences) (obj2)).contains("kill")) goto _L6; else goto _L5
_L5:
        obj1.c = ((SharedPreferences) (obj2)).getBoolean("kill", false);
        if (!((SharedPreferences) (obj2)).contains("persist")) goto _L8; else goto _L7
_L7:
        obj1.b = ((SharedPreferences) (obj2)).getBoolean("persist", false);
        if (!((SharedPreferences) (obj2)).contains("enabled")) goto _L10; else goto _L9
_L9:
        obj1.a = ((SharedPreferences) (obj2)).getBoolean("enabled", false);
_L11:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_467;
        }
        ay.r().a(((h) (obj1)));
        d.q();
        bq.a(f.i().e());
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_507;
        }
        if (file1.exists())
        {
            file1.isFile();
        }
        bj bj3;
        bj bj5;
        bj bj6;
        obj1 = f.i();
        obj2 = d.n();
        bj3 = d.o();
        bj5 = d.p();
        bj6 = d.l();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_600;
        }
        bj6.a(new bw(file1, ((bj) (obj2)), bj5, bj3));
        file1.delete();
        ((dk) (obj1)).a(new de(true));
        boolean flag;
        bj5.a();
        bj3.a();
        ((bj) (obj2)).a(bj5);
        ((bj) (obj2)).a(bx.a);
        flag = b.isNdkCrashReportingEnabled();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_652;
        }
        CrittercismNDK.installNdkLib(c, b.getNativeDumpPath());
_L12:
        obj1 = d.j();
        bj bj1 = d.k();
        bj bj2 = d.l();
        bj bj4 = d.m();
        ((bj) (obj1)).a(new bd());
        if (!b.delaySendingAppLoad())
        {
            cr cr1 = new cr(c, f);
            cr1.a(((bj) (obj1)), new ci.a(), b.a());
            cr1.a(bj1, new cn.a(), b.a());
            cr1.a(bj2, new cn.a(), b.a());
            cr1.a(bj4, new cn.a(), b.a());
            cr1.a();
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        a.open();
        throw obj1;
_L4:
        obj1 = null;
          goto _L11
_L6:
        obj1 = null;
          goto _L11
_L8:
        obj1 = null;
          goto _L11
_L10:
        obj1 = null;
          goto _L11
        obj1;
        (new StringBuilder("Exception installing ndk library: ")).append(obj1.getClass().getName());
          goto _L12
        a.open();
        return;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public final boolean a(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        if (d()) goto _L2; else goto _L1
_L1:
        g.add(runnable);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        runnable;
        throw runnable;
    }

    public final void b()
    {
        a.block();
    }
}
