// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;


// Referenced classes of package com.pinterest.api.model:
//            Board, Pin, Place, User, 
//            Interest

public final class 
{

    private Board board;
    private Pin pin;
    private Place place;
    private User promoterUser;
    private Board recommendationBoard;
    private Interest sourceInterest;
    private User user;
    private User viaUser;

    public final Board getBoard()
    {
        return board;
    }

    public final Pin getPin()
    {
        return pin;
    }

    public final Place getPlace()
    {
        return place;
    }

    public final User getPromoterUser()
    {
        return promoterUser;
    }

    public final Board getRecommendationBoard()
    {
        return recommendationBoard;
    }

    public final Interest getSourceInterest()
    {
        return sourceInterest;
    }

    public final User getUser()
    {
        return user;
    }

    public final User getViaUser()
    {
        return viaUser;
    }

    public final void setBoard(Board board1)
    {
        board = board1;
    }

    public final void setPin(Pin pin1)
    {
        pin = pin1;
    }

    public final void setPlace(Place place1)
    {
        place = place1;
    }

    public final void setPromoterUser(User user1)
    {
        promoterUser = user1;
    }

    public final void setRecommendationBoard(Board board1)
    {
        recommendationBoard = board1;
    }

    public final void setSourceInterest(Interest interest)
    {
        sourceInterest = interest;
    }

    public final void setUser(User user1)
    {
        user = user1;
    }

    public final void setViaUser(User user1)
    {
        viaUser = user1;
    }

    public ()
    {
    }
}
