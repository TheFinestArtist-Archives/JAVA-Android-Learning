// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;

// Referenced classes of package org.apache.commons.lang3.reflect:
//            MemberUtils

public class FieldUtils
{

    public FieldUtils()
    {
    }

    public static Field getDeclaredField(Class class1, String s)
    {
        return getDeclaredField(class1, s, false);
    }

    public static Field getDeclaredField(Class class1, String s, boolean flag)
    {
        Object obj;
        obj = null;
        if (class1 == null)
        {
            throw new IllegalArgumentException("The class must not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("The field name must not be null");
        }
        s = class1.getDeclaredField(s);
        if (!MemberUtils.isAccessible(s))
        {
            class1 = obj;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            try
            {
                s.setAccessible(true);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                return null;
            }
        }
        class1 = s;
        return class1;
    }

    public static Field getField(Class class1, String s)
    {
        class1 = getField(class1, s, false);
        MemberUtils.setAccessibleWorkaround(class1);
        return class1;
    }

    public static Field getField(Class class1, String s, boolean flag)
    {
        Object obj;
        if (class1 == null)
        {
            throw new IllegalArgumentException("The class must not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("The field name must not be null");
        }
        obj = class1;
_L3:
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj2 = ((Class) (obj)).getDeclaredField(s);
        Object obj1 = obj2;
        if (Modifier.isPublic(((Field) (obj2)).getModifiers()))
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((Field) (obj2)).setAccessible(true);
        obj1 = obj2;
_L5:
        return ((Field) (obj1));
        obj1;
        obj = ((Class) (obj)).getSuperclass();
          goto _L3
_L2:
        obj2 = ClassUtils.getAllInterfaces(class1).iterator();
        obj = null;
_L6:
        obj1 = obj;
        if (!((Iterator) (obj2)).hasNext()) goto _L5; else goto _L4
_L4:
        obj1 = (Class)((Iterator) (obj2)).next();
        obj1 = ((Class) (obj1)).getField(s);
        if (obj != null)
        {
            try
            {
                throw new IllegalArgumentException((new StringBuilder("Reference to field ")).append(s).append(" is ambiguous relative to ").append(class1).append("; a matching field exists on two or more implemented interfaces.").toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        } else
        {
            obj = obj1;
        }
          goto _L6
    }

    public static Object readDeclaredField(Object obj, String s)
    {
        return readDeclaredField(obj, s, false);
    }

    public static Object readDeclaredField(Object obj, String s, boolean flag)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class class1 = obj.getClass();
        Field field = getDeclaredField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate declared field ")).append(class1.getName()).append(".").append(s).toString());
        } else
        {
            return readField(field, obj);
        }
    }

    public static Object readDeclaredStaticField(Class class1, String s)
    {
        return readDeclaredStaticField(class1, s, false);
    }

    public static Object readDeclaredStaticField(Class class1, String s, boolean flag)
    {
        Field field = getDeclaredField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate declared field ")).append(class1.getName()).append(".").append(s).toString());
        } else
        {
            return readStaticField(field, false);
        }
    }

    public static Object readField(Object obj, String s)
    {
        return readField(obj, s, false);
    }

    public static Object readField(Object obj, String s, boolean flag)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class class1 = obj.getClass();
        Field field = getField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate field ")).append(s).append(" on ").append(class1).toString());
        } else
        {
            return readField(field, obj);
        }
    }

    public static Object readField(Field field, Object obj)
    {
        return readField(field, obj, false);
    }

    public static Object readField(Field field, Object obj, boolean flag)
    {
        if (field == null)
        {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (flag && !field.isAccessible())
        {
            field.setAccessible(true);
        } else
        {
            MemberUtils.setAccessibleWorkaround(field);
        }
        return field.get(obj);
    }

    public static Object readStaticField(Class class1, String s)
    {
        return readStaticField(class1, s, false);
    }

    public static Object readStaticField(Class class1, String s, boolean flag)
    {
        Field field = getField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate field ")).append(s).append(" on ").append(class1).toString());
        } else
        {
            return readStaticField(field, false);
        }
    }

    public static Object readStaticField(Field field)
    {
        return readStaticField(field, false);
    }

    public static Object readStaticField(Field field, boolean flag)
    {
        if (field == null)
        {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!Modifier.isStatic(field.getModifiers()))
        {
            throw new IllegalArgumentException((new StringBuilder("The field '")).append(field.getName()).append("' is not static").toString());
        } else
        {
            return readField(field, null, flag);
        }
    }

    public static void writeDeclaredField(Object obj, String s, Object obj1)
    {
        writeDeclaredField(obj, s, obj1, false);
    }

    public static void writeDeclaredField(Object obj, String s, Object obj1, boolean flag)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class class1 = obj.getClass();
        Field field = getDeclaredField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate declared field ")).append(class1.getName()).append(".").append(s).toString());
        } else
        {
            writeField(field, obj, obj1);
            return;
        }
    }

    public static void writeDeclaredStaticField(Class class1, String s, Object obj)
    {
        writeDeclaredStaticField(class1, s, obj, false);
    }

    public static void writeDeclaredStaticField(Class class1, String s, Object obj, boolean flag)
    {
        Field field = getDeclaredField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate declared field ")).append(class1.getName()).append(".").append(s).toString());
        } else
        {
            writeField(field, null, obj);
            return;
        }
    }

    public static void writeField(Object obj, String s, Object obj1)
    {
        writeField(obj, s, obj1, false);
    }

    public static void writeField(Object obj, String s, Object obj1, boolean flag)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class class1 = obj.getClass();
        Field field = getField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate declared field ")).append(class1.getName()).append(".").append(s).toString());
        } else
        {
            writeField(field, obj, obj1);
            return;
        }
    }

    public static void writeField(Field field, Object obj, Object obj1)
    {
        writeField(field, obj, obj1, false);
    }

    public static void writeField(Field field, Object obj, Object obj1, boolean flag)
    {
        if (field == null)
        {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (flag && !field.isAccessible())
        {
            field.setAccessible(true);
        } else
        {
            MemberUtils.setAccessibleWorkaround(field);
        }
        field.set(obj, obj1);
    }

    public static void writeStaticField(Class class1, String s, Object obj)
    {
        writeStaticField(class1, s, obj, false);
    }

    public static void writeStaticField(Class class1, String s, Object obj, boolean flag)
    {
        Field field = getField(class1, s, flag);
        if (field == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot locate field ")).append(s).append(" on ").append(class1).toString());
        } else
        {
            writeStaticField(field, obj);
            return;
        }
    }

    public static void writeStaticField(Field field, Object obj)
    {
        writeStaticField(field, obj, false);
    }

    public static void writeStaticField(Field field, Object obj, boolean flag)
    {
        if (field == null)
        {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!Modifier.isStatic(field.getModifiers()))
        {
            throw new IllegalArgumentException((new StringBuilder("The field '")).append(field.getName()).append("' is not static").toString());
        } else
        {
            writeField(field, null, obj, flag);
            return;
        }
    }
}
