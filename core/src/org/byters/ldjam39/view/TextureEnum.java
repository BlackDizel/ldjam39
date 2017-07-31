package org.byters.ldjam39.view;

public enum TextureEnum {
    BUTTON_START("graphics/buttons/start.png"),
    TEXTURE_PLAYER("graphics/player_move.png"),
    TEXTURE_BOX("graphics/box.png"),
    TEXTURE_MOBILE("graphics/mobile.png"),
    TEXTURE_HOME("graphics/bg_home.png"),
    TEXTURE_FISHING_ROD("graphics/home_fishing_rod.png"),
    TEXTURE_FONT("font/freesans15white.fnt");

    private final String path;

    TextureEnum(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
