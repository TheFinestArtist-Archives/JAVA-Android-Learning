// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.pinterest.activity.create.adapter.PinMarkletAdapter;
import com.pinterest.activity.create.dialog.SuspiciousSiteDialog;
import com.pinterest.activity.create.model.PinnableImageFeed;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.remote.SiteApi;
import com.pinterest.base.Events;
import com.pinterest.fragment.PinterestAdapterViewFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.webview.PWebView;

public class PinMarkletFragment extends PinterestAdapterViewFragment
{

    private static final String JS_FUNCTION = "javascript:function callback(pins){window.JavaScriptInterface.onPinsLoaded(JSON.stringify(pins))};";
    private static int JS_TIMEOUT_MS = 0;
    private static final String PINMARKLET = "javascript:(function(){var e=document.createElement('script');e.setAttribute('type','text/javascript');e.setAttribute('charset','UTF-8');e.setAttribute('render', 'callback');e.setAttribute('debug', 'true');e.setAttribute('src','//assets.pinterest.com/js/pinmarklet.js?r='+Math.random()*99999999);document.body.appendChild(e);})()";
    private PinnableImageFeed _feed;
    private Handler _handler;
    private Boolean _isWebPageClean;
    private android.widget.AdapterView.OnItemClickListener _onItemClick;
    private Boolean _pinMarkletLoaded;
    private String _sourceUrl;
    private Boolean _webPageLoaded;
    private PWebView _webview;
    ApiResponseHandler checkUrlResponse;
    private WebChromeClient pinitWebChrome;
    private WebViewClient pinitWebClient;

    public PinMarkletFragment()
    {
        _onItemClick = new _cls2();
        pinitWebClient = new _cls3();
        pinitWebChrome = new _cls4();
        checkUrlResponse = new _cls7(false);
    }

    private String getDomainName(String s)
    {
        if (s == null)
        {
            s = "";
        } else
        {
            String s1 = Uri.parse(s).getHost();
            s = s1;
            if (s1.startsWith("www."))
            {
                return s1.substring(4);
            }
        }
        return s;
    }

    private void initWebView()
    {
        _webview.getSettings().setJavaScriptEnabled(true);
        _webview.getSettings().setCacheMode(-1);
        _webview.addJavascriptInterface(new JavaScriptInterface(), "JavaScriptInterface");
        _webview.setWebViewClient(pinitWebClient);
        _webview.setWebChromeClient(pinitWebChrome);
        _webview.loadUrl(_sourceUrl);
        _webview.post(new _cls1());
        SiteApi.f(_sourceUrl, checkUrlResponse, getApiTag());
    }

    private void loadPinMarklet()
    {
        if (_webPageLoaded == Boolean.TRUE && _isWebPageClean == Boolean.TRUE)
        {
            _webview.loadUrl("javascript:function callback(pins){window.JavaScriptInterface.onPinsLoaded(JSON.stringify(pins))};");
            _webview.loadUrl("javascript:(function(){var e=document.createElement('script');e.setAttribute('type','text/javascript');e.setAttribute('charset','UTF-8');e.setAttribute('render', 'callback');e.setAttribute('debug', 'true');e.setAttribute('src','//assets.pinterest.com/js/pinmarklet.js?r='+Math.random()*99999999);document.body.appendChild(e);})()");
            _webview.postDelayed(new _cls6(), JS_TIMEOUT_MS);
        }
    }

    private void showBlockDialog()
    {
        if (isAdded())
        {
            Events.post(new DialogEvent(new SuspiciousSiteDialog()));
        }
    }

    private void showEmptyView()
    {
        if (_emptyView != null)
        {
            _emptyView.setMessage(Resources.string(0x7f0e0365));
            final String domain = (TextView)_emptyView.findViewById(0x7f0b00d0);
            if (domain != null)
            {
                domain.setCompoundDrawablesWithIntrinsicBounds(null, Resources.drawable(0x7f020142), null, null);
            }
            domain = getDomainName(_sourceUrl);
            if (TextUtils.equals(domain, ""))
            {
                _emptyView.setAction(1, Resources.string(0x7f0e02ea, new Object[] {
                    domain
                }), new _cls5());
            }
            AdapterEmptyView.setState(_emptyView, 1);
            _emptyView.setVisibility(0);
        }
    }

    protected void createAdapter()
    {
    }

    protected Class getApiHandlerClass()
    {
        return null;
    }

    protected android.widget.AdapterView.OnItemClickListener getClickHandler()
    {
        return _onItemClick;
    }

    protected void hideWaitDialog()
    {
        if (getView() != null)
        {
            ((ViewGroup)getView().getParent()).setVisibility(0);
            super.hideWaitDialog();
        }
    }

    protected void loadData()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        _adapter = new PinMarkletAdapter(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03009f;
        _menuId = -1;
        _handler = new Handler();
        setCutout(true);
    }

    public void onPause()
    {
        super.onPause();
        if (_emptyView != null)
        {
            _emptyView.deactivate();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (_emptyView != null)
        {
            _emptyView.activate();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("sourceUrl", _sourceUrl);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _actionBar.setTitle(0x7f0e0155);
        _webview = (PWebView)view.findViewById(0x7f0b018c);
        if (_sourceUrl == null && bundle != null)
        {
            _sourceUrl = bundle.getString("sourceUrl");
        }
        if (_feed != null)
        {
            _adapter.setDataSource(new PinnableImageFeed(_feed));
            return;
        } else
        {
            initWebView();
            return;
        }
    }

    public void setSourceUrl(String s)
    {
        _sourceUrl = s;
    }

    protected void showWaitDialog(String s)
    {
        super.showWaitDialog(s);
        s = getView();
        if (s != null)
        {
            s = s.getParent();
            if (s instanceof View)
            {
                ((View)s).setVisibility(4);
            }
        }
    }

    static 
    {
        JS_TIMEOUT_MS = 10000;
    }





/*
    static Boolean access$1102(PinMarkletFragment pinmarkletfragment, Boolean boolean1)
    {
        pinmarkletfragment._webPageLoaded = boolean1;
        return boolean1;
    }

*/



/*
    static Boolean access$1302(PinMarkletFragment pinmarkletfragment, Boolean boolean1)
    {
        pinmarkletfragment._isWebPageClean = boolean1;
        return boolean1;
    }

*/




/*
    static PinnableImageFeed access$302(PinMarkletFragment pinmarkletfragment, PinnableImageFeed pinnableimagefeed)
    {
        pinmarkletfragment._feed = pinnableimagefeed;
        return pinnableimagefeed;
    }

*/



/*
    static Boolean access$402(PinMarkletFragment pinmarkletfragment, Boolean boolean1)
    {
        pinmarkletfragment._pinMarkletLoaded = boolean1;
        return boolean1;
    }

*/







    private class _cls3 extends WebViewClient
    {

        private boolean receivedError;
        final PinMarkletFragment this$0;

        public void onPageFinished(WebView webview, String s)
        {
            onPageFinished(webview, s);
            if (!receivedError)
            {
                _webPageLoaded = Boolean.TRUE;
                loadPinMarklet();
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

        _cls3()
        {
            this$0 = PinMarkletFragment.this;
            super();
            receivedError = false;
        }
    }


    private class _cls4 extends WebChromeClient
    {

        final PinMarkletFragment this$0;

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            _pinMarkletLoaded = Boolean.TRUE;
            showEmptyView();
            hideWaitDialog();
            jsresult.cancel();
            return true;
        }

        _cls4()
        {
            this$0 = PinMarkletFragment.this;
            super();
        }
    }


    private class _cls7 extends ApiResponseHandler
    {

        final PinMarkletFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            PLog.a((new StringBuilder("checkUrlResponse: ")).append(apiresponse).toString(), new Object[0]);
            if (getView() != null && getActivity() != null)
            {
                apiresponse = ((PinterestJsonObject)apiresponse.getData()).a("action", "");
                if ("ALLOW".equals(apiresponse))
                {
                    _isWebPageClean = Boolean.TRUE;
                    loadPinMarklet();
                } else
                if ("BLOCK".equals(apiresponse) || "WARN".equals(apiresponse))
                {
                    _isWebPageClean = Boolean.FALSE;
                    hideWaitDialog();
                    showBlockDialog();
                    return;
                }
            }
        }

        _cls7(boolean flag)
        {
            this$0 = PinMarkletFragment.this;
            super(flag);
        }
    }


    private class JavaScriptInterface
    {

        final PinMarkletFragment this$0;

        public void onFailure(Throwable throwable)
        {
            _pinMarkletLoaded = Boolean.TRUE;
            class _cls2
                implements Runnable
            {

                final JavaScriptInterface this$1;

                public void run()
                {
                    if (isAdded())
                    {
                        Application.showToast(0x7f0e0215);
                        hideWaitDialog();
                        getActivity().finish();
                    }
                }

                _cls2()
                {
                    this$1 = JavaScriptInterface.this;
                    super();
                }
            }

            _handler.post(new _cls2());
        }

        public void onPinsLoaded(String s)
        {
            if (!StringUtils.isNotEmpty(s))
            {
                break MISSING_BLOCK_LABEL_49;
            }
            s = new PinnableImageFeed((new PinterestJsonObject(s)).e("thumb"));
            _feed = new PinnableImageFeed(s);
            onSuccess(s);
            return;
            s;
            CrashReporting.logHandledException(s);
            onFailure(s);
            return;
        }

        public void onSuccess(final PinnableImageFeed feed)
        {
            _pinMarkletLoaded = Boolean.TRUE;
            _handler.post(new _cls1());
        }

        JavaScriptInterface()
        {
            this$0 = PinMarkletFragment.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final PinMarkletFragment this$0;

        public void run()
        {
            showWaitDialog(Resources.string(0x7f0e02c5, new Object[] {
                getDomainName(_sourceUrl)
            }));
        }

        _cls1()
        {
            this$0 = PinMarkletFragment.this;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final PinMarkletFragment this$0;

        public void run()
        {
            if (_pinMarkletLoaded != Boolean.TRUE)
            {
                Application.showToast(Resources.string(0x7f0e0365));
                if (isAdded())
                {
                    hideWaitDialog();
                    getActivity().finish();
                }
            }
        }

        _cls6()
        {
            this$0 = PinMarkletFragment.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final PinMarkletFragment this$0;
        final String val$domain;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.PIN_DOMAIN, ComponentType.MODAL_DIALOG);
            ActivityHelper.goTask(view.getContext(), new Navigation(Location.DOMAIN, domain));
            getActivity().finish();
        }

        _cls5()
        {
            this$0 = PinMarkletFragment.this;
            domain = s;
            super();
        }
    }

}
