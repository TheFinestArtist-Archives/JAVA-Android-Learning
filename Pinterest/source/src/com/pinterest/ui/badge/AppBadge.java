// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.badge;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.pinterest.base.CrashReporting;
import java.io.ByteArrayOutputStream;
import java.util.List;

// Referenced classes of package com.pinterest.ui.badge:
//            AppBadgeUtils

public final class AppBadge
    implements Parcelable
{

    private static final String BADGE_SELECTION = "package=?";
    private static final int CONTENT_BADGE_COUNT_COLUMN = 3;
    private static final int CONTENT_CLASS_COLUMN = 2;
    private static final int CONTENT_ICON_COLUMN = 4;
    private static final int CONTENT_ID_COLUMN = 0;
    private static final int CONTENT_PACKAGE_COLUMN = 1;
    private static final String CONTENT_PROJECTION[] = {
        "_id", "package", "class", "badgecount", "icon"
    };
    private static final Uri CONTENT_URI = Uri.parse("content://com.sec.badge/apps");
    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public int badgeCount;
    public Uri baseUri;
    public String className;
    public byte icon[];
    public String packageName;
    public long uid;

    public AppBadge()
    {
        baseUri = CONTENT_URI;
    }

    public AppBadge(Parcel parcel)
    {
        baseUri = CONTENT_URI;
        uid = parcel.readLong();
        packageName = parcel.readString();
        className = parcel.readString();
        badgeCount = parcel.readInt();
        icon = parcel.createByteArray();
    }

    public static boolean deleteAllBadges(Context context)
    {
        if (!isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        }
        return context.getContentResolver().delete(CONTENT_URI, "package=?", new String[] {
            context.getPackageName()
        }) > 0;
    }

    public static AppBadge[] getAllBadges(Context context)
    {
        if (!isBadgingSupported(context))
        {
            return null;
        }
        context = context.getContentResolver().query(CONTENT_URI, CONTENT_PROJECTION, null, null, null);
        boolean flag = context.moveToFirst();
        if (!flag)
        {
            context.close();
            return null;
        }
        Object obj;
        obj = new AppBadge[context.getCount()];
        context.moveToPosition(-1);
        while (context.moveToNext()) 
        {
            AppBadge appbadge = new AppBadge();
            appbadge.restore(context);
            obj[context.getPosition()] = appbadge;
        }
        break MISSING_BLOCK_LABEL_106;
        obj;
        context.close();
        throw obj;
        context.close();
        return ((AppBadge []) (obj));
    }

    public static AppBadge getBadge(Context context)
    {
        if (isBadgingSupported(context)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((context = context.getContentResolver().query(CONTENT_URI, CONTENT_PROJECTION, "package=?", new String[] {
            context.getPackageName()
        }, null)) == null) goto _L1; else goto _L3
_L3:
        boolean flag = context.moveToFirst();
        if (!flag)
        {
            context.close();
            return null;
        }
        AppBadge appbadge;
        appbadge = new AppBadge();
        appbadge.restore(context);
        context.close();
        return appbadge;
        Object obj;
        obj;
        CrashReporting.logHandledException(((Throwable) (obj)));
        context.close();
        return null;
        obj;
        context.close();
        throw obj;
    }

    public static boolean isBadgingSupported(Context context)
    {
        int i = AppBadgeUtils.isBadgingSupported();
        if (i == -1)
        {
            try
            {
                context = context.getContentResolver().query(CONTENT_URI, null, null, null, null);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                CrashReporting.logHandledException(context);
                context = null;
            }
            if (context == null)
            {
                AppBadgeUtils.setBadgingSupported(false);
                return false;
            } else
            {
                context.close();
                return true;
            }
        }
        return i == 1;
    }

    private boolean isSaved()
    {
        return uid > 0L;
    }

    private void restore(Cursor cursor)
    {
        uid = cursor.getLong(0);
        packageName = cursor.getString(1);
        className = cursor.getString(2);
        badgeCount = cursor.getInt(3);
        icon = cursor.getBlob(4);
    }

    private ContentValues toContentValues()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("package", packageName);
        contentvalues.put("class", className);
        contentvalues.put("badgecount", Integer.valueOf(badgeCount));
        contentvalues.put("icon", icon);
        return contentvalues;
    }

    public final boolean delete(Context context)
    {
        if (!isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        }
        Uri uri = ContentUris.withAppendedId(baseUri, uid);
        return context.getContentResolver().delete(uri, null, null) > 0;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof AppBadge))
            {
                return false;
            }
            obj = (AppBadge)obj;
            if (uid != ((AppBadge) (obj)).uid)
            {
                return false;
            }
            if (!TextUtils.equals(packageName, ((AppBadge) (obj)).packageName))
            {
                return false;
            }
            if (!TextUtils.equals(className, ((AppBadge) (obj)).className))
            {
                return false;
            }
            if (badgeCount != ((AppBadge) (obj)).badgeCount)
            {
                return false;
            }
            if (icon != ((AppBadge) (obj)).icon)
            {
                return false;
            }
        }
        return true;
    }

    public final Bitmap getIcon()
    {
        if (icon == null || icon.length == 0)
        {
            return null;
        } else
        {
            return BitmapFactory.decodeByteArray(icon, 0, icon.length);
        }
    }

    public final int hashCode()
    {
        int k = 0;
        int l = (int)(uid ^ uid >>> 32);
        int i;
        int j;
        int i1;
        if (packageName == null)
        {
            i = 0;
        } else
        {
            i = packageName.hashCode();
        }
        if (className == null)
        {
            j = 0;
        } else
        {
            j = className.hashCode();
        }
        i1 = badgeCount;
        if (icon != null)
        {
            k = icon.hashCode();
        }
        return ((j + (i + (l + 527) * 31) * 31) * 31 + i1) * 31 + k;
    }

    public final Uri save(Context context)
    {
        if (isSaved() || !isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        }
        context = context.getContentResolver().insert(baseUri, toContentValues());
        if (context != null)
        {
            List list = context.getPathSegments();
            if (list != null)
            {
                uid = Long.parseLong((String)list.get(1));
            }
        }
        return context;
    }

    public final void setIcon(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
            icon = bytearrayoutputstream.toByteArray();
            return;
        }
    }

    public final void setIcon(Drawable drawable)
    {
        if (drawable == null)
        {
            return;
        } else
        {
            setIcon(((BitmapDrawable)drawable).getBitmap());
            return;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("_id: ")).append(String.valueOf(uid)).append(", package: ").append(String.valueOf(packageName)).append(", class: ").append(String.valueOf(className)).append(", badgecount: ").append(String.valueOf(badgeCount)).append(", hasIcon: ");
        String s;
        if (icon != null)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        return stringbuilder.append(s).toString();
    }

    public final boolean update(Context context)
    {
        Uri uri;
        if (isSaved() && isBadgingSupported(context))
        {
            if (context.getContentResolver().update(uri = ContentUris.withAppendedId(baseUri, uid), toContentValues(), null, null) > 0)
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(uid);
        parcel.writeString(packageName);
        parcel.writeString(className);
        parcel.writeInt(badgeCount);
        parcel.writeByteArray(icon);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final AppBadge createFromParcel(Parcel parcel)
        {
            return new AppBadge(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final AppBadge[] newArray(int i)
        {
            return new AppBadge[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
