// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.JsonReader;
import android.util.Log;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmJson;
import io.realm.internal.SharedGroup;
import io.realm.internal.Table;
import io.realm.internal.android.ReleaseAndroidLogger;
import io.realm.internal.log.RealmLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.realm:
//            RealmObject, RealmMigration, RealmQuery, RealmResults, 
//            RealmChangeListener

public final class Realm
    implements Closeable
{

    private static final String APT_NOT_EXECUTED_MESSAGE = "Annotation processor may not have been executed.";
    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    public static final String DEFAULT_REALM_NAME = "default.realm";
    private static final String DIFFERENT_KEY_MESSAGE = "Wrong key used to decrypt Realm.";
    private static final String INCORRECT_THREAD_MESSAGE = "Realm access from incorrect thread. Realm objects can only be accessed on the thread they where created.";
    private static final String INVALID_KEY_MESSAGE = "The provided key is invalid. It should either be null or be 64 bytes long.";
    private static final int REALM_CHANGED = 0xe3d1b0;
    private static final String TABLE_PREFIX = "class_";
    private static final String TAG = "REALM";
    private static final long UNVERSIONED = -1L;
    static final Map columnIndices = new HashMap();
    private static final Set customSchema = new HashSet();
    private static io.realm.internal.SharedGroup.Durability defaultDurability;
    protected static final Map handlers = new ConcurrentHashMap();
    private static final Map openRealms = new ConcurrentHashMap();
    protected static final ThreadLocal realmsCache = new _cls1();
    private static final ThreadLocal referenceCount = new _cls2();
    private boolean autoRefresh;
    private final List changeListeners = new ArrayList();
    private final Map constructors = new HashMap();
    private final Map generatedClasses = new HashMap();
    private final Map generatedConstructors = new HashMap();
    private Handler handler;
    private final int id;
    private final Map initTableMethods = new HashMap();
    private final Map insertOrUpdateMethods = new HashMap();
    private final byte key[];
    private final String path;
    private final Map proxiedClassNames = new HashMap();
    private final RealmJson realmJson = getRealmJson();
    private SharedGroup sharedGroup;
    private final Map simpleClassNames = new HashMap();
    private final Map tables = new HashMap();
    private final ImplicitTransaction transaction;

    private Realm(String s, byte abyte0[], boolean flag)
    {
        if (abyte0 != null && abyte0.length != 64)
        {
            throw new IllegalArgumentException("The provided key is invalid. It should either be null or be 64 bytes long.");
        } else
        {
            sharedGroup = new SharedGroup(s, true, abyte0);
            transaction = sharedGroup.beginImplicitTransaction();
            path = s;
            key = abyte0;
            id = s.hashCode();
            setAutoRefresh(flag);
            return;
        }
    }

    private void checkHasPrimaryKey(RealmObject realmobject)
    {
        realmobject = realmobject.getClass();
        if (!getTable(realmobject).hasPrimaryKey())
        {
            throw new IllegalArgumentException((new StringBuilder("RealmObject has no @PrimaryKey defined: ")).append(getClassSimpleName(realmobject)).toString());
        } else
        {
            return;
        }
    }

    private void checkHasPrimaryKey(Class class1)
    {
        if (!getTable(class1).hasPrimaryKey())
        {
            throw new IllegalArgumentException((new StringBuilder("A RealmObject with no @PrimaryKey cannot be updated: ")).append(class1.toString()).toString());
        } else
        {
            return;
        }
    }

    private void checkNotNullObject(RealmObject realmobject)
    {
        if (realmobject == null)
        {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        } else
        {
            return;
        }
    }

    private static void checkValidRealmPath(File file, String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Non-empty filename must be provided");
        }
        if (file == null || !file.isDirectory())
        {
            s = new StringBuilder("An existing folder must be provided. Yours was ");
            if (file != null)
            {
                file = file.getAbsolutePath();
            } else
            {
                file = "null";
            }
            throw new IllegalArgumentException(s.append(file).toString());
        } else
        {
            return;
        }
    }

    public static boolean compactRealmFile(Context context)
    {
        return compactRealmFile(context, "default.realm");
    }

    public static boolean compactRealmFile(Context context, String s)
    {
        boolean flag1 = false;
        io/realm/Realm;
        JVM INSTR monitorenter ;
        File file;
        File file1;
        file = new File(context.getFilesDir(), s);
        file1 = new File(context.getFilesDir(), (new StringBuilder()).append(String.valueOf(System.currentTimeMillis())).append(UUID.randomUUID()).append(".realm").toString());
        Context context1;
        Context context2;
        context2 = null;
        context1 = null;
        context = getInstance(context, s);
        context1 = context;
        context2 = context;
        context.writeCopyTo(file1);
        context1 = context;
        context2 = context;
        boolean flag = file.delete();
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        context.close();
        flag = flag1;
_L4:
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        context1 = context;
        context2 = context;
        flag = file1.renameTo(file);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        flag = flag1;
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context.close();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        context.close();
        break MISSING_BLOCK_LABEL_207;
        context;
        flag = flag1;
        if (context1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context1.close();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        context;
        if (context2 == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        context2.close();
        throw context;
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private RealmObject copyOrUpdate(RealmObject realmobject, boolean flag)
    {
        Class class2 = getRealmClassFromObject(realmobject);
        Class class1 = getProxyClass(class2);
        Method method1 = (Method)insertOrUpdateMethods.get(class2);
        Method method = method1;
        if (method1 == null)
        {
            try
            {
                method = class1.getMethod("copyOrUpdate", new Class[] {
                    io/realm/Realm, class2, Boolean.TYPE, java/util/Map
                });
            }
            // Misplaced declaration of an exception variable
            catch (RealmObject realmobject)
            {
                throw new RealmException((new StringBuilder("Could not find the copyOrUpdate() method in generated proxy class for ")).append(class1.getName()).append(": Annotation processor may not have been executed.").toString(), realmobject);
            }
            insertOrUpdateMethods.put(class1, method);
        }
        try
        {
            realmobject = (RealmObject)method.invoke(null, new Object[] {
                this, realmobject, Boolean.valueOf(flag), new HashMap()
            });
        }
        // Misplaced declaration of an exception variable
        catch (RealmObject realmobject)
        {
            throw new RealmException("Could not execute the copyToRealm method : Annotation processor may not have been executed.", realmobject);
        }
        // Misplaced declaration of an exception variable
        catch (RealmObject realmobject)
        {
            throw new RealmException((new StringBuilder("An exception was thrown in the copyToRealm method in the proxy class  ")).append(class1.getName()).append(": Annotation processor may not have been executed.").toString(), realmobject);
        }
        return realmobject;
    }

    private static Realm create(File file, String s, byte abyte0[])
    {
        checkValidRealmPath(file, s);
        file = (new File(file, s)).getAbsolutePath();
        if (Looper.myLooper() != null)
        {
            return createAndValidate(file, abyte0, true, true);
        } else
        {
            return createAndValidate(file, abyte0, true, false);
        }
    }

    private static Realm createAndValidate(String s, byte abyte0[], boolean flag, boolean flag1)
    {
        io/realm/Realm;
        JVM INSTR monitorenter ;
        Integer integer;
        Map map;
        int i;
        i = s.hashCode();
        map = (Map)referenceCount.get();
        integer = (Integer)map.get(Integer.valueOf(i));
        if (integer != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        integer = Integer.valueOf(0);
        if (integer.intValue() != 0) goto _L2; else goto _L1
_L1:
        Object obj = (AtomicInteger)openRealms.get(Integer.valueOf(i));
        if (obj != null) goto _L4; else goto _L3
_L3:
        openRealms.put(Integer.valueOf(i), new AtomicInteger(1));
_L2:
        Map map1;
        map1 = (Map)realmsCache.get();
        obj = (Realm)map1.get(Integer.valueOf(s.hashCode()));
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (!Arrays.equals(((Realm) (obj)).key, abyte0))
        {
            throw new IllegalStateException("Wrong key used to decrypt Realm.");
        }
          goto _L7
        s;
        io/realm/Realm;
        JVM INSTR monitorexit ;
        throw s;
_L4:
        ((AtomicInteger) (obj)).incrementAndGet();
          goto _L2
_L7:
        map.put(Integer.valueOf(i), Integer.valueOf(integer.intValue() + 1));
        s = ((String) (obj));
_L9:
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return s;
_L6:
        abyte0 = new Realm(s, abyte0, flag1);
        map1.put(Integer.valueOf(s.hashCode()), abyte0);
        realmsCache.set(map1);
        map.put(Integer.valueOf(i), Integer.valueOf(integer.intValue() + 1));
        s = abyte0;
        if (!flag) goto _L9; else goto _L8
_L8:
        initializeRealm(abyte0);
        s = abyte0;
          goto _L9
        s;
        abyte0.close();
        throw s;
    }

    private RealmObject createStandaloneRealmObjectInstance(Class class1)
    {
        RealmObject realmobject;
        try
        {
            realmobject = (RealmObject)class1.newInstance();
        }
        catch (InstantiationException instantiationexception)
        {
            throw new RealmException((new StringBuilder("Could not create an object of class: ")).append(class1).toString(), instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RealmException((new StringBuilder("Could not create an object of class: ")).append(class1).toString(), illegalaccessexception);
        }
        return realmobject;
    }

    public static boolean deleteRealmFile(Context context)
    {
        return deleteRealmFile(context, "default.realm");
    }

    public static boolean deleteRealmFile(Context context, String s)
    {
        boolean flag = true;
        io/realm/Realm;
        JVM INSTR monitorenter ;
        File file;
        AtomicInteger atomicinteger;
        context = context.getFilesDir();
        file = new File(context, s);
        int i = file.getAbsolutePath().hashCode();
        atomicinteger = (AtomicInteger)openRealms.get(Integer.valueOf(i));
        if (atomicinteger == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (atomicinteger.get() > 0)
        {
            throw new IllegalStateException("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file.");
        }
        break MISSING_BLOCK_LABEL_75;
        context;
        io/realm/Realm;
        JVM INSTR monitorexit ;
        throw context;
        context = Arrays.asList(new File[] {
            file, new File(context, (new StringBuilder()).append(s).append(".lock").toString())
        }).iterator();
_L1:
        do
        {
            if (!context.hasNext())
            {
                break MISSING_BLOCK_LABEL_185;
            }
            s = (File)context.next();
        } while (!s.exists() || s.delete());
        Log.w("REALM", (new StringBuilder("Could not delete the file ")).append(s).toString());
        flag = false;
          goto _L1
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return flag;
    }

    private String getClassSimpleName(Class class1)
    {
        String s1 = (String)simpleClassNames.get(class1);
        String s = s1;
        if (s1 == null)
        {
            s = class1.getSimpleName();
            simpleClassNames.put(class1, s);
        }
        return s;
    }

    public static Realm getInstance(Context context)
    {
        return getInstance(context, "default.realm");
    }

    public static Realm getInstance(Context context, String s)
    {
        return getInstance(context, s, null);
    }

    public static Realm getInstance(Context context, String s, byte abyte0[])
    {
        return create(context.getFilesDir(), s, abyte0);
    }

    public static Realm getInstance(Context context, byte abyte0[])
    {
        return getInstance(context, "default.realm", abyte0);
    }

    public static Realm getInstance(File file)
    {
        return create(file, "default.realm", null);
    }

    public static Realm getInstance(File file, String s)
    {
        return create(file, s, null);
    }

    public static Realm getInstance(File file, String s, byte abyte0[])
    {
        return create(file, s, abyte0);
    }

    public static Realm getInstance(File file, byte abyte0[])
    {
        return create(file, "default.realm", abyte0);
    }

    private Class getProxyClass(Class class1)
    {
        String s = getProxyClassName(getClassSimpleName(class1));
        Class class2 = (Class)generatedClasses.get(s);
        class1 = class2;
        if (class2 == null)
        {
            try
            {
                class1 = Class.forName(s);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RealmException("Could not find the generated proxy class: Annotation processor may not have been executed.");
            }
            generatedClasses.put(s, class1);
        }
        return class1;
    }

    private static String getProxyClassName(String s)
    {
        return (new StringBuilder("io.realm.")).append(s).append("RealmProxy").toString();
    }

    private Class getRealmClassFromObject(RealmObject realmobject)
    {
        if (realmobject.realm != null)
        {
            return realmobject.getClass().getSuperclass();
        } else
        {
            return realmobject.getClass();
        }
    }

    private static void initializeRealm(Realm realm)
    {
        Object obj;
        boolean flag;
        boolean flag1;
        boolean flag2;
        long l;
        try
        {
            obj = Class.forName("io.realm.ValidationList");
        }
        // Misplaced declaration of an exception variable
        catch (Realm realm)
        {
            throw new RealmException("Could not find the generated ValidationList class: Annotation processor may not have been executed.");
        }
        try
        {
            obj = ((Class) (obj)).getMethod("getProxyClasses", new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Realm realm)
        {
            throw new RealmException("Could not find the getProxyClasses method in the ValidationList class: Annotation processor may not have been executed.");
        }
        try
        {
            obj = (List)((Method) (obj)).invoke(null, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Realm realm)
        {
            throw new RealmException("Could not execute the getProxyClasses method in the ValidationList class: Annotation processor may not have been executed.");
        }
        // Misplaced declaration of an exception variable
        catch (Realm realm)
        {
            throw new RealmException("An exception was thrown in the getProxyClasses method in the ValidationList class: Annotation processor may not have been executed.");
        }
        if (customSchema.size() > 0)
        {
            obj = new ArrayList();
            for (Iterator iterator = customSchema.iterator(); iterator.hasNext(); ((List) (obj)).add(((Class)iterator.next()).getName())) { }
        }
        l = realm.getVersion();
        flag2 = false;
        flag1 = false;
        flag = flag2;
        realm.beginTransaction();
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        flag = flag2;
        realm.setVersion(0L);
        flag1 = true;
        flag = flag1;
        Iterator iterator1 = ((List) (obj)).iterator();
_L10:
        flag = flag1;
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        flag = flag1;
        String as[] = ((String)iterator1.next()).split("\\.");
        flag = flag1;
        String s = as[as.length - 1];
        flag = flag1;
        as = getProxyClassName(s);
        flag = flag1;
        Object obj1 = Class.forName(as);
        if (l != -1L) goto _L4; else goto _L3
_L3:
        flag = flag1;
        Object obj3 = ((Class) (obj1)).getMethod("initTable", new Class[] {
            io/realm/internal/ImplicitTransaction
        });
        flag = flag1;
        ((Method) (obj3)).invoke(null, new Object[] {
            realm.transaction
        });
        flag = true;
_L11:
        obj3 = ((Class) (obj1)).getMethod("validateTable", new Class[] {
            io/realm/internal/ImplicitTransaction
        });
        ((Method) (obj3)).invoke(null, new Object[] {
            realm.transaction
        });
        obj1 = ((Class) (obj1)).getMethod("getFieldNames", new Class[0]);
        obj1 = (List)((Method) (obj1)).invoke(null, new Object[0]);
        Iterator iterator2;
        obj3 = realm.transaction.getTable((new StringBuilder("class_")).append(s).toString());
        iterator2 = ((List) (obj1)).iterator();
_L9:
        if (!iterator2.hasNext()) goto _L6; else goto _L5
_L5:
        String s1;
        long l1;
        s1 = (String)iterator2.next();
        l1 = ((Table) (obj3)).getColumnIndex(s1);
        if (l1 != -1L) goto _L8; else goto _L7
_L7:
        throw new RealmMigrationNeededException((new StringBuilder("Field '")).append(s1).append("' not found for type '").append(s).append("'").toString());
        as;
_L12:
        Object obj2;
        Map map;
        if (flag)
        {
            realm.commitTransaction();
        } else
        {
            realm.cancelTransaction();
        }
        throw as;
        obj2;
        flag = flag1;
        throw new RealmException((new StringBuilder("Could not find the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        flag = flag1;
        throw new RealmException((new StringBuilder("Could not find the initTable method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        flag = flag1;
        throw new RealmException((new StringBuilder("Could not execute the initTable method in the ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        flag = flag1;
        throw new RealmException((new StringBuilder("An exception was thrown in the initTable method in the ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        throw new RealmException((new StringBuilder("Could not find the validateTable method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        throw new RealmException((new StringBuilder("Could not execute the validateTable method in the ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        as;
        throw new RealmMigrationNeededException(as.getMessage(), as);
        obj2;
        throw new RealmException((new StringBuilder("Could not find the getFieldNames method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        throw new RealmException((new StringBuilder("Could not execute the getFieldNames method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
        obj2;
        throw new RealmException((new StringBuilder("An exception was thrown in the getFieldNames method in the generated ")).append(as).append(" class: Annotation processor may not have been executed.").toString());
_L8:
        map = (Map)columnIndices.get(s);
        as = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_849;
        }
        as = new HashMap();
        as.put(s1, Long.valueOf(l1));
        columnIndices.put(s, as);
          goto _L9
_L6:
        flag1 = flag;
          goto _L10
_L2:
        if (flag1)
        {
            realm.commitTransaction();
            return;
        } else
        {
            realm.cancelTransaction();
            return;
        }
_L4:
        flag = flag1;
          goto _L11
        as;
          goto _L12
    }

    private boolean isObjectInRealm(RealmObject realmobject)
    {
        return realmobject.realm != null && realmobject.realm.id == id;
    }

    public static void migrateRealmAtPath(String s, RealmMigration realmmigration)
    {
        migrateRealmAtPath(s, null, realmmigration, true);
    }

    public static void migrateRealmAtPath(String s, RealmMigration realmmigration, boolean flag)
    {
        migrateRealmAtPath(s, null, realmmigration, flag);
    }

    public static void migrateRealmAtPath(String s, byte abyte0[], RealmMigration realmmigration)
    {
        migrateRealmAtPath(s, abyte0, realmmigration, true);
    }

    public static void migrateRealmAtPath(String s, byte abyte0[], RealmMigration realmmigration, boolean flag)
    {
        io/realm/Realm;
        JVM INSTR monitorenter ;
        s = createAndValidate(s, abyte0, false, flag);
        s.beginTransaction();
        s.setVersion(realmmigration.execute(s, s.getVersion()));
        s.commitTransaction();
        s.close();
        realmsCache.remove();
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void removeHandler(Handler handler1)
    {
        handler1.removeCallbacksAndMessages(null);
        handlers.remove(handler1);
    }

    static transient void setSchema(Class aclass[])
    {
        customSchema.clear();
        if (aclass != null)
        {
            Collections.addAll(customSchema, aclass);
        }
    }

    public final void addChangeListener(RealmChangeListener realmchangelistener)
    {
        checkIfValid();
        changeListeners.add(realmchangelistener);
    }

    public final RealmResults allObjects(Class class1)
    {
        return where(class1).findAll();
    }

    public final RealmResults allObjectsSorted(Class class1, String s, boolean flag)
    {
        checkIfValid();
        Table table = getTable(class1);
        io.realm.internal.TableView.Order order;
        Long long1;
        if (flag)
        {
            order = io.realm.internal.TableView.Order.ascending;
        } else
        {
            order = io.realm.internal.TableView.Order.descending;
        }
        long1 = (Long)((Map)columnIndices.get(getClassSimpleName(class1))).get(s);
        if (long1 == null || long1.longValue() < 0L)
        {
            throw new IllegalArgumentException(String.format("Field name '%s' does not exist.", new Object[] {
                s
            }));
        } else
        {
            return new RealmResults(this, table.getSortedView(long1.longValue(), order), class1);
        }
    }

    public final RealmResults allObjectsSorted(Class class1, String s, boolean flag, String s1, boolean flag1)
    {
        return allObjectsSorted(class1, new String[] {
            s, s1
        }, new boolean[] {
            flag, flag1
        });
    }

    public final RealmResults allObjectsSorted(Class class1, String s, boolean flag, String s1, boolean flag1, String s2, boolean flag2)
    {
        return allObjectsSorted(class1, new String[] {
            s, s1, s2
        }, new boolean[] {
            flag, flag1, flag2
        });
    }

    public final RealmResults allObjectsSorted(Class class1, String as[], boolean aflag[])
    {
        if (as == null)
        {
            throw new IllegalArgumentException("fieldNames must be provided.");
        }
        if (aflag == null)
        {
            throw new IllegalArgumentException("sortAscending must be provided.");
        }
        Table table = getTable(class1);
        long al[] = new long[as.length];
        for (int i = 0; i < as.length; i++)
        {
            String s = as[i];
            long l = table.getColumnIndex(s);
            if (l == -1L)
            {
                throw new IllegalArgumentException(String.format("Field name '%s' does not exist.", new Object[] {
                    s
                }));
            }
            al[i] = l;
        }

        return new RealmResults(this, table.getSortedView(al, aflag), class1);
    }

    public final void beginTransaction()
    {
        checkIfValid();
        transaction.promoteToWrite();
    }

    public final void cancelTransaction()
    {
        checkIfValid();
        transaction.rollbackAndContinueAsRead();
    }

    protected final void checkIfValid()
    {
        if (sharedGroup == null)
        {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        }
        if ((Realm)((Map)realmsCache.get()).get(Integer.valueOf(id)) != this)
        {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they where created.");
        } else
        {
            return;
        }
    }

    public final void clear(Class class1)
    {
        getTable(class1).clear();
    }

    public final void close()
    {
        Map map = (Map)referenceCount.get();
        Integer integer = (Integer)map.get(Integer.valueOf(id));
        if (integer == null)
        {
            integer = Integer.valueOf(0);
        }
        if (sharedGroup != null && integer.intValue() == 1)
        {
            ((Map)realmsCache.get()).remove(Integer.valueOf(id));
            sharedGroup.close();
            sharedGroup = null;
            ((AtomicInteger)openRealms.get(Integer.valueOf(id))).decrementAndGet();
        }
        int i = integer.intValue() - 1;
        if (i < 0)
        {
            RealmLog.w((new StringBuilder("Calling close() on a Realm that is already closed: ")).append(getPath()).toString());
        }
        map.put(Integer.valueOf(id), Integer.valueOf(Math.max(0, i)));
        if (handler != null && i <= 0)
        {
            removeHandler(handler);
        }
    }

    public final void commitTransaction()
    {
        checkIfValid();
        transaction.commitAndContinueAsRead();
        Iterator iterator = handlers.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Handler handler1 = (Handler)entry.getKey();
            if (((Integer)entry.getValue()).intValue() == id && !handler1.hasMessages(0xe3d1b0) && handler1.getLooper().getThread().isAlive() && !handler1.equals(handler))
            {
                handler1.sendEmptyMessage(0xe3d1b0);
            }
        } while (true);
        sendNotifications();
    }

    final boolean contains(Class class1)
    {
        return transaction.hasTable((new StringBuilder("class_")).append(getClassSimpleName(class1)).toString());
    }

    public final RealmObject copyToRealm(RealmObject realmobject)
    {
        checkNotNullObject(realmobject);
        if (isObjectInRealm(realmobject))
        {
            return realmobject;
        } else
        {
            return copyOrUpdate(realmobject, false);
        }
    }

    public final List copyToRealm(Iterable iterable)
    {
        if (iterable == null)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add(copyToRealm((RealmObject)iterable.next()))) { }
        return arraylist;
    }

    public final RealmObject copyToRealmOrUpdate(RealmObject realmobject)
    {
        checkNotNullObject(realmobject);
        checkHasPrimaryKey(realmobject);
        if (isObjectInRealm(realmobject))
        {
            return realmobject;
        } else
        {
            return copyOrUpdate(realmobject, true);
        }
    }

    public final List copyToRealmOrUpdate(Iterable iterable)
    {
        if (iterable == null)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add(copyToRealmOrUpdate((RealmObject)iterable.next()))) { }
        return arraylist;
    }

    public final void createAllFromJson(Class class1, InputStream inputstream)
    {
        if (class1 == null || inputstream == null)
        {
            return;
        }
        inputstream = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
        inputstream.beginArray();
        RealmObject realmobject;
        for (; inputstream.hasNext(); realmJson.populateUsingJsonStream(realmobject, inputstream))
        {
            realmobject = createObject(class1);
        }

        break MISSING_BLOCK_LABEL_66;
        class1;
        inputstream.close();
        throw class1;
        inputstream.endArray();
        inputstream.close();
        return;
    }

    public final void createAllFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return;
        }
        try
        {
            s = new JSONArray(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create JSON array from string", class1);
        }
        createAllFromJson(class1, ((JSONArray) (s)));
    }

    public final void createAllFromJson(Class class1, JSONArray jsonarray)
    {
        if (class1 != null && jsonarray != null)
        {
            int i = 0;
            while (i < jsonarray.length()) 
            {
                RealmObject realmobject = createObject(class1);
                try
                {
                    realmJson.populateUsingJsonObject(realmobject, jsonarray.getJSONObject(i));
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not map Json", class1);
                }
                i++;
            }
        }
    }

    public final RealmObject createObject(Class class1)
    {
        Table table = (Table)tables.get(class1);
        Object obj = table;
        if (table == null)
        {
            Class class2 = getProxyClass(class1);
            Method method = (Method)initTableMethods.get(class2);
            obj = method;
            if (method == null)
            {
                try
                {
                    obj = class2.getMethod("initTable", new Class[] {
                        io/realm/internal/ImplicitTransaction
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not find the initTable() method in generated proxy class: Annotation processor may not have been executed.");
                }
                initTableMethods.put(class2, obj);
            }
            try
            {
                obj = (Table)((Method) (obj)).invoke(null, new Object[] {
                    transaction
                });
                tables.put(class1, obj);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RealmException("Could not launch the initTable method: Annotation processor may not have been executed.");
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                class1.printStackTrace();
                throw new RealmException("An exception occurred while running the initTable method: Annotation processor may not have been executed.");
            }
        }
        return get(class1, ((Table) (obj)).addEmptyRow());
    }

    public final RealmObject createObjectFromJson(Class class1, InputStream inputstream)
    {
        if (class1 == null || inputstream == null)
        {
            return null;
        }
        inputstream = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
        class1 = createObject(class1);
        realmJson.populateUsingJsonStream(class1, inputstream);
        inputstream.close();
        return class1;
        class1;
        inputstream.close();
        throw class1;
    }

    public final RealmObject createObjectFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return null;
        }
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create Json object from string", class1);
        }
        return createObjectFromJson(class1, ((JSONObject) (s)));
    }

    public final RealmObject createObjectFromJson(Class class1, JSONObject jsonobject)
    {
        if (class1 == null || jsonobject == null)
        {
            return null;
        }
        class1 = createObject(class1);
        try
        {
            realmJson.populateUsingJsonObject(class1, jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not map Json", class1);
        }
        return class1;
    }

    public final void createOrUpdateAllFromJson(Class class1, InputStream inputstream)
    {
        if (class1 == null || inputstream == null)
        {
            return;
        }
        checkHasPrimaryKey(class1);
        inputstream = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
        inputstream.beginArray();
        RealmObject realmobject;
        for (; inputstream.hasNext(); copyToRealmOrUpdate(realmobject))
        {
            realmobject = createStandaloneRealmObjectInstance(class1);
            realmJson.populateUsingJsonStream(realmobject, inputstream);
        }

        break MISSING_BLOCK_LABEL_77;
        class1;
        inputstream.close();
        throw class1;
        inputstream.endArray();
        inputstream.close();
        return;
    }

    public final void createOrUpdateAllFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return;
        }
        checkHasPrimaryKey(class1);
        try
        {
            s = new JSONArray(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create JSON array from string", class1);
        }
        createOrUpdateAllFromJson(class1, ((JSONArray) (s)));
    }

    public final void createOrUpdateAllFromJson(Class class1, JSONArray jsonarray)
    {
        if (class1 != null && jsonarray != null)
        {
            checkHasPrimaryKey(class1);
            int i = 0;
            while (i < jsonarray.length()) 
            {
                RealmObject realmobject = createStandaloneRealmObjectInstance(class1);
                try
                {
                    realmJson.populateUsingJsonObject(realmobject, jsonarray.getJSONObject(i));
                    copyToRealmOrUpdate(realmobject);
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not map Json", class1);
                }
                i++;
            }
        }
    }

    public final RealmObject createOrUpdateObjectFromJson(Class class1, InputStream inputstream)
    {
        if (class1 == null || inputstream == null)
        {
            return null;
        }
        checkHasPrimaryKey(class1);
        class1 = createStandaloneRealmObjectInstance(class1);
        inputstream = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
        try
        {
            realmJson.populateUsingJsonStream(class1, inputstream);
            copyToRealmOrUpdate(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create Json object from string", class1);
        }
        return class1;
    }

    public final RealmObject createOrUpdateObjectFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return null;
        }
        checkHasPrimaryKey(class1);
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create Json object from string", class1);
        }
        return createOrUpdateObjectFromJson(class1, ((JSONObject) (s)));
    }

    public final RealmObject createOrUpdateObjectFromJson(Class class1, JSONObject jsonobject)
    {
        if (class1 == null || jsonobject == null)
        {
            return null;
        }
        checkHasPrimaryKey(class1);
        class1 = createStandaloneRealmObjectInstance(class1);
        try
        {
            realmJson.populateUsingJsonObject(class1, jsonobject);
            copyToRealmOrUpdate(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not map Json", class1);
        }
        return class1;
    }

    public final void executeTransaction(Transaction transaction1)
    {
        if (transaction1 == null)
        {
            return;
        }
        beginTransaction();
        try
        {
            transaction1.execute(this);
            commitTransaction();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Transaction transaction1)
        {
            cancelTransaction();
            throw new RealmException("Error during transaction.", transaction1);
        }
        // Misplaced declaration of an exception variable
        catch (Transaction transaction1)
        {
            cancelTransaction();
        }
        throw transaction1;
    }

    protected final void finalize()
    {
        if (sharedGroup != null)
        {
            RealmLog.w((new StringBuilder("Remember to call close() on all Realm instances. Realm ")).append(path).append(" is being finalized without being closed, this can lead to running out of native memory.").toString());
        }
        super.finalize();
    }

    final RealmObject get(Class class1, long l)
    {
        Object obj1 = (Table)tables.get(class1);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = getClassSimpleName(class1);
            obj = transaction.getTable((new StringBuilder("class_")).append(((String) (obj))).toString());
            tables.put(class1, obj);
        }
        io.realm.internal.Row row = ((Table) (obj)).getRow(l);
        obj1 = (Constructor)generatedConstructors.get(class1);
        obj = obj1;
        if (obj1 == null)
        {
            Object obj3 = getProxyClassName(getClassSimpleName(class1));
            obj = (Class)generatedClasses.get(obj3);
            Object obj2 = obj;
            if (obj == null)
            {
                try
                {
                    obj2 = Class.forName(((String) (obj3)));
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not find the generated proxy class: Annotation processor may not have been executed.");
                }
                generatedClasses.put(obj3, obj2);
            }
            obj3 = (Constructor)constructors.get(obj2);
            obj = obj3;
            if (obj3 == null)
            {
                try
                {
                    obj = ((Class) (obj2)).getConstructor(new Class[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not find the constructor in generated proxy class: Annotation processor may not have been executed.");
                }
                constructors.put(obj2, obj);
                generatedConstructors.put(class1, obj);
            }
        }
        try
        {
            class1 = (RealmObject)((Constructor) (obj)).newInstance(new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not instantiate the proxy class");
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not run the constructor of the proxy class");
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            throw new RealmException("An exception occurred while instantiating the proxy class");
        }
        class1.row = row;
        class1.realm = this;
        return class1;
    }

    final Handler getHandler()
    {
        for (Iterator iterator = handlers.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Integer)entry.getValue()).intValue() == id)
            {
                return (Handler)entry.getKey();
            }
        }

        return null;
    }

    final int getId()
    {
        return id;
    }

    public final String getPath()
    {
        return path;
    }

    public final RealmJson getRealmJson()
    {
        Object obj;
        try
        {
            obj = Class.forName("io.realm.RealmJsonImpl").getDeclaredConstructors()[0];
            ((Constructor) (obj)).setAccessible(true);
            obj = (RealmJson)((Constructor) (obj)).newInstance(new Object[0]);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RealmException("Could not find io.realm.RealmJsonImpl", classnotfoundexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RealmException("Could not create an instance of io.realm.RealmJsonImpl", invocationtargetexception);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new RealmException("Could not create an instance of io.realm.RealmJsonImpl", instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RealmException("Could not create an instance of io.realm.RealmJsonImpl", illegalaccessexception);
        }
        return ((RealmJson) (obj));
    }

    public final Table getTable(Class class1)
    {
        String s1 = (String)proxiedClassNames.get(class1);
        String s = s1;
        if (s1 == null)
        {
            s = class1.getSimpleName().replace("RealmProxy", "");
            proxiedClassNames.put(class1, s);
        }
        return transaction.getTable((new StringBuilder("class_")).append(s).toString());
    }

    final long getVersion()
    {
        if (!transaction.hasTable("metadata"))
        {
            return -1L;
        } else
        {
            return transaction.getTable("metadata").getLong(0L, 0L);
        }
    }

    final boolean hasChanged()
    {
        return sharedGroup.hasChanged();
    }

    public final boolean isAutoRefresh()
    {
        return autoRefresh;
    }

    public final void refresh()
    {
        checkIfValid();
        transaction.advanceRead();
    }

    final void remove(Class class1, long l)
    {
        getTable(class1).moveLastOver(l);
    }

    public final void removeAllChangeListeners()
    {
        checkIfValid();
        changeListeners.clear();
    }

    public final void removeChangeListener(RealmChangeListener realmchangelistener)
    {
        checkIfValid();
        changeListeners.remove(realmchangelistener);
    }

    final void sendNotifications()
    {
        for (Iterator iterator = (new ArrayList(changeListeners)).iterator(); iterator.hasNext(); ((RealmChangeListener)iterator.next()).onChange()) { }
    }

    public final void setAutoRefresh(boolean flag)
    {
        if (flag && Looper.myLooper() == null)
        {
            throw new IllegalStateException("Cannot set auto-refresh in a Thread without a Looper");
        }
        if (!flag || autoRefresh) goto _L2; else goto _L1
_L1:
        handler = new Handler(new RealmCallback(null));
        handlers.put(handler, Integer.valueOf(id));
_L4:
        autoRefresh = flag;
        return;
_L2:
        if (!flag && autoRefresh && handler != null)
        {
            removeHandler(handler);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void setVersion(long l)
    {
        Table table = transaction.getTable("metadata");
        if (table.getColumnCount() == 0L)
        {
            table.addColumn(ColumnType.INTEGER, "version");
            table.addEmptyRow();
        }
        table.setLong(0L, 0L, l);
    }

    public final RealmQuery where(Class class1)
    {
        checkIfValid();
        return new RealmQuery(this, class1);
    }

    public final void writeCopyTo(File file)
    {
        writeEncryptedCopyTo(file, null);
    }

    public final void writeEncryptedCopyTo(File file, byte abyte0[])
    {
        if (file == null)
        {
            throw new IllegalArgumentException("The destination argument cannot be null");
        } else
        {
            checkIfValid();
            transaction.writeToFile(file, abyte0);
            return;
        }
    }

    static 
    {
        defaultDurability = io.realm.internal.SharedGroup.Durability.FULL;
        RealmLog.add(new ReleaseAndroidLogger());
    }


    private class Transaction
    {

        public abstract void execute(Realm realm);
    }


    private class RealmCallback
        implements android.os.Handler.Callback
    {

        final Realm this$0;

        public boolean handleMessage(Message message)
        {
            if (message.what == 0xe3d1b0)
            {
                transaction.advanceRead();
                sendNotifications();
            }
            return true;
        }

        private RealmCallback()
        {
            this$0 = Realm.this;
            super();
        }

        RealmCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final Map initialValue()
        {
            return new HashMap();
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final Map initialValue()
        {
            return new HashMap();
        }

        _cls2()
        {
        }
    }

}
