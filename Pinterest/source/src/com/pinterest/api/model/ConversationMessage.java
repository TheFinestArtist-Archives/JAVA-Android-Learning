// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper, Pin, Board, 
//            User

public class ConversationMessage extends Model
{

    private String boardId;
    private String conversationId;
    private Date createdAt;
    private String pinId;
    private String senderId;
    private String text;
    private String uid;
    private String userId;

    public ConversationMessage()
    {
    }

    public ConversationMessage(String s)
    {
        uid = s;
    }

    public ConversationMessage(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            Date date)
    {
        uid = s;
        conversationId = s1;
        senderId = s2;
        pinId = s3;
        boardId = s4;
        userId = s5;
        text = s6;
        createdAt = date;
    }

    public static ConversationMessageArtifact make(String s, PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        return make(s, pinterestjsonobject, flag, true);
    }

    public static ConversationMessageArtifact make(String s, PinterestJsonObject pinterestjsonobject, boolean flag, boolean flag1)
    {
        Board board1 = null;
        ConversationMessageArtifact conversationmessageartifact = new ConversationMessageArtifact();
        ConversationMessage conversationmessage = new ConversationMessage();
        conversationmessage.setUid(pinterestjsonobject.a("id", ""));
        conversationmessage.setCreatedAt(ModelHelper.stringToDate(pinterestjsonobject.a("created_at", "")));
        conversationmessage.setConversationId(s);
        s = pinterestjsonobject.c("sender");
        if (s != null)
        {
            conversationmessage.setSenderId(s.a("id", ""));
        }
        s = pinterestjsonobject.a("text", "");
        if (ModelHelper.isValidString(s))
        {
            conversationmessage.setText(s);
        }
        s = pinterestjsonobject.c("pin");
        Board board;
        Object obj;
        Object obj1;
        if (s != null)
        {
            s = Pin.make(s, false, false).getPin();
            conversationmessage.setPinId(s.getUid());
        } else
        {
            s = null;
        }
        obj = pinterestjsonobject.c("board");
        if (obj != null)
        {
            board = Board.make(((PinterestJsonObject) (obj)), false, false).getBoard();
            conversationmessage.setBoardId(((PinterestJsonObject) (obj)).a("id", null));
        } else
        {
            board = null;
        }
        obj = pinterestjsonobject.c("user");
        pinterestjsonobject = board1;
        if (obj != null)
        {
            pinterestjsonobject = User.make(((PinterestJsonObject) (obj)), false, false);
            conversationmessage.setUserId(((PinterestJsonObject) (obj)).a("id", null));
        }
        obj1 = s;
        obj = pinterestjsonobject;
        board1 = board;
        if (flag1)
        {
            obj1 = Pin.merge(s);
            board1 = Board.merge(board);
            obj = User.merge(pinterestjsonobject);
        }
        conversationmessageartifact.setMessage(conversationmessage);
        conversationmessageartifact.setPin(((Pin) (obj1)));
        conversationmessageartifact.setBoard(board1);
        conversationmessageartifact.setUser(((User) (obj)));
        if (flag)
        {
            ModelHelper.setConversationMessage(conversationmessage);
            ModelHelper.setPin(conversationmessageartifact.getPin());
            ModelHelper.setBoard(conversationmessageartifact.getBoard());
            if (obj != null)
            {
                ModelHelper.setPartner(((User) (obj)).getPartner());
            }
            ModelHelper.setUser(conversationmessageartifact.getUser());
        }
        return conversationmessageartifact;
    }

    public static List makeAll(String s, PinterestJsonArray pinterestjsonarray)
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put(s, pinterestjsonarray);
        return makeAll(((Map) (hashmap)));
    }

    public static List makeAll(Map map)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        Object obj;
        Object obj1;
        ArrayList arraylist2;
        Object obj2;
        Object obj3;
        ArrayList arraylist3;
        arraylist = new ArrayList();
        arraylist3 = new ArrayList();
        obj3 = new ArrayList();
        obj2 = new ArrayList();
        arraylist2 = new ArrayList();
        obj1 = new ArrayList();
        obj = new ArrayList();
        arraylist1 = new ArrayList();
        map = map.entrySet().iterator();
_L5:
        String s;
        Object obj4;
        int i;
        do
        {
            if (!map.hasNext())
            {
                break MISSING_BLOCK_LABEL_329;
            }
            obj4 = (java.util.Map.Entry)map.next();
            s = (String)((java.util.Map.Entry) (obj4)).getKey();
            obj4 = (PinterestJsonArray)((java.util.Map.Entry) (obj4)).getValue();
        } while (obj4 == null);
        i = 0;
_L3:
        if (i >= ((PinterestJsonArray) (obj4)).a()) goto _L2; else goto _L1
_L1:
        ConversationMessageArtifact conversationmessageartifact = make(s, ((PinterestJsonArray) (obj4)).c(i), false, false);
        if (conversationmessageartifact != null)
        {
            try
            {
                if (conversationmessageartifact.getMessage() != null)
                {
                    arraylist.add(conversationmessageartifact.getMessage());
                }
                if (conversationmessageartifact.getPin() != null)
                {
                    arraylist2.add(conversationmessageartifact.getPin());
                    arraylist3.add(conversationmessageartifact.getPin().getUid());
                }
                if (conversationmessageartifact.getBoard() != null)
                {
                    ((List) (obj1)).add(conversationmessageartifact.getBoard());
                    ((List) (obj3)).add(conversationmessageartifact.getBoard().getUid());
                }
                if (conversationmessageartifact.getUser() != null)
                {
                    ((List) (obj)).add(conversationmessageartifact.getUser());
                    ((List) (obj2)).add(conversationmessageartifact.getUser().getUid());
                    if (conversationmessageartifact.getUser().getPartner() != null)
                    {
                        arraylist1.add(conversationmessageartifact.getUser().getPartner());
                    }
                }
            }
            catch (Exception exception) { }
        }
        i++;
          goto _L3
_L2:
        if (true) goto _L5; else goto _L4
_L4:
        map = ModelHelper.getPins(arraylist3);
        obj3 = ModelHelper.getBoards(((List) (obj3)));
        obj2 = ModelHelper.getUsers(((List) (obj2)));
        map = Pin.mergeAll(arraylist2, map);
        obj1 = Board.mergeAll(((List) (obj1)), ((List) (obj3)));
        obj = User.mergeAll(((List) (obj)), ((List) (obj2)));
        ModelHelper.setConversationMessages(arraylist);
        ModelHelper.setPins(map);
        ModelHelper.setBoards(((List) (obj1)));
        ModelHelper.setPartners(arraylist1);
        ModelHelper.setUsers(((List) (obj)));
        return arraylist;
    }

    public String getBoardId()
    {
        return boardId;
    }

    public String getConversationId()
    {
        return conversationId;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getPinId()
    {
        return pinId;
    }

    public String getSenderId()
    {
        return senderId;
    }

    public String getText()
    {
        return text;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setBoardId(String s)
    {
        boardId = s;
    }

    public void setConversationId(String s)
    {
        conversationId = s;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setPinId(String s)
    {
        pinId = s;
    }

    public void setSenderId(String s)
    {
        senderId = s;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    private class ConversationMessageArtifact
    {

        private Board board;
        private ConversationMessage message;
        private Pin pin;
        private User user;

        public final Board getBoard()
        {
            return board;
        }

        public final ConversationMessage getMessage()
        {
            return message;
        }

        public final Pin getPin()
        {
            return pin;
        }

        public final User getUser()
        {
            return user;
        }

        public final void setBoard(Board board1)
        {
            board = board1;
        }

        public final void setMessage(ConversationMessage conversationmessage)
        {
            message = conversationmessage;
        }

        public final void setPin(Pin pin1)
        {
            pin = pin1;
        }

        public final void setUser(User user1)
        {
            user = user1;
        }

        public ConversationMessageArtifact()
        {
        }
    }

}
