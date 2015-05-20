// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.dialog;

import android.app.Activity;

// Referenced classes of package com.pinterest.activity.task.dialog:
//            BaseDialog

public class ShakeMenuDialog extends BaseDialog
{

    public ShakeMenuDialog()
    {
    }

    public ShakeMenuDialog(Activity activity)
    {
        setContent(new ShakeMenuView(activity));
    }

    private class ShakeMenuView extends LinearLayout
        implements android.view.View.OnClickListener
    {

        final ShakeMenuDialog this$0;

        private void init()
        {
            LayoutInflater.from(getContext()).inflate(0x7f03005e, this);
            findViewById(0x7f0b00f7).setOnClickListener(this);
            findViewById(0x7f0b00f8).setOnClickListener(this);
        }

        public void onClick(View view)
        {
            view.getId();
            JVM INSTR tableswitch 2131427575 2131427576: default 28
        //                       2131427575 36
        //                       2131427576 49;
               goto _L1 _L2 _L3
_L1:
            dismiss();
            return;
_L2:
            DeveloperHelper.a(getActivity());
            continue; /* Loop/switch isn't completed */
_L3:
            (new ReportBugDialog(getActivity())).show(getFragmentManager(), "reportBug");
            if (true) goto _L1; else goto _L4
_L4:
        }

        public ShakeMenuView(Context context)
        {
            this$0 = ShakeMenuDialog.this;
            super(context);
            init();
        }

        public ShakeMenuView(Context context, AttributeSet attributeset)
        {
            this$0 = ShakeMenuDialog.this;
            super(context, attributeset);
            init();
        }
    }

}
