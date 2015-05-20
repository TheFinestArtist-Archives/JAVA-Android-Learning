// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Metadata;


public final class W extends Enum
{

    public static final V A;
    public static final V B;
    public static final V C;
    public static final V D;
    public static final V E;
    public static final V F;
    public static final V G;
    public static final V H;
    public static final V I;
    public static final V J;
    public static final V K;
    public static final V L;
    public static final V M;
    public static final V N;
    public static final V O;
    public static final V P;
    public static final V Q;
    public static final V R;
    public static final V S;
    public static final V T;
    public static final V U;
    public static final V V;
    private static final V X[];
    public static final V a;
    public static final V b;
    public static final V c;
    public static final V d;
    public static final V e;
    public static final V f;
    public static final V g;
    public static final V h;
    public static final V i;
    public static final V j;
    public static final V k;
    public static final V l;
    public static final V m;
    public static final V n;
    public static final V o;
    public static final V p;
    public static final V q;
    public static final V r;
    public static final V s;
    public static final V t;
    public static final V u;
    public static final V v;
    public static final V w;
    public static final V x;
    public static final V y;
    public static final V z;
    private String W;

    public static W a(String s1)
    {
        if (s1 != null)
        {
            W aw[] = values();
            int j1 = aw.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                W w1 = aw[i1];
                if (s1.equalsIgnoreCase(w1.W))
                {
                    return w1;
                }
            }

        }
        return null;
    }

    public static W valueOf(String s1)
    {
        return (W)Enum.valueOf(com/gracenote/gnsdk/Metadata/GnTypes$GnMetadataObjectType, s1);
    }

    public static W[] values()
    {
        return (W[])X.clone();
    }

    static 
    {
        a = new <init>("Album", 0, "gnsdk_ctx_album");
        b = new <init>("Artist", 1, "gnsdk_ctx_artist");
        c = new <init>("Work", 2, "gnsdk_ctx_audio_work");
        d = new <init>("Content", 3, "gnsdk_ctx_content");
        e = new <init>("Contributor", 4, "gnsdk_ctx_contributor");
        f = new <init>("Credit", 5, "gnsdk_ctx_credit");
        g = new <init>("ExtendedData", 6, "gnsdk_ctx_extdata");
        h = new <init>("ExternalID", 7, "gnsdk_ctx_xid");
        i = new <init>("Acr", 8, "ctx_match_acr");
        j = new <init>("MatchInfo", 9, "gnsdk_ctx_matchinfo");
        k = new <init>("Name", 10, "gnsdk_ctx_name");
        l = new <init>("ResponseACR", 11, "ctx_response_acr");
        m = new <init>("ResponseAlbum", 12, "gnsdk_ctx_response_album");
        n = new <init>("ResponseContributor", 13, "gnsdk_ctx_response_contributor");
        o = new <init>("ResponseMatch", 14, "gnsdk_ctx_response_match");
        p = new <init>("ResponseMatchInfo", 15, "gnsdk_ctx_response_matchinfo");
        q = new <init>("ResponseSuggestions", 16, "gnsdk_ctx_response_suggestions");
        r = new <init>("ResponseTrack", 17, "gnsdk_ctx_response_track");
        s = new <init>("ResponseTVAiring", 18, "gnsdk_ctx_response_tvairing");
        t = new <init>("ResponseTVChannel", 19, "gnsdk_ctx_response_tvchannel");
        u = new <init>("ResponseTVProgram", 20, "gnsdk_ctx_response_tvprogram");
        v = new <init>("ResponseTVProvider", 21, "gnsdk_ctx_response_tvprovider");
        w = new <init>("ResponseVideo", 22, "gnsdk_ctx_response_video_product");
        x = new <init>("ResponseVideoObject", 23, "gnsdk_ctx_response_video_object");
        y = new <init>("ResponseVideoProduct", 24, "gnsdk_ctx_response_video_product");
        z = new <init>("ResponseVideoSeason", 25, "gnsdk_ctx_response_video_season");
        A = new <init>("ResponseVideoSeries", 26, "gnsdk_ctx_response_video_series");
        B = new <init>("ResponseVideoWork", 27, "gnsdk_ctx_response_video_work");
        C = new <init>("ResponseVideoClip", 28, "gnsdk_ctx_response_videoclip");
        D = new <init>("Title", 29, "gnsdk_ctx_title");
        E = new <init>("Track", 30, "gnsdk_ctx_track");
        F = new <init>("TVAiring", 31, "gnsdk_ctx_tvairing");
        G = new <init>("TVChannel", 32, "gnsdk_ctx_tvchannel");
        H = new <init>("TVProgram", 33, "gnsdk_ctx_tvprogram");
        I = new <init>("TVProvider", 34, "gnsdk_ctx_tvprovider");
        J = new <init>("VideoChapter", 35, "gnsdk_ctx_video_chapter");
        K = new <init>("VideoDisc", 36, "gnsdk_ctx_video_disc");
        L = new <init>("VideoFeature", 37, "gnsdk_ctx_video_feature");
        M = new <init>("VideoLayer", 38, "gnsdk_ctx_video_layer");
        N = new <init>("VideoProduct", 39, "gnsdk_ctx_video_product");
        O = new <init>("VideoSeason", 40, "gnsdk_ctx_video_season");
        P = new <init>("VideoSeries", 41, "gnsdk_ctx_video_series");
        Q = new <init>("VideoSide", 42, "gnsdk_ctx_video_side");
        R = new <init>("VideoWork", 43, "gnsdk_ctx_video_work");
        S = new <init>("VideoClip", 44, "gnsdk_ctx_videoclip");
        T = new <init>("GnMetadataObject", 45, "GnMetadataObject");
        U = new <init>("Unknown", 46, "Unknown");
        V = new <init>("Match", 47, "gnsdk_gdo_type_match");
        X = (new X[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S, T, U, V
        });
    }

    private (String s1, int i1, String s2)
    {
        super(s1, i1);
        W = s2;
    }
}
