// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications.util;

import com.pinterest.api.model.ConversationFeed;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.activity.notifications.util:
//            RecentConversations

final class  extends BackgroundTask
{

    public final void run()
    {
        Object obj = DiskCache.getJsonArray("RECENT_CONVERSATIONS");
        if (obj != null)
        {
            obj = new ConversationFeed(((com.pinterest.api.PinterestJsonArray) (obj)), null);
            RecentConversations.access$002(RecentConversations.instance(), ((ConversationFeed) (obj)).getItems());
        }
    }

    ()
    {
    }
}
