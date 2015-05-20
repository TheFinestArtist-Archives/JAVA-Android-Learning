// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.experience;

import android.content.Context;
import com.pinterest.activity.pin.adapter.SimpleTextListAdapter;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.base.Events;
import com.pinterest.schemas.experiences.Experience;
import com.pinterest.schemas.experiences.Placement;

// Referenced classes of package com.pinterest.experience:
//            Experiences, ExperienceValue, SurveyDisplayData

public class SurveyHelper
{

    private static boolean a = false;

    public static void a(Context context, Placement placement)
    {
        if (!a)
        {
            if ((placement = Experiences.a(String.valueOf(placement.getValue()))) != null)
            {
                ExperienceValue.a(((ExperienceValue) (placement)).a);
                if (((ExperienceValue) (placement)).b != Experience.NOOP.getValue())
                {
                    SurveyDisplayData surveydisplaydata = (SurveyDisplayData)((ExperienceValue) (placement)).f;
                    BaseDialog basedialog = new BaseDialog();
                    basedialog.setTitle(surveydisplaydata.j);
                    basedialog.setSubTitle(surveydisplaydata.a);
                    basedialog.setTitleText(surveydisplaydata.k);
                    String as[] = new String[surveydisplaydata.b.length];
                    for (int i = 0; i < as.length; i++)
                    {
                        as[i] = surveydisplaydata.b[i].a;
                    }

                    SimpleTextListAdapter simpletextlistadapter = new SimpleTextListAdapter(false);
                    simpletextlistadapter.setDataSource(as);
                    basedialog.setListViewOptions(simpletextlistadapter, new _cls1(surveydisplaydata, context, placement, basedialog));
                    Events.postDelayed(new DialogEvent(basedialog), 1000L);
                    a = true;
                    return;
                }
            }
        }
    }

    static boolean a()
    {
        a = false;
        return false;
    }


    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final SurveyDisplayData a;
        final Context b;
        final ExperienceValue c;
        final BaseDialog d;

        public final void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = a.b[i].b;
            if (!TextUtils.isEmpty(adapterview))
            {
                ActivityHelper.goIntentView(b, adapterview);
                c.a();
            } else
            {
                c.c();
            }
            AnalyticsApi.b(String.format("%s_%s_%d_%d", new Object[] {
                "SURVEY", c.e, Integer.valueOf(c.b), Integer.valueOf(i)
            }));
            Experiences.c(c.e);
            d.dismiss();
            SurveyHelper.a();
        }

        _cls1(SurveyDisplayData surveydisplaydata, Context context, ExperienceValue experiencevalue, BaseDialog basedialog)
        {
            a = surveydisplaydata;
            b = context;
            c = experiencevalue;
            d = basedialog;
            super();
        }
    }

}
