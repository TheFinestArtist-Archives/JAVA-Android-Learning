// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, FrameWriter

class a extends NamedRunnable
{

    final a a;

    public final void a()
    {
        try
        {
            a.a.i.ackSettings();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient ( , String s, Object aobj[])
    {
        a = ;
        super(s, aobj);
    }
}
