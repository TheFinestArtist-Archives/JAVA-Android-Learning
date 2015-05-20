// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

// Referenced classes of package crittercism.android:
//            cb, cc

public final class j
{

    public static Object a(Field field, Object obj)
    {
        while (field == null || field == null) 
        {
            return null;
        }
        field.setAccessible(true);
        try
        {
            field = ((Field) (field.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new cb(cc.j);
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new cb(cc.i);
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new cb(cc.h);
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new cb(cc.k);
        }
        return field;
    }

    public static Field a(Class class1, Class class2)
    {
        Field afield[] = class1.getDeclaredFields();
        class1 = null;
        for (int i = 0; i < afield.length;)
        {
            Object obj = class1;
            if (class2.isAssignableFrom(afield[i].getType()))
            {
                if (class1 != null)
                {
                    throw new cb(cc.l);
                }
                obj = afield[i];
            }
            i++;
            class1 = ((Class) (obj));
        }

        if (class1 == null)
        {
            throw new cb(cc.g);
        } else
        {
            class1.setAccessible(true);
            return class1;
        }
    }

    public static void a(AccessibleObject aaccessibleobject[])
    {
        for (int i = 0; i < aaccessibleobject.length; i++)
        {
            AccessibleObject accessibleobject = aaccessibleobject[i];
            if (accessibleobject != null)
            {
                accessibleobject.setAccessible(true);
            }
        }

    }
}
