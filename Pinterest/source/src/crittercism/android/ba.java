// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.location.Location;

public final class ba
{

    private static Location a;

    public static Location a()
    {
        crittercism/android/ba;
        JVM INSTR monitorenter ;
        Location location = a;
        crittercism/android/ba;
        JVM INSTR monitorexit ;
        return location;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(Location location)
    {
        crittercism/android/ba;
        JVM INSTR monitorenter ;
        if (location != null) goto _L2; else goto _L1
_L1:
        a = location;
        crittercism/android/ba;
        JVM INSTR monitorexit ;
        return;
_L2:
        location = new Location(location);
        if (true) goto _L1; else goto _L3
_L3:
        location;
        throw location;
    }

    public static boolean b()
    {
        crittercism/android/ba;
        JVM INSTR monitorenter ;
        Location location = a;
        boolean flag;
        if (location != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        crittercism/android/ba;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
