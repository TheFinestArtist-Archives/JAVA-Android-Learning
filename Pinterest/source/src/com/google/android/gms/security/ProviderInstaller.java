// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.lang.reflect.Method;

public class ProviderInstaller
{

    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method apU = null;
    private static final Object ut = new Object();

    public ProviderInstaller()
    {
    }

    private static void V(Context context)
    {
        apU = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] {
            android/content/Context
        });
    }

    public static void installIfNeeded(Context context)
    {
        Context context1;
        jx.b(context, "Context must not be null");
        GooglePlayServicesUtil.C(context);
        context1 = GooglePlayServicesUtil.getRemoteContext(context);
        if (context1 == null)
        {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        if (true) goto _L2; else goto _L1
_L1:
        context;
        JVM INSTR monitorenter ;
_L2:
        synchronized (ut)
        {
            if (apU == null)
            {
                V(context1);
            }
            apU.invoke(null, new Object[] {
                context1
            });
        }
        return;
        Exception exception;
        exception;
        Log.e("ProviderInstaller", (new StringBuilder("Failed to install provider: ")).append(exception.getMessage()).toString());
        throw new GooglePlayServicesNotAvailableException(8);
        exception1;
        context;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerinstalllistener)
    {
        jx.b(context, "Context must not be null");
        jx.b(providerinstalllistener, "Listener must not be null");
        jx.aU("Must be called on the UI thread");
        (new _cls1(context, providerinstalllistener)).execute(new Void[0]);
    }


    private class _cls1 extends AsyncTask
    {

        final ProviderInstallListener apV;
        final Context nf;

        protected final transient Integer c(Void avoid[])
        {
            try
            {
                ProviderInstaller.installIfNeeded(nf);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return Integer.valueOf(avoid.getConnectionStatusCode());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return Integer.valueOf(((GooglePlayServicesNotAvailableException) (avoid)).errorCode);
            }
            return Integer.valueOf(0);
        }

        protected final void d(Integer integer)
        {
            if (integer.intValue() == 0)
            {
                apV.onProviderInstalled();
                return;
            } else
            {
                Intent intent = GooglePlayServicesUtil.aj(integer.intValue());
                apV.onProviderInstallFailed(integer.intValue(), intent);
                return;
            }
        }

        protected final Object doInBackground(Object aobj[])
        {
            return c((Void[])aobj);
        }

        protected final void onPostExecute(Object obj)
        {
            d((Integer)obj);
        }

        _cls1(Context context, ProviderInstallListener providerinstalllistener)
        {
            nf = context;
            apV = providerinstalllistener;
            super();
        }

        private class ProviderInstallListener
        {

            public abstract void onProviderInstallFailed(int i, Intent intent);

            public abstract void onProviderInstalled();
        }

    }

}
