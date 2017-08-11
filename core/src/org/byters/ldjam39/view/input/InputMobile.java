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

    public void input() {
        if (wMobile == null) return;

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_SHOW_MOBILE.getKey()))
            wMobile.setShown(true);
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CANCEL.getKey()) && wMobile.isShown())
            wMobile.setShown(false);

        inputMobileShown();
    }

    private void inputMobileShown() {
        if (wMobile == null || !wMobile.isShown())
            return;

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT.getKey()))
            wMobile.nextScreen();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV.getKey()))
            wMobile.prevScreen();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT_ITEM.getKey()))
            wMobile.nextItem();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV_ITEM.getKey()))
            wMobile.prevItem();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_INTERACT.getKey())) {
            interactionMobile.interact();
        }

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PHONEBOOK.getKey()))
            wMobile.openClosePhonebook();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_TASKS.getKey()))
            wMobile.openTasks();
    }
}
