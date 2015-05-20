// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompat
{

    static final ViewParentCompatImpl IMPL;

    private ViewParentCompat()
    {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
    {
        return IMPL.requestSendAccessibilityEvent(viewparent, view, accessibilityevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new ViewParentCompatICSImpl();
        } else
        {
            IMPL = new ViewParentCompatStubImpl();
        }
    }

    private class ViewParentCompatImpl
    {

        public abstract boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent);
    }


    private class ViewParentCompatICSImpl extends ViewParentCompatStubImpl
    {
        private class ViewParentCompatStubImpl
            implements ViewParentCompatImpl
        {

            public boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
            {
                if (view == null)
                {
                    return false;
                } else
                {
                    ((AccessibilityManager)view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityevent);
                    return true;
                }
            }

            ViewParentCompatStubImpl()
            {
            }
        }


        public boolean requestSendAccessibilityEvent(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
        {
            return ViewParentCompatICS.requestSendAccessibilityEvent(viewparent, view, accessibilityevent);
        }

        ViewParentCompatICSImpl()
        {
        }
    }

}
