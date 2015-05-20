// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Android;

import android.media.AudioRecord;

// Referenced classes of package com.gracenote.gnsdk.Android:
//            GnAudioSourceMic, IGnAudioSourceDelegate

class a
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

    ate(GnAudioSourceMic gnaudiosourcemic)
    {
        a = gnaudiosourcemic;
        super();
    }
}
