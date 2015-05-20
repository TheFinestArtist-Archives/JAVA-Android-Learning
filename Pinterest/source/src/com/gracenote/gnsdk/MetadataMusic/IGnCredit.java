// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataMusic;


// Referenced classes of package com.gracenote.gnsdk.MetadataMusic:
//            IGnContributor, IGnName

public interface IGnCredit
{

    public abstract String getArtistType1();

    public abstract String getArtistType2();

    public abstract IGnContributor getContributor();

    public abstract String getEra1();

    public abstract String getEra2();

    public abstract String getEra3();

    public abstract IGnName getName();

    public abstract String getOrigin1();

    public abstract String getOrigin2();

    public abstract String getOrigin3();

    public abstract String getOrigin4();

    public abstract int getRank();

    public abstract String getRole();

    public abstract String getRoleBilling();

    public abstract String getRoleCategory();

    public abstract String getRoleID();
}
