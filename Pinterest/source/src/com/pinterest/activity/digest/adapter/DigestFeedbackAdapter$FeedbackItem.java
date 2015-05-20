// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;


// Referenced classes of package com.pinterest.activity.digest.adapter:
//            DigestFeedbackAdapter

public class this._cls0
{

    String _coverUrl;
    String _display;
    String _itemId;
    ype _type;
    final DigestFeedbackAdapter this$0;

    public String getCoverUrl()
    {
        return _coverUrl;
    }

    public String getDisplay()
    {
        return _display;
    }

    public String getItemId()
    {
        return _itemId;
    }

    public ype getUnFollowItemType()
    {
        return _type;
    }

    public void setItem(String s, String s1, String s2, ype ype)
    {
        _itemId = s;
        _coverUrl = s1;
        _display = s2;
        _type = ype;
    }

    public ype()
    {
        this$0 = DigestFeedbackAdapter.this;
        super();
    }
}
