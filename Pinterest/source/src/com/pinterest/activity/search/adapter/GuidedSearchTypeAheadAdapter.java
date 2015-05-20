// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.pinterest.activity.search.model.GuidedSearchTypeAheadItem;
import com.pinterest.activity.search.ui.GuidedSearchDropDownCell;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class GuidedSearchTypeAheadAdapter extends BaseAdapter
    implements Filterable
{

    private String _apiTag;
    private Map _cacheditemsMap;
    private Context _context;
    private String _currentSearchTerm;
    private Handler _handler;
    private Map _itemsMap;
    private LayoutInflater _li;
    private String _searchMode;
    private com.pinterest.api.remote.SearchApi.Scope _searchScope;
    private com.pinterest.activity.search.event.GuidedSearchEvent.SearchType _searchType;
    private android.view.View.OnClickListener onDeleteRecentQuery;

    public GuidedSearchTypeAheadAdapter(Context context)
    {
        _itemsMap = Collections.emptyMap();
        _cacheditemsMap = Collections.emptyMap();
        _currentSearchTerm = "";
        _searchScope = com.pinterest.api.remote.SearchApi.Scope.d;
        _searchType = com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN;
        onDeleteRecentQuery = new _cls5();
        _context = context;
        _li = (LayoutInflater)context.getSystemService("layout_inflater");
        _handler = new Handler();
    }

    private void mergeApiResultsWithRealmData(List list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType searchtype)
    {
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype;
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype1;
        if (_itemsMap.get(searchtype) != null)
        {
            searchtype = (List)_itemsMap.get(searchtype);
        } else
        {
            searchtype = new ArrayList();
        }
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN;
        itemtype1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN;
        for (int i = 0; i < list.size(); i++)
        {
            GuidedSearchTypeAheadItem guidedsearchtypeaheaditem = (GuidedSearchTypeAheadItem)list.get(i);
            if (guidedsearchtypeaheaditem.getItemType() != itemtype1 && guidedsearchtypeaheaditem.getItemType() != itemtype)
            {
                break;
            }
            if (searchtype != null && !searchtype.contains(guidedsearchtypeaheaditem))
            {
                searchtype.add(guidedsearchtypeaheaditem);
            }
        }

        if (searchtype.size() > 0)
        {
            _itemsMap.put(com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN, searchtype);
        }
    }

    private void setAutoCompleteData(List list)
    {
        if (_itemsMap.isEmpty())
        {
            _itemsMap = new HashMap();
        }
        if (StringUtils.equals(_searchMode, "VALUE_SEARCH_GLOBAL"))
        {
            setSectionedAutoCompleteData(list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN);
            setSectionedAutoCompleteData(list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PINNER);
            setSectionedAutoCompleteData(list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.BOARD);
            return;
        } else
        {
            setSectionedAutoCompleteData(list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN);
            return;
        }
    }

    private void setSectionedAutoCompleteData(List list, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType searchtype)
    {
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype;
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype1;
        Object obj;
        Object obj1;
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype2;
        ArrayList arraylist;
        String s1;
        int i;
        boolean flag;
        i = 1;
        flag = false;
        arraylist = new ArrayList();
        s1 = Resources.string(0x7f0e0429, new Object[] {
            _currentSearchTerm
        });
        obj = "";
        itemtype2 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_SEARCH_ALL;
        obj1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN_HEADER;
        itemtype1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN;
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN;
        _cls6..SwitchMap.com.pinterest.activity.search.event.GuidedSearchEvent.SearchType[searchtype.ordinal()];
        JVM INSTR tableswitch 1 3: default 92
    //                   1 267
    //                   2 412
    //                   3 444;
           goto _L1 _L2 _L3 _L4
_L1:
        i = 0;
_L14:
        if (i == 0) goto _L6; else goto _L5
_L5:
        if (_itemsMap.get(searchtype) == null) goto _L8; else goto _L7
_L7:
        obj = (List)_itemsMap.get(searchtype);
          goto _L9
_L2:
        itemtype3 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_SEARCH_ALL;
        itemtype4 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN_HEADER;
        if (!StringUtils.equals(_searchMode, "VALUE_SEARCH_GLOBAL")) goto _L11; else goto _L10
_L10:
        s = Resources.string(0x7f0e0427);
        itemtype5 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN;
        itemtype6 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN;
        itemtype = itemtype6;
        itemtype1 = itemtype5;
        obj1 = itemtype4;
        itemtype2 = itemtype3;
        obj = s;
        if (!Experiments.p()) goto _L1; else goto _L12
_L12:
        itemtype = itemtype6;
        itemtype1 = itemtype5;
        obj1 = itemtype4;
        itemtype2 = itemtype3;
        obj = s;
        if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.d) goto _L1; else goto _L13
_L13:
        itemtype = itemtype6;
        itemtype1 = itemtype5;
        obj1 = itemtype4;
        itemtype2 = itemtype3;
        obj = s;
          goto _L14
_L11:
        obj = Resources.string(0x7f0e03d2);
        itemtype1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD;
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_MY_PIN;
        i = 0;
        obj1 = itemtype4;
        itemtype2 = itemtype3;
          goto _L14
_L3:
        obj = Resources.string(0x7f0e0428);
        itemtype2 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PINNER_SEARCH_ALL;
        obj1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER_HEADER;
        itemtype1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PINNER;
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER;
        i = 0;
          goto _L14
_L4:
        obj = Resources.string(0x7f0e0425);
        itemtype2 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD_SEARCH_ALL;
        obj1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD_HEADER;
        itemtype1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD;
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD;
        i = 0;
          goto _L14
_L6:
        GuidedSearchTypeAheadItem guidedsearchtypeaheaditem = new GuidedSearchTypeAheadItem();
        if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.b || _searchScope == com.pinterest.api.remote.SearchApi.Scope.c)
        {
            guidedsearchtypeaheaditem.setTitle(s1);
            guidedsearchtypeaheaditem.setItemType(itemtype2);
        } else
        {
            guidedsearchtypeaheaditem.setTitle(((String) (obj)));
            guidedsearchtypeaheaditem.setItemType(((com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType) (obj1)));
        }
        arraylist.add(guidedsearchtypeaheaditem);
        if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.b || _searchScope == com.pinterest.api.remote.SearchApi.Scope.c)
        {
            obj = new GuidedSearchTypeAheadItem();
            ((GuidedSearchTypeAheadItem) (obj)).setItemType(com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.HEADER_DIVIDER);
            arraylist.add(obj);
        }
_L8:
        obj = arraylist;
_L9:
        i = ((flag) ? 1 : 0);
        if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.c)
        {
            obj1 = new GuidedSearchTypeAheadItem();
            ((GuidedSearchTypeAheadItem) (obj1)).setTitle(Resources.string(0x7f0e051f));
            ((GuidedSearchTypeAheadItem) (obj1)).setItemType(com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD_HEADER);
            ((List) (obj)).add(obj1);
            i = ((flag) ? 1 : 0);
        }
        do
        {
            if (i >= list.size())
            {
                break;
            }
            obj1 = (GuidedSearchTypeAheadItem)list.get(i);
            com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype3;
            com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype4;
            String s;
            com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype5;
            com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype6;
            if (Experiments.p() && searchtype == com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN && ((GuidedSearchTypeAheadItem) (obj1)).getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN)
            {
                if (obj != null && !((List) (obj)).contains(obj1))
                {
                    ((List) (obj)).add(obj1);
                }
            } else
            if (((GuidedSearchTypeAheadItem) (obj1)).getItemType() == itemtype1 || ((GuidedSearchTypeAheadItem) (obj1)).getItemType() == itemtype)
            {
                ((List) (obj)).add(obj1);
            }
            i++;
        } while (true);
        _itemsMap.put(searchtype, obj);
        return;
          goto _L14
    }

    private void setTypeAheadRealmData(List list)
    {
        boolean flag = false;
        if (_itemsMap.isEmpty())
        {
            _itemsMap = new HashMap();
        }
        ArrayList arraylist = new ArrayList();
        String s = Resources.string(0x7f0e0429, new Object[] {
            _currentSearchTerm
        });
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_SEARCH_ALL;
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN_HEADER;
        itemtype = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_SEARCH_ALL;
        com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType itemtype1 = com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN_HEADER;
        String s1 = Resources.string(0x7f0e0427);
        GuidedSearchTypeAheadItem guidedsearchtypeaheaditem1 = new GuidedSearchTypeAheadItem();
        int i;
        if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.b)
        {
            guidedsearchtypeaheaditem1.setTitle(s);
            guidedsearchtypeaheaditem1.setItemType(itemtype);
        } else
        {
            guidedsearchtypeaheaditem1.setTitle(s1);
            guidedsearchtypeaheaditem1.setItemType(itemtype1);
        }
        arraylist.add(guidedsearchtypeaheaditem1);
        i = ((flag) ? 1 : 0);
        if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.b)
        {
            GuidedSearchTypeAheadItem guidedsearchtypeaheaditem = new GuidedSearchTypeAheadItem();
            guidedsearchtypeaheaditem.setItemType(com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.HEADER_DIVIDER);
            arraylist.add(guidedsearchtypeaheaditem);
            i = ((flag) ? 1 : 0);
        }
        for (; i < list.size(); i++)
        {
            arraylist.add(list.get(i));
        }

        _itemsMap.put(com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN, arraylist);
    }

    private void updateData(final String searchTerm, final List newData)
    {
        _handler.post(new _cls3());
    }

    public int getCount()
    {
        if (_itemsMap.get(_searchType) != null)
        {
            return ((List)_itemsMap.get(_searchType)).size();
        } else
        {
            return 0;
        }
    }

    public String getCurrentSearchTerm()
    {
        return _currentSearchTerm;
    }

    public Filter getFilter()
    {
        return new _cls2();
    }

    public Object getItem(int i)
    {
        List list = (List)_itemsMap.get(_searchType);
        if (list == null)
        {
            return null;
        } else
        {
            return (GuidedSearchTypeAheadItem)list.get(i);
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view instanceof GuidedSearchDropDownCell)
        {
            view = (GuidedSearchDropDownCell)view;
        } else
        {
            view = (GuidedSearchDropDownCell)_li.inflate(0x7f0300e7, viewgroup, false);
            view.setRightIvOnClickListener(onDeleteRecentQuery);
        }
        view.setOnTouchListener(new _cls1());
        view.setItem((GuidedSearchTypeAheadItem)getItem(i));
        return view;
    }

    public void loadCachedData()
    {
        if (_cacheditemsMap != null && !_cacheditemsMap.isEmpty())
        {
            _itemsMap = _cacheditemsMap;
            notifyDataSetChanged();
        }
    }

    public void loadRealmData(final String searchTerm, final List newData)
    {
        _handler.post(new _cls4());
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }

    public void setSearchMode(String s)
    {
        _searchMode = s;
    }

    public void setSearchScope(com.pinterest.api.remote.SearchApi.Scope scope)
    {
        _searchScope = scope;
    }

    public void setSearchType(com.pinterest.activity.search.event.GuidedSearchEvent.SearchType searchtype)
    {
        _searchType = searchtype;
    }





/*
    static String access$202(GuidedSearchTypeAheadAdapter guidedsearchtypeaheadadapter, String s)
    {
        guidedsearchtypeaheadadapter._currentSearchTerm = s;
        return s;
    }

*/




/*
    static Map access$502(GuidedSearchTypeAheadAdapter guidedsearchtypeaheadadapter, Map map)
    {
        guidedsearchtypeaheadadapter._cacheditemsMap = map;
        return map;
    }

*/




    private class _cls5
        implements android.view.View.OnClickListener
    {

        final GuidedSearchTypeAheadAdapter this$0;

        public void onClick(View view)
        {
            GuidedSearchTypeAheadItem guidedsearchtypeaheaditem = (GuidedSearchTypeAheadItem)view.getTag();
            _cls6..SwitchMap.com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType[guidedsearchtypeaheaditem.getItemType().ordinal()];
            JVM INSTR tableswitch 1 4: default 48
        //                       1 146
        //                       2 156
        //                       3 166
        //                       4 176;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            com.pinterest.activity.search.event.GuidedSearchEvent.SearchType searchtype;
            searchtype = com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN;
            view = "PIN";
_L7:
            SearchApi.d(guidedsearchtypeaheaditem.getTitle(), view, new DeleteRecentQueryApiResponse(null), _apiTag);
            if (_itemsMap.get(searchtype) != null && ((List)_itemsMap.get(searchtype)).remove(guidedsearchtypeaheaditem))
            {
                _cacheditemsMap = _itemsMap;
                notifyDataSetChanged();
            }
            return;
_L2:
            searchtype = com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN;
            view = "PIN";
            continue; /* Loop/switch isn't completed */
_L3:
            searchtype = com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.BOARD;
            view = "BOARD";
            continue; /* Loop/switch isn't completed */
_L4:
            searchtype = com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PINNER;
            view = "USER";
            continue; /* Loop/switch isn't completed */
_L5:
            searchtype = com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN;
            view = "PERSONAL";
            if (true) goto _L7; else goto _L6
_L6:
        }

        _cls5()
        {
            this$0 = GuidedSearchTypeAheadAdapter.this;
            super();
        }

        private class DeleteRecentQueryApiResponse extends BaseApiResponseHandler
        {

            final GuidedSearchTypeAheadAdapter this$0;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                Application.showToast(apiresponse.getMessage());
            }

            public void onSuccess(ApiResponse apiresponse)
            {
            }

            private DeleteRecentQueryApiResponse()
            {
                this$0 = GuidedSearchTypeAheadAdapter.this;
                super();
            }

            DeleteRecentQueryApiResponse(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class _cls6
    {

        static final int $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[];
        static final int $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[];

        static 
        {
            $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType = new int[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_MY_PIN.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType = new int[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PINNER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.BOARD.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls3
        implements Runnable
    {

        final GuidedSearchTypeAheadAdapter this$0;
        final List val$newData;
        final String val$searchTerm;

        public void run()
        {
            if (StringUtils.equals(searchTerm, _currentSearchTerm))
            {
                setAutoCompleteData(newData);
                if (_searchScope == com.pinterest.api.remote.SearchApi.Scope.d || _searchScope == com.pinterest.api.remote.SearchApi.Scope.e)
                {
                    _cacheditemsMap = _itemsMap;
                }
                notifyDataSetChanged();
            }
        }

        _cls3()
        {
            this$0 = GuidedSearchTypeAheadAdapter.this;
            searchTerm = s;
            newData = list;
            super();
        }
    }


    private class _cls2 extends Filter
    {

        final GuidedSearchTypeAheadAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            charsequence = new android.widget.Filter.FilterResults();
            List list = (List)_itemsMap.get(_searchType);
            charsequence.values = list;
            charsequence.count = list.size();
            return charsequence;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
        }

        _cls2()
        {
            this$0 = GuidedSearchTypeAheadAdapter.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final GuidedSearchTypeAheadAdapter this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0)
            {
                Device.hideSoftKeyboard(view);
            }
            return false;
        }

        _cls1()
        {
            this$0 = GuidedSearchTypeAheadAdapter.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final GuidedSearchTypeAheadAdapter this$0;
        final List val$newData;
        final String val$searchTerm;

        public void run()
        {
            if (StringUtils.equals(searchTerm, _currentSearchTerm))
            {
                setTypeAheadRealmData(newData);
                notifyDataSetChanged();
            }
        }

        _cls4()
        {
            this$0 = GuidedSearchTypeAheadAdapter.this;
            searchTerm = s;
            newData = list;
            super();
        }
    }

}
