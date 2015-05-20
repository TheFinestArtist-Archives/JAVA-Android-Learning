// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public class BoardInvite extends Model
{

    private String boardUid;
    private Date createdAt;
    private Long id;
    private String inviterUid;
    private Boolean isAcceptable;
    private String status;
    private String type;
    private String uid;

    public BoardInvite()
    {
    }

    public BoardInvite(Long long1)
    {
        id = long1;
    }

    public BoardInvite(Long long1, String s, Date date, String s1, String s2, String s3, String s4, 
            Boolean boolean1)
    {
        id = long1;
        uid = s;
        createdAt = date;
        inviterUid = s1;
        boardUid = s2;
        status = s3;
        type = s4;
        isAcceptable = boolean1;
    }

    public static BoardInvite make(PinterestJsonObject pinterestjsonobject)
    {
        BoardInvite boardinvite = new BoardInvite();
        if (pinterestjsonobject != null)
        {
            PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("board");
            if (pinterestjsonobject1 != null)
            {
                boardinvite.setUid(pinterestjsonobject1.a("id", "0"));
                boardinvite.setBoardUid(boardinvite.getUid());
            } else
            {
                boardinvite.setUid("0");
                boardinvite.setBoardUid("0");
            }
            pinterestjsonobject1 = pinterestjsonobject.c("invited_by_user");
            if (pinterestjsonobject1 != null)
            {
                boardinvite.setInviterUid(pinterestjsonobject1.a("id", "0"));
            } else
            {
                boardinvite.setInviterUid("0");
            }
            boardinvite.setCreatedAt(ModelHelper.stringToDate(pinterestjsonobject.a("created_at", "")));
            boardinvite.setIsAcceptable(pinterestjsonobject.a("is_acceptable"));
            boardinvite.setStatus(pinterestjsonobject.a("status", ""));
            boardinvite.setType(pinterestjsonobject.a("type", ""));
        }
        return boardinvite;
    }

    public static List makeAll(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        if (obj instanceof PinterestJsonArray)
        {
            obj = (PinterestJsonArray)obj;
            for (int i = 0; i < ((PinterestJsonArray) (obj)).a(); i++)
            {
                arraylist.add(make(((PinterestJsonArray) (obj)).b(i)));
            }

        } else
        if (obj instanceof PinterestJsonObject)
        {
            arraylist.add(make((PinterestJsonObject)obj));
        }
        ModelHelper.setBoardInvites(arraylist);
        return arraylist;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof BoardInvite)) 
        {
            return false;
        }
        return ((BoardInvite)obj).getBoardUid().equals(getBoardUid());
    }

    public String getBoardUid()
    {
        return boardUid;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public Long getId()
    {
        return id;
    }

    public String getInviterUid()
    {
        return inviterUid;
    }

    public Boolean getIsAcceptable()
    {
        return isAcceptable;
    }

    public String getStatus()
    {
        return status;
    }

    public String getType()
    {
        return type;
    }

    public String getUid()
    {
        return uid;
    }

    public void setBoardUid(String s)
    {
        boardUid = s;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setInviterUid(String s)
    {
        inviterUid = s;
    }

    public void setIsAcceptable(Boolean boolean1)
    {
        isAcceptable = boolean1;
    }

    public void setStatus(String s)
    {
        status = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }
}
