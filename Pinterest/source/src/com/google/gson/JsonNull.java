// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;


// Referenced classes of package com.google.gson:
//            JsonElement

public final class JsonNull extends JsonElement
{

    public static final JsonNull INSTANCE = new JsonNull();

    public JsonNull()
    {
    }

    final volatile JsonElement deepCopy()
    {
        return deepCopy();
    }

    final JsonNull deepCopy()
    {
        return INSTANCE;
    }

    public final boolean equals(Object obj)
    {
        return this == obj || (obj instanceof JsonNull);
    }

    public final int hashCode()
    {
        return com/google/gson/JsonNull.hashCode();
    }

}
