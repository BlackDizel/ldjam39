package org.byters.ldjam39.model.state;

import org.byters.ldjam39.model.DialogMessage;

import java.util.ArrayList;
import java.util.List;

public class DialogState extends ObjectStateBase {
    private static final long NO_VALUE = 0;
    private static final long TIME_SHOW_DEFAULT = 1100;
    private long timeStartMillis;
    private List<DialogMessage> messages;
    private int currentItemPos;

    public DialogState() {
        super(ObjectStateEnum.DIALOG_STATE);
    }

    @Override
    public void reset() {
        timeStartMillis = NO_VALUE;
        messages = null;
        currentItemPos = 0;
    }


    public DialogMessage getCurrentMessage() {
        if (timeStartMillis == NO_VALUE || messages == null || messages.size() == 0) return null;

        if (timeStartMillis + messages.get(currentItemPos).getDuration() < System.currentTimeMillis()) {
            if (currentItemPos < messages.size() - 1) {
                ++currentItemPos;
                timeStartMillis = System.currentTimeMillis();
            } else {
                messages = null;
                return null;
            }
        }

        return messages.get(currentItemPos);
    }

    public void setMessagePlayer(List<String> messages) {
        this.timeStartMillis = System.currentTimeMillis();
        currentItemPos = 0;

        if (messages == null) {
            this.messages = null;
            return;
        }

        this.messages = new ArrayList<DialogMessage>();
        for (String item : messages) {
            this.messages.add(DialogMessage.newInstancePlayer(item, TIME_SHOW_DEFAULT));
        }
    }

    public void setMessages(List<DialogMessage> data) {
        this.timeStartMillis = System.currentTimeMillis();
        currentItemPos = 0;
        this.messages = data;
    }
}
