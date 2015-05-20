// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model.metadata.recipe;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.kit.application.Resources;

public class CookTimes
{

    public static final int COOK = 2;
    public static final int NONE = -1;
    public static final int PREP = 1;
    public static final int TOTAL = 0;
    private String _cookDisplay;
    private String _prepDisplay;
    private String _totalDisplay;

    public CookTimes(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return;
        } else
        {
            resolveTimes(pinterestjsonobject);
            return;
        }
    }

    private String findDisplay(int i, int j, int k)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 66
    //                   1 111
    //                   2 156;
           goto _L1 _L2 _L3 _L4
_L1:
        i = -1;
_L5:
        if (i != -1)
        {
            if (j != 0)
            {
                return Resources.stringPlural(i, Integer.valueOf(j), new Object[] {
                    Integer.valueOf(j), Integer.valueOf(k)
                });
            } else
            {
                return Resources.stringPlural(i, Integer.valueOf(k), new Object[] {
                    Integer.valueOf(k)
                });
            }
        } else
        {
            return null;
        }
_L2:
        if (j != 0 && k != 0)
        {
            if (k > 1)
            {
                i = 0x7f0d0021;
            } else
            {
                i = 0x7f0d0020;
            }
        } else
        {
            if (j == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = 0x7f0d001f;
        }
          goto _L5
        if (k == 0) goto _L1; else goto _L6
_L6:
        i = 0x7f0d0022;
          goto _L5
_L3:
        if (j != 0 && k != 0)
        {
            if (k > 1)
            {
                i = 0x7f0d001d;
            } else
            {
                i = 0x7f0d001c;
            }
        } else
        {
            if (j == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = 0x7f0d001b;
        }
          goto _L5
        if (k == 0) goto _L1; else goto _L7
_L7:
        i = 0x7f0d001e;
          goto _L5
_L4:
        if (j != 0 && k != 0)
        {
            if (k > 1)
            {
                i = 0x7f0d0018;
            } else
            {
                i = 0x7f0d0017;
            }
        } else
        {
            if (j == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = 0x7f0d0016;
        }
          goto _L5
        if (k == 0) goto _L1; else goto _L8
_L8:
        i = 0x7f0d0019;
          goto _L5
    }

    private void resolveTimes(PinterestJsonObject pinterestjsonobject)
    {
        PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("total");
        if (pinterestjsonobject1 != null)
        {
            resolveTypedTime(0, pinterestjsonobject1);
        }
        pinterestjsonobject1 = pinterestjsonobject.c("prep");
        if (pinterestjsonobject1 != null)
        {
            resolveTypedTime(1, pinterestjsonobject1);
        }
        pinterestjsonobject = pinterestjsonobject.c("cook");
        if (pinterestjsonobject != null)
        {
            resolveTypedTime(2, pinterestjsonobject);
        }
    }

    private void resolveTypedTime(int i, PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return;
        }
        int j = pinterestjsonobject.a("h", 0);
        int k = pinterestjsonobject.a("m", 0);
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            _totalDisplay = findDisplay(i, j, k);
            return;

        case 1: // '\001'
            _prepDisplay = findDisplay(i, j, k);
            return;

        case 2: // '\002'
            _cookDisplay = findDisplay(i, j, k);
            break;
        }
    }

    public String getCookDisplay()
    {
        return _cookDisplay;
    }

    public String getDisplay()
    {
        if (ModelHelper.isValid(_totalDisplay))
        {
            return _totalDisplay;
        }
        if (ModelHelper.isValid(_cookDisplay))
        {
            return _cookDisplay;
        }
        if (ModelHelper.isValid(_prepDisplay))
        {
            return _prepDisplay;
        } else
        {
            return null;
        }
    }

    public String getPrepDisplay()
    {
        return _prepDisplay;
    }

    public String getTotalDisplay()
    {
        return _totalDisplay;
    }
}
