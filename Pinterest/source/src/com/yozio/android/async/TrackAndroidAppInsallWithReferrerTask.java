// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.async;

import android.content.Context;
import com.yozio.android.helpers.Api;

public class TrackAndroidAppInsallWithReferrerTask
    implements Runnable
{

    private final Context _context;
    private String _referrer;

    public TrackAndroidAppInsallWithReferrerTask(Context context, String s)
    {
        _context = context;
        _referrer = s;
    }

    public void run()
    {
        Api.getInstance().trackAndroidAppInstallWithReferrerApi(_context, _referrer);
    }
}
