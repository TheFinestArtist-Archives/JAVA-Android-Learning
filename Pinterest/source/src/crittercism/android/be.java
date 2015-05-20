// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package crittercism.android:
//            bj, bh

public final class be
{

    public JSONArray a;

    public be(bj bj1)
    {
        a = new JSONArray();
        bj1 = bj1.d();
        if (bj1 != null)
        {
            bj1 = bj1.iterator();
            do
            {
                if (!bj1.hasNext())
                {
                    break;
                }
                Object obj = ((bh)bj1.next()).a();
                if (obj != null)
                {
                    a.put(obj);
                }
            } while (true);
        }
    }
}
