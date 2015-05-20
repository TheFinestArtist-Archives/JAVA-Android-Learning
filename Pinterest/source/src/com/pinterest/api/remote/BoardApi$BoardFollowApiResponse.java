// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.Board;

public abstract class _following extends ApiResponseHandler
{

    private Board _board;
    private final boolean _following;

    public void onFailure(Board board)
    {
    }

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        onFailure(_board);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        class _cls1 extends BackgroundTask
        {

            final BoardApi.BoardFollowApiResponse a;

            public void onFinish()
            {
                a.onSuccess(a._board);
            }

            public void run()
            {
                Board board = a._board;
                boolean flag;
                if (!a._following)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                board.setFollowing(Boolean.valueOf(flag));
                ModelHelper.setBoard(a._board);
            }

            _cls1()
            {
                a = BoardApi.BoardFollowApiResponse.this;
                super();
            }
        }

        (new _cls1()).execute();
    }

    public void onSuccess(Board board)
    {
    }



    protected _cls1(Board board)
    {
        _board = board;
        boolean flag;
        if (_board.getFollowing() == Boolean.TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _following = flag;
    }
}
