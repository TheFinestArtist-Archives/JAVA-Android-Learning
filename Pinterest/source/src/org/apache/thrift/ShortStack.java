// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;


public class ShortStack
{

    private int top;
    private short vector[];

    public ShortStack(int i)
    {
        top = -1;
        vector = new short[i];
    }

    private void grow()
    {
        short aword0[] = new short[vector.length * 2];
        System.arraycopy(vector, 0, aword0, 0, vector.length);
        vector = aword0;
    }

    public void clear()
    {
        top = -1;
    }

    public short peek()
    {
        return vector[top];
    }

    public short pop()
    {
        short aword0[] = vector;
        int i = top;
        top = i - 1;
        return aword0[i];
    }

    public void push(short word0)
    {
        if (vector.length == top + 1)
        {
            grow();
        }
        short aword0[] = vector;
        int i = top + 1;
        top = i;
        aword0[i] = word0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<ShortStack vector:[");
        for (int i = 0; i < vector.length; i++)
        {
            if (i != 0)
            {
                stringbuilder.append(" ");
            }
            if (i == top)
            {
                stringbuilder.append(">>");
            }
            stringbuilder.append(vector[i]);
            if (i == top)
            {
                stringbuilder.append("<<");
            }
        }

        stringbuilder.append("]>");
        return stringbuilder.toString();
    }
}
