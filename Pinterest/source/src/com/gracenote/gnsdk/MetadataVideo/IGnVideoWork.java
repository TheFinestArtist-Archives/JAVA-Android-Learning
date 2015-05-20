// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.Metadata.GnValueIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoFranchise, IGnVideoTitle, IGnVideoSeries

public interface IGnVideoWork
{

    public abstract GnIterator GetCreditsByRole(com.gracenote.gnsdk.Video.GnVideoTypes.GnVideoRoleType gnvideoroletype);

    public abstract String getAudience();

    public abstract GnIterator getCredits();

    public abstract String getDateOriginalRelease();

    public abstract String getDuration();

    public abstract String getDurationUnit();

    public abstract GnIterator getExternalIDs();

    public abstract IGnVideoFranchise getFranchise();

    public abstract IGnVideoTitle getFranchiseTitle();

    public abstract String getGdoSerialized();

    public abstract GnValueIterator getGenres();

    public abstract String getGnId();

    public abstract String getGnUID();

    public abstract String getMatchedProductTUI();

    public abstract String getMood();

    public abstract String getOrigin1();

    public abstract String getOrigin2();

    public abstract String getOrigin3();

    public abstract String getOrigin4();

    public abstract GnValueIterator getPlots();

    public abstract String getProductID();

    public abstract String getProductionType();

    public abstract GnIterator getProducts();

    public abstract GnValueIterator getRatings();

    public abstract String getReputation();

    public abstract String getScenario();

    public abstract String getSeasonCount();

    public abstract String getSeasonEpisode();

    public abstract String getSeasonEpisodeCount();

    public abstract String getSeasonNumber();

    public abstract GnIterator getSeasons();

    public abstract String getSerialType();

    public abstract IGnVideoSeries getSeries();

    public abstract String getSeriesEpisode();

    public abstract String getSeriesEpisodeCount();

    public abstract IGnVideoTitle getSeriesTitle();

    public abstract String getSettingEnvironment();

    public abstract String getSettingTimePeriod();

    public abstract String getSource();

    public abstract String getStoryType();

    public abstract String getStyle();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract IGnVideoTitle getTitle();

    public abstract String getTopic();

    public abstract String getWorkType();

    public abstract Boolean isPartial();
}
