// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import java.util.List;
import java.util.Set;

// Referenced classes of package com.pinterest.api.model:
//            Board, DigestItem, Interest, User

public final class 
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

    public ()
    {
    }
}
