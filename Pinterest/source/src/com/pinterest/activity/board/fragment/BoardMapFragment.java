// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.pinterest.activity.map.InfoWindowAdapter;
import com.pinterest.activity.map.MapOptions;
import com.pinterest.activity.map.MapPin;
import com.pinterest.activity.map.PinMarkerOptionsChooser;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinFeed;
import com.pinterest.api.model.Place;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.fragment.MapFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.log.PLog;
import com.twotoasters.clusterkraf.ClusterPoint;
import com.twotoasters.clusterkraf.Clusterkraf;
import com.twotoasters.clusterkraf.InputPoint;
import com.twotoasters.clusterkraf.OnInfoWindowClickDownstreamListener;
import com.twotoasters.clusterkraf.OnMarkerClickDownstreamListener;
import com.twotoasters.clusterkraf.Options;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardMapFragment extends MapFragment
{

    public int MAP_PADDING;
    private PinFeed _feed;
    private LatLng _initCenter;
    private GoogleMap _map;
    private Clusterkraf clusterkraf;
    OnInfoWindowClickDownstreamListener infoClicked;
    private ArrayList inputPoints;
    OnMarkerClickDownstreamListener markerClicked;
    private MapOptions options;
    com.twotoasters.clusterkraf.Clusterkraf.ProcessingListener processingListener;

    public BoardMapFragment()
    {
        MAP_PADDING = (int)Resources.dimension(0x7f0a0098) + Constants.PLACE_MARKER_SIZE;
        inputPoints = new ArrayList();
        infoClicked = new _cls2();
        processingListener = new _cls3();
        markerClicked = new _cls4();
    }

    private void adjustMapZoom(LatLngBounds latlngbounds)
    {
        if (_map.getCameraPosition().zoom > (float)DEFAULT_ZOOM)
        {
            latlngbounds = latlngbounds.getCenter();
            _map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlngbounds, DEFAULT_ZOOM));
        }
    }

    private void applyDemoOptionsToClusterkrafOptions(Options options1)
    {
        options1.a(options.transitionDuration);
        options1.b(getPixelDistanceToJoinCluster());
        options1.d(options.zoomToBoundsAnimationDuration);
        options1.e(options.showInfoWindowAnimationDuration);
        options1.a(options.expandBoundsFactor);
        options1.a(options.singlePointClickBehavior);
        options1.a(options.clusterClickBehavior);
        options1.a(options.clusterInfoWindowClickBehavior);
        options1.a(markerClicked);
        options1.a(infoClicked);
        options1.c(MAP_PADDING);
        options1.a(PinMarkerOptionsChooser.instance());
        options1.a(processingListener);
        options1.a(new InfoWindowAdapter(getActivity()));
    }

    private int getPixelDistanceToJoinCluster()
    {
        return (int)Device.dpToPixel(options.dipDistanceToJoinCluster);
    }

    private void initCameraView(final com.google.android.gms.maps.model.LatLngBounds.Builder bounds)
    {
        if (_initCenter == null)
        {
            bounds = bounds.build();
            _map.setOnCameraChangeListener(new _cls1());
            try
            {
                _map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, MAP_PADDING));
            }
            catch (Exception exception)
            {
                exception.toString();
                _map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, (int)Device.getScreenWidth(), (int)Device.getScreenHeight(), MAP_PADDING));
            }
            adjustMapZoom(bounds);
            return;
        } else
        {
            centerOn(_initCenter);
            _initCenter = null;
            return;
        }
    }

    private void initMap()
    {
        _map = getMap();
        if (!isPinMapReady())
        {
            return;
        } else
        {
            showPins();
            return;
        }
    }

    private void showMapPins(ClusterPoint clusterpoint)
    {
        int j = clusterpoint.e();
        Object obj = new ArrayList(j);
        Pin pin = null;
        for (int i = 0; i < j; i++)
        {
            pin = ((MapPin)clusterpoint.a(i).d()).pin;
            ((List) (obj)).add(pin);
        }

        clusterpoint = new PinFeed();
        clusterpoint.setItems(((List) (obj)));
        obj = new Navigation(Location.STATIC_PIN_GRID);
        ((Navigation) (obj)).putExtra("com.pinterest.EXTRA_FEED", clusterpoint);
        ((Navigation) (obj)).putExtra("com.pinterest.EXTRA_TITLE", Resources.string(0x7f0e03ab, new Object[] {
            pin.getPlace().getAddress()
        }));
        Events.post(obj);
    }

    private void showPins()
    {
        int i = _feed.getCount();
        PLog.a((new StringBuilder("showPins: ")).append(i).toString(), new Object[0]);
        if (i != 0)
        {
            options = new MapOptions();
            Object obj1 = _feed.getItems();
            Object obj = LatLngBounds.builder();
            obj1 = ((List) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Object obj2 = (Pin)((Iterator) (obj1)).next();
                Place place = ((Pin) (obj2)).getPlace();
                if (place != null && place.getLatitude() != null && place.getLongitude() != null)
                {
                    obj2 = new MapPin(((Pin) (obj2)));
                    inputPoints.add(new InputPoint(((MapPin) (obj2)).latLng, obj2));
                    ((com.google.android.gms.maps.model.LatLngBounds.Builder) (obj)).include(((MapPin) (obj2)).latLng);
                }
            } while (true);
            if (inputPoints.size() != 0)
            {
                initCameraView(((com.google.android.gms.maps.model.LatLngBounds.Builder) (obj)));
                obj = new Options();
                applyDemoOptionsToClusterkrafOptions(((Options) (obj)));
                if (clusterkraf == null)
                {
                    clusterkraf = new Clusterkraf(_map, ((Options) (obj)), inputPoints);
                    return;
                } else
                {
                    Clusterkraf clusterkraf1 = clusterkraf;
                    ArrayList arraylist = inputPoints;
                    clusterkraf1.a();
                    clusterkraf1.a(arraylist);
                    return;
                }
            }
        }
    }

    public boolean isPinMapReady()
    {
        return _map != null && _feed != null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        PinMarkerOptionsChooser.instance().clearCache();
        PLog.a("BoardMapFragment onDestroyView", new Object[0]);
    }

    public void onPause()
    {
        super.onPause();
        PLog.a("BoardMapFragment onPause", new Object[0]);
    }

    public void onResume()
    {
        super.onResume();
        PLog.a("BoardMapFragment onResume", new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        PLog.a("BoardMapFragment onSaveInstanceState", new Object[0]);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        PLog.a("BoardMapFragment onViewCreated", new Object[0]);
        initMap();
    }

    public void setInitCenter(LatLng latlng)
    {
        _initCenter = latlng;
    }

    public void setPinFeed(PinFeed pinfeed)
    {
        _feed = pinfeed;
        if (!isPinMapReady())
        {
            return;
        } else
        {
            showPins();
            return;
        }
    }




    private class _cls2
        implements OnInfoWindowClickDownstreamListener
    {

        final BoardMapFragment this$0;

        public boolean onInfoWindowClick(Marker marker, ClusterPoint clusterpoint)
        {
            Pinalytics.a(ElementType.MAP_ANNOTATION, ComponentType.MAP);
            try
            {
                marker = (MapPin)clusterpoint.a(0).d();
            }
            // Misplaced declaration of an exception variable
            catch (Marker marker)
            {
                return false;
            }
            if (marker != null && ((MapPin) (marker)).pin != null && ((MapPin) (marker)).pinId != null)
            {
                Events.post(new Navigation(Location.PIN, ((MapPin) (marker)).pin));
                return true;
            } else
            {
                return false;
            }
        }

        _cls2()
        {
            this$0 = BoardMapFragment.this;
            super();
        }
    }


    private class _cls3
        implements com.twotoasters.clusterkraf.Clusterkraf.ProcessingListener
    {

        final BoardMapFragment this$0;

        public void onClusteringFinished()
        {
        }

        public void onClusteringStarted()
        {
        }

        _cls3()
        {
            this$0 = BoardMapFragment.this;
            super();
        }
    }


    private class _cls4
        implements OnMarkerClickDownstreamListener
    {

        final BoardMapFragment this$0;

        public boolean onMarkerClick(Marker marker, ClusterPoint clusterpoint)
        {
            if (marker == null || clusterpoint == null)
            {
                return false;
            }
            Pinalytics.a(ElementType.MAP_PIN_ICON, ComponentType.MAP);
            if (marker.isInfoWindowShown())
            {
                infoClicked.onInfoWindowClick(marker, clusterpoint);
                return true;
            }
            int j = clusterpoint.e();
            if (j < 2)
            {
                return false;
            }
            marker = LatLngBounds.builder();
            for (int i = 0; i < j; i++)
            {
                marker.include(clusterpoint.a(i).a());
            }

            marker = marker.build();
            float af[] = new float[1];
            android.location.Location.distanceBetween(((LatLngBounds) (marker)).southwest.latitude, ((LatLngBounds) (marker)).southwest.longitude, ((LatLngBounds) (marker)).northeast.latitude, ((LatLngBounds) (marker)).northeast.longitude, af);
            if (af[0] < (float)MIN_DISTANCE)
            {
                PLog.a((new StringBuilder("Points too close Results: ")).append(af[0]).toString(), new Object[0]);
                showMapPins(clusterpoint);
                return true;
            } else
            {
                return false;
            }
        }

        _cls4()
        {
            this$0 = BoardMapFragment.this;
            super();
        }
    }


    private class _cls1
        implements com.google.android.gms.maps.GoogleMap.OnCameraChangeListener
    {

        final BoardMapFragment this$0;
        final LatLngBounds val$bounds;

        public void onCameraChange(CameraPosition cameraposition)
        {
            _map.setOnCameraChangeListener(null);
            adjustMapZoom(bounds);
        }

        _cls1()
        {
            this$0 = BoardMapFragment.this;
            bounds = latlngbounds;
            super();
        }
    }

}
