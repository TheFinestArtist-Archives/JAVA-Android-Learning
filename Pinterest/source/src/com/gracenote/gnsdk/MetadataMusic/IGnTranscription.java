// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataMusic;


public interface IGnTranscription
{

    public abstract String getAlphabet();

    public abstract String getSpokenLanguage();

    public abstract String getValue();

    public abstract String isMispronunciation();

    public abstract String isOriginalLanguage();
}
