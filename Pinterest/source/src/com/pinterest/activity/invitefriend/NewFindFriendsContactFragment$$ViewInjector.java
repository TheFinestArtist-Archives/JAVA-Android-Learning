// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.widget.ListView;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsContactFragment

public class 
{

    public static void inject(butterknife.tFragment tfragment, NewFindFriendsContactFragment newfindfriendscontactfragment, Object obj)
    {
        newfindfriendscontactfragment._listView = (ListView)tfragment._listView(obj, 0x7f0b0173, "field '_listView'");
        newfindfriendscontactfragment._searchEt = (SearchEditText)tfragment._searchEt(obj, 0x7f0b014d, "field '_searchEt'");
    }

    public static void reset(NewFindFriendsContactFragment newfindfriendscontactfragment)
    {
        newfindfriendscontactfragment._listView = null;
        newfindfriendscontactfragment._searchEt = null;
    }

    public ()
    {
    }
}
