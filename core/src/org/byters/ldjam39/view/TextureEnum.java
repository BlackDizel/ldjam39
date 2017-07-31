package org.byters.ldjam39.view;

public enum TextureEnum {
    BUTTON_START("graphics/buttons/start.png"),
    TEXTURE_PLAYER("graphics/player_move.png"),
    TEXTURE_BOX("graphics/box.png"),
    TEXTURE_HOME("graphics/bg_home.png"),
    TEXTURE_FISHING_ROD("graphics/home_fishing_rod.png"),
    TEXTURE_FONT("font/smart/smart.fnt"),
    TEXTURE_OUTDOOR("graphics/bg_outdoor.png"),
    TEXTURE_MARKET("graphics/bg_shop.png"),
    TEXTURE_SIGN_PARK("graphics/sign_park.png"),
    TEXTURE_PARK("graphics/bg_park.png"),
    TEXTURE_MOBILE_TASK1("graphics/mobile/task.png"), //todo replace
    TEXTURE_MOBILE_TASK2("graphics/mobile/task_2.png"),
    TEXTURE_MOBILE_TASK3("graphics/mobile/task_3.png"),
    TEXTURE_MOBILE_PHONEBOOK1("graphics/mobile/phonebook_1.png"),
    TEXTURE_MOBILE_PHONEBOOK2("graphics/mobile/phonebook_2.png"),
    TEXTURE_MOBILE_PHONEBOOK3("graphics/mobile/phonebook_3.png"),
    TEXTURE_MOBILE_PHONEBOOK4("graphics/mobile/phonebook_4.png"),
    TEXTURE_CAT_DISH_FULL("graphics/cat_dish_full.png"),
    TEXTURE_SHOVEL("graphics/shovel.png"),
    TEXTURE_BENCH_BROKEN("graphics/bench_broken.png"),
    TEXTURE_BENCH_FIXED("graphics/bench_fixed.png"),
    TEXTURE_FOREST("graphics/bg_forest.png"),
    TEXTURE_WORMS("graphics/worms.png"),
    TEXTURE_GAMEOVER("graphics/bg_gameover.png"),
    TEXTURE_TREE("graphics/forest_tree.png"),
    TEXTURE_TREE_HOLE("graphics/tree_hole.png");

    private final String path;

    TextureEnum(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
