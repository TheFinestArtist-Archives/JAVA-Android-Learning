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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.tools.JavaFileObject;

// Referenced classes of package io.realm.processor:
//            ClassMetaData, Utils

public class RealmJSonImplGenerator
{

    private static final String CLASS_NAME = "RealmJsonImpl";
    private static final String EXCEPTION_MSG = "\"Could not find the generated proxy class for \" + classQualifiedName";
    private static final String REALM_PACKAGE_NAME = "io.realm";
    private final ProcessingEnvironment processingEnvironment;
    private List proxyClasses;
    private List qualifiedModelClasses;
    private List simpleModelClasses;

    public RealmJSonImplGenerator(ProcessingEnvironment processingenvironment, Set set)
    {
        qualifiedModelClasses = new ArrayList();
        simpleModelClasses = new ArrayList();
        proxyClasses = new ArrayList();
        processingEnvironment = processingenvironment;
        for (processingenvironment = set.iterator(); processingenvironment.hasNext(); proxyClasses.add(Utils.getProxyClassName(set.getSimpleClassName())))
        {
            set = (ClassMetaData)processingenvironment.next();
            qualifiedModelClasses.add(set.getFullyQualifiedClassName());
            simpleModelClasses.add(set.getSimpleClassName());
        }

    }

    private void emitPopulateUsingJsonObject(JavaWriter javawriter)
    {
        javawriter.c("Override");
        javawriter.a("<E extends RealmObject> void", "populateUsingJsonObject", EnumSet.of(Modifier.PUBLIC), Arrays.asList(new String[] {
            "E", "obj", "JSONObject", "json"
        }), Arrays.asList(new String[] {
            "JSONException"
        }));
        emitProxySwitch("%s.populateUsingJsonObject((%s) obj, json)", javawriter);
        javawriter.d();
        javawriter.b();
    }

    private void emitPopulateUsingJsonStream(JavaWriter javawriter)
    {
        javawriter.c("Override");
        javawriter.a("<E extends RealmObject> void", "populateUsingJsonStream", EnumSet.of(Modifier.PUBLIC), Arrays.asList(new String[] {
            "E", "obj", "JsonReader", "reader"
        }), Arrays.asList(new String[] {
            "IOException"
        }));
        emitProxySwitch("%s.populateUsingJsonStream((%s) obj, reader)", javawriter);
        javawriter.d();
        javawriter.b();
    }

    private void emitProxySwitch(String s, JavaWriter javawriter)
    {
        javawriter.a("String classQualifiedName = (obj.realm != null) ? obj.getClass().getSuperclass().getName() : obj.getClass().getName()", new Object[0]);
        if (simpleModelClasses.size() == 0)
        {
            javawriter.a("throw new RealmException(%s)", new Object[] {
                "\"Could not find the generated proxy class for \" + classQualifiedName"
            });
            return;
        }
        javawriter.b("if (classQualifiedName.equals(%s.class.getName()))", new Object[] {
            simpleModelClasses.get(0)
        });
        javawriter.a(s, new Object[] {
            proxyClasses.get(0), simpleModelClasses.get(0)
        });
        for (int i = 1; i < simpleModelClasses.size(); i++)
        {
            javawriter.c("else if (classQualifiedName.equals(%s.class.getName()))", new Object[] {
                simpleModelClasses.get(i)
            });
            javawriter.a(s, new Object[] {
                proxyClasses.get(i), simpleModelClasses.get(i)
            });
        }

        javawriter.c("else", new Object[0]);
        javawriter.a("throw new RealmException(%s)", new Object[] {
            "\"Could not find the generated proxy class for \" + classQualifiedName"
        });
        javawriter.c();
    }

    public void generate()
    {
        String s = String.format("%s.%s", new Object[] {
            "io.realm", "RealmJsonImpl"
        });
        JavaWriter javawriter = new JavaWriter(new BufferedWriter(processingEnvironment.getFiler().createSourceFile(s, new Element[0]).openWriter()));
        javawriter.a("    ");
        javawriter.b("io.realm");
        javawriter.b();
        javawriter.a(new String[] {
            "android.util.JsonReader", "io.realm.exceptions.RealmException", "io.realm.internal.RealmJson", "java.io.IOException", "java.util.ArrayList", "java.util.Collections", "java.util.List", "org.json.JSONException", "org.json.JSONObject"
        });
        javawriter.a(qualifiedModelClasses);
        javawriter.b();
        javawriter.a(s, "class", Collections.emptySet(), null, new String[] {
            "RealmJson"
        });
        javawriter.b();
        emitPopulateUsingJsonObject(javawriter);
        emitPopulateUsingJsonStream(javawriter);
        javawriter.a();
        javawriter.close();
    }
}
