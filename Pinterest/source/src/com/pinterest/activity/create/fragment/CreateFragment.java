// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.TextView;
import com.pinterest.activity.create.helper.CreateImageHelper;
import com.pinterest.activity.create.model.PinnableImage;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.ApiClientHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.utils.ImageUtils;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            CreateBaseFragment

public class CreateFragment extends CreateBaseFragment
{

    public CreateFragment()
    {
    }

    public int getTitleId()
    {
        return 0x7f0e014e;
    }

    public void onResume()
    {
        String s;
        String s1;
        Bundle bundle;
label0:
        {
            super.onResume();
            Intent intent = getActivity().getIntent();
            bundle = intent.getExtras();
            s = null;
            if (bundle != null)
            {
                s = bundle.getString("com.pinterest.EXTRA_SOURCE");
                intent.removeExtra("com.pinterest.EXTRA_SOURCE");
            }
            if (s != null)
            {
                if (!s.equalsIgnoreCase("com.pinterest.EXTRA_SOURCE_PLACE"))
                {
                    break label0;
                }
                _pinnableImage = new PinnableImage();
                _pinnableImage.setPlaceUid(intent.getStringExtra("com.pinterest.EXTRA_PLACE_ID"));
                _pinnableImage.setImageUrl(intent.getStringExtra("com.pinterest.EXTRA_IMAGE"));
                descriptionEt.setHint(0x7f0e0395);
                setPinnableImage(_pinnableImage);
            }
            return;
        }
        Application.context().getPackageManager();
        s1 = bundle.getString("com.pinterest.EXTRA_SOURCE_PACKAGE");
        if (!s.equalsIgnoreCase("com.pinterest.EXTRA_SOURCE_GALLERY")) goto _L2; else goto _L1
_L1:
        CreateImageHelper.showGallery(getActivity(), s1);
_L4:
        updateFromIntent();
        return;
_L2:
        if (s.equalsIgnoreCase("com.pinterest.EXTRA_SOURCE_CAMERA"))
        {
            CreateImageHelper.showCamera(getActivity(), s1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void pin()
    {
label0:
        {
            {
                com.pinterest.api.remote.PinApi.PinSubmitParams pinsubmitparams = getPinSubmitParams();
                if (imageUri == null)
                {
                    break label0;
                }
                com.pinterest.activity.task.model.Navigation.Remove remove;
                try
                {
                    pinsubmitparams.g = ImageUtils.scaleImageFromUri(getActivity(), imageUri, 720, 720);
                }
                catch (Exception exception) { }
                pinsubmitparams.k = getActivity().getIntent().getStringExtra("com.pinterest.EXTRA_PLACE_ID");
                if (StringUtils.isBlank(pinsubmitparams.k) && locationTv != null)
                {
                    pinsubmitparams.k = (String)locationTv.getTag();
                }
            }
            if (pinsubmitparams != null)
            {
                MyUser.addLastUsedBoard(pinsubmitparams.a);
                ApiClientHelper.a(pinsubmitparams, getActivity());
                if (pinsubmitparams.k != null)
                {
                    remove = new com.pinterest.activity.task.model.Navigation.Remove();
                    remove.add(new Navigation(Location.PLACE_PICKER));
                    remove.add(new Navigation(Location.PLACE_IMAGE_PICKER, pinsubmitparams.k));
                    Events.post(remove);
                }
            }
            return;
        }
        if (_pinnableImage != null && _pinnableImage.getImageUrl() != null)
        {
            if (_pinnableImage.getSourceUrl() != null && StringUtils.isBlank(_pinnableImage.getPlaceUid()))
            {
                pinsubmitparams.c = _pinnableImage.getSourceUrl();
            }
            pinsubmitparams.d = _pinnableImage.getImageUrl();
            if (_pinnableImage.getPlaceUid() != null)
            {
                pinsubmitparams.k = _pinnableImage.getPlaceUid();
            }
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_80;
        }
    }
}
