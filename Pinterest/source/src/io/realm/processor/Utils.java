// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import java.util.List;
import java.util.Set;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class Utils
{

    private static Messager messager;
    private static DeclaredType realmList;
    public static Types typeUtils;

    public Utils()
    {
    }

    public static void error(String s)
    {
        messager.printMessage(javax.tools.Diagnostic.Kind.ERROR, s);
    }

    public static void error(String s, Element element)
    {
        messager.printMessage(javax.tools.Diagnostic.Kind.ERROR, s, element);
    }

    public static String getFieldTypeSimpleName(VariableElement variableelement)
    {
        String s = variableelement.asType().toString();
        variableelement = s;
        if (s.contains("."))
        {
            variableelement = s.substring(s.lastIndexOf('.') + 1);
        }
        return variableelement;
    }

    public static String getGenericType(VariableElement variableelement)
    {
        String s = ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString();
        variableelement = s;
        if (s.contains("."))
        {
            variableelement = s.substring(s.lastIndexOf('.') + 1);
        }
        return variableelement;
    }

    public static String getProxyClassName(String s)
    {
        return (new StringBuilder()).append(s).append("RealmProxy").toString();
    }

    public static String getProxyClassSimpleName(VariableElement variableelement)
    {
        if (typeUtils.isAssignable(variableelement.asType(), realmList))
        {
            return getProxyClassName(getGenericType(variableelement));
        } else
        {
            return getProxyClassName(getFieldTypeSimpleName(variableelement));
        }
    }

    public static Element getSuperClass(TypeElement typeelement)
    {
        return typeUtils.asElement(typeelement.getSuperclass());
    }

    public static void initialize(ProcessingEnvironment processingenvironment)
    {
        typeUtils = processingenvironment.getTypeUtils();
        messager = processingenvironment.getMessager();
        realmList = typeUtils.getDeclaredType(processingenvironment.getElementUtils().getTypeElement("io.realm.RealmList"), new TypeMirror[] {
            typeUtils.getWildcardType(null, null)
        });
    }

    public static boolean isDefaultConstructor(Element element)
    {
        if (element.getModifiers().contains(Modifier.PUBLIC))
        {
            return ((ExecutableElement)element).getParameters().isEmpty();
        } else
        {
            return false;
        }
    }

    public static boolean isString(VariableElement variableelement)
    {
        if (variableelement == null)
        {
            return false;
        } else
        {
            return getFieldTypeSimpleName(variableelement).equals("String");
        }
    }

    public static String lowerFirstChar(String s)
    {
        return (new StringBuilder()).append(s.substring(0, 1).toLowerCase()).append(s.substring(1)).toString();
    }

    public static void note(String s)
    {
        messager.printMessage(javax.tools.Diagnostic.Kind.NOTE, s);
    }
}
