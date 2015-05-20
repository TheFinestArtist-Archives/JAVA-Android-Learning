// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.digest.adapter:
//            DigestGridAdapter

class val.i
    implements android.view.
{

    final DigestGridAdapter this$0;
    final int val$i;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.DIGEST_STORY_HEADER_BUTTON, ComponentType.DIGEST_STORY_HEADER);
        Events.post(getStoryNavigation(val$i));
    }

    ()
    {
        this$0 = final_digestgridadapter;
        val$i = I.this;
        super();
    }
}
