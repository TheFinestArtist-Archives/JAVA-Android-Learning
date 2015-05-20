// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.net.Uri;
import com.pinterest.base.Application;

// Referenced classes of package com.squareup.picasso:
//            Picasso, Utils

public class PicassoUtil
{

    public static boolean a(String s)
    {
        for (s = b(s); s == null || Picasso.a(Application.context()).b(s) == null;)
        {
            return false;
        }

        return true;
    }

    private static String b(String s)
    {
        try
        {
            s = (new Request.Builder(Uri.parse(s))).e();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = null;
        }
        if (s == null)
        {
            return null;
        } else
        {
            return Utils.a(s);
        }
    }
}
