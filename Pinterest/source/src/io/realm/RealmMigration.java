// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;


// Referenced classes of package io.realm:
//            Realm

public interface RealmMigration
{

    public abstract long execute(Realm realm, long l);
}
