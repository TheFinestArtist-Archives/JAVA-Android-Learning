// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.network.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Transformation;

// Referenced classes of package com.pinterest.kit.network.image:
//            CachableImage

public class CachableToolbarIcon
    implements CachableImage
{

    private Object _imageTag;
    private boolean _isLarge;
    private Listener _listener;
    private Transformation _transformation;
    private String _url;

    public CachableToolbarIcon()
    {
    }

    public Object getImageTag()
    {
        return _imageTag;
    }

    public boolean getIsLarge()
    {
        return _isLarge;
    }

    public Transformation getTransformation()
    {
        return _transformation;
    }

    public String getUrl()
    {
        return _url;
    }

    public void onBitmapFailed(Drawable drawable)
    {
    }

    public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
    {
        if (_listener != null)
        {
            _listener.onBitmapLoaded(bitmap);
        }
    }

    public void onPrepareLoad(Drawable drawable)
    {
    }

    public void setBitmap(Bitmap bitmap, boolean flag)
    {
        if (_listener != null)
        {
            _listener.onBitmapLoaded(bitmap);
        }
    }

    public void setImageTag(Object obj)
    {
        _imageTag = obj;
    }

    public void setIsLarge(boolean flag)
    {
        _isLarge = flag;
    }

    public void setListener(Listener listener)
    {
        _listener = listener;
    }

    public void setTransformation(Transformation transformation)
    {
        _transformation = transformation;
    }

    public void setUrl(String s)
    {
        _url = s;
    }

    private class Listener
    {

        public abstract void onBitmapLoaded(Bitmap bitmap);

        public Listener()
        {
        }
    }

}
