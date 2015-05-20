// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;


// Referenced classes of package okio:
//            AsyncTimeout

final class setDaemon extends Thread
{

    public final void run()
    {
        do
        {
            AsyncTimeout asynctimeout;
            do
            {
                asynctimeout = AsyncTimeout.e();
            } while (asynctimeout == null);
            try
            {
                asynctimeout.a();
            }
            catch (InterruptedException interruptedexception) { }
        } while (true);
    }

    public ion()
    {
        super("Okio Watchdog");
        setDaemon(true);
    }
}
