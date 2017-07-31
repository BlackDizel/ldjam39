package org.byters.ldjam39.model;

public class InteractedObject {
    private final String message;
    private final DrawableObject drawableObject;

    public InteractedObject(String message, DrawableObject drawableObject) {
        this.message = message;
        this.drawableObject = drawableObject;
    }

    public String getMessage() {
        return message;
    }

    public DrawableObject getDrawableObject() {
        return drawableObject;
    }
}
