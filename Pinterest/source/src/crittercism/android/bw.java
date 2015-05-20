// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            bk, bl, be, bj, 
//            cg

public final class bw
    implements bk
{

    private JSONObject a;
    private JSONObject b;
    private JSONArray c;
    private File d;

    public bw(File file, bj bj1, bj bj2, bj bj3)
    {
        file.exists();
        d = file;
        a = (new bl()).a(new bq.c()).a(new bq.b()).a(new bq.d()).a(new bq.f()).a(new bq.i()).a(new bq.y()).a(new bq.z()).a(new bq.l()).a(new bq.q()).a(new bq.r()).a(new bq.v()).a(new bq.w()).a();
        file = new HashMap();
        file.put("crashed_session", (new be(bj1)).a);
        if (bj2.c() > 0)
        {
            file.put("previous_session", (new be(bj2)).a);
        }
        b = new JSONObject(file);
        c = (new be(bj3)).a;
    }

    public final void a(OutputStream outputstream)
    {
        HashMap hashmap1 = new HashMap();
        hashmap1.put("app_state", a);
        hashmap1.put("breadcrumbs", b);
        hashmap1.put("endpoints", c);
        byte abyte0[] = new byte[0];
        byte abyte2[] = new byte[8192];
        FileInputStream fileinputstream = new FileInputStream(d);
        do
        {
            int i = fileinputstream.read(abyte2);
            if (i != -1)
            {
                byte abyte1[] = new byte[abyte0.length + i];
                System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
                System.arraycopy(abyte2, 0, abyte1, abyte0.length, i);
                abyte0 = abyte1;
            } else
            {
                fileinputstream.close();
                HashMap hashmap = new HashMap();
                hashmap.put("dmp_name", d.getName());
                hashmap.put("dmp_file", cg.a(abyte0));
                hashmap1.put("ndk_dmp_info", new JSONObject(hashmap));
                outputstream = new OutputStreamWriter(outputstream);
                outputstream.write((new JSONObject(hashmap1)).toString());
                outputstream.close();
                return;
            }
        } while (true);
    }
}
