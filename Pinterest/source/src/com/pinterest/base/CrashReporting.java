// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import com.crittercism.app.Crittercism;
import com.crittercism.app.CrittercismConfig;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.kit.application.Resources;

// Referenced classes of package com.pinterest.base:
//            ApplicationInfo, Application

public class CrashReporting
{

    public CrashReporting()
    {
    }

    public static void init()
    {
        CrittercismConfig crittercismconfig = new CrittercismConfig();
        crittercismconfig.setCustomVersionName(ApplicationInfo.getVersionName());
        crittercismconfig.setDelaySendingAppLoad(true);
        Crittercism.initialize(Application.context(), Resources.string(0x7f0e0158), crittercismconfig);
        updateUsername();
        updateAuxData();
    }

    public static void leaveBreadcrumb(String s)
    {
        Crittercism.leaveBreadcrumb(s);
    }

    public static void logHandledException(Throwable throwable)
    {
        Crittercism.logHandledException(throwable);
    }

    public static void sendAppLoad()
    {
        Crittercism.sendAppLoadData();
    }

    private static void updateAuxData()
    {
    }

    public static void updateUsername()
    {
        Object obj;
        try
        {
            obj = MyUser.get();
        }
        catch (Exception exception)
        {
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        obj = ((User) (obj)).getUsername();
        if (ModelHelper.isValid(obj))
        {
            Crittercism.setUsername(((String) (obj)));
        }
    }
}
