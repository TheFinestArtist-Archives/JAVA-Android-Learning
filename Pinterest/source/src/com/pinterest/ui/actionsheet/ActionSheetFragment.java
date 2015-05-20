// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.actionsheet;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Colors;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.FontUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.pinterest.ui.actionsheet:
//            ActionSheetItemView

public class ActionSheetFragment extends BaseFragment
{

    private static final int SLIDE_UP_DURATION = 250;
    private ActionSheetItem _footerItem;
    private ActionSheetItem _headerItem;
    private List _items;
    LinearLayout _sheetContainer;

    public ActionSheetFragment()
    {
        _items = new LinkedList();
    }

    private ActionSheetItemView createItem(ActionSheetItem actionsheetitem)
    {
        ActionSheetItemView actionsheetitemview = new ActionSheetItemView(getActivity());
        actionsheetitemview.setText(actionsheetitem.text);
        actionsheetitemview.setOnClickListener(actionsheetitem.onClickListener);
        return actionsheetitemview;
    }

    private void init()
    {
        if (_headerItem != null)
        {
            _sheetContainer.addView(createHeader(_headerItem));
        }
        ActionSheetItem actionsheetitem;
        for (Iterator iterator = _items.iterator(); iterator.hasNext(); _sheetContainer.addView(createItem(actionsheetitem)))
        {
            actionsheetitem = (ActionSheetItem)iterator.next();
        }

        if (_footerItem != null)
        {
            _sheetContainer.addView(createFooter(_footerItem));
        }
        float f = Math.max(Device.getScreenWidth(), Device.getScreenHeight());
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(_sheetContainer, "translationY", new float[] {
            f, 0.0F
        });
        objectanimator.setDuration(250L);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.start();
    }

    public void addFooter(String s)
    {
        addFooter(s, null);
    }

    public void addFooter(String s, android.view.View.OnClickListener onclicklistener)
    {
        _footerItem = new ActionSheetItem(s, onclicklistener);
    }

    public void addHeader(String s)
    {
        addHeader(s, null);
    }

    public void addHeader(String s, android.view.View.OnClickListener onclicklistener)
    {
        _headerItem = new ActionSheetItem(s, onclicklistener);
    }

    public void addItem(String s, android.view.View.OnClickListener onclicklistener)
    {
        _items.add(new ActionSheetItem(s, onclicklistener));
    }

    public void clear()
    {
        _headerItem = null;
        _footerItem = null;
        _items.clear();
    }

    public ActionSheetItemView createFooter(ActionSheetItem actionsheetitem)
    {
        actionsheetitem = createItem(actionsheetitem);
        TextView textview = ((ActionSheetItemView) (actionsheetitem))._tv;
        textview.setTextSize(0, Resources.dimension(0x7f0a00f6));
        textview.setSingleLine(false);
        textview.setTextColor(Colors.TEXT_LIGHT);
        FontUtils.setFont(com.pinterest.kit.utils.FontUtils.TypefaceId.LIGHT, textview);
        actionsheetitem.showDivider(false);
        return actionsheetitem;
    }

    public ActionSheetItemView createHeader(ActionSheetItem actionsheetitem)
    {
        actionsheetitem = createItem(actionsheetitem);
        ((ActionSheetItemView) (actionsheetitem))._tv.setTextSize(0, Resources.dimension(0x7f0a00fb));
        return actionsheetitem;
    }

    public void dismiss()
    {
        getActivity().onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03006d;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        init();
    }

    public void show()
    {
        Events.post(new ActionSheetEvent());
    }

    private class ActionSheetItem
    {

        public android.view.View.OnClickListener onClickListener;
        public String text;
        final ActionSheetFragment this$0;

        public ActionSheetItem(String s, android.view.View.OnClickListener onclicklistener)
        {
            this$0 = ActionSheetFragment.this;
            super();
            text = s;
            onClickListener = onclicklistener;
        }
    }


    private class ActionSheetEvent
    {

        private ActionSheetFragment _fragment;

        public ActionSheetFragment getFragment()
        {
            return _fragment;
        }

        public ActionSheetEvent()
        {
            _fragment = ActionSheetFragment.this;
        }
    }

}
