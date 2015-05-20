// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.base.Events;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.schemas.experiences.Experience;
import com.pinterest.schemas.experiences.Placement;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalHomeFeedModal

public class PinvitationalHomeFeedModalHelper
{

    private static boolean _loadedFromFile = false;

    public PinvitationalHomeFeedModalHelper()
    {
    }

    private static void goToModal(ExperienceValue experiencevalue)
    {
        experiencevalue = new PinvitationalHomeFeedModal(experiencevalue);
        if (!experiencevalue.isEmpty())
        {
            Navigation navigation = new Navigation(Location.PINVITATIONAL_MODAL);
            navigation.putExtra("modal", experiencevalue);
            Events.post(navigation);
        }
    }

    public static void loadModal(Placement placement, BaseFragment basefragment)
    {
        if (basefragment == null || basefragment.isActive())
        {
            if ((placement = Experiences.a(String.valueOf(placement.getValue()))) != null && ((ExperienceValue) (placement)).b == Experience.ANDROID_PINVITATIONAL_HOME_FEED_MODAL.getValue())
            {
                goToModal(placement);
                return;
            }
        }
    }

    public static void loadModalFromFile(Placement placement, BaseFragment basefragment)
    {
        if (basefragment != null && !basefragment.isActive() || _loadedFromFile)
        {
            return;
        } else
        {
            goToModal(new ExperienceValue(Experiences.a(0x7f06000e)));
            _loadedFromFile = true;
            return;
        }
    }

}
