// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TSimpleJSONProtocol

public class first_ extends first_
{

    protected boolean first_;
    final TSimpleJSONProtocol this$0;

    protected void write()
    {
        if (first_)
        {
            first_ = false;
            return;
        } else
        {
            trans_.write(TSimpleJSONProtocol.COMMA);
            return;
        }
    }

    protected ()
    {
        this$0 = TSimpleJSONProtocol.this;
        super(TSimpleJSONProtocol.this);
        first_ = true;
    }
}
