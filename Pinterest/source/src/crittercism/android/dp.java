// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package crittercism.android:
//            dq

public final class dp
{

    public static final dp a = new dp();
    private dq b;
    private SimpleDateFormat c;

    private dp()
    {
        b = new a((byte)0);
        c = null;
        try
        {
            c = b();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private static SimpleDateFormat b()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpledateformat;
    }

    public final String a()
    {
        return a(b.a());
    }

    public final String a(Date date)
    {
        if (c != null)
        {
            return c.format(date);
        } else
        {
            b();
            return "";
        }
    }


    private class a
        implements dq
    {

        final dp a;

        public final Date a()
        {
            return new Date();
        }

        private a()
        {
            a = dp.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

}
