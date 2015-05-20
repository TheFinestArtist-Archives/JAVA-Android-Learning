// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.ByteArrayOutputStream;

class Huffman
{

    private static final int a[] = {
        0x3ffffba, 0x3ffffbb, 0x3ffffbc, 0x3ffffbd, 0x3ffffbe, 0x3ffffbf, 0x3ffffc0, 0x3ffffc1, 0x3ffffc2, 0x3ffffc3, 
        0x3ffffc4, 0x3ffffc5, 0x3ffffc6, 0x3ffffc7, 0x3ffffc8, 0x3ffffc9, 0x3ffffca, 0x3ffffcb, 0x3ffffcc, 0x3ffffcd, 
        0x3ffffce, 0x3ffffcf, 0x3ffffd0, 0x3ffffd1, 0x3ffffd2, 0x3ffffd3, 0x3ffffd4, 0x3ffffd5, 0x3ffffd6, 0x3ffffd7, 
        0x3ffffd8, 0x3ffffd9, 6, 8188, 496, 16380, 32764, 30, 100, 8189, 
        1018, 497, 1019, 1020, 101, 102, 31, 7, 0, 1, 
        2, 8, 32, 33, 34, 35, 36, 37, 38, 236, 
        0x1fffc, 39, 32765, 1021, 32766, 103, 237, 238, 104, 239, 
        105, 106, 498, 240, 499, 500, 501, 107, 108, 241, 
        242, 502, 503, 109, 40, 243, 504, 505, 244, 506, 
        507, 2044, 0x3ffffda, 2045, 16381, 110, 0x3fffe, 9, 111, 10, 
        41, 11, 112, 42, 43, 12, 245, 246, 44, 45, 
        46, 13, 47, 508, 48, 49, 14, 113, 114, 115, 
        116, 117, 247, 0x1fffd, 4092, 0x1fffe, 4093, 0x3ffffdb, 0x3ffffdc, 0x3ffffdd, 
        0x3ffffde, 0x3ffffdf, 0x3ffffe0, 0x3ffffe1, 0x3ffffe2, 0x3ffffe3, 0x3ffffe4, 0x3ffffe5, 0x3ffffe6, 0x3ffffe7, 
        0x3ffffe8, 0x3ffffe9, 0x3ffffea, 0x3ffffeb, 0x3ffffec, 0x3ffffed, 0x3ffffee, 0x3ffffef, 0x3fffff0, 0x3fffff1, 
        0x3fffff2, 0x3fffff3, 0x3fffff4, 0x3fffff5, 0x3fffff6, 0x3fffff7, 0x3fffff8, 0x3fffff9, 0x3fffffa, 0x3fffffb, 
        0x3fffffc, 0x3fffffd, 0x3fffffe, 0x3ffffff, 0x1ffff80, 0x1ffff81, 0x1ffff82, 0x1ffff83, 0x1ffff84, 0x1ffff85, 
        0x1ffff86, 0x1ffff87, 0x1ffff88, 0x1ffff89, 0x1ffff8a, 0x1ffff8b, 0x1ffff8c, 0x1ffff8d, 0x1ffff8e, 0x1ffff8f, 
        0x1ffff90, 0x1ffff91, 0x1ffff92, 0x1ffff93, 0x1ffff94, 0x1ffff95, 0x1ffff96, 0x1ffff97, 0x1ffff98, 0x1ffff99, 
        0x1ffff9a, 0x1ffff9b, 0x1ffff9c, 0x1ffff9d, 0x1ffff9e, 0x1ffff9f, 0x1ffffa0, 0x1ffffa1, 0x1ffffa2, 0x1ffffa3, 
        0x1ffffa4, 0x1ffffa5, 0x1ffffa6, 0x1ffffa7, 0x1ffffa8, 0x1ffffa9, 0x1ffffaa, 0x1ffffab, 0x1ffffac, 0x1ffffad, 
        0x1ffffae, 0x1ffffaf, 0x1ffffb0, 0x1ffffb1, 0x1ffffb2, 0x1ffffb3, 0x1ffffb4, 0x1ffffb5, 0x1ffffb6, 0x1ffffb7, 
        0x1ffffb8, 0x1ffffb9, 0x1ffffba, 0x1ffffbb, 0x1ffffbc, 0x1ffffbd, 0x1ffffbe, 0x1ffffbf, 0x1ffffc0, 0x1ffffc1, 
        0x1ffffc2, 0x1ffffc3, 0x1ffffc4, 0x1ffffc5, 0x1ffffc6, 0x1ffffc7, 0x1ffffc8, 0x1ffffc9, 0x1ffffca, 0x1ffffcb, 
        0x1ffffcc, 0x1ffffcd, 0x1ffffce, 0x1ffffcf, 0x1ffffd0, 0x1ffffd1, 0x1ffffd2, 0x1ffffd3, 0x1ffffd4, 0x1ffffd5, 
        0x1ffffd6, 0x1ffffd7, 0x1ffffd8, 0x1ffffd9, 0x1ffffda, 0x1ffffdb
    };
    private static final byte b[] = {
        26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 
        26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 
        26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 
        26, 26, 5, 13, 9, 14, 15, 6, 7, 13, 
        10, 9, 10, 10, 7, 7, 6, 5, 4, 4, 
        4, 5, 6, 6, 6, 6, 6, 6, 6, 8, 
        17, 6, 15, 10, 15, 7, 8, 8, 7, 8, 
        7, 7, 9, 8, 9, 9, 9, 7, 7, 8, 
        8, 9, 9, 7, 6, 8, 9, 9, 8, 9, 
        9, 11, 26, 11, 14, 7, 18, 5, 7, 5, 
        6, 5, 7, 6, 6, 5, 8, 8, 6, 6, 
        6, 5, 6, 9, 6, 6, 5, 7, 7, 7, 
        7, 7, 8, 17, 12, 17, 12, 26, 26, 26, 
        26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 
        26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 
        26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 
        26, 26, 26, 26, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 
        25, 25, 25, 25, 25, 25
    };
    private static final Huffman c = new Huffman();
    private final Node d = new Node();

    private Huffman()
    {
        b();
    }

    public static Huffman a()
    {
        return c;
    }

    private void b()
    {
        for (int i = 0; i < b.length; i++)
        {
            int k = a[i];
            byte byte0 = b[i];
            Node node1 = new Node(i, byte0);
            Node node;
            int l;
            for (node = d; byte0 > 8; node = Node.a(node)[l])
            {
                byte0 -= 8;
                l = k >>> byte0 & 0xff;
                if (Node.a(node) == null)
                {
                    throw new IllegalStateException("invalid dictionary: prefix not unique");
                }
                if (Node.a(node)[l] == null)
                {
                    Node.a(node)[l] = new Node();
                }
            }

            int i1 = 8 - byte0;
            k = k << i1 & 0xff;
            for (int j = k; j < k + (1 << i1); j++)
            {
                Node.a(node)[j] = node1;
            }

        }

    }

    final byte[] a(byte abyte0[])
    {
        int j = 0;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Node node = d;
        int k = 0;
        int i = 0;
        Node node1;
        int l;
        do
        {
            l = i;
            node1 = node;
            if (j >= abyte0.length)
            {
                break;
            }
            k = k << 8 | abyte0[j] & 0xff;
            for (i += 8; i >= 8;)
            {
                node = Node.a(node)[k >>> i - 8 & 0xff];
                if (Node.a(node) == null)
                {
                    bytearrayoutputstream.write(Node.b(node));
                    i -= Node.c(node);
                    node = d;
                } else
                {
                    i -= 8;
                }
            }

            j++;
        } while (true);
        do
        {
            if (l <= 0)
            {
                break;
            }
            abyte0 = Node.a(node1)[k << 8 - l & 0xff];
            if (Node.a(abyte0) != null || Node.c(abyte0) > l)
            {
                break;
            }
            bytearrayoutputstream.write(Node.b(abyte0));
            l -= Node.c(abyte0);
            node1 = d;
        } while (true);
        return bytearrayoutputstream.toByteArray();
    }


    private class Node
    {

        private final Node a[];
        private final int b;
        private final int c;

        static Node[] a(Node node)
        {
            return node.a;
        }

        static int b(Node node)
        {
            return node.b;
        }

        static int c(Node node)
        {
            return node.c;
        }

        Node()
        {
            a = new Node[256];
            b = 0;
            c = 0;
        }

        Node(int i, int j)
        {
            a = null;
            b = i;
            j &= 7;
            i = j;
            if (j == 0)
            {
                i = 8;
            }
            c = i;
        }
    }

}
