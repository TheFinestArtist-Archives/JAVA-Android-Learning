// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.MetadataVideo;

import com.gracenote.gnsdk.Metadata.GnMetadataObject;

// Referenced classes of package com.gracenote.gnsdk.MetadataVideo:
//            IGnVideoName

public class GnVideoName extends GnMetadataObject
    implements IGnVideoName
{

    public String getDisplay()
    {
        return a("gnsdk_val_display");
    }

    public String getDisplayLanguage()
    {
        return a("gnsdk_val_displaylang");
    }

    public String getFamily()
    {
        return a("gnsdk_val_family");
    }

    public String getGiven()
    {
        return a("gnsdk_val_given");
    }

    public String getPrefix()
    {
        return a("gnsdk_val_prefix");
    }

    public String getSortable()
    {
        return a("gnsdk_val_name_sortable");
    }
}
