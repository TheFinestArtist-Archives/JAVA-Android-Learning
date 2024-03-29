// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;


// Referenced classes of package org.scribe.model:
//            Token

public class OAuthConstants
{

    public static final String ACCESS_TOKEN = "access_token";
    public static final String CALLBACK = "oauth_callback";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String CODE = "code";
    public static final String CONSUMER_KEY = "oauth_consumer_key";
    public static final String CONSUMER_SECRET = "oauth_consumer_secret";
    public static final Token EMPTY_TOKEN = new Token("", "");
    public static final String HEADER = "Authorization";
    public static final String NONCE = "oauth_nonce";
    public static final String OUT_OF_BAND = "oob";
    public static final String PARAM_PREFIX = "oauth_";
    public static final String REALM = "realm";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String SCOPE = "scope";
    public static final String SIGNATURE = "oauth_signature";
    public static final String SIGN_METHOD = "oauth_signature_method";
    public static final String TIMESTAMP = "oauth_timestamp";
    public static final String TOKEN = "oauth_token";
    public static final String TOKEN_SECRET = "oauth_token_secret";
    public static final String VERIFIER = "oauth_verifier";
    public static final String VERSION = "oauth_version";

    private OAuthConstants()
    {
    }

}
