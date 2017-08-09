package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.view.TextureEnum;

public class ModalImageInfo {
    private TextureEnum textureEnum;
    private WorldItemsEnum itemAvailability;
    private WorldItemsEnum itemShow;

    public ModalImageInfo(WorldItemsEnum itemAvailability,
                          WorldItemsEnum itemShow,
                          TextureEnum textureEnum) {
        this.textureEnum = textureEnum;
        this.itemAvailability = itemAvailability;
        this.itemShow = itemShow;
    }

    public boolean isAvailable() {
        return ControllerWorldState.getInstance().isWorldContains(itemAvailability);
    }

    public TextureEnum getTextureEnum() {
        return textureEnum;
    }

    public boolean isShow() {
        return ControllerWorldState.getInstance().isWorldContains(itemShow);
    }

    public void cancelShow() {
        ControllerWorldState.getInstance().removeWorldItem(itemShow);
        ControllerWorldState.getInstance().removeWorldItem(itemAvailability);
    }
}
