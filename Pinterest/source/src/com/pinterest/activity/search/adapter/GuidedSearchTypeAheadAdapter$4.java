// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.adapter;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.search.adapter:
//            GuidedSearchTypeAheadAdapter

class val.newData
    implements Runnable
{

    final GuidedSearchTypeAheadAdapter this$0;
    final List val$newData;
    final String val$searchTerm;

    public void run()
    {
        if (StringUtils.equals(val$searchTerm, GuidedSearchTypeAheadAdapter.access$200(GuidedSearchTypeAheadAdapter.this)))
        {
            GuidedSearchTypeAheadAdapter.access$600(GuidedSearchTypeAheadAdapter.this, val$newData);
            notifyDataSetChanged();
        }
    }

    ()
    {
        this$0 = final_guidedsearchtypeaheadadapter;
        val$searchTerm = s;
        val$newData = List.this;
        super();
    }
}
