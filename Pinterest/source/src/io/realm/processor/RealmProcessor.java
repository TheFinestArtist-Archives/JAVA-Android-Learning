// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.annotations.RealmClass;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

// Referenced classes of package io.realm.processor:
//            RealmVersionChecker, Utils, ClassMetaData, RealmProxyClassGenerator, 
//            RealmValidationListGenerator, RealmJSonImplGenerator

public class RealmProcessor extends AbstractProcessor
{

    Set classesToValidate;
    boolean done;

    public RealmProcessor()
    {
        classesToValidate = new HashSet();
        done = false;
    }

    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set set, RoundEnvironment roundenvironment)
    {
        RealmVersionChecker.getInstance(processingEnv).executeRealmVersionUpdate();
        Utils.initialize(processingEnv);
        set = roundenvironment.getElementsAnnotatedWith(io/realm/annotations/RealmClass).iterator();
_L8:
        if (!set.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        roundenvironment = (Element)set.next();
        if (!roundenvironment.getKind().equals(ElementKind.CLASS))
        {
            Utils.error("The RealmClass annotation can only be applied to classes", roundenvironment);
        }
        obj = new ClassMetaData(processingEnv, (TypeElement)roundenvironment);
        if (!((ClassMetaData) (obj)).isModelClass())
        {
            continue; /* Loop/switch isn't completed */
        }
        Utils.note((new StringBuilder("Processing class ")).append(((ClassMetaData) (obj)).getSimpleClassName()).toString());
        if (((ClassMetaData) (obj)).generateMetaData(processingEnv.getMessager())) goto _L4; else goto _L3
_L3:
        done = true;
_L6:
        return true;
_L4:
        classesToValidate.add(obj);
        obj = new RealmProxyClassGenerator(processingEnv, ((ClassMetaData) (obj)));
        try
        {
            ((RealmProxyClassGenerator) (obj)).generate();
        }
        catch (IOException ioexception)
        {
            Utils.error(ioexception.getMessage(), roundenvironment);
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            Utils.error(unsupportedoperationexception.getMessage(), roundenvironment);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (done) goto _L6; else goto _L5
_L5:
        set = new RealmValidationListGenerator(processingEnv, classesToValidate);
        roundenvironment = new RealmJSonImplGenerator(processingEnv, classesToValidate);
        set.generate();
        roundenvironment.generate();
        done = true;
        return true;
        set;
        Utils.error(set.getMessage());
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
