// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            bp, bq, bb

class sRoaming
    implements bp
{

    private JSONObject a;

    public String a()
    {
        return null;
    }

    public final Object b()
    {
        return c();
    }

    public JSONObject c()
    {
        return a;
    }

    public anager(int i)
    {
        a = null;
        if (!bq.c().c)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        a = new JSONObject();
        NetworkInfo networkinfo = ((ConnectivityManager)bq.b().getSystemService("connectivity")).getNetworkInfo(i);
        try
        {
            a.put("available", networkinfo.isAvailable());
            a.put("connected", networkinfo.isConnected());
            if (!networkinfo.isConnected())
            {
                a.put("connecting", networkinfo.isConnectedOrConnecting());
            }
            a.put("failover", networkinfo.isFailover());
        }
        catch (JSONException jsonexception)
        {
            a = null;
            return;
        }
        if (i == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        a.put("roaming", networkinfo.isRoaming());
    }
}
