// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.InputSource;

// Referenced classes of package com.larvalabs.svgandroid:
//            SVGParser, SVG

public class SVGBuilder
{

    private InputStream a;
    private Integer b;
    private Integer c;
    private ColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;

    public SVGBuilder()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = false;
        g = true;
    }

    public final SVG a()
    {
        if (a == null)
        {
            throw new IllegalStateException("SVG input not specified. Call one of the readFrom...() methods first.");
        }
        Object obj;
        obj = new SVGParser.SVGHandler();
        Integer integer = b;
        Integer integer1 = c;
        obj.l = integer;
        obj.m = integer1;
        obj.n = f;
        if (d != null)
        {
            ((SVGParser.SVGHandler) (obj)).a.setColorFilter(d);
        }
        if (e != null)
        {
            ((SVGParser.SVGHandler) (obj)).e.setColorFilter(e);
        }
        obj = SVGParser.a(new InputSource(a), ((SVGParser.SVGHandler) (obj)));
        if (g)
        {
            try
            {
                a.close();
            }
            catch (IOException ioexception)
            {
                Log.e("SVGAndroid", "Error closing SVG input stream.", ioexception);
                return ((SVG) (obj));
            }
        }
        return ((SVG) (obj));
        Exception exception;
        exception;
        if (g)
        {
            try
            {
                a.close();
            }
            catch (IOException ioexception1)
            {
                Log.e("SVGAndroid", "Error closing SVG input stream.", ioexception1);
            }
        }
        throw exception;
    }

    public final SVGBuilder a(Resources resources, int i)
    {
        a = resources.openRawResource(i);
        return this;
    }
}
