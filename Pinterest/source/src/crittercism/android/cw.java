// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.os.ConditionVariable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Referenced classes of package crittercism.android:
//            cv

public final class cw extends cv
{

    private BufferedReader a;
    private InputStream b;
    private ConditionVariable c;
    private Process d;
    private StringBuilder e;
    private a f;
    private boolean g;

    public cw(Process process, ConditionVariable conditionvariable, a a1)
    {
        a = null;
        b = null;
        c = conditionvariable;
        d = process;
        e = new StringBuilder();
        f = a1;
        g = false;
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        g = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a()
    {
        if (f != a.a) goto _L2; else goto _L1
_L1:
        Object obj = d.getInputStream();
_L4:
        b = ((InputStream) (obj));
        a = new BufferedReader(new InputStreamReader(b));
_L3:
        obj = a.readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        e.append(((String) (obj))).append('\n');
          goto _L3
        obj;
_L5:
        Object obj1;
        try
        {
            a.close();
        }
        catch (IOException ioexception1) { }
        try
        {
            b.close();
        }
        catch (IOException ioexception) { }
        a = null;
        c();
        if (c != null)
        {
            c.open();
        }
        return;
_L2:
        obj = d.getErrorStream();
          goto _L4
        obj1;
        (new StringBuilder("Exception when attempting to read stream: ")).append(obj1.getClass().getName());
          goto _L5
        obj1;
        a = null;
        throw obj1;
          goto _L4
    }

    public final StringBuilder b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder = e;
_L4:
        this;
        JVM INSTR monitorexit ;
        return stringbuilder;
_L2:
        stringbuilder = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(crittercism/android/cw$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("STDOUT", 0);
            b = new a("STDERR", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

}
