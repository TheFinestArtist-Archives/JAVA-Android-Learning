// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package crittercism.android:
//            db

public final class dd
{

    private static Map a;

    public static db a(String s)
    {
        if (s != null && a.containsKey(s))
        {
            return (db)a.get(s);
        } else
        {
            return null;
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        a = hashmap;
        hashmap.put("com.amazon.venezia", new dc.a.a());
        a.put("com.android.vending", new dc.b.a());
    }
}
