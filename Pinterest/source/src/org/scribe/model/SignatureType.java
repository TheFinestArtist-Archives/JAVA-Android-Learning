// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;


public final class SignatureType extends Enum
{

    private static final SignatureType $VALUES[];
    public static final SignatureType Header;
    public static final SignatureType QueryString;

    private SignatureType(String s, int i)
    {
        super(s, i);
    }

    public static SignatureType valueOf(String s)
    {
        return (SignatureType)Enum.valueOf(org/scribe/model/SignatureType, s);
    }

    public static SignatureType[] values()
    {
        return (SignatureType[])$VALUES.clone();
    }

    static 
    {
        Header = new SignatureType("Header", 0);
        QueryString = new SignatureType("QueryString", 1);
        $VALUES = (new SignatureType[] {
            Header, QueryString
        });
    }
}
