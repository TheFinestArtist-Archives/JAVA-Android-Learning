// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SVGColors
{

    private static final Map a;

    public static Integer a(String s)
    {
        return (Integer)a.get(s);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("aliceblue", Integer.valueOf(0xf0f8ff));
        hashmap.put("antiquewhite", Integer.valueOf(0xfaebd7));
        hashmap.put("aqua", Integer.valueOf(65535));
        hashmap.put("aquamarine", Integer.valueOf(0x7fffd4));
        hashmap.put("azure", Integer.valueOf(0xf0ffff));
        hashmap.put("beige", Integer.valueOf(0xf5f5dc));
        hashmap.put("bisque", Integer.valueOf(0xffe4c4));
        hashmap.put("black", Integer.valueOf(0));
        hashmap.put("blanchedalmond", Integer.valueOf(0xffebcd));
        hashmap.put("blue", Integer.valueOf(255));
        hashmap.put("blueviolet", Integer.valueOf(0x8a2be2));
        hashmap.put("brown", Integer.valueOf(0xa52a2a));
        hashmap.put("burlywood", Integer.valueOf(0xdeb887));
        hashmap.put("cadetblue", Integer.valueOf(0x5f9ea0));
        hashmap.put("chartreuse", Integer.valueOf(0x7fff00));
        hashmap.put("chocolate", Integer.valueOf(0xd2691e));
        hashmap.put("coral", Integer.valueOf(0xff7f50));
        hashmap.put("cornflowerblue", Integer.valueOf(0x6495ed));
        hashmap.put("cornsilk", Integer.valueOf(0xfff8dc));
        hashmap.put("crimson", Integer.valueOf(0xdc143c));
        hashmap.put("cyan", Integer.valueOf(65535));
        hashmap.put("darkblue", Integer.valueOf(139));
        hashmap.put("darkcyan", Integer.valueOf(35723));
        hashmap.put("darkgoldenrod", Integer.valueOf(0xb8860b));
        hashmap.put("darkgray", Integer.valueOf(0xa9a9a9));
        hashmap.put("darkgreen", Integer.valueOf(25600));
        hashmap.put("darkgrey", Integer.valueOf(0xa9a9a9));
        hashmap.put("darkkhaki", Integer.valueOf(0xbdb76b));
        hashmap.put("darkmagenta", Integer.valueOf(0x8b008b));
        hashmap.put("darkolivegreen", Integer.valueOf(0x556b2f));
        hashmap.put("darkorange", Integer.valueOf(0xff8c00));
        hashmap.put("darkorchid", Integer.valueOf(0x9932cc));
        hashmap.put("darkred", Integer.valueOf(0x8b0000));
        hashmap.put("darksalmon", Integer.valueOf(0xe9967a));
        hashmap.put("darkseagreen", Integer.valueOf(0x8fbc8f));
        hashmap.put("darkslateblue", Integer.valueOf(0x483d8b));
        hashmap.put("darkslategray", Integer.valueOf(0x2f4f4f));
        hashmap.put("darkslategrey", Integer.valueOf(0x2f4f4f));
        hashmap.put("darkturquoise", Integer.valueOf(52945));
        hashmap.put("darkviolet", Integer.valueOf(0x9400d3));
        hashmap.put("deeppink", Integer.valueOf(0xff1493));
        hashmap.put("deepskyblue", Integer.valueOf(49151));
        hashmap.put("dimgray", Integer.valueOf(0x696969));
        hashmap.put("dimgrey", Integer.valueOf(0x696969));
        hashmap.put("dodgerblue", Integer.valueOf(0x1e90ff));
        hashmap.put("firebrick", Integer.valueOf(0xb22222));
        hashmap.put("floralwhite", Integer.valueOf(0xfffaf0));
        hashmap.put("forestgreen", Integer.valueOf(0x228b22));
        hashmap.put("fuchsia", Integer.valueOf(0xff00ff));
        hashmap.put("gainsboro", Integer.valueOf(0xdcdcdc));
        hashmap.put("ghostwhite", Integer.valueOf(0xf8f8ff));
        hashmap.put("gold", Integer.valueOf(0xffd700));
        hashmap.put("goldenrod", Integer.valueOf(0xdaa520));
        hashmap.put("gray", Integer.valueOf(0x808080));
        hashmap.put("green", Integer.valueOf(32768));
        hashmap.put("greenyellow", Integer.valueOf(0xadff2f));
        hashmap.put("grey", Integer.valueOf(0x808080));
        hashmap.put("honeydew", Integer.valueOf(0xf0fff0));
        hashmap.put("hotpink", Integer.valueOf(0xff69b4));
        hashmap.put("indianred", Integer.valueOf(0xcd5c5c));
        hashmap.put("indigo", Integer.valueOf(0x4b0082));
        hashmap.put("ivory", Integer.valueOf(0xfffff0));
        hashmap.put("khaki", Integer.valueOf(0xf0e68c));
        hashmap.put("lavender", Integer.valueOf(0xe6e6fa));
        hashmap.put("lavenderblush", Integer.valueOf(0xfff0f5));
        hashmap.put("lawngreen", Integer.valueOf(0x7cfc00));
        hashmap.put("lemonchiffon", Integer.valueOf(0xfffacd));
        hashmap.put("lightblue", Integer.valueOf(0xadd8e6));
        hashmap.put("lightcoral", Integer.valueOf(0xf08080));
        hashmap.put("lightcyan", Integer.valueOf(0xe0ffff));
        hashmap.put("lightgoldenrodyellow", Integer.valueOf(0xfafad2));
        hashmap.put("lightgray", Integer.valueOf(0xd3d3d3));
        hashmap.put("lightgreen", Integer.valueOf(0x90ee90));
        hashmap.put("lightgrey", Integer.valueOf(0xd3d3d3));
        hashmap.put("lightpink", Integer.valueOf(0xffb6c1));
        hashmap.put("lightsalmon", Integer.valueOf(0xffa07a));
        hashmap.put("lightseagreen", Integer.valueOf(0x20b2aa));
        hashmap.put("lightskyblue", Integer.valueOf(0x87cefa));
        hashmap.put("lightslategray", Integer.valueOf(0x778899));
        hashmap.put("lightslategrey", Integer.valueOf(0x778899));
        hashmap.put("lightsteelblue", Integer.valueOf(0xb0c4de));
        hashmap.put("lightyellow", Integer.valueOf(0xffffe0));
        hashmap.put("lime", Integer.valueOf(65280));
        hashmap.put("limegreen", Integer.valueOf(0x32cd32));
        hashmap.put("linen", Integer.valueOf(0xfaf0e6));
        hashmap.put("magenta", Integer.valueOf(0xff00ff));
        hashmap.put("maroon", Integer.valueOf(0x800000));
        hashmap.put("mediumaquamarine", Integer.valueOf(0x66cdaa));
        hashmap.put("mediumblue", Integer.valueOf(205));
        hashmap.put("mediumorchid", Integer.valueOf(0xba55d3));
        hashmap.put("mediumpurple", Integer.valueOf(0x9370db));
        hashmap.put("mediumseagreen", Integer.valueOf(0x3cb371));
        hashmap.put("mediumslateblue", Integer.valueOf(0x7b68ee));
        hashmap.put("mediumspringgreen", Integer.valueOf(64154));
        hashmap.put("mediumturquoise", Integer.valueOf(0x48d1cc));
        hashmap.put("mediumvioletred", Integer.valueOf(0xc71585));
        hashmap.put("midnightblue", Integer.valueOf(0x191970));
        hashmap.put("mintcream", Integer.valueOf(0xf5fffa));
        hashmap.put("mistyrose", Integer.valueOf(0xffe4e1));
        hashmap.put("moccasin", Integer.valueOf(0xffe4b5));
        hashmap.put("navajowhite", Integer.valueOf(0xffdead));
        hashmap.put("navy", Integer.valueOf(128));
        hashmap.put("oldlace", Integer.valueOf(0xfdf5e6));
        hashmap.put("olive", Integer.valueOf(0x808000));
        hashmap.put("olivedrab", Integer.valueOf(0x6b8e23));
        hashmap.put("orange", Integer.valueOf(0xffa500));
        hashmap.put("orangered", Integer.valueOf(0xff4500));
        hashmap.put("orchid", Integer.valueOf(0xda70d6));
        hashmap.put("palegoldenrod", Integer.valueOf(0xeee8aa));
        hashmap.put("palegreen", Integer.valueOf(0x98fb98));
        hashmap.put("paleturquoise", Integer.valueOf(0xafeeee));
        hashmap.put("palevioletred", Integer.valueOf(0xdb7093));
        hashmap.put("papayawhip", Integer.valueOf(0xffefd5));
        hashmap.put("peachpuff", Integer.valueOf(0xffdab9));
        hashmap.put("peru", Integer.valueOf(0xcd853f));
        hashmap.put("pink", Integer.valueOf(0xffc0cb));
        hashmap.put("plum", Integer.valueOf(0xdda0dd));
        hashmap.put("powderblue", Integer.valueOf(0xb0e0e6));
        hashmap.put("purple", Integer.valueOf(0x800080));
        hashmap.put("red", Integer.valueOf(0xff0000));
        hashmap.put("rosybrown", Integer.valueOf(0xbc8f8f));
        hashmap.put("royalblue", Integer.valueOf(0x4169e1));
        hashmap.put("saddlebrown", Integer.valueOf(0x8b4513));
        hashmap.put("salmon", Integer.valueOf(0xfa8072));
        hashmap.put("sandybrown", Integer.valueOf(0xf4a460));
        hashmap.put("seagreen", Integer.valueOf(0x2e8b57));
        hashmap.put("seashell", Integer.valueOf(0xfff5ee));
        hashmap.put("sienna", Integer.valueOf(0xa0522d));
        hashmap.put("silver", Integer.valueOf(0xc0c0c0));
        hashmap.put("skyblue", Integer.valueOf(0x87ceeb));
        hashmap.put("slateblue", Integer.valueOf(0x6a5acd));
        hashmap.put("slategray", Integer.valueOf(0x708090));
        hashmap.put("slategrey", Integer.valueOf(0x708090));
        hashmap.put("snow", Integer.valueOf(0xfffafa));
        hashmap.put("springgreen", Integer.valueOf(65407));
        hashmap.put("steelblue", Integer.valueOf(0x4682b4));
        hashmap.put("tan", Integer.valueOf(0xd2b48c));
        hashmap.put("teal", Integer.valueOf(32896));
        hashmap.put("thistle", Integer.valueOf(0xd8bfd8));
        hashmap.put("tomato", Integer.valueOf(0xff6347));
        hashmap.put("turquoise", Integer.valueOf(0x40e0d0));
        hashmap.put("violet", Integer.valueOf(0xee82ee));
        hashmap.put("wheat", Integer.valueOf(0xf5deb3));
        hashmap.put("white", Integer.valueOf(0xffffff));
        hashmap.put("whitesmoke", Integer.valueOf(0xf5f5f5));
        hashmap.put("yellow", Integer.valueOf(0xffff00));
        hashmap.put("yellowgreen", Integer.valueOf(0x9acd32));
        a = Collections.unmodifiableMap(hashmap);
    }
}
