// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ph;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            Moment

public final class MomentBuffer extends DataBuffer
{

    public MomentBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    public final Moment get(int i)
    {
        return new ph(JG, i);
    }

    public final volatile Object get(int i)
    {
        return get(i);
    }
}
