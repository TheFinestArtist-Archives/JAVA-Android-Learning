// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.dialog;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.kit.application.Resources;

// Referenced classes of package com.pinterest.activity.task.dialog:
//            BaseDialog

public class SimpleTextDialog extends BaseDialog
{

    protected String _text;
    TextView _textView;

    public SimpleTextDialog()
    {
    }

    public static SimpleTextDialog newInstance()
    {
        return new SimpleTextDialog();
    }

    private void updateTitle()
    {
        if (_textView != null)
        {
            _textView.setText(_text);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setContent(LayoutInflater.from(getActivity()).inflate(0x7f030067, null));
        ButterKnife.a(this, container);
        _textView.setMovementMethod(LinkMovementMethod.getInstance());
        updateTitle();
    }

    public void setText(int i)
    {
        setText(Resources.string(i));
    }

    public void setText(String s)
    {
        _text = s;
        updateTitle();
    }
}
