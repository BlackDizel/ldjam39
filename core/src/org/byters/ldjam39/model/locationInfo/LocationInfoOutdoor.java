package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

public class LocationInfoOutdoor extends LocationInfoBase {

    @Override
    public String getBackground() {
        return TextureEnum.TEXTURE_OUTDOOR.toString();
    }

    @Override
    public int getRightBoundPositionX() {
        return 192;
    }

    @Override
    public void load() {
        super.load();
        listInteractedObject.add(new InteractedObject(
                InteractEnum.GO_TO_HOME,
                WorldItemsEnum.HOME_DOOR,
                StringEnum.GO_TO_HOME.toString(),
                new DrawableObject(null, 160, 20, 22, 48)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GO_TO_PARK,
                WorldItemsEnum.SIGN_PARK,
                StringEnum.GO_TO_PARK.toString(),
                new DrawableObject(TextureEnum.TEXTURE_SIGN_PARK.toString(), 12, 16, 20, 30)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_SHOVEL,
                WorldItemsEnum.SHOVEL,
                StringEnum.GET_SHOVEL.toString(),
                new DrawableObject(TextureEnum.TEXTURE_SHOVEL.toString(), 72, 16, 12, 36)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.FIX_BENCH,
                WorldItemsEnum.BENCH_BROKEN,
                StringEnum.FIX_BENCH.toString(),
                new DrawableObject(TextureEnum.TEXTURE_BENCH_BROKEN.toString(), 86, 12, 38, 26)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.NONE,
                WorldItemsEnum.BENCH_FIXED,
                null,
                new DrawableObject(TextureEnum.TEXTURE_BENCH_FIXED.toString(), 86, 12, 38, 26)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.PLANT_TREE,
                WorldItemsEnum.TREE_HOLE_IN_OUTDOOR,
                StringEnum.PLAT_TREE.toString(),
                new DrawableObject(TextureEnum.TEXTURE_TREE_HOLE.toString(), 32, 8, 38, 26)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.NONE,
                WorldItemsEnum.TREE_IN_OUTDOOR,
                null,
                new DrawableObject(TextureEnum.TEXTURE_TREE.toString(), 20, 12, 38, 26)));

    }
}
