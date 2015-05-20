// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.LatLng;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.board.view.BoardHeaderView;
import com.pinterest.activity.board.view.PlaceBoardLayout;
import com.pinterest.activity.map.GoogleServiceDialog;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Place;
import com.pinterest.base.Application;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.base.GooglePlayServices;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.PinterestAdapterView;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.board.fragment:
//            BaseBoardFragment, BoardMapFragment

public class BoardFragment extends BaseBoardFragment
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private Handler _handler;
    private LatLng _initCenter;
    private View _mapContainer;
    private BoardMapFragment _mapFragment;
    private boolean _mapShown;
    private PlaceBoardLayout _placeBoardLayout;
    private Runnable _showMapRunnable;
    private BoardMapState _state;
    private android.view.View.OnClickListener boardDescOnClickListener;
    private int googlePlayServicesResult;
    private com.pinterest.fragment.MapFragment.Listener onMapReady;
    private android.view.View.OnTouchListener scrollViewListener;

    public BoardFragment()
    {
        _state = BoardMapState.CLOSED;
        _handler = new Handler(Looper.getMainLooper());
        _showMapRunnable = new _cls2();
        onMapReady = new _cls3();
        scrollViewListener = new _cls4();
        boardDescOnClickListener = new _cls5();
        googlePlayServicesResult = -1;
        _eventsSubscriber = new _cls6();
    }

    private void adjustEmptyIfNeeded()
    {
        if (_gridVw != null)
        {
            fillViewWithPadding(_gridVw.getEmptyView());
        }
    }

    private void adjustFooterIfNeeded()
    {
        if (_gridVw != null)
        {
            fillViewWithPadding(_gridVw.getFooterView());
        }
    }

    private void createMapFragment()
    {
        if (_mapFragment != null)
        {
            return;
        } else
        {
            _handler.postDelayed(_showMapRunnable, Constants.ANIM_SPEED_SLOW);
            return;
        }
    }

    private void fillViewWithPadding(final View v)
    {
        if (_gridVw == null || v == null)
        {
            return;
        } else
        {
            v.post(new _cls7());
            return;
        }
    }

    private boolean showAsPlaceBoard(Board board)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (board != null)
        {
            flag = flag1;
            if (board.isPlaceBoard())
            {
                if (googlePlayServicesResult == -1)
                {
                    googlePlayServicesResult = GooglePlayServicesUtil.isGooglePlayServicesAvailable(Application.context());
                }
                flag = flag1;
                if (googlePlayServicesResult == 0)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void updateLayout(View view)
    {
        for (android.support.v4.app.FragmentActivity fragmentactivity = getActivity(); fragmentactivity == null || fragmentactivity.isFinishing() || !isAdded() || view == null || _board == null;)
        {
            return;
        }

        boolean flag = showAsPlaceBoard(_board);
        _placeBoardLayout.setMapShown(flag);
        _header.updateLayout(flag);
        if (_mapContainer == null)
        {
            _mapContainer = view.findViewById(0x7f0b0126);
        }
        if (flag)
        {
            createMapFragment();
            _header.setDescOnClickListener(boardDescOnClickListener);
            _gridVw.setOnTouchListener(scrollViewListener);
            _gridVw.setAdapterViewPadding(0, (int)Resources.dimension(0x7f0a0098), 0, 0);
            _gridVw.getAdapterView().setBackgroundColor(Resources.color(0x7f090011));
            return;
        }
        FragmentHelper.replaceFragment(this, 0x7f0b0126, null, false);
        if (_mapFragment != null)
        {
            _mapFragment.setListener(null);
            _mapFragment = null;
        }
        _gridVw.getAdapterView().setBackgroundColor(Resources.color(0x106000d));
    }

    private void updateMapVisibility(int i)
    {
        if (_mapContainer == null)
        {
            return;
        }
        if (!showAsPlaceBoard(_board))
        {
            i = 1;
        }
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            _mapContainer.setVisibility(8);
            return;

        case 1: // '\001'
        case 2: // '\002'
            _mapContainer.setVisibility(0);
            break;
        }
        adjustEmptyIfNeeded();
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber, com/pinterest/activity/board/fragment/BoardFragment$BoardMapState, new Class[] {
            com/pinterest/events/FeedEvents$MadeNewPin, com/pinterest/api/model/Board$UpdateEvent
        });
        Events.registerSticky(_eventsSubscriber, com/pinterest/api/model/Board$UpdateEvent, new Class[0]);
        updateLayout(getView());
        if (_gridVw != null)
        {
            updateMapVisibility(_gridVw.getEmptyView().getState());
        }
    }

    protected void onDeactivate()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/activity/board/fragment/BoardFragment$BoardMapState, com/pinterest/events/FeedEvents$MadeNewPin, com/pinterest/api/model/Board$UpdateEvent
        });
        _handler.removeCallbacks(_showMapRunnable);
        super.onDeactivate();
    }

    public void onDestroyView()
    {
        if (_mapFragment != null)
        {
            _mapFragment.setListener(null);
        }
        _mapFragment = null;
        _mapContainer = null;
        _placeBoardLayout = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _placeBoardLayout = (PlaceBoardLayout)view.findViewById(0x7f0b0125);
        _placeBoardLayout.setMapShown(showAsPlaceBoard(_board));
        _gridVw.getEmptyView().setBackgroundColor(Resources.color(0x7f090011));
        _gridVw.setOnStateSetListener(new _cls1());
        if (_board != null && _board.isPlaceBoard() && !GooglePlayServices.isAvailable())
        {
            GoogleServiceDialog.show();
        }
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        Object obj = navigation.getExtra("com.pinterest.EXTRA_MODE");
        if (obj != null)
        {
            _state = (BoardMapState)obj;
        }
        navigation = ((Navigation) (navigation.getExtra("com.pinterest.EXTRA_PLACE_ID")));
        if (navigation != null)
        {
            navigation = ModelHelper.getPlace((String)navigation);
            if (navigation.getLatitude() != null && navigation.getLongitude() != null)
            {
                _initCenter = new LatLng(navigation.getLatitude().doubleValue(), navigation.getLongitude().doubleValue());
            }
        }
    }





/*
    static BoardMapFragment access$102(BoardFragment boardfragment, BoardMapFragment boardmapfragment)
    {
        boardfragment._mapFragment = boardmapfragment;
        return boardmapfragment;
    }

*/




/*
    static BoardMapState access$1202(BoardFragment boardfragment, BoardMapState boardmapstate)
    {
        boardfragment._state = boardmapstate;
        return boardmapstate;
    }

*/





/*
    static boolean access$1502(BoardFragment boardfragment, boolean flag)
    {
        boardfragment._mapShown = flag;
        return flag;
    }

*/
















    private class BoardMapState extends Enum
    {

        private static final BoardMapState $VALUES[];
        public static final BoardMapState CLOSED;
        public static final BoardMapState OPEN;

        public static BoardMapState valueOf(String s)
        {
            return (BoardMapState)Enum.valueOf(com/pinterest/activity/board/fragment/BoardFragment$BoardMapState, s);
        }

        public static BoardMapState[] values()
        {
            return (BoardMapState[])$VALUES.clone();
        }

        static 
        {
            OPEN = new BoardMapState("OPEN", 0);
            CLOSED = new BoardMapState("CLOSED", 1);
            $VALUES = (new BoardMapState[] {
                OPEN, CLOSED
            });
        }

        private BoardMapState(String s, int i)
        {
            super(s, i);
        }
    }



    private class _cls3 extends com.pinterest.fragment.MapFragment.Listener
    {

        final BoardFragment this$0;

        public void onReady()
        {
            if (_mapFragment != null && _mapFragment.getMap() != null && _mapContainer != null && _header != null)
            {
                Object obj = new Point(_mapContainer.getWidth() / 2, _mapContainer.getHeight() / 2);
                obj = _mapFragment.getMap().getProjection().fromScreenLocation(((Point) (obj)));
                _header.setLatLng(((LatLng) (obj)));
                if (_state == BoardMapState.OPEN)
                {
                    _placeBoardLayout.switchMapState(true);
                }
                if (_initCenter != null)
                {
                    _mapFragment.setInitCenter(_initCenter);
                    return;
                }
            }
        }

        _cls3()
        {
            this$0 = BoardFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnTouchListener
    {

        final BoardFragment this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return _mapShown;
        }

        _cls4()
        {
            this$0 = BoardFragment.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final BoardFragment this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.BOARD_DESCRIPTION, ComponentType.LIST_HEADER);
            view = _placeBoardLayout;
            boolean flag;
            if (_state != BoardMapState.OPEN)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.switchMapState(flag);
        }

        _cls5()
        {
            this$0 = BoardFragment.this;
            super();
        }
    }


    private class _cls6 extends com.pinterest.base.Events.EventsSubscriber
    {

        final BoardFragment this$0;

        public void onEventMainThread(BoardMapState boardmapstate)
        {
            _state = boardmapstate;
            BoardFragment boardfragment = BoardFragment.this;
            boolean flag;
            if (boardmapstate == BoardMapState.OPEN)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boardfragment._mapShown = flag;
            _header.onMapStateChanged(boardmapstate);
        }

        public void onEventMainThread(com.pinterest.api.model.Board.UpdateEvent updateevent)
        {
            Events.removeStickyEvent(updateevent);
            updateLayout(getView());
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public void onEventMainThread(com.pinterest.events.FeedEvents.MadeNewPin madenewpin)
        {
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        _cls6()
        {
            this$0 = BoardFragment.this;
            super();
        }
    }



}
