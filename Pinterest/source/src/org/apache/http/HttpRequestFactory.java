// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http;


// Referenced classes of package org.apache.http:
//            HttpRequest, RequestLine

public interface HttpRequestFactory
{

    public abstract HttpRequest newHttpRequest(String s, String s1);

    public abstract HttpRequest newHttpRequest(RequestLine requestline);
}
