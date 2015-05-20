// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import java.util.concurrent.FutureTask;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter

final class a extends FutureTask
    implements Comparable
{

    private final BitmapHunter a;

    public final int compareTo(Object obj)
    {
        obj = (a)obj;
        a a1 = a.r;
        a a2 = ((a) (obj)).a.r;
        if (a1 == a2)
        {
            return a.a - ((a) (obj)).a.a;
        } else
        {
            return a2.a() - a1.a();
        }
    }

    public (BitmapHunter bitmaphunter)
    {
        super(bitmaphunter, null);
        a = bitmaphunter;
    }
}
