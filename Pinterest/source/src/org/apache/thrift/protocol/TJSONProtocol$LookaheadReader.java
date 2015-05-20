// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TJSONProtocol

public class data_
{

    private byte data_[];
    private boolean hasData_;
    final TJSONProtocol this$0;

    protected byte peek()
    {
        if (!hasData_)
        {
            trans_.readAll(data_, 0, 1);
        }
        hasData_ = true;
        return data_[0];
    }

    protected byte read()
    {
        if (hasData_)
        {
            hasData_ = false;
        } else
        {
            trans_.readAll(data_, 0, 1);
        }
        return data_[0];
    }

    protected ()
    {
        this$0 = TJSONProtocol.this;
        super();
        data_ = new byte[1];
    }
}
