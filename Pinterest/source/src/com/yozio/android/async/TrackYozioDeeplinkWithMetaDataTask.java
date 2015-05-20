// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.async;

import android.content.Context;
import com.yozio.android.helpers.Api;
import java.util.HashMap;

public class TrackYozioDeeplinkWithMetaDataTask
    implements Runnable
{

    Context _context;
    HashMap _metaData;

    public TrackYozioDeeplinkWithMetaDataTask(Context context, HashMap hashmap)
    {
        _context = context;
        _metaData = hashmap;
    }

    public void run()
    {
        Api.getInstance().trackYozioDeeplinkWithMetaDataApi(_context, _metaData);
    }
}
