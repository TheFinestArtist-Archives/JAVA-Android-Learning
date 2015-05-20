// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import org.scribe.utils.OAuthEncoder;

public class Parameter
    implements Comparable
{

    private static final String UTF = "UTF8";
    private final String key;
    private final String value;

    public Parameter(String s, String s1)
    {
        key = s;
        value = s1;
    }

    public String asUrlEncodedPair()
    {
        return OAuthEncoder.encode(key).concat("=").concat(OAuthEncoder.encode(value));
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Parameter)obj);
    }

    public int compareTo(Parameter parameter)
    {
        int i = key.compareTo(parameter.key);
        if (i != 0)
        {
            return i;
        } else
        {
            return value.compareTo(parameter.value);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof Parameter)
            {
                obj = (Parameter)obj;
                if (((Parameter) (obj)).key.equals(key) && ((Parameter) (obj)).value.equals(value))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode()
    {
        return key.hashCode() + value.hashCode();
    }
}
