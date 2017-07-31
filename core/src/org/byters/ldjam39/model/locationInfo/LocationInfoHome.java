package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

public class LocationInfoHome extends LocationInfoBase {

    @Override
    public void load() {
        super.load();
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
    public int getRightBoundPositionX() {
        return 380;
    }
}