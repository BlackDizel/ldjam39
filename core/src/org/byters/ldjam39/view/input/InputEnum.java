package org.byters.ldjam39.view.input;

import com.badlogic.gdx.Input;

public enum InputEnum {
    KEY_MOVE_LEFT(Input.Keys.A),
    KEY_MOVE_RIGHT(Input.Keys.D),
    KEY_CANCEL(Input.Keys.ESCAPE),
    KEY_INTERACT(Input.Keys.E),
    KEY_CONFIRM(Input.Keys.ENTER),

    KEY_MOBILE_NEXT(Input.Keys.RIGHT),
    KEY_MOBILE_PREV(Input.Keys.LEFT),
    KEY_MOBILE_PHONEBOOK(Input.Keys.NUM_2),
    KEY_MOBILE_TASKS(Input.Keys.NUM_1),
    KEY_MOBILE_NEXT_ITEM(Input.Keys.DOWN),
    KEY_MOBILE_PREV_ITEM(Input.Keys.UP),
    KEY_SHOW_MOBILE(Input.Keys.SPACE);

    private final int key;

    InputEnum(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
