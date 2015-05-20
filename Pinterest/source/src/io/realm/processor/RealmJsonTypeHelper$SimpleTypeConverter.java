// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import com.squareup.javawriter.JavaWriter;

class <init>
    implements rter
{

    private final String castType;
    private final String jsonType;

    public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
    {
        javawriter.a("obj.%s((%s) reader.next%s())", new Object[] {
            s, castType, jsonType
        });
    }

    public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
    {
        javawriter.b("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).a("obj.%s((%s) json.get%s(\"%s\"))", new Object[] {
            s, castType, jsonType, s1
        }).c();
    }

    private rter(String s, String s1)
    {
        castType = s;
        jsonType = s1;
    }

    jsonType(String s, String s1, jsonType jsontype)
    {
        this(s, s1);
    }
}
