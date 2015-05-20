// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.model.GraphUser;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.facebook.widget:
//            ToolTipPopup

public class LoginButton extends Button
{

    private static final String TAG = com/facebook/widget/LoginButton.getName();
    private String applicationId;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private android.view.View.OnClickListener listenerCallback;
    private String loginLogoutEventName;
    private String loginText;
    private String logoutText;
    private boolean nuxChecked;
    private long nuxDisplayTime;
    private ToolTipMode nuxMode;
    private ToolTipPopup nuxPopup;
    private ToolTipPopup.Style nuxStyle;
    private Fragment parentFragment;
    private LoginButtonProperties properties;
    private SessionTracker sessionTracker;
    private GraphUser user;
    private UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession;

    public LoginButton(Context context)
    {
        super(context);
        applicationId = null;
        user = null;
        userInfoSession = null;
        properties = new LoginButtonProperties();
        loginLogoutEventName = "fb_login_view_usage";
        nuxStyle = ToolTipPopup.Style.BLUE;
        nuxMode = ToolTipMode.DEFAULT;
        nuxDisplayTime = 6000L;
        initializeActiveSessionWithCachedToken(context);
        finishInit();
    }

    public LoginButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        applicationId = null;
        user = null;
        userInfoSession = null;
        properties = new LoginButtonProperties();
        loginLogoutEventName = "fb_login_view_usage";
        nuxStyle = ToolTipPopup.Style.BLUE;
        nuxMode = ToolTipMode.DEFAULT;
        nuxDisplayTime = 6000L;
        if (attributeset.getStyleAttribute() == 0)
        {
            setGravity(17);
            setTextColor(getResources().getColor(com.facebook.android.R.color.com_facebook_loginview_text_color));
            setTextSize(0, getResources().getDimension(com.facebook.android.R.dimen.com_facebook_loginview_text_size));
            setTypeface(Typeface.DEFAULT_BOLD);
            if (isInEditMode())
            {
                setBackgroundColor(getResources().getColor(com.facebook.android.R.color.com_facebook_blue));
                loginText = "Log in with Facebook";
            } else
            {
                setBackgroundResource(com.facebook.android.R.drawable.com_facebook_button_blue);
                setCompoundDrawablesWithIntrinsicBounds(com.facebook.android.R.drawable.com_facebook_inverse_icon, 0, 0, 0);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_compound_drawable_padding));
                setPadding(getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_left), getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_top), getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_right), getResources().getDimensionPixelSize(com.facebook.android.R.dimen.com_facebook_loginview_padding_bottom));
            }
        }
        parseAttributes(attributeset);
        if (!isInEditMode())
        {
            initializeActiveSessionWithCachedToken(context);
        }
    }

    public LoginButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        applicationId = null;
        user = null;
        userInfoSession = null;
        properties = new LoginButtonProperties();
        loginLogoutEventName = "fb_login_view_usage";
        nuxStyle = ToolTipPopup.Style.BLUE;
        nuxMode = ToolTipMode.DEFAULT;
        nuxDisplayTime = 6000L;
        parseAttributes(attributeset);
        initializeActiveSessionWithCachedToken(context);
    }

    private void checkNuxSettings()
    {
        if (nuxMode == ToolTipMode.DISPLAY_ALWAYS)
        {
            displayNux(getResources().getString(com.facebook.android.R.string.com_facebook_tooltip_default));
            return;
        } else
        {
            (new _cls1()).execute(null);
            return;
        }
    }

    private void displayNux(String s)
    {
        nuxPopup = new ToolTipPopup(s, this);
        nuxPopup.setStyle(nuxStyle);
        nuxPopup.setNuxDisplayTime(nuxDisplayTime);
        nuxPopup.show();
    }

    private void fetchUserInfo()
    {
        if (fetchUserInfo)
        {
            final Session currentSession = sessionTracker.getOpenSession();
            if (currentSession != null)
            {
                if (currentSession != userInfoSession)
                {
                    Request.executeBatchAsync(new Request[] {
                        Request.newMeRequest(currentSession, new _cls2())
                    });
                    userInfoSession = currentSession;
                }
            } else
            {
                user = null;
                if (userInfoChangedCallback != null)
                {
                    userInfoChangedCallback.onUserInfoFetched(user);
                    return;
                }
            }
        }
    }

    private void finishInit()
    {
        super.setOnClickListener(new LoginClickListener(null));
        setButtonText();
        if (!isInEditMode())
        {
            sessionTracker = new SessionTracker(getContext(), new LoginButtonCallback(null), null, false);
            fetchUserInfo();
        }
    }

    private boolean initializeActiveSessionWithCachedToken(Context context)
    {
        if (context != null)
        {
            Session session = Session.getActiveSession();
            if (session != null)
            {
                return session.isOpened();
            }
            if (Utility.getMetadataApplicationId(context) != null && Session.openActiveSessionFromCache(context) != null)
            {
                return true;
            }
        }
        return false;
    }

    private void parseAttributes(AttributeSet attributeset)
    {
        attributeset = getContext().obtainStyledAttributes(attributeset, com.facebook.android.R.styleable.com_facebook_login_view);
        confirmLogout = attributeset.getBoolean(com.facebook.android.R.styleable.com_facebook_login_view_confirm_logout, true);
        fetchUserInfo = attributeset.getBoolean(com.facebook.android.R.styleable.com_facebook_login_view_fetch_user_info, true);
        loginText = attributeset.getString(com.facebook.android.R.styleable.com_facebook_login_view_login_text);
        logoutText = attributeset.getString(com.facebook.android.R.styleable.com_facebook_login_view_logout_text);
        attributeset.recycle();
    }

    private void setButtonText()
    {
        if (sessionTracker != null && sessionTracker.getOpenSession() != null)
        {
            String s;
            if (logoutText != null)
            {
                s = logoutText;
            } else
            {
                s = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_log_out_button);
            }
            setText(s);
            return;
        }
        String s1;
        if (loginText != null)
        {
            s1 = loginText;
        } else
        {
            s1 = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_log_in_button);
        }
        setText(s1);
    }

    private void showNuxPerSettings(com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings)
    {
        if (fetchedappsettings != null && fetchedappsettings.getNuxEnabled() && getVisibility() == 0)
        {
            displayNux(fetchedappsettings.getNuxContent());
        }
    }

    public void clearPermissions()
    {
        properties.clearPermissions();
    }

    public void dismissToolTip()
    {
        if (nuxPopup != null)
        {
            nuxPopup.dismiss();
            nuxPopup = null;
        }
    }

    public SessionDefaultAudience getDefaultAudience()
    {
        return properties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior()
    {
        return properties.getLoginBehavior();
    }

    public OnErrorListener getOnErrorListener()
    {
        return properties.getOnErrorListener();
    }

    List getPermissions()
    {
        return properties.getPermissions();
    }

    public com.facebook.Session.StatusCallback getSessionStatusCallback()
    {
        return properties.getSessionStatusCallback();
    }

    public long getToolTipDisplayTime()
    {
        return nuxDisplayTime;
    }

    public ToolTipMode getToolTipMode()
    {
        return nuxMode;
    }

    public UserInfoChangedCallback getUserInfoChangedCallback()
    {
        return userInfoChangedCallback;
    }

    void handleError(Exception exception)
    {
label0:
        {
            if (properties.onErrorListener != null)
            {
                if (!(exception instanceof FacebookException))
                {
                    break label0;
                }
                properties.onErrorListener.onError((FacebookException)exception);
            }
            return;
        }
        properties.onErrorListener.onError(new FacebookException(exception));
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        Session session = sessionTracker.getSession();
        if (session != null)
        {
            return session.onActivityResult((Activity)getContext(), i, j, intent);
        } else
        {
            return false;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (sessionTracker != null && !sessionTracker.isTracking())
        {
            sessionTracker.startTracking();
            fetchUserInfo();
            setButtonText();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (sessionTracker != null)
        {
            sessionTracker.stopTracking();
        }
        dismissToolTip();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!nuxChecked && nuxMode != ToolTipMode.NEVER_DISPLAY && !isInEditMode())
        {
            nuxChecked = true;
            checkNuxSettings();
        }
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        finishInit();
    }

    protected void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        if (i != 0)
        {
            dismissToolTip();
        }
    }

    public void setApplicationId(String s)
    {
        applicationId = s;
    }

    public void setDefaultAudience(SessionDefaultAudience sessiondefaultaudience)
    {
        properties.setDefaultAudience(sessiondefaultaudience);
    }

    public void setFragment(Fragment fragment)
    {
        parentFragment = fragment;
    }

    public void setLoginBehavior(SessionLoginBehavior sessionloginbehavior)
    {
        properties.setLoginBehavior(sessionloginbehavior);
    }

    void setLoginLogoutEventName(String s)
    {
        loginLogoutEventName = s;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        listenerCallback = onclicklistener;
    }

    public void setOnErrorListener(OnErrorListener onerrorlistener)
    {
        properties.setOnErrorListener(onerrorlistener);
    }

    void setProperties(LoginButtonProperties loginbuttonproperties)
    {
        properties = loginbuttonproperties;
    }

    public void setPublishPermissions(List list)
    {
        properties.setPublishPermissions(list, sessionTracker.getSession());
    }

    public transient void setPublishPermissions(String as[])
    {
        properties.setPublishPermissions(Arrays.asList(as), sessionTracker.getSession());
    }

    public void setReadPermissions(List list)
    {
        properties.setReadPermissions(list, sessionTracker.getSession());
    }

    public transient void setReadPermissions(String as[])
    {
        properties.setReadPermissions(Arrays.asList(as), sessionTracker.getSession());
    }

    public void setSession(Session session)
    {
        sessionTracker.setSession(session);
        fetchUserInfo();
        setButtonText();
    }

    public void setSessionStatusCallback(com.facebook.Session.StatusCallback statuscallback)
    {
        properties.setSessionStatusCallback(statuscallback);
    }

    public void setToolTipDisplayTime(long l)
    {
        nuxDisplayTime = l;
    }

    public void setToolTipMode(ToolTipMode tooltipmode)
    {
        nuxMode = tooltipmode;
    }

    public void setToolTipStyle(ToolTipPopup.Style style)
    {
        nuxStyle = style;
    }

    public void setUserInfoChangedCallback(UserInfoChangedCallback userinfochangedcallback)
    {
        userInfoChangedCallback = userinfochangedcallback;
    }












/*
    static GraphUser access$502(LoginButton loginbutton, GraphUser graphuser)
    {
        loginbutton.user = graphuser;
        return graphuser;
    }

*/





    private class LoginButtonProperties
    {

        private SessionAuthorizationType authorizationType;
        private SessionDefaultAudience defaultAudience;
        private SessionLoginBehavior loginBehavior;
        private OnErrorListener onErrorListener;
        private List permissions;
        private com.facebook.Session.StatusCallback sessionStatusCallback;

        private boolean validatePermissions(List list, SessionAuthorizationType sessionauthorizationtype, Session session)
        {
            if (SessionAuthorizationType.PUBLISH.equals(sessionauthorizationtype) && Utility.isNullOrEmpty(list))
            {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            if (session != null && session.isOpened() && !Utility.isSubset(list, session.getPermissions()))
            {
                Log.e(LoginButton.TAG, "Cannot set additional permissions when session is already open.");
                return false;
            } else
            {
                return true;
            }
        }

        public void clearPermissions()
        {
            permissions = null;
            authorizationType = null;
        }

        public SessionDefaultAudience getDefaultAudience()
        {
            return defaultAudience;
        }

        public SessionLoginBehavior getLoginBehavior()
        {
            return loginBehavior;
        }

        public OnErrorListener getOnErrorListener()
        {
            return onErrorListener;
        }

        List getPermissions()
        {
            return permissions;
        }

        public com.facebook.Session.StatusCallback getSessionStatusCallback()
        {
            return sessionStatusCallback;
        }

        public void setDefaultAudience(SessionDefaultAudience sessiondefaultaudience)
        {
            defaultAudience = sessiondefaultaudience;
        }

        public void setLoginBehavior(SessionLoginBehavior sessionloginbehavior)
        {
            loginBehavior = sessionloginbehavior;
        }

        public void setOnErrorListener(OnErrorListener onerrorlistener)
        {
            onErrorListener = onerrorlistener;
        }

        public void setPublishPermissions(List list, Session session)
        {
            if (SessionAuthorizationType.READ.equals(authorizationType))
            {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (validatePermissions(list, SessionAuthorizationType.PUBLISH, session))
            {
                permissions = list;
                authorizationType = SessionAuthorizationType.PUBLISH;
            }
        }

        public void setReadPermissions(List list, Session session)
        {
            if (SessionAuthorizationType.PUBLISH.equals(authorizationType))
            {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            if (validatePermissions(list, SessionAuthorizationType.READ, session))
            {
                permissions = list;
                authorizationType = SessionAuthorizationType.READ;
            }
        }

        public void setSessionStatusCallback(com.facebook.Session.StatusCallback statuscallback)
        {
            sessionStatusCallback = statuscallback;
        }







        LoginButtonProperties()
        {
            defaultAudience = SessionDefaultAudience.FRIENDS;
            permissions = Collections.emptyList();
            authorizationType = null;
            loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
        }
    }


    private class ToolTipMode extends Enum
    {

        private static final ToolTipMode $VALUES[];
        public static final ToolTipMode DEFAULT;
        public static final ToolTipMode DISPLAY_ALWAYS;
        public static final ToolTipMode NEVER_DISPLAY;

        public static ToolTipMode valueOf(String s)
        {
            return (ToolTipMode)Enum.valueOf(com/facebook/widget/LoginButton$ToolTipMode, s);
        }

        public static ToolTipMode[] values()
        {
            return (ToolTipMode[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new ToolTipMode("DEFAULT", 0);
            DISPLAY_ALWAYS = new ToolTipMode("DISPLAY_ALWAYS", 1);
            NEVER_DISPLAY = new ToolTipMode("NEVER_DISPLAY", 2);
            $VALUES = (new ToolTipMode[] {
                DEFAULT, DISPLAY_ALWAYS, NEVER_DISPLAY
            });
        }

        private ToolTipMode(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1 extends AsyncTask
    {

        final LoginButton this$0;
        final String val$appId;

        protected transient com.facebook.internal.Utility.FetchedAppSettings doInBackground(Void avoid[])
        {
            return Utility.queryAppSettings(appId, false);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings)
        {
            showNuxPerSettings(fetchedappsettings);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((com.facebook.internal.Utility.FetchedAppSettings)obj);
        }

        _cls1()
        {
            this$0 = LoginButton.this;
            appId = s;
            super();
        }
    }


    private class _cls2
        implements com.facebook.Request.GraphUserCallback
    {

        final LoginButton this$0;
        final Session val$currentSession;

        public void onCompleted(GraphUser graphuser, Response response)
        {
            if (currentSession == sessionTracker.getOpenSession())
            {
                user = graphuser;
                if (userInfoChangedCallback != null)
                {
                    userInfoChangedCallback.onUserInfoFetched(user);
                }
            }
            if (response.getError() != null)
            {
                handleError(response.getError().getException());
            }
        }

        _cls2()
        {
            this$0 = LoginButton.this;
            currentSession = session;
            super();
        }
    }


    private class UserInfoChangedCallback
    {

        public abstract void onUserInfoFetched(GraphUser graphuser);
    }


    private class LoginClickListener
        implements android.view.View.OnClickListener
    {

        final LoginButton this$0;

        public void onClick(View view)
        {
            final Session openSession;
            Object obj3;
            obj3 = getContext();
            openSession = sessionTracker.getOpenSession();
            if (openSession == null) goto _L2; else goto _L1
_L1:
            int i;
            if (confirmLogout)
            {
                Object obj2 = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_log_out_action);
                String s = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_cancel_action);
                class _cls1
                    implements android.content.DialogInterface.OnClickListener
                {

                    final LoginClickListener this$1;
                    final Session val$openSession;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        openSession.closeAndClearTokenInformation();
                    }

                _cls1()
                {
                    this$1 = LoginClickListener.this;
                    openSession = session;
                    super();
                }
                }

                Object obj;
                if (user != null && user.getName() != null)
                {
                    obj = String.format(getResources().getString(com.facebook.android.R.string.com_facebook_loginview_logged_in_as), new Object[] {
                        user.getName()
                    });
                } else
                {
                    obj = getResources().getString(com.facebook.android.R.string.com_facebook_loginview_logged_in_using_facebook);
                }
                obj3 = new android.app.AlertDialog.Builder(((Context) (obj3)));
                ((android.app.AlertDialog.Builder) (obj3)).setMessage(((CharSequence) (obj))).setCancelable(true).setPositiveButton(((CharSequence) (obj2)), new _cls1()).setNegativeButton(s, null);
                ((android.app.AlertDialog.Builder) (obj3)).create().show();
            } else
            {
                openSession.closeAndClearTokenInformation();
            }
_L7:
            Object obj1;
            obj = AppEventsLogger.newLogger(getContext());
            obj2 = new Bundle();
            Session session;
            if (openSession != null)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            ((Bundle) (obj2)).putInt("logging_in", i);
            ((AppEventsLogger) (obj)).logSdkEvent(loginLogoutEventName, null, ((Bundle) (obj2)));
            if (listenerCallback != null)
            {
                listenerCallback.onClick(view);
            }
            return;
_L2:
            obj1 = sessionTracker.getSession();
            if (obj1 == null) goto _L4; else goto _L3
_L3:
            session = ((Session) (obj1));
            if (!((Session) (obj1)).getState().isClosed()) goto _L5; else goto _L4
_L4:
            sessionTracker.setSession(null);
            session = (new com.facebook.Session.Builder(((Context) (obj3)))).setApplicationId(applicationId).build();
            Session.setActiveSession(session);
_L5:
            if (session.isOpened()) goto _L7; else goto _L6
_L6:
            if (parentFragment != null)
            {
                obj1 = new com.facebook.Session.OpenRequest(parentFragment);
            } else
            if (obj3 instanceof Activity)
            {
                obj1 = new com.facebook.Session.OpenRequest((Activity)obj3);
            } else
            {
label0:
                {
                    if (!(obj3 instanceof ContextWrapper))
                    {
                        break label0;
                    }
                    obj1 = ((ContextWrapper)obj3).getBaseContext();
                    if (!(obj1 instanceof Activity))
                    {
                        break label0;
                    }
                    obj1 = new com.facebook.Session.OpenRequest((Activity)obj1);
                }
            }
_L8:
            if (obj1 != null)
            {
                ((com.facebook.Session.OpenRequest) (obj1)).setDefaultAudience(properties.defaultAudience);
                ((com.facebook.Session.OpenRequest) (obj1)).setPermissions(properties.permissions);
                ((com.facebook.Session.OpenRequest) (obj1)).setLoginBehavior(properties.loginBehavior);
                if (SessionAuthorizationType.PUBLISH.equals(properties.authorizationType))
                {
                    session.openForPublish(((com.facebook.Session.OpenRequest) (obj1)));
                } else
                {
                    session.openForRead(((com.facebook.Session.OpenRequest) (obj1)));
                }
            }
              goto _L7
            obj1 = null;
              goto _L8
        }

        private LoginClickListener()
        {
            this$0 = LoginButton.this;
            super();
        }

        LoginClickListener(_cls1 _pcls1)
        {
            this();
        }
    }


    private class LoginButtonCallback
        implements com.facebook.Session.StatusCallback
    {

        final LoginButton this$0;

        public void call(Session session, SessionState sessionstate, Exception exception)
        {
            fetchUserInfo();
            setButtonText();
            if (properties.sessionStatusCallback != null)
            {
                properties.sessionStatusCallback.call(session, sessionstate, exception);
            } else
            if (exception != null)
            {
                handleError(exception);
                return;
            }
        }

        private LoginButtonCallback()
        {
            this$0 = LoginButton.this;
            super();
        }

        LoginButtonCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class OnErrorListener
    {

        public abstract void onError(FacebookException facebookexception);
    }

}
