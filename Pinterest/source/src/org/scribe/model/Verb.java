// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;


public final class Verb extends Enum
{

    private static final Verb $VALUES[];
    public static final Verb DELETE;
    public static final Verb GET;
    public static final Verb HEAD;
    public static final Verb OPTIONS;
    public static final Verb POST;
    public static final Verb PUT;
    public static final Verb TRACE;

    private Verb(String s, int i)
    {
        super(s, i);
    }

    public static Verb valueOf(String s)
    {
        return (Verb)Enum.valueOf(org/scribe/model/Verb, s);
    }

    public static Verb[] values()
    {
        return (Verb[])$VALUES.clone();
    }

    static 
    {
        GET = new Verb("GET", 0);
        POST = new Verb("POST", 1);
        PUT = new Verb("PUT", 2);
        DELETE = new Verb("DELETE", 3);
        HEAD = new Verb("HEAD", 4);
        OPTIONS = new Verb("OPTIONS", 5);
        TRACE = new Verb("TRACE", 6);
        $VALUES = (new Verb[] {
            GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE
        });
    }
}
