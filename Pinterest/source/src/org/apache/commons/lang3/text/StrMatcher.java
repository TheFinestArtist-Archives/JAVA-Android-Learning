// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;

public abstract class StrMatcher
{

    private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('"');
    private static final StrMatcher NONE_MATCHER = new NoMatcher();
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();

    protected StrMatcher()
    {
    }

    public static StrMatcher charMatcher(char c)
    {
        return new CharMatcher(c);
    }

    public static StrMatcher charSetMatcher(String s)
    {
        if (s == null || s.length() == 0)
        {
            return NONE_MATCHER;
        }
        if (s.length() == 1)
        {
            return new CharMatcher(s.charAt(0));
        } else
        {
            return new CharSetMatcher(s.toCharArray());
        }
    }

    public static transient StrMatcher charSetMatcher(char ac[])
    {
        if (ac == null || ac.length == 0)
        {
            return NONE_MATCHER;
        }
        if (ac.length == 1)
        {
            return new CharMatcher(ac[0]);
        } else
        {
            return new CharSetMatcher(ac);
        }
    }

    public static StrMatcher commaMatcher()
    {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher()
    {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher()
    {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher()
    {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher()
    {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher()
    {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher()
    {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String s)
    {
        if (StringUtils.isEmpty(s))
        {
            return NONE_MATCHER;
        } else
        {
            return new StringMatcher(s);
        }
    }

    public static StrMatcher tabMatcher()
    {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher()
    {
        return TRIM_MATCHER;
    }

    public int isMatch(char ac[], int i)
    {
        return isMatch(ac, i, 0, ac.length);
    }

    public abstract int isMatch(char ac[], int i, int j, int k);


    private class CharMatcher extends StrMatcher
    {

        private final char ch;

        public final int isMatch(char ac[], int i, int j, int k)
        {
            return ch != ac[i] ? 0 : 1;
        }

        CharMatcher(char c)
        {
            ch = c;
        }
    }


    private class CharSetMatcher extends StrMatcher
    {

        private final char chars[];

        public final int isMatch(char ac[], int i, int j, int k)
        {
            return Arrays.binarySearch(chars, ac[i]) < 0 ? 0 : 1;
        }

        CharSetMatcher(char ac[])
        {
            chars = (char[])ac.clone();
            Arrays.sort(chars);
        }
    }


    private class StringMatcher extends StrMatcher
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

        StringMatcher(String s)
        {
            chars = s.toCharArray();
        }
    }


    private class TrimMatcher extends StrMatcher
    {

        public final int isMatch(char ac[], int i, int j, int k)
        {
            return ac[i] > ' ' ? 0 : 1;
        }

        TrimMatcher()
        {
        }
    }


    private class NoMatcher extends StrMatcher
    {

        public final int isMatch(char ac[], int i, int j, int k)
        {
            return 0;
        }

        NoMatcher()
        {
        }
    }

}
