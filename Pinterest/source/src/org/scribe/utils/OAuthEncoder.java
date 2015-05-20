// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;

// Referenced classes of package org.scribe.utils:
//            Preconditions

public class OAuthEncoder
{

    private static String CHARSET = "UTF-8";
    private static final Map ENCODING_RULES;

    private OAuthEncoder()
    {
    }

    private static String applyRule(String s, String s1, String s2)
    {
        return s.replaceAll(Pattern.quote(s1), s2);
    }

    public static String decode(String s)
    {
        Preconditions.checkNotNull(s, "Cannot decode null object");
        try
        {
            s = URLDecoder.decode(s, CHARSET);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new OAuthException((new StringBuilder("Charset not found while decoding string: ")).append(CHARSET).toString(), s);
        }
        return s;
    }

    public static String encode(String s)
    {
        Preconditions.checkNotNull(s, "Cannot encode null object");
        Iterator iterator;
        try
        {
            s = URLEncoder.encode(s, CHARSET);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new OAuthException((new StringBuilder("Charset not found while encoding string: ")).append(CHARSET).toString(), s);
        }
        for (iterator = ENCODING_RULES.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s = applyRule(s, (String)entry.getKey(), (String)entry.getValue());
        }

        return s;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("*", "%2A");
        hashmap.put("+", "%20");
        hashmap.put("%7E", "~");
        ENCODING_RULES = Collections.unmodifiableMap(hashmap);
    }
}
