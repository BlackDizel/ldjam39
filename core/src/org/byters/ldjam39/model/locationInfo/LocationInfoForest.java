package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

public class LocationInfoForest extends LocationInfoBase {
    @Override
    public String getBackground() {
        return TextureEnum.TEXTURE_FOREST.toString();
    }

    @Override
    public int getRightBoundPositionX() {
        return 250;
    }

    @Override
    public void load() {
        super.load();

        listInteractedObject.add(new InteractedObject(
                InteractEnum.RETURN_TO_PARK_FROM_FOREST,
                WorldItemsEnum.FOREST_PORTAL,
                StringEnum.GO_TO_PARK.toString(),
                new DrawableObject(null, 16, 18, 46, 48)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_WORMS,
                WorldItemsEnum.WORMS,
                StringEnum.GET_WORMS.toString(),
                new DrawableObject(TextureEnum.TEXTURE_WORMS.toString(), 64, 12, 20, 48)));

    }
}
