// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.text;

import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.ui.text:
//            NoUnderlineClickSpan

public class HashTag extends NoUnderlineClickSpan
{

    public HashTag()
    {
    }

    public void onClick(View view)
    {
        view = (Spanned)((TextView)view).getText();
        view = view.subSequence(view.getSpanStart(this) + 1, view.getSpanEnd(this)).toString();
        Pinalytics.a(ElementType.HASH_TAG, ComponentType.MODAL_PIN, view);
        Events.post(new Navigation(Location.SEARCH_PIN, view));
    }

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        textpaint.setFakeBoldText(true);
    }
}
