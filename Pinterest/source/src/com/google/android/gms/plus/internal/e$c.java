// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.plus.internal:
//            e

final class anK extends com.google.android.gms.internal.
    implements com.google.android.gms.plus.nts.LoadMomentsResult
{

    private final Status Eb;
    private final String OB;
    final e anJ;
    private final String anK;
    private MomentBuffer anL;

    protected final void a(com.google.android.gms.common.api.Implementation.b b1, DataHolder dataholder)
    {
        if (dataholder != null)
        {
            dataholder = new MomentBuffer(dataholder);
        } else
        {
            dataholder = null;
        }
        anL = dataholder;
        b1.b(this);
    }

    protected final void b(Object obj, DataHolder dataholder)
    {
        a((com.google.android.gms.common.api.Implementation.b)obj, dataholder);
    }

    public final MomentBuffer getMomentBuffer()
    {
        return anL;
    }

    public final String getNextPageToken()
    {
        return OB;
    }

    public final Status getStatus()
    {
        return Eb;
    }

    public final String getUpdated()
    {
        return anK;
    }

    public final void release()
    {
        if (anL != null)
        {
            anL.close();
        }
    }

    public lder(e e, com.google.android.gms.common.api.Implementation.b b1, Status status, DataHolder dataholder, String s, String s1)
    {
        anJ = e;
        super(e, b1, dataholder);
        Eb = status;
        OB = s;
        anK = s1;
    }
}
