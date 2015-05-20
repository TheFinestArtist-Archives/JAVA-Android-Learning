// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.activity.board.BoardCollaboratorInviteFragment;
import com.pinterest.activity.board.dialog.BoardCollaboratorsDialog;
import com.pinterest.activity.board.fragment.BoardEditFragment;
import com.pinterest.activity.board.fragment.BoardFragment;
import com.pinterest.activity.board.fragment.BoardRelatedBoardsFragment;
import com.pinterest.activity.category.fragment.CategoryFragment;
import com.pinterest.activity.conversation.ConversationCreateFragment;
import com.pinterest.activity.conversation.ConversationFragment;
import com.pinterest.activity.create.CreateActivity;
import com.pinterest.activity.create.PinEditActivity;
import com.pinterest.activity.create.PinItActivity;
import com.pinterest.activity.create.RepinActivity;
import com.pinterest.activity.create.fragment.BoardPickerFragment;
import com.pinterest.activity.create.fragment.CreateFragment;
import com.pinterest.activity.create.fragment.CreatePinFragment;
import com.pinterest.activity.create.fragment.FastRepinFragment;
import com.pinterest.activity.create.fragment.PinEditFragment;
import com.pinterest.activity.create.fragment.PinMarkletFragment;
import com.pinterest.activity.create.fragment.RepinFragment;
import com.pinterest.activity.digest.DigestFragment;
import com.pinterest.activity.digest.DigestPinFragment;
import com.pinterest.activity.domain.DomainFragment;
import com.pinterest.activity.explore.ExploreFragment;
import com.pinterest.activity.featured.FeaturedBoardFragment;
import com.pinterest.activity.featured.FeaturedUserFragment;
import com.pinterest.activity.findfriend.FindFriendsFragment;
import com.pinterest.activity.findfriend.NewFindFriendsFragment;
import com.pinterest.activity.home.HomeFragment;
import com.pinterest.activity.interest.InterestCollectionFragment;
import com.pinterest.activity.interest.InterestFragment;
import com.pinterest.activity.invitefriend.InviteFragment;
import com.pinterest.activity.invitefriend.InviteFriendFragment;
import com.pinterest.activity.invitefriend.NewFindFriendsContactFragment;
import com.pinterest.activity.invitefriend.NewFindFriendsInviteAllFragment;
import com.pinterest.activity.invitefriend.PinvitationalConfirmFragment;
import com.pinterest.activity.invitefriend.PinvitationalHomeFeedModalFragment;
import com.pinterest.activity.invitefriend.PinvitationalPinSummaryFragment;
import com.pinterest.activity.notifications.ConversationListFragment;
import com.pinterest.activity.notifications.ConversationPinnersFragment;
import com.pinterest.activity.notifications.NetworkStoryFragment;
import com.pinterest.activity.notifications.StoryBoardsFragment;
import com.pinterest.activity.notifications.StoryPinnersFragment;
import com.pinterest.activity.notifications.StoryPinsFragment;
import com.pinterest.activity.notifications.YourNotificationFragment;
import com.pinterest.activity.nux.NUXActivity;
import com.pinterest.activity.nux.fragment.NUXEndScreenFragment;
import com.pinterest.activity.nux.fragment.NUXInterestsPickerFragment;
import com.pinterest.activity.nux.fragment.NUXSocialPickerFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenPinvitationalFragment;
import com.pinterest.activity.pin.PinActivity;
import com.pinterest.activity.pin.fragment.PinCommentsFragment;
import com.pinterest.activity.pin.fragment.PinFragment;
import com.pinterest.activity.pin.fragment.PinLikesFragment;
import com.pinterest.activity.pin.fragment.PinRepinsFragment;
import com.pinterest.activity.place.fragment.PlaceImagePickerFragment;
import com.pinterest.activity.place.fragment.PlacePickerFragment;
import com.pinterest.activity.search.GuidedSearchFragment;
import com.pinterest.activity.search.fragment.GuidedBoardSearchFragment;
import com.pinterest.activity.search.fragment.GuidedMyPinSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPeopleSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPinSearchFragment;
import com.pinterest.activity.search.fragment.SearchTypeaheadFragment;
import com.pinterest.activity.search.fragment.addpin.AddPinTapFragment;
import com.pinterest.activity.sendapin.SendPinActivity;
import com.pinterest.activity.settings.AccountSettingsFragment;
import com.pinterest.activity.settings.fragment.EmailNotificationsSettingsFragment;
import com.pinterest.activity.settings.fragment.UpdatedDeactivateAccountSettingsFragment;
import com.pinterest.activity.signin.TwitterAuthActivity;
import com.pinterest.activity.signin.dialog.BusinessSignupDialog;
import com.pinterest.activity.signin.dialog.EmailOnlyLoginDialog;
import com.pinterest.activity.signin.dialog.EmailSignupDialog;
import com.pinterest.activity.signin.dialog.GenderSignupDialog;
import com.pinterest.activity.signin.dialog.LoginDialog;
import com.pinterest.activity.signin.dialog.SignupDialog;
import com.pinterest.activity.unauth.UnauthWallActivity;
import com.pinterest.activity.unauth.fragment.InspiredWallFragment;
import com.pinterest.activity.unauth.fragment.NewLoginFragment;
import com.pinterest.activity.unauth.fragment.PinvitationalInviteRequestFragment;
import com.pinterest.activity.unauth.fragment.PinvitationalSignupFragment;
import com.pinterest.activity.unauth.fragment.UnauthLoadingFragment;
import com.pinterest.activity.user.UserBoardsFragment;
import com.pinterest.activity.user.UserImageDialog;
import com.pinterest.activity.user.UserSetImageActivity;
import com.pinterest.activity.user.fragment.AddUserPinTapFragment;
import com.pinterest.activity.user.fragment.UserAboutFragment;
import com.pinterest.activity.user.fragment.UserFollowedBoardsFragment;
import com.pinterest.activity.user.fragment.UserFollowedFragment;
import com.pinterest.activity.user.fragment.UserFollowedInterestsFragment;
import com.pinterest.activity.user.fragment.UserFollowedPinnersFragment;
import com.pinterest.activity.user.fragment.UserFollowersFragment;
import com.pinterest.activity.user.fragment.UserLikesFragment;
import com.pinterest.activity.user.fragment.UserPinsFragment;
import com.pinterest.activity.web.WebViewActivity;
import com.pinterest.activity.web.fragment.WebViewFragment;
import com.pinterest.activity.webhook.WebhookActivity;
import com.pinterest.appwidget.SwitcherActivity;
import com.pinterest.fragment.PinPicksFragment;
import com.pinterest.fragment.StaticPinGridFragment;
import com.pinterest.fragment.StaticPinMapFragment;
import com.pinterest.schemas.event.ViewType;
import com.pinterest.ui.actionsheet.ActionSheetFragment;
import com.pinterest.ui.menu.ContextMenuEducationFragment;
import java.util.HashMap;

public class ViewTypeResolver
{

    private static HashMap a;

    public static ViewType a(Class class1)
    {
        if (class1 == null)
        {
            return null;
        } else
        {
            return (ViewType)a.get(class1);
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        a = hashmap;
        hashmap.put(com/pinterest/activity/web/WebViewActivity, ViewType.BROWSER);
        a.put(com/pinterest/activity/web/fragment/WebViewFragment, ViewType.BROWSER);
        a.put(com/pinterest/activity/home/HomeFragment, ViewType.FEED);
        a.put(com/pinterest/activity/digest/DigestFragment, ViewType.FEED);
        a.put(com/pinterest/fragment/PinPicksFragment, ViewType.FEED);
        a.put(com/pinterest/activity/digest/DigestPinFragment, ViewType.FEED);
        a.put(com/pinterest/activity/category/fragment/CategoryFragment, ViewType.FEED);
        a.put(com/pinterest/activity/user/UserBoardsFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/UserImageDialog, ViewType.USER);
        a.put(com/pinterest/activity/board/fragment/BoardFragment, ViewType.BOARD);
        a.put(com/pinterest/activity/pin/fragment/PinFragment, ViewType.PIN);
        a.put(com/pinterest/activity/pin/PinActivity, ViewType.PIN);
        a.put(com/pinterest/activity/create/fragment/PinMarkletFragment, ViewType.PIN);
        a.put(com/pinterest/activity/create/fragment/CreateFragment, ViewType.PIN);
        a.put(com/pinterest/activity/create/fragment/CreatePinFragment, ViewType.PIN);
        a.put(com/pinterest/activity/settings/AccountSettingsFragment, ViewType.SETTINGS);
        a.put(com/pinterest/activity/user/fragment/UserFollowersFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/fragment/UserFollowedPinnersFragment, ViewType.USER);
        a.put(com/pinterest/activity/domain/DomainFragment, ViewType.FEED);
        a.put(com/pinterest/activity/signin/dialog/LoginDialog, ViewType.LOGIN);
        a.put(com/pinterest/activity/signin/dialog/SignupDialog, ViewType.REGISTRATION);
        a.put(com/pinterest/activity/signin/TwitterAuthActivity, ViewType.LOGIN);
        a.put(com/pinterest/activity/create/RepinActivity, ViewType.PIN);
        a.put(com/pinterest/activity/create/fragment/RepinFragment, ViewType.PIN);
        a.put(com/pinterest/activity/create/CreateActivity, ViewType.PIN);
        a.put(com/pinterest/activity/create/fragment/FastRepinFragment, ViewType.PIN);
        a.put(com/pinterest/activity/board/BoardCollaboratorInviteFragment, ViewType.BOARD);
        a.put(com/pinterest/activity/board/dialog/BoardCollaboratorsDialog, ViewType.FEED);
        a.put(com/pinterest/activity/create/PinEditActivity, ViewType.PIN);
        a.put(com/pinterest/activity/create/fragment/PinEditFragment, ViewType.PIN);
        a.put(com/pinterest/activity/create/PinItActivity, ViewType.PIN);
        a.put(com/pinterest/activity/unauth/UnauthWallActivity, ViewType.SPLASH);
        a.put(com/pinterest/activity/sendapin/SendPinActivity, ViewType.PIN);
        a.put(com/pinterest/activity/invitefriend/InviteFragment, ViewType.FRIEND_INVITER);
        a.put(com/pinterest/activity/invitefriend/InviteFriendFragment, ViewType.FRIEND_INVITER);
        a.put(com/pinterest/activity/webhook/WebhookActivity, ViewType.DEEP_LINKING);
        a.put(com/pinterest/appwidget/SwitcherActivity, ViewType.ANDROID_WIDGET_FEED);
        a.put(com/pinterest/ui/menu/ContextMenuEducationFragment, ViewType.EDUCATION);
        a.put(com/pinterest/activity/explore/ExploreFragment, ViewType.DISCOVER);
        a.put(com/pinterest/activity/interest/InterestFragment, ViewType.FEED);
        a.put(com/pinterest/activity/interest/InterestCollectionFragment, ViewType.FEED);
        a.put(com/pinterest/activity/user/fragment/UserPinsFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/fragment/UserAboutFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/fragment/UserLikesFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/fragment/UserFollowedInterestsFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/fragment/UserFollowedFragment, ViewType.USER);
        a.put(com/pinterest/activity/user/fragment/UserFollowedBoardsFragment, ViewType.USER);
        a.put(com/pinterest/activity/notifications/NetworkStoryFragment, ViewType.NEWS);
        a.put(com/pinterest/activity/notifications/YourNotificationFragment, ViewType.NEWS);
        a.put(com/pinterest/activity/notifications/StoryPinsFragment, ViewType.STORIES);
        a.put(com/pinterest/activity/notifications/StoryBoardsFragment, ViewType.STORIES);
        a.put(com/pinterest/activity/notifications/StoryPinnersFragment, ViewType.STORIES);
        a.put(com/pinterest/activity/search/GuidedSearchFragment, ViewType.SEARCH);
        a.put(com/pinterest/activity/search/fragment/GuidedPinSearchFragment, ViewType.SEARCH);
        a.put(com/pinterest/activity/search/fragment/GuidedBoardSearchFragment, ViewType.SEARCH);
        a.put(com/pinterest/activity/search/fragment/GuidedPeopleSearchFragment, ViewType.SEARCH);
        a.put(com/pinterest/activity/search/fragment/GuidedMyPinSearchFragment, ViewType.USER);
        a.put(com/pinterest/activity/search/fragment/SearchTypeaheadFragment, ViewType.SEARCH);
        a.put(com/pinterest/activity/board/fragment/BoardEditFragment, ViewType.BOARD);
        a.put(com/pinterest/activity/unauth/fragment/InspiredWallFragment, ViewType.SPLASH);
        a.put(com/pinterest/activity/findfriend/FindFriendsFragment, ViewType.FIND_FRIENDS);
        a.put(com/pinterest/activity/findfriend/NewFindFriendsFragment, ViewType.FIND_FRIENDS);
        a.put(com/pinterest/activity/invitefriend/NewFindFriendsContactFragment, ViewType.FIND_FRIENDS);
        a.put(com/pinterest/activity/invitefriend/NewFindFriendsInviteAllFragment, ViewType.FIND_FRIENDS);
        a.put(com/pinterest/activity/pin/fragment/PinRepinsFragment, ViewType.PIN);
        a.put(com/pinterest/activity/pin/fragment/PinLikesFragment, ViewType.PIN);
        a.put(com/pinterest/activity/pin/fragment/PinCommentsFragment, ViewType.PIN);
        a.put(com/pinterest/activity/place/fragment/PlacePickerFragment, ViewType.SEARCH);
        a.put(com/pinterest/activity/place/fragment/PlaceImagePickerFragment, ViewType.PIN);
        a.put(com/pinterest/activity/signin/dialog/EmailOnlyLoginDialog, ViewType.LOGIN);
        a.put(com/pinterest/activity/signin/dialog/EmailSignupDialog, ViewType.REGISTRATION);
        a.put(com/pinterest/activity/signin/dialog/BusinessSignupDialog, ViewType.REGISTRATION);
        a.put(com/pinterest/activity/signin/dialog/GenderSignupDialog, ViewType.REGISTRATION);
        a.put(com/pinterest/activity/user/UserSetImageActivity, ViewType.USER);
        a.put(com/pinterest/fragment/StaticPinGridFragment, ViewType.FEED);
        a.put(com/pinterest/activity/board/fragment/BoardRelatedBoardsFragment, ViewType.BOARD);
        a.put(com/pinterest/activity/create/fragment/BoardPickerFragment, ViewType.BOARD);
        a.put(com/pinterest/fragment/StaticPinMapFragment, ViewType.PIN);
        a.put(com/pinterest/activity/settings/fragment/EmailNotificationsSettingsFragment, ViewType.SETTINGS);
        a.put(com/pinterest/activity/featured/FeaturedUserFragment, ViewType.FEED);
        a.put(com/pinterest/activity/featured/FeaturedBoardFragment, ViewType.FEED);
        a.put(com/pinterest/activity/nux/NUXActivity, ViewType.ORIENTATION);
        a.put(com/pinterest/activity/nux/fragment/NUXStartScreenFragment, ViewType.ORIENTATION);
        a.put(com/pinterest/activity/nux/fragment/NUXEndScreenFragment, ViewType.ORIENTATION);
        a.put(com/pinterest/activity/nux/fragment/NUXInterestsPickerFragment, ViewType.ORIENTATION);
        a.put(com/pinterest/activity/nux/fragment/NUXSocialPickerFragment, ViewType.ORIENTATION);
        a.put(com/pinterest/activity/notifications/ConversationListFragment, ViewType.CONVERSATION);
        a.put(com/pinterest/activity/conversation/ConversationFragment, ViewType.CONVERSATION);
        a.put(com/pinterest/activity/conversation/ConversationCreateFragment, ViewType.CONVERSATION);
        a.put(com/pinterest/activity/notifications/ConversationPinnersFragment, ViewType.CONVERSATION);
        a.put(com/pinterest/activity/search/fragment/addpin/AddPinTapFragment, ViewType.CONVERSATION);
        a.put(com/pinterest/activity/user/fragment/AddUserPinTapFragment, ViewType.CONVERSATION);
        a.put(com/pinterest/activity/unauth/fragment/NewLoginFragment, ViewType.REGISTRATION);
        a.put(com/pinterest/activity/settings/fragment/UpdatedDeactivateAccountSettingsFragment, ViewType.SETTINGS);
        a.put(com/pinterest/activity/unauth/fragment/PinvitationalInviteRequestFragment, ViewType.PINVITATIONAL);
        a.put(com/pinterest/activity/unauth/fragment/PinvitationalSignupFragment, ViewType.PINVITATIONAL);
        a.put(com/pinterest/activity/invitefriend/PinvitationalConfirmFragment, ViewType.PINVITATIONAL);
        a.put(com/pinterest/activity/invitefriend/PinvitationalHomeFeedModalFragment, ViewType.PINVITATIONAL);
        a.put(com/pinterest/activity/invitefriend/PinvitationalPinSummaryFragment, ViewType.PINVITATIONAL);
        a.put(com/pinterest/activity/unauth/fragment/UnauthLoadingFragment, ViewType.SPLASH);
        a.put(com/pinterest/activity/nux/fragment/NUXStartScreenPinvitationalFragment, ViewType.ORIENTATION);
        a.put(com/pinterest/ui/actionsheet/ActionSheetFragment, ViewType.ACTION_SHEET);
    }
}
