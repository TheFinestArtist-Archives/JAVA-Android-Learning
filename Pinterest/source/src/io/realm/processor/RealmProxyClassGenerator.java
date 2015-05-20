// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import com.squareup.javawriter.JavaWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

// Referenced classes of package io.realm.processor:
//            ClassMetaData, Utils, RealmJsonTypeHelper

public class RealmProxyClassGenerator
{

    private static final Map CASTING_TYPES;
    private static final Map JAVA_TO_COLUMN_TYPES;
    private static final Map JAVA_TO_REALM_TYPES;
    private static final Map NULLABLE_JAVA_TYPES;
    private final String className;
    private Elements elementUtils;
    private ClassMetaData metadata;
    private ProcessingEnvironment processingEnvironment;
    private DeclaredType realmList;
    private TypeMirror realmObject;
    private Types typeUtils;

    public RealmProxyClassGenerator(ProcessingEnvironment processingenvironment, ClassMetaData classmetadata)
    {
        processingEnvironment = processingenvironment;
        metadata = classmetadata;
        className = classmetadata.getSimpleClassName();
    }

    private void emitAccessors(JavaWriter javawriter)
    {
        Iterator iterator = metadata.getFields().iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (VariableElement)iterator.next();
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            String s1 = ((VariableElement) (obj)).asType().toString();
            if (JAVA_TO_REALM_TYPES.containsKey(s1))
            {
                obj = (String)JAVA_TO_REALM_TYPES.get(s1);
                String s2 = (String)CASTING_TYPES.get(s1);
                javawriter.c("Override");
                javawriter.a(s1, metadata.getGetter(s), EnumSet.of(Modifier.PUBLIC), new String[0]);
                javawriter.a("realm.checkIfValid()", new Object[0]);
                javawriter.a("return (%s) row.get%s(Realm.columnIndices.get(\"%s\").get(\"%s\"))", new Object[] {
                    s1, obj, className, s
                });
                javawriter.d();
                javawriter.b();
                javawriter.c("Override");
                javawriter.a("void", metadata.getSetter(s), EnumSet.of(Modifier.PUBLIC), new String[] {
                    s1, "value"
                });
                javawriter.a("realm.checkIfValid()", new Object[0]);
                javawriter.a("row.set%s(Realm.columnIndices.get(\"%s\").get(\"%s\"), (%s) value)", new Object[] {
                    obj, className, s, s2
                });
                javawriter.d();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                javawriter.c("Override");
                javawriter.a(s1, metadata.getGetter(s), EnumSet.of(Modifier.PUBLIC), new String[0]);
                javawriter.b("if (row.isNullLink(Realm.columnIndices.get(\"%s\").get(\"%s\")))", new Object[] {
                    className, s
                });
                javawriter.a("return null", new Object[0]);
                javawriter.c();
                javawriter.a("return realm.get(%s.class, row.getLink(Realm.columnIndices.get(\"%s\").get(\"%s\")))", new Object[] {
                    s1, className, s
                });
                javawriter.d();
                javawriter.b();
                javawriter.c("Override");
                javawriter.a("void", metadata.getSetter(s), EnumSet.of(Modifier.PUBLIC), new String[] {
                    s1, "value"
                });
                javawriter.b("if (value == null)", new Object[0]);
                javawriter.a("row.nullifyLink(Realm.columnIndices.get(\"%s\").get(\"%s\"))", new Object[] {
                    className, s
                });
                javawriter.a("return", new Object[0]);
                javawriter.c();
                javawriter.a("row.setLink(Realm.columnIndices.get(\"%s\").get(\"%s\"), value.row.getIndex())", new Object[] {
                    className, s
                });
                javawriter.d();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                obj = Utils.getGenericType(((VariableElement) (obj)));
                javawriter.c("Override");
                javawriter.a(s1, metadata.getGetter(s), EnumSet.of(Modifier.PUBLIC), new String[0]);
                javawriter.a("return new RealmList<%s>(%s.class, row.getLinkList(Realm.columnIndices.get(\"%s\").get(\"%s\")), realm)", new Object[] {
                    obj, obj, className, s
                });
                javawriter.d();
                javawriter.b();
                javawriter.c("Override");
                javawriter.a("void", metadata.getSetter(s), EnumSet.of(Modifier.PUBLIC), new String[] {
                    s1, "value"
                });
                javawriter.a("LinkView links = row.getLinkList(Realm.columnIndices.get(\"%s\").get(\"%s\"))", new Object[] {
                    className, s
                });
                javawriter.b("if (value == null)", new Object[0]);
                javawriter.a("return", new Object[0]);
                javawriter.c();
                javawriter.b("for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value)", new Object[0]);
                javawriter.a("links.add(linkedObject.row.getIndex())", new Object[0]);
                javawriter.c();
                javawriter.d();
            } else
            {
                throw new UnsupportedOperationException(String.format("Type %s of field %s is not supported", new Object[] {
                    s1, s
                }));
            }
            javawriter.b();
        }
    }

    private void emitCopyMethod(JavaWriter javawriter)
    {
        javawriter.a(className, "copy", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "Realm", "realm", className, "newObject", "boolean", "update", "Map<RealmObject,RealmObject>", "cache"
        });
        javawriter.a("%s realmObject = realm.createObject(%s.class)", new Object[] {
            className, className
        });
        javawriter.a("cache.put(newObject, realmObject)", new Object[0]);
        for (Iterator iterator = metadata.getFields().iterator(); iterator.hasNext();)
        {
            VariableElement variableelement = (VariableElement)iterator.next();
            String s = variableelement.getSimpleName().toString();
            String s1 = variableelement.asType().toString();
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                javawriter.b().a("%s %sObj = newObject.%s()", new Object[] {
                    s1, s, metadata.getGetter(s)
                }).b("if (%sObj != null)", new Object[] {
                    s
                }).a("%s cache%s = (%s) cache.get(%sObj)", new Object[] {
                    s1, s, s1, s
                }).b("if (cache%s != null)", new Object[] {
                    s
                }).a("realmObject.%s(cache%s)", new Object[] {
                    metadata.getSetter(s), s
                }).c("else", new Object[0]).a("realmObject.%s(%s.copyOrUpdate(realm, %sObj, update, cache))", new Object[] {
                    metadata.getSetter(s), Utils.getProxyClassSimpleName(variableelement), s
                }).c().c();
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                javawriter.b().a("RealmList<%s> %sList = newObject.%s()", new Object[] {
                    Utils.getGenericType(variableelement), s, metadata.getGetter(s)
                }).b("if (%sList != null)", new Object[] {
                    s
                }).a("RealmList<%s> %sRealmList = realmObject.%s()", new Object[] {
                    Utils.getGenericType(variableelement), s, metadata.getGetter(s)
                }).b("for (int i = 0; i < %sList.size(); i++)", new Object[] {
                    s
                }).a("%s %sItem = %sList.get(i)", new Object[] {
                    Utils.getGenericType(variableelement), s, s
                }).a("%s cache%s = (%s) cache.get(%sItem)", new Object[] {
                    Utils.getGenericType(variableelement), s, Utils.getGenericType(variableelement), s
                }).b("if (cache%s != null)", new Object[] {
                    s
                }).a("%sRealmList.add(cache%s)", new Object[] {
                    s, s
                }).c("else", new Object[0]).a("%sRealmList.add(%s.copyOrUpdate(realm, %sList.get(i), update, cache))", new Object[] {
                    s, Utils.getProxyClassSimpleName(variableelement), s
                }).c().c().c().b();
            } else
            if (NULLABLE_JAVA_TYPES.containsKey(s1))
            {
                javawriter.a("realmObject.%s(newObject.%s() != null ? newObject.%s() : %s)", new Object[] {
                    metadata.getSetter(s), metadata.getGetter(s), metadata.getGetter(s), NULLABLE_JAVA_TYPES.get(s1)
                });
            } else
            {
                javawriter.a("realmObject.%s(newObject.%s())", new Object[] {
                    metadata.getSetter(s), metadata.getGetter(s)
                });
            }
        }

        javawriter.a("return realmObject", new Object[0]);
        javawriter.d();
        javawriter.b();
    }

    private void emitCopyOrUpdateMethod(JavaWriter javawriter)
    {
        javawriter.a(className, "copyOrUpdate", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "Realm", "realm", className, "object", "boolean", "update", "Map<RealmObject,RealmObject>", "cache"
        });
        if (!metadata.hasPrimaryKey())
        {
            javawriter.a("return copy(realm, object, update, cache)", new Object[0]);
        } else
        {
            javawriter.a("%s realmObject = null", new Object[] {
                className
            }).a("boolean canUpdate = update", new Object[0]).b("if (canUpdate)", new Object[0]).a("Table table = realm.getTable(%s.class)", new Object[] {
                className
            }).a("long pkColumnIndex = table.getPrimaryKey()", new Object[0]);
            if (Utils.isString(metadata.getPrimaryKey()))
            {
                javawriter.a("long rowIndex = table.findFirstString(pkColumnIndex, object.%s())", new Object[] {
                    metadata.getPrimaryKeyGetter()
                });
            } else
            {
                javawriter.a("long rowIndex = table.findFirstLong(pkColumnIndex, object.%s())", new Object[] {
                    metadata.getPrimaryKeyGetter()
                });
            }
            javawriter.b("if (rowIndex != TableOrView.NO_MATCH)", new Object[0]).a("realmObject = new %s()", new Object[] {
                Utils.getProxyClassName(className)
            }).a("realmObject.realm = realm", new Object[0]).a("realmObject.row = table.getRow(rowIndex)", new Object[0]).a("cache.put(object, realmObject)", new Object[0]).c("else", new Object[0]).a("canUpdate = false", new Object[0]).c();
            javawriter.c();
            javawriter.b().b("if (canUpdate)", new Object[0]).a("return update(realm, realmObject, object, cache)", new Object[0]).c("else", new Object[0]).a("return copy(realm, object, update, cache)", new Object[0]).c();
        }
        javawriter.d();
        javawriter.b();
    }

    private void emitEqualsMethod(JavaWriter javawriter)
    {
        String s = (new StringBuilder()).append(className).append("RealmProxy").toString();
        javawriter.c("Override");
        javawriter.a("boolean", "equals", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Object", "o"
        });
        javawriter.a("if (this == o) return true", new Object[0]);
        javawriter.a("if (o == null || getClass() != o.getClass()) return false", new Object[0]);
        javawriter.a("%s a%s = (%s)o", new Object[] {
            s, className, s
        });
        javawriter.b();
        javawriter.a("String path = realm.getPath()", new Object[0]);
        javawriter.a("String otherPath = a%s.realm.getPath()", new Object[] {
            className
        });
        javawriter.a("if (path != null ? !path.equals(otherPath) : otherPath != null) return false;", new Object[0]);
        javawriter.b();
        javawriter.a("String tableName = row.getTable().getName()", new Object[0]);
        javawriter.a("String otherTableName = a%s.row.getTable().getName()", new Object[] {
            className
        });
        javawriter.a("if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false", new Object[0]);
        javawriter.b();
        javawriter.a("if (row.getIndex() != a%s.row.getIndex()) return false", new Object[] {
            className
        });
        javawriter.b();
        javawriter.a("return true", new Object[0]);
        javawriter.d();
        javawriter.b();
    }

    private void emitGetFieldNamesMethod(JavaWriter javawriter)
    {
        javawriter.a("List<String>", "getFieldNames", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[0]);
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = ((VariableElement)iterator.next()).getSimpleName().toString();
            stringbuilder.append("\"");
            stringbuilder.append(s);
            stringbuilder.append("\"");
            if (iterator.hasNext())
            {
                stringbuilder.append(", ");
            }
        } while (true);
        javawriter.a("return Arrays.asList(%s)", new Object[] {
            stringbuilder.toString()
        });
        javawriter.d();
        javawriter.b();
    }

    private void emitHashcodeMethod(JavaWriter javawriter)
    {
        javawriter.c("Override");
        javawriter.a("int", "hashCode", EnumSet.of(Modifier.PUBLIC), new String[0]);
        javawriter.a("String realmName = realm.getPath()", new Object[0]);
        javawriter.a("String tableName = row.getTable().getName()", new Object[0]);
        javawriter.a("long rowIndex = row.getIndex()", new Object[0]);
        javawriter.b();
        javawriter.a("int result = 17", new Object[0]);
        javawriter.a("result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0)", new Object[0]);
        javawriter.a("result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0)", new Object[0]);
        javawriter.a("result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32))", new Object[0]);
        javawriter.a("return result", new Object[0]);
        javawriter.d();
        javawriter.b();
    }

    private void emitInitTableMethod(JavaWriter javawriter)
    {
        javawriter.a("Table", "initTable", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "ImplicitTransaction", "transaction"
        });
        javawriter.b((new StringBuilder("if(!transaction.hasTable(\"class_")).append(className).append("\"))").toString(), new Object[0]);
        javawriter.a("Table table = transaction.getTable(\"%s%s\")", new Object[] {
            "class_", className
        });
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            String s1 = ((VariableElement) (obj)).asType().toString();
            String s2 = Utils.getFieldTypeSimpleName(((VariableElement) (obj)));
            if (JAVA_TO_REALM_TYPES.containsKey(s1))
            {
                javawriter.a("table.addColumn(%s, \"%s\")", new Object[] {
                    JAVA_TO_COLUMN_TYPES.get(s1), s
                });
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                javawriter.b("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", s2
                });
                javawriter.a("%s%s.initTable(transaction)", new Object[] {
                    s2, "RealmProxy"
                });
                javawriter.c();
                javawriter.a("table.addColumnLink(ColumnType.LINK, \"%s\", transaction.getTable(\"%s%s\"))", new Object[] {
                    s, "class_", s2
                });
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                obj = Utils.getGenericType(((VariableElement) (obj)));
                javawriter.b("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", obj
                });
                javawriter.a("%s%s.initTable(transaction)", new Object[] {
                    obj, "RealmProxy"
                });
                javawriter.c();
                javawriter.a("table.addColumnLink(ColumnType.LINK_LIST, \"%s\", transaction.getTable(\"%s%s\"))", new Object[] {
                    s, "class_", obj
                });
            }
        } while (true);
        for (Iterator iterator1 = metadata.getIndexedFields().iterator(); iterator1.hasNext(); javawriter.a("table.setIndex(table.getColumnIndex(\"%s\"))", new Object[] {
    ((VariableElement)iterator1.next()).getSimpleName().toString()
})) { }
        if (metadata.hasPrimaryKey())
        {
            javawriter.a("table.setPrimaryKey(\"%s\")", new Object[] {
                metadata.getPrimaryKey().getSimpleName().toString()
            });
        } else
        {
            javawriter.a("table.setPrimaryKey(\"\")", new Object[0]);
        }
        javawriter.a("return table", new Object[0]);
        javawriter.c();
        javawriter.a("return transaction.getTable(\"%s%s\")", new Object[] {
            "class_", className
        });
        javawriter.d();
        javawriter.b();
    }

    private void emitPopulateUsingJsonObjectMethod(JavaWriter javawriter)
    {
        javawriter.a("void", "populateUsingJsonObject", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), Arrays.asList(new String[] {
            className, "obj", "JSONObject", "json"
        }), Arrays.asList(new String[] {
            "JSONException"
        }));
        javawriter.a("boolean standalone = obj.realm == null", new Object[0]);
        for (Iterator iterator = metadata.getFields().iterator(); iterator.hasNext();)
        {
            VariableElement variableelement = (VariableElement)iterator.next();
            String s = variableelement.getSimpleName().toString();
            String s1 = variableelement.asType().toString();
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                RealmJsonTypeHelper.emitFillRealmObjectWithJsonValue(metadata.getSetter(s), s, s1, Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                RealmJsonTypeHelper.emitFillRealmListWithJsonValue(metadata.getGetter(s), metadata.getSetter(s), s, ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString(), Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            {
                RealmJsonTypeHelper.emitFillJavaTypeWithJsonValue(metadata.getSetter(s), s, s1, javawriter);
            }
        }

        javawriter.d();
        javawriter.b();
    }

    private void emitPopulateUsingJsonStreamMethod(JavaWriter javawriter)
    {
        javawriter.a("void", "populateUsingJsonStream", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), Arrays.asList(new String[] {
            className, "obj", "JsonReader", "reader"
        }), Arrays.asList(new String[] {
            "IOException"
        }));
        javawriter.a("boolean standalone = obj.realm == null", new Object[0]);
        javawriter.a("reader.beginObject()", new Object[0]);
        javawriter.b("while (reader.hasNext())", new Object[0]);
        javawriter.a("String name = reader.nextName()", new Object[0]);
        List list = metadata.getFields();
        int i = 0;
        while (i < list.size()) 
        {
            VariableElement variableelement = (VariableElement)list.get(i);
            String s = variableelement.getSimpleName().toString();
            String s1 = variableelement.asType().toString();
            if (i == 0)
            {
                javawriter.b("if (name.equals(\"%s\") && reader.peek() != JsonToken.NULL)", new Object[] {
                    s
                });
            } else
            {
                javawriter.c("else if (name.equals(\"%s\")  && reader.peek() != JsonToken.NULL)", new Object[] {
                    s
                });
            }
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                RealmJsonTypeHelper.emitFillRealmObjectFromStream(metadata.getSetter(s), s, s1, Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                RealmJsonTypeHelper.emitFillRealmListFromStream(metadata.getGetter(s), metadata.getSetter(s), ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString(), Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            {
                RealmJsonTypeHelper.emitFillJavaTypeFromStream(metadata.getSetter(s), s, s1, javawriter);
            }
            i++;
        }
        if (list.size() > 0)
        {
            javawriter.c("else", new Object[0]);
            javawriter.a("reader.skipValue()", new Object[0]);
            javawriter.c();
        }
        javawriter.c();
        javawriter.a("reader.endObject()", new Object[0]);
        javawriter.d();
        javawriter.b();
    }

    private void emitToStringMethod(JavaWriter javawriter)
    {
        javawriter.c("Override");
        javawriter.a("String", "toString", EnumSet.of(Modifier.PUBLIC), new String[0]);
        javawriter.b("if (!isValid())", new Object[0]);
        javawriter.a("return \"Invalid object\"", new Object[0]);
        javawriter.c();
        javawriter.a("StringBuilder stringBuilder = new StringBuilder(\"%s = [\")", new Object[] {
            className
        });
        List list = metadata.getFields();
        int i = 0;
        while (i < list.size()) 
        {
            Object obj = (VariableElement)list.get(i);
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            javawriter.a("stringBuilder.append(\"{%s:\")", new Object[] {
                s
            });
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                obj = Utils.getFieldTypeSimpleName(((VariableElement) (obj)));
                javawriter.a("stringBuilder.append(%s() != null ? \"%s\" : \"null\")", new Object[] {
                    metadata.getGetter(s), obj
                });
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                javawriter.a("stringBuilder.append(\"RealmList<%s>[\").append(%s().size()).append(\"]\")", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), metadata.getGetter(s)
                });
            } else
            {
                javawriter.a("stringBuilder.append(%s())", new Object[] {
                    metadata.getGetter(s)
                });
            }
            javawriter.a("stringBuilder.append(\"}\")", new Object[0]);
            if (i < list.size() - 1)
            {
                javawriter.a("stringBuilder.append(\",\")", new Object[0]);
            }
            i++;
        }
        javawriter.a("stringBuilder.append(\"]\")", new Object[0]);
        javawriter.a("return stringBuilder.toString()", new Object[0]);
        javawriter.d();
        javawriter.b();
    }

    private void emitUpdateMethod(JavaWriter javawriter)
    {
        javawriter.a(className, "update", EnumSet.of(Modifier.STATIC), new String[] {
            "Realm", "realm", className, "realmObject", className, "newObject", "Map<RealmObject, RealmObject>", "cache"
        });
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                javawriter.a("%s %sObj = newObject.%s()", new Object[] {
                    Utils.getFieldTypeSimpleName(((VariableElement) (obj))), s, metadata.getGetter(s)
                }).b("if (%sObj != null)", new Object[] {
                    s
                }).a("%s cache%s = (%s) cache.get(%sObj)", new Object[] {
                    Utils.getFieldTypeSimpleName(((VariableElement) (obj))), s, Utils.getFieldTypeSimpleName(((VariableElement) (obj))), s
                }).b("if (cache%s != null)", new Object[] {
                    s
                }).a("realmObject.%s(cache%s)", new Object[] {
                    metadata.getSetter(s), s
                }).c("else", new Object[0]).a("realmObject.%s(%s.copyOrUpdate(realm, %sObj, true, cache))", new Object[] {
                    metadata.getSetter(s), Utils.getProxyClassSimpleName(((VariableElement) (obj))), s, Utils.getFieldTypeSimpleName(((VariableElement) (obj)))
                }).c().c("else", new Object[0]).a("realmObject.%s(null)", new Object[] {
                    metadata.getSetter(s)
                }).c();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                javawriter.a("RealmList<%s> %sList = newObject.%s()", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, metadata.getGetter(s)
                }).a("RealmList<%s> %sRealmList = realmObject.%s()", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, metadata.getGetter(s)
                }).a("%sRealmList.clear()", new Object[] {
                    s
                }).b("if (%sList != null)", new Object[] {
                    s
                }).b("for (int i = 0; i < %sList.size(); i++)", new Object[] {
                    s
                }).a("%s %sItem = %sList.get(i)", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, s
                }).a("%s cache%s = (%s) cache.get(%sItem)", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, Utils.getGenericType(((VariableElement) (obj))), s
                }).b("if (cache%s != null)", new Object[] {
                    s
                }).a("%sRealmList.add(cache%s)", new Object[] {
                    s, s
                }).c("else", new Object[0]).a("%sRealmList.add(%s.copyOrUpdate(realm, %sList.get(i), true, cache))", new Object[] {
                    s, Utils.getProxyClassSimpleName(((VariableElement) (obj))), s
                }).c().c().c();
            } else
            if (obj != metadata.getPrimaryKey())
            {
                obj = ((VariableElement) (obj)).asType().toString();
                if (NULLABLE_JAVA_TYPES.containsKey(obj))
                {
                    javawriter.a("realmObject.%s(newObject.%s() != null ? newObject.%s() : %s)", new Object[] {
                        metadata.getSetter(s), metadata.getGetter(s), metadata.getGetter(s), NULLABLE_JAVA_TYPES.get(obj)
                    });
                } else
                {
                    javawriter.a("realmObject.%s(newObject.%s())", new Object[] {
                        metadata.getSetter(s), metadata.getGetter(s)
                    });
                }
            }
        } while (true);
        javawriter.a("return realmObject", new Object[0]);
        javawriter.d();
        javawriter.b();
    }

    private void emitValidateTableMethod(JavaWriter javawriter)
    {
        javawriter.a("void", "validateTable", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "ImplicitTransaction", "transaction"
        });
        javawriter.b((new StringBuilder("if(transaction.hasTable(\"class_")).append(className).append("\"))").toString(), new Object[0]);
        javawriter.a("Table table = transaction.getTable(\"%s%s\")", new Object[] {
            "class_", className
        });
        javawriter.b((new StringBuilder("if(table.getColumnCount() != ")).append(metadata.getFields().size()).append(")").toString(), new Object[0]);
        javawriter.a("throw new IllegalStateException(\"Column count does not match\")", new Object[0]);
        javawriter.c();
        javawriter.a("Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>()", new Object[0]);
        javawriter.b((new StringBuilder("for(long i = 0; i < ")).append(metadata.getFields().size()).append("; i++)").toString(), new Object[0]);
        javawriter.a("columnTypes.put(table.getColumnName(i), table.getColumnType(i))", new Object[0]);
        javawriter.c();
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            String s1 = ((VariableElement) (obj)).asType().toString();
            String s2 = Utils.getFieldTypeSimpleName(((VariableElement) (obj)));
            if (JAVA_TO_REALM_TYPES.containsKey(s1))
            {
                javawriter.b("if (!columnTypes.containsKey(\"%s\"))", new Object[] {
                    s
                });
                javawriter.a("throw new IllegalStateException(\"Missing column '%s'\")", new Object[] {
                    s
                });
                javawriter.c();
                javawriter.b("if (columnTypes.get(\"%s\") != %s)", new Object[] {
                    s, JAVA_TO_COLUMN_TYPES.get(s1)
                });
                javawriter.a("throw new IllegalStateException(\"Invalid type '%s' for column '%s'\")", new Object[] {
                    s2, s
                });
                javawriter.c();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                javawriter.b("if (!columnTypes.containsKey(\"%s\"))", new Object[] {
                    s
                });
                javawriter.a("throw new IllegalStateException(\"Missing column '%s'\")", new Object[] {
                    s
                });
                javawriter.c();
                javawriter.b("if (columnTypes.get(\"%s\") != ColumnType.LINK)", new Object[] {
                    s
                });
                javawriter.a("throw new IllegalStateException(\"Invalid type '%s' for column '%s'\")", new Object[] {
                    s2, s
                });
                javawriter.c();
                javawriter.b("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", s2
                });
                javawriter.a("throw new IllegalStateException(\"Missing table '%s%s' for column '%s'\")", new Object[] {
                    "class_", s2, s
                });
                javawriter.c();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                obj = Utils.getGenericType(((VariableElement) (obj)));
                javawriter.b("if(!columnTypes.containsKey(\"%s\"))", new Object[] {
                    s
                });
                javawriter.a("throw new IllegalStateException(\"Missing column '%s'\")", new Object[] {
                    s
                });
                javawriter.c();
                javawriter.b("if(columnTypes.get(\"%s\") != ColumnType.LINK_LIST)", new Object[] {
                    s
                });
                javawriter.a("throw new IllegalStateException(\"Invalid type '%s' for column '%s'\")", new Object[] {
                    obj, s
                });
                javawriter.c();
                javawriter.b("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", obj
                });
                javawriter.a("throw new IllegalStateException(\"Missing table '%s%s' for column '%s'\")", new Object[] {
                    "class_", obj, s
                });
                javawriter.c();
            }
        } while (true);
        javawriter.c();
        javawriter.d();
        javawriter.b();
    }

    public void generate()
    {
        elementUtils = processingEnvironment.getElementUtils();
        typeUtils = processingEnvironment.getTypeUtils();
        realmObject = elementUtils.getTypeElement("io.realm.RealmObject").asType();
        realmList = typeUtils.getDeclaredType(elementUtils.getTypeElement("io.realm.RealmList"), new TypeMirror[] {
            typeUtils.getWildcardType(null, null)
        });
        String s = String.format("%s.%s", new Object[] {
            "io.realm", Utils.getProxyClassName(className)
        });
        JavaWriter javawriter = new JavaWriter(new BufferedWriter(processingEnvironment.getFiler().createSourceFile(s, new Element[0]).openWriter()));
        javawriter.a("    ");
        javawriter.b("io.realm").b();
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.util.JsonReader");
        arraylist.add("android.util.JsonToken");
        arraylist.add("io.realm.RealmObject");
        arraylist.add("io.realm.exceptions.RealmException");
        arraylist.add("io.realm.internal.ColumnType");
        arraylist.add("io.realm.internal.Table");
        arraylist.add("io.realm.internal.TableOrView");
        arraylist.add("io.realm.internal.ImplicitTransaction");
        arraylist.add("io.realm.internal.LinkView");
        arraylist.add("io.realm.internal.android.JsonUtils");
        arraylist.add("java.io.IOException");
        arraylist.add("java.util.List");
        arraylist.add("java.util.Arrays");
        arraylist.add("java.util.Date");
        arraylist.add("java.util.Map");
        arraylist.add("java.util.HashMap");
        arraylist.add("org.json.JSONObject");
        arraylist.add("org.json.JSONException");
        arraylist.add("org.json.JSONArray");
        arraylist.add(metadata.getFullyQualifiedClassName());
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                obj = ((VariableElement) (obj)).asType().toString();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                obj = ((TypeMirror)((DeclaredType)((VariableElement) (obj)).asType()).getTypeArguments().get(0)).toString();
            } else
            {
                obj = "";
            }
            if (obj != "" && !arraylist.contains(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        Collections.sort(arraylist);
        javawriter.a(arraylist);
        javawriter.b();
        javawriter.a(s, "class", EnumSet.of(Modifier.PUBLIC), className, new String[0]).b();
        emitAccessors(javawriter);
        emitInitTableMethod(javawriter);
        emitValidateTableMethod(javawriter);
        emitGetFieldNamesMethod(javawriter);
        emitPopulateUsingJsonObjectMethod(javawriter);
        emitPopulateUsingJsonStreamMethod(javawriter);
        emitCopyOrUpdateMethod(javawriter);
        emitCopyMethod(javawriter);
        emitUpdateMethod(javawriter);
        emitToStringMethod(javawriter);
        emitHashcodeMethod(javawriter);
        emitEqualsMethod(javawriter);
        javawriter.a();
        javawriter.close();
    }

    static 
    {
        HashMap hashmap = new HashMap();
        JAVA_TO_REALM_TYPES = hashmap;
        hashmap.put("byte", "Long");
        JAVA_TO_REALM_TYPES.put("short", "Long");
        JAVA_TO_REALM_TYPES.put("int", "Long");
        JAVA_TO_REALM_TYPES.put("long", "Long");
        JAVA_TO_REALM_TYPES.put("float", "Float");
        JAVA_TO_REALM_TYPES.put("double", "Double");
        JAVA_TO_REALM_TYPES.put("boolean", "Boolean");
        JAVA_TO_REALM_TYPES.put("Byte", "Long");
        JAVA_TO_REALM_TYPES.put("Short", "Long");
        JAVA_TO_REALM_TYPES.put("Integer", "Long");
        JAVA_TO_REALM_TYPES.put("Long", "Long");
        JAVA_TO_REALM_TYPES.put("Float", "Float");
        JAVA_TO_REALM_TYPES.put("Double", "Double");
        JAVA_TO_REALM_TYPES.put("Boolean", "Boolean");
        JAVA_TO_REALM_TYPES.put("java.lang.String", "String");
        JAVA_TO_REALM_TYPES.put("java.util.Date", "Date");
        JAVA_TO_REALM_TYPES.put("byte[]", "BinaryByteArray");
        hashmap = new HashMap();
        NULLABLE_JAVA_TYPES = hashmap;
        hashmap.put("java.util.Date", "new Date(0)");
        NULLABLE_JAVA_TYPES.put("java.lang.String", "\"\"");
        NULLABLE_JAVA_TYPES.put("byte[]", "new byte[0]");
        hashmap = new HashMap();
        JAVA_TO_COLUMN_TYPES = hashmap;
        hashmap.put("byte", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("short", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("int", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("long", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("float", "ColumnType.FLOAT");
        JAVA_TO_COLUMN_TYPES.put("double", "ColumnType.DOUBLE");
        JAVA_TO_COLUMN_TYPES.put("boolean", "ColumnType.BOOLEAN");
        JAVA_TO_COLUMN_TYPES.put("Byte", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Short", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Integer", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Long", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Float", "ColumnType.FLOAT");
        JAVA_TO_COLUMN_TYPES.put("Double", "ColumnType.DOUBLE");
        JAVA_TO_COLUMN_TYPES.put("Boolean", "ColumnType.BOOLEAN");
        JAVA_TO_COLUMN_TYPES.put("java.lang.String", "ColumnType.STRING");
        JAVA_TO_COLUMN_TYPES.put("java.util.Date", "ColumnType.DATE");
        JAVA_TO_COLUMN_TYPES.put("byte[]", "ColumnType.BINARY");
        hashmap = new HashMap();
        CASTING_TYPES = hashmap;
        hashmap.put("byte", "long");
        CASTING_TYPES.put("short", "long");
        CASTING_TYPES.put("int", "long");
        CASTING_TYPES.put("long", "long");
        CASTING_TYPES.put("float", "float");
        CASTING_TYPES.put("double", "double");
        CASTING_TYPES.put("boolean", "boolean");
        CASTING_TYPES.put("Byte", "long");
        CASTING_TYPES.put("Short", "long");
        CASTING_TYPES.put("Integer", "long");
        CASTING_TYPES.put("Long", "long");
        CASTING_TYPES.put("Float", "float");
        CASTING_TYPES.put("Double", "double");
        CASTING_TYPES.put("Boolean", "boolean");
        CASTING_TYPES.put("java.lang.String", "String");
        CASTING_TYPES.put("java.util.Date", "Date");
        CASTING_TYPES.put("byte[]", "byte[]");
    }
}
