// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class ka
{

    public static String a(String s, String s1, Context context, AttributeSet attributeset, boolean flag, boolean flag1, String s2)
    {
        if (attributeset == null)
        {
            s = null;
        } else
        {
            s = attributeset.getAttributeValue(s, s1);
        }
        attributeset = s;
        if (s != null)
        {
            attributeset = s;
            if (s.startsWith("@string/"))
            {
                attributeset = s;
                if (flag)
                {
                    String s3 = s.substring(8);
                    String s4 = context.getPackageName();
                    attributeset = new TypedValue();
                    try
                    {
                        context.getResources().getValue((new StringBuilder()).append(s4).append(":string/").append(s3).toString(), attributeset, true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        Log.w(s2, (new StringBuilder("Could not find resource for ")).append(s1).append(": ").append(s).toString());
                    }
                    if (((TypedValue) (attributeset)).string != null)
                    {
                        attributeset = ((TypedValue) (attributeset)).string.toString();
                    } else
                    {
                        Log.w(s2, (new StringBuilder("Resource ")).append(s1).append(" was not a string: ").append(attributeset).toString());
                        attributeset = s;
                    }
                }
            }
        }
        if (flag1 && attributeset == null)
        {
            Log.w(s2, (new StringBuilder("Required XML attribute \"")).append(s1).append("\" missing").toString());
        }
        return attributeset;
    }
}
