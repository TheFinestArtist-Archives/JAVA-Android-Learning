// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataMusic;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataMusic:
//            IGnArtist, IGnGenre, IGnMood, IGnTempo, 
//            IGnTitle

public interface IGnTrack
{

    public abstract GnIterator getAlbums();

    public abstract IGnArtist getArtist();

    public abstract GnIterator getAudioWorks();

    public abstract String getDiscoverSeed();

    public abstract GnIterator getExternalIDs();

    public abstract String getGNUID();

    public abstract String getGdoSerialised();

    public abstract IGnGenre getGenre();

    public abstract String getGnId();

    public abstract Integer getMatchScore();

    public abstract IGnMood getMood();

    public abstract String getMoodLevel_1();

    public abstract String getMoodLevel_2();

    public abstract String getProductID();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract String getTempLevel_1();

    public abstract String getTempLevel_2();

    public abstract String getTempLevel_3();

    public abstract IGnTempo getTempo();

    public abstract IGnTitle getTitleAlternate();

    public abstract IGnTitle getTitleOfficial();

    public abstract IGnTitle getTitleReginal();

    public abstract IGnTitle getTitleRegional();

    public abstract IGnTitle getTitleRegionalLocale();

    public abstract IGnTitle getTitleTLS();

    public abstract int getTrackNumber();

    public abstract String getYear();

    public abstract Boolean isPartial();
}
