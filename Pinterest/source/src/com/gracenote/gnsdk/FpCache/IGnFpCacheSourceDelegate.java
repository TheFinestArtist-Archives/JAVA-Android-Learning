// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.FpCache;

import java.io.InputStream;

public interface IGnFpCacheSourceDelegate
{

    public abstract void readBundleData(InputStream inputstream, byte abyte0[], int i, int ai[], Boolean aboolean[]);
}
