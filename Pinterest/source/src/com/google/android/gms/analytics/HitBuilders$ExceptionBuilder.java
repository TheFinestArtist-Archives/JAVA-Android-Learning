// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            y, an

public class set extends set
{

    public volatile Map build()
    {
        return super.set();
    }

    public set setDescription(String s)
    {
        set("&exd", s);
        return this;
    }

    public set setFatal(boolean flag)
    {
        set("&exf", an.E(flag));
        return this;
    }

    public ()
    {
        y.eK().a();
        set("&t", "exception");
    }
}
