// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class DurationFormatUtils
{

    static final Object H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
    static final Object M = "M";
    static final Object S = "S";
    static final Object d = "d";
    static final Object m = "m";
    static final Object s = "s";
    static final Object y = "y";

    public DurationFormatUtils()
    {
    }

    static String format(Token atoken[], int i, int j, int k, int l, int i1, int j1, int k1, 
            boolean flag)
    {
        StringBuffer stringbuffer;
        int l1;
        boolean flag2;
        int j2;
        stringbuffer = new StringBuffer();
        j2 = atoken.length;
        l1 = 0;
        flag2 = false;
_L2:
        Object obj;
        boolean flag1;
        int i2;
        int k2;
        if (l1 >= j2)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        Token token = atoken[l1];
        obj = token.getValue();
        k2 = token.getCount();
        if (!(obj instanceof StringBuffer))
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(obj.toString());
        i2 = k1;
        flag1 = flag2;
_L3:
        l1++;
        flag2 = flag1;
        k1 = i2;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj == y)
        {
            String s1;
            if (flag)
            {
                s1 = StringUtils.leftPad(Integer.toString(i), k2, '0');
            } else
            {
                s1 = Integer.toString(i);
            }
            stringbuffer.append(s1);
        } else
        if (obj == M)
        {
            String s2;
            if (flag)
            {
                s2 = StringUtils.leftPad(Integer.toString(j), k2, '0');
            } else
            {
                s2 = Integer.toString(j);
            }
            stringbuffer.append(s2);
        } else
        if (obj == d)
        {
            String s3;
            if (flag)
            {
                s3 = StringUtils.leftPad(Integer.toString(k), k2, '0');
            } else
            {
                s3 = Integer.toString(k);
            }
            stringbuffer.append(s3);
        } else
        if (obj == H)
        {
            String s4;
            if (flag)
            {
                s4 = StringUtils.leftPad(Integer.toString(l), k2, '0');
            } else
            {
                s4 = Integer.toString(l);
            }
            stringbuffer.append(s4);
        } else
        {
label0:
            {
                if (obj != m)
                {
                    break label0;
                }
                String s5;
                if (flag)
                {
                    s5 = StringUtils.leftPad(Integer.toString(i1), k2, '0');
                } else
                {
                    s5 = Integer.toString(i1);
                }
                stringbuffer.append(s5);
            }
        }
_L5:
        flag1 = false;
        i2 = k1;
          goto _L3
label1:
        {
            if (obj != s)
            {
                break label1;
            }
            String s6;
            if (flag)
            {
                s6 = StringUtils.leftPad(Integer.toString(j1), k2, '0');
            } else
            {
                s6 = Integer.toString(j1);
            }
            stringbuffer.append(s6);
            flag1 = true;
            i2 = k1;
        }
          goto _L3
        flag1 = flag2;
        i2 = k1;
        if (obj != S) goto _L3; else goto _L4
_L4:
        if (flag2)
        {
            k1 += 1000;
            String s7;
            if (flag)
            {
                s7 = StringUtils.leftPad(Integer.toString(k1), k2, '0');
            } else
            {
                s7 = Integer.toString(k1);
            }
            stringbuffer.append(s7.substring(1));
        } else
        {
            String s8;
            if (flag)
            {
                s8 = StringUtils.leftPad(Integer.toString(k1), k2, '0');
            } else
            {
                s8 = Integer.toString(k1);
            }
            stringbuffer.append(s8);
        }
          goto _L5
        return stringbuffer.toString();
          goto _L3
    }

    public static String formatDuration(long l, String s1)
    {
        return formatDuration(l, s1, true);
    }

    public static String formatDuration(long l, String s1, boolean flag)
    {
        s1 = lexx(s1);
        int i = 0;
        int j = 0;
        int k = 0;
        int i1 = 0;
        int j1 = 0;
        long l1 = l;
        if (Token.containsTokenWithValue(s1, d))
        {
            i = (int)(l / 0x5265c00L);
            l1 = l - (long)i * 0x5265c00L;
        }
        l = l1;
        if (Token.containsTokenWithValue(s1, H))
        {
            j = (int)(l1 / 0x36ee80L);
            l = l1 - (long)j * 0x36ee80L;
        }
        l1 = l;
        if (Token.containsTokenWithValue(s1, m))
        {
            k = (int)(l / 60000L);
            l1 = l - (long)k * 60000L;
        }
        l = l1;
        if (Token.containsTokenWithValue(s1, s))
        {
            i1 = (int)(l1 / 1000L);
            l = l1 - (long)i1 * 1000L;
        }
        if (Token.containsTokenWithValue(s1, S))
        {
            j1 = (int)l;
        }
        return format(s1, 0, 0, i, j, k, i1, j1, flag);
    }

    public static String formatDurationHMS(long l)
    {
        return formatDuration(l, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long l)
    {
        return formatDuration(l, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
    }

    public static String formatDurationWords(long l, boolean flag, boolean flag1)
    {
        String s1 = formatDuration(l, "d' days 'H' hours 'm' minutes 's' seconds'");
        String s2 = s1;
        if (flag)
        {
            s1 = (new StringBuilder(" ")).append(s1).toString();
            s2 = StringUtils.replaceOnce(s1, " 0 days", "");
            if (s2.length() != s1.length())
            {
                String s4 = StringUtils.replaceOnce(s2, " 0 hours", "");
                s1 = s2;
                if (s4.length() != s2.length())
                {
                    s2 = StringUtils.replaceOnce(s4, " 0 minutes", "");
                    s1 = s2;
                    if (s2.length() != s2.length())
                    {
                        s1 = StringUtils.replaceOnce(s2, " 0 seconds", "");
                    }
                }
            }
            s2 = s1;
            if (s1.length() != 0)
            {
                s2 = s1.substring(1);
            }
        }
        s1 = s2;
        if (flag1)
        {
            String s5 = StringUtils.replaceOnce(s2, " 0 seconds", "");
            s1 = s2;
            if (s5.length() != s2.length())
            {
                String s3 = StringUtils.replaceOnce(s5, " 0 minutes", "");
                if (s3.length() != s5.length())
                {
                    s5 = StringUtils.replaceOnce(s3, " 0 hours", "");
                    s1 = s3;
                    if (s5.length() != s3.length())
                    {
                        s1 = StringUtils.replaceOnce(s5, " 0 days", "");
                    }
                } else
                {
                    s1 = s5;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce((new StringBuilder(" ")).append(s1).toString(), " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long l, long l1, String s1)
    {
        return formatPeriod(l, l1, s1, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long l, long l1, String s1, boolean flag, TimeZone timezone)
    {
        s1 = lexx(s1);
        Calendar calendar = Calendar.getInstance(timezone);
        calendar.setTime(new Date(l));
        timezone = Calendar.getInstance(timezone);
        timezone.setTime(new Date(l1));
        int k = timezone.get(14) - calendar.get(14);
        int j = timezone.get(13) - calendar.get(13);
        int j1 = timezone.get(12) - calendar.get(12);
        int k1 = timezone.get(11) - calendar.get(11);
        int i2 = timezone.get(5) - calendar.get(5);
        int j3 = timezone.get(2) - calendar.get(2);
        int j2 = timezone.get(1) - calendar.get(1);
        int i;
        int i1;
        do
        {
            i = j1;
            i1 = j;
            if (k >= 0)
            {
                break;
            }
            k += 1000;
            j--;
        } while (true);
        do
        {
            j = k1;
            j1 = i;
            if (i1 >= 0)
            {
                break;
            }
            i1 += 60;
            i--;
        } while (true);
        do
        {
            i = i2;
            k1 = j;
            if (j1 >= 0)
            {
                break;
            }
            j1 += 60;
            j--;
        } while (true);
        while (k1 < 0) 
        {
            k1 += 24;
            i--;
        }
        if (Token.containsTokenWithValue(s1, M))
        {
            i2 = j3;
            int k2 = i;
            do
            {
                i = j2;
                j = i2;
                if (k2 >= 0)
                {
                    break;
                }
                k2 += calendar.getActualMaximum(5);
                i2--;
                calendar.add(2, 1);
            } while (true);
            while (j < 0) 
            {
                j += 12;
                i--;
            }
            i2 = i;
            j2 = j;
            j3 = k2;
            if (!Token.containsTokenWithValue(s1, y))
            {
                i2 = i;
                j2 = j;
                j3 = k2;
                if (i != 0)
                {
                    do
                    {
                        i2 = i;
                        j2 = j;
                        j3 = k2;
                        if (i == 0)
                        {
                            break;
                        }
                        j += i * 12;
                        i = 0;
                    } while (true);
                }
            }
        } else
        {
            int l2 = j2;
            j = i;
            if (!Token.containsTokenWithValue(s1, y))
            {
                j2 = timezone.get(1);
                i2 = j2;
                j = i;
                if (j3 < 0)
                {
                    i2 = j2 - 1;
                    j = i;
                }
                while (calendar.get(1) != i2) 
                {
                    j += calendar.getActualMaximum(6) - calendar.get(6);
                    i = j;
                    if (calendar instanceof GregorianCalendar)
                    {
                        i = j;
                        if (calendar.get(2) == 1)
                        {
                            i = j;
                            if (calendar.get(5) == 29)
                            {
                                i = j + 1;
                            }
                        }
                    }
                    calendar.add(1, 1);
                    j = i + calendar.get(6);
                }
                l2 = 0;
            }
            for (; calendar.get(2) != timezone.get(2); calendar.add(2, 1))
            {
                j += calendar.getActualMaximum(5);
            }

            i = 0;
            do
            {
                i2 = l2;
                j2 = i;
                j3 = j;
                if (j >= 0)
                {
                    break;
                }
                j += calendar.getActualMaximum(5);
                i--;
                calendar.add(2, 1);
            } while (true);
        }
        int i3 = j3;
        i = k1;
        if (!Token.containsTokenWithValue(s1, d))
        {
            i = k1 + j3 * 24;
            i3 = 0;
        }
        k1 = i;
        j = j1;
        if (!Token.containsTokenWithValue(s1, H))
        {
            j = j1 + i * 60;
            k1 = 0;
        }
        j1 = j;
        i = i1;
        if (!Token.containsTokenWithValue(s1, m))
        {
            i = i1 + j * 60;
            j1 = 0;
        }
        i1 = i;
        j = k;
        if (!Token.containsTokenWithValue(s1, s))
        {
            j = k + i * 1000;
            i1 = 0;
        }
        return format(s1, i2, j2, i3, k1, j1, i1, j, flag);
    }

    public static String formatPeriodISO(long l, long l1)
    {
        return formatPeriod(l, l1, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
    }

    static Token[] lexx(String s1)
    {
        StringBuffer stringbuffer;
        Token token;
        char ac[];
        ArrayList arraylist;
        boolean flag;
        int i;
        int j;
        ac = s1.toCharArray();
        arraylist = new ArrayList(ac.length);
        j = ac.length;
        i = 0;
        token = null;
        stringbuffer = null;
        flag = false;
_L2:
        char c;
        Object obj;
        boolean flag1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        c = ac[i];
        if (!flag || c == '\'')
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(c);
        flag1 = flag;
        obj = token;
_L12:
        i++;
        token = ((Token) (obj));
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        c;
        JVM INSTR lookupswitch 8: default 160
    //                   39: 242
    //                   72: 308
    //                   77: 294
    //                   83: 329
    //                   100: 301
    //                   109: 315
    //                   115: 322
    //                   121: 287;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L7:
        break MISSING_BLOCK_LABEL_329;
_L3:
        obj = stringbuffer;
        if (stringbuffer == null)
        {
            obj = new StringBuffer();
            arraylist.add(new Token(obj));
        }
        ((StringBuffer) (obj)).append(c);
        s1 = null;
        stringbuffer = ((StringBuffer) (obj));
_L13:
        obj = token;
        flag1 = flag;
        if (s1 != null)
        {
            if (token != null && token.getValue() == s1)
            {
                token.increment();
            } else
            {
                token = new Token(s1);
                arraylist.add(token);
            }
            stringbuffer = null;
            obj = token;
            flag1 = flag;
        }
          goto _L12
_L4:
        if (flag)
        {
            s1 = null;
            stringbuffer = null;
            flag = false;
        } else
        {
            stringbuffer = new StringBuffer();
            arraylist.add(new Token(stringbuffer));
            flag = true;
            s1 = null;
        }
          goto _L13
_L11:
        s1 = ((String) (y));
          goto _L13
_L6:
        s1 = ((String) (M));
          goto _L13
_L8:
        s1 = ((String) (d));
          goto _L13
_L5:
        s1 = ((String) (H));
          goto _L13
_L9:
        s1 = ((String) (m));
          goto _L13
_L10:
        s1 = ((String) (s));
          goto _L13
        s1 = ((String) (S));
          goto _L13
        return (Token[])arraylist.toArray(new Token[arraylist.size()]);
          goto _L12
    }


    private class Token
    {

        private int count;
        private final Object value;

        static boolean containsTokenWithValue(Token atoken[], Object obj)
        {
            boolean flag1 = false;
            int j = atoken.length;
            int i = 0;
            do
            {
label0:
                {
                    boolean flag = flag1;
                    if (i < j)
                    {
                        if (atoken[i].getValue() != obj)
                        {
                            break label0;
                        }
                        flag = true;
                    }
                    return flag;
                }
                i++;
            } while (true);
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof Token)
            {
                obj = (Token)obj;
                break MISSING_BLOCK_LABEL_12;
            }
_L1:
            return false;
            if (value.getClass() == ((Token) (obj)).value.getClass() && count == ((Token) (obj)).count)
            {
                if (value instanceof StringBuffer)
                {
                    return value.toString().equals(((Token) (obj)).value.toString());
                }
                if (value instanceof Number)
                {
                    return value.equals(((Token) (obj)).value);
                }
                if (value == ((Token) (obj)).value)
                {
                    return true;
                }
            }
              goto _L1
        }

        int getCount()
        {
            return count;
        }

        Object getValue()
        {
            return value;
        }

        public int hashCode()
        {
            return value.hashCode();
        }

        void increment()
        {
            count = count + 1;
        }

        public String toString()
        {
            return StringUtils.repeat(value.toString(), count);
        }

        Token(Object obj)
        {
            value = obj;
            count = 1;
        }

        Token(Object obj, int i)
        {
            value = obj;
            count = i;
        }
    }

}
