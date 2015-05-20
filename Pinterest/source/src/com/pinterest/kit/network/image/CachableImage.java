// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.network.image;

import android.graphics.Bitmap;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

public interface CachableImage
    extends Target
{

    public abstract Object getImageTag();

    public abstract boolean getIsLarge();

    public abstract Transformation getTransformation();

    public abstract String getUrl();

    public abstract void setBitmap(Bitmap bitmap, boolean flag);

    public abstract void setImageTag(Object obj);

    public abstract void setIsLarge(boolean flag);

    public abstract void setTransformation(Transformation transformation);

    public abstract void setUrl(String s);
}
