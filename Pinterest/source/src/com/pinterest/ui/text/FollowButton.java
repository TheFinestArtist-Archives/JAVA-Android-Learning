// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.pinterest.kit.application.Resources;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pinterest.ui.text:
//            PButton

public abstract class FollowButton extends PButton
    implements android.view.View.OnClickListener
{

    private String _followLbl;
    private String _followingLbl;
    protected WeakReference _progressView;
    protected PButton.ButtonStyle _styleFollowing;
    protected PButton.ButtonStyle _styleNotFollowing;

    public FollowButton(Context context)
    {
        super(context);
        _followingLbl = Resources.string(0x7f0e04c8);
        _followLbl = Resources.string(0x7f0e022e);
        init();
    }

    public FollowButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _followingLbl = Resources.string(0x7f0e04c8);
        _followLbl = Resources.string(0x7f0e022e);
        init();
    }

    public FollowButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _followingLbl = Resources.string(0x7f0e04c8);
        _followLbl = Resources.string(0x7f0e022e);
        init();
    }

    protected void init()
    {
        _styleFollowing = PButton.ButtonStyle.PLAIN;
        _styleNotFollowing = PButton.ButtonStyle.RED;
        setOnClickListener(this);
        updateDisplay();
    }

    protected abstract boolean isFollowing();

    public abstract void onClick(View view);

    public void setLoading(boolean flag)
    {
        View view;
        if (_progressView != null)
        {
            if ((view = (View)_progressView.get()) != null)
            {
                if (flag)
                {
                    view.setVisibility(0);
                    setVisibility(8);
                    return;
                } else
                {
                    view.setVisibility(8);
                    setVisibility(0);
                    return;
                }
            }
        }
    }

    public void setProgressView(View view)
    {
        if (view == null)
        {
            view = null;
        } else
        {
            view = new WeakReference(view);
        }
        _progressView = view;
    }

    public void setStyleFollowing(PButton.ButtonStyle buttonstyle)
    {
        _styleFollowing = buttonstyle;
        updateDisplay();
    }

    public void setStyleNotFollowing(PButton.ButtonStyle buttonstyle)
    {
        _styleNotFollowing = buttonstyle;
        updateDisplay();
    }

    protected void updateDisplay()
    {
        if (isFollowing())
        {
            setStyle(_styleFollowing);
            setText(_followingLbl);
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return;
        } else
        {
            setStyle(_styleNotFollowing);
            setText(_followLbl);
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return;
        }
    }
}
