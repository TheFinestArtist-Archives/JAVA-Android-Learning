// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TSimpleJSONProtocol

public class colon_ extends colon_
{

    protected boolean colon_;
    protected boolean first_;
    final TSimpleJSONProtocol this$0;

    protected void write()
    {
        boolean flag;
        if (first_)
        {
            first_ = false;
            flag = true;
        } else
        {
            TTransport ttransport = trans_;
            byte abyte0[];
            if (colon_)
            {
                abyte0 = TSimpleJSONProtocol.COLON;
            } else
            {
                abyte0 = TSimpleJSONProtocol.COMMA;
            }
            ttransport.write(abyte0);
            if (!colon_)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        colon_ = flag;
    }

    protected ()
    {
        this$0 = TSimpleJSONProtocol.this;
        super(TSimpleJSONProtocol.this);
        first_ = true;
        colon_ = true;
    }
}
