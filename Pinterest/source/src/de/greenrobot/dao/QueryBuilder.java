// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package de.greenrobot.dao:
//            WhereCondition, Property, AbstractDao, TableStatements, 
//            SqlUtils, DaoLog, Query, CountQuery, 
//            DeleteQuery, DaoException, CloseableListIterator, LazyList

public class QueryBuilder
{

    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;
    private final AbstractDao dao;
    private StringBuilder joinBuilder;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBuilder;
    private final String tablePrefix;
    private final List values;
    private final List whereConditions;

    protected QueryBuilder(AbstractDao abstractdao)
    {
        this(abstractdao, "T");
    }

    protected QueryBuilder(AbstractDao abstractdao, String s)
    {
        dao = abstractdao;
        tablePrefix = s;
        values = new ArrayList();
        whereConditions = new ArrayList();
    }

    private void appendWhereClause(StringBuilder stringbuilder, String s)
    {
        values.clear();
        if (whereConditions.isEmpty()) goto _L2; else goto _L1
_L1:
        ListIterator listiterator;
        stringbuilder.append(" WHERE ");
        listiterator = whereConditions.listIterator();
_L5:
        if (listiterator.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        if (listiterator.hasPrevious())
        {
            stringbuilder.append(" AND ");
        }
        WhereCondition wherecondition = (WhereCondition)listiterator.next();
        wherecondition.appendTo(stringbuilder, s);
        wherecondition.appendValuesTo(values);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void checkOrderBuilder()
    {
        if (orderBuilder == null)
        {
            orderBuilder = new StringBuilder();
        } else
        if (orderBuilder.length() > 0)
        {
            orderBuilder.append(",");
            return;
        }
    }

    private transient void orderAscOrDesc(String s, Property aproperty[])
    {
        int j = aproperty.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Property property = aproperty[i];
            checkOrderBuilder();
            append(orderBuilder, property);
            if (java/lang/String.equals(property.type))
            {
                orderBuilder.append(" COLLATE LOCALIZED");
            }
            orderBuilder.append(s);
            i++;
        } while (true);
    }

    protected void addCondition(StringBuilder stringbuilder, List list1, WhereCondition wherecondition)
    {
        checkCondition(wherecondition);
        wherecondition.appendTo(stringbuilder, tablePrefix);
        wherecondition.appendValuesTo(list1);
    }

    public transient WhereCondition and(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        return combineWhereConditions(" AND ", wherecondition, wherecondition1, awherecondition);
    }

    protected StringBuilder append(StringBuilder stringbuilder, Property property)
    {
        checkProperty(property);
        stringbuilder.append(tablePrefix).append('.').append('\'').append(property.columnName).append('\'');
        return stringbuilder;
    }

    public Query build()
    {
        Object obj;
        int i;
        if (joinBuilder == null || joinBuilder.length() == 0)
        {
            obj = dao.getStatements().getSelectAll();
        } else
        {
            obj = SqlUtils.createSqlSelect(dao.getTablename(), tablePrefix, dao.getAllColumns());
        }
        obj = new StringBuilder(((String) (obj)));
        appendWhereClause(((StringBuilder) (obj)), tablePrefix);
        if (orderBuilder != null && orderBuilder.length() > 0)
        {
            ((StringBuilder) (obj)).append(" ORDER BY ").append(orderBuilder);
        }
        int j;
        if (limit != null)
        {
            ((StringBuilder) (obj)).append(" LIMIT ?");
            values.add(limit);
            i = values.size() - 1;
        } else
        {
            i = -1;
        }
        if (offset != null)
        {
            if (limit == null)
            {
                throw new IllegalStateException("Offset cannot be set without limit");
            }
            ((StringBuilder) (obj)).append(" OFFSET ?");
            values.add(offset);
            j = values.size() - 1;
        } else
        {
            j = -1;
        }
        obj = ((StringBuilder) (obj)).toString();
        if (LOG_SQL)
        {
            DaoLog.d((new StringBuilder("Built SQL for query: ")).append(((String) (obj))).toString());
        }
        if (LOG_VALUES)
        {
            DaoLog.d((new StringBuilder("Values for query: ")).append(values).toString());
        }
        obj = new Query(dao, ((String) (obj)), values);
        if (i != -1)
        {
            ((Query) (obj)).setLimitPosition(i);
        }
        if (j != -1)
        {
            ((Query) (obj)).setOffsetPosition(j);
        }
        return ((Query) (obj));
    }

    public CountQuery buildCount()
    {
        String s = dao.getTablename();
        StringBuilder stringbuilder = new StringBuilder(SqlUtils.createSqlSelectCountStar(s));
        appendWhereClause(stringbuilder, s);
        s = stringbuilder.toString();
        if (LOG_SQL)
        {
            DaoLog.d((new StringBuilder("Built SQL for count query: ")).append(s).toString());
        }
        if (LOG_VALUES)
        {
            DaoLog.d((new StringBuilder("Values for count query: ")).append(values).toString());
        }
        return new CountQuery(dao, s, values);
    }

    public DeleteQuery buildDelete()
    {
        String s = dao.getTablename();
        StringBuilder stringbuilder = new StringBuilder(SqlUtils.createSqlDelete(s, null));
        appendWhereClause(stringbuilder, s);
        s = stringbuilder.toString();
        if (LOG_SQL)
        {
            DaoLog.d((new StringBuilder("Built SQL for delete query: ")).append(s).toString());
        }
        if (LOG_VALUES)
        {
            DaoLog.d((new StringBuilder("Values for delete query: ")).append(values).toString());
        }
        return new DeleteQuery(dao, s, values);
    }

    protected void checkCondition(WhereCondition wherecondition)
    {
        if (wherecondition instanceof WhereCondition.PropertyCondition)
        {
            checkProperty(((WhereCondition.PropertyCondition)wherecondition).property);
        }
    }

    protected void checkProperty(Property property)
    {
        boolean flag = false;
        if (dao == null) goto _L2; else goto _L1
_L1:
        Property aproperty[];
        int i;
        int j;
        aproperty = dao.getProperties();
        j = aproperty.length;
        i = 0;
_L7:
        if (i < j) goto _L4; else goto _L3
_L3:
        i = ((flag) ? 1 : 0);
_L6:
        if (i == 0)
        {
            throw new DaoException((new StringBuilder("Property '")).append(property.name).append("' is not part of ").append(dao).toString());
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (property != aproperty[i])
        {
            break; /* Loop/switch isn't completed */
        }
        i = 1;
        if (true) goto _L6; else goto _L5
_L5:
        i++;
        if (true) goto _L7; else goto _L2
_L2:
    }

    protected transient WhereCondition combineWhereConditions(String s, WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        StringBuilder stringbuilder = new StringBuilder("(");
        ArrayList arraylist = new ArrayList();
        addCondition(stringbuilder, arraylist, wherecondition);
        stringbuilder.append(s);
        addCondition(stringbuilder, arraylist, wherecondition1);
        int j = awherecondition.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                stringbuilder.append(')');
                return new WhereCondition.StringCondition(stringbuilder.toString(), arraylist.toArray());
            }
            wherecondition = awherecondition[i];
            stringbuilder.append(s);
            addCondition(stringbuilder, arraylist, wherecondition);
            i++;
        } while (true);
    }

    public long count()
    {
        return buildCount().count();
    }

    public QueryBuilder join(Class class1, Property property)
    {
        throw new UnsupportedOperationException();
    }

    public QueryBuilder joinToMany(Class class1, Property property)
    {
        throw new UnsupportedOperationException();
    }

    public QueryBuilder limit(int i)
    {
        limit = Integer.valueOf(i);
        return this;
    }

    public List list()
    {
        return build().list();
    }

    public CloseableListIterator listIterator()
    {
        return build().listIterator();
    }

    public LazyList listLazy()
    {
        return build().listLazy();
    }

    public LazyList listLazyUncached()
    {
        return build().listLazyUncached();
    }

    public QueryBuilder offset(int i)
    {
        offset = Integer.valueOf(i);
        return this;
    }

    public transient WhereCondition or(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        return combineWhereConditions(" OR ", wherecondition, wherecondition1, awherecondition);
    }

    public transient QueryBuilder orderAsc(Property aproperty[])
    {
        orderAscOrDesc(" ASC", aproperty);
        return this;
    }

    public QueryBuilder orderCustom(Property property, String s)
    {
        checkOrderBuilder();
        append(orderBuilder, property).append(' ');
        orderBuilder.append(s);
        return this;
    }

    public transient QueryBuilder orderDesc(Property aproperty[])
    {
        orderAscOrDesc(" DESC", aproperty);
        return this;
    }

    public QueryBuilder orderRaw(String s)
    {
        checkOrderBuilder();
        orderBuilder.append(s);
        return this;
    }

    public Object unique()
    {
        return build().unique();
    }

    public Object uniqueOrThrow()
    {
        return build().uniqueOrThrow();
    }

    public transient QueryBuilder where(WhereCondition wherecondition, WhereCondition awherecondition[])
    {
        whereConditions.add(wherecondition);
        int j = awherecondition.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return this;
            }
            wherecondition = awherecondition[i];
            checkCondition(wherecondition);
            whereConditions.add(wherecondition);
            i++;
        } while (true);
    }

    public transient QueryBuilder whereOr(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition awherecondition[])
    {
        whereConditions.add(or(wherecondition, wherecondition1, awherecondition));
        return this;
    }
}
