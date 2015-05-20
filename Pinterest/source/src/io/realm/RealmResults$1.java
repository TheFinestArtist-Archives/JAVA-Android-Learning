// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.internal.ColumnType;

class or
{

    static final int $SwitchMap$io$realm$internal$ColumnType[];

    static 
    {
        $SwitchMap$io$realm$internal$ColumnType = new int[ColumnType.values().length];
        try
        {
            $SwitchMap$io$realm$internal$ColumnType[ColumnType.INTEGER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$io$realm$internal$ColumnType[ColumnType.FLOAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$io$realm$internal$ColumnType[ColumnType.DOUBLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
