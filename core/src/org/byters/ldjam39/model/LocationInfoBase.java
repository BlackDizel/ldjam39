package org.byters.ldjam39.model;

public abstract class LocationInfoBase {

    static final float DISTANCE_INTERACT = 12;

    public abstract String getBackground();

    public abstract int getInteractedObjectsNum();

    public abstract float getInteractedObjectPositionX(int pos);

    public abstract float getInteractedObjectPositionY(int pos);

    public abstract String getInteractedObjectTexturePath(int pos);

    public abstract void updateInteractMessage(float xPos);

    public abstract String getMessage();

    public abstract void interact();
}