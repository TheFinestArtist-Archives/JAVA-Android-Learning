// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.digest.adapter.DigestGridAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class this._cls0
    implements android.widget.mClickListener
{

    final DigestFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        Pinalytics.a(ElementType.DIGEST_STORY_EXPAND_BUTTON, ComponentType.DIGEST_STORY_HEADER);
        i = ((DigestGridAdapter)DigestFragment.access$000(DigestFragment.this)).getPrevStoryIndex(i);
        Events.post(((DigestGridAdapter)DigestFragment.access$100(DigestFragment.this)).getStoryNavigation(i));
    }

    dAdapter()
    {
        this$0 = DigestFragment.this;
        super();
    }
}
