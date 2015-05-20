// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package okio:
//            Util, Base64

public final class ByteString
    implements Serializable
{

    public static final ByteString a = a(new byte[0]);
    private static final char c[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    final byte b[];
    private transient int d;
    private transient String e;

    ByteString(byte abyte0[])
    {
        b = abyte0;
    }

    public static ByteString a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("s == null");
        } else
        {
            ByteString bytestring = new ByteString(s.getBytes(Util.a));
            bytestring.e = s;
            return bytestring;
        }
    }

    public static transient ByteString a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("data == null");
        } else
        {
            return new ByteString((byte[])abyte0.clone());
        }
    }

    public static ByteString b(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("base64 == null");
        }
        s = Base64.a(s);
        if (s != null)
        {
            return new ByteString(s);
        } else
        {
            return null;
        }
    }

    public final byte a(int i)
    {
        return b[i];
    }

    public final String a()
    {
        String s = e;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = new String(b, Util.a);
            e = s1;
            return s1;
        }
    }

    public final String b()
    {
        return Base64.a(b);
    }

    public final String c()
    {
        int i = 0;
        char ac[] = new char[b.length * 2];
        byte abyte0[] = b;
        int k = abyte0.length;
        int j = 0;
        for (; i < k; i++)
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac[j] = c[byte0 >> 4 & 0xf];
            j = l + 1;
            ac[l] = c[byte0 & 0xf];
        }

        return new String(ac);
    }

    public final ByteString d()
    {
        int i = 0;
        do
        {
label0:
            {
                Object obj = this;
                if (i < b.length)
                {
                    byte byte0 = b[i];
                    if (byte0 < 65 || byte0 > 90)
                    {
                        break label0;
                    }
                    obj = (byte[])b.clone();
                    obj[i] = (byte)(byte0 + 32);
                    for (i++; i < obj.length; i++)
                    {
                        byte byte1 = obj[i];
                        if (byte1 >= 65 && byte1 <= 90)
                        {
                            obj[i] = (byte)(byte1 + 32);
                        }
                    }

                    obj = new ByteString(((byte []) (obj)));
                }
                return ((ByteString) (obj));
            }
            i++;
        } while (true);
    }

    public final int e()
    {
        return b.length;
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof ByteString) && Arrays.equals(((ByteString)obj).b, b);
    }

    public final byte[] f()
    {
        return (byte[])b.clone();
    }

    public final int hashCode()
    {
        int i = d;
        if (i != 0)
        {
            return i;
        } else
        {
            int j = Arrays.hashCode(b);
            d = j;
            return j;
        }
    }

    public final String toString()
    {
        if (b.length == 0)
        {
            return "ByteString[size=0]";
        }
        if (b.length <= 16)
        {
            return String.format("ByteString[size=%s data=%s]", new Object[] {
                Integer.valueOf(b.length), c()
            });
        }
        String s;
        try
        {
            s = String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(b.length), a(MessageDigest.getInstance("MD5").digest(b)).c()
            });
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        return s;
    }

}
