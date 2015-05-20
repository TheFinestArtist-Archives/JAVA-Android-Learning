// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.app.ActivityManager;
import android.content.Context;

// Referenced classes of package crittercism.android:
//            bp, bq

public final class 
    implements bp
{

    private Integer a;

    public final String a()
    {
        return "low_memory";
    }

    public final volatile Object b()
    {
        return a;
    }

    public moryInfo()
    {
        a = null;
        ActivityManager activitymanager = (ActivityManager)bq.b().getSystemService("activity");
        android.app.ityManager.MemoryInfo memoryinfo = new android.app.ityManager.MemoryInfo();
        activitymanager.getMemoryInfo(memoryinfo);
        int i;
        if (memoryinfo.lowMemory)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        a = Integer.valueOf(i);
    }
}
