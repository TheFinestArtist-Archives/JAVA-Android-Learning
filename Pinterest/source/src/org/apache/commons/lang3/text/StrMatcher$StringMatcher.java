// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text;


// Referenced classes of package org.apache.commons.lang3.text:
//            StrMatcher

final class chars extends StrMatcher
{

    private final char chars[];

    public final int isMatch(char ac[], int i, int j, int k)
    {
        int l = chars.length;
        if (i + l <= k) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        j = 0;
label0:
        do
        {
label1:
            {
                if (j >= chars.length)
                {
                    break label1;
                }
                if (chars[j] != ac[i])
                {
                    break label0;
                }
                j++;
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return l;
    }

    (String s)
    {
        chars = s.toCharArray();
    }
}
