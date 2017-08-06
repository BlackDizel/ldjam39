package org.byters.ldjam39.controller;

import org.byters.engine.controller.ControllerMain;
import org.byters.ldjam39.model.InteractedObject;
import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.*;

public class InteractionLocation {

    private LocationInfoBase wLocationInfo;

    public InteractionLocation(LocationInfoBase locationInfo) {
        wLocationInfo = locationInfo;
    }

    public void checkInteraction() {
        if (wLocationInfo == null) return;

        InteractedObject itemInteracted = wLocationInfo.getInteractedObject();
        if (itemInteracted == null) return;

        boolean success = false;
        boolean needToShow = true;
        switch (itemInteracted.getAction()) {
            case GET_HAMMER:
                success = ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.HAMMER);
                break;
            case GET_MONEY:
                success = ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.MONEY);
                break;
            case GET_FISHING_ROD:
                success = ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.FISHING_ROD);
                break;
            case GET_SHOVEL:
                success = ControllerWorldState.getInstance().addToInventory(WorldItemsEnum.SHOVEL);
                break;

            case GET_TREE:
                success = ControllerWorldState.getInstance().getTree();
                break;

            case PLANT_TREE:
                success = ControllerWorldState.getInstance().plantTree();
                break;

            case GET_WORMS:
                success = ControllerWorldState.getInstance().getWorms();
                break;

            case FILL_CAT_DISH:
                success = ControllerWorldState.getInstance().fillCatDish();
                break;
            case BUY_CAT_FOOD:
                success = ControllerWorldState.getInstance().buyCatFood();
                break;
            case GET_CAT_FOOD:
                success = ControllerWorldState.getInstance().getCatFood();
                break;
            case FIX_BENCH:
                success = ControllerWorldState.getInstance().fixBench();
                break;
            case CATCH_FISH:
                success = ControllerWorldState.getInstance().catchFish();
                break;

            case GO_TO_OUTDOOR:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGameOutdoor(172, 12));
                break;
            case RETURN_TO_OUTDOOR:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGameOutdoor(16, 12));
                break;
            case GO_TO_HOME:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGameHome(204, 12));
                break;
            case GO_TO_MARKET:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGameMarket(178, 12));
                break;
            case GO_TO_PARK:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGamePark(16, 12));
                break;
            case RETURN_TO_PARK_FROM_MARKET:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGamePark(124, 12));
                break;
            case GO_TO_FOREST:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGameForest(16, 12));
                break;
            case RETURN_TO_PARK_FROM_FOREST:
                needToShow = false;
                ControllerMain.getInstance().navigateScreen(new ScreenGamePark(690, 12));
                break;
        }

        if (needToShow)
            ControllerWorldState.getInstance().setMessageDialogPlayer(success ? itemInteracted.getMessageSuccess() : itemInteracted.getMessageFault());
        wLocationInfo.resetInteractedItem();
    }
}
