// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import com.facebook.model.GraphUser;

public class <init>
{

    private boolean _connected;
    private GraphUser _graphUser;
    private _network _network;

    public GraphUser getGraphUser()
    {
        return _graphUser;
    }

    public _graphUser getNetwork()
    {
        return _network;
    }

    public boolean isConnected()
    {
        return _connected;
    }

    public void setGraphUser(GraphUser graphuser)
    {
        _graphUser = graphuser;
    }

    public void setNetwork(_graphUser _pgraphuser)
    {
        _network = _pgraphuser;
    }

    public ( )
    {
        this(, null, true);
    }

    public <init>(<init> <init>1, GraphUser graphuser)
    {
        this(<init>1, graphuser, true);
    }

    public <init>(<init> <init>1, GraphUser graphuser, boolean flag)
    {
        _network = <init>1;
        _graphUser = graphuser;
        _connected = flag;
    }

    public _connected(_connected _pconnected, boolean flag)
    {
        this(_pconnected, null, flag);
    }
}
