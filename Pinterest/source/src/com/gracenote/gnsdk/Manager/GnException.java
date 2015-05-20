// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager;

import jni.manager.GnsdkErrorInfo;
import jni.manager.GnsdkErrors;
import jni.manager.GnsdkManager;

public class GnException extends Exception
{

    private int a;
    private String b;

    private GnException(int i)
    {
        a = 0;
        b = null;
        a = i;
        GnsdkErrorInfo gnsdkerrorinfo = new GnsdkErrorInfo();
        GnsdkManager.gnsdk_manager_error_info(gnsdkerrorinfo);
        if (gnsdkerrorinfo.a == null || gnsdkerrorinfo.a.isEmpty())
        {
            b = String.format("[%d]: No error description", new Object[] {
                Integer.valueOf(i)
            });
            return;
        } else
        {
            b = String.format("[%d]: %s", new Object[] {
                Integer.valueOf(i), gnsdkerrorinfo.a
            });
            return;
        }
    }

    public GnException(String s)
    {
        a = 0;
        b = null;
        a = GnsdkErrors.au;
        b = s;
    }

    public static void a(int i)
    {
        if (GnsdkErrors.b(i))
        {
            throw new GnException(i);
        } else
        {
            return;
        }
    }

    public final int a()
    {
        return a;
    }

    public String getMessage()
    {
        return b;
    }
}
