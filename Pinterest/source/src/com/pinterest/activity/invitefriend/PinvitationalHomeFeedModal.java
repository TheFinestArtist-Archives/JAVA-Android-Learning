// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.ExperiencesApi;
import com.pinterest.experience.ExperienceValue;
import java.util.List;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalHomeFeedModalStep

public class PinvitationalHomeFeedModal
{

    private ExperienceValue _exp;
    private List _steps;

    public PinvitationalHomeFeedModal(ExperienceValue experiencevalue)
    {
        _exp = experiencevalue;
        if (experiencevalue != null && experiencevalue.g != null)
        {
            parse(experiencevalue.g);
        }
    }

    private void parse(PinterestJsonObject pinterestjsonobject)
    {
        pinterestjsonobject = pinterestjsonobject.c("display_data");
        if (pinterestjsonobject == null || pinterestjsonobject.b() == 0)
        {
            return;
        } else
        {
            _steps = PinvitationalHomeFeedModalStep.makeAll(pinterestjsonobject.e("steps"));
            return;
        }
    }

    public void complete()
    {
        _exp.b();
    }

    public void dismiss()
    {
        _exp.d();
    }

    public ExperienceValue getExperienceValue()
    {
        return _exp;
    }

    public List getSteps()
    {
        return _steps;
    }

    public boolean isEmpty()
    {
        return _steps == null || _steps.size() == 0;
    }

    public void viewed()
    {
        ExperiencesApi.b(_exp.d);
    }
}
