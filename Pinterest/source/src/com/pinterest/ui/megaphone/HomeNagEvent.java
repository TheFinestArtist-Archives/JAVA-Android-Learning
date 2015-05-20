// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.megaphone;

import com.pinterest.experiment.Experiments;

// Referenced classes of package com.pinterest.ui.megaphone:
//            BaseNagEvent

public class HomeNagEvent extends BaseNagEvent
{

    public HomeNagEvent()
    {
        boolean flag;
        if (!Experiments.l())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        enableAnimation = flag;
    }
}
