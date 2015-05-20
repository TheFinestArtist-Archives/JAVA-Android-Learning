// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataMusic;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataMusic:
//            IGnName

public interface IGnContributor
{

    public abstract IGnName getAlternate();

    public abstract String getArtistType1();

    public abstract String getArtistType2();

    public abstract String getBiography();

    public abstract String getBirthDate();

    public abstract String getBirthPlace();

    public abstract GnIterator getContributors();

    public abstract String getDeathDate();

    public abstract String getDeathPlace();

    public abstract String getEra1();

    public abstract String getEra2();

    public abstract String getEra3();

    public abstract GnIterator getExternalIDs();

    public abstract String getGDOSerialized();

    public abstract String getGNID();

    public abstract String getGNUID();

    public abstract int getMatchScore();

    public abstract String getMediaSpace();

    public abstract IGnName getName();

    public abstract String getOrigin1();

    public abstract String getOrigin2();

    public abstract String getOrigin3();

    public abstract String getOrigin4();

    public abstract String getProductID();

    public abstract IGnName getRegional();

    public abstract IGnName getRegionalLocale();

    public abstract String getRole();

    public abstract String getRoleCategory();

    public abstract String getTUI();

    public abstract boolean isCollaboratorResult();

    public abstract boolean isPartial();
}
