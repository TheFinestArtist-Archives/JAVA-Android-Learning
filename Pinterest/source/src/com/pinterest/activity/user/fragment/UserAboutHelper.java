// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.fragment;

import android.content.Context;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.pin.adapter.SimpleTextListAdapter;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import java.util.ArrayList;

public class UserAboutHelper
{

    public UserAboutHelper()
    {
    }

    public static void showUserPictureSource(final Context context)
    {
        if (context == null)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        if (Device.hasCamera())
        {
            arraylist.add(context.getString(0x7f0e04a0));
        }
        arraylist.add(context.getString(0x7f0e024b));
        arraylist.toArray(new String[arraylist.size()]);
        BaseDialog basedialog = new BaseDialog();
        basedialog.setTitle(0x7f0e00bf);
        SimpleTextListAdapter simpletextlistadapter = new SimpleTextListAdapter(false);
        simpletextlistadapter.setDataSource(arraylist);
        basedialog.setListViewOptions(simpletextlistadapter, new _cls1());
        Events.post(new DialogEvent(basedialog));
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final Context val$context;
        final BaseDialog val$dialog;
        final Intent val$intent;

        public final void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            int j;
            j = i;
            if (!Device.hasCamera())
            {
                j = i + 1;
            }
            j;
            JVM INSTR tableswitch 0 1: default 40
        //                       0 48
        //                       1 62;
               goto _L1 _L2 _L3
_L1:
            dialog.dismiss();
            return;
_L2:
            CreateImageHelper.showCustomCameraDialog(context, intent);
            continue; /* Loop/switch isn't completed */
_L3:
            CreateImageHelper.showCustomGalleryDialog(context, intent);
            if (true) goto _L1; else goto _L4
_L4:
        }

        _cls1()
        {
            context = context1;
            intent = intent1;
            dialog = basedialog;
            super();
        }
    }

}
