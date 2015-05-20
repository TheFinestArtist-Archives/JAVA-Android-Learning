// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.education.model;

import com.pinterest.api.PinterestJsonObject;

public class EducationButton
{

    public static final int DEFAULT_DESTINATION = 0;
    private int _destination;
    private String _label;

    public EducationButton(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject != null)
        {
            _label = pinterestjsonobject.a("label", "");
            _destination = pinterestjsonobject.a("destination", 0);
        }
    }

    public int getDestination()
    {
        return _destination;
    }

    public String getLabel()
    {
        return _label;
    }
}
