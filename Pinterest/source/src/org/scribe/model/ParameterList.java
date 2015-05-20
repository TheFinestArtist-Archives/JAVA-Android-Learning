// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.model:
//            Parameter

public class ParameterList
{

    private static final String EMPTY_STRING = "";
    private static final String PAIR_SEPARATOR = "=";
    private static final String PARAM_SEPARATOR = "&";
    private static final char QUERY_STRING_SEPARATOR = 63;
    private final List params;

    public ParameterList()
    {
        params = new ArrayList();
    }

    ParameterList(List list)
    {
        params = new ArrayList(list);
    }

    public ParameterList(Map map)
    {
        this();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); params.add(new Parameter((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public void add(String s, String s1)
    {
        params.add(new Parameter(s, s1));
    }

    public void addAll(ParameterList parameterlist)
    {
        params.addAll(parameterlist.params);
    }

    public void addQuerystring(String s)
    {
        if (s != null && s.length() > 0)
        {
            String as[] = s.split("&");
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                s = as[i].split("=");
                String s1 = OAuthEncoder.decode(s[0]);
                if (s.length > 1)
                {
                    s = OAuthEncoder.decode(s[1]);
                } else
                {
                    s = "";
                }
                params.add(new Parameter(s1, s));
                i++;
            }
        }
    }

    public String appendTo(String s)
    {
        Preconditions.checkNotNull(s, "Cannot append to null URL");
        String s1 = asFormUrlEncodedString();
        if (s1.equals(""))
        {
            return s;
        }
        StringBuilder stringbuilder = (new StringBuilder()).append(s);
        if (s.indexOf('?') != -1)
        {
            s = "&";
        } else
        {
            s = Character.valueOf('?');
        }
        s = stringbuilder.append(s).toString();
        return (new StringBuilder()).append(s).append(s1).toString();
    }

    public String asFormUrlEncodedString()
    {
        if (params.size() == 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        Parameter parameter;
        for (Iterator iterator = params.iterator(); iterator.hasNext(); stringbuilder.append('&').append(parameter.asUrlEncodedPair()))
        {
            parameter = (Parameter)iterator.next();
        }

        return stringbuilder.toString().substring(1);
    }

    public String asOauthBaseString()
    {
        return OAuthEncoder.encode(asFormUrlEncodedString());
    }

    public boolean contains(Parameter parameter)
    {
        return params.contains(parameter);
    }

    public int size()
    {
        return params.size();
    }

    public ParameterList sort()
    {
        ParameterList parameterlist = new ParameterList(params);
        Collections.sort(parameterlist.params);
        return parameterlist;
    }
}
