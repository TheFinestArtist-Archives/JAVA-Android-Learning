// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class this._cls0 extends WebChromeClient
{

    final PinMarkletFragment this$0;

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        PinMarkletFragment.access$402(PinMarkletFragment.this, Boolean.TRUE);
        PinMarkletFragment.access$900(PinMarkletFragment.this);
        hideWaitDialog();
        jsresult.cancel();
        return true;
    }

    A()
    {
        this$0 = PinMarkletFragment.this;
        super();
    }
}
