// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.oauth;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.BaseStringExtractor;
import org.scribe.extractors.HeaderExtractor;
import org.scribe.extractors.RequestTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.RequestTuner;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.services.Base64Encoder;
import org.scribe.services.SignatureService;
import org.scribe.services.TimestampService;
import org.scribe.utils.MapUtils;

// Referenced classes of package org.scribe.oauth:
//            OAuthService

public class OAuth10aServiceImpl
    implements OAuthService
{

    private static final String VERSION = "1.0";
    private DefaultApi10a api;
    private OAuthConfig config;

    public OAuth10aServiceImpl(DefaultApi10a defaultapi10a, OAuthConfig oauthconfig)
    {
        api = defaultapi10a;
        config = oauthconfig;
    }

    private void addOAuthParams(OAuthRequest oauthrequest, Token token)
    {
        oauthrequest.addOAuthParameter("oauth_timestamp", api.getTimestampService().getTimestampInSeconds());
        oauthrequest.addOAuthParameter("oauth_nonce", api.getTimestampService().getNonce());
        oauthrequest.addOAuthParameter("oauth_consumer_key", config.getApiKey());
        oauthrequest.addOAuthParameter("oauth_signature_method", api.getSignatureService().getSignatureMethod());
        oauthrequest.addOAuthParameter("oauth_version", getVersion());
        if (config.hasScope())
        {
            oauthrequest.addOAuthParameter("scope", config.getScope());
        }
        oauthrequest.addOAuthParameter("oauth_signature", getSignature(oauthrequest, token));
        config.log((new StringBuilder("appended additional OAuth parameters: ")).append(MapUtils.toString(oauthrequest.getOauthParameters())).toString());
    }

    private void appendSignature(OAuthRequest oauthrequest)
    {
        _cls1..SwitchMap.org.scribe.model.SignatureType[config.getSignatureType().ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 37
    //                   2 66;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        config.log("using Http Header signature");
        oauthrequest.addHeader("Authorization", api.getHeaderExtractor().extract(oauthrequest));
        return;
_L3:
        config.log("using Querystring signature");
        Iterator iterator = oauthrequest.getOauthParameters().entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            oauthrequest.addQuerystringParameter((String)entry.getKey(), (String)entry.getValue());
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private String getSignature(OAuthRequest oauthrequest, Token token)
    {
        config.log("generating signature...");
        config.log((new StringBuilder("using base64 encoder: ")).append(Base64Encoder.type()).toString());
        oauthrequest = api.getBaseStringExtractor().extract(oauthrequest);
        token = api.getSignatureService().getSignature(oauthrequest, config.getApiSecret(), token.getSecret());
        config.log((new StringBuilder("base string is: ")).append(oauthrequest).toString());
        config.log((new StringBuilder("signature is: ")).append(token).toString());
        return token;
    }

    public Token getAccessToken(Token token, Verifier verifier)
    {
        return getAccessToken(token, verifier, 2, TimeUnit.SECONDS);
    }

    public Token getAccessToken(Token token, Verifier verifier, int i, TimeUnit timeunit)
    {
        return getAccessToken(token, verifier, ((RequestTuner) (new TimeoutTuner(i, timeunit))));
    }

    public Token getAccessToken(Token token, Verifier verifier, RequestTuner requesttuner)
    {
        config.log((new StringBuilder("obtaining access token from ")).append(api.getAccessTokenEndpoint()).toString());
        OAuthRequest oauthrequest = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());
        oauthrequest.addOAuthParameter("oauth_token", token.getToken());
        oauthrequest.addOAuthParameter("oauth_verifier", verifier.getValue());
        config.log((new StringBuilder("setting token to: ")).append(token).append(" and verifier to: ").append(verifier).toString());
        addOAuthParams(oauthrequest, token);
        appendSignature(oauthrequest);
        config.log("sending request...");
        token = oauthrequest.send(requesttuner);
        verifier = token.getBody();
        config.log((new StringBuilder("response status code: ")).append(token.getCode()).toString());
        config.log((new StringBuilder("response body: ")).append(verifier).toString());
        return api.getAccessTokenExtractor().extract(verifier);
    }

    public String getAuthorizationUrl(Token token)
    {
        return api.getAuthorizationUrl(token);
    }

    public Token getRequestToken()
    {
        return getRequestToken(2, TimeUnit.SECONDS);
    }

    public Token getRequestToken(int i, TimeUnit timeunit)
    {
        return getRequestToken(((RequestTuner) (new TimeoutTuner(i, timeunit))));
    }

    public Token getRequestToken(RequestTuner requesttuner)
    {
        config.log((new StringBuilder("obtaining request token from ")).append(api.getRequestTokenEndpoint()).toString());
        Object obj = new OAuthRequest(api.getRequestTokenVerb(), api.getRequestTokenEndpoint());
        config.log((new StringBuilder("setting oauth_callback to ")).append(config.getCallback()).toString());
        ((OAuthRequest) (obj)).addOAuthParameter("oauth_callback", config.getCallback());
        addOAuthParams(((OAuthRequest) (obj)), OAuthConstants.EMPTY_TOKEN);
        appendSignature(((OAuthRequest) (obj)));
        config.log("sending request...");
        requesttuner = ((OAuthRequest) (obj)).send(requesttuner);
        obj = requesttuner.getBody();
        config.log((new StringBuilder("response status code: ")).append(requesttuner.getCode()).toString());
        config.log((new StringBuilder("response body: ")).append(((String) (obj))).toString());
        return api.getRequestTokenExtractor().extract(((String) (obj)));
    }

    public String getVersion()
    {
        return "1.0";
    }

    public void signRequest(Token token, OAuthRequest oauthrequest)
    {
        config.log((new StringBuilder("signing request: ")).append(oauthrequest.getCompleteUrl()).toString());
        if (!token.isEmpty())
        {
            oauthrequest.addOAuthParameter("oauth_token", token.getToken());
        }
        config.log((new StringBuilder("setting token to: ")).append(token).toString());
        addOAuthParams(oauthrequest, token);
        appendSignature(oauthrequest);
    }

    private class _cls1
    {

        static final int $SwitchMap$org$scribe$model$SignatureType[];

        static 
        {
            $SwitchMap$org$scribe$model$SignatureType = new int[SignatureType.values().length];
            try
            {
                $SwitchMap$org$scribe$model$SignatureType[SignatureType.Header.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$org$scribe$model$SignatureType[SignatureType.QueryString.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class TimeoutTuner extends RequestTuner
    {

        private final int duration;
        private final TimeUnit unit;

        public void tune(Request request)
        {
            request.setReadTimeout(duration, unit);
        }

        public TimeoutTuner(int i, TimeUnit timeunit)
        {
            duration = i;
            unit = timeunit;
        }
    }

}
