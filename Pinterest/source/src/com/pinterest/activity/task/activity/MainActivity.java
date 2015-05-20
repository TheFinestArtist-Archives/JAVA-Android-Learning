// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.facebook.Session;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.WebDialog;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.conversation.ConversationFragment;
import com.pinterest.activity.pin.events.SocialShareEvent;
import com.pinterest.activity.search.model.TypeAheadRealmItem;
import com.pinterest.activity.task.adapter.MainViewAdapter;
import com.pinterest.activity.task.education.event.EducationEvent;
import com.pinterest.activity.task.education.view.EducationContainerView;
import com.pinterest.activity.task.event.CommandEvent;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.event.ToastEvent;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.task.model.NavigationList;
import com.pinterest.activity.task.toast.BaseToast;
import com.pinterest.activity.task.toast.view.ToastContainer;
import com.pinterest.activity.task.view.MainViewPager;
import com.pinterest.activity.web.fragment.WebViewFragment;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.AccountApi;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;
import com.pinterest.base.Social;
import com.pinterest.base.StopWatch;
import com.pinterest.experiment.Experiments;
import com.pinterest.gcm.GcmRegistrar;
import com.pinterest.kit.activity.BaseActivity;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.notification.AppRater;
import com.pinterest.kit.utils.AppUtils;
import com.pinterest.kit.utils.FileUtils;
import com.pinterest.kit.utils.WebViewUtils;
import com.pinterest.rwd.RwdManager;
import com.pinterest.ui.menu.ContextMenuView;
import com.pinterest.ui.menu.ShowBoardContextMenuEvent;
import com.pinterest.ui.menu.ShowPinContextMenuEvent;
import io.realm.Realm;
import io.realm.RealmResults;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;

public class MainActivity extends BaseActivity
{

    private static final long BG_SERVICES_STARTUP_DELAY = 5000L;
    private static long INACTIVITY_LIMIT = 0L;
    private static final int MAX_UNAUTH_FRAGMENTS = 0;
    private static final int NUX_FALLBACK_ED_DELAY = 2000;
    public static final String TAG = "MainActivity";
    private ContextMenuView _contextMenu;
    private int _currentItem;
    private int _currentUnauthCount;
    private EducationContainerView _educationContainer;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private Handler _handler;
    private Handler _inactivityHandler;
    private MainViewAdapter _mainAdapter;
    private MainViewPager _mainPager;
    private Navigation _pendingNavigation;
    private ToastContainer _toastContainer;
    private Runnable onInactivity;

    public MainActivity()
    {
        _handler = new Handler();
        _eventsSubscriber = new _cls3();
        onInactivity = new _cls7();
        _inactivityHandler = new Handler(Looper.getMainLooper());
    }

    private void checkRoutes(Navigation navigation)
    {
        checkRoutes(navigation, null);
    }

    private void checkRoutes(Navigation navigation, Navigation navigation1)
    {
label0:
        {
label1:
            {
                if (navigation != null)
                {
                    if (!MyUser.hasAccessToken() && !Location.allowUnauthAccess(navigation.getLocation()))
                    {
                        break label0;
                    }
                    if (navigation1 != null)
                    {
                        break label1;
                    }
                    show(new Navigation[] {
                        navigation
                    });
                }
                return;
            }
            show(new Navigation[] {
                navigation1, navigation
            });
            return;
        }
        ActivityHelper.goSplash(this);
        finish();
    }

    private void confirmEmail()
    {
        if (MyUser.get() == null)
        {
            return;
        } else
        {
            MyUserApi.a(new _cls6(), getApiTag());
            return;
        }
    }

    private Navigation getPendingNavigation(Intent intent)
    {
        if (intent == null)
        {
            return null;
        }
        android.os.Parcelable parcelable = intent.getParcelableExtra("com.pinterest.EXTRA_PENDING_TASK");
        if (parcelable instanceof Navigation)
        {
            intent.removeExtra("com.pinterest.EXTRA_PENDING_TASK");
            return (Navigation)parcelable;
        } else
        {
            return null;
        }
    }

    private void initAutoCompleteCache()
    {
        Object obj;
        Object obj1;
        String s1;
        BufferedReader bufferedreader;
        Realm realm;
        boolean flag;
        obj = null;
        obj1 = null;
        s1 = null;
        bufferedreader = null;
        flag = false;
        realm = Realm.getInstance(this, AppUtils.getRealmKey());
        String s = FileUtils.decryptFile(new SecretKeySpec(FileUtils.hexStringToByteArray(AppUtils.getApplicationMetadata(Application.context().getPackageName(), "AutoCompleteFileSecret")), "AES"), "AES/CBC/PKCS5Padding", "ac.gzip.enc", getCacheDir());
        obj = bufferedreader;
        obj1 = s1;
        s1 = FileUtils.unzipFile(new File(getCacheDir(), s), getCacheDir());
        obj = s1;
        obj1 = s1;
        if (StringUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        obj = s1;
        obj1 = s1;
        bufferedreader = new BufferedReader(new FileReader(new File(getCacheDir(), s1)));
        obj = s1;
        obj1 = s1;
        realm.beginTransaction();
_L3:
        obj = s1;
        obj1 = s1;
        String s2 = bufferedreader.readLine();
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s1;
        obj1 = s1;
        TypeAheadRealmItem typeaheadrealmitem = (TypeAheadRealmItem)realm.createObject(com/pinterest/activity/search/model/TypeAheadRealmItem);
        obj = s1;
        obj1 = s1;
        typeaheadrealmitem.setQuery(s2.split("\t")[0]);
        obj = s1;
        obj1 = s1;
        typeaheadrealmitem.setScore(Float.valueOf(s2.split("\t")[1]).floatValue());
        if (true) goto _L3; else goto _L2
        obj1;
_L7:
        CrashReporting.logHandledException(((Throwable) (obj1)));
        if (realm != null)
        {
            realm.commitTransaction();
        }
        FileUtils.deleteFile(getCacheDir(), ((String) (obj)));
        FileUtils.deleteFile(getCacheDir(), s);
        realm.close();
        return;
_L2:
        if (realm != null)
        {
            realm.commitTransaction();
        }
        if (realm.allObjects(com/pinterest/activity/search/model/TypeAheadRealmItem).size() > 0)
        {
            Preferences.persisted().set("PREF_REALM_DB_POPULATED", true);
        }
        FileUtils.deleteFile(getCacheDir(), s1);
        FileUtils.deleteFile(getCacheDir(), s);
        realm.close();
        return;
        Exception exception;
        exception;
        s = null;
        obj = obj1;
_L5:
        if (realm != null)
        {
            realm.commitTransaction();
        }
        if (!flag && realm.allObjects(com/pinterest/activity/search/model/TypeAheadRealmItem).size() > 0)
        {
            Preferences.persisted().set("PREF_REALM_DB_POPULATED", true);
        }
        FileUtils.deleteFile(getCacheDir(), ((String) (obj)));
        FileUtils.deleteFile(getCacheDir(), s);
        realm.close();
        throw exception;
        exception;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        exception;
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
        s = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void publishFeedDialog(SocialShareEvent socialshareevent)
    {
        Bundle bundle = new Bundle();
        bundle.putString("link", socialshareevent.link);
        socialshareevent = Session.getActiveSession();
        if (!socialshareevent.isOpened())
        {
            socialshareevent.openForRead((new com.facebook.Session.OpenRequest(this)).setPermissions(Social.FB_READ_PERMISSIONS).setCallback(new _cls4()));
        }
        socialshareevent = new com.facebook.widget.WebDialog.FeedDialogBuilder(this, Session.getActiveSession(), bundle);
        socialshareevent.setOnCompleteListener(new _cls5());
        socialshareevent.build().show();
    }

    private void resetPassword()
    {
        if (MyUser.get() == null)
        {
            return;
        } else
        {
            AccountApi.b(MyUser.get().getEmail(), new com.pinterest.api.remote.AccountApi.ResetPasswordApiResponse());
            return;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (_contextMenu.isShown())
        {
            return _contextMenu.dispatchTouchEvent(motionevent);
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    public BaseFragment getActiveFragment()
    {
        return getFragment(_mainPager.getCurrentItem());
    }

    public BaseFragment getFragment(int i)
    {
        ArrayList arraylist;
        if (_mainAdapter != null && _mainPager != null)
        {
            if ((arraylist = _mainAdapter.getFragments()) != null && i + 1 <= arraylist.size())
            {
                return (BaseFragment)arraylist.get(i);
            }
        }
        return null;
    }

    public Navigation getNavigationSource(String s)
    {
        if (_mainAdapter != null)
        {
            return _mainAdapter.getNavigationSource(s);
        } else
        {
            return null;
        }
    }

    public void onBackPressed()
    {
        Pinalytics.f();
        if (!MyUser.hasAccessToken())
        {
            ActivityHelper.goSplash(this);
            finish();
        } else
        {
            if (_educationContainer.isActive())
            {
                Events.post(new EducationEvent(com.pinterest.activity.task.education.event.EducationEvent.Type.DISMISS_UI));
                return;
            }
            if (_mainPager == null)
            {
                super.onBackPressed();
                return;
            }
            boolean flag;
            if ((getActiveFragment() instanceof ConversationFragment) && !((ConversationFragment)getActiveFragment()).addPinVisible())
            {
                boolean flag1 = _mainPager.onBackPressed();
                flag = flag1;
                if (!flag1)
                {
                    boolean flag2 = getSupportFragmentManager().popBackStackImmediate();
                    flag = flag2;
                    if (flag2)
                    {
                        Pinalytics.a(getActiveFragment());
                        flag = flag2;
                    }
                }
            } else
            {
                flag = getSupportFragmentManager().popBackStackImmediate();
                if (flag)
                {
                    Pinalytics.a(getActiveFragment());
                }
                if (flag || _mainPager.onBackPressed())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            if (!flag)
            {
                super.onBackPressed();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        if (bundle != null && (ApplicationInfo.isStale(bundle) || ModelHelper.SHOULD_CLEAR_SESSION))
        {
            bundle.clear();
            Experiments.t();
            ModelHelper.SHOULD_CLEAR_SESSION = false;
        }
        super.onCreate(bundle);
        AppRater.conditionalShowRateDialog(this);
        GcmRegistrar.a(this);
        _autoAnalytics = false;
        setContentView(0x7f030022);
        _mainAdapter = new MainViewAdapter(getSupportFragmentManager());
        boolean flag;
        if (bundle != null)
        {
            _currentItem = bundle.getInt("_currentItem", 0);
            _mainAdapter.setNavigationItems(bundle.getParcelableArrayList("_tasks"));
            if (_mainAdapter.getCount() <= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = true;
        }
        _educationContainer = (EducationContainerView)findViewById(0x7f0b006f);
        _educationContainer.setFragmentManager(getSupportFragmentManager());
        _toastContainer = (ToastContainer)findViewById(0x7f0b006e);
        _mainPager = (MainViewPager)findViewById(0x7f0b006b);
        _mainAdapter.setPager(_mainPager);
        _mainPager.setOffscreenPageLimit(3);
        _mainPager.setPageMargin(0);
        _mainPager.setAdapter(_mainAdapter);
        _mainPager.setCurrentItem(_currentItem);
        _contextMenu = (ContextMenuView)findViewById(0x7f0b006c);
        _currentUnauthCount = 0;
        _pendingNavigation = getPendingNavigation(getIntent());
        bundle = Location.HOME;
        if (!flag || !MyUser.hasAccessToken()) goto _L2; else goto _L1
_L1:
        bundle = new Navigation(bundle, MyUser.getUid());
        if (_pendingNavigation == null)
        {
            show(new Navigation[] {
                bundle
            });
        } else
        {
            show(new Navigation[] {
                bundle, _pendingNavigation
            });
        }
_L4:
        _handler.postDelayed(new _cls1(), 5000L);
        return;
_L2:
        if (_pendingNavigation != null)
        {
            checkRoutes(_pendingNavigation);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDestroy()
    {
        Events.unregister(_eventsSubscriber);
        StopWatch.get().invalidateAll();
        super.onDestroy();
        if (RwdManager.b())
        {
            RwdManager.a().d();
        }
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent)
    {
        if (_mainPager != null)
        {
            return _mainPager.onKeyLongPress(i, keyevent);
        } else
        {
            return super.onKeyLongPress(i, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        _pendingNavigation = getPendingNavigation(intent);
        checkRoutes(_pendingNavigation);
        if (!isVisible())
        {
            setIntent(intent);
        }
    }

    protected void onPause()
    {
        _inactivityHandler.removeCallbacks(onInactivity);
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/api/model/Pin$UpdateEvent, com/pinterest/api/model/Board$UpdateEvent, com/pinterest/activity/pin/events/SocialShareEvent, com/pinterest/ui/menu/ShowPinContextMenuEvent, com/pinterest/ui/menu/ShowBoardContextMenuEvent, com/pinterest/experiment/Experiments$ExperimentsLoaded, com/pinterest/ui/actionsheet/ActionSheetFragment$ActionSheetEvent
        });
        StopWatch.get().invalidate("ttrfp");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (_mainPager != null)
        {
            final int page = _mainPager.getCurrentItem();
            _mainPager.postDelayed(new _cls2(), 100L);
        }
        _inactivityHandler.postDelayed(onInactivity, INACTIVITY_LIMIT);
        Events.register(_eventsSubscriber, com/pinterest/ui/menu/ShowPinContextMenuEvent, new Class[] {
            com/pinterest/ui/menu/ShowBoardContextMenuEvent, com/pinterest/experiment/Experiments$ExperimentsLoaded, com/pinterest/ui/actionsheet/ActionSheetFragment$ActionSheetEvent
        });
        Events.registerSticky(_eventsSubscriber, com/pinterest/api/model/Pin$UpdateEvent, new Class[] {
            com/pinterest/api/model/Board$UpdateEvent, com/pinterest/activity/pin/events/SocialShareEvent
        });
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("_currentItem", _mainPager.getCurrentItem());
        bundle.putParcelableArrayList("_tasks", _mainAdapter.getNavigationItems());
        bundle.putLong("PREF_LAST_SAVED_INSTANCE_TIME", SystemClock.elapsedRealtime());
    }

    protected void onStart()
    {
        Events.register(_eventsSubscriber, com/pinterest/activity/task/model/Navigation, new Class[] {
            com/pinterest/activity/task/event/ToastEvent, com/pinterest/activity/task/view/MainViewPager$ControlEvent, com/pinterest/activity/task/model/Navigation$Remove, com/pinterest/activity/task/event/CommandEvent, com/pinterest/activity/task/model/NavigationList, com/pinterest/experience/Experiences$ExperienceEvent
        });
        tryEducation();
        super.onStart();
    }

    protected void onStop()
    {
        Events.unregister(_eventsSubscriber);
        super.onStop();
    }

    public void onUserInteraction()
    {
        super.onUserInteraction();
        _inactivityHandler.removeCallbacks(onInactivity);
        _inactivityHandler.postDelayed(onInactivity, INACTIVITY_LIMIT);
    }

    protected void show(BaseToast basetoast)
    {
        if (_toastContainer != null)
        {
            _toastContainer.addToast(basetoast);
        }
    }

    protected void show(List list)
    {
        Navigation navigation = null;
        if (list != null && list.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist;
        Iterator iterator;
        int j;
        Events.post(new DialogEvent(null));
        arraylist = new ArrayList();
        iterator = list.iterator();
        j = -1;
_L3:
        int i;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_263;
            }
            Navigation navigation2 = (Navigation)iterator.next();
            Navigation navigation1;
            ArrayList arraylist1;
            if (navigation2.getDisplayMode() == com.pinterest.activity.task.model.Navigation.DisplayMode.MODAL)
            {
                arraylist.add(navigation2);
                navigation1 = navigation2;
            } else
            {
                switch (_cls8..SwitchMap.com.pinterest.activity.task.model.Location[navigation2.getLocation().ordinal()])
                {
                default:
                    navigation1 = navigation;
                    break;

                case 1: // '\001'
                    navigation1 = navigation;
                    if (WebViewUtils.shouldUseExternalBrowser(navigation2.getId()))
                    {
                        Pinalytics.a(this, com/pinterest/activity/web/fragment/WebViewFragment);
                        ActivityHelper.goIntentView(this, navigation2.getId());
                        arraylist.add(navigation2);
                        navigation1 = navigation;
                    }
                    break;

                case 2: // '\002'
                    MyUser.clearAccessToken();
                    ActivityHelper.goSplashLogin(this);
                    finish();
                    return;
                }
            }
            navigation = navigation1;
        } while (!Location.isRootLocation(navigation2));
        arraylist1 = _mainPager.getAdapter().getNavigationItems();
        i = 0;
_L4:
        navigation = navigation1;
        if (i < arraylist1.size())
        {
label0:
            {
                if (!((Navigation)arraylist1.get(i)).equalsIgnoreCreatedAt(navigation2))
                {
                    break label0;
                }
                navigation = navigation1;
                j = i;
            }
        }
          goto _L3
        i++;
          goto _L4
        list.removeAll(arraylist);
        if (_mainPager != null && _mainAdapter != null)
        {
            if (j >= 0)
            {
                _mainPager.popTo(j);
            } else
            {
                _mainAdapter.push(list);
                _mainPager.setCurrentItem(_mainAdapter.getCount() - 1, true);
            }
        }
        if (navigation != null)
        {
            try
            {
                list = (BaseFragment)navigation.getFragmentClass().newInstance();
                list.setNavigation(navigation);
                FragmentHelper.replaceFragment(getSupportFragmentManager(), 0x7f0b006d, list, true, com.pinterest.activity.FragmentHelper.Animation.MODAL);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                list.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                list.printStackTrace();
            }
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected transient void show(Navigation anavigation[])
    {
        show(((List) (new ArrayList(Arrays.asList(anavigation)))));
    }

    public void tryEducation()
    {
        if (Preferences.user().getBoolean("PREF_POST_SINGUP", false))
        {
            ActivityHelper.setPostSignup(false);
        }
    }

    static 
    {
        INACTIVITY_LIMIT = 10000L;
    }




/*
    static SocialShareEvent access$202(MainActivity mainactivity, SocialShareEvent socialshareevent)
    {
        mainactivity._lastShare = socialshareevent;
        return socialshareevent;
    }

*/






/*
    static int access$608(MainActivity mainactivity)
    {
        int i = mainactivity._currentUnauthCount;
        mainactivity._currentUnauthCount = i + 1;
        return i;
    }

*/




    private class _cls3 extends com.pinterest.base.Events.EventsSubscriber
    {

        final MainActivity this$0;

        public void onEventMainThread(SocialShareEvent socialshareevent)
        {
            socialshareevent.post = socialshareevent;
            socialshareevent = ((com.facebook.widget.FacebookDialog.ShareDialogBuilder)(new com.facebook.widget.FacebookDialog.ShareDialogBuilder(MainActivity.this)).setLink(socialshareevent.link)).build();
            getFacebookHelper().trackPendingDialogCall(socialshareevent.present());
        }

        public void onEventMainThread(CommandEvent commandevent)
        {
            switch (commandevent.getId())
            {
            default:
                return;

            case 1: // '\001'
                confirmEmail();
                return;

            case 2: // '\002'
                resetPassword();
                return;

            case 3: // '\003'
                UploadContactsUtil.setStoreContacts(true);
                return;

            case 4: // '\004'
                Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.FACEBOOK));
                return;

            case 5: // '\005'
                Experiences.c().d(Experiences.b);
                return;

            case 6: // '\006'
                Events.post(new com.pinterest.activity.nux.fragment.NUXEndScreenFragment.UndoRebuildFeedEvent());
                break;
            }
        }

        public void onEventMainThread(ToastEvent toastevent)
        {
            show(toastevent.getToast());
        }

        public void onEventMainThread(com.pinterest.activity.task.model.Navigation.Remove remove)
        {
            if (_mainAdapter != null)
            {
                _mainAdapter.remove(remove.getNavigationItems());
            }
        }

        public void onEventMainThread(Navigation navigation)
        {
            if (MyUser.hasAccessToken() || navigation != null && Location.BROWSER == navigation.getLocation())
            {
                show(new Navigation[] {
                    navigation
                });
                return;
            }
            if (_currentUnauthCount >= 0)
            {
                ActivityHelper.goSplash(MainActivity.this);
                finish();
                return;
            } else
            {
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void onEventMainThread(NavigationList navigationlist)
        {
            show(navigationlist);
        }

        public void onEventMainThread(com.pinterest.activity.task.view.MainViewPager.ControlEvent controlevent)
        {
            if (_mainPager == null)
            {
                return;
            }
            switch (controlevent.getType())
            {
            default:
                return;

            case 0: // '\0'
                _mainPager.setEnabled(false);
                return;

            case 1: // '\001'
                _mainPager.setEnabled(true);
                return;

            case 2: // '\002'
                controlevent = new AnimatorSet();
                controlevent.playTogether(new Animator[] {
                    ObjectAnimator.ofFloat(_mainPager, "alpha", new float[] {
                        0.7F
                    }), ObjectAnimator.ofFloat(_mainPager, "scaleX", new float[] {
                        0.87F
                    }), ObjectAnimator.ofFloat(_mainPager, "scaleY", new float[] {
                        0.87F
                    })
                });
                controlevent.setInterpolator(new DecelerateInterpolator());
                controlevent.setDuration(320L);
                controlevent.start();
                return;

            case 3: // '\003'
                controlevent = new AnimatorSet();
                break;
            }
            controlevent.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(_mainPager, "alpha", new float[] {
                    1.0F
                }), ObjectAnimator.ofFloat(_mainPager, "scaleX", new float[] {
                    1.0F
                }), ObjectAnimator.ofFloat(_mainPager, "scaleY", new float[] {
                    1.0F
                })
            });
            controlevent.setInterpolator(new DecelerateInterpolator());
            controlevent.setDuration(360L);
            controlevent.start();
        }

        public void onEventMainThread(com.pinterest.api.model.Board.UpdateEvent updateevent)
        {
            Events.removeStickyEvent(updateevent);
        }

        public void onEventMainThread(com.pinterest.api.model.Pin.UpdateEvent updateevent)
        {
            if (_mainAdapter != null && updateevent.wasDeleted())
            {
                _mainAdapter.remove(new Navigation(Location.PIN, updateevent.getPin()));
            }
        }

        public void onEventMainThread(com.pinterest.experience.Experiences.ExperienceEvent experienceevent)
        {
            if (Experiences.a.equalsIgnoreCase(experienceevent.a))
            {
                NagUtils.showNag(Experiences.a, new HomeNagEvent());
            } else
            if (Experiences.b.equalsIgnoreCase(experienceevent.a))
            {
                experienceevent = Experiences.b(experienceevent.a);
                if (experienceevent != null && ((ExperienceValue) (experienceevent)).f != null)
                {
                    ActivityHelper.goNUXExperience(MainActivity.this);
                    return;
                }
            }
        }

        public void onEventMainThread(com.pinterest.experiment.Experiments.ExperimentsLoaded experimentsloaded)
        {
            if (Experiments.e())
            {
                ExploreInterestsData.refreshIfNecessary();
            }
            if (Experiments.p() && !Preferences.persisted().getBoolean("PREF_REALM_DB_POPULATED", false))
            {
                (new PopulateRealmTask()).execute();
            }
        }

        public void onEventMainThread(com.pinterest.ui.actionsheet.ActionSheetFragment.ActionSheetEvent actionsheetevent)
        {
            FragmentHelper.replaceFragment(getSupportFragmentManager(), 0x7f0b0070, actionsheetevent.getFragment(), true, com.pinterest.activity.FragmentHelper.Animation.NONE);
        }

        public void onEventMainThread(ShowBoardContextMenuEvent showboardcontextmenuevent)
        {
            (new BoardContextMenu()).show(_contextMenu, showboardcontextmenuevent.getBoard());
        }

        public void onEventMainThread(ShowPinContextMenuEvent showpincontextmenuevent)
        {
            (new PinContextMenu()).show(_contextMenu, showpincontextmenuevent.getPin());
        }

        _cls3()
        {
            this$0 = MainActivity.this;
            super();
        }

        private class PopulateRealmTask extends BackgroundTask
        {

            final MainActivity this$0;

            public void run()
            {
                initAutoCompleteCache();
            }

            PopulateRealmTask()
            {
                this$0 = MainActivity.this;
                BackgroundTask();
            }
        }

    }


    private class _cls7
        implements Runnable
    {

        final MainActivity this$0;

        public void run()
        {
            Events.post(new GlobalInactvitiyEvent());
        }

        _cls7()
        {
            this$0 = MainActivity.this;
            super();
        }
    }


    private class _cls6 extends ApiResponseHandler
    {

        final MainActivity this$0;
        final String val$email;

        public void onSuccess(ApiResponse apiresponse)
        {
            Application.showToast(Resources.string(0x7f0e0111, new Object[] {
                email
            }));
        }

        _cls6()
        {
            this$0 = MainActivity.this;
            email = s;
            super();
        }
    }


    private class _cls4
        implements com.facebook.Session.StatusCallback
    {

        final MainActivity this$0;

        public void call(Session session, SessionState sessionstate, Exception exception)
        {
            if (exception != null)
            {
                return;
            } else
            {
                MyUserApi.a(session.getAccessToken(), getApiTag());
                return;
            }
        }

        _cls4()
        {
            this$0 = MainActivity.this;
            super();
        }
    }


    private class _cls5
        implements com.facebook.widget.WebDialog.OnCompleteListener
    {

        final MainActivity this$0;

        public void onComplete(Bundle bundle, FacebookException facebookexception)
        {
            if (facebookexception == null)
            {
                bundle = bundle.getString("post_id");
                if (bundle != null)
                {
                    Application.showToast((new StringBuilder("Posted story, id: ")).append(bundle).toString());
                    return;
                } else
                {
                    Application.showToast("Publish cancelled");
                    return;
                }
            }
            if (facebookexception instanceof FacebookOperationCanceledException)
            {
                Application.showToast("Publish cancelled");
                return;
            } else
            {
                Application.showToast("Error posting story");
                return;
            }
        }

        _cls5()
        {
            this$0 = MainActivity.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final MainActivity this$0;

        public void run()
        {
            Services.startBackgroundService();
        }

        _cls1()
        {
            this$0 = MainActivity.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final MainActivity this$0;
        final int val$page;

        public void run()
        {
            if (page == _mainPager.getCurrentItem())
            {
                _mainPager.handlePageSelected(page);
            }
        }

        _cls2()
        {
            this$0 = MainActivity.this;
            page = i;
            super();
        }
    }


    private class _cls8
    {

        static final int $SwitchMap$com$pinterest$activity$task$model$Location[];

        static 
        {
            $SwitchMap$com$pinterest$activity$task$model$Location = new int[Location.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$task$model$Location[Location.BROWSER.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$task$model$Location[Location.AUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
