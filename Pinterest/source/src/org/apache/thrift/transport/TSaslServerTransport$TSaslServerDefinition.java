// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.util.Map;
import javax.security.auth.callback.CallbackHandler;

class cbh
{

    public CallbackHandler cbh;
    public String mechanism;
    public Map props;
    public String protocol;
    public String serverName;

    public (String s, String s1, String s2, Map map, CallbackHandler callbackhandler)
    {
        mechanism = s;
        protocol = s1;
        serverName = s2;
        props = map;
        cbh = callbackhandler;
    }
}
