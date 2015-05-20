// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.web.fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.PinterestActivity;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.web.view.WebViewOpeninAppBar;
import com.pinterest.activity.web.view.WebViewPinItBar;
import com.pinterest.activity.webhook.WebhookActivity;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.base.CrashReporting;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.WebViewUtils;
import com.pinterest.ui.progress.LoadingView;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class WebViewFragment extends BaseFragment
{

    private static final String PINTEREST_MOBILE_URL = "http://m.pinterest.com";
    private static final String PWD_RESET_COMPLETE = "password/reset/complete/";
    private static final String TAG_EXTRACTION_JAVASCRIPT = "javascript:webViewResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:android:'.length) === 'al:android:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
    private WebViewPinItBar _browserPinBar;
    private String _displayTitle;
    private boolean _isWebPagePinnable;
    private WebViewOpeninAppBar _openInAppBar;
    private LoadingView _progressVw;
    private String _url;
    private WebView _webView;
    private WebViewClient _webViewClient;
    private ApiResponseHandler onZenDeskSso;

    public WebViewFragment()
    {
        _url = "http://m.pinterest.com";
        onZenDeskSso = new _cls2();
        _webViewClient = new _cls3();
        _menuId = -1;
    }

    private boolean handledByMarket(WebView webview, String s)
    {
label0:
        {
            if ("market".equals(Uri.parse(s).getScheme()))
            {
                webview.stopLoading();
                webview = getActivity();
                if (webview != null)
                {
                    break label0;
                }
            }
            return false;
        }
        if (!s.startsWith("market://details?id=com.pinterest")) goto _L2; else goto _L1
_L1:
        s = new Intent(webview, com/pinterest/activity/PinterestActivity);
        ActivityHelper.setSingleClearTop(s);
        webview.finish();
        webview.startActivity(s);
_L4:
        return true;
_L2:
        Intent intent = new Intent("android.intent.action.VIEW");
        try
        {
            intent.setData(Uri.parse(s));
            webview.startActivity(intent);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            intent.setData(Uri.parse(s.replaceFirst("market://", "http://play.google.com/store/apps/")));
            webview.startActivity(intent);
        }
        webview.finish();
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean shouldHandledByWebhook(String s)
    {
        while (getActivity() == null || getActivity().getIntent() == null || !getActivity().getIntent().getBooleanExtra("com.pinterest.EXTRA_ALLOW_REDIRECT_BACK", false) || s.contains("/secure/") || s.contains("/login/") || shouldHandledInWebview(s) && !s.startsWith("pinterest://") && !s.startsWith("pinit")) 
        {
            return false;
        }
        return true;
    }

    private boolean shouldHandledInWebview(String s)
    {
        boolean flag;
        try
        {
            flag = WebhookActivity.shouldHandleInWebView((new URI(s)).getHost());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashReporting.logHandledException(s);
            return true;
        }
        return flag;
    }

    protected void onActivate()
    {
        super.onActivate();
        if (_webView != null)
        {
            _webView.onResume();
        }
    }

    public boolean onBackPressed()
    {
        if (_webView.canGoBack())
        {
            _webView.goBack();
            return true;
        } else
        {
            return super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300b8;
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (menu != null)
        {
            menu.clear();
        }
    }

    protected void onDeactivate()
    {
        if (_webView != null)
        {
            _webView.onPause();
        }
        super.onDeactivate();
    }

    public void onDestroy()
    {
        WebViewUtils.safeDestroyWebView(_webView);
        _webView = null;
        super.onDestroy();
    }

    public void onViewCreated(final View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (_isWebPagePinnable)
        {
            _browserPinBar = (WebViewPinItBar)((ViewStub)view.findViewById(0x7f0b01af)).inflate();
        }
        bundle = getActivity().getIntent();
        _progressVw = new LoadingView(view.getContext());
        _progressVw.setState(0);
        _progressVw.setLoadingBackground(null);
        android.support.v7.widget.Toolbar.LayoutParams layoutparams = new android.support.v7.widget.Toolbar.LayoutParams(-2, -2, 21);
        _actionBar.addView(_progressVw, layoutparams);
        if (_webView != null)
        {
            try
            {
                _webView.destroy();
            }
            catch (Exception exception) { }
        }
        _webView = (WebView)view.findViewById(0x7f0b0077);
        WebViewUtils.setupCookieManager(_webView);
        _webView.setWebViewClient(_webViewClient);
        _webView.addJavascriptInterface(new _cls1(), "webViewResult");
        if (bundle.getBooleanExtra("com.pinterest.EXTRA_REMOVE_COOKIE", false))
        {
            WebViewUtils.clearCookies(_webView);
        }
        WebViewUtils.setupWebView(_webView, false);
        if (bundle.hasExtra("com.pinterest.EXTRA_WEB_TITLE"))
        {
            _displayTitle = getString(bundle.getExtras().getInt("com.pinterest.EXTRA_WEB_TITLE"));
        } else
        if (bundle.hasExtra("com.pinterest.EXTRA_WEB_TITLE_STRING"))
        {
            _displayTitle = bundle.getExtras().getString("com.pinterest.EXTRA_WEB_TITLE_STRING");
        }
        _actionBar.setTitle(_displayTitle);
        if (_url != null && !bundle.hasExtra("com.pinterest.EXTRA_HAS_URL")) goto _L2; else goto _L1
_L1:
        view = bundle.getData();
        if (view != null)
        {
            view = view.toString();
        } else
        {
            view = _url;
        }
        _url = view;
        if (!StringUtils.isEmpty(_url)) goto _L2; else goto _L3
_L3:
        getActivity().finish();
_L5:
        return;
_L2:
        if (_navigation == null)
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = ((Bundle) (_navigation.getExtra("Referer")));
        if (!(bundle instanceof String))
        {
            break; /* Loop/switch isn't completed */
        }
        view = new HashMap();
        view.put("Referer", (String)bundle);
_L6:
        if (StringUtils.isEmpty(_url))
        {
            getActivity().onBackPressed();
            return;
        }
        if (!_url.equalsIgnoreCase(Resources.string(0x7f0e04e2)) && view != null)
        {
            _webView.loadUrl(_url, view);
        } else
        {
            _webView.loadUrl(_url);
        }
        if (_browserPinBar != null)
        {
            _browserPinBar.setUrl(_url);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        view = null;
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    public void refresh()
    {
        _webView.reload();
    }

    public void scrollTo(int i, int j)
    {
        if (_webView != null)
        {
            _webView.scrollTo(i, j);
        }
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _url = navigation.getId();
        boolean flag;
        if (navigation.getExtra("com.pinterest.EXTRA_WEBPAGE_PINNABLE") == Boolean.TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _isWebPagePinnable = flag;
        navigation = ((Navigation) (navigation.getExtra("com.pinterest.EXTRA_WEB_TITLE")));
        if (navigation instanceof String)
        {
            _displayTitle = (String)navigation;
        }
    }



/*
    static WebViewOpeninAppBar access$002(WebViewFragment webviewfragment, WebViewOpeninAppBar webviewopeninappbar)
    {
        webviewfragment._openInAppBar = webviewopeninappbar;
        return webviewopeninappbar;
    }

*/












    private class _cls2 extends ApiResponseHandler
    {

        final WebViewFragment this$0;

        public void onSuccess(PinterestJsonObject pinterestjsonobject)
        {
            super.onSuccess(pinterestjsonobject);
            if (_webView == null)
            {
                return;
            }
            if (pinterestjsonobject != null)
            {
                pinterestjsonobject = pinterestjsonobject.c("data");
                if (pinterestjsonobject != null)
                {
                    String s = pinterestjsonobject.a("sso_url", null);
                    pinterestjsonobject = s;
                    if (s == null)
                    {
                        pinterestjsonobject = _url;
                    }
                    _webView.loadUrl(pinterestjsonobject);
                    return;
                }
            }
            _webView.loadUrl(_url);
        }

        _cls2()
        {
            this$0 = WebViewFragment.this;
            super();
        }
    }


    private class _cls3 extends WebViewClient
    {

        final WebViewFragment this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            if (getActivity() != null && s != null && s.contains("password/reset/complete/"))
            {
                ActivityHelper.goSplashLogin(getActivity());
            }
            if (_progressVw != null)
            {
                _progressVw.setVisibility(8);
            }
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            onPageStarted(webview, s, bitmap);
            if (!shouldHandledByWebhook(s)) goto _L2; else goto _L1
_L1:
            bitmap = getActivity();
            if (bitmap != null) goto _L4; else goto _L3
_L3:
            return;
_L4:
            Intent intent = new Intent(bitmap, com/pinterest/activity/webhook/WebhookActivity);
            intent.setData(Uri.parse(s));
            bitmap.startActivity(intent);
            webview.stopLoading();
            getActivity().finish();
            return;
_L2:
            if (_browserPinBar != null)
            {
                _browserPinBar.setUrl(s);
            }
            if (_progressVw != null)
            {
                _progressVw.setVisibility(0);
                _progressVw.setState(0);
            }
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            return handledByMarket(webview, s);
        }

        _cls3()
        {
            this$0 = WebViewFragment.this;
            super();
        }
    }


    private class _cls1
    {

        final WebViewFragment this$0;
        final View val$view;

        public void setValue(String s)
        {
            if (!StringUtils.isNotEmpty(s)) goto _L2; else goto _L1
_L1:
            final HashMap dataMap;
            dataMap = new HashMap();
            s = new PinterestJsonArray(s);
            int i = 0;
_L6:
            PinterestJsonObject pinterestjsonobject;
            if (i < s.a())
            {
                pinterestjsonobject = s.b(i);
                break MISSING_BLOCK_LABEL_43;
            }
            if (dataMap.isEmpty()) goto _L2; else goto _L3
_L3:
            intent = AppUtils.getAppLinkIntent(dataMap);
            pinterestjsonobject = null;
            s = pinterestjsonobject;
            if (getActivity() == null)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            packagemanager = getActivity().getPackageManager();
            s = pinterestjsonobject;
            if (packagemanager == null)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            s = packagemanager.resolveActivity(intent, 0x10000);
            if (s == null) goto _L2; else goto _L4
_L4:
            getActivity().runOnUiThread(new _cls1());
_L2:
            return;
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final HashMap val$dataMap;
                final Intent val$intent;

                public void run()
                {
                    Object obj;
                    if (view != null)
                    {
                        if ((obj = (ViewStub)view.findViewById(0x7f0b01ad)) != null)
                        {
                            _openInAppBar = (WebViewOpeninAppBar)((ViewStub) (obj)).inflate();
                            String s2 = (String)dataMap.get("al:android:app_name");
                            Button button = (Button)_openInAppBar.findViewById(0x7f0b01cc);
                            obj = s2;
                            if (StringUtils.isEmpty(s2))
                            {
                                obj = "";
                            }
                            button.setText(Resources.string(0x7f0e0342, new Object[] {
                                obj
                            }));
                            _openInAppBar.setIntent(intent);
                            return;
                        }
                    }
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    dataMap = hashmap;
                    intent = intent1;
                    super();
                }
            }

            final Intent intent;
            PackageManager packagemanager;
            if (pinterestjsonobject != null)
            {
                try
                {
                    String s1 = pinterestjsonobject.a("property", "");
                    if (StringUtils.isNotEmpty(s1))
                    {
                        dataMap.put(s1, pinterestjsonobject.a("content", ""));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    CrashReporting.logHandledException(s);
                    return;
                }
            }
            i++;
            if (true) goto _L6; else goto _L5
_L5:
        }

        _cls1()
        {
            this$0 = WebViewFragment.this;
            view = view1;
            super();
        }
    }

}
