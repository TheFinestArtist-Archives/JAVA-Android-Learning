// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Android;

import android.media.AudioRecord;
import android.util.Log;
import com.gracenote.gnsdk.Acr.GnAcrAudioConfig;

// Referenced classes of package com.gracenote.gnsdk.Android:
//            IGnAudioSourceDelegate

public class GnAudioSourceMic
{

    private IGnAudioSourceDelegate a;
    private AudioRecord b;
    private int c;
    private volatile boolean d;
    private Object e;

    public GnAudioSourceMic()
    {
        d = false;
        e = new Object();
    }

    static int a(GnAudioSourceMic gnaudiosourcemic)
    {
        return gnaudiosourcemic.c;
    }

    static Object b(GnAudioSourceMic gnaudiosourcemic)
    {
        return gnaudiosourcemic.e;
    }

    static boolean c(GnAudioSourceMic gnaudiosourcemic)
    {
        return gnaudiosourcemic.d;
    }

    static AudioRecord d(GnAudioSourceMic gnaudiosourcemic)
    {
        return gnaudiosourcemic.b;
    }

    static IGnAudioSourceDelegate e(GnAudioSourceMic gnaudiosourcemic)
    {
        return gnaudiosourcemic.a;
    }

    static AudioRecord f(GnAudioSourceMic gnaudiosourcemic)
    {
        gnaudiosourcemic.b = null;
        return null;
    }

    public final void a()
    {
        if (d)
        {
            Log.i("GNACRSDK", "Recording already started.");
            return;
        }
        int i = 0;
        do
        {
            try
            {
                b.startRecording();
                d = true;
            }
            catch (Object obj)
            {
                i++;
                if (i < 3)
                {
                    try
                    {
                        Thread.sleep(350L);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((InterruptedException) (obj)).printStackTrace();
                    }
                } else
                {
                    throw obj;
                }
            }
        } while (!d);
        (new Thread(new _cls1(), "AudioReadBytes")).start();
    }

    public final void a(GnAcrAudioConfig gnacraudioconfig, IGnAudioSourceDelegate ignaudiosourcedelegate)
    {
        if (ignaudiosourcedelegate == null)
        {
            throw new IllegalArgumentException();
        }
        gnacraudioconfig.d();
        JVM INSTR tableswitch 1 2: default 40
    //                   1 109
    //                   2 115;
           goto _L1 _L2 _L3
_L1:
        int i = 1;
_L10:
        gnacraudioconfig.b();
        JVM INSTR tableswitch 0 1: default 68
    //                   0 121
    //                   1 127;
           goto _L4 _L5 _L6
_L4:
        int j = 1;
_L8:
        a = ignaudiosourcedelegate;
        c = AudioRecord.getMinBufferSize(gnacraudioconfig.c(), i, j);
        if (c == -2)
        {
            throw new IllegalArgumentException("Unable to calculate minimum buffer size");
        }
        break; /* Loop/switch isn't completed */
_L2:
        i = 16;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 12;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 2;
        if (true) goto _L8; else goto _L7
_L7:
        if (c == -1)
        {
            throw new Exception("Unable query the hardware for its output properties or the minimum buffer size expressed in bytes");
        }
        b = new AudioRecord(1, gnacraudioconfig.c(), i, j, c * 5);
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final void b()
    {
        d = false;
        synchronized (e) { }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private class _cls1
        implements Runnable
    {

        final GnAudioSourceMic a;

        public void run()
        {
            byte abyte0[] = new byte[GnAudioSourceMic.a(a)];
            Object obj = GnAudioSourceMic.b(a);
            obj;
            JVM INSTR monitorenter ;
_L1:
            int i;
            do
            {
                if (!GnAudioSourceMic.c(a))
                {
                    break MISSING_BLOCK_LABEL_102;
                }
                i = GnAudioSourceMic.d(a).read(abyte0, 0, abyte0.length);
            } while (i <= 0);
            GnAudioSourceMic.e(a).audioBytesReady(abyte0, i);
              goto _L1
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            obj;
            GnAudioSourceMic.d(a).stop();
            GnAudioSourceMic.d(a).release();
            GnAudioSourceMic.f(a);
            throw obj;
            obj;
            JVM INSTR monitorexit ;
            GnAudioSourceMic.d(a).stop();
            GnAudioSourceMic.d(a).release();
            GnAudioSourceMic.f(a);
            return;
        }

        _cls1()
        {
            a = GnAudioSourceMic.this;
            super();
        }
    }

}
