// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationManagerCompat;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.Place;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.base.Geofencing;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.kit.utils.LocationUtils;
import com.pinterest.pushnotification.PushNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsData, SortedGeoFenceMap

public class NearbyPinsGeofencing
{

    public static final int DWELL_MINIMUM = 20000;
    private static final int GEOFENCE_EXPIRE_TIME = 0xa4cb800;
    public static final int GEOFENCE_RADIUS = 500;
    private static final String GOOGLEMAPS_URL = "http://maps.google.com/maps?saddr=%1$s,%2$s&daddr=%1$s,%2$s";
    private static final String MAP_URL = "http://maps.googleapis.com/maps/api/staticmap?center=%s&markers=color:red|%s&zoom=15&&scale=2&size=%s&key=AIzaSyDybBm_hqwipeuJdUDfpMjYdPxGG3jJjAA";
    public static final int MAX_UPDATE_FREQUENCY = 0x1499700;
    public static final int MIN_COOL_DOWN = 0x1b7740;
    private static float MIN_PLACE_DISTANCE = 0F;
    public static final String MY_BUBBLE = "com.pinterest.MY_BUBBLE";
    public static final int NOTIFICATION_ID = 34532;
    private static NearbyPinsGeofencing _instance;
    private static long _lastNotificationTime;
    private static long _lastUpdateTime;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;

    private NearbyPinsGeofencing()
    {
        _eventsSubscriber = new _cls2();
        Events.register(_eventsSubscriber, com/pinterest/receiver/GeofenceReceiver$UpdateEvent, new Class[0]);
    }

    private static android.support.v4.app.NotificationCompat.Builder getMapNotification(Place place, Bitmap bitmap)
    {
        Object obj = Uri.parse(String.format("http://maps.google.com/maps?saddr=%1$s,%2$s&daddr=%1$s,%2$s", new Object[] {
            place.getLatitude(), place.getLongitude()
        }));
        obj = PendingIntent.getActivity(Application.context(), 0, new Intent("android.intent.action.VIEW", ((Uri) (obj))), 0x8000000);
        return (new android.support.v4.app.NotificationCompat.Builder(Application.context())).setAutoCancel(true).setSmallIcon(0x7f02014b).setContentIntent(((PendingIntent) (obj))).setContentTitle(place.getName()).setContentText(StringUtils.defaultString(place.getStreet(), "")).setStyle((new android.support.v4.app.NotificationCompat.BigPictureStyle()).bigPicture(bitmap).setBigContentTitle(place.getName()).setSummaryText(place.getAddress()));
    }

    private static android.support.v4.app.NotificationCompat.Action.Builder getNavigateAction(Place place)
    {
        place = Uri.parse(String.format("google.navigation:q=%s,%s", new Object[] {
            place.getLatitude(), place.getLongitude()
        }));
        place = PendingIntent.getActivity(Application.context(), 0, new Intent("android.intent.action.VIEW", place), 0x8000000);
        return new android.support.v4.app.NotificationCompat.Action.Builder(0x7f020158, Resources.string(0x7f0e02f7), place);
    }

    private static android.support.v4.app.NotificationCompat.Builder getPinNotification(Pin pin, Bitmap bitmap)
    {
        Object obj = pin.getPlace();
        String s = Resources.string(0x7f0e0045);
        if (MyUser.isUserMe(pin.getUserUid()))
        {
            obj = Resources.string(0x7f0e02f9, new Object[] {
                ((Place) (obj)).getName()
            });
        } else
        {
            obj = Resources.string(0x7f0e02f8, new Object[] {
                ((Place) (obj)).getName()
            });
        }
        pin = PendingIntent.getActivity(Application.context(), 0, ActivityHelper.getTaskIntent(Application.context(), new Navigation(Location.PIN, pin)), 0x8000000);
        return (new android.support.v4.app.NotificationCompat.Builder(Application.context())).setAutoCancel(true).setSmallIcon(0x7f02014b).setContentIntent(pin).setContentTitle(s).setContentText(((CharSequence) (obj))).setStyle((new android.support.v4.app.NotificationCompat.BigPictureStyle()).bigPicture(bitmap).setBigContentTitle(s).setSummaryText(((CharSequence) (obj))));
    }

    private List loadNotificationBitmaps(Pin pin)
    {
        Object obj = pin.getPlace();
        if (obj == null)
        {
            return null;
        } else
        {
            Application.showDebugToast(String.format("Loading place from pin %s", new Object[] {
                pin.getUid()
            }));
            obj = (new StringBuilder()).append(((Place) (obj)).getLatitude()).append(",").append(((Place) (obj)).getLongitude()).toString();
            obj = String.format("http://maps.googleapis.com/maps/api/staticmap?center=%s&markers=color:red|%s&zoom=15&&scale=2&size=%s&key=AIzaSyDybBm_hqwipeuJdUDfpMjYdPxGG3jJjAA", new Object[] {
                obj, obj, "300x300"
            });
            Object obj1 = PushNotification.a(pin);
            pin = ImageCache.getBitmapBlocking((String)StringUtils.defaultIfBlank(pin.getImageLargeUrl(), pin.getImageMediumUrl()), false, ((android.graphics.Rect) (obj1)));
            obj = ImageCache.getBitmapBlocking(((String) (obj)), false, ((android.graphics.Rect) (obj1)));
            obj1 = new ArrayList(2);
            ((List) (obj1)).add(pin);
            ((List) (obj1)).add(obj);
            return ((List) (obj1));
        }
    }

    private static boolean needsToUpdate()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!Preferences.user().getBoolean("PREF_NEARBY_NOTIFICATIONS", true))
            {
                break label0;
            }
            if (NearbyPinsData.hasPlacesData())
            {
                flag = flag1;
                if (_lastUpdateTime >= SystemClock.uptimeMillis() - 0x1499700L)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private static void showNotification(Pin pin, Bitmap bitmap, Bitmap bitmap1)
    {
        if (!Preferences.user().getBoolean("PREF_NEARBY_NOTIFICATIONS", true))
        {
            return;
        } else
        {
            Application.showDebugToast(String.format("Showing place from pin %s", new Object[] {
                pin.getUid()
            }));
            Place place = pin.getPlace();
            bitmap = getPinNotification(pin, bitmap);
            bitmap1 = getMapNotification(place, bitmap1);
            android.support.v4.app.NotificationCompat.Action.Builder builder = getNavigateAction(place);
            pin = PendingIntent.getActivity(Application.context(), 0, ActivityHelper.getTaskIntent(Application.context(), new Navigation(Location.PIN, pin)), 0x8000000);
            pin = bitmap.extend((new android.support.v4.app.NotificationCompat.WearableExtender()).setDisplayIntent(pin).addPage(bitmap1.build()).addAction(builder.build())).build();
            NotificationManagerCompat.from(Application.context()).notify((int)(place.getId().longValue() + 34532L), pin);
            NearbyPinsData.markPlaceNotified(place.getUid());
            return;
        }
    }

    public static void update()
    {
        if (!MyUser.hasAccessTokenAndUser() || !needsToUpdate())
        {
            return;
        }
        if (_instance == null)
        {
            _instance = new NearbyPinsGeofencing();
        }
        NearbyPinsData.loadPlaces(new _cls1());
        _lastUpdateTime = SystemClock.uptimeMillis();
    }

    public void createGeofences(List list)
    {
        SortedGeoFenceMap sortedgeofencemap = new SortedGeoFenceMap();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Place place = (Place)list.next();
            float f = LocationUtils.distanceFromMe(place.getLatitude().doubleValue(), place.getLongitude().doubleValue());
            if (f != -1F && f < MIN_PLACE_DISTANCE)
            {
                sortedgeofencemap.put(Float.valueOf(f), (new com.google.android.gms.location.Geofence.Builder()).setRequestId(place.getUid()).setLoiteringDelay(20000).setTransitionTypes(4).setCircularRegion(place.getLatitude().doubleValue(), place.getLongitude().doubleValue(), 500F).setExpirationDuration(0xa4cb800L).build());
            }
        } while (true);
        Geofencing.instance().add(sortedgeofencemap);
    }

    static 
    {
        MIN_PLACE_DISTANCE = 50000F;
    }




/*
    static long access$102(long l)
    {
        _lastNotificationTime = l;
        return l;
    }

*/



    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final NearbyPinsGeofencing this$0;

        public void onEventMainThread(final com.pinterest.receiver.GeofenceReceiver.UpdateEvent finalRequestId)
        {
            Object obj;
            obj = finalRequestId.a();
            break MISSING_BLOCK_LABEL_5;
label0:
            while ("com.pinterest.MY_BUBBLE".equals(finalRequestId)) 
            {
                do
                {
                    return;
                } while (obj == null || ((List) (obj)).size() == 0 || SystemClock.uptimeMillis() - NearbyPinsGeofencing._lastNotificationTime < 0x1b7740L);
                NearbyPinsGeofencing._lastNotificationTime = SystemClock.uptimeMillis();
                finalRequestId = ((Geofence)((List) (obj)).get(0)).getRequestId();
                Iterator iterator = ((List) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    obj = ((Geofence)iterator.next()).getRequestId();
                    finalRequestId = ((com.pinterest.receiver.GeofenceReceiver.UpdateEvent) (obj));
                } while (NearbyPinsData.wasPlaceNotified(((String) (obj))));
                finalRequestId = ((com.pinterest.receiver.GeofenceReceiver.UpdateEvent) (obj));
            }
            Application.showDebugToast(String.format("Received geofence for place %s", new Object[] {
                finalRequestId
            }));
            class _cls1 extends BackgroundTask
            {

                private List _bitmaps;
                private Pin _pin;
                final _cls2 this$1;
                final String val$finalRequestId;

                public void onFinish()
                {
                    if (_pin != null && _bitmaps != null && _bitmaps.size() >= 2)
                    {
                        NearbyPinsGeofencing.showNotification(_pin, (Bitmap)_bitmaps.get(0), (Bitmap)_bitmaps.get(1));
                    }
                }

                public void run()
                {
                    _pin = ModelHelper.getPinFromPlace(finalRequestId);
                    if (_pin != null)
                    {
                        _bitmaps = loadNotificationBitmaps(_pin);
                    }
                }

                _cls1()
                {
                    this$1 = _cls2.this;
                    finalRequestId = s;
                    super();
                }
            }

            (new _cls1()).execute();
            return;
        }

        _cls2()
        {
            this$0 = NearbyPinsGeofencing.this;
            super();
        }
    }


    private class _cls1
        implements NearbyPinsData.Callback
    {

        public final void onPlacesLoaded(List list)
        {
            NearbyPinsGeofencing._instance.createGeofences(list);
        }

        _cls1()
        {
        }
    }

}
