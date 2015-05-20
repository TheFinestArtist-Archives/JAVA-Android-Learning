// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.kit.tasks.BackgroundTask;

class a extends BackgroundTask
{

    final a a;

    public void onFinish()
    {
        a.Success(cess._mth100(a));
    }

    public void run()
    {
        Board board = cess._mth100(a);
        boolean flag;
        if (!cess._mth000(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        board.setFollowing(Boolean.valueOf(flag));
        ModelHelper.setBoard(cess._mth100(a));
    }

    ( )
    {
        a = ;
        super();
    }
}
