// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            au, dp, b

public final class a
{

    JSONObject a;

    private a(au au1, List list)
    {
        a = new JSONObject();
        list.size();
        JSONArray jsonarray = new JSONArray();
        JSONArray jsonarray1 = new JSONArray();
        jsonarray1.put(au1.a());
        jsonarray1.put(au1.b());
        jsonarray1.put(au1.c());
        jsonarray1.put("4.3.0");
        jsonarray1.put(au1.d());
        jsonarray.put(jsonarray1);
        jsonarray1 = new JSONArray();
        jsonarray1.put(dp.a.a());
        jsonarray1.put(au1.e());
        jsonarray1.put(au1.g());
        jsonarray1.put(au1.f());
        jsonarray1.put(au1.h());
        jsonarray.put(jsonarray1);
        au1 = new JSONArray();
        for (list = list.iterator(); list.hasNext(); au1.put(((b)list.next()).d())) { }
        jsonarray.put(au1);
        a.put("d", jsonarray);
    }

    public static a a(au au1, List list)
    {
        try
        {
            au1 = new a(au1, list);
        }
        // Misplaced declaration of an exception variable
        catch (au au1)
        {
            Log.e("Crittercism", (new StringBuilder("Unable to generate APM request's JSON: ")).append(au1).toString());
            return null;
        }
        return au1;
    }
}
