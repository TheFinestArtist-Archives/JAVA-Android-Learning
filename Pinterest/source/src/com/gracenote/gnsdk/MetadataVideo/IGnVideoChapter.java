// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnIterator;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoTitle

public interface IGnVideoChapter
{

    public abstract GnIterator getCredits();

    public abstract GnIterator getCreditsByRole(com.gracenote.gnsdk.Video.GnVideoTypes.GnVideoRoleType gnvideoroletype);

    public abstract String getDuration();

    public abstract String getDurationUnits();

    public abstract String getNotes();

    public abstract String getOrdinal();

    public abstract IGnVideoTitle getTitle();
}
