// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.pinterest.activity.digest.adapter.DigestGridAdapter;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Interest;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinFeed;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.events.OverrideNavigationEvent;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.event.EventType;
import com.pinterest.ui.grid.pin.PinIconTextDrawable;
import com.pinterest.ui.grid.pin.PinImageDrawable;
import com.pinterest.ui.grid.pin.PinTextDrawable;
import com.pinterest.ui.menu.ShowPinContextMenuEvent;

// Referenced classes of package com.pinterest.ui.grid:
//            PinGridCell, PinterestAdapterView

class isDown extends com.pinterest.ui.etector.SimpleOnGestureListener
{

    public boolean isDown;
    public final int minTouch = ViewConfiguration.getPressedStateDuration();
    final PinGridCell this$0;
    public final int touchDelay = ViewConfiguration.getTapTimeout();

    public boolean onDown(MotionEvent motionevent)
    {
        resolveTouch(motionevent, true, false);
        return true;
    }

    public void onLongPress(MotionEvent motionevent)
    {
        resolveTouch(null, false, true);
        while (PinGridCell.access$300(PinGridCell.this) || !PinGridCell.access$400(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY())) 
        {
            return;
        }
        if (PinGridCell.access$500(PinGridCell.this))
        {
            motionevent = ComponentType.RELATED_PIN;
        } else
        {
            motionevent = ComponentType.FLOWED_PIN;
        }
        Pinalytics.a(EventType.LONG_PRESS, ElementType.PIN_SOURCE_IMAGE, motionevent, PinGridCell.access$600(PinGridCell.this).getUid(), PinGridCell.access$600(PinGridCell.this).getLoggingAuxData(PinGridCell.access$700(PinGridCell.this)));
        Events.post(new ShowPinContextMenuEvent(PinGridCell.access$600(PinGridCell.this)));
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        resolveTouch(null, false, true);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        ComponentType componenttype;
        boolean flag;
        int i = (int)(motionevent.getDownTime() - motionevent.getEventTime());
        class _cls1
            implements Runnable
        {

            final PinGridCell._cls2 this$1;

            public void run()
            {
                PinGridCell.access$800(this$0);
            }

            _cls1()
            {
                this$1 = PinGridCell._cls2.this;
                super();
            }
        }

        if (i < touchDelay)
        {
            i = touchDelay - i;
        } else
        {
            i = minTouch;
        }
        resolveTouch(motionevent, true, true);
        postDelayed(new _cls1(), i);
        if (PinGridCell.access$500(PinGridCell.this))
        {
            componenttype = ComponentType.RELATED_PIN;
        } else
        {
            componenttype = ComponentType.FLOWED_PIN;
        }
        if (!PinGridCell.access$400(PinGridCell.this).isPressed())
        {
            break MISSING_BLOCK_LABEL_1574;
        }
        Pinalytics.a(ElementType.PIN_SOURCE_IMAGE, componenttype, PinGridCell.access$600(PinGridCell.this).getUid(), PinGridCell.access$600(PinGridCell.this).getLoggingAuxData(PinGridCell.access$700(PinGridCell.this)));
        if (!PinGridCell.access$300(PinGridCell.this)) goto _L2; else goto _L1
_L1:
        Events.post(new OverrideNavigationEvent(2, PinGridCell.access$600(PinGridCell.this).getUid()));
_L3:
        playSoundEffect(0);
        flag = true;
_L4:
        int j;
        i = ((flag) ? 1 : 0);
        if (PinGridCell.access$900(PinGridCell.this))
        {
            i = ((flag) ? 1 : 0);
            if (PinGridCell.access$1000(PinGridCell.this).isPressed())
            {
                i = ((flag) ? 1 : 0);
                if (!flag)
                {
                    if (PinGridCell.access$1100(PinGridCell.this))
                    {
                        Pinalytics.a(ElementType.PIN_INTEREST, componenttype, PinGridCell.access$600(PinGridCell.this).getInterestUid());
                        Object obj;
                        if (PinGridCell.access$300(PinGridCell.this))
                        {
                            Events.post(new OverrideNavigationEvent(7, PinGridCell.access$600(PinGridCell.this).getInterestUid()));
                        } else
                        {
                            motionevent = PinGridCell.access$600(PinGridCell.this).getInterest();
                            if (motionevent != null)
                            {
                                if (motionevent.getFollowing() == null)
                                {
                                    motionevent.setFollowing(Boolean.valueOf(true));
                                }
                                StopWatch.get().start("interest_ttrfp");
                                Events.post(new Navigation(Location.INTEREST, motionevent));
                            }
                        }
                    } else
                    {
                        Pinalytics.a(ElementType.PIN_BOARD, componenttype, PinGridCell.access$600(PinGridCell.this).getBoardUid());
                        if (PinGridCell.access$300(PinGridCell.this))
                        {
                            Events.post(new OverrideNavigationEvent(4, PinGridCell.access$600(PinGridCell.this).getBoardUid()));
                        } else
                        {
                            motionevent = PinGridCell.access$600(PinGridCell.this).getBoard();
                            if (motionevent != null)
                            {
                                Events.post(new Navigation(Location.BOARD, motionevent));
                            }
                        }
                    }
                    playSoundEffect(0);
                    i = 1;
                }
            }
        }
        flag = i;
        if (PinGridCell.access$1200(PinGridCell.this).isPressed())
        {
            flag = i;
            if (i == 0)
            {
                motionevent = PinGridCell.access$600(PinGridCell.this).getBoard();
                flag = i;
                if (motionevent != null)
                {
                    Pinalytics.a(ElementType.PIN_BOARD, componenttype, motionevent.getUid());
                    if (PinGridCell.access$300(PinGridCell.this))
                    {
                        Events.post(new OverrideNavigationEvent(4, PinGridCell.access$600(PinGridCell.this).getBoardUid()));
                    } else
                    {
                        Events.post(new Navigation(Location.BOARD, motionevent));
                    }
                    playSoundEffect(0);
                    flag = true;
                }
            }
        }
        i = ((flag) ? 1 : 0);
        if (PinGridCell.access$1200(PinGridCell.this).isIconPressed())
        {
            i = ((flag) ? 1 : 0);
            if (!flag)
            {
                if (PinGridCell.access$600(PinGridCell.this).getRecommendationReason() != null)
                {
                    Pinalytics.a(ElementType.PIN_FEEDBACK_BUTTON_PFY, componenttype);
                    if (!PinGridCell.access$300(PinGridCell.this))
                    {
                        PinGridCell.access$1300(PinGridCell.this);
                    }
                }
                playSoundEffect(0);
                i = 1;
            }
        }
        flag = i;
        if (PinGridCell.access$1000(PinGridCell.this).isIconPressed())
        {
            flag = i;
            if (i == 0)
            {
                if (PinGridCell.access$600(PinGridCell.this).getPromoterUid() != null)
                {
                    Pinalytics.a(ElementType.PIN_FEEDBACK_BUTTON_PROMOTED, componenttype);
                    if (!PinGridCell.access$300(PinGridCell.this))
                    {
                        PinGridCell.access$1400(PinGridCell.this);
                    }
                }
                playSoundEffect(0);
                flag = true;
            }
        }
        i = ((flag) ? 1 : 0);
        if (PinGridCell.access$1500(PinGridCell.this))
        {
            i = ((flag) ? 1 : 0);
            if (PinGridCell.access$1000(PinGridCell.this).isPressed())
            {
                i = ((flag) ? 1 : 0);
                if (!flag)
                {
                    if (PinGridCell.access$300(PinGridCell.this))
                    {
                        Events.post(new OverrideNavigationEvent(3, PinGridCell.access$600(PinGridCell.this).getUserUid()));
                    } else
                    {
                        Pinalytics.a(ElementType.PIN_USER, componenttype, PinGridCell.access$600(PinGridCell.this).getUserUid());
                        Events.post(new Navigation(Location.USER, PinGridCell.access$600(PinGridCell.this).getUser()));
                    }
                    playSoundEffect(0);
                    i = 1;
                }
            }
        }
        flag = i;
        if (PinGridCell.access$1600(PinGridCell.this).isPressed())
        {
            flag = i;
            if (i == 0)
            {
                getContext();
                if (PinGridCell.access$600(PinGridCell.this).hasAttribution())
                {
                    Pinalytics.a(ElementType.PIN_ATTRIBUTION, componenttype);
                    if (PinGridCell.access$300(PinGridCell.this))
                    {
                        Events.post(new OverrideNavigationEvent(5, PinGridCell.access$600(PinGridCell.this).getAttrAuthorUrl()));
                    } else
                    {
                        motionevent = new Navigation(Location.BROWSER, PinGridCell.access$600(PinGridCell.this).getAttrAuthorUrl());
                        motionevent.putExtra("Referer", PinGridCell.access$600(PinGridCell.this).getPinterestLink());
                        Events.post(motionevent);
                    }
                } else
                if (PinGridCell.access$600(PinGridCell.this).getDomain() != null)
                {
                    Pinalytics.a(ElementType.PIN_DOMAIN, componenttype);
                    if (PinGridCell.access$300(PinGridCell.this))
                    {
                        Events.post(new OverrideNavigationEvent(4, PinGridCell.access$600(PinGridCell.this).getDomain()));
                    } else
                    {
                        Events.post(new Navigation(Location.DOMAIN, PinGridCell.access$600(PinGridCell.this).getDomain()));
                    }
                }
                flag = i;
                if (PinGridCell.access$300(PinGridCell.this))
                {
                    playSoundEffect(0);
                    flag = true;
                }
            }
        }
        i = ((flag) ? 1 : 0);
        if (PinGridCell.access$1700(PinGridCell.this).isPressed())
        {
            i = ((flag) ? 1 : 0);
            if (!flag)
            {
                motionevent = PinGridCell.access$600(PinGridCell.this).getBoard();
                i = ((flag) ? 1 : 0);
                if (motionevent != null)
                {
                    Pinalytics.a(ElementType.PIN_BOARD, componenttype, motionevent.getUid());
                    if (PinGridCell.access$300(PinGridCell.this))
                    {
                        Events.post(new OverrideNavigationEvent(4, PinGridCell.access$600(PinGridCell.this).getBoardUid()));
                    } else
                    {
                        Events.post(new Navigation(Location.BOARD, motionevent));
                    }
                    playSoundEffect(0);
                    i = 1;
                }
            }
        }
        flag = i;
        if (PinGridCell.access$1800(PinGridCell.this).isPressed())
        {
            flag = i;
            if (i == 0)
            {
                Pinalytics.a(ElementType.PIN_DOMAIN, componenttype);
                if (PinGridCell.access$300(PinGridCell.this))
                {
                    Events.post(new OverrideNavigationEvent(4, PinGridCell.access$600(PinGridCell.this).getDomain()));
                } else
                {
                    Events.post(new Navigation(Location.DOMAIN, PinGridCell.access$600(PinGridCell.this).getDomain()));
                }
                playSoundEffect(0);
                flag = true;
            }
        }
        i = ((flag) ? 1 : 0);
        if (PinGridCell.access$1900(PinGridCell.this).isPressed())
        {
            i = ((flag) ? 1 : 0);
            if (!flag)
            {
                playSoundEffect(0);
                i = 1;
            }
        }
        if (PinGridCell.access$1900(PinGridCell.this).isIconPressed() && i == 0)
        {
            if (PinGridCell.access$600(PinGridCell.this).getRecommendationReason() != null && !PinGridCell.access$300(PinGridCell.this))
            {
                PinGridCell.access$2000(PinGridCell.this);
            }
            playSoundEffect(0);
        }
        return true;
_L2:
        if (!(getParent() instanceof PinterestAdapterView))
        {
            break MISSING_BLOCK_LABEL_1563;
        }
        motionevent = (PinterestAdapterView)getParent();
        j = PinGridCell.access$700(PinGridCell.this);
        if (motionevent.getAdapter() instanceof PinGridAdapter)
        {
            motionevent = (PinFeed)((PinGridAdapter)motionevent.getAdapter()).getDataSource();
        } else
        if (motionevent.getAdapter() instanceof DigestGridAdapter)
        {
            obj = ((DigestGridAdapter)motionevent.getAdapter()).getPinFeed(PinGridCell.access$600(PinGridCell.this));
            j = ((PinFeed) (obj)).getItemIndex(PinGridCell.access$600(PinGridCell.this));
            motionevent = ((MotionEvent) (obj));
            if (obj != null)
            {
                j = ((PinFeed) (obj)).getItemIndex(PinGridCell.access$600(PinGridCell.this));
                motionevent = ((MotionEvent) (obj));
            }
        } else
        {
            motionevent = null;
        }
        if (motionevent == null)
        {
            break MISSING_BLOCK_LABEL_1563;
        }
        StopWatch.get().start("pin_closeup");
        obj = new Navigation(Location.PIN_PAGER);
        ((Navigation) (obj)).putExtra("com.pinterest.EXTRA_FEED", motionevent);
        ((Navigation) (obj)).putIntParcelable("com.pinterest.EXTRA_PIN_POSITION", j);
        Events.post(obj);
        j = 1;
        if (j == 0)
        {
            Events.post(new Navigation(Location.PIN, PinGridCell.access$600(PinGridCell.this)));
        }
          goto _L3
        j = 0;
        break MISSING_BLOCK_LABEL_1100;
        flag = false;
          goto _L4
    }

    public void resolveTouch(MotionEvent motionevent, boolean flag, boolean flag1)
    {
        PinGridCell.access$800(PinGridCell.this);
        if (isEnabled() && (isDown != flag || flag1) && motionevent != null)
        {
            if (PinGridCell.access$400(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                PinGridCell.access$400(PinGridCell.this).setPressed(true);
            }
            if (PinGridCell.access$1000(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                if (PinGridCell.access$1000(PinGridCell.this).getIconBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    PinGridCell.access$1000(PinGridCell.this).setIconPressed(true);
                } else
                {
                    PinGridCell.access$1000(PinGridCell.this).setPressed(true);
                }
            }
            if (PinGridCell.access$1600(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                PinGridCell.access$1600(PinGridCell.this).setPressed(true);
            }
            if (PinGridCell.access$1700(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                PinGridCell.access$1700(PinGridCell.this).setPressed(true);
            }
            if (PinGridCell.access$1200(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                if (PinGridCell.access$1200(PinGridCell.this).getIconBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    PinGridCell.access$1200(PinGridCell.this).setIconPressed(true);
                } else
                {
                    PinGridCell.access$1200(PinGridCell.this).setPressed(true);
                }
            }
            if (PinGridCell.access$1800(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                PinGridCell.access$1800(PinGridCell.this).setPressed(true);
            }
            if (PinGridCell.access$1900(PinGridCell.this).getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                if (PinGridCell.access$1900(PinGridCell.this).getRenderFeedbackIcon() && PinGridCell.access$1900(PinGridCell.this).getIconBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    PinGridCell.access$1900(PinGridCell.this).setIconPressed(true);
                } else
                {
                    PinGridCell.access$1900(PinGridCell.this).setPressed(true);
                }
            }
        }
        isDown = flag;
        if (flag1)
        {
            invalidate();
            return;
        } else
        {
            postInvalidateDelayed(touchDelay);
            return;
        }
    }

    r.DigestGridAdapter()
    {
        this$0 = PinGridCell.this;
        super();
        isDown = false;
    }
}
