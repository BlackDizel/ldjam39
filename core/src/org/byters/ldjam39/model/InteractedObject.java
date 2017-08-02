package org.byters.ldjam39.model;

import java.util.List;

public class InteractedObject {
    private final String message;
    private final DrawableObject drawableObject;
    private final List<String> listMessageSuccess;
    private final List<String> listMessageFail;
    private InteractEnum action;
    private WorldItemsEnum itemWorld;

    public InteractedObject(InteractEnum idInteract,
                            WorldItemsEnum itemWorld,
                            String message,
                            DrawableObject drawableObject) {
        this(idInteract, itemWorld, message, drawableObject, null, null);
    }

    public InteractedObject(InteractEnum idInteract,
                            WorldItemsEnum itemWorld,
                            String message,
                            DrawableObject drawableObject,
                            List<String> listMessageSuccess,
                            List<String> listMessageFail) {
        this.message = message;
        this.itemWorld = itemWorld;
        this.drawableObject = drawableObject;
        this.action = idInteract;
        this.listMessageSuccess = listMessageSuccess;
        this.listMessageFail = listMessageFail;
    }

    public String getMessage() {
        return message;
    }

    public DrawableObject getDrawableObject() {
        return drawableObject;
    }

    public InteractEnum getAction() {
        return action;
    }

    public WorldItemsEnum getWorldItem() {
        return itemWorld;
    }

    public List<String> getMessageSuccess() {
        return listMessageSuccess;
    }

    public List<String> getMessageFault() {
        return listMessageFail;
    }
}
