// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.Place;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.fragment.MapFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.text.IconView;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView

public class PinCloseupPlaceView extends PinCloseupSubView
    implements android.view.View.OnClickListener
{

    public static final int MARKER_SIZE = (int)(36F * Device.getDensity());
    private ViewGroup _mapContainer;
    private MapFragment _mapFragment;
    private Marker _mapMarker;
    private IconView _navigateBt;
    private FrameLayout _wrapper;
    private com.pinterest.fragment.MapFragment.Listener onMapReady;
    private com.google.android.gms.maps.GoogleMap.OnMarkerClickListener onMarkerClicked;

    public PinCloseupPlaceView(Context context)
    {
        super(context);
        onMapReady = new _cls1();
        onMarkerClicked = new _cls2();
    }

    private com.google.android.gms.maps.GoogleMap.OnCameraChangeListener makeMapListener(final GoogleMap map, final LatLng latLng)
    {
        return new _cls3();
    }

    private void showMapMarker()
    {
        Object obj = _pin.getPlace();
        if (obj != null && _mapFragment != null)
        {
            GoogleMap googlemap = _mapFragment.getMap();
            if (googlemap != null && ((Place) (obj)).getLatitude() != null && ((Place) (obj)).getLongitude() != null)
            {
                googlemap.getUiSettings().setAllGesturesEnabled(false);
                googlemap.setOnMarkerClickListener(onMarkerClicked);
                obj = new LatLng(((Place) (obj)).getLatitude().doubleValue(), ((Place) (obj)).getLongitude().doubleValue());
                googlemap.setOnCameraChangeListener(makeMapListener(googlemap, ((LatLng) (obj))));
                googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(((LatLng) (obj)), 15F));
                obj = (new MarkerOptions()).position(((LatLng) (obj))).icon(BitmapDescriptorFactory.fromResource(0x7f02012f));
                if (_mapMarker != null)
                {
                    _mapMarker.remove();
                }
                _mapMarker = googlemap.addMarker(((MarkerOptions) (obj)));
            }
        }
    }

    protected void initView()
    {
        setBackgroundColor(Colors.WHITE);
        removeAllViews();
        _wrapper = new FrameLayout(getContext());
        addView(_wrapper, -1, -2);
        _mapContainer = new FrameLayout(getContext());
        _mapContainer.setId(0x7f0b0008);
        _wrapper.addView(_mapContainer, -1, (int)Resources.dimension(0x7f0a00b8));
        _navigateBt = new IconView(getContext(), null, 0x7f0f0126);
        _navigateBt.setImageResource(0x7f020106);
        _navigateBt.setOnClickListener(this);
        _navigateBt.setBackgroundResource(0x7f020042);
        _navigateBt.setPadding(Constants.MARGIN, Constants.MARGIN, Constants.MARGIN, Constants.MARGIN);
        _wrapper.addView(_navigateBt, Constants.BUTTON_HEIGHT + Constants.MARGIN_HALF, Constants.BUTTON_HEIGHT + Constants.MARGIN_HALF);
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)_navigateBt.getLayoutParams();
        layoutparams.setMargins(0, 0, Constants.MARGIN, Constants.MARGIN);
        layoutparams.gravity = 85;
        _navigateBt.setLayoutParams(layoutparams);
    }

    public void onClick(View view)
    {
        if (view == _navigateBt)
        {
            Pinalytics.a(ElementType.MAP_DIRECTIONS_BUTTON, null, _pin.getUid());
            ActivityHelper.goIntentPlace(getContext(), _pinPlace);
        }
    }

    protected void onDetachedFromWindow()
    {
        if (_mapFragment != null)
        {
            _mapFragment.setListener(null);
        }
        _mapFragment = null;
        super.onDetachedFromWindow();
    }

    protected boolean shouldUpdateView()
    {
        return true;
    }

    protected void updateView()
    {
        if (_pin.showMap().booleanValue())
        {
            Object obj = getFragmentManager();
            if (_mapFragment == null && obj != null)
            {
                _mapFragment = new MapFragment();
                _mapFragment.setListener(onMapReady);
                obj = ((FragmentManager) (obj)).beginTransaction();
                ((FragmentTransaction) (obj)).replace(_mapContainer.getId(), _mapFragment, null);
                ((FragmentTransaction) (obj)).commitAllowingStateLoss();
            }
            _wrapper.setVisibility(0);
            return;
        } else
        {
            _wrapper.setVisibility(8);
            return;
        }
    }



    private class _cls1 extends com.pinterest.fragment.MapFragment.Listener
    {

        final PinCloseupPlaceView this$0;

        public void onReady()
        {
            showMapMarker();
        }

        _cls1()
        {
            this$0 = PinCloseupPlaceView.this;
            super();
        }
    }


    private class _cls2
        implements com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    {

        final PinCloseupPlaceView this$0;

        public boolean onMarkerClick(Marker marker)
        {
            (new com.pinterest.activity.board.fragment.BoardMapFragment.PinCloseupMarkerClickListener(_pin)).onClick();
            return true;
        }

        _cls2()
        {
            this$0 = PinCloseupPlaceView.this;
            super();
        }
    }


    private class _cls3
        implements com.google.android.gms.maps.GoogleMap.OnCameraChangeListener
    {

        final PinCloseupPlaceView this$0;
        final LatLng val$latLng;
        final GoogleMap val$map;

        public void onCameraChange(CameraPosition cameraposition)
        {
            cameraposition = map.getProjection();
            Point point = cameraposition.toScreenLocation(latLng);
            point.offset(0, -PinCloseupPlaceView.MARKER_SIZE / 2);
            cameraposition = cameraposition.fromScreenLocation(point);
            map.setOnCameraChangeListener(null);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraposition, 15F));
        }

        _cls3()
        {
            this$0 = PinCloseupPlaceView.this;
            map = googlemap;
            latLng = latlng;
            super();
        }
    }

}
