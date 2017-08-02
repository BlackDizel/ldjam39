package org.byters.ldjam39.model;

import java.util.ArrayList;

public class InteractedObject {
    private final String message;
    private final DrawableObject drawableObject;
    private InteractEnum action;
    private WorldItemsEnum itemWorld;
    private ArrayList<String> listMessageSuccess;
    private ArrayList<String> listMessageFail;

    public InteractedObject(InteractEnum idInteract,
                            WorldItemsEnum itemWorld,
                            String message,
                            DrawableObject drawableObject,
                            ArrayList<String> listMessageSuccess,
                            ArrayList<String> listMessageFail) {
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

    public ArrayList<String> getMessageSuccess() {
        return listMessageSuccess;
    }

    public ArrayList<String> getMessageFault() {
        return listMessageFail;
    }
}
