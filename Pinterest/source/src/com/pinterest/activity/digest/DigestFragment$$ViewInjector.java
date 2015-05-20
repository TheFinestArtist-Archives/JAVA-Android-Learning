// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import com.pinterest.activity.digest.ui.DigestHeaderView;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

public class 
{

    public static void inject(butterknife.ent ent, DigestFragment digestfragment, Object obj)
    {
        com.pinterest.fragment.jector.inject(ent, digestfragment, obj);
        digestfragment._headerView = (DigestHeaderView)ent.aderView(obj, 0x7f0b0158, "field '_headerView'");
    }

    public static void reset(DigestFragment digestfragment)
    {
        com.pinterest.fragment.jector.reset(digestfragment);
        digestfragment._headerView = null;
    }

    public ()
    {
    }
}
