// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.io.Closeable;
import okio.BufferedSource;

public abstract class ResponseBody
    implements Closeable
{

    public ResponseBody()
    {
    }

    public abstract BufferedSource a();

    public void close()
    {
        a().close();
    }
}
