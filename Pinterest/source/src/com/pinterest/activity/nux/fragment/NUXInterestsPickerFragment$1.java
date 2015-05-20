// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.nux.NUXActivity;
import com.pinterest.activity.nux.adapter.NUXInterestGridAdapter;
import com.pinterest.activity.nux.view.NUXContinueBar;
import com.pinterest.activity.nux.view.NUXInterestGridCell;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.nux.fragment:
//            NUXInterestsPickerFragment

class this._cls0
    implements android.widget.er
{

    final NUXInterestsPickerFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (NUXInterestsPickerFragment.access$000(NUXInterestsPickerFragment.this) == null)
        {
            return;
        }
        adapterview = (NUXInterestGridCell)view;
        view = adapterview.getInterest();
        android.support.v4.app.FragmentActivity fragmentactivity;
        if (((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$100(NUXInterestsPickerFragment.this)).containsInterest(view))
        {
            ((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$200(NUXInterestsPickerFragment.this)).toggleCheckInterest(view);
            if (((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$300(NUXInterestsPickerFragment.this)).getCheckedSize() < NUXInterestsPickerFragment.access$400(NUXInterestsPickerFragment.this))
            {
                Events.post(new com.pinterest.activity.nux.Event(-1, com.pinterest.activity.nux.Event.EventType.INTEREST));
            }
        } else
        {
            if (((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$500(NUXInterestsPickerFragment.this)).getCheckedSize() < NUXInterestsPickerFragment.access$400(NUXInterestsPickerFragment.this))
            {
                Events.post(new com.pinterest.activity.nux.Event(1, com.pinterest.activity.nux.Event.EventType.INTEREST));
            }
            ((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$600(NUXInterestsPickerFragment.this)).toggleCheckInterest(view);
        }
        _continueBar.popInAnimate();
        fragmentactivity = getActivity();
        if (fragmentactivity instanceof NUXActivity)
        {
            ((NUXActivity)fragmentactivity).setProgressVisibility(0);
        }
        ((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$700(NUXInterestsPickerFragment.this)).getCheckedSize();
        JVM INSTR tableswitch 1 5: default 172
    //                   1 279
    //                   2 294
    //                   3 309
    //                   4 324
    //                   5 339;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_339;
_L7:
        if (((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$800(NUXInterestsPickerFragment.this)).getCheckedSize() == NUXInterestsPickerFragment.access$400(NUXInterestsPickerFragment.this))
        {
            _continueBar.enableButton(true);
        } else
        if (((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$900(NUXInterestsPickerFragment.this)).getCheckedSize() < NUXInterestsPickerFragment.access$400(NUXInterestsPickerFragment.this))
        {
            _continueBar.enableButton(false);
        }
        adapterview.setChecked(((NUXInterestGridAdapter)NUXInterestsPickerFragment.access$1000(NUXInterestsPickerFragment.this)).isInterestChecked(view));
        return;
_L2:
        _continueBar.updateText(0x7f0e0334);
          goto _L7
_L3:
        _continueBar.updateText(0x7f0e0335);
          goto _L7
_L4:
        _continueBar.updateText(0x7f0e0336);
          goto _L7
_L5:
        _continueBar.updateText(0x7f0e0337);
          goto _L7
        _continueBar.updateText(0x7f0e0338);
          goto _L7
    }

    ntType()
    {
        this$0 = NUXInterestsPickerFragment.this;
        super();
    }
}
