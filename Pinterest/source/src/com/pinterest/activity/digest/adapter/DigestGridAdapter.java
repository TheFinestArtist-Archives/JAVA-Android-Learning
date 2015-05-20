// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.digest.ui.DigestHeaderView;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.DigestFeed;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.Interest;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinFeed;
import com.pinterest.api.model.User;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.grid.PinGridCell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class DigestGridAdapter extends PinterestBaseAdapter
{

    private ArrayList _impressions;

    public DigestGridAdapter()
    {
        _impressions = new ArrayList();
    }

    public List dumpPinImpressions()
    {
        ArrayList arraylist = new ArrayList(_impressions);
        _impressions.clear();
        return arraylist;
    }

    public List getIncludedItemsForHeader(DigestItem digestitem)
    {
        if (_dataSource == null)
        {
            return new ArrayList();
        }
        Object obj = (DigestFeed)_dataSource;
        ArrayList arraylist = new ArrayList();
        obj = ((DigestFeed) (obj)).getItems().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            DigestItem digestitem1 = (DigestItem)((Iterator) (obj)).next();
            if (digestitem1.getReferId().equals(digestitem.getUid()) && !digestitem1.getUid().equals(digestitem.getUid()))
            {
                arraylist.add(digestitem1);
            }
        } while (true);
        return arraylist;
    }

    public int getItemPaddingMode(int i)
    {
        return ((DigestItem)getItem(i)).getEnumType().intValue() != 0 ? 1 : 0;
    }

    public int getItemSpan(int i)
    {
        DigestItem digestitem = (DigestItem)getItem(i);
        if (digestitem.getEnumType().intValue() == 0)
        {
            return 0x7fffffff;
        }
        return !digestitem.getLargePin().booleanValue() ? 1 : 2;
    }

    public PinFeed getPinFeed(Pin pin)
    {
        Object obj1 = null;
        if (_dataSource == null)
        {
            return null;
        }
        List list = _dataSource.getItems();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        Object obj;
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (DigestItem)iterator.next();
            if (!((DigestItem) (obj)).getUid().equals(pin.getUid()))
            {
                continue;
            }
            obj = ((DigestItem) (obj)).getReferId();
            break;
        } while (true);
        if (StringUtils.isNotEmpty(((CharSequence) (obj))))
        {
            boolean flag = false;
            pin = list.iterator();
            do
            {
                if (!pin.hasNext())
                {
                    break;
                }
                DigestItem digestitem = (DigestItem)pin.next();
                if (digestitem.getReferId().equals(obj))
                {
                    if (flag)
                    {
                        arraylist.add(ModelHelper.getPin(digestitem.getUid()));
                    }
                    flag = true;
                }
            } while (true);
        }
        pin = new PinFeed();
        pin.setItems(arraylist);
        return pin;
    }

    public int getPrevStoryIndex(int i)
    {
        List list = _dataSource.getItems();
        for (i--; i >= 0; i--)
        {
            if (((DigestItem)list.get(i)).getEnumType().intValue() == 0)
            {
                return i;
            }
        }

        return 0;
    }

    public Navigation getStoryNavigation(int i)
    {
        Navigation navigation;
        DigestItem digestitem;
        navigation = new Navigation(Location.DIGEST_PINS);
        digestitem = (DigestItem)getItem(i);
        if (digestitem.getEnumType().intValue() != 0)
        {
            return null;
        }
        _cls2..SwitchMap.com.pinterest.api.model.DigestItem.DigestMode[com.pinterest.api.model.DigestItem.DigestMode.withName(digestitem.getContainerType()).ordinal()];
        JVM INSTR tableswitch 1 6: default 84
    //                   1 86
    //                   2 86
    //                   3 162
    //                   4 162
    //                   5 134
    //                   6 134;
           goto _L1 _L2 _L2 _L3 _L3 _L4 _L4
_L1:
        return navigation;
_L2:
        Board board = ModelHelper.getBoard(digestitem.getBoardUid());
        if (board != null)
        {
            navigation.putStringParcelable("com.pinterest.EXTRA_DIGEST_ID", board.getUid());
        }
_L6:
        navigation.putStringParcelable("com.pinterest.EXTRA_DIGEST_MODE", digestitem.getContainerType());
        navigation.putExtra("com.pinterest.EXTRA_DIGEST_PIN_ITEMS", getIncludedItemsForHeader(digestitem));
        return navigation;
_L4:
        Interest interest = ModelHelper.getInterest(digestitem.getInterestUid());
        if (interest != null)
        {
            navigation.putStringParcelable("com.pinterest.EXTRA_DIGEST_ID", interest.getUid());
        }
        continue; /* Loop/switch isn't completed */
_L3:
        User user = ModelHelper.getUser(digestitem.getUserUid());
        if (user != null)
        {
            navigation.putStringParcelable("com.pinterest.EXTRA_DIGEST_ID", user.getUid());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public View getView(final int i, View view, ViewGroup viewgroup, boolean flag)
    {
        DigestItem digestitem = (DigestItem)getItem(i);
        if (digestitem != null && digestitem.getEnumType().intValue() == 0)
        {
            boolean flag1;
            if (view == null || !(view instanceof DigestHeaderView))
            {
                view = (DigestHeaderView)getInflater(view, viewgroup).inflate(0x7f0300bb, null);
            } else
            {
                view = (DigestHeaderView)view;
            }
            if (i != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            view.showTopSeparator(flag1);
            if (!flag)
            {
                view.setIncludedItems(getIncludedItemsForHeader(digestitem));
                view.setDigestPin(digestitem);
                view.setOnClickListener(new _cls1());
            }
            return view;
        }
        if (view == null || !(view instanceof PinGridCell))
        {
            viewgroup = new PinGridCell(ViewHelper.getContext(view, viewgroup));
            viewgroup.setBackgroundColor(-1);
        } else
        {
            viewgroup = (PinGridCell)view;
        }
        if (!flag)
        {
            loadMore(i);
            if (view != null)
            {
                view = viewgroup.markImpressionEnd();
                if (view != null)
                {
                    _impressions.add(view);
                }
            }
            viewgroup.markImpressionStart();
        }
        viewgroup.setRenderLargePin(digestitem.getLargePin().booleanValue());
        viewgroup.setRenderCompactUser(false);
        viewgroup.setRenderDescription(true);
        viewgroup.setRenderSocial(false);
        viewgroup.setRenderUser(false);
        viewgroup.setRenderSource(false);
        viewgroup.setRenderOnto(false);
        viewgroup.setRenderThrough(false);
        viewgroup.setRenderDomain(true);
        viewgroup.setPinPosition(i);
        viewgroup.setPin(ModelHelper.getPin(digestitem.getUid()), flag);
        return viewgroup;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isSectionHeader(int i)
    {
        DigestItem digestitem = (DigestItem)getItem(i);
        return digestitem != null && digestitem.getEnumType().intValue() == 0;
    }

    public void removeStory(DigestItem digestitem, DigestFeedbackAdapter.UnFollowItemType unfollowitemtype)
    {
        List list;
        ArrayList arraylist;
        int i;
        boolean flag;
        if (_dataSource == null || digestitem == null)
        {
            return;
        }
        list = _dataSource.getItems();
        arraylist = new ArrayList();
        i = 0;
        flag = false;
_L9:
        DigestItem digestitem1;
        if (i >= list.size())
        {
            break MISSING_BLOCK_LABEL_257;
        }
        digestitem1 = (DigestItem)list.get(i);
        if (digestitem1.getEnumType().intValue() != 0) goto _L2; else goto _L1
_L1:
        if (!digestitem1.getContainerType().equals(digestitem.getContainerType()))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        _cls2..SwitchMap.com.pinterest.api.model.DigestItem.DigestMode[com.pinterest.api.model.DigestItem.DigestMode.withName(digestitem.getContainerType()).ordinal()];
        JVM INSTR tableswitch 1 5: default 132
    //                   1 159
    //                   2 176
    //                   3 217
    //                   4 217
    //                   5 234;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        flag = false;
_L2:
        if (!flag)
        {
            arraylist.add(digestitem1);
        }
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        flag = digestitem.getBoardUid().equals(digestitem1.getBoardUid());
          goto _L2
_L5:
        if (unfollowitemtype == DigestFeedbackAdapter.UnFollowItemType.OTHER_BOARD)
        {
            flag = digestitem.getBoardUid().equals(digestitem1.getBoardUid());
        } else
        {
            flag = digestitem.getUserUid().equals(digestitem1.getUserUid());
        }
          goto _L2
_L6:
        flag = digestitem.getUserUid().equals(digestitem1.getUserUid());
          goto _L2
_L7:
        flag = digestitem.getInterestUid().equals(digestitem1.getInterestUid());
          goto _L2
        flag = false;
          goto _L2
        _dataSource.setItems(arraylist);
        return;
    }

    public void setDataSource(Feed feed)
    {
        if (_dataSource != null)
        {
            _dataSource.setDataListener(null);
        }
        super.setDataSource(feed);
        if (_dataSource != null)
        {
            _dataSource.setDataListener(_dataListener);
        }
    }

    private class _cls2
    {

        static final int $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[];

        static 
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode = new int[com.pinterest.api.model.DigestItem.DigestMode.values().length];
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_BOARD.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.BOARD.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER_CATEGORY.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.INTEREST.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_THROUGH_INTEREST.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final DigestGridAdapter this$0;
        final int val$i;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.DIGEST_STORY_HEADER_BUTTON, ComponentType.DIGEST_STORY_HEADER);
            Events.post(getStoryNavigation(i));
        }

        _cls1()
        {
            this$0 = DigestGridAdapter.this;
            i = j;
            super();
        }
    }

}
