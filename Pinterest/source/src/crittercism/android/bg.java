// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.File;

// Referenced classes of package crittercism.android:
//            bo, bj

public final class bg extends bo
{

    private boolean a;

    public bg(boolean flag)
    {
        a = flag;
    }

    public final File a(bj bj1)
    {
        File afile[] = bj1.b();
        bj1 = null;
        if (!a)
        {
            if (afile.length > 0)
            {
                bj1 = afile[0];
            }
        } else
        if (afile.length >= 2)
        {
            return afile[1];
        }
        return bj1;
    }
}
