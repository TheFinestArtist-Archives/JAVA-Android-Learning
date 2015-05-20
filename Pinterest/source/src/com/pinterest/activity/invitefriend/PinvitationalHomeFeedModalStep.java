// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PinvitationalHomeFeedModalStep
{

    private String _completeButtonText;
    private String _completeButtonUrl;
    private String _descriptionText;
    private int _dismissAfterSeconds;
    private String _dismissButtonText;
    private boolean _hasBackgroundImage;
    private int _id;
    private int _pinSummaryCount;
    private String _titleText;

    public PinvitationalHomeFeedModalStep(PinterestJsonObject pinterestjsonobject)
    {
        parse(pinterestjsonobject);
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        if (pinterestjsonarray == null || pinterestjsonarray.a() == 0)
        {
            return Collections.EMPTY_LIST;
        }
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < pinterestjsonarray.a(); i++)
        {
            arraylist.add(new PinvitationalHomeFeedModalStep(pinterestjsonarray.c(i)));
        }

        return arraylist;
    }

    private void parse(PinterestJsonObject pinterestjsonobject)
    {
        _id = pinterestjsonobject.a("id", 0);
        _titleText = pinterestjsonobject.a("title_text", "");
        _descriptionText = pinterestjsonobject.a("description_text", "");
        _completeButtonText = pinterestjsonobject.a("complete_button_text", "");
        _dismissButtonText = pinterestjsonobject.a("dismiss_button_text", "");
        _completeButtonUrl = pinterestjsonobject.a("complete_button_url", "");
        _pinSummaryCount = pinterestjsonobject.a("pin_summary", 0);
        _dismissAfterSeconds = pinterestjsonobject.a("dismiss_after_seconds", 0);
        _hasBackgroundImage = pinterestjsonobject.a("background_img", Boolean.valueOf(false)).booleanValue();
    }

    public String getCompleteButtonText()
    {
        return _completeButtonText;
    }

    public String getCompleteButtonUrl()
    {
        return _completeButtonUrl;
    }

    public String getDescriptionText()
    {
        return _descriptionText;
    }

    public int getDismissAfterSeconds()
    {
        return _dismissAfterSeconds;
    }

    public String getDismissButtonText()
    {
        return _dismissButtonText;
    }

    public int getId()
    {
        return _id;
    }

    public int getPinSummaryCount()
    {
        return _pinSummaryCount;
    }

    public String getTitleText()
    {
        return _titleText;
    }

    public boolean hasBackgroundImage()
    {
        return _hasBackgroundImage;
    }
}
