// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jni.manager;


// Referenced classes of package jni.manager:
//            GnsdkErrorInfo, GnsdkInt, GnsdkHandle

public class GnsdkManager
{

    public static final byte a[] = null;

    public static native int gnsdk_manager_error_info(GnsdkErrorInfo gnsdkerrorinfo);

    public static native int gnsdk_manager_gdo_addref(byte abyte0[]);

    public static native int gnsdk_manager_gdo_child_count(byte abyte0[], String s, GnsdkInt gnsdkint);

    public static native int gnsdk_manager_gdo_child_get(byte abyte0[], String s, int i, GnsdkHandle gnsdkhandle);

    public static native int gnsdk_manager_gdo_get_type(byte abyte0[], String as[]);

    public static native int gnsdk_manager_gdo_release(byte abyte0[]);

    public static native int gnsdk_manager_gdo_value_get(byte abyte0[], String s, int i, String as[]);

    public static native String gnsdk_manager_get_product_version();

    public static native int gnsdk_manager_initialize(GnsdkHandle gnsdkhandle, String s, long l);

    public static native int gnsdk_manager_locale_unset_group_default(String s);

    public static native int gnsdk_manager_release_callback();

    public static native int gnsdk_manager_shutdown();

    public static native int gnsdk_manager_user_create(String s, String s1, GnsdkHandle gnsdkhandle);

    public static native int gnsdk_manager_user_option_set(byte abyte0[], String s, String s1);

    public static native int gnsdk_manager_user_register(String s, String s1, String s2, String s3, String as[]);

    public static native int gnsdk_manager_user_release(byte abyte0[]);

}
