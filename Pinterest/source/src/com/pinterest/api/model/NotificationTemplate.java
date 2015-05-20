// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.utils.PStringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.pinterest.api.model:
//            ModelHelper

public class NotificationTemplate
{

    private HashMap _subjectMap;
    private String subjectsJson;
    private String templateString;
    private String uid;

    public NotificationTemplate()
    {
    }

    public NotificationTemplate(String s)
    {
        uid = s;
    }

    public NotificationTemplate(String s, String s1, String s2)
    {
        uid = s;
        templateString = s1;
        subjectsJson = s2;
    }

    private void createSubjectMap()
    {
        _subjectMap = new HashMap();
        PinterestJsonObject pinterestjsonobject = new PinterestJsonObject(subjectsJson);
        Iterator iterator = pinterestjsonobject.c().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c(s);
            SubjectType subjecttype = SubjectType.parse(pinterestjsonobject1.a("type", ""));
            if (subjecttype != null)
            {
                NotificationSubject notificationsubject = new NotificationSubject();
                notificationsubject.setType(subjecttype);
                notificationsubject.setValue(pinterestjsonobject1.a("value", ""));
                notificationsubject.setUid(pinterestjsonobject1.a("uid", ""));
                notificationsubject.setIsArray(pinterestjsonobject1.a("isArray"));
                _subjectMap.put(s, notificationsubject);
            }
        } while (true);
    }

    public static NotificationTemplate make(PinterestJsonObject pinterestjsonobject, String s, String s1)
    {
        return make(pinterestjsonobject, s, s1, true);
    }

    public static NotificationTemplate make(PinterestJsonObject pinterestjsonobject, String s, String s1, boolean flag)
    {
        NotificationTemplate notificationtemplate = new NotificationTemplate();
        notificationtemplate.setTemplateString(s1);
        notificationtemplate.setUid(s);
        HashMap hashmap = new HashMap();
        Iterator iterator = pinterestjsonobject.c().iterator();
        while (iterator.hasNext()) 
        {
            String s3 = (String)iterator.next();
            Object obj = pinterestjsonobject.c(s3);
            HashMap hashmap1 = new HashMap();
            hashmap1.put("value", ((PinterestJsonObject) (obj)).a("string_value", ""));
            String s2 = ((PinterestJsonObject) (obj)).a("data_type", "");
            s = "";
            Boolean boolean1 = Boolean.valueOf(false);
            if (s2.equals("model"))
            {
                s = ((PinterestJsonObject) (obj)).c("data");
                s1 = s.a("type", "");
                s = s.a("id", "0");
            } else
            {
                s1 = s2;
                if (s2.equals("array"))
                {
                    boolean1 = Boolean.valueOf(true);
                    s = ((PinterestJsonObject) (obj)).e("data");
                    obj = new ArrayList();
                    int i = 0;
                    int j = s.a();
                    s1 = s2;
                    for (; i < j; i++)
                    {
                        PinterestJsonObject pinterestjsonobject1 = s.b(i);
                        s1 = pinterestjsonobject1.a("type", null);
                        ((ArrayList) (obj)).add(pinterestjsonobject1.a("id", null));
                    }

                    s = PStringUtils.concatStringArray(((java.util.List) (obj)), ",");
                }
            }
            hashmap1.put("uid", s);
            hashmap1.put("type", s1);
            hashmap1.put("isArray", boolean1.toString());
            hashmap.put(s3, hashmap1);
        }
        notificationtemplate.setSubjectsJson((new PinterestJsonObject(hashmap)).toString());
        if (flag)
        {
            ModelHelper.setNotificationTemplate(notificationtemplate);
        }
        return notificationtemplate;
    }

    public NotificationSubject getSubject(String s)
    {
        if (_subjectMap == null)
        {
            createSubjectMap();
        }
        return (NotificationSubject)_subjectMap.get(s);
    }

    public ArrayList getSubjects()
    {
        if (_subjectMap == null)
        {
            createSubjectMap();
        }
        return new ArrayList(_subjectMap.values());
    }

    public String getSubjectsJson()
    {
        return subjectsJson;
    }

    public String getTemplateString()
    {
        return templateString;
    }

    public String getUid()
    {
        return uid;
    }

    public void setSubjectsJson(String s)
    {
        subjectsJson = s;
    }

    public void setTemplateString(String s)
    {
        templateString = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    private class SubjectType extends Enum
    {

        private static final SubjectType $VALUES[];
        public static final SubjectType ARRAY;
        public static final SubjectType BOARD;
        public static final SubjectType COMMENT;
        public static final SubjectType PIN;
        public static final SubjectType USER;

        public static SubjectType parse(String s)
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

        public static SubjectType valueOf(String s)
        {
            return (SubjectType)Enum.valueOf(com/pinterest/api/model/NotificationTemplate$SubjectType, s);
        }

        public static SubjectType[] values()
        {
            return (SubjectType[])$VALUES.clone();
        }

        static 
        {
            PIN = new SubjectType("PIN", 0);
            USER = new SubjectType("USER", 1);
            BOARD = new SubjectType("BOARD", 2);
            COMMENT = new SubjectType("COMMENT", 3);
            ARRAY = new SubjectType("ARRAY", 4);
            $VALUES = (new SubjectType[] {
                PIN, USER, BOARD, COMMENT, ARRAY
            });
        }

        private SubjectType(String s, int i)
        {
            super(s, i);
        }
    }


    private class NotificationSubject
    {

        private SubjectType _dataType;
        private Boolean _isArray;
        private SubjectType _type;
        private String _uid;
        private String _value;
        final NotificationTemplate this$0;

        public Boolean getIsArray()
        {
            return _isArray;
        }

        public SubjectType getType()
        {
            return _type;
        }

        public String getUid()
        {
            return _uid;
        }

        public String getValue()
        {
            return _value;
        }

        public void setIsArray(Boolean boolean1)
        {
            _isArray = boolean1;
        }

        public void setType(SubjectType subjecttype)
        {
            _type = subjecttype;
        }

        public void setUid(String s)
        {
            _uid = s;
        }

        public void setValue(String s)
        {
            _value = s;
        }

        public NotificationSubject()
        {
            this$0 = NotificationTemplate.this;
            super();
        }
    }

}
