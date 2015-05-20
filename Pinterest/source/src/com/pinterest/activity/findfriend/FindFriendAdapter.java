// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.board.view.PersonListCell;
import com.pinterest.activity.invitefriend.InviteUtil;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.activity.sendapin.adapter.PeopleSearchAdapter;
import com.pinterest.activity.task.event.ToastEvent;
import com.pinterest.activity.user.view.UserToast;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.SignupFormUtils;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.HashSet;
import java.util.Set;

public class FindFriendAdapter extends PeopleSearchAdapter
{

    private String _apiTag;
    private Set _pendingUserApiResponse;
    private android.view.View.OnClickListener onInviteClickListener;

    public FindFriendAdapter(Context context)
    {
        super(context);
        _pendingUserApiResponse = new HashSet();
        onInviteClickListener = new _cls3();
        _emailMaxCount = 50;
    }

    private void followUser(final TypeAheadItem user)
    {
        ModelHelper.followUser(user.getUid(), user.isFollowedByMe(), new _cls1(), _apiTag);
    }

    private void updateFollowBtnState(final PersonListCell listCell, final TypeAheadItem user)
    {
        int i = 0x7f0e022e;
        com.pinterest.ui.text.PButton.ButtonStyle buttonstyle = com.pinterest.ui.text.PButton.ButtonStyle.RED;
        if (user.isFollowedByMe())
        {
            i = 0x7f0e04c8;
            buttonstyle = com.pinterest.ui.text.PButton.ButtonStyle.PLAIN;
        }
        listCell.setActionButtonStyle(buttonstyle);
        listCell.setActionButton(Resources.string(i), new _cls2());
    }

    protected com.pinterest.api.remote.SearchApi.Scope getSearchScope()
    {
        return com.pinterest.api.remote.SearchApi.Scope.h;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        viewgroup = ((ViewGroup) (getItem(i)));
        if ((viewgroup instanceof TypeAheadItem) && (view instanceof PersonListCell))
        {
            viewgroup = (TypeAheadItem)viewgroup;
            PersonListCell personlistcell = (PersonListCell)view;
            personlistcell.setTitle(viewgroup.getTitle());
            personlistcell.setActionButtonTag(viewgroup);
            if (viewgroup.getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.PINNER)
            {
                updateFollowBtnState(personlistcell, viewgroup);
            } else
            if (viewgroup.getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_CONTACT)
            {
                if (!_pendingUserApiResponse.contains(viewgroup.getUid()))
                {
                    personlistcell.setActionButton(Resources.string(0x7f0e029b), onInviteClickListener);
                    return view;
                }
            } else
            if (viewgroup.getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT)
            {
                personlistcell.setActionButton(Resources.string(0x7f0e029b), onInviteClickListener);
                return view;
            } else
            {
                personlistcell.setActionButton(null, null);
                return view;
            }
        }
        return view;
    }

    public boolean inviteUserEmail(String s, String s1, String s2)
    {
        Pinalytics.a(ElementType.EMAIL_BUTTON, ComponentType.USER_FEED);
        if (SignupFormUtils.isEmailValid(s1))
        {
            UserApi.a(s1, InviteUtil.getInviteSource(), _apiTag);
            Events.post(new ToastEvent(new UserToast(Resources.string(0x7f0e0229), s, s2)));
            return true;
        } else
        {
            Application.showToast(0x7f0e0298);
            return false;
        }
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }






    private class _cls3
        implements android.view.View.OnClickListener
    {

        final FindFriendAdapter this$0;

        public void onClick(View view)
        {
            Device.hideSoftKeyboard(view);
            Object obj = view.getTag();
            if (obj instanceof TypeAheadItem)
            {
                obj = (TypeAheadItem)obj;
                if (((TypeAheadItem) (obj)).getItemType() == com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT)
                {
                    InviteUtil.inviteUserSMS((Activity)
// JavaClassFileOutputException: get_constant: invalid tag

        _cls3()
        {
            this$0 = FindFriendAdapter.this;
            super();
        }
    }


    private class _cls1 extends ApiResponseHandler
    {

        final FindFriendAdapter this$0;
        final TypeAheadItem val$user;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            onFailure(throwable, apiresponse);
            throwable = user;
            boolean flag;
            if (!user.isFollowedByMe())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            throwable.setFollowedByMe(flag);
            _pendingUserApiResponse.remove(user.getUid());
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            onSuccess(apiresponse);
            if (user.isFollowedByMe())
            {
                apiresponse = EventType.USER_FOLLOW;
            } else
            {
                apiresponse = EventType.USER_UNFOLLOW;
            }
            Pinalytics.a(apiresponse, user.getUid());
            apiresponse = ModelHelper.getUser(user.getUid());
            if (apiresponse != null)
            {
                ModelHelper.updateUser(apiresponse);
            }
            _pendingUserApiResponse.remove(user.getUid());
        }

        _cls1()
        {
            this$0 = FindFriendAdapter.this;
            user = typeaheaditem;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final FindFriendAdapter this$0;
        final PersonListCell val$listCell;
        final TypeAheadItem val$user;

        public void onClick(View view)
        {
            if (_pendingUserApiResponse.add(user.getUid()))
            {
                view = user;
                boolean flag;
                if (!user.isFollowedByMe())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setFollowedByMe(flag);
                Pinalytics.a(ElementType.USER_FOLLOW, ComponentType.USER_FEED);
                updateFollowBtnState(listCell, user);
                followUser(user);
            }
        }

        _cls2()
        {
            this$0 = FindFriendAdapter.this;
            user = typeaheaditem;
            listCell = personlistcell;
            super();
        }
    }

}
