// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.os.Handler;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class this._cls0
    implements Runnable
{

    final DigestFragment this$0;

    public void run()
    {
        DigestFragment.access$200(DigestFragment.this);
        if (isAdded() && isActive() && DigestFragment.access$300(DigestFragment.this) != null)
        {
            DigestFragment.access$300(DigestFragment.this).postDelayed(this, 30000L);
        }
    }

    ()
    {
        this$0 = DigestFragment.this;
        super();
    }
}
