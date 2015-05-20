// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

// Referenced classes of package crittercism.android:
//            bp, bq

public final class a
    implements bp
{

    public String a;

    public final String a()
    {
        return "carrier";
    }

    public final volatile Object b()
    {
        return a;
    }

    public nyManager()
    {
        a = null;
        String s;
        try
        {
            s = ((TelephonyManager)bq.b().getSystemService("phone")).getNetworkOperatorName();
        }
        catch (Exception exception)
        {
            exception = Build.BRAND;
        }
        a = s;
    }
}
