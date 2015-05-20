// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.util.JsonReader;
import android.util.JsonToken;
import com.pinterest.activity.search.model.TypeAheadRealmItem;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package io.realm:
//            Realm

public class TypeAheadRealmItemRealmProxy extends TypeAheadRealmItem
{

    public TypeAheadRealmItemRealmProxy()
    {
    }

    public static TypeAheadRealmItem copy(Realm realm, TypeAheadRealmItem typeaheadrealmitem, boolean flag, Map map)
    {
        TypeAheadRealmItem typeaheadrealmitem1 = (TypeAheadRealmItem)realm.createObject(com/pinterest/activity/search/model/TypeAheadRealmItem);
        map.put(typeaheadrealmitem, typeaheadrealmitem1);
        if (typeaheadrealmitem.getQuery() != null)
        {
            realm = typeaheadrealmitem.getQuery();
        } else
        {
            realm = "";
        }
        typeaheadrealmitem1.setQuery(realm);
        typeaheadrealmitem1.setScore(typeaheadrealmitem.getScore());
        return typeaheadrealmitem1;
    }

    public static TypeAheadRealmItem copyOrUpdate(Realm realm, TypeAheadRealmItem typeaheadrealmitem, boolean flag, Map map)
    {
        TypeAheadRealmItemRealmProxy typeaheadrealmitemrealmproxy = null;
        boolean flag1;
        if (flag)
        {
            Table table = realm.getTable(com/pinterest/activity/search/model/TypeAheadRealmItem);
            long l = table.findFirstString(table.getPrimaryKey(), typeaheadrealmitem.getQuery());
            if (l != -1L)
            {
                typeaheadrealmitemrealmproxy = new TypeAheadRealmItemRealmProxy();
                typeaheadrealmitemrealmproxy.realm = realm;
                typeaheadrealmitemrealmproxy.row = table.getRow(l);
                map.put(typeaheadrealmitem, typeaheadrealmitemrealmproxy);
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
        } else
        {
            flag1 = flag;
        }
        if (flag1)
        {
            return update(realm, typeaheadrealmitemrealmproxy, typeaheadrealmitem, map);
        } else
        {
            return copy(realm, typeaheadrealmitem, flag, map);
        }
    }

    public static List getFieldNames()
    {
        return Arrays.asList(new String[] {
            "query", "score"
        });
    }

    public static Table initTable(ImplicitTransaction implicittransaction)
    {
        if (!implicittransaction.hasTable("class_TypeAheadRealmItem"))
        {
            implicittransaction = implicittransaction.getTable("class_TypeAheadRealmItem");
            implicittransaction.addColumn(ColumnType.STRING, "query");
            implicittransaction.addColumn(ColumnType.FLOAT, "score");
            implicittransaction.setIndex(implicittransaction.getColumnIndex("query"));
            implicittransaction.setPrimaryKey("query");
            return implicittransaction;
        } else
        {
            return implicittransaction.getTable("class_TypeAheadRealmItem");
        }
    }

    public static void populateUsingJsonObject(TypeAheadRealmItem typeaheadrealmitem, JSONObject jsonobject)
    {
        if (!jsonobject.isNull("query"))
        {
            typeaheadrealmitem.setQuery(jsonobject.getString("query"));
        }
        if (!jsonobject.isNull("score"))
        {
            typeaheadrealmitem.setScore((float)jsonobject.getDouble("score"));
        }
    }

    public static void populateUsingJsonStream(TypeAheadRealmItem typeaheadrealmitem, JsonReader jsonreader)
    {
        jsonreader.beginObject();
        while (jsonreader.hasNext()) 
        {
            String s = jsonreader.nextName();
            if (s.equals("query") && jsonreader.peek() != JsonToken.NULL)
            {
                typeaheadrealmitem.setQuery(jsonreader.nextString());
            } else
            if (s.equals("score") && jsonreader.peek() != JsonToken.NULL)
            {
                typeaheadrealmitem.setScore((float)jsonreader.nextDouble());
            } else
            {
                jsonreader.skipValue();
            }
        }
        jsonreader.endObject();
    }

    static TypeAheadRealmItem update(Realm realm, TypeAheadRealmItem typeaheadrealmitem, TypeAheadRealmItem typeaheadrealmitem1, Map map)
    {
        typeaheadrealmitem.setScore(typeaheadrealmitem1.getScore());
        return typeaheadrealmitem;
    }

    public static void validateTable(ImplicitTransaction implicittransaction)
    {
        if (implicittransaction.hasTable("class_TypeAheadRealmItem"))
        {
            implicittransaction = implicittransaction.getTable("class_TypeAheadRealmItem");
            if (implicittransaction.getColumnCount() != 2L)
            {
                throw new IllegalStateException("Column count does not match");
            }
            HashMap hashmap = new HashMap();
            for (long l = 0L; l < 2L; l++)
            {
                hashmap.put(implicittransaction.getColumnName(l), implicittransaction.getColumnType(l));
            }

            if (!hashmap.containsKey("query"))
            {
                throw new IllegalStateException("Missing column 'query'");
            }
            if (hashmap.get("query") != ColumnType.STRING)
            {
                throw new IllegalStateException("Invalid type 'String' for column 'query'");
            }
            if (!hashmap.containsKey("score"))
            {
                throw new IllegalStateException("Missing column 'score'");
            }
            if (hashmap.get("score") != ColumnType.FLOAT)
            {
                throw new IllegalStateException("Invalid type 'float' for column 'score'");
            }
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (TypeAheadRealmItemRealmProxy)obj;
            String s = realm.getPath();
            String s1 = ((TypeAheadRealmItemRealmProxy) (obj)).realm.getPath();
            if (s == null ? s1 != null : !s.equals(s1))
            {
                return false;
            }
            s = row.getTable().getName();
            s1 = ((TypeAheadRealmItemRealmProxy) (obj)).row.getTable().getName();
            if (s == null ? s1 != null : !s.equals(s1))
            {
                return false;
            }
            if (row.getIndex() != ((TypeAheadRealmItemRealmProxy) (obj)).row.getIndex())
            {
                return false;
            }
        }
        return true;
    }

    public String getQuery()
    {
        realm.checkIfValid();
        return row.getString(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("query")).longValue());
    }

    public float getScore()
    {
        realm.checkIfValid();
        return row.getFloat(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("score")).longValue());
    }

    public int hashCode()
    {
        int j = 0;
        String s = realm.getPath();
        String s1 = row.getTable().getName();
        long l = row.getIndex();
        int i;
        if (s != null)
        {
            i = s.hashCode();
        } else
        {
            i = 0;
        }
        if (s1 != null)
        {
            j = s1.hashCode();
        }
        return (j + (i + 527) * 31) * 31 + (int)(l >>> 32 ^ l);
    }

    public void setQuery(String s)
    {
        realm.checkIfValid();
        row.setString(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("query")).longValue(), s);
    }

    public void setScore(float f)
    {
        realm.checkIfValid();
        row.setFloat(((Long)((Map)Realm.columnIndices.get("TypeAheadRealmItem")).get("score")).longValue(), f);
    }

    public String toString()
    {
        if (!isValid())
        {
            return "Invalid object";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("TypeAheadRealmItem = [");
            stringbuilder.append("{query:");
            stringbuilder.append(getQuery());
            stringbuilder.append("}");
            stringbuilder.append(",");
            stringbuilder.append("{score:");
            stringbuilder.append(getScore());
            stringbuilder.append("}");
            stringbuilder.append("]");
            return stringbuilder.toString();
        }
    }
}
