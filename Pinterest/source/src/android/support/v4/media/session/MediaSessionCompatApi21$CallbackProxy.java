// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.os.ResultReceiver;

class mCallback extends android.media.session.lbackProxy
{

    protected final p mCallback;

    public void onCommand(String s, Bundle bundle, ResultReceiver resultreceiver)
    {
        mCallback.mand(s, bundle, resultreceiver);
    }

    public void onFastForward()
    {
        mCallback.tForward();
    }

    public boolean onMediaButtonEvent(Intent intent)
    {
        return mCallback.iaButtonEvent(intent);
    }

    public void onPause()
    {
        mCallback.se();
    }

    public void onPlay()
    {
        mCallback.y();
    }

    public void onRewind()
    {
        mCallback.ind();
    }

    public void onSeekTo(long l)
    {
        mCallback.kTo(l);
    }

    public void onSetRating(Rating rating)
    {
        mCallback.Rating(rating);
    }

    public void onSkipToNext()
    {
        mCallback.pToNext();
    }

    public void onSkipToPrevious()
    {
        mCallback.pToPrevious();
    }

    public void onStop()
    {
        mCallback.p();
    }

    public ( )
    {
        mCallback = ;
    }
}
