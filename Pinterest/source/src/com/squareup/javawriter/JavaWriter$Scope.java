// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.javawriter;


final class  extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/squareup/javawriter/JavaWriter$Scope, s);
    }

    public static [] values()
    {
        return ([])j.clone();
    }

    static 
    {
        a = new <init>("TYPE_DECLARATION", 0);
        b = new <init>("INTERFACE_DECLARATION", 1);
        c = new <init>("ABSTRACT_METHOD", 2);
        d = new <init>("NON_ABSTRACT_METHOD", 3);
        e = new <init>("CONSTRUCTOR", 4);
        f = new <init>("CONTROL_FLOW", 5);
        g = new <init>("ANNOTATION_ATTRIBUTE", 6);
        h = new <init>("ANNOTATION_ARRAY_VALUE", 7);
        i = new <init>("INITIALIZER", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
