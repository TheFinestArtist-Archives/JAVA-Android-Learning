// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;


// Referenced classes of package io.realm:
//            RealmChangeListener, RealmBaseAdapter

class this._cls0
    implements RealmChangeListener
{

    final RealmBaseAdapter this$0;

    public void onChange()
    {
        notifyDataSetChanged();
    }

    ()
    {
        this$0 = RealmBaseAdapter.this;
        super();
    }
}
