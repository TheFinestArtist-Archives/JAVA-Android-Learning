// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            ColumnType, TableSpec

public class tableSpec
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
            obj = (tableSpec)obj;
            if (name == null)
            {
                if (((name) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((name) (obj)).name))
            {
                return false;
            }
            if (tableSpec == null)
            {
                if (((tableSpec) (obj)).tableSpec != null)
                {
                    return false;
                }
            } else
            if (!tableSpec.equals(((tableSpec) (obj)).tableSpec))
            {
                return false;
            }
            if (type != ((type) (obj)).type)
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

    public (ColumnType columntype, String s)
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
