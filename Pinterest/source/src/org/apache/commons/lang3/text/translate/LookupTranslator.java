// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import java.util.HashMap;

// Referenced classes of package org.apache.commons.lang3.text.translate:
//            CharSequenceTranslator

public class LookupTranslator extends CharSequenceTranslator
{

    private final int longest;
    private final HashMap lookupMap = new HashMap();
    private final int shortest;

    public transient LookupTranslator(CharSequence acharsequence[][])
    {
        int j = 0x7fffffff;
        int i;
        if (acharsequence != null)
        {
            int j1 = acharsequence.length;
            int k = 0;
            i = 0;
            int l;
            for (j = 0x7fffffff; k < j1; j = l)
            {
                CharSequence acharsequence1[] = acharsequence[k];
                lookupMap.put(acharsequence1[0], acharsequence1[1]);
                int i1 = acharsequence1[0].length();
                l = j;
                if (i1 < j)
                {
                    l = i1;
                }
                if (i1 > i)
                {
                    i = i1;
                }
                k++;
            }

        } else
        {
            i = 0;
        }
        shortest = j;
        longest = i;
    }

    public int translate(CharSequence charsequence, int i, Writer writer)
    {
        int j = longest;
        if (longest + i > charsequence.length())
        {
            j = charsequence.length() - i;
        }
        for (; j >= shortest; j--)
        {
            CharSequence charsequence1 = charsequence.subSequence(i, i + j);
            charsequence1 = (CharSequence)lookupMap.get(charsequence1);
            if (charsequence1 != null)
            {
                writer.write(charsequence1.toString());
                return j;
            }
        }

        return 0;
    }
}
