// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.pinterest.activity.board.view.PersonListCell;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.model.UserFeed;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class PeopleListAdapter extends BaseAdapter
{

    public static final int FOLLOW_DELAY_MILLISECONDS = 1000;
    private static AbstractMap _runnableMap = new ConcurrentHashMap();
    protected UserFeed _dataSource;
    private Handler _followHandler;
    private LayoutInflater _li;
    private PeopleListListener _listener;
    protected boolean _loading;
    private android.view.View.OnClickListener onFollowClicked;
    public android.widget.AdapterView.OnItemClickListener onItemClick;

    public PeopleListAdapter()
    {
        this(null);
    }

    public PeopleListAdapter(Context context)
    {
        onItemClick = new _cls1();
        onFollowClicked = new _cls2();
        if (context != null)
        {
            _li = LayoutInflater.from(context);
        }
        _followHandler = new Handler();
        _dataSource = new UserFeed();
    }

    public static void clearRunnableMap()
    {
        for (Iterator iterator = _runnableMap.values().iterator(); iterator.hasNext(); ((FollowRunnable)iterator.next()).run()) { }
        _runnableMap.clear();
    }

    public void appendItems(UserFeed userfeed)
    {
        _dataSource.appendItems(userfeed);
    }

    public final void finishedLoading()
    {
        _loading = false;
    }

    public int getCount()
    {
        if (_dataSource == null)
        {
            return 0;
        } else
        {
            return _dataSource.getCount();
        }
    }

    public UserFeed getDataSource()
    {
        return _dataSource;
    }

    public User getItem(int i)
    {
        return (User)_dataSource.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (_li == null)
        {
            _li = LayoutInflater.from(ViewHelper.getContext(view, viewgroup));
        }
        if (view != null && (view instanceof PersonListCell))
        {
            view = (PersonListCell)view;
            view.reset();
        } else
        {
            view = (PersonListCell)_li.inflate(0x7f0300ed, viewgroup, false);
        }
        viewgroup = getItem(i);
        view.setTitle(viewgroup.getFullName());
        view.setDesc(viewgroup.getWebsite(), viewgroup.getWebsiteVerified(), viewgroup.getLocation());
        view.setImage(viewgroup.getImageMediumUrl());
        if (MyUser.getUid().equals(viewgroup.getUid()))
        {
            view.setActionButton(null, null);
        } else
        {
            if (!viewgroup.getFollowing())
            {
                view.setActionButton(Resources.string(0x7f0e022e), onFollowClicked);
                view.setActionButtonStyle(com.pinterest.ui.text.PButton.ButtonStyle.RED);
            } else
            {
                view.setActionButton(Resources.string(0x7f0e04c8), onFollowClicked);
                view.setActionButtonStyle(com.pinterest.ui.text.PButton.ButtonStyle.PLAIN);
            }
            view.setActionButtonTag(viewgroup);
        }
        loadMore(i);
        return view;
    }

    protected final void loadMore(int i)
    {
        if (_listener != null && i == getCount() - 1 && !_loading)
        {
            _listener.loadMore();
            _loading = true;
        }
    }

    public void setDataSource(UserFeed userfeed)
    {
        _loading = false;
        _dataSource = userfeed;
        notifyDataSetChanged();
    }

    public void setListener(PeopleListListener peoplelistlistener)
    {
        _listener = peoplelistlistener;
    }




    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PeopleListAdapter this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (User)adapterview.getItemAtPosition(i);
            if (adapterview == null)
            {
                return;
            } else
            {
                adapterview = adapterview.getUid();
                Pinalytics.a(ElementType.USER_LIST_USER, ComponentType.USER_FEED, adapterview);
                Events.post(new Navigation(Location.USER, adapterview));
                return;
            }
        }

        _cls1()
        {
            this$0 = PeopleListAdapter.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PeopleListAdapter this$0;

        public void onClick(View view)
        {
            User user = (User)view.getTag();
            boolean flag;
            if (!user.getFollowing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            user.setFollowing(flag);
            notifyDataSetChanged();
            if (user.getFollowing())
            {
                view = EventType.USER_FOLLOW;
            } else
            {
                view = EventType.USER_UNFOLLOW;
            }
            Pinalytics.a(ElementType.USER_FEED_FOLLOW, ComponentType.USER_FEED, user.getUid());
            if (PeopleListAdapter._runnableMap.containsKey(user))
            {
                view = (FollowRunnable)PeopleListAdapter._runnableMap.get(user);
                _followHandler.removeCallbacks(view);
            } else
            {
                class _cls1 extends FollowRunnable.FollowRunnableComplete
                {

                    final _cls2 this$1;

                    public void onComplete()
                    {
                        notifyDataSetChanged();
                    }

                _cls1()
                {
                    this$1 = _cls2.this;
                    class FollowRunnable.FollowRunnableComplete
                    {

                        public abstract void onComplete();

                            public FollowRunnable.FollowRunnableComplete()
                            {
                            }
                    }

                    super();
                }
                }

                view = new FollowRunnable(user, new _cls1());
                PeopleListAdapter._runnableMap.put(user, view);
            }
            _followHandler.postDelayed(view, 1000L);
        }

        _cls2()
        {
            this$0 = PeopleListAdapter.this;
            super();
        }
    }


    private class FollowRunnable
        implements Runnable
    {

        public FollowRunnableComplete onComplete;
        public User user;

        public void run()
        {
            class _cls1 extends ApiResponseHandler
            {

                final FollowRunnable this$0;

                public void onFailure(Throwable throwable, ApiResponse apiresponse)
                {
                    super.onFailure(throwable, apiresponse);
                    throwable = ModelHelper.getUser(user.getUid());
                    if (throwable != null)
                    {
                        boolean flag;
                        if (!throwable.getFollowing())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        throwable.setFollowing(flag);
                        ModelHelper.updateUser(throwable);
                        if (onComplete != null)
                        {
                            onComplete.onComplete();
                        }
                    }
                }

                public void onSuccess(ApiResponse apiresponse)
                {
                    super.onSuccess(apiresponse);
                    if (user.getFollowing())
                    {
                        apiresponse = EventType.USER_FOLLOW;
                    } else
                    {
                        apiresponse = EventType.USER_UNFOLLOW;
                    }
                    Pinalytics.a(apiresponse, user.getUid());
                }

                _cls1()
                {
                    this$0 = FollowRunnable.this;
                    super();
                }
            }

            ModelHelper.followUser(user.getUid(), user.getFollowing(), new _cls1(), null);
            if (onComplete != null)
            {
                onComplete.onComplete();
            }
            PeopleListAdapter._runnableMap.remove(user);
        }

        public FollowRunnable(User user1, FollowRunnableComplete followrunnablecomplete)
        {
            user = user1;
            onComplete = followrunnablecomplete;
        }
    }


    private class PeopleListListener
    {

        public abstract void loadMore();
    }

}
