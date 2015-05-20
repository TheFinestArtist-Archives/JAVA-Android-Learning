// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

// Referenced classes of package org.apache.commons.lang3.text.translate:
//            CharSequenceTranslator

public class NumericEntityUnescaper extends CharSequenceTranslator
{

    private final EnumSet options;

    public transient NumericEntityUnescaper(OPTION aoption[])
    {
        if (aoption.length > 0)
        {
            options = EnumSet.copyOf(Arrays.asList(aoption));
            return;
        } else
        {
            options = EnumSet.copyOf(Arrays.asList(new OPTION[] {
                OPTION.semiColonRequired
            }));
            return;
        }
    }

    public boolean isSet(OPTION option)
    {
        if (options == null)
        {
            return false;
        } else
        {
            return options.contains(option);
        }
    }

    public int translate(CharSequence charsequence, int i, Writer writer)
    {
        int l;
        boolean flag1;
        flag1 = true;
        l = charsequence.length();
        if (charsequence.charAt(i) != '&' || i >= l - 2 || charsequence.charAt(i + 1) != '#') goto _L2; else goto _L1
_L1:
        i += 2;
        char c = charsequence.charAt(i);
        if (c != 'x' && c != 'X')
        {
            break MISSING_BLOCK_LABEL_375;
        }
        i++;
        if (i != l) goto _L3; else goto _L2
_L2:
        return 0;
_L3:
        int k = 1;
_L5:
        int j;
        boolean flag;
        for (j = i; j < l && (charsequence.charAt(j) >= '0' && charsequence.charAt(j) <= '9' || charsequence.charAt(j) >= 'a' && charsequence.charAt(j) <= 'f' || charsequence.charAt(j) >= 'A' && charsequence.charAt(j) <= 'F'); j++) { }
        if (j != l && charsequence.charAt(j) == ';')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        if (isSet(OPTION.semiColonRequired)) goto _L2; else goto _L4
_L4:
        if (isSet(OPTION.errorIfNoSemiColon))
        {
            throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
        }
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        int i1;
        int j1;
        try
        {
            j1 = Integer.parseInt(charsequence.subSequence(i, j).toString(), 16);
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            return 0;
        }
        if (j1 > 65535)
        {
            charsequence = Character.toChars(j1);
            writer.write(charsequence[0]);
            writer.write(charsequence[1]);
        } else
        {
            writer.write(j1);
        }
        if (k != 0)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        return k + ((j + 2) - i) + i1;
        j1 = Integer.parseInt(charsequence.subSequence(i, j).toString(), 10);
        break MISSING_BLOCK_LABEL_272;
        k = 0;
          goto _L5
    }

    private class OPTION extends Enum
    {

        private static final OPTION $VALUES[];
        public static final OPTION errorIfNoSemiColon;
        public static final OPTION semiColonOptional;
        public static final OPTION semiColonRequired;

        public static OPTION valueOf(String s)
        {
            return (OPTION)Enum.valueOf(org/apache/commons/lang3/text/translate/NumericEntityUnescaper$OPTION, s);
        }

        public static final OPTION[] values()
        {
            return (OPTION[])$VALUES.clone();
        }

        static 
        {
            semiColonRequired = new OPTION("semiColonRequired", 0);
            semiColonOptional = new OPTION("semiColonOptional", 1);
            errorIfNoSemiColon = new OPTION("errorIfNoSemiColon", 2);
            $VALUES = (new OPTION[] {
                semiColonRequired, semiColonOptional, errorIfNoSemiColon
            });
        }

        private OPTION(String s, int i)
        {
            super(s, i);
        }
    }

}
