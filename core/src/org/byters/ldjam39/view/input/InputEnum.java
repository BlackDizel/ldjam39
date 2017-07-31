package org.byters.ldjam39.view.input;

import com.badlogic.gdx.Input;

public enum InputEnum {
    KEY_RUN(Input.Keys.SHIFT_LEFT),
    KEY_MOVE_LEFT(Input.Keys.A),
    KEY_MOVE_UP(Input.Keys.W),
    KEY_MOVE_RIGHT(Input.Keys.D),
    KEY_MOVE_DOWN(Input.Keys.S),
    KEY_SHOW_MOBILE(Input.Keys.SPACE),
    KEY_CANCEL(Input.Keys.ESCAPE),
    KEY_INTERACT(Input.Keys.E);

    private final int key;

    InputEnum(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
