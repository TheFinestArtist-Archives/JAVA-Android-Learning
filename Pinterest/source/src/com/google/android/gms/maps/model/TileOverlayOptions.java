// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.internal.o;

// Referenced classes of package com.google.android.gms.maps.model:
//            w, x, TileProvider

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final w CREATOR = new w();
    private final int CK;
    private float alX;
    private boolean alY;
    private o amD;
    private TileProvider amE;
    private boolean amF;

    public TileOverlayOptions()
    {
        alY = true;
        amF = true;
        CK = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        alY = true;
        amF = true;
        CK = i;
        amD = com.google.android.gms.maps.model.internal.o.a.bE(ibinder);
        if (amD == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new _cls1();
        }
        amE = ibinder;
        alY = flag;
        alX = f;
        amF = flag1;
    }

    static o a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.amD;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final TileOverlayOptions fadeIn(boolean flag)
    {
        amF = flag;
        return this;
    }

    public final boolean getFadeIn()
    {
        return amF;
    }

    public final TileProvider getTileProvider()
    {
        return amE;
    }

    final int getVersionCode()
    {
        return CK;
    }

    public final float getZIndex()
    {
        return alX;
    }

    public final boolean isVisible()
    {
        return alY;
    }

    final IBinder og()
    {
        return amD.asBinder();
    }

    public final TileOverlayOptions tileProvider(TileProvider tileprovider)
    {
        amE = tileprovider;
        if (amE == null)
        {
            tileprovider = null;
        } else
        {
            tileprovider = new _cls2(tileprovider);
        }
        amD = tileprovider;
        return this;
    }

    public final TileOverlayOptions visible(boolean flag)
    {
        alY = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (aa.ob())
        {
            x.a(this, parcel, i);
            return;
        } else
        {
            w.a(this, parcel, i);
            return;
        }
    }

    public final TileOverlayOptions zIndex(float f)
    {
        alX = f;
        return this;
    }


    private class _cls1
        implements TileProvider
    {

        private final o amG;
        final TileOverlayOptions amH;

        public Tile getTile(int i, int j, int k)
        {
            Tile tile;
            try
            {
                tile = amG.getTile(i, j, k);
            }
            catch (RemoteException remoteexception)
            {
                return null;
            }
            return tile;
        }

        _cls1()
        {
            amH = TileOverlayOptions.this;
            super();
            amG = TileOverlayOptions.a(amH);
        }
    }


    private class _cls2 extends com.google.android.gms.maps.model.internal.o.a
    {

        final TileOverlayOptions amH;
        final TileProvider amI;

        public Tile getTile(int i, int j, int k)
        {
            return amI.getTile(i, j, k);
        }

        _cls2(TileProvider tileprovider)
        {
            amH = TileOverlayOptions.this;
            amI = tileprovider;
            super();
        }
    }

}
