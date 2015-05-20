// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.details;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pinterest.ui.imageview.WebImageView;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.details:
//            PinCloseupView

class this._cls0 extends WebViewClient
{

    final PinCloseupView this$0;

    public void onLoadResource(WebView webview, String s)
    {
        PinCloseupView.access$400(PinCloseupView.this);
    }

    public void onPageFinished(WebView webview, String s)
    {
        PinCloseupView.access$400(PinCloseupView.this);
        class _cls1
            implements Runnable
        {

            final PinCloseupView._cls2 this$1;

            public void run()
            {
                if (PinCloseupView.access$300(this$0) != null)
                {
                    removeView(PinCloseupView.access$300(this$0));
                    PinCloseupView.access$300(this$0).setBitmap(null, false);
                    PinCloseupView.access$302(this$0, null);
                }
            }

            _cls1()
            {
                this$1 = PinCloseupView._cls2.this;
                super();
            }
        }

        if (PinCloseupView.access$300(PinCloseupView.this) != null)
        {
            PinCloseupView.access$300(PinCloseupView.this).postDelayed(new _cls1(), 500L);
        }
    }

    _cls1()
    {
        this$0 = PinCloseupView.this;
        super();
    }
}
