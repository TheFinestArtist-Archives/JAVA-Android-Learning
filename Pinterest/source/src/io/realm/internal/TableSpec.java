// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package io.realm.internal:
//            ColumnType

public class TableSpec
{

    private List columnInfos;

    public TableSpec()
    {
        columnInfos = new ArrayList();
    }

    protected void addColumn(int i, String s)
    {
        addColumn(ColumnType.fromNativeValue(i), s);
    }

    public void addColumn(ColumnType columntype, String s)
    {
        if (s.length() > 63)
        {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        } else
        {
            columnInfos.add(new ColumnInfo(columntype, s));
            return;
        }
    }

    public TableSpec addSubtableColumn(String s)
    {
        if (s.length() > 63)
        {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        } else
        {
            s = new ColumnInfo(ColumnType.TABLE, s);
            columnInfos.add(s);
            return ((ColumnInfo) (s)).tableSpec;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (TableSpec)obj;
        if (columnInfos != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((TableSpec) (obj)).columnInfos == null) goto _L1; else goto _L3
_L3:
        return false;
        if (columnInfos.equals(((TableSpec) (obj)).columnInfos)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public long getColumnCount()
    {
        return (long)columnInfos.size();
    }

    public long getColumnIndex(String s)
    {
        for (int i = 0; i < columnInfos.size(); i++)
        {
            if (((ColumnInfo)columnInfos.get(i)).name.equals(s))
            {
                return (long)i;
            }
        }

        return -1L;
    }

    public String getColumnName(long l)
    {
        return ((ColumnInfo)columnInfos.get((int)l)).name;
    }

    public ColumnType getColumnType(long l)
    {
        return ((ColumnInfo)columnInfos.get((int)l)).type;
    }

    public TableSpec getSubtableSpec(long l)
    {
        return ((ColumnInfo)columnInfos.get((int)l)).tableSpec;
    }

    public int hashCode()
    {
        int i;
        if (columnInfos == null)
        {
            i = 0;
        } else
        {
            i = columnInfos.hashCode();
        }
        return i + 31;
    }

    private class ColumnInfo
    {

        protected final String name;
        protected final TableSpec tableSpec;
        protected final ColumnType type;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (ColumnInfo)obj;
                if (name == null)
                {
                    if (((ColumnInfo) (obj)).name != null)
                    {
                        return false;
                    }
                } else
                if (!name.equals(((ColumnInfo) (obj)).name))
                {
                    return false;
                }
                if (tableSpec == null)
                {
                    if (((ColumnInfo) (obj)).tableSpec != null)
                    {
                        return false;
                    }
                } else
                if (!tableSpec.equals(((ColumnInfo) (obj)).tableSpec))
                {
                    return false;
                }
                if (type != ((ColumnInfo) (obj)).type)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int k = 0;
            int i;
            int j;
            if (name == null)
            {
                i = 0;
            } else
            {
                i = name.hashCode();
            }
            if (tableSpec == null)
            {
                j = 0;
            } else
            {
                j = tableSpec.hashCode();
            }
            if (type != null)
            {
                k = type.hashCode();
            }
            return (j + (i + 31) * 31) * 31 + k;
        }

        public ColumnInfo(ColumnType columntype, String s)
        {
            name = s;
            type = columntype;
            if (columntype == ColumnType.TABLE)
            {
                columntype = new TableSpec();
            } else
            {
                columntype = null;
            }
            tableSpec = columntype;
        }
    }

}
