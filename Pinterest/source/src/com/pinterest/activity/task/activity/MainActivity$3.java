// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.contacts.UploadContactsUtil;
import com.pinterest.activity.explore.util.ExploreInterestsData;
import com.pinterest.activity.pin.events.SocialShareEvent;
import com.pinterest.activity.task.adapter.MainViewAdapter;
import com.pinterest.activity.task.event.CommandEvent;
import com.pinterest.activity.task.event.ToastEvent;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.task.model.NavigationList;
import com.pinterest.activity.task.view.MainViewPager;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Events;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.ui.megaphone.HomeNagEvent;
import com.pinterest.ui.megaphone.NagUtils;
import com.pinterest.ui.menu.BoardContextMenu;
import com.pinterest.ui.menu.PinContextMenu;
import com.pinterest.ui.menu.ShowBoardContextMenuEvent;
import com.pinterest.ui.menu.ShowPinContextMenuEvent;

// Referenced classes of package com.pinterest.activity.task.activity:
//            MainActivity

class this._cls0 extends com.pinterest.base.bscriber
{

    final MainActivity this$0;

    public void onEventMainThread(SocialShareEvent socialshareevent)
    {
        MainActivity.access$202(MainActivity.this, socialshareevent);
        socialshareevent = ((com.facebook.widget.ShareDialogBuilder)(new com.facebook.widget.ShareDialogBuilder(MainActivity.this)).setLink(socialshareevent.link)).build();
        MainActivity.access$300(MainActivity.this).trackPendingDialogCall(socialshareevent.present());
    }

    public void onEventMainThread(CommandEvent commandevent)
    {
        switch (commandevent.getId())
        {
        default:
            return;

        case 1: // '\001'
            MainActivity.access$400(MainActivity.this);
            return;

        case 2: // '\002'
            MainActivity.access$500(MainActivity.this);
            return;

        case 3: // '\003'
            UploadContactsUtil.setStoreContacts(true);
            return;

        case 4: // '\004'
            Events.post(new com.pinterest.base.onnectEvent(com.pinterest.base.FACEBOOK));
            return;

        case 5: // '\005'
            Experiences.c().d(Experiences.b);
            return;

        case 6: // '\006'
            Events.post(new com.pinterest.activity.nux.fragment.gment.UndoRebuildFeedEvent());
            break;
        }
    }

    public void onEventMainThread(ToastEvent toastevent)
    {
        show(toastevent.getToast());
    }

    public void onEventMainThread(com.pinterest.activity.task.model.ve ve)
    {
        if (MainActivity.access$700(MainActivity.this) != null)
        {
            MainActivity.access$700(MainActivity.this).remove(ve.getNavigationItems());
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
        if (MainActivity.access$600(MainActivity.this) >= 0)
        {
            ActivityHelper.goSplash(MainActivity.this);
            finish();
            return;
        } else
        {
            int _tmp = MainActivity.access$608(MainActivity.this);
            show(new Navigation[] {
                navigation
            });
            return;
        }
    }

    public void onEventMainThread(NavigationList navigationlist)
    {
        show(navigationlist);
    }

    public void onEventMainThread(com.pinterest.activity.task.view.ontrolEvent ontrolevent)
    {
        if (MainActivity.access$000(MainActivity.this) == null)
        {
            return;
        }
        switch (ontrolevent.getType())
        {
        default:
            return;

        case 0: // '\0'
            MainActivity.access$000(MainActivity.this).setEnabled(false);
            return;

        case 1: // '\001'
            MainActivity.access$000(MainActivity.this).setEnabled(true);
            return;

        case 2: // '\002'
            ontrolevent = new AnimatorSet();
            ontrolevent.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(MainActivity.access$000(MainActivity.this), "alpha", new float[] {
                    0.7F
                }), ObjectAnimator.ofFloat(MainActivity.access$000(MainActivity.this), "scaleX", new float[] {
                    0.87F
                }), ObjectAnimator.ofFloat(MainActivity.access$000(MainActivity.this), "scaleY", new float[] {
                    0.87F
                })
            });
            ontrolevent.setInterpolator(new DecelerateInterpolator());
            ontrolevent.setDuration(320L);
            ontrolevent.start();
            return;

        case 3: // '\003'
            ontrolevent = new AnimatorSet();
            break;
        }
        ontrolevent.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(MainActivity.access$000(MainActivity.this), "alpha", new float[] {
                1.0F
            }), ObjectAnimator.ofFloat(MainActivity.access$000(MainActivity.this), "scaleX", new float[] {
                1.0F
            }), ObjectAnimator.ofFloat(MainActivity.access$000(MainActivity.this), "scaleY", new float[] {
                1.0F
            })
        });
        ontrolevent.setInterpolator(new DecelerateInterpolator());
        ontrolevent.setDuration(360L);
        ontrolevent.start();
    }

    public void onEventMainThread(com.pinterest.api.model.nt nt)
    {
        Events.removeStickyEvent(nt);
    }

    public void onEventMainThread(com.pinterest.api.model. )
    {
        if (MainActivity.access$700(MainActivity.this) != null && .wasDeleted())
        {
            MainActivity.access$700(MainActivity.this).remove(new Navigation(Location.PIN, .getPin()));
        }
    }

    public void onEventMainThread(com.pinterest.experience.erienceEvent erienceevent)
    {
        if (Experiences.a.equalsIgnoreCase(erienceevent.a))
        {
            NagUtils.showNag(Experiences.a, new HomeNagEvent());
        } else
        if (Experiences.b.equalsIgnoreCase(erienceevent.a))
        {
            erienceevent = Experiences.b(erienceevent.a);
            if (erienceevent != null && ((ExperienceValue) (erienceevent)).f != null)
            {
                ActivityHelper.goNUXExperience(MainActivity.this);
                return;
            }
        }
    }

    public void onEventMainThread(com.pinterest.experiment.erimentsLoaded erimentsloaded)
    {
        if (Experiments.e())
        {
            ExploreInterestsData.refreshIfNecessary();
        }
        if (Experiments.p() && !Preferences.persisted().getBoolean("PREF_REALM_DB_POPULATED", false))
        {
            (new pulateRealmTask(MainActivity.this)).execute();
        }
    }

    public void onEventMainThread(com.pinterest.ui.actionsheet.ment.ActionSheetEvent actionsheetevent)
    {
        FragmentHelper.replaceFragment(getSupportFragmentManager(), 0x7f0b0070, actionsheetevent.getFragment(), true, com.pinterest.activity.Animation.NONE);
    }

    public void onEventMainThread(ShowBoardContextMenuEvent showboardcontextmenuevent)
    {
        (new BoardContextMenu()).show(MainActivity.access$100(MainActivity.this), showboardcontextmenuevent.getBoard());
    }

    public void onEventMainThread(ShowPinContextMenuEvent showpincontextmenuevent)
    {
        (new PinContextMenu()).show(MainActivity.access$100(MainActivity.this), showpincontextmenuevent.getPin());
    }

    ionSheetEvent()
    {
        this$0 = MainActivity.this;
        super();
    }
}
