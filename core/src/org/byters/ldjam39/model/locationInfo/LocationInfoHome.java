package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.*;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;
import java.util.Arrays;

public class LocationInfoHome extends LocationInfoBase {

    @Override
    public void load() {
        super.load();
        //todo put into json

        listAnimations = new ArrayList<AnimationInfo>();
        listAnimations.add(new AnimationInfo(TextureEnum.TEXTURE_ANIMATION_CAT, 4, 86f, 64f));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_HAMMER,
                WorldItemsEnum.HAMMER,
                StringEnum.GET_HAMMER.toString(),
                new DrawableObject(null, 84, 16, 24, 50),
                Arrays.asList(StringEnum.SUCCESS_GET_HAMMER.toString()),
                null));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_MONEY,
                WorldItemsEnum.MONEY,
                StringEnum.GET_MONEY.toString(),
                new DrawableObject(null, 350, 16, 20, 12),
                Arrays.asList(StringEnum.SUCCESS_GET_MONEY.toString()),
                null));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GO_TO_OUTDOOR,
                WorldItemsEnum.HOME_DOOR,
                StringEnum.GO_TO_OUTDOOR.toString(),
                new DrawableObject(null, 194, 16, 22, 45)));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.GET_FISHING_ROD,
                WorldItemsEnum.FISHING_ROD,
                StringEnum.GET_FISHING_ROD.toString(),
                new DrawableObject(TextureEnum.TEXTURE_FISHING_ROD.toString(), 224, 16, 12, 40),
                Arrays.asList(StringEnum.SUCCESS_GET_FISHING_ROD.toString()),
                null));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.FILL_CAT_DISH,
                WorldItemsEnum.CAT_DISH_EMPTY,
                StringEnum.FILL_CAT_DISH.toString(),
                new DrawableObject(null, 122, 16, 8, 4),
                Arrays.asList(StringEnum.SUCCESS_FILL_CAT_DISH.toString()),
                Arrays.asList(StringEnum.FAIL_FILL_CAT_DISH.toString())));

        listInteractedObject.add(new InteractedObject(
                InteractEnum.NONE,
                WorldItemsEnum.CAT_DISH_FULL,
                null,
                new DrawableObject(TextureEnum.TEXTURE_CAT_DISH_FULL.toString(), 121, 15, 8, 4)));

        if (ControllerWorldState.getInstance().isWorldContains(WorldItemsEnum.GAME_START)) {
            ControllerWorldState.getInstance().removeWorldItem(WorldItemsEnum.GAME_START);
            ControllerWorldState.getInstance().resetDialogs();

            ArrayList<DialogMessage> list = new ArrayList<DialogMessage>();
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_1.toString(), 1000));
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_2.toString(), 2000));
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_3.toString(), 2000));
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_4.toString(), 2000));
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_5.toString(), 2000));
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_6.toString(), 2000));
            list.add(DialogMessage.newInstancePlayer(StringEnum.GAME_START_DIALOG_7.toString(), 3000));

            ControllerWorldState.getInstance().setMessagesDialog(list);
        }
    }

    @Override
    public String getBackground() {
        return TextureEnum.TEXTURE_HOME.toString();
    }

    @Override
    public int getRightBoundPositionX() {
        return 380;
    }
}