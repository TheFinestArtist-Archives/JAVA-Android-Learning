// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.autoupdate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.pinterest.activity.map.GoogleServiceDialog;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.base.ApplicationInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.pinterest.kit.autoupdate:
//            ProdAutoUpdateClient

class a extends BaseApiResponseHandler
{

    final ProdAutoUpdateClient a;

    private int a(PinterestJsonObject pinterestjsonobject)
    {
        int i = a(pinterestjsonobject.c("latest_version"), android.os.ect.c);
        ProdAutoUpdateClient.a(a, pinterestjsonobject.a("link", ""));
        return i;
    }

    private static int a(Object obj, int i)
    {
        int k;
        if (obj instanceof PinterestJsonObject)
        {
            obj = (PinterestJsonObject)obj;
            Iterator iterator = ((PinterestJsonObject) (obj)).c().iterator();
            int j = 0;
            do
            {
                k = j;
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (i >= Integer.parseInt(s))
                {
                    int l = ((PinterestJsonObject) (obj)).a(s, 0);
                    k = j;
                    if (l > j)
                    {
                        k = l;
                    }
                    j = k;
                }
            } while (true);
        } else
        {
            k = 0;
        }
        return k;
    }

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
    }

    public void onSuccess(PinterestJsonObject pinterestjsonobject)
    {
        super.onSuccess(pinterestjsonobject);
        if (pinterestjsonobject == null) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        int k;
        k = ApplicationInfo.getVersionCode();
        obj = pinterestjsonobject.c("bad_version");
        if (!(obj instanceof PinterestJsonArray))
        {
            break MISSING_BLOCK_LABEL_234;
        }
        obj = (PinterestJsonArray)obj;
        j = ((PinterestJsonArray) (obj)).a();
        int i = 0;
_L16:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        if (k != ((PinterestJsonArray) (obj)).a.get(i).getAsInt()) goto _L4; else goto _L3
_L3:
        i = 1;
_L17:
        if (a(pinterestjsonobject.c("min_version"), android.os.ect.c) > k)
        {
            j = 1;
        } else
        {
            j = 0;
        }
          goto _L5
_L14:
        try
        {
            ProdAutoUpdateClient.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PinterestJsonObject pinterestjsonobject)
        {
            return;
        }
_L15:
        if (GoogleServiceDialog.isPlayServicesAvailable() || !ProdAutoUpdateClient.a()) goto _L7; else goto _L6
_L6:
        if (!ProdAutoUpdateClient.b()) goto _L9; else goto _L8
_L8:
        obj = pinterestjsonobject.c("amazon_phone");
        if (obj == null) goto _L7; else goto _L10
_L10:
        i = a(((PinterestJsonObject) (obj)));
_L13:
        if (ProdAutoUpdateClient.a(i) - ProdAutoUpdateClient.a(k) >= 2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L2; else goto _L11
_L11:
        pinterestjsonobject = ProdAutoUpdateClient.d();
        obj = Calendar.getInstance();
        ((Calendar) (obj)).add(5, -7);
        if (((Calendar) (obj)).getTime().compareTo(pinterestjsonobject) > 0)
        {
            ProdAutoUpdateClient.c();
            ProdAutoUpdateClient.e();
            return;
        }
          goto _L2
_L9:
        obj = pinterestjsonobject.c("amazon");
        if (obj == null) goto _L7; else goto _L12
_L12:
        i = a(((PinterestJsonObject) (obj)));
          goto _L13
_L7:
        i = a(pinterestjsonobject);
          goto _L13
_L5:
        if (i == 0 && !j) goto _L15; else goto _L14
_L2:
        return;
_L4:
        i++;
          goto _L16
        i = 0;
          goto _L17
    }

    _cls9(ProdAutoUpdateClient prodautoupdateclient)
    {
        a = prodautoupdateclient;
        super();
    }
}
