// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            nk, nf

class gleApiClient extends gleApiClient
{

    final nf agH;
    final Location agI;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((nk));
    }

    protected void a(nk nk1)
    {
        nk1.b(agI);
        b(Status.Kw);
    }

    gleApiClient(nf nf, GoogleApiClient googleapiclient, Location location)
    {
        agH = nf;
        agI = location;
        super(googleapiclient);
    }
}
