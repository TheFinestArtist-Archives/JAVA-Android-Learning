// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import android.util.JsonReader;
import io.realm.RealmObject;
import org.json.JSONObject;

public interface RealmJson
{

    public abstract void populateUsingJsonObject(RealmObject realmobject, JSONObject jsonobject);

    public abstract void populateUsingJsonStream(RealmObject realmobject, JsonReader jsonreader);
}
