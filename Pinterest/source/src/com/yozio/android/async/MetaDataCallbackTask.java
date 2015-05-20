// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.async;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.yozio.android.YozioService;
import com.yozio.android.helpers.MetaData;
import com.yozio.android.interfaces.YozioMetaDataCallbackable;
import java.util.HashMap;

public class MetaDataCallbackTask
    implements Runnable
{

    private Context _context;
    private String _referrer;

    public MetaDataCallbackTask(Context context, String s)
    {
        _context = context;
        _referrer = s;
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("Got referrer string:")).append(_referrer).toString());
    }

    public void run()
    {
        HashMap hashmap = MetaData.getInstance().getMetaDataFromNewInstallReferrerString(_referrer);
        MetaData.getInstance().persistInstallMetaData(_context, hashmap);
        if (!hashmap.containsKey("__y"))
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "This referrer string is not constructed by Yozio. Skipping.");
            return;
        }
        try
        {
            Object obj = _context.getPackageManager().getApplicationInfo(_context.getPackageName(), 128).metaData.getString("YozioNewInstallMetaDataCallback");
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("yozioMetaDataCallbackClassName: ")).append(((String) (obj))).toString());
            obj = (YozioMetaDataCallbackable)Class.forName(((String) (obj))).newInstance();
            String s = (String)hashmap.get("__yta");
            hashmap = MetaData.getInstance().filterYozioSpecificParams(hashmap);
            ((YozioMetaDataCallbackable) (obj)).onCallback(_context, s, hashmap);
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "YozioMetaDataCallback not configured!");
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "YozioMetaDataCallback is configured, but the class name is not found!");
            return;
        }
        catch (InstantiationException instantiationexception)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "YozioMetaDataCallback is configured, but the class can't be instantiated!");
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "YozioMetaDataCallback is configured, but the class didn't implement YozioMetaDataCallbackable interface!");
        }
    }
}
