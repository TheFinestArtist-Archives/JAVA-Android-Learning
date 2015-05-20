// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.os.Parcel;
import com.pinterest.activity.search.model.RelatedQueryItem;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            PinFeed, SearchFilter

public class GuidedPinFeed extends PinFeed
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final String NAME = "GuidedPinFeed";
    protected List _filters;
    protected List _relatedQueries;

    public GuidedPinFeed()
    {
        super(null, null);
        _relatedQueries = new ArrayList();
        _filters = new ArrayList();
    }

    public GuidedPinFeed(Parcel parcel)
    {
        super(null, null);
        _relatedQueries = new ArrayList();
        _filters = new ArrayList();
        readFromParcel(parcel);
    }

    public GuidedPinFeed(PinterestJsonObject pinterestjsonobject, String s)
    {
        super(pinterestjsonobject, s);
        _relatedQueries = new ArrayList();
        _filters = new ArrayList();
        if (pinterestjsonobject != null)
        {
            s = pinterestjsonobject.e("terms");
            for (int i = 0; i < s.a(); i++)
            {
                RelatedQueryItem relatedqueryitem = new RelatedQueryItem();
                relatedqueryitem.setItem(s.b(i));
                _relatedQueries.add(relatedqueryitem);
            }

            pinterestjsonobject = pinterestjsonobject.c("filter_data");
            if (pinterestjsonobject != null)
            {
                _filters = SearchFilter.makeAll(pinterestjsonobject.e("filters"));
                return;
            }
        }
    }

    public List getRelatedQueries()
    {
        return _relatedQueries;
    }

    public List getSearchFilters()
    {
        return _filters;
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final GuidedPinFeed createFromParcel(Parcel parcel)
        {
            return new GuidedPinFeed(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final GuidedPinFeed[] newArray(int i)
        {
            return new GuidedPinFeed[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
