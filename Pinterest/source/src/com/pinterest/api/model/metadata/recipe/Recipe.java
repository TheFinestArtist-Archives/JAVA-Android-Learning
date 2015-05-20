// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model.metadata.recipe;

import android.text.Html;
import android.text.Spanned;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model.metadata.recipe:
//            AggregateRating, CategorizedIngredient, CookTimes

public class Recipe extends PinMetadata
{

    private AggregateRating _aggregateRating;
    private String _bullet;
    private List _categorizedIngredients;
    private CookTimes _cookTimes;
    private String _description;
    private PinterestJsonArray _diets;
    private String _id;
    private int _ingredientCount;
    private String _metadataDisplay;
    private String _name;
    private String _recipeYield;
    private String _type;

    public Recipe(Pin pin, PinterestJsonObject pinterestjsonobject)
    {
        super(pin, pinterestjsonobject);
        _categorizedIngredients = new ArrayList();
        _diets = new PinterestJsonArray();
        _ingredientCount = 0;
        _bullet = " &#8226; ";
        if (pinterestjsonobject == null)
        {
            return;
        }
        pin = pinterestjsonobject.c("recipe");
        _aggregateRating = new AggregateRating(pin.c("aggregate_rating"));
        _categorizedIngredients = CategorizedIngredient.getCategorizedIngredients(pin.e("categorized_ingredients"));
        _cookTimes = new CookTimes(pin.c("cook_times"));
        _diets = pin.e("diets");
        _description = pin.a("description", "");
        _id = pin.a("id", "");
        _name = pin.a("name", "");
        pinterestjsonobject = pin.c("servings_summary");
        if (pinterestjsonobject == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        _recipeYield = pinterestjsonobject.a("summary", "");
        _type = pin.a("type", "");
        for (pin = _categorizedIngredients.iterator(); pin.hasNext();)
        {
            pinterestjsonobject = (CategorizedIngredient)pin.next();
            int i = _ingredientCount;
            _ingredientCount = pinterestjsonobject.getIngredients().size() + i;
        }

        break MISSING_BLOCK_LABEL_232;
        pin;
        _metadataDisplay = makeMetadataDisplay();
        return;
    }

    private String makeMetadataDisplay()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = getCookTimeDisplay();
        if (ModelHelper.isValid(s))
        {
            stringbuilder.append(s);
        }
        if (ModelHelper.isValid(_recipeYield))
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(_bullet);
            }
            stringbuilder.append(_recipeYield);
        }
        int i = 0;
        for (int j = _diets.a(); i < j; i++)
        {
            if (i == 0 && stringbuilder.length() > 0)
            {
                stringbuilder.append(_bullet);
            }
            stringbuilder.append(_diets.a(i));
            stringbuilder.append(_bullet);
        }

        return StringUtils.removeEnd(stringbuilder.toString(), _bullet);
    }

    public AggregateRating getAggregateRating()
    {
        return _aggregateRating;
    }

    public List getCategorizedIngredients()
    {
        return _categorizedIngredients;
    }

    public String getCookTimeDisplay()
    {
        if (!ModelHelper.isValid(_cookTimes.getDisplay()))
        {
            return null;
        } else
        {
            return _cookTimes.getDisplay();
        }
    }

    public CookTimes getCookTimes()
    {
        return _cookTimes;
    }

    public String getDescription()
    {
        return _description;
    }

    public PinterestJsonArray getDiets()
    {
        return _diets;
    }

    public String getId()
    {
        return _id;
    }

    public Spanned getMetadataDisplay()
    {
        return Html.fromHtml(_metadataDisplay);
    }

    public String getName()
    {
        return _name;
    }

    public String getRecipeYield()
    {
        return _recipeYield;
    }

    public String getType()
    {
        return _type;
    }

    public void setAggregateRating(AggregateRating aggregaterating)
    {
        _aggregateRating = aggregaterating;
    }

    public void setCategorizedIngredients(List list)
    {
        _categorizedIngredients = list;
    }

    public void setCookTimes(CookTimes cooktimes)
    {
        _cookTimes = cooktimes;
    }

    public void setDescription(String s)
    {
        _description = s;
    }

    public void setDiets(PinterestJsonArray pinterestjsonarray)
    {
        _diets = pinterestjsonarray;
    }

    public void setId(String s)
    {
        _id = s;
    }

    public void setName(String s)
    {
        _name = s;
    }

    public void setRecipeYield(String s)
    {
        _recipeYield = s;
    }

    public void setType(String s)
    {
        _type = s;
    }
}
