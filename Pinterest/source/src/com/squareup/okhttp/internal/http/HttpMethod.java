// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class HttpMethod
{

    public static final Set a = new LinkedHashSet(Arrays.asList(new String[] {
        "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"
    }));

    public static boolean a(String s)
    {
        return s.equals("POST") || s.equals("PATCH") || s.equals("PUT") || s.equals("DELETE");
    }

    public static boolean b(String s)
    {
        return s.equals("POST") || s.equals("PUT") || s.equals("PATCH") || s.equals("DELETE");
    }

}
