// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import java.security.InvalidParameterException;

public final class byteCount
{

    private int byteCount;
    private int fileCount;

    final int getByteCount()
    {
        return byteCount;
    }

    final int getFileCount()
    {
        return fileCount;
    }

    final void setByteCount(int i)
    {
        if (i < 0)
        {
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        } else
        {
            byteCount = i;
            return;
        }
    }

    final void setFileCount(int i)
    {
        if (i < 0)
        {
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        } else
        {
            fileCount = i;
            return;
        }
    }

    public ()
    {
        fileCount = 1024;
        byteCount = 0x100000;
    }
}
