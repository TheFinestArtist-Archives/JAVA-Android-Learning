// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;


// Referenced classes of package org.scribe.services:
//            TimestampService

public class TimestampServiceImpl
    implements TimestampService
{

    private Timer timer;

    public TimestampServiceImpl()
    {
        timer = new Timer();
    }

    private Long getTs()
    {
        return Long.valueOf(timer.getMilis().longValue() / 1000L);
    }

    public String getNonce()
    {
        return String.valueOf(getTs().longValue() + (long)timer.getRandomInteger().intValue());
    }

    public String getTimestampInSeconds()
    {
        return String.valueOf(getTs());
    }

    void setTimer(Timer timer1)
    {
        timer = timer1;
    }

    private class Timer
    {

        private final Random rand = new Random();

        Long getMilis()
        {
            return Long.valueOf(System.currentTimeMillis());
        }

        Integer getRandomInteger()
        {
            return Integer.valueOf(rand.nextInt());
        }

        Timer()
        {
        }
    }

}
