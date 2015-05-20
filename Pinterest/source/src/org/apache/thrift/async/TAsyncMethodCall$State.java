// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;


public final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR CONNECTING;
    public static final ERROR ERROR;
    public static final ERROR READING_RESPONSE_BODY;
    public static final ERROR READING_RESPONSE_SIZE;
    public static final ERROR RESPONSE_READ;
    public static final ERROR WRITING_REQUEST_BODY;
    public static final ERROR WRITING_REQUEST_SIZE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/apache/thrift/async/TAsyncMethodCall$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CONNECTING = new <init>("CONNECTING", 0);
        WRITING_REQUEST_SIZE = new <init>("WRITING_REQUEST_SIZE", 1);
        WRITING_REQUEST_BODY = new <init>("WRITING_REQUEST_BODY", 2);
        READING_RESPONSE_SIZE = new <init>("READING_RESPONSE_SIZE", 3);
        READING_RESPONSE_BODY = new <init>("READING_RESPONSE_BODY", 4);
        RESPONSE_READ = new <init>("RESPONSE_READ", 5);
        ERROR = new <init>("ERROR", 6);
        $VALUES = (new .VALUES[] {
            CONNECTING, WRITING_REQUEST_SIZE, WRITING_REQUEST_BODY, READING_RESPONSE_SIZE, READING_RESPONSE_BODY, RESPONSE_READ, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
