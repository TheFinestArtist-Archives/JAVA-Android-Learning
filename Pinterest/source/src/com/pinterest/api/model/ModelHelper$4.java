// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.kit.tasks.BackgroundTask;
import java.io.File;

// Referenced classes of package com.pinterest.api.model:
//            ModelHelper

class  extends BackgroundTask
{

    final ModelHelper this$0;
    final File val$dbFile;

    public void run()
    {
        val$dbFile.delete();
    }

    ()
    {
        this$0 = final_modelhelper;
        val$dbFile = File.this;
        super();
    }
}
