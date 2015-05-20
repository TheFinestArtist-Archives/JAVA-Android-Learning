// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.internal.ColumnType;
import io.realm.internal.TableOrView;
import io.realm.internal.TableView;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package io.realm:
//            RealmObject, Realm, RealmQuery

public class RealmResults extends AbstractList
{

    public static final boolean SORT_ORDER_ASCENDING = true;
    public static final boolean SORT_ORDER_DESCENDING = false;
    private static final String TYPE_MISMATCH = "Field '%s': type mismatch - %s expected.";
    private Class classSpec;
    private long currentTableViewVersion;
    private Realm realm;
    private TableOrView table;

    RealmResults(Realm realm1, TableOrView tableorview, Class class1)
    {
        this(realm1, class1);
        table = tableorview;
    }

    RealmResults(Realm realm1, Class class1)
    {
        table = null;
        currentTableViewVersion = -1L;
        realm = realm1;
        classSpec = class1;
    }

    private void assertRealmIsStable()
    {
        long l = table.sync();
        if (currentTableViewVersion > -1L && l != currentTableViewVersion)
        {
            throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a RealmResults. Use iterators methods instead.");
        } else
        {
            currentTableViewVersion = l;
            return;
        }
    }

    private long getColumnIndex(String s)
    {
        if (s.contains("."))
        {
            throw new IllegalArgumentException((new StringBuilder("Sorting using child object properties is not supported: ")).append(s).toString());
        }
        long l = table.getColumnIndex(s);
        if (l < 0L)
        {
            throw new IllegalArgumentException(String.format("Field '%s' does not exist.", new Object[] {
                s
            }));
        } else
        {
            return l;
        }
    }

    public void add(int i, RealmObject realmobject)
    {
        throw new UnsupportedOperationException();
    }

    public volatile void add(int i, Object obj)
    {
        add(i, (RealmObject)obj);
    }

    public boolean add(RealmObject realmobject)
    {
        throw new UnsupportedOperationException();
    }

    public volatile boolean add(Object obj)
    {
        return add((RealmObject)obj);
    }

    public double average(String s)
    {
        realm.checkIfValid();
        long l = table.getColumnIndex(s);
        switch (_cls1..SwitchMap.io.realm.internal.ColumnType[table.getColumnType(l).ordinal()])
        {
        default:
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch - %s expected.", new Object[] {
                s, "int, float or double"
            }));

        case 1: // '\001'
            return table.averageLong(l);

        case 3: // '\003'
            return table.averageDouble(l);

        case 2: // '\002'
            return table.averageFloat(l);
        }
    }

    public void clear()
    {
        getTable().clear();
    }

    public RealmObject first()
    {
        return get(0);
    }

    public RealmObject get(int i)
    {
        realm.checkIfValid();
        TableOrView tableorview = getTable();
        if (tableorview instanceof TableView)
        {
            return realm.get(classSpec, ((TableView)tableorview).getSourceRowIndex(i));
        } else
        {
            return realm.get(classSpec, i);
        }
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    Realm getRealm()
    {
        return realm;
    }

    TableOrView getTable()
    {
        if (table == null)
        {
            return realm.getTable(classSpec);
        } else
        {
            return table;
        }
    }

    public int indexOf(Object obj)
    {
        throw new NoSuchMethodError("indexOf is not supported on RealmResults");
    }

    public Iterator iterator()
    {
        return new RealmResultsIterator();
    }

    public RealmObject last()
    {
        return get(size() - 1);
    }

    public ListIterator listIterator()
    {
        return new RealmResultsListIterator(0);
    }

    public ListIterator listIterator(int i)
    {
        return new RealmResultsListIterator(i);
    }

    public Number max(String s)
    {
        realm.checkIfValid();
        long l = table.getColumnIndex(s);
        switch (_cls1..SwitchMap.io.realm.internal.ColumnType[table.getColumnType(l).ordinal()])
        {
        default:
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch - %s expected.", new Object[] {
                s, "int, float or double"
            }));

        case 1: // '\001'
            return Long.valueOf(table.maximumLong(l));

        case 2: // '\002'
            return Float.valueOf(table.maximumFloat(l));

        case 3: // '\003'
            return Double.valueOf(table.maximumDouble(l));
        }
    }

    public Date maxDate(String s)
    {
        realm.checkIfValid();
        long l = table.getColumnIndex(s);
        if (table.getColumnType(l) == ColumnType.DATE)
        {
            return table.maximumDate(l);
        } else
        {
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch - %s expected.", new Object[] {
                s, "Date"
            }));
        }
    }

    public Number min(String s)
    {
        realm.checkIfValid();
        long l = table.getColumnIndex(s);
        switch (_cls1..SwitchMap.io.realm.internal.ColumnType[table.getColumnType(l).ordinal()])
        {
        default:
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch - %s expected.", new Object[] {
                s, "int, float or double"
            }));

        case 1: // '\001'
            return Long.valueOf(table.minimumLong(l));

        case 2: // '\002'
            return Float.valueOf(table.minimumFloat(l));

        case 3: // '\003'
            return Double.valueOf(table.minimumDouble(l));
        }
    }

    public Date minDate(String s)
    {
        realm.checkIfValid();
        long l = table.getColumnIndex(s);
        if (table.getColumnType(l) == ColumnType.DATE)
        {
            return table.minimumDate(l);
        } else
        {
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch - %s expected.", new Object[] {
                s, "Date"
            }));
        }
    }

    public RealmObject remove(int i)
    {
        getTable().remove(i);
        return null;
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public void removeLast()
    {
        getTable().removeLast();
    }

    public int size()
    {
        return Long.valueOf(getTable().size()).intValue();
    }

    public void sort(String s)
    {
        sort(s, true);
    }

    public void sort(String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("fieldName must be provided");
        }
        realm.checkIfValid();
        TableOrView tableorview = getTable();
        if (tableorview instanceof TableView)
        {
            long l = getColumnIndex(s);
            if (flag)
            {
                s = io.realm.internal.TableView.Order.ascending;
            } else
            {
                s = io.realm.internal.TableView.Order.descending;
            }
            ((TableView)tableorview).sort(l, s);
            return;
        } else
        {
            throw new IllegalArgumentException("Only RealmResults can be sorted - please use allObject() to create a RealmResults.");
        }
    }

    public void sort(String s, boolean flag, String s1, boolean flag1)
    {
        sort(new String[] {
            s, s1
        }, new boolean[] {
            flag, flag1
        });
    }

    public void sort(String s, boolean flag, String s1, boolean flag1, String s2, boolean flag2)
    {
        sort(new String[] {
            s, s1, s2
        }, new boolean[] {
            flag, flag1, flag2
        });
    }

    public void sort(String as[], boolean aflag[])
    {
        boolean flag = false;
        if (as == null)
        {
            throw new IllegalArgumentException("fieldNames must be provided.");
        }
        if (aflag == null)
        {
            throw new IllegalArgumentException("sortAscending must be provided.");
        }
        if (as.length == 1 && aflag.length == 1)
        {
            sort(as[0], aflag[0]);
        } else
        {
            realm.checkIfValid();
            TableOrView tableorview = getTable();
            if (tableorview instanceof TableView)
            {
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
                    arraylist1.add(Long.valueOf(getColumnIndex(as[i])));
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
                    arraylist.add(as);
                    j++;
                }
                ((TableView)tableorview).sort(arraylist1, arraylist);
                return;
            }
        }
    }

    public Number sum(String s)
    {
        realm.checkIfValid();
        long l = table.getColumnIndex(s);
        switch (_cls1..SwitchMap.io.realm.internal.ColumnType[table.getColumnType(l).ordinal()])
        {
        default:
            throw new IllegalArgumentException(String.format("Field '%s': type mismatch - %s expected.", new Object[] {
                s, "int, float or double"
            }));

        case 1: // '\001'
            return Long.valueOf(table.sumLong(l));

        case 2: // '\002'
            return Double.valueOf(table.sumFloat(l));

        case 3: // '\003'
            return Double.valueOf(table.sumDouble(l));
        }
    }

    public RealmQuery where()
    {
        realm.checkIfValid();
        return new RealmQuery(this, classSpec);
    }


/*
    static long access$002(RealmResults realmresults, long l)
    {
        realmresults.currentTableViewVersion = l;
        return l;
    }

*/



    private class _cls1
    {

        static final int $SwitchMap$io$realm$internal$ColumnType[];

        static 
        {
            $SwitchMap$io$realm$internal$ColumnType = new int[ColumnType.values().length];
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.INTEGER.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.FLOAT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.DOUBLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RealmResultsIterator
        implements Iterator
    {

        int pos;
        boolean removeUsed;
        final RealmResults this$0;

        public boolean hasNext()
        {
            assertRealmIsStable();
            return pos + 1 < size();
        }

        public RealmObject next()
        {
            assertRealmIsStable();
            pos = pos + 1;
            removeUsed = false;
            if (pos >= size())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Cannot access index ")).append(pos).append(" when size is ").append(size()).append(". Remember to check hasNext() before using next().").toString());
            } else
            {
                return get(pos);
            }
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new RealmException("Removing is not supported.");
        }

        RealmResultsIterator()
        {
            this$0 = RealmResults.this;
            super();
            pos = -1;
            removeUsed = false;
            currentTableViewVersion = table.sync();
        }
    }


    private class RealmResultsListIterator extends RealmResultsIterator
        implements ListIterator
    {

        final RealmResults this$0;

        public void add(RealmObject realmobject)
        {
            throw new RealmException("Adding elements not supported. Use Realm.createObject() instead.");
        }

        public volatile void add(Object obj)
        {
            add((RealmObject)obj);
        }

        public boolean hasPrevious()
        {
            assertRealmIsStable();
            return pos > 0;
        }

        public int nextIndex()
        {
            assertRealmIsStable();
            return pos + 1;
        }

        public RealmObject previous()
        {
            assertRealmIsStable();
            pos = pos - 1;
            if (pos < 0)
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Cannot access index less than zero. This was ")).append(pos).append(". Remember to check hasPrevious() before using previous().").toString());
            } else
            {
                return get(pos);
            }
        }

        public volatile Object previous()
        {
            return previous();
        }

        public int previousIndex()
        {
            assertRealmIsStable();
            return pos;
        }

        public void remove()
        {
            throw new RealmException("Removing elements not supported.");
        }

        public void set(RealmObject realmobject)
        {
            throw new RealmException("Replacing elements not supported.");
        }

        public volatile void set(Object obj)
        {
            set((RealmObject)obj);
        }

        RealmResultsListIterator(int i)
        {
            this$0 = RealmResults.this;
            super();
            if (i >= 0 && i <= size())
            {
                pos = i - 1;
                return;
            } else
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Starting location must be a valid index: [0, ")).append(size() - 1).append("]. Yours was ").append(i).toString());
            }
        }
    }

}
