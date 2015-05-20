// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.pinterest.kit.log.PLog;

public class MapFragment extends SupportMapFragment
{

    public int DEFAULT_ZOOM;
    public int MIN_DISTANCE;
    private Listener _listener;
    private int readyCheckCount;

    public MapFragment()
    {
        DEFAULT_ZOOM = 13;
        MIN_DISTANCE = 200;
    }

    private void checkMapReady()
    {
        GoogleMap googlemap;
        readyCheckCount = readyCheckCount + 1;
        googlemap = getMap();
        if (googlemap != null) goto _L2; else goto _L1
_L1:
        if (readyCheckCount <= 3) goto _L4; else goto _L3
_L3:
        return;
_L4:
        (new Handler(Looper.getMainLooper())).postDelayed(new _cls1(), readyCheckCount * 60);
        return;
_L2:
        UiSettings uisettings = googlemap.getUiSettings();
        uisettings.setZoomControlsEnabled(false);
        uisettings.setCompassEnabled(false);
        uisettings.setTiltGesturesEnabled(false);
        googlemap.addTileOverlay((new TileOverlayOptions()).tileProvider(new MapboxTileProvider()).zIndex(5F).fadeIn(true).visible(true));
        googlemap.setMapType(0);
        if (_listener != null)
        {
            _listener.onReady();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void centerOn(LatLng latlng)
    {
        if (getMap() == null)
        {
            return;
        } else
        {
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, DEFAULT_ZOOM));
            PLog.a((new StringBuilder("centerOn: ")).append(latlng).toString(), new Object[0]);
            return;
        }
    }

    public Listener getListener()
    {
        return _listener;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        readyCheckCount = 0;
        checkMapReady();
    }

    public void setListener(Listener listener)
    {
        _listener = listener;
    }


    private class _cls1
        implements Runnable
    {

        final MapFragment this$0;

        public void run()
        {
            checkMapReady();
        }

        _cls1()
        {
            this$0 = MapFragment.this;
            super();
        }
    }


    private class MapboxTileProvider extends UrlTileProvider
    {

        private static final String ACCESS_TOKEN = AppUtils.getApplicationMetadata(Application.context().getPackageName(), "com.pinterest.mapbox.ApiKey");
        private static final String ACCOUNT = "pinterest.";
        private static final String FORMAT = "http://api.tiles.mapbox.com/v4/%s/%d/%d/%d.png";
        private static final String FORMAT_2X = "http://api.tiles.mapbox.com/v4/%s/%d/%d/%d.png".replace(".png", "@2x.png");
        public static final String MAP_ID_DE = "md5kx1or";
        public static final String MAP_ID_EN = "ijz1714i";
        public static final String MAP_ID_ES = "hiqhyqfr";
        public static final String MAP_ID_FR = "vypkfbt9";
        private String _mapIdentifier;

        private String resolveIdentifier()
        {
            if (LocaleUtils.isLanguageEs())
            {
                return "hiqhyqfr";
            }
            if (LocaleUtils.isLanguageDe())
            {
                return "md5kx1or";
            }
            if (LocaleUtils.isLanguageFr())
            {
                return "vypkfbt9";
            } else
            {
                return "ijz1714i";
            }
        }

        public URL getTileUrl(int i, int j, int k)
        {
            String s;
            StringBuilder stringbuilder;
            stringbuilder = new StringBuilder();
            if (!Device.shouldLoadBigImages())
            {
                break MISSING_BLOCK_LABEL_99;
            }
            s = FORMAT_2X;
_L1:
            return new URL(stringbuilder.append(String.format(s, new Object[] {
                (new StringBuilder("pinterest.")).append(_mapIdentifier).toString(), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j)
            })).append("?access_token=").append(ACCESS_TOKEN).toString());
            s = "http://api.tiles.mapbox.com/v4/%s/%d/%d/%d.png";
              goto _L1
            MalformedURLException malformedurlexception;
            malformedurlexception;
            return null;
        }


        public MapboxTileProvider()
        {
            super(256, 256);
            _mapIdentifier = resolveIdentifier();
        }
    }


    private class Listener
    {

        public void onReady()
        {
        }

        public Listener()
        {
        }
    }

}
