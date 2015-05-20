// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package io.realm.internal:
//            TightDB

public class Util
{

    public Util()
    {
    }

    public static long getNativeMemUsage()
    {
        return nativeGetMemUsage();
    }

    static void javaPrint(String s)
    {
        System.out.print(s);
    }

    static native long nativeGetMemUsage();

    static native void nativeSetDebugLevel(int i);

    static native String nativeTestcase(int i, boolean flag, long l);

    public static void setDebugLevel(int i)
    {
        nativeSetDebugLevel(i);
    }

    public static void waitForEnter()
    {
        System.out.println("Press Enter to continue...");
        Scanner scanner;
        for (scanner = new Scanner(System.in); !scanner.nextLine().equals("");) { }
        scanner.close();
    }

    static 
    {
        TightDB.loadLibrary();
    }
}
