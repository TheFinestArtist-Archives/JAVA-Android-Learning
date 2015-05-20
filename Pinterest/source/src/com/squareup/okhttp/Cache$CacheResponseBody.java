// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody

class apshot extends ResponseBody
{

    private final com.squareup.okhttp.internal.ose a;
    private final BufferedSource b;
    private final String c;
    private final String d;

    static com.squareup.okhttp.internal.ose a(apshot apshot)
    {
        return apshot.a;
    }

    public final BufferedSource a()
    {
        return b;
    }

    public apshot(com.squareup.okhttp.internal. , String s, String s1)
    {
        a = ;
        c = s;
        d = s1;
        class _cls1 extends ForwardingSource
        {

            final com.squareup.okhttp.internal.DiskLruCache.Snapshot a;
            final Cache.CacheResponseBody b;

            public void close()
            {
                a.close();
                super.close();
            }

            _cls1(Source source, com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot)
            {
                b = Cache.CacheResponseBody.this;
                a = snapshot;
                super(source);
            }
        }

        b = Okio.a(new _cls1(Okio.a(.ose(1)), ));
    }
}
