// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.sendapin.adapter;

import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.activity.sendapin.providers.ContactsProvider;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.base.ApplicationInfo;
import java.util.List;

// Referenced classes of package com.pinterest.activity.sendapin.adapter:
//            PeopleSearchAdapter

class query extends BaseApiResponseHandler
{

    private String query;
    final PeopleSearchAdapter this$0;

    private void parseData(ApiResponse apiresponse)
    {
        List list = TypeAheadItem.parseData(apiresponse.getData());
        Object obj = ContactsProvider.getContactsWithEmail(_context, query, _emailMaxCount);
        apiresponse = ((ApiResponse) (obj));
        if (getSearchScope() == com.pinterest.api.remote.e)
        {
            apiresponse = ContactsProvider.getContactsWithPhoneNumber(_context, query, _phoneMaxCount);
            if (obj != null && !((List) (obj)).isEmpty())
            {
                ((List) (obj)).addAll(apiresponse);
                apiresponse = ((ApiResponse) (obj));
            }
        }
        obj = query;
        list.size();
        apiresponse.size();
        if (ApplicationInfo.isNonProduction() && PeopleSearchAdapter.access$200() && !apiresponse.isEmpty())
        {
            addToDataSet(query, apiresponse);
        } else
        {
            if (!list.isEmpty() && !apiresponse.isEmpty())
            {
                list.addAll(apiresponse);
                addToDataSet(query, list);
                return;
            }
            if (apiresponse.isEmpty())
            {
                addToDataSet(query, list);
                return;
            }
            if (list.isEmpty())
            {
                addToDataSet(query, apiresponse);
                return;
            }
        }
    }

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        apiresponse.toString();
        setSpinnerState(false);
    }

    public void onSuccess(final ApiResponse response)
    {
        class _cls1 extends BackgroundTask
        {

            final PeopleSearchAdapter.PeopleSearchResponseHandler this$1;
            final ApiResponse val$response;

            public void run()
            {
                parseData(response);
            }

            _cls1()
            {
                this$1 = PeopleSearchAdapter.PeopleSearchResponseHandler.this;
                response = apiresponse;
                super();
            }
        }

        if (query.equalsIgnoreCase(_currentQuery))
        {
            (new _cls1()).execute();
        }
        setSpinnerState(false);
    }


    public _cls1(String s)
    {
        this$0 = PeopleSearchAdapter.this;
        super();
        query = s;
    }
}
