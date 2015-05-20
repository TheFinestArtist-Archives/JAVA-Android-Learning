// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android;

import android.content.Context;
import android.content.Intent;
import com.yozio.android.helpers.MetaData;
import java.util.HashMap;

// Referenced classes of package com.yozio.android:
//            YozioService

public class Yozio
{

    public static int YOZIO_CONNECTION_TIMEOUT = 15000;
    public static boolean YOZIO_ENABLE_LOGGING = true;
    public static int YOZIO_SOCKET_TIMEOUT = 15000;

    public Yozio()
    {
    }

    public static HashMap getInstallMetaDataAsHash(Context context)
    {
        return MetaData.getInstance().getInstallMetaDataAsHash(context);
    }

    public static String getInstallMetaDataAsUrlParameterString(Context context)
    {
        return MetaData.getInstance().getInstallMetaDataAsUrlParameterString(context);
    }

    public static HashMap getMetaData(Intent intent)
    {
        return MetaData.getInstance().getMetaDataFromIntent(intent);
    }

    public static void initialize(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("!!!!!!!!!!!!!!!!!! Context cannot be null.");
        } else
        {
            YozioService.getInstance().initialize(context);
            return;
        }
    }

    public static void startActivityWithMetaData(Context context, String s, HashMap hashmap)
    {
        YozioService.getInstance().startActivityWithMetaData(context, s, hashmap);
    }

    public static void trackCustomEvent(Context context, String s, double d)
    {
        HashMap hashmap = getInstallMetaDataAsHash(context);
        hashmap.put("__yozio_event_type", "custom_event");
        YozioService.getInstance().trackEvent(context, s, d, hashmap);
    }

    public static void trackPayment(Context context, double d)
    {
        trackCustomEvent(context, "payment", d);
    }

    public static void trackSignUp(Context context)
    {
        trackCustomEvent(context, "signup", 0.0D);
    }

}
