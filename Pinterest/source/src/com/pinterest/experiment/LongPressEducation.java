// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.experiment;

import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import java.util.Calendar;
import java.util.Date;

public class LongPressEducation
{

    private static Boolean a;

    public static boolean a()
    {
        if (a == null)
        {
            a = Boolean.valueOf(false);
            Object obj = MyUser.get();
            if (obj != null)
            {
                obj = ((User) (obj)).getCreatedAt();
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, -1);
                if (obj != null && calendar.getTime().compareTo(((Date) (obj))) > 0)
                {
                    a = Boolean.valueOf(Preferences.persisted().getBoolean("PREF_SHOW_PIN_CONTEXTMENU_EDU", true));
                }
            }
        }
        return a.booleanValue();
    }

    public static void b()
    {
        if (a == null || a.booleanValue())
        {
            a = Boolean.valueOf(false);
            Preferences.persisted().set("PREF_SHOW_PIN_CONTEXTMENU_EDU", false);
        }
    }
}
