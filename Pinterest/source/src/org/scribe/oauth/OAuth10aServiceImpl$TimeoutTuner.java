// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.oauth;

import java.util.concurrent.TimeUnit;
import org.scribe.model.Request;
import org.scribe.model.RequestTuner;

class unit extends RequestTuner
{

    private final int duration;
    private final TimeUnit unit;

    public void tune(Request request)
    {
        request.setReadTimeout(duration, unit);
    }

    public (int i, TimeUnit timeunit)
    {
        duration = i;
        unit = timeunit;
    }
}
