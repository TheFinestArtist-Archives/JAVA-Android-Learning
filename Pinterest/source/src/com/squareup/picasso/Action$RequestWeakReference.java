// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.squareup.picasso:
//            Action

class a extends WeakReference
{

    final Action a;

    public (Action action, Object obj, ReferenceQueue referencequeue)
    {
        super(obj, referencequeue);
        a = action;
    }
}
