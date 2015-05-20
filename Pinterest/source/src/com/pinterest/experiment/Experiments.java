// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.experiment;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.ExperimentsApi;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.kit.data.DiskCache;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Experiments
{

    private static boolean a = false;
    private static HashSet b = new HashSet();
    private static Map c = new HashMap();
    private static Map d = new HashMap();
    private static Map e = new _cls1();
    private static Map f = new _cls2();

    public static String a(String s1, boolean flag)
    {
        String s2 = null;
        String s3 = null;
        if (!ApplicationInfo.isNonProduction() || !a)
        {
            boolean flag1 = false;
            s3 = (String)d.get(s1);
            if (s3 != null)
            {
                s2 = s3;
                if (s3.equals(""))
                {
                    s2 = null;
                }
                flag1 = true;
            }
            if (!flag1 && ApplicationInfo.isNonProduction())
            {
                s3 = (String)f.get(s1);
                if (s3 != null)
                {
                    d.put(s1, s3);
                    s2 = s3;
                    flag1 = true;
                }
            }
            if (!flag1)
            {
                s2 = (String)c.get(s1);
                Map map = d;
                if (s2 == null)
                {
                    s3 = "";
                } else
                {
                    s3 = s2;
                }
                map.put(s1, s3);
            }
            s3 = s2;
            if (flag)
            {
                a(s1);
                return s2;
            }
        }
        return s3;
    }

    public static void a(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject != null)
        {
            Iterator iterator = pinterestjsonobject.c().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                String s2 = pinterestjsonobject.c(s1).a("group", "");
                if (s2 != null)
                {
                    c.put(s1, s2);
                }
            } while (true);
        }
    }

    public static void a(String s1)
    {
        while (b.contains(s1) || a(s1, false) == null) 
        {
            return;
        }
        ExperimentsApi.a(s1, new _cls3(s1));
    }

    public static void a(String s1, String s2)
    {
        if (ApplicationInfo.isNonProduction())
        {
            Map map = d;
            String s3;
            if (s2 == null)
            {
                s3 = "";
            } else
            {
                s3 = s2;
            }
            map.put(s1, s3);
            c.put(s1, s2);
        }
    }

    public static boolean a()
    {
        return b("android_action_filter", false);
    }

    private static boolean a(String s1, String s2, boolean flag)
    {
        s1 = a(s1, flag);
        return s1 != null && s1.equalsIgnoreCase(s2);
    }

    public static boolean b()
    {
        return b("android_clickthrough_to_device_browser", false);
    }

    private static boolean b(String s1, boolean flag)
    {
label0:
        {
            boolean flag2 = false;
            String s2 = a(s1, flag);
            boolean flag1;
            if (s2 != null && s2.startsWith("enabled"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                if (a(s1, "employees", flag) || a(s1, "employee", flag))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = flag2;
                if (!flag1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean c()
    {
        return a("android_persistent_follow_button", "autohide", false);
    }

    public static boolean d()
    {
        boolean flag = false;
        if (a("android_persistent_follow_button", "autohide", false) || a("android_persistent_follow_button", "fixed_to_top", false))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean e()
    {
        return b("topical_feeds_android", false);
    }

    public static boolean f()
    {
        return a("topical_feeds_android", "enabled_popular_only", false);
    }

    public static boolean g()
    {
        return b("pinvitational_philippines", false);
    }

    public static boolean h()
    {
        return a("restrict_collaborator_invites", "rollout", false);
    }

    public static boolean i()
    {
        return b("android_new_perf_logging", false);
    }

    public static boolean j()
    {
        return b("android_persistent_top_bar", true);
    }

    public static boolean k()
    {
        return b("interests_feed_blended_pin_annotation_android", false);
    }

    public static boolean l()
    {
        return b("android_clean_nag", false);
    }

    public static boolean m()
    {
        return b("android_create_board_pin_dialog", true);
    }

    public static boolean n()
    {
        return b("android_custom_notification", true);
    }

    public static boolean o()
    {
        return b("android_new_find_friends", false);
    }

    public static boolean p()
    {
        return b("android_autocomplete_speedup", false);
    }

    public static void q()
    {
        PinterestJsonObject pinterestjsonobject = w();
        if (pinterestjsonobject != null)
        {
            a(pinterestjsonobject);
            return;
        } else
        {
            a(DiskCache.getJsonObject("MY_EXPERIMENTS"));
            return;
        }
    }

    public static void r()
    {
        ExperimentsApi.a(new ExperimentApiResponse());
    }

    public static void s()
    {
        d.clear();
        c.clear();
        b.clear();
        DiskCache.delete("MY_EXPERIMENTS");
    }

    public static void t()
    {
        d.clear();
    }

    public static Map u()
    {
        return e;
    }

    static HashSet v()
    {
        return b;
    }

    private static PinterestJsonObject w()
    {
        PinterestJsonObject pinterestjsonobject;
        pinterestjsonobject = MyUser.getJson();
        if (pinterestjsonobject == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        pinterestjsonobject = pinterestjsonobject.c("gatekeeper_experiments");
        return pinterestjsonobject;
        Exception exception;
        exception;
        return null;
    }


    private class _cls3 extends ApiResponseHandler
    {

        final String a;

        public final void onSuccess(PinterestJsonObject pinterestjsonobject)
        {
            super.onSuccess(pinterestjsonobject);
            Experiments.v().add(a);
        }

        _cls3(String s1)
        {
            a = s1;
            super();
        }
    }


    private class ExperimentApiResponse extends ApiResponseHandler
    {

        private boolean a;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            Events.post(new ExperimentsLoaded(a));
        }

        public void onFinish()
        {
            super.onFinish();
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            PinterestJsonObject pinterestjsonobject = (PinterestJsonObject)apiresponse.getData();
            if (pinterestjsonobject != null)
            {
                try
                {
                    Experiments.a(pinterestjsonobject);
                    DiskCache.setJsonObject("MY_EXPERIMENTS", pinterestjsonobject);
                }
                catch (Exception exception) { }
            }
            super.onSuccess(apiresponse);
            a = true;
            Events.post(new ExperimentsLoaded(a));
            return;
        }

        public ExperimentApiResponse()
        {
            a = false;
        }

        private class ExperimentsLoaded
        {

            public boolean a;

            public ExperimentsLoaded(boolean flag)
            {
                a = flag;
            }
        }

    }


    private class _cls1 extends HashMap
    {

        _cls1()
        {
            put("restrict_collaborator_invites", new String[] {
                "rollout", "none"
            });
            put("android_action_filter", new String[] {
                "employee", "control", "enabled"
            });
            put("pinvitational_philippines", new String[] {
                "control", "enabled", "employees"
            });
            put("topical_feeds_android", new String[] {
                "enabled", "control", "employees", "enabled_popular_only"
            });
            put("digest_v01", new String[] {
                "employee", "control", "enabled"
            });
            put("android_persistent_top_bar", new String[] {
                "control", "enabled", "employee"
            });
            put("android_clean_nag", new String[] {
                "employee", "control", "enabled"
            });
            put("android_create_board_pin_dialog", new String[] {
                "control", "enabled", "employee"
            });
            put("android_persistent_follow_button", new String[] {
                "control", "autohide", "fixed_to_top"
            });
            put("android_new_find_friends", new String[] {
                "control", "enabled", "employee"
            });
            put("android_custom_notification", new String[] {
                "control", "enabled", "employee"
            });
        }
    }


    private class _cls2 extends HashMap
    {

        _cls2()
        {
            put("restrict_collaborator_invites", "rollout");
            put("android_action_filter", "employee");
            put("topical_feeds_android", "employees");
            put("android_new_find_friends", "employees");
            put("android_custom_notification", "employees");
        }
    }

}
