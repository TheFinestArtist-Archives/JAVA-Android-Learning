// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.megaphone;

import com.pinterest.activity.invitefriend.InviteUtil;
import com.pinterest.activity.task.fragment.AdapterViewFragment;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.ExperiencesApi;
import com.pinterest.base.Events;
import com.pinterest.experience.DisplayData;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.schemas.experiences.Experience;

// Referenced classes of package com.pinterest.ui.megaphone:
//            BaseNagEvent, MegaphoneView

public class NagUtils
{

    private static final int DEFAULT_NAG_DELAY = 500;
    private static final boolean NAG_TESTING = false;

    public NagUtils()
    {
    }

    public static void postEventForExperience(ExperienceValue experiencevalue, BaseNagEvent basenagevent)
    {
        if (experiencevalue != null)
        {
            DisplayData displaydata = (DisplayData)experiencevalue.f;
            basenagevent.expValue = experiencevalue;
            basenagevent.displayData = displaydata;
            if (basenagevent.displayData != null)
            {
                Events.postDelayed(basenagevent, 500L);
                return;
            }
        }
    }

    public static void showNag(String s, BaseNagEvent basenagevent)
    {
        showNag(s, basenagevent, 0);
    }

    public static void showNag(String s, BaseNagEvent basenagevent, int i)
    {
        postEventForExperience(Experiences.b(s), basenagevent);
    }

    public static void showNagFromEvent(AdapterViewFragment adapterviewfragment, final MegaphoneView nag, BaseNagEvent basenagevent)
    {
        if (!nag.isShown())
        {
            final android.support.v4.app.FragmentActivity context = adapterviewfragment.getActivity();
            final ExperienceValue expValue = basenagevent.expValue;
            ExperiencesApi.b(expValue.d);
            final DisplayData displayData = basenagevent.displayData;
            nag.setBackgroundType(displayData.i);
            nag.setStyleByDisplayType(displayData.i);
            nag.setTitle(displayData.j);
            nag.setDesc(displayData.k);
            nag.setEnableAnimation(basenagevent.enableAnimation);
            nag.setPositiveButton(displayData.c, new _cls1());
            nag.setNegativeButton(displayData.a, new _cls2());
            nag.show();
            if (adapterviewfragment.isActive() && !nag.isViewed())
            {
                nag.setViewed(expValue.e);
                return;
            }
        }
    }

    public static void showNagTest(String s, BaseNagEvent basenagevent, int i)
    {
        PinterestJsonObject pinterestjsonobject = Experiences.a(i);
        if (pinterestjsonobject == null)
        {
            return;
        } else
        {
            postEventForExperience(ExperienceValue.a(pinterestjsonobject.c(s)), basenagevent);
            return;
        }
    }

    private static void trackNagButtonClick(ExperienceValue experiencevalue)
    {
        if (experiencevalue.b == Experience.ANDROID_NAG_INVITER.getValue() || experiencevalue.b == Experience.ANDROID_NAG_PINVITATIONAL.getValue())
        {
            InviteUtil.setInviteSource((new StringBuilder("nag_")).append(experiencevalue.b).toString());
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final Context val$context;
        final DisplayData val$displayData;
        final ExperienceValue val$expValue;
        final MegaphoneView val$nag;

        public final void onClick(View view)
        {
            AnalyticsApi.b(String.format("%s%s_%d", new Object[] {
                "NAG_BT2_", expValue.e, Integer.valueOf(expValue.b)
            }));
            if (!TextUtils.isEmpty(displayData.d))
            {
                Location.navigateUri(context, displayData.d);
                NagUtils.trackNagButtonClick(expValue);
            }
            if (ExperienceCompleteAction.COMPLETE.equals(displayData.h))
            {
                expValue.a();
                nag.hide();
                Experiences.c(expValue.e);
                return;
            }
            if (ExperienceCompleteAction.COMPLETE_AND_SHOW.equals(displayData.h))
            {
                expValue.a();
                return;
            }
            if (ExperienceCompleteAction.DONT_COMPLETE_AND_HIDE.equals(displayData.h))
            {
                nag.hide();
                Experiences.c(expValue.e);
                return;
            } else
            {
                ExperienceCompleteAction.DONT_COMPLETE_AND_SHOW.equals(displayData.h);
                return;
            }
        }

        _cls1()
        {
            expValue = experiencevalue;
            displayData = displaydata;
            context = context1;
            nag = megaphoneview;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final Context val$context;
        final DisplayData val$displayData;
        final ExperienceValue val$expValue;
        final MegaphoneView val$nag;

        public final void onClick(View view)
        {
            AnalyticsApi.b(String.format("%s%s_%d", new Object[] {
                "NAG_BT1_", expValue.e, Integer.valueOf(expValue.b)
            }));
            if (TextUtils.isEmpty(displayData.b))
            {
                expValue.c();
                Experiences.c(expValue.e);
                return;
            } else
            {
                nag.setDismissable(false);
                Location.navigateUri(context, displayData.b);
                return;
            }
        }

        _cls2()
        {
            expValue = experiencevalue;
            displayData = displaydata;
            nag = megaphoneview;
            context = context1;
            super();
        }
    }

}
