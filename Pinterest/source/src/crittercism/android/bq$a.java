// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

// Referenced classes of package crittercism.android:
//            bp, bq, bb

public final class a
    implements bp
{

    private String a;

    public final String a()
    {
        return "activity";
    }

    public final volatile Object b()
    {
        return a;
    }

    public Name()
    {
        String s = null;
        super();
        a = null;
        if (bq.c().b)
        {
            s = ((android.app.ityManager.RunningTaskInfo)((ActivityManager)bq.b().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.flattenToShortString().replace("/", "");
        }
        a = s;
    }
}
