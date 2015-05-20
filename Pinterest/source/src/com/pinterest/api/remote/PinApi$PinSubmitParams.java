// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.graphics.Bitmap;
import android.util.Base64;
import com.pinterest.api.PinterestJsonObject;
import java.io.ByteArrayOutputStream;

public class k
{

    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public Bitmap g;
    public String h;
    public String i;
    public String j;
    public String k;

    public static k a(PinterestJsonObject pinterestjsonobject)
    {
        k k1 = new <init>();
        try
        {
            k1.i = pinterestjsonobject.a("sdk_package_id", "");
            k1.j = pinterestjsonobject.a("sdk_client_id", "");
            k1.a = pinterestjsonobject.a("board_id", "");
            k1.b = pinterestjsonobject.a("summary", "");
            k1.e = pinterestjsonobject.a("share_facebook", 0);
            k1.f = pinterestjsonobject.a("share_twitter", 0);
            k1.c = pinterestjsonobject.a("source_url", "");
            k1.d = pinterestjsonobject.a("image_url", "");
            k1.k = pinterestjsonobject.a("place", "");
            k1.h = pinterestjsonobject.a("imageData", "");
        }
        // Misplaced declaration of an exception variable
        catch (PinterestJsonObject pinterestjsonobject)
        {
            return k1;
        }
        return k1;
    }

    public final PinterestJsonObject a()
    {
        PinterestJsonObject pinterestjsonobject = new PinterestJsonObject();
        try
        {
            pinterestjsonobject.b("sdk_client_id", j);
            pinterestjsonobject.b("sdk_package_id", i);
            pinterestjsonobject.b("board_id", a);
            pinterestjsonobject.b("summary", b);
            pinterestjsonobject.b("source_url", c);
            pinterestjsonobject.b("image_url", d);
            pinterestjsonobject.b("share_facebook", String.valueOf(e));
            pinterestjsonobject.b("share_twitter", String.valueOf(f));
            pinterestjsonobject.b("place", k);
            if (g != null)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                g.compress(android.graphics.PEG, 90, bytearrayoutputstream);
                bytearrayoutputstream.flush();
                byte abyte0[] = bytearrayoutputstream.toByteArray();
                bytearrayoutputstream.close();
                pinterestjsonobject.b("imageData", Base64.encodeToString(abyte0, 0));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return pinterestjsonobject;
        }
        return pinterestjsonobject;
    }

    public ()
    {
        a = "";
        b = "";
        c = "";
        d = "";
        e = 0;
        f = 0;
        g = null;
        h = "";
        i = "";
        j = "";
        k = "";
    }
}
