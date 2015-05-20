// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.URLUtil;
import android.widget.EditText;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.create.dialog.CreateFromWebDialog;
import com.pinterest.activity.pin.adapter.CreateBoardPinAdapter;
import com.pinterest.activity.pin.adapter.IconTextListAdapter;
import com.pinterest.activity.pin.adapter.SimpleTextListAdapter;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.base.Application;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.DrawableUtils;
import com.pinterest.kit.utils.ImageUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateImageHelper
{

    public static final int IMAGE_CAPTURE = 800;
    public static final int IMAGE_CROP = 802;
    public static final int IMAGE_SELECT = 801;
    public static File cameraFile;

    public CreateImageHelper()
    {
    }

    private static com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem addItemsToList(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(null, Resources.string(0x7f0e0065));

        case 1: // '\001'
            return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(DrawableUtils.tintIcon(0x7f0200e3), Resources.string(0x7f0e0142));

        case 2: // '\002'
            return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(null, Resources.string(0x7f0e036a));

        case 3: // '\003'
            if (Device.hasCamera())
            {
                return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(DrawableUtils.tintIcon(0x7f0200e5), Resources.string(0x7f0e04a1));
            } else
            {
                return null;
            }

        case 4: // '\004'
            return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(DrawableUtils.tintIcon(0x7f0200e6), Resources.string(0x7f0e00be));

        case 5: // '\005'
            return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(DrawableUtils.tintIcon(0x7f0200e8), Resources.string(0x7f0e0373));

        case 6: // '\006'
            return new com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem(DrawableUtils.tintIcon(0x7f0200e7), Resources.string(0x7f0e0248));
        }
    }

    private static File getCameraDir()
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), String.format("100PINT/%s", new Object[] {
                Application.context().getResources().getString(0x7f0e037f)
            }));
            if (!file.exists())
            {
                file.mkdirs();
            }
            return file;
        } else
        {
            return null;
        }
    }

    public static String getValidWebUrl(EditText edittext)
    {
        edittext = URLUtil.guessUrl(edittext.getText().toString().trim());
        if (URLUtil.isValidUrl(edittext))
        {
            return edittext;
        } else
        {
            return null;
        }
    }

    public static void handleCancel(int i)
    {
    }

    public static Uri handleResult(Activity activity, int i, int j, Intent intent)
    {
        if (i != 802) goto _L2; else goto _L1
_L1:
        Object obj = intent.getData();
        if (obj == null) goto _L4; else goto _L3
_L3:
        intent = ImageUtils.getMediaPath(activity, ((Uri) (obj)));
        if (intent == null) goto _L6; else goto _L5
_L5:
        intent = Uri.parse((new StringBuilder("file://")).append(intent).toString());
        obj = ImageUtils.imageFromUri(activity, intent, 0, 0, 612, 612, false, null);
_L10:
        ImageUtils.storeScratchImage(activity, ((Bitmap) (obj)), "pin", true);
        return intent;
_L6:
        Bitmap bitmap;
        try
        {
            intent = ((Uri) (obj)).getPath();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity) { }
          goto _L7
_L4:
        intent = intent.getExtras();
        if (intent == null) goto _L9; else goto _L8
_L8:
        bitmap = (Bitmap)intent.getParcelable("data");
        intent = ((Intent) (obj));
        obj = bitmap;
          goto _L10
_L2:
        if (j != -1) goto _L7; else goto _L11
_L7:
        return null;
_L9:
        intent = ((Intent) (obj));
        obj = null;
          goto _L10
_L11:
        if (i == 801)
        {
            obj = intent.getData();
            intent = ((Intent) (obj));
            if (obj == null)
            {
                intent = ((Intent) (obj));
                if (cameraFile != null)
                {
                    intent = Uri.fromFile(cameraFile);
                }
            }
            if (intent == null)
            {
                return null;
            }
            obj = intent;
            if (ImageUtils.getMediaPath(activity, intent) == null)
            {
                intent.getPath();
                obj = intent;
            }
        } else
        if (i == 800)
        {
            if (cameraFile == null)
            {
                return null;
            }
            obj = Uri.fromFile(cameraFile);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            MediaScannerConnection.scanFile(Application.context(), new String[] {
                ((Uri) (obj)).getPath()
            }, null, null);
            return ((Uri) (obj));
        }
        return ((Uri) (obj));
        if (true) goto _L5; else goto _L12
_L12:
    }

    public static void showAppListDialog(Context context, final PackageManager pm, List list, final com.pinterest.activity.task.dialog.BaseDialog.OnDialogClickListener dialogClick)
    {
        Collections.sort(list, new _cls5());
        ArrayList arraylist = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++)
        {
            arraylist.add(new com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText(pm.getApplicationIcon(((ResolveInfo)list.get(i)).activityInfo.applicationInfo), (String)pm.getApplicationLabel(((ResolveInfo)list.get(i)).activityInfo.applicationInfo), null));
        }

        pm = new BaseDialog();
        list = new IconTextListAdapter();
        list.setDataSource(arraylist);
        pm.setTitle(context.getString(0x7f0e0041));
        pm.setListViewOptions(list, new _cls6());
        Events.post(new DialogEvent(pm));
    }

    public static void showBoardPinSourceDialog(Context context)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i <= 6; i++)
        {
            com.pinterest.activity.pin.adapter.CreateBoardPinAdapter.BoardPinItem boardpinitem = addItemsToList(i);
            if (boardpinitem != null)
            {
                arraylist.add(boardpinitem);
            }
        }

        BaseDialog basedialog = new BaseDialog();
        basedialog.setListViewOptions(new CreateBoardPinAdapter(arraylist), new _cls1());
        Events.post(new DialogEvent(basedialog));
    }

    public static void showCamera(Activity activity, String s)
    {
        Object obj = new File(getCameraDir(), String.format("IMG-%d.jpg", new Object[] {
            Long.valueOf(System.currentTimeMillis())
        }));
        cameraFile = ((File) (obj));
        obj = Uri.fromFile(((File) (obj)));
        if (s == null || s.length() == 0)
        {
            s = new Intent("android.media.action.IMAGE_CAPTURE");
            s.putExtra("output", ((android.os.Parcelable) (obj)));
            activity.startActivityForResult(s, 800);
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setPackage(s);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", ((android.os.Parcelable) (obj)));
            activity.startActivityForResult(intent, 800);
            return;
        }
    }

    public static void showCameraDialog(Context context)
    {
        Intent intent = ActivityHelper.getCreatePinIntent(context);
        intent.putExtra("com.pinterest.EXTRA_SOURCE", "com.pinterest.EXTRA_SOURCE_CAMERA");
        intent.putExtra("com.pinterest.EXTRA_SOURCE_PACKAGE", "");
        context.startActivity(intent);
    }

    public static void showCustomCameraDialog(final Context context, final Intent intent)
    {
        final List apps = new File(getCameraDir(), String.format("IMG-%d.jpg", new Object[] {
            Long.valueOf(System.currentTimeMillis())
        }));
        cameraFile = apps;
        Object obj = Uri.fromFile(apps);
        apps = new Intent("android.media.action.IMAGE_CAPTURE");
        apps.setAction("android.media.action.IMAGE_CAPTURE");
        apps.putExtra("output", ((android.os.Parcelable) (obj)));
        obj = Application.context().getPackageManager();
        apps = ((PackageManager) (obj)).queryIntentActivities(apps, 0x10000);
        intent.putExtra("com.pinterest.EXTRA_SOURCE", "com.pinterest.EXTRA_SOURCE_CAMERA");
        if (apps.size() > 1)
        {
            showAppListDialog(context, ((PackageManager) (obj)), apps, new _cls3());
            return;
        }
        if (apps.size() == 0)
        {
            Application.showToast(0x7f0e030b);
            return;
        } else
        {
            intent.putExtra("com.pinterest.EXTRA_SOURCE_PACKAGE", ((ResolveInfo)apps.get(0)).activityInfo.packageName);
            context.startActivity(intent);
            return;
        }
    }

    public static void showCustomGalleryDialog(final Context context, final Intent intent)
    {
        final List apps = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        PackageManager packagemanager = Application.context().getPackageManager();
        apps = packagemanager.queryIntentActivities(apps, 0x10000);
        intent.putExtra("com.pinterest.EXTRA_SOURCE", "com.pinterest.EXTRA_SOURCE_GALLERY");
        if (apps.size() > 1)
        {
            showAppListDialog(context, packagemanager, apps, new _cls4());
            return;
        }
        if (apps.size() == 0)
        {
            Application.showToast(0x7f0e030c);
            return;
        } else
        {
            intent.putExtra("com.pinterest.EXTRA_SOURCE_PACKAGE", ((ResolveInfo)apps.get(0)).activityInfo.packageName);
            context.startActivity(intent);
            return;
        }
    }

    public static void showGallery(Activity activity, String s)
    {
        if (s == null || s.length() == 0)
        {
            activity.startActivityForResult(new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 801);
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setPackage(s);
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            activity.startActivityForResult(intent, 801);
            return;
        }
    }

    public static void showGalleryDialog(Context context)
    {
        Intent intent = ActivityHelper.getCreatePinIntent(context);
        intent.putExtra("com.pinterest.EXTRA_SOURCE", "com.pinterest.EXTRA_SOURCE_GALLERY");
        intent.putExtra("com.pinterest.EXTRA_SOURCE_PACKAGE", "");
        context.startActivity(intent);
    }

    public static void showImageSourceDialog(Context context)
    {
        if (Experiments.m())
        {
            showBoardPinSourceDialog(context);
            return;
        } else
        {
            showImageSourceDialog(context, null, false);
            return;
        }
    }

    public static void showImageSourceDialog(final Context intent, Bundle bundle, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (Device.hasCamera())
        {
            arraylist.add(intent.getString(0x7f0e04a1));
        }
        arraylist.add(intent.getString(0x7f0e00be));
        if (!flag)
        {
            arraylist.add(intent.getString(0x7f0e0373));
            arraylist.add(intent.getString(0x7f0e0248));
        }
        arraylist.toArray(new String[arraylist.size()]);
        final BaseDialog dialog = new BaseDialog();
        SimpleTextListAdapter simpletextlistadapter = new SimpleTextListAdapter(false);
        simpletextlistadapter.setDataSource(arraylist);
        dialog.setTitle(intent.getString(0x7f0e036c));
        dialog.setSubTitle(intent.getString(0x7f0e036b));
        intent = ActivityHelper.getCreatePinIntent(intent);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        dialog.setListViewOptions(simpletextlistadapter, new _cls2());
        Events.post(new DialogEvent(dialog));
    }

    private static void showPinFromWebDialog(Context context)
    {
        Events.post(new DialogEvent(new CreateFromWebDialog()));
    }


    private class _cls5
        implements Comparator
    {

        final PackageManager val$pm;

        public final int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
        {
            return ((String)pm.getApplicationLabel(resolveinfo.activityInfo.applicationInfo)).compareTo((String)pm.getApplicationLabel(resolveinfo1.activityInfo.applicationInfo));
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((ResolveInfo)obj, (ResolveInfo)obj1);
        }

        _cls5()
        {
            pm = packagemanager;
            super();
        }
    }


    private class _cls6
        implements android.widget.AdapterView.OnItemClickListener
    {

        final BaseDialog val$dialog;
        final com.pinterest.activity.task.dialog.BaseDialog.OnDialogClickListener val$dialogClick;

        public final void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            dialogClick.onClick(dialog, i);
        }

        _cls6()
        {
            dialogClick = ondialogclicklistener;
            dialog = basedialog;
            super();
        }
    }


    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final BaseDialog val$dialog;
        final Intent val$intent;

        public final void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            int j;
            j = i;
            if (!Device.hasCamera())
            {
                j = i + 1;
            }
            j;
            JVM INSTR tableswitch 0 6: default 60
        //                       0 60
        //                       1 68
        //                       2 60
        //                       3 86
        //                       4 109
        //                       5 132
        //                       6 151;
               goto _L1 _L1 _L2 _L1 _L3 _L4 _L5 _L6
_L1:
            dialog.dismiss();
            return;
_L2:
            Events.post(new DialogEvent(new CreateBoardDialog()));
            return;
_L3:
            Pinalytics.a(ElementType.CAMERA_BUTTON, ComponentType.MODAL_DIALOG);
            CreateImageHelper.showCustomCameraDialog(view.getContext(), intent);
            continue; /* Loop/switch isn't completed */
_L4:
            Pinalytics.a(ElementType.GALLERY_BUTTON, ComponentType.MODAL_DIALOG);
            CreateImageHelper.showCustomGalleryDialog(view.getContext(), intent);
            continue; /* Loop/switch isn't completed */
_L5:
            Pinalytics.a(ElementType.FIND_IMAGES_BUTTON, ComponentType.MODAL_DIALOG);
            CreateImageHelper.showPinFromWebDialog(view.getContext());
            continue; /* Loop/switch isn't completed */
_L6:
            Pinalytics.a(ElementType.ADD_PLACE_BUTTON, ComponentType.MODAL_DIALOG);
            adapterview = new Navigation(Location.PLACE_PICKER);
            adapterview.putExtra("com.pinterest.EXTRA_MODE", com.pinterest.activity.place.fragment.PlacePickerFragment.Mode.CREATE);
            Events.post(adapterview);
            if (true) goto _L1; else goto _L7
_L7:
        }

        _cls1()
        {
            intent = intent1;
            dialog = basedialog;
            super();
        }
    }


    private class _cls3
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDialogClickListener
    {

        final List val$apps;
        final Context val$context;
        final Intent val$intent;

        public final void onClick(BaseDialog basedialog, int i)
        {
            intent.putExtra("com.pinterest.EXTRA_SOURCE_PACKAGE", ((ResolveInfo)apps.get(i)).activityInfo.packageName);
            context.startActivity(intent);
            basedialog.dismiss();
        }

        _cls3()
        {
            intent = intent1;
            apps = list;
            context = context1;
            super();
        }
    }


    private class _cls4
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDialogClickListener
    {

        final List val$apps;
        final Context val$context;
        final Intent val$intent;

        public final void onClick(BaseDialog basedialog, int i)
        {
            intent.putExtra("com.pinterest.EXTRA_SOURCE_PACKAGE", ((ResolveInfo)apps.get(i)).activityInfo.packageName);
            context.startActivity(intent);
            basedialog.dismiss();
        }

        _cls4()
        {
            intent = intent1;
            apps = list;
            context = context1;
            super();
        }
    }


    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final BaseDialog val$dialog;
        final Intent val$intent;

        public final void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            int j;
            j = i;
            if (!Device.hasCamera())
            {
                j = i + 1;
            }
            j;
            JVM INSTR tableswitch 0 3: default 48
        //                       0 56
        //                       1 79
        //                       2 102
        //                       3 121;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            dialog.dismiss();
            return;
_L2:
            Pinalytics.a(ElementType.CAMERA_BUTTON, ComponentType.MODAL_DIALOG);
            CreateImageHelper.showCustomCameraDialog(view.getContext(), intent);
            continue; /* Loop/switch isn't completed */
_L3:
            Pinalytics.a(ElementType.GALLERY_BUTTON, ComponentType.MODAL_DIALOG);
            CreateImageHelper.showCustomGalleryDialog(view.getContext(), intent);
            continue; /* Loop/switch isn't completed */
_L4:
            Pinalytics.a(ElementType.FIND_IMAGES_BUTTON, ComponentType.MODAL_DIALOG);
            CreateImageHelper.showPinFromWebDialog(view.getContext());
            continue; /* Loop/switch isn't completed */
_L5:
            Pinalytics.a(ElementType.ADD_PLACE_BUTTON, ComponentType.MODAL_DIALOG);
            adapterview = new Navigation(Location.PLACE_PICKER);
            adapterview.putExtra("com.pinterest.EXTRA_MODE", com.pinterest.activity.place.fragment.PlacePickerFragment.Mode.CREATE);
            Events.post(adapterview);
            if (true) goto _L1; else goto _L6
_L6:
        }

        _cls2()
        {
            intent = intent1;
            dialog = basedialog;
            super();
        }
    }

}
