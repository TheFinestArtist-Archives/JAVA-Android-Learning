// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.board.view.PersonListCell;
import com.pinterest.activity.invitefriend.events.InviteCountChangeEvent;
import com.pinterest.activity.invitefriend.events.InviteFriendEvent;
import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.activity.task.event.ToastEvent;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.task.toast.BulkInviteSendToast;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.log.PLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            FriendSearchAdapter

public class InviteFriendAdapter extends FriendSearchAdapter
{

    private String _apiTag;
    private Set _inviteList;
    private Set _inviteSentList;
    private android.view.View.OnClickListener onInviteCheckBoxListener;
    private android.view.View.OnClickListener onInviteClickListener;

    public InviteFriendAdapter(Context context)
    {
        super(context);
        _inviteSentList = new HashSet();
        _inviteList = new HashSet();
        onInviteClickListener = new _cls1();
        onInviteCheckBoxListener = new _cls2();
    }

    public void addAllToInviteList()
    {
        List list = getEmailContactList(500);
        for (int i = 0; i < list.size(); i++)
        {
            addToInviteList((TypeAheadItem)list.get(i));
        }

    }

    public void addToInviteList(TypeAheadItem typeaheaditem)
    {
        if (typeaheaditem != null && typeaheaditem.getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_CONTACT)
        {
            _inviteList.add(typeaheaditem.getIdentifier());
            Events.post(new InviteCountChangeEvent(_inviteList.size()));
        }
    }

    public void bulkInvite()
    {
        boolean flag;
        if (getCount() == _inviteList.size())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bulkInvite(flag);
    }

    public void bulkInvite(boolean flag)
    {
        if (_inviteList.isEmpty())
        {
            Application.showToast(0x7f0e02a6);
            return;
        }
        HashSet hashset = new HashSet(_inviteList);
        if (Experiments.g())
        {
            Navigation navigation = new Navigation(Location.INVITE_FRIENDS_CONFIRM);
            navigation.putStringArrayListParcelable("invitees", new ArrayList(hashset));
            Events.post(navigation);
        } else
        {
            Events.post(new ToastEvent(new BulkInviteSendToast(new InviteFriendEvent(hashset), flag)));
        }
        PLog.a((new StringBuilder("INVITER _inviteSentList size ")).append(_inviteSentList.size()).toString(), new Object[0]);
    }

    public void clearInviteList()
    {
        _inviteList.clear();
    }

    public int getInviteListSize()
    {
        return _inviteList.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        PersonListCell personlistcell;
label0:
        {
label1:
            {
                view = super.getView(i, view, viewgroup);
                viewgroup = ((ViewGroup) (getItem(i)));
                if ((viewgroup instanceof TypeAheadItem) && (view instanceof PersonListCell))
                {
                    viewgroup = (TypeAheadItem)viewgroup;
                    personlistcell = (PersonListCell)view;
                    personlistcell.setTitle(viewgroup.getTitle());
                    if (viewgroup.getItemType() != com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_CONTACT)
                    {
                        break label1;
                    }
                    personlistcell.setActionCheckBoxTag(viewgroup);
                    if (_inviteSentList.contains(viewgroup.getIdentifier()))
                    {
                        break label0;
                    }
                    personlistcell.setActionCheckBox(_inviteList.contains(viewgroup.getIdentifier()), onInviteCheckBoxListener);
                }
                return view;
            }
            if (viewgroup.getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT)
            {
                personlistcell.setActionButtonTag(viewgroup);
                personlistcell.setActionButton(Resources.string(0x7f0e029b), onInviteClickListener);
                return view;
            }
        }
        personlistcell.setActionCheckBox(false, null);
        return view;
    }

    public void removeFromInviteList(TypeAheadItem typeaheaditem)
    {
        PLog.a((new StringBuilder("INVITER removeFromInviteList ")).append(typeaheaditem.getIdentifier()).toString(), new Object[0]);
        if (typeaheaditem != null)
        {
            _inviteList.remove(typeaheaditem.getIdentifier());
            Events.post(new InviteCountChangeEvent(_inviteList.size()));
        }
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }

    public void updateInviteList(InviteSendEvent invitesendevent)
    {
        if (invitesendevent.isCompleted())
        {
            _inviteSentList.addAll(invitesendevent.getInviteList());
        }
        String s;
        for (invitesendevent = invitesendevent.getInviteList().iterator(); invitesendevent.hasNext(); _inviteList.remove(s))
        {
            s = (String)invitesendevent.next();
        }

        refresh();
    }



    private class _cls1
        implements android.view.View.OnClickListener
    {

        final InviteFriendAdapter this$0;

        public void onClick(View view)
        {
label0:
            {
                Device.hideSoftKeyboard(view);
                view = ((View) (view.getTag()));
                if (view instanceof TypeAheadItem)
                {
                    view = (TypeAheadItem)view;
                    if (view.getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT && (!Experiments.g() || PinvitationalData.getQuotaLeft() > 0))
                    {
                        break label0;
                    }
                }
                return;
            }
            InviteUtil.inviteUserSMS((Activity)_context, view.getTitle(), view.getIdentifier(), _apiTag);
        }

        _cls1()
        {
            this$0 = InviteFriendAdapter.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final InviteFriendAdapter this$0;

        public void onClick(View view)
        {
            Object obj;
            Device.hideSoftKeyboard(view);
            obj = view.getTag();
            if (!(obj instanceof TypeAheadItem)) goto _L2; else goto _L1
_L1:
            obj = (TypeAheadItem)obj;
            view = (CheckBox)view;
            if (!Experiments.g() || !view.isChecked() || _inviteList.size() != PinvitationalData.getQuota()) goto _L4; else goto _L3
_L3:
            view.setChecked(false);
_L2:
            return;
_L4:
            if (!view.isChecked())
            {
                break; /* Loop/switch isn't completed */
            }
            addToInviteList(((TypeAheadItem) (obj)));
            if (_inviteList.size() == getCount())
            {
                Events.post(new SingleCheckEvent(true));
            }
_L6:
            if (Experiments.g())
            {
                PinvitationalData.setFriendsSelected(_inviteList.size());
                return;
            }
            if (true) goto _L2; else goto _L5
_L5:
            removeFromInviteList(((TypeAheadItem) (obj)));
            if (_inviteList.size() == getCount() - 1)
            {
                Events.post(new SingleCheckEvent(false));
            }
              goto _L6
            if (true) goto _L2; else goto _L7
_L7:
        }

        _cls2()
        {
            this$0 = InviteFriendAdapter.this;
            super();
        }
    }

}
