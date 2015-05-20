// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataEPG;


// Referenced classes of package com.gracenote.gnsdk.MetadataEPG:
//            IGnTvChannel, IGnTvProgram

public interface IGnTvAiring
{

    public abstract IGnTvChannel getChannel();

    public abstract String getDateEnd();

    public abstract String getDateStart();

    public abstract String getDuration();

    public abstract String getDurationUnit();

    public abstract IGnTvProgram getTvProgram();
}
