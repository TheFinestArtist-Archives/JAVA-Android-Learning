// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


public final class nativeFeature extends Enum
{

    private static final Feature_Replication $VALUES[];
    public static final Feature_Replication Feature_Debug;
    public static final Feature_Replication Feature_Replication;
    private final int nativeFeature;

    public static nativeFeature valueOf(String s)
    {
        return (nativeFeature)Enum.valueOf(io/realm/internal/Version$Feature, s);
    }

    public static nativeFeature[] values()
    {
        return (nativeFeature[])$VALUES.clone();
    }

    static 
    {
        Feature_Debug = new <init>("Feature_Debug", 0, 0);
        Feature_Replication = new <init>("Feature_Replication", 1, 1);
        $VALUES = (new .VALUES[] {
            Feature_Debug, Feature_Replication
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        nativeFeature = j;
    }
}
