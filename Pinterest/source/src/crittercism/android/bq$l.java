// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

// Referenced classes of package crittercism.android:
//            bp, bq

public final class a
    implements bp
{

    private String a;

    public final String a()
    {
        return "locale";
    }

    public final volatile Object b()
    {
        return a;
    }

    public guration()
    {
        a = null;
        String s = bq.b().getResources().getConfiguration().locale.getLanguage();
        if (s == null || s.equals(""))
        {
            s = "en";
        }
        a = s;
    }
}
