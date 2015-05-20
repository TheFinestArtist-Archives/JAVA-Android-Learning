// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.data;

import android.content.SharedPreferences;
import com.pinterest.base.Application;
import com.pinterest.kit.application.PApplication;
import java.util.Map;
import java.util.Set;

public class PreferencesManager
{

    private final SharedPreferences _sharedPreferences;

    public PreferencesManager(String s)
    {
        _sharedPreferences = Application.context().getSharedPreferences(s, 0);
    }

    public void clear()
    {
        _sharedPreferences.edit().clear().apply();
    }

    public boolean contains(String s)
    {
        return _sharedPreferences.contains(s);
    }

    public android.content.SharedPreferences.Editor edit()
    {
        return _sharedPreferences.edit();
    }

    public Map getAll()
    {
        return _sharedPreferences.getAll();
    }

    public boolean getBoolean(String s, boolean flag)
    {
        return _sharedPreferences.getBoolean(s, flag);
    }

    public float getFloat(String s, float f)
    {
        return _sharedPreferences.getFloat(s, f);
    }

    public int getInt(String s, int i)
    {
        return _sharedPreferences.getInt(s, i);
    }

    public long getLong(String s, long l)
    {
        return _sharedPreferences.getLong(s, l);
    }

    public String getString(String s, String s1)
    {
        return _sharedPreferences.getString(s, s1);
    }

    public Set getStringSet(String s, Set set1)
    {
        return _sharedPreferences.getStringSet(s, set1);
    }

    public void remove(String s)
    {
        _sharedPreferences.edit().remove(s).apply();
    }

    public void set(String s, float f)
    {
        _sharedPreferences.edit().putFloat(s, f).apply();
    }

    public void set(String s, int i)
    {
        _sharedPreferences.edit().putInt(s, i).apply();
    }

    public void set(String s, long l)
    {
        _sharedPreferences.edit().putLong(s, l).apply();
    }

    public void set(String s, String s1)
    {
        _sharedPreferences.edit().putString(s, s1).apply();
    }

    public void set(String s, Set set1)
    {
        _sharedPreferences.edit().putStringSet(s, set1).apply();
    }

    public void set(String s, boolean flag)
    {
        _sharedPreferences.edit().putBoolean(s, flag).apply();
    }
}
