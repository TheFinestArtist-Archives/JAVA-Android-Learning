// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams
{

    public Streams()
    {
    }

    public static JsonElement parse(JsonReader jsonreader)
    {
        boolean flag = true;
        try
        {
            jsonreader.peek();
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            if (flag)
            {
                return JsonNull.INSTANCE;
            } else
            {
                throw new JsonSyntaxException(jsonreader);
            }
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException(jsonreader);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonIOException(jsonreader);
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException(jsonreader);
        }
        flag = false;
        jsonreader = (JsonElement)TypeAdapters.JSON_ELEMENT.read(jsonreader);
        return jsonreader;
    }

    public static void write(JsonElement jsonelement, JsonWriter jsonwriter)
    {
        TypeAdapters.JSON_ELEMENT.write(jsonwriter, jsonelement);
    }

    public static Writer writerForAppendable(Appendable appendable)
    {
        if (appendable instanceof Writer)
        {
            return (Writer)appendable;
        } else
        {
            return new AppendableWriter(appendable, null);
        }
    }

    private class AppendableWriter extends Writer
    {

        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        public final void close()
        {
        }

        public final void flush()
        {
        }

        public final void write(int i)
        {
            appendable.append((char)i);
        }

        public final void write(char ac[], int i, int j)
        {
            currentWrite.chars = ac;
            appendable.append(currentWrite, i, i + j);
        }

        private AppendableWriter(Appendable appendable1)
        {
            class CurrentWrite
                implements CharSequence
            {

                char chars[];

                public char charAt(int i)
                {
                    return chars[i];
                }

                public int length()
                {
                    return chars.length;
                }

                public CharSequence subSequence(int i, int j)
                {
                    return new String(chars, i, j - i);
                }

                CurrentWrite()
                {
                }
            }

            currentWrite = new CurrentWrite();
            appendable = appendable1;
        }

        AppendableWriter(Appendable appendable1, _cls1 _pcls1)
        {
            this(appendable1);
        }
    }

}
