// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;


public final class  extends Enum
{

    private static final DATE_SECTION $VALUES[];
    public static final DATE_SECTION DATE_SECTION;
    public static final DATE_SECTION MODEL_SECTION;
    public static final DATE_SECTION TEMPLATE_SECTION;

    public static  parse(String s)
    {
        try
        {
            s = valueOf(s.toUpperCase());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static valueOf valueOf(String s)
    {
        return (valueOf)Enum.valueOf(com/pinterest/api/model/Notification$SectionType, s);
    }

    public static valueOf[] values()
    {
        return (valueOf[])$VALUES.clone();
    }

    static 
    {
        TEMPLATE_SECTION = new <init>("TEMPLATE_SECTION", 0);
        MODEL_SECTION = new <init>("MODEL_SECTION", 1);
        DATE_SECTION = new <init>("DATE_SECTION", 2);
        $VALUES = (new .VALUES[] {
            TEMPLATE_SECTION, MODEL_SECTION, DATE_SECTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
