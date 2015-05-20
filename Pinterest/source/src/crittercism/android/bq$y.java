// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package crittercism.android:
//            bp, bq

public final class cs.xdpi
    implements bp
{

    private Float a;

    public final String a()
    {
        return "xdpi";
    }

    public final volatile Object b()
    {
        return a;
    }

    public cs()
    {
        a = null;
        a = Float.valueOf(bq.b().getResources().getDisplayMetrics().xdpi);
    }
}
