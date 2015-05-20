// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.megaphone;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.widget.ImageView;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGBuilder;
import com.pinterest.base.CrashReporting;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.ui.megaphone:
//            MegaphoneView

class t> extends BackgroundTask
{

    private SVG _svg;
    final MegaphoneView this$0;
    final int val$resId;

    public void onFinish()
    {
        Picture picture = _svg.a();
        Bitmap bitmap;
        try
        {
            bitmap = Bitmap.createBitmap(picture.getWidth(), picture.getHeight(), android.graphics.GB_8888);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            CrashReporting.logHandledException(outofmemoryerror);
            outofmemoryerror = null;
        }
        if (bitmap != null)
        {
            picture.draw(new Canvas(bitmap));
            if (MegaphoneView.access$200(MegaphoneView.this) != null)
            {
                MegaphoneView.access$200(MegaphoneView.this).setImageBitmap(bitmap);
                MegaphoneView.access$302(MegaphoneView.this, true);
                if (MegaphoneView.access$400(MegaphoneView.this))
                {
                    show();
                }
            }
        } else
        {
            MegaphoneView.access$502(MegaphoneView.this, true);
        }
        _svg = null;
    }

    public void run()
    {
        _svg = (new SVGBuilder()).a(getResources(), val$resId).a();
    }

    ()
    {
        this$0 = final_megaphoneview;
        val$resId = I.this;
        super();
    }
}
