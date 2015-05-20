// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

class 
{

    private static final Throwable java6Exception;
    private static final Method java6NormalizeMethod;
    private static final Object java6NormalizerFormNFD;
    private static final Pattern java6Pattern;
    private static final Method sunDecomposeMethod;
    private static final Throwable sunException;
    private static final Pattern sunPattern;

    static 
    {
        Object obj3;
        obj3 = null;
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        sunPattern = pattern;
        java6Pattern = pattern;
        Object obj;
        Object obj1;
        obj1 = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer$Form");
        obj = ((Class) (obj1)).getField("NFD").get(null);
        Method method = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer").getMethod("normalize", new Class[] {
            java/lang/CharSequence, obj1
        });
        Object obj2;
        Object obj4 = null;
        obj1 = null;
        obj2 = obj;
        obj = obj4;
_L1:
        java6Exception = ((Throwable) (obj));
        java6NormalizerFormNFD = obj2;
        java6NormalizeMethod = method;
        sunException = ((Throwable) (obj3));
        sunDecomposeMethod = ((Method) (obj1));
        return;
        obj;
        obj1 = null;
_L2:
        Method method1 = Thread.currentThread().getContextClassLoader().loadClass("sun.text.Normalizer").getMethod("decompose", new Class[] {
            java/lang/String, Boolean.TYPE, Integer.TYPE
        });
        obj2 = obj1;
        method = null;
        obj1 = method1;
          goto _L1
        obj3;
        obj2 = obj1;
        method = null;
        obj1 = null;
          goto _L1
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
          goto _L2
    }








    private ()
    {
    }
}
