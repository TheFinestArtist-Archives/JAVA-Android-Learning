// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal.log;


public interface Logger
{

    public abstract void d(String s);

    public abstract void d(String s, Throwable throwable);

    public abstract void e(String s);

    public abstract void e(String s, Throwable throwable);

    public abstract void i(String s);

    public abstract void i(String s, Throwable throwable);

    public abstract void v(String s);

    public abstract void v(String s, Throwable throwable);

    public abstract void w(String s);

    public abstract void w(String s, Throwable throwable);
}
