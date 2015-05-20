// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            au

public final class cj
{

    public Map a;

    public cj(au au1)
    {
        a = new HashMap();
        a.put("app_id", au1.a());
        a.put("hashed_device_id", au1.c());
        a.put("library_version", "4.3.0");
    }

    public final cj a(String s, String s1)
    {
        a.put(s, s1);
        return this;
    }

    public final cj a(String s, JSONObject jsonobject)
    {
        a.put(s, jsonobject);
        return this;
    }
}
