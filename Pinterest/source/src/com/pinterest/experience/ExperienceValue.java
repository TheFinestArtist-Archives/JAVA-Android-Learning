// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.experience;

import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.ExperiencesApi;
import com.pinterest.base.CrashReporting;
import com.pinterest.schemas.experiences.ExperienceType;

// Referenced classes of package com.pinterest.experience:
//            Experiences, NuxDisplayData, SurveyDisplayData, DisplayData, 
//            DisplayDataBase

public class ExperienceValue
{

    public PinterestJsonArray a;
    public int b;
    public int c;
    public String d;
    public String e;
    public DisplayDataBase f;
    public PinterestJsonObject g;
    private ApiResponseHandler h;

    public ExperienceValue(PinterestJsonObject pinterestjsonobject)
    {
label0:
        {
            super();
            h = new _cls1();
            if (pinterestjsonobject != null)
            {
                g = pinterestjsonobject;
                a = pinterestjsonobject.e("triggerable_placed_exps");
                b = pinterestjsonobject.a("experience_id", 0);
                c = pinterestjsonobject.a("type", 0);
                d = pinterestjsonobject.a("id", "");
                if (d != null)
                {
                    e = d.split(":")[0];
                }
                pinterestjsonobject = pinterestjsonobject.c("display_data");
                if (pinterestjsonobject != null && pinterestjsonobject.b() > 0)
                {
                    if (!Experiences.b.equalsIgnoreCase(e))
                    {
                        break label0;
                    }
                    f = new NuxDisplayData(pinterestjsonobject);
                }
            }
            return;
        }
        if (c == ExperienceType.SURVEY.getValue())
        {
            f = new SurveyDisplayData(pinterestjsonobject);
            return;
        } else
        {
            f = new DisplayData(pinterestjsonobject);
            return;
        }
    }

    public static ExperienceValue a(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return null;
        } else
        {
            return new ExperienceValue(pinterestjsonobject);
        }
    }

    public static void a(PinterestJsonArray pinterestjsonarray)
    {
        if (pinterestjsonarray != null && pinterestjsonarray.a() != 0)
        {
            int i = 0;
            while (i < pinterestjsonarray.a()) 
            {
                try
                {
                    ExperiencesApi.a(pinterestjsonarray.a(i));
                }
                catch (Exception exception)
                {
                    CrashReporting.logHandledException(exception);
                }
                i++;
            }
        }
    }

    public final void a()
    {
        ExperiencesApi.a(d, h);
    }

    public final void b()
    {
        Experiences.c(e);
        a();
    }

    public final void c()
    {
        ExperiencesApi.b(d, h);
    }

    public final void d()
    {
        Experiences.c(e);
        c();
    }

    private class _cls1 extends ApiResponseHandler
    {

        final ExperienceValue a;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            Experiences.c().d();
        }

        _cls1()
        {
            a = ExperienceValue.this;
            super();
        }
    }

}
