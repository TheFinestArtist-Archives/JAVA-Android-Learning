// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;

public interface 
{

    public abstract Context getActionBarThemedContext();

    public abstract Drawable getThemeUpIndicator();

    public abstract void setActionBarDescription(int i);

    public abstract void setActionBarUpIndicator(Drawable drawable, int i);
}
