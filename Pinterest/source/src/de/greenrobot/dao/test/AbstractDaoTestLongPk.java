// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.UnitTestDaoAccess;
import java.util.Random;

// Referenced classes of package de.greenrobot.dao.test:
//            AbstractDaoTestSinglePk

public abstract class AbstractDaoTestLongPk extends AbstractDaoTestSinglePk
{

    public AbstractDaoTestLongPk(Class class1)
    {
        super(class1);
    }

    protected Long createRandomPk()
    {
        return Long.valueOf(random.nextLong());
    }

    protected volatile Object createRandomPk()
    {
        return createRandomPk();
    }

    public void testAssignPk()
    {
        if (daoAccess.isEntityUpdateable())
        {
            Object obj1 = createEntity(null);
            if (obj1 != null)
            {
                Object obj = createEntity(null);
                dao.insert(obj1);
                dao.insert(obj);
                obj1 = (Long)daoAccess.getKey(obj1);
                assertNotNull(obj1);
                obj = (Long)daoAccess.getKey(obj);
                assertNotNull(obj);
                assertFalse(((Long) (obj1)).equals(obj));
                assertNotNull(dao.load(obj1));
                assertNotNull(dao.load(obj));
                return;
            } else
            {
                DaoLog.d((new StringBuilder("Skipping testAssignPk for ")).append(daoClass).append(" (createEntity returned null for null key)").toString());
                return;
            }
        } else
        {
            DaoLog.d((new StringBuilder("Skipping testAssignPk for not updateable ")).append(daoClass).toString());
            return;
        }
    }
}
