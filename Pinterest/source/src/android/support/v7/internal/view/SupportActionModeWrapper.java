// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class SupportActionModeWrapper extends ActionMode
{

    final Context mContext;
    final android.support.v7.view.ActionMode mWrappedObject;

    public SupportActionModeWrapper(Context context, android.support.v7.view.ActionMode actionmode)
    {
        mContext = context;
        mWrappedObject = actionmode;
    }

    public void finish()
    {
        mWrappedObject.finish();
    }

    public View getCustomView()
    {
        return mWrappedObject.getCustomView();
    }

    public Menu getMenu()
    {
        return MenuWrapperFactory.a(mContext, (SupportMenu)mWrappedObject.getMenu());
    }

    public MenuInflater getMenuInflater()
    {
        return mWrappedObject.getMenuInflater();
    }

    public CharSequence getSubtitle()
    {
        return mWrappedObject.getSubtitle();
    }

    public Object getTag()
    {
        return mWrappedObject.getTag();
    }

    public CharSequence getTitle()
    {
        return mWrappedObject.getTitle();
    }

    public boolean getTitleOptionalHint()
    {
        return mWrappedObject.getTitleOptionalHint();
    }

    public void invalidate()
    {
        mWrappedObject.invalidate();
    }

    public boolean isTitleOptional()
    {
        return mWrappedObject.isTitleOptional();
    }

    public void setCustomView(View view)
    {
        mWrappedObject.setCustomView(view);
    }

    public void setSubtitle(int i)
    {
        mWrappedObject.setSubtitle(i);
    }

    public void setSubtitle(CharSequence charsequence)
    {
        mWrappedObject.setSubtitle(charsequence);
    }

    public void setTag(Object obj)
    {
        mWrappedObject.setTag(obj);
    }

    public void setTitle(int i)
    {
        mWrappedObject.setTitle(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        mWrappedObject.setTitle(charsequence);
    }

    public void setTitleOptionalHint(boolean flag)
    {
        mWrappedObject.setTitleOptionalHint(flag);
    }
}
