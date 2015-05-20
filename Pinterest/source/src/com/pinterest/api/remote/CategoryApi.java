// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiFields;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.appwidget.MccMnc;
import com.pinterest.base.Device;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class CategoryApi extends BaseApi
{

    public static void a(CategoriesFeedApiResponse categoriesfeedapiresponse, String s)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("add_fields", "category.images[45x,200x]");
        a("categories/", ((Map) (treemap)), ((com.pinterest.api.BaseApiResponseHandler) (categoriesfeedapiresponse)), s);
    }

    public static void a(String s, PinApi.PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        s = String.format("feeds/%s/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.t);
        treemap.put("page_size", Device.getPageSizeString());
        MccMnc mccmnc = Device.getNetworkOperatorFromConfig();
        treemap.put("mcc", String.valueOf(mccmnc.mcc));
        treemap.put("mnc", String.valueOf(mccmnc.mnc));
        a(s, ((Map) (treemap)), ((com.pinterest.api.BaseApiResponseHandler) (pinfeedapiresponse)), s1);
    }

    public static void a(String s, PinApi.PinFeedApiResponse pinfeedapiresponse, Map map)
    {
        s = String.format("feeds/%s/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("page_size", "40");
        MccMnc mccmnc = Device.getNetworkOperatorFromConfig();
        treemap.put("mcc", String.valueOf(mccmnc.mcc));
        treemap.put("mnc", String.valueOf(mccmnc.mnc));
        treemap.put("join", "board,pinner,via_pinner");
        treemap.put("add_fields", "pin.board,pin.pinner,pin.via_pinner");
        try
        {
            ApiHttpClient.signedCall(s, "GET", treemap, pinfeedapiresponse, map, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }
}
