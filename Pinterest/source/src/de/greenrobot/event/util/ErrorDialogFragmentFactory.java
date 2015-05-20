// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event.util;

import android.content.res.Resources;
import android.os.Bundle;

// Referenced classes of package de.greenrobot.event.util:
//            ThrowableFailureEvent, ErrorDialogConfig

public abstract class ErrorDialogFragmentFactory
{

    protected final ErrorDialogConfig config;

    protected ErrorDialogFragmentFactory(ErrorDialogConfig errordialogconfig)
    {
        config = errordialogconfig;
    }

    protected abstract Object createErrorFragment(ThrowableFailureEvent throwablefailureevent, Bundle bundle);

    protected String getMessageFor(ThrowableFailureEvent throwablefailureevent, Bundle bundle)
    {
        int i = config.getMessageIdForThrowable(throwablefailureevent.throwable);
        return config.resources.getString(i);
    }

    protected String getTitleFor(ThrowableFailureEvent throwablefailureevent, Bundle bundle)
    {
        return config.resources.getString(config.defaultTitleId);
    }

    protected Object prepareErrorFragment(ThrowableFailureEvent throwablefailureevent, boolean flag, Bundle bundle)
    {
        if (throwablefailureevent.isSuppressErrorUi())
        {
            return null;
        }
        if (bundle != null)
        {
            bundle = (Bundle)bundle.clone();
        } else
        {
            bundle = new Bundle();
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.title"))
        {
            bundle.putString("de.greenrobot.eventbus.errordialog.title", getTitleFor(throwablefailureevent, bundle));
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.message"))
        {
            bundle.putString("de.greenrobot.eventbus.errordialog.message", getMessageFor(throwablefailureevent, bundle));
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog"))
        {
            bundle.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", flag);
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && config.defaultEventTypeOnDialogClosed != null)
        {
            bundle.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", config.defaultEventTypeOnDialogClosed);
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && config.defaultDialogIconId != 0)
        {
            bundle.putInt("de.greenrobot.eventbus.errordialog.icon_id", config.defaultDialogIconId);
        }
        return createErrorFragment(throwablefailureevent, bundle);
    }
}
