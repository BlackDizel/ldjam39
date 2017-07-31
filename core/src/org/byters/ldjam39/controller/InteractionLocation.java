package org.byters.ldjam39.controller;

import org.byters.engine.controller.ControllerMain;
import org.byters.ldjam39.model.InteractedObject;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.view.ScreenGameHome;
import org.byters.ldjam39.view.ScreenGameOutdoor;

import java.lang.ref.WeakReference;

public class InteractionLocation {

    private WeakReference<LocationInfoBase> wLocationInfo;

    public InteractionLocation(LocationInfoBase locationInfo) {
        wLocationInfo = new WeakReference<LocationInfoBase>(locationInfo);
    }

    public void checkInteraction() {
        if (wLocationInfo.get() == null) return;

        InteractedObject itemInteracted = wLocationInfo.get().getInteractedObject();
        if (itemInteracted == null) return;

        switch (itemInteracted.getAction()) {
            case GET_HAMMER:
                ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.HAMMER);
                break;
            case GET_MONEY:
                ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.MONEY);
                break;
            case GET_FISHING_ROD:
                ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.FISHING_ROD);
                break;
            case FILL_CAT_DISH:
                ControllerWorldState.getInstance().fillCatDish();
                break;
            case GO_TO_OUTDOOR:
                ControllerMain.getInstance().navigateScreen(new ScreenGameOutdoor());
                break;
            case GO_TO_HOME:
                ControllerMain.getInstance().navigateScreen(new ScreenGameHome());
                break;
        }
    }
}
