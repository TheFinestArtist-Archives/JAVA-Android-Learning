// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.e;

// Referenced classes of package com.google.android.gms.internal:
//            pc

class gleApiClient extends gleApiClient
{

    final pc aoi;
    final String aok[];

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((e));
    }

    protected void a(e e1)
    {
        e1.d(this, aok);
    }

    gleApiClient(pc pc, GoogleApiClient googleapiclient, String as[])
    {
        aoi = pc;
        aok = as;
        super(googleapiclient, null);
    }
}
