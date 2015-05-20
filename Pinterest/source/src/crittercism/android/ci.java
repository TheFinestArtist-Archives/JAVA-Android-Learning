// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            cn, dk, di, cx, 
//            cj, au, cp, co, 
//            h, ay, bj

public final class ci extends cn
{

    private String a;
    private Context b;
    private au c;
    private dk d;
    private JSONObject e;
    private JSONObject f;
    private JSONObject g;
    private boolean h;

    public ci(bj bj, bj bj1, String s, Context context, au au1, dk dk1)
    {
        super(bj, bj1);
        a = s;
        b = context;
        c = au1;
        d = dk1;
        h = false;
    }

    public final void a(boolean flag, int i, JSONObject jsonobject)
    {
        super.a(flag, i, jsonobject);
        if (jsonobject != null)
        {
            Object obj = jsonobject.optJSONObject("me");
            if (obj != null)
            {
                e = ((JSONObject) (obj)).optJSONObject("notify");
                obj = d.b();
                if (e == null)
                {
                    ((di) (obj)).c();
                } else
                if (e.optString("type") != null && e.optString("type").equals("rate_my_app"))
                {
                    obj = new di(((di) (obj)));
                    JSONObject jsonobject1 = e;
                    obj.d = jsonobject1.optInt("rate_after_load_num", 5);
                    obj.e = jsonobject1.optInt("remind_after_load_num", 5);
                    obj.f = jsonobject1.optString("message", "Would you mind taking a second to rate my app?  I would really appreciate it!");
                    obj.g = jsonobject1.optString("title", "Rate My App");
                    ((di) (obj)).a();
                    d.a(((di) (obj)));
                }
            }
            obj = jsonobject.optJSONObject("app_settings");
            if (obj != null)
            {
                obj = ((JSONObject) (obj)).optJSONObject("settings");
            } else
            {
                obj = null;
            }
            g = ((JSONObject) (obj));
            if (g != null && g.optInt("need_pkg", 0) == 1)
            {
                try
                {
                    (new cx((new cj(c)).a("device_name", c.f()).a("pkg", b.getPackageName()), new cp((new co(a, "/android_v2/update_package_name")).a()))).run();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    (new StringBuilder("IOException in handleResponse(): ")).append(((IOException) (obj)).getMessage());
                }
                h = true;
            }
            f = jsonobject.optJSONObject("apm");
            if (f != null)
            {
                jsonobject = new h(f);
                obj = b;
                if (((h) (jsonobject)).c)
                {
                    crittercism.android.h.b(((Context) (obj)));
                } else
                {
                    File file = crittercism.android.h.a(((Context) (obj)));
                    if (!file.delete() && file.exists())
                    {
                        Log.e("Crittercism", "Unable to reenable OPTMZ instrumentation");
                    }
                }
                obj = ((Context) (obj)).getSharedPreferences("com.crittercism.optmz.config", 0).edit();
                if (((h) (jsonobject)).b)
                {
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("enabled", ((h) (jsonobject)).a);
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("kill", ((h) (jsonobject)).c);
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("persist", ((h) (jsonobject)).b);
                    ((android.content.SharedPreferences.Editor) (obj)).putInt("interval", ((h) (jsonobject)).d);
                } else
                {
                    ((android.content.SharedPreferences.Editor) (obj)).clear();
                }
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                ay.r().a(jsonobject);
            }
        }
    }
}
