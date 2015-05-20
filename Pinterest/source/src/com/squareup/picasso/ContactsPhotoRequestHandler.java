// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Utils, Request

class ContactsPhotoRequestHandler extends RequestHandler
{

    private static final UriMatcher b;
    final Context a;

    ContactsPhotoRequestHandler(Context context)
    {
        a = context;
    }

    private Bitmap a(InputStream inputstream, Request request)
    {
        InputStream inputstream1;
        android.graphics.BitmapFactory.Options options;
        if (inputstream == null)
        {
            return null;
        }
        options = d(request);
        if (!a(options))
        {
            break MISSING_BLOCK_LABEL_52;
        }
        inputstream1 = c(request);
        BitmapFactory.decodeStream(inputstream1, null, options);
        Utils.a(inputstream1);
        a(request.h, request.i, options, request);
        return BitmapFactory.decodeStream(inputstream, null, options);
        inputstream;
        Utils.a(inputstream1);
        throw inputstream;
    }

    private InputStream c(Request request)
    {
        ContentResolver contentresolver = a.getContentResolver();
        Uri uri = request.d;
        request = uri;
        switch (b.match(uri))
        {
        default:
            throw new IllegalStateException((new StringBuilder("Invalid uri: ")).append(uri).toString());

        case 1: // '\001'
            uri = android.provider.ContactsContract.Contacts.lookupContact(contentresolver, uri);
            request = uri;
            if (uri == null)
            {
                return null;
            }
            // fall through

        case 3: // '\003'
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, request);
            } else
            {
                return ContactPhotoStreamIcs.a(contentresolver, request);
            }

        case 2: // '\002'
        case 4: // '\004'
            return contentresolver.openInputStream(uri);
        }
    }

    public final boolean a(Request request)
    {
        request = request.d;
        return "content".equals(request.getScheme()) && android.provider.ContactsContract.Contacts.CONTENT_URI.getHost().equals(request.getHost()) && !request.getPathSegments().contains("photo");
    }

    public final RequestHandler.Result b(Request request)
    {
        InputStream inputstream = null;
        InputStream inputstream1 = c(request);
        inputstream = inputstream1;
        request = new RequestHandler.Result(a(inputstream1, request), Picasso.LoadedFrom.b);
        Utils.a(inputstream1);
        return request;
        request;
        Utils.a(inputstream);
        throw request;
    }

    static 
    {
        UriMatcher urimatcher = new UriMatcher(-1);
        b = urimatcher;
        urimatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        b.addURI("com.android.contacts", "contacts/lookup/*", 1);
        b.addURI("com.android.contacts", "contacts/#/photo", 2);
        b.addURI("com.android.contacts", "contacts/#", 3);
        b.addURI("com.android.contacts", "display_photo/#", 4);
    }

    private class ContactPhotoStreamIcs
    {

        static InputStream a(ContentResolver contentresolver, Uri uri)
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri, true);
        }
    }

}
