// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.FloatMath;
import android.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.XMLReader;

// Referenced classes of package com.larvalabs.svgandroid:
//            SVG, SVGParseException, ParserHelper

public class SVGParser
{

    private static boolean a = true;
    private static final Pattern b = Pattern.compile("[\\s,]*");
    private static final RectF c = new RectF();
    private static final Matrix d = new Matrix();
    private static final Matrix e = new Matrix();

    private static float a(float f, float f1, float f2, float f3)
    {
        return (float)Math.toDegrees(Math.atan2(f, f1) - Math.atan2(f2, f3)) % 360F;
    }

    static Matrix a(String s)
    {
        Matrix matrix = new Matrix();
_L3:
        if (!s.startsWith("matrix(")) goto _L2; else goto _L1
_L1:
        NumberParse numberparse = d(s.substring(7));
        if (NumberParse.a(numberparse).size() == 6)
        {
            Matrix matrix1 = new Matrix();
            matrix1.setValues(new float[] {
                ((Float)NumberParse.a(numberparse).get(0)).floatValue(), ((Float)NumberParse.a(numberparse).get(2)).floatValue(), ((Float)NumberParse.a(numberparse).get(4)).floatValue(), ((Float)NumberParse.a(numberparse).get(1)).floatValue(), ((Float)NumberParse.a(numberparse).get(3)).floatValue(), ((Float)NumberParse.a(numberparse).get(5)).floatValue(), 0.0F, 0.0F, 1.0F
            });
            matrix.preConcat(matrix1);
        }
_L4:
        int i = s.indexOf(")");
        float f1;
        float f3;
        NumberParse numberparse1;
        if (i > 0 && s.length() > i + 1)
        {
            s = b.matcher(s.substring(i + 1)).replaceFirst("");
        } else
        {
            return matrix;
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (s.startsWith("translate("))
        {
            numberparse1 = d(s.substring(10));
            if (NumberParse.a(numberparse1).size() > 0)
            {
                f1 = ((Float)NumberParse.a(numberparse1).get(0)).floatValue();
                float f;
                float f2;
                if (NumberParse.a(numberparse1).size() > 1)
                {
                    f = ((Float)NumberParse.a(numberparse1).get(1)).floatValue();
                } else
                {
                    f = 0.0F;
                }
                matrix.preTranslate(f1, f);
            }
        } else
        if (s.startsWith("scale("))
        {
            numberparse1 = d(s.substring(6));
            if (NumberParse.a(numberparse1).size() > 0)
            {
                f2 = ((Float)NumberParse.a(numberparse1).get(0)).floatValue();
                if (NumberParse.a(numberparse1).size() > 1)
                {
                    f = ((Float)NumberParse.a(numberparse1).get(1)).floatValue();
                } else
                {
                    f = f2;
                }
                matrix.preScale(f2, f);
            }
        } else
        if (s.startsWith("skewX("))
        {
            numberparse1 = d(s.substring(6));
            if (NumberParse.a(numberparse1).size() > 0)
            {
                matrix.preSkew((float)Math.tan(((Float)NumberParse.a(numberparse1).get(0)).floatValue()), 0.0F);
            }
        } else
        if (s.startsWith("skewY("))
        {
            numberparse1 = d(s.substring(6));
            if (NumberParse.a(numberparse1).size() > 0)
            {
                matrix.preSkew(0.0F, (float)Math.tan(((Float)NumberParse.a(numberparse1).get(0)).floatValue()));
            }
        } else
        if (s.startsWith("rotate("))
        {
            numberparse1 = d(s.substring(7));
            if (NumberParse.a(numberparse1).size() > 0)
            {
                f3 = ((Float)NumberParse.a(numberparse1).get(0)).floatValue();
                if (NumberParse.a(numberparse1).size() > 2)
                {
                    f2 = ((Float)NumberParse.a(numberparse1).get(1)).floatValue();
                    f = ((Float)NumberParse.a(numberparse1).get(2)).floatValue();
                } else
                {
                    f = 0.0F;
                    f2 = 0.0F;
                }
                matrix.preTranslate(-f2, -f);
                matrix.preRotate(f3);
                matrix.preTranslate(f2, f);
            }
        } else
        {
            Log.w("SVGAndroid", (new StringBuilder("Invalid transform (")).append(s).append(")").toString());
        }
          goto _L4
    }

    static SVG a(InputSource inputsource, SVGHandler svghandler)
    {
        Picture picture;
        XMLReader xmlreader;
        SAXNotRecognizedException saxnotrecognizedexception;
        boolean flag;
        try
        {
            picture = new Picture();
            svghandler.a(picture);
            xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xmlreader.setContentHandler(svghandler);
            xmlreader.setFeature("http://xml.org/sax/features/validation", false);
            flag = a;
        }
        // Misplaced declaration of an exception variable
        catch (InputSource inputsource)
        {
            Log.e("SVGAndroid", "Failed to parse SVG.", inputsource);
            throw new SVGParseException(inputsource);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        xmlreader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
_L1:
        xmlreader.parse(inputsource);
        inputsource = new SVG(picture, svghandler.j);
        if (Float.isInfinite(svghandler.k.top))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        inputsource.a(svghandler.k);
        return inputsource;
        saxnotrecognizedexception;
        a = false;
          goto _L1
        return inputsource;
    }

    private static Float a(String s, Float float1)
    {
        if (s == null)
        {
            return float1;
        }
        if (s.endsWith("px"))
        {
            float1 = s.substring(0, s.length() - 2);
        } else
        {
            float1 = s;
            if (s.endsWith("%"))
            {
                return Float.valueOf(Float.parseFloat(s.substring(0, s.length() - 1)) / 100F);
            }
        }
        return Float.valueOf(Float.parseFloat(float1));
    }

    static Float a(String s, Attributes attributes, Float float1)
    {
        return b(s, attributes, float1);
    }

    static String a(String s, Attributes attributes)
    {
        return d(s, attributes);
    }

    static Float b(String s)
    {
        return a(s, ((Float) (null)));
    }

    static Float b(String s, Attributes attributes)
    {
        return b(s, attributes, null);
    }

    private static Float b(String s, Attributes attributes, Float float1)
    {
        return a(d(s, attributes), float1);
    }

    static Path c(String s)
    {
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        char c1;
        ParserHelper parserhelper;
        Path path;
        int j;
        j = s.length();
        parserhelper = new ParserHelper(s);
        parserhelper.a();
        path = new Path();
        c1 = '\0';
        f1 = 0.0F;
        f = 0.0F;
        f2 = 0.0F;
        f5 = 0.0F;
        f4 = 0.0F;
        f3 = 0.0F;
_L18:
        if (parserhelper.a >= j) goto _L2; else goto _L1
_L1:
        char c2 = s.charAt(parserhelper.a);
        c2;
        JVM INSTR tableswitch 43 57: default 144
    //                   43 443
    //                   44 144
    //                   45 443
    //                   46 144
    //                   47 144
    //                   48 443
    //                   49 443
    //                   50 443
    //                   51 443
    //                   52 443
    //                   53 443
    //                   54 443
    //                   55 443
    //                   56 443
    //                   57 443;
           goto _L3 _L4 _L3 _L4 _L3 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L3:
        parserhelper.b();
        c1 = c2;
        char c3 = c2;
        c2 = c1;
        c1 = c3;
_L14:
        c2;
        JVM INSTR lookupswitch 20: default 336
    //                   65: 1279
    //                   67: 987
    //                   72: 767
    //                   76: 648
    //                   77: 488
    //                   81: 1148
    //                   83: 1148
    //                   84: 648
    //                   86: 877
    //                   90: 607
    //                   97: 1279
    //                   99: 987
    //                   104: 767
    //                   108: 648
    //                   109: 488
    //                   113: 1148
    //                   115: 1148
    //                   116: 648
    //                   118: 877
    //                   122: 607;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L9 _L12 _L13 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L9 _L12 _L13
_L5:
        int i;
        Log.w("SVGAndroid", (new StringBuilder("Invalid path command: ")).append(c2).toString());
        parserhelper.b();
        float f6 = f1;
        float f19 = f;
        i = 0;
        f1 = f4;
        f = f5;
        f5 = f2;
        f4 = f3;
        f3 = f19;
        f2 = f6;
_L16:
        if (i == 0)
        {
            f4 = f;
            f5 = f1;
        }
        parserhelper.a();
        float f7 = f3;
        float f20 = f;
        float f31 = f1;
        f3 = f4;
        f1 = f2;
        f = f7;
        f2 = f5;
        f5 = f20;
        f4 = f31;
        continue; /* Loop/switch isn't completed */
_L4:
        if (c1 != 'm' && c1 != 'M')
        {
            continue; /* Loop/switch isn't completed */
        }
        c2 = (char)(c1 - 1);
          goto _L14
        if ("lhvcsqta".indexOf(Character.toLowerCase(c1)) < 0) goto _L3; else goto _L15
_L15:
        c2 = c1;
          goto _L14
_L10:
        float f8 = parserhelper.c();
        float f21 = parserhelper.c();
        if (c2 == 'm')
        {
            path.rMoveTo(f8, f21);
            float f40 = f1 + f21;
            f1 = f3;
            float f32 = f2;
            f21 = f5 + f21;
            f3 = f + f8;
            i = 0;
            f8 = f4 + f8;
            f2 = f40;
            f4 = f1;
            f5 = f32;
            f = f21;
            f1 = f8;
        } else
        {
            path.moveTo(f8, f21);
            i = 0;
            f5 = f2;
            f = f21;
            f1 = f8;
            f4 = f3;
            f2 = f21;
            f3 = f8;
        }
          goto _L16
_L13:
        path.close();
        path.moveTo(f, f1);
        f3 = f;
        f4 = f1;
        f5 = f;
        float f9 = f1;
        float f22 = f;
        i = 1;
        f2 = f1;
        f = f9;
        f1 = f22;
          goto _L16
_L9:
        float f41 = parserhelper.c();
        float f33 = parserhelper.c();
        if (c2 == 'l')
        {
            path.rLineTo(f41, f33);
            float f23 = f1;
            f1 = f3;
            float f10 = f2;
            f33 = f5 + f33;
            i = 0;
            f41 = f4 + f41;
            f2 = f23;
            f3 = f;
            f4 = f1;
            f5 = f10;
            f = f33;
            f1 = f41;
        } else
        {
            path.lineTo(f41, f33);
            f4 = f1;
            f5 = f2;
            i = 0;
            f1 = f41;
            float f11 = f3;
            f2 = f4;
            f3 = f;
            f4 = f11;
            f = f33;
        }
          goto _L16
_L8:
        float f42 = parserhelper.c();
        if (c2 == 'h')
        {
            path.rLineTo(f42, 0.0F);
            float f34 = f1;
            f1 = f3;
            float f12 = f2;
            float f24 = f5;
            i = 0;
            f42 = f4 + f42;
            f2 = f34;
            f3 = f;
            f4 = f1;
            f5 = f12;
            f = f24;
            f1 = f42;
        } else
        {
            path.lineTo(f42, f5);
            float f25 = f1;
            f4 = f3;
            f1 = f2;
            i = 0;
            f3 = f;
            float f13 = f42;
            f = f5;
            f2 = f25;
            f5 = f1;
            f1 = f13;
        }
          goto _L16
_L12:
        float f35 = parserhelper.c();
        if (c2 == 'v')
        {
            path.rLineTo(0.0F, f35);
            float f26 = f1;
            f1 = f3;
            float f14 = f2;
            float f43 = f5 + f35;
            i = 0;
            f35 = f4;
            f2 = f26;
            f3 = f;
            f4 = f1;
            f5 = f14;
            f = f43;
            f1 = f35;
        } else
        {
            path.lineTo(f4, f35);
            float f27 = f1;
            f1 = f3;
            f5 = f2;
            i = 0;
            float f15 = f4;
            f2 = f27;
            f3 = f;
            f4 = f1;
            f = f35;
            f1 = f15;
        }
          goto _L16
_L7:
        float f62 = parserhelper.c();
        float f54 = parserhelper.c();
        float f60 = parserhelper.c();
        float f51 = parserhelper.c();
        float f57 = parserhelper.c();
        float f48 = parserhelper.c();
        float f44 = f62;
        float f36 = f54;
        float f28 = f60;
        float f16 = f51;
        f3 = f57;
        f2 = f48;
        if (c2 == 'c')
        {
            f44 = f62 + f4;
            f28 = f60 + f4;
            f3 = f57 + f4;
            f36 = f54 + f5;
            f16 = f51 + f5;
            f2 = f48 + f5;
        }
        path.cubicTo(f44, f36, f28, f16, f3, f2);
        f4 = f1;
        i = 1;
        f5 = f28;
        f1 = f3;
        f28 = f2;
        f2 = f4;
        f3 = f;
        f4 = f16;
        f = f28;
          goto _L16
_L11:
        float f58 = parserhelper.c();
        float f52 = parserhelper.c();
        float f55 = parserhelper.c();
        float f49 = parserhelper.c();
        float f45 = f58;
        float f37 = f52;
        float f29 = f55;
        float f17 = f49;
        if (Character.isLowerCase(c2))
        {
            f45 = f58 + f4;
            f29 = f55 + f4;
            f37 = f52 + f5;
            f17 = f49 + f5;
        }
        path.cubicTo(2.0F * f4 - f2, 2.0F * f5 - f3, f45, f37, f29, f17);
        f2 = f1;
        i = 1;
        f5 = f45;
        f4 = f37;
        f1 = f29;
        f3 = f;
        f = f17;
          goto _L16
_L6:
        float f53 = parserhelper.c();
        float f50 = parserhelper.c();
        float f61 = parserhelper.c();
        i = parserhelper.d();
        int k = parserhelper.d();
        float f46 = parserhelper.c();
        float f38 = parserhelper.c();
        float f30 = f38;
        float f18 = f46;
        if (c2 == 'a')
        {
            f18 = f46 + f4;
            f30 = f38 + f5;
        }
        if (f53 == 0.0F || f50 == 0.0F)
        {
            path.lineTo(f18, f30);
        } else
        if (f18 != f4 || f30 != f5)
        {
            float f56 = Math.abs(f53);
            float f59 = Math.abs(f50);
            float f39 = (3.141593F * f61) / 180F;
            float f64 = FloatMath.sin(f39);
            float f65 = FloatMath.cos(f39);
            f39 = (f4 - f18) / 2.0F;
            float f47 = (f5 - f30) / 2.0F;
            float f63 = f65 * f39 + f64 * f47;
            float f66 = f39 * -f64 + f47 * f65;
            float f67 = f63 * f63;
            float f68 = f66 * f66;
            f53 = f56 * f56;
            f50 = f59 * f59;
            float f69 = (f67 / f53 + f68 / f50) * 1.001F;
            f47 = f59;
            f39 = f56;
            if (f69 > 1.0F)
            {
                f47 = FloatMath.sqrt(f69);
                f39 = f56 * f47;
                f47 = f59 * f47;
                f53 = f39 * f39;
                f50 = f47 * f47;
            }
            f50 = FloatMath.sqrt((f53 * f50 - f53 * f68 - f50 * f67) / (f50 * f67 + f53 * f68));
            if (i == k)
            {
                i = -1;
            } else
            {
                i = 1;
            }
            f50 = (float)i * f50;
            f53 = (f50 * f39 * f66) / f47;
            f56 = (-f50 * f47 * f63) / f39;
            f50 = (f4 + f18) / 2.0F + (f65 * f53 - f64 * f56);
            f59 = (f5 + f30) / 2.0F + (f64 * f53 + f65 * f56);
            f64 = a(1.0F, 0.0F, (f63 - f53) / f39, (f66 - f56) / f47);
            f5 = a((f63 - f53) / f39, (f66 - f56) / f47, (-f63 - f53) / f39, (-f66 - f56) / f47);
            if (k == 0 && f5 > 0.0F)
            {
                f4 = f5 - 360F;
            } else
            {
                f4 = f5;
                if (k != 0)
                {
                    f4 = f5;
                    if (f5 < 0.0F)
                    {
                        f4 = f5 + 360F;
                    }
                }
            }
            if (f61 % 360F == 0.0F)
            {
                c.set(f50 - f39, f59 - f47, f39 + f50, f47 + f59);
                path.arcTo(c, f64, f4);
            } else
            {
                c.set(-f39, -f47, f39, f47);
                d.reset();
                d.postRotate(f61);
                d.postTranslate(f50, f59);
                d.invert(e);
                path.transform(e);
                path.arcTo(c, f64, f4);
                path.transform(d);
            }
        }
        f4 = f3;
        f5 = f2;
        i = 0;
        f2 = f1;
        f3 = f;
        f = f30;
        f1 = f18;
          goto _L16
_L2:
        return path;
        if (true) goto _L18; else goto _L17
_L17:
    }

    static NumberParse c(String s, Attributes attributes)
    {
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if (attributes.getLocalName(i).equals(s))
            {
                return d(attributes.getValue(i));
            }
        }

        return null;
    }

    private static NumberParse d(String s)
    {
        ArrayList arraylist;
        int i;
        int j;
        int k;
        int l;
        int j1;
        j1 = s.length();
        arraylist = new ArrayList();
        k = 1;
        j = 0;
        i = 0;
        l = 0;
_L5:
        if (k >= j1) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        i = j;
        j = 0;
_L11:
        int i1 = k + 1;
        k = i;
        i = j;
        j = k;
        k = i1;
          goto _L5
_L4:
        char c1 = s.charAt(k);
        c1;
        JVM INSTR lookupswitch 27: default 300
    //                   9: 355
    //                   10: 355
    //                   32: 355
    //                   41: 308
    //                   44: 355
    //                   45: 350
    //                   65: 308
    //                   67: 308
    //                   72: 308
    //                   76: 308
    //                   77: 308
    //                   81: 308
    //                   83: 308
    //                   84: 308
    //                   86: 308
    //                   90: 308
    //                   97: 308
    //                   99: 308
    //                   101: 429
    //                   104: 308
    //                   108: 308
    //                   109: 308
    //                   113: 308
    //                   115: 308
    //                   116: 308
    //                   118: 308
    //                   122: 308;
           goto _L6 _L7 _L7 _L7 _L8 _L7 _L9 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L10 _L8 _L8 _L8 _L8 _L8 _L8 _L8 _L8
_L6:
        j = i;
        i = 0;
          goto _L11
_L8:
        s = s.substring(l, k);
        if (s.trim().length() > 0)
        {
            arraylist.add(Float.valueOf(Float.parseFloat(s)));
        }
        return new NumberParse(arraylist, k);
_L9:
        if (j != 0) goto _L6; else goto _L7
_L7:
        String s1 = s.substring(l, k);
        if (s1.trim().length() > 0)
        {
            arraylist.add(Float.valueOf(Float.parseFloat(s1)));
            if (c1 == '-')
            {
                j = k;
            } else
            {
                j = k + 1;
                i = 1;
            }
        } else
        {
            j = l + 1;
        }
        l = j;
        j = i;
        i = 0;
          goto _L11
_L10:
        j = i;
        i = 1;
          goto _L11
_L2:
        String s2 = s.substring(l);
        if (s2.length() > 0)
        {
            try
            {
                arraylist.add(Float.valueOf(Float.parseFloat(s2)));
            }
            catch (NumberFormatException numberformatexception) { }
            l = s.length();
        }
        return new NumberParse(arraylist, l);
    }

    private static String d(String s, Attributes attributes)
    {
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if (attributes.getLocalName(i).equals(s))
            {
                return attributes.getValue(i);
            }
        }

        return null;
    }


    private class NumberParse
    {

        private ArrayList a;
        private int b;

        static ArrayList a(NumberParse numberparse)
        {
            return numberparse.a;
        }

        public NumberParse(ArrayList arraylist, int i)
        {
            a = arraylist;
            b = i;
        }
    }


    private class SVGHandler extends DefaultHandler
    {

        private boolean A;
        private final RectF B = new RectF();
        Paint a;
        boolean b;
        Stack c;
        Stack d;
        Paint e;
        boolean f;
        Stack g;
        Stack h;
        RectF i;
        RectF j;
        RectF k;
        Integer l;
        Integer m;
        boolean n;
        Integer o;
        Stack p;
        Stack q;
        HashMap r;
        Gradient s;
        private Picture t;
        private Canvas u;
        private Float v;
        private Float w;
        private final Matrix x = new Matrix();
        private boolean y;
        private int z;

        private static float a(String s1, float f1)
        {
            float f2;
            try
            {
                f2 = Float.parseFloat(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return f1;
            }
            return f2;
        }

        private static Gradient a(boolean flag, Attributes attributes)
        {
            Gradient gradient = new Gradient((byte)0);
            gradient.a = SVGParser.a("id", attributes);
            gradient.c = flag;
            Object obj;
            String s1;
            if (flag)
            {
                gradient.d = SVGParser.a("x1", attributes, Float.valueOf(0.0F)).floatValue();
                gradient.f = SVGParser.a("x2", attributes, Float.valueOf(1.0F)).floatValue();
                gradient.e = SVGParser.a("y1", attributes, Float.valueOf(0.0F)).floatValue();
                gradient.g = SVGParser.a("y2", attributes, Float.valueOf(0.0F)).floatValue();
            } else
            {
                gradient.h = SVGParser.a("cx", attributes, Float.valueOf(0.0F)).floatValue();
                gradient.i = SVGParser.a("cy", attributes, Float.valueOf(0.0F)).floatValue();
                gradient.j = SVGParser.a("r", attributes, Float.valueOf(0.0F)).floatValue();
            }
            obj = SVGParser.a("gradientTransform", attributes);
            if (obj != null)
            {
                gradient.m = SVGParser.a(((String) (obj)));
            }
            s1 = SVGParser.a("spreadMethod", attributes);
            obj = s1;
            if (s1 == null)
            {
                obj = "pad";
            }
            if (((String) (obj)).equals("reflect"))
            {
                obj = android.graphics.Shader.TileMode.MIRROR;
            } else
            if (((String) (obj)).equals("repeat"))
            {
                obj = android.graphics.Shader.TileMode.REPEAT;
            } else
            {
                obj = android.graphics.Shader.TileMode.CLAMP;
            }
            gradient.p = ((android.graphics.Shader.TileMode) (obj));
            s1 = SVGParser.a("gradientUnits", attributes);
            obj = s1;
            if (s1 == null)
            {
                obj = "objectBoundingBox";
            }
            if (!((String) (obj)).equals("userSpaceOnUse"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            gradient.o = flag;
            obj = SVGParser.a("href", attributes);
            if (obj != null)
            {
                attributes = ((Attributes) (obj));
                if (((String) (obj)).startsWith("#"))
                {
                    attributes = ((String) (obj)).substring(1);
                }
                gradient.b = attributes;
            }
            return gradient;
        }

        private void a()
        {
            if (((Boolean)p.pop()).booleanValue())
            {
                u.restore();
                q.pop();
            }
        }

        private void a(float f1, float f2)
        {
            if (f1 < k.left)
            {
                k.left = f1;
            }
            if (f1 > k.right)
            {
                k.right = f1;
            }
            if (f2 < k.top)
            {
                k.top = f2;
            }
            if (f2 > k.bottom)
            {
                k.bottom = f2;
            }
        }

        private void a(RectF rectf, Paint paint)
        {
            ((Matrix)q.peek()).mapRect(B, rectf);
            float f1;
            if (paint == null)
            {
                f1 = 0.0F;
            } else
            {
                f1 = paint.getStrokeWidth() / 2.0F;
            }
            a(B.left - f1, B.top - f1);
            a(B.right + f1, f1 + B.bottom);
        }

        private void a(Properties properties, Integer integer, boolean flag, Paint paint)
        {
            int j1 = 0xffffff & integer.intValue() | 0xff000000;
            int i1 = j1;
            if (l != null)
            {
                i1 = j1;
                if (l.intValue() == j1)
                {
                    i1 = m.intValue();
                }
            }
            paint.setShader(null);
            paint.setColor(i1);
            Float float1 = properties.c("opacity");
            integer = float1;
            if (float1 == null)
            {
                if (flag)
                {
                    integer = "fill-opacity";
                } else
                {
                    integer = "stroke-opacity";
                }
                integer = properties.c(integer);
            }
            if (integer == null)
            {
                paint.setAlpha(255);
                return;
            } else
            {
                paint.setAlpha((int)(integer.floatValue() * 255F));
                return;
            }
        }

        private void a(Attributes attributes)
        {
            attributes = SVGParser.a("transform", attributes);
            boolean flag;
            if (attributes != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            p.push(Boolean.valueOf(flag));
            if (flag)
            {
                attributes = SVGParser.a(attributes);
                u.save();
                u.concat(attributes);
                attributes.postConcat((Matrix)q.peek());
                q.push(attributes);
            }
        }

        private boolean a(Properties properties)
        {
            float f3;
            f3 = 0.0F;
            break MISSING_BLOCK_LABEL_3;
_L6:
            float f2;
            if (b)
            {
                if (a.getColor() != 0)
                {
                    return true;
                }
            } else
            {
                a.setColor(0);
                return false;
            }
            do
            {
                return false;
            } while (n || "none".equals(properties.a("display")));
            obj = properties.c("stroke-width");
            if (obj != null)
            {
                a.setStrokeWidth(((Float) (obj)).floatValue());
            }
            obj = properties.a("stroke-linecap");
            if ("round".equals(obj))
            {
                a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
            } else
            if ("square".equals(obj))
            {
                a.setStrokeCap(android.graphics.Paint.Cap.SQUARE);
            } else
            if ("butt".equals(obj))
            {
                a.setStrokeCap(android.graphics.Paint.Cap.BUTT);
            }
            obj = properties.a("stroke-linejoin");
            if ("miter".equals(obj))
            {
                a.setStrokeJoin(android.graphics.Paint.Join.MITER);
            } else
            if ("round".equals(obj))
            {
                a.setStrokeJoin(android.graphics.Paint.Join.ROUND);
            } else
            if ("bevel".equals(obj))
            {
                a.setStrokeJoin(android.graphics.Paint.Join.BEVEL);
            }
            obj1 = properties.a("stroke-dasharray");
            obj = properties.a("stroke-dashoffset");
            if (obj1 == null) goto _L2; else goto _L1
_L1:
            if (!((String) (obj1)).equals("none")) goto _L4; else goto _L3
_L3:
            a.setPathEffect(null);
_L2:
            obj = properties.a("stroke");
            if (obj == null) goto _L6; else goto _L5
_L4:
            stringtokenizer = new StringTokenizer(((String) (obj1)), " ,");
            j1 = stringtokenizer.countTokens();
            i1 = j1;
            if ((j1 & 1) == 1)
            {
                i1 = j1 * 2;
            }
            af = new float[i1];
            f2 = 1.0F;
            f1 = 0.0F;
            for (i1 = 0; stringtokenizer.hasMoreTokens(); i1++)
            {
                f2 = a(stringtokenizer.nextToken(), f2);
                af[i1] = f2;
                f1 += f2;
            }

            for (j1 = 0; i1 < af.length; j1++)
            {
                f2 = af[j1];
                af[i1] = f2;
                f1 += f2;
                i1++;
            }

            f2 = f3;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_437;
            }
            f2 = Float.parseFloat(((String) (obj)));
            f2 %= f1;
_L7:
            a.setPathEffect(new DashPathEffect(af, f2));
              goto _L2
_L5:
            if (((String) (obj)).equalsIgnoreCase("none"))
            {
                a.setColor(0);
                return false;
            }
            af = properties.b("stroke");
            if (af != null)
            {
                a(properties, ((Integer) (af)), false, a);
                return true;
            } else
            {
                Log.w("SVGAndroid", (new StringBuilder("Unrecognized stroke color, using none: ")).append(((String) (obj))).toString());
                a.setColor(0);
                return false;
            }
            NumberFormatException numberformatexception;
            numberformatexception;
            f2 = f3;
              goto _L7
        }

        private boolean a(Properties properties, RectF rectf)
        {
            if (!"none".equals(properties.a("display")))
            {
                if (n)
                {
                    e.setShader(null);
                    e.setColor(-1);
                    return true;
                }
                Object obj = properties.a("fill");
                if (obj != null)
                {
                    if (((String) (obj)).startsWith("url(#"))
                    {
                        String s1 = ((String) (obj)).substring(5, ((String) (obj)).length() - 1);
                        Gradient gradient = (Gradient)r.get(s1);
                        if (gradient != null)
                        {
                            obj = gradient.n;
                        } else
                        {
                            obj = null;
                        }
                        if (obj != null)
                        {
                            e.setShader(((Shader) (obj)));
                            x.set(gradient.m);
                            if (gradient.o && rectf != null)
                            {
                                x.preTranslate(rectf.left, rectf.top);
                                x.preScale(rectf.width(), rectf.height());
                            }
                            ((Shader) (obj)).setLocalMatrix(x);
                            return true;
                        } else
                        {
                            Log.w("SVGAndroid", (new StringBuilder("Didn't find shader, using black: ")).append(s1).toString());
                            e.setShader(null);
                            a(properties, Integer.valueOf(0xff000000), true, e);
                            return true;
                        }
                    }
                    if (((String) (obj)).equalsIgnoreCase("none"))
                    {
                        e.setShader(null);
                        e.setColor(0);
                        return true;
                    }
                    e.setShader(null);
                    rectf = properties.b("fill");
                    if (rectf != null)
                    {
                        a(properties, ((Integer) (rectf)), true, e);
                        return true;
                    } else
                    {
                        Log.w("SVGAndroid", (new StringBuilder("Unrecognized fill color, using black: ")).append(((String) (obj))).toString());
                        a(properties, Integer.valueOf(0xff000000), true, e);
                        return true;
                    }
                }
                if (f)
                {
                    if (e.getColor() != 0)
                    {
                        return true;
                    }
                } else
                {
                    e.setShader(null);
                    e.setColor(0xff000000);
                    return true;
                }
            }
            return false;
        }

        final void a(Picture picture)
        {
            t = picture;
        }

        public void characters(char ac[], int i1, int j1)
        {
        }

        public void endDocument()
        {
        }

        public void endElement(String s1, String s2, String s3)
        {
            boolean flag = false;
            if (!s2.equals("svg")) goto _L2; else goto _L1
_L1:
            if (o != null)
            {
                u.restoreToCount(o.intValue());
            }
            if (v != null)
            {
                s1 = k;
                s1.left = ((RectF) (s1)).left + v.floatValue();
                s1 = k;
                s1.right = ((RectF) (s1)).right + v.floatValue();
            }
            if (w != null)
            {
                s1 = k;
                s1.top = ((RectF) (s1)).top + w.floatValue();
                s1 = k;
                s1.bottom = ((RectF) (s1)).bottom + w.floatValue();
            }
            t.endRecording();
_L4:
            return;
_L2:
            if (!s2.equals("linearGradient") && !s2.equals("radialGradient"))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (s.a == null) goto _L4; else goto _L3
_L3:
            if (s.b != null)
            {
                s1 = (Gradient)r.get(s.b);
                if (s1 != null)
                {
                    s = s1.a(s);
                }
            }
            s1 = new int[s.l.size()];
            for (int i1 = 0; i1 < s1.length; i1++)
            {
                s1[i1] = ((Integer)s.l.get(i1)).intValue();
            }

            s3 = new float[s.k.size()];
            for (int j1 = ((flag) ? 1 : 0); j1 < s3.length; j1++)
            {
                s3[j1] = ((Float)s.k.get(j1)).floatValue();
            }

            if (s1.length == 0)
            {
                Log.d("BAD", "BAD");
            }
            if (s2.equals("linearGradient"))
            {
                s.n = new LinearGradient(s.d, s.e, s.f, s.g, s1, s3, s.p);
            } else
            {
                s.n = new RadialGradient(s.h, s.i, s.j, s1, s3, s.p);
            }
            r.put(s.a, s);
            return;
            if (!s2.equals("g")) goto _L4; else goto _L5
_L5:
            if (A)
            {
                A = false;
            }
            if (y)
            {
                z = z - 1;
                if (z == 0)
                {
                    y = false;
                }
            }
            a();
            e = (Paint)g.pop();
            f = ((Boolean)h.pop()).booleanValue();
            a = (Paint)c.pop();
            b = ((Boolean)d.pop()).booleanValue();
            return;
        }

        public void startDocument()
        {
        }

        public void startElement(String s1, String s2, String s3, Attributes attributes)
        {
            a.setAlpha(255);
            e.setAlpha(255);
            if (!A) goto _L2; else goto _L1
_L1:
            if (s2.equals("rect"))
            {
                s2 = SVGParser.b("x", attributes);
                s1 = s2;
                if (s2 == null)
                {
                    s1 = Float.valueOf(0.0F);
                }
                s3 = SVGParser.b("y", attributes);
                s2 = s3;
                if (s3 == null)
                {
                    s2 = Float.valueOf(0.0F);
                }
                s3 = SVGParser.b("width", attributes);
                attributes = SVGParser.b("height", attributes);
                j = new RectF(s1.floatValue(), s2.floatValue(), s1.floatValue() + s3.floatValue(), s2.floatValue() + attributes.floatValue());
            }
_L4:
            return;
_L2:
            if (!s2.equals("svg"))
            {
                continue; /* Loop/switch isn't completed */
            }
            u = null;
            s1 = SVGParser.a("viewBox", attributes);
            if (s1 != null)
            {
                String as[] = s1.replace(',', ' ').split("\\s+");
                if (as.length == 4)
                {
                    s1 = SVGParser.b(as[0]);
                    s2 = SVGParser.b(as[1]);
                    s3 = SVGParser.b(as[2]);
                    Float float1 = SVGParser.b(as[3]);
                    if (s1 != null && s3 != null && s2 != null && float1 != null)
                    {
                        float f1 = FloatMath.ceil(s3.floatValue() - s1.floatValue());
                        float f4 = FloatMath.ceil(float1.floatValue() - s2.floatValue());
                        u = t.beginRecording((int)f1, (int)f4);
                        o = Integer.valueOf(u.save());
                        u.clipRect(0.0F, 0.0F, f1, f4);
                        v = Float.valueOf(-s1.floatValue());
                        w = Float.valueOf(-s2.floatValue());
                        u.translate(v.floatValue(), w.floatValue());
                    }
                }
            }
            if (u == null)
            {
                int i1 = (int)FloatMath.ceil(SVGParser.b("width", attributes).floatValue());
                int l1 = (int)FloatMath.ceil(SVGParser.b("height", attributes).floatValue());
                u = t.beginRecording(i1, l1);
                o = null;
                return;
            }
            continue; /* Loop/switch isn't completed */
            if (s2.equals("defs")) goto _L4; else goto _L3
_L3:
            if (s2.equals("linearGradient"))
            {
                s = a(true, attributes);
                return;
            }
            if (s2.equals("radialGradient"))
            {
                s = a(false, attributes);
                return;
            }
            if (!s2.equals("stop"))
            {
                break; /* Loop/switch isn't completed */
            }
            if (s != null)
            {
                s1 = new Properties(attributes, (byte)0);
                float f2 = s1.a("offset", 0.0F).floatValue();
                int j1 = s1.b("stop-color").intValue();
                int i2 = Math.round(s1.a("stop-opacity", 1.0F).floatValue() * 255F);
                s.k.add(Float.valueOf(f2));
                s.l.add(Integer.valueOf(i2 << 24 | j1));
                return;
            }
            if (true) goto _L4; else goto _L5
_L5:
            if (s2.equals("g"))
            {
                if ("bounds".equalsIgnoreCase(SVGParser.a("id", attributes)))
                {
                    A = true;
                }
                if (y)
                {
                    z = z + 1;
                }
                if ("none".equals(SVGParser.a("display", attributes)) && !y)
                {
                    y = true;
                    z = 1;
                }
                a(attributes);
                s1 = new Properties(attributes, (byte)0);
                g.push(new Paint(e));
                c.push(new Paint(a));
                h.push(Boolean.valueOf(f));
                d.push(Boolean.valueOf(b));
                a(s1, ((RectF) (null)));
                a(s1);
                boolean flag1 = f;
                boolean flag;
                if (s1.a("fill") != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f = flag | flag1;
                flag1 = b;
                if (s1.a("stroke") != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                b = flag | flag1;
                return;
            }
            if (!y && s2.equals("rect"))
            {
                s2 = SVGParser.b("x", attributes);
                s1 = s2;
                if (s2 == null)
                {
                    s1 = Float.valueOf(0.0F);
                }
                s3 = SVGParser.b("y", attributes);
                s2 = s3;
                if (s3 == null)
                {
                    s2 = Float.valueOf(0.0F);
                }
                s3 = SVGParser.b("width", attributes);
                Float float2 = SVGParser.b("height", attributes);
                Float float5 = SVGParser.a("rx", attributes, Float.valueOf(0.0F));
                Float float6 = SVGParser.a("ry", attributes, Float.valueOf(0.0F));
                a(attributes);
                attributes = new Properties(attributes, (byte)0);
                i.set(s1.floatValue(), s2.floatValue(), s1.floatValue() + s3.floatValue(), s2.floatValue() + float2.floatValue());
                if (a(attributes, i))
                {
                    i.set(s1.floatValue(), s2.floatValue(), s1.floatValue() + s3.floatValue(), s2.floatValue() + float2.floatValue());
                    if (float5.floatValue() <= 0.0F && float6.floatValue() <= 0.0F)
                    {
                        u.drawRect(i, e);
                    } else
                    {
                        u.drawRoundRect(i, float5.floatValue(), float6.floatValue(), e);
                    }
                    a(i, ((Paint) (null)));
                }
                if (a(attributes))
                {
                    i.set(s1.floatValue(), s2.floatValue(), s1.floatValue() + s3.floatValue(), s2.floatValue() + float2.floatValue());
                    if (float5.floatValue() <= 0.0F && float6.floatValue() <= 0.0F)
                    {
                        u.drawRect(i, a);
                    } else
                    {
                        u.drawRoundRect(i, float5.floatValue(), float6.floatValue(), a);
                    }
                    a(i, a);
                }
                a();
                return;
            }
            if (y || !s2.equals("line"))
            {
                break; /* Loop/switch isn't completed */
            }
            s1 = SVGParser.b("x1", attributes);
            s2 = SVGParser.b("x2", attributes);
            s3 = SVGParser.b("y1", attributes);
            Float float3 = SVGParser.b("y2", attributes);
            if (a(new Properties(attributes, (byte)0)))
            {
                a(attributes);
                i.set(s1.floatValue(), s3.floatValue(), s2.floatValue(), float3.floatValue());
                u.drawLine(s1.floatValue(), s3.floatValue(), s2.floatValue(), float3.floatValue(), a);
                a(i, a);
                a();
                return;
            }
            if (true) goto _L4; else goto _L6
_L6:
            if (y || !s2.equals("circle") && !s2.equals("ellipse"))
            {
                break; /* Loop/switch isn't completed */
            }
            s3 = SVGParser.b("cx", attributes);
            Float float4 = SVGParser.b("cy", attributes);
            if (s2.equals("ellipse"))
            {
                s2 = SVGParser.b("rx", attributes);
                s1 = SVGParser.b("ry", attributes);
            } else
            {
                s1 = SVGParser.b("r", attributes);
                s2 = s1;
            }
            if (s3 != null && float4 != null && s2 != null && s1 != null)
            {
                a(attributes);
                attributes = new Properties(attributes, (byte)0);
                RectF rectf = i;
                float f3 = s3.floatValue();
                float f5 = s2.floatValue();
                float f6 = float4.floatValue();
                float f7 = s1.floatValue();
                float f8 = s3.floatValue();
                float f9 = s2.floatValue();
                float f10 = float4.floatValue();
                rectf.set(f3 - f5, f6 - f7, f9 + f8, s1.floatValue() + f10);
                if (a(attributes, i))
                {
                    u.drawOval(i, e);
                    a(i, ((Paint) (null)));
                }
                if (a(attributes))
                {
                    u.drawOval(i, a);
                    a(i, a);
                }
                a();
                return;
            }
            if (true) goto _L4; else goto _L7
_L7:
            if (y || !s2.equals("polygon") && !s2.equals("polyline"))
            {
                break; /* Loop/switch isn't completed */
            }
            s3 = SVGParser.c("points", attributes);
            if (s3 != null)
            {
                s1 = new Path();
                s3 = NumberParse.a(s3);
                if (s3.size() > 1)
                {
                    a(attributes);
                    attributes = new Properties(attributes, (byte)0);
                    s1.moveTo(((Float)s3.get(0)).floatValue(), ((Float)s3.get(1)).floatValue());
                    for (int k1 = 2; k1 < s3.size(); k1 += 2)
                    {
                        s1.lineTo(((Float)s3.get(k1)).floatValue(), ((Float)s3.get(k1 + 1)).floatValue());
                    }

                    if (s2.equals("polygon"))
                    {
                        s1.close();
                    }
                    s1.computeBounds(i, false);
                    if (a(attributes, i))
                    {
                        u.drawPath(s1, e);
                        a(i, ((Paint) (null)));
                    }
                    if (a(attributes))
                    {
                        u.drawPath(s1, a);
                        a(i, a);
                    }
                    a();
                    return;
                }
            }
            if (true) goto _L4; else goto _L8
_L8:
            if (!y && s2.equals("path"))
            {
                s1 = SVGParser.c(SVGParser.a("d", attributes));
                a(attributes);
                s2 = new Properties(attributes, (byte)0);
                s1.computeBounds(i, false);
                if (a(s2, i))
                {
                    u.drawPath(s1, e);
                    a(i, ((Paint) (null)));
                }
                if (a(s2))
                {
                    u.drawPath(s1, a);
                    a(i, a);
                }
                a();
                return;
            }
            if (!y)
            {
                Log.w("SVGAndroid", (new StringBuilder("UNRECOGNIZED SVG COMMAND: ")).append(s2).toString());
                return;
            }
            if (true) goto _L4; else goto _L9
_L9:
        }

        public SVGHandler()
        {
            b = false;
            c = new Stack();
            d = new Stack();
            f = false;
            g = new Stack();
            h = new Stack();
            i = new RectF();
            j = null;
            k = new RectF((1.0F / 0.0F), (1.0F / 0.0F), (-1.0F / 0.0F), (-1.0F / 0.0F));
            l = null;
            m = null;
            n = false;
            p = new Stack();
            q = new Stack();
            r = new HashMap();
            s = null;
            y = false;
            z = 0;
            A = false;
            a = new Paint();
            a.setAntiAlias(true);
            a.setStyle(android.graphics.Paint.Style.STROKE);
            e = new Paint();
            e.setAntiAlias(true);
            e.setStyle(android.graphics.Paint.Style.FILL);
            q.push(new Matrix());
        }

        private class Gradient
        {

            String a;
            String b;
            boolean c;
            float d;
            float e;
            float f;
            float g;
            float h;
            float i;
            float j;
            ArrayList k;
            ArrayList l;
            Matrix m;
            public Shader n;
            public boolean o;
            public android.graphics.Shader.TileMode p;

            public final Gradient a(Gradient gradient)
            {
                Gradient gradient1 = new Gradient();
                gradient1.a = gradient.a;
                gradient1.b = a;
                gradient1.c = gradient.c;
                gradient1.d = gradient.d;
                gradient1.f = gradient.f;
                gradient1.e = gradient.e;
                gradient1.g = gradient.g;
                gradient1.h = gradient.h;
                gradient1.i = gradient.i;
                gradient1.j = gradient.j;
                gradient1.k = k;
                gradient1.l = l;
                gradient1.m = m;
                if (gradient.m != null)
                {
                    if (m == null)
                    {
                        gradient1.m = gradient.m;
                    } else
                    {
                        Matrix matrix = new Matrix(m);
                        matrix.preConcat(gradient.m);
                        gradient1.m = matrix;
                    }
                }
                gradient1.o = gradient.o;
                gradient1.n = gradient.n;
                gradient1.p = gradient.p;
                return gradient1;
            }

            private Gradient()
            {
                k = new ArrayList();
                l = new ArrayList();
                m = null;
                n = null;
                o = false;
            }

            Gradient(byte byte0)
            {
                this();
            }
        }


        private class Properties
        {
            private class StyleSet
            {

                HashMap a;

                private StyleSet(String s1)
                {
                    a = new HashMap();
                    s1 = s1.split(";");
                    int j1 = s1.length;
                    for (int i1 = 0; i1 < j1; i1++)
                    {
                        String as[] = s1[i1].split(":");
                        if (as.length == 2)
                        {
                            a.put(as[0], as[1]);
                        }
                    }

                }

                StyleSet(String s1, byte byte0)
                {
                    this(s1);
                }
            }


            StyleSet a;
            Attributes b;

            private static int d(String s1)
            {
                if (s1.endsWith("%"))
                {
                    return Math.round((Float.parseFloat(s1.substring(0, s1.length() - 1)) / 100F) * 255F);
                } else
                {
                    return Integer.parseInt(s1);
                }
            }

            public final Float a(String s1, float f1)
            {
                Float float1 = c(s1);
                s1 = float1;
                if (float1 == null)
                {
                    s1 = Float.valueOf(f1);
                }
                return s1;
            }

            public final String a(String s1)
            {
                String s2 = null;
                if (a != null)
                {
                    s2 = (String)a.a.get(s1);
                }
                String s3 = s2;
                if (s2 == null)
                {
                    s3 = SVGParser.a(s1, b);
                }
                return s3;
            }

            public final Integer b(String s1)
            {
                s1 = a(s1);
                if (s1 == null)
                {
                    return null;
                }
                if (!s1.startsWith("#"))
                {
                    break MISSING_BLOCK_LABEL_94;
                }
                int i1;
                int j1;
                int k1;
                try
                {
                    j1 = Integer.parseInt(s1.substring(1), 16);
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    return null;
                }
                i1 = j1;
                if (s1.length() == 4)
                {
                    i1 = j1 & 0xf | ((j1 & 0xf00) << 8 | (j1 & 0xf00) << 12 | (j1 & 0xf0) << 4 | (j1 & 0xf0) << 8 | (j1 & 0xf) << 4);
                }
                return Integer.valueOf(i1);
                if (s1.startsWith("rgb(") && s1.endsWith(")"))
                {
                    s1 = s1.substring(4, s1.length() - 1).split(",");
                    try
                    {
                        i1 = d(s1[0]);
                        j1 = d(s1[1]);
                        k1 = d(s1[2]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        return null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        return null;
                    }
                    return Integer.valueOf(k1 & 0xff | ((i1 & 0xff) << 16 | (j1 & 0xff) << 8));
                } else
                {
                    return SVGColors.a(s1);
                }
            }

            public final Float c(String s1)
            {
                s1 = a(s1);
                if (s1 == null)
                {
                    return null;
                }
                float f1;
                try
                {
                    f1 = Float.parseFloat(s1);
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    return null;
                }
                return Float.valueOf(f1);
            }

            private Properties(Attributes attributes)
            {
                a = null;
                b = attributes;
                attributes = SVGParser.a("style", attributes);
                if (attributes != null)
                {
                    a = new StyleSet(attributes, (byte)0);
                }
            }

            Properties(Attributes attributes, byte byte0)
            {
                this(attributes);
            }
        }

    }

}
