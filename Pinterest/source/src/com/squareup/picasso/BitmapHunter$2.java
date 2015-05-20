// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;


// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Request

final class Result extends RequestHandler
{

    public final boolean a(Request request)
    {
        return true;
    }

    public final Result b(Request request)
    {
        throw new IllegalStateException((new StringBuilder("Unrecognized type of request: ")).append(request).toString());
    }

    Result()
    {
    }
}
