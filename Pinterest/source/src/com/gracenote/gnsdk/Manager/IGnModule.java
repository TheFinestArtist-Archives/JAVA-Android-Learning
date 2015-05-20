// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager;


public interface IGnModule
{

    public abstract com.gracenote.gnsdk.Metadata.GnTypes.SDK getSDK();

    public abstract void initialize();

    public abstract void shutdown();
}
