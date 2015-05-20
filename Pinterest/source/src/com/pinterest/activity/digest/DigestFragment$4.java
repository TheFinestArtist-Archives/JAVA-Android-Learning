// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.view.View;
import com.pinterest.activity.digest.ui.DigestHeaderView;
import com.pinterest.api.model.DigestItem;
import com.pinterest.base.Constants;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class ner extends com.pinterest.ui.scrollview.iew.ScrollViewListener
{

    final DigestFragment this$0;

    public void onScroll(View view, int i, int j, int k, int l)
    {
        if (_headerView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        DigestFragment.access$600(DigestFragment.this);
        i = (int)((float)(int)_headerView.getY() + (float)(l - j) * DigestFragment.access$700(DigestFragment.this));
        if (j >= l)
        {
            continue; /* Loop/switch isn't completed */
        }
        _headerView.setTranslationY(Math.min(i, Constants.ACTIONBAR_HEIGHT));
        if (j < ((gestHeader)DigestFragment.access$800(DigestFragment.this).get(_headerView.getItem().getUid())).height.intValue())
        {
            view = DigestFragment.access$900(DigestFragment.this, _headerView.getItem().getUid());
            if (StringUtils.isNotEmpty(view))
            {
                _headerView.setDigestPin(((gestHeader)DigestFragment.access$800(DigestFragment.this).get(view)).item);
                _headerView.setTranslationY(Constants.ACTIONBAR_HEIGHT - DigestFragment.access$1000());
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (j <= l) goto _L1; else goto _L3
_L3:
        _headerView.setTranslationY(Math.max(0, i));
        view = DigestFragment.access$1100(DigestFragment.this, _headerView.getItem().getUid());
        if (StringUtils.isNotEmpty(view) && DigestFragment.access$800(DigestFragment.this).containsKey(view))
        {
            k = ((gestHeader)DigestFragment.access$800(DigestFragment.this).get(view)).height.intValue();
            if (k != 0 && j >= k + (Constants.ACTIONBAR_HEIGHT - DigestFragment.access$1000()))
            {
                _headerView.setTranslationY(i);
                if (i <= -DigestFragment.access$1000())
                {
                    _headerView.setDigestPin(((gestHeader)DigestFragment.access$800(DigestFragment.this).get(view)).item);
                    _headerView.setTranslationY(0.0F);
                    return;
                }
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    gestHeader()
    {
        this$0 = DigestFragment.this;
        super();
    }
}
