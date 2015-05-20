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
        javawriter.a("obj.%s(JsonUtils.stringToBytes(reader.nextString()))", new Object[] {
            s
        });
    }

    public final void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
    {
        javawriter.a("obj.%s(JsonUtils.stringToBytes(json.isNull(\"%s\") ? null : json.getString(\"%s\")))", new Object[] {
            s, s1, s1
        });
    }

    onToRealmTypeConverter()
    {
    }
}
