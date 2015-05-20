// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;

final class CharRange
    implements Serializable, Iterable
{

    private static final long serialVersionUID = 0x72c597c5037807eeL;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    private CharRange(char c, char c1, boolean flag)
    {
        char c2;
        if (c > c1)
        {
            c2 = c1;
            c1 = c;
        } else
        {
            c2 = c;
        }
        start = c2;
        end = c1;
        negated = flag;
    }

    public static CharRange is(char c)
    {
        return new CharRange(c, c, false);
    }

    public static CharRange isIn(char c, char c1)
    {
        return new CharRange(c, c1, false);
    }

    public static CharRange isNot(char c)
    {
        return new CharRange(c, c, true);
    }

    public static CharRange isNotIn(char c, char c1)
    {
        return new CharRange(c, c1, true);
    }

    public final boolean contains(char c)
    {
        boolean flag;
        if (c >= start && c <= end)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag != negated;
    }

    public final boolean contains(CharRange charrange)
    {
        if (charrange == null)
        {
            throw new IllegalArgumentException("The Range must not be null");
        }
        if (!negated) goto _L2; else goto _L1
_L1:
        if (!charrange.negated) goto _L4; else goto _L3
_L3:
        if (start < charrange.start || end > charrange.end) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        if (charrange.end < start || charrange.start > end) goto _L5; else goto _L7
_L7:
        return false;
_L2:
        if (!charrange.negated)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (start == 0 && end == '\uFFFF') goto _L5; else goto _L8
_L8:
        return false;
        if (start <= charrange.start && end >= charrange.end) goto _L5; else goto _L9
_L9:
        return false;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof CharRange))
            {
                return false;
            }
            obj = (CharRange)obj;
            if (start != ((CharRange) (obj)).start || end != ((CharRange) (obj)).end || negated != ((CharRange) (obj)).negated)
            {
                return false;
            }
        }
        return true;
    }

    public final char getEnd()
    {
        return end;
    }

    public final char getStart()
    {
        return start;
    }

    public final int hashCode()
    {
        char c = start;
        char c1 = end;
        int i;
        if (negated)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + (c1 * 7 + (c + 83));
    }

    public final boolean isNegated()
    {
        return negated;
    }

    public final Iterator iterator()
    {
        return new CharacterIterator(null);
    }

    public final String toString()
    {
        if (iToString == null)
        {
            StringBuilder stringbuilder = new StringBuilder(4);
            if (isNegated())
            {
                stringbuilder.append('^');
            }
            stringbuilder.append(start);
            if (start != end)
            {
                stringbuilder.append('-');
                stringbuilder.append(end);
            }
            iToString = stringbuilder.toString();
        }
        return iToString;
    }




    private class CharacterIterator
        implements Iterator
    {

        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext()
        {
            if (range.negated)
            {
                if (current != '\uFFFF')
                {
                    if (current + 1 == range.start)
                    {
                        if (range.end != '\uFFFF')
                        {
                            current = (char)(range.end + 1);
                            return;
                        }
                    } else
                    {
                        current = (char)(current + 1);
                        return;
                    }
                }
            } else
            if (current < range.end)
            {
                current = (char)(current + 1);
                return;
            }
            hasNext = false;
        }

        public boolean hasNext()
        {
            return hasNext;
        }

        public Character next()
        {
            if (!hasNext)
            {
                throw new NoSuchElementException();
            } else
            {
                char c = current;
                prepareNext();
                return Character.valueOf(c);
            }
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        private CharacterIterator()
        {
            range = CharRange.this;
            hasNext = true;
            if (range.negated)
            {
                if (range.start == 0)
                {
                    if (range.end == '\uFFFF')
                    {
                        hasNext = false;
                        return;
                    } else
                    {
                        current = (char)(range.end + 1);
                        return;
                    }
                } else
                {
                    current = '\0';
                    return;
                }
            } else
            {
                current = range.start;
                return;
            }
        }

        CharacterIterator(_cls1 _pcls1)
        {
            this();
        }
    }

}
