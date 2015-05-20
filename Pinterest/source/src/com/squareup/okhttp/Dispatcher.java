// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Dispatcher
{

    private int a;
    private int b;
    private final Deque c = new ArrayDeque();
    private final Deque d = new ArrayDeque();

    public Dispatcher()
    {
        a = 64;
        b = 5;
    }
}
