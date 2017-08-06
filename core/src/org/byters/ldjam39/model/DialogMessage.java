package org.byters.ldjam39.model;

public class DialogMessage {

    private boolean isPlayer;
    private float x;
    private float y;
    private String message;
    private long duration;

    private DialogMessage(boolean isPlayer, float x, float y, String message, long duration) {
        this.isPlayer = isPlayer;
        this.x = x;
        this.y = y;
        this.message = message;
        this.duration = duration;
    }

    public static DialogMessage newInstancePlayer(String message, long duration) {
        return new DialogMessage(true, 0, 0, message, duration);
    }

    public static DialogMessage newInstance(String message, float x, float y, long duration) {
        return new DialogMessage(false, x, y, message, duration);
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getMessage() {
        return message;
    }

    public long getDuration() {
        return duration;
    }
}
