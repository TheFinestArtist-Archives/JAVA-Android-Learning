// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.graphics.Rect;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinMetadata;
import com.pinterest.api.model.metadata.article.Article;
import com.pinterest.api.model.metadata.movie.Movie;
import com.pinterest.api.model.metadata.product.Product;
import com.pinterest.api.model.metadata.recipe.Recipe;
import com.pinterest.api.remote.SiteApi;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.time.FuzzyDateFormatter;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.text.PButton;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView

public class PinCloseupClickThroughView extends PinCloseupSubView
    implements android.view.View.OnClickListener
{

    private String _buttonText;
    private CharSequence _createdAtText;
    private TextView _createdAtTv;
    private String _linkUrl;
    private PButton _siteBt;
    private TextView _urlTv;
    private android.view.View.OnClickListener onSourceSiteClicked;
    private android.view.View.OnClickListener onWebsiteButtonClicked;

    public PinCloseupClickThroughView(Context context)
    {
        super(context);
        onWebsiteButtonClicked = new _cls1();
        onSourceSiteClicked = new _cls2();
    }

    public static void gotoPinLink(Context context, String s, Pin pin, String s1)
    {
        if (StringUtils.isNotEmpty(s))
        {
            SiteApi.d(s, pin.getUid(), new _cls3(context), s1);
            return;
        } else
        {
            gotoVerifiedLink(context, s, pin);
            return;
        }
    }

    private static void gotoVerifiedLink(Context context, String s, Pin pin)
    {
        if (!ModelHelper.isValid(s))
        {
            return;
        }
        context = new Navigation(Location.BROWSER, s);
        if (pin != null)
        {
            context.putExtra("Referer", pin.getPinterestLink());
        }
        context.putExtra("com.pinterest.EXTRA_WEBPAGE_PINNABLE", Boolean.valueOf(true));
        Events.post(context);
    }

    private boolean updateCreatedAtText()
    {
        boolean flag = true;
        android.text.Spanned spanned = null;
        java.util.Date date = _pin.getCreatedAt();
        if (date != null)
        {
            spanned = Html.fromHtml(Resources.string(0x7f0e037a, new Object[] {
                FuzzyDateFormatter.a(date)
            }));
        }
        if (StringUtils.equals(_createdAtText, spanned))
        {
            flag = false;
        }
        _createdAtText = spanned;
        return flag;
    }

    private boolean updateLinkUrl()
    {
        String s = _pin.getClickThroughUrl();
        boolean flag;
        if (!StringUtils.equals(_linkUrl, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _linkUrl = s;
        return flag;
    }

    protected void init()
    {
        _padding.top = Constants.MARGIN_HALF;
        _padding.bottom = Constants.MARGIN_HALF;
    }

    protected void initView()
    {
        setBackgroundColor(Colors.WHITE);
        removeAllViews();
        setOrientation(1);
        _createdAtTv = new TextView(getContext(), null, 0x7f0f01a7);
        _createdAtTv.setPadding(Constants.MARGIN, 0, Constants.MARGIN, 0);
        _createdAtTv.setTextSize(0, Resources.dimension(0x7f0a00f6));
        _createdAtTv.setMaxLines(1);
        _createdAtTv.setTextColor(Colors.GRAY_SOLID);
        addView(_createdAtTv, -1, -2);
        ((android.view.ViewGroup.MarginLayoutParams)_createdAtTv.getLayoutParams()).setMargins(0, 0, 0, -Constants.MARGIN_HALF);
        _urlTv = new TextView(getContext(), null, 0x7f0f01a7);
        _urlTv.setOnClickListener(this);
        _urlTv.setPadding(Constants.MARGIN, 0, Constants.MARGIN, 0);
        _urlTv.setTextSize(0, Resources.dimension(0x7f0a00f6));
        _urlTv.setMaxLines(1);
        _urlTv.setEllipsize(android.text.TextUtils.TruncateAt.END);
        _urlTv.setTextColor(Colors.GRAY_SOLID);
        addView(_urlTv, -1, -2);
        ((android.view.ViewGroup.MarginLayoutParams)_urlTv.getLayoutParams()).setMargins(0, -Constants.MARGIN_HALF, 0, -Constants.MARGIN_HALF);
        _siteBt = new PButton(getContext(), null, 0x7f0f0126);
        _siteBt.setOnClickListener(this);
        _siteBt.setStyle(com.pinterest.ui.text.PButton.ButtonStyle.PLAIN);
        _siteBt.setMaxLines(1);
        _siteBt.setVisibility(8);
        _siteBt.setTypeface(null, 1);
        _siteBt.setTextColor(Colors.GRAY_SOLID);
        _siteBt.setGravity(17);
        _siteBt.setEllipsize(android.text.TextUtils.TruncateAt.END);
        _siteBt.setTextSize(0, Resources.dimension(0x7f0a00f4));
        ViewHelper.setViewPadding(_urlTv, Constants.MARGIN);
        addView(_siteBt, -1, Constants.BUTTON_HEIGHT);
        ((android.view.ViewGroup.MarginLayoutParams)_siteBt.getLayoutParams()).setMargins(Constants.MARGIN, Constants.MARGIN_HALF, Constants.MARGIN, Constants.MARGIN_HALF);
    }

    public void onClick(View view)
    {
        if (view == _urlTv)
        {
            onSourceSiteClicked.onClick(view);
        } else
        if (view == _siteBt)
        {
            onWebsiteButtonClicked.onClick(view);
            return;
        }
    }

    protected boolean shouldUpdateView()
    {
        return BooleanUtils.or(new boolean[] {
            updateButtonText(), updateCreatedAtText(), updateLinkUrl()
        });
    }

    public boolean updateButtonText()
    {
        int i = 0x7f0e04f0;
        String s = _pin.getDomain();
        boolean flag;
        if (_pinMetadata != null && ModelHelper.isValid(_pinMetadata.getWebsiteName()))
        {
            if (_pinMetadata instanceof Recipe)
            {
                i = 0x7f0e04f3;
            } else
            if (_pinMetadata instanceof Movie)
            {
                i = 0x7f0e04ee;
            } else
            if (_pinMetadata instanceof Product)
            {
                i = 0x7f0e04f1;
            } else
            if (_pinMetadata instanceof Article)
            {
                i = 0x7f0e04ed;
            }
            s = _pin.getMetadata().getWebsiteName();
        } else
        {
            i = 0x7f0e04f0;
        }
        if (StringUtils.isNotBlank(s))
        {
            if (StringUtils.isBlank(s))
            {
                s = null;
            } else
            {
                s = Resources.string(i, new Object[] {
                    s
                });
            }
        } else
        {
            s = null;
        }
        if (!StringUtils.equals(_buttonText, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _buttonText = s;
        return flag;
    }

    protected void updateView()
    {
        _createdAtTv.setText(_createdAtText);
        _urlTv.setText(_linkUrl);
        if (StringUtils.isNotBlank(_buttonText))
        {
            _siteBt.setText(_buttonText);
            _siteBt.setVisibility(0);
            return;
        } else
        {
            _siteBt.setVisibility(8);
            return;
        }
    }



    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PinCloseupClickThroughView this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.WEBSITE_BUTTON, ComponentType.MODAL_PIN, _pin.getUid(), _pin.getLoggingAuxData());
            PinCloseupClickThroughView.gotoPinLink(getContext(), _linkUrl, _pin, _apiTag);
            int i = EducationHelper.b();
            if (i == Experience.ANDROID_CLICKTHROUGH_ED.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_HELPER.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_TABLET.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_HELPER_TABLET.getValue())
            {
                Events.post(new EducationEvent(com.pinterest.activity.task.education.event.EducationEvent.Type.NEXT));
            }
        }

        _cls1()
        {
            this$0 = PinCloseupClickThroughView.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PinCloseupClickThroughView this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.PIN_ATTRIBUTION, ComponentType.MODAL_PIN);
            if (_pin.hasAttribution() && !_pin.hasMetadata())
            {
                PinCloseupClickThroughView.gotoPinLink(getContext(), _pin.getAttrProviderUrl(), _pin, _apiTag);
                return;
            } else
            {
                PinCloseupClickThroughView.gotoPinLink(getContext(), _linkUrl, _pin, _apiTag);
                return;
            }
        }

        _cls2()
        {
            this$0 = PinCloseupClickThroughView.this;
            super();
        }
    }


    private class _cls3 extends ApiResponseHandler
    {

        final Context val$context;
        final String val$link;
        final Pin val$pin;

        public final void onSuccess(final ApiResponse url)
        {
            super.onSuccess(url);
            Pinalytics.a(EventType.PIN_CLICKTHROUGH, pin.getUid());
            StopWatch.get().complete("clickthrough_verify");
            Object obj = (PinterestJsonObject)url.getData();
            String s = ((PinterestJsonObject) (obj)).a("redirect_status", "");
            url = ((PinterestJsonObject) (obj)).a("url", link);
            obj = ((PinterestJsonObject) (obj)).a("message", Resources.string(0x7f0e0371));
            if (s.equalsIgnoreCase("blocked"))
            {
                url = new BaseDialog();
                url.setTitle(0x7f0e0492);
                url.setMessage(((String) (obj)));
                url.setPositiveButton(0x7f0e033a, null);
                Events.post(new DialogEvent(url));
                return;
            }
            if (s.equalsIgnoreCase("suspicious"))
            {
                BaseDialog basedialog = new BaseDialog();
                basedialog.setTitle(0x7f0e04f7);
                basedialog.setMessage(((String) (obj)));
                basedialog.setNegativeButton(0x7f0e008f, null);
                class _cls1
                    implements android.view.View.OnClickListener
                {

                    final _cls3 this$0;
                    final String val$url;

                    public void onClick(View view)
                    {
                        PinCloseupClickThroughView.gotoVerifiedLink(context, url, pin);
                    }

                _cls1()
                {
                    this$0 = _cls3.this;
                    url = s;
                    super();
                }
                }

                basedialog.setPositiveButton(0x7f0e0458, new _cls1());
                Events.post(new DialogEvent(basedialog));
                return;
            } else
            {
                PinCloseupClickThroughView.gotoVerifiedLink(context, url, pin);
                return;
            }
        }

        _cls3(Context context1)
        {
            pin = pin1;
            link = s;
            context = context1;
            super(final_flag);
        }
    }

}
