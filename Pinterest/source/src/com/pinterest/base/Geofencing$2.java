// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.pinterest.base:
//            Geofencing

class this._cls0
    implements com.google.android.gms.common.api.nt.OnConnectionFailedListener
{

    final Geofencing this$0;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        (new StringBuilder("Failed to connect to LocationClient with error ")).append(connectionresult.toString());
    }

    nnectionResult()
    {
        this$0 = Geofencing.this;
        super();
    }
}
