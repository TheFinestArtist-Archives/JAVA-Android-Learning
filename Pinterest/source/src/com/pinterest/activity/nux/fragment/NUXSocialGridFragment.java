// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.nux.NUXActivity;
import com.pinterest.activity.nux.adapter.NUXSocialGridAdapter;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.model.UserFeed;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Events;
import com.pinterest.fragment.PinterestGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.grid.PinterestGridView;

public class NUXSocialGridFragment extends PinterestGridFragment
{

    NUXUserApiResponse _fbHandler;
    private int _socialType;
    NUXUserApiResponse _twitHandler;
    private UserFeed _users;
    private Handler handler;
    private android.widget.AdapterView.OnItemClickListener onItemClick;

    public NUXSocialGridFragment()
    {
        this(-1);
    }

    public NUXSocialGridFragment(int i)
    {
        _socialType = -1;
        onItemClick = new _cls2();
        _fbHandler = new NUXUserApiResponse(gridResponseHandler);
        _twitHandler = new NUXUserApiResponse(gridResponseHandler);
        Bundle bundle = getArguments();
        if (bundle == null)
        {
            _socialType = i;
            bundle = new Bundle();
            bundle.putInt("_type", _socialType);
            setArguments(bundle);
        } else
        {
            _socialType = bundle.getInt("_type");
        }
        _layoutId = 0x7f030097;
        _adapter = new NUXSocialGridAdapter(this);
        ((NUXSocialGridAdapter)_adapter).setApiTag(getApiTag());
        handler = new Handler(Looper.getMainLooper());
    }

    private void postUpdateProgressEvent(boolean flag)
    {
        byte byte0 = -1;
        if (_socialType == 0)
        {
            if (!flag)
            {
                byte0 = 1;
            }
            Events.post(new com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent(byte0, com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent.EventType.FACEBOOK));
        } else
        if (_socialType == 1)
        {
            if (!flag)
            {
                byte0 = 1;
            }
            Events.post(new com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent(byte0, com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent.EventType.TWITTER));
            return;
        }
    }

    public boolean isComplete()
    {
        return !((NUXSocialGridAdapter)_adapter).isCheckedUsersEmpty() || ((NUXSocialGridAdapter)_adapter).getDataSource().getCount() == 0;
    }

    protected void loadData()
    {
        super.loadData();
        if (MyUser.isConnectedToFacebook() && _socialType == 0)
        {
            MyUserApi.f("on_pinterest", _fbHandler, getApiTag());
        } else
        {
            if (MyUser.isConnectedToTwitter() && _socialType == 1)
            {
                MyUserApi.g("on_pinterest", _twitHandler, getApiTag());
                return;
            }
            if (_socialType == 2)
            {
                _users = new UserFeed();
                for (int i = 0; i < 50; i++)
                {
                    _users.appendItem(new User());
                }

                ((NUXSocialGridAdapter)_adapter).setDataSource(_users);
                ((NUXSocialGridAdapter)_adapter).setIsDefault(true, ((NUXActivity)getActivity()).getDefaultUserImages());
                return;
            }
        }
    }

    public void onDestroyView()
    {
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (_socialType == 2)
        {
            _gridVw.setAlpha(0.6F);
            _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.NONE);
            _gridVw.setOnTouchListener(new _cls1());
        }
        _gridVw.setOnItemClickListener(onItemClick);
        _gridVw.getFooterView().setPadding(0, 0, 0, (int)Resources.dimension(0x7f0a00a6));
        _gridVw.setBackgroundColor(Resources.color(0x7f09000a));
        _gridVw.getFooterView().setBackgroundColor(Resources.color(0x7f09000a));
        ((NUXSocialGridAdapter)_adapter).setFooterView(_gridVw.getFooterView());
    }

    public void showNoFollowersHeader()
    {
        if (_gridVw.getHeaderCount() == 0)
        {
            _gridVw.addHeaderView(0x7f030136);
            TextView textview = (TextView)_gridVw.findViewById(0x7f0b02cf);
            String s;
            String s1;
            if (_socialType == 0)
            {
                s = Resources.string(0x7f0e020f);
            } else
            {
                s = Resources.string(0x7f0e04ba);
            }
            if (_socialType == 0)
            {
                s1 = Resources.string(0x7f0e04ba);
            } else
            {
                s1 = Resources.string(0x7f0e020f);
            }
            textview.setText(Resources.string(0x7f0e032c, new Object[] {
                s, s1
            }));
            _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADED);
            Events.post(new NUXSocialPickerFragment.SocialConnectedEvent(_socialType));
        }
    }

    public void submitFollowUsers()
    {
        if (getActivity() != null)
        {
            if (MyUser.isConnectedToFacebook() && _socialType == 0 && isComplete())
            {
                ((NUXActivity)getActivity()).submitFollowUsers(((NUXSocialGridAdapter)_adapter).isAllUsersChecked(), ((NUXSocialGridAdapter)_adapter).getCheckedUsers(), com.pinterest.base.Social.Network.FACEBOOK);
                return;
            }
            if (MyUser.isConnectedToTwitter() && _socialType == 1 && isComplete())
            {
                ((NUXActivity)getActivity()).submitFollowUsers(((NUXSocialGridAdapter)_adapter).isAllUsersChecked(), ((NUXSocialGridAdapter)_adapter).getCheckedUsers(), com.pinterest.base.Social.Network.TWITTER);
                return;
            }
        }
    }









/*
    static UserFeed access$1402(NUXSocialGridFragment nuxsocialgridfragment, UserFeed userfeed)
    {
        nuxsocialgridfragment._users = userfeed;
        return userfeed;
    }

*/











    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final NUXSocialGridFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (access$200 != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            adapterview = NUXSocialGridCell.from(view, view.getContext());
            if (!adapterview.isFirstCell() || i != 0) goto _L4; else goto _L3
_L3:
            ((NUXSocialGridAdapter)access$200).toggleCheckAllUsers();
_L6:
            if (((NUXSocialGridAdapter)access$200).getCheckUsersSize() == 0 || ((NUXSocialGridAdapter)access$200).getCheckUsersSize() == 1 && adapterview.isChecked())
            {
                postUpdateProgressEvent(((NUXSocialGridAdapter)access$200).isCheckedUsersEmpty());
                return;
            }
            break; /* Loop/switch isn't completed */
_L4:
            if (!((NUXSocialGridAdapter)access$200).isAllUsersChecked())
            {
                view = adapterview.getUser();
                ((NUXSocialGridAdapter)access$200).toggleCheckUser(view);
                adapterview.setChecked(((NUXSocialGridAdapter)access$200).isUserChecked(view));
            }
            if (true) goto _L6; else goto _L5
_L5:
            if (!adapterview.isFirstCell() || ((NUXSocialGridAdapter)access$200).getCheckUsersSize() != 0 && (((NUXSocialGridAdapter)access$200).getCheckUsersSize() != 1 || !((NUXSocialGridAdapter)access$200).isAllUsersChecked())) goto _L1; else goto _L7
_L7:
            postUpdateProgressEvent(((NUXSocialGridAdapter)access$200).isCheckedUsersEmpty());
            return;
        }

        _cls2()
        {
            this$0 = NUXSocialGridFragment.this;
            super();
        }
    }


    private class NUXUserApiResponse extends com.pinterest.api.remote.UserApi.UserFeedApiResponse
    {

        final NUXSocialGridFragment this$0;
        int tryagain;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            Application.showDebugToast(throwable.toString());
            super.onFailure(throwable, apiresponse);
        }

        public void onFinish()
        {
        }

        public void onStart()
        {
            _showLoadingDialog = true;
            super.onStart();
        }

        public void onSuccess(Feed feed)
        {
            if (feed.getCode() == 0 || tryagain >= 5) goto _L2; else goto _L1
_L1:
            tryagain = tryagain + 1;
            class _cls1
                implements Runnable
            {

                final NUXUserApiResponse this$1;

                public void run()
                {
                    loadData();
                }

                _cls1()
                {
                    this$1 = NUXUserApiResponse.this;
                    super();
                }
            }

            handler.postDelayed(new _cls1(), tryagain * 2000);
_L4:
            return;
_L2:
            if (feed.getCode() != 0) goto _L4; else goto _L3
_L3:
            _users = (UserFeed)feed;
            ((NUXSocialGridAdapter)access$1402).setDataSource(_users);
            if (_users.getCount() == 0)
            {
                showNoFollowersHeader();
                return;
            }
            if (!MyUser.isConnectedToFacebook() || _socialType != 0) goto _L6; else goto _L5
_L5:
            Events.post(new NUXSocialPickerFragment.SocialConnectedEvent(0));
_L8:
            super.onSuccess(feed);
            return;
_L6:
            if (MyUser.isConnectedToTwitter() && _socialType == 1)
            {
                Events.post(new NUXSocialPickerFragment.SocialConnectedEvent(1));
            }
            if (true) goto _L8; else goto _L7
_L7:
        }

        public NUXUserApiResponse(FeedApiResponseHandler feedapiresponsehandler)
        {
            this$0 = NUXSocialGridFragment.this;
            super(feedapiresponsehandler);
            tryagain = 0;
        }
    }


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final NUXSocialGridFragment this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

        _cls1()
        {
            this$0 = NUXSocialGridFragment.this;
            super();
        }
    }

}
