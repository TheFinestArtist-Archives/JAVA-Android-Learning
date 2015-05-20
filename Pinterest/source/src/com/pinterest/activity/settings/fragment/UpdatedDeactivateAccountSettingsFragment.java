// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.settings.dialog.DeactivateSettingReasonDialog;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.gcm.GcmRegistrar;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.actions.Scrollable;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.text.PButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdatedDeactivateAccountSettingsFragment extends BaseFragment
    implements com.pinterest.activity.settings.dialog.DeactivateSettingReasonDialog.DeactivationExplanationListener, Scrollable
{

    private static boolean CLOSING = false;
    private static boolean DEACTIVATING = false;
    private static final String _noSocialNetworksConnected = "anything";
    PButton _accountDeactivateButton;
    RadioButton _accountHackDeactivateBt;
    RadioButton _anotherAccountDeactivateBt;
    RadioButton _businessAccountDeactivateBt;
    RadioGroup _deactivateRadioGroup;
    private final List _deactivateReasonsList = Arrays.asList(Resources.stringArray(0x7f070026));
    TextView _deactivateSocialTitleTv;
    private String _deactivationDialogMessage;
    private String _deactivationExplanation;
    private String _deactivationReason;
    RadioButton _emailsDeactivateBt;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    RadioButton _interestingPinsDeactivateBt;
    private int _lastRadioBt;
    RadioButton _otherDeactivateBt;
    RadioButton _privacyConcernDeactivateBt;
    ScrollView _scrollView;
    private ArrayList _socialNetworksList;
    RadioButton _takingBreakDeactivateBt;
    RadioButton _understandPinterestDeactivateBt;
    RadioButton _usePinterestDeactivateBt;
    TextView closeAccountTv;
    View containerLayout;
    AdapterFooterView footer;
    private final android.view.View.OnClickListener onDeactivateOptionsClick = new _cls3();
    private ApiResponseHandler onMeDeactivated;
    private ApiResponseHandler onMyAccountClosed;

    public UpdatedDeactivateAccountSettingsFragment()
    {
        _lastRadioBt = -1;
        _eventsSubscriber = new _cls5();
        onMeDeactivated = new _cls6();
        onMyAccountClosed = new _cls7();
        _menuId = 0x7f100005;
    }

    private void addPaddingForJellyBean()
    {
        if (android.os.Build.VERSION.SDK_INT <= 16)
        {
            int i = (int)(getResources().getDimension(0x7f0a0099) * getResources().getDisplayMetrics().density + 0.5F);
            _emailsDeactivateBt.setPadding(i, 0, 0, 0);
            _accountHackDeactivateBt.setPadding(i, 0, 0, 0);
            _interestingPinsDeactivateBt.setPadding(i, 0, 0, 0);
            _takingBreakDeactivateBt.setPadding(i, 0, 0, 0);
            _anotherAccountDeactivateBt.setPadding(i, 0, 0, 0);
            _businessAccountDeactivateBt.setPadding(i, 0, 0, 0);
            _usePinterestDeactivateBt.setPadding(i, 0, 0, 0);
            _understandPinterestDeactivateBt.setPadding(i, 0, 0, 0);
            _privacyConcernDeactivateBt.setPadding(i, 0, 0, 0);
            _otherDeactivateBt.setPadding(i, 0, 0, 0);
        }
    }

    private void addSocialNetworksToTitle()
    {
        _socialNetworksList.size();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 60
    //                   1 66
    //                   2 99
    //                   3 152;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        String s = "anything";
_L7:
        _deactivateSocialTitleTv.setText(Resources.string(0x7f0e015b, new Object[] {
            s
        }));
        return;
_L2:
        s = "anything";
        continue; /* Loop/switch isn't completed */
_L3:
        s = (new StringBuilder()).append("").append((String)_socialNetworksList.get(0)).toString();
        continue; /* Loop/switch isn't completed */
_L4:
        s = (new StringBuilder()).append("").append((String)_socialNetworksList.get(0)).append(" or ").append((String)_socialNetworksList.get(1)).toString();
        continue; /* Loop/switch isn't completed */
_L5:
        s = (new StringBuilder()).append("").append((String)_socialNetworksList.get(0)).append(", ").append((String)_socialNetworksList.get(1)).append(" or ").append((String)_socialNetworksList.get(2)).toString();
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void createDeactivateSettingsDialog(String s, String s1)
    {
        s = new DeactivateSettingReasonDialog(s, s1, Resources.string(0x7f0e016f));
        s.setListener(this);
        Events.post(new DialogEvent(s));
    }

    private void createReasonDialog(String s, String s1, final Navigation navigation, String s2)
    {
        final BaseDialog dialog = new BaseDialog();
        dialog.setNegativeButton(Resources.string(0x7f0e02fc), null);
        dialog.setTitle(s);
        dialog.setMessage(s1);
        dialog.setPositiveButton(s2, new _cls4());
        Events.post(new DialogEvent(dialog));
    }

    private void deactivateAccount()
    {
        try
        {
            DEACTIVATING = true;
            getActivity();
            GcmRegistrar.a();
            showWaitDialog();
            return;
        }
        catch (Exception exception)
        {
            DEACTIVATING = false;
            Application.showToast(exception.getMessage());
            return;
        }
    }

    private void initRadioButtons()
    {
        _emailsDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _accountHackDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _interestingPinsDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _takingBreakDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _anotherAccountDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _businessAccountDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _usePinterestDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _understandPinterestDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _privacyConcernDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
        _otherDeactivateBt.setOnClickListener(onDeactivateOptionsClick);
    }

    private void initUi(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            ButterKnife.a(this, view);
            addSocialNetworksToTitle();
            return;
        }
    }

    private void listSocialNetworks()
    {
        _socialNetworksList = new ArrayList();
        if (MyUser.isConnectedToFacebook())
        {
            _socialNetworksList.add(Resources.string(0x7f0e020f));
        }
        if (MyUser.isConnectedToTwitter())
        {
            _socialNetworksList.add(Resources.string(0x7f0e04ba));
        }
        if (MyUser.isConnectedToGplus())
        {
            _socialNetworksList.add(Resources.string(0x7f0e0256));
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber, com/pinterest/gcm/GcmRegistrar$GcmEvent, new Class[0]);
    }

    public void onActivityCreated(Bundle bundle)
    {
        _deactivateRadioGroup.clearCheck();
        initRadioButtons();
        addPaddingForJellyBean();
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        DEACTIVATING = false;
        CLOSING = false;
        _layoutId = 0x7f03007b;
        listSocialNetworks();
    }

    protected void onDeactivate()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/gcm/GcmRegistrar$GcmEvent
        });
        super.onDeactivate();
    }

    public void onDestroyView()
    {
        ButterKnife.a(this);
        _deactivateRadioGroup = null;
        super.onDestroyView();
    }

    void onOptionDeactivateAccountClicked(View view)
    {
        deactivateAccount();
    }

    void onOptionPermanentlyCloseClicked(final View dialog)
    {
        dialog = new BaseDialog();
        if (MyUser.get() != null)
        {
            if (MyUser.get().getPartner() != null)
            {
                dialog.setTitle(Resources.string(0x7f0e00c8));
                dialog.setMessage(Resources.string(0x7f0e00c7));
                dialog.setNegativeButton(Resources.string(0x7f0e02fc), null);
                dialog.setPositiveButton(Resources.string(0x7f0e01d4), new _cls1());
            } else
            {
                dialog.setTitle(Resources.string(0x7f0e00ca));
                dialog.setMessage(Resources.string(0x7f0e00c9, new Object[] {
                    MyUser.get().getEmail()
                }));
                dialog.setPositiveButton(Resources.string(0x7f0e02fc), null);
                dialog.setNegativeButton(Resources.string(0x7f0e0513), new _cls2());
            }
            Events.post(new DialogEvent(dialog));
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _actionBar.setTitle(0x7f0e015a);
        initUi(view);
    }

    public void startDeactivateAccountProcess(String s)
    {
        _deactivationExplanation = s;
        deactivateAccount();
    }

    static 
    {
        DEACTIVATING = false;
        CLOSING = false;
    }



/*
    static boolean access$002(boolean flag)
    {
        CLOSING = flag;
        return flag;
    }

*/










/*
    static int access$202(UpdatedDeactivateAccountSettingsFragment updateddeactivateaccountsettingsfragment, int i)
    {
        updateddeactivateaccountsettingsfragment._lastRadioBt = i;
        return i;
    }

*/



/*
    static String access$302(UpdatedDeactivateAccountSettingsFragment updateddeactivateaccountsettingsfragment, String s)
    {
        updateddeactivateaccountsettingsfragment._deactivationReason = s;
        return s;
    }

*/





/*
    static String access$602(UpdatedDeactivateAccountSettingsFragment updateddeactivateaccountsettingsfragment, String s)
    {
        updateddeactivateaccountsettingsfragment._deactivationDialogMessage = s;
        return s;
    }

*/




/*
    static String access$802(UpdatedDeactivateAccountSettingsFragment updateddeactivateaccountsettingsfragment, String s)
    {
        updateddeactivateaccountsettingsfragment._deactivationExplanation = s;
        return s;
    }

*/



/*
    static boolean access$902(boolean flag)
    {
        DEACTIVATING = flag;
        return flag;
    }

*/

    private class _cls3
        implements android.view.View.OnClickListener
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;

        public void onClick(View view)
        {
            _accountDeactivateButton.setEnabled(true);
            _accountDeactivateButton.setStyle(com.pinterest.ui.text.PButton.ButtonStyle.RED);
            if (_lastRadioBt != view.getId() || view.getId() != _deactivateRadioGroup.getCheckedRadioButtonId()) goto _L2; else goto _L1
_L1:
            _lastRadioBt = -1;
_L4:
            _scrollView.scrollTo(0, _accountDeactivateButton.getBottom());
            return;
_L2:
            _lastRadioBt = _deactivateRadioGroup.getCheckedRadioButtonId();
            switch (_lastRadioBt)
            {
            default:
                _deactivationReason = "";
                _deactivationExplanation = "";
                break;

            case 2131427978: 
                _deactivationReason = (String)_deactivateReasonsList.get(0);
                view = new Navigation(Location.EMAIL_NOTIFICATIONS_SETTINGS);
                createReasonDialog(Resources.string(0x7f0e0169), Resources.string(0x7f0e0167), view, Resources.string(0x7f0e0164));
                break;

            case 2131427979: 
                _deactivationReason = (String)_deactivateReasonsList.get(1);
                _deactivationDialogMessage = Resources.string(0x7f0e016a, new Object[] {
                    Resources.string(0x7f0e04dc)
                });
                createDeactivateSettingsDialog(Resources.string(0x7f0e015f), _deactivationDialogMessage);
                break;

            case 2131427980: 
                _deactivationReason = (String)_deactivateReasonsList.get(2);
                _deactivationDialogMessage = Resources.string(0x7f0e0172, new Object[] {
                    Resources.string(0x7f0e04db)
                });
                createDeactivateSettingsDialog(Resources.string(0x7f0e016c), _deactivationDialogMessage);
                break;

            case 2131427981: 
                _deactivationReason = (String)_deactivateReasonsList.get(3);
                createReasonDialog(Resources.string(0x7f0e0161), Resources.string(0x7f0e0179, new Object[] {
                    MyUser.get().getEmail()
                }), null, Resources.string(0x7f0e025b));
                break;

            case 2131427982: 
                _deactivationReason = (String)_deactivateReasonsList.get(4);
                _deactivationDialogMessage = Resources.string(0x7f0e016d, new Object[] {
                    Resources.string(0x7f0e04dd)
                });
                createDeactivateSettingsDialog(Resources.string(0x7f0e015f), _deactivationDialogMessage);
                break;

            case 2131427983: 
                _deactivationReason = (String)_deactivateReasonsList.get(5);
                _deactivationDialogMessage = Resources.string(0x7f0e0162, new Object[] {
                    Resources.string(0x7f0e04d9)
                });
                createDeactivateSettingsDialog(Resources.string(0x7f0e015f), _deactivationDialogMessage);
                break;

            case 2131427984: 
                _deactivationReason = (String)_deactivateReasonsList.get(6);
                Application.showToast(Resources.string(0x7f0e0165));
                break;

            case 2131427985: 
                _deactivationReason = (String)_deactivateReasonsList.get(7);
                _deactivationDialogMessage = Resources.string(0x7f0e017b, new Object[] {
                    Resources.string(0x7f0e04d8)
                });
                createDeactivateSettingsDialog(Resources.string(0x7f0e017d), _deactivationDialogMessage);
                break;

            case 2131427986: 
                _deactivationReason = (String)_deactivateReasonsList.get(8);
                _deactivationDialogMessage = Resources.string(0x7f0e0174, new Object[] {
                    Resources.string(0x7f0e04df)
                });
                createDeactivateSettingsDialog(Resources.string(0x7f0e0176), _deactivationDialogMessage);
                break;

            case 2131427987: 
                _deactivationReason = (String)_deactivateReasonsList.get(9);
                createDeactivateSettingsDialog(Resources.string(0x7f0e0171), null);
                break;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls3()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            super();
        }
    }


    private class _cls5 extends com.pinterest.base.Events.EventsSubscriber
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;

        public void onEventMainThread(com.pinterest.gcm.GcmRegistrar.GcmEvent gcmevent)
        {
            _cls8..SwitchMap.com.pinterest.gcm.GcmRegistrar.GcmEvent.Type[gcmevent.a().ordinal()];
            JVM INSTR tableswitch 1 1: default 28
        //                       1 29;
               goto _L1 _L2
_L1:
            return;
_L2:
            if (UpdatedDeactivateAccountSettingsFragment.DEACTIVATING)
            {
                MyUserApi.d(_deactivationReason, _deactivationExplanation, onMeDeactivated, getApiTag());
                UpdatedDeactivateAccountSettingsFragment.DEACTIVATING = false;
                return;
            }
            if (UpdatedDeactivateAccountSettingsFragment.CLOSING)
            {
                MyUserApi.b(onMyAccountClosed, getApiTag());
                UpdatedDeactivateAccountSettingsFragment.CLOSING = false;
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        _cls5()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            super();
        }

        private class _cls8
        {

            static final int $SwitchMap$com$pinterest$gcm$GcmRegistrar$GcmEvent$Type[];

            static 
            {
                $SwitchMap$com$pinterest$gcm$GcmRegistrar$GcmEvent$Type = new int[com.pinterest.gcm.GcmRegistrar.GcmEvent.Type.values().length];
                try
                {
                    $SwitchMap$com$pinterest$gcm$GcmRegistrar$GcmEvent$Type[com.pinterest.gcm.GcmRegistrar.GcmEvent.Type.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

    }


    private class _cls6 extends ApiResponseHandler
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            ActivityHelper.doLogout(getActivity(), false);
            hideWaitDialog();
            class _cls1
                implements Runnable
            {

                final _cls6 this$1;

                public void run()
                {
                    BaseDialog basedialog = new BaseDialog();
                    basedialog.setTitle(Resources.string(0x7f0e0178));
                    basedialog.setMessage(Resources.string(0x7f0e0177));
                    basedialog.setPositiveButton(Resources.string(0x7f0e033a), null);
                    Events.postSticky(new DialogEvent(basedialog));
                }

                _cls1()
                {
                    this$1 = _cls6.this;
                    super();
                }
            }

            if (getView() != null)
            {
                getView().postDelayed(new _cls1(), 100L);
            }
        }

        _cls6()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            super();
        }
    }


    private class _cls7 extends ApiResponseHandler
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            ActivityHelper.doLogout(getActivity(), false);
            hideWaitDialog();
            class _cls1
                implements Runnable
            {

                final _cls7 this$1;

                public void run()
                {
                    BaseDialog basedialog = new BaseDialog();
                    basedialog.setTitle(Resources.string(0x7f0e00cc));
                    basedialog.setMessage(Resources.string(0x7f0e00cb));
                    basedialog.setPositiveButton(Resources.string(0x7f0e033b), null);
                    Events.postSticky(new DialogEvent(basedialog));
                }

                _cls1()
                {
                    this$1 = _cls7.this;
                    super();
                }
            }

            if (getView() != null)
            {
                getView().postDelayed(new _cls1(), 100L);
            }
        }

        _cls7()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;
        final BaseDialog val$dialog;
        final Navigation val$navigation;

        public void onClick(View view)
        {
            if (navigation != null)
            {
                Events.post(navigation);
            }
            dialog.dismiss();
        }

        _cls4()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            navigation = navigation1;
            dialog = basedialog;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;
        final BaseDialog val$dialog;

        public void onClick(View view)
        {
            ActivityHelper.goIntentView(getActivity(), Resources.string(0x7f0e04e2));
            dialog.dismiss();
        }

        _cls1()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            dialog = basedialog;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final UpdatedDeactivateAccountSettingsFragment this$0;
        final BaseDialog val$dialog;

        public void onClick(View view)
        {
            try
            {
                UpdatedDeactivateAccountSettingsFragment.CLOSING = true;
                getActivity();
                GcmRegistrar.a();
                dialog.dismiss();
                showWaitDialog();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                UpdatedDeactivateAccountSettingsFragment.CLOSING = false;
            }
            Application.showToast(view.getMessage());
            dialog.dismiss();
        }

        _cls2()
        {
            this$0 = UpdatedDeactivateAccountSettingsFragment.this;
            dialog = basedialog;
            super();
        }
    }

}
