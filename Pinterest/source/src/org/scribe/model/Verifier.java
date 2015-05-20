// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import org.scribe.utils.Preconditions;

public class Verifier
{

    private final String value;

    public Verifier(String s)
    {
        Preconditions.checkNotNull(s, "Must provide a valid string as verifier");
        value = s;
    }

    public String getValue()
    {
        return value;
    }
}
