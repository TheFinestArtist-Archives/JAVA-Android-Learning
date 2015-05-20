// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            bm

public final class df
    implements bm
{

    private Map a;

    public df()
    {
        a = new HashMap();
        a.put("username", "anonymous");
    }

    public final JSONObject a()
    {
        return new JSONObject(a);
    }

    public final void a(String s, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        Log.w("Crittercism", (new StringBuilder("Ignoring null value for metadata key ")).append(s).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.put(s, obj);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public final void a(JSONObject jsonobject)
    {
        this;
        JVM INSTR monitorenter ;
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        Log.w("Crittercism", "JSONObject cannot be null.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = jsonobject.keys();
_L3:
        String s;
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = (String)iterator.next();
        obj = jsonobject.opt(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        hashmap.put(s, obj);
          goto _L3
        jsonobject;
        throw jsonobject;
        Log.w("Crittercism", (new StringBuilder("Ignoring null value for metadata key ")).append(s).toString());
          goto _L3
        a.putAll(hashmap);
          goto _L4
    }

    public final Object b()
    {
        return a();
    }
}
