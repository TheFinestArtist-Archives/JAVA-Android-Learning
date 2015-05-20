// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;


public final class IdentityScopeType extends Enum
{

    private static final IdentityScopeType ENUM$VALUES[];
    public static final IdentityScopeType None;
    public static final IdentityScopeType Session;

    private IdentityScopeType(String s, int i)
    {
        super(s, i);
    }

    public static IdentityScopeType valueOf(String s)
    {
        return (IdentityScopeType)Enum.valueOf(de/greenrobot/dao/IdentityScopeType, s);
    }

    public static IdentityScopeType[] values()
    {
        IdentityScopeType aidentityscopetype[] = ENUM$VALUES;
        int i = aidentityscopetype.length;
        IdentityScopeType aidentityscopetype1[] = new IdentityScopeType[i];
        System.arraycopy(aidentityscopetype, 0, aidentityscopetype1, 0, i);
        return aidentityscopetype1;
    }

    static 
    {
        Session = new IdentityScopeType("Session", 0);
        None = new IdentityScopeType("None", 1);
        ENUM$VALUES = (new IdentityScopeType[] {
            Session, None
        });
    }
}
