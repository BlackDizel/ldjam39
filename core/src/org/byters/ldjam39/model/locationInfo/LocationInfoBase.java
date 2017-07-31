package org.byters.ldjam39.model.locationInfo;

import org.byters.engine.model.util.HelperMath;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.InteractedObject;
import org.byters.ldjam39.model.StringEnum;

import java.util.ArrayList;

public abstract class LocationInfoBase {

    static final float DISTANCE_INTERACT = 12;
    ArrayList<InteractedObject> listInteractedObject;
    private InteractedObject interactedObject;
    private InteractedObject nearestObject;

    public void load() {
        interactedObject = null;
        nearestObject = null;
        listInteractedObject = new ArrayList<InteractedObject>();
    }

    public int getInteractedObjectsNum() {
        return listInteractedObject == null ? 0 : listInteractedObject.size();
    }

    public float getInteractedObjectPositionX(int pos) {
        return listInteractedObject == null || pos < 0 || pos >= listInteractedObject.size() ? 0 : listInteractedObject.get(pos).getDrawableObject().getX();
    }

    public float getInteractedObjectPositionY(int pos) {
        return listInteractedObject == null || pos < 0 || pos >= listInteractedObject.size() ? 0 : listInteractedObject.get(pos).getDrawableObject().getY();
    }

    public String getInteractedObjectTexturePath(int pos) {
        return listInteractedObject == null || pos < 0 || pos >= listInteractedObject.size() ? null : listInteractedObject.get(pos).getDrawableObject().getTexturePath();

    }


    public String getMessage() {
        return nearestObject == null
                || nearestObject.getMessage() == null
                || nearestObject.getMessage().isEmpty()
                ? null
                : StringEnum.PRESS_E.toString() + nearestObject.getMessage();
    }

    public void updateInteractMessage(float xPos) {
        nearestObject = null;
        if (listInteractedObject == null) return;

        for (InteractedObject item : listInteractedObject)
            if (HelperMath.distance(item.getDrawableObject().getOriginX(), xPos) < DISTANCE_INTERACT
                    && ControllerWorldState.getInstance().isWorldContains(item.getWorldItem())) {
                nearestObject = item;
                return;
            }
    }

    public void interact() {
        if (nearestObject == null) return;
        interactedObject = nearestObject;
    }

    public boolean isDrawableObjectExist(int pos) {
        InteractedObject item = listInteractedObject.get(pos);
        return ControllerWorldState.getInstance().isWorldContains(item.getWorldItem());
    }

    public abstract String getBackground();

    public abstract int getRightBoundPositionX();

    public InteractedObject getInteractedObject() {
        return interactedObject;
    }
}