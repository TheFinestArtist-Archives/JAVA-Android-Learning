// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            am, ae, m

class 
    implements 
{

    private final am Cu = new am();

    public void c(String s, int i)
    {
        if ("ga_sessionTimeout".equals(s))
        {
            Cu.Cx = i;
            return;
        } else
        {
            ae.W((new StringBuilder("int configuration name not recognized:  ")).append(s).toString());
            return;
        }
    }

    public void e(String s, String s1)
    {
        Cu.CB.put(s, s1);
    }

    public void e(String s, boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        int i = 1;
        if ("ga_autoActivityTracking".equals(s))
        {
            s = Cu;
            if (!flag)
            {
                i = 0;
            }
            s.Cy = i;
            return;
        }
        if ("ga_anonymizeIp".equals(s))
        {
            s = Cu;
            int j;
            if (flag)
            {
                j = ((flag1) ? 1 : 0);
            } else
            {
                j = 0;
            }
            s.Cz = j;
            return;
        }
        if ("ga_reportUncaughtExceptions".equals(s))
        {
            s = Cu;
            int k;
            if (flag)
            {
                k = ((flag2) ? 1 : 0);
            } else
            {
                k = 0;
            }
            s.CA = k;
            return;
        } else
        {
            ae.W((new StringBuilder("bool configuration name not recognized:  ")).append(s).toString());
            return;
        }
    }

    public m er()
    {
        return fs();
    }

    public void f(String s, String s1)
    {
        if ("ga_trackingId".equals(s))
        {
            Cu.Cv = s1;
            return;
        }
        if ("ga_sampleFrequency".equals(s))
        {
            try
            {
                Cu.Cw = Double.parseDouble(s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ae.T((new StringBuilder("Error parsing ga_sampleFrequency value: ")).append(s1).toString());
            }
            return;
        } else
        {
            ae.W((new StringBuilder("string configuration name not recognized:  ")).append(s).toString());
            return;
        }
    }

    public am fs()
    {
        return Cu;
    }

    public ()
    {
    }
}
