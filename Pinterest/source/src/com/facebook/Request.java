// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            HttpMethod, Session, FacebookException, Settings, 
//            Response, RequestBatch, RequestAsyncTask, LoggingBehavior, 
//            ProgressNoopOutputStream, ProgressOutputStream

public class Request
{

    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_ACTION_FORMAT = "me/%s";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String MY_VIDEOS = "me/videos";
    private static final String OBJECT_PARAM = "object";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String STAGING_PARAM = "file";
    public static final String TAG = com/facebook/Request.getSimpleName();
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private Session session;
    private boolean skipClientToken;
    private Object tag;
    private String version;

    public Request()
    {
        this(null, null, null, null, null);
    }

    public Request(Session session1, String s)
    {
        this(session1, s, null, null, null);
    }

    public Request(Session session1, String s, Bundle bundle, HttpMethod httpmethod)
    {
        this(session1, s, bundle, httpmethod, null);
    }

    public Request(Session session1, String s, Bundle bundle, HttpMethod httpmethod, Callback callback1)
    {
        this(session1, s, bundle, httpmethod, callback1, null);
    }

    public Request(Session session1, String s, Bundle bundle, HttpMethod httpmethod, Callback callback1, String s1)
    {
        batchEntryOmitResultOnSuccess = true;
        skipClientToken = false;
        session = session1;
        graphPath = s;
        callback = callback1;
        version = s1;
        setHttpMethod(httpmethod);
        if (bundle != null)
        {
            parameters = new Bundle(bundle);
        } else
        {
            parameters = new Bundle();
        }
        if (version == null)
        {
            version = ServerProtocol.getAPIVersion();
        }
    }

    Request(Session session1, URL url)
    {
        batchEntryOmitResultOnSuccess = true;
        skipClientToken = false;
        session = session1;
        overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        parameters = new Bundle();
    }

    private void addCommonParameters()
    {
        if (session == null) goto _L2; else goto _L1
_L1:
        if (!session.isOpened())
        {
            throw new FacebookException("Session provided to a Request in un-opened state.");
        }
        if (!parameters.containsKey("access_token"))
        {
            String s = session.getAccessToken();
            Logger.registerAccessToken(s);
            parameters.putString("access_token", s);
        }
_L4:
        parameters.putString("sdk", "android");
        parameters.putString("format", "json");
        return;
_L2:
        if (!skipClientToken && !parameters.containsKey("access_token"))
        {
            String s1 = Settings.getApplicationId();
            String s2 = Settings.getClientToken();
            if (!Utility.isNullOrEmpty(s1) && !Utility.isNullOrEmpty(s2))
            {
                s1 = (new StringBuilder()).append(s1).append("|").append(s2).toString();
                parameters.putString("access_token", s1);
            } else
            {
                Log.d(TAG, "Warning: Sessionless Request needs token but missing either application ID or client token.");
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String appendParametersToBaseUrl(String s)
    {
        android.net.Uri.Builder builder;
label0:
        {
            builder = (new android.net.Uri.Builder()).encodedPath(s);
label1:
            do
            {
                String s1;
                for (Iterator iterator = parameters.keySet().iterator(); iterator.hasNext(); builder.appendQueryParameter(s1, parameterToString(s).toString()))
                {
                    s1 = (String)iterator.next();
                    Object obj = parameters.get(s1);
                    s = ((String) (obj));
                    if (obj == null)
                    {
                        s = "";
                    }
                    if (!isSupportedParameterType(s))
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (httpMethod != HttpMethod.GET);
            throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", new Object[] {
                s.getClass().getSimpleName()
            }));
        }
        return builder.toString();
    }

    static HttpURLConnection createConnection(URL url)
    {
        url = (HttpURLConnection)url.openConnection();
        url.setRequestProperty("User-Agent", getUserAgent());
        url.setRequestProperty("Content-Type", getMimeContentType());
        url.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        url.setChunkedStreamingMode(0);
        return url;
    }

    public static Response executeAndWait(Request request)
    {
        request = executeBatchAndWait(new Request[] {
            request
        });
        if (request == null || request.size() != 1)
        {
            throw new FacebookException("invalid state: expected a single response");
        } else
        {
            return (Response)request.get(0);
        }
    }

    public static List executeBatchAndWait(RequestBatch requestbatch)
    {
        Validate.notEmptyAndContainsNoNulls(requestbatch, "requests");
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = toHttpConnection(requestbatch);
        }
        catch (Exception exception)
        {
            List list = Response.constructErrorResponses(requestbatch.getRequests(), null, new FacebookException(exception));
            runCallbacks(requestbatch, list);
            return list;
        }
        return executeConnectionAndWait(httpurlconnection, requestbatch);
    }

    public static List executeBatchAndWait(Collection collection)
    {
        return executeBatchAndWait(new RequestBatch(collection));
    }

    public static transient List executeBatchAndWait(Request arequest[])
    {
        Validate.notNull(arequest, "requests");
        return executeBatchAndWait(((Collection) (Arrays.asList(arequest))));
    }

    public static RequestAsyncTask executeBatchAsync(RequestBatch requestbatch)
    {
        Validate.notEmptyAndContainsNoNulls(requestbatch, "requests");
        requestbatch = new RequestAsyncTask(requestbatch);
        requestbatch.executeOnSettingsExecutor();
        return requestbatch;
    }

    public static RequestAsyncTask executeBatchAsync(Collection collection)
    {
        return executeBatchAsync(new RequestBatch(collection));
    }

    public static transient RequestAsyncTask executeBatchAsync(Request arequest[])
    {
        Validate.notNull(arequest, "requests");
        return executeBatchAsync(((Collection) (Arrays.asList(arequest))));
    }

    public static List executeConnectionAndWait(HttpURLConnection httpurlconnection, RequestBatch requestbatch)
    {
        List list = Response.fromHttpConnection(httpurlconnection, requestbatch);
        Utility.disconnectQuietly(httpurlconnection);
        int i = requestbatch.size();
        if (i != list.size())
        {
            throw new FacebookException(String.format("Received %d responses while expecting %d", new Object[] {
                Integer.valueOf(list.size()), Integer.valueOf(i)
            }));
        }
        runCallbacks(requestbatch, list);
        httpurlconnection = new HashSet();
        requestbatch = requestbatch.iterator();
        do
        {
            if (!requestbatch.hasNext())
            {
                break;
            }
            Request request = (Request)requestbatch.next();
            if (request.session != null)
            {
                httpurlconnection.add(request.session);
            }
        } while (true);
        for (httpurlconnection = httpurlconnection.iterator(); httpurlconnection.hasNext(); ((Session)httpurlconnection.next()).extendAccessTokenIfNeeded()) { }
        return list;
    }

    public static List executeConnectionAndWait(HttpURLConnection httpurlconnection, Collection collection)
    {
        return executeConnectionAndWait(httpurlconnection, new RequestBatch(collection));
    }

    public static RequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpurlconnection, RequestBatch requestbatch)
    {
        Validate.notNull(httpurlconnection, "connection");
        httpurlconnection = new RequestAsyncTask(httpurlconnection, requestbatch);
        requestbatch.setCallbackHandler(handler);
        httpurlconnection.executeOnSettingsExecutor();
        return httpurlconnection;
    }

    public static RequestAsyncTask executeConnectionAsync(HttpURLConnection httpurlconnection, RequestBatch requestbatch)
    {
        return executeConnectionAsync(null, httpurlconnection, requestbatch);
    }

    public static RequestAsyncTask executeGraphPathRequestAsync(Session session1, String s, Callback callback1)
    {
        return newGraphPathRequest(session1, s, callback1).executeAsync();
    }

    public static RequestAsyncTask executeMeRequestAsync(Session session1, GraphUserCallback graphusercallback)
    {
        return newMeRequest(session1, graphusercallback).executeAsync();
    }

    public static RequestAsyncTask executeMyFriendsRequestAsync(Session session1, GraphUserListCallback graphuserlistcallback)
    {
        return newMyFriendsRequest(session1, graphuserlistcallback).executeAsync();
    }

    public static RequestAsyncTask executePlacesSearchRequestAsync(Session session1, Location location, int i, int j, String s, GraphPlaceListCallback graphplacelistcallback)
    {
        return newPlacesSearchRequest(session1, location, i, j, s, graphplacelistcallback).executeAsync();
    }

    public static RequestAsyncTask executePostRequestAsync(Session session1, String s, GraphObject graphobject, Callback callback1)
    {
        return newPostRequest(session1, s, graphobject, callback1).executeAsync();
    }

    public static RequestAsyncTask executeStatusUpdateRequestAsync(Session session1, String s, Callback callback1)
    {
        return newStatusUpdateRequest(session1, s, callback1).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session1, Bitmap bitmap, Callback callback1)
    {
        return newUploadPhotoRequest(session1, bitmap, callback1).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session1, File file, Callback callback1)
    {
        return newUploadPhotoRequest(session1, file, callback1).executeAsync();
    }

    private static String getBatchAppId(RequestBatch requestbatch)
    {
        if (!Utility.isNullOrEmpty(requestbatch.getBatchApplicationId()))
        {
            return requestbatch.getBatchApplicationId();
        }
        for (requestbatch = requestbatch.iterator(); requestbatch.hasNext();)
        {
            Session session1 = ((Request)requestbatch.next()).session;
            if (session1 != null)
            {
                return session1.getApplicationId();
            }
        }

        return defaultBatchApplicationId;
    }

    public static final String getDefaultBatchApplicationId()
    {
        return defaultBatchApplicationId;
    }

    private String getGraphPathWithVersion()
    {
        if (versionPattern.matcher(graphPath).matches())
        {
            return graphPath;
        } else
        {
            return String.format("%s/%s", new Object[] {
                version, graphPath
            });
        }
    }

    private static String getMimeContentType()
    {
        return String.format("multipart/form-data; boundary=%s", new Object[] {
            "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        });
    }

    private static String getUserAgent()
    {
        if (userAgent == null)
        {
            userAgent = String.format("%s.%s", new Object[] {
                "FBAndroidSDK", "3.22.0"
            });
        }
        return userAgent;
    }

    private static boolean hasOnProgressCallbacks(RequestBatch requestbatch)
    {
        for (Iterator iterator = requestbatch.getCallbacks().iterator(); iterator.hasNext();)
        {
            if ((RequestBatch.Callback)iterator.next() instanceof RequestBatch.OnProgressCallback)
            {
                return true;
            }
        }

        for (requestbatch = requestbatch.iterator(); requestbatch.hasNext();)
        {
            if (((Request)requestbatch.next()).getCallback() instanceof OnProgressCallback)
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isMeRequest(String s)
    {
        Matcher matcher = versionPattern.matcher(s);
        if (matcher.matches())
        {
            s = matcher.group(1);
        }
        return s.startsWith("me/") || s.startsWith("/me/");
    }

    private static boolean isSupportedAttachmentType(Object obj)
    {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelFileDescriptorWithMimeType);
    }

    private static boolean isSupportedParameterType(Object obj)
    {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static Request newCustomAudienceThirdPartyIdRequest(Session session1, Context context, Callback callback1)
    {
        return newCustomAudienceThirdPartyIdRequest(session1, context, null, callback1);
    }

    public static Request newCustomAudienceThirdPartyIdRequest(Session session1, Context context, String s, Callback callback1)
    {
        if (session1 == null)
        {
            session1 = Session.getActiveSession();
        }
        Session session2 = session1;
        if (session1 != null)
        {
            session2 = session1;
            if (!session1.isOpened())
            {
                session2 = null;
            }
        }
        session1 = s;
        if (s == null)
        {
            if (session2 != null)
            {
                session1 = session2.getApplicationId();
            } else
            {
                session1 = Utility.getMetadataApplicationId(context);
            }
        }
        if (session1 == null)
        {
            throw new FacebookException("Facebook App ID cannot be determined");
        }
        s = (new StringBuilder()).append(session1).append("/custom_audience_third_party_id").toString();
        AttributionIdentifiers attributionidentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        Bundle bundle = new Bundle();
        if (session2 == null)
        {
            if (attributionidentifiers.getAttributionId() != null)
            {
                session1 = attributionidentifiers.getAttributionId();
            } else
            {
                session1 = attributionidentifiers.getAndroidAdvertiserId();
            }
            if (attributionidentifiers.getAttributionId() != null)
            {
                bundle.putString("udid", session1);
            }
        }
        if (Settings.getLimitEventAndDataUsage(context) || attributionidentifiers.isTrackingLimited())
        {
            bundle.putString("limit_event_usage", "1");
        }
        return new Request(session2, s, bundle, HttpMethod.GET, callback1);
    }

    public static Request newDeleteObjectRequest(Session session1, String s, Callback callback1)
    {
        return new Request(session1, s, null, HttpMethod.DELETE, callback1);
    }

    public static Request newGraphPathRequest(Session session1, String s, Callback callback1)
    {
        return new Request(session1, s, null, null, callback1);
    }

    public static Request newMeRequest(Session session1, final GraphUserCallback callback)
    {
        return new Request(session1, "me", null, null, new _cls1());
    }

    public static Request newMyFriendsRequest(Session session1, final GraphUserListCallback callback)
    {
        return new Request(session1, "me/friends", null, null, new _cls2());
    }

    public static Request newPlacesSearchRequest(Session session1, Location location, int i, int j, String s, final GraphPlaceListCallback callback)
    {
        if (location == null && Utility.isNullOrEmpty(s))
        {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle bundle = new Bundle(5);
        bundle.putString("type", "place");
        bundle.putInt("limit", j);
        if (location != null)
        {
            bundle.putString("center", String.format(Locale.US, "%f,%f", new Object[] {
                Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())
            }));
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(s))
        {
            bundle.putString("q", s);
        }
        location = new _cls3();
        return new Request(session1, "search", bundle, HttpMethod.GET, location);
    }

    public static Request newPostOpenGraphActionRequest(Session session1, OpenGraphAction opengraphaction, Callback callback1)
    {
        if (opengraphaction == null)
        {
            throw new FacebookException("openGraphAction cannot be null");
        }
        if (Utility.isNullOrEmpty(opengraphaction.getType()))
        {
            throw new FacebookException("openGraphAction must have non-null 'type' property");
        } else
        {
            return newPostRequest(session1, String.format("me/%s", new Object[] {
                opengraphaction.getType()
            }), opengraphaction, callback1);
        }
    }

    public static Request newPostOpenGraphObjectRequest(Session session1, OpenGraphObject opengraphobject, Callback callback1)
    {
        if (opengraphobject == null)
        {
            throw new FacebookException("openGraphObject cannot be null");
        }
        if (Utility.isNullOrEmpty(opengraphobject.getType()))
        {
            throw new FacebookException("openGraphObject must have non-null 'type' property");
        }
        if (Utility.isNullOrEmpty(opengraphobject.getTitle()))
        {
            throw new FacebookException("openGraphObject must have non-null 'title' property");
        } else
        {
            String s = String.format("me/objects/%s", new Object[] {
                opengraphobject.getType()
            });
            Bundle bundle = new Bundle();
            bundle.putString("object", opengraphobject.getInnerJSONObject().toString());
            return new Request(session1, s, bundle, HttpMethod.POST, callback1);
        }
    }

    public static Request newPostOpenGraphObjectRequest(Session session1, String s, String s1, String s2, String s3, String s4, GraphObject graphobject, Callback callback1)
    {
        s = com.facebook.model.OpenGraphObject.Factory.createForPost(com/facebook/model/OpenGraphObject, s, s1, s2, s3, s4);
        if (graphobject != null)
        {
            s.setData(graphobject);
        }
        return newPostOpenGraphObjectRequest(session1, ((OpenGraphObject) (s)), callback1);
    }

    public static Request newPostRequest(Session session1, String s, GraphObject graphobject, Callback callback1)
    {
        session1 = new Request(session1, s, null, HttpMethod.POST, callback1);
        session1.setGraphObject(graphobject);
        return session1;
    }

    public static Request newStatusUpdateRequest(Session session1, String s, Callback callback1)
    {
        return newStatusUpdateRequest(session1, s, ((String) (null)), null, callback1);
    }

    public static Request newStatusUpdateRequest(Session session1, String s, GraphPlace graphplace, List list, Callback callback1)
    {
        if (list != null)
        {
            ArrayList arraylist = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            do
            {
                list = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                arraylist.add(((GraphUser)iterator.next()).getId());
            } while (true);
        } else
        {
            list = null;
        }
        if (graphplace == null)
        {
            graphplace = null;
        } else
        {
            graphplace = graphplace.getId();
        }
        return newStatusUpdateRequest(session1, s, ((String) (graphplace)), list, callback1);
    }

    private static Request newStatusUpdateRequest(Session session1, String s, String s1, List list, Callback callback1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", s);
        if (s1 != null)
        {
            bundle.putString("place", s1);
        }
        if (list != null && list.size() > 0)
        {
            bundle.putString("tags", TextUtils.join(",", list));
        }
        return new Request(session1, "me/feed", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUpdateOpenGraphObjectRequest(Session session1, OpenGraphObject opengraphobject, Callback callback1)
    {
        if (opengraphobject == null)
        {
            throw new FacebookException("openGraphObject cannot be null");
        }
        String s = opengraphobject.getId();
        if (s == null)
        {
            throw new FacebookException("openGraphObject must have an id");
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("object", opengraphobject.getInnerJSONObject().toString());
            return new Request(session1, s, bundle, HttpMethod.POST, callback1);
        }
    }

    public static Request newUpdateOpenGraphObjectRequest(Session session1, String s, String s1, String s2, String s3, String s4, GraphObject graphobject, Callback callback1)
    {
        s1 = com.facebook.model.OpenGraphObject.Factory.createForPost(com/facebook/model/OpenGraphObject, null, s1, s2, s3, s4);
        s1.setId(s);
        s1.setData(graphobject);
        return newUpdateOpenGraphObjectRequest(session1, ((OpenGraphObject) (s1)), callback1);
    }

    public static Request newUploadPhotoRequest(Session session1, Bitmap bitmap, Callback callback1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", bitmap);
        return new Request(session1, "me/photos", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadPhotoRequest(Session session1, File file, Callback callback1)
    {
        file = ParcelFileDescriptor.open(file, 0x10000000);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", file);
        return new Request(session1, "me/photos", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadStagingResourceWithImageRequest(Session session1, Bitmap bitmap, Callback callback1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new Request(session1, "me/staging_resources", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadStagingResourceWithImageRequest(Session session1, File file, Callback callback1)
    {
        file = new ParcelFileDescriptorWithMimeType(ParcelFileDescriptor.open(file, 0x10000000), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", file);
        return new Request(session1, "me/staging_resources", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadVideoRequest(Session session1, File file, Callback callback1)
    {
        ParcelFileDescriptor parcelfiledescriptor = ParcelFileDescriptor.open(file, 0x10000000);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(file.getName(), parcelfiledescriptor);
        return new Request(session1, "me/videos", bundle, HttpMethod.POST, callback1);
    }

    private static String parameterToString(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number))
        {
            return obj.toString();
        }
        if (obj instanceof Date)
        {
            return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(obj);
        } else
        {
            throw new IllegalArgumentException("Unsupported parameter type.");
        }
    }

    private static void processGraphObject(GraphObject graphobject, String s, KeyValueSerializer keyvalueserializer)
    {
        int i;
        if (isMeRequest(s))
        {
            i = s.indexOf(":");
            int j = s.indexOf("?");
            if (i > 3 && (j == -1 || i < j))
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 0;
        }
        graphobject = graphobject.asMap().entrySet().iterator();
        while (graphobject.hasNext()) 
        {
            s = (java.util.Map.Entry)graphobject.next();
            boolean flag;
            if (i && ((String)s.getKey()).equalsIgnoreCase("image"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            processGraphObjectProperty((String)s.getKey(), s.getValue(), keyvalueserializer, flag);
        }
    }

    private static void processGraphObjectProperty(String s, Object obj, KeyValueSerializer keyvalueserializer, boolean flag)
    {
label0:
        {
            Object obj1;
            Object obj2;
            do
            {
                Class class1 = obj.getClass();
                if (com/facebook/model/GraphObject.isAssignableFrom(class1))
                {
                    obj1 = ((GraphObject)obj).getInnerJSONObject();
                    obj2 = obj1.getClass();
                } else
                {
                    obj1 = obj;
                    obj2 = class1;
                    if (com/facebook/model/GraphObjectList.isAssignableFrom(class1))
                    {
                        obj1 = ((GraphObjectList)obj).getInnerJSONArray();
                        obj2 = obj1.getClass();
                    }
                }
                if (!org/json/JSONObject.isAssignableFrom(((Class) (obj2))))
                {
                    break;
                }
                obj = (JSONObject)obj1;
                if (flag)
                {
                    for (obj1 = ((JSONObject) (obj)).keys(); ((Iterator) (obj1)).hasNext(); processGraphObjectProperty(String.format("%s[%s]", new Object[] {
    s, obj2
}), ((JSONObject) (obj)).opt(((String) (obj2))), keyvalueserializer, flag))
                    {
                        obj2 = (String)((Iterator) (obj1)).next();
                    }

                    break label0;
                }
                if (((JSONObject) (obj)).has("id"))
                {
                    obj = ((JSONObject) (obj)).optString("id");
                } else
                if (((JSONObject) (obj)).has("url"))
                {
                    obj = ((JSONObject) (obj)).optString("url");
                } else
                {
                    if (!((JSONObject) (obj)).has("fbsdk:create_object"))
                    {
                        break label0;
                    }
                    obj = ((JSONObject) (obj)).toString();
                }
            } while (true);
            if (org/json/JSONArray.isAssignableFrom(((Class) (obj2))))
            {
                obj = (JSONArray)obj1;
                int j = ((JSONArray) (obj)).length();
                for (int i = 0; i < j; i++)
                {
                    processGraphObjectProperty(String.format("%s[%d]", new Object[] {
                        s, Integer.valueOf(i)
                    }), ((JSONArray) (obj)).opt(i), keyvalueserializer, flag);
                }

            } else
            if (java/lang/String.isAssignableFrom(((Class) (obj2))) || java/lang/Number.isAssignableFrom(((Class) (obj2))) || java/lang/Boolean.isAssignableFrom(((Class) (obj2))))
            {
                keyvalueserializer.writeString(s, obj1.toString());
            } else
            if (java/util/Date.isAssignableFrom(((Class) (obj2))))
            {
                obj = (Date)obj1;
                keyvalueserializer.writeString(s, (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(((Date) (obj))));
                return;
            }
        }
    }

    private static void processRequest(RequestBatch requestbatch, Logger logger, int i, URL url, OutputStream outputstream)
    {
        outputstream = new Serializer(outputstream, logger);
        if (i == 1)
        {
            requestbatch = requestbatch.get(0);
            HashMap hashmap = new HashMap();
            Iterator iterator = ((Request) (requestbatch)).parameters.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                Object obj = ((Request) (requestbatch)).parameters.get(s);
                if (isSupportedAttachmentType(obj))
                {
                    hashmap.put(s, requestbatch. new Attachment(obj));
                }
            } while (true);
            if (logger != null)
            {
                logger.append("  Parameters:\n");
            }
            serializeParameters(((Request) (requestbatch)).parameters, outputstream, requestbatch);
            if (logger != null)
            {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashmap, outputstream);
            if (((Request) (requestbatch)).graphObject != null)
            {
                processGraphObject(((Request) (requestbatch)).graphObject, url.getPath(), outputstream);
            }
            return;
        }
        url = getBatchAppId(requestbatch);
        if (Utility.isNullOrEmpty(url))
        {
            throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
        }
        outputstream.writeString("batch_app_id", url);
        url = new HashMap();
        serializeRequestsAsJSON(outputstream, requestbatch, url);
        if (logger != null)
        {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(url, outputstream);
    }

    static void runCallbacks(final RequestBatch requests, List list)
    {
label0:
        {
            int j = requests.size();
            final ArrayList callbacks = new ArrayList();
            for (int i = 0; i < j; i++)
            {
                Request request = requests.get(i);
                if (request.callback != null)
                {
                    callbacks.add(new Pair(request.callback, list.get(i)));
                }
            }

            if (callbacks.size() > 0)
            {
                list = new _cls4();
                requests = requests.getCallbackHandler();
                if (requests != null)
                {
                    break label0;
                }
                list.run();
            }
            return;
        }
        requests.post(list);
    }

    private static void serializeAttachments(Map map, Serializer serializer)
    {
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Attachment attachment = (Attachment)map.get(s);
            if (isSupportedAttachmentType(attachment.getValue()))
            {
                serializer.writeObject(s, attachment.getValue(), attachment.getRequest());
            }
        } while (true);
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer, Request request)
    {
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (isSupportedParameterType(obj))
            {
                serializer.writeObject(s, obj, request);
            }
        } while (true);
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection collection, Map map)
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ((Request)iterator.next()).serializeToBatch(jsonarray, map)) { }
        serializer.writeRequestsAsJson("batch", jsonarray, collection);
    }

    private void serializeToBatch(JSONArray jsonarray, final Map keysAndValues)
    {
        JSONObject jsonobject = new JSONObject();
        if (batchEntryName != null)
        {
            jsonobject.put("name", batchEntryName);
            jsonobject.put("omit_response_on_success", batchEntryOmitResultOnSuccess);
        }
        if (batchEntryDependsOn != null)
        {
            jsonobject.put("depends_on", batchEntryDependsOn);
        }
        String s = getUrlForBatchedRequest();
        jsonobject.put("relative_url", s);
        jsonobject.put("method", httpMethod);
        if (session != null)
        {
            Logger.registerAccessToken(session.getAccessToken());
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = parameters.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            obj = parameters.get(((String) (obj)));
            if (isSupportedAttachmentType(obj))
            {
                String s1 = String.format("%s%d", new Object[] {
                    "file", Integer.valueOf(keysAndValues.size())
                });
                arraylist.add(s1);
                keysAndValues.put(s1, new Attachment(obj));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            jsonobject.put("attached_files", TextUtils.join(",", arraylist));
        }
        if (graphObject != null)
        {
            keysAndValues = new ArrayList();
            processGraphObject(graphObject, s, new _cls5());
            jsonobject.put("body", TextUtils.join("&", keysAndValues));
        }
        jsonarray.put(jsonobject);
    }

    static final void serializeToUrlConnection(RequestBatch requestbatch, HttpURLConnection httpurlconnection)
    {
        Logger logger;
        URL url;
        int j;
        logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        j = requestbatch.size();
        HttpMethod httpmethod;
        boolean flag;
        if (j == 1)
        {
            httpmethod = requestbatch.get(0).httpMethod;
        } else
        {
            httpmethod = HttpMethod.POST;
        }
        httpurlconnection.setRequestMethod(httpmethod.name());
        url = httpurlconnection.getURL();
        logger.append("Request:\n");
        logger.appendKeyValue("Id", requestbatch.getId());
        logger.appendKeyValue("URL", url);
        logger.appendKeyValue("Method", httpurlconnection.getRequestMethod());
        logger.appendKeyValue("User-Agent", httpurlconnection.getRequestProperty("User-Agent"));
        logger.appendKeyValue("Content-Type", httpurlconnection.getRequestProperty("Content-Type"));
        httpurlconnection.setConnectTimeout(requestbatch.getTimeout());
        httpurlconnection.setReadTimeout(requestbatch.getTimeout());
        if (httpmethod == HttpMethod.POST)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            logger.log();
            return;
        }
        httpurlconnection.setDoOutput(true);
        if (!hasOnProgressCallbacks(requestbatch))
        {
            break MISSING_BLOCK_LABEL_248;
        }
        Object obj = new ProgressNoopOutputStream(requestbatch.getCallbackHandler());
        processRequest(requestbatch, null, j, url, ((OutputStream) (obj)));
        int i = ((ProgressNoopOutputStream) (obj)).getMaxProgress();
        obj = ((ProgressNoopOutputStream) (obj)).getProgressMap();
        httpurlconnection = new ProgressOutputStream(new BufferedOutputStream(httpurlconnection.getOutputStream()), requestbatch, ((Map) (obj)), i);
_L1:
        processRequest(requestbatch, logger, j, url, httpurlconnection);
        httpurlconnection.close();
        logger.log();
        return;
        httpurlconnection = new BufferedOutputStream(httpurlconnection.getOutputStream());
          goto _L1
        requestbatch;
        httpurlconnection = null;
_L3:
        if (httpurlconnection != null)
        {
            httpurlconnection.close();
        }
        throw requestbatch;
        requestbatch;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static final void setDefaultBatchApplicationId(String s)
    {
        defaultBatchApplicationId = s;
    }

    public static HttpURLConnection toHttpConnection(RequestBatch requestbatch)
    {
        Object obj;
        if (requestbatch.size() != 1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new URL(requestbatch.get(0).getUrlForSingleRequest());
_L1:
        try
        {
            obj = createConnection(((URL) (obj)));
            serializeToUrlConnection(requestbatch, ((HttpURLConnection) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (RequestBatch requestbatch)
        {
            throw new FacebookException("could not construct request body", requestbatch);
        }
        // Misplaced declaration of an exception variable
        catch (RequestBatch requestbatch)
        {
            throw new FacebookException("could not construct request body", requestbatch);
        }
        return ((HttpURLConnection) (obj));
        try
        {
            obj = new URL(ServerProtocol.getGraphUrlBase());
        }
        // Misplaced declaration of an exception variable
        catch (RequestBatch requestbatch)
        {
            throw new FacebookException("could not construct URL for request", requestbatch);
        }
          goto _L1
    }

    public static HttpURLConnection toHttpConnection(Collection collection)
    {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new RequestBatch(collection));
    }

    public static transient HttpURLConnection toHttpConnection(Request arequest[])
    {
        return toHttpConnection(((Collection) (Arrays.asList(arequest))));
    }

    private static List typedListFromResponse(Response response, Class class1)
    {
        response = (GraphMultiResult)response.getGraphObjectAs(com/facebook/model/GraphMultiResult);
        if (response == null)
        {
            return null;
        }
        response = response.getData();
        if (response == null)
        {
            return null;
        } else
        {
            return response.castToListOf(class1);
        }
    }

    public final Response executeAndWait()
    {
        return executeAndWait(this);
    }

    public final RequestAsyncTask executeAsync()
    {
        return executeBatchAsync(new Request[] {
            this
        });
    }

    public final String getBatchEntryDependsOn()
    {
        return batchEntryDependsOn;
    }

    public final String getBatchEntryName()
    {
        return batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess()
    {
        return batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback()
    {
        return callback;
    }

    public final GraphObject getGraphObject()
    {
        return graphObject;
    }

    public final String getGraphPath()
    {
        return graphPath;
    }

    public final HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    public final Bundle getParameters()
    {
        return parameters;
    }

    public final Session getSession()
    {
        return session;
    }

    public final Object getTag()
    {
        return tag;
    }

    final String getUrlForBatchedRequest()
    {
        if (overriddenURL != null)
        {
            throw new FacebookException("Can't override URL for a batch request");
        } else
        {
            String s = getGraphPathWithVersion();
            addCommonParameters();
            return appendParametersToBaseUrl(s);
        }
    }

    final String getUrlForSingleRequest()
    {
        if (overriddenURL != null)
        {
            return overriddenURL.toString();
        }
        String s;
        if (getHttpMethod() == HttpMethod.POST && graphPath != null && graphPath.endsWith("/videos"))
        {
            s = ServerProtocol.getGraphVideoUrlBase();
        } else
        {
            s = ServerProtocol.getGraphUrlBase();
        }
        s = String.format("%s/%s", new Object[] {
            s, getGraphPathWithVersion()
        });
        addCommonParameters();
        return appendParametersToBaseUrl(s);
    }

    public final String getVersion()
    {
        return version;
    }

    public final void setBatchEntryDependsOn(String s)
    {
        batchEntryDependsOn = s;
    }

    public final void setBatchEntryName(String s)
    {
        batchEntryName = s;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean flag)
    {
        batchEntryOmitResultOnSuccess = flag;
    }

    public final void setCallback(Callback callback1)
    {
        callback = callback1;
    }

    public final void setGraphObject(GraphObject graphobject)
    {
        graphObject = graphobject;
    }

    public final void setGraphPath(String s)
    {
        graphPath = s;
    }

    public final void setHttpMethod(HttpMethod httpmethod)
    {
        if (overriddenURL != null && httpmethod != HttpMethod.GET)
        {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpmethod == null)
        {
            httpmethod = HttpMethod.GET;
        }
        httpMethod = httpmethod;
    }

    public final void setParameters(Bundle bundle)
    {
        parameters = bundle;
    }

    public final void setSession(Session session1)
    {
        session = session1;
    }

    public final void setSkipClientToken(boolean flag)
    {
        skipClientToken = flag;
    }

    public final void setTag(Object obj)
    {
        tag = obj;
    }

    public final void setVersion(String s)
    {
        version = s;
    }

    public String toString()
    {
        return (new StringBuilder("{Request:  session: ")).append(session).append(", graphPath: ").append(graphPath).append(", graphObject: ").append(graphObject).append(", httpMethod: ").append(httpMethod).append(", parameters: ").append(parameters).append("}").toString();
    }





    private class OnProgressCallback
        implements Callback
    {

        public abstract void onProgress(long l, long l1);
    }


    private class ParcelFileDescriptorWithMimeType
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private final ParcelFileDescriptor fileDescriptor;
        private final String mimeType;

        public int describeContents()
        {
            return 1;
        }

        public ParcelFileDescriptor getFileDescriptor()
        {
            return fileDescriptor;
        }

        public String getMimeType()
        {
            return mimeType;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mimeType);
            parcel.writeFileDescriptor(fileDescriptor.getFileDescriptor());
        }


        private ParcelFileDescriptorWithMimeType(Parcel parcel)
        {
            mimeType = parcel.readString();
            fileDescriptor = parcel.readFileDescriptor();
        }

        ParcelFileDescriptorWithMimeType(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        public ParcelFileDescriptorWithMimeType(ParcelFileDescriptor parcelfiledescriptor, String s)
        {
            mimeType = s;
            fileDescriptor = parcelfiledescriptor;
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final ParcelFileDescriptorWithMimeType createFromParcel(Parcel parcel)
            {
                return new ParcelFileDescriptorWithMimeType(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final ParcelFileDescriptorWithMimeType[] newArray(int i)
            {
                return new ParcelFileDescriptorWithMimeType[i];
            }

            public final volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

                _cls1()
                {
                }
        }

    }


    private class _cls1
        implements Callback
    {

        final GraphUserCallback val$callback;

        public final void onCompleted(Response response)
        {
            if (callback != null)
            {
                callback.onCompleted((GraphUser)response.getGraphObjectAs(com/facebook/model/GraphUser), response);
            }
        }

        _cls1()
        {
            callback = graphusercallback;
            super();
        }

        private class GraphUserCallback
        {

            public abstract void onCompleted(GraphUser graphuser, Response response);
        }

    }


    private class _cls2
        implements Callback
    {

        final GraphUserListCallback val$callback;

        public final void onCompleted(Response response)
        {
            if (callback != null)
            {
                callback.onCompleted(Request.typedListFromResponse(response, com/facebook/model/GraphUser), response);
            }
        }

        _cls2()
        {
            callback = graphuserlistcallback;
            super();
        }

        private class GraphUserListCallback
        {

            public abstract void onCompleted(List list, Response response);
        }

    }


    private class _cls3
        implements Callback
    {

        final GraphPlaceListCallback val$callback;

        public final void onCompleted(Response response)
        {
            if (callback != null)
            {
                callback.onCompleted(Request.typedListFromResponse(response, com/facebook/model/GraphPlace), response);
            }
        }

        _cls3()
        {
            callback = graphplacelistcallback;
            super();
        }

        private class GraphPlaceListCallback
        {

            public abstract void onCompleted(List list, Response response);
        }

    }


    private class KeyValueSerializer
    {

        public abstract void writeString(String s, String s1);
    }


    private class Serializer
        implements KeyValueSerializer
    {

        private boolean firstWrite;
        private final Logger logger;
        private final OutputStream outputStream;

        public transient void write(String s, Object aobj[])
        {
            if (firstWrite)
            {
                outputStream.write("--".getBytes());
                outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                outputStream.write("\r\n".getBytes());
                firstWrite = false;
            }
            outputStream.write(String.format(s, aobj).getBytes());
        }

        public void writeBitmap(String s, Bitmap bitmap)
        {
            writeContentDisposition(s, s, "image/png");
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (logger != null)
            {
                logger.appendKeyValue((new StringBuilder("    ")).append(s).toString(), "<Image>");
            }
        }

        public void writeBytes(String s, byte abyte0[])
        {
            writeContentDisposition(s, s, "content/unknown");
            outputStream.write(abyte0);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (logger != null)
            {
                logger.appendKeyValue((new StringBuilder("    ")).append(s).toString(), String.format("<Data: %d>", new Object[] {
                    Integer.valueOf(abyte0.length)
                }));
            }
        }

        public void writeContentDisposition(String s, String s1, String s2)
        {
            write("Content-Disposition: form-data; name=\"%s\"", new Object[] {
                s
            });
            if (s1 != null)
            {
                write("; filename=\"%s\"", new Object[] {
                    s1
                });
            }
            writeLine("", new Object[0]);
            if (s2 != null)
            {
                writeLine("%s: %s", new Object[] {
                    "Content-Type", s2
                });
            }
            writeLine("", new Object[0]);
        }

        public void writeFile(String s, ParcelFileDescriptor parcelfiledescriptor, String s1)
        {
            Object obj1;
            obj1 = null;
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "content/unknown";
            }
            writeContentDisposition(s, s, s2);
            if (!(outputStream instanceof ProgressNoopOutputStream)) goto _L2; else goto _L1
_L1:
            int i;
            ((ProgressNoopOutputStream)outputStream).addProgress(parcelfiledescriptor.getStatSize());
            i = 0;
_L6:
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (logger != null)
            {
                logger.appendKeyValue((new StringBuilder("    ")).append(s).toString(), String.format("<Data: %d>", new Object[] {
                    Integer.valueOf(i)
                }));
            }
            return;
_L2:
            parcelfiledescriptor = new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelfiledescriptor);
            s1 = new BufferedInputStream(parcelfiledescriptor);
            byte abyte0[] = new byte[8192];
            i = 0;
_L4:
            int j = s1.read(abyte0);
            if (j == -1)
            {
                break; /* Loop/switch isn't completed */
            }
            outputStream.write(abyte0, 0, j);
            i += j;
            if (true) goto _L4; else goto _L3
_L3:
            s1.close();
            parcelfiledescriptor.close();
            if (true) goto _L6; else goto _L5
_L5:
            s;
            parcelfiledescriptor = null;
            s1 = obj1;
_L8:
            if (parcelfiledescriptor != null)
            {
                parcelfiledescriptor.close();
            }
            if (s1 != null)
            {
                s1.close();
            }
            throw s;
            s;
            Object obj = null;
            s1 = parcelfiledescriptor;
            parcelfiledescriptor = obj;
            continue; /* Loop/switch isn't completed */
            s;
            ParcelFileDescriptor parcelfiledescriptor1 = parcelfiledescriptor;
            parcelfiledescriptor = s1;
            s1 = parcelfiledescriptor1;
            if (true) goto _L8; else goto _L7
_L7:
        }

        public void writeFile(String s, ParcelFileDescriptorWithMimeType parcelfiledescriptorwithmimetype)
        {
            writeFile(s, parcelfiledescriptorwithmimetype.getFileDescriptor(), parcelfiledescriptorwithmimetype.getMimeType());
        }

        public transient void writeLine(String s, Object aobj[])
        {
            write(s, aobj);
            write("\r\n", new Object[0]);
        }

        public void writeObject(String s, Object obj, Request request)
        {
            if (outputStream instanceof RequestOutputStream)
            {
                ((RequestOutputStream)outputStream).setCurrentRequest(request);
            }
            if (Request.isSupportedParameterType(obj))
            {
                writeString(s, Request.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap)
            {
                writeBitmap(s, (Bitmap)obj);
                return;
            }
            if (obj instanceof byte[])
            {
                writeBytes(s, (byte[])obj);
                return;
            }
            if (obj instanceof ParcelFileDescriptor)
            {
                writeFile(s, (ParcelFileDescriptor)obj, null);
                return;
            }
            if (obj instanceof ParcelFileDescriptorWithMimeType)
            {
                writeFile(s, (ParcelFileDescriptorWithMimeType)obj);
                return;
            } else
            {
                throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
            }
        }

        public void writeRecordBoundary()
        {
            writeLine("--%s", new Object[] {
                "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
            });
        }

        public void writeRequestsAsJson(String s, JSONArray jsonarray, Collection collection)
        {
            if (!(outputStream instanceof RequestOutputStream))
            {
                writeString(s, jsonarray.toString());
            } else
            {
                RequestOutputStream requestoutputstream = (RequestOutputStream)outputStream;
                writeContentDisposition(s, null, null);
                write("[", new Object[0]);
                collection = collection.iterator();
                int i = 0;
                while (collection.hasNext()) 
                {
                    Request request = (Request)collection.next();
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    requestoutputstream.setCurrentRequest(request);
                    if (i > 0)
                    {
                        write(",%s", new Object[] {
                            jsonobject.toString()
                        });
                    } else
                    {
                        write("%s", new Object[] {
                            jsonobject.toString()
                        });
                    }
                    i++;
                }
                write("]", new Object[0]);
                if (logger != null)
                {
                    logger.appendKeyValue((new StringBuilder("    ")).append(s).toString(), jsonarray.toString());
                    return;
                }
            }
        }

        public void writeString(String s, String s1)
        {
            writeContentDisposition(s, null, null);
            writeLine("%s", new Object[] {
                s1
            });
            writeRecordBoundary();
            if (logger != null)
            {
                logger.appendKeyValue((new StringBuilder("    ")).append(s).toString(), s1);
            }
        }

        public Serializer(OutputStream outputstream, Logger logger1)
        {
            firstWrite = true;
            outputStream = outputstream;
            logger = logger1;
        }
    }


    private class Attachment
    {

        private final Request request;
        private final Object value;

        public Request getRequest()
        {
            return request;
        }

        public Object getValue()
        {
            return value;
        }

        public Attachment(Object obj)
        {
            request = Request.this;
            value = obj;
        }
    }


    private class _cls4
        implements Runnable
    {

        final ArrayList val$callbacks;
        final RequestBatch val$requests;

        public final void run()
        {
            Pair pair;
            for (Iterator iterator = callbacks.iterator(); iterator.hasNext(); ((Callback)pair.first).onCompleted((Response)pair.second))
            {
                pair = (Pair)iterator.next();
            }

            for (Iterator iterator1 = requests.getCallbacks().iterator(); iterator1.hasNext(); ((RequestBatch.Callback)iterator1.next()).onBatchCompleted(requests)) { }
        }

        _cls4()
        {
            callbacks = arraylist;
            requests = requestbatch;
            super();
        }

        private class Callback
        {

            public abstract void onCompleted(Response response);
        }

    }


    private class _cls5
        implements KeyValueSerializer
    {

        final Request this$0;
        final ArrayList val$keysAndValues;

        public void writeString(String s, String s1)
        {
            keysAndValues.add(String.format("%s=%s", new Object[] {
                s, URLEncoder.encode(s1, "UTF-8")
            }));
        }

        _cls5()
        {
            this$0 = Request.this;
            keysAndValues = arraylist;
            super();
        }
    }

}
