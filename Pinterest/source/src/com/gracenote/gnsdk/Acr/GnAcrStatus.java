// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Acr;

import jni.manager.GnsdkErrorInfo;
import jni.manager.GnsdkManager;

public class GnAcrStatus
{

    private int a;
    private float b;
    private int c;
    private String d;

    public final int a()
    {
        return a;
    }

    public final float b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final String d()
    {
        GnsdkErrorInfo gnsdkerrorinfo = new GnsdkErrorInfo();
        c = GnsdkManager.gnsdk_manager_error_info(gnsdkerrorinfo);
        d = gnsdkerrorinfo.a;
        return d;
    }
}
