// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.create.fragment.CreatePinFragment;
import com.pinterest.activity.create.fragment.PinMarkletFragment;
import com.pinterest.activity.create.model.PinnableImage;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Application;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;
import com.pinterest.kit.activity.BaseActivity;
import org.apache.commons.lang3.StringUtils;

public class PinItActivity extends BaseActivity
{

    private BaseFragment _currentFragment;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;

    public PinItActivity()
    {
        _eventsSubscriber = new _cls1();
    }

    private Uri getImageUri(Bundle bundle)
    {
        Uri uri1 = (Uri)bundle.get("com.pinterest.EXTRA_URI");
        Uri uri = uri1;
        if (uri1 == null)
        {
            uri = (Uri)bundle.get("android.intent.extra.STREAM");
        }
        return uri;
    }

    private String getSourceURL(Bundle bundle)
    {
        String s = bundle.getString("com.pinterest.EXTRA_URL");
        Object obj = s;
        if (s == null)
        {
            bundle = bundle.getString("android.intent.extra.TEXT");
            obj = bundle;
            if (bundle != null)
            {
                obj = bundle;
                if (!URLUtil.isValidUrl(bundle))
                {
                    obj = StringUtils.substring(bundle, bundle.indexOf("http"), bundle.length());
                }
            }
        }
        return ((String) (obj));
    }

    private void initActivity()
    {
        Object obj1 = getIntent().getExtras();
        if (obj1 != null)
        {
            Object obj = getSourceURL(((Bundle) (obj1)));
            Object obj2 = getImageUri(((Bundle) (obj1)));
            if (obj2 != null)
            {
                obj = new CreatePinFragment();
                FragmentHelper.replaceFragment(this, ((android.support.v4.app.Fragment) (obj)), false);
                obj.imageUri = ((Uri) (obj2));
                _currentFragment = ((BaseFragment) (obj));
                return;
            }
            String s = ((Bundle) (obj1)).getString("com.pinterest.EXTRA_IMAGE");
            if (StringUtils.isNotEmpty(((CharSequence) (obj))) && StringUtils.isNotEmpty(s))
            {
                obj2 = new PinnableImage();
                ((PinnableImage) (obj2)).setSourceUrl(((String) (obj)));
                ((PinnableImage) (obj2)).setImageUrl(s);
                ((PinnableImage) (obj2)).setDescription(((Bundle) (obj1)).getString("com.pinterest.EXTRA_DESCRIPTION"));
                obj = new CreatePinFragment();
                FragmentHelper.replaceFragment(this, ((android.support.v4.app.Fragment) (obj)), false);
                ((CreatePinFragment) (obj)).setPinnableImage(((PinnableImage) (obj2)));
                _currentFragment = ((BaseFragment) (obj));
                return;
            }
            s = ((Bundle) (obj1)).getString("com.pinterest.EXTRA_ID");
            obj2 = ((Bundle) (obj1)).getString("com.pinterest.EXTRA_MESSAGE");
            if (s != null && obj2 != null && obj != null)
            {
                obj1 = new Navigation(Location.REPIN, s);
                ((Navigation) (obj1)).putStringParcelable("com.pinterest.EXTRA_MESSAGE", ((String) (obj2)));
                ((Navigation) (obj1)).putStringParcelable("com.pinterest.EXTRA_URL", ((String) (obj)));
                Events.post(obj1);
                finish();
                return;
            }
            if (URLUtil.isNetworkUrl(((String) (obj))))
            {
                initPinMarklet(((String) (obj)));
                return;
            } else
            {
                Application.showToast(0x7f0e02f4);
                CrashReporting.logHandledException(new IllegalStateException(((Bundle) (obj1)).toString()));
                finish();
                return;
            }
        } else
        {
            finish();
            return;
        }
    }

    private void initPinMarklet(String s)
    {
        PinMarkletFragment pinmarkletfragment = new PinMarkletFragment();
        pinmarkletfragment.setSourceUrl(s);
        FragmentHelper.replaceFragment(this, pinmarkletfragment, false);
        FragmentHelper.updateFragmentWidth(this);
        _currentFragment = pinmarkletfragment;
    }

    public BaseFragment getActiveFragment()
    {
        return _currentFragment;
    }

    protected void onActionBarClicked()
    {
        _currentFragment.scrollTo(0, 0);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!MyUser.hasAccessTokenAndUser())
        {
            ActivityHelper.goSplash(this);
            finish();
            return;
        } else
        {
            setContentView(0x7f030020);
            initActivity();
            Events.register(_eventsSubscriber, com/pinterest/base/Device$MetricsUpdateEvent, new Class[0]);
            return;
        }
    }

    protected void onDestroy()
    {
        Events.unregister(_eventsSubscriber);
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/activity/task/model/Navigation
        });
    }

    protected void onResume()
    {
        super.onResume();
        Events.register(_eventsSubscriber, com/pinterest/activity/task/model/Navigation, new Class[0]);
    }

    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final PinItActivity this$0;

        public void onEventMainThread(Navigation navigation)
        {
            ActivityHelper.goTask(PinItActivity.this, navigation);
        }

        public void onEventMainThread(com.pinterest.base.Device.MetricsUpdateEvent metricsupdateevent)
        {
            FragmentHelper.updateFragmentWidth(PinItActivity.this);
        }

        _cls1()
        {
            this$0 = PinItActivity.this;
            super();
        }
    }

}
