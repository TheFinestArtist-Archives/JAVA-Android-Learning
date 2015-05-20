// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.appwidget;


public class MccMncSet
{

    public static final String DEFAULT_OPERATOR = "Telefonica";
    private static final String TEMPLATE = "Operator: %s MCC: %d, MNC: %d";
    public int mcc;
    public int mncs[];
    public String operator;

    public transient MccMncSet(String s, int i, int ai[])
    {
        operator = "Telefonica";
        operator = s;
        mcc = i;
        mncs = ai;
    }

    public boolean contains(int i)
    {
        if (mncs != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int ai[] = mncs;
        int k = ai.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                if (ai[j] == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public String toString()
    {
        return String.format("Operator: %s MCC: %d, MNC: %d", new Object[] {
            operator, Integer.valueOf(mcc), Integer.valueOf(mncs[0])
        });
    }
}
