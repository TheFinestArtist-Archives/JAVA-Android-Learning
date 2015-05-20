// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.PrintStream;

public class Version
{

    static final int CORE_MIN_MAJOR = 0;
    static final int CORE_MIN_MINOR = 1;
    static final int CORE_MIN_PATCH = 6;
    static final int REQUIRED_JNI_VERSION = 23;

    public Version()
    {
    }

    public static boolean coreLibVersionCompatible(boolean flag)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!nativeIsAtLeast(0, 1, 6))
        {
            String s = (new StringBuilder("Version mismatch between realm.jar (0.1.6) and native core library (")).append(getCoreVersion()).append(")").toString();
            if (flag)
            {
                throw new RuntimeException(s);
            }
            System.err.println(s);
        } else
        {
            if (nativeGetAPIVersion() == 23)
            {
                flag1 = true;
            }
            flag2 = flag1;
            if (!flag1)
            {
                String s1 = (new StringBuilder("Native lib API is version ")).append(nativeGetAPIVersion()).append(" != 23 which is expected by the jar.").toString();
                if (flag)
                {
                    throw new RuntimeException(s1);
                } else
                {
                    System.err.println(s1);
                    return flag1;
                }
            }
        }
        return flag2;
    }

    public static String getCoreVersion()
    {
        return nativeGetVersion();
    }

    public static String getVersion()
    {
        return getCoreVersion();
    }

    public static boolean hasFeature(Feature feature)
    {
        return nativeHasFeature(feature.ordinal());
    }

    static native int nativeGetAPIVersion();

    static native String nativeGetVersion();

    static native boolean nativeHasFeature(int i);

    static native boolean nativeIsAtLeast(int i, int j, int k);

    private class Feature extends Enum
    {

        private static final Feature $VALUES[];
        public static final Feature Feature_Debug;
        public static final Feature Feature_Replication;
        private final int nativeFeature;

        public static Feature valueOf(String s)
        {
            return (Feature)Enum.valueOf(io/realm/internal/Version$Feature, s);
        }

        public static Feature[] values()
        {
            return (Feature[])$VALUES.clone();
        }

        static 
        {
            Feature_Debug = new Feature("Feature_Debug", 0, 0);
            Feature_Replication = new Feature("Feature_Replication", 1, 1);
            $VALUES = (new Feature[] {
                Feature_Debug, Feature_Replication
            });
        }

        private Feature(String s, int i, int j)
        {
            super(s, i);
            nativeFeature = j;
        }
    }

}
