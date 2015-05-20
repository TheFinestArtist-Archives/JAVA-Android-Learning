// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ClassUtils;

public class TypeUtils
{

    public TypeUtils()
    {
    }

    public static Map determineTypeArguments(Class class1, ParameterizedType parameterizedtype)
    {
        do
        {
            Object obj = getRawType(parameterizedtype);
            if (!isAssignable(class1, ((Class) (obj))))
            {
                return null;
            }
            if (class1.equals(obj))
            {
                return getTypeArguments(parameterizedtype, ((Class) (obj)), null);
            }
            obj = getClosestParentType(class1, ((Class) (obj)));
            if (obj instanceof Class)
            {
                class1 = (Class)obj;
            } else
            {
                obj = (ParameterizedType)obj;
                parameterizedtype = determineTypeArguments(getRawType(((ParameterizedType) (obj))), parameterizedtype);
                mapTypeVariablesToArguments(class1, ((ParameterizedType) (obj)), parameterizedtype);
                return parameterizedtype;
            }
        } while (true);
    }

    public static Type getArrayComponentType(Type type)
    {
        Class class1 = null;
        if (type instanceof Class)
        {
            type = (Class)type;
            if (type.isArray())
            {
                class1 = type.getComponentType();
            }
        } else
        if (type instanceof GenericArrayType)
        {
            return ((GenericArrayType)type).getGenericComponentType();
        }
        return class1;
    }

    private static Type getClosestParentType(Class class1, Class class2)
    {
        if (class2.isInterface())
        {
            Type atype[] = class1.getGenericInterfaces();
            Type type = null;
            int j = atype.length;
            int i = 0;
            while (i < j) 
            {
                Type type1 = atype[i];
                Class class3;
                if (type1 instanceof ParameterizedType)
                {
                    class3 = getRawType((ParameterizedType)type1);
                } else
                if (type1 instanceof Class)
                {
                    class3 = (Class)type1;
                } else
                {
                    throw new IllegalStateException((new StringBuilder("Unexpected generic interface type found: ")).append(type1).toString());
                }
                if (isAssignable(class3, class2) && isAssignable(type, class3))
                {
                    type = type1;
                }
                i++;
            }
            if (type != null)
            {
                return type;
            }
        }
        return class1.getGenericSuperclass();
    }

    public static Type[] getImplicitBounds(TypeVariable typevariable)
    {
        typevariable = typevariable.getBounds();
        if (typevariable.length == 0)
        {
            return (new Type[] {
                java/lang/Object
            });
        } else
        {
            return normalizeUpperBounds(typevariable);
        }
    }

    public static Type[] getImplicitLowerBounds(WildcardType wildcardtype)
    {
        Type atype[] = wildcardtype.getLowerBounds();
        wildcardtype = atype;
        if (atype.length == 0)
        {
            wildcardtype = new Type[1];
            wildcardtype[0] = null;
        }
        return wildcardtype;
    }

    public static Type[] getImplicitUpperBounds(WildcardType wildcardtype)
    {
        wildcardtype = wildcardtype.getUpperBounds();
        if (wildcardtype.length == 0)
        {
            return (new Type[] {
                java/lang/Object
            });
        } else
        {
            return normalizeUpperBounds(wildcardtype);
        }
    }

    private static Class getRawType(ParameterizedType parameterizedtype)
    {
        parameterizedtype = parameterizedtype.getRawType();
        if (!(parameterizedtype instanceof Class))
        {
            throw new IllegalStateException((new StringBuilder("Wait... What!? Type of rawType: ")).append(parameterizedtype).toString());
        } else
        {
            return (Class)parameterizedtype;
        }
    }

    public static Class getRawType(Type type, Type type1)
    {
        do
        {
            if (type instanceof Class)
            {
                return (Class)type;
            }
            if (type instanceof ParameterizedType)
            {
                return getRawType((ParameterizedType)type);
            }
            if (type instanceof TypeVariable)
            {
                if (type1 == null)
                {
                    return null;
                }
                Object obj = ((TypeVariable)type).getGenericDeclaration();
                if (!(obj instanceof Class))
                {
                    return null;
                }
                obj = getTypeArguments(type1, (Class)obj);
                if (obj == null)
                {
                    return null;
                }
                obj = (Type)((Map) (obj)).get(type);
                type = ((Type) (obj));
                if (obj == null)
                {
                    return null;
                }
            } else
            {
                if (type instanceof GenericArrayType)
                {
                    return Array.newInstance(getRawType(((GenericArrayType)type).getGenericComponentType(), type1), 0).getClass();
                }
                if (type instanceof WildcardType)
                {
                    return null;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder("unknown type: ")).append(type).toString());
                }
            }
        } while (true);
    }

    private static Map getTypeArguments(Class class1, Class class2, Map map)
    {
        if (!isAssignable(class1, class2))
        {
            map = null;
        } else
        {
            Class class3 = class1;
            if (class1.isPrimitive())
            {
                if (class2.isPrimitive())
                {
                    return new HashMap();
                }
                class3 = ClassUtils.primitiveToWrapper(class1);
            }
            if (map == null)
            {
                class1 = new HashMap();
            } else
            {
                class1 = new HashMap(map);
            }
            map = class1;
            if (class3.getTypeParameters().length <= 0)
            {
                map = class1;
                if (!class2.equals(class3))
                {
                    return getTypeArguments(getClosestParentType(class3, class2), class2, ((Map) (class1)));
                }
            }
        }
        return map;
    }

    public static Map getTypeArguments(ParameterizedType parameterizedtype)
    {
        return getTypeArguments(parameterizedtype, getRawType(parameterizedtype), null);
    }

    private static Map getTypeArguments(ParameterizedType parameterizedtype, Class class1, Map map)
    {
        Class class2 = getRawType(parameterizedtype);
        if (!isAssignable(class2, class1))
        {
            parameterizedtype = null;
        } else
        {
            Object obj = parameterizedtype.getOwnerType();
            Type atype[];
            TypeVariable atypevariable[];
            if (obj instanceof ParameterizedType)
            {
                obj = (ParameterizedType)obj;
                map = getTypeArguments(((ParameterizedType) (obj)), getRawType(((ParameterizedType) (obj))), map);
            } else
            if (map == null)
            {
                map = new HashMap();
            } else
            {
                map = new HashMap(map);
            }
            atype = parameterizedtype.getActualTypeArguments();
            atypevariable = class2.getTypeParameters();
            for (int i = 0; i < atypevariable.length; i++)
            {
                Type type = atype[i];
                TypeVariable typevariable = atypevariable[i];
                parameterizedtype = type;
                if (map.containsKey(type))
                {
                    parameterizedtype = (Type)map.get(type);
                }
                map.put(typevariable, parameterizedtype);
            }

            parameterizedtype = map;
            if (!class1.equals(class2))
            {
                return getTypeArguments(getClosestParentType(class2, class1), class1, map);
            }
        }
        return parameterizedtype;
    }

    public static Map getTypeArguments(Type type, Class class1)
    {
        return getTypeArguments(type, class1, null);
    }

    private static Map getTypeArguments(Type type, Class class1, Map map)
    {
label0:
        {
label1:
            do
            {
                do
                {
                    if (type instanceof Class)
                    {
                        return getTypeArguments((Class)type, class1, map);
                    }
                    if (type instanceof ParameterizedType)
                    {
                        return getTypeArguments((ParameterizedType)type, class1, map);
                    }
                    if (!(type instanceof GenericArrayType))
                    {
                        break;
                    }
                    Type type1 = ((GenericArrayType)type).getGenericComponentType();
                    type = type1;
                    if (class1.isArray())
                    {
                        class1 = class1.getComponentType();
                        type = type1;
                    }
                } while (true);
                if (type instanceof WildcardType)
                {
                    Type atype[] = getImplicitUpperBounds((WildcardType)type);
                    int k = atype.length;
                    for (int i = 0; i < k; i++)
                    {
                        Type type2 = atype[i];
                        type = type2;
                        if (isAssignable(type2, class1))
                        {
                            continue label1;
                        }
                    }

                    return null;
                }
                if (!(type instanceof TypeVariable))
                {
                    break label0;
                }
                Type atype1[] = getImplicitBounds((TypeVariable)type);
                int l = atype1.length;
                int j = 0;
                do
                {
                    if (j >= l)
                    {
                        break label1;
                    }
                    Type type3 = atype1[j];
                    type = type3;
                    if (isAssignable(type3, class1))
                    {
                        continue label1;
                    }
                    j++;
                } while (true);
            } while (true);
            return null;
        }
        throw new IllegalStateException((new StringBuilder("found an unhandled type: ")).append(type).toString());
    }

    public static boolean isArrayType(Type type)
    {
        return (type instanceof GenericArrayType) || (type instanceof Class) && ((Class)type).isArray();
    }

    private static boolean isAssignable(Type type, Class class1)
    {
        do
        {
            if (type == null)
            {
                return class1 == null || !class1.isPrimitive();
            }
            if (class1 == null)
            {
                return false;
            }
            if (class1.equals(type))
            {
                return true;
            }
            if (type instanceof Class)
            {
                return ClassUtils.isAssignable((Class)type, class1);
            }
            if (!(type instanceof ParameterizedType))
            {
                break;
            }
            type = getRawType((ParameterizedType)type);
        } while (true);
        if (type instanceof TypeVariable)
        {
            type = ((TypeVariable)type).getBounds();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                if (isAssignable(type[i], class1))
                {
                    return true;
                }
            }

            return false;
        }
        if (type instanceof GenericArrayType)
        {
            return class1.equals(java/lang/Object) || class1.isArray() && isAssignable(((GenericArrayType)type).getGenericComponentType(), class1.getComponentType());
        }
        if (type instanceof WildcardType)
        {
            return false;
        } else
        {
            throw new IllegalStateException((new StringBuilder("found an unhandled type: ")).append(type).toString());
        }
    }

    private static boolean isAssignable(Type type, GenericArrayType genericarraytype, Map map)
    {
        if (type != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Type type1;
        if (genericarraytype == null)
        {
            return false;
        }
        if (genericarraytype.equals(type))
        {
            continue; /* Loop/switch isn't completed */
        }
        type1 = genericarraytype.getGenericComponentType();
        if (!(type instanceof Class))
        {
            break; /* Loop/switch isn't completed */
        }
        type = (Class)type;
        if (!type.isArray() || !isAssignable(((Type) (type.getComponentType())), type1, map))
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (type instanceof GenericArrayType)
        {
            return isAssignable(((GenericArrayType)type).getGenericComponentType(), type1, map);
        }
        if (type instanceof WildcardType)
        {
            type = getImplicitUpperBounds((WildcardType)type);
            int k = type.length;
            for (int i = 0; i < k; i++)
            {
                if (isAssignable(type[i], ((Type) (genericarraytype))))
                {
                    continue; /* Loop/switch isn't completed */
                }
            }

            return false;
        }
        if (!(type instanceof TypeVariable))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        type = getImplicitBounds((TypeVariable)type);
        int l = type.length;
        int j = 0;
        do
        {
            if (j >= l)
            {
                break; /* Loop/switch isn't completed */
            }
            if (isAssignable(type[j], ((Type) (genericarraytype))))
            {
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        if (true) goto _L1; else goto _L4
_L4:
        return false;
        if (type instanceof ParameterizedType)
        {
            return false;
        } else
        {
            throw new IllegalStateException((new StringBuilder("found an unhandled type: ")).append(type).toString());
        }
    }

    private static boolean isAssignable(Type type, ParameterizedType parameterizedtype, Map map)
    {
        if (type == null)
        {
            return true;
        }
        if (parameterizedtype == null)
        {
            return false;
        }
        if (parameterizedtype.equals(type))
        {
            return true;
        }
        Class class1 = getRawType(parameterizedtype);
        type = getTypeArguments(type, class1, null);
        if (type == null)
        {
            return false;
        }
        if (type.isEmpty())
        {
            return true;
        }
        for (parameterizedtype = getTypeArguments(parameterizedtype, class1, map).entrySet().iterator(); parameterizedtype.hasNext();)
        {
            Object obj = (java.util.Map.Entry)parameterizedtype.next();
            Type type1 = (Type)((java.util.Map.Entry) (obj)).getValue();
            obj = (Type)type.get(((java.util.Map.Entry) (obj)).getKey());
            if (obj != null && !type1.equals(obj) && (!(type1 instanceof WildcardType) || !isAssignable(((Type) (obj)), type1, map)))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isAssignable(Type type, Type type1)
    {
        return isAssignable(type, type1, null);
    }

    private static boolean isAssignable(Type type, Type type1, Map map)
    {
        if (type1 == null || (type1 instanceof Class))
        {
            return isAssignable(type, (Class)type1);
        }
        if (type1 instanceof ParameterizedType)
        {
            return isAssignable(type, (ParameterizedType)type1, map);
        }
        if (type1 instanceof GenericArrayType)
        {
            return isAssignable(type, (GenericArrayType)type1, map);
        }
        if (type1 instanceof WildcardType)
        {
            return isAssignable(type, (WildcardType)type1, map);
        }
        if (type1 instanceof TypeVariable)
        {
            return isAssignable(type, (TypeVariable)type1, map);
        } else
        {
            throw new IllegalStateException((new StringBuilder("found an unhandled type: ")).append(type1).toString());
        }
    }

    private static boolean isAssignable(Type type, TypeVariable typevariable, Map map)
    {
        if (type == null)
        {
            return true;
        }
        if (typevariable == null)
        {
            return false;
        }
        if (typevariable.equals(type))
        {
            return true;
        }
        if (type instanceof TypeVariable)
        {
            Type atype[] = getImplicitBounds((TypeVariable)type);
            int j = atype.length;
            for (int i = 0; i < j; i++)
            {
                if (isAssignable(atype[i], typevariable, map))
                {
                    return true;
                }
            }

        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType))
        {
            return false;
        } else
        {
            throw new IllegalStateException((new StringBuilder("found an unhandled type: ")).append(type).toString());
        }
    }

    private static boolean isAssignable(Type type, WildcardType wildcardtype, Map map)
    {
        if (type != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Type atype[];
        if (wildcardtype == null)
        {
            return false;
        }
        if (wildcardtype.equals(type))
        {
            continue; /* Loop/switch isn't completed */
        }
        atype = getImplicitUpperBounds(wildcardtype);
        wildcardtype = getImplicitLowerBounds(wildcardtype);
        if (!(type instanceof WildcardType))
        {
            break; /* Loop/switch isn't completed */
        }
        WildcardType wildcardtype1 = (WildcardType)type;
        type = getImplicitUpperBounds(wildcardtype1);
        Type atype1[] = getImplicitLowerBounds(wildcardtype1);
        int l1 = atype.length;
        for (int i = 0; i < l1; i++)
        {
            Type type1 = substituteTypeVariables(atype[i], map);
            int i2 = type.length;
            for (int i1 = 0; i1 < i2; i1++)
            {
                if (!isAssignable(type[i1], type1, map))
                {
                    return false;
                }
            }

        }

        l1 = wildcardtype.length;
        int j = 0;
        while (j < l1) 
        {
            type = substituteTypeVariables(wildcardtype[j], map);
            int j2 = atype1.length;
            for (int j1 = 0; j1 < j2; j1++)
            {
                if (!isAssignable(type, atype1[j1], map))
                {
                    return false;
                }
            }

            j++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int k1 = atype.length;
        for (int k = 0; k < k1; k++)
        {
            if (!isAssignable(type, substituteTypeVariables(atype[k], map), map))
            {
                return false;
            }
        }

        k1 = wildcardtype.length;
        int l = 0;
        while (l < k1) 
        {
            if (!isAssignable(substituteTypeVariables(wildcardtype[l], map), type, map))
            {
                return false;
            }
            l++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static boolean isInstance(Object obj, Type type)
    {
        if (type != null)
        {
            if (obj == null)
            {
                if (!(type instanceof Class) || !((Class)type).isPrimitive())
                {
                    return true;
                }
            } else
            {
                return isAssignable(obj.getClass(), type, null);
            }
        }
        return false;
    }

    private static void mapTypeVariablesToArguments(Class class1, ParameterizedType parameterizedtype, Map map)
    {
        Type type = parameterizedtype.getOwnerType();
        if (type instanceof ParameterizedType)
        {
            mapTypeVariablesToArguments(class1, (ParameterizedType)type, map);
        }
        Type atype[] = parameterizedtype.getActualTypeArguments();
        parameterizedtype = getRawType(parameterizedtype).getTypeParameters();
        class1 = Arrays.asList(class1.getTypeParameters());
        for (int i = 0; i < atype.length; i++)
        {
            Object obj = parameterizedtype[i];
            Type type1 = atype[i];
            if (class1.contains(type1) && map.containsKey(obj))
            {
                map.put((TypeVariable)type1, map.get(obj));
            }
        }

    }

    public static Type[] normalizeUpperBounds(Type atype[])
    {
        HashSet hashset;
        int i;
        int k;
        if (atype.length < 2)
        {
            return atype;
        }
        hashset = new HashSet(atype.length);
        k = atype.length;
        i = 0;
_L5:
        if (i >= k) goto _L2; else goto _L1
_L1:
        Type type;
        int j;
        int l;
        type = atype[i];
        l = atype.length;
        j = 0;
_L6:
        Type type1;
        if (j >= l)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        type1 = atype[j];
        if (type == type1 || !isAssignable(type1, type, null)) goto _L4; else goto _L3
_L3:
        j = 1;
_L7:
        if (j == 0)
        {
            hashset.add(type);
        }
        i++;
          goto _L5
_L4:
        j++;
          goto _L6
_L2:
        return (Type[])hashset.toArray(new Type[hashset.size()]);
        j = 0;
          goto _L7
    }

    private static Type substituteTypeVariables(Type type, Map map)
    {
        if ((type instanceof TypeVariable) && map != null)
        {
            Type type1 = (Type)map.get(type);
            map = type1;
            if (type1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("missing assignment type for type variable ")).append(type).toString());
            }
        } else
        {
            map = type;
        }
        return map;
    }

    public static boolean typesSatisfyVariables(Map map)
    {
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            TypeVariable typevariable = (TypeVariable)((java.util.Map.Entry) (obj)).getKey();
            obj = (Type)((java.util.Map.Entry) (obj)).getValue();
            Type atype[] = getImplicitBounds(typevariable);
            int j = atype.length;
            int i = 0;
            while (i < j) 
            {
                if (!isAssignable(((Type) (obj)), substituteTypeVariables(atype[i], map), map))
                {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}
