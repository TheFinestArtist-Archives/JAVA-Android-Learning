// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// Referenced classes of package crittercism.android:
//            bi, bo, bv, bk, 
//            bz

public class bj
{

    private static final String a = crittercism/android/bj.getName();
    private final File b;
    private bz c;
    private int d;
    private int e;
    private int f;
    private bo g;
    private bv h;
    private boolean i;
    private String j;
    private String k;

    public bj(Context context, bi bi1)
    {
        String s = bi1.a();
        this(new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("//com.crittercism//").append(s).toString()), bi1.d(), bi1.e(), bi1.c(), bi1.g(), bi1.b(), bi1.h(), bi1.f());
    }

    private bj(File file, bo bo1, bz bz1, bv bv1, int l, int i1, String s, 
            String s1)
    {
        i = false;
        g = bo1;
        c = bz1;
        h = bv1;
        f = l;
        e = i1;
        j = s;
        k = s1;
        b = file;
        a(true);
        d = i().length;
    }

    private boolean a(boolean flag)
    {
        if (i)
        {
            Log.e(a, (new StringBuilder("Batch has been disabled: ")).append(b.getName()).toString());
        } else
        {
            if (flag)
            {
                b.mkdirs();
            }
            if (!b.isDirectory())
            {
                Log.e(a, (new StringBuilder("Unable to create directory ")).append(b.getName()).toString());
                i = true;
            }
            if (!i)
            {
                return true;
            }
        }
        return false;
    }

    private void g()
    {
        while (c() > j() && h()) ;
    }

    private boolean h()
    {
        File file;
        if (g != null)
        {
            if ((file = g.a(this)) != null && file.delete())
            {
                return true;
            }
        }
        return false;
    }

    private File[] i()
    {
        File afile1[] = b.listFiles();
        File afile[] = afile1;
        if (afile1 == null)
        {
            afile = new File[0];
        }
        return afile;
    }

    private int j()
    {
        this;
        JVM INSTR monitorenter ;
        int l = e;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final bj a(Context context)
    {
        String s = b.getName();
        s = (new StringBuilder()).append(s).append("_").append(UUID.randomUUID().toString()).toString();
        return new bj(new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("//com.crittercism/pending/").append(s).toString()), g, c, h, 0x7fffffff, 0x7fffffff, j, k);
    }

    public final void a()
    {
        int l = 0;
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(false);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        File afile[] = i();
_L4:
        if (l >= afile.length)
        {
            break; /* Loop/switch isn't completed */
        }
        afile[l].delete();
        l++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(bj bj1)
    {
        int l;
        int i1;
        for (l = 0; bj1 == null || (i1 = b.getName().compareTo(bj1.b.getName())) == 0;)
        {
            return;
        }

        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        bj bj3 = bj1;
        bj bj2 = this;
_L4:
        bj2;
        JVM INSTR monitorenter ;
        bj3;
        JVM INSTR monitorenter ;
        if (a(false) && bj1.a(false))
        {
            break; /* Loop/switch isn't completed */
        }
        bj3;
        JVM INSTR monitorexit ;
        bj2;
        JVM INSTR monitorexit ;
        return;
        bj1;
        bj2;
        JVM INSTR monitorexit ;
        throw bj1;
_L2:
        bj3 = this;
        bj2 = bj1;
        if (true) goto _L4; else goto _L3
_L3:
        File afile[] = b();
_L5:
        if (l >= afile.length)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        File file = new File(bj1.b, afile[l].getName());
        afile[l].renameTo(file);
        l++;
          goto _L5
        bj1.g();
        bj3;
        JVM INSTR monitorexit ;
        bj2;
        JVM INSTR monitorexit ;
        return;
        bj1;
        bj3;
        JVM INSTR monitorexit ;
        throw bj1;
    }

    public final boolean a(bk bk1)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(false);
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = flag1;
        Object obj;
        int l;
        if (d >= f)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new File(b, h.a());
        l = c();
        if (l != j())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        flag = flag1;
        if (!h())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l <= j())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        i = true;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        bk1;
        throw bk1;
        obj = new FileOutputStream(((File) (obj)));
        bk1.a(((java.io.OutputStream) (obj)));
        d = d + 1;
        flag = true;
        continue; /* Loop/switch isn't completed */
        bk1;
        (new StringBuilder("FileNotFoundException in add(): ")).append(bk1.getMessage());
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        bk1;
        (new StringBuilder("IOException in add(): ")).append(bk1.getMessage());
        flag = flag1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final File[] b()
    {
        File afile[] = i();
        Arrays.sort(afile);
        return afile;
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        int l = i().length;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final List d()
    {
        int l = 0;
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(false);
        if (flag) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L2:
        ArrayList arraylist;
        File afile[];
        arraylist = new ArrayList();
        afile = b();
_L5:
        obj = arraylist;
        if (l >= afile.length) goto _L4; else goto _L3
_L3:
        arraylist.add(c.a(afile[l]));
        l++;
          goto _L5
        Exception exception;
        exception;
        throw exception;
    }

    public final String e()
    {
        return j;
    }

    public final String f()
    {
        return k;
    }

}
