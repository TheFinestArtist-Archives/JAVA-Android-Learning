// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import com.squareup.javawriter.JavaWriter;

final class onToRealmTypeConverter
    implements onToRealmTypeConverter
{

    public final void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
    {
        javawriter.b("if (reader.peek() == JsonToken.NUMBER)", new Object[0]).a("long timestamp = reader.nextLong()", new Object[] {
            s1
        }).b("if (timestamp > -1)", new Object[0]).a("obj.%s(new Date(timestamp))", new Object[] {
            s
        }).c().c("else", new Object[0]).a("obj.%s(JsonUtils.stringToDate(reader.nextString()))", new Object[] {
            s
        }).c();
    }

    public final void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
    {
        javawriter.b("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).a("Object timestamp = json.get(\"%s\")", new Object[] {
            s1
        }).b("if (timestamp instanceof String)", new Object[0]).a("obj.%s(JsonUtils.stringToDate((String) timestamp))", new Object[] {
            s
        }).c("else", new Object[0]).a("obj.%s(new Date(json.getLong(\"%s\")))", new Object[] {
            s, s1
        }).c().c("else", new Object[0]).a("obj.%s(new Date(0))", new Object[] {
            s
        }).c();
    }

    onToRealmTypeConverter()
    {
    }
}
