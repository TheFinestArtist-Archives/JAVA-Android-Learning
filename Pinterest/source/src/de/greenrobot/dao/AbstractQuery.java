// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package de.greenrobot.dao:
//            AbstractDao

abstract class AbstractQuery
{

    protected final AbstractDao dao;
    protected final String parameters[];
    protected final String sql;

    protected AbstractQuery(AbstractDao abstractdao, String s, Collection collection)
    {
        dao = abstractdao;
        sql = s;
        parameters = new String[collection.size()];
        int i = 0;
        abstractdao = collection.iterator();
        do
        {
            if (!abstractdao.hasNext())
            {
                return;
            }
            s = ((String) (abstractdao.next()));
            if (s != null)
            {
                parameters[i] = s.toString();
            } else
            {
                parameters[i] = null;
            }
            i++;
        } while (true);
    }

    public void setParameter(int i, Object obj)
    {
        if (obj != null)
        {
            parameters[i] = obj.toString();
            return;
        } else
        {
            parameters[i] = null;
            return;
        }
    }
}
