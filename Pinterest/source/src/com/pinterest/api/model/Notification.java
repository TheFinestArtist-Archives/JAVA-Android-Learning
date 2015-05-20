// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.pinterest.api.model:
//            Model, NotificationTemplate, User, Board, 
//            Pin, ModelHelper

public class Notification extends Model
{

    private Map sectionMap;
    private String sectionsJson;
    private String style;
    private String uid;

    public Notification()
    {
    }

    public Notification(String s)
    {
        uid = s;
    }

    public Notification(String s, String s1, String s2)
    {
        uid = s;
        style = s1;
        sectionsJson = s2;
    }

    public static NotificationArtifact make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        NotificationArtifact notificationartifact = new NotificationArtifact();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        ArrayList arraylist4 = new ArrayList();
        ArrayList arraylist5 = new ArrayList();
        ArrayList arraylist6 = new ArrayList();
        ArrayList arraylist7 = new ArrayList();
        Notification notification = new Notification();
        String s = pinterestjsonobject.a("id", "");
        notification.setUid(s);
        notification.setStyle(pinterestjsonobject.a("style", "").toUpperCase());
        notificationartifact.setNotification(notification);
        HashMap hashmap = new HashMap();
        PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("sections");
        if (pinterestjsonobject1 == null)
        {
            return null;
        }
        Iterator iterator = pinterestjsonobject1.c().iterator();
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            Object obj1 = pinterestjsonobject1.c(s1);
            Object obj2 = ((PinterestJsonObject) (obj1)).c("data");
            String s2 = ((PinterestJsonObject) (obj1)).a("type", "");
            Object obj = null;
            pinterestjsonobject = "";
            HashMap hashmap1 = new HashMap();
            if (s2.equals("template_section"))
            {
                obj = ((PinterestJsonObject) (obj1)).a("data_type", "");
                pinterestjsonobject = (new StringBuilder()).append(s).append(":").append(s1).toString();
                arraylist7.add(NotificationTemplate.make(((PinterestJsonObject) (obj2)), pinterestjsonobject, ((PinterestJsonObject) (obj1)).a("template", ""), false));
            } else
            if (s2.equals("model_section"))
            {
                obj1 = ((PinterestJsonObject) (obj2)).a("type", "");
                if (((String) (obj1)).equals("user"))
                {
                    User user = User.make(((PinterestJsonObject) (obj2)), false, false);
                    arraylist1.add(user);
                    obj2 = user.getUid();
                    arraylist2.add(obj2);
                    pinterestjsonobject = ((PinterestJsonObject) (obj2));
                    obj = obj1;
                    if (user.getPartner() != null)
                    {
                        arraylist.add(user.getPartner());
                        pinterestjsonobject = ((PinterestJsonObject) (obj2));
                        obj = obj1;
                    }
                } else
                if (((String) (obj1)).equals("board"))
                {
                    pinterestjsonobject = Board.make(((PinterestJsonObject) (obj2)), false, false).getBoard();
                    arraylist3.add(pinterestjsonobject);
                    pinterestjsonobject = pinterestjsonobject.getUid();
                    arraylist4.add(pinterestjsonobject);
                    obj = obj1;
                } else
                {
                    obj = obj1;
                    if (((String) (obj1)).equals("pin"))
                    {
                        pinterestjsonobject = Pin.make(((PinterestJsonObject) (obj2)), false, false).getPin();
                        arraylist5.add(pinterestjsonobject);
                        pinterestjsonobject = pinterestjsonobject.getUid();
                        arraylist6.add(pinterestjsonobject);
                        obj = obj1;
                    }
                }
            } else
            if (s2.equals("date_section"))
            {
                obj = ((PinterestJsonObject) (obj1)).a("data_type", "");
                pinterestjsonobject = ((PinterestJsonObject) (obj1)).a("data", "");
            }
            hashmap1.put("data_id", pinterestjsonobject);
            hashmap1.put("data_type", obj);
            hashmap1.put("type", s2);
            hashmap.put(s1, hashmap1);
        }
        notification.setSectionsJson((new PinterestJsonObject(hashmap)).toString());
        notificationartifact.setUsers(arraylist1);
        notificationartifact.setUserIds(arraylist2);
        notificationartifact.setBoards(arraylist3);
        notificationartifact.setBoardIds(arraylist4);
        notificationartifact.setPins(arraylist5);
        notificationartifact.setPinIds(arraylist6);
        notificationartifact.setNotificationTemplates(arraylist7);
        notificationartifact.setNotification(notification);
        if (flag)
        {
            ModelHelper.setPartners(arraylist);
            ModelHelper.setUsers(User.mergeAll(arraylist1, ModelHelper.getUsers(arraylist2)));
            ModelHelper.setBoards(Board.mergeAll(arraylist3, ModelHelper.getBoards(arraylist4)));
            ModelHelper.setPins(Pin.mergeAll(arraylist5, ModelHelper.getPins(arraylist6)));
            ModelHelper.setNotificationTemplates(arraylist7);
            ModelHelper.setNotification(notification);
        }
        return notificationartifact;
    }

    public static Notification make(PinterestJsonObject pinterestjsonobject)
    {
        pinterestjsonobject = make(pinterestjsonobject, true);
        if (pinterestjsonobject == null)
        {
            return null;
        } else
        {
            return pinterestjsonobject.getNotification();
        }
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (pinterestjsonarray == null)
        {
            return arraylist;
        }
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        ArrayList arraylist4 = new ArrayList();
        ArrayList arraylist5 = new ArrayList();
        ArrayList arraylist6 = new ArrayList();
        ArrayList arraylist7 = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            NotificationArtifact notificationartifact = make(pinterestjsonarray.c(i), false);
            if (notificationartifact != null)
            {
                arraylist.add(notificationartifact.getNotification());
                arraylist1.addAll(notificationartifact.getUsers());
                arraylist2.addAll(notificationartifact.getUserIds());
                arraylist3.addAll(notificationartifact.getBoards());
                arraylist4.addAll(notificationartifact.getBoardIds());
                arraylist5.addAll(notificationartifact.getPins());
                arraylist6.addAll(notificationartifact.getPinIds());
                arraylist7.addAll(notificationartifact.getNotificationTemplates());
            }
        }

        ModelHelper.setNotifications(arraylist);
        ModelHelper.setNotificationTemplates(arraylist7);
        ModelHelper.setUsers(User.mergeAll(arraylist1, ModelHelper.getUsers(arraylist2)));
        ModelHelper.setBoards(Board.mergeAll(arraylist3, ModelHelper.getBoards(arraylist4)));
        ModelHelper.setPins(Pin.mergeAll(arraylist5, ModelHelper.getPins(arraylist6)));
        return arraylist;
    }

    public Style getNotificationStyle()
    {
        return Style.parse(style);
    }

    public NotificationSection getSection(String s)
    {
        if (sectionMap == null)
        {
            sectionMap = new HashMap();
            PinterestJsonObject pinterestjsonobject = new PinterestJsonObject(getSectionsJson());
            Iterator iterator = pinterestjsonobject.c().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c(s1);
                DataType datatype = DataType.parse(pinterestjsonobject1.a("data_type", null));
                SectionType sectiontype = SectionType.parse(pinterestjsonobject1.a("type", null));
                if (datatype != null && sectiontype != null)
                {
                    NotificationSection notificationsection = new NotificationSection();
                    notificationsection.setDataType(datatype);
                    notificationsection.setDataId(pinterestjsonobject1.a("data_id", null));
                    notificationsection.setType(sectiontype);
                    sectionMap.put(s1, notificationsection);
                }
            } while (true);
        }
        return (NotificationSection)sectionMap.get(s);
    }

    public String getSectionsJson()
    {
        return sectionsJson;
    }

    public String getStyle()
    {
        return style;
    }

    public String getUid()
    {
        return uid;
    }

    public void setSectionsJson(String s)
    {
        sectionsJson = s;
    }

    public void setStyle(String s)
    {
        style = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    private class NotificationArtifact
    {

        private List _boardIds;
        private List _boards;
        private Notification _notification;
        private List _notificationTemplates;
        private List _pinIds;
        private List _pins;
        private List _userIds;
        private List _users;

        public final List getBoardIds()
        {
            return _boardIds;
        }

        public final List getBoards()
        {
            return _boards;
        }

        public final Notification getNotification()
        {
            return _notification;
        }

        public final List getNotificationTemplates()
        {
            return _notificationTemplates;
        }

        public final List getPinIds()
        {
            return _pinIds;
        }

        public final List getPins()
        {
            return _pins;
        }

        public final List getUserIds()
        {
            return _userIds;
        }

        public final List getUsers()
        {
            return _users;
        }

        public final void setBoardIds(List list)
        {
            _boardIds = list;
        }

        public final void setBoards(List list)
        {
            _boards = list;
        }

        public final void setNotification(Notification notification)
        {
            _notification = notification;
        }

        public final void setNotificationTemplates(List list)
        {
            _notificationTemplates = list;
        }

        public final void setPinIds(List list)
        {
            _pinIds = list;
        }

        public final void setPins(List list)
        {
            _pins = list;
        }

        public final void setUserIds(List list)
        {
            _userIds = list;
        }

        public final void setUsers(List list)
        {
            _users = list;
        }

        public NotificationArtifact()
        {
        }
    }


    private class Style extends Enum
    {

        private static final Style $VALUES[];
        public static final Style BAL;
        public static final Style BAL_TXT;

        public static Style parse(String s)
        {
            try
            {
                s = valueOf(s.toUpperCase());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }

        public static String requestString()
        {
            ArrayList arraylist = new ArrayList();
            Style astyle[] = values();
            int j = astyle.length;
            for (int i = 0; i < j; i++)
            {
                arraylist.add(astyle[i].toString().toLowerCase());
            }

            return PStringUtils.concatStringArray(arraylist, ",");
        }

        public static Style valueOf(String s)
        {
            return (Style)Enum.valueOf(com/pinterest/api/model/Notification$Style, s);
        }

        public static Style[] values()
        {
            return (Style[])$VALUES.clone();
        }

        static 
        {
            BAL = new Style("BAL", 0);
            BAL_TXT = new Style("BAL_TXT", 1);
            $VALUES = (new Style[] {
                BAL, BAL_TXT
            });
        }

        private Style(String s, int i)
        {
            super(s, i);
        }
    }


    private class DataType extends Enum
    {

        private static final DataType $VALUES[];
        public static final DataType BOARD;
        public static final DataType DATE;
        public static final DataType PIN;
        public static final DataType PIN_COMMENT;
        public static final DataType TEMPLATE;
        public static final DataType USER;

        public static DataType parse(String s)
        {
            try
            {
                s = valueOf(s.toUpperCase());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }

        public static DataType valueOf(String s)
        {
            return (DataType)Enum.valueOf(com/pinterest/api/model/Notification$DataType, s);
        }

        public static DataType[] values()
        {
            return (DataType[])$VALUES.clone();
        }

        static 
        {
            PIN = new DataType("PIN", 0);
            BOARD = new DataType("BOARD", 1);
            USER = new DataType("USER", 2);
            TEMPLATE = new DataType("TEMPLATE", 3);
            DATE = new DataType("DATE", 4);
            PIN_COMMENT = new DataType("PIN_COMMENT", 5);
            $VALUES = (new DataType[] {
                PIN, BOARD, USER, TEMPLATE, DATE, PIN_COMMENT
            });
        }

        private DataType(String s, int i)
        {
            super(s, i);
        }
    }


    private class SectionType extends Enum
    {

        private static final SectionType $VALUES[];
        public static final SectionType DATE_SECTION;
        public static final SectionType MODEL_SECTION;
        public static final SectionType TEMPLATE_SECTION;

        public static SectionType parse(String s)
        {
            try
            {
                s = valueOf(s.toUpperCase());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }

        public static SectionType valueOf(String s)
        {
            return (SectionType)Enum.valueOf(com/pinterest/api/model/Notification$SectionType, s);
        }

        public static SectionType[] values()
        {
            return (SectionType[])$VALUES.clone();
        }

        static 
        {
            TEMPLATE_SECTION = new SectionType("TEMPLATE_SECTION", 0);
            MODEL_SECTION = new SectionType("MODEL_SECTION", 1);
            DATE_SECTION = new SectionType("DATE_SECTION", 2);
            $VALUES = (new SectionType[] {
                TEMPLATE_SECTION, MODEL_SECTION, DATE_SECTION
            });
        }

        private SectionType(String s, int i)
        {
            super(s, i);
        }
    }


    private class NotificationSection
    {

        private String _dataId;
        private DataType _dataType;
        private SectionType _type;
        final Notification this$0;

        public final String getDataId()
        {
            return _dataId;
        }

        public final DataType getDataType()
        {
            return _dataType;
        }

        public final SectionType getType()
        {
            return _type;
        }

        public final void setDataId(String s)
        {
            _dataId = s;
        }

        public final void setDataType(DataType datatype)
        {
            _dataType = datatype;
        }

        public final void setType(SectionType sectiontype)
        {
            _type = sectiontype;
        }

        public NotificationSection()
        {
            this$0 = Notification.this;
            super();
        }
    }

}
