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
                new DrawableObject(TextureEnum.TEXTURE_SIGN_PARK.toString(), 12, 20, 20, 30)));

    }
}
