// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search;

import android.text.TextUtils;
import com.pinterest.activity.search.event.GuidedSearchEvent;
import com.pinterest.activity.search.event.SearchSuggestionEvent;
import com.pinterest.activity.search.ui.GuidedSearchBar;
import com.pinterest.api.model.SearchFilter;
import com.pinterest.base.Device;

// Referenced classes of package com.pinterest.activity.search:
//            GuidedSearchFragment

class this._cls0 extends com.pinterest.base.
{

    final GuidedSearchFragment this$0;

    public void onEventMainThread(GuidedSearchEvent guidedsearchevent)
    {
        boolean flag = false;
        if (TextUtils.isEmpty(guidedsearchevent.getQuery()) && !guidedsearchevent.getForceRefresh()) goto _L2; else goto _L1
_L1:
        GuidedSearchFragment.access$100(GuidedSearchFragment.this).loseFocus();
        Device.hideSoftKeyboard(GuidedSearchFragment.access$100(GuidedSearchFragment.this));
        if (!guidedsearchevent.isTokenFilter()) goto _L4; else goto _L3
_L3:
        if (GuidedSearchFragment.access$100(GuidedSearchFragment.this).addTokenFilter(guidedsearchevent.getQuery(), guidedsearchevent.getDominantColor(), guidedsearchevent.isTokenFront(), false)) goto _L5; else goto _L2
_L2:
        return;
_L5:
        GuidedSearchFragment.access$400(GuidedSearchFragment.this, guidedsearchevent, guidedsearchevent.getQuery(), com.pinterest.activity.search.model.pe.FILTER);
        guidedsearchevent.setQuery(GuidedSearchFragment.access$100(GuidedSearchFragment.this).getCurrentTokenQuery(false));
_L7:
        guidedsearchevent.setQueryMetaList(GuidedSearchFragment.access$100(GuidedSearchFragment.this).getQueryMetaDataList());
        guidedsearchevent.setLastQueryData(GuidedSearchFragment.access$100(GuidedSearchFragment.this).getLastQueryDataWithFilters());
        guidedsearchevent.setLastQueryState(GuidedSearchFragment.access$100(GuidedSearchFragment.this).getLastQueryState());
        GuidedSearchFragment.access$500(GuidedSearchFragment.this, guidedsearchevent);
        return;
_L4:
        if (guidedsearchevent.getActionFilter() != null)
        {
            Object obj = guidedsearchevent.getActionFilter();
            boolean flag1 = com.pinterest.api.model..MODE.getValue().equals(((SearchFilter) (obj)).getType());
            Object obj1 = GuidedSearchFragment.access$100(GuidedSearchFragment.this);
            String s = guidedsearchevent.getDominantColor();
            if (flag1 || guidedsearchevent.isTokenFront())
            {
                flag = true;
            }
            if (!((GuidedSearchBar) (obj1)).addSearchFilter(((SearchFilter) (obj)), s, flag, flag1))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = GuidedSearchFragment.this;
            s = ((SearchFilter) (obj)).getTypeValue();
            if (flag1)
            {
                obj = com.pinterest.activity.search.model.pe.MODE;
            } else
            {
                obj = com.pinterest.activity.search.model.pe.ACTION_FILTER;
            }
            GuidedSearchFragment.access$400(((GuidedSearchFragment) (obj1)), guidedsearchevent, s, ((com.pinterest.activity.search.model.pe) (obj)));
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void onEventMainThread(SearchSuggestionEvent searchsuggestionevent)
    {
        com.pinterest.api.remote.nt nt = com.pinterest.api.remote.nt;
        if (searchsuggestionevent.getType() == com.pinterest.activity.search.event.uggestionType.RECENT_QUERY)
        {
            if ("VALUE_SEARCH_GLOBAL".equals(GuidedSearchFragment.access$200(GuidedSearchFragment.this)))
            {
                nt = com.pinterest.api.remote.nt;
            } else
            {
                nt = com.pinterest.api.remote.nt;
            }
        } else
        if ("VALUE_SEARCH_GLOBAL".equals(GuidedSearchFragment.access$200(GuidedSearchFragment.this)))
        {
            nt = com.pinterest.api.remote.nt;
        } else
        {
            nt = com.pinterest.api.remote.nt;
        }
        GuidedSearchFragment.access$300(GuidedSearchFragment.this, searchsuggestionevent.getQuery(), nt);
    }

    vent()
    {
        this$0 = GuidedSearchFragment.this;
        super();
    }
}
