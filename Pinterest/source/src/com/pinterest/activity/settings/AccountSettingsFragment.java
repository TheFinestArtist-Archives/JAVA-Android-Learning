// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.contacts.UploadContactsDialog;
import com.pinterest.activity.contacts.UploadContactsUtil;
import com.pinterest.activity.settings.dialog.BusinessNameSettingDialog;
import com.pinterest.activity.settings.dialog.ChangePasswordDialog;
import com.pinterest.activity.settings.dialog.ContactNameSettingDialog;
import com.pinterest.activity.settings.dialog.CountrySettingDialog;
import com.pinterest.activity.settings.dialog.EmailSettingDialog;
import com.pinterest.activity.settings.dialog.GenderSettingDialog;
import com.pinterest.activity.settings.dialog.NameSettingDialog;
import com.pinterest.activity.settings.dialog.NewsPrivacyDialog;
import com.pinterest.activity.settings.dialog.PersonalizationSettingDialog;
import com.pinterest.activity.settings.dialog.SearchPrivacyDialog;
import com.pinterest.activity.settings.dialog.SettingsVersionDialog;
import com.pinterest.activity.settings.dialog.UsernameSettingDialog;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.dialog.SimpleTextDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Partner;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.api.remote.SearchApi;
import com.pinterest.api.remote.SettingsApi;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.autoupdate.AutoUpdateManager;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.log.PLog;
import com.pinterest.kit.utils.LocaleUtils;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.actions.Scrollable;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.notify.DialogCheckedTextViewAdapter;
import java.util.ArrayList;

public class AccountSettingsFragment extends BaseFragment
    implements Scrollable
{

    private static final String TEMP_STR = "(%1$s)";
    private static ArrayList sNotifArray;
    TextView _businessName;
    View _businessNameBt;
    TextView _changePwdBt;
    TextView _contactName;
    View _contactNameBt;
    TextView _country;
    View _countryBt;
    TextView _email;
    View _emailBt;
    TextView _emailNotifTv;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    TextView _gender;
    View _genderBt;
    View _genderContainer;
    View _languageBt;
    TextView _name;
    View _nameBt;
    View _newsPrivacyBt;
    private ApiResponseHandler _notifHandler;
    TextView _notifTv;
    private PinterestJsonArray _notifs;
    View _partnerNameContainer;
    View _personalRecBt;
    View _pinnerNameContainer;
    ScrollView _scrollView;
    View _searchPrivacyBt;
    TextView _updateBt;
    View _updateDivider;
    TextView _username;
    View _usernameBt;
    ArrayList dialogItems;
    CheckedTextView facebookCb;
    CheckedTextView gplusCb;
    private boolean isCountriesShown;
    CheckedTextView nearbyCb;
    android.widget.AdapterView.OnItemClickListener notifItemClicked;
    public android.view.View.OnClickListener onProfileClicked;
    CheckedTextView rakutenCb;
    CheckedTextView storeContactsCb;
    CheckedTextView twitterCb;

    public AccountSettingsFragment()
    {
        onProfileClicked = new _cls2();
        isCountriesShown = false;
        _notifHandler = new _cls3();
        notifItemClicked = new _cls4();
        _eventsSubscriber = new _cls22();
    }

    private void initNotifKeyArray()
    {
        if (sNotifArray == null || dialogItems == null)
        {
            sNotifArray = new ArrayList();
            dialogItems = new ArrayList();
            int i = 0;
            while (i < _notifs.a()) 
            {
                try
                {
                    PinterestJsonObject pinterestjsonobject = _notifs.c(i);
                    sNotifArray.add(pinterestjsonobject.a("key", ""));
                    dialogItems.add(pinterestjsonobject.a("label", ""));
                }
                catch (Exception exception) { }
                i++;
            }
        }
    }

    private void initUi(View view)
    {
        if (view == null)
        {
            return;
        }
        ButterKnife.a(this, view);
        _changePwdBt.setText(Resources.string(0x7f0e00bb));
        if (LocaleUtils.isLanguageJa() && rakutenCb != null)
        {
            View view1 = view.findViewById(0x7f0b027f);
            if (view1 != null)
            {
                view1.setVisibility(0);
            }
            view1 = view.findViewById(0x7f0b0280);
            if (view1 != null)
            {
                view1.setVisibility(0);
            }
        }
        ((TextView)view.findViewById(0x7f0b025f)).setText(ApplicationInfo.getVersionName());
        view = (AdapterFooterView)view.findViewById(0x7f0b0122);
        view.setState(1);
        view.setShadowVisibility(8);
        updateUi();
    }

    private void loadCountries()
    {
        SettingsApi.c(new _cls18(), getApiTag());
    }

    private void loadMyUser()
    {
        MyUserApi.a(new _cls1(true), getApiTag());
    }

    private void loadNotifSettings()
    {
        SettingsApi.b(_notifHandler, getApiTag());
    }

    private void loadSettings()
    {
        SettingsApi.a(new _cls17(), getApiTag());
    }

    private void promptDisconnectFb()
    {
        final SimpleTextDialog dialog = SimpleTextDialog.newInstance();
        dialog.setTitle(0x7f0e0196);
        dialog.setText(getString(0x7f0e0195).replace("(%1$s)", ""));
        dialog.setPositiveButton(0x7f0e019a, new _cls13());
        dialog.setNegativeButton(0x7f0e0199, new _cls14());
        dialog.setOnDismissListener(new _cls15());
        Events.post(new DialogEvent(dialog));
    }

    private void promptDisconnectGplus()
    {
        final SimpleTextDialog dialog = SimpleTextDialog.newInstance();
        dialog.setTitle(0x7f0e0198);
        dialog.setText(getString(0x7f0e0197).replace("(%1$s)", ""));
        dialog.setPositiveButton(0x7f0e019a, new _cls19());
        dialog.setNegativeButton(0x7f0e0199, new _cls20());
        dialog.setOnDismissListener(new _cls21());
        Events.post(new DialogEvent(dialog));
    }

    private void promptDisconnectRakuten()
    {
        final SimpleTextDialog dialog = SimpleTextDialog.newInstance();
        dialog.setTitle(0x7f0e019c);
        dialog.setText(getString(0x7f0e019b).replace("(%1$s)", ""));
        dialog.setPositiveButton(0x7f0e019a, new _cls5());
        dialog.setNegativeButton(0x7f0e0199, new _cls6());
        dialog.setOnDismissListener(new _cls7());
        Events.post(new DialogEvent(dialog));
    }

    private void promptDisconnectSocial(final com.pinterest.base.Social.Network methodName)
    {
        _cls23..SwitchMap.com.pinterest.base.Social.Network[methodName.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 141
    //                   2 163
    //                   3 185;
           goto _L1 _L2 _L3 _L4
_L1:
        final CheckedTextView cb;
        int i;
        int j;
        j = 0x7f0e019c;
        i = 0x7f0e019b;
        cb = rakutenCb;
        methodName = "actuallyDisconnectRakuten";
_L6:
        final SimpleTextDialog dialog = SimpleTextDialog.newInstance();
        dialog.setTitle(j);
        dialog.setText(getString(i).replace("(%1$s)", ""));
        dialog.setPositiveButton(0x7f0e019a, new _cls9());
        dialog.setNegativeButton(0x7f0e0199, new _cls10());
        dialog.setOnDismissListener(new _cls11());
        Events.post(new DialogEvent(dialog));
        return;
_L2:
        j = 0x7f0e0196;
        i = 0x7f0e0195;
        cb = facebookCb;
        methodName = "actuallyDisconnectFb";
        continue; /* Loop/switch isn't completed */
_L3:
        j = 0x7f0e0198;
        i = 0x7f0e0197;
        cb = gplusCb;
        methodName = "actuallyDisconnectGplus";
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0x7f0e019e;
        i = 0x7f0e019d;
        cb = twitterCb;
        methodName = "actuallyDisconnectTwitter";
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void promptDisconnectTwitter()
    {
    }

    private void registerEvents()
    {
        Events.register(_eventsSubscriber, com/pinterest/base/Social$UpdateEvent, new Class[] {
            com/pinterest/api/model/MyUser$UpdateEvent, com/pinterest/activity/contacts/UploadContactsUtil$UploadContactsCancelledEvent, com/pinterest/activity/settings/AccountSettingsFragment$AccountSettingsEvent
        });
    }

    private void showBusinessNameDialog()
    {
        Events.post(new DialogEvent(new BusinessNameSettingDialog()));
    }

    private void showChangePwdDialog()
    {
        if (getActivity() == null || MyUser.get() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new ChangePasswordDialog()));
            return;
        }
    }

    private void showContactNameDialog()
    {
        Events.post(new DialogEvent(new ContactNameSettingDialog()));
    }

    private void showCountriesDialog()
    {
        PinterestJsonObject pinterestjsonobject = DiskCache.getJsonObject("COUNTRIES");
        FragmentActivity fragmentactivity = getActivity();
        if (pinterestjsonobject == null || fragmentactivity == null)
        {
            return;
        } else
        {
            isCountriesShown = true;
            Events.post(new DialogEvent(new CountrySettingDialog()));
            return;
        }
    }

    private void showEmailDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new EmailSettingDialog(_email.getText().toString())));
            return;
        }
    }

    private void showGenderDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new GenderSettingDialog()));
            return;
        }
    }

    private void showLanguageSetting()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings");
        try
        {
            getActivity().startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            CrashReporting.logHandledException(exception);
        }
    }

    private void showNameDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new NameSettingDialog()));
            return;
        }
    }

    private void showNewsPrivacyDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new NewsPrivacyDialog()));
            return;
        }
    }

    private void showNotifSettingDialog()
    {
        if (dialogItems == null)
        {
            return;
        } else
        {
            getActivity();
            BaseDialog basedialog = new BaseDialog();
            basedialog.setTitle(0x7f0e02e4);
            basedialog.setSubTitle(0x7f0e0251);
            basedialog.setListViewOptions(new DialogCheckedTextViewAdapter(dialogItems, _notifs), notifItemClicked);
            basedialog.setPositiveButton(0x7f0e033b, null);
            Events.post(new DialogEvent(basedialog));
            return;
        }
    }

    private void showPersonalRecDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new PersonalizationSettingDialog()));
            return;
        }
    }

    private void showSearchPrivacyDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new SearchPrivacyDialog()));
            return;
        }
    }

    private void showUsernameDialog()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Events.post(new DialogEvent(new UsernameSettingDialog()));
            return;
        }
    }

    private void unregisterEvents()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/base/Social$UpdateEvent, com/pinterest/api/model/MyUser$UpdateEvent, com/pinterest/activity/contacts/UploadContactsUtil$UploadContactsCancelledEvent, com/pinterest/activity/settings/AccountSettingsFragment$AccountSettingsEvent
        });
    }

    private void updateFacebookCbs()
    {
        if (facebookCb == null)
        {
            return;
        } else
        {
            facebookCb.setChecked(MyUser.isConnectedToFacebook());
            return;
        }
    }

    private void updateGPlusCb()
    {
        if (gplusCb == null)
        {
            return;
        } else
        {
            gplusCb.setChecked(MyUser.isConnectedToGplus());
            return;
        }
    }

    private void updateOtaButton()
    {
        ViewHelper.setVisibility(_updateBt, ApplicationInfo.isOta());
        ViewHelper.setVisibility(_updateDivider, ApplicationInfo.isOta());
    }

    private void updateRakutenCb()
    {
        if (rakutenCb != null)
        {
            rakutenCb.setChecked(MyUser.isConnectedToRakuten());
        }
    }

    private void updateTwitterCb()
    {
        if (twitterCb == null)
        {
            return;
        } else
        {
            twitterCb.setChecked(MyUser.isConnectedToTwitter());
            return;
        }
    }

    private void updateUi()
    {
        if (getActivity() != null)
        {
            updateFacebookCbs();
            updateGPlusCb();
            updateTwitterCb();
            updateRakutenCb();
            updateOtaButton();
            storeContactsCb.setChecked(UploadContactsUtil.isAccountStoredContacts());
            nearbyCb.setChecked(Preferences.user().getBoolean("PREF_NEARBY_NOTIFICATIONS", true));
            if (MyUser.get() != null)
            {
                User user = MyUser.get();
                Partner partner = user.getPartner();
                if (partner != null)
                {
                    _partnerNameContainer.setVisibility(0);
                    _pinnerNameContainer.setVisibility(8);
                    _genderContainer.setVisibility(8);
                    _businessName.setText(partner.getBusinessName());
                    _contactName.setText(partner.getContactName());
                } else
                {
                    _partnerNameContainer.setVisibility(8);
                    _pinnerNameContainer.setVisibility(0);
                    _genderContainer.setVisibility(0);
                    setName(user.getFullName());
                    setGender(user.getGender());
                }
                _username.setText(user.getUsername());
                _email.setText(user.getEmail());
                _country.setText(LocaleUtils.getCountry());
                _nameBt.setOnClickListener(onProfileClicked);
                _businessNameBt.setOnClickListener(onProfileClicked);
                _contactNameBt.setOnClickListener(onProfileClicked);
                _usernameBt.setOnClickListener(onProfileClicked);
                _emailBt.setOnClickListener(onProfileClicked);
                _countryBt.setOnClickListener(onProfileClicked);
                _genderBt.setOnClickListener(onProfileClicked);
                _languageBt.setOnClickListener(onProfileClicked);
                _changePwdBt.setOnClickListener(onProfileClicked);
                _personalRecBt.setOnClickListener(onProfileClicked);
                _searchPrivacyBt.setOnClickListener(onProfileClicked);
                _newsPrivacyBt.setOnClickListener(onProfileClicked);
                return;
            }
        }
    }

    void actuallyDisconnectFb()
    {
        MyUserApi.a(3, new _cls16(true), getApiTag());
    }

    void actuallyDisconnectGplus()
    {
        Events.post(new com.pinterest.base.Social.RequestDisconnectEvent(com.pinterest.base.Social.Network.GPLUS));
    }

    void actuallyDisconnectRakuten()
    {
        MyUserApi.a(4, new _cls8(true), getApiTag());
    }

    void actuallyDisconnectTwitter()
    {
        MyUserApi.a(2, new _cls12(true), getApiTag());
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        loadMyUser();
        loadSettings();
        loadNotifSettings();
    }

    void onClearSearchHistoryClicked(View view)
    {
        Pinalytics.a(ElementType.CLEAR_SEARCHES_BUTTON);
        SearchApi.a(new ClearSearchHistoryApiResponseHandler(), getApiTag());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03006c;
        _menuId = 0x7f100005;
    }

    void onDeactivateAccountClicked(View view)
    {
        Events.post(new Navigation(Location.DEACTIVATE_ACCOUNT_SETTINGS));
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        unregisterEvents();
    }

    void onEmailNotifClick(View view)
    {
        Pinalytics.a(ElementType.EMAIL_BUTTON);
        Events.post(new Navigation(Location.EMAIL_NOTIFICATIONS_SETTINGS));
    }

    void onFbClick(View view)
    {
        if (facebookCb.isChecked())
        {
            promptDisconnectSocial(com.pinterest.base.Social.Network.FACEBOOK);
            return;
        } else
        {
            Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.FACEBOOK));
            return;
        }
    }

    void onGplusClick(View view)
    {
        view = gplusCb;
        boolean flag;
        if (!gplusCb.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        if (gplusCb.isChecked())
        {
            Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.GPLUS));
            return;
        } else
        {
            promptDisconnectSocial(com.pinterest.base.Social.Network.GPLUS);
            return;
        }
    }

    void onNearbyClick(View view)
    {
        view = nearbyCb;
        boolean flag;
        if (!nearbyCb.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        Preferences.user().set("PREF_NEARBY_NOTIFICATIONS", nearbyCb.isChecked());
    }

    void onNotifClick(View view)
    {
        Pinalytics.a(ElementType.PUSH_NOTIFICATIONS_BUTTON);
        showNotifSettingDialog();
    }

    void onRakutenClick(View view)
    {
        view = rakutenCb;
        boolean flag;
        if (!rakutenCb.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        if (rakutenCb.isChecked())
        {
            ActivityHelper.goRakutenAuth(getActivity());
            return;
        } else
        {
            promptDisconnectSocial(com.pinterest.base.Social.Network.RAKUTEN);
            return;
        }
    }

    void onStoreContactsClick(View view)
    {
        view = storeContactsCb;
        boolean flag;
        if (!storeContactsCb.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        Pinalytics.a(ElementType.ANALYTICS_BUTTON);
        if (storeContactsCb.isChecked())
        {
            Events.post(new DialogEvent(new UploadContactsDialog(true)));
        } else
        {
            UploadContactsUtil.setStoreContacts(false);
        }
        PLog.a((new StringBuilder("onStoreContactsClick: ")).append(storeContactsCb.isChecked()).toString(), new Object[0]);
    }

    void onTwitterClick(View view)
    {
        view = twitterCb;
        boolean flag;
        if (!twitterCb.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        if (twitterCb.isChecked())
        {
            Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.TWITTER));
            return;
        } else
        {
            promptDisconnectSocial(com.pinterest.base.Social.Network.TWITTER);
            return;
        }
    }

    void onUpdateClicked(View view)
    {
        AutoUpdateManager.a().startUpdate(null);
    }

    void onVersionClicked(View view)
    {
        Events.post(new DialogEvent(new SettingsVersionDialog()));
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _actionBar.setTitle(0x7f0e0023);
        _actionBarWrapper.setShadowVisibility(0);
        initUi(view);
        registerEvents();
    }

    public void scrollTo(int i, int j)
    {
        if (_scrollView != null)
        {
            _scrollView.smoothScrollTo(i, j);
        }
    }

    public void setCountryText(String s)
    {
        _country.setText(s);
    }

    public void setEmail(String s)
    {
        _email.setText(s);
    }

    public void setGender(String s)
    {
        if (s.equals("female"))
        {
            _gender.setText(Resources.string(0x7f0e0476));
            return;
        }
        if (s.equals("male"))
        {
            _gender.setText(Resources.string(0x7f0e0477));
            return;
        } else
        {
            _gender.setText(Resources.string(0x7f0e0479));
            return;
        }
    }

    public void setName(String s)
    {
        _name.setText(s);
    }

    public void setUserName(String s)
    {
        _username.setText(s);
    }









/*
    static PinterestJsonArray access$1402(AccountSettingsFragment accountsettingsfragment, PinterestJsonArray pinterestjsonarray)
    {
        accountsettingsfragment._notifs = pinterestjsonarray;
        return pinterestjsonarray;
    }

*/


















    private class _cls2
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;

        public void onClick(View view)
        {
            if (view == _nameBt)
            {
                Pinalytics.a(ElementType.NAME_BUTTON);
                showNameDialog();
            } else
            {
                if (view == _businessNameBt)
                {
                    Pinalytics.a(ElementType.NAME_BUTTON);
                    showBusinessNameDialog();
                    return;
                }
                if (view == _contactNameBt)
                {
                    Pinalytics.a(ElementType.NAME_BUTTON);
                    showContactNameDialog();
                    return;
                }
                if (view == _usernameBt)
                {
                    Pinalytics.a(ElementType.USERNAME_BUTTON);
                    showUsernameDialog();
                    return;
                }
                if (view == _emailBt)
                {
                    Pinalytics.a(ElementType.EMAIL_BUTTON);
                    showEmailDialog();
                    return;
                }
                if (view == _countryBt)
                {
                    Pinalytics.a(ElementType.COUNTRY_BUTTON);
                    loadCountries();
                    showCountriesDialog();
                    return;
                }
                if (view == _languageBt)
                {
                    Pinalytics.a(ElementType.LANGUAGE_BUTTON);
                    showLanguageSetting();
                    return;
                }
                if (view == _changePwdBt)
                {
                    Pinalytics.a(ElementType.CHANGE_PASSWORD_BUTTON);
                    showChangePwdDialog();
                    return;
                }
                if (view == _genderBt)
                {
                    Pinalytics.a(ElementType.GENDER_BUTTON);
                    showGenderDialog();
                    return;
                }
                if (view == _personalRecBt)
                {
                    Pinalytics.a(ElementType.PERSONALIZED_RECOMMENDATIONS_BUTTON);
                    showPersonalRecDialog();
                    return;
                }
                if (view == _searchPrivacyBt)
                {
                    Pinalytics.a(ElementType.SEARCH_PRIVACY_BUTTON);
                    showSearchPrivacyDialog();
                    return;
                }
                if (view == _newsPrivacyBt)
                {
                    Pinalytics.a(ElementType.SEARCH_PRIVACY_BUTTON);
                    showNewsPrivacyDialog();
                    return;
                }
            }
        }

        _cls2()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls3 extends ApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            if (_notifTv != null)
            {
                if ((apiresponse = ((ApiResponse) (apiresponse.getData()))) instanceof PinterestJsonArray)
                {
                    _notifs = (PinterestJsonArray)apiresponse;
                    if (_notifs.a() != 0)
                    {
                        _notifTv.setVisibility(0);
                        initNotifKeyArray();
                        return;
                    }
                }
            }
        }

        _cls3()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.widget.AdapterView.OnItemClickListener
    {

        final AccountSettingsFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (view != null)
            {
                if ((adapterview = (CheckedTextView)view.findViewById(0x7f0b01f1)) != null)
                {
                    boolean flag;
                    if (!adapterview.isChecked())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    adapterview.setChecked(flag);
                    if (AccountSettingsFragment.sNotifArray != null)
                    {
                        view = (String)AccountSettingsFragment.sNotifArray.get(i);
                        if (adapterview.isChecked())
                        {
                            adapterview = "anyone";
                        } else
                        {
                            adapterview = "none";
                        }
                        SettingsApi.d(view, adapterview, _notifHandler, getApiTag());
                        return;
                    }
                }
            }
        }

        _cls4()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls22 extends com.pinterest.base.Events.EventsSubscriber
    {

        final AccountSettingsFragment this$0;

        public void onEventMainThread(com.pinterest.activity.contacts.UploadContactsUtil.UploadContactsCancelledEvent uploadcontactscancelledevent)
        {
            storeContactsCb.setChecked(false);
        }

        public void onEventMainThread(AccountSettingsEvent accountsettingsevent)
        {
            setCountryText(LocaleUtils.getCountry());
            accountsettingsevent = MyUser.get();
            setEmail(accountsettingsevent.getEmail());
        }

        public void onEventMainThread(com.pinterest.api.model.MyUser.UpdateEvent updateevent)
        {
            updateUi();
        }

        public void onEventMainThread(com.pinterest.base.Social.UpdateEvent updateevent)
        {
            switch (_cls23..SwitchMap.com.pinterest.base.Social.Network[updateevent.getNetwork().ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                updateFacebookCbs();
                return;

            case 3: // '\003'
                updateTwitterCb();
                return;

            case 2: // '\002'
                updateGPlusCb();
                return;

            case 4: // '\004'
                updateRakutenCb();
                break;
            }
        }

        _cls22()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls18 extends ApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            DiskCache.setJsonObject("COUNTRIES", (PinterestJsonObject)apiresponse.getData());
            if (!isCountriesShown)
            {
                showCountriesDialog();
            }
        }

        _cls18()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls1 extends com.pinterest.api.remote.MyUserApi.MyUserApiResponse
    {

        final AccountSettingsFragment this$0;

        public void onSuccess(User user)
        {
            super.onSuccess(user);
            updateUi();
        }

        _cls1(boolean flag)
        {
            this$0 = AccountSettingsFragment.this;
            super(flag);
        }
    }


    private class _cls17 extends ApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            apiresponse = (PinterestJsonObject)apiresponse.getData();
            String s = LocaleUtils.getCountryFromCode(apiresponse.a("country", ""));
            if (_country != null)
            {
                _country.setText(s);
            }
            User user = MyUser.get();
            if (user == null)
            {
                return;
            } else
            {
                user.setPersonalizeFromOffsiteBrowsing(apiresponse.a("personalize_from_offsite_browsing"));
                user.setAdsCustomizeFromConversion(apiresponse.a("ads_customize_from_conversion"));
                user.setExcludeFromSearch(apiresponse.a("exclude_from_search"));
                user.setHideFromNews(apiresponse.a("hide_from_news"));
                LocaleUtils.saveLocale(LocaleUtils.getLang(), s);
                MyUser.saveUserSettingsMe(apiresponse);
                return;
            }
        }

        _cls17()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls13
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            actuallyDisconnectFb();
            dialog.dismiss();
        }

        _cls13()
        {
            this$0 = AccountSettingsFragment.this;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls14
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            facebookCb.setChecked(true);
            dialog.dismiss();
        }

        _cls14()
        {
            this$0 = AccountSettingsFragment.this;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls15
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDismissListener
    {

        final AccountSettingsFragment this$0;

        public void onDismiss(BaseDialog basedialog)
        {
            facebookCb.setChecked(true);
        }

        _cls15()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls19
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            actuallyDisconnectGplus();
            dialog.dismiss();
        }

        _cls19()
        {
            this$0 = AccountSettingsFragment.this;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls20
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            gplusCb.setChecked(true);
            dialog.dismiss();
        }

        _cls20()
        {
            this$0 = AccountSettingsFragment.this;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls21
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDismissListener
    {

        final AccountSettingsFragment this$0;

        public void onDismiss(BaseDialog basedialog)
        {
            gplusCb.setChecked(true);
        }

        _cls21()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            actuallyDisconnectRakuten();
            dialog.dismiss();
        }

        _cls5()
        {
            this$0 = AccountSettingsFragment.this;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls6
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            rakutenCb.setChecked(true);
            dialog.dismiss();
        }

        _cls6()
        {
            this$0 = AccountSettingsFragment.this;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls7
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDismissListener
    {

        final AccountSettingsFragment this$0;

        public void onDismiss(BaseDialog basedialog)
        {
            rakutenCb.setChecked(true);
        }

        _cls7()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }


    private class _cls23
    {

        static final int $SwitchMap$com$pinterest$base$Social$Network[];

        static 
        {
            $SwitchMap$com$pinterest$base$Social$Network = new int[com.pinterest.base.Social.Network.values().length];
            try
            {
                $SwitchMap$com$pinterest$base$Social$Network[com.pinterest.base.Social.Network.FACEBOOK.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$base$Social$Network[com.pinterest.base.Social.Network.GPLUS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$base$Social$Network[com.pinterest.base.Social.Network.TWITTER.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$base$Social$Network[com.pinterest.base.Social.Network.RAKUTEN.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls9
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final SimpleTextDialog val$dialog;
        final String val$methodName;

        public void onClick(View view)
        {
            try
            {
                com/pinterest/activity/settings/AccountSettingsFragment.getDeclaredMethod(methodName, null).invoke(AccountSettingsFragment.this, null);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                CrashReporting.logHandledException(view);
            }
            dialog.dismiss();
        }

        _cls9()
        {
            this$0 = AccountSettingsFragment.this;
            methodName = s;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls10
        implements android.view.View.OnClickListener
    {

        final AccountSettingsFragment this$0;
        final CheckedTextView val$cb;
        final SimpleTextDialog val$dialog;

        public void onClick(View view)
        {
            cb.setChecked(true);
            dialog.dismiss();
        }

        _cls10()
        {
            this$0 = AccountSettingsFragment.this;
            cb = checkedtextview;
            dialog = simpletextdialog;
            super();
        }
    }


    private class _cls11
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDismissListener
    {

        final AccountSettingsFragment this$0;
        final CheckedTextView val$cb;

        public void onDismiss(BaseDialog basedialog)
        {
            cb.setChecked(true);
        }

        _cls11()
        {
            this$0 = AccountSettingsFragment.this;
            cb = checkedtextview;
            super();
        }
    }


    private class _cls16 extends ApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onFinish()
        {
            super.onFinish();
            updateFacebookCbs();
        }

        public void onSuccess(PinterestJsonObject pinterestjsonobject)
        {
            super.onSuccess(pinterestjsonobject);
            Pinalytics.a(EventType.USER_DISABLE_FACBOOK, "0");
            Preferences.user().set("PREF_CONNETED_FACEBOOK", false);
            Social.tryCloseFacebookSession();
        }

        _cls16(boolean flag)
        {
            this$0 = AccountSettingsFragment.this;
            super(flag);
        }
    }


    private class _cls8 extends ApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onFinish()
        {
            super.onFinish();
            updateRakutenCb();
        }

        public void onSuccess(PinterestJsonArray pinterestjsonarray)
        {
            super.onSuccess(pinterestjsonarray);
            Pinalytics.a(EventType.USER_DISABLE_RAKUTEN, "0");
            Preferences.user().set("PREF_CONNETED_RAKUTEN", false);
        }

        _cls8(boolean flag)
        {
            this$0 = AccountSettingsFragment.this;
            super(flag);
        }
    }


    private class _cls12 extends ApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onFinish()
        {
            super.onFinish();
            updateTwitterCb();
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            Pinalytics.a(EventType.USER_DISABLE_TWITTER, "0");
            Preferences.user().set("PREF_CONNETED_TWITTER", false);
        }

        _cls12(boolean flag)
        {
            this$0 = AccountSettingsFragment.this;
            super(flag);
        }
    }


    private class ClearSearchHistoryApiResponseHandler extends BaseApiResponseHandler
    {

        final AccountSettingsFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            Application.showToast(apiresponse.getMessage());
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            Application.showToast(0x7f0e03d1);
        }

        ClearSearchHistoryApiResponseHandler()
        {
            this$0 = AccountSettingsFragment.this;
            super();
        }
    }

}
