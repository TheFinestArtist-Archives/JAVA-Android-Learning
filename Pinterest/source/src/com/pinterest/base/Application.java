// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.content.res.Configuration;
import com.pinterest.api.ApiClient;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.model.MyUser;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.PApplication;

// Referenced classes of package com.pinterest.base:
//            CrashReporting, ApplicationInfo, Device

public class Application extends PApplication
{

    public Application()
    {
    }

    protected void init()
    {
        super.init();
        CrashReporting.init();
        ApplicationInfo.ensureInstallId();
        ApiHttpClient.initCookieStore(context());
        ApiClient.b(ApplicationInfo.getClientSecret());
        ApiClient.a(MyUser.getAccessToken());
        ApiClient.b();
        Device.init();
        Experiments.q();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        Device.onConfigurationChanged(configuration);
    }
}
