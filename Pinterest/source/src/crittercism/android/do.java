// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


public final class do extends Enum
{

    public static final do a;
    public static final do b;
    public static final do c;
    public static final do d;
    public static final do e;
    public static final do f;
    private static final do g[];

    private do(String s, int i)
    {
        super(s, i);
    }

    public static do valueOf(String s)
    {
        return (do)Enum.valueOf(crittercism/android/do, s);
    }

    public static do[] values()
    {
        return (do[])g.clone();
    }

    static 
    {
        a = new do("GENERIC_HANDLER_DO_OPEN_CONNECTION_FAULT", 0);
        b = new do("STREAM_HANDLER_FACTORY_ANNUL_REFLECTION_FAULT", 1);
        c = new do("STREAM_HANDLER_FACTORY_CLEAR_STREAM_HANDLERS_FAULT", 2);
        d = new do("HASHED_DEVICE_ID_GENERATE_FROM_DROID_ID_FAULT", 3);
        e = new do("HASHED_DEVICE_ID_GENERATE_FROM_TELCO_ID_FAULT", 4);
        f = new do("HASHED_DEVICE_ID_GENERATE_RANDOM_ID_FAULT", 5);
        g = (new do[] {
            a, b, c, d, e, f
        });
    }
}
