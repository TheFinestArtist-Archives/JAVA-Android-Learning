// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import com.squareup.javawriter.JavaWriter;

interface 
{

    public abstract void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter);

    public abstract void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter);
}
