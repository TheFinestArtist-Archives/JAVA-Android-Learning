// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            bm, bp

public final class bl
    implements bm
{

    private Map a;

    public bl()
    {
        a = new HashMap();
    }

    public final bl a(bp bp1)
    {
        if (bp1.b() != null)
        {
            a.put(bp1.a(), bp1.b());
        }
        return this;
    }

    public final JSONObject a()
    {
        return new JSONObject(a);
    }

    public final Object b()
    {
        return a();
    }
}
