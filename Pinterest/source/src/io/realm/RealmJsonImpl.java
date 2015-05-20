// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.util.JsonReader;
import com.pinterest.activity.search.model.TypeAheadRealmItem;
import io.realm.exceptions.RealmException;
import io.realm.internal.RealmJson;
import org.json.JSONObject;

// Referenced classes of package io.realm:
//            RealmObject, TypeAheadRealmItemRealmProxy

class RealmJsonImpl
    implements RealmJson
{

    RealmJsonImpl()
    {
    }

    public void populateUsingJsonObject(RealmObject realmobject, JSONObject jsonobject)
    {
        String s;
        if (realmobject.realm != null)
        {
            s = realmobject.getClass().getSuperclass().getName();
        } else
        {
            s = realmobject.getClass().getName();
        }
        if (s.equals(com/pinterest/activity/search/model/TypeAheadRealmItem.getName()))
        {
            TypeAheadRealmItemRealmProxy.populateUsingJsonObject((TypeAheadRealmItem)realmobject, jsonobject);
            return;
        } else
        {
            throw new RealmException((new StringBuilder("Could not find the generated proxy class for ")).append(s).toString());
        }
    }

    public void populateUsingJsonStream(RealmObject realmobject, JsonReader jsonreader)
    {
        String s;
        if (realmobject.realm != null)
        {
            s = realmobject.getClass().getSuperclass().getName();
        } else
        {
            s = realmobject.getClass().getName();
        }
        if (s.equals(com/pinterest/activity/search/model/TypeAheadRealmItem.getName()))
        {
            TypeAheadRealmItemRealmProxy.populateUsingJsonStream((TypeAheadRealmItem)realmobject, jsonreader);
            return;
        } else
        {
            throw new RealmException((new StringBuilder("Could not find the generated proxy class for ")).append(s).toString());
        }
    }
}
