// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataACR;

import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.MetadataVideo.GnVideoName;
import com.gracenote.gnsdk.MetadataVideo.GnVideoTitle;

public interface IGnVideoAdvert
{

    public abstract GnVideoName getBrand();

    public abstract GnIterator getExternalIDs();

    public abstract String getGNUID();

    public abstract GnVideoTitle getTitle();

    public abstract String getTui();

    public abstract String getTuiTag();

    public abstract boolean isPartial();
}
