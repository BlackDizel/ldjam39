package org.byters.ldjam39.model;

public enum StringEnum {
    //todo put into json
    GET_HAMMER("get hammer from locker"),
    GET_MONEY("get money from store"),
    GO_TO_OUTDOOR("go to outdoor"),
    GO_TO_HOME("return home"),
    GET_FISHING_ROD("get fishing rod"),
    FILL_CAT_DISH("fill cat dish"),
    PRESS_E("Press E to ");

    private String title;

    StringEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
