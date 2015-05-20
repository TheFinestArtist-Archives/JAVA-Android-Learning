// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.pinterest.api:
//            ApiHttpClient

final class er extends StringRequest
{

    final String a;

    public final Map getHeaders()
    {
        return ApiHttpClient.getRequestHeaders(a);
    }

    public final Map getParams()
    {
        return new HashMap();
    }

    istener(String s, com.android.volley.r r, com.android.volley.stener stener, String s1)
    {
        a = s1;
        super(3, s, r, stener);
    }
}
