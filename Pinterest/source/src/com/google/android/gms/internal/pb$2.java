// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.e;

// Referenced classes of package com.google.android.gms.internal:
//            pb

class gleApiClient extends gleApiClient
{

    final int aaI;
    final pb anZ;
    final String aoa;
    final Uri aob;
    final String aoc;
    final String aod;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((e));
    }

    protected void a(e e1)
    {
        e1.a(this, aaI, aoa, aob, aoc, aod);
    }

    gleApiClient(pb pb, GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        anZ = pb;
        aaI = i;
        aoa = s;
        aob = uri;
        aoc = s1;
        aod = s2;
        super(googleapiclient, null);
    }
}
