// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;


public interface BitArray
{

    public abstract void clear();

    public abstract boolean get(int i);

    public abstract void set(int i);

    public abstract void shiftLeft(int i);

    public abstract void toggle(int i);
}
