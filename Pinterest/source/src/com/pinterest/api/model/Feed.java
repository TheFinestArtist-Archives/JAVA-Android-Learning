// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.kit.application.Resources;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public abstract class Feed extends ApiResponse
    implements Parcelable
{

    protected String _baseUrl;
    private boolean _cached;
    protected DataListener _dataListener;
    protected List _ids;
    protected List _items;
    protected SparseArray _sectionIndices;

    protected Feed()
    {
        super(null);
        _items = new ArrayList();
        _ids = new ArrayList();
        _sectionIndices = new SparseArray();
    }

    public Feed(PinterestJsonObject pinterestjsonobject, String s)
    {
        super(pinterestjsonobject);
        _items = new ArrayList();
        _ids = new ArrayList();
        _sectionIndices = new SparseArray();
        _baseUrl = s;
    }

    protected Feed(Feed feed)
    {
        super(null);
        _items = new ArrayList();
        _ids = new ArrayList();
        _sectionIndices = new SparseArray();
        if (feed == null)
        {
            return;
        } else
        {
            _status = feed.getStatus();
            _bookmark = feed.getBookmark();
            _message = feed.getMessage();
            _messageDetail = feed.getMessageDetail();
            _generatedAt = feed.getGeneratedAt();
            _baseUrl = feed.getBaseUrl();
            setItems(new ArrayList(feed.getItems()));
            return;
        }
    }

    public static String getName()
    {
        return "__FEED";
    }

    public static Feed restoreInstanceState(Bundle bundle)
    {
        return restoreInstanceState(bundle, getName());
    }

    public static Feed restoreInstanceState(Bundle bundle, String s)
    {
        if (bundle == null)
        {
            bundle = null;
        } else
        {
            s = (Feed)bundle.getParcelable(s);
            bundle = s;
            if (s != null)
            {
                s.onStart();
                return s;
            }
        }
        return bundle;
    }

    public void addItemTitle(int i, int j)
    {
        _sectionIndices.put(i, Resources.string(j));
    }

    public void addItemTitle(int i, String s)
    {
        _sectionIndices.put(i, s);
    }

    public void appendItem(Model model)
    {
        List list = _items;
        if (list == null || list.size() == 0)
        {
            onStart();
        }
        list.add(model);
        setItems(list);
    }

    public void appendItems(Feed feed)
    {
        update(feed);
        if (_items == null || _items.size() == 0)
        {
            onStart();
        }
        setItems(_items);
        List list = _items;
        if (list == null)
        {
            setItems(feed.getItems());
            return;
        }
        feed = feed.getItems().iterator();
        do
        {
            if (!feed.hasNext())
            {
                break;
            }
            Model model = (Model)feed.next();
            if (!list.contains(model))
            {
                list.add(model);
            }
        } while (true);
        setItems(list);
    }

    public void clearSectionTitles()
    {
        _sectionIndices.clear();
    }

    public int describeContents()
    {
        return 0;
    }

    public final void destroy()
    {
        _data = null;
        _items.clear();
        _ids.clear();
        _items = null;
        _ids = null;
        _code = -1;
        _baseUrl = null;
        _generatedAt = null;
        _message = null;
        _bookmark = null;
        _status = null;
    }

    public Model get(int i)
    {
        if (getCount() == 0 || i > _items.size() - 1)
        {
            return null;
        } else
        {
            return (Model)_items.get(i);
        }
    }

    public int getAbsCount()
    {
        if (_ids == null)
        {
            return 0;
        } else
        {
            return _ids.size();
        }
    }

    public String getBaseUrl()
    {
        return _baseUrl;
    }

    public int getCount()
    {
        if (_items == null)
        {
            return 0;
        } else
        {
            return _items.size();
        }
    }

    public List getIds()
    {
        return _ids;
    }

    protected String getItemId(Model model)
    {
        return model.getUid();
    }

    public String getItemTitle(int i)
    {
        return (String)_sectionIndices.get(i);
    }

    public List getItems()
    {
        if (getCount() == 0)
        {
            onStart();
        }
        return _items;
    }

    public String getNextUrl()
    {
        if (!ModelHelper.isValid(_baseUrl) || !ModelHelper.isValid(_bookmark))
        {
            return null;
        }
        String s = "?bookmark=";
        if (_baseUrl.contains("?"))
        {
            s = "&bookmark=";
        }
        return String.format("%s%s%s", new Object[] {
            _baseUrl, s, Uri.encode(_bookmark)
        });
    }

    protected abstract List getPersistedItems();

    public boolean isAtEnd()
    {
        return !ModelHelper.isValid(_bookmark) || _bookmark.equals("");
    }

    public boolean isCached()
    {
        return _cached;
    }

    public FeedApiResponseHandler newApiHandler()
    {
        return null;
    }

    public boolean onStart()
    {
        if (_ids != null && _ids.size() > 0 && (_items == null || _items.size() == 0))
        {
            int i = _ids.size();
            setItems(getPersistedItems());
            if (_dataListener != null)
            {
                DataListener datalistener = _dataListener;
                boolean flag;
                if (i != _ids.size())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                datalistener.onStart(flag);
            }
            if (i != _ids.size())
            {
                return true;
            }
        }
        return false;
    }

    public void onStop()
    {
        if (_items != null)
        {
            if (_dataListener != null)
            {
                _dataListener.onStop();
            }
            _items.clear();
        }
    }

    public void prependItem(Model model)
    {
        if (_items == null || _items.size() == 0)
        {
            onStart();
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(model);
        arraylist.addAll(_items);
        setItems(arraylist);
    }

    public void prependItems(Feed feed)
    {
        update(feed);
        if (_items == null || _items.size() == 0)
        {
            onStart();
        }
        feed = new ArrayList(feed.getItems());
        feed.addAll(_items);
        setItems(feed);
    }

    protected void readFromParcel(Parcel parcel)
    {
        if (parcel == null)
        {
            return;
        } else
        {
            _code = parcel.readInt();
            _status = parcel.readString();
            _message = parcel.readString();
            _generatedAt = parcel.readString();
            _bookmark = parcel.readString();
            _baseUrl = parcel.readString();
            _ids = new ArrayList();
            parcel.readList(_ids, java/lang/String.getClassLoader());
            return;
        }
    }

    public final void refresh()
    {
        onStop();
        onStart();
    }

    public Model removeItem(int i)
    {
        Model model = (Model)_items.remove(i);
        updateIds();
        return model;
    }

    public Model removeItem(Model model)
    {
        int i = _items.indexOf(model);
        if (i >= 0)
        {
            return removeItem(i);
        } else
        {
            return null;
        }
    }

    public void removeItemTitle(int i)
    {
        _sectionIndices.remove(i);
    }

    public void removeItems(int i, int j)
    {
        int k;
label0:
        {
            if (i >= 0)
            {
                k = j;
                if (j < _items.size())
                {
                    break label0;
                }
            }
            return;
        }
        for (; k > i; k--)
        {
            _items.remove(i);
        }

        updateIds();
    }

    public void saveInstanceState(Bundle bundle)
    {
        saveInstanceState(bundle, getName());
    }

    public void saveInstanceState(Bundle bundle, String s)
    {
        bundle.putParcelable(s, this);
    }

    public void setBaseUrl(String s)
    {
        _baseUrl = s;
    }

    public void setCached(boolean flag)
    {
        _cached = flag;
    }

    public void setDataListener(DataListener datalistener)
    {
        _dataListener = datalistener;
    }

    public void setItem(int i, Model model)
    {
        _items.set(i, model);
        updateIds();
    }

    public void setItems(List list)
    {
        _items = list;
        updateIds();
    }

    public void updateIds()
    {
        if (_items != null)
        {
            Iterator iterator;
            if (_ids == null)
            {
                _ids = new ArrayList();
            } else
            {
                _ids.clear();
            }
            iterator = _items.iterator();
            while (iterator.hasNext()) 
            {
                Model model = (Model)iterator.next();
                _ids.add(getItemId(model));
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(_code);
        if (_status == null)
        {
            _status = "";
        }
        parcel.writeString(_status);
        if (_message == null)
        {
            _message = "";
        }
        parcel.writeString(_message);
        if (_generatedAt == null)
        {
            _generatedAt = "";
        }
        parcel.writeString(_generatedAt);
        if (_bookmark == null)
        {
            _bookmark = "";
        }
        parcel.writeString(_bookmark);
        if (_baseUrl == null)
        {
            _baseUrl = "";
        }
        parcel.writeString(_baseUrl);
        if (_ids == null)
        {
            _ids = new ArrayList();
        }
        parcel.writeList(_ids);
    }

    private class DataListener
    {

        public void onChange(int i, boolean flag)
        {
        }

        public void onStart(boolean flag)
        {
        }

        public void onStop()
        {
        }

        public DataListener()
        {
        }
    }

}
