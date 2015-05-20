// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;

import java.util.Random;

class 
{

    private final Random rand = new Random();

    Long getMilis()
    {
        return Long.valueOf(System.currentTimeMillis());
    }

    Integer getRandomInteger()
    {
        return Integer.valueOf(rand.nextInt());
    }

    ()
    {
    }
}
