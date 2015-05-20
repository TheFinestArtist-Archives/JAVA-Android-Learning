// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataMusic;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataMusic:
//            IGnTitle

public interface IGnAudioWork
{

    public abstract String getCompositionForm();

    public abstract GnIterator getCredits();

    public abstract String getDiscoverSeed();

    public abstract String getGNID();

    public abstract String getGNUID();

    public abstract String getProductID();

    public abstract String getSerializedString();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract IGnTitle getTitleAlternate();

    public abstract IGnTitle getTitleOfficial();

    public abstract IGnTitle getTitleRegional();

    public abstract IGnTitle getTitleRegionalLocale();

    public abstract IGnTitle getTitleTLS();
}
