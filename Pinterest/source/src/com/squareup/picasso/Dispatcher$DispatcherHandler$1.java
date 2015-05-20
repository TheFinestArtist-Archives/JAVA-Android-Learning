// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.os.Message;

class a
    implements Runnable
{

    final Message a;
    final a b;

    public void run()
    {
        throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(a.what).toString());
    }

    _cls9(_cls9 _pcls9, Message message)
    {
        b = _pcls9;
        a = message;
        super();
    }
}
