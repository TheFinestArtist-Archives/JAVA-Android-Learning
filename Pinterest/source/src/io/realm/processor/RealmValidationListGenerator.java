// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import com.squareup.javawriter.JavaWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.tools.JavaFileObject;

// Referenced classes of package io.realm.processor:
//            ClassMetaData

public class RealmValidationListGenerator
{

    private static final String CLASS_NAME = "ValidationList";
    private Set classesToValidate;
    private ProcessingEnvironment processingEnvironment;

    public RealmValidationListGenerator(ProcessingEnvironment processingenvironment, Set set)
    {
        classesToValidate = new HashSet();
        processingEnvironment = processingenvironment;
        classesToValidate = set;
    }

    public static String joinStringList(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        for (list = list.listIterator(); list.hasNext(); stringbuilder.append(s1))
        {
            int i = list.nextIndex();
            s1 = (String)list.next();
            if (i > 0)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    public void generate()
    {
        Object obj = String.format("%s.%s", new Object[] {
            "io.realm", "ValidationList"
        });
        JavaWriter javawriter = new JavaWriter(new BufferedWriter(processingEnvironment.getFiler().createSourceFile(((CharSequence) (obj)), new Element[0]).openWriter()));
        javawriter.a("    ");
        javawriter.b("io.realm");
        javawriter.b();
        javawriter.a(new String[] {
            "java.util.Arrays", "java.util.List"
        });
        javawriter.b();
        javawriter.a(((String) (obj)), "class", EnumSet.of(Modifier.PUBLIC), null, new String[0]);
        javawriter.b();
        javawriter.a("List<String>", "getProxyClasses", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[0]);
        obj = new ArrayList();
        for (Iterator iterator = classesToValidate.iterator(); iterator.hasNext(); ((List) (obj)).add(String.format("\"%s\"", new Object[] {
    ((ClassMetaData)iterator.next()).getSimpleClassName()
}))) { }
        javawriter.a("return Arrays.asList(%s)", new Object[] {
            joinStringList(((List) (obj)), ", ")
        });
        javawriter.d();
        javawriter.b();
        javawriter.a();
        javawriter.close();
    }
}
