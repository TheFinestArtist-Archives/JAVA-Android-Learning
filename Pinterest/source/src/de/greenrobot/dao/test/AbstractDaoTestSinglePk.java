// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.SqlUtils;
import de.greenrobot.dao.UnitTestDaoAccess;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package de.greenrobot.dao.test:
//            AbstractDaoTest

public abstract class AbstractDaoTestSinglePk extends AbstractDaoTest
{

    private Property pkColumn;
    protected Set usedPks;

    public AbstractDaoTestSinglePk(Class class1)
    {
        super(class1);
        usedPks = new HashSet();
    }

    protected abstract Object createEntity(Object obj);

    protected Object createEntityWithRandomPk()
    {
        return createEntity(createRandomPk());
    }

    protected abstract Object createRandomPk();

    protected Object nextPk()
    {
        int i = 0;
        do
        {
            if (i >= 0x186a0)
            {
                throw new IllegalStateException("Could not find a new PK");
            }
            Object obj = createRandomPk();
            if (usedPks.add(obj))
            {
                return obj;
            }
            i++;
        } while (true);
    }

    protected Cursor queryWithDummyColumnsInFront(int i, String s, Object obj)
    {
        Object obj1;
        int j;
        boolean flag;
        flag = false;
        obj1 = new StringBuilder("SELECT ");
        j = 0;
_L8:
        if (j < i) goto _L2; else goto _L1
_L1:
        SqlUtils.appendColumns(((StringBuilder) (obj1)), "T", dao.getAllColumns()).append(" FROM ");
        ((StringBuilder) (obj1)).append(dao.getTablename()).append(" T");
        if (obj != null)
        {
            ((StringBuilder) (obj1)).append(" WHERE ");
            assertEquals(1, dao.getPkColumns().length);
            ((StringBuilder) (obj1)).append(dao.getPkColumns()[0]).append("=");
            DatabaseUtils.appendValueToSql(((StringBuilder) (obj1)), obj);
        }
        obj1 = ((StringBuilder) (obj1)).toString();
        obj1 = db.rawQuery(((String) (obj1)), null);
        assertTrue(((Cursor) (obj1)).moveToFirst());
        j = ((flag) ? 1 : 0);
_L6:
        if (j < i) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        assertEquals(1, ((Cursor) (obj1)).getCount());
        return ((Cursor) (obj1));
_L2:
        ((StringBuilder) (obj1)).append(s).append(",");
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        assertEquals(s, ((Cursor) (obj1)).getString(j));
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        ((Cursor) (obj1)).close();
        throw s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void runLoadPkTest(int i)
    {
        Object obj;
        Object obj1;
        obj = nextPk();
        obj1 = createEntity(obj);
        dao.insert(obj1);
        obj1 = queryWithDummyColumnsInFront(i, "42", obj);
        assertEquals(obj, daoAccess.readKey(((Cursor) (obj1)), i));
        ((Cursor) (obj1)).close();
        return;
        Exception exception;
        exception;
        ((Cursor) (obj1)).close();
        throw exception;
    }

    protected void setUp()
    {
        super.setUp();
        Property aproperty[] = daoAccess.getProperties();
        int j = aproperty.length;
        int i = 0;
        do
        {
            Property property;
            if (i >= j)
            {
                if (pkColumn == null)
                {
                    throw new RuntimeException("Test does not work without a PK column");
                } else
                {
                    return;
                }
            }
            property = aproperty[i];
            if (property.primaryKey)
            {
                if (pkColumn != null)
                {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
                pkColumn = property;
            }
            i++;
        } while (true);
    }

    public void testCount()
    {
        dao.deleteAll();
        assertEquals(0L, dao.count());
        dao.insert(createEntityWithRandomPk());
        assertEquals(1L, dao.count());
        dao.insert(createEntityWithRandomPk());
        assertEquals(2L, dao.count());
    }

    public void testDelete()
    {
        Object obj = nextPk();
        dao.deleteByKey(obj);
        Object obj1 = createEntity(obj);
        dao.insert(obj1);
        assertNotNull(dao.load(obj));
        dao.deleteByKey(obj);
        assertNull(dao.load(obj));
    }

    public void testDeleteAll()
    {
        Object obj;
        int i;
        obj = new ArrayList();
        i = 0;
_L3:
        if (i < 10) goto _L2; else goto _L1
_L1:
        dao.insertInTx(((Iterable) (obj)));
        dao.deleteAll();
        assertEquals(0L, dao.count());
        obj = ((List) (obj)).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext())
        {
            return;
        }
        break MISSING_BLOCK_LABEL_77;
_L2:
        ((List) (obj)).add(createEntityWithRandomPk());
        i++;
          goto _L3
        Object obj1 = (Object)((Iterator) (obj)).next();
        obj1 = daoAccess.getKey(obj1);
        assertNotNull(obj1);
        assertNull(dao.load(obj1));
          goto _L4
    }

    public void testDeleteInTx()
    {
        Object obj;
        int i;
        obj = new ArrayList();
        i = 0;
_L3:
        if (i < 10) goto _L2; else goto _L1
_L1:
        dao.insertInTx(((Iterable) (obj)));
        ArrayList arraylist = new ArrayList();
        arraylist.add(((List) (obj)).get(0));
        arraylist.add(((List) (obj)).get(3));
        arraylist.add(((List) (obj)).get(4));
        arraylist.add(((List) (obj)).get(8));
        dao.deleteInTx(arraylist);
        assertEquals(((List) (obj)).size() - arraylist.size(), dao.count());
        obj = arraylist.iterator();
_L4:
        if (!((Iterator) (obj)).hasNext())
        {
            return;
        }
        break MISSING_BLOCK_LABEL_156;
_L2:
        ((List) (obj)).add(createEntityWithRandomPk());
        i++;
          goto _L3
        Object obj1 = (Object)((Iterator) (obj)).next();
        obj1 = daoAccess.getKey(obj1);
        assertNotNull(obj1);
        assertNull(dao.load(obj1));
          goto _L4
    }

    public void testInsertAndLoad()
    {
        Object obj1 = nextPk();
        Object obj = createEntity(obj1);
        dao.insert(obj);
        assertEquals(obj1, daoAccess.getKey(obj));
        obj1 = dao.load(obj1);
        assertNotNull(obj1);
        assertEquals(daoAccess.getKey(obj), daoAccess.getKey(obj1));
    }

    public void testInsertInTx()
    {
        dao.deleteAll();
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            if (i >= 20)
            {
                dao.insertInTx(arraylist);
                assertEquals(arraylist.size(), dao.count());
                return;
            }
            arraylist.add(createEntityWithRandomPk());
            i++;
        } while (true);
    }

    public void testInsertOrReplaceInTx()
    {
        dao.deleteAll();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        int i = 0;
        do
        {
            if (i >= 20)
            {
                dao.insertOrReplaceInTx(arraylist);
                dao.insertOrReplaceInTx(arraylist1);
                assertEquals(arraylist1.size(), dao.count());
                return;
            }
            Object obj = createEntityWithRandomPk();
            if (i % 2 == 0)
            {
                arraylist.add(obj);
            }
            arraylist1.add(obj);
            i++;
        } while (true);
    }

    public void testInsertOrReplaceTwice()
    {
        Object obj = createEntityWithRandomPk();
        long l = dao.insert(obj);
        long l1 = dao.insertOrReplace(obj);
        if (dao.getPkProperty().type == java/lang/Long)
        {
            assertEquals(l, l1);
        }
    }

    public void testInsertTwice()
    {
        Object obj = createEntity(nextPk());
        dao.insert(obj);
        try
        {
            dao.insert(obj);
            fail("Inserting twice should not work");
            return;
        }
        catch (SQLException sqlexception)
        {
            return;
        }
    }

    public void testLoadAll()
    {
        dao.deleteAll();
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            if (i >= 15)
            {
                dao.insertInTx(arraylist);
                List list = dao.loadAll();
                assertEquals(arraylist.size(), list.size());
                return;
            }
            arraylist.add(createEntity(nextPk()));
            i++;
        } while (true);
    }

    public void testLoadPk()
    {
        runLoadPkTest(0);
    }

    public void testLoadPkWithOffset()
    {
        runLoadPkTest(10);
    }

    public void testQuery()
    {
        dao.insert(createEntityWithRandomPk());
        Object obj = nextPk();
        dao.insert(createEntity(obj));
        dao.insert(createEntityWithRandomPk());
        Object obj1 = (new StringBuilder("WHERE ")).append(dao.getPkColumns()[0]).append("=?").toString();
        obj1 = dao.queryRaw(((String) (obj1)), new String[] {
            obj.toString()
        });
        assertEquals(1, ((List) (obj1)).size());
        assertEquals(obj, daoAccess.getKey(((List) (obj1)).get(0)));
    }

    public void testReadWithOffset()
    {
        Object obj;
        Object obj1;
        obj = nextPk();
        obj1 = createEntity(obj);
        dao.insert(obj1);
        obj1 = queryWithDummyColumnsInFront(5, "42", obj);
        Object obj2 = daoAccess.readEntity(((Cursor) (obj1)), 5);
        assertEquals(obj, daoAccess.getKey(obj2));
        ((Cursor) (obj1)).close();
        return;
        Exception exception;
        exception;
        ((Cursor) (obj1)).close();
        throw exception;
    }

    public void testRowId()
    {
        Object obj = createEntityWithRandomPk();
        Object obj1 = createEntityWithRandomPk();
        boolean flag;
        if (dao.insert(obj) != dao.insert(obj1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        assertTrue(flag);
    }

    public void testUpdate()
    {
        dao.deleteAll();
        Object obj = createEntityWithRandomPk();
        dao.insert(obj);
        dao.update(obj);
        assertEquals(1L, dao.count());
    }
}
