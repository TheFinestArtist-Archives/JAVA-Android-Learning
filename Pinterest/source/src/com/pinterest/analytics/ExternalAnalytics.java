// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.base.CrashReporting;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.event.EventType;
import com.pinterest.schemas.event.ViewParameterType;
import com.pinterest.schemas.event.ViewType;

public class ExternalAnalytics
{

    public static void a(EventType eventtype)
    {
        if (eventtype != null)
        {
            eventtype = eventtype.toString();
        } else
        {
            eventtype = "";
        }
        eventtype = String.format("Event: %s", new Object[] {
            eventtype
        });
        try
        {
            CrashReporting.leaveBreadcrumb(eventtype);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EventType eventtype)
        {
            return;
        }
    }

    public static void a(EventType eventtype, ElementType elementtype, ComponentType componenttype)
    {
        if (eventtype != null)
        {
            eventtype = eventtype.toString();
        } else
        {
            eventtype = "";
        }
        if (elementtype != null)
        {
            elementtype = elementtype.toString();
        } else
        {
            elementtype = "";
        }
        if (componenttype != null)
        {
            componenttype = componenttype.toString();
        } else
        {
            componenttype = "";
        }
        eventtype = String.format("Action: %s Element: %s Component: %s", new Object[] {
            eventtype, elementtype, componenttype
        });
        try
        {
            CrashReporting.leaveBreadcrumb(eventtype);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EventType eventtype)
        {
            return;
        }
    }

    public static void a(ViewType viewtype, ViewParameterType viewparametertype)
    {
        if (viewtype != null)
        {
            viewtype = viewtype.toString();
        } else
        {
            viewtype = "";
        }
        if (viewparametertype != null)
        {
            viewparametertype = viewparametertype.toString();
        } else
        {
            viewparametertype = "";
        }
        viewtype = String.format("View Loaded: %s:%s", new Object[] {
            viewtype, viewparametertype
        });
        try
        {
            CrashReporting.leaveBreadcrumb(viewtype);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewType viewtype)
        {
            return;
        }
    }
}
