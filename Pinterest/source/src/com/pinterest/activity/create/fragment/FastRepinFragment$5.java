// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import com.pinterest.activity.create.fragment.view.CreateBoardListHeaderRepin;
import com.pinterest.api.model.Pin;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            FastRepinFragment

class this._cls0 extends com.pinterest.api.remote.e
{

    final FastRepinFragment this$0;

    public void onSuccess(Pin pin)
    {
        super.onSuccess(pin);
        setPin(pin);
        class _cls1
            implements Runnable
        {

            final FastRepinFragment._cls5 this$1;

            public void run()
            {
                FastRepinFragment.access$300(this$0);
            }

            _cls1()
            {
                this$1 = FastRepinFragment._cls5.this;
                super();
            }
        }

        if (isAdded())
        {
            _fastRepinDup.post(new _cls1());
        }
    }

    HeaderRepin()
    {
        this$0 = FastRepinFragment.this;
        super();
    }
}
