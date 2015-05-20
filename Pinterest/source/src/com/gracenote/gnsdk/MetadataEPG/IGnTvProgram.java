// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataEPG;

import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoSeries;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoTitle;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoWork;

public interface IGnTvProgram
{

    public abstract IGnVideoWork getAvWork();

    public abstract GnIterator getCredits();

    public abstract GnIterator getExternalIDs();

    public abstract String getSeasonCount();

    public abstract String getSeasonEpisode();

    public abstract String getSeasonEpisodeCount();

    public abstract String getSeasonNumber();

    public abstract IGnVideoSeries getSeries();

    public abstract String getSeriesEpisode();

    public abstract String getSeriesEpisodeCount();

    public abstract IGnVideoTitle getSubtitle();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract IGnVideoTitle getTitle();
}
