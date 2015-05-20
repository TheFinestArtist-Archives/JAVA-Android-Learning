// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.service;

import android.app.Service;
import java.io.File;
import java.util.List;

// Referenced classes of package com.pinterest.service:
//            PinUploader

class this._cls0
    implements Runnable
{

    final PinUploader this$0;

    public void run()
    {
        if (PinUploader.access$000(PinUploader.this) == null)
        {
            return;
        }
        Object obj = PinUploader.access$100(PinUploader.this);
        obj;
        JVM INSTR monitorenter ;
_L3:
        Exception exception;
        if (PinUploader.access$000(PinUploader.this).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (PinUploader.access$200(PinUploader.this))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (PinUploader.access$000(PinUploader.this) != null && PinUploader.access$000(PinUploader.this).size() != 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        return;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!PinUploader.access$400(PinUploader.this, (File)PinUploader.access$000(PinUploader.this).get(0), PinUploader.access$300(PinUploader.this)))
        {
            break MISSING_BLOCK_LABEL_165;
        }
        PinUploader.access$202(PinUploader.this, true);
_L1:
        boolean flag = PinUploader.access$200(PinUploader.this);
        if (flag)
        {
            try
            {
                PinUploader.access$100(PinUploader.this).wait();
                PinUploader.access$002(PinUploader.this, PinUploader.access$700(PinUploader.this));
            }
            catch (Exception exception1) { }
            finally { }
        }
        continue; /* Loop/switch isn't completed */
        PinUploader.access$500(PinUploader.this, 0x7f0e0316);
        PinUploader.access$600(PinUploader.this);
          goto _L1
        if (PinUploader.access$800(PinUploader.this) != null)
        {
            PinUploader.access$800(PinUploader.this).stopSelf();
            PinUploader.access$802(PinUploader.this, null);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    ()
    {
        this$0 = PinUploader.this;
        super();
    }
}
