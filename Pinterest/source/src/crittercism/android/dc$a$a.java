// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            db, da

public final class ion
    implements db
{

    public final da a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("packageName cannot be null");
        } else
        {
            return new nit>(s, (byte)0);
        }
    }

    public ion()
    {
    }
}
