package org.byters.ldjam39.view.input;


import com.badlogic.gdx.Gdx;
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

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_SHOW_MOBILE.getKey())) {
            wMobile.setShown(true);
            return true;
        }
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CANCEL.getKey()) && wMobile.isShown()) {
            wMobile.setShown(false);
            return true;
        }

        return inputMobileShown();
    }

    private boolean inputMobileShown() {
        if (wMobile == null || !wMobile.isShown())
            return false;

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT.getKey())) {
            wMobile.nextScreen();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV.getKey())) {
            wMobile.prevScreen();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT_ITEM.getKey())) {
            wMobile.nextItem();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV_ITEM.getKey())) {
            wMobile.prevItem();
            return true;
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_INTERACT.getKey())) {
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
