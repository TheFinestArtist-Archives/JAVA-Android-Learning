// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.helper;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.create.helper:
//            CreateImageHelper

final class val.dialog
    implements android.widget.ickListener
{

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
        JVM INSTR tableswitch 0 3: default 48
    //                   0 56
    //                   1 79
    //                   2 102
    //                   3 121;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        val$dialog.dismiss();
        return;
_L2:
        Pinalytics.a(ElementType.CAMERA_BUTTON, ComponentType.MODAL_DIALOG);
        CreateImageHelper.showCustomCameraDialog(view.getContext(), val$intent);
        continue; /* Loop/switch isn't completed */
_L3:
        Pinalytics.a(ElementType.GALLERY_BUTTON, ComponentType.MODAL_DIALOG);
        CreateImageHelper.showCustomGalleryDialog(view.getContext(), val$intent);
        continue; /* Loop/switch isn't completed */
_L4:
        Pinalytics.a(ElementType.FIND_IMAGES_BUTTON, ComponentType.MODAL_DIALOG);
        CreateImageHelper.access$000(view.getContext());
        continue; /* Loop/switch isn't completed */
_L5:
        Pinalytics.a(ElementType.ADD_PLACE_BUTTON, ComponentType.MODAL_DIALOG);
        adapterview = new Navigation(Location.PLACE_PICKER);
        adapterview.putExtra("com.pinterest.EXTRA_MODE", com.pinterest.activity.place.fragment.Mode.CREATE);
        Events.post(adapterview);
        if (true) goto _L1; else goto _L6
_L6:
    }

    .Mode()
    {
        val$intent = intent1;
        val$dialog = basedialog;
        super();
    }
}
