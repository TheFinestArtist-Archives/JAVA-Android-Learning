// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.education.view;

import com.pinterest.activity.home.events.PageChangedEvent;
import com.pinterest.activity.task.education.event.EducationEvent;
import com.pinterest.activity.task.education.model.Education;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;

// Referenced classes of package com.pinterest.activity.task.education.view:
//            EducationContainerView, EducationFlyoutView

class this._cls0 extends com.pinterest.base.ducationContainerView._cls5
{

    final EducationContainerView this$0;

    public void onEventMainThread(PageChangedEvent pagechangedevent)
    {
        if (!EducationContainerView.access$700(EducationContainerView.this))
        {
            EducationContainerView.access$800(EducationContainerView.this).updateLocationState();
            EducationContainerView.access$500(EducationContainerView.this);
        }
    }

    public void onEventMainThread(EducationEvent educationevent)
    {
        switch (.SwitchMap.com.pinterest.activity.task.education.event.EducationEvent.Type[educationevent.getType().al()])
        {
        default:
            return;

        case 1: // '\001'
            EducationHelper.a(educationevent.getEducation().getEid());
            EducationContainerView.access$200(EducationContainerView.this, educationevent.getEducation(), educationevent);
            return;

        case 2: // '\002'
            EducationContainerView.access$300(EducationContainerView.this);
            return;

        case 3: // '\003'
            EducationContainerView.access$400(EducationContainerView.this);
            EducationHelper.a(null);
            return;

        case 4: // '\004'
            EducationContainerView.access$500(EducationContainerView.this);
            EducationHelper.a(null);
            return;

        case 5: // '\005'
            suspend();
            break;
        }
        EducationHelper.a(null);
    }

    public void onEventMainThread(Navigation navigation)
    {
        if (!EducationContainerView.access$700(EducationContainerView.this))
        {
            EducationContainerView.access$800(EducationContainerView.this).updateLocationState();
            EducationContainerView.access$500(EducationContainerView.this);
        }
    }

    public void onEventMainThread(com.pinterest.activity.task.view.Event event)
    {
        if (!EducationContainerView.access$700(EducationContainerView.this))
        {
            EducationContainerView.access$800(EducationContainerView.this).updateLocationState();
            EducationContainerView.access$500(EducationContainerView.this);
        }
    }

    public void onEventMainThread(com.pinterest.activity.task.view.ent ent)
    {
        switch (ent.getState())
        {
        default:
            return;

        case 0: // '\0'
            setClickable(false);
            break;
        }
        Events.unregister(EducationContainerView.access$600(EducationContainerView.this), new Class[] {
            com/pinterest/activity/task/view/MainViewPager$PageStateEvent
        });
        EducationContainerView.access$100(EducationContainerView.this);
    }

    I()
    {
        this$0 = EducationContainerView.this;
        super();
    }
}
