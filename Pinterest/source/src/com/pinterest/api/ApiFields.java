// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import com.pinterest.base.Device;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class ApiFields
{

    public static final String A;
    private static final String B = a(new String[] {
        "75x75", "150x150(ir.12)", "150x150(ir.24)", "150x150(ir.48)", "300x300(ir.24)", "300x300(ir.48)"
    });
    private static final String C;
    private static final String D;
    private static final String E;
    private static final String F;
    private static final String G;
    private static final String H;
    public static final String a = a(new String[] {
        "pin.id", "pin.description", "pin.link", "pin.image_medium_url", "pin.image_medium_size_pixels", "pin.created_at", "pin.like_count", "pin.repin_count", "pin.comment_count", "pin.view_tags"
    });
    public static final String b = a(new String[] {
        "board.id", "board.url", "board.name", "board.category", "board.created_at", "board.layout", "board.collaborator_invites_enabled"
    });
    public static final String c = a(new String[] {
        "user.id", "user.username", "user.first_name", "user.last_name", "user.full_name", "user.gender", "user.partner()"
    });
    public static final String d = a(new String[] {
        "comment.id", "comment.text", "comment.created_at", "comment.text"
    });
    public static final String e = a(new String[] {
        "place.id", "place.name", "place.latitude", "place.longitude", "place.source_icon", "place.source_name"
    });
    public static final String f = a(new String[] {
        "conversation.id", "conversation.users()", "conversation.emails", "conversation.last_message()", "conversation.unread"
    });
    public static final String g = a(new String[] {
        "conversationmessage.id", "conversationmessage.text", "conversationmessage.created_at", "conversationmessage.pin()", "conversationmessage.board()", "conversationmessage.user()", "conversationmessage.sender()"
    });
    public static final String h = a(new String[] {
        c, "user.image_medium_url", "user.image_large_url", "user.email", "user.secret_board_count", "user.connected_to_facebook", "user.facebook_timeline_enabled", "user.facebook_publish_stream_enabled", "user.connected_to_gplus", "user.connected_to_twitter", 
        "user.connected_to_rakuten", "user.experiments", "user.gatekeeper_experiments", "user.created_at"
    });
    public static final String i = a(new String[] {
        c, "user.image_medium_url", "user.website_url", "user.domain_verified", "user.location", "user.explicitly_followed_by_me", "user.implicitly_followed_by_me", "user.blocked_by_me", "user.pin_count", "user.follower_count", 
        "user.pin_thumbnail_urls"
    });
    public static final String j = a(new String[] {
        c, "user.image_medium_url", "user.image_large_url", "user.about", "user.blocked_by_me", "user.board_count", "user.domain_verified", "user.explicitly_followed_by_me", "user.facebook_url", "user.follower_count", 
        "user.following_count", "user.implicitly_followed_by_me", "user.impressum_url", "user.like_count", "user.location", "user.pin_count", "user.show_impressum", "user.twitter_url", "user.website_url"
    });
    public static final String k = a(new String[] {
        b, "board.image_cover_url", "board.images[90x90]", "board.collaborated_by_me", "board.is_collaborative", "board.followed_by_me", "board.privacy", "board.owner()", "board.pin_count"
    });
    public static final String l = a(new String[] {
        b, "board.image_cover_url", "board.images[90x90]", c, "user.image_medium_url", "board.description", "board.is_collaborative", "board.collaborator_count", "board.followed_by_me", "board.collaborated_by_me", 
        "board.owner()", "board.pin_count"
    });
    public static final String m = a(new String[] {
        b, "board.cover_images[60x60]", "board.is_collaborative", "board.privacy"
    });
    public static final String n = a(new String[] {
        "collaboratorinvite.invited_user()", "collaboratorinvite.invited_by_user()", "collaboratorinvite.access"
    });
    public static final String o;
    public static final String p = a(new String[] {
        "interest.images[150x150(ir.24),150x150(ir.12)]", "interest.name", "interest.follower_count"
    });
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v = a(new String[] {
        a, e, "pin.place()", "pin.pinner()", "place.street", "place.locality", "place.region", "place.country", "place.phone", "place.url"
    });
    public static final String w;
    public static final String x;
    public static final String y = a(new String[] {
        a, b, "board.cover_images[60x60]", "board.image_cover_url", "board.images[90x90]", c, "user.image_medium_url", f, g
    });
    public static final String z;

    private static String a(String s1)
    {
        Object obj = null;
        Object obj1 = Pattern.compile("pin.images\\[(.*?)\\],?").matcher(s1);
        while (((Matcher) (obj1)).find()) 
        {
            if (StringUtils.isEmpty(((CharSequence) (obj))))
            {
                obj = "pin.images[";
            } else
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(",").toString();
            }
            s1 = s1.replace(((Matcher) (obj1)).group(), "");
            obj = (new StringBuilder()).append(((String) (obj))).append(((Matcher) (obj1)).group(1)).toString();
        }
        obj1 = s1;
        if (obj != null)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append("]").toString();
            obj1 = (new StringBuilder()).append(((String) (obj))).append(",").append(s1).toString();
        }
        return ((String) (obj1));
    }

    private static transient String a(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i1 = 0; i1 < as.length; i1++)
        {
            stringbuilder.append(as[i1]);
            if (i1 < as.length - 1)
            {
                stringbuilder.append(",");
            }
        }

        return a(stringbuilder.toString());
    }

    static 
    {
        String s1;
        if (Device.shouldLoadBigImages())
        {
            s1 = "600x";
        } else
        {
            s1 = "474x";
        }
        C = s1;
        D = (new StringBuilder("interest.images[")).append(a(new String[] {
            B, C
        })).append("]").toString();
        o = a(new String[] {
            "interest.id", "interest.name", "interest.creation_time", "interest.key", "interest.background_color", "interest.url_name", "interest.follower_count", "interest.feed_update_time", D
        });
        q = a(new String[] {
            o, "interest.is_followed"
        });
        if (Device.shouldLoadBigImages())
        {
            s1 = "pin.images[136x136]";
        } else
        {
            s1 = "pin.images[90x90]";
        }
        E = s1;
        if (Device.shouldLoadBigImages())
        {
            s1 = "pin.images[236x]";
        } else
        {
            s1 = "pin.images[200x]";
        }
        F = s1;
        if (Device.shouldLoadBigImages())
        {
            s1 = "pin.images[736x]";
        } else
        {
            s1 = "pin.images[550x]";
        }
        G = s1;
        r = a(new String[] {
            a, b, c, e, E, G, "board.image_thumbnail_url", "user.image_medium_url", "pin.liked_by_me", "pin.tracked_link", 
            "pin.domain", "pin.board()", "pin.comment_count", "pin.pinned_to_board", "pin.pinner()", "pin.via_pinner()", "pin.rich_metadata()", "pin.rich_summary()", "pin.embed()", "pin.canonical_pin", 
            "user.blocked_by_me", "pin.place()", "place.street", "place.locality", "place.region", "place.country", "place.phone", "place.url", "pin.is_video"
        });
        s = a(new String[] {
            a, F, G, b, "board.image_thumbnail_url", c, "user.image_medium_url", "pin.liked_by_me", "pin.dominant_color", "pin.rich_summary()", 
            "pin.embed()", "pin.promoter()", "pin.recommendation_reason", "pin.board()", "pin.pinner()", "pin.source_interest()", "pin.is_video", o
        });
        t = a(new String[] {
            s, "pin.place_summary()"
        });
        u = a(new String[] {
            s, E, e, "pin.place()", "place.street", "place.locality", "place.region", "place.country"
        });
        if (Device.shouldLoadBigImages())
        {
            s1 = "placeimage.thumbnails[300x300]";
        } else
        {
            s1 = "placeimage.thumbnails[100x100]";
        }
        H = s1;
        w = a(new String[] {
            H, "placeimage.url", "placeimage.width", "placeimage.height"
        });
        x = a(new String[] {
            a, b, c, E, G, "board.image_thumbnail_url", "user.image_medium_url", "pin.type", "pin.embed()", "board.type", 
            "user.type", "comment.text", "comment.type", "comment.commenter"
        });
        z = a(new String[] {
            a, G, b, "board.image_cover_url", "board.images[90x90]", c, "user.image_medium_url", f, g, "board.pin_count"
        });
        A = a(new String[] {
            F, D, "board.image_cover_url", "pin.board()", "pin.pinner()", "pin.via_pinner()", "pin.lookbook()", "pin.rich_summary()", "pin.rich_metadata()", "pin.place_summary()", 
            "pin.dominant_color", "user.explicitly_followed_by_me", "user.implicitly_followed_by_me", "interest.is_followed", "interest.feed_update_time"
        });
    }
}
