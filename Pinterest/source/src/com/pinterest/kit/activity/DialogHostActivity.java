// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.dialog.LoadingDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.event.DialogHideEvent;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.kit.activity:
//            VisibilityControl

public class DialogHostActivity extends ActionBarActivity
    implements VisibilityControl
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private boolean _isVisible;
    private BaseDialog _previousDialog;
    private String _waitMessage;

    public DialogHostActivity()
    {
        _eventsSubscriber = new _cls1();
    }

    public void hideWaitDialog()
    {
        if (_previousDialog instanceof LoadingDialog)
        {
            show(null);
        }
    }

    public boolean isVisible()
    {
        return _isVisible;
    }

    protected void onPause()
    {
        hideWaitDialog();
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/activity/task/event/DialogEvent, com/pinterest/activity/task/event/DialogHideEvent
        });
        _isVisible = false;
        super.onPause();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        _isVisible = true;
    }

    protected void onResume()
    {
        super.onResume();
        Events.registerSticky(_eventsSubscriber, com/pinterest/activity/task/event/DialogEvent, new Class[] {
            com/pinterest/activity/task/event/DialogHideEvent
        });
        if (shouldBeWaiting())
        {
            showWaitDialog(_waitMessage);
        }
    }

    public boolean shouldBeWaiting()
    {
        return StringUtils.isNotEmpty(_waitMessage);
    }

    protected void show(BaseDialog basedialog)
    {
        if ((_previousDialog instanceof LoadingDialog) && (basedialog instanceof LoadingDialog))
        {
            ((LoadingDialog)_previousDialog).setWaitText(((LoadingDialog)basedialog).getWaitText());
            _waitMessage = null;
        } else
        {
            if (_previousDialog != null && (basedialog == null || basedialog.getHidePrevious()))
            {
                _previousDialog.dismiss();
                _previousDialog = null;
            }
            if (basedialog != null && !basedialog.isAdded() && !isFinishing())
            {
                try
                {
                    basedialog.show(getSupportFragmentManager().beginTransaction(), basedialog.getKey());
                    if (_previousDialog == null)
                    {
                        _previousDialog = basedialog;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (BaseDialog basedialog)
                {
                    CrashReporting.logHandledException(basedialog);
                }
                _waitMessage = null;
                return;
            }
        }
    }

    public void showWaitDialog()
    {
        showWaitDialog(0x7f0e02c4);
    }

    public void showWaitDialog(int i)
    {
        showWaitDialog(Resources.string(i));
    }

    public void showWaitDialog(String s)
    {
        if (!(_previousDialog instanceof LoadingDialog) && isVisible())
        {
            show(new LoadingDialog(s));
        }
    }

    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final DialogHostActivity this$0;

        public void onEventMainThread(DialogEvent dialogevent)
        {
            Events.removeStickyEvent(dialogevent);
            show(dialogevent.getDialog());
        }

        public void onEventMainThread(DialogHideEvent dialoghideevent)
        {
            Events.removeStickyEvent(dialoghideevent);
            if (dialoghideevent.waitDialogOnly())
            {
                hideWaitDialog();
                return;
            } else
            {
                show(null);
                return;
            }
        }

        _cls1()
        {
            this$0 = DialogHostActivity.this;
            super();
        }
    }

}
