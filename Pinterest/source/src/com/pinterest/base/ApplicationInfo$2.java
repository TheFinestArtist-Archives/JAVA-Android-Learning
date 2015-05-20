// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.log.PLog;
import java.util.Map;
import java.util.TreeMap;

final class 
    implements Runnable
{

    public final void run()
    {
        TreeMap treemap = new TreeMap();
        String s = Preferences.persisted().getString("PREF_YOZIO_DATA", null);
        if (s != null)
        {
            treemap.put("data", s);
            PLog.a("YOZIO_METADATA submitting: %s", new Object[] {
                s
            });
        }
        class _cls1 extends BaseApiResponseHandler
        {

            final ApplicationInfo._cls2 this$0;

            public void onSuccess(PinterestJsonObject pinterestjsonobject)
            {
                super.onSuccess(pinterestjsonobject);
                PLog.a("Report install successful", new Object[0]);
                AnalyticsApi.a("yozio_submit");
                Preferences.persisted().set("PREF_FIRST_LAUNCH", false);
            }

            _cls1()
            {
                this$0 = ApplicationInfo._cls2.this;
                super();
            }
        }

        AnalyticsApi.a(treemap, new _cls1());
    }

    ()
    {
    }
}
