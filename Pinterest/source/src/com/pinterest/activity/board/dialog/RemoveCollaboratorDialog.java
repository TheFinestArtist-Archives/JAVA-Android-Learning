// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.kit.application.Resources;

public class RemoveCollaboratorDialog extends BaseDialog
{

    private static final String INVITED_USER_UID = "_invitedUserUid";
    CheckBox _blockCb;
    TextView _blockDesc;
    private View _container;
    private User _invitedUser;

    public RemoveCollaboratorDialog()
    {
        this(null);
    }

    public RemoveCollaboratorDialog(User user)
    {
        Bundle bundle = getArguments();
        if (user == null && bundle != null)
        {
            _invitedUser = ModelHelper.getUser(bundle.getString("_invitedUserUid"));
        } else
        if (user != null)
        {
            (new Bundle()).putString("_invitedUserUid", user.getUid());
            _invitedUser = user;
            return;
        }
    }

    public void init()
    {
        ButterKnife.a(this, _container);
    }

    public boolean isBlockedCbChecked()
    {
        return _blockCb.isChecked();
    }

    public void make(LayoutInflater layoutinflater)
    {
        if (getContext() == null)
        {
            return;
        } else
        {
            _container = LayoutInflater.from(getActivity()).inflate(0x7f030040, null);
            setContent(_container, 0);
            super.make(layoutinflater);
            init();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (_invitedUser == null)
        {
            dismiss();
            return;
        } else
        {
            bundle = _invitedUser.getFirstName();
            setTitle(Resources.string(0x7f0e03de, new Object[] {
                _invitedUser.getFullName()
            }));
            setSubTitle(0x7f0e03dd);
            _blockCb.setText(Resources.string(0x7f0e005a, new Object[] {
                bundle
            }));
            _blockDesc.setText(Resources.string(0x7f0e005b, new Object[] {
                bundle
            }));
            setNegativeButton(0x7f0e008f, null);
            return;
        }
    }
}
