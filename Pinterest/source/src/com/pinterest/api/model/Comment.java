// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.utils.PStringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper, User

public class Comment extends Model
{

    private Date createdAt;
    private Long id;
    private String pinUid;
    private String text;
    private String uid;
    private User user;
    private String userUid;

    public Comment()
    {
    }

    public Comment(Long long1)
    {
        id = long1;
    }

    public Comment(Long long1, String s, String s1, String s2, String s3, Date date)
    {
        id = long1;
        uid = s;
        userUid = s1;
        pinUid = s2;
        text = s3;
        createdAt = date;
    }

    public static CommentArtifact make(String s, PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        CommentArtifact commentartifact = new CommentArtifact();
        PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("commenter");
        Comment comment = new Comment();
        comment.setUid(pinterestjsonobject.a("id", "0"));
        comment.setPinUid(s);
        comment.setCreatedAt(ModelHelper.stringToDate(pinterestjsonobject.a("created_at", "")));
        comment.setText(PStringUtils.getAbsoluteHtmlString(pinterestjsonobject.a("text", ""), true));
        s = new User();
        if (pinterestjsonobject1 != null)
        {
            s = User.make(pinterestjsonobject1, false);
            comment.setUserUid(s.getUid());
        }
        s = User.merge(s);
        comment.cacheUser(s);
        commentartifact.setComment(merge(comment));
        commentartifact.setUser(s);
        if (flag)
        {
            ModelHelper.setComment(commentartifact.getComment());
            ModelHelper.setPartner(s.getPartner());
            ModelHelper.setUser(commentartifact.getUser());
        }
        return commentartifact;
    }

    public static Comment make(String s, PinterestJsonObject pinterestjsonobject)
    {
        return make(s, pinterestjsonobject, true).getComment();
    }

    public static List makeAll(String s, PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            CommentArtifact commentartifact = make(s, pinterestjsonarray.c(i), false);
            arraylist.add(commentartifact.getComment());
            arraylist1.add(commentartifact.getUser());
            if (commentartifact.getUser().getPartner() != null)
            {
                arraylist2.add(commentartifact.getUser().getPartner());
            }
        }

        ModelHelper.setComments(arraylist);
        ModelHelper.setPartners(arraylist2);
        ModelHelper.setUsers(arraylist1);
        return arraylist;
    }

    public static Comment merge(Comment comment)
    {
        return comment;
    }

    public void cacheUser(User user1)
    {
        user = user1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Comment)obj;
            if (uid == null ? ((Comment) (obj)).uid != null : !uid.equals(((Comment) (obj)).uid))
            {
                return false;
            }
        }
        return true;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public Long getId()
    {
        return id;
    }

    public String getPinUid()
    {
        return pinUid;
    }

    public String getText()
    {
        return text;
    }

    public String getUid()
    {
        return uid;
    }

    public User getUser()
    {
        if (user == null)
        {
            user = ModelHelper.getUser(getUserUid());
        }
        return user;
    }

    public String getUserUid()
    {
        return userUid;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setPinUid(String s)
    {
        pinUid = s;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUserUid(String s)
    {
        userUid = s;
    }

    private class CommentArtifact
    {

        private Comment comment;
        private User user;

        public final Comment getComment()
        {
            return comment;
        }

        public final User getUser()
        {
            return user;
        }

        public final void setComment(Comment comment1)
        {
            comment = comment1;
        }

        public final void setUser(User user1)
        {
            user = user1;
        }

        public CommentArtifact()
        {
        }
    }

}
