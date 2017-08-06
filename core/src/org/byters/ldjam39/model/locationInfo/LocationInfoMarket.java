package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        ControllerWorldState.getInstance().resetDialogs();
        List<DialogMessage> listWelcome = new ArrayList<DialogMessage>();
        listWelcome.add(DialogMessage.newInstance(StringEnum.MARKET_WELCOME.toString(), 224, 68, 1100));
        ControllerWorldState.getInstance().setMessagesDialog(listWelcome);

        listInteractedObject.add(new InteractedObject(
                InteractEnum.RETURN_TO_PARK_FROM_MARKET,
                WorldItemsEnum.MARKET_DOOR,
                StringEnum.GO_TO_PARK.toString(),
                new DrawableObject(null, 156, 16, 44, 48)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_CAT_FOOD,
                WorldItemsEnum.CAT_FOOD_IN_MARKET,
                StringEnum.GET_CAT_FOOD.toString(),
                new DrawableObject(null, 34, 16, 30, 48),
                Arrays.asList(StringEnum.SUCCESS_GET_CAT_FOOD.toString()),
                Arrays.asList(StringEnum.FAIL_GET_CAT_FOOD.toString())));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.BUY_CAT_FOOD,
                WorldItemsEnum.SELLER,
                StringEnum.BUY_CAT_FOOD.toString(),
                new DrawableObject(null, 222, 16, 46, 48),
                Arrays.asList(StringEnum.SUCCESS_BUY_CAT_FOOD.toString()),
                null));

    }

    @Override
    public void dispose() {
        super.dispose();
        ControllerWorldState.getInstance().resetDialogs();
    }
}
