// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.rwd;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Environment;
import com.gracenote.gnsdk.Acr.GnAcr;
import com.gracenote.gnsdk.Acr.GnAcrAudioConfig;
import com.gracenote.gnsdk.Acr.GnAcrStatus;
import com.gracenote.gnsdk.Acr.IGnAcrDelegate;
import com.gracenote.gnsdk.Android.GnAudioSourceMic;
import com.gracenote.gnsdk.Android.IGnAudioSourceDelegate;
import com.gracenote.gnsdk.FpCache.GnFpCache;
import com.gracenote.gnsdk.Manager.Android.GnApplicationContext;
import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.GnUser;
import com.gracenote.gnsdk.Metadata.GnIterator;
import com.gracenote.gnsdk.Metadata.GnResult;
import com.gracenote.gnsdk.Metadata.IGnExternalID;
import com.gracenote.gnsdk.MetadataACR.IGnAcrMatch;
import com.gracenote.gnsdk.MetadataACR.IGnCustomData;
import com.gracenote.gnsdk.MetadataACR.IGnVideoAdvert;
import com.gracenote.gnsdk.MetadataEPG.IGnTvAiring;
import com.gracenote.gnsdk.MetadataEPG.IGnTvChannel;
import com.gracenote.gnsdk.MetadataVideo.GnVideoName;
import com.gracenote.gnsdk.MetadataVideo.GnVideoTitle;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoTitle;
import com.gracenote.gnsdk.MetadataVideo.IGnVideoWork;
import com.gracenote.gnsdk.StorageSqlite.GnStorageSqlite;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import java.io.File;
import java.io.InvalidObjectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package com.pinterest.rwd:
//            Titles, GnCircularBuffer

public class RwdManager
    implements IGnAcrDelegate, IGnAudioSourceDelegate
{

    private static RwdManager b;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private boolean a;
    private Context c;
    private GnUser g;
    private GnAcrAudioConfig h;
    private GnAcr i;
    private GnAudioSourceMic j;
    private GnCircularBuffer k;
    private IGnAcrMatch l;

    protected RwdManager()
    {
        a = false;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        c = Application.context();
    }

    public static RwdManager a()
    {
        if (b == null)
        {
            RwdManager rwdmanager = new RwdManager();
            b = rwdmanager;
            rwdmanager.g();
        }
        return b;
    }

    private static void a(ArrayList arraylist)
    {
        if (arraylist.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1 = 0;
_L4:
        if (i1 >= arraylist.size()) goto _L1; else goto _L3
_L3:
        Object obj = (IGnAcrMatch)arraylist.get(i1);
        obj = ((IGnAcrMatch) (obj)).getTitle().getDisplay();
        String s = Titles.a(((String) (obj)));
        if (s != null)
        {
            Events.post(new Navigation(Location.BRAND_PINS, s));
        } else
        if (i1 == arraylist.size())
        {
            Events.post(new Navigation(Location.RWD_PINS, ((String) (obj))));
        }
_L5:
        i1++;
          goto _L4
          goto _L1
        Exception exception;
        exception;
          goto _L5
    }

    public static boolean b()
    {
        return b != null;
    }

    private boolean e()
    {
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            Application.showToast("Unable to start ACR. The external storage is not available.");
            return false;
        }
        int i1;
        try
        {
            (new StringBuilder("ACR Version: ")).append(GnSdk.e());
            i = new GnAcr(g, this);
            new GnStorageSqlite();
            String s = c.getExternalFilesDir(null).getAbsolutePath();
            GnStorageSqlite.a(s);
            GnStorageSqlite.b(s);
            new GnFpCache();
            GnFpCache.a("gnsdk_lookup_fpcache_stgmdata", s);
            if (h != null)
            {
                break MISSING_BLOCK_LABEL_124;
            }
        }
        catch (GnException gnexception)
        {
            String.format("Error: %s", new Object[] {
                gnexception.getLocalizedMessage()
            });
            gnexception.printStackTrace();
            return false;
        }
        catch (Exception exception)
        {
            String.format("Error: %s", new Object[] {
                exception.getLocalizedMessage()
            });
            exception.printStackTrace();
            return false;
        }
        i1 = 44100;
        if (!f())
        {
            i1 = 8000;
        }
        h = new GnAcrAudioConfig(i1);
        k = new GnCircularBuffer(h.c() * h.b() * h.d() * 10);
        i.a(h);
        i.a("default");
        String.format("Optimization Mode: %s", new Object[] {
            i.b()
        });
        i.c();
        j = new GnAudioSourceMic();
        j.a(h, this);
        j.a();
        a = true;
        return true;
    }

    private static boolean f()
    {
        try
        {
            (new AudioRecord(1, 44100, 2, 2, AudioRecord.getMinBufferSize(44100, 2, 2) * 5)).release();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean g()
    {
        Object obj;
        String s;
        d = Resources.string(0x7f0e00c3);
        e = Resources.string(0x7f0e00c5);
        f = Resources.string(0x7f0e02bb);
        try
        {
            GnSdk.a(new GnApplicationContext(Application.context()), f, f.length());
            s = d;
            obj = e;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            (new StringBuilder("GNSDK initialize failed with an error: ")).append(((GnException) (obj)).getLocalizedMessage());
            return false;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (s.isEmpty() || obj == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (!((String) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_110;
        }
        throw new GnException("No client ID or tag provided.");
        String s1 = Preferences.persisted().getString(s, null);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        obj = new GnUser(com.gracenote.gnsdk.Metadata.GnTypes.GnUserRegisterMode.a, s, ((String) (obj)), "1.0");
        s1 = ((GnUser) (obj)).a();
        Preferences.persisted().set(s, s1);
_L1:
        g = ((GnUser) (obj));
        GnSdk.a(g);
        return true;
        obj = new GnUser(s1);
          goto _L1
    }

    public void acrResultReady(GnResult gnresult)
    {
        ArrayList arraylist = new ArrayList();
        GnIterator gniterator = new GnIterator(gnresult, "com.gracenote.gnsdk.MetadataACR.GnAcrMatch", "ctx_match_acr!");
        int i1 = 0;
_L15:
        if (!gniterator.hasNext()) goto _L2; else goto _L1
_L1:
        IGnAcrMatch ignacrmatch = (IGnAcrMatch)gniterator.next();
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        l = ignacrmatch;
        String s;
        int j1 = Integer.parseInt(ignacrmatch.getAdjustedPosition()) / 1000;
        s = String.format("%02d:%02d:%02d", new Object[] {
            Integer.valueOf(j1 / 3600), Integer.valueOf((j1 / 60) % 60), Integer.valueOf(j1 % 60)
        });
        gnresult = ignacrmatch.getTvAiring();
        int k1 = i1;
        if (gnresult == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        obj1 = gnresult.getChannel();
        gnresult = ignacrmatch.getTitle();
        obj = ignacrmatch.getSubTitle();
        if (gnresult == null) goto _L6; else goto _L5
_L5:
        gnresult = gnresult.getDisplay();
_L14:
        if (obj == null) goto _L8; else goto _L7
_L7:
        obj = ((IGnVideoTitle) (obj)).getDisplay();
_L16:
        obj1 = ((IGnTvChannel) (obj1)).getCallsign();
        k1 = i1 + 1;
        String.format("[TV] ACR: %s(%s) %s %s (Match #%d)", new Object[] {
            gnresult, obj, obj1, s, Integer.valueOf(k1)
        });
        arraylist.add(ignacrmatch);
_L4:
        obj = ignacrmatch.getAvWork();
        i1 = k1;
        if (obj == null) goto _L10; else goto _L9
_L9:
        String s1;
        gnresult = ((IGnVideoWork) (obj)).getTitle();
        obj1 = ((IGnVideoWork) (obj)).getTUI();
        s1 = ((IGnVideoWork) (obj)).getTUITag();
        if (gnresult == null)
        {
            break MISSING_BLOCK_LABEL_777;
        }
        gnresult = gnresult.getDisplay();
_L17:
        if (((IGnVideoWork) (obj)).isPartial().booleanValue())
        {
            obj = "YES";
        } else
        {
            obj = "NO";
        }
        String.format("[Video work] TUI: %s\n Work Tag: %s\n Work Title: %s\n Is Partial? %s\n", new Object[] {
            obj1, s1, gnresult, obj
        });
        i1 = k1 + 1;
_L10:
        gnresult = ignacrmatch.getCustomData();
        k1 = i1;
        if (gnresult == null)
        {
            break MISSING_BLOCK_LABEL_400;
        }
        gnresult = gnresult.getDataID();
        k1 = i1 + 1;
        String.format("[Custom Data]: %s %s (Match #%d)", new Object[] {
            gnresult, s, Integer.valueOf(k1)
        });
        gnresult = ignacrmatch.getAvAdvert();
        if (gnresult == null) goto _L12; else goto _L11
_L11:
        String.format("Ad is partial: %b", new Object[] {
            Boolean.valueOf(gnresult.isPartial())
        });
        String.format("Ad brand name: %s", new Object[] {
            gnresult.getBrand().getDisplay()
        });
        String.format("Ad GNUID: %s", new Object[] {
            gnresult.getGNUID()
        });
        String.format("Ad tui/tui-tag: %s-%s", new Object[] {
            gnresult.getTui(), gnresult.getTuiTag()
        });
        IGnExternalID ignexternalid;
        for (obj = gnresult.getExternalIDs(); ((GnIterator) (obj)).hasNext(); String.format("Ad XID value: %s", new Object[] {
    ignexternalid.getValue()
}))
        {
            ignexternalid = (IGnExternalID)((GnIterator) (obj)).next();
            String.format("Ad XID source: %s", new Object[] {
                ignexternalid.getSource()
            });
            String.format("Ad XID type: %s", new Object[] {
                ignexternalid.getIDType()
            });
        }

          goto _L13
_L2:
        if (i1 == 0)
        {
            try
            {
                String.format("ACR: No match (%s)", new Object[] {
                    (new SimpleDateFormat("HH:mm:ss")).format(Calendar.getInstance().getTime())
                });
            }
            // Misplaced declaration of an exception variable
            catch (GnResult gnresult)
            {
                String.format("Error: %s", new Object[] {
                    gnresult.getLocalizedMessage()
                });
                gnresult.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (GnResult gnresult)
            {
                String.format("Error: %s", new Object[] {
                    gnresult.getLocalizedMessage()
                });
                gnresult.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (GnResult gnresult)
            {
                String.format("Error: %s", new Object[] {
                    gnresult.getLocalizedMessage()
                });
                gnresult.printStackTrace();
            }
        }
        a(arraylist);
        return;
_L6:
        gnresult = "N/A";
          goto _L14
_L13:
        gnresult = gnresult.getTitle().getDisplay();
        i1 = k1 + 1;
        String.format("[Ad] title: %s (Match #%d)", new Object[] {
            gnresult, Integer.valueOf(i1)
        });
          goto _L15
_L12:
        i1 = k1;
          goto _L15
_L8:
        obj = "N/A";
          goto _L16
        gnresult = "N/A";
          goto _L17
    }

    public void acrStatusReady(GnAcrStatus gnacrstatus)
    {
        String s = "";
        gnacrstatus.a();
        JVM INSTR lookupswitch 11: default 108
    //                   10: 171
    //                   70: 116
    //                   80: 140
    //                   81: 192
    //                   82: 185
    //                   83: 199
    //                   110: 178
    //                   200: 206
    //                   210: 213
    //                   600: 220
    //                   700: 164;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        gnacrstatus = s;
_L14:
        gnacrstatus.length();
        return;
_L3:
        gnacrstatus = String.format("Silence %.2f", new Object[] {
            Float.valueOf(gnacrstatus.b())
        });
        continue; /* Loop/switch isn't completed */
_L4:
        gnacrstatus = String.format("Silence ratio %.2f", new Object[] {
            Float.valueOf(gnacrstatus.b())
        });
        continue; /* Loop/switch isn't completed */
_L12:
        gnacrstatus = "Transition detected...";
        continue; /* Loop/switch isn't completed */
_L2:
        gnacrstatus = "Query begin...";
        continue; /* Loop/switch isn't completed */
_L8:
        gnacrstatus = "Online lookup complete...";
        continue; /* Loop/switch isn't completed */
_L6:
        gnacrstatus = "Music...";
        continue; /* Loop/switch isn't completed */
_L5:
        gnacrstatus = "Noise...";
        continue; /* Loop/switch isn't completed */
_L7:
        gnacrstatus = "Speech...";
        continue; /* Loop/switch isn't completed */
_L9:
        gnacrstatus = "Normal match mode...";
        continue; /* Loop/switch isn't completed */
_L10:
        gnacrstatus = "No match mode...";
        continue; /* Loop/switch isn't completed */
_L11:
        gnacrstatus = String.format("Error %s(0x%x)", new Object[] {
            gnacrstatus.d(), Integer.valueOf(gnacrstatus.c())
        });
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void audioBytesReady(byte abyte0[], int i1)
    {
        try
        {
            if (i != null)
            {
                i.a(abyte0, i1);
            }
            if (k != null)
            {
                k.a(abyte0, i1);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.getLocalizedMessage();
        }
    }

    public final void c()
    {
        Object obj;
        if (a)
        {
            j.b();
            try
            {
                i.a();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((GnException) (obj)).printStackTrace();
            }
            j = null;
            i = null;
            a = false;
        } else
        {
            e();
        }
        if (a)
        {
            obj = "Start lisening ";
        } else
        {
            obj = "Stop listening";
        }
        Application.showToast(((String) (obj)));
    }

    public final void d()
    {
        if (a)
        {
            j.b();
            try
            {
                i.a();
            }
            catch (GnException gnexception)
            {
                gnexception.printStackTrace();
            }
            a = false;
        }
        h = null;
        j = null;
        i = null;
        g = null;
        k = null;
        try
        {
            GnSdk.c();
            return;
        }
        catch (GnException gnexception1)
        {
            gnexception1.printStackTrace();
        }
    }

}
