// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.json.JSONArray;

// Referenced classes of package crittercism.android:
//            bf, dp

public final class bx extends bf
{

    public static final bx a = new bx("session_start");
    private String b;
    private String c;

    public bx(String s)
    {
        this(s, dp.a.a());
    }

    private bx(String s, String s1)
    {
        String s2 = s;
        if (s.length() > 140)
        {
            s2 = s.substring(0, 140);
        }
        b = s2;
        c = s1;
    }

    public final void a(OutputStream outputstream)
    {
        outputstream = new OutputStreamWriter(outputstream);
        outputstream.write((new JSONArray()).put(b).put(c).toString());
        outputstream.close();
    }

}
