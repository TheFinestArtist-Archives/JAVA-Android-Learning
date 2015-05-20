// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationServices;
import com.pinterest.activity.geofence.googleio.SortedGeoFenceMap;

// Referenced classes of package com.pinterest.base:
//            Application

public class Geofencing
{

    private static Geofencing _instance;
    private SortedGeoFenceMap _geofences;
    private GoogleApiClient _locationClient;
    private PendingIntent _pendingIntent;
    private ResultCallback onGeofenceAdded;
    private com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks onLocationConnect;
    private com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onLocationFail;

    private Geofencing()
    {
        onLocationConnect = new _cls1();
        onLocationFail = new _cls2();
        onGeofenceAdded = new _cls3();
        _geofences = new SortedGeoFenceMap();
        _locationClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(Application.context())).addApi(LocationServices.API).addConnectionCallbacks(onLocationConnect).addOnConnectionFailedListener(onLocationFail).build();
    }

    public static Geofencing instance()
    {
        if (_instance == null)
        {
            _instance = new Geofencing();
        }
        return _instance;
    }

    public void add(SortedGeoFenceMap sortedgeofencemap)
    {
        if (sortedgeofencemap != null && !sortedgeofencemap.isEmpty())
        {
            _geofences.putAll(sortedgeofencemap);
            _locationClient.connect();
        }
    }



/*
    static PendingIntent access$002(Geofencing geofencing, PendingIntent pendingintent)
    {
        geofencing._pendingIntent = pendingintent;
        return pendingintent;
    }

*/




    private class _cls1
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    {

        final Geofencing this$0;

        public void onConnected(Bundle bundle)
        {
            bundle = new Intent(Application.context(), com/pinterest/receiver/GeofenceReceiver);
            _pendingIntent = PendingIntent.getBroadcast(Application.context(), 0, bundle, 0x8000000);
            LocationServices.GeofencingApi.addGeofences(_locationClient, _geofences.getValuesAsList(), _pendingIntent).setResultCallback(onGeofenceAdded);
        }

        public void onConnectionSuspended(int i)
        {
        }

        _cls1()
        {
            this$0 = Geofencing.this;
            super();
        }
    }


    private class _cls2
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final Geofencing this$0;

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            (new StringBuilder("Failed to connect to LocationClient with error ")).append(connectionresult.toString());
        }

        _cls2()
        {
            this$0 = Geofencing.this;
            super();
        }
    }


    private class _cls3
        implements ResultCallback
    {

        final Geofencing this$0;

        public volatile void onResult(Result result)
        {
            onResult((Status)result);
        }

        public void onResult(Status status)
        {
            _locationClient.disconnect();
        }

        _cls3()
        {
            this$0 = Geofencing.this;
            super();
        }
    }

}
