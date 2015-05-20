// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupClickThroughView

final class val.context extends ApiResponseHandler
{

    final Context val$context;
    final String val$link;
    final Pin val$pin;

    public final void onSuccess(final ApiResponse url)
    {
        super.onSuccess(url);
        Pinalytics.a(EventType.PIN_CLICKTHROUGH, val$pin.getUid());
        StopWatch.get().complete("clickthrough_verify");
        Object obj = (PinterestJsonObject)url.getData();
        String s = ((PinterestJsonObject) (obj)).a("redirect_status", "");
        url = ((PinterestJsonObject) (obj)).a("url", val$link);
        obj = ((PinterestJsonObject) (obj)).a("message", Resources.string(0x7f0e0371));
        if (s.equalsIgnoreCase("blocked"))
        {
            url = new BaseDialog();
            url.setTitle(0x7f0e0492);
            url.setMessage(((String) (obj)));
            url.setPositiveButton(0x7f0e033a, null);
            Events.post(new DialogEvent(url));
            return;
        }
        if (s.equalsIgnoreCase("suspicious"))
        {
            BaseDialog basedialog = new BaseDialog();
            basedialog.setTitle(0x7f0e04f7);
            basedialog.setMessage(((String) (obj)));
            basedialog.setNegativeButton(0x7f0e008f, null);
            class _cls1
                implements android.view.View.OnClickListener
            {

                final PinCloseupClickThroughView._cls3 this$0;
                final String val$url;

                public void onClick(View view)
                {
                    PinCloseupClickThroughView.access$100(context, url, pin);
                }

            _cls1()
            {
                this$0 = PinCloseupClickThroughView._cls3.this;
                url = s;
                super();
            }
            }

            basedialog.setPositiveButton(0x7f0e0458, new _cls1());
            Events.post(new DialogEvent(basedialog));
            return;
        } else
        {
            PinCloseupClickThroughView.access$100(val$context, url, val$pin);
            return;
        }
    }

    _cls1(Context context1)
    {
        val$pin = pin1;
        val$link = s;
        val$context = context1;
        super(final_flag);
    }
}
