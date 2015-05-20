// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            cd, cc

public final class cb extends Exception
{

    private cd a;

    public cb(cc cc)
    {
        this(new cd(cc, "Unable to install OPTMZ"));
    }

    public cb(cd cd1)
    {
        a = cd1;
    }

    public final cd a()
    {
        return a;
    }
}
