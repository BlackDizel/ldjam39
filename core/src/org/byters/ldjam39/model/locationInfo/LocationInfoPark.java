package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;
import java.util.Arrays;

public class LocationInfoPark extends LocationInfoBase {
    @Override
    public String getBackground() {
        return TextureEnum.TEXTURE_PARK.toString();
    }

    @Override
    public int getRightBoundPositionX() {
        return 725;
    }

    @Override
    public void load() {
        super.load();

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GO_TO_MARKET,
                WorldItemsEnum.MARKET_DOOR,
                StringEnum.GO_TO_MARKET.toString(),
                new DrawableObject(null, 102, 18, 46, 48)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.RETURN_TO_OUTDOOR,
                WorldItemsEnum.SIGN_PARK,
                StringEnum.GO_TO_OUTDOOR.toString(),
                new DrawableObject(TextureEnum.TEXTURE_SIGN_PARK.toString(), 12, 16, 20, 30)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GO_TO_FOREST,
                WorldItemsEnum.FOREST_PORTAL,
                StringEnum.GO_TO_FOREST.toString(),
                new DrawableObject(null, 660, 18, 104, 48)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.CATCH_FISH,
                WorldItemsEnum.POUND,
                StringEnum.CATCH_FISH.toString(),
                new DrawableObject(null, 550, 18, 30, 48),
                Arrays.asList(StringEnum.SUCCESS_CATCH_FISH.toString()),
                Arrays.asList(StringEnum.FAIL_CATCH_FISH.toString())));


        if (!ControllerWorldState.getInstance().isWorldContains(WorldItemsEnum.NANCY_CALL)
                && !ControllerWorldState.getInstance().isTaskCompleted(TaskListEnum.NANCY_BD)) {
            listInteractedObject.add(new InteractedObject(
                    null,
                    WorldItemsEnum.NANCY_SPRITE,
                    null,
                    new DrawableObject(TextureEnum.TEXTURE_NANCY.toString(), 280, 15, 0, 0),
                    null,
                    null));

            listInteractedObject.add(new InteractedObject(
                    InteractEnum.GIVE_NANCY_A_GIFT,
                    WorldItemsEnum.NANCY,
                    StringEnum.GIVE_NANCY_A_GIFT.toString(),
                    new DrawableObject(null, 280, 18, 30, 48),
                    null,
                    Arrays.asList(StringEnum.FAIL_GIVE_GIFT.toString())));
        }

        ArrayList<ModalImageInfo> listImageModal = new ArrayList<ModalImageInfo>();
        listImageModal.add(new ModalImageInfo(
                WorldItemsEnum.MODAL_IMAGE_SELFIE_AVAILABLE,
                WorldItemsEnum.MODAL_IMAGE_SELFIE_SHOW,
                TextureEnum.TEXTURE_MODAL_IMAGE_SELFIE));

        imagesModal = new LocationInfoModalImageInfo(listImageModal);

    }
}
