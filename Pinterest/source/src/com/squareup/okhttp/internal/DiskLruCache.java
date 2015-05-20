// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

// Referenced classes of package com.squareup.okhttp.internal:
//            Util, Platform

public final class DiskLruCache
    implements Closeable
{

    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream p = new _cls2();
    final ThreadPoolExecutor b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g = 0x31191;
    private long h;
    private final int i = 2;
    private long j;
    private BufferedSink k;
    private final LinkedHashMap l = new LinkedHashMap(0, 0.75F, true);
    private int m;
    private long n;
    private final Runnable o = new _cls1();

    private DiskLruCache(File file, long l1)
    {
        j = 0L;
        n = 0L;
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.c("OkHttp DiskLruCache"));
        c = file;
        d = new File(file, "journal");
        e = new File(file, "journal.tmp");
        f = new File(file, "journal.bkp");
        h = l1;
    }

    static Editor a(DiskLruCache disklrucache, String s, long l1)
    {
        return disklrucache.a(s, l1);
    }

    private Editor a(String s, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        f();
        d(s);
        entry = (Entry)l.get(s);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (entry == null) goto _L4; else goto _L3
_L3:
        long l2 = Entry.f(entry);
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (entry != null) goto _L6; else goto _L5
_L5:
        entry = new Entry(s, (byte)0);
        l.put(s, entry);
_L8:
        Editor editor;
        editor = new Editor(entry, (byte)0);
        Entry.a(entry, editor);
        k.b("DIRTY").e(32).b(s).e(10);
        k.b();
        s = editor;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        editor = Entry.b(entry);
        if (editor == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static DiskLruCache a(File file, long l1)
    {
        Object obj;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        obj = new File(file, "journal.bkp");
        if (((File) (obj)).exists())
        {
            File file1 = new File(file, "journal");
            if (file1.exists())
            {
                ((File) (obj)).delete();
            } else
            {
                a(((File) (obj)), file1, false);
            }
        }
        obj = new DiskLruCache(file, l1);
        if (!((DiskLruCache) (obj)).d.exists())
        {
            break MISSING_BLOCK_LABEL_175;
        }
        ((DiskLruCache) (obj)).b();
        ((DiskLruCache) (obj)).c();
        obj.k = Okio.a(Okio.a(new FileOutputStream(((DiskLruCache) (obj)).d, true)));
        return ((DiskLruCache) (obj));
        IOException ioexception;
        ioexception;
        Platform.a();
        Platform.a((new StringBuilder("DiskLruCache ")).append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((DiskLruCache) (obj)).close();
        Util.a(((DiskLruCache) (obj)).c);
        file.mkdirs();
        file = new DiskLruCache(file, l1);
        file.d();
        return file;
    }

    static OutputStream a()
    {
        return p;
    }

    static BufferedSink a(DiskLruCache disklrucache)
    {
        return disklrucache.k;
    }

    private void a(Editor editor, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        entry = Editor.a(editor);
        if (Entry.b(entry) != editor)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        editor;
        this;
        JVM INSTR monitorexit ;
        throw editor;
        int j1 = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j1 = ((flag1) ? 1 : 0);
        if (Entry.e(entry)) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L7:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= i) goto _L2; else goto _L4
_L4:
        if (!Editor.b(editor)[i1])
        {
            editor.b();
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i1).toString());
        }
        if (entry.b(i1).exists()) goto _L6; else goto _L5
_L5:
        editor.b();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        i1++;
          goto _L7
_L2:
        File file;
        long l1;
        long l2;
        for (; j1 >= i; j1++)
        {
            break MISSING_BLOCK_LABEL_225;
        }

        editor = entry.b(j1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        if (editor.exists())
        {
            file = entry.a(j1);
            editor.renameTo(file);
            l1 = Entry.c(entry)[j1];
            l2 = file.length();
            Entry.c(entry)[j1] = l2;
            j = (j - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_443;
        a(((File) (editor)));
        break MISSING_BLOCK_LABEL_443;
        m = m + 1;
        Entry.a(entry, null);
        if (!(Entry.e(entry) | flag))
        {
            break MISSING_BLOCK_LABEL_382;
        }
        Entry.a(entry);
        k.b("CLEAN").e(32);
        k.b(Entry.d(entry));
        k.b(entry.a());
        k.e(10);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        l1 = n;
        n = 1L + l1;
        Entry.a(entry, l1);
_L9:
        k.b();
        if (j > h || e())
        {
            b.execute(o);
        }
          goto _L8
        l.remove(Entry.d(entry));
        k.b("REMOVE").e(32);
        k.b(Entry.d(entry));
        k.e(10);
          goto _L9
    }

    static void a(DiskLruCache disklrucache, Editor editor, boolean flag)
    {
        disklrucache.a(editor, flag);
    }

    private static void a(File file)
    {
        if (!file.delete() && file.exists())
        {
            throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
        } else
        {
            return;
        }
    }

    private static void a(File file, File file1, boolean flag)
    {
        if (flag)
        {
            a(file1);
        }
        if (!file.renameTo(file1))
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private void b()
    {
        BufferedSource bufferedsource = Okio.a(Okio.a(d));
        Exception exception;
        String s = bufferedsource.m();
        String s2 = bufferedsource.m();
        String s3 = bufferedsource.m();
        String s4 = bufferedsource.m();
        String s6 = bufferedsource.m();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s2) || !Integer.toString(g).equals(s3) || !Integer.toString(i).equals(s4) || !"".equals(s6))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s).append(", ").append(s2).append(", ").append(s4).append(", ").append(s6).append("]").toString());
        }
        int i1 = 0;
_L2:
        String s5;
        int j1;
        s5 = bufferedsource.m();
        j1 = s5.indexOf(' ');
        if (j1 != -1)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        try
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s5).toString());
        }
        catch (EOFException eofexception) { }
        finally
        {
            Util.a(bufferedsource);
            throw exception;
        }
        m = i1 - l.size();
        Util.a(bufferedsource);
        return;
        int k1 = j1 + 1;
        int l1 = s5.indexOf(' ', k1);
        if (l1 != -1)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        String s1 = s5.substring(k1);
        if (j1 != 6)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        if (s5.startsWith("REMOVE"))
        {
            l.remove(s1);
            break MISSING_BLOCK_LABEL_519;
        }
        break MISSING_BLOCK_LABEL_330;
        s1 = s5.substring(k1, l1);
        Entry entry1 = (Entry)l.get(s1);
        Entry entry;
        entry = entry1;
        if (entry1 != null)
        {
            break MISSING_BLOCK_LABEL_369;
        }
        entry = new Entry(s1, (byte)0);
        l.put(s1, entry);
        if (l1 == -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        if (s5.startsWith("CLEAN"))
        {
            String as[] = s5.substring(l1 + 1).split(" ");
            Entry.a(entry);
            Entry.a(entry, null);
            Entry.a(entry, as);
            break MISSING_BLOCK_LABEL_519;
        }
        if (l1 != -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_467;
        }
        if (s5.startsWith("DIRTY"))
        {
            Entry.a(entry, new Editor(entry, (byte)0));
            break MISSING_BLOCK_LABEL_519;
        }
        if (l1 != -1 || j1 != 4)
        {
            break MISSING_BLOCK_LABEL_490;
        }
        if (s5.startsWith("READ"))
        {
            break MISSING_BLOCK_LABEL_519;
        }
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(s5).toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void b(DiskLruCache disklrucache)
    {
        disklrucache.g();
    }

    private void c()
    {
        a(e);
        for (Iterator iterator = l.values().iterator(); iterator.hasNext();)
        {
            Entry entry = (Entry)iterator.next();
            if (Entry.b(entry) == null)
            {
                int i1 = 0;
                while (i1 < i) 
                {
                    j = j + Entry.c(entry)[i1];
                    i1++;
                }
            } else
            {
                Entry.a(entry, null);
                for (int j1 = 0; j1 < i; j1++)
                {
                    a(entry.a(j1));
                    a(entry.b(j1));
                }

                iterator.remove();
            }
        }

    }

    static boolean c(DiskLruCache disklrucache)
    {
        return disklrucache.e();
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (k != null)
        {
            k.close();
        }
        obj = Okio.a(Okio.a(new FileOutputStream(e)));
        Iterator iterator;
        ((BufferedSink) (obj)).b("libcore.io.DiskLruCache").e(10);
        ((BufferedSink) (obj)).b("1").e(10);
        ((BufferedSink) (obj)).b(Integer.toString(g)).e(10);
        ((BufferedSink) (obj)).b(Integer.toString(i)).e(10);
        ((BufferedSink) (obj)).e(10);
        iterator = l.values().iterator();
_L1:
        Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_264;
            }
            entry = (Entry)iterator.next();
            if (Entry.b(entry) == null)
            {
                break MISSING_BLOCK_LABEL_213;
            }
            ((BufferedSink) (obj)).b("DIRTY").e(32);
            ((BufferedSink) (obj)).b(Entry.d(entry));
            ((BufferedSink) (obj)).e(10);
        } while (true);
        Exception exception;
        exception;
        ((BufferedSink) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((BufferedSink) (obj)).b("CLEAN").e(32);
        ((BufferedSink) (obj)).b(Entry.d(entry));
        ((BufferedSink) (obj)).b(entry.a());
        ((BufferedSink) (obj)).e(10);
          goto _L1
        ((BufferedSink) (obj)).close();
        if (d.exists())
        {
            a(d, f, true);
        }
        a(e, d, false);
        f.delete();
        k = Okio.a(Okio.a(new FileOutputStream(d, true)));
        this;
        JVM INSTR monitorexit ;
    }

    static void d(DiskLruCache disklrucache)
    {
        disklrucache.d();
    }

    private static void d(String s)
    {
        if (!a.matcher(s).matches())
        {
            throw new IllegalArgumentException((new StringBuilder("keys must match regex [a-z0-9_-]{1,64}: \"")).append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    static int e(DiskLruCache disklrucache)
    {
        disklrucache.m = 0;
        return 0;
    }

    private boolean e()
    {
        return m >= 2000 && m >= l.size();
    }

    static int f(DiskLruCache disklrucache)
    {
        return disklrucache.i;
    }

    private void f()
    {
        if (k == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    static File g(DiskLruCache disklrucache)
    {
        return disklrucache.c;
    }

    private void g()
    {
        while (j > h) 
        {
            c((String)((java.util.Map.Entry)l.entrySet().iterator().next()).getKey());
        }
    }

    public final Snapshot a(String s)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        f();
        d(s);
        entry = (Entry)l.get(s);
        if (entry != null) goto _L2; else goto _L1
_L1:
        Snapshot snapshot = obj;
_L7:
        this;
        JVM INSTR monitorexit ;
        return snapshot;
_L2:
        snapshot = obj;
        InputStream ainputstream[];
        if (!Entry.e(entry))
        {
            continue; /* Loop/switch isn't completed */
        }
        ainputstream = new InputStream[i];
        int i1 = 0;
_L4:
        if (i1 >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        ainputstream[i1] = new FileInputStream(entry.a(i1));
        i1++;
        if (true) goto _L4; else goto _L3
        s;
        i1 = 0;
_L5:
        snapshot = obj;
        if (i1 >= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        snapshot = obj;
        if (ainputstream[i1] == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Util.a(ainputstream[i1]);
        i1++;
        if (true) goto _L5; else goto _L3
_L3:
        m = m + 1;
        k.b("READ").e(32).b(s).e(10);
        if (e())
        {
            b.execute(o);
        }
        snapshot = new Snapshot(s, Entry.f(entry), ainputstream, Entry.c(entry), (byte)0);
        if (true) goto _L7; else goto _L6
_L6:
        s;
        throw s;
    }

    public final Editor b(String s)
    {
        return a(s, -1L);
    }

    public final boolean c(String s)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        f();
        d(s);
        entry = (Entry)l.get(s);
        if (entry == null) goto _L2; else goto _L1
_L1:
        Editor editor = Entry.b(entry);
        if (editor == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        if (i1 >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        a(entry.a(i1));
        j = j - Entry.c(entry)[i1];
        Entry.c(entry)[i1] = 0L;
        i1++;
        if (true) goto _L3; else goto _L4
_L4:
        m = m + 1;
        k.b("REMOVE").e(32).b(s).e(10);
        l.remove(s);
        if (e())
        {
            b.execute(o);
        }
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        BufferedSink bufferedsink = k;
        if (bufferedsink != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object aobj[];
        int j1;
        aobj = l.values().toArray();
        j1 = aobj.length;
        Exception exception;
        Entry entry;
        for (int i1 = 0; i1 >= j1; i1++)
        {
            break MISSING_BLOCK_LABEL_63;
        }

        entry = (Entry)aobj[i1];
        if (Entry.b(entry) != null)
        {
            Entry.b(entry).b();
        }
        break MISSING_BLOCK_LABEL_89;
        g();
        k.close();
        k = null;
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        throw exception;
    }


    private class _cls1
        implements Runnable
    {

        final DiskLruCache a;

        public void run()
        {
label0:
            {
                synchronized (a)
                {
                    if (DiskLruCache.a(a) != null)
                    {
                        break label0;
                    }
                }
                return;
            }
            DiskLruCache.b(a);
            if (DiskLruCache.c(a))
            {
                DiskLruCache.d(a);
                DiskLruCache.e(a);
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
            IOException ioexception;
            ioexception;
            throw new RuntimeException(ioexception);
        }

        _cls1()
        {
            a = DiskLruCache.this;
            super();
        }
    }


    private class Entry
    {

        final DiskLruCache a;
        private final String b;
        private final long c[];
        private boolean d;
        private Editor e;
        private long f;

        static long a(Entry entry, long l1)
        {
            entry.f = l1;
            return l1;
        }

        static Editor a(Entry entry, Editor editor)
        {
            entry.e = editor;
            return editor;
        }

        private static IOException a(String as[])
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
        }

        static void a(Entry entry, String as[])
        {
            if (as.length != DiskLruCache.f(entry.a))
            {
                throw a(as);
            }
            int i1 = 0;
            do
            {
                try
                {
                    if (i1 >= as.length)
                    {
                        break;
                    }
                    entry.c[i1] = Long.parseLong(as[i1]);
                }
                // Misplaced declaration of an exception variable
                catch (Entry entry)
                {
                    throw a(as);
                }
                i1++;
            } while (true);
        }

        static boolean a(Entry entry)
        {
            entry.d = true;
            return true;
        }

        static Editor b(Entry entry)
        {
            return entry.e;
        }

        static long[] c(Entry entry)
        {
            return entry.c;
        }

        static String d(Entry entry)
        {
            return entry.b;
        }

        static boolean e(Entry entry)
        {
            return entry.d;
        }

        static long f(Entry entry)
        {
            return entry.f;
        }

        public final File a(int i1)
        {
            return new File(DiskLruCache.g(a), (new StringBuilder()).append(b).append(".").append(i1).toString());
        }

        public final String a()
        {
            StringBuilder stringbuilder = new StringBuilder();
            long al[] = c;
            int j1 = al.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                long l1 = al[i1];
                stringbuilder.append(' ').append(l1);
            }

            return stringbuilder.toString();
        }

        public final File b(int i1)
        {
            return new File(DiskLruCache.g(a), (new StringBuilder()).append(b).append(".").append(i1).append(".tmp").toString());
        }

        private Entry(String s)
        {
            a = DiskLruCache.this;
            super();
            b = s;
            c = new long[DiskLruCache.f(DiskLruCache.this)];
        }

        Entry(String s, byte byte0)
        {
            this(s);
        }
    }


    private class Editor
    {

        final DiskLruCache a;
        private final Entry b;
        private final boolean c[];
        private boolean d;
        private boolean e;

        static Entry a(Editor editor)
        {
            return editor.b;
        }

        static boolean[] b(Editor editor)
        {
            return editor.c;
        }

        static boolean c(Editor editor)
        {
            editor.d = true;
            return true;
        }

        public final OutputStream a(int i1)
        {
            DiskLruCache disklrucache = a;
            disklrucache;
            JVM INSTR monitorenter ;
            if (Entry.b(b) != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            disklrucache;
            JVM INSTR monitorexit ;
            throw obj;
            File file;
            if (!Entry.e(b))
            {
                c[i1] = true;
            }
            file = b.b(i1);
            Object obj1 = new FileOutputStream(file);
_L1:
            class FaultHidingOutputStream extends FilterOutputStream
            {

                final Editor a;

                public void close()
                {
                    try
                    {
                        out.close();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        Editor.c(a);
                    }
                }

                public void flush()
                {
                    try
                    {
                        out.flush();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        Editor.c(a);
                    }
                }

                public void write(int j1)
                {
                    try
                    {
                        out.write(j1);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        Editor.c(a);
                    }
                }

                public void write(byte abyte0[], int j1, int k1)
                {
                    try
                    {
                        out.write(abyte0, j1, k1);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        Editor.c(a);
                    }
                }

                private FaultHidingOutputStream(OutputStream outputstream)
                {
                    a = Editor.this;
                    super(outputstream);
                }

                FaultHidingOutputStream(OutputStream outputstream, byte byte0)
                {
                    this(outputstream);
                }
            }

            obj1 = new FaultHidingOutputStream(((OutputStream) (obj1)), (byte)0);
            disklrucache;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
            obj1;
            DiskLruCache.g(a).mkdirs();
            obj1 = new FileOutputStream(file);
              goto _L1
            obj1;
            obj1 = DiskLruCache.a();
            disklrucache;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
        }

        public final void a()
        {
            if (d)
            {
                DiskLruCache.a(a, this, false);
                a.c(Entry.d(b));
            } else
            {
                DiskLruCache.a(a, this, true);
            }
            e = true;
        }

        public final void b()
        {
            DiskLruCache.a(a, this, false);
        }

        private Editor(Entry entry)
        {
            a = DiskLruCache.this;
            super();
            b = entry;
            if (Entry.e(entry))
            {
                disklrucache = null;
            } else
            {
                disklrucache = new boolean[DiskLruCache.f(DiskLruCache.this)];
            }
            c = DiskLruCache.this;
        }

        Editor(Entry entry, byte byte0)
        {
            this(entry);
        }
    }


    private class Snapshot
        implements Closeable
    {

        final DiskLruCache a;
        private final String b;
        private final long c;
        private final InputStream d[];
        private final long e[];

        public final Editor a()
        {
            return DiskLruCache.a(a, b, c);
        }

        public final InputStream a(int i1)
        {
            return d[i1];
        }

        public final void close()
        {
            InputStream ainputstream[] = d;
            int j1 = ainputstream.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                Util.a(ainputstream[i1]);
            }

        }

        private Snapshot(String s, long l1, InputStream ainputstream[], long al[])
        {
            a = DiskLruCache.this;
            super();
            b = s;
            c = l1;
            d = ainputstream;
            e = al;
        }

        Snapshot(String s, long l1, InputStream ainputstream[], long al[], byte byte0)
        {
            this(s, l1, ainputstream, al);
        }
    }


    private class _cls2 extends OutputStream
    {

        public final void write(int i1)
        {
        }

        _cls2()
        {
        }
    }

}
