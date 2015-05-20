// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.api.remote.PinApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.log.PLog;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.QueryBuilder;
import de.greenrobot.dao.WhereCondition;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            DaoMaster, ModelAccessCache, BoardDao, BoardInviteDao, 
//            ConversationDao, DaoSession, PinDao, CommentDao, 
//            Board, User, BoardInvite, CategoryDao, 
//            Category, Comment, Conversation, ConversationMessageDao, 
//            DigestItemDao, DigestItem, FilterOptionDao, FilterOption, 
//            InterestDao, Interest, ConversationMessage, NotificationTemplateDao, 
//            NotificationTemplate, NotificationDao, Notification, PartnerDao, 
//            Partner, Pin, PlaceDao, Place, 
//            MyUser, SearchFilterDao, SearchFilter, StoryDao, 
//            Story, UserDao, Feed, Model

public class ModelHelper
{

    private static final String DB_NAME = "pinterest-db";
    private static final String GET_RECENT_CONVERSATIONS_QUERY;
    private static final int MAX_CHUNK = 800;
    public static final int MAX_DB_SIZE = 0x500000;
    private static final int MILLISECONDS_IN_SECOND = 1000;
    public static boolean SHOULD_CLEAR_SESSION;
    private static final SimpleDateFormat _dateFormatter;
    private static ModelHelper _instance;
    private static final Object _lock = new Object();
    private static List _pinPickItems = new ArrayList();
    private DaoSession _daoSession;

    public ModelHelper()
    {
        throw new Exception("init(context) only!");
    }

    private ModelHelper(Context context)
    {
        try
        {
            _daoSession = (new DaoMaster((new DaoMaster.DevOpenHelper(context, getDbName(false), null)).getWritableDatabase())).newSession();
            return;
        }
        catch (Exception exception)
        {
            _daoSession = (new DaoMaster((new DaoMaster.DevOpenHelper(context, getDbName(true), null)).getWritableDatabase())).newSession();
        }
    }

    public static User blockUser(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        User user = getUser(s);
        if (user != null)
        {
            UserApi.i(s, baseapiresponsehandler, s1);
        }
        return user;
    }

    public static void deleteBoard(String s)
    {
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        Board board;
        board = getBoard(s);
        ModelAccessCache.removeBoard(s);
        if (board == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        getBoardDao().delete(board);
        Events.postSticky(new Board.UpdateEvent(board, true));
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void deleteBoard(final String boardUid, final BaseApiResponseHandler handler, String s)
    {
        BoardApi.j(boardUid, new _cls3(), s);
    }

    public static void deleteBoardInvite(String s)
    {
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        s = getBoardInviteAcceptable(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        getBoardInviteDao().delete(s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void deleteConversation(Conversation conversation)
    {
        synchronized (_lock)
        {
            getConversationDao().delete(conversation);
            getInstance()._daoSession.clear();
        }
        return;
        conversation;
        obj;
        JVM INSTR monitorexit ;
        throw conversation;
    }

    public static void deletePin(String s)
    {
        if (s == null)
        {
            return;
        }
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        Pin pin;
        pin = getPin(s);
        ModelAccessCache.removePin(s);
        if (pin == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        getPinDao().delete(pin);
        Events.postSticky(new Pin.UpdateEvent(pin, true));
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void deletePin(final String pinUid, final BaseApiResponseHandler handler, String s)
    {
        PinApi.g(pinUid, new _cls2(), s);
    }

    public static void deletePinComment(String s)
    {
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        s = getComment(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        getCommentDao().delete(s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void deletePinComments(Long long1)
    {
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        long1 = getCommentDao().queryBuilder().where(CommentDao.Properties.PinUid.eq(long1), new WhereCondition[0]).list();
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (long1.size() > 0)
        {
            getCommentDao().deleteInTx(long1);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        long1;
        obj;
        JVM INSTR monitorexit ;
        throw long1;
    }

    public static Board followBoard(String s, boolean flag, com.pinterest.api.remote.BoardApi.BoardFollowApiResponse boardfollowapiresponse, String s1)
    {
        Board board = getBoard(s);
        if (board != null)
        {
            board.setFollowing(Boolean.valueOf(flag));
            BoardApi.a(s, flag, boardfollowapiresponse, s1);
            setBoard(board);
        }
        return board;
    }

    public static User followUser(String s, boolean flag, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        User user = getUser(s);
        if (user != null)
        {
            user.setFollowing(flag);
            UserApi.a(s, flag, baseapiresponsehandler, s1);
            setUser(user);
        }
        return user;
    }

    private String generateNewDBName()
    {
        return (new StringBuilder("pinterest-db")).append(System.currentTimeMillis()).toString();
    }

    public static Board getBoard(String s)
    {
        if (s != null)
        {
            Board board = ModelAccessCache.getBoard(s);
            if (board != null)
            {
                return board;
            }
            s = getBoardDao().queryBuilder().where(BoardDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
            if (s != null && s.size() > 0)
            {
                s = (Board)s.get(0);
                ModelAccessCache.put(s);
                return s;
            }
        }
        return null;
    }

    protected static BoardDao getBoardDao()
    {
        return getInstance()._daoSession.getBoardDao();
    }

    public static BoardInvite getBoardInviteAcceptable(String s)
    {
        s = getBoardInviteDao().queryBuilder().where(BoardInviteDao.Properties.IsAcceptable.eq(Boolean.valueOf(true)), new WhereCondition[] {
            BoardInviteDao.Properties.BoardUid.eq(s)
        }).list();
        if (s != null && s.size() > 0)
        {
            return (BoardInvite)s.get(0);
        } else
        {
            return null;
        }
    }

    protected static BoardInviteDao getBoardInviteDao()
    {
        return getInstance()._daoSession.getBoardInviteDao();
    }

    public static List getBoardInvites(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getBoardInviteDao().queryBuilder().where(BoardInviteDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            BoardInvite boardinvite = new BoardInvite();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                boardinvite.setUid((String)list.next());
                int j = arraylist.indexOf(boardinvite);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static List getBoardInvitesAcceptable()
    {
        return getBoardInviteDao().queryBuilder().where(BoardInviteDao.Properties.IsAcceptable.eq(Boolean.valueOf(true)), new WhereCondition[0]).list();
    }

    public static List getBoards(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getBoardDao().queryBuilder().where(BoardDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            Board board = new Board();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                board.setUid((String)list.next());
                int j = arraylist.indexOf(board);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static List getBrowsableCategories(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        List list1 = getCategoryDao().queryBuilder().where(CategoryDao.Properties.Browsable.eq(Boolean.valueOf(true)), new WhereCondition[] {
            CategoryDao.Properties.Key.in(list)
        }).list();
        if (list1.size() > 0)
        {
            ArrayList arraylist = new ArrayList();
            Category category = new Category();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                category.setKey((String)list.next());
                int i = list1.indexOf(category);
                if (i != -1)
                {
                    arraylist.add(list1.get(i));
                }
            } while (true);
            return arraylist;
        } else
        {
            return new ArrayList();
        }
    }

    public static List getCategories()
    {
        List list = getCategoryDao().queryBuilder().list();
        if (list != null && list.size() > 0)
        {
            return list;
        } else
        {
            return new ArrayList();
        }
    }

    public static List getCategories(List list)
    {
        List list1 = getCategoryDao().queryBuilder().where(CategoryDao.Properties.Key.in(list), new WhereCondition[0]).list();
        if (list1 != null && list1.size() > 0)
        {
            Category category = new Category();
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                category.setKey((String)list.next());
                int i = list1.indexOf(category);
                if (i != -1)
                {
                    arraylist.add(list1.get(i));
                }
            } while (true);
            return arraylist;
        } else
        {
            return new ArrayList();
        }
    }

    public static Category getCategory(String s)
    {
        if (s != null)
        {
            Category category = ModelAccessCache.getCategory(s);
            if (category != null)
            {
                return category;
            }
            s = getCategoryDao().queryBuilder().where(CategoryDao.Properties.Key.eq(s), new WhereCondition[0]).list();
            if (s != null && s.size() > 0)
            {
                s = (Category)s.get(0);
                ModelAccessCache.put(s);
                return s;
            }
        }
        return null;
    }

    protected static CategoryDao getCategoryDao()
    {
        return getInstance()._daoSession.getCategoryDao();
    }

    public static Comment getComment(String s)
    {
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        s = getCommentDao().queryBuilder().where(CommentDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (s.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        s = (Comment)s.get(0);
        return s;
        obj;
        JVM INSTR monitorexit ;
        return null;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected static CommentDao getCommentDao()
    {
        return getInstance()._daoSession.getCommentDao();
    }

    public static List getComments(List list)
    {
        Object obj = _lock;
        obj;
        JVM INSTR monitorenter ;
        List list1 = getCommentDao().queryBuilder().where(CommentDao.Properties.Uid.in(list), new WhereCondition[0]).list();
        if (list1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        ArrayList arraylist;
        Comment comment;
        if (list1.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        arraylist = new ArrayList();
        comment = new Comment();
        list = list.iterator();
_L2:
        int i;
        do
        {
            if (!list.hasNext())
            {
                break MISSING_BLOCK_LABEL_127;
            }
            comment.setUid((String)list.next());
            i = list1.indexOf(comment);
        } while (i == -1);
        arraylist.add(list1.get(i));
        if (true) goto _L2; else goto _L1
_L1:
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
        obj;
        JVM INSTR monitorexit ;
        return arraylist;
        obj;
        JVM INSTR monitorexit ;
        return new ArrayList();
    }

    public static Conversation getConversation(String s)
    {
        s = getConversationDao().queryBuilder().where(ConversationDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
        if (!s.isEmpty())
        {
            return (Conversation)s.get(0);
        } else
        {
            return null;
        }
    }

    protected static ConversationDao getConversationDao()
    {
        return getInstance()._daoSession.getConversationDao();
    }

    protected static ConversationMessageDao getConversationMessageDao()
    {
        return getInstance()._daoSession.getConversationMessageDao();
    }

    public static List getConversationMessages(String s, int i)
    {
        return getConversationMessageDao().queryBuilder().where(ConversationMessageDao.Properties.ConversationId.eq(s), new WhereCondition[0]).orderDesc(new Property[] {
            ConversationMessageDao.Properties.CreatedAt
        }).limit(i).list();
    }

    private String getDbName(boolean flag)
    {
        String s = Preferences.user().getString("DB_NAME", null);
        if (StringUtils.isNotBlank(s))
        {
            final File dbFile = Application.context().getDatabasePath(s);
            if (dbFile != null && dbFile.exists())
            {
                if (!flag && dbFile.length() <= 0x500000L)
                {
                    SHOULD_CLEAR_SESSION = false;
                    return s;
                }
                SHOULD_CLEAR_SESSION = true;
                (new _cls4()).execute();
            }
        }
        s = generateNewDBName();
        Preferences.user().set("DB_NAME", s);
        return s;
    }

    protected static DigestItemDao getDigestItemDao()
    {
        return getInstance()._daoSession.getDigestItemDao();
    }

    public static List getDigestItems(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getDigestItemDao().queryBuilder().where(DigestItemDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            DigestItem digestitem = new DigestItem();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                digestitem.setUid((String)list.next());
                int j = arraylist.indexOf(digestitem);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static FilterOption getFilterOption(String s)
    {
        if (s != null)
        {
            if ((s = getFilterOptionDao().queryBuilder().where(FilterOptionDao.Properties.TypeValue.eq(s), new WhereCondition[0]).list()) != null && s.size() > 0)
            {
                return (FilterOption)s.get(0);
            }
        }
        return null;
    }

    protected static FilterOptionDao getFilterOptionDao()
    {
        return getInstance()._daoSession.getFilterOptionDao();
    }

    public static ModelHelper getInstance()
    {
        if (_instance == null)
        {
            _instance = new ModelHelper(Application.context());
        }
        return _instance;
    }

    public static Interest getInterest(String s)
    {
        if (s != null)
        {
            Interest interest = ModelAccessCache.getInterest(s);
            if (interest != null)
            {
                return interest;
            }
            s = getInterestDao().queryBuilder().where(InterestDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
            if (s != null && s.size() > 0)
            {
                s = (Interest)s.get(0);
                ModelAccessCache.put(s);
                return s;
            }
        }
        return null;
    }

    protected static InterestDao getInterestDao()
    {
        return getInstance()._daoSession.getInterestDao();
    }

    public static List getInterests(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getInterestDao().queryBuilder().where(InterestDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            Interest interest = new Interest();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                interest.setUid((String)list.next());
                int j = arraylist.indexOf(interest);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static ConversationMessage getLastConversationMessage(String s)
    {
        s = getConversationMessages(s, 1);
        if (s != null && !s.isEmpty())
        {
            return (ConversationMessage)s.get(0);
        } else
        {
            return null;
        }
    }

    protected static NotificationDao getNotificationDao()
    {
        return getInstance()._daoSession.getNotificationDao();
    }

    public static NotificationTemplate getNotificationTemplate(String s)
    {
        s = getNotificationTemplateDao().queryBuilder().where(NotificationTemplateDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
        if (s.size() > 0)
        {
            return (NotificationTemplate)s.get(0);
        } else
        {
            return null;
        }
    }

    protected static NotificationTemplateDao getNotificationTemplateDao()
    {
        return getInstance()._daoSession.getNotificationTemplateDao();
    }

    public static List getNotifications(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getNotificationDao().queryBuilder().where(NotificationDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            Notification notification = new Notification();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                notification.setUid((String)list.next());
                int j = arraylist.indexOf(notification);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static Partner getPartner(String s)
    {
        if (s != null)
        {
            if ((s = getPartnerDao().queryBuilder().where(PartnerDao.Properties.Uid.eq(s), new WhereCondition[0]).list()) != null && s.size() > 0)
            {
                return (Partner)s.get(0);
            }
        }
        return null;
    }

    protected static PartnerDao getPartnerDao()
    {
        return getInstance()._daoSession.getPartnerDao();
    }

    public static Pin getPin(String s)
    {
        if (s != null)
        {
            Pin pin = ModelAccessCache.getPin(s);
            if (pin != null)
            {
                return pin;
            }
            s = getPinDao().queryBuilder().where(PinDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
            if (s != null && s.size() > 0)
            {
                s = (Pin)s.get(0);
                ModelAccessCache.put(s);
                return s;
            }
        }
        return null;
    }

    public static List getPinComments(Long long1)
    {
        long1 = getCommentDao().queryBuilder().where(CommentDao.Properties.PinUid.eq(long1), new WhereCondition[0]).list();
        if (long1 != null && long1.size() > 0)
        {
            return long1;
        } else
        {
            return new ArrayList();
        }
    }

    protected static PinDao getPinDao()
    {
        return getInstance()._daoSession.getPinDao();
    }

    public static Pin getPinFromPlace(String s)
    {
        if (s != null)
        {
            s = getPinDao().queryBuilder().where(PinDao.Properties.PlaceUid.eq(s), new WhereCondition[0]).list();
            if (s != null && s.size() > 0)
            {
                s = (Pin)s.get(0);
                ModelAccessCache.put(s);
                return s;
            }
        }
        return null;
    }

    public static List getPinPicksItems()
    {
        return _pinPickItems;
    }

    public static List getPins(List list)
    {
        return getPins(list, false);
    }

    public static List getPins(List list, boolean flag)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        int i = 0;
        while (i < k) 
        {
            int l = i * 800;
            int i1 = Math.min((i + 1) * 800, list.size());
            if (flag)
            {
                arraylist.addAll(getPinDao().queryBuilder().where(PinDao.Properties.Uid.in(list.subList(l, i1)), new WhereCondition[] {
                    PinDao.Properties.Liked.eq(Boolean.valueOf(true))
                }).list());
            } else
            {
                arraylist.addAll(getPinDao().queryBuilder().where(PinDao.Properties.Uid.in(list.subList(l, i1)), new WhereCondition[0]).list());
            }
            i++;
        }
        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            Pin pin = new Pin();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                pin.setUid((String)list.next());
                int j = arraylist.indexOf(pin);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static Place getPlace(String s)
    {
        if (s != null)
        {
            if ((s = getPlaceDao().queryBuilder().where(PlaceDao.Properties.Uid.eq(s), new WhereCondition[0]).list()) != null && s.size() > 0)
            {
                return (Place)s.get(0);
            }
        }
        return null;
    }

    protected static PlaceDao getPlaceDao()
    {
        return getInstance()._daoSession.getPlaceDao();
    }

    public static List getRecentConversationUsers()
    {
        Object obj = getRecentConversations();
        ArrayList arraylist = new ArrayList();
        HashSet hashset = new HashSet();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Object obj1 = ((Conversation)((Iterator) (obj)).next()).getCachedUsers();
            if (obj1 != null)
            {
                obj1 = ((List) (obj1)).iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    User user = (User)((Iterator) (obj1)).next();
                    if (!MyUser.isUserMe(user) && !user.getUid().equals("424605208526455283") && hashset.add(user.getUid()))
                    {
                        TypeAheadItem typeaheaditem = new TypeAheadItem();
                        typeaheaditem.setUid(user.getUid());
                        typeaheaditem.setItemType(com.pinterest.activity.search.model.TypeAheadItem.ItemType.PINNER);
                        typeaheaditem.setTitle(user.getFullName());
                        typeaheaditem.setImageUri(user.getImageMediumUrl());
                        typeaheaditem.setIdentifier(user.getUsername());
                        arraylist.add(typeaheaditem);
                    }
                }
            }
        }

        return arraylist;
    }

    public static List getRecentConversations()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = getInstance()._daoSession.getDatabase().rawQuery(GET_RECENT_CONVERSATIONS_QUERY, null);
        if (cursor != null && cursor.moveToFirst())
        {
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                String s = cursor.getString(0);
                String s1 = cursor.getString(1);
                int i = cursor.getInt(2);
                String s2 = cursor.getString(3);
                Conversation conversation = new Conversation();
                conversation.setUid(s);
                conversation.setUsers(s1);
                conversation.setUnread(Integer.valueOf(i));
                conversation.setEmails(s2);
                arraylist.add(conversation);
            }

            cursor.close();
        }
        return arraylist;
    }

    public static SearchFilter getSearchFilter(String s)
    {
        if (s != null)
        {
            if ((s = getSearchFilterDao().queryBuilder().where(FilterOptionDao.Properties.TypeValue.eq(s), new WhereCondition[0]).list()) != null && s.size() > 0)
            {
                return (SearchFilter)s.get(0);
            }
        }
        return null;
    }

    protected static SearchFilterDao getSearchFilterDao()
    {
        return getInstance()._daoSession.getSearchFilterDao();
    }

    public static List getServerCategories()
    {
        List list = getCategoryDao().queryBuilder().where(CategoryDao.Properties.Hash.isNotNull(), new WhereCondition[0]).orderAsc(new Property[] {
            CategoryDao.Properties.Name
        }).list();
        if (list != null && list.size() > 0)
        {
            return list;
        } else
        {
            return new ArrayList();
        }
    }

    public static List getStories(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getStoryDao().queryBuilder().where(StoryDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            Story story = new Story();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                story.setUid((String)list.next());
                int j = arraylist.indexOf(story);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static Story getStory(String s)
    {
        if (s != null)
        {
            if ((s = getStoryDao().queryBuilder().where(StoryDao.Properties.Uid.eq(s), new WhereCondition[0]).list()) != null && s.size() > 0)
            {
                return (Story)s.get(0);
            }
        }
        return null;
    }

    protected static StoryDao getStoryDao()
    {
        return getInstance()._daoSession.getStoryDao();
    }

    public static User getUser(String s)
    {
        if (s != null)
        {
            User user = ModelAccessCache.getUser(s);
            if (user != null)
            {
                return user;
            }
            s = getUserDao().queryBuilder().where(UserDao.Properties.Uid.eq(s), new WhereCondition[0]).list();
            if (s != null && s.size() > 0)
            {
                s = (User)s.get(0);
                ModelAccessCache.put(s);
                return s;
            }
        }
        return null;
    }

    protected static UserDao getUserDao()
    {
        return getInstance()._daoSession.getUserDao();
    }

    public static List getUsers(List list)
    {
        if (list == null || list.size() == 0)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        int k = (int)Math.ceil((float)list.size() / 800F);
        for (int i = 0; i < k; i++)
        {
            int l = Math.min((i + 1) * 800, list.size());
            arraylist.addAll(getUserDao().queryBuilder().where(UserDao.Properties.Uid.in(list.subList(i * 800, l)), new WhereCondition[0]).list());
        }

        if (arraylist.size() > 0)
        {
            ArrayList arraylist1 = new ArrayList();
            User user = new User();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                user.setUid((String)list.next());
                int j = arraylist.indexOf(user);
                if (j != -1)
                {
                    arraylist1.add(arraylist.get(j));
                }
            } while (true);
            return arraylist1;
        } else
        {
            return new ArrayList();
        }
    }

    public static boolean isSameDay(long l, long l1)
    {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar.setTimeInMillis(l * 1000L);
        calendar1.setTimeInMillis(l1 * 1000L);
        return isSameDay(calendar, calendar1);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar1)
    {
        return calendar.get(6) == calendar1.get(6) && calendar.get(1) == calendar1.get(1);
    }

    public static boolean isValid(Object obj)
    {
        do
        {
            if (obj == null)
            {
                return false;
            }
            if ((obj instanceof String) && (((String)obj).trim().length() == 0 || ((String)obj).equalsIgnoreCase("null")))
            {
                return false;
            }
            if ((obj instanceof CharSequence) && TextUtils.getTrimmedLength((CharSequence)obj) == 0)
            {
                return false;
            }
            if ((obj instanceof Long) && ((Long)obj).longValue() == 0L)
            {
                return false;
            }
            if (obj instanceof List)
            {
                return ((List)obj).size() > 0;
            }
            if (obj instanceof Feed)
            {
                return ((Feed)obj).getCount() > 0;
            }
            if (obj instanceof Model)
            {
                obj = ((Model)obj).getUid();
            } else
            {
                return true;
            }
        } while (true);
    }

    public static boolean isValidString(String s)
    {
        return StringUtils.isNotBlank(s) && !s.equalsIgnoreCase("null");
    }

    public static void removeAllData()
    {
        synchronized (_lock)
        {
            _instance = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void repinPin(final Pin pin, final com.pinterest.api.remote.PinApi.PinDetailParams params, ApiResponseHandler apiresponsehandler, String s)
    {
        if (pin != null)
        {
            pin.setRepinned(Boolean.valueOf(true));
            (new _cls1()).execute();
            PinApi.a(params, apiresponsehandler, s);
        }
    }

    public static void setBoard(Board board)
    {
        if (board == null)
        {
            return;
        }
        synchronized (_lock)
        {
            ModelAccessCache.put(board);
            getBoardDao().insertOrReplace(board);
            Events.post(new Board.UpdateEvent(board));
        }
        return;
        board;
        obj;
        JVM INSTR monitorexit ;
        throw board;
    }

    public static void setBoardInvites(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getBoardInviteDao().deleteAll();
            getBoardInviteDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setBoards(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getBoardDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setCategories(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getCategoryDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setCategory(Category category)
    {
        if (category == null)
        {
            return;
        }
        synchronized (_lock)
        {
            ModelAccessCache.put(category);
            getCategoryDao().insertOrReplace(category);
        }
        return;
        category;
        obj;
        JVM INSTR monitorexit ;
        throw category;
    }

    public static void setComment(Comment comment)
    {
        if (comment == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getCommentDao().insertOrReplace(comment);
        }
        return;
        comment;
        obj;
        JVM INSTR monitorexit ;
        throw comment;
    }

    public static void setComments(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getCommentDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setConversation(Conversation conversation)
    {
        synchronized (_lock)
        {
            getConversationDao().insertOrReplaceInTx(new Conversation[] {
                conversation
            });
        }
        return;
        conversation;
        obj;
        JVM INSTR monitorexit ;
        throw conversation;
    }

    public static void setConversationMessage(ConversationMessage conversationmessage)
    {
        if (conversationmessage != null)
        {
            synchronized (_lock)
            {
                getConversationMessageDao().insertOrReplaceInTx(new ConversationMessage[] {
                    conversationmessage
                });
            }
            return;
        } else
        {
            return;
        }
        conversationmessage;
        obj;
        JVM INSTR monitorexit ;
        throw conversationmessage;
    }

    public static void setConversationMessages(List list)
    {
        if (list != null)
        {
            synchronized (_lock)
            {
                getConversationMessageDao().insertOrReplaceInTx(list);
            }
            return;
        } else
        {
            return;
        }
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setConversations(List list)
    {
        synchronized (_lock)
        {
            getConversationDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setDigestItems(List list)
    {
        if (list != null)
        {
            synchronized (_lock)
            {
                getDigestItemDao().insertOrReplaceInTx(list);
            }
            return;
        } else
        {
            return;
        }
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setFilterOption(FilterOption filteroption)
    {
        if (filteroption == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getFilterOptionDao().insertOrReplace(filteroption);
        }
        return;
        filteroption;
        obj;
        JVM INSTR monitorexit ;
        throw filteroption;
    }

    public static void setFilterOptions(List list)
    {
        synchronized (_lock)
        {
            getFilterOptionDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setInterest(Interest interest)
    {
        if (interest == null)
        {
            return;
        }
        synchronized (_lock)
        {
            ModelAccessCache.put(interest);
            getInterestDao().insertOrReplace(interest);
        }
        return;
        interest;
        obj;
        JVM INSTR monitorexit ;
        throw interest;
    }

    public static void setInterests(List list)
    {
        synchronized (_lock)
        {
            getInterestDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setNotification(Notification notification)
    {
        if (notification == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getNotificationDao().insertOrReplace(notification);
        }
        return;
        notification;
        obj;
        JVM INSTR monitorexit ;
        throw notification;
    }

    public static void setNotificationTemplate(NotificationTemplate notificationtemplate)
    {
        if (notificationtemplate == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getNotificationTemplateDao().insertOrReplace(notificationtemplate);
        }
        return;
        notificationtemplate;
        obj;
        JVM INSTR monitorexit ;
        throw notificationtemplate;
    }

    public static void setNotificationTemplates(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getNotificationTemplateDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setNotifications(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getNotificationDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setPartner(Partner partner)
    {
        if (partner == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getPartnerDao().insertOrReplace(partner);
        }
        return;
        partner;
        obj;
        JVM INSTR monitorexit ;
        throw partner;
    }

    public static void setPartners(List list)
    {
        if (list == null || list.size() == 0)
        {
            return;
        }
        synchronized (_lock)
        {
            getPartnerDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setPin(Pin pin)
    {
        if (pin == null)
        {
            return;
        }
        synchronized (_lock)
        {
            ModelAccessCache.put(pin);
            getPinDao().insertOrReplace(pin);
            Events.post(new Pin.UpdateEvent(pin));
        }
        return;
        pin;
        obj;
        JVM INSTR monitorexit ;
        throw pin;
    }

    public static void setPinPicksItems(List list)
    {
        _pinPickItems = list;
    }

    public static void setPins(List list)
    {
        synchronized (_lock)
        {
            getPinDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setPlace(Place place)
    {
        if (place == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getPlaceDao().insertOrReplace(place);
        }
        return;
        place;
        obj;
        JVM INSTR monitorexit ;
        throw place;
    }

    public static void setPlaces(List list)
    {
        synchronized (_lock)
        {
            getPlaceDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setSearchFilter(SearchFilter searchfilter)
    {
        if (searchfilter == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getSearchFilterDao().insertOrReplace(searchfilter);
        }
        return;
        searchfilter;
        obj;
        JVM INSTR monitorexit ;
        throw searchfilter;
    }

    public static void setSearchFilters(List list)
    {
        synchronized (_lock)
        {
            getSearchFilterDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setStories(List list)
    {
        if (list == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getStoryDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setStory(Story story)
    {
        if (story == null)
        {
            return;
        }
        synchronized (_lock)
        {
            getStoryDao().insertOrReplace(story);
        }
        return;
        story;
        obj;
        JVM INSTR monitorexit ;
        throw story;
    }

    public static void setUser(User user)
    {
        if (user == null)
        {
            return;
        }
        synchronized (_lock)
        {
            ModelAccessCache.put(user);
            getUserDao().insertOrReplace(user);
            Events.post(new User.UpdateEvent(user));
        }
        return;
        user;
        obj;
        JVM INSTR monitorexit ;
        throw user;
    }

    public static void setUsers(List list)
    {
        synchronized (_lock)
        {
            getUserDao().insertOrReplaceInTx(list);
        }
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static Date stringToDate(String s)
    {
        Date date = new Date();
        if (!isValid(s))
        {
            return date;
        }
        try
        {
            s = _dateFormatter.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            PLog.a((new StringBuilder("Exception: ")).append(s).toString(), new Object[0]);
            return date;
        }
        return s;
    }

    public static User unblockUser(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        User user = getUser(s);
        if (user != null)
        {
            UserApi.j(s, baseapiresponsehandler, s1);
        }
        return user;
    }

    public static void updateBoard(Board board, String s, String s1, String s2, Boolean boolean1, Boolean boolean2, BaseApiResponseHandler baseapiresponsehandler, String s3)
    {
        setBoard(board);
        BoardApi.a(board.getUid(), s, s1, s2, boolean1, board.getLayout(), boolean2, baseapiresponsehandler, s3);
    }

    public static Comment updateComment(Comment comment)
    {
        Comment comment1 = Comment.merge(comment);
        synchronized (_lock)
        {
            getCommentDao().insertOrReplace(comment1);
        }
        return comment1;
        exception;
        comment;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Pin updatePin(Pin pin)
    {
        Pin pin1 = Pin.merge(pin);
        synchronized (_lock)
        {
            getPinDao().insertOrReplace(pin1);
        }
        return pin1;
        exception;
        pin;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static User updateUser(User user)
    {
        User user1 = User.merge(user);
        setUser(user);
        return user1;
    }

    static 
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        _dateFormatter = simpledateformat;
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        GET_RECENT_CONVERSATIONS_QUERY = String.format("SELECT %s, %s, %s, %s, %s FROM %s INNER JOIN %s ON %s=%s GROUP BY %s ORDER BY %s DESC LIMIT 25", new Object[] {
            ConversationMessageDao.Properties.ConversationId.columnName, ConversationDao.Properties.Users.columnName, ConversationDao.Properties.Unread.columnName, ConversationDao.Properties.Emails.columnName, (new StringBuilder("MAX(")).append(ConversationMessageDao.Properties.CreatedAt.columnName).append(")").toString(), "CONVERSATION_MESSAGE", "CONVERSATION", ConversationMessageDao.Properties.ConversationId.columnName, (new StringBuilder("CONVERSATION.")).append(ConversationDao.Properties.Uid.columnName).toString(), ConversationMessageDao.Properties.ConversationId.columnName, 
            (new StringBuilder("MAX(")).append(ConversationMessageDao.Properties.CreatedAt.columnName).append(")").toString()
        });
    }

    private class _cls3 extends BaseApiResponseHandler
    {

        final String val$boardUid;
        final BaseApiResponseHandler val$handler;

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            if (handler != null)
            {
                handler.onFailure(throwable, apiresponse);
            }
        }

        public final void onFinish()
        {
            super.onFinish();
            if (handler != null)
            {
                handler.onFinish();
            }
        }

        public final void onStart()
        {
            super.onStart();
            if (handler != null)
            {
                handler.onStart();
            }
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            CreateBoardHelper.removeBoardFromCache(boardUid);
            ModelHelper.deleteBoard(boardUid);
            if (handler != null)
            {
                handler.onSuccess(apiresponse);
            }
        }

        _cls3()
        {
            handler = baseapiresponsehandler;
            boardUid = s;
            super();
        }
    }


    private class _cls2 extends BaseApiResponseHandler
    {

        final BaseApiResponseHandler val$handler;
        final String val$pinUid;

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            handler.onFailure(throwable, apiresponse);
        }

        public final void onFinish()
        {
            handler.onFinish();
        }

        public final void onStart()
        {
            handler.onStart();
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            ModelHelper.deletePin(pinUid);
            handler.onSuccess(apiresponse);
        }

        _cls2()
        {
            pinUid = s;
            handler = baseapiresponsehandler;
            super();
        }
    }


    private class _cls4 extends BackgroundTask
    {

        final ModelHelper this$0;
        final File val$dbFile;

        public void run()
        {
            dbFile.delete();
        }

        _cls4()
        {
            this$0 = ModelHelper.this;
            dbFile = file;
            super();
        }
    }


    private class _cls1 extends BackgroundTask
    {

        final com.pinterest.api.remote.PinApi.PinDetailParams val$params;
        final Pin val$pin;

        public final void run()
        {
            MyUser.addLastUsedBoard(params.b);
            Board board = pin.getBoard();
            if (board != null && !Constants.isTrue(board.getSecret()))
            {
                pin.setRepinCount(Integer.valueOf(pin.getRepinCountDisplay() + 1));
            }
            ModelHelper.setPin(pin);
        }

        _cls1()
        {
            params = pindetailparams;
            pin = pin1;
            super();
        }
    }

}
