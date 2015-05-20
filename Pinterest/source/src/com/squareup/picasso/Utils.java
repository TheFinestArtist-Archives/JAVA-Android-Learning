// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.StatFs;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.squareup.picasso:
//            Request, UrlConnectionDownloader, BitmapHunter, Action, 
//            Transformation, Downloader

final class Utils
{

    static final StringBuilder a = new StringBuilder();

    static int a(Resources resources, Request request)
    {
        if (request.e != 0 || request.d == null)
        {
            return request.e;
        }
        String s = request.d.getAuthority();
        if (s == null)
        {
            throw new FileNotFoundException((new StringBuilder("No package provided: ")).append(request.d).toString());
        }
        List list = request.d.getPathSegments();
        if (list == null || list.isEmpty())
        {
            throw new FileNotFoundException((new StringBuilder("No path segments: ")).append(request.d).toString());
        }
        if (list.size() == 1)
        {
            int i;
            try
            {
                i = Integer.parseInt((String)list.get(0));
            }
            // Misplaced declaration of an exception variable
            catch (Resources resources)
            {
                throw new FileNotFoundException((new StringBuilder("Last path segment is not a resource ID: ")).append(request.d).toString());
            }
            return i;
        }
        if (list.size() == 2)
        {
            request = (String)list.get(0);
            return resources.getIdentifier((String)list.get(1), request, s);
        } else
        {
            throw new FileNotFoundException((new StringBuilder("More than two path segments: ")).append(request.d).toString());
        }
    }

    static int a(Bitmap bitmap)
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            i = BitmapHoneycombMR1.a(bitmap);
        } else
        {
            i = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (i < 0)
        {
            throw new IllegalStateException((new StringBuilder("Negative size: ")).append(bitmap).toString());
        } else
        {
            return i;
        }
    }

    static long a(File file)
    {
        long l;
        try
        {
            file = new StatFs(file.getAbsolutePath());
            l = file.getBlockCount();
            l = ((long)file.getBlockSize() * l) / 50L;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            l = 0x500000L;
        }
        return Math.max(Math.min(l, 0x3200000L), 0x500000L);
    }

    static Resources a(Context context, Request request)
    {
        if (request.e != 0 || request.d == null)
        {
            return context.getResources();
        }
        String s = request.d.getAuthority();
        if (s == null)
        {
            throw new FileNotFoundException((new StringBuilder("No package provided: ")).append(request.d).toString());
        }
        try
        {
            context = context.getPackageManager().getResourcesForApplication(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new FileNotFoundException((new StringBuilder("Unable to obtain resources for package: ")).append(request.d).toString());
        }
        return context;
    }

    static Downloader a(Context context)
    {
        boolean flag1 = true;
        Class.forName("com.squareup.okhttp.OkUrlFactory");
        boolean flag = true;
_L1:
        ClassNotFoundException classnotfoundexception;
        try
        {
            Class.forName("com.squareup.okhttp.OkHttpClient");
        }
        catch (ClassNotFoundException classnotfoundexception1)
        {
            flag1 = false;
        }
        if (flag1 != flag)
        {
            throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
        }
        break MISSING_BLOCK_LABEL_43;
        classnotfoundexception;
        flag = false;
          goto _L1
        if (flag1)
        {
            return OkHttpLoaderCreator.a(context);
        } else
        {
            return new UrlConnectionDownloader(context);
        }
    }

    static Object a(Context context, String s)
    {
        return context.getSystemService(s);
    }

    static String a(BitmapHunter bitmaphunter)
    {
        return a(bitmaphunter, "");
    }

    static String a(BitmapHunter bitmaphunter, String s)
    {
        s = new StringBuilder(s);
        Action action = bitmaphunter.j;
        if (action != null)
        {
            s.append(action.b.a());
        }
        bitmaphunter = bitmaphunter.k;
        if (bitmaphunter != null)
        {
            int j = bitmaphunter.size();
            for (int i = 0; i < j; i++)
            {
                if (i > 0 || action != null)
                {
                    s.append(", ");
                }
                s.append(((Action)bitmaphunter.get(i)).b.a());
            }

        }
        return s.toString();
    }

    static String a(Request request)
    {
        request = a(request, a);
        a.setLength(0);
        return request;
    }

    static String a(Request request, StringBuilder stringbuilder)
    {
        int i;
        int j;
        if (request.f != null)
        {
            stringbuilder.ensureCapacity(request.f.length() + 50);
            stringbuilder.append(request.f);
        } else
        if (request.d != null)
        {
            String s = request.d.toString();
            stringbuilder.ensureCapacity(s.length() + 50);
            stringbuilder.append(s);
        } else
        {
            stringbuilder.ensureCapacity(50);
            stringbuilder.append(request.e);
        }
        stringbuilder.append('\n');
        if (request.l != 0.0F)
        {
            stringbuilder.append("rotation:").append(request.l);
            if (request.o)
            {
                stringbuilder.append('@').append(request.m).append('x').append(request.n);
            }
            stringbuilder.append('\n');
        }
        if (request.c())
        {
            stringbuilder.append("resize:").append(request.h).append('x').append(request.i);
            stringbuilder.append('\n');
        }
        if (!request.j) goto _L2; else goto _L1
_L1:
        stringbuilder.append("centerCrop\n");
_L4:
        if (request.g != null)
        {
            j = request.g.size();
            for (i = 0; i < j; i++)
            {
                stringbuilder.append(((Transformation)request.g.get(i)).key());
                stringbuilder.append('\n');
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (request.k)
        {
            stringbuilder.append("centerInside\n");
        }
        if (true) goto _L4; else goto _L3
_L3:
        return stringbuilder.toString();
    }

    static void a()
    {
        if (c())
        {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        } else
        {
            return;
        }
    }

    static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return;
        }
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
    }

    static void a(String s, String s1, String s2)
    {
        a(s, s1, s2, "");
    }

    static void a(String s, String s1, String s2, String s3)
    {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] {
            s, s1, s2, s3
        }));
    }

    static void a(Throwable throwable)
    {
        throw throwable;
    }

    static boolean a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = s.split(" ", 2);
        if ("CACHE".equals(s[0]))
        {
            return true;
        }
        if (s.length == 1) goto _L1; else goto _L3
_L3:
        if (!"CONDITIONAL_CACHE".equals(s[0])) goto _L1; else goto _L4
_L4:
        int i = Integer.parseInt(s[1]);
        if (i == 304)
        {
            return true;
        }
          goto _L1
        s;
        return false;
    }

    static File b(Context context)
    {
        context = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!context.exists())
        {
            context.mkdirs();
        }
        return context;
    }

    static void b()
    {
        if (!c())
        {
            throw new IllegalStateException("Method call should happen from the main thread.");
        } else
        {
            return;
        }
    }

    static boolean b(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    static byte[] b(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[4096];
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 != i)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    static int c(Context context)
    {
        ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
        int i;
        int j;
        if ((context.getApplicationInfo().flags & 0x100000) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = activitymanager.getMemoryClass();
        if (i != 0 && android.os.Build.VERSION.SDK_INT >= 11)
        {
            i = ActivityManagerHoneycomb.a(activitymanager);
        } else
        {
            i = j;
        }
        return (i * 0x100000) / 7;
    }

    static boolean c()
    {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean c(InputStream inputstream)
    {
        boolean flag1 = false;
        byte abyte0[] = new byte[12];
        boolean flag = flag1;
        if (inputstream.read(abyte0, 0, 12) == 12)
        {
            flag = flag1;
            if ("RIFF".equals(new String(abyte0, 0, 4, "US-ASCII")))
            {
                flag = flag1;
                if ("WEBP".equals(new String(abyte0, 8, 4, "US-ASCII")))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    static boolean d(Context context)
    {
        boolean flag = false;
        if (android.provider.Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0)
        {
            flag = true;
        }
        return flag;
    }


    private class BitmapHoneycombMR1
    {

        static int a(Bitmap bitmap)
        {
            return bitmap.getByteCount();
        }
    }


    private class OkHttpLoaderCreator
    {

        static Downloader a(Context context)
        {
            return new OkHttpDownloader(context);
        }
    }


    private class ActivityManagerHoneycomb
    {

        static int a(ActivityManager activitymanager)
        {
            return activitymanager.getLargeMemoryClass();
        }
    }

}
