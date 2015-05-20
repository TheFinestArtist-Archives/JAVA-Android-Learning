// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Pin;
import com.pinterest.api.remote.PinApi;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.kit.notification.NotificationHelper;
import com.pinterest.kit.utils.IOUtils;
import com.pinterest.pushnotification.PushNotification;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;

public class PinUploader
{

    private Service _hostService;
    private final Object _lock = new Object();
    private int _retryCount;
    private boolean _uploadInProgress;
    private List _uploads;
    private com.pinterest.api.remote.PinApi.PinApiResponse onPinUpload;

    public PinUploader(Service service)
    {
        _uploadInProgress = false;
        onPinUpload = new _cls2();
        _hostService = service;
    }

    private void delayedRetry()
    {
        (new Timer()).schedule(new _cls3(), _retryCount * 10000);
    }

    public static String getPendingJSONFolder()
    {
        File file = new File(PApplication.context().getFilesDir(), "pending");
        if (!file.exists())
        {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String getPendingJSONPath()
    {
        String s = String.format("%s/%d", new Object[] {
            getPendingJSONFolder(), Long.valueOf(System.currentTimeMillis() / 1000L)
        });
        File file = new File(s);
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException ioexception)
            {
                return s;
            }
        }
        return s;
    }

    private List getPendingPins()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = new File(getPendingJSONFolder());
        if (((File) (obj)).exists())
        {
            obj = new LinkedHashSet(new ArrayList(Arrays.asList(((File) (obj)).listFiles())));
            if (((Set) (obj)).size() > 0)
            {
                arraylist.addAll(((java.util.Collection) (obj)));
                Collections.reverse(arraylist);
                ((Set) (obj)).clear();
            }
        }
        return Collections.synchronizedList(arraylist);
    }

    private Notification getRichNotification(String s, String s1, long l, Pin pin)
    {
        Object obj = new Navigation(Location.PIN, pin);
        Object obj1 = ActivityHelper.getHomeIntent(Application.context());
        ((Intent) (obj1)).putExtra("com.pinterest.EXTRA_PENDING_TASK", ((android.os.Parcelable) (obj)));
        obj = PendingIntent.getActivity(_hostService, 0, ((Intent) (obj1)), 0x8000000);
        obj1 = (new android.support.v4.app.NotificationCompat.Builder(_hostService)).setContentTitle(s).setContentText(s1).setSmallIcon(0x7f02014b).setOnlyAlertOnce(true).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
        obj = ImageCache.getBitmapBlocking(pin.getBoard().getImageCoverThumbnail(), false);
        s = ((String) (obj));
        if (obj != null)
        {
            s = Bitmap.createScaledBitmap(((Bitmap) (obj)), PushNotification.a, PushNotification.a, true);
        }
        if (s != null)
        {
            ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setLargeIcon(s);
        }
        obj = PushNotification.a(pin);
        if (TextUtils.isEmpty(pin.getImageLargeUrl()))
        {
            s = pin.getImageMediumUrl();
        } else
        {
            s = pin.getImageLargeUrl();
        }
        s = ImageCache.getBitmapBlocking(s, true, ((android.graphics.Rect) (obj)));
        if (s == null)
        {
            return ((android.support.v4.app.NotificationCompat.Builder) (obj1)).build();
        } else
        {
            return (new android.support.v4.app.NotificationCompat.BigPictureStyle(((android.support.v4.app.NotificationCompat.Builder) (obj1)))).setSummaryText(s1).bigPicture(s).build();
        }
    }

    private Thread newUploadThread()
    {
        return new Thread(new _cls1());
    }

    private void purgeCurrentPin()
    {
        synchronized (_lock)
        {
            ((File)_uploads.get(0)).delete();
            _uploads.remove(0);
            _uploadInProgress = false;
            _retryCount = 0;
            _lock.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void showNotification(int i)
    {
        Notification notification = NotificationHelper.getNotification(Resources.string(0x7f0e0045), Resources.string(i));
        ((NotificationManager)Application.context().getSystemService("notification")).notify(0, notification);
    }

    private void showNotification(Pin pin)
    {
        Object obj = Resources.string(0x7f0e0045);
        long l = System.currentTimeMillis();
        if (pin != null)
        {
            obj = getRichNotification(((String) (obj)), Resources.string(0x7f0e0318, new Object[] {
                pin.getBoard().getName()
            }), l, pin);
        } else
        {
            obj = NotificationHelper.getNotification(((String) (obj)), Resources.string(0x7f0e0376), l);
        }
        ((NotificationManager)Application.context().getSystemService("notification")).notify(0, ((Notification) (obj)));
        Events.postSticky(new com.pinterest.events.FeedEvents.MadeNewPin(pin));
        purgeCurrentPin();
    }

    private boolean uploadJsonPin(File file, ApiResponseHandler apiresponsehandler)
    {
        try
        {
            PinApi.a(com.pinterest.api.remote.PinApi.PinSubmitParams.a(new PinterestJsonObject(IOUtils.loadTextFile(file))), apiresponsehandler);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return false;
        }
        return true;
    }

    public void startContinuousUpload()
    {
        _uploads = getPendingPins();
        Thread thread = newUploadThread();
        thread.setPriority(4);
        thread.start();
    }



/*
    static List access$002(PinUploader pinuploader, List list)
    {
        pinuploader._uploads = list;
        return list;
    }

*/






/*
    static boolean access$202(PinUploader pinuploader, boolean flag)
    {
        pinuploader._uploadInProgress = flag;
        return flag;
    }

*/








/*
    static Service access$802(PinUploader pinuploader, Service service)
    {
        pinuploader._hostService = service;
        return service;
    }

*/



/*
    static int access$902(PinUploader pinuploader, int i)
    {
        pinuploader._retryCount = i;
        return i;
    }

*/


/*
    static int access$908(PinUploader pinuploader)
    {
        int i = pinuploader._retryCount;
        pinuploader._retryCount = i + 1;
        return i;
    }

*/

    private class _cls2 extends com.pinterest.api.remote.PinApi.PinApiResponse
    {

        final PinUploader this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            throwable = ((Throwable) (apiresponse.getData()));
            if ((throwable instanceof PinterestJsonObject) && ((PinterestJsonObject)throwable).a("param_name", "").equalsIgnoreCase("sdk_client_id"))
            {
                _retryCount = 10;
                Application.showToast(0x7f0e040f);
                NotificationHelper.cancelNotifPinUpload();
                purgeCurrentPin();
                return;
            }
            if (_retryCount > 3)
            {
                showNotification(0x7f0e0316);
                purgeCurrentPin();
                return;
            } else
            {
                delayedRetry();
                return;
            }
        }

        public void onStart()
        {
            super.onStart();
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void onSuccess(Pin pin)
        {
            onSuccess(pin);
            Pinalytics.a(EventType.PIN_CREATE, pin.getUid());
            if (pin != null && pin.getBoard() != null)
            {
                (new ShowNotifTask(null)).execute(new Pin[] {
                    pin
                });
            }
        }

        _cls2()
        {
            this$0 = PinUploader.this;
            super();
        }

        private class ShowNotifTask extends AsyncTask
        {

            final PinUploader this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Pin[])aobj);
            }

            protected transient Void doInBackground(Pin apin[])
            {
                showNotification(apin[0]);
                return null;
            }

            private ShowNotifTask()
            {
                this$0 = PinUploader.this;
                AsyncTask();
            }

            ShowNotifTask(_cls1 _pcls1)
            {
                ShowNotifTask();
            }
        }

    }


    private class _cls3 extends TimerTask
    {

        final PinUploader this$0;

        public void run()
        {
            _uploadInProgress = false;
            synchronized (_lock)
            {
                _lock.notifyAll();
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls3()
        {
            this$0 = PinUploader.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final PinUploader this$0;

        public void run()
        {
            if (_uploads == null)
            {
                return;
            }
            Object obj = _lock;
            obj;
            JVM INSTR monitorenter ;
_L3:
            Exception exception;
            if (_uploads.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_184;
            }
            if (_uploadInProgress)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            if (_uploads != null && _uploads.size() != 0)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            return;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            if (!uploadJsonPin((File)_uploads.get(0), onPinUpload))
            {
                break MISSING_BLOCK_LABEL_165;
            }
            _uploadInProgress = true;
_L1:
            boolean flag = _uploadInProgress;
            if (flag)
            {
                try
                {
                    _lock.wait();
                    _uploads = getPendingPins();
                }
                catch (Exception exception1) { }
                finally { }
            }
            continue; /* Loop/switch isn't completed */
            showNotification(0x7f0e0316);
            purgeCurrentPin();
              goto _L1
            if (_hostService != null)
            {
                _hostService.stopSelf();
                _hostService = null;
            }
            obj;
            JVM INSTR monitorexit ;
            return;
            if (true) goto _L3; else goto _L2
_L2:
        }

        _cls1()
        {
            this$0 = PinUploader.this;
            super();
        }
    }

}
