// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

// Referenced classes of package org.apache.commons.lang3.text.translate:
//            AggregateTranslator

public abstract class CharSequenceTranslator
{

    public CharSequenceTranslator()
    {
    }

    public static String hex(int i)
    {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    public abstract int translate(CharSequence charsequence, int i, Writer writer);

    public final String translate(CharSequence charsequence)
    {
        if (charsequence == null)
        {
            return null;
        }
        try
        {
            StringWriter stringwriter = new StringWriter(charsequence.length() * 2);
            translate(charsequence, ((Writer) (stringwriter)));
            charsequence = stringwriter.toString();
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new RuntimeException(charsequence);
        }
        return charsequence;
    }

    public final void translate(CharSequence charsequence, Writer writer)
    {
        if (writer == null)
        {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charsequence != null)
        {
            int k = charsequence.length();
            int i = 0;
            while (i < k) 
            {
                int l = translate(charsequence, i, writer);
                if (l == 0)
                {
                    char ac[] = Character.toChars(Character.codePointAt(charsequence, i));
                    writer.write(ac);
                    i += ac.length;
                } else
                {
                    int j = 0;
                    while (j < l) 
                    {
                        i += Character.charCount(Character.codePointAt(charsequence, i));
                        j++;
                    }
                }
            }
        }
    }

    public final transient CharSequenceTranslator with(CharSequenceTranslator acharsequencetranslator[])
    {
        CharSequenceTranslator acharsequencetranslator1[] = new CharSequenceTranslator[acharsequencetranslator.length + 1];
        acharsequencetranslator1[0] = this;
        System.arraycopy(acharsequencetranslator, 0, acharsequencetranslator1, 1, acharsequencetranslator.length);
        return new AggregateTranslator(acharsequencetranslator1);
    }
}
