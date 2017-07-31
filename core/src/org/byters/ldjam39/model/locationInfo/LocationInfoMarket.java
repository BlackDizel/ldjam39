package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

public class LocationInfoMarket extends LocationInfoBase {
    @Override
    public String getBackground() {
        return TextureEnum.TEXTURE_MARKET.toString();
    }

    @Override
    public int getRightBoundPositionX() {
        return 400;
    }

    @Override
    public void load() {
        super.load();

        listInteractedObject.add(new InteractedObject(
                InteractEnum.RETURN_TO_PARK_FROM_MARKET,
                WorldItemsEnum.MARKET_DOOR,
                StringEnum.GO_TO_PARK.toString(),
                new DrawableObject(null, 156, 16, 44, 48)));

    }
}
