// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.time;

import java.util.Calendar;

class mField
    implements mField
{

    private final int mField;

    public final void appendTo(StringBuffer stringbuffer, int i)
    {
        if (i < 10)
        {
            stringbuffer.append((char)(i + 48));
            return;
        }
        if (i < 100)
        {
            stringbuffer.append((char)(i / 10 + 48));
            stringbuffer.append((char)(i % 10 + 48));
            return;
        } else
        {
            stringbuffer.append(Integer.toString(i));
            return;
        }
    }

    public void appendTo(StringBuffer stringbuffer, Calendar calendar)
    {
        appendTo(stringbuffer, calendar.get(mField));
    }

    public int estimateLength()
    {
        return 4;
    }

    (int i)
    {
        mField = i;
    }
}
