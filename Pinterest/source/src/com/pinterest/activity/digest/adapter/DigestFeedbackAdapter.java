// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.pinterest.activity.digest.ui.DigestFeedbackCell;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.Interest;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.api.remote.PinApi;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.event.EventType;
import java.util.HashMap;

public class DigestFeedbackAdapter extends BaseAdapter
{

    private String _apiTag;
    private Context _context;
    private DigestItem _item;
    private LayoutInflater _li;

    public DigestFeedbackAdapter(Context context)
    {
        _context = context;
        _li = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    private void unFollowBoard(String s)
    {
        final Board final_board = ModelHelper.getBoard(s);
        BoardApi.a(String.valueOf(s), false, new _cls3(s), _apiTag);
    }

    private void unFollowInterest(String s)
    {
        s = ModelHelper.getInterest(s);
        HashMap hashmap = new HashMap();
        hashmap.put("interest", s.getUrlName());
        Pinalytics.a(EventType.INTEREST_FOLLOW, null, null, hashmap);
        InterestsApi.a(s, false, new _cls1(true), _apiTag);
    }

    private void unFollowMyBoard(String s, Pin pin)
    {
        if (pin == null)
        {
            return;
        } else
        {
            PinApi.a(pin.getUid(), 1, s, new ApiResponseHandler(), _apiTag);
            return;
        }
    }

    private void unFollowUser(final String userId)
    {
        ModelHelper.followUser(userId, false, new _cls2(), _apiTag);
    }

    public int getCount()
    {
        int i;
        boolean flag;
        flag = true;
        i = ((flag) ? 1 : 0);
        _cls4..SwitchMap.com.pinterest.api.model.DigestItem.DigestMode[com.pinterest.api.model.DigestItem.DigestMode.withName(_item.getContainerType()).ordinal()];
        JVM INSTR tableswitch 1 5: default 56
    //                   1 58
    //                   2 58
    //                   3 58
    //                   4 58
    //                   5 60;
           goto _L1 _L2 _L2 _L2 _L2 _L3
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 0;
_L5:
        return i;
_L3:
        i = ((flag) ? 1 : 0);
        if (!MyUser.isUserMe(_item.getUserUid()))
        {
            return 2;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public FeedbackItem getItem(int i)
    {
        if (i < 0 || i >= getCount())
        {
            return null;
        }
        FeedbackItem feedbackitem = new FeedbackItem();
        switch (_cls4..SwitchMap.com.pinterest.api.model.DigestItem.DigestMode[com.pinterest.api.model.DigestItem.DigestMode.withName(_item.getContainerType()).ordinal()])
        {
        default:
            return feedbackitem;

        case 1: // '\001'
            Board board = ModelHelper.getBoard(_item.getBoardUid());
            feedbackitem.setItem(_item.getBoardUid(), board.getImageCoverUrl(), board.getName(), UnFollowItemType.MY_BOARD);
            return feedbackitem;

        case 2: // '\002'
        case 3: // '\003'
            User user = ModelHelper.getUser(_item.getUserUid());
            feedbackitem.setItem(_item.getUserUid(), user.getImageMediumUrl(), user.getFullName(), UnFollowItemType.USER);
            return feedbackitem;

        case 4: // '\004'
            Interest interest = ModelHelper.getInterest(_item.getInterestUid());
            feedbackitem.setItem(_item.getInterestUid(), interest.getImageGridLg2LineUrl(), interest.getName(), UnFollowItemType.INTEREST);
            return feedbackitem;

        case 5: // '\005'
            break;
        }
        if (MyUser.isUserMe(_item.getUserUid()))
        {
            Board board1 = ModelHelper.getBoard(_item.getBoardUid());
            feedbackitem.setItem(_item.getBoardUid(), board1.getImageCoverUrl(), board1.getName(), UnFollowItemType.MY_BOARD);
            return feedbackitem;
        }
        if (i == 0)
        {
            User user1 = ModelHelper.getUser(_item.getUserUid());
            feedbackitem.setItem(_item.getUserUid(), user1.getImageMediumUrl(), user1.getFullName(), UnFollowItemType.USER);
            return feedbackitem;
        } else
        {
            Board board2 = ModelHelper.getBoard(_item.getBoardUid());
            feedbackitem.setItem(_item.getBoardUid(), board2.getImageCoverUrl(), board2.getName(), UnFollowItemType.OTHER_BOARD);
            return feedbackitem;
        }
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
        view = DigestFeedbackCell.get(view, viewgroup);
        view.setFeedbackItem(getItem(i));
        return view;
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }

    public void setDigestItem(DigestItem digestitem)
    {
        _item = digestitem;
    }

    public void unFollow(int i, Pin pin)
    {
        FeedbackItem feedbackitem = getItem(i);
        _cls4..SwitchMap.com.pinterest.activity.digest.adapter.DigestFeedbackAdapter.UnFollowItemType[feedbackitem.getUnFollowItemType().ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 49
    //                   2 89
    //                   3 105
    //                   4 124;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        pin = ElementType.DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_INTEREST;
        unFollowInterest(feedbackitem.getItemId());
_L7:
        Pinalytics.a(pin, ComponentType.DIGEST_STORY_FEEDBACK_DIALOG);
        Events.post(new com.pinterest.api.remote.DigestApi.UnfollowStoryEvent(_item, feedbackitem.getUnFollowItemType()));
        return;
_L3:
        pin = ElementType.DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_USER;
        unFollowUser(feedbackitem.getItemId());
        continue; /* Loop/switch isn't completed */
_L4:
        ElementType elementtype = ElementType.DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD;
        unFollowMyBoard(feedbackitem.getItemId(), pin);
        pin = elementtype;
        continue; /* Loop/switch isn't completed */
_L5:
        pin = ElementType.DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD;
        unFollowBoard(feedbackitem.getItemId());
        if (true) goto _L7; else goto _L6
_L6:
    }

    private class _cls3 extends com.pinterest.api.remote.BoardApi.BoardFollowApiResponse
    {

        final DigestFeedbackAdapter this$0;
        final String val$boardId;

        public void onSuccess(Board board)
        {
            Pinalytics.a(EventType.BOARD_UNFOLLOW, boardId);
        }

        _cls3(String s)
        {
            this$0 = DigestFeedbackAdapter.this;
            boardId = s;
            super(final_board);
        }
    }


    private class _cls1 extends ApiResponseHandler
    {

        final DigestFeedbackAdapter this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
        }

        _cls1(boolean flag)
        {
            this$0 = DigestFeedbackAdapter.this;
            super(flag);
        }
    }


    private class _cls2 extends ApiResponseHandler
    {

        final DigestFeedbackAdapter this$0;
        final String val$userId;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            throwable = ModelHelper.getUser(userId);
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
            }
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            Pinalytics.a(EventType.USER_UNFOLLOW, userId);
        }

        _cls2()
        {
            this$0 = DigestFeedbackAdapter.this;
            userId = s;
            super();
        }
    }


    private class _cls4
    {

        static final int $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[];
        static final int $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[];

        static 
        {
            $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType = new int[UnFollowItemType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[UnFollowItemType.INTEREST.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[UnFollowItemType.USER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[UnFollowItemType.MY_BOARD.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[UnFollowItemType.OTHER_BOARD.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode = new int[com.pinterest.api.model.DigestItem.DigestMode.values().length];
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_BOARD.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER_CATEGORY.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.INTEREST.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.BOARD.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class FeedbackItem
    {

        String _coverUrl;
        String _display;
        String _itemId;
        UnFollowItemType _type;
        final DigestFeedbackAdapter this$0;

        public String getCoverUrl()
        {
            return _coverUrl;
        }

        public String getDisplay()
        {
            return _display;
        }

        public String getItemId()
        {
            return _itemId;
        }

        public UnFollowItemType getUnFollowItemType()
        {
            return _type;
        }

        public void setItem(String s, String s1, String s2, UnFollowItemType unfollowitemtype)
        {
            _itemId = s;
            _coverUrl = s1;
            _display = s2;
            _type = unfollowitemtype;
        }

        public FeedbackItem()
        {
            this$0 = DigestFeedbackAdapter.this;
            super();
        }
    }


    private class UnFollowItemType extends Enum
    {

        private static final UnFollowItemType $VALUES[];
        public static final UnFollowItemType INTEREST;
        public static final UnFollowItemType MY_BOARD;
        public static final UnFollowItemType OTHER_BOARD;
        public static final UnFollowItemType USER;

        public static UnFollowItemType valueOf(String s)
        {
            return (UnFollowItemType)Enum.valueOf(com/pinterest/activity/digest/adapter/DigestFeedbackAdapter$UnFollowItemType, s);
        }

        public static UnFollowItemType[] values()
        {
            return (UnFollowItemType[])$VALUES.clone();
        }

        static 
        {
            INTEREST = new UnFollowItemType("INTEREST", 0);
            USER = new UnFollowItemType("USER", 1);
            MY_BOARD = new UnFollowItemType("MY_BOARD", 2);
            OTHER_BOARD = new UnFollowItemType("OTHER_BOARD", 3);
            $VALUES = (new UnFollowItemType[] {
                INTEREST, USER, MY_BOARD, OTHER_BOARD
            });
        }

        private UnFollowItemType(String s, int i)
        {
            super(s, i);
        }
    }

}
