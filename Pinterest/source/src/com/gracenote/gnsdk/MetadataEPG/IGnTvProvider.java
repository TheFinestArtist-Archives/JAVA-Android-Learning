// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataEPG;

import com.gracenote.gnsdk.MetadataVideo.IGnVideoName;

public interface IGnTvProvider
{

    public abstract IGnVideoName getName();

    public abstract String getPlace();

    public abstract String getTUI();

    public abstract String getTUITag();
}
