// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import java.io.Serializable;

// Referenced classes of package com.facebook:
//            FacebookTimeSpentData

class firstOpenSourceApplication
    implements Serializable
{

    private static final long serialVersionUID = 6L;
    private final String firstOpenSourceApplication;
    private final int interruptionCount;
    private final long lastResumeTime;
    private final long lastSuspendTime;
    private final long millisecondsSpentInSession;

    private Object readResolve()
    {
        return new FacebookTimeSpentData(lastResumeTime, lastSuspendTime, millisecondsSpentInSession, interruptionCount, firstOpenSourceApplication, null);
    }

    (long l, long l1, long l2, int i, 
            String s)
    {
        lastResumeTime = l;
        lastSuspendTime = l1;
        millisecondsSpentInSession = l2;
        interruptionCount = i;
        firstOpenSourceApplication = s;
    }
}
