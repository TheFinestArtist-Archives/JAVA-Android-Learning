// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;

public class RealmVersionChecker
{

    private static final int CONNECT_TIMEOUT = 4000;
    private static final int READ_TIMEOUT = 2000;
    public static final String REALM_ANDROID_DOWNLOAD_URL = "http://static.realm.io/downloads/java/latest";
    private static final String REALM_VERSION = "0.80.0";
    private static final String VERSION_URL = "http://static.realm.io/update/java?";
    private static RealmVersionChecker instance = null;
    private static boolean isFirstRound = true;
    private ProcessingEnvironment processingEnvironment;

    private RealmVersionChecker(ProcessingEnvironment processingenvironment)
    {
        processingEnvironment = processingenvironment;
    }

    private String checkLatestVersion()
    {
        Object obj;
        BufferedReader bufferedreader;
        try
        {
            obj = (HttpURLConnection)(new URL("http://static.realm.io/update/java?0.80.0")).openConnection();
            ((HttpURLConnection) (obj)).setConnectTimeout(4000);
            ((HttpURLConnection) (obj)).setReadTimeout(2000);
            bufferedreader = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
            obj = bufferedreader.readLine();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return "0.80.0";
        }
        try
        {
            bufferedreader.close();
        }
        catch (IOException ioexception)
        {
            return ((String) (obj));
        }
        return ((String) (obj));
    }

    public static RealmVersionChecker getInstance(ProcessingEnvironment processingenvironment)
    {
        if (instance == null)
        {
            instance = new RealmVersionChecker(processingenvironment);
        }
        return instance;
    }

    private void launchRealmCheck()
    {
        String s = checkLatestVersion();
        if (!s.equals("0.80.0"))
        {
            printMessage((new StringBuilder("Version ")).append(s).append(" of Realm is now available: http://static.realm.io/downloads/java/latest").toString());
        }
    }

    private void printMessage(String s)
    {
        processingEnvironment.getMessager().printMessage(javax.tools.Diagnostic.Kind.OTHER, s);
    }

    public void executeRealmVersionUpdate()
    {
        Thread thread;
        if (!isFirstRound)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        isFirstRound = false;
        thread = new Thread(new _cls1());
        thread.start();
        thread.join(6000L);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
    }



    private class _cls1
        implements Runnable
    {

        final RealmVersionChecker this$0;

        public void run()
        {
            launchRealmCheck();
        }

        _cls1()
        {
            this$0 = RealmVersionChecker.this;
            super();
        }
    }

}
