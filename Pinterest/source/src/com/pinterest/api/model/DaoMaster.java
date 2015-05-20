// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.IdentityScopeType;

// Referenced classes of package com.pinterest.api.model:
//            CategoryDao, StoryDao, ActorDao, NotificationDao, 
//            NotificationTemplateDao, ConversationDao, ConversationMessageDao, UserDao, 
//            PartnerDao, BoardDao, CommentDao, InterestDao, 
//            PlaceDao, PinDao, BoardInviteDao, BusinessTypeDao, 
//            SearchFilterDao, FilterOptionDao, DigestItemDao, DaoSession

public class DaoMaster extends AbstractDaoMaster
{

    public static final int SCHEMA_VERSION = 118;

    public DaoMaster(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase, 118);
        registerDaoClass(com/pinterest/api/model/CategoryDao);
        registerDaoClass(com/pinterest/api/model/StoryDao);
        registerDaoClass(com/pinterest/api/model/ActorDao);
        registerDaoClass(com/pinterest/api/model/NotificationDao);
        registerDaoClass(com/pinterest/api/model/NotificationTemplateDao);
        registerDaoClass(com/pinterest/api/model/ConversationDao);
        registerDaoClass(com/pinterest/api/model/ConversationMessageDao);
        registerDaoClass(com/pinterest/api/model/UserDao);
        registerDaoClass(com/pinterest/api/model/PartnerDao);
        registerDaoClass(com/pinterest/api/model/BoardDao);
        registerDaoClass(com/pinterest/api/model/CommentDao);
        registerDaoClass(com/pinterest/api/model/InterestDao);
        registerDaoClass(com/pinterest/api/model/PlaceDao);
        registerDaoClass(com/pinterest/api/model/PinDao);
        registerDaoClass(com/pinterest/api/model/BoardInviteDao);
        registerDaoClass(com/pinterest/api/model/BusinessTypeDao);
        registerDaoClass(com/pinterest/api/model/SearchFilterDao);
        registerDaoClass(com/pinterest/api/model/FilterOptionDao);
        registerDaoClass(com/pinterest/api/model/DigestItemDao);
    }

    public static void createAllTables(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        CategoryDao.createTable(sqlitedatabase, flag);
        StoryDao.createTable(sqlitedatabase, flag);
        ActorDao.createTable(sqlitedatabase, flag);
        NotificationDao.createTable(sqlitedatabase, flag);
        NotificationTemplateDao.createTable(sqlitedatabase, flag);
        ConversationDao.createTable(sqlitedatabase, flag);
        ConversationMessageDao.createTable(sqlitedatabase, flag);
        UserDao.createTable(sqlitedatabase, flag);
        PartnerDao.createTable(sqlitedatabase, flag);
        BoardDao.createTable(sqlitedatabase, flag);
        CommentDao.createTable(sqlitedatabase, flag);
        InterestDao.createTable(sqlitedatabase, flag);
        PlaceDao.createTable(sqlitedatabase, flag);
        PinDao.createTable(sqlitedatabase, flag);
        BoardInviteDao.createTable(sqlitedatabase, flag);
        BusinessTypeDao.createTable(sqlitedatabase, flag);
        SearchFilterDao.createTable(sqlitedatabase, flag);
        FilterOptionDao.createTable(sqlitedatabase, flag);
        DigestItemDao.createTable(sqlitedatabase, flag);
    }

    public static void dropAllTables(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        CategoryDao.dropTable(sqlitedatabase, flag);
        StoryDao.dropTable(sqlitedatabase, flag);
        ActorDao.dropTable(sqlitedatabase, flag);
        NotificationDao.dropTable(sqlitedatabase, flag);
        NotificationTemplateDao.dropTable(sqlitedatabase, flag);
        ConversationDao.dropTable(sqlitedatabase, flag);
        ConversationMessageDao.dropTable(sqlitedatabase, flag);
        UserDao.dropTable(sqlitedatabase, flag);
        PartnerDao.dropTable(sqlitedatabase, flag);
        BoardDao.dropTable(sqlitedatabase, flag);
        CommentDao.dropTable(sqlitedatabase, flag);
        InterestDao.dropTable(sqlitedatabase, flag);
        PlaceDao.dropTable(sqlitedatabase, flag);
        PinDao.dropTable(sqlitedatabase, flag);
        BoardInviteDao.dropTable(sqlitedatabase, flag);
        BusinessTypeDao.dropTable(sqlitedatabase, flag);
        SearchFilterDao.dropTable(sqlitedatabase, flag);
        FilterOptionDao.dropTable(sqlitedatabase, flag);
        DigestItemDao.dropTable(sqlitedatabase, flag);
    }

    public DaoSession newSession()
    {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityscopetype)
    {
        return new DaoSession(db, identityscopetype, daoConfigMap);
    }

    public volatile AbstractDaoSession newSession()
    {
        return newSession();
    }

    public volatile AbstractDaoSession newSession(IdentityScopeType identityscopetype)
    {
        return newSession(identityscopetype);
    }
}
