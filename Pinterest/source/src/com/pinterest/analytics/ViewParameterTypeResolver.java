// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.activity.board.BoardCollaboratorInviteFragment;
import com.pinterest.activity.board.dialog.BoardCollaboratorsDialog;
import com.pinterest.activity.board.fragment.BoardEditFragment;
import com.pinterest.activity.board.fragment.BoardRelatedBoardsFragment;
import com.pinterest.activity.category.fragment.CategoryFragment;
import com.pinterest.activity.conversation.ConversationCreateFragment;
import com.pinterest.activity.conversation.ConversationFragment;
import com.pinterest.activity.create.CreateActivity;
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
import com.pinterest.activity.home.HomeFragment;
import com.pinterest.activity.interest.InterestCollectionFragment;
import com.pinterest.activity.interest.InterestFragment;
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
import com.pinterest.activity.nux.fragment.NUXEndScreenFragment;
import com.pinterest.activity.nux.fragment.NUXInterestsPickerFragment;
import com.pinterest.activity.nux.fragment.NUXSocialPickerFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenPinvitationalFragment;
import com.pinterest.activity.pin.fragment.PinCommentsFragment;
import com.pinterest.activity.pin.fragment.PinLikesFragment;
import com.pinterest.activity.pin.fragment.PinRepinsFragment;
import com.pinterest.activity.place.fragment.PlaceImagePickerFragment;
import com.pinterest.activity.place.fragment.PlacePickerFragment;
import com.pinterest.activity.search.fragment.GuidedBoardSearchFragment;
import com.pinterest.activity.search.fragment.GuidedMyPinSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPeopleSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPinSearchFragment;
import com.pinterest.activity.search.fragment.SearchTypeaheadFragment;
import com.pinterest.activity.search.fragment.addpin.AddPinTapFragment;
import com.pinterest.activity.sendapin.SendPinFragment;
import com.pinterest.activity.signin.dialog.BusinessSignupDialog;
import com.pinterest.activity.signin.dialog.EmailOnlyLoginDialog;
import com.pinterest.activity.signin.dialog.EmailSignupDialog;
import com.pinterest.activity.signin.dialog.GenderSignupDialog;
import com.pinterest.activity.unauth.fragment.InspiredWallFragment;
import com.pinterest.activity.unauth.fragment.NewLoginFragment;
import com.pinterest.activity.unauth.fragment.PinvitationalInviteRequestFragment;
import com.pinterest.activity.unauth.fragment.PinvitationalSignupFragment;
import com.pinterest.activity.unauth.fragment.UnauthLoadingFragment;
import com.pinterest.activity.user.UserBoardsFragment;
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
import com.pinterest.fragment.PinPicksFragment;
import com.pinterest.fragment.StaticPinGridFragment;
import com.pinterest.fragment.StaticPinMapFragment;
import com.pinterest.schemas.event.ViewParameterType;
import com.pinterest.schemas.event.ViewType;
import com.pinterest.ui.menu.ContextMenuEducationFragment;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public class ViewParameterTypeResolver
{

    private static HashMap a;

    public static TEnum a(Class class1)
    {
        if (class1 == null)
        {
            return null;
        } else
        {
            return (TEnum)a.get(class1);
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        a = hashmap;
        hashmap.put(com/pinterest/activity/home/HomeFragment, ViewParameterType.FEED_HOME);
        a.put(com/pinterest/activity/digest/DigestFragment, ViewParameterType.FEED_DIGEST);
        a.put(com/pinterest/fragment/PinPicksFragment, ViewParameterType.FEED_DIGEST);
        a.put(com/pinterest/activity/digest/DigestPinFragment, ViewParameterType.FEED_DIGEST_STORY);
        a.put(com/pinterest/activity/create/fragment/RepinFragment, ViewParameterType.PIN_CREATE_REPIN);
        a.put(com/pinterest/activity/create/fragment/FastRepinFragment, ViewParameterType.PIN_CREATE_REPIN);
        a.put(com/pinterest/activity/create/fragment/CreateFragment, ViewParameterType.PIN_CREATE);
        a.put(com/pinterest/activity/user/UserBoardsFragment, ViewParameterType.USER_BOARDS);
        a.put(com/pinterest/activity/user/fragment/UserPinsFragment, ViewParameterType.USER_PINS);
        a.put(com/pinterest/activity/user/fragment/UserLikesFragment, ViewParameterType.USER_LIKES);
        a.put(com/pinterest/activity/user/fragment/UserAboutFragment, ViewParameterType.USER_ABOUT);
        a.put(com/pinterest/activity/user/fragment/UserFollowersFragment, ViewParameterType.USER_FOLLOWERS);
        a.put(com/pinterest/activity/user/fragment/UserFollowedPinnersFragment, ViewParameterType.USER_FOLLOWING);
        a.put(com/pinterest/activity/user/fragment/UserFollowedFragment, ViewParameterType.USER_FOLLOWING);
        a.put(com/pinterest/activity/user/fragment/UserFollowedBoardsFragment, ViewParameterType.USER_BOARDS);
        a.put(com/pinterest/activity/user/fragment/UserFollowedInterestsFragment, ViewParameterType.DISCOVER_INTEREST);
        a.put(com/pinterest/activity/domain/DomainFragment, ViewParameterType.FEED_DOMAIN);
        a.put(com/pinterest/activity/board/dialog/BoardCollaboratorsDialog, ViewParameterType.BOARD_COLLABORATORS);
        a.put(com/pinterest/activity/create/fragment/PinEditFragment, ViewParameterType.PIN_EDIT);
        a.put(com/pinterest/activity/create/fragment/BoardPickerFragment, ViewType.BOARD_PICKER);
        a.put(com/pinterest/activity/board/BoardCollaboratorInviteFragment, ViewParameterType.BOARD_EDIT_COLLABORATORS);
        a.put(com/pinterest/activity/sendapin/SendPinFragment, ViewParameterType.PIN_SEND_TO);
        a.put(com/pinterest/activity/create/fragment/PinMarkletFragment, ViewParameterType.PIN_CREATE_PINMARKLET);
        a.put(com/pinterest/activity/create/fragment/CreatePinFragment, ViewParameterType.PIN_CREATE);
        a.put(com/pinterest/ui/menu/ContextMenuEducationFragment, ViewParameterType.EDUCATION_CONTEXTUAL_MENU);
        a.put(com/pinterest/activity/explore/ExploreFragment, ViewParameterType.CATEGORY_DISCOVER);
        a.put(com/pinterest/activity/interest/InterestFragment, ViewParameterType.FEED_INTEREST);
        a.put(com/pinterest/activity/interest/InterestCollectionFragment, ViewParameterType.DISCOVER_INTEREST);
        a.put(com/pinterest/activity/user/fragment/UserFollowedInterestsFragment, ViewParameterType.USER_INTERESTS);
        a.put(com/pinterest/activity/notifications/NetworkStoryFragment, ViewParameterType.NEWS_NETWORK_STORY);
        a.put(com/pinterest/activity/notifications/YourNotificationFragment, ViewParameterType.NEWS_YOUR_STORY);
        a.put(com/pinterest/activity/notifications/StoryPinsFragment, ViewParameterType.STORIES_RELATED_PINS);
        a.put(com/pinterest/activity/notifications/StoryBoardsFragment, ViewParameterType.STORIES_RELATED_BOARDS);
        a.put(com/pinterest/activity/notifications/StoryPinnersFragment, ViewParameterType.STORIES_RELATED_USERS);
        a.put(com/pinterest/activity/search/fragment/GuidedPinSearchFragment, ViewParameterType.SEARCH_PINS);
        a.put(com/pinterest/activity/search/fragment/GuidedBoardSearchFragment, ViewParameterType.SEARCH_BOARDS);
        a.put(com/pinterest/activity/search/fragment/GuidedPeopleSearchFragment, ViewParameterType.SEARCH_USERS);
        a.put(com/pinterest/activity/search/fragment/GuidedMyPinSearchFragment, ViewParameterType.USER_FYP);
        a.put(com/pinterest/activity/search/fragment/SearchTypeaheadFragment, ViewParameterType.SEARCH_AUTOCOMPLETE);
        a.put(com/pinterest/activity/board/fragment/BoardEditFragment, ViewParameterType.BOARD_EDIT);
        a.put(com/pinterest/activity/unauth/fragment/InspiredWallFragment, ViewParameterType.SPLASH_INSPIRED_WALL);
        a.put(com/pinterest/activity/pin/fragment/PinRepinsFragment, ViewParameterType.PIN_REPIN_BOARDS);
        a.put(com/pinterest/activity/pin/fragment/PinCommentsFragment, ViewParameterType.PIN_COMMENTS);
        a.put(com/pinterest/activity/pin/fragment/PinLikesFragment, ViewParameterType.PIN_LIKES);
        a.put(com/pinterest/activity/place/fragment/PlacePickerFragment, ViewParameterType.SEARCH_PLACES);
        a.put(com/pinterest/activity/place/fragment/PlaceImagePickerFragment, ViewParameterType.PIN_CREATE_PLACES);
        a.put(com/pinterest/activity/signin/dialog/EmailOnlyLoginDialog, ViewParameterType.LOGIN_EMAIL);
        a.put(com/pinterest/activity/signin/dialog/EmailSignupDialog, ViewParameterType.REGISTRATION_SIGNUP);
        a.put(com/pinterest/activity/signin/dialog/BusinessSignupDialog, ViewParameterType.REGISTRATION_SIGNUP_BUSINESS);
        a.put(com/pinterest/activity/signin/dialog/GenderSignupDialog, ViewParameterType.REGISTRATION_AGE_GENDER);
        a.put(com/pinterest/activity/user/UserSetImageActivity, ViewParameterType.USER_EDIT);
        a.put(com/pinterest/fragment/StaticPinGridFragment, ViewParameterType.FEED_PLACES);
        a.put(com/pinterest/activity/board/fragment/BoardRelatedBoardsFragment, ViewParameterType.FEED_RELATED_BOARD);
        a.put(com/pinterest/fragment/StaticPinMapFragment, ViewParameterType.PIN_PLACE);
        a.put(com/pinterest/activity/featured/FeaturedUserFragment, ViewParameterType.FEED_FOLLOWING);
        a.put(com/pinterest/activity/featured/FeaturedBoardFragment, ViewParameterType.FEED_FOLLOWING);
        a.put(com/pinterest/activity/nux/fragment/NUXStartScreenFragment, ViewParameterType.ORIENTATION_START);
        a.put(com/pinterest/activity/nux/fragment/NUXEndScreenFragment, ViewParameterType.ORIENTATION_END);
        a.put(com/pinterest/activity/nux/fragment/NUXInterestsPickerFragment, ViewParameterType.ORIENTATION_INTEREST_PICKER);
        a.put(com/pinterest/activity/nux/fragment/NUXSocialPickerFragment, ViewParameterType.ORIENTATION_USER_PICKER);
        a.put(com/pinterest/activity/notifications/ConversationListFragment, ViewParameterType.CONVERSATION_INBOX);
        a.put(com/pinterest/activity/conversation/ConversationFragment, ViewParameterType.CONVERSATION_THREAD);
        a.put(com/pinterest/activity/conversation/ConversationCreateFragment, ViewParameterType.CONVERSATION_CREATE);
        a.put(com/pinterest/activity/notifications/ConversationPinnersFragment, ViewParameterType.CONVERSATION_USERS);
        a.put(com/pinterest/activity/search/fragment/addpin/AddPinTapFragment, ViewParameterType.CONVERSATION_ADD_PIN);
        a.put(com/pinterest/activity/user/fragment/AddUserPinTapFragment, ViewParameterType.CONVERSATION_ADD_PIN);
        a.put(com/pinterest/activity/unauth/fragment/NewLoginFragment, ViewParameterType.REGISTRATION_LOCAL_INFO);
        a.put(com/pinterest/activity/create/RepinActivity, ViewParameterType.PIN_CREATE_REPIN);
        a.put(com/pinterest/activity/create/fragment/RepinFragment, ViewParameterType.PIN_CREATE_REPIN);
        a.put(com/pinterest/activity/create/CreateActivity, ViewParameterType.PIN_CREATE);
        a.put(com/pinterest/activity/create/fragment/FastRepinFragment, ViewParameterType.PIN_CREATE_REPIN);
        a.put(com/pinterest/activity/category/fragment/CategoryFragment, ViewParameterType.FEED_CATEGORY);
        a.put(com/pinterest/activity/webhook/WebhookActivity, ViewParameterType.DEEP_LINKING_APP);
        a.put(com/pinterest/activity/web/WebViewActivity, ViewParameterType.BROWSER);
        a.put(com/pinterest/activity/web/fragment/WebViewFragment, ViewParameterType.BROWSER);
        a.put(com/pinterest/activity/unauth/fragment/PinvitationalInviteRequestFragment, ViewParameterType.PINVITATIONAL_UNAUTH_EMAIL);
        a.put(com/pinterest/activity/unauth/fragment/PinvitationalSignupFragment, ViewParameterType.PINVITATIONAL_SIGNUP_REDEMPTION);
        a.put(com/pinterest/activity/invitefriend/PinvitationalConfirmFragment, ViewParameterType.PINVITATIONAL_AUTH_CONFIRM);
        a.put(com/pinterest/activity/invitefriend/PinvitationalHomeFeedModalFragment, ViewParameterType.PINVITATIONAL_HOME_FEED_MODAL);
        a.put(com/pinterest/activity/invitefriend/PinvitationalPinSummaryFragment, ViewParameterType.PINVITATIONAL_PIN_SUMMARY);
        a.put(com/pinterest/activity/unauth/fragment/UnauthLoadingFragment, ViewParameterType.SPLASH_LOADING);
        a.put(com/pinterest/activity/nux/fragment/NUXStartScreenPinvitationalFragment, ViewParameterType.ORIENTATION_START);
    }
}
