// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import android.util.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class CrittercismConfig
{

    public static final String API_VERSION = "4.3.0";
    private String a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private String g;
    private String h;
    private String i;
    private List j;
    private List k;

    public CrittercismConfig()
    {
        a = null;
        b = false;
        c = false;
        d = false;
        e = true;
        f = a();
        g = "com.crittercism/dumps";
        h = "Developer Reply";
        i = null;
        j = new LinkedList();
        k = new LinkedList();
    }

    public CrittercismConfig(CrittercismConfig crittercismconfig)
    {
        a = null;
        b = false;
        c = false;
        d = false;
        e = true;
        f = a();
        g = "com.crittercism/dumps";
        h = "Developer Reply";
        i = null;
        j = new LinkedList();
        k = new LinkedList();
        a = crittercismconfig.a;
        b = crittercismconfig.b;
        c = crittercismconfig.c;
        d = crittercismconfig.d;
        e = crittercismconfig.e;
        f = crittercismconfig.f;
        g = crittercismconfig.g;
        h = crittercismconfig.h;
        setURLBlacklistPatterns(crittercismconfig.j);
        setPreserveQueryStringPatterns(crittercismconfig.k);
        i = crittercismconfig.i;
    }

    public CrittercismConfig(JSONObject jsonobject)
    {
        a = null;
        b = false;
        c = false;
        d = false;
        e = true;
        f = a();
        g = "com.crittercism/dumps";
        h = "Developer Reply";
        i = null;
        j = new LinkedList();
        k = new LinkedList();
        a = a(jsonobject, "customVersionName", a);
        c = a(jsonobject, "includeVersionCode", c);
        d = a(jsonobject, "installNdk", d);
        b = a(jsonobject, "delaySendingAppLoad", b);
        e = a(jsonobject, "shouldCollectLogcat", e);
        g = a(jsonobject, "nativeDumpPath", g);
        h = a(jsonobject, "notificationTitle", h);
        f = a(jsonobject, "installApm", f);
    }

    private static int a(String s)
    {
        int l = 0;
        if (s != null)
        {
            l = s.hashCode();
        }
        return l;
    }

    private static String a(JSONObject jsonobject, String s, String s1)
    {
        String s2 = s1;
        if (jsonobject.has(s))
        {
            try
            {
                s2 = jsonobject.getString(s);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return s1;
            }
        }
        return s2;
    }

    private static final boolean a()
    {
        return android.os.Build.VERSION.SDK_INT >= 10 && android.os.Build.VERSION.SDK_INT <= 18;
    }

    protected static boolean a(String s, String s1)
    {
        if (s == null)
        {
            return s1 == null;
        } else
        {
            return s.equals(s1);
        }
    }

    private static boolean a(JSONObject jsonobject, String s, boolean flag)
    {
        boolean flag1 = flag;
        if (jsonobject.has(s))
        {
            try
            {
                flag1 = jsonobject.getBoolean(s);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return flag;
            }
        }
        return flag1;
    }

    public final boolean delaySendingAppLoad()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof CrittercismConfig)
        {
            if (b == ((CrittercismConfig) (obj = (CrittercismConfig)obj)).b && e == ((CrittercismConfig) (obj)).e && isNdkCrashReportingEnabled() == ((CrittercismConfig) (obj)).isNdkCrashReportingEnabled() && isOptmzEnabled() == ((CrittercismConfig) (obj)).isOptmzEnabled() && isVersionCodeToBeIncludedInVersionString() == ((CrittercismConfig) (obj)).isVersionCodeToBeIncludedInVersionString() && a(a, ((CrittercismConfig) (obj)).a) && a(h, ((CrittercismConfig) (obj)).h) && a(g, ((CrittercismConfig) (obj)).g) && j.equals(((CrittercismConfig) (obj)).j) && k.equals(((CrittercismConfig) (obj)).k) && a(i, ((CrittercismConfig) (obj)).i))
            {
                return true;
            }
        }
        return false;
    }

    public final String getCustomVersionName()
    {
        return a;
    }

    public final String getNativeDumpPath()
    {
        return g;
    }

    public final String getNotificationTitle()
    {
        return h;
    }

    public List getOptmzBlackListURLPatterns()
    {
        return getURLBlacklistPatterns();
    }

    public List getPreserveQueryStringPatterns()
    {
        return new LinkedList(k);
    }

    public final String getRateMyAppTestTarget()
    {
        return i;
    }

    public List getURLBlacklistPatterns()
    {
        return new LinkedList(j);
    }

    public int hashCode()
    {
        int l1 = 1;
        int i2 = a(a);
        int j2 = a(h);
        int k2 = a(g);
        int l2 = a(i);
        int i3 = j.hashCode();
        int j3 = k.hashCode();
        int l;
        int i1;
        int j1;
        int k1;
        if (b)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (e)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (isNdkCrashReportingEnabled())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (isOptmzEnabled())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (!isVersionCodeToBeIncludedInVersionString())
        {
            l1 = 0;
        }
        return Integer.valueOf((k1 + (j1 + (i1 + (l + 0 << 1) << 1) << 1) << 1) + l1).hashCode() + (j3 + (((((i2 + 0) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31) * 31;
    }

    public final boolean isLogcatReportingEnabled()
    {
        return e;
    }

    public final boolean isNdkCrashReportingEnabled()
    {
        return d;
    }

    public final boolean isOptmzEnabled()
    {
        return f;
    }

    public final boolean isVersionCodeToBeIncludedInVersionString()
    {
        return c;
    }

    public final void setCustomVersionName(String s)
    {
        a = s;
    }

    public final void setDelaySendingAppLoad(boolean flag)
    {
        b = flag;
    }

    public final void setLogcatReportingEnabled(boolean flag)
    {
        e = flag;
    }

    public final void setNativeDumpPath(String s)
    {
        g = s;
    }

    public final void setNdkCrashReportingEnabled(boolean flag)
    {
        d = flag;
    }

    public final void setNotificationTitle(String s)
    {
        h = s;
    }

    public void setOptmzBlackListURLPatterns(List list)
    {
        setURLBlacklistPatterns(list);
    }

    public final void setOptmzEnabled(boolean flag)
    {
        if (!a() && flag)
        {
            Log.i("Crittercism", "OPTMZ is currently only allowed for api levels 10 to 18.  APM will not be installed");
            return;
        } else
        {
            f = flag;
            return;
        }
    }

    public void setPreserveQueryStringPatterns(List list)
    {
        k.clear();
        if (list != null)
        {
            k.addAll(list);
        }
    }

    public final void setRateMyAppTestTarget(String s)
    {
        i = s;
    }

    public void setURLBlacklistPatterns(List list)
    {
        j.clear();
        if (list != null)
        {
            j.addAll(list);
        }
    }

    public final void setVersionCodeToBeIncludedInVersionString(boolean flag)
    {
        c = flag;
    }
}
