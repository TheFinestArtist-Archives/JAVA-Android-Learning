// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.education.model;

import android.os.Handler;
import android.os.Looper;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.schemas.experiences.EducationTriggerType;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.pinterest.activity.task.education.model:
//            EducationStep, EducationFlyout

public class Education
{

    public static final int DELAY = 2000;
    public static final int DELAY_SHORT = 1000;
    private static Handler sHandler;
    private String _eid;
    private EducationFlyout _flyout;
    private String _id;
    private boolean _isAutomatic;
    private boolean _isEmpty;
    private boolean _isFlyout;
    private boolean _isTriggered;
    private String _pid;
    private List _steps;
    private PinterestJsonArray _triggerable;

    public Education(PinterestJsonObject pinterestjsonobject)
    {
        _steps = Collections.EMPTY_LIST;
        parse(pinterestjsonobject);
    }

    public Education(PinterestJsonObject pinterestjsonobject, String s)
    {
        _steps = Collections.EMPTY_LIST;
        parse(pinterestjsonobject.c(s));
    }

    public static Handler getHandler()
    {
        if (sHandler == null)
        {
            sHandler = new Handler(Looper.getMainLooper());
        }
        return sHandler;
    }

    private void parse(PinterestJsonObject pinterestjsonobject)
    {
        PinterestJsonObject pinterestjsonobject1;
        boolean flag1;
        flag1 = true;
        if (pinterestjsonobject == null)
        {
            return;
        }
        _id = pinterestjsonobject.a("id", "");
        if (_id != null)
        {
            _pid = _id.split(":")[0];
        }
        _eid = pinterestjsonobject.a("experience_id", "");
        pinterestjsonobject1 = pinterestjsonobject.c("display_data");
        if (pinterestjsonobject1 != null && pinterestjsonobject1.b() != 0) goto _L2; else goto _L1
_L1:
        _isEmpty = true;
_L4:
        _triggerable = pinterestjsonobject.e("triggerable_placed_exps");
        ExperienceValue.a(_triggerable);
        return;
_L2:
        _isEmpty = false;
        int i = pinterestjsonobject1.a("trigger", 0);
        boolean flag;
        if (i == EducationTriggerType.AUTOMATIC.getValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _isAutomatic = flag;
        if (i == EducationTriggerType.FLYOUT.getValue())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        _isFlyout = flag;
        _isTriggered = _isAutomatic;
        _steps = EducationStep.makeAll(pinterestjsonobject1.e("steps"));
        if (_isFlyout)
        {
            _flyout = new EducationFlyout(pinterestjsonobject1.a("flyout_text", ""));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void removeCallbacks(Runnable runnable)
    {
        getHandler().removeCallbacks(runnable);
    }

    public static void showDelayed(Runnable runnable)
    {
        showDelayed(runnable, 2000);
    }

    public static void showDelayed(Runnable runnable, int i)
    {
        getHandler().postDelayed(runnable, i);
    }

    public String getEid()
    {
        return _eid;
    }

    public ExperienceValue getExperienceValue()
    {
        return Experiences.a(_pid);
    }

    public EducationFlyout getFlyout()
    {
        return _flyout;
    }

    public String getId()
    {
        return _id;
    }

    public String getPid()
    {
        return _pid;
    }

    public List getSteps()
    {
        return _steps;
    }

    public boolean isAutomatic()
    {
        return _isAutomatic;
    }

    public boolean isEmpty()
    {
        return _isEmpty;
    }

    public boolean isFlyout()
    {
        return _isFlyout;
    }

    public boolean isTriggered()
    {
        return _isTriggered;
    }

    public void setIsFlyout(boolean flag)
    {
        _isFlyout = flag;
    }

    public void setTriggered(boolean flag)
    {
        _isTriggered = flag;
    }
}
