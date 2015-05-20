// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            bk, bl

public final class bd
    implements bk
{

    private JSONObject a;

    public bd()
    {
        a = (new bl()).a(new bq.c()).a(new bq.b()).a(new bq.f()).a(new bq.l()).a(new bq.o()).a(new bq.q()).a(new bq.v()).a(new bq.w()).a();
    }

    public final void a(OutputStream outputstream)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("app_state", a);
        outputstream = new OutputStreamWriter(outputstream);
        outputstream.write((new JSONObject(hashmap)).toString());
        outputstream.close();
    }
}
