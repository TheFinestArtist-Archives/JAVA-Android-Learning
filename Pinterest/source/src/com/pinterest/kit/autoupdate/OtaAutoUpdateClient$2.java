// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.autoupdate;

import com.pinterest.api.ByteApiResponseHandler;
import com.pinterest.base.Application;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.notification.NotificationHelper;
import com.pinterest.kit.utils.FileUtils;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.pinterest.kit.autoupdate:
//            OtaAutoUpdateClient

final class  extends ByteApiResponseHandler
{

    public final void a()
    {
        OtaAutoUpdateClient.d();
        OtaAutoUpdateClient.a(true);
    }

    public final void a(byte abyte0[])
    {
        File file = new File(Application.context().getExternalCacheDir(), "pinterest-master.apk");
        file.delete();
        try
        {
            FileUtils.writeByteArrayToFile(file, abyte0);
            if (file.exists())
            {
                OtaAutoUpdateClient.a(file);
            }
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        NotificationHelper.cancelNotification(1);
        OtaAutoUpdateClient.a(false);
    }

    public final void onResponse(Object obj)
    {
        a((byte[])obj);
    }

    ()
    {
    }
}
