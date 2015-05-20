// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;


// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoLayer, IGnVideoTitle

public interface IGnVideoSide
{

    public abstract IGnVideoLayer getLayer();

    public abstract String getMatched();

    public abstract IGnVideoLayer getMatchedLayer();

    public abstract String getNotes();

    public abstract String getOrdinal();

    public abstract IGnVideoTitle getTitle();
}
