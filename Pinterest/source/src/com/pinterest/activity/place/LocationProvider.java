// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.place;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.pinterest.base.Application;
import com.pinterest.kit.application.PApplication;
import java.util.Timer;

public class LocationProvider
{

    private static final long LISTENER_TIMEOUT_MS = 20000L;
    private Listener _listener;
    private LocationManager _locationManager;
    private Timer _timer;
    private LocationListener gpsLocationListener;
    private LocationListener networkLocationListener;

    public LocationProvider()
    {
        networkLocationListener = new _cls2();
        gpsLocationListener = new _cls3();
        _locationManager = (LocationManager)Application.context().getSystemService("location");
    }

    public static Location getLastLocation(Context context)
    {
        Object obj = (LocationManager)context.getSystemService("location");
        boolean flag = isNetworkLocationEnabled(((LocationManager) (obj)));
        Object obj1;
        if (isGPSEnabled(((LocationManager) (obj))))
        {
            context = ((LocationManager) (obj)).getLastKnownLocation("gps");
        } else
        {
            context = null;
        }
        if (flag)
        {
            obj = ((LocationManager) (obj)).getLastKnownLocation("network");
        } else
        {
            obj = null;
        }
        if (context != null && obj != null)
        {
            obj1 = obj;
            if (context.getTime() > ((Location) (obj)).getTime())
            {
                obj1 = context;
            }
        } else
        {
            obj1 = obj;
            if (context != null)
            {
                return context;
            }
        }
        return ((Location) (obj1));
    }

    private static boolean isGPSEnabled(LocationManager locationmanager)
    {
        boolean flag;
        try
        {
            flag = locationmanager.isProviderEnabled("gps");
        }
        // Misplaced declaration of an exception variable
        catch (LocationManager locationmanager)
        {
            return false;
        }
        return flag;
    }

    private static boolean isNetworkLocationEnabled(LocationManager locationmanager)
    {
        boolean flag;
        try
        {
            flag = locationmanager.isProviderEnabled("network");
        }
        // Misplaced declaration of an exception variable
        catch (LocationManager locationmanager)
        {
            return false;
        }
        return flag;
    }

    public void removeLocationListeners()
    {
        _locationManager.removeUpdates(networkLocationListener);
        _locationManager.removeUpdates(gpsLocationListener);
        _listener = null;
        if (_timer != null)
        {
            _timer.cancel();
            _timer.purge();
            _timer = null;
        }
    }

    public void requestLocationUpdate(Listener listener)
    {
        if (_listener != null)
        {
            return;
        }
        _listener = listener;
        if (isNetworkLocationEnabled(_locationManager))
        {
            _locationManager.requestLocationUpdates("network", 0L, 0.0F, networkLocationListener);
        }
        if (isGPSEnabled(_locationManager))
        {
            _locationManager.requestLocationUpdates("gps", 0L, 0.0F, gpsLocationListener);
        }
        _timer = new Timer();
        _timer.schedule(new _cls1(), 20000L);
    }


    private class _cls2
        implements LocationListener
    {

        final LocationProvider this$0;

        public void onLocationChanged(Location location)
        {
            if (_listener != null)
            {
                _listener.onNetworkLocationUpdate(location);
            }
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
        }

        _cls2()
        {
            this$0 = LocationProvider.this;
            super();
        }

        private class Listener
        {

            public abstract void onGPSLocationUpdate(Location location);

            public abstract void onNetworkLocationUpdate(Location location);
        }

    }


    private class _cls3
        implements LocationListener
    {

        final LocationProvider this$0;

        public void onLocationChanged(Location location)
        {
            if (_listener != null)
            {
                _listener.onGPSLocationUpdate(location);
            }
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
        }

        _cls3()
        {
            this$0 = LocationProvider.this;
            super();
        }
    }


    private class _cls1 extends TimerTask
    {

        final LocationProvider this$0;

        public void run()
        {
            removeLocationListeners();
        }

        _cls1()
        {
            this$0 = LocationProvider.this;
            super();
        }
    }

}
