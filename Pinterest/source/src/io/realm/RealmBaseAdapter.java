// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

// Referenced classes of package io.realm:
//            RealmResults, Realm, RealmObject

public abstract class RealmBaseAdapter extends BaseAdapter
{

    protected Context context;
    protected LayoutInflater inflater;
    protected RealmResults realmResults;

    public RealmBaseAdapter(Context context1, RealmResults realmresults, boolean flag)
    {
        if (context1 == null)
        {
            throw new IllegalArgumentException("Context cannot be null");
        }
        if (realmresults == null)
        {
            throw new IllegalArgumentException("RealmResults cannot be null");
        }
        context = context1;
        realmResults = realmresults;
        inflater = LayoutInflater.from(context1);
        if (flag)
        {
            realmresults.getRealm().addChangeListener(new _cls1());
        }
    }

    public int getCount()
    {
        return realmResults.size();
    }

    public RealmObject getItem(int i)
    {
        return realmResults.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public void updateRealmResults(RealmResults realmresults)
    {
        realmResults = realmresults;
        notifyDataSetChanged();
    }

    private class _cls1
        implements RealmChangeListener
    {

        final RealmBaseAdapter this$0;

        public void onChange()
        {
            notifyDataSetChanged();
        }

        _cls1()
        {
            this$0 = RealmBaseAdapter.this;
            super();
        }
    }

}
