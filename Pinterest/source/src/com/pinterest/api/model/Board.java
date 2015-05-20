// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.base.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper, User, MyUser

public class Board extends Model
{

    public static final String LAYOUT_DEFAULT = "default";
    public static final String LAYOUT_PLACE = "places";
    private String category;
    private Boolean collaborative;
    private Boolean collaborator;
    private Integer collaboratorCount;
    private Boolean collaboratorInvitesEnabled;
    private Date createdAt;
    private String description;
    private Integer followerCount;
    private Boolean following;
    private Long id;
    private String imageCoverThumbnail;
    private String imageCoverUrl;
    private String imagePreviewUrl;
    private String imageThumbnailUrls;
    private String layout;
    private String name;
    private Integer pinCount;
    private Boolean secret;
    private String uid;
    private String url;
    public User user;
    private String userUid;

    public Board()
    {
    }

    public Board(Long long1)
    {
        id = long1;
    }

    public Board(Long long1, String s, String s1, Date date, String s2, String s3, String s4, 
            String s5, String s6, String s7, String s8, String s9, Boolean boolean1, Boolean boolean2, 
            Boolean boolean3, Boolean boolean4, Boolean boolean5, Integer integer, Integer integer1, Integer integer2, String s10)
    {
        id = long1;
        uid = s;
        userUid = s1;
        createdAt = date;
        name = s2;
        category = s3;
        description = s4;
        url = s5;
        imageThumbnailUrls = s6;
        imagePreviewUrl = s7;
        imageCoverUrl = s8;
        imageCoverThumbnail = s9;
        following = boolean1;
        collaborative = boolean2;
        collaboratorInvitesEnabled = boolean3;
        collaborator = boolean4;
        secret = boolean5;
        pinCount = integer;
        followerCount = integer1;
        collaboratorCount = integer2;
        layout = s10;
    }

    private static String getThumbnailUrlsEntry(PinterestJsonArray pinterestjsonarray)
    {
        if (pinterestjsonarray == null || pinterestjsonarray.a() == 0)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        for (int j = pinterestjsonarray.a(); i < j; i++)
        {
            String s = pinterestjsonarray.c(i).a("url", null);
            if (s != null)
            {
                stringbuilder.append((new StringBuilder(",")).append(s).toString());
            }
        }

        return stringbuilder.toString().substring(1);
    }

    public static final boolean isNameValid(String s)
    {
        return s.trim().length() > 0;
    }

    public static BoardArtifact make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        return make(pinterestjsonobject, flag, true);
    }

    public static BoardArtifact make(PinterestJsonObject pinterestjsonobject, boolean flag, boolean flag1)
    {
        if (pinterestjsonobject == null)
        {
            return null;
        }
        BoardArtifact boardartifact = new BoardArtifact();
        Object obj = pinterestjsonobject.c("data");
        if (obj != null)
        {
            pinterestjsonobject = ((PinterestJsonObject) (obj));
        }
        obj = pinterestjsonobject.c("owner");
        Board board = new Board();
        board.setUid(pinterestjsonobject.a("id", "0"));
        if (pinterestjsonobject.f("is_collaborative"))
        {
            board.setCollaborative(pinterestjsonobject.a("is_collaborative"));
        }
        board.setCollaboratorInvitesEnabled(pinterestjsonobject.a("collaborator_invites_enabled", Boolean.valueOf(true)));
        if (pinterestjsonobject.f("collaborated_by_me"))
        {
            board.setCollaborator(pinterestjsonobject.a("collaborated_by_me"));
        }
        if (pinterestjsonobject.f("privacy"))
        {
            board.setSecret(Boolean.valueOf(pinterestjsonobject.a("privacy", "public").equalsIgnoreCase("secret")));
        }
        if (pinterestjsonobject.f("followed_by_me"))
        {
            board.setFollowing(pinterestjsonobject.a("followed_by_me"));
        }
        if (pinterestjsonobject.f("created_at"))
        {
            board.setCreatedAt(ModelHelper.stringToDate(pinterestjsonobject.a("created_at", "")));
        }
        if (ModelHelper.isValidString(pinterestjsonobject.a("image_thumbnail_url", "")))
        {
            board.setImagePreviewUrl(pinterestjsonobject.a("image_thumbnail_url", ""));
        }
        if (ModelHelper.isValidString(pinterestjsonobject.a("image_cover_url", "")))
        {
            board.setImageCoverUrl(pinterestjsonobject.a("image_cover_url", ""));
        }
        Object obj1 = pinterestjsonobject.c("cover_images");
        if (obj1 != null)
        {
            obj1 = ((PinterestJsonObject) (obj1)).c("60x60");
            if (obj1 != null)
            {
                board.setImageCoverThumbnail(((PinterestJsonObject) (obj1)).a("url", null));
            }
        }
        obj1 = pinterestjsonobject.c("images");
        if (obj1 != null)
        {
            board.setImageThumbnailUrls(getThumbnailUrlsEntry(((PinterestJsonObject) (obj1)).e("90x90")));
        }
        if (pinterestjsonobject.f("name"))
        {
            board.setName(pinterestjsonobject.a("name", ""));
        }
        if (ModelHelper.isValidString(pinterestjsonobject.a("category", "")))
        {
            board.setCategory(pinterestjsonobject.a("category", ""));
        }
        if (ModelHelper.isValidString(pinterestjsonobject.a("description", "")))
        {
            board.setDescription(pinterestjsonobject.a("description", ""));
        }
        if (pinterestjsonobject.f("url"))
        {
            board.setUrl(pinterestjsonobject.a("url", ""));
        }
        if (pinterestjsonobject.f("layout"))
        {
            board.setLayout(pinterestjsonobject.a("layout", ""));
        }
        board.setPinCount(Integer.valueOf(pinterestjsonobject.a("pin_count", -1)));
        board.setFollowerCount(Integer.valueOf(pinterestjsonobject.a("follower_count", -1)));
        board.setCollaboratorCount(Integer.valueOf(pinterestjsonobject.a("collaborator_count", -1)));
        if (obj != null)
        {
            pinterestjsonobject = User.make(((PinterestJsonObject) (obj)), false, flag1);
            board.setUserUid(pinterestjsonobject.getUid());
        } else
        {
            pinterestjsonobject = null;
        }
        obj1 = pinterestjsonobject;
        obj = board;
        if (flag1)
        {
            obj = merge(board);
            obj1 = User.merge(pinterestjsonobject);
        }
        boardartifact.setBoard(((Board) (obj)));
        boardartifact.setUser(((User) (obj1)));
        if (flag)
        {
            ModelHelper.setBoard(boardartifact.getBoard());
            ModelHelper.setPartner(((User) (obj1)).getPartner());
            ModelHelper.setUser(boardartifact.getUser());
        }
        return boardartifact;
    }

    public static Board make(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return null;
        } else
        {
            return make(pinterestjsonobject, true).getBoard();
        }
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist1 = new ArrayList();
        if (pinterestjsonarray == null)
        {
            return arraylist1;
        }
        ArrayList arraylist2 = new ArrayList();
        Object obj1 = new ArrayList();
        Object obj = new ArrayList();
        ArrayList arraylist = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            BoardArtifact boardartifact = make(pinterestjsonarray.c(i), false, false);
            if (boardartifact.getBoard() != null)
            {
                arraylist1.add(boardartifact.getBoard());
                arraylist2.add(boardartifact.getBoard().getUid());
            }
            if (boardartifact.getUser() == null)
            {
                continue;
            }
            ((List) (obj)).add(boardartifact.getUser());
            ((List) (obj1)).add(boardartifact.getUser().getUid());
            if (boardartifact.getUser().getPartner() != null)
            {
                arraylist.add(boardartifact.getUser().getPartner());
            }
        }

        pinterestjsonarray = ModelHelper.getBoards(arraylist2);
        obj1 = ModelHelper.getUsers(((List) (obj1)));
        pinterestjsonarray = mergeAll(arraylist1, pinterestjsonarray);
        obj = User.mergeAll(((List) (obj)), ((List) (obj1)));
        ModelHelper.setBoards(pinterestjsonarray);
        ModelHelper.setPartners(arraylist);
        ModelHelper.setUsers(((List) (obj)));
        return pinterestjsonarray;
    }

    public static Board merge(Board board)
    {
        if (board == null)
        {
            return null;
        } else
        {
            return merge(board, ModelHelper.getBoard(board.getUid()));
        }
    }

    public static Board merge(Board board, Board board1)
    {
        Board board2;
        if (board == null)
        {
            board2 = null;
        } else
        {
            board2 = board;
            if (board1 != null)
            {
                if (board.userUid != null)
                {
                    board1.userUid = board.userUid;
                }
                if (board.createdAt != null)
                {
                    board1.createdAt = board.createdAt;
                }
                if (board.name != null)
                {
                    board1.name = board.name;
                }
                if (board.category != null)
                {
                    board1.category = board.category;
                }
                if (board.description != null)
                {
                    board1.description = board.description;
                }
                if (board.url != null)
                {
                    board1.url = board.url;
                }
                if (board.imageThumbnailUrls != null)
                {
                    board1.imageThumbnailUrls = board.imageThumbnailUrls;
                }
                if (board.imagePreviewUrl != null)
                {
                    board1.imagePreviewUrl = board.imagePreviewUrl;
                }
                if (board.imageCoverUrl != null)
                {
                    board1.imageCoverUrl = board.imageCoverUrl;
                }
                if (board.imageCoverThumbnail != null)
                {
                    board1.imageCoverThumbnail = board.imageCoverThumbnail;
                }
                if (board.following != null)
                {
                    board1.following = board.following;
                }
                if (board.collaborative != null)
                {
                    board1.collaborative = board.collaborative;
                }
                if (board.collaboratorInvitesEnabled != null)
                {
                    board1.collaboratorInvitesEnabled = board.collaboratorInvitesEnabled;
                }
                if (board.collaborator != null)
                {
                    board1.collaborator = board.collaborator;
                }
                if (board.secret != null)
                {
                    board1.secret = board.secret;
                }
                if (board.pinCount != null && board.pinCount.intValue() >= 0)
                {
                    board1.pinCount = board.pinCount;
                }
                if (board.followerCount != null && board.followerCount.intValue() >= 0)
                {
                    board1.followerCount = board.followerCount;
                }
                if (board.collaboratorCount != null && board.collaboratorCount.intValue() >= 0)
                {
                    board1.collaboratorCount = board.collaboratorCount;
                }
                if (board.layout != null)
                {
                    board1.layout = board.layout;
                }
                if (board.imageThumbnailUrls != null)
                {
                    board1.imageThumbnailUrls = board.imageThumbnailUrls;
                }
                return board1;
            }
        }
        return board2;
    }

    public static List mergeAll(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            Board board = (Board)iterator.next();
            int i = list1.indexOf(board);
            if (i != -1)
            {
                list = (Board)list1.get(i);
            } else
            {
                list = null;
            }
            arraylist.add(merge(board, list));
        }
        return arraylist;
    }

    public boolean allowToInviteOthers()
    {
        return MyUser.isUserMe(userUid) || Constants.isTrue(collaborator) && Constants.isTrue(collaboratorInvitesEnabled);
    }

    public void cacheUser(User user1)
    {
        user = user1;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || getUid() == null || !(obj instanceof Board) || !getUid().equals(((Board)obj).getUid())) 
        {
            return false;
        }
        return true;
    }

    public String getCategory()
    {
        return category;
    }

    public Boolean getCollaborative()
    {
        return collaborative;
    }

    public Boolean getCollaborator()
    {
        return collaborator;
    }

    public Integer getCollaboratorCount()
    {
        return collaboratorCount;
    }

    public Boolean getCollaboratorInvitesEnabled()
    {
        return collaboratorInvitesEnabled;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getDescription()
    {
        return description;
    }

    public int getFollowCountDisplay()
    {
        if (followerCount == null || followerCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return followerCount.intValue();
        }
    }

    public Integer getFollowerCount()
    {
        return followerCount;
    }

    public Boolean getFollowing()
    {
        return following;
    }

    public Long getId()
    {
        return id;
    }

    public String getImageCoverThumbnail()
    {
        return imageCoverThumbnail;
    }

    public String getImageCoverUrl()
    {
        return imageCoverUrl;
    }

    public String getImagePreviewUrl()
    {
        return imagePreviewUrl;
    }

    public String getImageThumbnailUrls()
    {
        return imageThumbnailUrls;
    }

    public List getImageThumbnailsList()
    {
        if (ModelHelper.isValid(imageThumbnailUrls))
        {
            return Arrays.asList(imageThumbnailUrls.split(","));
        } else
        {
            return new ArrayList();
        }
    }

    public String getLayout()
    {
        return layout;
    }

    public String getName()
    {
        return name;
    }

    public Integer getPinCount()
    {
        return pinCount;
    }

    public int getPinCountDisplay()
    {
        if (pinCount == null || pinCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return pinCount.intValue();
        }
    }

    public Boolean getSecret()
    {
        return secret;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUrl()
    {
        return url;
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

    public boolean hasDescription()
    {
        return StringUtils.isNotBlank(getDescription());
    }

    public boolean isMeOwnerOrCollaborator()
    {
        return Constants.isTrue(collaborator) || MyUser.isUserMe(userUid);
    }

    public boolean isPlaceBoard()
    {
        return "places".equals(layout);
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setCollaborative(Boolean boolean1)
    {
        collaborative = boolean1;
    }

    public void setCollaborator(Boolean boolean1)
    {
        collaborator = boolean1;
    }

    public void setCollaboratorCount(Integer integer)
    {
        collaboratorCount = integer;
    }

    public void setCollaboratorInvitesEnabled(Boolean boolean1)
    {
        collaboratorInvitesEnabled = boolean1;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setFollowerCount(Integer integer)
    {
        followerCount = integer;
    }

    public void setFollowing(Boolean boolean1)
    {
        following = boolean1;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setImageCoverThumbnail(String s)
    {
        imageCoverThumbnail = s;
    }

    public void setImageCoverUrl(String s)
    {
        imageCoverUrl = s;
    }

    public void setImagePreviewUrl(String s)
    {
        imagePreviewUrl = s;
    }

    public void setImageThumbnailUrls(String s)
    {
        imageThumbnailUrls = s;
    }

    public void setImageThumbnailsList(List list)
    {
        setImageThumbnailUrls(list.toString().replaceAll("(^.|.$)", "").replace(", ", ","));
        ModelHelper.setBoard(this);
    }

    public void setLayout(String s)
    {
        layout = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPinCount(Integer integer)
    {
        pinCount = integer;
    }

    public void setSecret(Boolean boolean1)
    {
        secret = boolean1;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setUserUid(String s)
    {
        userUid = s;
    }

    private class BoardArtifact
    {

        private Board board;
        private User user;

        public final Board getBoard()
        {
            return board;
        }

        public final User getUser()
        {
            return user;
        }

        public final void setBoard(Board board1)
        {
            board = board1;
        }

        public final void setUser(User user1)
        {
            user = user1;
        }

        public BoardArtifact()
        {
        }
    }

}
