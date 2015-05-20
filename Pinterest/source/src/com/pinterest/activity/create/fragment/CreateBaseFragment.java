// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.create.BoardSelectedEvent;
import com.pinterest.activity.create.model.PinnableImage;
import com.pinterest.activity.pin.view.PinIconTextView;
import com.pinterest.activity.place.PlaceSelectedEvent;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.BoardFeed;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Place;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Application;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.utils.ImageUtils;
import com.pinterest.kit.utils.LocaleUtils;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.actions.Scrollable;
import com.pinterest.ui.imageview.WebImageView;
import com.pinterest.ui.text.PButton;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            RepinFragment, BoardPickerFragment

public abstract class CreateBaseFragment extends BaseFragment
    implements Scrollable
{

    private static final String BOARD_UID = "boardUid";
    private static final String IMAGE_URI = "imageUri";
    private static final String PLACE_UID = "placeUid";
    private boolean _autoPin;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    protected boolean _hideSocialContainer;
    private Drawable _icChevron;
    private Drawable _icMap;
    protected PButton _negativeBtn;
    protected boolean _ontoSecretBoard;
    private android.view.View.OnClickListener _pinClick;
    protected PinnableImage _pinnableImage;
    protected PButton _positiveBtn;
    public WebImageView boardIv;
    public TextView boardTv;
    public String boardUid;
    protected PinIconTextView boardWrapper;
    private ComponentType componentType;
    protected EditText descriptionEt;
    public Uri imageUri;
    protected TextView locationTv;
    protected ViewGroup mainContent;
    protected android.view.View.OnClickListener onBoardsClicked;
    protected com.pinterest.api.remote.MyUserApi.BoardPickerApiResponse onBoardsLoaded;
    private android.view.View.OnClickListener onLocationEtClicked;
    protected WebImageView pinIv;
    public String placeUid;
    protected ScrollView scroller;

    public CreateBaseFragment()
    {
        _pinClick = new _cls1();
        _eventsSubscriber = new _cls2();
        onBoardsClicked = new _cls3();
        onLocationEtClicked = new _cls4();
        onBoardsLoaded = new _cls5();
        componentType = null;
    }

    private void setBoardSelector(Board board)
    {
        int i = 0;
        if (boardWrapper == null)
        {
            return;
        }
        if (board == null)
        {
            boardTv.setText(0x7f0e0142);
            boardIv.setImageResource(0x7f020104);
            return;
        }
        PinIconTextView pinicontextview;
        boolean flag;
        if (Constants.isTrue(board.getSecret()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _ontoSecretBoard = flag;
        _positiveBtn.setOnClickListener(_pinClick);
        boardUid = board.getUid();
        boardTv.setText(board.getName());
        pinicontextview = boardWrapper;
        if (!_ontoSecretBoard)
        {
            i = 8;
        }
        pinicontextview.setSecretIconVis(i);
        pinicontextview = boardWrapper;
        if (_ontoSecretBoard)
        {
            i = 0x7f0e0080;
        } else
        {
            i = 0x7f0e007f;
        }
        pinicontextview.setLabel(i);
        if (!ModelHelper.isValid(board.getImageCoverThumbnail()))
        {
            boardIv.setImageDrawable(null);
            return;
        } else
        {
            boardIv.loadUrl(board.getImageCoverThumbnail());
            return;
        }
    }

    protected void autoPickBoard()
    {
        if (boardWrapper == null || boardTv == null || boardIv == null)
        {
            return;
        }
        Object obj;
        if (StringUtils.isEmpty(boardUid))
        {
            obj = MyUser.getLastSelectedBoardId();
        } else
        {
            obj = boardUid;
        }
        obj = ModelHelper.getBoard(((String) (obj)));
        if (obj != null)
        {
            _positiveBtn.setOnClickListener(onBoardsClicked);
            setBoardSelector(((Board) (obj)));
            return;
        }
        obj = DiskCache.getJsonObject("MY_PICKER_BOARDS");
        if (obj != null)
        {
            _positiveBtn.setOnClickListener(onBoardsClicked);
            setBoardSelector((Board)(new BoardFeed(((com.pinterest.api.PinterestJsonObject) (obj)), null)).get(0));
            return;
        } else
        {
            showWaitDialog(0x7f0e02c4);
            return;
        }
    }

    protected ComponentType getComponentType()
    {
        if (componentType == null)
        {
            componentType = ComponentType.MODAL_ADD_PIN;
            if (this instanceof RepinFragment)
            {
                componentType = ComponentType.MODAL_REPIN;
            }
        }
        return componentType;
    }

    protected com.pinterest.api.remote.PinApi.PinSubmitParams getPinSubmitParams()
    {
        com.pinterest.api.remote.PinApi.PinSubmitParams pinsubmitparams = new com.pinterest.api.remote.PinApi.PinSubmitParams();
        pinsubmitparams.a = String.valueOf(boardUid);
        pinsubmitparams.k = String.valueOf(placeUid);
        pinsubmitparams.b = descriptionEt.getText().toString();
        Object obj = getActivity();
        if (obj != null)
        {
            obj = ((Activity) (obj)).getIntent();
            if (obj != null)
            {
                obj = ((Intent) (obj)).getExtras();
                if (obj != null)
                {
                    String s = ((Bundle) (obj)).getString("com.pinterest.EXTRA_PARTNER_ID");
                    if (s != null && s.length() > 0)
                    {
                        pinsubmitparams.j = s;
                    }
                    obj = ((Bundle) (obj)).getString("com.pinterest.EXTRA_PARTNER_PACKAGE");
                    if (obj != null && ((String) (obj)).length() > 0 && !((String) (obj)).equals(Application.context().getPackageName()))
                    {
                        pinsubmitparams.i = ((String) (obj));
                    }
                }
            }
        }
        return pinsubmitparams;
    }

    public abstract int getTitleId();

    protected void init(View view)
    {
        if (imageUri != null)
        {
            setImageUri(imageUri);
        }
    }

    public boolean isValid()
    {
        if (StringUtils.isEmpty(boardUid))
        {
            Application.showToast(0x7f0e0137);
            return false;
        }
        if (descriptionEt.getText().toString().length() == 0)
        {
            Application.showToast(0x7f0e0138);
            return false;
        }
        if (!Device.hasInternet())
        {
            Application.showNoInternetToast();
            return false;
        } else
        {
            return true;
        }
    }

    protected void navigateBoardSelectorFragment(Bundle bundle)
    {
        Pinalytics.a(getActivity(), com/pinterest/activity/create/fragment/BoardPickerFragment);
        BoardPickerFragment boardpickerfragment = new BoardPickerFragment();
        if (bundle != null)
        {
            boardpickerfragment.setArguments(bundle);
        }
        FragmentHelper.replaceFragment(getActivity(), boardpickerfragment, true);
    }

    public void onCreate(Bundle bundle)
    {
        setRetainInstance(true);
        super.onCreate(bundle);
        _layoutId = 0x7f03007a;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (bundle != null)
        {
            boardUid = bundle.getString("boardUid");
            placeUid = bundle.getString("placeUid");
            imageUri = (Uri)bundle.getParcelable("imageUri");
        } else
        {
            boardUid = getActivity().getIntent().getStringExtra("com.pinterest.EXTRA_BOARD_ID");
            placeUid = getActivity().getIntent().getStringExtra("com.pinterest.EXTRA_PLACE_ID");
        }
        scroller = (ScrollView)layoutinflater.findViewById(0x7f0b014f);
        mainContent = (ViewGroup)layoutinflater.findViewById(0x7f0b0121);
        pinIv = (WebImageView)layoutinflater.findViewById(0x7f0b0150);
        descriptionEt = (EditText)layoutinflater.findViewById(0x7f0b0152);
        locationTv = (TextView)layoutinflater.findViewById(0x7f0b0153);
        locationTv.setOnClickListener(onLocationEtClicked);
        boardWrapper = (PinIconTextView)layoutinflater.findViewById(0x7f0b0154);
        boardWrapper.setOnClickListener(onBoardsClicked);
        boardWrapper.setLabel(0x7f0e007f);
        boardWrapper.setArrowVis(0);
        boardWrapper.setPaddingDimen(0x7f0a0098, 0x7f0a0093);
        boardTv = (TextView)boardWrapper.findViewById(0x7f0b0065);
        boardTv.setTypeface(Typeface.DEFAULT_BOLD);
        boardIv = (WebImageView)boardWrapper.findViewById(0x7f0b01d8);
        _positiveBtn = (PButton)layoutinflater.findViewById(0x7f0b0155);
        _positiveBtn.setIconTint(0x106000b);
        if (LocaleUtils.isLanguageJa())
        {
            ViewHelper.setLeftDrawable(_positiveBtn, 0x7f020136);
            _positiveBtn.setText(0x7f0e014b);
            _positiveBtn.setTypeface(null, 1);
        } else
        {
            ViewHelper.setLeftDrawable(_positiveBtn, 0x7f020135);
        }
        _negativeBtn = (PButton)layoutinflater.findViewById(0x7f0b0156);
        _positiveBtn.setStyle(com.pinterest.ui.text.PButton.ButtonStyle.RED);
        _positiveBtn.setOnClickListener(_pinClick);
        MyUserApi.a(onBoardsLoaded, getApiTag());
        init(layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        pinIv.clear();
        super.onDestroyView();
    }

    public void onPause()
    {
        Device.hideSoftKeyboard(descriptionEt);
        Events.unregister(_eventsSubscriber);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Events.registerSticky(_eventsSubscriber, com/pinterest/activity/create/helper/CreateBoardHelper$BoardCreatedEvent, new Class[] {
            com/pinterest/activity/create/BoardSelectedEvent, com/pinterest/activity/place/PlaceSelectedEvent
        });
        autoPickBoard();
        updatePlaceDisplay(ModelHelper.getPlace(placeUid));
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (boardUid != null)
        {
            bundle.putString("boardUid", boardUid);
        }
        if (imageUri != null)
        {
            bundle.putParcelable("imageUri", imageUri);
        }
        if (placeUid != null)
        {
            bundle.putString("placeUid", placeUid);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart()
    {
        super.onStart();
        descriptionEt.clearFocus();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (_pinnableImage != null)
        {
            setPinnableImage(_pinnableImage);
        } else
        if (imageUri != null)
        {
            setImageUri(imageUri);
            return;
        }
    }

    public abstract void pin();

    public void scrollTo(int i, int j)
    {
        if (scroller != null)
        {
            scroller.smoothScrollTo(i, j);
        }
    }

    public void setImageUri(Uri uri)
    {
        imageUri = uri;
        try
        {
            uri = ImageUtils.imageFromUri(getActivity(), imageUri, 0, 0, 400, 267, false, null);
            pinIv.setImageBitmap(uri);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return;
        }
    }

    public void setNegativeButtonAction(String s, android.view.View.OnClickListener onclicklistener)
    {
        boolean flag = StringUtils.isEmpty(s);
        if (!flag)
        {
            _negativeBtn.setText(s);
            _negativeBtn.setOnClickListener(onclicklistener);
            _negativeBtn.setVisibility(0);
        } else
        {
            _negativeBtn.setVisibility(8);
        }
        s = (android.widget.RelativeLayout.LayoutParams)_positiveBtn.getLayoutParams();
        if (s != null)
        {
            byte byte0;
            if (flag)
            {
                byte0 = 14;
            } else
            {
                byte0 = 11;
            }
            s.addRule(byte0);
        }
    }

    public void setPinnableImage(PinnableImage pinnableimage)
    {
        _pinnableImage = pinnableimage;
        if (pinIv == null || descriptionEt == null)
        {
            return;
        }
        if (ModelHelper.isValidString(_pinnableImage.getImageUrl()))
        {
            pinIv.loadUrl(_pinnableImage.getImageUrl());
        }
        if (ModelHelper.isValidString(_pinnableImage.getDescription()))
        {
            descriptionEt.setText(_pinnableImage.getDescription());
        }
        updatePlaceDisplay(_pinnableImage.getPlace());
    }

    protected void showBoardSelector()
    {
        navigateBoardSelectorFragment(null);
    }

    public void updateFromIntent()
    {
        updatePlaceDisplay(ModelHelper.getPlace(getActivity().getIntent().getStringExtra("com.pinterest.EXTRA_PLACE_ID")));
    }

    public void updatePlaceDisplay(Place place)
    {
        if (place != null)
        {
            if (_icChevron == null)
            {
                _icChevron = Resources.drawable(0x7f02006c);
            }
            if (_icMap == null)
            {
                _icMap = Resources.drawable(0x7f02012e);
            }
            locationTv.setTag(place.getUid());
            locationTv.setText(place.getName());
            Object obj1 = locationTv;
            Object obj;
            if (place.canEdit())
            {
                obj = onLocationEtClicked;
            } else
            {
                obj = null;
            }
            ((TextView) (obj1)).setOnClickListener(((android.view.View.OnClickListener) (obj)));
            obj = locationTv;
            obj1 = _icMap;
            if (place.canEdit())
            {
                place = _icChevron;
            } else
            {
                place = null;
            }
            ((TextView) (obj)).setCompoundDrawablesWithIntrinsicBounds(((Drawable) (obj1)), null, place, null);
        }
    }




    private class _cls1
        implements android.view.View.OnClickListener
    {

        final CreateBaseFragment this$0;

        public void onClick(View view)
        {
label0:
            {
                if (isValid())
                {
                    if (!(CreateBaseFragment.this instanceof CreatePinFragment))
                    {
                        break label0;
                    }
                    showWaitDialog(0x7f0e0319);
                    (new AsyncPinTask()).execute(new Void[0]);
                }
                return;
            }
            if (CreateBaseFragment.this instanceof PinEditFragment)
            {
                pin();
                return;
            } else
            {
                _positiveBtn.setOnClickListener(null);
                pin();
                getActivity().onBackPressed();
                return;
            }
        }

        _cls1()
        {
            this$0 = CreateBaseFragment.this;
            super();
        }

        private class AsyncPinTask extends AsyncTask
        {

            final CreateBaseFragment this$0;

            protected transient Boolean doInBackground(Void avoid[])
            {
                _positiveBtn.setOnClickListener(null);
                pin();
                return Boolean.valueOf(true);
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Boolean boolean1)
            {
                hideWaitDialog();
                boolean1 = getActivity();
                if (boolean1 != null)
                {
                    boolean1.finish();
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Boolean)obj);
            }

            AsyncPinTask()
            {
                this$0 = CreateBaseFragment.this;
                super();
            }
        }

    }


    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final CreateBaseFragment this$0;

        public void onEventMainThread(BoardSelectedEvent boardselectedevent)
        {
            Events.removeStickyEvent(boardselectedevent);
            boardUid = boardselectedevent.getBoardId();
            autoPickBoard();
        }

        public void onEventMainThread(com.pinterest.activity.create.helper.CreateBoardHelper.BoardCreatedEvent boardcreatedevent)
        {
            Events.removeStickyEvent(boardcreatedevent);
            boardUid = boardcreatedevent.getBoardId();
            autoPickBoard();
        }

        public void onEventMainThread(PlaceSelectedEvent placeselectedevent)
        {
            Events.removeStickyEvent(placeselectedevent);
            placeUid = placeselectedevent.getSelectedPlace().getUid();
            getActivity().getIntent().putExtra("com.pinterest.EXTRA_PLACE_ID", placeUid);
            updatePlaceDisplay(placeselectedevent.getSelectedPlace());
        }

        _cls2()
        {
            this$0 = CreateBaseFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final CreateBaseFragment this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.BOARD_PICKER, getComponentType());
            Device.hideSoftKeyboard(descriptionEt);
            showBoardSelector();
        }

        _cls3()
        {
            this$0 = CreateBaseFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final CreateBaseFragment this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.ADD_PLACE_BUTTON);
            view = new Navigation(Location.PLACE_PICKER);
            view.putExtra("com.pinterest.EXTRA_MODE", com.pinterest.activity.place.fragment.PlacePickerFragment.Mode.EDIT);
            PlacePickerFragment placepickerfragment = new PlacePickerFragment();
            placepickerfragment.setNavigation(view);
            FragmentHelper.replaceFragment(getActivity(), placepickerfragment, true);
        }

        _cls4()
        {
            this$0 = CreateBaseFragment.this;
            super();
        }
    }


    private class _cls5 extends com.pinterest.api.remote.MyUserApi.BoardPickerApiResponse
    {

        final CreateBaseFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            try
            {
                if (DiskCache.getJsonObject("MY_PICKER_BOARDS") != null)
                {
                    break MISSING_BLOCK_LABEL_30;
                }
                throwable = getActivity();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable)
            {
                return;
            }
            if (throwable == null)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            throwable.onBackPressed();
        }

        public void onFinish()
        {
            hideWaitDialog();
        }

        public void onSuccess(Feed feed)
        {
            super.onSuccess(feed);
            if (StringUtils.isEmpty(boardUid))
            {
                autoPickBoard();
            }
        }

        _cls5()
        {
            this$0 = CreateBaseFragment.this;
            super();
        }
    }

}
