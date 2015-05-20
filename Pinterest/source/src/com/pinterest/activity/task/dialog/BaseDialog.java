// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.Colors;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.notify.DialogTitleView;
import com.pinterest.ui.progress.SmallLoadingView;

public class BaseDialog extends DialogFragment
{

    private Bundle _bundle;
    private int _contentPadding;
    protected View _customView;
    private final int _defaultPadding = (int)Resources.dimension(0x7f0a0098);
    private boolean _forceFullWidthOnTablet;
    private boolean _hidePrevious;
    protected String _key;
    private android.widget.AdapterView.OnItemClickListener _listOnItemClick;
    private ListAdapter _listViewAdapter;
    protected AdapterFooterView _listViewFooter;
    protected Spanned _message;
    private Navigation _navigation;
    private android.view.View.OnClickListener _negButtonListener;
    private String _negButtonText;
    private OnDismissListener _onDismissListener;
    private android.view.View.OnClickListener _posButtonListener;
    private String _posButtonText;
    protected CharSequence _subTitle;
    protected CharSequence _text;
    protected CharSequence _title;
    private View barDivider;
    private View buttonDivider;
    protected FrameLayout container;
    private View content;
    private DialogTitleView headerVw;
    protected Button negativeBt;
    protected Button positiveBt;

    public BaseDialog()
    {
        _key = "task_dialog";
        _hidePrevious = true;
        _forceFullWidthOnTablet = false;
    }

    private void updateCustomView()
    {
        if (container != null)
        {
            container.removeAllViews();
            container.setPadding(_contentPadding, _contentPadding, _contentPadding, _contentPadding);
            if (_customView.getParent() == null)
            {
                container.addView(_customView);
                return;
            }
        }
    }

    private void updateListView()
    {
        if (container == null)
        {
            return;
        } else
        {
            container.removeAllViews();
            int i = (int)Resources.dimension(0x7f0a0105);
            SmallLoadingView smallloadingview = new SmallLoadingView(container.getContext());
            Object obj = new android.widget.FrameLayout.LayoutParams(i, i);
            obj.gravity = 17;
            ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(i, i, i, i);
            smallloadingview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            _listViewFooter = new AdapterFooterView(container.getContext());
            _listViewFooter.setState(2);
            _listViewFooter.setShadowVisibility(8);
            _listViewFooter.setBackgroundColor(Resources.color(0x106000d));
            obj = (ListView)LayoutInflater.from(container.getContext()).inflate(0x7f03012d, container, false);
            ((ListView) (obj)).addFooterView(_listViewFooter, null, false);
            ((ListView) (obj)).setDividerHeight(0);
            ((ListView) (obj)).setEmptyView(smallloadingview);
            ((ListView) (obj)).setAdapter(_listViewAdapter);
            ((ListView) (obj)).setOnItemClickListener(_listOnItemClick);
            setContent(((View) (obj)), 0);
            container.addView(smallloadingview);
            return;
        }
    }

    private void updateMessage()
    {
        if (container == null)
        {
            return;
        } else
        {
            TextView textview = new TextView(content.getContext(), null, 0x7f0f013c);
            textview.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
            textview.setLineSpacing(0.0F, 1.3F);
            textview.setText(_message);
            textview.setTextColor(Colors.TEXT_DARK);
            setContent(textview, _defaultPadding);
            return;
        }
    }

    private void updateNegativeButton()
    {
        if (negativeBt == null || positiveBt == null)
        {
            return;
        }
        if (ModelHelper.isValid(_negButtonText))
        {
            negativeBt.setText(_negButtonText);
            negativeBt.setOnClickListener(new _cls1());
            negativeBt.setVisibility(0);
            if (positiveBt.getVisibility() == 0)
            {
                buttonDivider.setVisibility(0);
            }
        } else
        {
            negativeBt.setVisibility(8);
            buttonDivider.setVisibility(8);
        }
        if (positiveBt.getVisibility() == 0 || negativeBt.getVisibility() == 0)
        {
            barDivider.setVisibility(0);
            return;
        } else
        {
            barDivider.setVisibility(8);
            return;
        }
    }

    private void updatePositiveButton()
    {
        if (positiveBt == null || negativeBt == null)
        {
            return;
        }
        if (ModelHelper.isValid(_posButtonText))
        {
            positiveBt.setText(_posButtonText);
            positiveBt.setOnClickListener(new _cls2());
            positiveBt.setVisibility(0);
            if (negativeBt.getVisibility() == 0)
            {
                buttonDivider.setVisibility(0);
            }
        } else
        {
            positiveBt.setVisibility(8);
            buttonDivider.setVisibility(8);
        }
        if (positiveBt.getVisibility() == 0 || negativeBt.getVisibility() == 0)
        {
            barDivider.setVisibility(0);
            return;
        } else
        {
            barDivider.setVisibility(8);
            return;
        }
    }

    private void updateSubTitle()
    {
        if (headerVw == null)
        {
            return;
        }
        if (!TextUtils.isEmpty(_subTitle))
        {
            headerVw.subTitleTv.setText(_subTitle.toString());
            headerVw.subTitleTv.setVisibility(0);
            return;
        } else
        {
            headerVw.subTitleTv.setVisibility(8);
            return;
        }
    }

    private void updateTask()
    {
        if (container == null)
        {
            return;
        }
        container.removeAllViews();
        container.setPadding(0, 0, 0, 0);
        try
        {
            BaseFragment basefragment = (BaseFragment)_navigation.getFragmentClass().newInstance();
            basefragment.setNavigation(_navigation);
            FragmentTransaction fragmenttransaction = getChildFragmentManager().beginTransaction();
            fragmenttransaction.add(container.getId(), basefragment);
            fragmenttransaction.commit();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void updateTitle()
    {
        if (headerVw == null)
        {
            return;
        }
        if (!TextUtils.isEmpty(_title))
        {
            headerVw.titleTv.setText(_title.toString());
            headerVw.setVisibility(0);
            return;
        } else
        {
            headerVw.setVisibility(8);
            return;
        }
    }

    private void updateTitleText()
    {
        if (headerVw == null)
        {
            return;
        }
        if (!TextUtils.isEmpty(_text))
        {
            headerVw.textTv.setText(_text.toString());
            headerVw.textTv.setVisibility(0);
            return;
        } else
        {
            headerVw.textTv.setVisibility(8);
            return;
        }
    }

    public View findViewById(int i)
    {
        if (content == null)
        {
            return null;
        } else
        {
            return container.findViewById(i);
        }
    }

    public Bundle getBundle()
    {
        return _bundle;
    }

    protected Context getContext()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            return fragmentactivity;
        }
        if (container != null)
        {
            return container.getContext();
        } else
        {
            return null;
        }
    }

    public boolean getHidePrevious()
    {
        return _hidePrevious;
    }

    public String getKey()
    {
        return _key;
    }

    public Navigation getNavigation()
    {
        return _navigation;
    }

    public void make(Context context)
    {
        make(LayoutInflater.from(context));
    }

    public void make(LayoutInflater layoutinflater)
    {
        content = layoutinflater.inflate(0x7f030053, null);
        headerVw = (DialogTitleView)content.findViewById(0x7f0b00dd);
        container = (FrameLayout)content.findViewById(0x7f0b00de);
        barDivider = content.findViewById(0x7f0b00df);
        buttonDivider = content.findViewById(0x7f0b00e2);
        positiveBt = (Button)content.findViewById(0x7f0b00e3);
        negativeBt = (Button)content.findViewById(0x7f0b00e1);
        updateTitle();
        updateSubTitle();
        updateTitleText();
        if (_navigation == null) goto _L2; else goto _L1
_L1:
        updateTask();
_L4:
        updatePositiveButton();
        updateNegativeButton();
        return;
_L2:
        if (_message != null)
        {
            updateMessage();
        } else
        if (_customView != null)
        {
            updateCustomView();
        } else
        if (_listViewAdapter != null)
        {
            updateListView();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(2, 0x7f0f00c3);
        setCancelable(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        make(layoutinflater);
        return content;
    }

    public void onDestroyView()
    {
        content = null;
        headerVw = null;
        container = null;
        barDivider = null;
        buttonDivider = null;
        positiveBt = null;
        negativeBt = null;
        super.onDestroyView();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (_onDismissListener != null)
        {
            _onDismissListener.onDismiss(this);
        }
    }

    public void onStart()
    {
        super.onStart();
        if (Device.isTablet() && !_forceFullWidthOnTablet)
        {
            android.view.WindowManager.LayoutParams layoutparams = getDialog().getWindow().getAttributes();
            layoutparams.width = (int)Resources.dimension(0x7f0a006f);
            getDialog().getWindow().setAttributes(layoutparams);
        }
    }

    public void setBundle(Bundle bundle)
    {
        _bundle = bundle;
    }

    protected void setContent(View view)
    {
        setContent(view, _defaultPadding);
    }

    protected void setContent(View view, int i)
    {
        setContent(view, i, -1, -2);
    }

    protected void setContent(View view, int i, int j, int k)
    {
        _customView = view;
        _customView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(j, k));
        _contentPadding = i;
        updateCustomView();
    }

    public void setForceFullWidthOnTablet(boolean flag)
    {
        _forceFullWidthOnTablet = flag;
    }

    public void setHidePrevious(boolean flag)
    {
        _hidePrevious = flag;
    }

    public void setKey(String s)
    {
        _key = s;
    }

    public void setListViewOptions(ListAdapter listadapter, android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        _listViewAdapter = listadapter;
        _listOnItemClick = onitemclicklistener;
        updateListView();
    }

    public void setMessage(int i)
    {
        setMessage(Resources.string(i));
    }

    public void setMessage(Spanned spanned)
    {
        _message = spanned;
        updateMessage();
    }

    public void setMessage(String s)
    {
        setMessage(Html.fromHtml(s));
    }

    public void setMessageSize(float f)
    {
        if (container != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        j = container.getChildCount();
        i = 0;
_L5:
        Object obj;
        if (i > j)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = container.getChildAt(i);
        if (!(obj instanceof TextView)) goto _L4; else goto _L3
_L3:
        obj = (TextView)obj;
_L6:
        if (obj != null)
        {
            ((TextView) (obj)).setTextSize(f);
            return;
        }
          goto _L1
_L4:
        i++;
          goto _L5
        obj = null;
          goto _L6
    }

    public void setNavigation(Navigation navigation)
    {
        _navigation = navigation;
        updateTask();
    }

    public void setNegativeButton(int i, android.view.View.OnClickListener onclicklistener)
    {
        setNegativeButton(Resources.string(i), onclicklistener);
    }

    public void setNegativeButton(String s, android.view.View.OnClickListener onclicklistener)
    {
        _negButtonText = s;
        _negButtonListener = onclicklistener;
        updateNegativeButton();
    }

    public void setOnDismissListener(OnDismissListener ondismisslistener)
    {
        _onDismissListener = ondismisslistener;
    }

    public void setPositiveButton(int i, android.view.View.OnClickListener onclicklistener)
    {
        setPositiveButton(Resources.string(i), onclicklistener);
    }

    public void setPositiveButton(String s, android.view.View.OnClickListener onclicklistener)
    {
        _posButtonText = s;
        _posButtonListener = onclicklistener;
        updatePositiveButton();
    }

    public void setSubTitle(int i)
    {
        setSubTitle(((CharSequence) (Resources.string(i))));
    }

    public void setSubTitle(CharSequence charsequence)
    {
        _subTitle = charsequence;
        updateSubTitle();
    }

    public void setTitle(int i)
    {
        setTitle(((CharSequence) (Resources.string(i))));
    }

    public void setTitle(CharSequence charsequence)
    {
        _title = charsequence;
        updateTitle();
    }

    public void setTitleText(int i)
    {
        setTitleText(((CharSequence) (Resources.string(i))));
    }

    public void setTitleText(CharSequence charsequence)
    {
        _text = charsequence;
        updateTitleText();
    }



    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BaseDialog this$0;

        public void onClick(View view)
        {
            if (_negButtonListener != null)
            {
                _negButtonListener.onClick(view);
                return;
            } else
            {
                dismiss();
                return;
            }
        }

        _cls1()
        {
            this$0 = BaseDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final BaseDialog this$0;

        public void onClick(View view)
        {
            if (_posButtonListener != null)
            {
                _posButtonListener.onClick(view);
                return;
            } else
            {
                dismiss();
                return;
            }
        }

        _cls2()
        {
            this$0 = BaseDialog.this;
            super();
        }
    }


    private class OnDismissListener
    {

        public abstract void onDismiss(BaseDialog basedialog);
    }

}
