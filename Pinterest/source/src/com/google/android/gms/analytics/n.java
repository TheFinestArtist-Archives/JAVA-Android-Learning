// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.google.android.gms.analytics:
//            ae, m

abstract class n
{

    Context mContext;
    a yL;

    public n(Context context, a a1)
    {
        mContext = context;
        yL = a1;
    }

    private m a(XmlResourceParser xmlresourceparser)
    {
        int i;
        xmlresourceparser.next();
        i = xmlresourceparser.getEventType();
_L7:
        if (i == 1) goto _L2; else goto _L1
_L1:
        if (xmlresourceparser.getEventType() != 2) goto _L4; else goto _L3
_L3:
        String s = xmlresourceparser.getName().toLowerCase();
        if (!s.equals("screenname")) goto _L6; else goto _L5
_L5:
        s = xmlresourceparser.getAttributeValue(null, "name");
        String s1 = xmlresourceparser.nextText().trim();
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            yL.e(s, s1);
        }
_L4:
        i = xmlresourceparser.next();
          goto _L7
_L6:
        if (!s.equals("string")) goto _L9; else goto _L8
_L8:
        String s2;
        s = xmlresourceparser.getAttributeValue(null, "name");
        s2 = xmlresourceparser.nextText().trim();
        if (TextUtils.isEmpty(s) || s2 == null) goto _L4; else goto _L10
_L10:
        yL.f(s, s2);
          goto _L4
        xmlresourceparser;
        ae.T((new StringBuilder("Error parsing tracker configuration file: ")).append(xmlresourceparser).toString());
_L2:
        return yL.er();
_L9:
        if (!s.equals("bool")) goto _L12; else goto _L11
_L11:
        s2 = xmlresourceparser.getAttributeValue(null, "name");
        s = xmlresourceparser.nextText().trim();
        if (TextUtils.isEmpty(s2)) goto _L4; else goto _L13
_L13:
        boolean flag = TextUtils.isEmpty(s);
        if (flag) goto _L4; else goto _L14
_L14:
        flag = Boolean.parseBoolean(s);
        yL.e(s2, flag);
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        ae.T((new StringBuilder("Error parsing bool configuration value: ")).append(s).toString());
          goto _L4
        xmlresourceparser;
        ae.T((new StringBuilder("Error parsing tracker configuration file: ")).append(xmlresourceparser).toString());
          goto _L2
_L12:
        if (!s.equals("integer")) goto _L4; else goto _L15
_L15:
        numberformatexception = xmlresourceparser.getAttributeValue(null, "name");
        s = xmlresourceparser.nextText().trim();
        if (TextUtils.isEmpty(numberformatexception)) goto _L4; else goto _L16
_L16:
        flag = TextUtils.isEmpty(s);
        if (flag) goto _L4; else goto _L17
_L17:
        int j = Integer.parseInt(s);
        yL.c(numberformatexception, j);
          goto _L4
        numberformatexception;
        ae.T((new StringBuilder("Error parsing int configuration value: ")).append(s).toString());
          goto _L4
    }

    public m x(int i)
    {
        m m;
        try
        {
            m = a(mContext.getResources().getXml(i));
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            ae.W((new StringBuilder("inflate() called with unknown resourceId: ")).append(notfoundexception).toString());
            return null;
        }
        return m;
    }

    private class a
    {

        public abstract void c(String s, int i);

        public abstract void e(String s, String s1);

        public abstract void e(String s, boolean flag);

        public abstract m er();

        public abstract void f(String s, String s1);
    }

}
