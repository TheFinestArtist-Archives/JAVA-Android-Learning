// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.extractors;

import org.scribe.model.Token;

public interface RequestTokenExtractor
{

    public abstract Token extract(String s);
}
