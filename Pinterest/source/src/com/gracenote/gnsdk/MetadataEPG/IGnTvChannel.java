// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataEPG;

import com.gracenote.gnsdk.Metadata.GnIterator;

public interface IGnTvChannel
{

    public abstract String getCallsign();

    public abstract GnIterator getExternalIDs();

    public abstract Integer getIdent();

    public abstract String getName();

    public abstract String getNumber();

    public abstract String getONID();

    public abstract String getSID();

    public abstract String getTSID();

    public abstract String getTUI();

    public abstract String getTUITag();
}
