// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            cc

public final class cd
{

    public cc a;
    private String b;

    public cd(cc cc1, String s)
    {
        a = cc1;
        b = s;
    }

    public final String toString()
    {
        String s1 = a.toString();
        String s = s1;
        if (b != null)
        {
            s = s1;
            if (b.trim().length() > 0)
            {
                s = (new StringBuilder()).append(s1).append(" : ").append(b).toString();
            }
        }
        return s;
    }
}
