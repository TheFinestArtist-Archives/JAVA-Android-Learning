// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;

// Referenced classes of package com.google.android.gms.maps:
//            CameraUpdate, Projection, UiSettings, LocationSource

public final class GoogleMap
{

    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate akm;
    private UiSettings akn;

    protected GoogleMap(IGoogleMapDelegate igooglemapdelegate)
    {
        akm = (IGoogleMapDelegate)jx.i(igooglemapdelegate);
    }

    public final Circle addCircle(CircleOptions circleoptions)
    {
        try
        {
            circleoptions = new Circle(akm.addCircle(circleoptions));
        }
        // Misplaced declaration of an exception variable
        catch (CircleOptions circleoptions)
        {
            throw new RuntimeRemoteException(circleoptions);
        }
        return circleoptions;
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundoverlayoptions)
    {
        try
        {
            groundoverlayoptions = akm.addGroundOverlay(groundoverlayoptions);
        }
        // Misplaced declaration of an exception variable
        catch (GroundOverlayOptions groundoverlayoptions)
        {
            throw new RuntimeRemoteException(groundoverlayoptions);
        }
        if (groundoverlayoptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        groundoverlayoptions = new GroundOverlay(groundoverlayoptions);
        return groundoverlayoptions;
        return null;
    }

    public final Marker addMarker(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = akm.addMarker(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new RuntimeRemoteException(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new Marker(markeroptions);
        return markeroptions;
        return null;
    }

    public final Polygon addPolygon(PolygonOptions polygonoptions)
    {
        try
        {
            polygonoptions = new Polygon(akm.addPolygon(polygonoptions));
        }
        // Misplaced declaration of an exception variable
        catch (PolygonOptions polygonoptions)
        {
            throw new RuntimeRemoteException(polygonoptions);
        }
        return polygonoptions;
    }

    public final Polyline addPolyline(PolylineOptions polylineoptions)
    {
        try
        {
            polylineoptions = new Polyline(akm.addPolyline(polylineoptions));
        }
        // Misplaced declaration of an exception variable
        catch (PolylineOptions polylineoptions)
        {
            throw new RuntimeRemoteException(polylineoptions);
        }
        return polylineoptions;
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileoverlayoptions)
    {
        try
        {
            tileoverlayoptions = akm.addTileOverlay(tileoverlayoptions);
        }
        // Misplaced declaration of an exception variable
        catch (TileOverlayOptions tileoverlayoptions)
        {
            throw new RuntimeRemoteException(tileoverlayoptions);
        }
        if (tileoverlayoptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        tileoverlayoptions = new TileOverlay(tileoverlayoptions);
        return tileoverlayoptions;
        return null;
    }

    public final void animateCamera(CameraUpdate cameraupdate)
    {
        try
        {
            akm.animateCamera(cameraupdate.nA());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
    }

    public final void animateCamera(CameraUpdate cameraupdate, int i, CancelableCallback cancelablecallback)
    {
        IGoogleMapDelegate igooglemapdelegate;
        com.google.android.gms.dynamic.d d;
        try
        {
            igooglemapdelegate = akm;
            d = cameraupdate.nA();
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
        if (cancelablecallback != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        cameraupdate = null;
        igooglemapdelegate.animateCameraWithDurationAndCallback(d, i, cameraupdate);
        return;
        cameraupdate = new a(cancelablecallback);
        break MISSING_BLOCK_LABEL_18;
    }

    public final void animateCamera(CameraUpdate cameraupdate, CancelableCallback cancelablecallback)
    {
        IGoogleMapDelegate igooglemapdelegate;
        com.google.android.gms.dynamic.d d;
        try
        {
            igooglemapdelegate = akm;
            d = cameraupdate.nA();
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
        if (cancelablecallback != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        cameraupdate = null;
        igooglemapdelegate.animateCameraWithCallback(d, cameraupdate);
        return;
        cameraupdate = new a(cancelablecallback);
        break MISSING_BLOCK_LABEL_17;
    }

    public final void clear()
    {
        try
        {
            akm.clear();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final CameraPosition getCameraPosition()
    {
        CameraPosition cameraposition;
        try
        {
            cameraposition = akm.getCameraPosition();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return cameraposition;
    }

    public final IndoorBuilding getFocusedBuilding()
    {
        Object obj;
        try
        {
            obj = akm.getFocusedBuilding();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        obj = new IndoorBuilding(((com.google.android.gms.maps.model.internal.j) (obj)));
        return ((IndoorBuilding) (obj));
        return null;
    }

    public final int getMapType()
    {
        int i;
        try
        {
            i = akm.getMapType();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final float getMaxZoomLevel()
    {
        float f;
        try
        {
            f = akm.getMaxZoomLevel();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final float getMinZoomLevel()
    {
        float f;
        try
        {
            f = akm.getMinZoomLevel();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final Location getMyLocation()
    {
        Location location;
        try
        {
            location = akm.getMyLocation();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return location;
    }

    public final Projection getProjection()
    {
        Projection projection;
        try
        {
            projection = new Projection(akm.getProjection());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return projection;
    }

    public final UiSettings getUiSettings()
    {
        UiSettings uisettings;
        try
        {
            if (akn == null)
            {
                akn = new UiSettings(akm.getUiSettings());
            }
            uisettings = akn;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return uisettings;
    }

    public final boolean isBuildingsEnabled()
    {
        boolean flag;
        try
        {
            flag = akm.isBuildingsEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isIndoorEnabled()
    {
        boolean flag;
        try
        {
            flag = akm.isIndoorEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isMyLocationEnabled()
    {
        boolean flag;
        try
        {
            flag = akm.isMyLocationEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isTrafficEnabled()
    {
        boolean flag;
        try
        {
            flag = akm.isTrafficEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final void moveCamera(CameraUpdate cameraupdate)
    {
        try
        {
            akm.moveCamera(cameraupdate.nA());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
    }

    final IGoogleMapDelegate nC()
    {
        return akm;
    }

    public final void setBuildingsEnabled(boolean flag)
    {
        try
        {
            akm.setBuildingsEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setContentDescription(String s)
    {
        try
        {
            akm.setContentDescription(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeRemoteException(s);
        }
    }

    public final boolean setIndoorEnabled(boolean flag)
    {
        try
        {
            flag = akm.setIndoorEnabled(flag);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infowindowadapter)
    {
        if (infowindowadapter == null)
        {
            try
            {
                akm.setInfoWindowAdapter(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InfoWindowAdapter infowindowadapter)
            {
                throw new RuntimeRemoteException(infowindowadapter);
            }
        }
        akm.setInfoWindowAdapter(new _cls13(infowindowadapter));
        return;
    }

    public final void setLocationSource(LocationSource locationsource)
    {
        if (locationsource == null)
        {
            try
            {
                akm.setLocationSource(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LocationSource locationsource)
            {
                throw new RuntimeRemoteException(locationsource);
            }
        }
        akm.setLocationSource(new _cls6(locationsource));
        return;
    }

    public final void setMapType(int i)
    {
        try
        {
            akm.setMapType(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setMyLocationEnabled(boolean flag)
    {
        try
        {
            akm.setMyLocationEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener oncamerachangelistener)
    {
        if (oncamerachangelistener == null)
        {
            try
            {
                akm.setOnCameraChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnCameraChangeListener oncamerachangelistener)
            {
                throw new RuntimeRemoteException(oncamerachangelistener);
            }
        }
        akm.setOnCameraChangeListener(new _cls7(oncamerachangelistener));
        return;
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onindoorstatechangelistener)
    {
        if (onindoorstatechangelistener == null)
        {
            try
            {
                akm.setOnIndoorStateChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnIndoorStateChangeListener onindoorstatechangelistener)
            {
                throw new RuntimeRemoteException(onindoorstatechangelistener);
            }
        }
        akm.setOnIndoorStateChangeListener(new _cls1(onindoorstatechangelistener));
        return;
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener oninfowindowclicklistener)
    {
        if (oninfowindowclicklistener == null)
        {
            try
            {
                akm.setOnInfoWindowClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnInfoWindowClickListener oninfowindowclicklistener)
            {
                throw new RuntimeRemoteException(oninfowindowclicklistener);
            }
        }
        akm.setOnInfoWindowClickListener(new _cls12(oninfowindowclicklistener));
        return;
    }

    public final void setOnMapClickListener(OnMapClickListener onmapclicklistener)
    {
        if (onmapclicklistener == null)
        {
            try
            {
                akm.setOnMapClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapClickListener onmapclicklistener)
            {
                throw new RuntimeRemoteException(onmapclicklistener);
            }
        }
        akm.setOnMapClickListener(new _cls8(onmapclicklistener));
        return;
    }

    public final void setOnMapLoadedCallback(OnMapLoadedCallback onmaploadedcallback)
    {
        if (onmaploadedcallback == null)
        {
            try
            {
                akm.setOnMapLoadedCallback(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapLoadedCallback onmaploadedcallback)
            {
                throw new RuntimeRemoteException(onmaploadedcallback);
            }
        }
        akm.setOnMapLoadedCallback(new _cls4(onmaploadedcallback));
        return;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onmaplongclicklistener)
    {
        if (onmaplongclicklistener == null)
        {
            try
            {
                akm.setOnMapLongClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapLongClickListener onmaplongclicklistener)
            {
                throw new RuntimeRemoteException(onmaplongclicklistener);
            }
        }
        akm.setOnMapLongClickListener(new _cls9(onmaplongclicklistener));
        return;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        if (onmarkerclicklistener == null)
        {
            try
            {
                akm.setOnMarkerClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMarkerClickListener onmarkerclicklistener)
            {
                throw new RuntimeRemoteException(onmarkerclicklistener);
            }
        }
        akm.setOnMarkerClickListener(new _cls10(onmarkerclicklistener));
        return;
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onmarkerdraglistener)
    {
        if (onmarkerdraglistener == null)
        {
            try
            {
                akm.setOnMarkerDragListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMarkerDragListener onmarkerdraglistener)
            {
                throw new RuntimeRemoteException(onmarkerdraglistener);
            }
        }
        akm.setOnMarkerDragListener(new _cls11(onmarkerdraglistener));
        return;
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
    {
        if (onmylocationbuttonclicklistener == null)
        {
            try
            {
                akm.setOnMyLocationButtonClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
            {
                throw new RuntimeRemoteException(onmylocationbuttonclicklistener);
            }
        }
        akm.setOnMyLocationButtonClickListener(new _cls3(onmylocationbuttonclicklistener));
        return;
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onmylocationchangelistener)
    {
        if (onmylocationchangelistener == null)
        {
            try
            {
                akm.setOnMyLocationChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMyLocationChangeListener onmylocationchangelistener)
            {
                throw new RuntimeRemoteException(onmylocationchangelistener);
            }
        }
        akm.setOnMyLocationChangeListener(new _cls2(onmylocationchangelistener));
        return;
    }

    public final void setPadding(int i, int j, int k, int l)
    {
        try
        {
            akm.setPadding(i, j, k, l);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setTrafficEnabled(boolean flag)
    {
        try
        {
            akm.setTrafficEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotreadycallback)
    {
        snapshot(snapshotreadycallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotreadycallback, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            bitmap = e.k(bitmap);
        } else
        {
            bitmap = null;
        }
        bitmap = (e)bitmap;
        try
        {
            akm.snapshot(new _cls5(snapshotreadycallback), bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SnapshotReadyCallback snapshotreadycallback)
        {
            throw new RuntimeRemoteException(snapshotreadycallback);
        }
    }

    public final void stopAnimation()
    {
        try
        {
            akm.stopAnimation();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    private class a extends com.google.android.gms.maps.internal.b.a
    {

        private final CancelableCallback akE;

        public final void onCancel()
        {
            akE.onCancel();
        }

        public final void onFinish()
        {
            akE.onFinish();
        }

        a(CancelableCallback cancelablecallback)
        {
            akE = cancelablecallback;
        }

        private class CancelableCallback
        {

            public abstract void onCancel();

            public abstract void onFinish();
        }

    }


    private class _cls13 extends com.google.android.gms.maps.internal.d.a
    {

        final InfoWindowAdapter akD;
        final GoogleMap akp;

        public d f(l l)
        {
            return e.k(akD.getInfoWindow(new Marker(l)));
        }

        public d g(l l)
        {
            return e.k(akD.getInfoContents(new Marker(l)));
        }

        _cls13(InfoWindowAdapter infowindowadapter)
        {
            akp = GoogleMap.this;
            akD = infowindowadapter;
            super();
        }

        private class InfoWindowAdapter
        {

            public abstract View getInfoContents(Marker marker);

            public abstract View getInfoWindow(Marker marker);
        }

    }


    private class _cls6 extends com.google.android.gms.maps.internal.ILocationSourceDelegate.a
    {

        final GoogleMap akp;
        final LocationSource aku;

        public void activate(i i)
        {
            class _cls1
                implements LocationSource.OnLocationChangedListener
            {

                final i akv;
                final _cls6 akw;

                public void onLocationChanged(Location location)
                {
                    try
                    {
                        akv.d(location);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Location location)
                    {
                        throw new RuntimeRemoteException(location);
                    }
                }

                _cls1(i j)
                {
                    akw = _cls6.this;
                    akv = j;
                    super();
                }
            }

            aku.activate(new _cls1(i));
        }

        public void deactivate()
        {
            aku.deactivate();
        }

        _cls6(LocationSource locationsource)
        {
            akp = GoogleMap.this;
            aku = locationsource;
            super();
        }
    }


    private class _cls7 extends com.google.android.gms.maps.internal.f.a
    {

        final GoogleMap akp;
        final OnCameraChangeListener akx;

        public void onCameraChange(CameraPosition cameraposition)
        {
            akx.onCameraChange(cameraposition);
        }

        _cls7(OnCameraChangeListener oncamerachangelistener)
        {
            akp = GoogleMap.this;
            akx = oncamerachangelistener;
            super();
        }

        private class OnCameraChangeListener
        {

            public abstract void onCameraChange(CameraPosition cameraposition);
        }

    }


    private class _cls1 extends com.google.android.gms.maps.internal.g.a
    {

        final OnIndoorStateChangeListener ako;
        final GoogleMap akp;

        public void a(j j)
        {
            ako.onIndoorLevelActivated(new IndoorBuilding(j));
        }

        public void onIndoorBuildingFocused()
        {
            ako.onIndoorBuildingFocused();
        }

        _cls1(OnIndoorStateChangeListener onindoorstatechangelistener)
        {
            akp = GoogleMap.this;
            ako = onindoorstatechangelistener;
            super();
        }

        private class OnIndoorStateChangeListener
        {

            public abstract void onIndoorBuildingFocused();

            public abstract void onIndoorLevelActivated(IndoorBuilding indoorbuilding);
        }

    }


    private class _cls12 extends com.google.android.gms.maps.internal.h.a
    {

        final OnInfoWindowClickListener akC;
        final GoogleMap akp;

        public void e(l l)
        {
            akC.onInfoWindowClick(new Marker(l));
        }

        _cls12(OnInfoWindowClickListener oninfowindowclicklistener)
        {
            akp = GoogleMap.this;
            akC = oninfowindowclicklistener;
            super();
        }

        private class OnInfoWindowClickListener
        {

            public abstract void onInfoWindowClick(Marker marker);
        }

    }


    private class _cls8 extends com.google.android.gms.maps.internal.j.a
    {

        final GoogleMap akp;
        final OnMapClickListener aky;

        public void onMapClick(LatLng latlng)
        {
            aky.onMapClick(latlng);
        }

        _cls8(OnMapClickListener onmapclicklistener)
        {
            akp = GoogleMap.this;
            aky = onmapclicklistener;
            super();
        }

        private class OnMapClickListener
        {

            public abstract void onMapClick(LatLng latlng);
        }

    }


    private class _cls4 extends com.google.android.gms.maps.internal.k.a
    {

        final GoogleMap akp;
        final OnMapLoadedCallback aks;

        public void onMapLoaded()
        {
            aks.onMapLoaded();
        }

        _cls4(OnMapLoadedCallback onmaploadedcallback)
        {
            akp = GoogleMap.this;
            aks = onmaploadedcallback;
            super();
        }

        private class OnMapLoadedCallback
        {

            public abstract void onMapLoaded();
        }

    }


    private class _cls9 extends com.google.android.gms.maps.internal.l.a
    {

        final GoogleMap akp;
        final OnMapLongClickListener akz;

        public void onMapLongClick(LatLng latlng)
        {
            akz.onMapLongClick(latlng);
        }

        _cls9(OnMapLongClickListener onmaplongclicklistener)
        {
            akp = GoogleMap.this;
            akz = onmaplongclicklistener;
            super();
        }

        private class OnMapLongClickListener
        {

            public abstract void onMapLongClick(LatLng latlng);
        }

    }


    private class _cls10 extends com.google.android.gms.maps.internal.n.a
    {

        final OnMarkerClickListener akA;
        final GoogleMap akp;

        public boolean a(l l)
        {
            return akA.onMarkerClick(new Marker(l));
        }

        _cls10(OnMarkerClickListener onmarkerclicklistener)
        {
            akp = GoogleMap.this;
            akA = onmarkerclicklistener;
            super();
        }

        private class OnMarkerClickListener
        {

            public abstract boolean onMarkerClick(Marker marker);
        }

    }


    private class _cls11 extends com.google.android.gms.maps.internal.o.a
    {

        final OnMarkerDragListener akB;
        final GoogleMap akp;

        public void b(l l)
        {
            akB.onMarkerDragStart(new Marker(l));
        }

        public void c(l l)
        {
            akB.onMarkerDragEnd(new Marker(l));
        }

        public void d(l l)
        {
            akB.onMarkerDrag(new Marker(l));
        }

        _cls11(OnMarkerDragListener onmarkerdraglistener)
        {
            akp = GoogleMap.this;
            akB = onmarkerdraglistener;
            super();
        }

        private class OnMarkerDragListener
        {

            public abstract void onMarkerDrag(Marker marker);

            public abstract void onMarkerDragEnd(Marker marker);

            public abstract void onMarkerDragStart(Marker marker);
        }

    }


    private class _cls3 extends com.google.android.gms.maps.internal.p.a
    {

        final GoogleMap akp;
        final OnMyLocationButtonClickListener akr;

        public boolean onMyLocationButtonClick()
        {
            return akr.onMyLocationButtonClick();
        }

        _cls3(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
        {
            akp = GoogleMap.this;
            akr = onmylocationbuttonclicklistener;
            super();
        }

        private class OnMyLocationButtonClickListener
        {

            public abstract boolean onMyLocationButtonClick();
        }

    }


    private class _cls2 extends com.google.android.gms.maps.internal.q.a
    {

        final GoogleMap akp;
        final OnMyLocationChangeListener akq;

        public void c(Location location)
        {
            akq.onMyLocationChange(location);
        }

        public void g(d d)
        {
            akq.onMyLocationChange((Location)e.f(d));
        }

        _cls2(OnMyLocationChangeListener onmylocationchangelistener)
        {
            akp = GoogleMap.this;
            akq = onmylocationchangelistener;
            super();
        }

        private class OnMyLocationChangeListener
        {

            public abstract void onMyLocationChange(Location location);
        }

    }


    private class _cls5 extends com.google.android.gms.maps.internal.v.a
    {

        final GoogleMap akp;
        final SnapshotReadyCallback akt;

        public void h(d d)
        {
            akt.onSnapshotReady((Bitmap)e.f(d));
        }

        public void onSnapshotReady(Bitmap bitmap)
        {
            akt.onSnapshotReady(bitmap);
        }

        _cls5(SnapshotReadyCallback snapshotreadycallback)
        {
            akp = GoogleMap.this;
            akt = snapshotreadycallback;
            super();
        }

        private class SnapshotReadyCallback
        {

            public abstract void onSnapshotReady(Bitmap bitmap);
        }

    }

}
