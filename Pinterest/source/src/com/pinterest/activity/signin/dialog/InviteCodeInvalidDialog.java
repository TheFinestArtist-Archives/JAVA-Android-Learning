// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.kit.application.Resources;

public class InviteCodeInvalidDialog extends BaseDialog
{

    public InviteCodeInvalidDialog()
    {
        setTitle(Resources.string(0x7f0e0340));
        setMessage(Resources.string(0x7f0e038d));
        setPositiveButton(0x7f0e025b, null);
    }
}
