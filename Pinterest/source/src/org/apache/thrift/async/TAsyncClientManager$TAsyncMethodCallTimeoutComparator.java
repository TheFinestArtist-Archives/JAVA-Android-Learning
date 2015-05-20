// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;

import java.util.Comparator;

// Referenced classes of package org.apache.thrift.async:
//            TAsyncMethodCall

class <init>
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((TAsyncMethodCall)obj, (TAsyncMethodCall)obj1);
    }

    public int compare(TAsyncMethodCall tasyncmethodcall, TAsyncMethodCall tasyncmethodcall1)
    {
        if (tasyncmethodcall.getTimeoutTimestamp() == tasyncmethodcall1.getTimeoutTimestamp())
        {
            return (int)(tasyncmethodcall.getSequenceId() - tasyncmethodcall1.getSequenceId());
        } else
        {
            return (int)(tasyncmethodcall.getTimeoutTimestamp() - tasyncmethodcall1.getTimeoutTimestamp());
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
