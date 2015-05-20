// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.pm.PackageManager;
import com.crittercism.app.CrittercismConfig;

public final class bb
{

    public boolean a;
    public boolean b;
    public boolean c;

    public bb(Context context, CrittercismConfig crittercismconfig)
    {
        boolean flag;
        if (a("android.permission.READ_LOGS", context) || android.os.Build.VERSION.SDK_INT >= 16 && crittercismconfig.isLogcatReportingEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        c = a("android.permission.ACCESS_NETWORK_STATE", context);
        b = a("android.permission.GET_TASKS", context);
    }

    private static boolean a(String s, Context context)
    {
        return context.getPackageManager().checkPermission(s, context.getPackageName()) == 0;
    }
}
