// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.widget.Adapter;
import com.pinterest.activity.digest.adapter.DigestPinGridAdapter;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.fragment.PinGridFragment;
import com.pinterest.ui.grid.PinterestGridView;
import java.util.List;

public class DigestPinFragment extends PinGridFragment
{

    com.pinterest.api.model.DigestItem.DigestMode _digestMode;
    String _requestId;
    List _topItems;
    protected FeedApiResponseHandler digestGridResponseHandler;

    public DigestPinFragment()
    {
        digestGridResponseHandler = new _cls1();
        _layoutId = 0x7f03007d;
        _adapter = new DigestPinGridAdapter();
    }

    protected void loadData()
    {
        switch (_cls2..SwitchMap.com.pinterest.api.model.DigestItem.DigestMode[_digestMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            BoardApi.a(_requestId, false, new com.pinterest.api.remote.PinApi.PinFeedApiResponse(digestGridResponseHandler), getApiTag());
            return;

        case 3: // '\003'
        case 4: // '\004'
            UserApi.a(_requestId, new com.pinterest.api.remote.PinApi.PinFeedApiResponse(digestGridResponseHandler), getApiTag());
            return;

        case 5: // '\005'
        case 6: // '\006'
            InterestsApi.a(_requestId, new com.pinterest.api.remote.PinApi.PinFeedApiResponse(digestGridResponseHandler), getApiTag());
            break;
        }
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _requestId = navigation.getStringParcelable("com.pinterest.EXTRA_DIGEST_ID");
        _digestMode = com.pinterest.api.model.DigestItem.DigestMode.withName(navigation.getStringParcelable("com.pinterest.EXTRA_DIGEST_MODE"));
        _topItems = (List)navigation.getExtra("com.pinterest.EXTRA_DIGEST_PIN_ITEMS");
        ((DigestPinGridAdapter)_adapter).setHeadItems(_topItems);
    }











/*
    static boolean access$1702(DigestPinFragment digestpinfragment, boolean flag)
    {
        digestpinfragment._refreshing = flag;
        return flag;
    }

*/
















/*
    static boolean access$802(DigestPinFragment digestpinfragment, boolean flag)
    {
        digestpinfragment._refreshing = flag;
        return flag;
    }

*/


    private class _cls1 extends FeedApiResponseHandler
    {

        final DigestPinFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            if (ERROR != null)
            {
                throwable = Resources.string(0x7f0e02cb);
                if (!Device.hasInternet())
                {
                    ERROR.setState(com.pinterest.ui.grid.PinterestGridView.State.ERROR);
                    return;
                }
                if (apiresponse != null)
                {
                    throwable = apiresponse.getMessageDetailIfExist();
                }
                ERROR.setState(com.pinterest.ui.grid.PinterestGridView.State.ERROR);
                ERROR.setEmptyMessage(throwable);
            }
            false.access$1600 = throwable;
            if (hasInternet != null)
            {
                ((PinGridAdapter)hasInternet).setLoading(false);
            }
            setEmptyContent(hasInternet);
        }

        public void onStart()
        {
            super.onStart();
            if (ERROR != null)
            {
                ERROR.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADING);
            }
            if (hasInternet != null)
            {
                ((PinGridAdapter)hasInternet).setLoading(true);
            }
        }

        public void onSuccess(Feed feed)
        {
            feed = ((DigestPinGridAdapter)hasInternet).resetDataFeed(feed);
            super.onSuccess(feed);
            if (ERROR != null)
            {
                if (access$1600)
                {
                    ERROR.setDataSource(feed);
                    onDataSourceChanged(false);
                } else
                {
                    ERROR.appendDataSource(feed);
                    onDataSourceChanged(false);
                }
                ERROR.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADED);
            }
            false.access$1600 = feed;
            if (hasInternet != null)
            {
                ((PinGridAdapter)hasInternet).setLoading(false);
            }
            setEmptyContent(hasInternet);
        }

        _cls1()
        {
            this$0 = DigestPinFragment.this;
            super();
        }
    }


    private class _cls2
    {

        static final int $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[];

        static 
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode = new int[com.pinterest.api.model.DigestItem.DigestMode.values().length];
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_BOARD.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.BOARD.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER_CATEGORY.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.INTEREST.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_THROUGH_INTEREST.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
