// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

// Referenced classes of package crittercism.android:
//            g

public final class c
{

    private ConnectivityManager a;

    public c(Context context)
    {
        if (context == null)
        {
            Log.e("Crittercism", "Given a null Context.");
            return;
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0)
        {
            a = (ConnectivityManager)context.getSystemService("connectivity");
            return;
        } else
        {
            Log.e("Crittercism", "Add android.permission.ACCESS_NETWORK_STATE to AndroidManifest.xml to get more detailed OPTMZ data");
            return;
        }
    }

    public final g a()
    {
        g g2 = g.a;
        g g1 = g2;
        if (a != null)
        {
            NetworkInfo networkinfo = a.getActiveNetworkInfo();
            g1 = g2;
            if (networkinfo != null)
            {
                g1 = g.a(networkinfo.getType());
            }
        }
        return g1;
    }
}
