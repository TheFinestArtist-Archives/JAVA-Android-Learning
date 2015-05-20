// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataACR;

import com.gracenote.gnsdk.MetadataEPG.IGnTvAiring;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoTitle;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoWork;

// Referenced classes of package com.gracenote.gnsdk.MetadataACR:
//            IGnVideoAdvert, IGnCustomData

public interface IGnAcrMatch
{

    public abstract String getActualPosition();

    public abstract String getAdjustedPosition();

    public abstract IGnVideoAdvert getAvAdvert();

    public abstract IGnVideoWork getAvWork();

    public abstract IGnCustomData getCustomData();

    public abstract String getFingerprintCreationDate();

    public abstract IGnVideoTitle getSubTitle();

    public abstract IGnVideoTitle getTitle();

    public abstract IGnTvAiring getTvAiring();
}
