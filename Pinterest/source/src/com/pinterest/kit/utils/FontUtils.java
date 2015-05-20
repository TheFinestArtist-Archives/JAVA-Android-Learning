// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import android.graphics.Typeface;
import android.widget.TextView;
import com.pinterest.base.Application;
import java.util.HashMap;

public class FontUtils
{

    private static HashMap _typefaceCache = new HashMap();

    public FontUtils()
    {
    }

    public static final Typeface getTypeface(TypefaceId typefaceid)
    {
        Typeface typeface1 = (Typeface)_typefaceCache.get(typefaceid);
        Typeface typeface = typeface1;
        if (typeface1 == null)
        {
            typeface = loadFont(typefaceid);
            _typefaceCache.put(typefaceid, typeface);
        }
        return typeface;
    }

    private static Typeface loadFont(TypefaceId typefaceid)
    {
        Typeface typeface = null;
        _cls1..SwitchMap.com.pinterest.kit.utils.FontUtils.TypefaceId[typefaceid.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 74
    //                   2 80
    //                   3 86
    //                   4 92;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        typefaceid = null;
_L7:
        if (typefaceid != null)
        {
            typeface = Typeface.createFromAsset(Application.assets(), (new StringBuilder()).append("fonts/").append(typefaceid).toString());
        }
        return typeface;
_L2:
        typefaceid = "Roboto-Light.ttf";
        continue; /* Loop/switch isn't completed */
_L3:
        typefaceid = "Roboto-Regular.ttf";
        continue; /* Loop/switch isn't completed */
_L4:
        typefaceid = "Roboto-Medium.ttf";
        continue; /* Loop/switch isn't completed */
_L5:
        typefaceid = "Roboto-Bold.ttf";
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void setFont(TypefaceId typefaceid, TextView textview)
    {
        textview.setTypeface(getTypeface(typefaceid));
    }


    private class _cls1
    {

        static final int $SwitchMap$com$pinterest$kit$utils$FontUtils$TypefaceId[];

        static 
        {
            $SwitchMap$com$pinterest$kit$utils$FontUtils$TypefaceId = new int[TypefaceId.values().length];
            try
            {
                $SwitchMap$com$pinterest$kit$utils$FontUtils$TypefaceId[TypefaceId.LIGHT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$kit$utils$FontUtils$TypefaceId[TypefaceId.REGULAR.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$kit$utils$FontUtils$TypefaceId[TypefaceId.MEDIUM.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$kit$utils$FontUtils$TypefaceId[TypefaceId.BOLD.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class TypefaceId extends Enum
    {

        private static final TypefaceId $VALUES[];
        public static final TypefaceId BOLD;
        public static final TypefaceId LIGHT;
        public static final TypefaceId MEDIUM;
        public static final TypefaceId REGULAR;

        public static TypefaceId valueOf(String s)
        {
            return (TypefaceId)Enum.valueOf(com/pinterest/kit/utils/FontUtils$TypefaceId, s);
        }

        public static TypefaceId[] values()
        {
            return (TypefaceId[])$VALUES.clone();
        }

        static 
        {
            LIGHT = new TypefaceId("LIGHT", 0);
            REGULAR = new TypefaceId("REGULAR", 1);
            MEDIUM = new TypefaceId("MEDIUM", 2);
            BOLD = new TypefaceId("BOLD", 3);
            $VALUES = (new TypefaceId[] {
                LIGHT, REGULAR, MEDIUM, BOLD
            });
        }

        private TypefaceId(String s, int i)
        {
            super(s, i);
        }
    }

}
