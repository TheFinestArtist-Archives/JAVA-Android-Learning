// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;


public final class minVersion extends Enum
    implements minVersion
{

    private static final VIDEO $VALUES[];
    public static final VIDEO MESSAGE_DIALOG;
    public static final VIDEO PHOTOS;
    public static final VIDEO VIDEO;
    private int minVersion;

    public static minVersion valueOf(String s)
    {
        return (minVersion)Enum.valueOf(com/facebook/widget/FacebookDialog$MessageDialogFeature, s);
    }

    public static minVersion[] values()
    {
        return (minVersion[])$VALUES.clone();
    }

    public final String getAction()
    {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }

    public final int getMinVersion()
    {
        return minVersion;
    }

    static 
    {
        MESSAGE_DIALOG = new <init>("MESSAGE_DIALOG", 0, 0x13350ac);
        PHOTOS = new <init>("PHOTOS", 1, 0x1335124);
        VIDEO = new <init>("VIDEO", 2, 0x13354a2);
        $VALUES = (new .VALUES[] {
            MESSAGE_DIALOG, PHOTOS, VIDEO
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        minVersion = j;
    }
}
