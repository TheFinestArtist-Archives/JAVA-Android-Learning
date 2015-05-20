// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.pinterest.api.model.Board;
import com.pinterest.api.model.BoardFeed;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.Place;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Constants;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NearbyPinsData
{

    private static Map ALL_PLACES = new HashMap();
    private static final int HOMEFEED_PAGE_SIZE = 200;

    public NearbyPinsData()
    {
    }

    public static void clearPlacesData()
    {
        ALL_PLACES.clear();
    }

    private static List extractAndStorePlaces(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (Pin)list.next();
            if (Constants.isTrue(((Pin) (obj)).getHasPlace()))
            {
                obj = ((Pin) (obj)).getPlace();
                if (!wasPlaceNotified(((Place) (obj)).getUid()))
                {
                    ALL_PLACES.put(((Place) (obj)).getUid(), obj);
                    arraylist.add(obj);
                }
            }
        } while (true);
        return arraylist;
    }

    public static boolean hasPlacesData()
    {
        return ALL_PLACES.size() > 0;
    }

    private static void loadHomePlacePins(final Callback cb)
    {
        MyUserApi.a(new _cls1());
    }

    private static void loadMyBoards(final Callback cb)
    {
        UserApi.a(MyUser.getUid(), new _cls2(), null);
    }

    private static void loadPlaceBoardsPins(BoardFeed boardfeed, final Callback cb)
    {
        final ArrayList ids = new ArrayList();
        boardfeed = boardfeed.getItems().iterator();
        do
        {
            if (!boardfeed.hasNext())
            {
                break;
            }
            Board board = (Board)boardfeed.next();
            if (board.isPlaceBoard())
            {
                ids.add(board.getUid());
            }
        } while (true);
        BoardApi.a(ids, new _cls3());
    }

    public static void loadPlaces(Callback callback)
    {
        loadHomePlacePins(callback);
        loadMyBoards(callback);
    }

    public static void markPlaceNotified(String s)
    {
        Set set = Preferences.user().getStringSet("PREF_VISITED_PLACES", new HashSet(1));
        set.add(s);
        Preferences.user().set("PREF_VISITED_PLACES", set);
    }

    public static boolean wasPlaceNotified(String s)
    {
        return Preferences.user().getStringSet("PREF_VISITED_PLACES", Collections.EMPTY_SET).contains(s);
    }




    private class _cls1 extends com.pinterest.api.remote.PinApi.PinFeedApiResponse
    {

        final Callback val$cb;

        public final void onSuccess(final Feed feed)
        {
            super.onSuccess(feed);
            class _cls1 extends BackgroundTask
            {

                final _cls1 this$0;
                final Feed val$feed;

                public void run()
                {
                    List list = NearbyPinsData.extractAndStorePlaces(((PinFeed)feed).getItems());
                    cb.onPlacesLoaded(list);
                }

                _cls1()
                {
                    this$0 = _cls1.this;
                    feed = feed1;
                    super();
                }

                private class Callback
                {

                    public abstract void onPlacesLoaded(List list);
                }

            }

            (new _cls1()).execute();
        }

        _cls1()
        {
            cb = callback;
            super();
        }
    }


    private class _cls2 extends com.pinterest.api.remote.BoardApi.BoardFeedApiResponse
    {

        final Callback val$cb;

        public final void onSuccess(Feed feed)
        {
            super.onSuccess(feed);
            NearbyPinsData.loadPlaceBoardsPins((BoardFeed)feed, cb);
        }

        _cls2()
        {
            cb = callback;
            super();
        }
    }


    private class _cls3 extends com.pinterest.api.remote.PinApi.PinFeedApiResponse
    {

        final Callback val$cb;
        final List val$ids;

        public final void onSuccess(final ApiResponse data)
        {
            super.onSuccess(data);
            data = (PinterestJsonObject)data.getData();
            class _cls1 extends BackgroundTask
            {

                final _cls3 this$0;
                final PinterestJsonObject val$data;

                public void run()
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator = ids.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        Object obj = (String)iterator.next();
                        obj = (new ApiResponse(data.c(String.format("GET:/v3/boards/%s/pins/", new Object[] {
                            obj
                        })))).getData();
                        if (obj instanceof PinterestJsonArray)
                        {
                            arraylist.addAll(NearbyPinsData.extractAndStorePlaces(Pin.makeAll((PinterestJsonArray)obj)));
                        }
                    } while (true);
                    cb.onPlacesLoaded(arraylist);
                }

                _cls1()
                {
                    this$0 = _cls3.this;
                    data = pinterestjsonobject;
                    super();
                }
            }

            if (data != null)
            {
                (new _cls1()).execute();
            }
        }

        _cls3()
        {
            ids = list;
            cb = callback;
            super();
        }
    }

}
