// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.utils.PStringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, User, ModelHelper, ConversationMessage, 
//            MyUser

public class Conversation extends Model
{

    private List _emailList;
    private List _users;
    private String emails;
    private String uid;
    private Integer unread;
    private String users;

    public Conversation()
    {
    }

    public Conversation(String s)
    {
        uid = s;
    }

    public Conversation(String s, String s1, String s2, Integer integer)
    {
        uid = s;
        users = s1;
        emails = s2;
        unread = integer;
    }

    public static Conversation make(PinterestJsonObject pinterestjsonobject)
    {
        return make(pinterestjsonobject, true);
    }

    public static Conversation make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        boolean flag1 = false;
        if (pinterestjsonobject == null) goto _L2; else goto _L1
_L1:
        Conversation conversation;
        Object obj;
        conversation = new Conversation();
        conversation.setUid(pinterestjsonobject.a("id", ""));
        conversation.setUnread(Integer.valueOf(pinterestjsonobject.a("unread", 0)));
        obj = pinterestjsonobject.e("emails");
        if (((PinterestJsonArray) (obj)).a() <= 0) goto _L4; else goto _L3
_L3:
        ArrayList arraylist = new ArrayList();
        int i = 0;
_L11:
        if (i >= ((PinterestJsonArray) (obj)).a()) goto _L6; else goto _L5
_L5:
        Object obj1 = ((PinterestJsonArray) (obj)).a(i);
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        arraylist.add(obj1);
          goto _L8
_L6:
        conversation.setEmails(PStringUtils.concatStringArray(arraylist, ","));
        conversation.cacheEmailList(arraylist);
_L4:
        pinterestjsonobject = pinterestjsonobject.e("users");
        obj = new ArrayList();
        arraylist = new ArrayList();
        obj1 = new ArrayList();
        i = ((flag1) ? 1 : 0);
_L12:
        if (i >= pinterestjsonobject.a()) goto _L10; else goto _L9
_L9:
        User user = User.make(pinterestjsonobject.c(i), false);
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        try
        {
            ((List) (obj1)).add(user.getUid());
            ((List) (obj)).add(user);
            if (user.getPartner() != null)
            {
                arraylist.add(user.getPartner());
            }
            break MISSING_BLOCK_LABEL_275;
        }
        // Misplaced declaration of an exception variable
        catch (PinterestJsonObject pinterestjsonobject) { }
          goto _L2
_L10:
        conversation.setUsers(PStringUtils.concatStringArray(((List) (obj1)), ","));
        conversation.cacheUsers(((List) (obj)));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        ModelHelper.setPartners(arraylist);
        ModelHelper.setUsers(((List) (obj)));
        ModelHelper.setConversation(conversation);
        return conversation;
_L2:
        return null;
_L8:
        i++;
          goto _L11
        i++;
          goto _L12
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList(pinterestjsonarray.a());
        HashMap hashmap = new HashMap();
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < pinterestjsonarray.a(); i++)
        {
            PinterestJsonObject pinterestjsonobject = pinterestjsonarray.b(i);
            if (pinterestjsonobject == null)
            {
                continue;
            }
            Conversation conversation = make(pinterestjsonobject, false);
            if (conversation != null)
            {
                arraylist.add(conversation);
                arraylist1.addAll(conversation.getCachedUsers());
            }
            pinterestjsonobject = pinterestjsonobject.c("last_message");
            if (pinterestjsonobject != null)
            {
                PinterestJsonArray pinterestjsonarray1 = new PinterestJsonArray();
                pinterestjsonarray1.a(pinterestjsonobject);
                hashmap.put(conversation.getUid(), pinterestjsonarray1);
            }
        }

        if (!arraylist.isEmpty())
        {
            ModelHelper.setConversations(arraylist);
        }
        if (!hashmap.isEmpty())
        {
            ConversationMessage.makeAll(hashmap);
        }
        if (!arraylist1.isEmpty())
        {
            ModelHelper.setUsers(arraylist1);
        }
        return arraylist;
    }

    public void cacheEmailList(List list)
    {
        _emailList = list;
    }

    public void cacheUsers(List list)
    {
        _users = list;
    }

    public List getCachedEmailList()
    {
        if (_emailList == null && StringUtils.isNotBlank(emails))
        {
            _emailList = Arrays.asList(emails.split(","));
        }
        return _emailList;
    }

    public List getCachedUsers()
    {
        if (_users == null)
        {
            _users = ModelHelper.getUsers(Arrays.asList(users.split(",")));
        }
        return _users;
    }

    public List getConversationImageUrls()
    {
        Object obj = getCachedUsers();
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                User user = (User)((Iterator) (obj)).next();
                if (!MyUser.isUserMe(user.getUid()))
                {
                    arraylist.add(user.getImageLargeUrlByDpi());
                }
            } while (true);
        }
        return arraylist;
    }

    public String getConversationTitle()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj = getCachedUsers();
        if (obj != null)
        {
            int i = 0;
            while (i < ((List) (obj)).size()) 
            {
                User user = (User)((List) (obj)).get(i);
                if (!MyUser.isUserMe(user.getUid()))
                {
                    if (isGroupConversation())
                    {
                        stringbuilder.append(user.getFirstName());
                        if (i + 1 < ((List) (obj)).size())
                        {
                            stringbuilder.append(", ");
                        }
                    } else
                    {
                        stringbuilder.append(user.getFullName());
                    }
                }
                i++;
            }
        }
        obj = getCachedEmailList();
        if (obj != null)
        {
            String s;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append(s))
            {
                s = (String)((Iterator) (obj)).next();
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
            }

        }
        return stringbuilder.toString();
    }

    public String getEmails()
    {
        return emails;
    }

    public String getUid()
    {
        return uid;
    }

    public Integer getUnread()
    {
        return unread;
    }

    public String getUsers()
    {
        return users;
    }

    public boolean isGroupConversation()
    {
        boolean flag = false;
        int i;
        int j;
        if (getCachedUsers() != null)
        {
            i = getCachedUsers().size();
        } else
        {
            i = 0;
        }
        if (getCachedEmailList() != null)
        {
            j = getCachedEmailList().size();
        } else
        {
            j = 0;
        }
        if (i + j > 2)
        {
            flag = true;
        }
        return flag;
    }

    public void setEmails(String s)
    {
        emails = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUnread(Integer integer)
    {
        unread = integer;
    }

    public void setUsers(String s)
    {
        users = s;
    }
}
