package org.byters.ldjam39.model;

public abstract class LocationInfoBase {

    static final float DISTANCE_INTERACT = 12;
    InteractedObject interactedObject;

    public void load() {
        interactedObject = null;
    }

    public abstract String getBackground();

    public abstract int getInteractedObjectsNum();

    public abstract float getInteractedObjectPositionX(int pos);

    public abstract float getInteractedObjectPositionY(int pos);

    public abstract String getInteractedObjectTexturePath(int pos);

    public abstract void updateInteractMessage(float xPos);

    public abstract String getMessage();

    public abstract void interact();

    public InteractedObject getInteractedObject() {
        return interactedObject;
    }

    public abstract boolean isDrawableObjectExist(int pos);
}