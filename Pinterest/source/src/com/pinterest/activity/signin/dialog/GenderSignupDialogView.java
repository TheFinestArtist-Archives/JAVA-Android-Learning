// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            SignupDialogView

public class GenderSignupDialogView extends SignupDialogView
    implements android.view.View.OnClickListener
{

    public GenderSignupDialogView(Context context)
    {
        super(context);
    }

    public GenderSignupDialogView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f030063, this, true);
    }
}
