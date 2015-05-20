// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


public final class cf extends Enum
{

    public static final cf a;
    public static final cf b;
    public static final cf c;
    public static final cf d;
    public static final cf e;
    public static final cf f;
    public static final cf g;
    public static final cf h;
    public static final cf i;
    public static final cf j;
    public static final cf k;
    public static final cf l;
    public static final cf m;
    private static final cf p[];
    private String n;
    private String o;

    private cf(String s, int i1, String s1, String s2)
    {
        super(s, i1);
        n = s1;
        o = s2;
    }

    public static cf valueOf(String s)
    {
        return (cf)Enum.valueOf(crittercism/android/cf, s);
    }

    public static cf[] values()
    {
        return (cf[])p.clone();
    }

    public final String a()
    {
        return n;
    }

    public final String b()
    {
        return o;
    }

    static 
    {
        a = new cf("APP_LOADS_FILES", 0, "com.crittercism.apploads", "appLoadFiles");
        b = new cf("HANDLED_EXCEPTION_FILES", 1, "com.crittercism.exceptions", "handledExceptionFiles");
        c = new cf("SDK_CRASHES_FILES", 2, "com.crittercism.sdkcrashes", "sdkCrashFiles");
        d = new cf("NDK_CRASHES_FILES", 3, "com.crittercism.ndkcrashes", "ndkCrashFiles");
        e = new cf("CURRENT_BREADCRUMBS_FILES", 4, "com.crittercism.breadcrumbs", "currentBreadcrumbFiles");
        f = new cf("PREVIOUS_BREADCRUMBS_FILES", 5, "com.crittercism.breadcrumbs", "previousBreadcrumbFiles");
        g = new cf("NETWORK_BREADCRUMBS_FILES", 6, "com.crittercism.breadcrumbs", "networkBreadcrumbFiles");
        h = new cf("RATE_APP_SETTING", 7, "com.crittercism.usersettings", "rateAppSettings");
        i = new cf("CRASHED_ON_LAST_LOAD_SETTING", 8, "com.crittercism.usersettings", "crashedOnLastLoad");
        j = new cf("OPT_OUT_STATUS_SETTING", 9, "com.crittercism.usersettings", "optOutStatusSettings");
        k = new cf("SESSION_ID_SETTING", 10, "com.crittercism.usersettings", "sessionIDSetting");
        l = new cf("OLD_SESSION_ID_SETTING", 11, "com.crittercism.prefs", "com.crittercism.prefs.sessid");
        m = new cf("OLD_OPT_OUT_STATUS_SETTING", 12, "com.crittercism.prefs", "optOutStatus");
        p = (new cf[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m
        });
    }
}
