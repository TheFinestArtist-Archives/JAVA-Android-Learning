// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.lang.annotation.Annotation;

public interface DefineTable
    extends Annotation
{

    public abstract String query();

    public abstract String row();

    public abstract String table();

    public abstract String view();
}
