// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter
{

    private static final JsonPrimitive SENTINEL_CLOSED = new JsonPrimitive("closed");
    private static final Writer UNWRITABLE_WRITER = new _cls1();
    private String pendingName;
    private JsonElement product;
    private final List stack = new ArrayList();

    public JsonTreeWriter()
    {
        super(UNWRITABLE_WRITER);
        product = JsonNull.INSTANCE;
    }

    private JsonElement peek()
    {
        return (JsonElement)stack.get(stack.size() - 1);
    }

    private void put(JsonElement jsonelement)
    {
        if (pendingName != null)
        {
            if (!jsonelement.isJsonNull() || getSerializeNulls())
            {
                ((JsonObject)peek()).add(pendingName, jsonelement);
            }
            pendingName = null;
            return;
        }
        if (stack.isEmpty())
        {
            product = jsonelement;
            return;
        }
        JsonElement jsonelement1 = peek();
        if (jsonelement1 instanceof JsonArray)
        {
            ((JsonArray)jsonelement1).add(jsonelement);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter beginArray()
    {
        JsonArray jsonarray = new JsonArray();
        put(jsonarray);
        stack.add(jsonarray);
        return this;
    }

    public final JsonWriter beginObject()
    {
        JsonObject jsonobject = new JsonObject();
        put(jsonobject);
        stack.add(jsonobject);
        return this;
    }

    public final void close()
    {
        if (!stack.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            stack.add(SENTINEL_CLOSED);
            return;
        }
    }

    public final JsonWriter endArray()
    {
        if (stack.isEmpty() || pendingName != null)
        {
            throw new IllegalStateException();
        }
        if (peek() instanceof JsonArray)
        {
            stack.remove(stack.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter endObject()
    {
        if (stack.isEmpty() || pendingName != null)
        {
            throw new IllegalStateException();
        }
        if (peek() instanceof JsonObject)
        {
            stack.remove(stack.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final void flush()
    {
    }

    public final JsonElement get()
    {
        if (!stack.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Expected one JSON element but was ")).append(stack).toString());
        } else
        {
            return product;
        }
    }

    public final JsonWriter name(String s)
    {
        if (stack.isEmpty() || pendingName != null)
        {
            throw new IllegalStateException();
        }
        if (peek() instanceof JsonObject)
        {
            pendingName = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter nullValue()
    {
        put(JsonNull.INSTANCE);
        return this;
    }

    public final JsonWriter value(double d)
    {
        if (!isLenient() && (Double.isNaN(d) || Double.isInfinite(d)))
        {
            throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(d).toString());
        } else
        {
            put(new JsonPrimitive(Double.valueOf(d)));
            return this;
        }
    }

    public final JsonWriter value(long l)
    {
        put(new JsonPrimitive(Long.valueOf(l)));
        return this;
    }

    public final JsonWriter value(Number number)
    {
        if (number == null)
        {
            return nullValue();
        }
        if (!isLenient())
        {
            double d = number.doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d))
            {
                throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(number).toString());
            }
        }
        put(new JsonPrimitive(number));
        return this;
    }

    public final JsonWriter value(String s)
    {
        if (s == null)
        {
            return nullValue();
        } else
        {
            put(new JsonPrimitive(s));
            return this;
        }
    }

    public final JsonWriter value(boolean flag)
    {
        put(new JsonPrimitive(Boolean.valueOf(flag)));
        return this;
    }


    private class _cls1 extends Writer
    {

        public final void close()
        {
            throw new AssertionError();
        }

        public final void flush()
        {
            throw new AssertionError();
        }

        public final void write(char ac[], int i, int j)
        {
            throw new AssertionError();
        }

        _cls1()
        {
        }
    }

}
