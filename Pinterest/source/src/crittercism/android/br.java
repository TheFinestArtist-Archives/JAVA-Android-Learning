// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package crittercism.android:
//            bh

public final class br extends bh
{

    private File a;

    private br(File file)
    {
        a = file;
    }

    br(File file, byte byte0)
    {
        this(file);
    }

    public final Object a()
    {
        Object obj = new StringBuilder();
        Object obj1;
        InputStreamReader inputstreamreader;
        obj1 = new FileInputStream(a);
        inputstreamreader = new InputStreamReader(((InputStream) (obj1)));
_L3:
        int i = inputstreamreader.read();
        if (i == -1) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append((char)i);
          goto _L3
_L5:
        IOException ioexception;
        try
        {
            obj = new JSONArray(((StringBuilder) (obj)).toString());
        }
        catch (JSONException jsonexception)
        {
            (new StringBuilder("JSONException in getData(): ")).append(jsonexception.getMessage());
            return null;
        }
        return obj;
_L2:
        try
        {
            ((InputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            (new StringBuilder("FileNotFoundException in getData(): ")).append(((FileNotFoundException) (obj1)).getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            (new StringBuilder("IOException in getData(): ")).append(ioexception.getMessage());
        }
        if (true) goto _L5; else goto _L4
_L4:
    }
}
