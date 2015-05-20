// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Acr;


// Referenced classes of package com.gracenote.gnsdk.Acr:
//            IGnAcrDelegate, GnAcrQueryHandle

class a
    implements jni.acr.callbacks_t
{

    final IGnAcrDelegate a;
    final GnAcrQueryHandle b;

    (GnAcrQueryHandle gnacrqueryhandle, IGnAcrDelegate ignacrdelegate)
    {
        b = gnacrqueryhandle;
        a = ignacrdelegate;
        super();
    }
}
