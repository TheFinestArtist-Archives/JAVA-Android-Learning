// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.details;

import com.pinterest.api.model.Pin;
import com.pinterest.ui.imageview.WebImageView;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.details:
//            PinCloseupView, PinCloseUpImageView

class val.forMeasure
    implements Runnable
{

    final PinCloseupView this$0;
    final boolean val$forMeasure;
    final boolean val$isBigImage;
    final boolean val$isGif;

    public void run()
    {
        if (val$isBigImage || val$isGif)
        {
            PinCloseupView.access$000(PinCloseupView.this);
            PinCloseupView.access$200(PinCloseupView.this).setPin(PinCloseupView.access$100(PinCloseupView.this), val$forMeasure);
            PinCloseupView.access$200(PinCloseupView.this).setLayoutParams(new android.widget.tParams(PinCloseupView.access$300(PinCloseupView.this).getLayoutParams()));
            return;
        } else
        {
            PinCloseupView.access$300(PinCloseupView.this).loadUrl(PinCloseupView.access$100(PinCloseupView.this).getImageLargeUrl(), false);
            class _cls1 extends com.pinterest.ui.imageview.WebImageView.ImageListener
            {

                final PinCloseupView._cls1 this$1;

                public void onBitmapSet()
                {
                    PinCloseupView.access$400(this$0);
                }

            _cls1()
            {
                this$1 = PinCloseupView._cls1.this;
                super();
            }
            }

            PinCloseupView.access$300(PinCloseupView.this).setImageListener(new _cls1());
            return;
        }
    }

    _cls1()
    {
        this$0 = final_pincloseupview;
        val$isBigImage = flag;
        val$isGif = flag1;
        val$forMeasure = Z.this;
        super();
    }
}
