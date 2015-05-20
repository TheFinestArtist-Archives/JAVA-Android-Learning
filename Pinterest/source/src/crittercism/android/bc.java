// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            bk, bl, be, bj, 
//            dp

public final class bc
    implements bk
{

    private JSONObject a;
    private JSONObject b;
    private long c;
    private JSONArray d;
    private String e;
    private String f;
    private String g;
    private JSONArray h;
    private JSONArray i;
    private String j;
    private a k;

    public bc(Throwable throwable, long l, a a1, bj bj1, bj bj2, bj bj3)
    {
        k = a1;
        a = (new bl()).a(new bq.a()).a(new bq.c()).a(new bq.b()).a(new bq.d()).a(new bq.e()).a(new bq.f()).a(new bq.h()).a(new bq.j()).a(new bq.k()).a(new bq.i()).a(new bq.y()).a(new bq.z()).a(new bq.l()).a(new bq.m()).a(new bq.n()).a(new bq.o()).a(new bq.p()).a(new bq.q()).a(new bq.r()).a(new bq.s()).a(new bq.t()).a(new bq.u()).a(new bq.v()).a(new bq.w()).a(new bq.x()).a();
        HashMap hashmap = new HashMap();
        hashmap.put(k.b(), (new be(bj1)).a);
        if (k == a.a && bj2.c() != 0)
        {
            hashmap.put(k.c(), (new be(bj2)).a);
        }
        b = new JSONObject(hashmap);
        c = l;
        int j1;
        if (a1 == a.a)
        {
            a1 = (new be(bj3)).a;
        } else
        {
            a1 = null;
        }
        d = a1;
        e = a(throwable);
        if (throwable.getMessage() == null)
        {
            a1 = new String();
        } else
        {
            a1 = throwable.getMessage();
        }
        f = a1;
        g = "android";
        i = a();
        j = dp.a.a();
        h = new JSONArray();
        throwable = b(throwable);
        j1 = throwable.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            a1 = throwable[i1];
            h.put(a1);
        }

    }

    private static String a(Throwable throwable)
    {
        do
        {
            String s = throwable.getClass().getName();
            Throwable throwable1 = throwable.getCause();
            if (throwable1 == null || throwable1 == throwable)
            {
                return s;
            }
            throwable = throwable1;
        } while (true);
    }

    private JSONArray a()
    {
        JSONArray jsonarray = new JSONArray();
        Iterator iterator = Thread.getAllStackTraces().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            HashMap hashmap = new HashMap();
            Thread thread = (Thread)entry.getKey();
            if (thread.getId() != c)
            {
                hashmap.put("name", thread.getName());
                hashmap.put("id", Long.valueOf(thread.getId()));
                hashmap.put("state", thread.getState().name());
                hashmap.put("stacktrace", new JSONArray(Arrays.asList((Object[])entry.getValue())));
                jsonarray.put(new JSONObject(hashmap));
            }
        } while (true);
        return jsonarray;
    }

    private static String[] b(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        do
        {
            throwable.printStackTrace(printwriter);
            Throwable throwable1 = throwable.getCause();
            if (throwable1 == null || throwable1 == throwable)
            {
                return stringwriter.toString().split("\n");
            }
            throwable = throwable1;
        } while (true);
    }

    public final void a(OutputStream outputstream)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("app_state", a);
        hashmap.put("breadcrumbs", b);
        hashmap.put("current_thread_id", Long.valueOf(c));
        if (d != null)
        {
            hashmap.put("endpoints", d);
        }
        hashmap.put("exception_name", e);
        hashmap.put("exception_reason", f);
        hashmap.put("platform", g);
        hashmap.put("threads", i);
        hashmap.put("ts", j);
        String s;
        if (c == 1L)
        {
            s = k.a();
        } else
        {
            s = (new StringBuilder()).append(k.a()).append("-bg").toString();
        }
        hashmap.put("type", s);
        hashmap.put("unsymbolized_stacktrace", h);
        outputstream = new OutputStreamWriter(outputstream);
        outputstream.write((new JSONObject(hashmap)).toString());
        outputstream.close();
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a f[];
        private String c;
        private String d;
        private String e;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(crittercism/android/bc$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        public final String a()
        {
            return e;
        }

        public final String b()
        {
            return c;
        }

        public final String c()
        {
            return d;
        }

        static 
        {
            a = new a("SDK", 0, "uhe", "crashed_session", "previous_session");
            b = new a("EXC", 1, "he", "current_session", "previous_session");
            f = (new a[] {
                a, b
            });
        }

        private a(String s, int l, String s1, String s2, String s3)
        {
            super(s, l);
            e = s1;
            c = s2;
            d = s3;
        }
    }

}
