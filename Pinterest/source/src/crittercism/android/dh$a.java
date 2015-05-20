// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            cf, aw, dh

public final class 
{

    public static dh a(aw aw1)
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = null;
        obj = aw1.a(cf.j.a(), cf.j.b());
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new JSONObject(((String) (obj)));
        jsonobject = ((JSONObject) (obj));
_L4:
        boolean flag;
        if (jsonobject != null)
        {
            flag = jsonobject.optBoolean("optOutStatusSet", false);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag = jsonobject.optBoolean("optOutStatus", false);
        } else
        {
            flag = aw1.c(cf.m.a(), cf.m.b());
        }
        return new dh(flag);
_L2:
        jsonobject = null;
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
