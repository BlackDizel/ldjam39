package org.byters.ldjam39.model;

import org.byters.engine.model.util.HelperMath;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;

public class LocationInfoHome extends LocationInfoBase {

    private ArrayList<InteractedObject> listInteractedObject;
    private InteractedObject nearestObject;

    @Override
    public void load() {
        super.load();
        nearestObject = null;
        listInteractedObject = new ArrayList<InteractedObject>();

        //todo put into json

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_HAMMER,
                WorldItemsEnum.HAMMER,
                StringEnum.GET_HAMMER.toString(),
                new DrawableObject(null, 84, 16, 24, 50)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_MONEY,
                WorldItemsEnum.MONEY,
                StringEnum.GET_MONEY.toString(),
                new DrawableObject(null, 350, 16, 20, 12)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GO_TO_OUTDOOR,
                WorldItemsEnum.HOME_DOOR,
                StringEnum.GO_TO_OUTDOOR.toString(),
                new DrawableObject(null, 194, 16, 22, 45)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_FISHING_ROD,
                WorldItemsEnum.FISHING_ROD,
                StringEnum.GET_FISHING_ROD.toString(),
                new DrawableObject(TextureEnum.TEXTURE_FISHING_ROD.toString(), 224, 16, 12, 40)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.FILL_CAT_DISH,
                WorldItemsEnum.CAT_DISH_EMPTY,
                StringEnum.FILL_CAT_DISH.toString(),
                new DrawableObject(null, 122, 16, 8, 4)));
    }

    @Override
    public String getBackground() {
        return TextureEnum.TEXTURE_HOME.toString();
    }

    @Override
    public int getInteractedObjectsNum() {
        return listInteractedObject == null ? 0 : listInteractedObject.size();
    }

    @Override
    public float getInteractedObjectPositionX(int pos) {
        return listInteractedObject == null || pos < 0 || pos >= listInteractedObject.size() ? 0 : listInteractedObject.get(pos).getDrawableObject().getX();
    }

    @Override
    public float getInteractedObjectPositionY(int pos) {
        return listInteractedObject == null || pos < 0 || pos >= listInteractedObject.size() ? 0 : listInteractedObject.get(pos).getDrawableObject().getY();
    }

    @Override
    public String getInteractedObjectTexturePath(int pos) {
        return listInteractedObject == null || pos < 0 || pos >= listInteractedObject.size() ? null : listInteractedObject.get(pos).getDrawableObject().getTexturePath();

    }

    @Override
    public String getMessage() {
        return nearestObject == null ? null : StringEnum.PRESS_E.toString() + nearestObject.getMessage();
    }

    public void updateInteractMessage(float xPos) {
        nearestObject = null;
        if (listInteractedObject == null) return;

        for (InteractedObject item : listInteractedObject)
            if (HelperMath.distance(item.getDrawableObject().getOriginX(), xPos) < DISTANCE_INTERACT
                    && ControllerWorldState.getInstance().isWorldContains(item.getWorldItem())) {
                nearestObject = item;
                item.getMessage();
                return;
            }
    }

    @Override
    public void interact() {
        if (nearestObject == null) return;
        interactedObject = nearestObject;
    }

    @Override
    public boolean isDrawableObjectExist(int pos) {
        InteractedObject item = listInteractedObject.get(pos);
        return ControllerWorldState.getInstance().isWorldContains(item.getWorldItem());
    }
}