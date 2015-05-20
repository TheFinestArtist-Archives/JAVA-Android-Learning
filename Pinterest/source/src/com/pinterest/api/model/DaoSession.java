// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.IdentityScope;
import de.greenrobot.dao.IdentityScopeType;
import java.util.Map;

// Referenced classes of package com.pinterest.api.model:
//            CategoryDao, StoryDao, ActorDao, NotificationDao, 
//            NotificationTemplateDao, ConversationDao, ConversationMessageDao, UserDao, 
//            PartnerDao, BoardDao, CommentDao, InterestDao, 
//            PlaceDao, PinDao, BoardInviteDao, BusinessTypeDao, 
//            SearchFilterDao, FilterOptionDao, DigestItemDao, Category, 
//            Story, Actor, Notification, NotificationTemplate, 
//            Conversation, ConversationMessage, User, Partner, 
//            Board, Comment, Interest, Place, 
//            Pin, BoardInvite, BusinessType, SearchFilter, 
//            FilterOption, DigestItem

public class DaoSession extends AbstractDaoSession
{

    private final ActorDao actorDao;
    private final DaoConfig actorDaoConfig;
    private final BoardDao boardDao;
    private final DaoConfig boardDaoConfig;
    private final BoardInviteDao boardInviteDao;
    private final DaoConfig boardInviteDaoConfig;
    private final BusinessTypeDao businessTypeDao;
    private final DaoConfig businessTypeDaoConfig;
    private final CategoryDao categoryDao;
    private final DaoConfig categoryDaoConfig;
    private final CommentDao commentDao;
    private final DaoConfig commentDaoConfig;
    private final ConversationDao conversationDao;
    private final DaoConfig conversationDaoConfig;
    private final ConversationMessageDao conversationMessageDao;
    private final DaoConfig conversationMessageDaoConfig;
    private final DigestItemDao digestItemDao;
    private final DaoConfig digestItemDaoConfig;
    private final FilterOptionDao filterOptionDao;
    private final DaoConfig filterOptionDaoConfig;
    private final InterestDao interestDao;
    private final DaoConfig interestDaoConfig;
    private final NotificationDao notificationDao;
    private final DaoConfig notificationDaoConfig;
    private final NotificationTemplateDao notificationTemplateDao;
    private final DaoConfig notificationTemplateDaoConfig;
    private final PartnerDao partnerDao;
    private final DaoConfig partnerDaoConfig;
    private final PinDao pinDao;
    private final DaoConfig pinDaoConfig;
    private final PlaceDao placeDao;
    private final DaoConfig placeDaoConfig;
    private final SearchFilterDao searchFilterDao;
    private final DaoConfig searchFilterDaoConfig;
    private final StoryDao storyDao;
    private final DaoConfig storyDaoConfig;
    private final UserDao userDao;
    private final DaoConfig userDaoConfig;

    public DaoSession(SQLiteDatabase sqlitedatabase, IdentityScopeType identityscopetype, Map map)
    {
        super(sqlitedatabase);
        categoryDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/CategoryDao)).clone();
        categoryDaoConfig.initIdentityScope(identityscopetype);
        storyDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/StoryDao)).clone();
        storyDaoConfig.initIdentityScope(identityscopetype);
        actorDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/ActorDao)).clone();
        actorDaoConfig.initIdentityScope(identityscopetype);
        notificationDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/NotificationDao)).clone();
        notificationDaoConfig.initIdentityScope(identityscopetype);
        notificationTemplateDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/NotificationTemplateDao)).clone();
        notificationTemplateDaoConfig.initIdentityScope(identityscopetype);
        conversationDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/ConversationDao)).clone();
        conversationDaoConfig.initIdentityScope(identityscopetype);
        conversationMessageDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/ConversationMessageDao)).clone();
        conversationMessageDaoConfig.initIdentityScope(identityscopetype);
        userDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/UserDao)).clone();
        userDaoConfig.initIdentityScope(identityscopetype);
        partnerDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/PartnerDao)).clone();
        partnerDaoConfig.initIdentityScope(identityscopetype);
        boardDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/BoardDao)).clone();
        boardDaoConfig.initIdentityScope(identityscopetype);
        commentDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/CommentDao)).clone();
        commentDaoConfig.initIdentityScope(identityscopetype);
        interestDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/InterestDao)).clone();
        interestDaoConfig.initIdentityScope(identityscopetype);
        placeDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/PlaceDao)).clone();
        placeDaoConfig.initIdentityScope(identityscopetype);
        pinDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/PinDao)).clone();
        pinDaoConfig.initIdentityScope(identityscopetype);
        boardInviteDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/BoardInviteDao)).clone();
        boardInviteDaoConfig.initIdentityScope(identityscopetype);
        businessTypeDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/BusinessTypeDao)).clone();
        businessTypeDaoConfig.initIdentityScope(identityscopetype);
        searchFilterDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/SearchFilterDao)).clone();
        searchFilterDaoConfig.initIdentityScope(identityscopetype);
        filterOptionDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/FilterOptionDao)).clone();
        filterOptionDaoConfig.initIdentityScope(identityscopetype);
        digestItemDaoConfig = ((DaoConfig)map.get(com/pinterest/api/model/DigestItemDao)).clone();
        digestItemDaoConfig.initIdentityScope(identityscopetype);
        categoryDao = new CategoryDao(categoryDaoConfig, this);
        storyDao = new StoryDao(storyDaoConfig, this);
        actorDao = new ActorDao(actorDaoConfig, this);
        notificationDao = new NotificationDao(notificationDaoConfig, this);
        notificationTemplateDao = new NotificationTemplateDao(notificationTemplateDaoConfig, this);
        conversationDao = new ConversationDao(conversationDaoConfig, this);
        conversationMessageDao = new ConversationMessageDao(conversationMessageDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        partnerDao = new PartnerDao(partnerDaoConfig, this);
        boardDao = new BoardDao(boardDaoConfig, this);
        commentDao = new CommentDao(commentDaoConfig, this);
        interestDao = new InterestDao(interestDaoConfig, this);
        placeDao = new PlaceDao(placeDaoConfig, this);
        pinDao = new PinDao(pinDaoConfig, this);
        boardInviteDao = new BoardInviteDao(boardInviteDaoConfig, this);
        businessTypeDao = new BusinessTypeDao(businessTypeDaoConfig, this);
        searchFilterDao = new SearchFilterDao(searchFilterDaoConfig, this);
        filterOptionDao = new FilterOptionDao(filterOptionDaoConfig, this);
        digestItemDao = new DigestItemDao(digestItemDaoConfig, this);
        registerDao(com/pinterest/api/model/Category, categoryDao);
        registerDao(com/pinterest/api/model/Story, storyDao);
        registerDao(com/pinterest/api/model/Actor, actorDao);
        registerDao(com/pinterest/api/model/Notification, notificationDao);
        registerDao(com/pinterest/api/model/NotificationTemplate, notificationTemplateDao);
        registerDao(com/pinterest/api/model/Conversation, conversationDao);
        registerDao(com/pinterest/api/model/ConversationMessage, conversationMessageDao);
        registerDao(com/pinterest/api/model/User, userDao);
        registerDao(com/pinterest/api/model/Partner, partnerDao);
        registerDao(com/pinterest/api/model/Board, boardDao);
        registerDao(com/pinterest/api/model/Comment, commentDao);
        registerDao(com/pinterest/api/model/Interest, interestDao);
        registerDao(com/pinterest/api/model/Place, placeDao);
        registerDao(com/pinterest/api/model/Pin, pinDao);
        registerDao(com/pinterest/api/model/BoardInvite, boardInviteDao);
        registerDao(com/pinterest/api/model/BusinessType, businessTypeDao);
        registerDao(com/pinterest/api/model/SearchFilter, searchFilterDao);
        registerDao(com/pinterest/api/model/FilterOption, filterOptionDao);
        registerDao(com/pinterest/api/model/DigestItem, digestItemDao);
    }

    public void clear()
    {
        categoryDaoConfig.getIdentityScope().clear();
        storyDaoConfig.getIdentityScope().clear();
        actorDaoConfig.getIdentityScope().clear();
        notificationDaoConfig.getIdentityScope().clear();
        notificationTemplateDaoConfig.getIdentityScope().clear();
        conversationDaoConfig.getIdentityScope().clear();
        conversationMessageDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
        partnerDaoConfig.getIdentityScope().clear();
        boardDaoConfig.getIdentityScope().clear();
        commentDaoConfig.getIdentityScope().clear();
        interestDaoConfig.getIdentityScope().clear();
        placeDaoConfig.getIdentityScope().clear();
        pinDaoConfig.getIdentityScope().clear();
        boardInviteDaoConfig.getIdentityScope().clear();
        businessTypeDaoConfig.getIdentityScope().clear();
        searchFilterDaoConfig.getIdentityScope().clear();
        filterOptionDaoConfig.getIdentityScope().clear();
        digestItemDaoConfig.getIdentityScope().clear();
    }

    public ActorDao getActorDao()
    {
        return actorDao;
    }

    public BoardDao getBoardDao()
    {
        return boardDao;
    }

    public BoardInviteDao getBoardInviteDao()
    {
        return boardInviteDao;
    }

    public BusinessTypeDao getBusinessTypeDao()
    {
        return businessTypeDao;
    }

    public CategoryDao getCategoryDao()
    {
        return categoryDao;
    }

    public CommentDao getCommentDao()
    {
        return commentDao;
    }

    public ConversationDao getConversationDao()
    {
        return conversationDao;
    }

    public ConversationMessageDao getConversationMessageDao()
    {
        return conversationMessageDao;
    }

    public DigestItemDao getDigestItemDao()
    {
        return digestItemDao;
    }

    public FilterOptionDao getFilterOptionDao()
    {
        return filterOptionDao;
    }

    public InterestDao getInterestDao()
    {
        return interestDao;
    }

    public NotificationDao getNotificationDao()
    {
        return notificationDao;
    }

    public NotificationTemplateDao getNotificationTemplateDao()
    {
        return notificationTemplateDao;
    }

    public PartnerDao getPartnerDao()
    {
        return partnerDao;
    }

    public PinDao getPinDao()
    {
        return pinDao;
    }

    public PlaceDao getPlaceDao()
    {
        return placeDao;
    }

    public SearchFilterDao getSearchFilterDao()
    {
        return searchFilterDao;
    }

    public StoryDao getStoryDao()
    {
        return storyDao;
    }

    public UserDao getUserDao()
    {
        return userDao;
    }
}
