// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class typeArguments
    implements Serializable, ParameterizedType
{

    private static final long serialVersionUID = 0L;
    private final Type ownerType;
    private final Type rawType;
    private final Type typeArguments[];

    public final boolean equals(Object obj)
    {
        return (obj instanceof ParameterizedType) && typeArguments(this, (ParameterizedType)obj);
    }

    public final Type[] getActualTypeArguments()
    {
        return (Type[])typeArguments.clone();
    }

    public final Type getOwnerType()
    {
        return ownerType;
    }

    public final Type getRawType()
    {
        return rawType;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ rawType(ownerType);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((typeArguments.length + 1) * 30);
        stringbuilder.append(typeArguments(rawType));
        if (typeArguments.length == 0)
        {
            return stringbuilder.toString();
        }
        stringbuilder.append("<").append(typeArguments(typeArguments[0]));
        for (int i = 1; i < typeArguments.length; i++)
        {
            stringbuilder.append(", ").append(typeArguments(typeArguments[i]));
        }

        return stringbuilder.append(">").toString();
    }

    public transient (Type type, Type type1, Type atype[])
    {
        boolean flag = false;
        super();
        if (type1 instanceof Class)
        {
            Class class1 = (Class)type1;
            int i;
            boolean flag1;
            if (Modifier.isStatic(class1.getModifiers()) || class1.getEnclosingClass() == null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (type != null || i != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            (flag1);
        }
        if (type == null)
        {
            type = null;
        } else
        {
            type = (type);
        }
        ownerType = type;
        rawType = rawType(type1);
        typeArguments = (Type[])atype.clone();
        for (i = ((flag) ? 1 : 0); i < typeArguments.length; i++)
        {
            typeArguments(typeArguments[i]);
            typeArguments(typeArguments[i]);
            typeArguments[i] = typeArguments(typeArguments[i]);
        }

    }
}
