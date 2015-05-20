// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.SocialUtils;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.List;

final class val.context
    implements com.pinterest.activity.task.dialog.ogClickListener
{

    final List val$apps;
    final Context val$context;
    final Intent val$intent;
    final PackageManager val$pm;
    final String val$toShare;

    public final void onClick(BaseDialog basedialog, int i)
    {
        Object obj = ((ResolveInfo)val$apps.get(i)).activityInfo;
        String s = ((ActivityInfo) (obj)).packageName;
        Pinalytics.a(ElementType.SHARE_SOCIAL_BUTTON, ComponentType.MODAL_DIALOG, s);
        obj = (String)val$pm.getApplicationLabel(((ActivityInfo) (obj)).applicationInfo);
        val$intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(val$toShare).append(SocialUtils.getMedium(((String) (obj)))).toString());
        val$intent.setPackage(s);
        val$context.startActivity(val$intent);
        basedialog.dismiss();
    }

    ialog()
    {
        val$apps = list;
        val$pm = packagemanager;
        val$intent = intent1;
        val$toShare = s;
        val$context = context1;
        super();
    }
}
