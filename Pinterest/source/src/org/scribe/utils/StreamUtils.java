// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

// Referenced classes of package org.scribe.utils:
//            Preconditions

public class StreamUtils
{

    private StreamUtils()
    {
    }

    public static String getStreamContents(InputStream inputstream)
    {
        Preconditions.checkNotNull(inputstream, "Cannot get String from a null object");
        char ac[];
        StringBuilder stringbuilder;
        ac = new char[0x10000];
        stringbuilder = new StringBuilder();
        inputstream = new InputStreamReader(inputstream, "UTF-8");
_L2:
        int i = inputstream.read(ac, 0, 0x10000);
        if (i > 0)
        {
            try
            {
                stringbuilder.append(ac, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new IllegalStateException("Error while reading response body", inputstream);
            }
        }
        if (i >= 0) goto _L2; else goto _L1
_L1:
        inputstream.close();
        inputstream = stringbuilder.toString();
        return inputstream;
    }
}
