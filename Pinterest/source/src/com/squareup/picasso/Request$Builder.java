// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.squareup.picasso:
//            Transformation, Request

public final class b
{

    private Uri a;
    private int b;
    private String c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private List l;
    private android.graphics.rity m;
    private  n;

    public final b a(int i1, int j1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException("Width must be positive number or 0.");
        }
        if (j1 < 0)
        {
            throw new IllegalArgumentException("Height must be positive number or 0.");
        }
        if (j1 == 0 && i1 == 0)
        {
            throw new IllegalArgumentException("At least one dimension has to be positive number.");
        } else
        {
            d = i1;
            e = j1;
            return this;
        }
    }

    public final  a( )
    {
        if ( == null)
        {
            throw new IllegalArgumentException("Priority invalid.");
        }
        if (n != null)
        {
            throw new IllegalStateException("Priority already set.");
        } else
        {
            n = ;
            return this;
        }
    }

    public final n a(Transformation transformation)
    {
        if (transformation == null)
        {
            throw new IllegalArgumentException("Transformation must not be null.");
        }
        if (transformation.key() == null)
        {
            throw new IllegalArgumentException("Transformation key must not be null.");
        }
        if (l == null)
        {
            l = new ArrayList(2);
        }
        l.add(transformation);
        return this;
    }

    final boolean a()
    {
        return a != null || b != 0;
    }

    final boolean b()
    {
        return d != 0 || e != 0;
    }

    final boolean c()
    {
        return n != null;
    }

    public final n d()
    {
        if (g)
        {
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        } else
        {
            f = true;
            return this;
        }
    }

    public final Request e()
    {
        if (g && f)
        {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        }
        if (f && (d == 0 || e == 0))
        {
            throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
        }
        if (g && (d == 0 || e == 0))
        {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        }
        if (n == null)
        {
            n = .b;
        }
        return new Request(a, b, c, l, d, e, f, g, h, i, j, k, m, n, (byte)0);
    }

    public (Uri uri)
    {
        if (uri == null)
        {
            throw new IllegalArgumentException("Image URI may not be null.");
        } else
        {
            a = uri;
            b = 0;
            return;
        }
    }

    b(Uri uri, byte byte0)
    {
        a = uri;
        b = 0;
    }
}
