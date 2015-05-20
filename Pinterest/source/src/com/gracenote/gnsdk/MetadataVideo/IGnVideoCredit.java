// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoContributor

public interface IGnVideoCredit
{

    public abstract String getCharacterName();

    public abstract IGnVideoContributor getContributor();

    public abstract String getRank();

    public abstract String getRole();

    public abstract String getRoleBilling();

    public abstract String getRoleCategory();

    public abstract GnIterator getSeasons();

    public abstract GnIterator getSeries();

    public abstract GnIterator getWorks();
}
