// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.support.v4.app.FragmentActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pinterest.base.Application;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class receivedError extends WebViewClient
{

    private boolean receivedError;
    final PinMarkletFragment this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (!receivedError)
        {
            PinMarkletFragment.access$1102(PinMarkletFragment.this, Boolean.TRUE);
            PinMarkletFragment.access$1200(PinMarkletFragment.this);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        receivedError = true;
        Application.showToast(s);
        if (isAdded())
        {
            hideWaitDialog();
            getActivity().finish();
        }
    }

    A()
    {
        this$0 = PinMarkletFragment.this;
        super();
        receivedError = false;
    }
}
