// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.developer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.pinterest.experiment.Experiments;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DeveloperExperimentView extends LinearLayout
{

    public DeveloperExperimentView(Context context)
    {
        this(context, null);
    }

    public DeveloperExperimentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private static int a(String s, String as[])
    {
        for (int i = 0; i < as.length; i++)
        {
            if (as[i].equals(s))
            {
                return i;
            }
        }

        return 0;
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        setOrientation(1);
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        Map map = Experiments.u();
        LinearLayout linearlayout;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); addView(linearlayout))
        {
            String s = (String)iterator.next();
            linearlayout = (LinearLayout)layoutinflater.inflate(0x7f0300c3, null);
            ((TextView)linearlayout.findViewById(0x7f0b01c7)).setText(s);
            Spinner spinner = (Spinner)linearlayout.findViewById(0x7f0b0075);
            String as[] = (String[])map.get(s);
            spinner.setAdapter(new ArrayAdapter(getContext(), 0x1090009, as));
            spinner.setSelection(a(Experiments.a(s, false), as));
            spinner.setOnItemSelectedListener(new _cls1(s, as));
        }

    }

    private class _cls1
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final String a;
        final String b[];
        final DeveloperExperimentView c;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            Experiments.a(a, b[i]);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        _cls1(String s, String as[])
        {
            c = DeveloperExperimentView.this;
            a = s;
            b = as;
            super();
        }
    }

}
