// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.sendapin.providers;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.pinterest.activity.contacts.InvitabilityContact;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.kit.utils.SignupFormUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class ContactsProvider
{

    private static final Uri CONTACTS_URI;
    private static final String PROJECTION_EMAIL[] = {
        "_id", "photo_id", "display_name", "contact_id", "data1"
    };
    private static final String PROJECTION_PHONE[] = {
        "_id", "photo_id", "display_name", "contact_id", "data1"
    };
    private static final String TAG = "ContactsProvider";
    private static final String WHERE_FORMAT = "%s LIKE '%s' OR %s LIKE '%s' AND %s <> '' AND %s = 1";
    private static List bannedEmailDomains;

    public ContactsProvider()
    {
    }

    public static String escapeQuotes(String s)
    {
        return StringUtils.replace(s, "'", "''");
    }

    private static String extractEmail(String s)
    {
        s = s.split("<|>|\\s");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            CharSequence charsequence = s[i];
            if (StringUtils.isNotEmpty(charsequence) && SignupFormUtils.isEmailValid(charsequence))
            {
                return charsequence;
            }
        }

        return null;
    }

    public static void fillInvitabilityContactsWithCloseFriend(Context context, HashMap hashmap)
    {
        String s = String.format("%s = 1 AND %s in %s", new Object[] {
            "in_visible_group", "_id", toSqlWhereInString(hashmap.keySet())
        });
        context = context.getContentResolver().query(android.provider.ContactsContract.Contacts.CONTENT_STREQUENT_URI, new String[] {
            "_id"
        }, s, null, null);
        if (context != null && context.moveToFirst())
        {
            int i = context.getColumnIndex("_id");
            for (; !context.isAfterLast(); context.moveToNext())
            {
                long l = context.getLong(i);
                if (hashmap.containsKey(Long.valueOf(l)))
                {
                    ((InvitabilityContact)hashmap.get(Long.valueOf(l))).isCloseFriend = true;
                }
            }

            context.close();
        }
    }

    public static void fillInvitabilityContactsWithEmail(Context context, HashMap hashmap, int i)
    {
        Object obj = String.format("%s <> '' AND %s = 1", new Object[] {
            "data1", "in_visible_group"
        });
        Object obj1 = (new StringBuilder("contact_id LIMIT ")).append(i).toString();
        obj = context.getContentResolver().query(android.provider.ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] {
            "contact_id", "display_name", "photo_id", "data1"
        }, ((String) (obj)), null, ((String) (obj1)));
        obj1 = new HashSet();
        if (obj != null && ((Cursor) (obj)).moveToFirst())
        {
            i = ((Cursor) (obj)).getColumnIndex("contact_id");
            int j = ((Cursor) (obj)).getColumnIndex("data1");
            int k = ((Cursor) (obj)).getColumnIndex("display_name");
            int l = ((Cursor) (obj)).getColumnIndex("photo_id");
            while (!((Cursor) (obj)).isAfterLast()) 
            {
                String s = extractEmail(((Cursor) (obj)).getString(j));
                if (s != null && isEmailAllowed(s) && !((HashSet) (obj1)).contains(s))
                {
                    ((HashSet) (obj1)).add(s);
                    long l1 = ((Cursor) (obj)).getLong(i);
                    String s1 = ((Cursor) (obj)).getString(k);
                    String s2 = ((Cursor) (obj)).getString(l);
                    boolean flag;
                    if (hashmap.containsKey(Long.valueOf(l1)))
                    {
                        context = (InvitabilityContact)hashmap.get(Long.valueOf(l1));
                    } else
                    {
                        context = new InvitabilityContact(l1);
                        hashmap.put(Long.valueOf(l1), context);
                    }
                    if (TextUtils.isEmpty(((InvitabilityContact) (context)).email))
                    {
                        context.email = s;
                    }
                    context.name = s1;
                    if (!StringUtils.isEmpty(s2))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    context.hasPhoto = flag;
                    context.numPiecesOfInfo = ((InvitabilityContact) (context)).numPiecesOfInfo + 1;
                }
                ((Cursor) (obj)).moveToNext();
            }
            ((Cursor) (obj)).close();
        }
    }

    public static void fillInvitabilityContactsWithName(Context context, HashMap hashmap)
    {
        String s = String.format("%s = 1 AND %s = \"%s\" AND %s in %s", new Object[] {
            "in_visible_group", "mimetype", "vnd.android.cursor.item/name", "contact_id", toSqlWhereInString(hashmap.keySet())
        });
        context = context.getContentResolver().query(android.provider.ContactsContract.Data.CONTENT_URI, new String[] {
            "contact_id", "data2", "data3"
        }, s, null, null);
        if (context != null && context.moveToFirst())
        {
            int i = context.getColumnIndex("contact_id");
            int j = context.getColumnIndex("data2");
            int k = context.getColumnIndex("data3");
            for (; !context.isAfterLast(); context.moveToNext())
            {
                long l = context.getLong(i);
                String s1 = context.getString(j);
                String s2 = context.getString(k);
                if (hashmap.containsKey(Long.valueOf(l)))
                {
                    InvitabilityContact invitabilitycontact = (InvitabilityContact)hashmap.get(Long.valueOf(l));
                    invitabilitycontact.firstName = s1;
                    invitabilitycontact.lastName = s2;
                }
            }

            context.close();
        }
    }

    public static void fillInvitabilityContactsWithPhone(Context context, HashMap hashmap)
    {
        String s = String.format("%s <> '' AND %s = 1 AND %s in %s", new Object[] {
            "data1", "in_visible_group", "contact_id", toSqlWhereInString(hashmap.keySet())
        });
        context = context.getContentResolver().query(android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] {
            "contact_id", "data1"
        }, s, null, null);
        if (context != null && context.moveToFirst())
        {
            int i = context.getColumnIndex("contact_id");
            int j = context.getColumnIndex("data1");
            for (; !context.isAfterLast(); context.moveToNext())
            {
                long l = context.getLong(i);
                String s1 = context.getString(j);
                if (s1 == null || !hashmap.containsKey(Long.valueOf(l)))
                {
                    continue;
                }
                InvitabilityContact invitabilitycontact = (InvitabilityContact)hashmap.get(Long.valueOf(l));
                if (TextUtils.isEmpty(invitabilitycontact.phoneNumber))
                {
                    invitabilitycontact.phoneNumber = s1;
                }
                invitabilitycontact.numPiecesOfInfo = invitabilitycontact.numPiecesOfInfo + 1;
            }

            context.close();
        }
    }

    public static void fillInvitabilityContactsWithPostal(Context context, HashMap hashmap)
    {
        String s = String.format("%s = 1 AND %s in %s", new Object[] {
            "in_visible_group", "contact_id", toSqlWhereInString(hashmap.keySet())
        });
        context = context.getContentResolver().query(android.provider.ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, new String[] {
            "contact_id"
        }, s, null, null);
        if (context != null && context.moveToFirst())
        {
            int i = context.getColumnIndex("contact_id");
            for (; !context.isAfterLast(); context.moveToNext())
            {
                long l = context.getLong(i);
                if (hashmap.containsKey(Long.valueOf(l)))
                {
                    InvitabilityContact invitabilitycontact = (InvitabilityContact)hashmap.get(Long.valueOf(l));
                    invitabilitycontact.numPiecesOfInfo = invitabilitycontact.numPiecesOfInfo + 1;
                }
            }

            context.close();
        }
    }

    private static String getContactSortOrder()
    {
        String s = "display_name COLLATE LOCALIZED ASC";
        if (Locale.getDefault().getLanguage().equals("ja"))
        {
            s = (new StringBuilder("phonetic_name IS NULL, phonetic_name COLLATE LOCALIZED ASC, ")).append("display_name COLLATE LOCALIZED ASC").toString();
        }
        return s;
    }

    public static List getContactsWithEmail(Context context, String s, int i)
    {
        Object obj1 = Collections.emptyList();
        Object obj = (new StringBuilder()).append(escapeQuotes(s)).append("%").toString();
        obj = String.format("%s LIKE '%s' OR %s LIKE '%s' AND %s <> '' AND %s = 1", new Object[] {
            "display_name", obj, "display_name", (new StringBuilder("% ")).append(((String) (obj))).toString(), "data1", "in_visible_group"
        });
        String s1 = (new StringBuilder()).append(getContactSortOrder()).append(" LIMIT ").append(i).toString();
        context = context.getContentResolver().query(android.provider.ContactsContract.CommonDataKinds.Email.CONTENT_URI, PROJECTION_EMAIL, ((String) (obj)), null, s1);
        obj = new HashSet();
        if (context != null && context.moveToFirst())
        {
            obj1 = new ArrayList(context.getCount());
            i = context.getColumnIndex("display_name");
            int j = context.getColumnIndex("data1");
            int k = context.getColumnIndex("contact_id");
            int l = context.getColumnIndex("photo_id");
            for (; !context.isAfterLast(); context.moveToNext())
            {
                String s2 = extractEmail(context.getString(j));
                if (s2 == null || !isEmailAllowed(s2) || ((HashSet) (obj)).contains(s2))
                {
                    continue;
                }
                String s3 = String.valueOf(context.getLong(k));
                String s4 = context.getString(i);
                TypeAheadItem typeaheaditem = new TypeAheadItem();
                typeaheaditem.setUid(s3);
                typeaheaditem.setTitle(s4);
                typeaheaditem.setItemType(com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_CONTACT);
                if (!StringUtils.isEmpty(context.getString(l)))
                {
                    typeaheaditem.setImageUri((new StringBuilder()).append(CONTACTS_URI).append("/").append(s3).append("/photo").toString());
                }
                typeaheaditem.setIdentifier(s2);
                ((List) (obj1)).add(typeaheaditem);
                ((HashSet) (obj)).add(s2);
            }

            context.close();
            return sortByFirstNameMatch(escapeQuotes(s).toLowerCase(), ((List) (obj1)));
        } else
        {
            return ((List) (obj1));
        }
    }

    public static List getContactsWithPhoneNumber(Context context, String s, int i)
    {
        Object obj1 = Collections.emptyList();
        Object obj = (new StringBuilder()).append(escapeQuotes(s)).append("%").toString();
        obj = String.format("%s LIKE '%s' OR %s LIKE '%s' AND %s <> '' AND %s = 1", new Object[] {
            "display_name", obj, "display_name", (new StringBuilder("% ")).append(((String) (obj))).toString(), "data1", "in_visible_group"
        });
        String s1 = (new StringBuilder()).append(getContactSortOrder()).append(" LIMIT ").append(i).toString();
        context = context.getContentResolver().query(android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PROJECTION_PHONE, ((String) (obj)), null, s1);
        obj = new HashSet();
        if (context != null && context.moveToFirst())
        {
            obj1 = new ArrayList(context.getCount());
            i = context.getColumnIndex("display_name");
            int j = context.getColumnIndex("data1");
            int k = context.getColumnIndex("contact_id");
            int l = context.getColumnIndex("photo_id");
            for (; !context.isAfterLast(); context.moveToNext())
            {
                String s2 = context.getString(j);
                if (s2 == null || ((HashSet) (obj)).contains(s2))
                {
                    continue;
                }
                String s3 = String.valueOf(context.getLong(k));
                String s4 = context.getString(i);
                TypeAheadItem typeaheaditem = new TypeAheadItem();
                typeaheaditem.setUid(s3);
                typeaheaditem.setTitle(s4);
                typeaheaditem.setItemType(com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT);
                if (!StringUtils.isEmpty(context.getString(l)))
                {
                    typeaheaditem.setImageUri((new StringBuilder()).append(CONTACTS_URI).append("/").append(s3).append("/photo").toString());
                }
                typeaheaditem.setIdentifier(s2);
                ((List) (obj1)).add(typeaheaditem);
                ((HashSet) (obj)).add(s2);
            }

            context.close();
            return sortByFirstNameMatch(escapeQuotes(s).toLowerCase(), ((List) (obj1)));
        } else
        {
            return ((List) (obj1));
        }
    }

    private static boolean isEmailAllowed(String s)
    {
        s = s.split("@");
        s = s[s.length - 1];
        return !bannedEmailDomains.contains(s);
    }

    public static List sortByFirstNameMatch(String s, List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        ArrayList arraylist1 = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            TypeAheadItem typeaheaditem = (TypeAheadItem)iterator.next();
            list = typeaheaditem.getTitle();
            int i = list.indexOf(' ');
            if (i > 0)
            {
                String s1 = list.substring(0, i);
                list.substring(i + 1);
                list = s1;
            }
            if (list.toLowerCase().startsWith(s))
            {
                arraylist.add(typeaheaditem);
            } else
            {
                arraylist1.add(typeaheaditem);
            }
        }

        arraylist.addAll(arraylist1);
        return arraylist;
    }

    private static String toSqlWhereInString(Set set)
    {
        return set.toString().replace('[', '(').replace(']', ')');
    }

    static 
    {
        CONTACTS_URI = android.provider.ContactsContract.Contacts.CONTENT_URI;
        ArrayList arraylist = new ArrayList();
        bannedEmailDomains = arraylist;
        arraylist.add("facebook.com");
    }
}
