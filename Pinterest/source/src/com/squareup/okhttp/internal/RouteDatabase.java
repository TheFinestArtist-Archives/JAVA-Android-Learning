// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase
{

    private final Set a = new LinkedHashSet();

    public RouteDatabase()
    {
    }

    public final void a(Route route)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(route);
        this;
        JVM INSTR monitorexit ;
        return;
        route;
        throw route;
    }

    public final void b(Route route)
    {
        this;
        JVM INSTR monitorenter ;
        a.remove(route);
        this;
        JVM INSTR monitorexit ;
        return;
        route;
        throw route;
    }

    public final boolean c(Route route)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.contains(route);
        this;
        JVM INSTR monitorexit ;
        return flag;
        route;
        throw route;
    }
}
