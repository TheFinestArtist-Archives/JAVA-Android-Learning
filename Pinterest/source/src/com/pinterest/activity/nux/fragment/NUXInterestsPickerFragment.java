// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.nux.NUXActivity;
import com.pinterest.activity.nux.adapter.NUXInterestGridAdapter;
import com.pinterest.activity.nux.adapter.NUXNextFragmentListener;
import com.pinterest.activity.nux.view.NUXContinueBar;
import com.pinterest.activity.nux.view.NUXHeaderView;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.experience.ExperienceEnabled;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.experience.NuxDisplayData;
import com.pinterest.experience.NuxStep;
import com.pinterest.fragment.PinterestGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.nux.fragment:
//            NUXSocialPickerFragment, NUXEndScreenFragment

public class NUXInterestsPickerFragment extends PinterestGridFragment
    implements ExperienceEnabled
{

    NUXContinueBar _continueBar;
    NUXHeaderView _header;
    private int _minInterests;
    NUXNextFragmentListener nextFragmentListener;
    private android.widget.AdapterView.OnItemClickListener onItemClick;

    public NUXInterestsPickerFragment()
    {
        _minInterests = 5;
        onItemClick = new _cls1();
        nextFragmentListener = new _cls2();
        _layoutId = 0x7f030096;
        _adapter = new NUXInterestGridAdapter();
        ((NUXInterestGridAdapter)_adapter).setBounceOnTouch(true);
    }

    public void applyExperience()
    {
        Object obj;
        obj = Experiences.a(Experiences.b);
        break MISSING_BLOCK_LABEL_7;
        if (obj != null && (((ExperienceValue) (obj)).f instanceof NuxDisplayData))
        {
            obj = ((NuxDisplayData)((ExperienceValue) (obj)).f).a();
            if (obj != null)
            {
                _header.applyExperience(((NuxStep) (obj)));
                _continueBar.applyExperience(((NuxStep) (obj)));
                if (((NuxStep) (obj)).l > 0)
                {
                    _minInterests = ((NuxStep) (obj)).l;
                    return;
                }
            }
        }
        return;
    }

    public void goToNextFragment()
    {
        if (getActivity() == null)
        {
            return;
        }
        Object obj = NuxDisplayData.c();
        if (obj == null)
        {
            obj = new NUXSocialPickerFragment();
        } else
        {
            obj = ((NuxDisplayData) (obj)).a(((NuxDisplayData) (obj)).a());
            if (obj != null && ((NuxStep) (obj)).b())
            {
                obj = new NUXSocialPickerFragment();
            } else
            {
                obj = new NUXEndScreenFragment();
            }
        }
        FragmentHelper.replaceFragment(getActivity(), ((android.support.v4.app.Fragment) (obj)), false, com.pinterest.activity.FragmentHelper.Animation.SLIDE);
    }

    protected void loadData()
    {
        InterestsApi.a("nux", new com.pinterest.api.remote.InterestsApi.InterestsFeedApiResponse(gridResponseHandler), getApiTag());
    }

    public boolean onBackPressed()
    {
        return false;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroyView()
    {
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onPause()
    {
        if (getActivity() != null)
        {
            ((NUXActivity)getActivity()).setCheckedInterests(((NUXInterestGridAdapter)_adapter).getCheckedInterests());
        }
        super.onPause();
    }

    public void onResume()
    {
        if (getActivity() != null && _adapter != null)
        {
            ((NUXInterestGridAdapter)_adapter).setCheckedInterests(((NUXActivity)getActivity()).getCheckedInterests());
        }
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        AnalyticsApi.b("interest_selector_start");
        _header = new NUXHeaderView(view.getContext());
        _header.setSkipListener(nextFragmentListener);
        _header.setTitle(Resources.string(0x7f0e0327));
        _header.setTitleDesc(Resources.string(0x7f0e0326));
        _header.setSkipTitle(Resources.string(0x7f0e0320));
        _header.setSkipDesc(Resources.string(0x7f0e0322));
        _header.setSkipPosTx(Resources.string(0x7f0e0321));
        _header.setSkipNegTx(Resources.string(0x7f0e048d));
        _continueBar.setContinueListener(nextFragmentListener);
        _gridVw.addHeaderView(_header, -1, -2);
        _gridVw.setOnItemClickListener(onItemClick);
        _gridVw.getFooterView().setPadding(0, 0, 0, (int)Resources.dimension(0x7f0a00a6));
        applyExperience();
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _emptyCenterImage = 0x7f020134;
        _emptyMessage = Resources.string(0x7f0e01ff);
    }














    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final NUXInterestsPickerFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (toggleCheckInterest == null)
            {
                return;
            }
            adapterview = (NUXInterestGridCell)view;
            view = adapterview.getInterest();
            android.support.v4.app.FragmentActivity fragmentactivity;
            if (((NUXInterestGridAdapter)toggleCheckInterest).containsInterest(view))
            {
                ((NUXInterestGridAdapter)toggleCheckInterest).toggleCheckInterest(view);
                if (((NUXInterestGridAdapter)toggleCheckInterest).getCheckedSize() < _minInterests)
                {
                    Events.post(new com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent(-1, com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent.EventType.INTEREST));
                }
            } else
            {
                if (((NUXInterestGridAdapter)toggleCheckInterest).getCheckedSize() < _minInterests)
                {
                    Events.post(new com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent(1, com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent.EventType.INTEREST));
                }
                ((NUXInterestGridAdapter)toggleCheckInterest).toggleCheckInterest(view);
            }
            _continueBar.popInAnimate();
            fragmentactivity = getActivity();
            if (fragmentactivity instanceof NUXActivity)
            {
                ((NUXActivity)fragmentactivity).setProgressVisibility(0);
            }
            ((NUXInterestGridAdapter)toggleCheckInterest).getCheckedSize();
            JVM INSTR tableswitch 1 5: default 172
        //                       1 279
        //                       2 294
        //                       3 309
        //                       4 324
        //                       5 339;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            break; /* Loop/switch isn't completed */
_L6:
            break MISSING_BLOCK_LABEL_339;
_L7:
            if (((NUXInterestGridAdapter)toggleCheckInterest).getCheckedSize() == _minInterests)
            {
                _continueBar.enableButton(true);
            } else
            if (((NUXInterestGridAdapter)toggleCheckInterest).getCheckedSize() < _minInterests)
            {
                _continueBar.enableButton(false);
            }
            adapterview.setChecked(((NUXInterestGridAdapter)toggleCheckInterest).isInterestChecked(view));
            return;
_L2:
            _continueBar.updateText(0x7f0e0334);
              goto _L7
_L3:
            _continueBar.updateText(0x7f0e0335);
              goto _L7
_L4:
            _continueBar.updateText(0x7f0e0336);
              goto _L7
_L5:
            _continueBar.updateText(0x7f0e0337);
              goto _L7
            _continueBar.updateText(0x7f0e0338);
              goto _L7
        }

        _cls1()
        {
            this$0 = NUXInterestsPickerFragment.this;
            super();
        }
    }


    private class _cls2
        implements NUXNextFragmentListener
    {

        final NUXInterestsPickerFragment this$0;

        public void nextFragment()
        {
            ((NUXActivity)getActivity()).submitInterests(((NUXInterestGridAdapter)access$1200).getCheckedInterests());
            goToNextFragment();
        }

        public void skipFragment()
        {
            ((NUXInterestGridAdapter)access$1200).clearInterests();
            for (int i = 0; i < NUXProgressIndicatorView.INTERESTS_STEP; i++)
            {
                Events.post(new com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent(-1, com.pinterest.activity.nux.NUXActivity.NUXProgressChangeEvent.EventType.INTEREST));
            }

            goToNextFragment();
        }

        _cls2()
        {
            this$0 = NUXInterestsPickerFragment.this;
            super();
        }
    }

}
