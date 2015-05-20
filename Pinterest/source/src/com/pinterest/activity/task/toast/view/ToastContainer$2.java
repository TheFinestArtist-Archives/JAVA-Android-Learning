// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast.view;


// Referenced classes of package com.pinterest.activity.task.toast.view:
//            ToastContainer

class this._cls0 extends com.pinterest.base.criber
{

    final ToastContainer this$0;

    public void onEventMainThread(com.pinterest.activity.task.view.eChangedEvent echangedevent)
    {
        ToastContainer.access$402(ToastContainer.this, echangedevent.getNavigation());
        for (int i = 0; i < getChildCount(); i++)
        {
            echangedevent = getChildAt(i);
            if (ToastContainer.access$000(ToastContainer.this, echangedevent))
            {
                ToastContainer.access$100(echangedevent);
            }
        }

    }

    edEvent()
    {
        this$0 = ToastContainer.this;
        super();
    }
}
