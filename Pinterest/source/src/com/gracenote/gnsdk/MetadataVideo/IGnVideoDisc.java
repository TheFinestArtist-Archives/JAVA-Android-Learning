// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoLayer, IGnVideoSide, IGnVideoTitle

public interface IGnVideoDisc
{

    public abstract String getMatched();

    public abstract IGnVideoLayer getMatchedLayer();

    public abstract IGnVideoSide getMatchedSide();

    public abstract String getNotes();

    public abstract String getOrdinal();

    public abstract String getProductID();

    public abstract GnIterator getSides();

    public abstract String getTUI();

    public abstract String getTUITag();

    public abstract IGnVideoTitle getTitle();
}
