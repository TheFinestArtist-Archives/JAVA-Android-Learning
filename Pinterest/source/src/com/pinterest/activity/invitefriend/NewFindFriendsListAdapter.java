// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.board.view.PersonListCell;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.actionsheet.ActionSheetFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            FriendSearchAdapter

public class NewFindFriendsListAdapter extends FriendSearchAdapter
{

    private ActionSheetFragment _actionSheet;
    private String _apiTag;
    private Context _context;
    private android.view.View.OnClickListener _onInviteClickListener;

    public NewFindFriendsListAdapter(Context context, ActionSheetFragment actionsheetfragment)
    {
        super(context);
        _onInviteClickListener = new _cls1();
        _context = context;
        _actionSheet = actionsheetfragment;
    }

    public List getContactList()
    {
        Object obj = new HashMap();
        for (Iterator iterator = getEmailContactList(500).iterator(); iterator.hasNext();)
        {
            TypeAheadItem typeaheaditem = (TypeAheadItem)iterator.next();
            if (((HashMap) (obj)).containsKey(typeaheaditem.getUid()))
            {
                ((TypeAheadItem)((HashMap) (obj)).get(typeaheaditem.getUid())).addEmail(typeaheaditem.getIdentifier());
            } else
            {
                typeaheaditem.addEmail(typeaheaditem.getIdentifier());
                ((HashMap) (obj)).put(typeaheaditem.getUid(), typeaheaditem);
            }
        }

        for (Iterator iterator1 = getPhoneContactList(500).iterator(); iterator1.hasNext();)
        {
            TypeAheadItem typeaheaditem1 = (TypeAheadItem)iterator1.next();
            if (((HashMap) (obj)).containsKey(typeaheaditem1.getUid()))
            {
                ((TypeAheadItem)((HashMap) (obj)).get(typeaheaditem1.getUid())).addPhoneNumber(typeaheaditem1.getIdentifier());
            } else
            {
                typeaheaditem1.addPhoneNumber(typeaheaditem1.getIdentifier());
                ((HashMap) (obj)).put(typeaheaditem1.getUid(), typeaheaditem1);
            }
        }

        obj = new ArrayList(((HashMap) (obj)).values());
        Collections.sort(((List) (obj)));
        return ((List) (obj));
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        viewgroup = ((ViewGroup) (getItem(i)));
        if (!(viewgroup instanceof TypeAheadItem) || !(view instanceof PersonListCell))
        {
            return view;
        } else
        {
            viewgroup = (TypeAheadItem)viewgroup;
            PersonListCell personlistcell = (PersonListCell)view;
            personlistcell.setActionButtonTag(viewgroup);
            personlistcell.setActionButton(Resources.string(0x7f0e029b), _onInviteClickListener);
            personlistcell.setActionButtonStyle(com.pinterest.ui.text.PButton.ButtonStyle.RED);
            personlistcell.setTag(viewgroup);
            personlistcell.setOnClickListener(_onInviteClickListener);
            return view;
        }
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }




    private class _cls1
        implements android.view.View.OnClickListener
    {

        final NewFindFriendsListAdapter this$0;

        public void onClick(final View item)
        {
            Device.hideSoftKeyboard(item);
            item = ((View) (item.getTag()));
            if (!(item instanceof TypeAheadItem))
            {
                return;
            }
            item = (TypeAheadItem)item;
            _actionSheet.clear();
            _actionSheet.addHeader(Resources.string(0x7f0e02a0));
            _actionSheet.addFooter(Resources.string(0x7f0e02a1));
            class _cls1
                implements android.view.View.OnClickListener
            {

                final _cls1 this$1;
                final TypeAheadItem val$item;

                public void onClick(View view)
                {
                    _actionSheet.dismiss();
                    Events.post(new ToastEvent(new BulkInviteSendToast(new InviteFriendEvent(item.getIdentifier()), false)));
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    item = typeaheaditem;
                    super();
                }
            }

            String s;
            for (Iterator iterator = item.getEmails().iterator(); iterator.hasNext(); _actionSheet.addItem(s, new _cls1()))
            {
                s = (String)iterator.next();
            }

            class _cls2
                implements android.view.View.OnClickListener
            {

                final _cls1 this$1;
                final TypeAheadItem val$item;

                public void onClick(View view)
                {
                    _actionSheet.dismiss();
                    InviteUtil.inviteUserSMS((Activity)_context, item.getTitle(), item.getIdentifier(), _apiTag);
                }

                _cls2()
                {
                    this$1 = _cls1.this;
                    item = typeaheaditem;
                    super();
                }
            }

            String s1;
            for (Iterator iterator1 = item.getPhoneNumbers().iterator(); iterator1.hasNext(); _actionSheet.addItem(s1, new _cls2()))
            {
                s1 = (String)iterator1.next();
            }

            _actionSheet.show();
        }

        _cls1()
        {
            this$0 = NewFindFriendsListAdapter.this;
            super();
        }
    }

}
