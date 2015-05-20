// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import com.pinterest.activity.board.view.BoardHeaderInviteView;
import com.pinterest.activity.board.view.BoardHeaderView;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.ApiFields;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.BoardInviteFeed;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;
import com.pinterest.experiment.Experiments;
import com.pinterest.fragment.PinGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.experiences.Placement;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.actionbar.MetadataBar;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.PinterestGridView;
import com.pinterest.ui.megaphone.BoardMegaphoneEvent;

public class BaseBoardFragment extends PinGridFragment
{

    protected Board _board;
    protected String _boardId;
    private Runnable _eduRunnable;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    MetadataBar _floatingMetadataBar;
    protected BoardHeaderView _header;
    protected BoardHeaderInviteView _inviteHeader;
    private FrameLayout _inviteWrapper;
    protected MetadataBar _metadataBar;
    protected User _user;
    private BaseApiResponseHandler batchHandler;
    private com.pinterest.api.remote.MyUserApi.BoardInviteFeedResponse onBoardInviteLoaded;
    private com.pinterest.api.remote.BoardApi.BoardApiResponse onBoardLoaded;
    private ApiResponseHandler onEducationLoaded;

    public BaseBoardFragment()
    {
        _eventsSubscriber = new _cls5();
        batchHandler = new _cls6();
        onBoardLoaded = new _cls7();
        onEducationLoaded = new _cls8();
        onBoardInviteLoaded = new _cls9();
        _layoutId = 0x7f03006e;
    }

    private void handleBatch(PinterestJsonObject pinterestjsonobject)
    {
        if (isActive())
        {
            Object obj = pinterestjsonobject.c("GET:/v3/experiences/");
            Object obj1 = pinterestjsonobject.c((new StringBuilder("GET:/v3/boards/")).append(_navigation.getId()).append("/").toString());
            PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c((new StringBuilder("GET:/v3/boards/")).append(_navigation.getId()).append("/pins/").toString());
            pinterestjsonobject = pinterestjsonobject.c((new StringBuilder("GET:/v3/boards/")).append(_navigation.getId()).append("/collaborators/invites/me/").toString());
            obj = new ApiResponse(((PinterestJsonObject) (obj)));
            ApiResponse apiresponse1 = new ApiResponse(((PinterestJsonObject) (obj1)));
            obj1 = new ApiResponse(pinterestjsonobject1);
            ApiResponse apiresponse = new ApiResponse(pinterestjsonobject);
            if (onEducationLoaded != null)
            {
                if (((ApiResponse) (obj)).getCode() == 0)
                {
                    onEducationLoaded.onSuccess(((ApiResponse) (obj)));
                } else
                {
                    onEducationLoaded.onFailure(null, ((ApiResponse) (obj)));
                }
                onEducationLoaded.onFinish();
            }
            if (onBoardLoaded != null)
            {
                if (apiresponse1.getCode() == 0)
                {
                    onBoardLoaded.onSuccess(apiresponse1);
                } else
                {
                    onBoardLoaded.onFailure(null, apiresponse1);
                }
                onBoardLoaded.onFinish();
            }
            obj = new com.pinterest.api.remote.PinApi.PinFeedApiResponse(gridResponseHandler);
            ((com.pinterest.api.remote.PinApi.PinFeedApiResponse) (obj)).setBaseUrl((new StringBuilder("boards/")).append(_navigation.getId()).append("/pins/?fields=").append(ApiFields.u).append("&page_size=").append(Device.getPageSizeString()).toString());
            if (((ApiResponse) (obj1)).getCode() == 0)
            {
                ((com.pinterest.api.remote.PinApi.PinFeedApiResponse) (obj)).onSuccess(pinterestjsonobject1);
            } else
            {
                ((com.pinterest.api.remote.PinApi.PinFeedApiResponse) (obj)).onFailure(null, pinterestjsonobject1);
            }
            ((com.pinterest.api.remote.PinApi.PinFeedApiResponse) (obj)).onFinish();
            if (onBoardInviteLoaded != null)
            {
                if (apiresponse.getCode() == 0)
                {
                    onBoardInviteLoaded.onSuccess(pinterestjsonobject);
                } else
                {
                    onBoardInviteLoaded.onFailure(null, pinterestjsonobject);
                }
                onBoardInviteLoaded.onFinish();
                return;
            }
        }
    }

    private void setEmptyViewButton()
    {
        while (_gridVw == null || _board == null || _board.getPinCountDisplay() > 0) 
        {
            return;
        }
        if (_board.isPlaceBoard() && MyUser.isUserMe(_user))
        {
            _emptyActionLabel = Resources.string(0x7f0e03a4);
            _emptyAction = new _cls4();
            return;
        } else
        {
            _gridVw.getEmptyView().removeAction(1);
            return;
        }
    }

    private void updateActionBar()
    {
        if (_actionBar != null && _board != null)
        {
            _actionBar.setTitle(_board.getName());
        }
    }

    private void updateInvite(final BoardInviteFeed feed)
    {
        (new _cls3()).execute();
    }

    private void updateMetadataBarState()
    {
        if (getView() == null || _floatingMetadataBar == null || _gridVw == null || _metadataBar == null)
        {
            return;
        }
        int ai[] = new int[2];
        _metadataBar.getLocationOnScreen(ai);
        int ai1[] = new int[2];
        _floatingMetadataBar.getLocationOnScreen(ai1);
        if (ai[1] > ai1[1])
        {
            _floatingMetadataBar.setVisibility(4);
            _metadataBar.setVisibility(0);
            return;
        }
        _floatingMetadataBar.setVisibility(0);
        _metadataBar.setVisibility(4);
        if (Experiments.c())
        {
            if ((float)(_actionBar.getHeight() + _floatingMetadataBar.getHeight()) - Math.abs(_actionBar.getY()) < 2.0F)
            {
                _floatingMetadataBar.setTranslationY(-_floatingMetadataBar.getHeight());
                return;
            } else
            {
                _floatingMetadataBar.setTranslationY((float)_actionBar.getHeight() - Math.abs(_actionBarWrapper.getY()));
                return;
            }
        } else
        {
            _floatingMetadataBar.setTranslationY((float)_actionBar.getHeight() - Math.abs(_actionBarWrapper.getY()));
            return;
        }
    }

    protected void loadData()
    {
        String s = getNavigation().getId();
        _boardId = s;
        String s1 = Integer.toString(Placement.ANDROID_BOARD_TAKEOVER.getValue());
        if (MyUser.hasAccessToken())
        {
            BoardApi.d(s1, s, batchHandler, getApiTag());
        } else
        {
            BoardApi.a(s, false, new com.pinterest.api.remote.PinApi.PinFeedApiResponse(gridResponseHandler), getApiTag());
        }
        super.loadData();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (_board != null && _board.isMeOwnerOrCollaborator())
        {
            _menuId = 0x7f100005;
        }
    }

    protected void onDeactivate()
    {
        EducationHelper.a(_eduRunnable);
        super.onDeactivate();
    }

    public void onDestroy()
    {
        onBoardLoaded = null;
        onBoardInviteLoaded = null;
        onEducationLoaded = null;
        batchHandler = null;
        super.onDestroy();
    }

    public void onDestroyView()
    {
        Events.unregister(_eventsSubscriber);
        if (_header != null)
        {
            _header.setOnClickListener(null);
            _header = null;
        }
        _inviteWrapper = null;
        _inviteHeader = null;
        _metadataBar = null;
        _floatingMetadataBar = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        setEmptyViewButton();
        updateActionBar();
        Experiments.a("android_persistent_follow_button");
        if (Experiments.d())
        {
            _floatingMetadataBar.postDelayed(new _cls1(), 1L);
        }
        _gridVw.addListener(new _cls2());
        _header = new BoardHeaderView(view.getContext());
        _header.setId(0x7f0b015d);
        _header.setApiTag(getApiTag());
        _header.setVisibility(8);
        _header.setUser(_user);
        _header.setBoard(_board);
        _gridVw.addHeaderView(_header, -1, -2);
        _inviteWrapper = new FrameLayout(view.getContext());
        _gridVw.addHeaderView(_inviteWrapper, -1, -2);
        _metadataBar = new MetadataBar(view.getContext());
        _metadataBar.setModel(_board, com.pinterest.ui.actionbar.MetadataBar.Mode.PINS);
        _floatingMetadataBar.setModel(_board, com.pinterest.ui.actionbar.MetadataBar.Mode.PINS);
        _gridVw.addHeaderView(_metadataBar, -1, -2);
        ((PinGridAdapter)_adapter).setRenderUser(true);
        ((PinGridAdapter)_adapter).setRenderOnto(false);
        ((PinGridAdapter)_adapter).setRenderSource(false);
        ((PinGridAdapter)_adapter).setCropPinImage(false);
        Events.register(_eventsSubscriber, com/pinterest/api/model/Board$BoardDoesNotExistEvent, new Class[] {
            com/pinterest/api/model/Board$UpdateEvent, com/pinterest/api/model/User$UpdateEvent, com/pinterest/api/model/Board$RequestUpdateEvent, com/pinterest/ui/megaphone/BoardMegaphoneEvent
        });
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _board = navigation.getModelAsBoard();
        if (_board != null)
        {
            _user = _board.getUser();
        }
    }

    protected void updateEmptyContent()
    {
        _emptyLeftImage = 0x7f020163;
        _emptyCenterImage = 0x7f02016b;
        _emptyRightImage = 0x7f020166;
        if (_user != null)
        {
            if (MyUser.isUserMe(_user))
            {
                if (_board != null && _board.isPlaceBoard())
                {
                    _emptyMessage = Resources.string(0x7f0e03a5);
                    return;
                } else
                {
                    _emptyMessage = Resources.string(0x7f0e01f0);
                    return;
                }
            } else
            {
                _emptyMessage = Resources.string(0x7f0e01d5, new Object[] {
                    _user.getFirstName()
                });
                return;
            }
        } else
        {
            _emptyMessage = Resources.string(0x7f0e01d6);
            return;
        }
    }










/*
    static Runnable access$802(BaseBoardFragment baseboardfragment, Runnable runnable)
    {
        baseboardfragment._eduRunnable = runnable;
        return runnable;
    }

*/


    private class _cls5 extends com.pinterest.base.Events.EventsSubscriber
    {

        final BaseBoardFragment this$0;

        public void onEventMainThread(com.pinterest.api.model.Board.RequestUpdateEvent requestupdateevent)
        {
            BoardApi.a(String.valueOf(_board.getUid()), onBoardLoaded, getApiTag());
        }

        public void onEventMainThread(com.pinterest.api.model.Board.UpdateEvent updateevent)
        {
            if (_board != null && updateevent.getBoard().getUid().equals(_board.getUid()))
            {
                _board = updateevent.getBoard();
                if (updateevent.wasDeleted())
                {
                    getActivity().onBackPressed();
                } else
                {
                    setEmptyViewButton();
                    updateActionBar();
                    if (_header != null)
                    {
                        _header.setBoard(_board);
                    }
                    if (_metadataBar != null)
                    {
                        _metadataBar.setModel(_board, com.pinterest.ui.actionbar.MetadataBar.Mode.PINS);
                    }
                    if (_floatingMetadataBar != null)
                    {
                        _floatingMetadataBar.setModel(_board, com.pinterest.ui.actionbar.MetadataBar.Mode.PINS);
                    }
                    if (updateevent.refreshFeed())
                    {
                        refresh();
                        return;
                    }
                }
            }
        }

        public void onEventMainThread(com.pinterest.api.model.User.UpdateEvent updateevent)
        {
            if (_user != null && updateevent.getUser().getUid().equals(_user.getUid()))
            {
                _user = updateevent.getUser();
                updateEmptyContent();
            }
        }

        _cls5()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls6 extends BaseApiResponseHandler
    {

        final BaseBoardFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            handleBatch((PinterestJsonObject)apiresponse.getData());
        }

        _cls6()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls7 extends com.pinterest.api.remote.BoardApi.BoardApiResponse
    {

        final BaseBoardFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            if (apiresponse.getCode() == 40)
            {
                Events.post(new com.pinterest.api.model.Board.BoardDoesNotExistEvent(apiresponse));
            }
            if (_board == null)
            {
                throwable = getActivity();
                if (throwable != null)
                {
                    throwable.onBackPressed();
                }
            }
        }

        public void onSuccess(Board board)
        {
            super.onSuccess(board);
            _board = board;
            _user = _board.getUser();
            if (_header != null)
            {
                _header.setUser(_user);
                _header.setBoard(_board);
            }
            if (_metadataBar != null)
            {
                _metadataBar.setModel(_board);
            }
            if (_floatingMetadataBar != null)
            {
                _floatingMetadataBar.setModel(_board);
            }
            updateActionBar();
            setEmptyViewButton();
        }

        _cls7()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls8 extends com.pinterest.api.remote.ExperiencesApi.ExperienceResponseHandler
    {

        final BaseBoardFragment this$0;

        public void onSuccess()
        {
            if (isActive())
            {
                _eduRunnable = EducationHelper.a(Placement.ANDROID_BOARD_TAKEOVER, BaseBoardFragment.this);
            }
        }

        _cls8()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls9 extends com.pinterest.api.remote.MyUserApi.BoardInviteFeedResponse
    {

        final BaseBoardFragment this$0;

        public void onSuccess(Feed feed)
        {
            super.onSuccess(feed);
            updateInvite((BoardInviteFeed)feed);
        }

        _cls9()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final BaseBoardFragment this$0;

        public void onClick(View view)
        {
            view = new Navigation(Location.PLACE_PICKER);
            view.putExtra("com.pinterest.EXTRA_MODE", com.pinterest.activity.place.fragment.PlacePickerFragment.Mode.CREATE);
            view.putExtra("com.pinterest.EXTRA_BOARD_ID", _board.getUid());
            Events.post(view);
        }

        _cls4()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls3 extends BackgroundTask
    {

        BoardInvite invite;
        User inviter;
        final BaseBoardFragment this$0;
        final BoardInviteFeed val$feed;

        public void onFinish()
        {
            super.onFinish();
            View view = getView();
            if (view != null)
            {
                if (invite != null && invite.getStatus().equals("new"))
                {
                    if (_inviteHeader == null)
                    {
                        _inviteHeader = (BoardHeaderInviteView)LayoutInflater.from(view.getContext()).inflate(0x7f03011b, _inviteWrapper, false);
                        _inviteHeader.setApiTag(getApiTag());
                        _inviteWrapper.addView(_inviteHeader);
                    }
                    _inviteHeader.setBoard(_board);
                    _inviteHeader.setInviter(inviter);
                    _inviteHeader.setVisibility(0);
                    return;
                }
                if (_inviteHeader != null)
                {
                    _inviteHeader.setVisibility(8);
                    return;
                }
            }
        }

        public void run()
        {
            if (_board != null)
            {
                if (feed != null && feed.getCount() > 0)
                {
                    invite = (BoardInvite)feed.get(0);
                } else
                {
                    invite = ModelHelper.getBoardInviteAcceptable(_board.getUid());
                }
                if (invite != null)
                {
                    inviter = ModelHelper.getUser(invite.getInviterUid());
                }
            }
        }

        _cls3()
        {
            this$0 = BaseBoardFragment.this;
            feed = boardinvitefeed;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final BaseBoardFragment this$0;

        public void run()
        {
            updateMetadataBarState();
        }

        _cls1()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }


    private class _cls2 extends com.pinterest.ui.scrollview.ObservableScrollView.ScrollViewListener
    {

        final BaseBoardFragment this$0;

        public void onScroll(View view, int i, int j, int k, int l)
        {
            if (Experiments.d())
            {
                updateMetadataBarState();
            }
        }

        _cls2()
        {
            this$0 = BaseBoardFragment.this;
            super();
        }
    }

}
