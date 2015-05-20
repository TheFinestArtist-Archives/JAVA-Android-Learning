// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TJSONProtocol

public class colon_ extends colon_
{

    private boolean colon_;
    private boolean first_;
    final TJSONProtocol this$0;

    protected boolean escapeNum()
    {
        return colon_;
    }

    protected void read()
    {
        boolean flag;
        if (first_)
        {
            first_ = false;
            flag = true;
        } else
        {
            TJSONProtocol tjsonprotocol = TJSONProtocol.this;
            byte abyte0[];
            if (colon_)
            {
                abyte0 = TJSONProtocol.access$100();
            } else
            {
                abyte0 = TJSONProtocol.access$000();
            }
            tjsonprotocol.readJSONSyntaxChar(abyte0);
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
                abyte0 = TJSONProtocol.access$100();
            } else
            {
                abyte0 = TJSONProtocol.access$000();
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
        this$0 = TJSONProtocol.this;
        super(TJSONProtocol.this);
        first_ = true;
        colon_ = true;
    }
}
