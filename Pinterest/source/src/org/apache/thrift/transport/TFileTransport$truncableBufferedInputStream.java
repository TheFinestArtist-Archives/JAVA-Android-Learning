// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class  extends BufferedInputStream
{

    public void trunc()
    {
        count = 0;
        pos = 0;
    }

    public (InputStream inputstream)
    {
        super(inputstream);
    }

    public (InputStream inputstream, int i)
    {
        super(inputstream, i);
    }
}
