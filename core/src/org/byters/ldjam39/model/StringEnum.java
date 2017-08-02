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
    GET_SHOVEL("get shovel"),
    FIX_BENCH("fix the bench"),
    GO_TO_FOREST("go to forest"),
    GET_WORMS("get the worms"),
    CATCH_FISH("catch fish"),
    GET_TREE("dig out tree"),
    PLAT_TREE("plant the tree"),
    SUCCESS_GET_WORMS("Let's go fishing"),
    FAIL_GET_WORMS("worms"), 
    SUCCESS_GET_TREE("I get the tree"), 
    FAIL_GET_TREE("What must I do?"), 
    SUCCESS_GET_HAMMER("There's the hammer"), 
    SUCCESS_GET_MONEY("I found the purse!"), 
    SUCCESS_GET_FISHING_ROD("I get the fishing rod"), 
    SUCCESS_FILL_CAT_DISH("Bon appetit, Orange"),
    FAIL_FILL_CAT_DISH("The feed is out"),
    FAIL_GET_CAT_FOOD("Where is my purse?"),
    SUCCESS_GET_CAT_FOOD("Now I need to pay for food"),
    SUCCESS_BUY_CAT_FOOD("Seller: Thank you for purchase!"),
    SUCCESS_GET_SHOVEL("I get the shovel"),
    SUCCESS_FIX_BENCH_1("I hope"),
    SUCCESS_FIX_BENCH_2("it will not be broken again"),
    FAIL_FIX_BENCH("I can't fix the bench without tools"),
    FAIL_PLANT_TREE("Tree in the forest"),
    SUCCESS_PLANT_TREE_1("Now I have"),
    SUCCESS_PLANT_TREE_2("a piece of wood"),
    SUCCESS_CATCH_FISH("Fish, smile!"),
    FAIL_CATCH_FISH("The pond");

    private String title;

    StringEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
