// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.seismic;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class ShakeDetector
    implements SensorEventListener
{

    private final SampleQueue a = new SampleQueue();
    private final Listener b;
    private SensorManager c;
    private Sensor d;

    public ShakeDetector(Listener listener)
    {
        b = listener;
    }

    public final void a()
    {
        if (d != null)
        {
            c.unregisterListener(this, d);
            c = null;
            d = null;
        }
    }

    public final boolean a(SensorManager sensormanager)
    {
        if (d == null)
        {
            d = sensormanager.getDefaultSensor(1);
            if (d != null)
            {
                c = sensormanager;
                sensormanager.registerListener(this, d, 0);
            }
            if (d == null)
            {
                return false;
            }
        }
        return true;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        boolean flag = true;
        float f = sensorevent.values[0];
        float f1 = sensorevent.values[1];
        float f2 = sensorevent.values[2];
        long l;
        if (Math.sqrt(f * f + f1 * f1 + f2 * f2) <= 13D)
        {
            flag = false;
        }
        l = sensorevent.timestamp;
        a.a(l, flag);
        if (a.b())
        {
            a.a();
            b.hearShake();
        }
    }

    private class SampleQueue
    {
        private class SamplePool
        {

            private Sample a;

            final Sample a()
            {
                Sample sample = a;
                if (sample == null)
                {
                    return new Sample();
                } else
                {
                    a = sample.c;
                    return sample;
                }
            }

            final void a(Sample sample)
            {
                sample.c = a;
                a = sample;
            }

            SamplePool()
            {
            }

            private class Sample
            {

                long a;
                boolean b;
                Sample c;

                Sample()
                {
                }
            }

        }


        private final SamplePool a = new SamplePool();
        private Sample b;
        private Sample c;
        private int d;
        private int e;

        final void a()
        {
            while (b != null) 
            {
                Sample sample = b;
                b = sample.c;
                a.a(sample);
            }
            c = null;
            d = 0;
            e = 0;
        }

        final void a(long l, boolean flag)
        {
            while (d >= 4 && b != null && l - 0x1dcd6500L - b.a > 0L) 
            {
                Sample sample = b;
                if (sample.b)
                {
                    e = e - 1;
                }
                d = d - 1;
                b = sample.c;
                if (b == null)
                {
                    c = null;
                }
                a.a(sample);
            }
            Sample sample1 = a.a();
            sample1.a = l;
            sample1.b = flag;
            sample1.c = null;
            if (c != null)
            {
                c.c = sample1;
            }
            c = sample1;
            if (b == null)
            {
                b = sample1;
            }
            d = d + 1;
            if (flag)
            {
                e = e + 1;
            }
        }

        final boolean b()
        {
            return c != null && b != null && c.a - b.a >= 0xee6b280L && e >= (d >> 1) + (d >> 2);
        }

        SampleQueue()
        {
        }
    }


    private class Listener
    {

        public abstract void hearShake();
    }

}
