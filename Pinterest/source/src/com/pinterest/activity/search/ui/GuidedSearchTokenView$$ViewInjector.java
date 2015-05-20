// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.pinterest.activity.search.ui:
//            GuidedSearchTokenView

public class 
{

    public static void inject(butterknife.enView enview, GuidedSearchTokenView guidedsearchtokenview, Object obj)
    {
        guidedsearchtokenview._tokenLayout = (LinearLayout)enview._tokenLayout(obj, 0x7f0b0255, "field '_tokenLayout'");
        guidedsearchtokenview._tokenText = (TextView)enview._tokenText(obj, 0x7f0b0257, "field '_tokenText'");
        guidedsearchtokenview._removeToken = (ImageView)enview._removeToken(obj, 0x7f0b0258, "field '_removeToken'");
        guidedsearchtokenview._tokenIcon = (ImageView)enview._tokenIcon(obj, 0x7f0b020e, "field '_tokenIcon'");
        guidedsearchtokenview._tokenNameWrapper = (LinearLayout)enview._tokenNameWrapper(obj, 0x7f0b0256, "field '_tokenNameWrapper'");
    }

    public static void reset(GuidedSearchTokenView guidedsearchtokenview)
    {
        guidedsearchtokenview._tokenLayout = null;
        guidedsearchtokenview._tokenText = null;
        guidedsearchtokenview._removeToken = null;
        guidedsearchtokenview._tokenIcon = null;
        guidedsearchtokenview._tokenNameWrapper = null;
    }

    public ()
    {
    }
}
