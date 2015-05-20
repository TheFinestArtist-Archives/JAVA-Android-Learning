// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;


class ate
{

    static final int $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[];

    static 
    {
        $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State = new int[ate.values().length];
        try
        {
            $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[ate.CONNECTING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[ate.WRITING_REQUEST_SIZE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[ate.WRITING_REQUEST_BODY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[ate.READING_RESPONSE_SIZE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[ate.READING_RESPONSE_BODY.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
