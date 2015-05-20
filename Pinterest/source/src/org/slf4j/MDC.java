// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j;

import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

public class MDC
{

    static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
    static MDCAdapter mdcAdapter;

    private MDC()
    {
    }

    public static void clear()
    {
        if (mdcAdapter == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            mdcAdapter.clear();
            return;
        }
    }

    public static String get(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (mdcAdapter == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            return mdcAdapter.get(s);
        }
    }

    public static Map getCopyOfContextMap()
    {
        if (mdcAdapter == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            return mdcAdapter.getCopyOfContextMap();
        }
    }

    public static MDCAdapter getMDCAdapter()
    {
        return mdcAdapter;
    }

    public static void put(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (mdcAdapter == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            mdcAdapter.put(s, s1);
            return;
        }
    }

    public static void remove(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (mdcAdapter == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            mdcAdapter.remove(s);
            return;
        }
    }

    public static void setContextMap(Map map)
    {
        if (mdcAdapter == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            mdcAdapter.setContextMap(map);
            return;
        }
    }

    static 
    {
        try
        {
            mdcAdapter = StaticMDCBinder.SINGLETON.getMDCA();
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            mdcAdapter = new NOPMDCAdapter();
            String s = noclassdeffounderror.getMessage();
            if (s != null && s.indexOf("org/slf4j/impl/StaticMDCBinder") != -1)
            {
                Util.report("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                Util.report("Defaulting to no-operation MDCAdapter implementation.");
                Util.report("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
            } else
            {
                throw noclassdeffounderror;
            }
        }
        catch (Exception exception)
        {
            Util.report("MDC binding unsuccessful.", exception);
        }
    }
}
