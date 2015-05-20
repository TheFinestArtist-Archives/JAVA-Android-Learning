// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.IInterface;

public interface n
    extends IInterface
{

    public abstract boolean a(n n1);

    public abstract void clearTileCache();

    public abstract boolean getFadeIn();

    public abstract String getId();

    public abstract float getZIndex();

    public abstract int hashCodeRemote();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setFadeIn(boolean flag);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);
}
