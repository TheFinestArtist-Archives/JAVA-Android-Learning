// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.scrollview.ObservableScrollView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.ui.grid:
//            RecycleBin

public class PinterestAdapterView extends AdapterView
{

    public static final int AUTO_COLUMNS = -1;
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_UP = -1;
    protected PinterestBaseAdapter _adapter;
    private SparseArray _attachedChildren;
    private List _brickCols;
    private int _brickPadding;
    private int _columnCount;
    private int _columnCountRes;
    private ArrayList _columnHeight;
    private int _columnWidth;
    private boolean _dataChanged;
    private DataSetObserver _dataObserver;
    private Rect _displayRect;
    private List _expandViews;
    private GestureDetector _gestureDetector;
    private WeakReference _listener;
    private android.widget.AdapterView.OnItemClickListener _onExpandClicked;
    private android.widget.AdapterView.OnItemClickListener _onItemClicked;
    private android.widget.AdapterView.OnItemLongClickListener _onItemLongClicked;
    private int _outerPadding;
    private int _previousMeasuredHeight;
    private int _previousMeasuredWidth;
    private RecycleBin _recycleBin;
    private Rect _removeVisibleRect;
    private float _scrollAdjust;
    private int _scrollDirection;
    private ObservableScrollView _scrollView;
    private float _scrolledPercent;
    private int _top;
    private android.view.GestureDetector.OnGestureListener onGesture;

    public PinterestAdapterView(Context context)
    {
        this(context, null);
    }

    public PinterestAdapterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _dataChanged = false;
        _expandViews = new ArrayList();
        _recycleBin = new RecycleBin();
        _brickPadding = 10;
        _outerPadding = 0;
        _brickCols = new ArrayList();
        _columnWidth = 0;
        _columnCountRes = 0x7f0c0016;
        _scrollDirection = -1;
        _scrollAdjust = 0.0F;
        _previousMeasuredWidth = -1;
        _previousMeasuredHeight = -1;
        _dataObserver = new _cls1();
        _removeVisibleRect = new Rect();
        onGesture = new _cls6();
        if (attributeset != null)
        {
            context = getContext().obtainStyledAttributes(attributeset, com.pinterest.R.styleable.Pinterest);
            _brickPadding = context.getDimensionPixelSize(1, _brickPadding);
            _outerPadding = context.getDimensionPixelSize(2, _outerPadding);
            _columnCountRes = context.getResourceId(3, _columnCountRes);
            _columnCount = Resources.integer(_columnCountRes).intValue();
            context.recycle();
        }
        _attachedChildren = new SparseArray();
        _gestureDetector = new GestureDetector(getContext(), onGesture);
        updateColumnWidth(getMeasuredWidth());
    }

    private void addAndMeasureChild(View view, BrickRect brickrect, int i, int j)
    {
        LayoutParams layoutparams1 = (LayoutParams)view.getLayoutParams();
        LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new LayoutParams(-2, -2);
        }
        if (_adapter != null)
        {
            layoutparams.viewType = _adapter.getItemViewType(j);
        }
        if (!layoutparams.decorView)
        {
            if (_onItemClicked != null)
            {
                view.setOnClickListener(new _cls3());
            }
            if (_onItemLongClicked != null)
            {
                view.setOnLongClickListener(new _cls4());
            }
        }
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(brickrect.width(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(brickrect.height(), 0x40000000));
        view.layout(brickrect.left(), brickrect.top(), brickrect.right(), brickrect.bottom());
        view.setTag(0x7f0e0003, Integer.valueOf(j));
        view.setTag(0x7f0e0001, brickrect);
        addViewInLayout(view, i, layoutparams, true);
        _attachedChildren.put(j, view);
    }

    private void addDecorViews()
    {
        if (_adapter != null && _adapter.getSectionCount() > 0)
        {
            List list = _adapter.getSectionIndicies();
            ArrayList arraylist = new ArrayList(list.size());
            for (int i = 0; i < list.size(); i++)
            {
                arraylist.add(Integer.valueOf(0));
            }

label0:
            for (int j = 0; j < list.size(); j++)
            {
                Integer integer = (Integer)list.get(j);
                Iterator iterator = _brickCols.iterator();
label1:
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    Iterator iterator1 = ((List)iterator.next()).iterator();
                    BrickRect brickrect;
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            continue label1;
                        }
                        brickrect = (BrickRect)iterator1.next();
                    } while (integer.intValue() != brickrect.index);
                    int l = brickrect.bottom();
                    arraylist.set(j, Integer.valueOf(brickrect.padding + l));
                } while (true);
            }

            int j1 = list.size();
            int k = 0;
            while (k < j1) 
            {
                LayoutParams layoutparams;
                View view;
                int i1;
                int k1;
                if (k == 0)
                {
                    i1 = 0;
                } else
                {
                    i1 = ((Integer)arraylist.get(k - 1)).intValue();
                }
                k1 = ((Integer)arraylist.get(k)).intValue();
                layoutparams = new LayoutParams(-1, -2);
                layoutparams.decorView = true;
                view = _adapter.getSectionBackground(k, this);
                if (view != null)
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k1 - i1, 0x40000000));
                    view.layout(0, i1, getMeasuredWidth(), k1);
                    addViewInLayout(view, -1, layoutparams, true);
                }
                k++;
            }
        }
    }

    private void addExpandBarView(BrickRect brickrect)
    {
        Button button = new Button(getContext());
        button.setBackgroundColor(Resources.color(0x7f090047));
        button.setText(Resources.string(0x7f0e0508));
        button.setOnClickListener(new _cls5());
        LayoutParams layoutparams = new LayoutParams(-2, -2);
        layoutparams.decorView = true;
        button.measure(android.view.View.MeasureSpec.makeMeasureSpec(brickrect.width(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(brickrect.height(), 0x40000000));
        button.layout(brickrect.left(), brickrect.top(), brickrect.right(), brickrect.bottom());
        addViewInLayout(button, -1, layoutparams, true);
        _expandViews.add(button);
    }

    private void addVisibleItems()
    {
        if (_adapter != null)
        {
            Iterator iterator = _brickCols.iterator();
            while (iterator.hasNext()) 
            {
                Iterator iterator1 = ((List)iterator.next()).iterator();
                while (iterator1.hasNext()) 
                {
                    BrickRect brickrect = (BrickRect)iterator1.next();
                    if (_attachedChildren.get(brickrect.index) == null && Rect.intersects(brickrect.rect, _displayRect))
                    {
                        if (brickrect.truncateRect)
                        {
                            addExpandBarView(brickrect);
                        } else
                        {
                            View view = _recycleBin.poll(_adapter.getItemViewType(brickrect.index));
                            addAndMeasureChild(_adapter.getView(brickrect.index, view, this), brickrect, -1, brickrect.index);
                        }
                    }
                }
            }
        }
    }

    private void checkAndSetExpandBrick(final int storyIndex)
    {
        Object obj = placeExpandBrick(storyIndex);
        if (obj != null)
        {
            trimExpandableColums();
            int j = Math.min(((BrickRect) (obj)).column + ((BrickRect) (obj)).span, _columnCount);
            ((List)_brickCols.get(((BrickRect) (obj)).column)).add(obj);
            for (int i = ((BrickRect) (obj)).column; i < j; i++)
            {
                _columnHeight.set(i, Integer.valueOf(((BrickRect) (obj)).rect.bottom + ((BrickRect) (obj)).padding));
            }

            obj = new Button(getContext());
            ((Button) (obj)).setBackgroundColor(Resources.color(0x7f090047));
            ((Button) (obj)).setText(Resources.string(0x7f0e0508));
            ((Button) (obj)).setOnClickListener(new _cls2());
        }
    }

    private Rect getChildRect(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i = ai[0];
        int j = view.getWidth();
        int k = ai[1];
        rect.set(i, k, j + i, view.getHeight() + k);
        return rect;
    }

    private boolean isPositionWithinView(int i, int j, View view)
    {
        return getChildRect(view).contains(i, j);
    }

    private BrickRect placeBrick(int i)
    {
        int j = _adapter.getItemSpan(i);
        int k = j;
        if (j > _columnCount)
        {
            k = _columnCount;
        }
        int j1 = getNextCellColumn(k);
        int k1 = getNextCellTop(j1, k);
        int l = _brickPadding;
        int i1;
        int l1;
        if (k <= 1)
        {
            j = _columnWidth;
        } else
        if (k >= _columnCount)
        {
            if (_adapter.getItemPaddingMode(i) == 0)
            {
                j = getMeasuredWidth();
            } else
            {
                j = getMeasuredWidth() - _columnCount * l - _outerPadding * 2;
            }
        } else
        {
            j = _columnWidth * k + (k - 1) * l;
        }
        l1 = _adapter.getItemHeight(i, j);
        if (l1 == 0)
        {
            l = 0;
        }
        if (_adapter.getItemPaddingMode(i) == 0)
        {
            i1 = 0;
        } else
        {
            i1 = (_columnWidth + l) * j1 + l + _outerPadding;
        }
        return new BrickRect(new Rect(i1, k1, i1 + j, k1 + l1), i, j1, k, l, null);
    }

    private void placeBricks()
    {
        Iterator iterator = _brickCols.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = ((List)iterator.next()).size() + i) { }
        int k = getCount();
        while (i < k) 
        {
            checkAndSetExpandBrick(i);
            BrickRect brickrect = placeBrick(i);
            if (brickrect.span == 1)
            {
                _columnHeight.set(brickrect.column, Integer.valueOf(brickrect.rect.bottom + brickrect.padding));
                ((List)_brickCols.get(brickrect.column)).add(brickrect);
            } else
            {
                int l = Math.min(brickrect.column + brickrect.span, _columnCount);
                ((List)_brickCols.get(brickrect.column)).add(brickrect);
                int j = brickrect.column;
                while (j < l) 
                {
                    _columnHeight.set(j, Integer.valueOf(brickrect.rect.bottom + brickrect.padding));
                    j++;
                }
            }
            i++;
        }
    }

    private BrickRect placeExpandBrick(int i)
    {
        if (_adapter.isSectionHeader(i) && ((Integer)Collections.max(_columnHeight)).intValue() - ((Integer)Collections.min(_columnHeight)).intValue() > Constants.MARGIN)
        {
            int j = _outerPadding + _brickPadding;
            int k = getNextTruncateCellTop(0, _columnCount);
            return new BrickRect(new Rect(j, k, j + (getMeasuredWidth() - _outerPadding * 2 - _brickPadding * _columnCount), k + (int)Resources.dimension(0x7f0a0034)), i, 0, _columnCount, 0, true, null);
        } else
        {
            return null;
        }
    }

    private void removeNonVisibleItems()
    {
        this;
        JVM INSTR monitorenter ;
        int j = getChildCount();
        int i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        View view = getChildAt(i);
        if (view == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((LayoutParams)view.getLayoutParams()).decorView && !Rect.intersects(((BrickRect)view.getTag(0x7f0e0001)).rect, _displayRect))
        {
            removeViewInLayout(view);
            _attachedChildren.remove(((Integer)view.getTag(0x7f0e0003)).intValue());
            _recycleBin.offer(view);
        }
        i++;
          goto _L3
_L2:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void trimExpandableColums()
    {
        int j = ((Integer)Collections.min(_columnHeight)).intValue();
        for (int i = 0; i < _columnCount; i++)
        {
            if (((Integer)_columnHeight.get(i)).intValue() != j)
            {
                List list = (List)_brickCols.get(i);
                BrickRect brickrect = (BrickRect)list.remove(list.size() - 1);
                int k = brickrect.top();
                int l = brickrect.height();
                int i1 = ((Integer)_columnHeight.get(i)).intValue();
                int j1 = _brickPadding;
                brickrect.rect.set(brickrect.rect.left, brickrect.top(), brickrect.right(), ((l + k) - (i1 - j)) + j1);
                list.add(brickrect);
                _columnHeight.set(i, Integer.valueOf(j));
            }
        }

    }

    private void updateBricksAfterChange(int i)
    {
        resetColumns();
        placeBricks();
    }

    private void updateDisplayRect()
    {
        if (_scrollView == null)
        {
            return;
        }
        if (_displayRect == null)
        {
            _displayRect = new Rect();
        }
        _displayRect.left = getLeft();
        _displayRect.top = _scrollView.scrollY - _top;
        _displayRect.right = getRight();
        _displayRect.bottom = _displayRect.top + _scrollView.getMeasuredHeight();
    }

    public void destroy()
    {
        _recycleBin.clear();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return super.dispatchTouchEvent(motionevent) | _gestureDetector.onTouchEvent(motionevent);
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return _adapter;
    }

    public int getBrickPadding()
    {
        return _brickPadding;
    }

    public int getColumnCount()
    {
        return _columnCount;
    }

    public int getColumnFromXPos(int i)
    {
        return Math.round(i / (_columnWidth + _brickPadding));
    }

    public int getColumnWidth()
    {
        return _columnWidth;
    }

    public int getCount()
    {
        return _adapter.getCount();
    }

    public int getNextCellColumn(int i)
    {
        int j = 0;
        if (i <= 1)
        {
            j = _columnHeight.indexOf(Collections.min(_columnHeight));
        } else
        if (i < _columnCount)
        {
            int l = 0x7fffffff;
            int i1 = 0x7fffffff;
            for (int k = 0; k < (_columnHeight.size() - i) + 1;)
            {
                Integer integer = (Integer)_columnHeight.get(k);
                int j1 = l;
                if (integer.intValue() < l)
                {
                    j1 = integer.intValue();
                    i1 = k;
                }
                k++;
                l = j1;
            }

            return getNextEvenCellColumn(i1, i);
        }
        return j;
    }

    public int getNextCellTop(int i, int j)
    {
        int k = 0x80000000;
        for (int l = i; l < i + j; l++)
        {
            Integer integer = (Integer)_columnHeight.get(l);
            if (integer.intValue() > k)
            {
                k = integer.intValue();
            }
        }

        return k;
    }

    public int getNextEvenCellColumn(int i, int j)
    {
        int i1 = ((Integer)_columnHeight.get(i)).intValue();
        int j1 = i;
        int l = 1;
        for (int k = i + 1; k < _columnHeight.size(); k++)
        {
            if (((Integer)_columnHeight.get(k)).intValue() == i1)
            {
                l++;
            } else
            {
                i1 = ((Integer)_columnHeight.get(k)).intValue();
                j1 = k;
                l = 1;
            }
            if (l >= j)
            {
                return j1;
            }
        }

        if (i != 0)
        {
            return getNextEvenCellColumn(0, j);
        } else
        {
            return i;
        }
    }

    public int getNextTruncateCellTop(int i, int j)
    {
        int k = 0x7fffffff;
        for (int l = i; l < i + j; l++)
        {
            Integer integer = (Integer)_columnHeight.get(l);
            if (integer.intValue() < k)
            {
                k = integer.intValue();
            }
        }

        return k;
    }

    public int getOuterPadding()
    {
        return _outerPadding;
    }

    public View getSelectedView()
    {
        return null;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        _scrollAdjust = _scrolledPercent;
        setColumnCount(getResources().getInteger(_columnCountRes));
        if (_listener != null)
        {
            PinterAdapterViewListener pinteradapterviewlistener = (PinterAdapterViewListener)_listener.get();
            if (pinteradapterviewlistener != null)
            {
                pinteradapterviewlistener.onConfigurationChanged(configuration);
            }
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        _top = j;
        if (_scrollView != null)
        {
            _top = _top + _scrollView.getPaddingTop();
        }
        if (_scrollAdjust > 0.0F && _scrollView != null)
        {
            _scrollView.scrollTo(0, (int)(_scrollAdjust * (float)getHeight()));
            _scrollAdjust = 0.0F;
        }
        updateDisplayRect();
        if (_dataChanged)
        {
            _dataChanged = false;
            removeAllViewsInLayout();
            addDecorViews();
            addVisibleItems();
        } else
        {
            removeNonVisibleItems();
            addVisibleItems();
        }
        super.onLayout(flag, i, j, k, l);
        if (_listener != null)
        {
            PinterAdapterViewListener pinteradapterviewlistener = (PinterAdapterViewListener)_listener.get();
            if (pinteradapterviewlistener != null)
            {
                pinteradapterviewlistener.onLayout();
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (_adapter != null)
        {
            i = android.view.View.MeasureSpec.getSize(i);
            if (_previousMeasuredWidth != i)
            {
                reset();
            }
            _previousMeasuredWidth = i;
            placeBricks();
            if (i == 0)
            {
                i = (int)Device.getScreenWidth();
            }
            setMeasuredDimension(i, ((Integer)Collections.max(_columnHeight)).intValue());
            if (_listener != null)
            {
                PinterAdapterViewListener pinteradapterviewlistener = (PinterAdapterViewListener)_listener.get();
                if (pinteradapterviewlistener != null)
                {
                    pinteradapterviewlistener.onMeasure();
                    return;
                }
            }
        }
    }

    public void onScroll(ScrollView scrollview, int i, int j)
    {
        for (int k = 0; k < getChildCount(); k++)
        {
            getChildAt(k).setPressed(false);
        }

        if (j < i)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        _scrollDirection = i;
        _scrolledPercent = (float)scrollview.getScrollY() / (float)getHeight();
        updateDisplayRect();
        removeNonVisibleItems();
        addVisibleItems();
        invalidate();
    }

    public void removeAllViewsInLayout()
    {
        if (_attachedChildren != null)
        {
            _attachedChildren.clear();
        }
        _expandViews.clear();
        super.removeAllViewsInLayout();
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        updateColumnWidth(getMeasuredWidth());
        resetColumns();
        removeAllViewsInLayout();
        _recycleBin.clear();
        if (_adapter != null)
        {
            _adapter.resetCachedItemHeights();
        }
        _dataChanged = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void resetColumns()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        _columnHeight = new ArrayList();
        int i = 0;
_L2:
        if (i >= _columnCount)
        {
            break; /* Loop/switch isn't completed */
        }
        _columnHeight.add(Integer.valueOf(getPaddingTop()));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        _brickCols = new ArrayList();
        i = ((flag) ? 1 : 0);
_L4:
        if (i >= _columnCount)
        {
            break; /* Loop/switch isn't completed */
        }
        _brickCols.add(new ArrayList());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (_adapter != null)
        {
            _adapter.unregisterDataSetObserver(_dataObserver);
        }
        _adapter = (PinterestBaseAdapter)listadapter;
        if (_adapter != null)
        {
            _adapter.registerDataSetObserver(_dataObserver);
            _adapter.setDataListener(new _cls7());
        }
        reset();
    }

    public void setBrickPadding(int i)
    {
        _brickPadding = i;
        reset();
        requestLayout();
    }

    public void setColumnCount(int i)
    {
        _columnCount = i;
        _columnWidth = 0;
        reset();
        requestLayout();
    }

    public void setColumnCountRes(int i)
    {
        _columnCountRes = i;
        setColumnCount(getResources().getInteger(_columnCountRes));
    }

    public void setContainingScrollView(ObservableScrollView observablescrollview)
    {
        _scrollView = observablescrollview;
    }

    public void setEmptyView(View view)
    {
        throw new RuntimeException("Not supported!");
    }

    public void setListener(PinterAdapterViewListener pinteradapterviewlistener)
    {
        _listener = new WeakReference(pinteradapterviewlistener);
    }

    public void setOnExpandClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        _onExpandClicked = onitemclicklistener;
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        _onItemClicked = onitemclicklistener;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        _onItemLongClicked = onitemlongclicklistener;
    }

    public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
    }

    public void setOuterPadding(int i)
    {
        _outerPadding = i;
        reset();
        requestLayout();
    }

    public void setSelection(int i)
    {
    }

    protected void updateColumnWidth(int i)
    {
        if (i == 0)
        {
            return;
        } else
        {
            _columnCount = Math.max(1, _columnCount);
            _columnWidth = (i - _brickPadding - _outerPadding * 2) / _columnCount - _brickPadding;
            return;
        }
    }


/*
    static boolean access$002(PinterestAdapterView pinterestadapterview, boolean flag)
    {
        pinterestadapterview._dataChanged = flag;
        return flag;
    }

*/







    private class _cls1 extends DataSetObserver
    {

        final PinterestAdapterView this$0;

        public void onChanged()
        {
            synchronized (PinterestAdapterView.this)
            {
                _dataChanged = true;
            }
            if (_adapter != null)
            {
                _recycleBin.setViewTypeCount(_adapter.getViewTypeCount());
            }
            requestLayout();
            return;
            exception;
            pinterestadapterview;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onInvalidated()
        {
            reset();
            if (_adapter != null)
            {
                _recycleBin.setViewTypeCount(_adapter.getViewTypeCount());
            }
            requestLayout();
        }

        _cls1()
        {
            this$0 = PinterestAdapterView.this;
            super();
        }
    }


    private class _cls6 extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final PinterestAdapterView this$0;

        private boolean isEventWithinView(MotionEvent motionevent, View view)
        {
            return isPositionWithinView((int)motionevent.getRawX(), (int)motionevent.getRawY(), view);
        }

        public boolean onDown(MotionEvent motionevent)
        {
            for (int i = 0; i < getChildCount(); i++)
            {
                View view = getChildAt(i);
                if (!(view instanceof PinGridCell))
                {
                    view.setPressed(isEventWithinView(motionevent, view));
                }
            }

            return true;
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            for (int i = 0; i < getChildCount(); i++)
            {
                getChildAt(i).setPressed(false);
            }

            return super.onFling(motionevent, motionevent1, f, f1);
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            for (int i = 0; i < getChildCount(); i++)
            {
                getChildAt(i).setPressed(false);
            }

            return super.onScroll(motionevent, motionevent1, f, f1);
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            for (int i = 0; i < getChildCount(); i++)
            {
                View view = getChildAt(i);
                if (!(view instanceof PinGridCell))
                {
                    view.setPressed(false);
                }
            }

            return super.onSingleTapUp(motionevent);
        }

        _cls6()
        {
            this$0 = PinterestAdapterView.this;
            super();
        }
    }


    private class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        public boolean decorView;
        public boolean forceAdd;
        public int viewType;

        public LayoutParams(int i, int j)
        {
            super(i, j);
            forceAdd = false;
            decorView = false;
            viewType = 0;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            forceAdd = false;
            decorView = false;
            viewType = 0;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            forceAdd = false;
            decorView = false;
            viewType = 0;
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final PinterestAdapterView this$0;

        public void onClick(View view)
        {
            if (_onItemClicked == null || _adapter == null)
            {
                return;
            } else
            {
                int i = ((Integer)view.getTag(0x7f0e0003)).intValue();
                _onItemClicked.onItemClick(PinterestAdapterView.this, view, i, _adapter.getItemId(i));
                return;
            }
        }

        _cls3()
        {
            this$0 = PinterestAdapterView.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnLongClickListener
    {

        final PinterestAdapterView this$0;

        public boolean onLongClick(View view)
        {
            if (_onItemLongClicked == null || _adapter == null)
            {
                return false;
            } else
            {
                int i = ((Integer)view.getTag(0x7f0e0003)).intValue();
                return _onItemLongClicked.onItemLongClick(PinterestAdapterView.this, view, i, _adapter.getItemId(i));
            }
        }

        _cls4()
        {
            this$0 = PinterestAdapterView.this;
            super();
        }
    }


    private class BrickRect
    {

        public int column;
        public int index;
        public int padding;
        public Rect rect;
        public int span;
        public boolean truncateRect;

        public int bottom()
        {
            return rect.bottom;
        }

        public int height()
        {
            return rect.height();
        }

        public boolean inColumn(int i)
        {
            while (span <= 1 && column == i || i < column + span && i >= column) 
            {
                return true;
            }
            return false;
        }

        public int left()
        {
            return rect.left;
        }

        public void offset(int i, int j)
        {
            rect.offset(i, j);
        }

        public int right()
        {
            return rect.right;
        }

        public int top()
        {
            return rect.top;
        }

        public int width()
        {
            return rect.width();
        }

        private BrickRect(Rect rect1, int i, int j, int k, int l)
        {
            this(rect1, i, j, k, l, false);
        }

        BrickRect(Rect rect1, int i, int j, int k, int l, _cls1 _pcls1)
        {
            this(rect1, i, j, k, l);
        }

        private BrickRect(Rect rect1, int i, int j, int k, int l, boolean flag)
        {
            rect = rect1;
            index = i;
            column = j;
            span = k;
            padding = l;
            truncateRect = flag;
        }

        BrickRect(Rect rect1, int i, int j, int k, int l, boolean flag, _cls1 _pcls1)
        {
            this(rect1, i, j, k, l, flag);
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final PinterestAdapterView this$0;
        final int val$storyIndex;

        public void onClick(View view)
        {
            if (_onExpandClicked == null || _adapter == null)
            {
                return;
            } else
            {
                _onExpandClicked.onItemClick(PinterestAdapterView.this, view, storyIndex, _adapter.getItemId(storyIndex));
                return;
            }
        }

        _cls5()
        {
            this$0 = PinterestAdapterView.this;
            storyIndex = i;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PinterestAdapterView this$0;
        final int val$storyIndex;

        public void onClick(View view)
        {
            if (_onExpandClicked == null || _adapter == null)
            {
                return;
            } else
            {
                _onExpandClicked.onItemClick(PinterestAdapterView.this, view, storyIndex, _adapter.getItemId(storyIndex));
                return;
            }
        }

        _cls2()
        {
            this$0 = PinterestAdapterView.this;
            storyIndex = i;
            super();
        }
    }


    private class PinterAdapterViewListener
    {

        public abstract void onConfigurationChanged(Configuration configuration);

        public abstract void onLayout();

        public abstract void onMeasure();
    }


    private class _cls7 extends com.pinterest.api.model.Feed.DataListener
    {

        final PinterestAdapterView this$0;

        public void onChange(int i, boolean flag)
        {
            if (flag)
            {
                reset();
                return;
            } else
            {
                updateBricksAfterChange(i);
                return;
            }
        }

        _cls7()
        {
            this$0 = PinterestAdapterView.this;
            super();
        }
    }

}
