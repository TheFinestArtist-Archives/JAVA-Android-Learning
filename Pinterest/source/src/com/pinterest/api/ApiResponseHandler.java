// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.dialog.LoadingDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.event.DialogHideEvent;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api:
//            BaseApiResponseHandler, ApiResponse

public class ApiResponseHandler extends BaseApiResponseHandler
{

    private static boolean _forceUnauthLogout = true;
    private static final List noAuth = Arrays.asList(new Integer[] {
        Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(81)
    });
    private static final List noToast = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(60)
    });
    private static final List showAlert = Arrays.asList(new Integer[] {
        Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(19)
    });
    protected boolean _showLoadingDialog;
    protected int _waitStringId;

    public ApiResponseHandler()
    {
        _showLoadingDialog = false;
        _waitStringId = 0x7f0e02c4;
    }

    public ApiResponseHandler(int i)
    {
        _showLoadingDialog = false;
        _waitStringId = 0x7f0e02c4;
        _showLoadingDialog = true;
        _waitStringId = i;
    }

    public ApiResponseHandler(boolean flag)
    {
        _showLoadingDialog = false;
        _waitStringId = 0x7f0e02c4;
        _showLoadingDialog = flag;
    }

    public static void setForceUnauthedLogout(boolean flag)
    {
        _forceUnauthLogout = flag;
    }

    public static boolean shouldForceUnauthedLogout()
    {
        return MyUser.isLoggedIn() && _forceUnauthLogout;
    }

    private boolean shouldLogout(int i)
    {
        return shouldForceUnauthedLogout() && noAuth.contains(Integer.valueOf(i));
    }

    private boolean shouldShowDialog(int i)
    {
        return showAlert.contains(Integer.valueOf(i));
    }

    private boolean shouldToast(int i)
    {
        return ApplicationInfo.isNonProduction() || !noToast.contains(Integer.valueOf(i));
    }

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        boolean flag = true;
        String s = _baseUrl;
        s = _method;
        apiresponse.getMessageDetailIfExist();
        if (!Device.hasInternet())
        {
            Application.showNoInternetToast();
        } else
        {
            int i = apiresponse.getCode();
            if (shouldLogout(i))
            {
                Events.post(new Navigation(Location.AUTH));
            }
            if (shouldShowDialog(i))
            {
                BaseDialog basedialog = new BaseDialog();
                basedialog.setTitle(apiresponse.getMessage());
                basedialog.setMessage(apiresponse.getMessageDetail());
                basedialog.setNegativeButton(0x7f0e033a, null);
                Events.post(new DialogEvent(basedialog));
            } else
            {
                flag = false;
            }
            if (!flag && shouldToast(i))
            {
                String s1 = apiresponse.getMessageDisplay();
                Object obj = s1;
                if (ApplicationInfo.isNonProduction())
                {
                    apiresponse = s1;
                    if (StringUtils.isEmpty(s1))
                    {
                        apiresponse = throwable.getMessage();
                    }
                    obj = apiresponse;
                    if (StringUtils.isEmpty(apiresponse))
                    {
                        obj = throwable.toString();
                    }
                }
                Application.showToast(((String) (obj)));
                return;
            }
        }
    }

    public void onFinish()
    {
        if (_showLoadingDialog)
        {
            Events.post(new DialogHideEvent(true));
        }
        super.onFinish();
    }

    public void onStart()
    {
        if (_showLoadingDialog)
        {
            Events.post(new DialogEvent(new LoadingDialog(_waitStringId)));
        }
        super.onStart();
    }

    public void setShowLoadingDialog(boolean flag)
    {
        _showLoadingDialog = flag;
    }

}
