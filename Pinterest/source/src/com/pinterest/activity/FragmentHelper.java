// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.kit.activity.DialogHostActivity;
import com.pinterest.ui.ViewHelper;

public class FragmentHelper
{

    public FragmentHelper()
    {
    }

    public static void addFragment(FragmentManager fragmentmanager, int i, Fragment fragment)
    {
        fragmentmanager = getFragmentTransaction(fragmentmanager, Animation.DEFAULT);
        fragmentmanager.add(i, fragment);
        fragmentmanager.commit();
    }

    public static int getCloseupWidth(View view)
    {
        int j = (int)Device.getScreenWidth();
        int i = j;
        if (Device.isTablet())
        {
            i = j;
            if (view != null)
            {
                i = j;
                if (Device.isLandscape())
                {
                    i = (int)((float)j * 0.7F);
                }
            }
        }
        return i;
    }

    public static int getDesiredWidth()
    {
        int j = (int)Device.getScreenWidth();
        int i = j;
        if (Device.hasBigScreen())
        {
            if (Device.isLandscape())
            {
                i = (int)((float)j * 0.7F);
            } else
            {
                i = j;
                if (!Device.isTablet())
                {
                    return j - Constants.MARGIN * 2;
                }
            }
        }
        return i;
    }

    private static FragmentTransaction getFragmentTransaction(FragmentManager fragmentmanager, Animation animation)
    {
        fragmentmanager = fragmentmanager.beginTransaction();
        if (fragmentmanager != null)
        {
            if (animation == Animation.FADE)
            {
                fragmentmanager.setCustomAnimations(0x7f04000a, 0x7f04000e, 0x7f040007, 0x7f040008);
            } else
            {
                if (animation == Animation.SLIDE)
                {
                    fragmentmanager.setCustomAnimations(0x7f040019, 0x7f04001b, 0x7f040015, 0x7f040016);
                    return fragmentmanager;
                }
                if (animation == Animation.MODAL)
                {
                    fragmentmanager.setCustomAnimations(0x7f040017, 0x7f04001a, 0x7f040017, 0x7f04001a);
                    return fragmentmanager;
                }
                if (animation == Animation.DEFAULT)
                {
                    fragmentmanager.setCustomAnimations(0x7f040009, 0x7f04000d, 0x7f040007, 0x7f040008);
                    return fragmentmanager;
                }
                if (animation == Animation.MODAL_OUT)
                {
                    fragmentmanager.setCustomAnimations(0, 0, 0, 0x7f04001a);
                    return fragmentmanager;
                }
            }
        }
        return fragmentmanager;
    }

    public static boolean isActivityVisible(Fragment fragment)
    {
        if (fragment == null)
        {
            return false;
        }
        fragment = fragment.getActivity();
        if (fragment instanceof DialogHostActivity)
        {
            return ((DialogHostActivity)fragment).isVisible();
        } else
        {
            return true;
        }
    }

    public static void removeFragment(FragmentManager fragmentmanager, Fragment fragment)
    {
        fragmentmanager = getFragmentTransaction(fragmentmanager, Animation.DEFAULT);
        fragmentmanager.remove(fragment);
        fragmentmanager.commit();
    }

    public static void replaceFragment(Fragment fragment, int i, Fragment fragment1, boolean flag)
    {
        replaceFragment(fragment, i, fragment1, flag, Animation.DEFAULT);
    }

    public static void replaceFragment(Fragment fragment, int i, Fragment fragment1, boolean flag, Animation animation)
    {
        replaceFragment(fragment.getChildFragmentManager(), i, fragment1, flag, animation);
    }

    public static void replaceFragment(Fragment fragment, Fragment fragment1, boolean flag)
    {
        replaceFragment(fragment, 0x7f0b006a, fragment1, flag);
    }

    public static void replaceFragment(FragmentActivity fragmentactivity, Fragment fragment, boolean flag)
    {
        replaceFragment(fragmentactivity.getSupportFragmentManager(), 0x7f0b006a, fragment, flag, Animation.DEFAULT);
    }

    public static void replaceFragment(FragmentActivity fragmentactivity, Fragment fragment, boolean flag, Animation animation)
    {
        replaceFragment(fragmentactivity.getSupportFragmentManager(), 0x7f0b006a, fragment, flag, animation);
    }

    public static void replaceFragment(FragmentManager fragmentmanager, int i, Fragment fragment, boolean flag, Animation animation)
    {
        animation = getFragmentTransaction(fragmentmanager, animation);
        fragmentmanager = fragmentmanager.findFragmentById(i);
        if (fragment == null || !isActivityVisible(fragment)) goto _L2; else goto _L1
_L1:
        animation.replace(i, fragment);
_L4:
        if (flag)
        {
            animation.addToBackStack(null);
        }
        if (!animation.isEmpty())
        {
            animation.commit();
        }
        if (fragmentmanager instanceof BaseFragment)
        {
            ((BaseFragment)fragmentmanager).setActive(false);
        }
        if (fragment instanceof BaseFragment)
        {
            Pinalytics.a(fragment);
            ((BaseFragment)fragment).setActive(true);
        }
        return;
_L2:
        if (fragmentmanager != null && isActivityVisible(fragmentmanager))
        {
            animation.remove(fragmentmanager);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void replaceFragment(FragmentManager fragmentmanager, Fragment fragment, boolean flag)
    {
        replaceFragment(fragmentmanager, 0x7f0b006a, fragment, flag, Animation.DEFAULT);
    }

    public static void updateFragmentWidth(Activity activity)
    {
        if (activity != null && Device.hasBigScreen())
        {
            ViewHelper.updateViewWidth(activity.findViewById(0x7f0b006a), getDesiredWidth());
        }
    }

    private class Animation extends Enum
    {

        private static final Animation $VALUES[];
        public static final Animation DEFAULT;
        public static final Animation FADE;
        public static final Animation MODAL;
        public static final Animation MODAL_OUT;
        public static final Animation NONE;
        public static final Animation SLIDE;

        public static Animation valueOf(String s)
        {
            return (Animation)Enum.valueOf(com/pinterest/activity/FragmentHelper$Animation, s);
        }

        public static Animation[] values()
        {
            return (Animation[])$VALUES.clone();
        }

        static 
        {
            NONE = new Animation("NONE", 0);
            DEFAULT = new Animation("DEFAULT", 1);
            FADE = new Animation("FADE", 2);
            SLIDE = new Animation("SLIDE", 3);
            MODAL = new Animation("MODAL", 4);
            MODAL_OUT = new Animation("MODAL_OUT", 5);
            $VALUES = (new Animation[] {
                NONE, DEFAULT, FADE, SLIDE, MODAL, MODAL_OUT
            });
        }

        private Animation(String s, int i)
        {
            super(s, i);
        }
    }

}
