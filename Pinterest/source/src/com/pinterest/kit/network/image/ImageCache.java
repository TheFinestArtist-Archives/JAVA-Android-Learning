// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.network.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.base.Application;
import com.pinterest.base.CrashReporting;
import com.pinterest.kit.application.Resources;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoUtil;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pinterest.kit.network.image:
//            CachableToolbarIcon, CachableImage

public class ImageCache
{

    public ImageCache()
    {
    }

    public static void clean(CachableImage cachableimage)
    {
        Picasso.a(Application.context()).a(cachableimage);
    }

    public static boolean contains(String s)
    {
        if (!isValidImageUrl(s))
        {
            return false;
        } else
        {
            return PicassoUtil.a(s);
        }
    }

    public static Bitmap getBitmapBlocking(String s)
    {
        return getBitmapBlocking(s, false, null);
    }

    public static Bitmap getBitmapBlocking(String s, boolean flag)
    {
        return getBitmapBlocking(s, flag, null);
    }

    public static Bitmap getBitmapBlocking(String s, boolean flag, Rect rect)
    {
        if (!isValidImageUrl(s))
        {
            return null;
        }
        try
        {
            s = Picasso.a(Application.context()).a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashReporting.logHandledException(s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashReporting.logHandledException(s);
            return null;
        }
        if (rect == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s.a(rect.width(), rect.height());
        s.b();
        s = s.c();
        return s;
    }

    private static File getExternalStorageFilePath(String s)
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), String.format("100PINT%s%s", new Object[] {
                File.separator, Resources.string(0x7f0e037f)
            }));
            file.mkdirs();
            return new File(file, s.substring(s.lastIndexOf("/") + 1));
        } else
        {
            return null;
        }
    }

    private static boolean isValidImageUrl(String s)
    {
        return s != null && s.length() > 0 && !"null".equals(s);
    }

    public static boolean loadImage(Toolbar toolbar, String s)
    {
        final WeakReference weakToolBar = new WeakReference(toolbar);
        CachableToolbarIcon cachabletoolbaricon = new CachableToolbarIcon();
        if (toolbar.getLogo() == null)
        {
            toolbar.setLogo(0x7f020195);
        }
        cachabletoolbaricon.setListener(new _cls1());
        return loadImage(((CachableImage) (cachabletoolbaricon)), s, true);
    }

    public static boolean loadImage(CachableImage cachableimage, String s)
    {
        return loadImage(cachableimage, s, true);
    }

    public static boolean loadImage(CachableImage cachableimage, String s, boolean flag)
    {
        if (cachableimage == null || !isValidImageUrl(s))
        {
            return false;
        }
        if (flag)
        {
            cachableimage.setBitmap(null, false);
        }
        Object obj1 = cachableimage.getTransformation();
        Object obj = Picasso.a(Application.context()).a(s);
        s = ((String) (obj));
        if (obj1 != null)
        {
            s = ((RequestCreator) (obj)).a(((com.squareup.picasso.Transformation) (obj1)));
        }
        obj1 = cachableimage.getImageTag();
        obj = s;
        if (obj1 != null)
        {
            obj = s.a(obj1);
        }
        ((RequestCreator) (obj)).a(cachableimage);
        return false;
    }

    public static void pauseTag(Object obj)
    {
        Picasso.a(Application.context()).a(obj);
    }

    public static void preloadImage(String s)
    {
        if (!isValidImageUrl(s))
        {
            return;
        } else
        {
            Picasso.a(Application.context()).a(s).d();
            return;
        }
    }

    public static void resumeTag(Object obj)
    {
        Picasso.a(Application.context()).b(obj);
    }

    public static boolean saveImageToGallery(String s)
    {
        final File fileDir = getExternalStorageFilePath(s);
        if (fileDir == null)
        {
            return false;
        } else
        {
            ApiHttpClient.getImageData(s, new _cls2(), false, null);
            return true;
        }
    }

    private class _cls1 extends CachableToolbarIcon.Listener
    {

        final WeakReference val$weakToolBar;

        public final void onBitmapLoaded(final Bitmap bitmap)
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$0;
                final Bitmap val$bitmap;

                public void run()
                {
                    Toolbar toolbar = (Toolbar)weakToolBar.get();
                    if (toolbar != null)
                    {
                        RoundedDrawable roundeddrawable = new RoundedDrawable(bitmap, 0.0F);
                        roundeddrawable.a(true);
                        toolbar.setLogo(roundeddrawable);
                    }
                }

                _cls1()
                {
                    this$0 = _cls1.this;
                    bitmap = bitmap1;
                    super();
                }
            }

            if (bitmap != null)
            {
                (new Handler(Looper.getMainLooper())).post(new _cls1());
            }
        }

        _cls1()
        {
            weakToolBar = weakreference;
            super();
        }
    }


    private class _cls2 extends ImageApiResponseHandler
    {

        final File val$fileDir;

        public final void onErrorResponse(VolleyError volleyerror)
        {
            super.onErrorResponse(volleyerror);
            CrashReporting.logHandledException(volleyerror.getCause());
        }

        public final void onResponse(Bitmap bitmap)
        {
            try
            {
                FileOutputStream fileoutputstream = new FileOutputStream(fileDir);
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, fileoutputstream);
                MediaScannerConnection.scanFile(Application.context(), new String[] {
                    fileDir.getAbsolutePath()
                }, null, null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                CrashReporting.logHandledException(bitmap);
            }
        }

        public final volatile void onResponse(Object obj)
        {
            onResponse((Bitmap)obj);
        }

        _cls2()
        {
            fileDir = file;
            super();
        }
    }

}
