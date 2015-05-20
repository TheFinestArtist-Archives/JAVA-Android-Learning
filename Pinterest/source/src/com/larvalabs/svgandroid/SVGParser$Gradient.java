// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import android.graphics.Matrix;
import android.graphics.Shader;
import java.util.ArrayList;

class <init>
{

    String a;
    String b;
    boolean c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    ArrayList k;
    ArrayList l;
    Matrix m;
    public Shader n;
    public boolean o;
    public android.graphics.radient.p p;

    public final <init> a(<init> <init>1)
    {
        <init> <init>2 = new <init>();
        <init>2.a = <init>1.a;
        <init>2.b = a;
        <init>2.c = <init>1.c;
        <init>2.d = <init>1.d;
        <init>2.f = <init>1.f;
        <init>2.e = <init>1.e;
        <init>2.g = <init>1.g;
        <init>2.h = <init>1.h;
        <init>2.i = <init>1.i;
        <init>2.j = <init>1.j;
        <init>2.k = k;
        <init>2.l = l;
        <init>2.m = m;
        if (<init>1.m != null)
        {
            if (m == null)
            {
                <init>2.m = <init>1.m;
            } else
            {
                Matrix matrix = new Matrix(m);
                matrix.preConcat(<init>1.m);
                <init>2.m = matrix;
            }
        }
        <init>2.o = <init>1.o;
        <init>2.n = <init>1.n;
        <init>2.p = <init>1.p;
        return <init>2;
    }

    private ()
    {
        k = new ArrayList();
        l = new ArrayList();
        m = null;
        n = null;
        o = false;
    }

    o(byte byte0)
    {
        this();
    }
}
