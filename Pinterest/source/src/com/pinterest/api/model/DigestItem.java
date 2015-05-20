// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.pinterest.api.model:
//            Model, User, Board, Interest, 
//            Pin, ModelHelper

public class DigestItem extends Model
{

    public static final int DIGEST_STORY_HEADER = 0;
    public static final int DIGEST_STORY_PIN = 1;
    private String boardUid;
    private String containerType;
    private String coverUrl;
    private String description;
    private String descriptionArgs;
    private Integer enumType;
    private Long id;
    private String interestUid;
    private Boolean largePin;
    private String referId;
    private Integer totalPins;
    private String uid;
    private String userUid;

    public DigestItem()
    {
    }

    public DigestItem(Long long1)
    {
        id = long1;
    }

    public DigestItem(Long long1, String s, String s1, String s2, String s3, String s4, Integer integer, 
            String s5, String s6, String s7, Boolean boolean1, Integer integer1)
    {
        id = long1;
        uid = s;
        referId = s1;
        containerType = s2;
        description = s3;
        descriptionArgs = s4;
        totalPins = integer;
        userUid = s5;
        boardUid = s6;
        interestUid = s7;
        largePin = boolean1;
        enumType = integer1;
    }

    public static DigestItemArtifact make(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null || !DigestMode.isValid(pinterestjsonobject.a("container_type", "")))
        {
            return null;
        }
        DigestItem digestitem = new DigestItem();
        DigestItemArtifact digestitemartifact = new DigestItemArtifact();
        Object obj = pinterestjsonobject.c("user");
        if (obj != null)
        {
            obj = User.make(((PinterestJsonObject) (obj)), false);
            digestitemartifact.setUser(((User) (obj)));
            digestitem.setUserUid(((User) (obj)).getUid());
        }
        obj = pinterestjsonobject.c("board");
        if (obj != null)
        {
            obj = Board.make(((PinterestJsonObject) (obj)), false).getBoard();
            digestitemartifact.setBoard(((Board) (obj)));
            digestitem.setBoardUid(((Board) (obj)).getUid());
        }
        obj = pinterestjsonobject.c("interest");
        if (obj != null)
        {
            obj = Interest.make(((PinterestJsonObject) (obj)), false);
            digestitemartifact.setInterest(((Interest) (obj)));
            digestitem.setInterestUid(((Interest) (obj)).getUid());
        }
        digestitemartifact.setPins(Pin.makeAll(pinterestjsonobject.e("pins")));
        obj = pinterestjsonobject.e("large_pins");
        HashSet hashset = new HashSet();
        for (int i = 0; i < ((PinterestJsonArray) (obj)).a(); i++)
        {
            hashset.add(((PinterestJsonArray) (obj)).a(i));
        }

        digestitemartifact.setLargePinSet(hashset);
        digestitem.setDescriptionArgs(pinterestjsonobject.e("description_args").toString());
        digestitem.setUid(pinterestjsonobject.a("id", "0"));
        digestitem.setReferId(pinterestjsonobject.a("id", "0"));
        digestitem.setContainerType(pinterestjsonobject.a("container_type", ""));
        digestitem.setDescription(pinterestjsonobject.a("description", ""));
        digestitem.setEnumType(Integer.valueOf(0));
        digestitemartifact.setDigestItem(digestitem);
        return digestitemartifact;
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
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            DigestItemArtifact digestitemartifact = make(pinterestjsonarray.c(i));
            if (digestitemartifact == null)
            {
                continue;
            }
            arraylist.add(digestitemartifact.getDigestItem());
            if (digestitemartifact.getUser() != null)
            {
                arraylist1.add(digestitemartifact.getUser());
            }
            if (digestitemartifact.getBoard() != null)
            {
                arraylist2.add(digestitemartifact.getBoard());
            }
            if (digestitemartifact.getInterest() != null)
            {
                arraylist3.add(digestitemartifact.getInterest());
            }
            if (digestitemartifact.getPins() == null)
            {
                continue;
            }
            arraylist4.addAll(digestitemartifact.getPins());
            ArrayList arraylist5 = new ArrayList();
            for (Iterator iterator = digestitemartifact.getPins().iterator(); iterator.hasNext();)
            {
                Pin pin = (Pin)iterator.next();
                DigestItem digestitem = new DigestItem();
                digestitem.setUid(pin.getUid());
                digestitem.setReferId(digestitemartifact.getDigestItem().getReferId());
                digestitem.setEnumType(Integer.valueOf(1));
                if (digestitemartifact.getLargePinSet().contains(pin.getCacheableId()) || digestitemartifact.getPins().size() == 1)
                {
                    digestitem.setLargePin(Boolean.valueOf(true));
                    arraylist.add(digestitem);
                } else
                {
                    digestitem.setLargePin(Boolean.valueOf(false));
                    arraylist5.add(digestitem);
                }
            }

            arraylist.addAll(arraylist5);
        }

        ModelHelper.setBoards(arraylist2);
        ModelHelper.setUsers(arraylist1);
        ModelHelper.setInterests(arraylist3);
        ModelHelper.setPins(arraylist4);
        ModelHelper.setDigestItems(arraylist);
        return arraylist;
    }

    public String getBoardUid()
    {
        return boardUid;
    }

    public String getContainerType()
    {
        return containerType;
    }

    public String getCoverUrl()
    {
        return coverUrl;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDescriptionArgs()
    {
        return descriptionArgs;
    }

    public Integer getEnumType()
    {
        return enumType;
    }

    public Long getId()
    {
        return id;
    }

    public String getInterestUid()
    {
        return interestUid;
    }

    public Boolean getLargePin()
    {
        return largePin;
    }

    public String getReferId()
    {
        return referId;
    }

    public Integer getTotalPins()
    {
        return totalPins;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUserUid()
    {
        return userUid;
    }

    public void setBoardUid(String s)
    {
        boardUid = s;
    }

    public void setContainerType(String s)
    {
        containerType = s;
    }

    public void setCoverUrl(String s)
    {
        coverUrl = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setDescriptionArgs(String s)
    {
        descriptionArgs = s;
    }

    public void setEnumType(Integer integer)
    {
        enumType = integer;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setInterestUid(String s)
    {
        interestUid = s;
    }

    public void setLargePin(Boolean boolean1)
    {
        largePin = boolean1;
    }

    public void setReferId(String s)
    {
        referId = s;
    }

    public void setTotalPins(Integer integer)
    {
        totalPins = integer;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUserUid(String s)
    {
        userUid = s;
    }

    private class DigestMode extends Enum
    {

        private static final DigestMode $VALUES[];
        public static final DigestMode BOARD;
        public static final DigestMode INTEREST;
        public static final DigestMode NONE;
        public static final DigestMode REC_BOARD;
        public static final DigestMode REC_THROUGH_INTEREST;
        public static final DigestMode USER;
        public static final DigestMode USER_CATEGORY;
        private static final Map modeMap;
        private final String name;

        public static boolean isValid(String s)
        {
            return StringUtils.isNotEmpty(s) && withName(s) != NONE;
        }

        public static DigestMode valueOf(String s)
        {
            return (DigestMode)Enum.valueOf(com/pinterest/api/model/DigestItem$DigestMode, s);
        }

        public static DigestMode[] values()
        {
            return (DigestMode[])$VALUES.clone();
        }

        public static DigestMode withName(String s)
        {
            if (modeMap.containsKey(s))
            {
                return (DigestMode)modeMap.get(s);
            } else
            {
                return NONE;
            }
        }

        public final String getName()
        {
            return name;
        }

        static 
        {
            int i = 0;
            NONE = new DigestMode("NONE", 0, "none");
            REC_BOARD = new DigestMode("REC_BOARD", 1, "rec_board");
            BOARD = new DigestMode("BOARD", 2, "board");
            INTEREST = new DigestMode("INTEREST", 3, "interest");
            USER = new DigestMode("USER", 4, "user");
            USER_CATEGORY = new DigestMode("USER_CATEGORY", 5, "user_category");
            REC_THROUGH_INTEREST = new DigestMode("REC_THROUGH_INTEREST", 6, "rec_through_interest");
            $VALUES = (new DigestMode[] {
                NONE, REC_BOARD, BOARD, INTEREST, USER, USER_CATEGORY, REC_THROUGH_INTEREST
            });
            modeMap = new HashMap();
            DigestMode adigestmode[] = values();
            for (int j = adigestmode.length; i < j; i++)
            {
                DigestMode digestmode = adigestmode[i];
                modeMap.put(digestmode.toString().toLowerCase(), digestmode);
            }

        }

        private DigestMode(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }


    private class DigestItemArtifact
    {

        private Board board;
        private DigestItem digestItem;
        private Interest interest;
        private Set largePinSet;
        private List pins;
        private User user;

        public final Board getBoard()
        {
            return board;
        }

        public final DigestItem getDigestItem()
        {
            return digestItem;
        }

        public final Interest getInterest()
        {
            return interest;
        }

        public final Set getLargePinSet()
        {
            return largePinSet;
        }

        public final List getPins()
        {
            return pins;
        }

        public final User getUser()
        {
            return user;
        }

        public final void setBoard(Board board1)
        {
            board = board1;
        }

        public final void setDigestItem(DigestItem digestitem)
        {
            digestItem = digestitem;
        }

        public final void setInterest(Interest interest1)
        {
            interest = interest1;
        }

        public final void setLargePinSet(Set set)
        {
            largePinSet = set;
        }

        public final void setPins(List list)
        {
            pins = list;
        }

        public final void setUser(User user1)
        {
            user = user1;
        }

        public DigestItemArtifact()
        {
        }
    }

}
