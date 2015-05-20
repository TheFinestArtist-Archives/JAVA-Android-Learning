// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;


// Referenced classes of package de.greenrobot.dao:
//            AbstractDao

public class Command
{

    public AbstractDao dao;
    public Object data;
    public CommandType type;

    public Command(CommandType commandtype, AbstractDao abstractdao, Object obj)
    {
        type = commandtype;
        dao = abstractdao;
        data = obj;
    }
}
