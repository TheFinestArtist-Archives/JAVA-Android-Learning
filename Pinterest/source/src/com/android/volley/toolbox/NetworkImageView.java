// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.android.volley.toolbox:
//            ImageLoader

public class NetworkImageView extends ImageView
{

    private int mDefaultImageId;
    private int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    public NetworkImageView(Context context)
    {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void setDefaultImageOrNull()
    {
        if (mDefaultImageId != 0)
        {
            setImageResource(mDefaultImageId);
            return;
        } else
        {
            setImageBitmap(null);
            return;
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        invalidate();
    }

    void loadImageIfNecessary(final boolean isInLayoutPass)
    {
        boolean flag = true;
        boolean flag1 = false;
        int l = getWidth();
        int k = getHeight();
        int i;
        int j;
        if (getLayoutParams() != null)
        {
            if (getLayoutParams().width == -2)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (getLayoutParams().height == -2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 0;
            j = 0;
        }
        if (j == 0 || i == 0)
        {
            flag = false;
        }
        if (l != 0 || k != 0 || flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (TextUtils.isEmpty(mUrl))
        {
            if (mImageContainer != null)
            {
                mImageContainer.cancelRequest();
                mImageContainer = null;
            }
            setDefaultImageOrNull();
            return;
        }
        if (mImageContainer == null || mImageContainer.getRequestUrl() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mImageContainer.getRequestUrl().equals(mUrl))
        {
            continue; /* Loop/switch isn't completed */
        }
        mImageContainer.cancelRequest();
        setDefaultImageOrNull();
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        if (j != 0)
        {
            j = 0;
        } else
        {
            j = l;
        }
        if (i != 0)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = k;
        }
        mImageContainer = mImageLoader.get(mUrl, new _cls1(), j, i);
        return;
    }

    protected void onDetachedFromWindow()
    {
        if (mImageContainer != null)
        {
            mImageContainer.cancelRequest();
            setImageBitmap(null);
            mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        loadImageIfNecessary(true);
    }

    public void setDefaultImageResId(int i)
    {
        mDefaultImageId = i;
    }

    public void setErrorImageResId(int i)
    {
        mErrorImageId = i;
    }

    public void setImageUrl(String s, ImageLoader imageloader)
    {
        mUrl = s;
        mImageLoader = imageloader;
        loadImageIfNecessary(false);
    }



    private class _cls1
        implements ImageLoader.ImageListener
    {

        final NetworkImageView this$0;
        final boolean val$isInLayoutPass;

        public void onErrorResponse(VolleyError volleyerror)
        {
            if (mErrorImageId != 0)
            {
                setImageResource(mErrorImageId);
            }
        }

        public void onResponse(final ImageLoader.ImageContainer response, boolean flag)
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final ImageLoader.ImageContainer val$response;

                public void run()
                {
                    onResponse(response, false);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    response = imagecontainer;
                    super();
                }
            }

            if (flag && isInLayoutPass)
            {
                post(new _cls1());
            } else
            {
                if (response.getBitmap() != null)
                {
                    setImageBitmap(response.getBitmap());
                    return;
                }
                if (mDefaultImageId != 0)
                {
                    setImageResource(mDefaultImageId);
                    return;
                }
            }
        }

        _cls1()
        {
            this$0 = NetworkImageView.this;
            isInLayoutPass = flag;
            super();
        }
    }

}
