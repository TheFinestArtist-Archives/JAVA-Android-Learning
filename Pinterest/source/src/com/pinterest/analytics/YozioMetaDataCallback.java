// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import android.content.Context;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.log.PLog;
import com.yozio.android.Yozio;
import com.yozio.android.interfaces.YozioMetaDataCallbackable;
import java.util.HashMap;

public class YozioMetaDataCallback
    implements YozioMetaDataCallbackable
{

    public YozioMetaDataCallback()
    {
    }

    public void onCallback(Context context, String s, HashMap hashmap)
    {
        PLog.a((new StringBuilder("YozioMetaDataCallback Got meta data: ")).append(hashmap.toString()).toString(), new Object[0]);
        AnalyticsApi.a("yozio_callback");
        if (s != null)
        {
            Yozio.startActivityWithMetaData(context, s, hashmap);
        }
        if (hashmap.isEmpty()) goto _L2; else goto _L1
_L1:
        context = new PinterestJsonObject(hashmap);
        s = new PinterestJsonObject();
        s.a("body", context);
        s.b("status", "ok");
        context = new PinterestJsonObject();
        context.a("yozio_data", s);
_L4:
        if (context != null)
        {
            context = context.toString();
            PLog.a("YOZIO_METADATA serializing and save: %s", new Object[] {
                context
            });
            Preferences.persisted().set("PREF_YOZIO_DATA", context);
        }
_L2:
        return;
        s;
        context = null;
_L5:
        s.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
        s;
          goto _L5
    }
}
