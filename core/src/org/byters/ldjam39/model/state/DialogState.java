package org.byters.ldjam39.model.state;

import java.util.List;

public class DialogState extends ObjectStateBase {
    private static final long NO_VALUE = 0;
    private static final long TIME_SHOW = 700;
    private long timeStartMillis;
    private List<String> message;
    private int currentItemPos;

    public DialogState() {
        super(ObjectStateEnum.DIALOG_STATE);
    }

    @Override
    public void reset() {
        timeStartMillis = NO_VALUE;
        message = null;
        currentItemPos = 0;
    }

    public String getMessage() {
        if (timeStartMillis == NO_VALUE || message == null || message.size() == 0) return null;

        if (timeStartMillis + TIME_SHOW < System.currentTimeMillis()
                && currentItemPos < message.size() - 1) {
            ++currentItemPos;
            timeStartMillis = System.currentTimeMillis();
        }

        return message.get(currentItemPos);
    }

    public void setMessage(List<String> message) {
        this.timeStartMillis = System.currentTimeMillis();
        currentItemPos = 0;
        this.message = message;
    }
}
