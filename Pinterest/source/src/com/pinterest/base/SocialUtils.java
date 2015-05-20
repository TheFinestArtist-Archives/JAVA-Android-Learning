// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.widget.FacebookDialog;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.sendapin.model.SendableObject;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.User;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.LocaleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.base:
//            Device, Social, Application

public class SocialUtils
{

    public static final int MAX_SEND_APP = 2;
    public static final int MAX_SHARE_APP = 3;

    public SocialUtils()
    {
    }

    private static String attachTracking(String s)
    {
        String s2 = (new StringBuilder("?s=")).append(String.valueOf(Device.getAppTypeInt())).toString();
        String s1 = s2;
        if (!StringUtils.isEmpty(s))
        {
            s1 = (new StringBuilder()).append(s2).append(getMedium(s)).toString();
        }
        return s1;
    }

    private static String capDescription(String s)
    {
        String s1 = s;
        if (s.length() > 105)
        {
            s1 = (new StringBuilder()).append(s.substring(0, 100)).append("...").toString();
        }
        s = s1;
        if (s1.length() > 0)
        {
            s = (new StringBuilder()).append(s1).append(" - ").toString();
        }
        return s;
    }

    public static List getAppListForSend()
    {
        return getIconTextList(Social.RANKDED_APP_LIST, 2);
    }

    public static List getAppListForShare()
    {
        return getIconTextList(Social.RANKDED_APP_LIST, 3);
    }

    public static List getIconTextList(List list, int i)
    {
        ArrayList arraylist;
        PackageManager packagemanager;
        arraylist = new ArrayList(list.size());
        packagemanager = Application.context().getPackageManager();
        list = list.iterator();
_L2:
        String s;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        s = (String)list.next();
        int j;
        ApplicationInfo applicationinfo = packagemanager.getApplicationInfo(s, 0);
        if (!applicationinfo.enabled)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s1 = (String)packagemanager.getApplicationLabel(applicationinfo);
        arraylist.add(new com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText(packagemanager.getApplicationIcon(applicationinfo), s1, s));
        j = arraylist.size();
        if (j < i)
        {
            continue; /* Loop/switch isn't completed */
        }
        return arraylist;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static ArrayList getInstalledTopApps(int i)
    {
        ArrayList arraylist = new ArrayList(i);
        Iterator iterator = Social.RANKDED_APP_LIST.iterator();
label0:
        do
        {
            String s;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s = (String)iterator.next();
            } while (!isAppInstalled(s));
            arraylist.add(s);
        } while (arraylist.size() < i);
        return arraylist;
    }

    public static String getMedium(String s)
    {
        return (new StringBuilder("&m=")).append(s.replaceAll("\\s", "").toLowerCase()).toString();
    }

    public static boolean hasFBShareDialog()
    {
        return FacebookDialog.canPresentShareDialog(Application.context(), new com.facebook.widget.FacebookDialog.ShareDialogFeature[] {
            com.facebook.widget.FacebookDialog.ShareDialogFeature.SHARE_DIALOG
        });
    }

    public static boolean isAppInstalled(String s)
    {
        PackageManager packagemanager = Application.context().getPackageManager();
        try
        {
            packagemanager.getPackageInfo(s, 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static boolean isLineInstalledInJp()
    {
        return LocaleUtils.isLanguageJa() && isAppInstalled("jp.naver.line.android");
    }

    public static void startShare(Context context, SendableObject sendableobject, String s, String s1)
    {
        if (sendableobject != null)
        {
            if (sendableobject.isPin())
            {
                startShare(context, ModelHelper.getPin(sendableobject.getUid()), s, s1);
                return;
            }
            if (sendableobject.isBoard())
            {
                startShare(context, ModelHelper.getBoard(sendableobject.getUid()), s, s1);
                return;
            }
            if (sendableobject.isUser())
            {
                startShare(context, ModelHelper.getUser(sendableobject.getUid()), s, s1);
                return;
            }
        }
    }

    public static void startShare(Context context, Board board, String s, String s1)
    {
        if (board == null)
        {
            return;
        } else
        {
            String s2 = capDescription((new StringBuilder()).append(Resources.string(0x7f0e049f)).append(" ").append(board.getName()).toString());
            board = (new StringBuilder()).append(s2).append(StringUtils.removeEnd(Resources.string(0x7f0e0381), "/")).append(board.getUrl()).toString();
            ActivityHelper.doShare(context, (new StringBuilder()).append(board).append(attachTracking(s)).toString(), null, s1);
            return;
        }
    }

    public static void startShare(Context context, Pin pin)
    {
        startShare(context, pin, null, null);
    }

    public static void startShare(Context context, Pin pin, String s, String s1)
    {
        if (pin == null)
        {
            return;
        } else
        {
            Object obj = capDescription(pin.getDescription());
            obj = (new StringBuilder()).append(((String) (obj))).append(String.format(context.getString(0x7f0e04de), new Object[] {
                pin.getUid().toString()
            })).toString();
            s = (new StringBuilder()).append(((String) (obj))).append(attachTracking(s)).toString();
            obj = new Bundle();
            ((Bundle) (obj)).putString("com.pinterest.EXTRA_PIN_ID", pin.getUid());
            ((Bundle) (obj)).putString("com.pinterest.EXTRA_MESSAGE", pin.getDescription());
            ((Bundle) (obj)).putString("com.pinterest.EXTRA_URL", pin.getImageLargeUrl());
            ActivityHelper.doShare(context, s, ((Bundle) (obj)), s1);
            return;
        }
    }

    public static void startShare(Context context, User user, String s, String s1)
    {
        if (user == null)
        {
            return;
        } else
        {
            String s2 = capDescription((new StringBuilder()).append(Resources.string(0x7f0e049f)).append(" ").append(user.getFullName()).toString());
            user = (new StringBuilder()).append(s2).append(Resources.string(0x7f0e0381)).append(user.getUsername()).toString();
            ActivityHelper.doShare(context, (new StringBuilder()).append(user).append(attachTracking(s)).toString(), null, s1);
            return;
        }
    }
}
