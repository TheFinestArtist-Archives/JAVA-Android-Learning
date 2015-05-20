// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

final class FastCursor
    implements Cursor
{

    private final int count;
    private int position;
    private final CursorWindow window;

    FastCursor(CursorWindow cursorwindow)
    {
        window = cursorwindow;
        count = cursorwindow.getNumRows();
    }

    public final void close()
    {
        throw new UnsupportedOperationException();
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer)
    {
        throw new UnsupportedOperationException();
    }

    public final void deactivate()
    {
        throw new UnsupportedOperationException();
    }

    public final byte[] getBlob(int i)
    {
        return window.getBlob(position, i);
    }

    public final int getColumnCount()
    {
        throw new UnsupportedOperationException();
    }

    public final int getColumnIndex(String s)
    {
        throw new UnsupportedOperationException();
    }

    public final int getColumnIndexOrThrow(String s)
    {
        throw new UnsupportedOperationException();
    }

    public final String getColumnName(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final String[] getColumnNames()
    {
        throw new UnsupportedOperationException();
    }

    public final int getCount()
    {
        return window.getNumRows();
    }

    public final double getDouble(int i)
    {
        return window.getDouble(position, i);
    }

    public final Bundle getExtras()
    {
        throw new UnsupportedOperationException();
    }

    public final float getFloat(int i)
    {
        return window.getFloat(position, i);
    }

    public final int getInt(int i)
    {
        return window.getInt(position, i);
    }

    public final long getLong(int i)
    {
        return window.getLong(position, i);
    }

    public final int getPosition()
    {
        return position;
    }

    public final short getShort(int i)
    {
        return window.getShort(position, i);
    }

    public final String getString(int i)
    {
        return window.getString(position, i);
    }

    public final int getType(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean getWantsAllOnMoveCalls()
    {
        throw new UnsupportedOperationException();
    }

    public final boolean isAfterLast()
    {
        throw new UnsupportedOperationException();
    }

    public final boolean isBeforeFirst()
    {
        throw new UnsupportedOperationException();
    }

    public final boolean isClosed()
    {
        throw new UnsupportedOperationException();
    }

    public final boolean isFirst()
    {
        return position == 0;
    }

    public final boolean isLast()
    {
        return position == count - 1;
    }

    public final boolean isNull(int i)
    {
        return window.isNull(position, i);
    }

    public final boolean move(int i)
    {
        return moveToPosition(position + i);
    }

    public final boolean moveToFirst()
    {
        boolean flag = false;
        position = 0;
        if (count > 0)
        {
            flag = true;
        }
        return flag;
    }

    public final boolean moveToLast()
    {
        if (count > 0)
        {
            position = count - 1;
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean moveToNext()
    {
        if (position < count - 1)
        {
            position = position + 1;
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean moveToPosition(int i)
    {
        if (i >= 0 && i < count)
        {
            position = i;
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean moveToPrevious()
    {
        if (position > 0)
        {
            position = position - 1;
            return true;
        } else
        {
            return false;
        }
    }

    public final void registerContentObserver(ContentObserver contentobserver)
    {
        throw new UnsupportedOperationException();
    }

    public final void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean requery()
    {
        throw new UnsupportedOperationException();
    }

    public final Bundle respond(Bundle bundle)
    {
        throw new UnsupportedOperationException();
    }

    public final void setNotificationUri(ContentResolver contentresolver, Uri uri)
    {
        throw new UnsupportedOperationException();
    }

    public final void unregisterContentObserver(ContentObserver contentobserver)
    {
        throw new UnsupportedOperationException();
    }

    public final void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        throw new UnsupportedOperationException();
    }
}
