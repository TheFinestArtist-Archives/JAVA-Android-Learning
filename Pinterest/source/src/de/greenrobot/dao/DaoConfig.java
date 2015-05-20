// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package de.greenrobot.dao:
//            TableStatements, Property, DaoException, IdentityScopeType, 
//            IdentityScopeLong, IdentityScopeObject, IdentityScope

public final class DaoConfig
    implements Cloneable
{

    final String allColumns[];
    final SQLiteDatabase db;
    private IdentityScope identityScope;
    final boolean keyIsNumeric;
    final String nonPkColumns[];
    final String pkColumns[];
    final Property pkProperty;
    final Property properties[];
    final TableStatements statements;
    final String tablename;

    DaoConfig(SQLiteDatabase sqlitedatabase, Class class1)
    {
        int i;
        boolean flag;
        db = sqlitedatabase;
        Property property;
        Property aproperty[];
        ArrayList arraylist;
        ArrayList arraylist1;
        String s;
        try
        {
            tablename = (String)class1.getField("TABLENAME").get(null);
            aproperty = reflectProperties(class1);
            properties = aproperty;
            allColumns = new String[aproperty.length];
            arraylist = new ArrayList();
            arraylist1 = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            throw new DaoException("Could not init DAOConfig", sqlitedatabase);
        }
        i = 0;
        class1 = null;
_L2:
        if (i < aproperty.length)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        nonPkColumns = (String[])arraylist1.toArray(new String[arraylist1.size()]);
        pkColumns = (String[])arraylist.toArray(new String[arraylist.size()]);
        if (pkColumns.length != 1)
        {
            class1 = null;
        }
        pkProperty = class1;
        statements = new TableStatements(sqlitedatabase, tablename, allColumns, pkColumns);
        if (pkProperty == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        sqlitedatabase = pkProperty.type;
        if (!sqlitedatabase.equals(Long.TYPE) && !sqlitedatabase.equals(java/lang/Long) && !sqlitedatabase.equals(Integer.TYPE) && !sqlitedatabase.equals(java/lang/Integer) && !sqlitedatabase.equals(Short.TYPE) && !sqlitedatabase.equals(java/lang/Short) && !sqlitedatabase.equals(Byte.TYPE) && !sqlitedatabase.equals(java/lang/Byte))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        keyIsNumeric = flag;
        return;
        property = aproperty[i];
        s = property.columnName;
        allColumns[i] = s;
        if (!property.primaryKey)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        arraylist.add(s);
        class1 = property;
        break MISSING_BLOCK_LABEL_340;
        arraylist1.add(s);
        break MISSING_BLOCK_LABEL_340;
        keyIsNumeric = false;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    DaoConfig(DaoConfig daoconfig)
    {
        db = daoconfig.db;
        tablename = daoconfig.tablename;
        properties = daoconfig.properties;
        allColumns = daoconfig.allColumns;
        pkColumns = daoconfig.pkColumns;
        nonPkColumns = daoconfig.nonPkColumns;
        pkProperty = daoconfig.pkProperty;
        statements = daoconfig.statements;
        keyIsNumeric = daoconfig.keyIsNumeric;
    }

    private static Property[] reflectProperties(Class class1)
    {
        Object aobj[];
        int i;
        int j;
        aobj = Class.forName((new StringBuilder(String.valueOf(class1.getName()))).append("$Properties").toString()).getDeclaredFields();
        class1 = new ArrayList();
        j = aobj.length;
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        aobj = new Property[class1.size()];
        class1 = class1.iterator();
_L4:
        if (!class1.hasNext())
        {
            return ((Property []) (aobj));
        }
        break MISSING_BLOCK_LABEL_118;
_L2:
        Object obj = aobj[i];
        if ((((Field) (obj)).getModifiers() & 9) == 9)
        {
            obj = ((Field) (obj)).get(null);
            if (obj instanceof Property)
            {
                class1.add((Property)obj);
            }
        }
        i++;
          goto _L3
        Property property = (Property)class1.next();
        if (aobj[property.ordinal] != null)
        {
            throw new DaoException("Duplicate property ordinals");
        }
        aobj[property.ordinal] = property;
          goto _L4
    }

    public final DaoConfig clone()
    {
        return new DaoConfig(this);
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final IdentityScope getIdentityScope()
    {
        return identityScope;
    }

    public final void initIdentityScope(IdentityScopeType identityscopetype)
    {
        if (identityscopetype == IdentityScopeType.None)
        {
            identityScope = null;
            return;
        }
        if (identityscopetype == IdentityScopeType.Session)
        {
            if (keyIsNumeric)
            {
                identityScope = new IdentityScopeLong();
                return;
            } else
            {
                identityScope = new IdentityScopeObject();
                return;
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unsupported type: ")).append(identityscopetype).toString());
        }
    }

    final void setIdentityScope(IdentityScope identityscope)
    {
        identityScope = identityscope;
    }
}
