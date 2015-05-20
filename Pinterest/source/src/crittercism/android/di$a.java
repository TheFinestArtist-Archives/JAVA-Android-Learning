// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            aw, di

public final class 
{

    public static di a(aw aw1, String s, String s1)
    {
        Object obj = null;
        aw1 = aw1.a(s, s1);
        if (aw1 != null)
        {
            try
            {
                aw1 = new JSONObject(aw1);
            }
            // Misplaced declaration of an exception variable
            catch (aw aw1)
            {
                aw1 = obj;
            }
        } else
        {
            aw1 = null;
        }
        if (aw1 != null)
        {
            return new di(aw1);
        } else
        {
            return new di();
        }
    }
}
