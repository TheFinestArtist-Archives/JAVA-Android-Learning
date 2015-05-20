// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import okio.ForwardingSource;
import okio.Source;

class a extends ForwardingSource
{

    final com.squareup.okhttp.internal.e a;
    final shot b;

    public void close()
    {
        a.e();
        super.close();
    }

    shot(shot shot, Source source, com.squareup.okhttp.internal. )
    {
        b = shot;
        a = ;
        super(source);
    }
}
