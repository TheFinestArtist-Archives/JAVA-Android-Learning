// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.graphics.Rect;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Place;
import com.pinterest.api.model.metadata.article.Article;
import com.pinterest.api.model.metadata.movie.Movie;
import com.pinterest.api.model.metadata.product.Product;
import com.pinterest.api.model.metadata.recipe.CategorizedIngredient;
import com.pinterest.api.model.metadata.recipe.Ingredient;
import com.pinterest.api.model.metadata.recipe.Recipe;
import com.pinterest.base.Constants;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.text.PTextView;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView

public class PinCloseupRichDataView extends PinCloseupSubView
{

    public PinCloseupRichDataView(Context context)
    {
        super(context);
    }

    private void addMovieRow(String s, CharSequence charsequence)
    {
        PTextView ptextview = new PTextView(getContext(), null, 0x7f0f01a7);
        ptextview.setText(Html.fromHtml((new StringBuilder("<b>")).append(s).append("</b><br/>").append(charsequence).toString()));
        ptextview.setPadding(0, 0, 0, Constants.MARGIN);
        addView(ptextview, -1, -2);
    }

    private void addPlaceRow(String s, CharSequence charsequence, android.view.View.OnClickListener onclicklistener)
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        linearlayout.setOrientation(0);
        PTextView ptextview = new PTextView(getContext());
        ptextview.setTextAppearance(getContext(), 0x7f0f01a7);
        ptextview.setText(s);
        ptextview.setTypeface(null, 1);
        ptextview.setLayoutParams(getLblLp());
        linearlayout.addView(ptextview);
        s = new PTextView(getContext());
        s.setTextAppearance(getContext(), 0x7f0f01a7);
        s.setText(charsequence);
        s.setLayoutParams(getItemsLp(false));
        linearlayout.addView(s);
        linearlayout.setOnClickListener(onclicklistener);
        addView(linearlayout, -1, -2);
    }

    private android.widget.LinearLayout.LayoutParams getItemsLp(boolean flag)
    {
        float f;
        android.widget.LinearLayout.LayoutParams layoutparams;
        int i;
        if (flag)
        {
            f = 0.75F;
        } else
        {
            f = 1.0F;
        }
        if (flag)
        {
            i = 0;
        } else
        {
            i = Constants.MARGIN_HALF;
        }
        layoutparams = new android.widget.LinearLayout.LayoutParams(0, -2, f);
        layoutparams.setMargins(i, 0, Constants.MARGIN_HALF, 0);
        return layoutparams;
    }

    private android.widget.LinearLayout.LayoutParams getLblLp()
    {
        return new android.widget.LinearLayout.LayoutParams(0, -2, 0.25F);
    }

    private void styleButton(Button button)
    {
        button.setTextAppearance(getContext(), 0x7f0f0126);
        button.setBackgroundResource(0x7f020042);
    }

    protected void displayArticle()
    {
        Article article = (Article)_pinMetadata;
        PTextView ptextview = new PTextView(getContext());
        ptextview.setTextAppearance(getContext(), 0x7f0f0110);
        ptextview.setText(article.getDescription());
        ptextview.setLineSpacing(0.0F, 1.2F);
        addView(ptextview, -1, -2);
    }

    protected void displayMovie()
    {
        Movie movie = (Movie)_pinMetadata;
        if (!movie.hasWriters() && !movie.hasDirectors())
        {
            movie.hasActors();
        }
        if (movie.hasRating())
        {
            PTextView ptextview = new PTextView(getContext());
            ptextview.setTextAppearance(getContext(), 0x7f0f01a7);
            ptextview.setText(movie.getRatingDisplay());
            ptextview.setPadding(0, 0, 0, Constants.MARGIN);
            addView(ptextview, -1, -2);
        }
        if (movie.hasWriters())
        {
            addMovieRow(Resources.stringPlural(0x7f0d0012, Integer.valueOf(movie.getWriters().size())), movie.getWritersDisplay());
        }
        if (movie.hasDirectors())
        {
            addMovieRow(Resources.stringPlural(0x7f0d0011, Integer.valueOf(movie.getDirectors().size())), movie.getDirectorsDisplay());
        }
        if (movie.hasActors())
        {
            addMovieRow(Resources.stringPlural(0x7f0d0010, Integer.valueOf(movie.getActors().size())), movie.getActorsDisplay());
        }
        if (getChildCount() > 0)
        {
            getChildAt(getChildCount() - 1).setPadding(0, 0, 0, 0);
        }
    }

    protected void displayPlace()
    {
        if (ModelHelper.isValid(_pinPlace.getAddressDisplay()))
        {
            addPlaceRow(Resources.string(0x7f0e002c), _pinPlace.getAddressDisplay(), new _cls1());
        }
        if (ModelHelper.isValid(_pinPlace.getPhone()))
        {
            addPlaceRow(Resources.string(0x7f0e0351), _pinPlace.getPhone(), new _cls2());
        }
        if (ModelHelper.isValid(_pinPlace.getUrl()))
        {
            addPlaceRow(Resources.string(0x7f0e04f9), _pinPlace.getUrl(), new _cls3());
        }
    }

    protected void displayProduct()
    {
    }

    protected void displayRecipe()
    {
        List list = ((Recipe)_pinMetadata).getCategorizedIngredients();
        for (int i = 0; i < list.size(); i++)
        {
            Object obj = (CategorizedIngredient)list.get(i);
            PTextView ptextview = new PTextView(getContext());
            ptextview.setTextAppearance(getContext(), 0x7f0f01a7);
            ptextview.setText(((CategorizedIngredient) (obj)).getCategory());
            ptextview.setTypeface(null, 1);
            ptextview.setPadding(0, Constants.MARGIN, 0, 0);
            addView(ptextview, -1, -2);
            obj = ((CategorizedIngredient) (obj)).getIngredients();
            for (int j = 0; j < ((List) (obj)).size(); j++)
            {
                Ingredient ingredient = (Ingredient)((List) (obj)).get(j);
                LinearLayout linearlayout = new LinearLayout(getContext());
                linearlayout.setOrientation(0);
                boolean flag = StringUtils.isNotEmpty(ingredient.getAmount());
                if (flag)
                {
                    PTextView ptextview1 = new PTextView(getContext());
                    ptextview1.setTextAppearance(getContext(), 0x7f0f01a7);
                    ptextview1.setTypeface(null, 1);
                    ptextview1.setText(ingredient.getAmount());
                    ptextview1.setLayoutParams(getLblLp());
                    ptextview1.setSingleLine(true);
                    ptextview1.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    ptextview1.setMaxLines(1);
                    linearlayout.addView(ptextview1);
                }
                TextView textview = new TextView(getContext());
                textview.setTextAppearance(getContext(), 0x7f0f01a7);
                textview.setText(ingredient.getName());
                textview.setLayoutParams(getItemsLp(flag));
                linearlayout.addView(textview);
                addView(linearlayout, -1, -2);
            }

        }

    }

    protected void init()
    {
        _padding.bottom = Constants.MARGIN_HALF;
    }

    protected void initView()
    {
        setOrientation(1);
    }

    protected boolean shouldUpdateView()
    {
        return true;
    }

    protected void updateView()
    {
        removeAllViews();
        if (_pinMetadata == null) goto _L2; else goto _L1
_L1:
        if (!(_pinMetadata instanceof Recipe)) goto _L4; else goto _L3
_L3:
        displayRecipe();
_L2:
        if (_pinPlace != null)
        {
            displayPlace();
        }
        return;
_L4:
        if (_pinMetadata instanceof Movie)
        {
            displayMovie();
        } else
        if (_pinMetadata instanceof Product)
        {
            displayProduct();
        } else
        if (_pinMetadata instanceof Article)
        {
            displayArticle();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PinCloseupRichDataView this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.MAP_DIRECTIONS_BUTTON, null, _pin.getUid());
            ActivityHelper.goIntentPlace(getContext(), _pinPlace);
        }

        _cls1()
        {
            this$0 = PinCloseupRichDataView.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PinCloseupRichDataView this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.PHONE_BUTTON, null, _pin.getUid());
            ActivityHelper.goIntentView(getContext(), (new StringBuilder("tel:")).append(_pinPlace.getPhone()).toString());
        }

        _cls2()
        {
            this$0 = PinCloseupRichDataView.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final PinCloseupRichDataView this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.WEBSITE_BUTTON, null, _pin.getUid());
            Events.post(new Navigation(Location.BROWSER, _pinPlace.getUrl()));
        }

        _cls3()
        {
            this$0 = PinCloseupRichDataView.this;
            super();
        }
    }

}
