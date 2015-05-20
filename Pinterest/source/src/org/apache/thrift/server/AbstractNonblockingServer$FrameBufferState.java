// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;


final class I extends Enum
{

    private static final AWAITING_CLOSE $VALUES[];
    public static final AWAITING_CLOSE AWAITING_CLOSE;
    public static final AWAITING_CLOSE AWAITING_REGISTER_READ;
    public static final AWAITING_CLOSE AWAITING_REGISTER_WRITE;
    public static final AWAITING_CLOSE READING_FRAME;
    public static final AWAITING_CLOSE READING_FRAME_SIZE;
    public static final AWAITING_CLOSE READ_FRAME_COMPLETE;
    public static final AWAITING_CLOSE WRITING;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(org/apache/thrift/server/AbstractNonblockingServer$FrameBufferState, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        READING_FRAME_SIZE = new <init>("READING_FRAME_SIZE", 0);
        READING_FRAME = new <init>("READING_FRAME", 1);
        READ_FRAME_COMPLETE = new <init>("READ_FRAME_COMPLETE", 2);
        AWAITING_REGISTER_WRITE = new <init>("AWAITING_REGISTER_WRITE", 3);
        WRITING = new <init>("WRITING", 4);
        AWAITING_REGISTER_READ = new <init>("AWAITING_REGISTER_READ", 5);
        AWAITING_CLOSE = new <init>("AWAITING_CLOSE", 6);
        $VALUES = (new .VALUES[] {
            READING_FRAME_SIZE, READING_FRAME, READ_FRAME_COMPLETE, AWAITING_REGISTER_WRITE, WRITING, AWAITING_REGISTER_READ, AWAITING_CLOSE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
