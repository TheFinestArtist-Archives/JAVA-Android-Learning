// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.report;

import android.app.Activity;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

public class ReportHelper
{

    public ReportHelper()
    {
    }

    public static void blockUser(final User user, String s)
    {
        Pinalytics.a(ElementType.USER_BLOCK_BUTTON, ComponentType.MODAL_DIALOG, user.getUid());
        ModelHelper.blockUser(user.getUid(), new _cls1(), s);
    }

    public static void showBlockDialog(Activity activity, final User user)
    {
        final BaseDialog dialog = new BaseDialog();
        String s;
        int i;
        int j;
        int k;
        final boolean blocked;
        if (user.getBlocked() == Boolean.TRUE)
        {
            blocked = true;
        } else
        {
            blocked = false;
        }
        if (blocked)
        {
            i = 0x7f0e04c5;
        } else
        {
            i = 0x7f0e0064;
        }
        if (blocked)
        {
            j = 0x7f0e04bd;
        } else
        {
            j = 0x7f0e0057;
        }
        if (blocked)
        {
            k = 0x7f0e04c2;
        } else
        {
            k = 0x7f0e0061;
        }
        if (user.getFullName() == null)
        {
            s = "";
        } else
        {
            s = user.getFullName();
        }
        dialog.setTitle(String.format(activity.getString(i), new Object[] {
            s
        }));
        if (user.getFirstName() != null)
        {
            dialog.setMessage(String.format(activity.getString(k), new Object[] {
                user.getFirstName()
            }));
        }
        dialog.setPositiveButton(activity.getString(j), new _cls3());
        dialog.setNegativeButton(0x7f0e008f, null);
        Events.post(new DialogEvent(dialog));
    }

    public static void unblockUser(final User user, String s)
    {
        Pinalytics.a(ElementType.USER_BLOCK_BUTTON, ComponentType.MODAL_DIALOG, user.getUid());
        ModelHelper.unblockUser(user.getUid(), new _cls2(), s);
    }

    private class _cls1 extends ApiResponseHandler
    {

        final User val$user;

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            if (apiresponse != null)
            {
                Application.showToast(apiresponse.getMessageDisplay());
            } else
            if (user.getFullName() != null)
            {
                Application.showToast(Resources.string(0x7f0e005f, new Object[] {
                    user.getFullName()
                }));
                return;
            }
        }

        public final void onFinish()
        {
            super.onFinish();
            Events.post(new DialogHideEvent(true));
        }

        public final void onStart()
        {
            if (user.getFullName() != null)
            {
                Events.post(new DialogEvent(new LoadingDialog(Resources.string(0x7f0e0062, new Object[] {
                    user.getFullName()
                }))));
            }
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            Pinalytics.a(EventType.USER_BLOCK, user.getUid());
            if (user.getFullName() != null)
            {
                Application.showToastShort(Resources.string(0x7f0e0063, new Object[] {
                    user.getFullName()
                }));
            }
            user.setBlocked(Boolean.valueOf(true));
            user.setFollowing(false);
            ModelHelper.setUser(user);
            Events.post(new com.pinterest.api.model.User.UpdateEvent(user));
            Events.postSticky(new com.pinterest.api.model.User.UserFollowEvent(user));
        }

        _cls1()
        {
            user = user1;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final boolean val$blocked;
        final BaseDialog val$dialog;
        final User val$user;

        public final void onClick(View view)
        {
            if (blocked)
            {
                ReportHelper.unblockUser(user, null);
            } else
            {
                ReportHelper.blockUser(user, null);
            }
            dialog.dismiss();
        }

        _cls3()
        {
            blocked = flag;
            user = user1;
            dialog = basedialog;
            super();
        }
    }


    private class _cls2 extends ApiResponseHandler
    {

        final User val$user;

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            if (apiresponse != null)
            {
                Application.showToast(apiresponse.getMessageDisplay());
            } else
            if (user.getFullName() != null)
            {
                Application.showToast(Resources.string(0x7f0e04c1, new Object[] {
                    user.getFullName()
                }));
                return;
            }
        }

        public final void onFinish()
        {
            super.onFinish();
            Events.post(new DialogHideEvent(true));
        }

        public final void onStart()
        {
            if (user.getFullName() != null)
            {
                Events.post(new DialogEvent(new LoadingDialog(Resources.string(0x7f0e04c3, new Object[] {
                    user.getFullName()
                }))));
            }
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            Pinalytics.a(EventType.USER_UNBLOCK, user.getUid());
            if (user.getFullName() != null)
            {
                Application.showToastShort(Resources.string(0x7f0e04c4, new Object[] {
                    user.getFullName()
                }));
            }
            user.setBlocked(Boolean.valueOf(false));
            ModelHelper.setUser(user);
            Events.post(new com.pinterest.api.model.User.UpdateEvent(user));
        }

        _cls2()
        {
            user = user1;
            super();
        }
    }

}
