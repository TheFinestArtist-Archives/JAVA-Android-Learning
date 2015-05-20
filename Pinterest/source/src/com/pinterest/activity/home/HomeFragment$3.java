// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.home;

import com.pinterest.activity.HomeHelper;
import com.pinterest.activity.invitefriend.PinvitationalHomeFeedModalHelper;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.education.EducationHelper;
import com.pinterest.experience.SurveyHelper;
import com.pinterest.schemas.experiences.Placement;

// Referenced classes of package com.pinterest.activity.home:
//            HomeFragment

class dler extends com.pinterest.api.remote.eedApiResponseHandler
{

    final HomeFragment this$0;

    public void onSuccess(Feed feed)
    {
        if (HomeFragment.access$1700(HomeFragment.this) != null)
        {
            ((PinGridAdapter)HomeFragment.access$1800(HomeFragment.this)).setDataSource(null);
        }
        super.onSuccess(feed);
        feed = feed.getNags();
        if (feed == null || feed.a() <= 0) goto _L2; else goto _L1
_L1:
        feed = feed.c(0).a("nag_type", "");
        if (!feed.equals("write_banned")) goto _L4; else goto _L3
_L3:
        HomeHelper.showWriteBannedMegaphone();
_L6:
        if (isActive())
        {
            SurveyHelper.a(getActivity(), Placement.ANDROID_GLOBAL_SURVEY);
            HomeFragment.access$1902(HomeFragment.this, EducationHelper.a(Placement.ANDROID_HOME_FEED_TAKEOVER, HomeFragment.this));
            PinvitationalHomeFeedModalHelper.loadModal(Placement.ANDROID_HOME_FEED_TAKEOVER, HomeFragment.this);
        }
        return;
_L4:
        if (feed.equals("email_verification"))
        {
            HomeHelper.showEmailVerificationMegaphone();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        feed = MyUser.get();
        if (feed != null && (feed.getFollowingCount() == null || feed.getFollowingCount().intValue() == 0))
        {
            HomeHelper.showEmptyFollowingMegaphone();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    dler(FeedApiResponseHandler feedapiresponsehandler)
    {
        this$0 = HomeFragment.this;
        super(feedapiresponsehandler);
    }
}
