// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import android.os.Handler;
import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.User;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.AbstractMap;

// Referenced classes of package com.pinterest.adapter:
//            PinPicksAdapter

class this._cls0
    implements android.view.er
{

    final PinPicksAdapter this$0;

    public void onClick(View view)
    {
        User user = (User)view.getTag();
        boolean flag;
        if (!user.getFollowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        user.setFollowing(flag);
        notifyDataSetChanged();
        Pinalytics.a(ElementType.USER_FEED_FOLLOW, ComponentType.USER_FEED, user.getUid());
        if (PinPicksAdapter.access$000().containsKey(user))
        {
            view = (llowRunnable)PinPicksAdapter.access$000().get(user);
            PinPicksAdapter.access$100(PinPicksAdapter.this).removeCallbacks(view);
        } else
        {
            class _cls1 extends PinPicksAdapter.FollowRunnable.FollowRunnableComplete
            {

                final PinPicksAdapter._cls2 this$1;

                public void onComplete()
                {
                    notifyDataSetChanged();
                }

            _cls1()
            {
                this$1 = PinPicksAdapter._cls2.this;
                super();
            }
            }

            view = new llowRunnable(user, new _cls1());
            PinPicksAdapter.access$000().put(user, view);
        }
        PinPicksAdapter.access$100(PinPicksAdapter.this).postDelayed(view, 1000L);
    }

    _cls1()
    {
        this$0 = PinPicksAdapter.this;
        super();
    }
}
