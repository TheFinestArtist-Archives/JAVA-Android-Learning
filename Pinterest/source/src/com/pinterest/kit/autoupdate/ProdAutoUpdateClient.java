// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.autoupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.pinterest.activity.map.GoogleServiceDialog;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent;
import java.util.Date;

// Referenced classes of package com.pinterest.kit.autoupdate:
//            AutoUpdateClient

public class ProdAutoUpdateClient
    implements AutoUpdateClient
{

    private String a;
    private BaseApiResponseHandler b;

    public ProdAutoUpdateClient()
    {
        a = null;
        b = new _cls1();
    }

    static int a(int i)
    {
        return i / 10;
    }

    static String a(ProdAutoUpdateClient prodautoupdateclient, String s)
    {
        prodautoupdateclient.a = s;
        return s;
    }

    public static boolean a()
    {
        return Build.MANUFACTURER.equalsIgnoreCase("Amazon");
    }

    public static boolean b()
    {
        return Build.MODEL.equalsIgnoreCase("SD4930UR");
    }

    static void c()
    {
        HomeFeedMegaphoneEvent homefeedmegaphoneevent = new HomeFeedMegaphoneEvent(com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent.EventType.UPDATE);
        homefeedmegaphoneevent.setTitle(Resources.string(0x7f0e0055));
        homefeedmegaphoneevent.setDesc(Resources.string(0x7f0e0054));
        homefeedmegaphoneevent.setPositiveBtnText(Resources.string(0x7f0e04d2));
        homefeedmegaphoneevent.setNegativeBtnText(Resources.string(0x7f0e0315));
        Events.removeStickyEvent(com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent);
        Events.postSticky(homefeedmegaphoneevent);
    }

    static Date d()
    {
        return new Date(Preferences.user().getLong("PREF_AUTO_UPDATE_LAST_SHOWN", 0L));
    }

    static void e()
    {
        Preferences.user().set("PREF_AUTO_UPDATE_LAST_SHOWN", (new Date()).getTime());
    }

    public void checkForUpdate()
    {
        ApiHttpClient.get("http://passets-cdn.pinterest.com/status/android_status.json", b, false, null);
    }

    public void startUpdate(Activity activity)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        String s;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        s = a;
_L1:
        intent.setData(Uri.parse(s));
        activity.startActivity(intent);
        return;
        if (GoogleServiceDialog.isPlayServicesAvailable())
        {
            s = "market://details?id=com.pinterest";
        } else
        {
            s = "amzn://apps/android?p=com.pinterest";
        }
          goto _L1
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.pinterest"));
        intent.addFlags(0x10000000);
        activity.startActivity(intent);
        return;
    }

    private class _cls1 extends BaseApiResponseHandler
    {

        final ProdAutoUpdateClient a;

        private int a(PinterestJsonObject pinterestjsonobject)
        {
            int i = a(pinterestjsonobject.c("latest_version"), android.os.Build.VERSION.SDK_INT);
            ProdAutoUpdateClient.a(a, pinterestjsonobject.a("link", ""));
            return i;
        }

        private static int a(Object obj, int i)
        {
            int k;
            if (obj instanceof PinterestJsonObject)
            {
                obj = (PinterestJsonObject)obj;
                Iterator iterator = ((PinterestJsonObject) (obj)).c().iterator();
                int j = 0;
                do
                {
                    k = j;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (i >= Integer.parseInt(s))
                    {
                        int l = ((PinterestJsonObject) (obj)).a(s, 0);
                        k = j;
                        if (l > j)
                        {
                            k = l;
                        }
                        j = k;
                    }
                } while (true);
            } else
            {
                k = 0;
            }
            return k;
        }

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
        }

        public void onSuccess(PinterestJsonObject pinterestjsonobject)
        {
            super.onSuccess(pinterestjsonobject);
            if (pinterestjsonobject == null) goto _L2; else goto _L1
_L1:
            Object obj;
            int j;
            int k;
            k = ApplicationInfo.getVersionCode();
            obj = pinterestjsonobject.c("bad_version");
            if (!(obj instanceof PinterestJsonArray))
            {
                break MISSING_BLOCK_LABEL_234;
            }
            obj = (PinterestJsonArray)obj;
            j = ((PinterestJsonArray) (obj)).a();
            int i = 0;
_L16:
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_234;
            }
            if (k != ((PinterestJsonArray) (obj)).a.get(i).getAsInt()) goto _L4; else goto _L3
_L3:
            i = 1;
_L17:
            if (a(pinterestjsonobject.c("min_version"), android.os.Build.VERSION.SDK_INT) > k)
            {
                j = 1;
            } else
            {
                j = 0;
            }
              goto _L5
_L14:
            try
            {
                ProdAutoUpdateClient.c();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (PinterestJsonObject pinterestjsonobject)
            {
                return;
            }
_L15:
            if (GoogleServiceDialog.isPlayServicesAvailable() || !ProdAutoUpdateClient.a()) goto _L7; else goto _L6
_L6:
            if (!ProdAutoUpdateClient.b()) goto _L9; else goto _L8
_L8:
            obj = pinterestjsonobject.c("amazon_phone");
            if (obj == null) goto _L7; else goto _L10
_L10:
            i = a(((PinterestJsonObject) (obj)));
_L13:
            if (ProdAutoUpdateClient.a(i) - ProdAutoUpdateClient.a(k) >= 2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i == 0) goto _L2; else goto _L11
_L11:
            pinterestjsonobject = ProdAutoUpdateClient.d();
            obj = Calendar.getInstance();
            ((Calendar) (obj)).add(5, -7);
            if (((Calendar) (obj)).getTime().compareTo(pinterestjsonobject) > 0)
            {
                ProdAutoUpdateClient.c();
                ProdAutoUpdateClient.e();
                return;
            }
              goto _L2
_L9:
            obj = pinterestjsonobject.c("amazon");
            if (obj == null) goto _L7; else goto _L12
_L12:
            i = a(((PinterestJsonObject) (obj)));
              goto _L13
_L7:
            i = a(pinterestjsonobject);
              goto _L13
_L5:
            if (i == 0 && !j) goto _L15; else goto _L14
_L2:
            return;
_L4:
            i++;
              goto _L16
            i = 0;
              goto _L17
        }

        _cls1()
        {
            a = ProdAutoUpdateClient.this;
            super();
        }
    }

}
