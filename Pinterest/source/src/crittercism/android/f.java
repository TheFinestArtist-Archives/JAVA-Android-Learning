// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            e, a, au, b

public final class f
    implements e, Runnable
{

    private List a;
    private URL b;
    private long c;
    private ConditionVariable d;
    private au e;
    private ConditionVariable f;
    private volatile boolean g;
    private final Object h;
    private int i;
    private volatile long j;

    public f(au au, URL url)
    {
        this(au, url, (byte)0);
    }

    private f(au au, URL url, byte byte0)
    {
        a = new LinkedList();
        b = null;
        c = System.currentTimeMillis();
        d = new ConditionVariable(false);
        f = new ConditionVariable(false);
        g = false;
        h = new Object();
        i = 50;
        j = 10000L;
        e = au;
        b = url;
        i = 50;
        j = 10000L;
    }

    private static boolean a(HttpURLConnection httpurlconnection, JSONObject jsonobject)
    {
        boolean flag = false;
        int k;
        try
        {
            httpurlconnection.getOutputStream().write(jsonobject.toString().getBytes("UTF8"));
            k = httpurlconnection.getResponseCode();
            httpurlconnection.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            return false;
        }
        if (k == 202)
        {
            flag = true;
        }
        return flag;
    }

    private long b()
    {
        long l1 = 0L;
        long l2 = j;
        long l3 = System.currentTimeMillis() - c;
        long l = l2;
        if (l3 > 0L)
        {
            l2 -= l3;
            l = l2;
            if (l2 < 0L)
            {
                l = l1;
            }
        }
        l1 = j;
        return l;
    }

    private HttpURLConnection c()
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)b.openConnection();
        httpurlconnection.setConnectTimeout(2500);
        httpurlconnection.setRequestProperty("User-Agent", "4.3.0");
        httpurlconnection.setRequestProperty("Content-Type", "application/json");
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setRequestMethod("POST");
        return httpurlconnection;
        IOException ioexception;
        ioexception;
        httpurlconnection = null;
_L2:
        Log.e("Crittercism", (new StringBuilder("Failed to instantiate URLConnection to APM server: ")).append(ioexception.getMessage()).toString());
        return httpurlconnection;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean d()
    {
        return !g && a.size() < i;
    }

    public final void a()
    {
        f.open();
    }

    public final void a(int k, TimeUnit timeunit)
    {
        j = timeunit.toMillis(k);
    }

    public final void a(b b1)
    {
label0:
        {
            if (!d())
            {
                return;
            }
            synchronized (h)
            {
                if (d())
                {
                    break label0;
                }
            }
            return;
        }
        a.add(b1);
        d.open();
        obj;
        JVM INSTR monitorexit ;
    }

    public final void run()
    {
_L2:
        boolean flag;
        if (g)
        {
            break; /* Loop/switch isn't completed */
        }
        f.block();
        d.block();
        flag = g;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            if (b() > 0L)
            {
                Thread.sleep(b());
            }
        }
        catch (InterruptedException interruptedexception) { }
        c = System.currentTimeMillis();
        obj = c();
        if (obj == null)
        {
            List list;
            try
            {
                g = true;
                Log.e("Crittercism", "Disabling APM due to failure instantiating connection");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("Crittercism", (new StringBuilder("Exited APM send task due to: \n")).append(obj).toString());
            }
            break MISSING_BLOCK_LABEL_160;
        }
        synchronized (h)
        {
            list = a;
            a = new LinkedList();
            d.close();
        }
        obj1 = crittercism.android.a.a(e, list);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        g = true;
        Log.e("Crittercism", "Disabling APM due to failure building request");
        return;
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        a(((HttpURLConnection) (obj)), ((a) (obj1)).a);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
