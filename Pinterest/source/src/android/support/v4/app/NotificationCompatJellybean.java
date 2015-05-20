// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            NotificationBuilderWithBuilderAccessor, BundleUtil, RemoteInputCompatJellybean

class NotificationCompatJellybean
{

    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    static final String EXTRA_SORT_KEY = "android.support.sortKey";
    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = new Object();
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();

    NotificationCompatJellybean()
    {
    }

    public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor notificationbuilderwithbuilderaccessor, CharSequence charsequence, boolean flag, CharSequence charsequence1, Bitmap bitmap, Bitmap bitmap1, boolean flag1)
    {
        notificationbuilderwithbuilderaccessor = (new android.app.Notification.BigPictureStyle(notificationbuilderwithbuilderaccessor.getBuilder())).setBigContentTitle(charsequence).bigPicture(bitmap);
        if (flag1)
        {
            notificationbuilderwithbuilderaccessor.bigLargeIcon(bitmap1);
        }
        if (flag)
        {
            notificationbuilderwithbuilderaccessor.setSummaryText(charsequence1);
        }
    }

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor notificationbuilderwithbuilderaccessor, CharSequence charsequence, boolean flag, CharSequence charsequence1, CharSequence charsequence2)
    {
        notificationbuilderwithbuilderaccessor = (new android.app.Notification.BigTextStyle(notificationbuilderwithbuilderaccessor.getBuilder())).setBigContentTitle(charsequence).bigText(charsequence2);
        if (flag)
        {
            notificationbuilderwithbuilderaccessor.setSummaryText(charsequence1);
        }
    }

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor notificationbuilderwithbuilderaccessor, CharSequence charsequence, boolean flag, CharSequence charsequence1, ArrayList arraylist)
    {
        notificationbuilderwithbuilderaccessor = (new android.app.Notification.InboxStyle(notificationbuilderwithbuilderaccessor.getBuilder())).setBigContentTitle(charsequence);
        if (flag)
        {
            notificationbuilderwithbuilderaccessor.setSummaryText(charsequence1);
        }
        for (charsequence = arraylist.iterator(); charsequence.hasNext(); notificationbuilderwithbuilderaccessor.addLine((CharSequence)charsequence.next())) { }
    }

    public static SparseArray buildActionExtrasMap(List list)
    {
        SparseArray sparsearray = null;
        int j = list.size();
        for (int i = 0; i < j;)
        {
            Bundle bundle = (Bundle)list.get(i);
            SparseArray sparsearray1 = sparsearray;
            if (bundle != null)
            {
                sparsearray1 = sparsearray;
                if (sparsearray == null)
                {
                    sparsearray1 = new SparseArray();
                }
                sparsearray1.put(i, bundle);
            }
            i++;
            sparsearray = sparsearray1;
        }

        return sparsearray;
    }

    private static boolean ensureActionReflectionReadyLocked()
    {
        if (!sActionsAccessFailed)
        {
            try
            {
                if (sActionsField == null)
                {
                    Object obj = Class.forName("android.app.Notification$Action");
                    sActionClass = ((Class) (obj));
                    sActionIconField = ((Class) (obj)).getDeclaredField("icon");
                    sActionTitleField = sActionClass.getDeclaredField("title");
                    sActionIntentField = sActionClass.getDeclaredField("actionIntent");
                    obj = android/app/Notification.getDeclaredField("actions");
                    sActionsField = ((Field) (obj));
                    ((Field) (obj)).setAccessible(true);
                }
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                Log.e("NotificationCompat", "Unable to access notification actions", classnotfoundexception);
                sActionsAccessFailed = true;
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                Log.e("NotificationCompat", "Unable to access notification actions", nosuchfieldexception);
                sActionsAccessFailed = true;
            }
            if (!sActionsAccessFailed)
            {
                return true;
            }
        }
        return false;
    }

    public static NotificationCompatBase.Action getAction(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory1)
    {
        Object obj = sActionsLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = getActionObjectsLocked(notification)[i];
        notification = getExtras(notification);
        if (notification == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        notification = notification.getSparseParcelableArray("android.support.actionExtras");
        if (notification == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        notification = (Bundle)notification.get(i);
_L1:
        notification = readAction(factory, factory1, sActionIconField.getInt(obj1), (CharSequence)sActionTitleField.get(obj1), (PendingIntent)sActionIntentField.get(obj1), notification);
        obj;
        JVM INSTR monitorexit ;
        return notification;
        notification;
        Log.e("NotificationCompat", "Unable to access notification actions", notification);
        sActionsAccessFailed = true;
        obj;
        JVM INSTR monitorexit ;
        return null;
        notification;
        obj;
        JVM INSTR monitorexit ;
        throw notification;
        notification = null;
          goto _L1
    }

    public static int getActionCount(Notification notification)
    {
        Object obj = sActionsLock;
        obj;
        JVM INSTR monitorenter ;
        notification = ((Notification) (getActionObjectsLocked(notification)));
        if (notification == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        int i = notification.length;
_L1:
        obj;
        JVM INSTR monitorexit ;
        return i;
        notification;
        obj;
        JVM INSTR monitorexit ;
        throw notification;
        i = 0;
          goto _L1
    }

    private static NotificationCompatBase.Action getActionFromBundle(Bundle bundle, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory1)
    {
        return factory.build(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent)bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "remoteInputs"), factory1));
    }

    private static Object[] getActionObjectsLocked(Notification notification)
    {
label0:
        {
            synchronized (sActionsLock)
            {
                if (ensureActionReflectionReadyLocked())
                {
                    break label0;
                }
            }
            return null;
        }
        notification = ((Notification) ((Object[])sActionsField.get(notification)));
        obj;
        JVM INSTR monitorexit ;
        return notification;
        notification;
        obj;
        JVM INSTR monitorexit ;
        throw notification;
        notification;
        Log.e("NotificationCompat", "Unable to access notification actions", notification);
        sActionsAccessFailed = true;
        obj;
        JVM INSTR monitorexit ;
        return null;
    }

    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList arraylist, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory1)
    {
        if (arraylist == null)
        {
            return null;
        }
        NotificationCompatBase.Action aaction[] = factory.newArray(arraylist.size());
        for (int i = 0; i < aaction.length; i++)
        {
            aaction[i] = getActionFromBundle((Bundle)arraylist.get(i), factory, factory1);
        }

        return aaction;
    }

    private static Bundle getBundleForAction(NotificationCompatBase.Action action)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", action.getIcon());
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable("actionIntent", action.getActionIntent());
        bundle.putBundle("extras", action.getExtras());
        bundle.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        return bundle;
    }

    public static Bundle getExtras(Notification notification)
    {
label0:
        {
            synchronized (sExtrasLock)
            {
                if (!sExtrasFieldAccessFailed)
                {
                    break label0;
                }
            }
            return null;
        }
        Object obj;
        if (sExtrasField != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        obj = android/app/Notification.getDeclaredField("extras");
        if (android/os/Bundle.isAssignableFrom(((Field) (obj)).getType()))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
        sExtrasFieldAccessFailed = true;
        obj1;
        JVM INSTR monitorexit ;
        return null;
        ((Field) (obj)).setAccessible(true);
        sExtrasField = ((Field) (obj));
        Bundle bundle = (Bundle)sExtrasField.get(notification);
        obj = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = new Bundle();
        sExtrasField.set(notification, obj);
        obj1;
        JVM INSTR monitorexit ;
        return ((Bundle) (obj));
        notification;
        obj1;
        JVM INSTR monitorexit ;
        throw notification;
        notification;
        Log.e("NotificationCompat", "Unable to access notification extras", notification);
_L1:
        sExtrasFieldAccessFailed = true;
        obj1;
        JVM INSTR monitorexit ;
        return null;
        notification;
        Log.e("NotificationCompat", "Unable to access notification extras", notification);
          goto _L1
    }

    public static String getGroup(Notification notification)
    {
        return getExtras(notification).getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(Notification notification)
    {
        return getExtras(notification).getBoolean("android.support.localOnly");
    }

    public static ArrayList getParcelableArrayListForActions(NotificationCompatBase.Action aaction[])
    {
        if (aaction != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = null;
_L4:
        return arraylist;
_L2:
        ArrayList arraylist1 = new ArrayList(aaction.length);
        int j = aaction.length;
        int i = 0;
        do
        {
            arraylist = arraylist1;
            if (i >= j)
            {
                continue;
            }
            arraylist1.add(getBundleForAction(aaction[i]));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getSortKey(Notification notification)
    {
        return getExtras(notification).getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(Notification notification)
    {
        return getExtras(notification).getBoolean("android.support.isGroupSummary");
    }

    public static NotificationCompatBase.Action readAction(NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory1, int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle)
    {
        RemoteInputCompatBase.RemoteInput aremoteinput[] = null;
        if (bundle != null)
        {
            aremoteinput = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "android.support.remoteInputs"), factory1);
        }
        return factory.build(i, charsequence, pendingintent, bundle, aremoteinput);
    }

    public static Bundle writeActionAndGetExtras(android.app.Notification.Builder builder, NotificationCompatBase.Action action)
    {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        builder = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null)
        {
            builder.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        return builder;
    }

}
