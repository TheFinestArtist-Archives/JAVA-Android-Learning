// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.pinterest.kit.application.PApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;

public class IOUtils
{

    public IOUtils()
    {
    }

    public static void copyFile(File file, String s)
    {
        try
        {
            file = new FileInputStream(file);
            s = new FileOutputStream(s);
            copyStream(file, s);
            file.close();
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    public static void copyStream(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
_L1:
        int i = inputstream.read(abyte0, 0, 1024);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        inputstream;
    }

    public static void destroyDirectByteBuffer(Buffer buffer)
    {
        if (!buffer.isDirect())
        {
            return;
        }
        try
        {
            Method method = buffer.getClass().getMethod("cleaner", new Class[0]);
            method.setAccessible(true);
            buffer = ((Buffer) (method.invoke(buffer, new Object[0])));
            method = buffer.getClass().getMethod("clean", new Class[0]);
            method.setAccessible(true);
            method.invoke(buffer, new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Buffer buffer)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Buffer buffer)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Buffer buffer)
        {
            return;
        }
    }

    public static Bitmap loadImage(String s)
    {
        Object obj;
        try
        {
            obj = new android.graphics.BitmapFactory.Options();
            obj.inScaled = false;
            obj.inDensity = 0;
            obj.inPurgeable = true;
            obj.inInputShareable = true;
            s = PApplication.context().getAssets().open(s);
            obj = BitmapFactory.decodeStream(s, null, ((android.graphics.BitmapFactory.Options) (obj)));
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return ((Bitmap) (obj));
    }

    public static String loadTextFile(File file)
    {
        try
        {
            file = new FileInputStream(file);
            byte abyte0[] = new byte[file.available()];
            file.read(abyte0);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bytearrayoutputstream.write(abyte0);
            bytearrayoutputstream.flush();
            bytearrayoutputstream.close();
            file.close();
            file = bytearrayoutputstream.toString();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
            return "";
        }
        return file;
    }

    public static String loadTextFile(String s)
    {
        try
        {
            s = PApplication.context().getResources().getAssets().open(s);
            byte abyte0[] = new byte[s.available()];
            s.read(abyte0);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bytearrayoutputstream.write(abyte0);
            bytearrayoutputstream.flush();
            bytearrayoutputstream.close();
            s.close();
            s = bytearrayoutputstream.toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }

    public static void writeTextFile(String s, String s1)
    {
        try
        {
            s = new FileOutputStream(s);
            s.write(s1.getBytes());
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }
}
