// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.content.Intent;
import com.pinterest.kit.application.PApplication;
import com.pinterest.service.NotificationService;
import com.pinterest.service.PinterestWorkerService;

// Referenced classes of package com.pinterest.base:
//            Application

public class Services
{

    public Services()
    {
    }

    public static void startBackgroundService()
    {
        Application.context().startService(new Intent(Application.context(), com/pinterest/service/PinterestWorkerService));
    }

    public static void startNotificationService()
    {
        Application.context().startService(new Intent(Application.context(), com/pinterest/service/NotificationService));
    }
}
