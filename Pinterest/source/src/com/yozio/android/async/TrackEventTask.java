// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.async;

import android.content.Context;
import com.yozio.android.YozioService;
import com.yozio.android.helpers.Api;
import com.yozio.android.helpers.SystemInfo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrackEventTask
    implements Runnable
{

    private final Context _context;
    private final String _name;
    private final HashMap _properties;
    private final double _value;

    public TrackEventTask(Context context, String s, double d, HashMap hashmap)
    {
        _context = context;
        _name = s;
        _value = d;
        _properties = hashmap;
    }

    public void run()
    {
        Object obj1 = Double.toString(_value);
        com.yozio.android.Constants.LOG_LEVEL log_level = com.yozio.android.Constants.LOG_LEVEL.INFO;
        StringBuilder stringbuilder = new StringBuilder("track event name:[");
        Object obj;
        if (_name != null)
        {
            obj = _name;
        } else
        {
            obj = "";
        }
        stringbuilder = stringbuilder.append(((String) (obj))).append("], value:[").append(((String) (obj1))).append("], properties:[");
        if (_properties != null)
        {
            obj = _properties.toString();
        } else
        {
            obj = "";
        }
        YozioService.log(log_level, stringbuilder.append(((String) (obj))).append("]").toString());
        obj = new JSONObject();
        if (_name != null)
        {
            ((JSONObject) (obj)).put("name", _name);
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        ((JSONObject) (obj)).put("value", obj1);
        if (_properties != null)
        {
            ((JSONObject) (obj)).put("properties", new JSONObject(_properties));
        }
        ((JSONObject) (obj)).put("timestamp", Long.toString(SystemInfo.getInstance().getCurrentTimeLong()));
_L2:
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(obj);
        if (!Api.getInstance().postEvents(_context, ((JSONArray) (obj1))))
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("failed to post event to server - ")).append(((JSONArray) (obj1)).toString()).toString());
        }
        return;
        Exception exception;
        exception;
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "failed to construct event JSON before posting to server!");
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }
}
