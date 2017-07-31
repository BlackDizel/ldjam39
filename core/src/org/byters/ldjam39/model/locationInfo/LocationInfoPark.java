package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

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

    }
}
