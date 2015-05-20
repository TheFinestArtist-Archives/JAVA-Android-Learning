// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.javawriter;

import java.io.Closeable;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Modifier;

public class JavaWriter
    implements Closeable
{

    private static final Pattern a = Pattern.compile("(?:[\\w$]+\\.)*([\\w\\.*$]+)");
    private static final EnumSet i;
    private final Map b = new LinkedHashMap();
    private String c;
    private final Deque d = new ArrayDeque();
    private final Deque e = new ArrayDeque();
    private final Writer f;
    private boolean g;
    private String h;

    public JavaWriter(Writer writer)
    {
        g = true;
        h = "  ";
        f = writer;
    }

    private JavaWriter a(Object obj)
    {
        if (obj instanceof Object[])
        {
            f.write("{");
            d.push(Scope.h);
            obj = ((Object) ((Object[])obj));
            int k = obj.length;
            int j = 0;
            boolean flag = true;
            while (j < k) 
            {
                Object obj1 = obj[j];
                if (flag)
                {
                    f.write("\n");
                    flag = false;
                } else
                {
                    f.write(",\n");
                }
                e();
                f.write(obj1.toString());
                j++;
            }
            a(new Scope[] {
                Scope.h
            });
            f.write("\n");
            e();
            f.write("}");
            return this;
        } else
        {
            f.write(obj.toString());
            return this;
        }
    }

    private void a(Set set)
    {
        if (!set.isEmpty())
        {
            Object obj = set;
            if (!(set instanceof EnumSet))
            {
                obj = EnumSet.copyOf(set);
            }
            set = ((Set) (obj)).iterator();
            while (set.hasNext()) 
            {
                Modifier modifier = (Modifier)set.next();
                f.append(modifier.toString()).append(' ');
            }
        }
    }

    private transient void a(Scope ascope[])
    {
        if (!EnumSet.copyOf(Arrays.asList(ascope)).contains(d.pop()))
        {
            throw new IllegalStateException();
        } else
        {
            return;
        }
    }

    private static boolean a(String s, String s1)
    {
        while (s.startsWith(s1) && (s.indexOf('.', s1.length()) == -1 || Character.isUpperCase(s.charAt(s1.length())))) 
        {
            return true;
        }
        return false;
    }

    private JavaWriter d(String s)
    {
        if (g)
        {
            Writer writer = f;
            StringBuilder stringbuilder = new StringBuilder();
            if (c == null)
            {
                throw new IllegalStateException();
            }
            Matcher matcher = a.matcher(s);
            int j = 0;
            do
            {
                boolean flag = matcher.find(j);
                int k;
                if (flag)
                {
                    k = matcher.start();
                } else
                {
                    k = s.length();
                }
                stringbuilder.append(s, j, k);
                if (flag)
                {
                    String s1 = matcher.group(0);
                    String s2 = (String)b.get(s1);
                    if (s2 != null)
                    {
                        stringbuilder.append(s2);
                    } else
                    if (a(s1, c))
                    {
                        String s3 = s1.substring(c.length());
                        if (b.values().contains(s3))
                        {
                            stringbuilder.append(s1);
                        } else
                        {
                            stringbuilder.append(s3);
                        }
                    } else
                    if (a(s1, "java.lang."))
                    {
                        stringbuilder.append(s1.substring(10));
                    } else
                    {
                        stringbuilder.append(s1);
                    }
                    j = matcher.end();
                } else
                {
                    writer.write(stringbuilder.toString());
                    return this;
                }
            } while (true);
        } else
        {
            f.write(s);
            return this;
        }
    }

    private void e()
    {
        int j = 0;
        for (int k = d.size(); j < k; j++)
        {
            f.write(h);
        }

    }

    private void f()
    {
        if (!i.contains(d.peekFirst()))
        {
            throw new IllegalArgumentException();
        } else
        {
            return;
        }
    }

    public final JavaWriter a()
    {
        a(new Scope[] {
            Scope.a, Scope.b
        });
        e.pop();
        e();
        f.write("}\n");
        return this;
    }

    public final transient JavaWriter a(String s, String s1, Set set, String s2, String as[])
    {
        e();
        a(set);
        f.write(s1);
        f.write(" ");
        d(s);
        if (s2 != null)
        {
            f.write(" extends ");
            d(s2);
        }
        if (as.length > 0)
        {
            f.write("\n");
            e();
            f.write("    implements ");
            for (int j = 0; j < as.length; j++)
            {
                if (j != 0)
                {
                    f.write(", ");
                }
                d(as[j]);
            }

        }
        f.write(" {\n");
        set = d;
        if ("interface".equals(s1))
        {
            s1 = Scope.b;
        } else
        {
            s1 = Scope.a;
        }
        set.push(s1);
        e.push(s);
        return this;
    }

    public final JavaWriter a(String s, String s1, Set set, List list, List list1)
    {
        boolean flag = false;
        e();
        a(set);
        if (s != null)
        {
            d(s);
            f.write(" ");
            f.write(s1);
        } else
        {
            d(s1);
        }
        f.write("(");
        if (list != null)
        {
            int l;
            for (int j = 0; j < list.size(); j = l + 1)
            {
                if (j != 0)
                {
                    f.write(", ");
                }
                l = j + 1;
                d((String)list.get(j));
                f.write(" ");
                d((String)list.get(l));
            }

        }
        f.write(")");
        if (list1 != null && list1.size() > 0)
        {
            f.write("\n");
            e();
            f.write("    throws ");
            for (int k = ((flag) ? 1 : 0); k < list1.size(); k++)
            {
                if (k != 0)
                {
                    f.write(", ");
                }
                d((String)list1.get(k));
            }

        }
        if (set.contains(Modifier.ABSTRACT) || Scope.b.equals(d.peek()))
        {
            f.write(";\n");
            s1 = d;
            s = Scope.c;
        } else
        {
            f.write(" {\n");
            s1 = d;
            if (s == null)
            {
                s = Scope.e;
            } else
            {
                s = Scope.d;
            }
        }
        s1.push(s);
        return this;
    }

    public final transient JavaWriter a(String s, String s1, Set set, String as[])
    {
        return a(s, s1, set, Arrays.asList(as), ((List) (null)));
    }

    public final transient JavaWriter a(String s, Object aobj[])
    {
        f();
        s = String.format(s, aobj).split("\n", -1);
        e();
        f.write(s[0]);
        for (int j = 1; j < s.length; j++)
        {
            f.write("\n");
            int l = d.size();
            for (int k = 0; k < l + 2; k++)
            {
                f.write(h);
            }

            f.write(s[j]);
        }

        f.write(";\n");
        return this;
    }

    public final JavaWriter a(Collection collection)
    {
        for (collection = (new TreeSet(collection)).iterator(); collection.hasNext(); f.write(";\n"))
        {
            String s = (String)collection.next();
            Matcher matcher = a.matcher(s);
            if (!matcher.matches())
            {
                throw new IllegalArgumentException(s);
            }
            if (b.put(s, matcher.group(1)) != null)
            {
                throw new IllegalArgumentException(s);
            }
            f.write("import ");
            f.write(s);
        }

        return this;
    }

    public final transient JavaWriter a(String as[])
    {
        return a(((Collection) (Arrays.asList(as))));
    }

    public final void a(String s)
    {
        h = s;
    }

    public final JavaWriter b()
    {
        f.write("\n");
        return this;
    }

    public final JavaWriter b(String s)
    {
        if (c != null)
        {
            throw new IllegalStateException();
        }
        if (s.isEmpty())
        {
            c = "";
            return this;
        } else
        {
            f.write("package ");
            f.write(s);
            f.write(";\n\n");
            c = (new StringBuilder()).append(s).append(".").toString();
            return this;
        }
    }

    public final transient JavaWriter b(String s, Object aobj[])
    {
        f();
        e();
        f.write(String.format(s, aobj));
        f.write(" {\n");
        d.push(Scope.f);
        return this;
    }

    public final JavaWriter c()
    {
        a(new Scope[] {
            Scope.f
        });
        e();
        f.write("}\n");
        return this;
    }

    public final JavaWriter c(String s)
    {
        Object obj;
        obj = Collections.emptyMap();
        e();
        f.write("@");
        d(s);
        ((Map) (obj)).size();
        JVM INSTR tableswitch 0 1: default 52
    //                   0 324
    //                   1 232;
           goto _L1 _L2 _L3
_L1:
        if (((Map) (obj)).size() > 3) goto _L5; else goto _L4
_L4:
        s = ((Map) (obj)).values().iterator();
_L9:
        if (!s.hasNext()) goto _L7; else goto _L6
_L6:
        if (!(s.next() instanceof Object[])) goto _L9; else goto _L8
_L8:
        boolean flag = true;
_L12:
        if (!flag) goto _L10; else goto _L5
_L5:
        flag = true;
          goto _L11
_L3:
        s = (java.util.Map.Entry)((Map) (obj)).entrySet().iterator().next();
        f.write("(");
        if (!"value".equals(s.getKey()))
        {
            f.write((String)s.getKey());
            f.write(" = ");
        }
        a(s.getValue());
_L13:
        f.write(")");
_L2:
        f.write("\n");
        return this;
_L7:
        flag = false;
          goto _L12
_L10:
        flag = false;
_L11:
        f.write("(");
        d.push(Scope.g);
        if (flag)
        {
            s = "\n";
        } else
        {
            s = "";
        }
        obj = ((Map) (obj)).entrySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            f.write(s);
            if (flag)
            {
                s = ",\n";
            } else
            {
                s = ", ";
            }
            if (flag)
            {
                e();
            }
            f.write((String)entry.getKey());
            f.write(" = ");
            a(entry.getValue());
        }
        a(new Scope[] {
            Scope.g
        });
        if (flag)
        {
            f.write("\n");
            e();
        }
          goto _L13
    }

    public final transient JavaWriter c(String s, Object aobj[])
    {
        a(new Scope[] {
            Scope.f
        });
        e();
        d.push(Scope.f);
        f.write("} ");
        f.write(String.format(s, aobj));
        f.write(" {\n");
        return this;
    }

    public void close()
    {
        f.close();
    }

    public final JavaWriter d()
    {
        Scope scope = (Scope)d.pop();
        if (scope == Scope.d || scope == Scope.e)
        {
            e();
            f.write("}\n");
        } else
        if (scope != Scope.c)
        {
            throw new IllegalStateException();
        }
        return this;
    }

    static 
    {
        i = EnumSet.of(Scope.d, Scope.e, Scope.f, Scope.i);
    }

    private class Scope extends Enum
    {

        public static final Scope a;
        public static final Scope b;
        public static final Scope c;
        public static final Scope d;
        public static final Scope e;
        public static final Scope f;
        public static final Scope g;
        public static final Scope h;
        public static final Scope i;
        private static final Scope j[];

        public static Scope valueOf(String s)
        {
            return (Scope)Enum.valueOf(com/squareup/javawriter/JavaWriter$Scope, s);
        }

        public static Scope[] values()
        {
            return (Scope[])j.clone();
        }

        static 
        {
            a = new Scope("TYPE_DECLARATION", 0);
            b = new Scope("INTERFACE_DECLARATION", 1);
            c = new Scope("ABSTRACT_METHOD", 2);
            d = new Scope("NON_ABSTRACT_METHOD", 3);
            e = new Scope("CONSTRUCTOR", 4);
            f = new Scope("CONTROL_FLOW", 5);
            g = new Scope("ANNOTATION_ATTRIBUTE", 6);
            h = new Scope("ANNOTATION_ARRAY_VALUE", 7);
            i = new Scope("INITIALIZER", 8);
            j = (new Scope[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private Scope(String s, int k)
        {
            super(s, k);
        }
    }

}
