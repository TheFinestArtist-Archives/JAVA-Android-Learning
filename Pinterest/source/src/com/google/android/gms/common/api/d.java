// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.internal.jx;

public final class d
{

    private final a Kt;
    private volatile Object mListener;

    d(Looper looper, Object obj)
    {
        Kt = new a(looper);
        mListener = jx.b(obj, "Listener must not be null");
    }

    public final void a(b b1)
    {
        jx.b(b1, "Notifier must not be null");
        b1 = Kt.obtainMessage(1, b1);
        Kt.sendMessage(b1);
    }

    final void b(b b1)
    {
        Object obj = mListener;
        if (obj == null)
        {
            b1.gG();
            return;
        }
        try
        {
            b1.c(obj);
            return;
        }
        catch (Exception exception)
        {
            Log.w("ListenerHolder", "Notifying listener failed", exception);
        }
        b1.gG();
    }

    public final void clear()
    {
        mListener = null;
    }

    private class a extends Handler
    {

        final d Ku;

        public final void handleMessage(Message message)
        {
            boolean flag = true;
            if (message.what != 1)
            {
                flag = false;
            }
            jx.L(flag);
            Ku.b((b)message.obj);
        }

        public a(Looper looper)
        {
            Ku = d.this;
            super(looper);
        }
    }


    private class b
    {

        public abstract void c(Object obj);

        public abstract void gG();
    }

}
