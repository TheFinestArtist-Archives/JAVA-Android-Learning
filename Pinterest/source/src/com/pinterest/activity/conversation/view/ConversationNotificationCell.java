// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.conversation.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.home.view.BaseNotificationListCell;
import com.pinterest.activity.pin.adapter.SimpleTextListAdapter;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Conversation;
import com.pinterest.api.model.ConversationMessage;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.User;
import com.pinterest.base.Colors;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.time.FuzzyDateFormatter;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.imageview.WebImageView;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.conversation.view:
//            GroupUserImageView

public class ConversationNotificationCell extends BaseNotificationListCell
{

    WebImageView _sentItemIv;
    TextView _subTitleTv;
    TextView _timeStampTv;
    TextView _titleTv;
    GroupUserImageView _userImage;

    public ConversationNotificationCell(Context context)
    {
        this(context, null, 0);
    }

    public ConversationNotificationCell(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ConversationNotificationCell(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public static ConversationNotificationCell from(View view, Context context)
    {
        if (view instanceof ConversationNotificationCell)
        {
            return (ConversationNotificationCell)view;
        } else
        {
            return (ConversationNotificationCell)ViewHelper.viewById(context, 0x7f0300d7);
        }
    }

    private String getLastMessageText(ConversationMessage conversationmessage)
    {
        Object obj1 = null;
        if (ModelHelper.isValidString(conversationmessage.getText()))
        {
            conversationmessage = conversationmessage.getText();
        } else
        {
            Object obj;
            int i;
            boolean flag;
            boolean flag1;
            if (MyUser.isUserMe(conversationmessage.getSenderId()))
            {
                obj = Resources.string(0x7f0e0514);
            } else
            {
                obj = ModelHelper.getUser(conversationmessage.getSenderId());
                if (obj != null)
                {
                    obj = ((User) (obj)).getFirstName();
                } else
                {
                    obj = null;
                }
            }
            flag1 = MyUser.isUserMe(conversationmessage.getSenderId());
            if (conversationmessage.getPinId() != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (conversationmessage.getBoardId() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag1)
            {
                if (i != 0)
                {
                    i = 0x7f0e051d;
                } else
                if (flag)
                {
                    i = 0x7f0e051c;
                } else
                {
                    i = 0x7f0e051e;
                }
                return Resources.string(i);
            }
            conversationmessage = obj1;
            if (obj != null)
            {
                if (i != 0)
                {
                    i = 0x7f0e051a;
                } else
                if (flag)
                {
                    i = 0x7f0e0519;
                } else
                {
                    i = 0x7f0e051b;
                }
                return Resources.string(i, new Object[] {
                    obj
                });
            }
        }
        return conversationmessage;
    }

    private void showReportDialog(final Conversation conversation)
    {
        Context context = getContext();
        final BaseDialog dialog = new BaseDialog();
        Object obj = new ArrayList();
        ((ArrayList) (obj)).add(context.getString(0x7f0e0262));
        if (conversation.getCachedUsers().size() != 1)
        {
            ((ArrayList) (obj)).add(context.getString(0x7f0e03ec));
            ((ArrayList) (obj)).add(context.getString(0x7f0e0059));
        }
        String as[] = (String[])((ArrayList) (obj)).toArray(new String[((ArrayList) (obj)).size()]);
        obj = new SimpleTextListAdapter(false);
        ((SimpleTextListAdapter) (obj)).setDataSource(as);
        dialog.setListViewOptions(((android.widget.ListAdapter) (obj)), new _cls2());
        Events.post(new DialogEvent(dialog));
    }

    private void updateView(final Conversation conversation, com.pinterest.activity.home.view.BaseNotificationListCell.CellPosition cellposition)
    {
        _titleTv.setText(conversation.getConversationTitle());
        _userImage.setConversation(conversation);
        Object obj = getBackground();
        if (obj instanceof ColorDrawable)
        {
            int i = ((ColorDrawable)obj).getColor();
            _userImage.setBorderColor(i);
        }
        obj = ModelHelper.getLastConversationMessage(conversation.getUid());
        int j;
        if (conversation.getUnread() != null)
        {
            j = conversation.getUnread().intValue();
        } else
        {
            j = 0;
        }
        updateBackground(cellposition, j);
        setOnClickListener(new OnCellClickListener(conversation, ((ConversationMessage) (obj))));
        setOnLongClickListener(new _cls1());
        if (obj != null)
        {
            cellposition = null;
            conversation = ((ConversationMessage) (obj)).getPinId();
            String s = ((ConversationMessage) (obj)).getBoardId();
            Object obj1 = ((ConversationMessage) (obj)).getUserId();
            if (conversation != null)
            {
                obj1 = ModelHelper.getPin(conversation);
                conversation = cellposition;
                if (obj1 != null)
                {
                    conversation = ((Pin) (obj1)).getImageMediumUrl();
                }
            } else
            if (s != null)
            {
                obj1 = ModelHelper.getBoard(s);
                conversation = cellposition;
                if (obj1 != null)
                {
                    conversation = ((Board) (obj1)).getImagePreviewUrl();
                }
            } else
            {
                conversation = cellposition;
                if (obj1 != null)
                {
                    obj1 = ModelHelper.getUser(((String) (obj1)));
                    conversation = cellposition;
                    if (obj1 != null)
                    {
                        conversation = ((User) (obj1)).getImageMediumUrl();
                    }
                }
            }
            if (StringUtils.isNotEmpty(conversation))
            {
                _sentItemIv.setVisibility(0);
                _sentItemIv.loadUrl(conversation);
            } else
            {
                _sentItemIv.setVisibility(8);
            }
            _subTitleTv.setText(getLastMessageText(((ConversationMessage) (obj))));
            conversation = ((ConversationMessage) (obj)).getSenderId();
            if (conversation != null && conversation.equals(MyUser.getUid()))
            {
                _subTitleTv.setTextColor(Colors.TEXT_LIGHT);
                _unseenMark.setVisibility(8);
            } else
            {
                _subTitleTv.setTextColor(Colors.TEXT_DARK);
            }
            _timeStampTv.setText(FuzzyDateFormatter.a(((ConversationMessage) (obj)).getCreatedAt()));
        }
    }

    public void hideUnseenMark()
    {
        _unseenMark.setVisibility(8);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        ButterKnife.a(this);
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        ButterKnife.a(this);
        _divider = findViewById(0x7f0b01fe);
        _unseenMark = findViewById(0x7f0b01f9);
    }

    public void setConversation(Conversation conversation, com.pinterest.activity.home.view.BaseNotificationListCell.CellPosition cellposition)
    {
        updateView(conversation, cellposition);
    }

    protected void updateViewState(boolean flag)
    {
        int i = getResources().getColor(0x7f090015);
        int j = getResources().getColor(0x7f090016);
        GroupUserImageView groupuserimageview;
        int k;
        if (flag)
        {
            k = i;
        } else
        {
            k = j;
        }
        setBackgroundColor(k);
        groupuserimageview = _userImage;
        if (!flag)
        {
            i = j;
        }
        groupuserimageview.setBackgroundColor(i);
    }


    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ConversationNotificationCell this$0;
        final Conversation val$conversation;
        final BaseDialog val$dialog;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            i;
            JVM INSTR tableswitch 0 2: default 28
        //                       0 36
        //                       1 53
        //                       2 80;
               goto _L1 _L2 _L3 _L4
_L1:
            dialog.dismiss();
            return;
_L2:
            (new HideConversationTask(conversation)).execute();
            continue; /* Loop/switch isn't completed */
_L3:
            Events.post(new DialogEvent(new ReportConversationDialog(conversation.getUid())));
            continue; /* Loop/switch isn't completed */
_L4:
            adapterview = new BlockConversationUserDialog();
            adapterview.setConversation(conversation);
            Events.post(new DialogEvent(adapterview));
            if (true) goto _L1; else goto _L5
_L5:
        }

        _cls2()
        {
            this$0 = ConversationNotificationCell.this;
            conversation = conversation1;
            dialog = basedialog;
            super();
        }
    }


    private class OnCellClickListener
        implements android.view.View.OnClickListener
    {

        private final Conversation conversation;
        private final ConversationMessage lastMessage;

        public void onClick(View view)
        {
            if (view instanceof ConversationNotificationCell)
            {
                conversation.setUnread(Integer.valueOf(0));
                ((ConversationNotificationCell)view).hideUnseenMark();
            }
            (new MarkConversationReadTask(conversation)).execute();
            view = new Navigation(Location.CONVERSATION);
            view.setId(conversation.getUid());
            view.setCachedModel(conversation);
            view.putExtra("lastMessage", lastMessage);
            Events.post(view);
        }

        public OnCellClickListener(Conversation conversation1, ConversationMessage conversationmessage)
        {
            conversation = conversation1;
            lastMessage = conversationmessage;
        }

        private class MarkConversationReadTask extends BackgroundTask
        {

            private Conversation _conversation;

            public void run()
            {
                if (_conversation != null)
                {
                    ConversationApi.b(_conversation.getUid(), new ApiResponseHandler());
                    Events.post(new com.pinterest.api.model.Conversation.UpdateEvent(_conversation));
                }
            }

            public MarkConversationReadTask(Conversation conversation1)
            {
                _conversation = conversation1;
            }
        }

    }


    private class _cls1
        implements android.view.View.OnLongClickListener
    {

        final ConversationNotificationCell this$0;
        final Conversation val$conversation;

        public boolean onLongClick(View view)
        {
            showReportDialog(conversation);
            return true;
        }

        _cls1()
        {
            this$0 = ConversationNotificationCell.this;
            conversation = conversation1;
            super();
        }
    }

}
