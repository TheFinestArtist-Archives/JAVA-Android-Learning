// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package org.apache.thrift:
//            TEnum

public class TEnumHelper
{

    public TEnumHelper()
    {
    }

    public static TEnum getByValue(Class class1, int i)
    {
        try
        {
            class1 = (TEnum)class1.getMethod("findByValue", new Class[] {
                Integer.TYPE
            }).invoke(null, new Object[] {
                Integer.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }
}
