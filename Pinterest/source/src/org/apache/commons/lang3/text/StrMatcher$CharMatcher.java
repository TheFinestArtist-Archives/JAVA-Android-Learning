// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text;


// Referenced classes of package org.apache.commons.lang3.text:
//            StrMatcher

final class ch extends StrMatcher
{

    private final char ch;

    public final int isMatch(char ac[], int i, int j, int k)
    {
        return ch != ac[i] ? 0 : 1;
    }

    (char c)
    {
        ch = c;
    }
}
