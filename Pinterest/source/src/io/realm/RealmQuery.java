// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.internal.ColumnType;
import io.realm.internal.LinkView;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.TableQuery;
import io.realm.internal.TableView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package io.realm:
//            Realm, RealmResults, RealmObject

public class RealmQuery
{

    public static final boolean CASE_INSENSITIVE = false;
    public static final boolean CASE_SENSITIVE = true;
    private static final String LINK_NOT_SUPPORTED_METHOD = "'%s' is not supported for link queries";
    private Class clazz;
    private Map columns;
    private TableQuery query;
    private Realm realm;
    private Table table;
    private LinkView view;

    RealmQuery(Realm realm1, LinkView linkview, Class class1)
    {
        columns = new HashMap();
        realm = realm1;
        clazz = class1;
        query = linkview.where();
        view = linkview;
        table = realm1.getTable(class1);
        columns = (Map)Realm.columnIndices.get(class1.getSimpleName());
    }

    public RealmQuery(Realm realm1, Class class1)
    {
        columns = new HashMap();
        realm = realm1;
        clazz = class1;
        table = realm1.getTable(class1);
        query = table.where();
        columns = (Map)Realm.columnIndices.get(class1.getSimpleName());
    }

    public RealmQuery(RealmResults realmresults, Class class1)
    {
        columns = new HashMap();
        realm = realmresults.getRealm();
        clazz = class1;
        table = realm.getTable(class1);
        query = realmresults.getTable().where();
        columns = (Map)Realm.columnIndices.get(class1.getSimpleName());
    }

    private boolean containsDot(String s)
    {
        return s.indexOf('.') != -1;
    }

    private long[] getColumnIndices(String s, ColumnType columntype)
    {
        Object obj = table;
        if (containsDot(s))
        {
            String as[] = splitString(s);
            long al[] = new long[as.length];
            int i = 0;
            s = ((String) (obj));
            while (i < as.length - 1) 
            {
                long l = s.getColumnIndex(as[i]);
                if (l < 0L)
                {
                    throw new IllegalArgumentException((new StringBuilder("Invalid query: ")).append(as[i]).append(" does not refer to a class.").toString());
                }
                obj = s.getColumnType(l);
                if (obj == ColumnType.LINK || obj == ColumnType.LINK_LIST)
                {
                    s = s.getLinkTarget(l);
                    al[i] = l;
                    i++;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder("Invalid query: ")).append(as[i]).append(" does not refer to a class.").toString());
                }
            }
            al[as.length - 1] = s.getColumnIndex(as[as.length - 1]);
            if (columntype != s.getColumnType(al[as.length - 1]))
            {
                throw new IllegalArgumentException(String.format("Field '%s': type mismatch.", new Object[] {
                    as[as.length - 1]
                }));
            } else
            {
                return al;
            }
        }
        if (columns.get(s) == null)
        {
            throw new IllegalArgumentException(String.format("Field '%s' does not exist.", new Object[] {
                s
            }));
        }
        obj = ((Table) (obj)).getColumnType(((Long)columns.get(s)).longValue());
        if (columntype != obj)
        {
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch. Was %s, expected %s.", new Object[] {
                s, columntype, obj
            }));
        } else
        {
            return (new long[] {
                ((Long)columns.get(s)).longValue()
            });
        }
    }

    private String[] splitString(String s)
    {
        boolean flag = false;
        int k = 0;
        for (int i = 0; i < s.length();)
        {
            int l = k;
            if (s.charAt(i) == '.')
            {
                l = k + 1;
            }
            i++;
            k = l;
        }

        String as[] = new String[k + 1];
        k = s.indexOf('.');
        int i1 = 0;
        int j;
        for (j = ((flag) ? 1 : 0); k != -1; j++)
        {
            as[j] = s.substring(i1, k);
            i1 = k + 1;
            k = s.indexOf('.', i1);
        }

        as[j] = s.substring(s.lastIndexOf('.') + 1);
        return as;
    }

    public double averageDouble(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.averageDouble(l);
    }

    public double averageFloat(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.averageFloat(l);
    }

    public double averageInt(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.averageInt(l);
    }

    public RealmQuery beginGroup()
    {
        query.group();
        return this;
    }

    public RealmQuery beginsWith(String s, String s1)
    {
        return beginsWith(s, s1, true);
    }

    public RealmQuery beginsWith(String s, String s1, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.STRING);
        query.beginsWith(s, s1, flag);
        return this;
    }

    public RealmQuery between(String s, double d, double d1)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.between(s, d, d1);
        return this;
    }

    public RealmQuery between(String s, float f, float f1)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.between(s, f, f1);
        return this;
    }

    public RealmQuery between(String s, int i, int j)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.between(s, i, j);
        return this;
    }

    public RealmQuery between(String s, long l, long l1)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.between(s, l, l1);
        return this;
    }

    public RealmQuery between(String s, Date date, Date date1)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.between(s, date, date1);
        return this;
    }

    public RealmQuery contains(String s, String s1)
    {
        return contains(s, s1, true);
    }

    public RealmQuery contains(String s, String s1, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.STRING);
        query.contains(s, s1, flag);
        return this;
    }

    public long count()
    {
        return query.count();
    }

    public RealmQuery endGroup()
    {
        query.endGroup();
        return this;
    }

    public RealmQuery endsWith(String s, String s1)
    {
        return endsWith(s, s1, true);
    }

    public RealmQuery endsWith(String s, String s1, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.STRING);
        query.endsWith(s, s1, flag);
        return this;
    }

    public RealmQuery equalTo(String s, double d)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.equalTo(s, d);
        return this;
    }

    public RealmQuery equalTo(String s, float f)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.equalTo(s, f);
        return this;
    }

    public RealmQuery equalTo(String s, int i)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.equalTo(s, i);
        return this;
    }

    public RealmQuery equalTo(String s, long l)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.equalTo(s, l);
        return this;
    }

    public RealmQuery equalTo(String s, String s1)
    {
        return equalTo(s, s1, true);
    }

    public RealmQuery equalTo(String s, String s1, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.STRING);
        query.equalTo(s, s1, flag);
        return this;
    }

    public RealmQuery equalTo(String s, Date date)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.equalTo(s, date);
        return this;
    }

    public RealmQuery equalTo(String s, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.BOOLEAN);
        query.equalTo(s, flag);
        return this;
    }

    public RealmResults findAll()
    {
        return new RealmResults(realm, query.findAll(), clazz);
    }

    public RealmResults findAllSorted(String s)
    {
        return findAllSorted(s, true);
    }

    public RealmResults findAllSorted(String s, boolean flag)
    {
        TableView tableview = query.findAll();
        io.realm.internal.TableView.Order order;
        Long long1;
        if (flag)
        {
            order = io.realm.internal.TableView.Order.ascending;
        } else
        {
            order = io.realm.internal.TableView.Order.descending;
        }
        long1 = (Long)columns.get(s);
        if (long1 == null || long1.longValue() < 0L)
        {
            throw new IllegalArgumentException(String.format("Field name '%s' does not exist.", new Object[] {
                s
            }));
        } else
        {
            tableview.sort(long1.longValue(), order);
            return new RealmResults(realm, tableview, clazz);
        }
    }

    public RealmResults findAllSorted(String s, boolean flag, String s1, boolean flag1)
    {
        return findAllSorted(new String[] {
            s, s1
        }, new boolean[] {
            flag, flag1
        });
    }

    public RealmResults findAllSorted(String s, boolean flag, String s1, boolean flag1, String s2, boolean flag2)
    {
        return findAllSorted(new String[] {
            s, s1, s2
        }, new boolean[] {
            flag, flag1, flag2
        });
    }

    public RealmResults findAllSorted(String as[], boolean aflag[])
    {
        boolean flag = false;
        if (as == null)
        {
            throw new IllegalArgumentException("fieldNames cannot be 'null'.");
        }
        if (aflag == null)
        {
            throw new IllegalArgumentException("sortAscending cannot be 'null'.");
        }
        if (as.length == 0)
        {
            throw new IllegalArgumentException("At least one field name must be specified.");
        }
        if (as.length != aflag.length)
        {
            throw new IllegalArgumentException(String.format("Number of field names (%d) and sort orders (%d) does not match.", new Object[] {
                Integer.valueOf(as.length), Integer.valueOf(aflag.length)
            }));
        }
        if (as.length == 1 && aflag.length == 1)
        {
            return findAllSorted(as[0], aflag[0]);
        }
        TableView tableview = query.findAll();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        int i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= as.length)
            {
                break;
            }
            String s = as[i];
            Long long1 = (Long)columns.get(s);
            if (long1 == null || long1.longValue() < 0L)
            {
                throw new IllegalArgumentException(String.format("Field name '%s' does not exist.", new Object[] {
                    s
                }));
            }
            arraylist.add(long1);
            i++;
        } while (true);
        while (j < aflag.length) 
        {
            if (aflag[j])
            {
                as = io.realm.internal.TableView.Order.ascending;
            } else
            {
                as = io.realm.internal.TableView.Order.descending;
            }
            arraylist1.add(as);
            j++;
        }
        tableview.sort(arraylist, arraylist1);
        return new RealmResults(realm, tableview, clazz);
    }

    public RealmObject findFirst()
    {
        long l1 = query.find();
        if (l1 >= 0L)
        {
            Realm realm1 = realm;
            Class class1 = clazz;
            long l = l1;
            if (view != null)
            {
                l = view.getTargetRowIndex(l1);
            }
            return realm1.get(class1, l);
        } else
        {
            return null;
        }
    }

    public RealmQuery greaterThan(String s, double d)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.greaterThan(s, d);
        return this;
    }

    public RealmQuery greaterThan(String s, float f)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.greaterThan(s, f);
        return this;
    }

    public RealmQuery greaterThan(String s, int i)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.greaterThan(s, i);
        return this;
    }

    public RealmQuery greaterThan(String s, long l)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.greaterThan(s, l);
        return this;
    }

    public RealmQuery greaterThan(String s, Date date)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.greaterThan(s, date);
        return this;
    }

    public RealmQuery greaterThanOrEqualTo(String s, double d)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.greaterThanOrEqual(s, d);
        return this;
    }

    public RealmQuery greaterThanOrEqualTo(String s, float f)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.greaterThanOrEqual(s, f);
        return this;
    }

    public RealmQuery greaterThanOrEqualTo(String s, int i)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.greaterThanOrEqual(s, i);
        return this;
    }

    public RealmQuery greaterThanOrEqualTo(String s, long l)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.greaterThanOrEqual(s, l);
        return this;
    }

    public RealmQuery greaterThanOrEqualTo(String s, Date date)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.greaterThanOrEqual(s, date);
        return this;
    }

    public RealmQuery lessThan(String s, double d)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.lessThan(s, d);
        return this;
    }

    public RealmQuery lessThan(String s, float f)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.lessThan(s, f);
        return this;
    }

    public RealmQuery lessThan(String s, int i)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.lessThan(s, i);
        return this;
    }

    public RealmQuery lessThan(String s, long l)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.lessThan(s, l);
        return this;
    }

    public RealmQuery lessThan(String s, Date date)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.lessThan(s, date);
        return this;
    }

    public RealmQuery lessThanOrEqualTo(String s, double d)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.lessThanOrEqual(s, d);
        return this;
    }

    public RealmQuery lessThanOrEqualTo(String s, float f)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.lessThanOrEqual(s, f);
        return this;
    }

    public RealmQuery lessThanOrEqualTo(String s, int i)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.lessThanOrEqual(s, i);
        return this;
    }

    public RealmQuery lessThanOrEqualTo(String s, long l)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.lessThanOrEqual(s, l);
        return this;
    }

    public RealmQuery lessThanOrEqualTo(String s, Date date)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.lessThanOrEqual(s, date);
        return this;
    }

    public Date maximumDate(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.maximumDate(l);
    }

    public double maximumDouble(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.maximumDouble(l);
    }

    public float maximumFloat(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.maximumFloat(l);
    }

    public long maximumInt(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.maximumInt(l);
    }

    public Date minimumDate(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.minimumDate(l);
    }

    public double minimumDouble(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.minimumDouble(l);
    }

    public float minimumFloat(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.minimumFloat(l);
    }

    public long minimumInt(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.minimumInt(l);
    }

    public RealmQuery not()
    {
        query.not();
        return this;
    }

    public RealmQuery notEqualTo(String s, double d)
    {
        s = getColumnIndices(s, ColumnType.DOUBLE);
        query.notEqualTo(s, d);
        return this;
    }

    public RealmQuery notEqualTo(String s, float f)
    {
        s = getColumnIndices(s, ColumnType.FLOAT);
        query.notEqualTo(s, f);
        return this;
    }

    public RealmQuery notEqualTo(String s, int i)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.notEqualTo(s, i);
        return this;
    }

    public RealmQuery notEqualTo(String s, long l)
    {
        s = getColumnIndices(s, ColumnType.INTEGER);
        query.notEqualTo(s, l);
        return this;
    }

    public RealmQuery notEqualTo(String s, String s1)
    {
        return notEqualTo(s, s1, true);
    }

    public RealmQuery notEqualTo(String s, String s1, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.STRING);
        if (s.length > 1 && !flag)
        {
            throw new IllegalArgumentException("Link queries cannot be case insensitive - coming soon.");
        } else
        {
            query.notEqualTo(s, s1, flag);
            return this;
        }
    }

    public RealmQuery notEqualTo(String s, Date date)
    {
        s = getColumnIndices(s, ColumnType.DATE);
        query.notEqualTo(s, date);
        return this;
    }

    public RealmQuery notEqualTo(String s, boolean flag)
    {
        s = getColumnIndices(s, ColumnType.BOOLEAN);
        TableQuery tablequery = query;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tablequery.equalTo(s, flag);
        return this;
    }

    public RealmQuery or()
    {
        query.or();
        return this;
    }

    public double sumDouble(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.sumDouble(l);
    }

    public double sumFloat(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.sumFloat(l);
    }

    public long sumInt(String s)
    {
        long l = ((Long)columns.get(s)).longValue();
        return query.sumInt(l);
    }
}
