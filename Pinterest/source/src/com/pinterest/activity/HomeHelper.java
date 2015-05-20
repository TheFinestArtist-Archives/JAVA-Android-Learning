// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity;

import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent;

public class HomeHelper
{

    public HomeHelper()
    {
    }

    public static void showEmailVerificationMegaphone()
    {
        HomeFeedMegaphoneEvent homefeedmegaphoneevent = new HomeFeedMegaphoneEvent(com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent.EventType.CONFIRM_EMAIL);
        homefeedmegaphoneevent.setTitle(Resources.string(0x7f0e0110));
        homefeedmegaphoneevent.setDesc(Resources.string(0x7f0e010d));
        homefeedmegaphoneevent.setPositiveBtnText(Resources.string(0x7f0e010f));
        homefeedmegaphoneevent.setNegativeBtnText(Resources.string(0x7f0e010e));
        Events.removeStickyEvent(com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent);
        Events.postSticky(homefeedmegaphoneevent);
    }

    public static void showEmptyFollowingMegaphone()
    {
        User user = MyUser.get();
        if (user != null && user.getFirstName() != null)
        {
            HomeFeedMegaphoneEvent homefeedmegaphoneevent = new HomeFeedMegaphoneEvent(com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent.EventType.EMPTY_FEED);
            homefeedmegaphoneevent.setTitle(Resources.string(0x7f0e01df, new Object[] {
                user.getFirstName()
            }));
            homefeedmegaphoneevent.setDesc(Resources.string(0x7f0e01de));
            homefeedmegaphoneevent.setPositiveBtnText(Resources.string(0x7f0e0227));
            Events.removeStickyEvent(com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent);
            Events.postSticky(homefeedmegaphoneevent);
        }
    }

    public static void showWriteBannedMegaphone()
    {
        HomeFeedMegaphoneEvent homefeedmegaphoneevent = new HomeFeedMegaphoneEvent(com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent.EventType.WRITE_BANNED);
        homefeedmegaphoneevent.setTitle(Resources.string(0x7f0e0511));
        homefeedmegaphoneevent.setDesc(Resources.string(0x7f0e0510));
        homefeedmegaphoneevent.setPositiveBtnText(Resources.string(0x7f0e0405));
        Events.removeStickyEvent(com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent);
        Events.postSticky(homefeedmegaphoneevent);
    }
}
