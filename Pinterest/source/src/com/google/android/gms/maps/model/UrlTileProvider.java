// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileProvider, Tile

public abstract class UrlTileProvider
    implements TileProvider
{

    private final int li;
    private final int lj;

    public UrlTileProvider(int i, int j)
    {
        li = i;
        lj = j;
    }

    private static long a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[4096];
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while (true);
    }

    private static byte[] e(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        a(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public final Tile getTile(int i, int j, int k)
    {
        Object obj = getTileUrl(i, j, k);
        if (obj == null)
        {
            return NO_TILE;
        }
        try
        {
            obj = new Tile(li, lj, e(((URL) (obj)).openStream()));
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return ((Tile) (obj));
    }

    public abstract URL getTileUrl(int i, int j, int k);
}
