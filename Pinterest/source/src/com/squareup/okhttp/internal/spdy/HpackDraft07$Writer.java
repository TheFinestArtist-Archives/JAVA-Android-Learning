// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.ByteString;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, HpackDraft07

final class a
{

    private final Buffer a;

    private void a(int i, int j)
    {
        if (i < j)
        {
            a.a(i | 0);
            return;
        }
        a.a(j | 0);
        for (i -= j; i >= 128; i >>>= 7)
        {
            a.a(i & 0x7f | 0x80);
        }

        a.a(i);
    }

    private void a(ByteString bytestring)
    {
        a(bytestring.e(), 127);
        a.a(bytestring);
    }

    final void a(List list)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            ByteString bytestring = ((Header)list.get(i)).h.d();
            Integer integer = (Integer)HpackDraft07.b().get(bytestring);
            if (integer != null)
            {
                a(integer.intValue() + 1, 15);
                a(((Header)list.get(i)).i);
            } else
            {
                a.a(0);
                a(bytestring);
                a(((Header)list.get(i)).i);
            }
            i++;
        }
    }

    (Buffer buffer)
    {
        a = buffer;
    }
}
