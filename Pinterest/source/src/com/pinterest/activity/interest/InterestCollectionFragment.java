// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.interest;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.InterestsApi;

// Referenced classes of package com.pinterest.activity.interest:
//            InterestsFragment

public class InterestCollectionFragment extends InterestsFragment
{

    private String _collectionId;
    private String _collectionImage;
    private String _collectionName;

    public InterestCollectionFragment()
    {
        _layoutId = 0x7f03008b;
    }

    protected void loadData()
    {
        if (_collectionId != null)
        {
            InterestsApi.a(_collectionId, new com.pinterest.api.remote.InterestsApi.InterestsFeedApiResponse(gridResponseHandler), getApiTag());
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _actionBar.setTitle(_collectionName);
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        try
        {
            navigation = new PinterestJsonObject(navigation.getStringParcelable("collection"));
            _collectionName = navigation.a("text", "");
            _collectionId = navigation.a("id", "");
            _collectionImage = navigation.c("images").a("320x149", "");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Navigation navigation)
        {
            return;
        }
    }
}
