// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.a;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.e;
import com.google.android.gms.maps.model.internal.h;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.j;
import com.google.android.gms.maps.model.internal.l;
import com.google.android.gms.maps.model.internal.m;
import com.google.android.gms.maps.model.internal.n;
import com.google.android.gms.maps.model.internal.p;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IGoogleMapDelegate, b, m, d, 
//            e, ILocationSourceDelegate, f, g, 
//            h, j, k, l, 
//            n, o, p, q, 
//            v, IProjectionDelegate, IUiSettingsDelegate

class le
    implements IGoogleMapDelegate
{

    private IBinder le;

    public h addCircle(CircleOptions circleoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (circleoptions == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        circleoptions.writeToParcel(parcel, 0);
_L1:
        le.transact(35, parcel, parcel1, 0);
        parcel1.readException();
        circleoptions = com.google.android.gms.maps.model.internal.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return circleoptions;
        parcel.writeInt(0);
          goto _L1
        circleoptions;
        parcel1.recycle();
        parcel.recycle();
        throw circleoptions;
    }

    public i addGroundOverlay(GroundOverlayOptions groundoverlayoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (groundoverlayoptions == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        groundoverlayoptions.writeToParcel(parcel, 0);
_L1:
        le.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        groundoverlayoptions = com.google.android.gms.maps.model.internal.el(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return groundoverlayoptions;
        parcel.writeInt(0);
          goto _L1
        groundoverlayoptions;
        parcel1.recycle();
        parcel.recycle();
        throw groundoverlayoptions;
    }

    public i addGroundOverlay2(GroundOverlayOptions groundoverlayoptions, e e1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (groundoverlayoptions == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        groundoverlayoptions.writeToParcel(parcel, 0);
_L3:
        if (e1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        parcel.writeInt(1);
        e1.writeToParcel(parcel, 0);
_L4:
        le.transact(70, parcel, parcel1, 0);
        parcel1.readException();
        groundoverlayoptions = com.google.android.gms.maps.model.internal.el(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return groundoverlayoptions;
_L2:
        parcel.writeInt(0);
          goto _L3
        groundoverlayoptions;
        parcel1.recycle();
        parcel.recycle();
        throw groundoverlayoptions;
        parcel.writeInt(0);
          goto _L4
    }

    public l addMarker(MarkerOptions markeroptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        markeroptions.writeToParcel(parcel, 0);
_L1:
        le.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        markeroptions = com.google.android.gms.maps.model.internal.el(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return markeroptions;
        parcel.writeInt(0);
          goto _L1
        markeroptions;
        parcel1.recycle();
        parcel.recycle();
        throw markeroptions;
    }

    public l addMarker2(MarkerOptions markeroptions, p p1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (markeroptions == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        markeroptions.writeToParcel(parcel, 0);
_L3:
        if (p1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        parcel.writeInt(1);
        p1.writeToParcel(parcel, 0);
_L4:
        le.transact(68, parcel, parcel1, 0);
        parcel1.readException();
        markeroptions = com.google.android.gms.maps.model.internal.el(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return markeroptions;
_L2:
        parcel.writeInt(0);
          goto _L3
        markeroptions;
        parcel1.recycle();
        parcel.recycle();
        throw markeroptions;
        parcel.writeInt(0);
          goto _L4
    }

    public m addPolygon(PolygonOptions polygonoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (polygonoptions == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        polygonoptions.writeToParcel(parcel, 0);
_L1:
        le.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        polygonoptions = com.google.android.gms.maps.model.internal.el(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return polygonoptions;
        parcel.writeInt(0);
          goto _L1
        polygonoptions;
        parcel1.recycle();
        parcel.recycle();
        throw polygonoptions;
    }

    public IPolylineDelegate addPolyline(PolylineOptions polylineoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (polylineoptions == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        polylineoptions.writeToParcel(parcel, 0);
_L1:
        le.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        polylineoptions = com.google.android.gms.maps.model.internal.el(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return polylineoptions;
        parcel.writeInt(0);
          goto _L1
        polylineoptions;
        parcel1.recycle();
        parcel.recycle();
        throw polylineoptions;
    }

    public n addTileOverlay(TileOverlayOptions tileoverlayoptions)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (tileoverlayoptions == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        tileoverlayoptions.writeToParcel(parcel, 0);
_L1:
        le.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        tileoverlayoptions = com.google.android.gms.maps.model.internal.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return tileoverlayoptions;
        parcel.writeInt(0);
          goto _L1
        tileoverlayoptions;
        parcel1.recycle();
        parcel.recycle();
        throw tileoverlayoptions;
    }

    public void animateCamera(d d1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        le.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public void animateCamera2(c c1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        c1.writeToParcel(parcel, 0);
_L1:
        le.transact(65, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        c1;
        parcel1.recycle();
        parcel.recycle();
        throw c1;
    }

    public void animateCameraWithCallback(d d1, b b1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        d1 = obj;
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        d1 = b1.asBinder();
        parcel.writeStrongBinder(d1);
        le.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public void animateCameraWithCallback2(c c1, b b1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (c1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        c1.writeToParcel(parcel, 0);
_L3:
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        c1 = b1.asBinder();
_L4:
        parcel.writeStrongBinder(c1);
        le.transact(66, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        c1;
        parcel1.recycle();
        parcel.recycle();
        throw c1;
        c1 = null;
          goto _L4
    }

    public void animateCameraWithDurationAndCallback(d d1, int i, b b1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        parcel.writeInt(i);
        d1 = obj;
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        d1 = b1.asBinder();
        parcel.writeStrongBinder(d1);
        le.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public void animateCameraWithDurationAndCallback2(c c1, int i, b b1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (c1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        c1.writeToParcel(parcel, 0);
_L3:
        parcel.writeInt(i);
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        c1 = b1.asBinder();
_L4:
        parcel.writeStrongBinder(c1);
        le.transact(67, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        c1;
        parcel1.recycle();
        parcel.recycle();
        throw c1;
        c1 = null;
          goto _L4
    }

    public IBinder asBinder()
    {
        return le;
    }

    public void clear()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public CameraPosition getCameraPosition()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        CameraPosition cameraposition = CameraPosition.CREATOR.da(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return cameraposition;
_L2:
        cameraposition = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public j getFocusedBuilding()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        j j1;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(44, parcel, parcel1, 0);
        parcel1.readException();
        j1 = com.google.android.gms.maps.model.internal.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return j1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void getMapAsync(com.google.android.gms.maps.internal.m m1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (m1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        m1 = m1.asBinder();
_L1:
        parcel.writeStrongBinder(m1);
        le.transact(53, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        m1 = null;
          goto _L1
        m1;
        parcel1.recycle();
        parcel.recycle();
        throw m1;
    }

    public int getMapType()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public float getMaxZoomLevel()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        float f1;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        f1 = parcel1.readFloat();
        parcel1.recycle();
        parcel.recycle();
        return f1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public float getMinZoomLevel()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        float f1;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        f1 = parcel1.readFloat();
        parcel1.recycle();
        parcel.recycle();
        return f1;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Location getMyLocation()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(23, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Location location = (Location)Location.CREATOR.teFromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return location;
_L2:
        location = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public IProjectionDelegate getProjection()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        IProjectionDelegate iprojectiondelegate;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(26, parcel, parcel1, 0);
        parcel1.readException();
        iprojectiondelegate = p(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return iprojectiondelegate;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public IUiSettingsDelegate getUiSettings()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        IUiSettingsDelegate iuisettingsdelegate;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(25, parcel, parcel1, 0);
        parcel1.readException();
        iuisettingsdelegate = u(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return iuisettingsdelegate;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isBuildingsEnabled()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(40, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isIndoorEnabled()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(19, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isMyLocationEnabled()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(21, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isTrafficEnabled()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(17, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void moveCamera(d d1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        le.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public void moveCamera2(c c1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        c1.writeToParcel(parcel, 0);
_L1:
        le.transact(64, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        c1;
        parcel1.recycle();
        parcel.recycle();
        throw c1;
    }

    public void onCreate(Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        le.transact(54, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public void onDestroy()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(57, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onLowMemory()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(58, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onPause()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(56, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onResume()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(55, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        le.transact(60, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() != 0)
        {
            bundle.readFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public void setBuildingsEnabled(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        le.transact(41, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void setContentDescription(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        parcel.writeString(s);
        le.transact(61, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public boolean setIndoorEnabled(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag1;
        flag1 = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        le.transact(20, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void setInfoWindowAdapter(com.google.android.gms.maps.internal.d d1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        le.transact(33, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public void setInfoWindowRenderer(com.google.android.gms.maps.internal.e e1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (e1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        e1 = e1.asBinder();
_L1:
        parcel.writeStrongBinder(e1);
        le.transact(69, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        e1 = null;
          goto _L1
        e1;
        parcel1.recycle();
        parcel.recycle();
        throw e1;
    }

    public void setLocationSource(ILocationSourceDelegate ilocationsourcedelegate)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (ilocationsourcedelegate == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ilocationsourcedelegate = ilocationsourcedelegate.asBinder();
_L1:
        parcel.writeStrongBinder(ilocationsourcedelegate);
        le.transact(24, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ilocationsourcedelegate = null;
          goto _L1
        ilocationsourcedelegate;
        parcel1.recycle();
        parcel.recycle();
        throw ilocationsourcedelegate;
    }

    public void setMapType(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        parcel.writeInt(i);
        le.transact(16, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void setMyLocationEnabled(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        le.transact(22, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void setOnCameraChangeListener(f f1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        f1 = f1.asBinder();
_L1:
        parcel.writeStrongBinder(f1);
        le.transact(27, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        f1 = null;
          goto _L1
        f1;
        parcel1.recycle();
        parcel.recycle();
        throw f1;
    }

    public void setOnIndoorStateChangeListener(g g1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (g1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        g1 = g1.asBinder();
_L1:
        parcel.writeStrongBinder(g1);
        le.transact(45, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        g1 = null;
          goto _L1
        g1;
        parcel1.recycle();
        parcel.recycle();
        throw g1;
    }

    public void setOnInfoWindowClickListener(com.google.android.gms.maps.internal.h h1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (h1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        h1 = h1.asBinder();
_L1:
        parcel.writeStrongBinder(h1);
        le.transact(32, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        h1 = null;
          goto _L1
        h1;
        parcel1.recycle();
        parcel.recycle();
        throw h1;
    }

    public void setOnMapClickListener(com.google.android.gms.maps.internal.j j1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (j1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        j1 = j1.asBinder();
_L1:
        parcel.writeStrongBinder(j1);
        le.transact(28, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        j1 = null;
          goto _L1
        j1;
        parcel1.recycle();
        parcel.recycle();
        throw j1;
    }

    public void setOnMapLoadedCallback(k k1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        k1 = k1.asBinder();
_L1:
        parcel.writeStrongBinder(k1);
        le.transact(42, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        k1 = null;
          goto _L1
        k1;
        parcel1.recycle();
        parcel.recycle();
        throw k1;
    }

    public void setOnMapLongClickListener(com.google.android.gms.maps.internal.l l1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (l1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        l1 = l1.asBinder();
_L1:
        parcel.writeStrongBinder(l1);
        le.transact(29, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        l1 = null;
          goto _L1
        l1;
        parcel1.recycle();
        parcel.recycle();
        throw l1;
    }

    public void setOnMarkerClickListener(com.google.android.gms.maps.internal.n n1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (n1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        n1 = n1.asBinder();
_L1:
        parcel.writeStrongBinder(n1);
        le.transact(30, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        n1 = null;
          goto _L1
        n1;
        parcel1.recycle();
        parcel.recycle();
        throw n1;
    }

    public void setOnMarkerDragListener(o o1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (o1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        o1 = o1.asBinder();
_L1:
        parcel.writeStrongBinder(o1);
        le.transact(31, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        o1 = null;
          goto _L1
        o1;
        parcel1.recycle();
        parcel.recycle();
        throw o1;
    }

    public void setOnMyLocationButtonClickListener(com.google.android.gms.maps.internal.p p1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (p1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        p1 = p1.asBinder();
_L1:
        parcel.writeStrongBinder(p1);
        le.transact(37, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        p1 = null;
          goto _L1
        p1;
        parcel1.recycle();
        parcel.recycle();
        throw p1;
    }

    public void setOnMyLocationChangeListener(q q1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (q1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        q1 = q1.asBinder();
_L1:
        parcel.writeStrongBinder(q1);
        le.transact(36, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        q1 = null;
          goto _L1
        q1;
        parcel1.recycle();
        parcel.recycle();
        throw q1;
    }

    public void setPadding(int i, int i1, int j1, int k1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        parcel.writeInt(i);
        parcel.writeInt(i1);
        parcel.writeInt(j1);
        parcel.writeInt(k1);
        le.transact(39, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void setTrafficEnabled(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        le.transact(18, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void snapshot(v v1, d d1)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (v1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        v1 = v1.asBinder();
_L1:
        parcel.writeStrongBinder(v1);
        v1 = obj;
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        v1 = d1.asBinder();
        parcel.writeStrongBinder(v1);
        le.transact(38, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        v1 = null;
          goto _L1
        v1;
        parcel1.recycle();
        parcel.recycle();
        throw v1;
    }

    public void stopAnimation()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean useViewLifecycleWhenInFragment()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        le.transact(59, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        le = ibinder;
    }
}
