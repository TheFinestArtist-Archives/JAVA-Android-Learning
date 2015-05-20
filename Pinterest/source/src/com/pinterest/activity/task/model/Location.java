// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.board.BoardCollaboratorInviteFragment;
import com.pinterest.activity.board.fragment.BoardEditFragment;
import com.pinterest.activity.board.fragment.BoardFragment;
import com.pinterest.activity.board.fragment.BoardRelatedBoardsFragment;
import com.pinterest.activity.category.fragment.CategoryFragment;
import com.pinterest.activity.conversation.ConversationCreateFragment;
import com.pinterest.activity.conversation.ConversationFragment;
import com.pinterest.activity.create.fragment.FastRepinFragment;
import com.pinterest.activity.digest.DigestFragment;
import com.pinterest.activity.digest.DigestPinFragment;
import com.pinterest.activity.domain.DomainFragment;
import com.pinterest.activity.explore.ExploreFragment;
import com.pinterest.activity.featured.FeaturedBoardFragment;
import com.pinterest.activity.featured.FeaturedUserFragment;
import com.pinterest.activity.findfriend.FindFriendsFragment;
import com.pinterest.activity.findfriend.NewFindFriendsFragment;
import com.pinterest.activity.home.HomeFragment;
import com.pinterest.activity.home.events.HomeControlEvent;
import com.pinterest.activity.interest.InterestCollectionFragment;
import com.pinterest.activity.interest.InterestFragment;
import com.pinterest.activity.interest.MyInterestsFragment;
import com.pinterest.activity.invitefriend.InviteFragment;
import com.pinterest.activity.invitefriend.NewFindFriendsInviteAllFragment;
import com.pinterest.activity.invitefriend.PinvitationalConfirmFragment;
import com.pinterest.activity.invitefriend.PinvitationalHomeFeedModalFragment;
import com.pinterest.activity.notifications.ConversationPinnersFragment;
import com.pinterest.activity.notifications.NotificationsFragment;
import com.pinterest.activity.notifications.StoryBoardsFragment;
import com.pinterest.activity.notifications.StoryPinnersFragment;
import com.pinterest.activity.notifications.StoryPinsFragment;
import com.pinterest.activity.nux.fragment.NUXInterestsPickerFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenFragment;
import com.pinterest.activity.pin.fragment.PinCommentsFragment;
import com.pinterest.activity.pin.fragment.PinFragment;
import com.pinterest.activity.pin.fragment.PinLikesFragment;
import com.pinterest.activity.pin.fragment.PinRepinsFragment;
import com.pinterest.activity.pin.fragment.PinSwipeFragment;
import com.pinterest.activity.place.fragment.PlaceImagePickerFragment;
import com.pinterest.activity.place.fragment.PlacePickerFragment;
import com.pinterest.activity.search.GuidedSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPinSearchFragment;
import com.pinterest.activity.settings.AccountSettingsFragment;
import com.pinterest.activity.settings.fragment.EmailNotificationsSettingsFragment;
import com.pinterest.activity.settings.fragment.UpdatedDeactivateAccountSettingsFragment;
import com.pinterest.activity.task.event.CommandEvent;
import com.pinterest.activity.unauth.fragment.NewLoginFragment;
import com.pinterest.activity.user.UserBoardsFragment;
import com.pinterest.activity.user.UserFragment;
import com.pinterest.activity.user.fragment.AddUserPinTapFragment;
import com.pinterest.activity.user.fragment.BrandPinsFragment;
import com.pinterest.activity.user.fragment.UserAboutFragment;
import com.pinterest.activity.user.fragment.UserFollowedBoardsFragment;
import com.pinterest.activity.user.fragment.UserFollowedFragment;
import com.pinterest.activity.user.fragment.UserFollowedInterestsFragment;
import com.pinterest.activity.user.fragment.UserFollowedPinnersFragment;
import com.pinterest.activity.user.fragment.UserFollowersFragment;
import com.pinterest.activity.user.fragment.UserLikesFragment;
import com.pinterest.activity.user.fragment.UserPinsFragment;
import com.pinterest.activity.web.fragment.WebViewFragment;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.fragment.PinPicksFragment;
import com.pinterest.fragment.StaticPinGridFragment;
import com.pinterest.fragment.StaticPinMapFragment;
import com.pinterest.rwd.RwdPinsFragment;
import com.pinterest.ui.menu.ContextMenuEducationFragment;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.task.model:
//            Navigation

public class Location extends Enum
{

    private static final Location $VALUES[];
    public static final Location ACCOUNT_SETTINGS;
    public static final Location AUTH;
    public static final Location BOARD;
    public static final Location BOARD_EDIT;
    public static final Location BRAND_PINS;
    public static final Location BROWSER;
    public static final Location CATEGORY;
    public static final Location CONTEXTMENU_EDUCATION;
    public static final Location CONVERSATION;
    public static final Location CONVERSATION_CREATE;
    public static final Location CONVERSATION_USERS;
    public static final Location DEACTIVATE_ACCOUNT_SETTINGS;
    public static final Location DIGEST;
    public static final Location DIGEST_PINS;
    public static final Location DOMAIN;
    public static final Location EMAIL_NOTIFICATIONS_SETTINGS;
    public static final Location EXPLORE;
    public static final Location FEATURED_BOARD;
    public static final Location FEATURED_USER;
    public static final Location FIND_FRIENDS;
    public static final Location HOME;
    public static final Location INTEREST;
    public static final Location INTEREST_COLLECTION;
    public static final Location INVITE_ALL_FRIENDS;
    public static final Location INVITE_BOARD_COLLAB;
    public static final Location INVITE_FRIENDS;
    public static final Location INVITE_FRIENDS_CONFIRM;
    public static final Location MY_INTERESTS;
    public static final Location NONE;
    public static final Location NOTIFICATIONS;
    public static final Location NUX_INTEREST;
    public static final Location NUX_START_SCREEN;
    public static final Location PIN;
    public static final Location PINVITATIONAL_MODAL;
    public static final Location PIN_COMMENTS;
    public static final Location PIN_LIKES;
    public static final Location PIN_PAGER;
    public static final Location PIN_PICKS;
    public static final Location PIN_REPINS;
    public static final Location PLACE_IMAGE_PICKER;
    public static final Location PLACE_PICKER;
    public static final String PREFIX = "pinterest://";
    public static final Location RELATED_BOARDS;
    public static final Location REPIN;
    public static final Location RWD_PINS;
    public static final Location SEARCH;
    public static final Location SEARCH_PIN;
    public static final Location SIGNUP_EXPERIMENT;
    public static final Location STATIC_PIN_GRID;
    public static final Location STATIC_PIN_MAP;
    public static final Location STORY_BOARDS;
    public static final Location STORY_PINS;
    public static final Location STORY_USERS;
    public static final Location USER;
    public static final Location USER_ABOUT;
    public static final Location USER_BOARDS;
    public static final Location USER_FOLLOWED_BOARDS;
    public static final Location USER_FOLLOWED_INTERESTS;
    public static final Location USER_FOLLOWED_PINNERS;
    public static final Location USER_FOLLOWERS;
    public static final Location USER_FOLLOWING;
    public static final Location USER_LIKES;
    public static final Location USER_PINS;
    public static final Location USER_PINS_SELECT;
    private static final HashMap _siteMap;
    private static final Set _unauthLocations = new _cls3();
    private static Location values[];
    private Class _displayClass;
    protected boolean _rootLocation;

    private Location(String s, int i, Class class1)
    {
        super(s, i);
        _displayClass = class1;
    }

    Location(String s, int i, Class class1, _cls1 _pcls1)
    {
        this(s, i, class1);
    }

    public static boolean allowUnauthAccess(Location location)
    {
        return _unauthLocations.contains(location);
    }

    public static Location from(int i)
    {
        if (values == null)
        {
            values = values();
        }
        if (i < 0 || i >= values.length)
        {
            return NONE;
        } else
        {
            return values[i];
        }
    }

    public static CommandEvent getSiteEvent(String s)
    {
        if (s.startsWith("pinterest://"))
        {
            s = s.substring(12);
            return (CommandEvent)_siteMap.get(s);
        } else
        {
            return null;
        }
    }

    public static boolean isRootLocation(Navigation navigation)
    {
        Location location = navigation.getLocation();
        if (location == USER)
        {
            return MyUser.isUserMe(navigation.getId());
        } else
        {
            return location._rootLocation;
        }
    }

    public static void navigateUri(Context context, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        Object obj = getSiteEvent(s);
        if (obj == null)
        {
            obj = ActivityHelper.getWebhook(context);
            ((Intent) (obj)).setData(Uri.parse(s));
            context.startActivity(((Intent) (obj)));
            return;
        }
        switch (((CommandEvent) (obj)).getType())
        {
        default:
            return;

        case 0: // '\0'
            Events.post(new CommandEvent(((CommandEvent) (obj)).getType(), ((CommandEvent) (obj)).getId()));
            return;

        case 1: // '\001'
            Events.post(new Navigation(from(((CommandEvent) (obj)).getId())));
            return;

        case 2: // '\002'
            Events.post(new HomeControlEvent(((CommandEvent) (obj)).getId()));
            break;
        }
    }

    public static Location valueOf(String s)
    {
        return (Location)Enum.valueOf(com/pinterest/activity/task/model/Location, s);
    }

    public static Location[] values()
    {
        return (Location[])$VALUES.clone();
    }

    public Class getDisplayClass()
    {
        return _displayClass;
    }

    public void setDisplayClass(Class class1)
    {
        _displayClass = class1;
    }

    static 
    {
        NONE = new Location("NONE", 0, null);
        AUTH = new Location("AUTH", 1, null);
        HOME = new _cls1("HOME", 2, com/pinterest/activity/home/HomeFragment);
        DIGEST = new Location("DIGEST", 3, com/pinterest/activity/digest/DigestFragment);
        DIGEST_PINS = new Location("DIGEST_PINS", 4, com/pinterest/activity/digest/DigestPinFragment);
        NUX_START_SCREEN = new Location("NUX_START_SCREEN", 5, com/pinterest/activity/nux/fragment/NUXStartScreenFragment);
        NUX_INTEREST = new Location("NUX_INTEREST", 6, com/pinterest/activity/nux/fragment/NUXInterestsPickerFragment);
        PIN = new Location("PIN", 7, com/pinterest/activity/pin/fragment/PinFragment);
        PIN_PAGER = new Location("PIN_PAGER", 8, com/pinterest/activity/pin/fragment/PinSwipeFragment);
        PIN_LIKES = new Location("PIN_LIKES", 9, com/pinterest/activity/pin/fragment/PinLikesFragment);
        PIN_REPINS = new Location("PIN_REPINS", 10, com/pinterest/activity/pin/fragment/PinRepinsFragment);
        PIN_COMMENTS = new Location("PIN_COMMENTS", 11, com/pinterest/activity/pin/fragment/PinCommentsFragment);
        REPIN = new Location("REPIN", 12, com/pinterest/activity/create/fragment/FastRepinFragment);
        BOARD = new Location("BOARD", 13, com/pinterest/activity/board/fragment/BoardFragment);
        BOARD_EDIT = new Location("BOARD_EDIT", 14, com/pinterest/activity/board/fragment/BoardEditFragment);
        RELATED_BOARDS = new Location("RELATED_BOARDS", 15, com/pinterest/activity/board/fragment/BoardRelatedBoardsFragment);
        INVITE_BOARD_COLLAB = new Location("INVITE_BOARD_COLLAB", 16, com/pinterest/activity/board/BoardCollaboratorInviteFragment);
        USER = new Location("USER", 17, com/pinterest/activity/user/UserFragment);
        USER_BOARDS = new Location("USER_BOARDS", 18, com/pinterest/activity/user/UserBoardsFragment);
        USER_PINS = new Location("USER_PINS", 19, com/pinterest/activity/user/fragment/UserPinsFragment);
        BRAND_PINS = new Location("BRAND_PINS", 20, com/pinterest/activity/user/fragment/BrandPinsFragment);
        RWD_PINS = new Location("RWD_PINS", 21, com/pinterest/rwd/RwdPinsFragment);
        USER_LIKES = new Location("USER_LIKES", 22, com/pinterest/activity/user/fragment/UserLikesFragment);
        USER_ABOUT = new Location("USER_ABOUT", 23, com/pinterest/activity/user/fragment/UserAboutFragment);
        USER_FOLLOWERS = new Location("USER_FOLLOWERS", 24, com/pinterest/activity/user/fragment/UserFollowersFragment);
        USER_FOLLOWING = new Location("USER_FOLLOWING", 25, com/pinterest/activity/user/fragment/UserFollowedFragment);
        USER_FOLLOWED_PINNERS = new Location("USER_FOLLOWED_PINNERS", 26, com/pinterest/activity/user/fragment/UserFollowedPinnersFragment);
        USER_FOLLOWED_INTERESTS = new Location("USER_FOLLOWED_INTERESTS", 27, com/pinterest/activity/user/fragment/UserFollowedInterestsFragment);
        USER_FOLLOWED_BOARDS = new Location("USER_FOLLOWED_BOARDS", 28, com/pinterest/activity/user/fragment/UserFollowedBoardsFragment);
        CATEGORY = new Location("CATEGORY", 29, com/pinterest/activity/category/fragment/CategoryFragment);
        FEATURED_USER = new Location("FEATURED_USER", 30, com/pinterest/activity/featured/FeaturedUserFragment);
        FEATURED_BOARD = new Location("FEATURED_BOARD", 31, com/pinterest/activity/featured/FeaturedBoardFragment);
        DOMAIN = new Location("DOMAIN", 32, com/pinterest/activity/domain/DomainFragment);
        EXPLORE = new Location("EXPLORE", 33, com/pinterest/activity/explore/ExploreFragment);
        SEARCH = new _cls2("SEARCH", 34, com/pinterest/activity/search/GuidedSearchFragment);
        BROWSER = new Location("BROWSER", 35, com/pinterest/activity/web/fragment/WebViewFragment);
        ACCOUNT_SETTINGS = new Location("ACCOUNT_SETTINGS", 36, com/pinterest/activity/settings/AccountSettingsFragment);
        CONTEXTMENU_EDUCATION = new Location("CONTEXTMENU_EDUCATION", 37, com/pinterest/ui/menu/ContextMenuEducationFragment);
        PLACE_PICKER = new Location("PLACE_PICKER", 38, com/pinterest/activity/place/fragment/PlacePickerFragment);
        PLACE_IMAGE_PICKER = new Location("PLACE_IMAGE_PICKER", 39, com/pinterest/activity/place/fragment/PlaceImagePickerFragment);
        STATIC_PIN_GRID = new Location("STATIC_PIN_GRID", 40, com/pinterest/fragment/StaticPinGridFragment);
        STATIC_PIN_MAP = new Location("STATIC_PIN_MAP", 41, com/pinterest/fragment/StaticPinMapFragment);
        INTEREST = new Location("INTEREST", 42, com/pinterest/activity/interest/InterestFragment);
        INTEREST_COLLECTION = new Location("INTEREST_COLLECTION", 43, com/pinterest/activity/interest/InterestCollectionFragment);
        MY_INTERESTS = new Location("MY_INTERESTS", 44, com/pinterest/activity/interest/MyInterestsFragment);
        NOTIFICATIONS = new Location("NOTIFICATIONS", 45, com/pinterest/activity/notifications/NotificationsFragment);
        Object obj;
        if (Experiments.o())
        {
            obj = com/pinterest/activity/findfriend/NewFindFriendsFragment;
        } else
        {
            obj = com/pinterest/activity/invitefriend/InviteFragment;
        }
        INVITE_FRIENDS = new Location("INVITE_FRIENDS", 46, ((Class) (obj)));
        INVITE_ALL_FRIENDS = new Location("INVITE_ALL_FRIENDS", 47, com/pinterest/activity/invitefriend/NewFindFriendsInviteAllFragment);
        INVITE_FRIENDS_CONFIRM = new Location("INVITE_FRIENDS_CONFIRM", 48, com/pinterest/activity/invitefriend/PinvitationalConfirmFragment);
        PINVITATIONAL_MODAL = new Location("PINVITATIONAL_MODAL", 49, com/pinterest/activity/invitefriend/PinvitationalHomeFeedModalFragment);
        if (Experiments.o())
        {
            obj = com/pinterest/activity/findfriend/NewFindFriendsFragment;
        } else
        {
            obj = com/pinterest/activity/findfriend/FindFriendsFragment;
        }
        FIND_FRIENDS = new Location("FIND_FRIENDS", 50, ((Class) (obj)));
        EMAIL_NOTIFICATIONS_SETTINGS = new Location("EMAIL_NOTIFICATIONS_SETTINGS", 51, com/pinterest/activity/settings/fragment/EmailNotificationsSettingsFragment);
        DEACTIVATE_ACCOUNT_SETTINGS = new Location("DEACTIVATE_ACCOUNT_SETTINGS", 52, com/pinterest/activity/settings/fragment/UpdatedDeactivateAccountSettingsFragment);
        CONVERSATION = new Location("CONVERSATION", 53, com/pinterest/activity/conversation/ConversationFragment);
        CONVERSATION_CREATE = new Location("CONVERSATION_CREATE", 54, com/pinterest/activity/conversation/ConversationCreateFragment);
        STORY_PINS = new Location("STORY_PINS", 55, com/pinterest/activity/notifications/StoryPinsFragment);
        STORY_BOARDS = new Location("STORY_BOARDS", 56, com/pinterest/activity/notifications/StoryBoardsFragment);
        STORY_USERS = new Location("STORY_USERS", 57, com/pinterest/activity/notifications/StoryPinnersFragment);
        CONVERSATION_USERS = new Location("CONVERSATION_USERS", 58, com/pinterest/activity/notifications/ConversationPinnersFragment);
        SIGNUP_EXPERIMENT = new Location("SIGNUP_EXPERIMENT", 59, com/pinterest/activity/unauth/fragment/NewLoginFragment);
        USER_PINS_SELECT = new Location("USER_PINS_SELECT", 60, com/pinterest/activity/user/fragment/AddUserPinTapFragment);
        SEARCH_PIN = new Location("SEARCH_PIN", 61, com/pinterest/activity/search/fragment/GuidedPinSearchFragment);
        PIN_PICKS = new Location("PIN_PICKS", 62, com/pinterest/fragment/PinPicksFragment);
        $VALUES = (new Location[] {
            NONE, AUTH, HOME, DIGEST, DIGEST_PINS, NUX_START_SCREEN, NUX_INTEREST, PIN, PIN_PAGER, PIN_LIKES, 
            PIN_REPINS, PIN_COMMENTS, REPIN, BOARD, BOARD_EDIT, RELATED_BOARDS, INVITE_BOARD_COLLAB, USER, USER_BOARDS, USER_PINS, 
            BRAND_PINS, RWD_PINS, USER_LIKES, USER_ABOUT, USER_FOLLOWERS, USER_FOLLOWING, USER_FOLLOWED_PINNERS, USER_FOLLOWED_INTERESTS, USER_FOLLOWED_BOARDS, CATEGORY, 
            FEATURED_USER, FEATURED_BOARD, DOMAIN, EXPLORE, SEARCH, BROWSER, ACCOUNT_SETTINGS, CONTEXTMENU_EDUCATION, PLACE_PICKER, PLACE_IMAGE_PICKER, 
            STATIC_PIN_GRID, STATIC_PIN_MAP, INTEREST, INTEREST_COLLECTION, MY_INTERESTS, NOTIFICATIONS, INVITE_FRIENDS, INVITE_ALL_FRIENDS, INVITE_FRIENDS_CONFIRM, PINVITATIONAL_MODAL, 
            FIND_FRIENDS, EMAIL_NOTIFICATIONS_SETTINGS, DEACTIVATE_ACCOUNT_SETTINGS, CONVERSATION, CONVERSATION_CREATE, STORY_PINS, STORY_BOARDS, STORY_USERS, CONVERSATION_USERS, SIGNUP_EXPERIMENT, 
            USER_PINS_SELECT, SEARCH_PIN, PIN_PICKS
        });
        obj = new HashMap();
        _siteMap = ((HashMap) (obj));
        ((HashMap) (obj)).put("invite_friends", new CommandEvent(1, INVITE_FRIENDS.ordinal()));
        _siteMap.put("settings", new CommandEvent(1, ACCOUNT_SETTINGS.ordinal()));
        _siteMap.put("notifications", new CommandEvent(1, NOTIFICATIONS.ordinal()));
        _siteMap.put("explore", new CommandEvent(1, EXPLORE.ordinal()));
        _siteMap.put("send_verification_email", new CommandEvent(0, 1));
        _siteMap.put("settings/send_password_reset_email", new CommandEvent(0, 2));
        _siteMap.put("upload_contacts", new CommandEvent(0, 3));
        _siteMap.put("connect/facebook", new CommandEvent(0, 4));
        _siteMap.put("nux_start", new CommandEvent(0, 5));
        _siteMap.put("undo_rebuild_feed", new CommandEvent(0, 6));
    }

    private class _cls1 extends Location
    {

        _cls1(String s, int i, Class class1)
        {
            super(s, i, class1, null);
            _rootLocation = true;
        }
    }


    private class _cls2 extends Location
    {

        _cls2(String s, int i, Class class1)
        {
            super(s, i, class1, null);
            _rootLocation = true;
        }
    }


    private class _cls3 extends HashSet
    {

        _cls3()
        {
            add(Location.PIN);
            add(Location.BOARD);
            add(Location.USER);
            add(Location.INTEREST);
            add(Location.CATEGORY);
            add(Location.BROWSER);
        }
    }

}
