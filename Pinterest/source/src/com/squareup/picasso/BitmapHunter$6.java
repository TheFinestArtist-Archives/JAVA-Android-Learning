// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;


// Referenced classes of package com.squareup.picasso:
//            Transformation

final class a
    implements Runnable
{

    final Transformation a;

    public final void run()
    {
        throw new IllegalStateException((new StringBuilder("Transformation ")).append(a.key()).append(" mutated input Bitmap but failed to recycle the original.").toString());
    }

    (Transformation transformation)
    {
        a = transformation;
        super();
    }
}
