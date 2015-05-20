// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.activity;

import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.Events;
import com.pinterest.kit.tasks.IntervalRunner;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.squareup.seismic.ShakeDetector;

// Referenced classes of package com.pinterest.kit.activity:
//            SocialConnectActivity

public class BaseActivity extends SocialConnectActivity
{

    private static final int DAU_PING_DELAY = 1000;
    protected boolean _autoAnalytics;
    private Runnable _dauRunnable;
    protected Handler _handler;
    private ShakeDetector _shakeDetector;
    private com.squareup.seismic.ShakeDetector.Listener onShake;

    public BaseActivity()
    {
        _autoAnalytics = true;
        _handler = new Handler();
        _dauRunnable = new _cls1();
        onShake = new _cls2();
    }

    public BaseFragment getActiveFragment()
    {
        return null;
    }

    protected String getApiTag()
    {
        return getClass().getName();
    }

    protected void init()
    {
    }

    protected void onActionBarClicked()
    {
    }

    public void onBackPressed()
    {
        Pinalytics.a(ElementType.BACK_BUTTON, ComponentType.NAVIGATION);
        if (getIntent().hasExtra("com.pinterest.EXTRA_BACK_TO_ROOT"))
        {
            ActivityHelper.goHome(this);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (ApplicationInfo.isPrerelease())
        {
            _shakeDetector = new ShakeDetector(onShake);
            _shakeDetector.a((SensorManager)getSystemService("sensor"));
        }
    }

    protected void onDestroy()
    {
        ApiHttpClient.cancelPendingRequests(getApiTag());
        super.onDestroy();
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            ActivityHelper.goHome(this);
            return true;
        } else
        {
            return super.onKeyLongPress(i, keyevent);
        }
    }

    protected void onPause()
    {
        if (_shakeDetector != null)
        {
            _shakeDetector.a();
        }
        Pinalytics.b();
        IntervalRunner.instance().onBackground();
        ApplicationInfo.onBackground();
        super.onPause();
    }

    protected void onResume()
    {
        if (_shakeDetector != null)
        {
            _shakeDetector.a((SensorManager)getSystemService("sensor"));
        }
        if (_autoAnalytics)
        {
            Pinalytics.a(this);
        }
        IntervalRunner.instance().onForeground();
        ApplicationInfo.onForeground();
        super.onResume();
    }

    public boolean onSearchRequested()
    {
        Events.post(new Navigation(Location.SEARCH));
        return super.onSearchRequested();
    }

    protected void onStart()
    {
        super.onStart();
        _handler.postDelayed(_dauRunnable, 1000L);
    }

    protected void onStop()
    {
        _handler.removeCallbacks(_dauRunnable);
        super.onStop();
    }

    public void refresh()
    {
    }


    private class _cls1
        implements Runnable
    {

        final BaseActivity this$0;

        public void run()
        {
            AnalyticsApi.a(new BaseApiResponseHandler());
        }

        _cls1()
        {
            this$0 = BaseActivity.this;
            super();
        }
    }


    private class _cls2
        implements com.squareup.seismic.ShakeDetector.Listener
    {

        final BaseActivity this$0;

        public void hearShake()
        {
            _shakeDetector.a();
            ShakeMenuDialog shakemenudialog = new ShakeMenuDialog(BaseActivity.this);
            class _cls1
                implements com.pinterest.activity.task.dialog.BaseDialog.OnDismissListener
            {

                final _cls2 this$1;

                public void onDismiss(BaseDialog basedialog)
                {
                    _shakeDetector.a((SensorManager)getSystemService("sensor"));
                }

                _cls1()
                {
                    this$1 = _cls2.this;
                    super();
                }
            }

            shakemenudialog.setOnDismissListener(new _cls1());
            show(shakemenudialog);
        }

        _cls2()
        {
            this$0 = BaseActivity.this;
            super();
        }
    }

}
