// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.network.image;

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import com.android.volley.VolleyError;
import com.pinterest.api.ImageApiResponseHandler;
import com.pinterest.base.Application;
import com.pinterest.base.CrashReporting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class it> extends ImageApiResponseHandler
{

    final File val$fileDir;

    public final void onErrorResponse(VolleyError volleyerror)
    {
        super.onErrorResponse(volleyerror);
        CrashReporting.logHandledException(volleyerror.getCause());
    }

    public final void onResponse(Bitmap bitmap)
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(val$fileDir);
            bitmap.compress(android.graphics.ssFormat.JPEG, 90, fileoutputstream);
            MediaScannerConnection.scanFile(Application.context(), new String[] {
                val$fileDir.getAbsolutePath()
            }, null, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            CrashReporting.logHandledException(bitmap);
        }
    }

    public final volatile void onResponse(Object obj)
    {
        onResponse((Bitmap)obj);
    }

    ()
    {
        val$fileDir = file;
        super();
    }
}
