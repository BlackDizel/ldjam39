package org.byters.ldjam39.model;

public class InteractedObject {
    private final String message;
    private final DrawableObject drawableObject;
    private InteractEnum action;
    private WorldItemsEnum itemWorld;

    InteractedObject(InteractEnum idInteract,
                            WorldItemsEnum itemWorld,
                            String message,
                            DrawableObject drawableObject) {
        this.message = message;
        this.itemWorld = itemWorld;
        this.drawableObject = drawableObject;
        this.action = idInteract;
    }

    String getMessage() {
        return message;
    }

    DrawableObject getDrawableObject() {
        return drawableObject;
    }

    public InteractEnum getAction() {
        return action;
    }

    WorldItemsEnum getWorldItem() {
        return itemWorld;
    }
}
