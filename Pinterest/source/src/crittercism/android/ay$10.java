// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.DialogInterface;
import android.util.Log;

// Referenced classes of package crittercism.android:
//            ay

final class a
    implements android.content.Interface.OnClickListener
{

    final String a;
    final ay b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            ay.r().a(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Log.w("CrittercismInstance", "YES button failed.  Email support@crittercism.com.");
        }
    }

    rface(ay ay1, String s)
    {
        b = ay1;
        a = s;
        super();
    }
}
