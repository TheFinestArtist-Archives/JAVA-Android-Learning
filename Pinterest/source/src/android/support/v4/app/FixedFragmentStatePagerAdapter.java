// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.app:
//            BetterFragmentStatePagerAdapter, Fragment, FragmentManager

public abstract class FixedFragmentStatePagerAdapter extends BetterFragmentStatePagerAdapter
{

    public FixedFragmentStatePagerAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (Fragment)super.instantiateItem(viewgroup, i);
        Bundle bundle = ((Fragment) (viewgroup)).mSavedFragmentState;
        if (bundle != null)
        {
            bundle.setClassLoader(viewgroup.getClass().getClassLoader());
        }
        return viewgroup;
    }

    public Parcelable saveState()
    {
        Parcelable parcelable;
        try
        {
            parcelable = super.saveState();
        }
        catch (IllegalStateException illegalstateexception)
        {
            return new Bundle();
        }
        return parcelable;
    }
}
