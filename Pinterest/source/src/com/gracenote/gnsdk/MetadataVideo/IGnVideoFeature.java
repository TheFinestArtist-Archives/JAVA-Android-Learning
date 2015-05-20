// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.Metadata.GnValueIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoTitle

public interface IGnVideoFeature
{

    public abstract String getAspectRatio();

    public abstract String getAspectRatioType();

    public abstract GnIterator getChapters();

    public abstract GnIterator getCredits();

    public abstract String getDateOriginalRelease();

    public abstract String getDateRelease();

    public abstract String getDuration();

    public abstract String getDurationUnits();

    public abstract String getFeatureType();

    public abstract GnValueIterator getGenres();

    public abstract String getMatched();

    public abstract String getNotes();

    public abstract String getOrdinal();

    public abstract GnIterator getPlots();

    public abstract String getProductionType();

    public abstract GnIterator getRatings();

    public abstract IGnVideoTitle getTitle();

    public abstract GnIterator getWorks();
}
