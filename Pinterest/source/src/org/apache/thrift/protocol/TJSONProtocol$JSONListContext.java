// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TJSONProtocol

public class first_ extends first_
{

    private boolean first_;
    final TJSONProtocol this$0;

    protected void read()
    {
        if (first_)
        {
            first_ = false;
            return;
        } else
        {
            readJSONSyntaxChar(TJSONProtocol.access$000());
            return;
        }
    }

    protected void write()
    {
        if (first_)
        {
            first_ = false;
            return;
        } else
        {
            trans_.write(TJSONProtocol.access$000());
            return;
        }
    }

    protected ()
    {
        this$0 = TJSONProtocol.this;
        super(TJSONProtocol.this);
        first_ = true;
    }
}
