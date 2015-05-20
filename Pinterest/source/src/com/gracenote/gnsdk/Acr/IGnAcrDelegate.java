// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Acr;

import com.gracenote.gnsdk.Metadata.GnResult;

// Referenced classes of package com.gracenote.gnsdk.Acr:
//            GnAcrStatus

public interface IGnAcrDelegate
{

    public abstract void acrResultReady(GnResult gnresult);

    public abstract void acrStatusReady(GnAcrStatus gnacrstatus);
}
