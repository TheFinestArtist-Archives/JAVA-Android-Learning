// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import android.content.res.AssetManager;
import com.pinterest.base.Application;
import com.pinterest.base.CrashReporting;
import com.pinterest.kit.application.PApplication;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.pinterest.kit.utils:
//            AppUtils

public class FileUtils
{

    public FileUtils()
    {
    }

    public static String decryptFile(SecretKeySpec secretkeyspec, String s, String s1, File file)
    {
        File file1;
        File file2;
        FileOutputStream fileoutputstream;
        Object obj;
        String s2;
        obj = null;
        fileoutputstream = null;
        s2 = AppUtils.getApplicationMetadata(Application.context().getPackageName(), "AutoCompleteFileIv");
        file2 = fileoutputstream;
        file1 = obj;
        AssetManager assetmanager = Application.assets();
        file2 = fileoutputstream;
        file1 = obj;
        file = File.createTempFile("tmp", null, file);
        file2 = file;
        file1 = file;
        fileoutputstream = new FileOutputStream(file);
        file2 = file;
        file1 = file;
        s1 = assetmanager.open(s1);
        file2 = file;
        file1 = file;
        s = Cipher.getInstance(s);
        file2 = file;
        file1 = file;
        s.init(2, secretkeyspec, new IvParameterSpec(hexStringToByteArray(s2)));
        file2 = file;
        file1 = file;
        secretkeyspec = new CipherOutputStream(fileoutputstream, s);
_L2:
        file2 = file;
        file1 = file;
        int i = s1.read();
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        file2 = file;
        file1 = file;
        secretkeyspec.write(i);
        file2 = file;
        file1 = file;
        secretkeyspec.flush();
        if (true) goto _L2; else goto _L1
        secretkeyspec;
        file1 = file2;
        CrashReporting.logHandledException(secretkeyspec);
        if (file2 == null)
        {
            return "";
        } else
        {
            return file2.getName();
        }
_L1:
        file2 = file;
        file1 = file;
        secretkeyspec.close();
        if (file == null)
        {
            return "";
        } else
        {
            return file.getName();
        }
        secretkeyspec;
        if (file1 == null)
        {
            return "";
        } else
        {
            return file1.getName();
        }
    }

    public static void deleteFile(File file, String s)
    {
        file = new File(file, s);
        if (file.exists())
        {
            file.delete();
        }
    }

    public static byte[] hexStringToByteArray(String s)
    {
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return abyte0;
    }

    public static FileOutputStream openOutputStream(File file, boolean flag)
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException((new StringBuilder("File '")).append(file).append("' exists but is a directory").toString());
            }
            if (!file.canWrite())
            {
                throw new IOException((new StringBuilder("File '")).append(file).append("' cannot be written to").toString());
            }
        } else
        {
            File file1 = file.getParentFile();
            if (file1 != null && !file1.mkdirs() && !file1.isDirectory())
            {
                throw new IOException((new StringBuilder("Directory '")).append(file1).append("' could not be created").toString());
            }
        }
        return new FileOutputStream(file, flag);
    }

    public static String unzipFile(File file, File file1)
    {
        File file2;
        File file3;
        Object obj;
        Object obj1;
        byte abyte0[];
        obj1 = null;
        obj = null;
        abyte0 = new byte[1024];
        file3 = obj;
        file2 = obj1;
        GZIPInputStream gzipinputstream = new GZIPInputStream(new BufferedInputStream(new FileInputStream(file)));
        file3 = obj;
        file2 = obj1;
        file = File.createTempFile("tmp", null, file1);
        file3 = file;
        file2 = file;
        file1 = new FileOutputStream(file);
_L2:
        file3 = file;
        file2 = file;
        int i = gzipinputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        file3 = file;
        file2 = file;
        file1.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        file;
        file2 = file3;
        CrashReporting.logHandledException(file);
        if (file3 == null)
        {
            return "";
        } else
        {
            return file3.getName();
        }
_L1:
        file3 = file;
        file2 = file;
        gzipinputstream.close();
        file3 = file;
        file2 = file;
        file1.close();
        if (file == null)
        {
            return "";
        } else
        {
            return file.getName();
        }
        file;
        if (file2 == null)
        {
            return "";
        } else
        {
            return file2.getName();
        }
    }

    public static void writeByteArrayToFile(File file, byte abyte0[])
    {
        File file1 = null;
        file = openOutputStream(file, false);
        file1 = file;
        file.write(abyte0);
        file1 = file;
        file.close();
        IOUtils.closeQuietly(file);
        return;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }
}
