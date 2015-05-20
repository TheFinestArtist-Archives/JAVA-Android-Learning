// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.data;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.utils.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DiskCache
{

    public static final String COUNTRIES = "COUNTRIES";
    public static final String EXPLORE_TOPIC_DATA = "EXPLORE_TOPIC_DATA";
    public static final String MY_DIGEST_FEED = "MY_DIGEST_FEED";
    public static final String MY_EXPERIMENTS = "MY_EXPERIMENTS";
    public static final String MY_HOME_FEED = "MY_HOME_FEED";
    public static final String MY_PICKER_BOARDS = "MY_PICKER_BOARDS";
    public static final String MY_PINPICKS_FEED = "MY_PINPICKS_FEED";
    public static final String MY_USED_BOARDS = "MY_USED_BOARDS_v2";
    public static final String MY_USED_CATEGORIES = "MY_USED_CATEGORIES_v2";
    public static final String MY_USED_INTERESTS = "MY_USED_INTERESTS";
    public static final String RECENT_CONVERSATIONS = "RECENT_CONVERSATIONS";
    private static final String TAG = "DiskCache";

    public DiskCache()
    {
    }

    public static void clean()
    {
        delete("MY_EXPERIMENTS");
        delete("MY_HOME_FEED");
        delete("MY_PICKER_BOARDS");
        delete("MY_USED_BOARDS_v2");
        delete("MY_USED_CATEGORIES_v2");
        delete("MY_USED_INTERESTS");
        delete("COUNTRIES");
        delete("RECENT_CONVERSATIONS");
        delete("MY_DIGEST_FEED");
        delete("EXPLORE_TOPIC_DATA");
    }

    public static void delete(String s)
    {
        (new File(getCacheFilePath(s))).delete();
    }

    private static String getCacheFilePath(String s)
    {
        s = String.format("%s/%s", new Object[] {
            getCachePath(), s
        });
        File file = new File(s);
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException ioexception)
            {
                return s;
            }
        }
        return s;
    }

    private static String getCachePath()
    {
        File file = new File(PApplication.context().getCacheDir(), "json");
        if (!file.exists())
        {
            file.mkdir();
        }
        return file.getPath();
    }

    public static PinterestJsonArray getJsonArray(String s)
    {
        try
        {
            s = new PinterestJsonArray(IOUtils.loadTextFile(new File(getCacheFilePath(s))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static PinterestJsonObject getJsonObject(String s)
    {
        try
        {
            s = new PinterestJsonObject(IOUtils.loadTextFile(new File(getCacheFilePath(s))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Object getSerializable(String s)
    {
        s = new ObjectInputStream(new BufferedInputStream(new FileInputStream(getCacheFilePath(s))));
        Object obj = s;
        Object obj1 = s.readObject();
        org.apache.commons.io.IOUtils.closeQuietly(s);
        return obj1;
        obj;
        s = null;
_L4:
        org.apache.commons.io.IOUtils.closeQuietly(s);
        return null;
        s;
        obj = null;
_L2:
        org.apache.commons.io.IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void setJsonArray(String s, PinterestJsonArray pinterestjsonarray)
    {
        IOUtils.writeTextFile(getCacheFilePath(s), pinterestjsonarray.toString());
    }

    public static void setJsonObject(String s, PinterestJsonObject pinterestjsonobject)
    {
        IOUtils.writeTextFile(getCacheFilePath(s), pinterestjsonobject.toString());
    }

    public static void setSerializable(String s, Serializable serializable)
    {
        String s1 = null;
        s = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(getCacheFilePath(s))));
        s1 = s;
        s.writeObject(serializable);
        org.apache.commons.io.IOUtils.closeQuietly(s);
        return;
        serializable;
        s = null;
_L4:
        org.apache.commons.io.IOUtils.closeQuietly(s);
        return;
        s;
        serializable = s1;
_L2:
        org.apache.commons.io.IOUtils.closeQuietly(serializable);
        throw s;
        s;
        serializable = s1;
        if (true) goto _L2; else goto _L1
_L1:
        serializable;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
