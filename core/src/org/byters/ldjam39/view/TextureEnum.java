package org.byters.ldjam39.view;

public enum TextureEnum {
    BUTTON_START("graphics/buttons/start.png");

    private final String path;

    TextureEnum(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
