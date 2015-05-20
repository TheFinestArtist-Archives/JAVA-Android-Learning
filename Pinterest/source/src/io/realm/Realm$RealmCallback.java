// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.os.Message;
import io.realm.internal.ImplicitTransaction;

// Referenced classes of package io.realm:
//            Realm

class <init>
    implements android.os.nit>
{

    final Realm this$0;

    public boolean handleMessage(Message message)
    {
        if (message.what == 0xe3d1b0)
        {
            Realm.access$000(Realm.this).advanceRead();
            sendNotifications();
        }
        return true;
    }

    private nsaction()
    {
        this$0 = Realm.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
