// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;

// Referenced classes of package com.google.gson.stream:
//            JsonReader

final class eeReader extends JsonReaderInternalAccess
{

    public final void promoteNameToValue(JsonReader jsonreader)
    {
        if (jsonreader instanceof JsonTreeReader)
        {
            ((JsonTreeReader)jsonreader).promoteNameToValue();
            return;
        }
        int j = JsonReader.access$000(jsonreader);
        int i = j;
        if (j == 0)
        {
            i = JsonReader.access$100(jsonreader);
        }
        if (i == 13)
        {
            JsonReader.access$002(jsonreader, 9);
            return;
        }
        if (i == 12)
        {
            JsonReader.access$002(jsonreader, 8);
            return;
        }
        if (i == 14)
        {
            JsonReader.access$002(jsonreader, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(jsonreader.peek()).append("  at line ").append(JsonReader.access$200(jsonreader)).append(" column ").append(JsonReader.access$300(jsonreader)).append(" path ").append(jsonreader.getPath()).toString());
        }
    }

    eeReader()
    {
    }
}
