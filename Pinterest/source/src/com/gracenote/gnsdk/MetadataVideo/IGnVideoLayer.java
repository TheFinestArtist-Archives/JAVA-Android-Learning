// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoRegion

public interface IGnVideoLayer
{

    public abstract String getAspectRatio();

    public abstract String getAspectRatioType();

    public abstract GnIterator getFeatures();

    public abstract String getMatched();

    public abstract String getMediaType();

    public abstract String getOrdinal();

    public abstract IGnVideoRegion getRegion();

    public abstract String getRegionCode();

    public abstract String getTVSystem();
}
