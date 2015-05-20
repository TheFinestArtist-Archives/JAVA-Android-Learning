// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.Metadata.GnValueIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoName

public interface IGnVideoContributor
{

    public abstract String getBiography();

    public abstract String getBiographyLanguage();

    public abstract String getBirthDate();

    public abstract String getBirthPlace();

    public abstract GnIterator getCredits();

    public abstract String getDeathDate();

    public abstract String getDeathPlace();

    public abstract GnIterator getExternalIDs();

    public abstract GnValueIterator getGenres();

    public abstract String getMediaSpace();

    public abstract IGnVideoName getNameOfficial();

    public abstract IGnVideoName getNameRegional();

    public abstract IGnVideoName getNameRegionalLocale();

    public abstract String getProductID();

    public abstract String getRole();

    public abstract String getRoleBilling();

    public abstract String getRoleCategory();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract Boolean isPartial();
}
