// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.service;

import android.os.AsyncTask;
import com.pinterest.api.PinterestJsonObject;

// Referenced classes of package com.pinterest.service:
//            NotificationService

class <init> extends AsyncTask
{

    final NotificationService this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((PinterestJsonObject[])aobj);
    }

    protected transient Void doInBackground(PinterestJsonObject apinterestjsonobject[])
    {
        NotificationService.access$100(NotificationService.this, apinterestjsonobject[0]);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        stopSelf();
    }

    private ()
    {
        this$0 = NotificationService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
