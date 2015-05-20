// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.os.Parcel;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.FeedApiResponseHandler;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            Feed, DigestItem, ModelHelper

public class DigestFeed extends Feed
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final String NAME = "DigestFeed";

    public DigestFeed()
    {
        super(null, null);
    }

    public DigestFeed(Parcel parcel)
    {
        super(null, null);
        readFromParcel(parcel);
    }

    public DigestFeed(PinterestJsonObject pinterestjsonobject, String s)
    {
        super(pinterestjsonobject, s);
        if (pinterestjsonobject == null)
        {
            return;
        }
        if (_data instanceof PinterestJsonArray)
        {
            setItems(DigestItem.makeAll((PinterestJsonArray)_data));
        } else
        {
            setItems(new ArrayList());
        }
        setData(null);
    }

    protected List getPersistedItems()
    {
        return ModelHelper.getDigestItems(_ids);
    }

    public FeedApiResponseHandler newApiHandler()
    {
        return new com.pinterest.api.remote.DigestApi.DigestStoryFeedApiResponseHandler();
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final DigestFeed createFromParcel(Parcel parcel)
        {
            return new DigestFeed(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final DigestFeed[] newArray(int i)
        {
            return new DigestFeed[i];
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
