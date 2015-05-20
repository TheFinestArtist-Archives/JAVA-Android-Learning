// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.os.ConditionVariable;
import java.io.IOException;
import org.json.JSONArray;

// Referenced classes of package crittercism.android:
//            bt, cw, dm

public final class bu
    implements bt
{

    private String a[];

    public bu()
    {
        String s;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            s = "logcat -t 100 -v time";
        } else
        {
            s = "logcat -d -v time";
        }
        a = s.split("\\s+");
    }

    private static JSONArray a(String as[])
    {
        Object obj = null;
        JSONArray jsonarray = obj;
        if (as != null)
        {
            jsonarray = obj;
            if (as.length > 0)
            {
                int i;
                if (as.length > 200)
                {
                    i = as.length - 200;
                } else
                {
                    i = 0;
                }
                jsonarray = new JSONArray();
                for (; i < as.length; i++)
                {
                    jsonarray.put(as[i]);
                }

            }
        }
        return jsonarray;
    }

    private Process b()
    {
        Process process;
        try
        {
            process = (new ProcessBuilder(new String[0])).command(a).start();
        }
        catch (IOException ioexception)
        {
            (new StringBuilder("IOException in createProcess(): ")).append(ioexception.getMessage());
            return null;
        }
        return process;
    }

    public final JSONArray a()
    {
        Object obj;
        obj = null;
        Process process;
        cw cw1;
        cw cw2;
        try
        {
            process = b();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            (new StringBuilder("Unanticipated throwable in getLogcat: ")).append(((Throwable) (obj)).getMessage());
            return null;
        }
        if (process == null) goto _L2; else goto _L1
_L1:
        obj = new ConditionVariable();
        cw1 = new cw(process, ((ConditionVariable) (obj)), cw.a.a);
        cw2 = new cw(process, null, cw.a.b);
        (new dm(cw1)).start();
        (new dm(cw2)).start();
        ((ConditionVariable) (obj)).block(250L);
        process.destroy();
        obj = cw1.b();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = ((StringBuilder) (obj)).toString();
        if (((String) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = ((String) (obj)).split("\n");
_L3:
        obj = a(((String []) (obj)));
_L2:
        return ((JSONArray) (obj));
        obj = null;
          goto _L3
    }
}
