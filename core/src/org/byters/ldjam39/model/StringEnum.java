package org.byters.ldjam39.model;

public enum StringEnum {
    //todo put into json
    GET_HAMMER("get hammer from locker"),
    GET_MONEY("get money from store"),
    GO_TO_OUTDOOR("go to outdoor"),
    GO_TO_HOME("return home"),
    GET_FISHING_ROD("get fishing rod"),
    FILL_CAT_DISH("fill cat dish"),
    PRESS_E("Press E to "),
    GO_TO_PARK("go to park"),
    GO_TO_MARKET("go to market"),
    GET_CAT_FOOD("get cat food"),
    BUY_CAT_FOOD("purchase cat food"),
    GAME_OVER("Mobile is discharged.\nYou can't complete the tasks.\nPress Enter to restart"),
    GAME_WIN("You complete all tasks!\nThanks for playing");

    private String title;

    StringEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
