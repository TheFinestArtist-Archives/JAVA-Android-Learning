// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat

class <init>
    implements android.content.tener, 
{

    private ListAdapter mListAdapter;
    private AlertDialog mPopup;
    private CharSequence mPrompt;
    final SpinnerCompat this$0;

    public void dismiss()
    {
        if (mPopup != null)
        {
            mPopup.dismiss();
            mPopup = null;
        }
    }

    public Drawable getBackground()
    {
        return null;
    }

    public CharSequence getHintText()
    {
        return mPrompt;
    }

    public int getHorizontalOffset()
    {
        return 0;
    }

    public int getVerticalOffset()
    {
        return 0;
    }

    public boolean isShowing()
    {
        if (mPopup != null)
        {
            return mPopup.isShowing();
        } else
        {
            return false;
        }
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        setSelection(i);
        if (mOnItemClickListener != null)
        {
            performItemClick(null, i, mListAdapter.getItemId(i));
        }
        dismiss();
    }

    public void setAdapter(ListAdapter listadapter)
    {
        mListAdapter = listadapter;
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        Log.e("Spinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    public void setHorizontalOffset(int i)
    {
        Log.e("Spinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    public void setPromptText(CharSequence charsequence)
    {
        mPrompt = charsequence;
    }

    public void setVerticalOffset(int i)
    {
        Log.e("Spinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    public void show()
    {
        if (mListAdapter == null)
        {
            return;
        }
        android.app.kListener klistener = new android.app.(getContext());
        if (mPrompt != null)
        {
            klistener.le(mPrompt);
        }
        mPopup = klistener.gleChoiceItems(mListAdapter, getSelectedItemPosition(), this).();
        mPopup.show();
    }

    private ()
    {
        this$0 = SpinnerCompat.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
