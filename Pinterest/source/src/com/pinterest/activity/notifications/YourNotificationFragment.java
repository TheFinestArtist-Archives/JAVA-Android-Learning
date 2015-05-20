// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications;

import com.pinterest.activity.notifications.adapter.NotificationAdapter;
import com.pinterest.activity.notifications.adapter.StoryAdapter;
import com.pinterest.api.remote.MyUserApi;

// Referenced classes of package com.pinterest.activity.notifications:
//            BaseNotificationFragment

public class YourNotificationFragment extends BaseNotificationFragment
{

    public YourNotificationFragment()
    {
    }

    protected NotificationAdapter createAdapter()
    {
        return new NotificationAdapter();
    }

    protected volatile StoryAdapter createAdapter()
    {
        return createAdapter();
    }

    protected void loadData()
    {
        MyUserApi.a(onNotificationsLoaded, getApiTag());
        updateEmptyContent();
    }
}
