// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
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
//            b, m, IProjectionDelegate, IUiSettingsDelegate, 
//            d, e, ILocationSourceDelegate, f, 
//            g, h, j, k, 
//            l, n, o, p, 
//            q, v

public interface IGoogleMapDelegate
    extends IInterface
{

    public abstract h addCircle(CircleOptions circleoptions);

    public abstract i addGroundOverlay(GroundOverlayOptions groundoverlayoptions);

    public abstract i addGroundOverlay2(GroundOverlayOptions groundoverlayoptions, e e);

    public abstract l addMarker(MarkerOptions markeroptions);

    public abstract l addMarker2(MarkerOptions markeroptions, p p);

    public abstract m addPolygon(PolygonOptions polygonoptions);

    public abstract IPolylineDelegate addPolyline(PolylineOptions polylineoptions);

    public abstract n addTileOverlay(TileOverlayOptions tileoverlayoptions);

    public abstract void animateCamera(d d);

    public abstract void animateCamera2(c c);

    public abstract void animateCameraWithCallback(d d, b b);

    public abstract void animateCameraWithCallback2(c c, b b);

    public abstract void animateCameraWithDurationAndCallback(d d, int i, b b);

    public abstract void animateCameraWithDurationAndCallback2(c c, int i, b b);

    public abstract void clear();

    public abstract CameraPosition getCameraPosition();

    public abstract j getFocusedBuilding();

    public abstract void getMapAsync(com.google.android.gms.maps.internal.m m);

    public abstract int getMapType();

    public abstract float getMaxZoomLevel();

    public abstract float getMinZoomLevel();

    public abstract Location getMyLocation();

    public abstract IProjectionDelegate getProjection();

    public abstract IUiSettingsDelegate getUiSettings();

    public abstract boolean isBuildingsEnabled();

    public abstract boolean isIndoorEnabled();

    public abstract boolean isMyLocationEnabled();

    public abstract boolean isTrafficEnabled();

    public abstract void moveCamera(d d);

    public abstract void moveCamera2(c c);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onLowMemory();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void setBuildingsEnabled(boolean flag);

    public abstract void setContentDescription(String s);

    public abstract boolean setIndoorEnabled(boolean flag);

    public abstract void setInfoWindowAdapter(com.google.android.gms.maps.internal.d d);

    public abstract void setInfoWindowRenderer(com.google.android.gms.maps.internal.e e);

    public abstract void setLocationSource(ILocationSourceDelegate ilocationsourcedelegate);

    public abstract void setMapType(int i);

    public abstract void setMyLocationEnabled(boolean flag);

    public abstract void setOnCameraChangeListener(f f);

    public abstract void setOnIndoorStateChangeListener(g g);

    public abstract void setOnInfoWindowClickListener(com.google.android.gms.maps.internal.h h);

    public abstract void setOnMapClickListener(com.google.android.gms.maps.internal.j j);

    public abstract void setOnMapLoadedCallback(k k);

    public abstract void setOnMapLongClickListener(com.google.android.gms.maps.internal.l l);

    public abstract void setOnMarkerClickListener(com.google.android.gms.maps.internal.n n);

    public abstract void setOnMarkerDragListener(o o);

    public abstract void setOnMyLocationButtonClickListener(com.google.android.gms.maps.internal.p p);

    public abstract void setOnMyLocationChangeListener(q q);

    public abstract void setPadding(int i, int j, int k, int l);

    public abstract void setTrafficEnabled(boolean flag);

    public abstract void snapshot(v v, d d);

    public abstract void stopAnimation();

    public abstract boolean useViewLifecycleWhenInFragment();
}
