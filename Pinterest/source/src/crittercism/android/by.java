// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.UUID;

// Referenced classes of package crittercism.android:
//            bv

public final class by extends bv
{

    public by()
    {
    }

    public final String a()
    {
        return (new StringBuilder()).append(Long.toString(System.nanoTime())).append("_").append(UUID.randomUUID()).append(".log").toString();
    }
}
