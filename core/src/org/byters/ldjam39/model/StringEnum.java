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
    BUY("purchase goods"),
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
    SUCCESS_BUY("Thank you for purchase!"),
    SUCCESS_GET_SHOVEL("I get the shovel"),
    SUCCESS_FIX_BENCH_1("I hope"),
    SUCCESS_FIX_BENCH_2("it will not be broken again"),
    FAIL_FIX_BENCH("I can't fix the bench without tools"),
    FAIL_PLANT_TREE("Tree in the forest"),
    SUCCESS_PLANT_TREE_1("Now I have"),
    SUCCESS_PLANT_TREE_2("a piece of wood"),
    SUCCESS_CATCH_FISH("Fish, smile!"),
    FAIL_CATCH_FISH("The pond"),
    MARKET_WELCOME("Welcome, sir"),
    CLOSE_IMAGE_MODAL("Press ESC to close image"),
    GET_FLOWERS("get the flowers"),
    SUCCESS_GET_FLOWERS("Now I need to pay for flowers."),
    FAIL_GET_FLOWERS("Where is my purse?"),
    MOBILE_HELP("Press\nLeft, right to change screens.\nUp, down to select item\nI,Z to select tasks, phonebook"),
    DIALOG_NANCY_1("Hi, Nancy!"),
    DIALOG_NANCY_2("Nancy:Hi, Joseph!"),
    DIALOG_NANCY_3("I want to meet you"),
    DIALOG_NANCY_4("Nancy: OK! I'll be in park soon"),
    DIALOG_NANCY_FAIL("Nancy will be in park soon"),
    GIVE_NANCY_A_GIFT("happy birthday Nancy"),
    FAIL_GIVE_GIFT("I need some present"),
    SUCCESS_GIVE_GIFT_1("Happy Birthday, Nancy!"),
    SUCCESS_GIVE_GIFT_2("My favorite flowers!"),
    SUCCESS_GIVE_GIFT_3("Thank you, Joseph."),
    GAME_START_DIALOG_1("Oh, no!"),
    GAME_START_DIALOG_2("I forgot to charge the phone."),
    GAME_START_DIALOG_3("But now there is no time."),
    GAME_START_DIALOG_4("I have a lot to do."),
    GAME_START_DIALOG_5("I must do everything in time"),
    GAME_START_DIALOG_6("Before the phone power runs out!");

    private String title;

    StringEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
