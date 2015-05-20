// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v4.media:
//            MediaMetadataCompatApi21, RatingCompat

public final class MediaMetadataCompat
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final ArrayMap METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    private static final int METADATA_TYPE_BITMAP = 2;
    private static final int METADATA_TYPE_LONG = 0;
    private static final int METADATA_TYPE_RATING = 3;
    private static final int METADATA_TYPE_TEXT = 1;
    private static final String TAG = "MediaMetadata";
    private final Bundle mBundle;
    private Object mMetadataObj;

    private MediaMetadataCompat(Bundle bundle)
    {
        mBundle = new Bundle(bundle);
    }

    MediaMetadataCompat(Bundle bundle, _cls1 _pcls1)
    {
        this(bundle);
    }

    private MediaMetadataCompat(Parcel parcel)
    {
        mBundle = parcel.readBundle();
    }

    MediaMetadataCompat(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj)
    {
        if (obj == null || android.os.Build.VERSION.SDK_INT < 21)
        {
            return null;
        }
        Object obj1 = new Builder();
label0:
        do
        {
            for (Iterator iterator = MediaMetadataCompatApi21.keySet(obj).iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Integer integer = (Integer)METADATA_KEYS_TYPE.get(s);
                if (integer != null)
                {
                    switch (integer.intValue())
                    {
                    case 0: // '\0'
                        ((Builder) (obj1)).putLong(s, MediaMetadataCompatApi21.getLong(obj, s));
                        break;

                    case 2: // '\002'
                        ((Builder) (obj1)).putBitmap(s, MediaMetadataCompatApi21.getBitmap(obj, s));
                        break;

                    case 3: // '\003'
                        ((Builder) (obj1)).putRating(s, RatingCompat.fromRating(MediaMetadataCompatApi21.getRating(obj, s)));
                        break;

                    case 1: // '\001'
                        ((Builder) (obj1)).putText(s, MediaMetadataCompatApi21.getText(obj, s));
                        break;
                    }
                    continue label0;
                }
            }

            obj1 = ((Builder) (obj1)).build();
            obj1.mMetadataObj = obj;
            return ((MediaMetadataCompat) (obj1));
        } while (true);
    }

    public final boolean containsKey(String s)
    {
        return mBundle.containsKey(s);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Bitmap getBitmap(String s)
    {
        try
        {
            s = (Bitmap)mBundle.getParcelable(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", s);
            return null;
        }
        return s;
    }

    public final long getLong(String s)
    {
        return mBundle.getLong(s, 0L);
    }

    public final Object getMediaMetadata()
    {
        if (mMetadataObj != null || android.os.Build.VERSION.SDK_INT < 21)
        {
            return mMetadataObj;
        }
        Object obj = MediaMetadataCompatApi21.Builder.newInstance();
label0:
        do
        {
            for (Iterator iterator = keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Integer integer = (Integer)METADATA_KEYS_TYPE.get(s);
                if (integer != null)
                {
                    switch (integer.intValue())
                    {
                    case 0: // '\0'
                        MediaMetadataCompatApi21.Builder.putLong(obj, s, getLong(s));
                        break;

                    case 2: // '\002'
                        MediaMetadataCompatApi21.Builder.putBitmap(obj, s, getBitmap(s));
                        break;

                    case 3: // '\003'
                        MediaMetadataCompatApi21.Builder.putRating(obj, s, getRating(s).getRating());
                        break;

                    case 1: // '\001'
                        MediaMetadataCompatApi21.Builder.putText(obj, s, getText(s));
                        break;
                    }
                    continue label0;
                }
            }

            mMetadataObj = MediaMetadataCompatApi21.Builder.build(obj);
            return mMetadataObj;
        } while (true);
    }

    public final RatingCompat getRating(String s)
    {
        try
        {
            s = (RatingCompat)mBundle.getParcelable(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", s);
            return null;
        }
        return s;
    }

    public final String getString(String s)
    {
        s = mBundle.getCharSequence(s);
        if (s != null)
        {
            return s.toString();
        } else
        {
            return null;
        }
    }

    public final CharSequence getText(String s)
    {
        return mBundle.getCharSequence(s);
    }

    public final Set keySet()
    {
        return mBundle.keySet();
    }

    public final int size()
    {
        return mBundle.size();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(mBundle);
    }

    static 
    {
        ArrayMap arraymap = new ArrayMap();
        METADATA_KEYS_TYPE = arraymap;
        arraymap.put("android.media.metadata.TITLE", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
        METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
        METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
    }



    private class Builder
    {

        private final Bundle mBundle;

        public final MediaMetadataCompat build()
        {
            return new MediaMetadataCompat(mBundle, null);
        }

        public final Builder putBitmap(String s, Bitmap bitmap)
        {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)).intValue() != 2)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a Bitmap").toString());
            } else
            {
                mBundle.putParcelable(s, bitmap);
                return this;
            }
        }

        public final Builder putLong(String s, long l)
        {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)).intValue() != 0)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a long").toString());
            } else
            {
                mBundle.putLong(s, l);
                return this;
            }
        }

        public final Builder putRating(String s, RatingCompat ratingcompat)
        {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)).intValue() != 3)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a Rating").toString());
            } else
            {
                mBundle.putParcelable(s, ratingcompat);
                return this;
            }
        }

        public final Builder putString(String s, String s1)
        {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)).intValue() != 1)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a String").toString());
            } else
            {
                mBundle.putCharSequence(s, s1);
                return this;
            }
        }

        public final Builder putText(String s, CharSequence charsequence)
        {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)).intValue() != 1)
            {
                throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a CharSequence").toString());
            } else
            {
                mBundle.putCharSequence(s, charsequence);
                return this;
            }
        }

        public Builder()
        {
            mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat mediametadatacompat)
        {
            mBundle = new Bundle(mediametadatacompat.mBundle);
        }
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final MediaMetadataCompat createFromParcel(Parcel parcel)
        {
            return new MediaMetadataCompat(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final MediaMetadataCompat[] newArray(int i)
        {
            return new MediaMetadataCompat[i];
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
