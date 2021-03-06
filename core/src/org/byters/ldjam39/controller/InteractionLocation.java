package org.byters.ldjam39.controller;

import org.byters.engine.controller.ControllerMain;
import org.byters.ldjam39.model.InteractedObject;
import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.*;

public class InteractionLocation {

    private LocationInfoBase wLocationInfo;
    private boolean isTaskComplete;

    public InteractionLocation(LocationInfoBase locationInfo) {
        wLocationInfo = locationInfo;
        isTaskComplete = false;
    }

    public boolean isTaskComplete() {
        if (isTaskComplete) {
            isTaskComplete = false;
            return true;
        }
        return false;
    }

    public void checkInteraction() {
        if (wLocationInfo == null) return;

        InteractedObject itemInteracted = wLocationInfo.getInteractedObject();
        if (itemInteracted == null || itemInteracted.getAction() == null) return;

        boolean success = false;
        boolean needToShow = true;
        switch (itemInteracted.getAction()) {

            //region tasks
            case PLANT_TREE:
                success = ControllerWorldState.getInstance().plantTree();
                isTaskComplete = success;
                break;

            case FILL_CAT_DISH:
                success = ControllerWorldState.getInstance().fillCatDish();
                isTaskComplete = success;
                break;

            case FIX_BENCH:
                success = ControllerWorldState.getInstance().fixBench();
                isTaskComplete = success;
                break;

            case CATCH_FISH:
                success = ControllerWorldState.getInstance().catchFish();
                isTaskComplete = success;
                break;

            case GIVE_NANCY_A_GIFT:
                success = ControllerWorldState.getInstance().happyBirthdayNancy();
                needToShow = !success;
                isTaskComplete = success;
                break;
            //endregion

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

            case GET_WORMS:
                success = ControllerWorldState.getInstance().getWorms();
                break;

            case BUY_IN_MARKET:
                needToShow = false;
                success = ControllerWorldState.getInstance().buyInMarket();
                break;
            case GET_CAT_FOOD:
                success = ControllerWorldState.getInstance().getCatFood();
                break;
            case GET_FLOWERS:
                success = ControllerWorldState.getInstance().getFlowers();
                break;

            //region navigation
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
            //endregion
        }

        if (needToShow)
            ControllerWorldState.getInstance().setMessageDialogPlayer(success ? itemInteracted.getMessageSuccess() : itemInteracted.getMessageFault());
        wLocationInfo.resetInteractedItem();
    }
}
