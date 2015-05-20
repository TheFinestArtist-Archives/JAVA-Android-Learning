// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.Metadata.GnValueIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoLanguage, IGnVideoDisc, IGnVideoLayer, IGnVideoSide, 
//            IGnVideoRegion, IGnVideoTitle

public interface IGnVideoProduct
{

    public abstract String getAspectRatio();

    public abstract String getAspectRatioType();

    public abstract String getDateOriginalRelease();

    public abstract String getDateRelease();

    public abstract GnIterator getDiscs();

    public abstract String getDuration();

    public abstract String getDurationUnits();

    public abstract GnIterator getExternalIDs();

    public abstract GnValueIterator getGenres();

    public abstract IGnVideoLanguage getLanguage();

    public abstract IGnVideoDisc getMatchedDisc();

    public abstract IGnVideoLayer getMatchedLayer();

    public abstract IGnVideoSide getMatchedSide();

    public abstract String getNotes();

    public abstract String getProductID();

    public abstract String getProductionType();

    public abstract GnValueIterator getRatings();

    public abstract IGnVideoRegion getRegion();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract IGnVideoTitle getTitle();

    public abstract Boolean isPartial();
}
