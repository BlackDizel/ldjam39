package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

import java.util.Arrays;

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
                new DrawableObject(null, -12, 18, 64, 48)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_WORMS,
                WorldItemsEnum.WORMS,
                StringEnum.GET_WORMS.toString(),
                new DrawableObject(TextureEnum.TEXTURE_WORMS.toString(), 64, 12, 20, 48),
                Arrays.asList(StringEnum.SUCCESS_GET_WORMS.toString()),
                Arrays.asList(StringEnum.FAIL_GET_WORMS.toString())));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_TREE,
                WorldItemsEnum.FOREST_TREE,
                StringEnum.GET_TREE.toString(),
                new DrawableObject(TextureEnum.TEXTURE_TREE.toString(), 172, 12, 45, 78),
                Arrays.asList(StringEnum.SUCCESS_GET_TREE.toString()),
                Arrays.asList(StringEnum.FAIL_GET_TREE.toString())));

    }
}
