package org.byters.ldjam39.view.input;


import com.badlogic.gdx.Gdx;
import org.byters.ldjam39.model.Mobile;

public class InputMobile {
    private Mobile wMobile;

    public InputMobile(Mobile mobile) {
        this.wMobile = mobile;
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

        /*if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT.getKey()))
            wMobile.get().nextScreen();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV.getKey()))
            wMobile.get().prevScreen();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PHONEBOOK.getKey()))
            wMobile.get().openClosePhonebook();*/
    }
}
