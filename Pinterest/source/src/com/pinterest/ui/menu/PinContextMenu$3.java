// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.remote.PinApi;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.ui.menu:
//            PinContextMenu

class this._cls0
    implements android.view.ner
{

    final PinContextMenu this$0;

    public void onClick(View view)
    {
        int i = 1;
        view = ModelHelper.getPin(PinContextMenu.access$000(PinContextMenu.this).getUid());
        boolean flag;
        if (!Constants.isTrue(view.getLiked()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (view != null)
        {
            Pinalytics.a(ElementType.PIN_LIKE_BUTTON, ComponentType.CONTEXTUAL_MENU, PinContextMenu.access$000(PinContextMenu.this).getUid());
            view.setLiked(Boolean.valueOf(flag));
            int j = view.getLikeCountDisplay();
            if (!flag)
            {
                i = -1;
            }
            view.setLikeCount(Integer.valueOf(i + j));
            Events.post(new com.pinterest.api.model.init>(view));
            PinApi.a(view.getUid(), flag, new com.pinterest.api.remote.Response(view));
        }
    }

    ApiResponse()
    {
        this$0 = PinContextMenu.this;
        super();
    }
}
