package org.byters.ldjam39.view.input;


import com.badlogic.gdx.Gdx;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.controller.InteractionMobile;
import org.byters.ldjam39.model.Mobile;

public class InputMobile {
    private final InteractionMobile interactionMobile;
    private Mobile wMobile;

    public InputMobile(Mobile mobile, InteractionMobile interactionMobile) {
        this.wMobile = mobile;
        this.interactionMobile = interactionMobile;
    }

    public boolean input() {
        if (wMobile == null) return false;

        if (!wMobile.isShown()
                && (Gdx.input.isKeyJustPressed(InputEnum.KEY_SHOW_MOBILE.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_UP.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV_ITEM.getKey()))) {
            wMobile.setShown(true);
            ControllerWorldState.getInstance().resetDialogs();
            return true;
        }
        if (wMobile.isShown()
                && Gdx.input.isKeyJustPressed(InputEnum.KEY_CANCEL.getKey())) {
            wMobile.setShown(false);
            return true;
        }

        return inputMobileShown();
    }

    private boolean inputMobileShown() {
        if (wMobile == null || !wMobile.isShown())
            return false;

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_MOVE_RIGHT.getKey())) {
            wMobile.nextScreen();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_MOVE_LEFT.getKey())) {
            wMobile.prevScreen();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT_ITEM.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_DOWN.getKey())) {
            wMobile.nextItem();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV_ITEM.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_UP.getKey())) {
            wMobile.prevItem();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_INTERACT.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_SHOW_MOBILE.getKey())
                || Gdx.input.isKeyJustPressed(InputEnum.KEY_CONFIRM.getKey())) {
            interactionMobile.interact();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PHONEBOOK.getKey())) {
            wMobile.openClosePhonebook();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_TASKS.getKey())) {
            wMobile.openTasks();
            return true;
        }
        return false;
    }
}
