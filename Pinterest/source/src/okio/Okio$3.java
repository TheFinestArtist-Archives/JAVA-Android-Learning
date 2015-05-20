// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package okio:
//            AsyncTimeout, Okio

final class meout extends AsyncTimeout
{

    final Socket a;

    protected final void a()
    {
        try
        {
            a.close();
            return;
        }
        catch (Exception exception)
        {
            Okio.a().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(a).toString(), exception);
        }
    }

    ket(Socket socket)
    {
        a = socket;
        super();
    }
}
