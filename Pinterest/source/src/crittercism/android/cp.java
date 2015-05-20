// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class cp
{

    public URL a;
    public Map b;
    public int c;
    public boolean d;
    public boolean e;
    public String f;
    public boolean g;
    public int h;

    public cp(URL url)
    {
        b = new HashMap();
        c = 0;
        d = true;
        e = true;
        f = "POST";
        g = false;
        h = 2500;
        a = url;
        b.put("User-Agent", Arrays.asList(new String[] {
            "4.3.0"
        }));
        b.put("Content-Type", Arrays.asList(new String[] {
            "application/json"
        }));
        b.put("Accept", Arrays.asList(new String[] {
            "text/plain", "application/json"
        }));
    }
}
