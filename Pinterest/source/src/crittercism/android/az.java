// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import com.crittercism.app.CrittercismConfig;
import java.util.List;

public final class az extends CrittercismConfig
{

    private String a;
    private String b;

    public az()
    {
        a = "https://api.crittercism.com";
        b = "https://apm.crittercism.com";
    }

    public az(CrittercismConfig crittercismconfig)
    {
        super(crittercismconfig);
        a = "https://api.crittercism.com";
        b = "https://apm.crittercism.com";
    }

    public final String a()
    {
        return a;
    }

    public final String b()
    {
        return b;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof az))
        {
            return false;
        }
        az az1 = (az)obj;
        return super.equals(obj) && a(a, az1.a) && a(b, az1.b);
    }

    public final List getOptmzBlackListURLPatterns()
    {
        List list = super.getOptmzBlackListURLPatterns();
        list.add(b);
        return list;
    }

    public final int hashCode()
    {
        return (super.hashCode() * 31 + a.hashCode()) * 31 + b.hashCode();
    }
}
