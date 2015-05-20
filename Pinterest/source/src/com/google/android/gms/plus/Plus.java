// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.oz;
import com.google.android.gms.internal.pa;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pc;
import com.google.android.gms.plus.internal.e;

// Referenced classes of package com.google.android.gms.plus:
//            Account, Moments, People, b, 
//            a

public final class Plus
{

    public static final Api API;
    public static final Account AccountApi = new oy();
    public static final com.google.android.gms.common.api.Api.c DQ;
    static final com.google.android.gms.common.api.Api.b DR;
    public static final Moments MomentsApi = new pb();
    public static final People PeopleApi = new pc();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    public static final b anp = new pa();
    public static final a anq = new oz();

    private Plus()
    {
    }

    public static e a(GoogleApiClient googleapiclient, com.google.android.gms.common.api.Api.c c)
    {
        boolean flag1 = true;
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jx.b(flag, "GoogleApiClient parameter is required.");
        jx.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (e)googleapiclient.a(c);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        jx.a(flag, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    static 
    {
        DQ = new com.google.android.gms.common.api.Api.c();
        DR = new _cls1();
        API = new Api(DR, DQ, new Scope[0]);
    }

    private class _cls1
        implements com.google.android.gms.common.api.Api.b
    {

        public final volatile com.google.android.gms.common.api.Api.a a(Context context, Looper looper, jg jg1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return a(context, looper, jg1, (PlusOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final e a(Context context, Looper looper, jg jg1, PlusOptions plusoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            PlusOptions plusoptions1 = plusoptions;
            if (plusoptions == null)
            {
                plusoptions1 = new PlusOptions(null);
            }
            plusoptions = jg1.hm();
            jg1 = jg1.hp();
            String as[] = (String[])plusoptions1.ans.toArray(new String[0]);
            String s = context.getPackageName();
            String s1 = context.getPackageName();
            PlusCommonExtras pluscommonextras = new PlusCommonExtras();
            return new e(context, looper, connectioncallbacks, onconnectionfailedlistener, new h(plusoptions, jg1, as, new String[0], s, s1, null, pluscommonextras));
        }

        public final int getPriority()
        {
            return 2;
        }

        _cls1()
        {
        }

        private class PlusOptions
            implements com.google.android.gms.common.api.Api.ApiOptions.Optional
        {

            final String anr;
            final Set ans;

            public static Builder builder()
            {
                return new Builder();
            }

            private PlusOptions()
            {
                anr = null;
                ans = new HashSet();
            }

            PlusOptions(_cls1 _pcls1)
            {
                this();
            }

            private PlusOptions(Builder builder1)
            {
                class Builder
                {

                    String anr;
                    final Set ans = new HashSet();

                    public final transient Builder addActivityTypes(String as[])
                    {
                        jx.b(as, "activityTypes may not be null.");
                        for (int i = 0; i < as.length; i++)
                        {
                            ans.add(as[i]);
                        }

                        return this;
                    }

                    public final PlusOptions build()
                    {
                        return new PlusOptions(this, null);
                    }

                    public final Builder setServerClientId(String s)
                    {
                        anr = s;
                        return this;
                    }

                    public Builder()
                    {
                    }
                }

                anr = builder1.anr;
                ans = builder1.ans;
            }

            PlusOptions(Builder builder1, _cls1 _pcls1)
            {
                this(builder1);
            }
        }

    }

}
