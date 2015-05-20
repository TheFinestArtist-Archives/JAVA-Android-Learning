// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.oauth;

import org.scribe.model.SignatureType;

class 
{

    static final int $SwitchMap$org$scribe$model$SignatureType[];

    static 
    {
        $SwitchMap$org$scribe$model$SignatureType = new int[SignatureType.values().length];
        try
        {
            $SwitchMap$org$scribe$model$SignatureType[SignatureType.Header.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$scribe$model$SignatureType[SignatureType.QueryString.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
