// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.education;

import com.pinterest.activity.task.education.event.EducationEvent;
import com.pinterest.activity.task.education.model.Education;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.base.Events;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.schemas.experiences.ExperienceType;
import com.pinterest.schemas.experiences.Placement;

public class EducationHelper
{

    private static int a;

    public static Runnable a(Placement placement)
    {
        return a(placement, null);
    }

    public static Runnable a(Placement placement, BaseFragment basefragment)
    {
        placement = Experiences.a(String.valueOf(placement.getValue()));
        if (placement == null || ((ExperienceValue) (placement)).c != ExperienceType.GUIDE.getValue())
        {
            return null;
        }
        placement = new Education(((ExperienceValue) (placement)).g);
        basefragment = new _cls1(basefragment, placement);
        int i;
        if (placement.isFlyout())
        {
            i = 0;
        } else
        {
            i = 2000;
        }
        Education.showDelayed(basefragment, i);
        return basefragment;
    }

    public static void a()
    {
        AnalyticsApi.b(String.format("AndroidEducationFlyout_%s", new Object[] {
            Integer.valueOf(a)
        }));
    }

    public static void a(int i)
    {
        AnalyticsApi.b(String.format("AndroidEducationStep_%d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    public static void a(Runnable runnable)
    {
        if (runnable != null)
        {
            Education.removeCallbacks(runnable);
        }
        Events.post(new EducationEvent(com.pinterest.activity.task.education.event.EducationEvent.Type.DISMISS_UI));
    }

    public static void a(String s)
    {
        if (s != null)
        {
            a = Integer.parseInt(s);
            return;
        } else
        {
            a = -1;
            return;
        }
    }

    public static int b()
    {
        return a;
    }

    public static void b(int i)
    {
        AnalyticsApi.b(String.format("AndroidEducationAnchor_%d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    private class _cls1
        implements Runnable
    {

        final BaseFragment a;
        final Education b;

        public final void run()
        {
            while (a != null && !a.isActive() || b.getEid().equals(String.valueOf(Experience.NOOP.getValue()))) 
            {
                return;
            }
            Events.post(new EducationEvent(b));
        }

        _cls1(BaseFragment basefragment, Education education)
        {
            a = basefragment;
            b = education;
            super();
        }
    }

}
