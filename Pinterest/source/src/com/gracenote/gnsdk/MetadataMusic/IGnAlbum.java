// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataMusic;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataMusic:
//            IGnArtist, IGnGenre, IGnLanguage, IGnTitle

public interface IGnAlbum
{

    public abstract IGnArtist getArtist();

    public abstract GnIterator getAudioWorks();

    public abstract int getDiscNumber();

    public abstract String getDiscoverSeed();

    public abstract GnIterator getExternalIDs();

    public abstract String getGNID();

    public abstract String getGNUID();

    public abstract IGnGenre getGenre();

    public abstract String getGlobalID();

    public abstract String getLabel();

    public abstract int getMatchScore();

    public abstract GnIterator getMatchedTracks();

    public abstract int getNumberOfDiscs();

    public abstract IGnLanguage getPackageLanguage();

    public abstract String getPackageLanguageDisplay();

    public abstract String getProductID();

    public abstract String getSerializedString();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract IGnTitle getTitleAlternate();

    public abstract IGnTitle getTitleOfficial();

    public abstract IGnTitle getTitleRegional();

    public abstract IGnTitle getTitleRegionalLocale();

    public abstract IGnTitle getTitleTLS();

    public abstract int getTrackCount();

    public abstract int getTrackMatchNumber();

    public abstract int getTrackMatchPosition();

    public abstract GnIterator getTracks();

    public abstract String getYear();

    public abstract Boolean isClassicalDataAvailable();

    public abstract Boolean isCompilation();

    public abstract Boolean isPartial();
}
