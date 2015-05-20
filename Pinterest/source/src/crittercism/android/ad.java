// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.net.SocketImpl;
import java.net.SocketImplFactory;

// Referenced classes of package crittercism.android:
//            cb, cc, cd, ac, 
//            d, c

public final class ad
    implements SocketImplFactory
{

    private Class a;
    private SocketImplFactory b;
    private d c;
    private c d;

    public ad(Class class1, d d1, c c1)
    {
        c = d1;
        d = c1;
        a = class1;
        d1 = a;
        if (d1 == null)
        {
            throw new cb(cc.o);
        }
        class1 = cc.a;
        try
        {
            d1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1 = cc.q;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1 = cc.r;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1 = cc.r;
        }
        if (class1 != cc.a)
        {
            throw new cb(class1);
        } else
        {
            return;
        }
    }

    public ad(SocketImplFactory socketimplfactory, d d1, c c1)
    {
        c = d1;
        d = c1;
        b = socketimplfactory;
        socketimplfactory = b;
        if (socketimplfactory == null)
        {
            throw new cb(cc.n);
        }
        try
        {
            if (socketimplfactory.createSocketImpl() == null)
            {
                throw new cb(cc.p);
            }
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            throw new cb(new cd(cc.p, socketimplfactory.getMessage()));
        }
    }

    public final SocketImpl createSocketImpl()
    {
        SocketImpl socketimpl = null;
        if (b == null) goto _L2; else goto _L1
_L1:
        socketimpl = b.createSocketImpl();
_L3:
        SocketImpl socketimpl1;
        Object obj;
        if (socketimpl != null)
        {
            return new ac(c, d, socketimpl);
        } else
        {
            return socketimpl;
        }
_L2:
        socketimpl1 = (SocketImpl)a.newInstance();
        socketimpl = socketimpl1;
          goto _L3
        obj;
        ((IllegalAccessException) (obj)).printStackTrace();
          goto _L3
        obj;
        ((InstantiationException) (obj)).printStackTrace();
          goto _L3
    }
}
