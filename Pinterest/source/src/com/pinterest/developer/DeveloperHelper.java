// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.developer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.api.ApiClientHelper;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.Device;
import com.pinterest.kit.utils.LocaleUtils;
import com.pinterest.ui.notify.PinterestDialog;
import java.util.Locale;

public class DeveloperHelper
{

    private static boolean a = false;
    private static android.view.View.OnClickListener b = new _cls11();

    public static void a(Context context)
    {
        if (!ApplicationInfo.isNonProduction())
        {
            return;
        } else
        {
            PinterestDialog pinterestdialog = ActivityHelper.getPinterestDialogCancelable(context);
            View view = LayoutInflater.from(context).inflate(0x7f030043, null);
            pinterestdialog.setContent(view);
            Object obj = (TabHost)view.findViewById(0x7f0b00aa);
            ((TabHost) (obj)).setup();
            Object obj1 = ((TabHost) (obj)).newTabSpec("tag1");
            ((android.widget.TabHost.TabSpec) (obj1)).setContent(0x7f0b00ab);
            ((android.widget.TabHost.TabSpec) (obj1)).setIndicator("Basic");
            ((TabHost) (obj)).addTab(((android.widget.TabHost.TabSpec) (obj1)));
            obj1 = ((TabHost) (obj)).newTabSpec("tag2");
            ((android.widget.TabHost.TabSpec) (obj1)).setContent(0x7f0b00ac);
            ((android.widget.TabHost.TabSpec) (obj1)).setIndicator("Experiments");
            ((TabHost) (obj)).addTab(((android.widget.TabHost.TabSpec) (obj1)));
            ((TabHost) (obj)).setCurrentTab(0);
            obj = (TextView)view.findViewById(0x7f0b00ae);
            obj1 = Device.getCarrierName();
            MccMnc mccmnc = Device.getNetworkOperatorFromConfig();
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(((String) (obj1)));
            stringbuilder.append(mccmnc);
            stringbuilder.append((new StringBuilder(" locale: ")).append(Locale.getDefault()).toString());
            stringbuilder.append((new StringBuilder("\n")).append(ApiClientHelper.a()).toString());
            ((TextView) (obj)).setText(stringbuilder);
            ((Button)view.findViewById(0x7f0b00b6)).setOnClickListener(new _cls12(mccmnc));
            view.findViewById(0x7f0b00af).setOnClickListener(b);
            view.findViewById(0x7f0b00b0).setOnClickListener(b);
            view.findViewById(0x7f0b00b1).setOnClickListener(b);
            ((Button)view.findViewById(0x7f0b00b2)).setOnClickListener(new _cls1());
            ((Button)view.findViewById(0x7f0b00b3)).setOnClickListener(new _cls2(pinterestdialog));
            view.findViewById(0x7f0b00b4);
            ((Button)view.findViewById(0x7f0b00b5)).setOnClickListener(new _cls3(context));
            context = (EditText)view.findViewById(0x7f0b00bb);
            context.setText(ApiHttpClient.getBaseApiUrl());
            view.findViewById(0x7f0b00b9).setOnClickListener(new _cls4(context));
            view.findViewById(0x7f0b00ba).setOnClickListener(new _cls5(context));
            obj = (EditText)view.findViewById(0x7f0b00be);
            ((EditText) (obj)).setText(ApiHttpClient.getBaseLoggingApiUrl());
            view.findViewById(0x7f0b00bc).setOnClickListener(new _cls6(((EditText) (obj))));
            view.findViewById(0x7f0b00bd).setOnClickListener(new _cls7(((EditText) (obj))));
            ((Button)view.findViewById(0x7f0b00b8)).setOnClickListener(new _cls8());
            ((Button)view.findViewById(0x7f0b00b7)).setOnClickListener(new _cls9());
            obj1 = (CheckBox)view.findViewById(0x7f0b00bf);
            ((CheckBox) (obj1)).setChecked(a);
            ((TextView)view.findViewById(0x7f0b00c1)).setText(LocaleUtils.getDisplayLang());
            view.findViewById(0x7f0b00c0);
            pinterestdialog.setTitle("Developer Options");
            pinterestdialog.setPositiveButton("Save", new _cls10(context, ((EditText) (obj)), ((CheckBox) (obj1))));
            pinterestdialog.show();
            return;
        }
    }

    public static void a(boolean flag)
    {
        a = flag;
    }

    public static boolean a()
    {
        return a;
    }


    private class _cls12
        implements android.view.View.OnClickListener
    {

        final MccMnc a;

        public final void onClick(View view)
        {
            class _cls1 extends ApiResponseHandler
            {

                final _cls12 a;

                public void onSuccess(ApiResponse apiresponse)
                {
                    super.onSuccess(apiresponse);
                    Application.showToast((new StringBuilder("loadWidgetAvailability: ")).append(apiresponse).toString());
                }

                _cls1()
                {
                    a = _cls12.this;
                    super();
                }
            }

            WidgetApi.a(a.mcc, a.mnc, new _cls1());
        }

        _cls12(MccMnc mccmnc)
        {
            a = mccmnc;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        public final void onClick(View view)
        {
            AutoUpdateManager.a().startUpdate(null);
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PinterestDialog a;

        public final void onClick(View view)
        {
            Events.post(new Navigation(Location.PIN_PICKS, "pinpicks/us/breakfast/"));
            a.dismiss();
        }

        _cls2(PinterestDialog pinterestdialog)
        {
            a = pinterestdialog;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final Context a;

        public final void onClick(View view)
        {
            ActivityHelper.goNUXExperience(a);
        }

        _cls3(Context context)
        {
            a = context;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final EditText a;

        public final void onClick(View view)
        {
            a.setText(ApiHttpClient.getDevBaseApiUrl());
        }

        _cls4(EditText edittext)
        {
            a = edittext;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final EditText a;

        public final void onClick(View view)
        {
            a.setText("https://api.pinterest.com/v3/%s");
        }

        _cls5(EditText edittext)
        {
            a = edittext;
            super();
        }
    }


    private class _cls6
        implements android.view.View.OnClickListener
    {

        final EditText a;

        public final void onClick(View view)
        {
            a.setText(ApiHttpClient.getDevBaseLoggingApiUrl());
        }

        _cls6(EditText edittext)
        {
            a = edittext;
            super();
        }
    }


    private class _cls7
        implements android.view.View.OnClickListener
    {

        final EditText a;

        public final void onClick(View view)
        {
            a.setText("https://trk.pinterest.com/v3/%s");
        }

        _cls7(EditText edittext)
        {
            a = edittext;
            super();
        }
    }


    private class _cls8
        implements android.view.View.OnClickListener
    {

        public final void onClick(View view)
        {
            Events.post(new DialogEvent(new UploadContactsDialog()));
        }

        _cls8()
        {
        }
    }


    private class _cls9
        implements android.view.View.OnClickListener
    {

        public final void onClick(View view)
        {
            Services.startNotificationService();
        }

        _cls9()
        {
        }
    }


    private class _cls10
        implements android.content.DialogInterface.OnClickListener
    {

        final EditText a;
        final EditText b;
        final CheckBox c;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            String s = a.getText().toString();
            if (s.lastIndexOf("%s") != s.length() - 2)
            {
                Application.showToast("API URL must contain AND end with '%s'");
                return;
            }
            ApiHttpClient.setBaseApiUrl(s);
            s = b.getText().toString();
            if (s.lastIndexOf("%s") != s.length() - 2)
            {
                Application.showToast("Logging API URL must contain AND end with '%s'");
                return;
            } else
            {
                ApiHttpClient.setBaseLoggingApiUrl(s);
                DeveloperHelper.a(c.isChecked());
                dialoginterface.dismiss();
                return;
            }
        }

        _cls10(EditText edittext, EditText edittext1, CheckBox checkbox)
        {
            a = edittext;
            b = edittext1;
            c = checkbox;
            super();
        }
    }


    private class _cls11
        implements android.view.View.OnClickListener
    {

        public final void onClick(View view)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131427503: 
                Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.GPLUS, true));
                return;

            case 2131427504: 
                Events.post(new com.pinterest.base.Social.RequestDisconnectEvent(com.pinterest.base.Social.Network.GPLUS));
                return;

            case 2131427505: 
                Experiments.r();
                break;
            }
        }

        _cls11()
        {
        }
    }

}
