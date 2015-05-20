// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

final class refreshDecorView
{

    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;

    final void applyFrozenState()
    {
        if (menu != null && frozenMenuState != null)
        {
            menu.b(frozenMenuState);
            frozenMenuState = null;
        }
    }

    public final void clearMenuPresenters()
    {
        if (menu != null)
        {
            menu.b(listMenuPresenter);
        }
        listMenuPresenter = null;
    }

    final MenuView getListMenuView(android.support.v7.internal.view.menu.er er)
    {
        if (menu == null)
        {
            return null;
        }
        if (listMenuPresenter == null)
        {
            listMenuPresenter = new ListMenuPresenter(listPresenterContext, android.support.v7.appcompat.esenterContext);
            listMenuPresenter.setCallback(er);
            menu.a(listMenuPresenter);
        }
        return listMenuPresenter.getMenuView(decorView);
    }

    public final boolean hasPanelItems()
    {
        while (shownPanelView == null || listMenuPresenter.a().getCount() <= 0) 
        {
            return false;
        }
        return true;
    }

    final void onRestoreInstanceState(Parcelable parcelable)
    {
        class SavedState
            implements Parcelable
        {

            public static final android.os.Parcelable.Creator CREATOR = new _cls1();
            int featureId;
            boolean isOpen;
            Bundle menuState;

            private static SavedState readFromParcel(Parcel parcel)
            {
                boolean flag = true;
                SavedState savedstate = new SavedState();
                savedstate.featureId = parcel.readInt();
                if (parcel.readInt() != 1)
                {
                    flag = false;
                }
                savedstate.isOpen = flag;
                if (savedstate.isOpen)
                {
                    savedstate.menuState = parcel.readBundle();
                }
                return savedstate;
            }

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
                parcel.writeInt(featureId);
                if (isOpen)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                parcel.writeInt(i);
                if (isOpen)
                {
                    parcel.writeBundle(menuState);
                }
            }



            private SavedState()
            {
            }

            SavedState(ActionBarActivityDelegateBase._cls1 _pcls1)
            {
                this();
            }

            class _cls1
                implements android.os.Parcelable.Creator
            {

                public final SavedState createFromParcel(Parcel parcel)
                {
                    return SavedState.readFromParcel(parcel);
                }

                public final volatile Object createFromParcel(Parcel parcel)
                {
                    return createFromParcel(parcel);
                }

                public final SavedState[] newArray(int i)
                {
                    return new SavedState[i];
                }

                public final volatile Object[] newArray(int i)
                {
                    return newArray(i);
                }

                        _cls1()
                        {
                        }
            }

        }

        parcelable = (SavedState)parcelable;
        featureId = ((SavedState) (parcelable)).featureId;
        wasLastOpen = ((SavedState) (parcelable)).isOpen;
        frozenMenuState = ((SavedState) (parcelable)).menuState;
        shownPanelView = null;
        decorView = null;
    }

    final Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(null);
        savedstate.featureId = featureId;
        savedstate.isOpen = isOpen;
        if (menu != null)
        {
            savedstate.menuState = new Bundle();
            menu.a(savedstate.menuState);
        }
        return savedstate;
    }

    final void setMenu(MenuBuilder menubuilder)
    {
        if (menubuilder != menu)
        {
            if (menu != null)
            {
                menu.b(listMenuPresenter);
            }
            menu = menubuilder;
            if (menubuilder != null && listMenuPresenter != null)
            {
                menubuilder.a(listMenuPresenter);
                return;
            }
        }
    }

    final void setStyle(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        android.content.res.te te = context.getResources().newTheme();
        te.te(context.getTheme());
        te.te(android.support.v7.appcompat.nuPresenter, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        }
        te.te(android.support.v7.appcompat.nuPresenter, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        } else
        {
            te.te(android.support.v7.appcompat.nuPresenter, true);
        }
        context = new ContextThemeWrapper(context, 0);
        context.getTheme().te(te);
        listPresenterContext = context;
    }

    SavedState(int i)
    {
        featureId = i;
        refreshDecorView = false;
    }
}
