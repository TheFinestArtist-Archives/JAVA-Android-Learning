// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;

public final class jv
{

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static a h(Object obj)
    {
        return new a(obj, null);
    }

    public static transient int hashCode(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }

    private class a
    {

        private final List Nr;
        private final Object Ns;

        public final a a(String s, Object obj)
        {
            Nr.add((new StringBuilder()).append((String)jx.i(s)).append("=").append(String.valueOf(obj)).toString());
            return this;
        }

        public final String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder(100)).append(Ns.getClass().getSimpleName()).append('{');
            int j = Nr.size();
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append((String)Nr.get(i));
                if (i < j - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            return stringbuilder.append('}').toString();
        }

        private a(Object obj)
        {
            Ns = jx.i(obj);
            Nr = new ArrayList();
        }

        a(Object obj, _cls1 _pcls1)
        {
            this(obj);
        }
    }

}
