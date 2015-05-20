// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.FloatMath;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package com.larvalabs.svgandroid:
//            SVGParser

class q extends DefaultHandler
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
    y s;
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

    private static q a(boolean flag, Attributes attributes)
    {
        q q1 = new nit>((byte)0);
        q1.nit> = SVGParser.a("id", attributes);
        q1.nit> = flag;
        Object obj;
        String s1;
        if (flag)
        {
            q1.nit> = SVGParser.a("x1", attributes, Float.valueOf(0.0F)).floatValue();
            q1.nit> = SVGParser.a("x2", attributes, Float.valueOf(1.0F)).floatValue();
            q1.nit> = SVGParser.a("y1", attributes, Float.valueOf(0.0F)).floatValue();
            q1.nit> = SVGParser.a("y2", attributes, Float.valueOf(0.0F)).floatValue();
        } else
        {
            q1.nit> = SVGParser.a("cx", attributes, Float.valueOf(0.0F)).floatValue();
            q1.nit> = SVGParser.a("cy", attributes, Float.valueOf(0.0F)).floatValue();
            q1.nit> = SVGParser.a("r", attributes, Float.valueOf(0.0F)).floatValue();
        }
        obj = SVGParser.a("gradientTransform", attributes);
        if (obj != null)
        {
            q1.nit> = SVGParser.a(((String) (obj)));
        }
        s1 = SVGParser.a("spreadMethod", attributes);
        obj = s1;
        if (s1 == null)
        {
            obj = "pad";
        }
        if (((String) (obj)).equals("reflect"))
        {
            obj = android.graphics.R;
        } else
        if (((String) (obj)).equals("repeat"))
        {
            obj = android.graphics.T;
        } else
        {
            obj = android.graphics.;
        }
        q1.nit> = ((android.graphics.dient.p) (obj));
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
        q1.nit> = flag;
        obj = SVGParser.a("href", attributes);
        if (obj != null)
        {
            attributes = ((Attributes) (obj));
            if (((String) (obj)).startsWith("#"))
            {
                attributes = ((String) (obj)).substring(1);
            }
            q1.nit> = attributes;
        }
        return q1;
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

    private void a(B b1, Integer integer, boolean flag, Paint paint)
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
        Float float1 = b1.c("opacity");
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
            integer = b1.c(integer);
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

    private boolean a(q q1)
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
        } while (n || "none".equals(q1.a("display")));
        obj = q1.c("stroke-width");
        if (obj != null)
        {
            a.setStrokeWidth(((Float) (obj)).floatValue());
        }
        obj = q1.a("stroke-linecap");
        if ("round".equals(obj))
        {
            a.setStrokeCap(android.graphics.Handler.a);
        } else
        if ("square".equals(obj))
        {
            a.setStrokeCap(android.graphics.Handler.a);
        } else
        if ("butt".equals(obj))
        {
            a.setStrokeCap(android.graphics.Handler.a);
        }
        obj = q1.a("stroke-linejoin");
        if ("miter".equals(obj))
        {
            a.setStrokeJoin(android.graphics.Handler.a);
        } else
        if ("round".equals(obj))
        {
            a.setStrokeJoin(android.graphics.Handler.a);
        } else
        if ("bevel".equals(obj))
        {
            a.setStrokeJoin(android.graphics.Handler.a);
        }
        obj1 = q1.a("stroke-dasharray");
        obj = q1.a("stroke-dashoffset");
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (!((String) (obj1)).equals("none")) goto _L4; else goto _L3
_L3:
        a.setPathEffect(null);
_L2:
        obj = q1.a("stroke");
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
        af = q1.b("stroke");
        if (af != null)
        {
            a(q1, ((Integer) (af)), false, a);
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

    private boolean a(a a1, RectF rectf)
    {
        if (!"none".equals(a1.a("display")))
        {
            if (n)
            {
                e.setShader(null);
                e.setColor(-1);
                return true;
            }
            Object obj = a1.a("fill");
            if (obj != null)
            {
                if (((String) (obj)).startsWith("url(#"))
                {
                    String s1 = ((String) (obj)).substring(5, ((String) (obj)).length() - 1);
                    a a2 = (a)r.get(s1);
                    if (a2 != null)
                    {
                        obj = a2.r;
                    } else
                    {
                        obj = null;
                    }
                    if (obj != null)
                    {
                        e.setShader(((Shader) (obj)));
                        x.set(a2.x);
                        if (a2.x && rectf != null)
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
                        a(a1, Integer.valueOf(0xff000000), true, e);
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
                rectf = a1.b("fill");
                if (rectf != null)
                {
                    a(a1, ((Integer) (rectf)), true, e);
                    return true;
                } else
                {
                    Log.w("SVGAndroid", (new StringBuilder("Unrecognized fill color, using black: ")).append(((String) (obj))).toString());
                    a(a1, Integer.valueOf(0xff000000), true, e);
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
        if (s.s == null) goto _L4; else goto _L3
_L3:
        if (s.s != null)
        {
            s1 = (s)r.get(s.s);
            if (s1 != null)
            {
                s = s1.s(s);
            }
        }
        s1 = new int[s.s.size()];
        for (int i1 = 0; i1 < s1.length; i1++)
        {
            s1[i1] = ((Integer)s.s.get(i1)).intValue();
        }

        s3 = new float[s.s.size()];
        for (int j1 = ((flag) ? 1 : 0); j1 < s3.length; j1++)
        {
            s3[j1] = ((Float)s.s.get(j1)).floatValue();
        }

        if (s1.length == 0)
        {
            Log.d("BAD", "BAD");
        }
        if (s2.equals("linearGradient"))
        {
            s.s = new LinearGradient(s.s, s.s, s.s, s.s, s1, s3, s.s);
        } else
        {
            s.s = new RadialGradient(s.s, s.s, s.s, s1, s3, s.s);
        }
        r.put(s.s, s);
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
            s1 = new <init>(attributes, (byte)0);
            float f2 = s1.a("offset", 0.0F).floatValue();
            int j1 = s1.b("stop-color").intValue();
            int i2 = Math.round(s1.a("stop-opacity", 1.0F).floatValue() * 255F);
            s.s.add(Float.valueOf(f2));
            s.s.add(Integer.valueOf(i2 << 24 | j1));
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
            s1 = new <init>(attributes, (byte)0);
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
            attributes = new <init>(attributes, (byte)0);
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
        if (a(new <init>(attributes, (byte)0)))
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
            attributes = new <init>(attributes, (byte)0);
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
            s3 = .a(s3);
            if (s3.size() > 1)
            {
                a(attributes);
                attributes = new <init>(attributes, (byte)0);
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
            s2 = new <init>(attributes, (byte)0);
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

    public ()
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
        a.setStyle(android.graphics.Handler.a);
        e = new Paint();
        e.setAntiAlias(true);
        e.setStyle(android.graphics.Handler.e);
        q.push(new Matrix());
    }
}
