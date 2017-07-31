package org.byters.ldjam39.view.input;


import com.badlogic.gdx.Gdx;
import org.byters.ldjam39.model.Mobile;

import java.lang.ref.WeakReference;

public class InputMobile {
    private WeakReference<Mobile> wMobile;

    public InputMobile(Mobile mobile) {
        this.wMobile = new WeakReference<Mobile>(mobile);
    }

    public void input() {
        if (wMobile.get() == null) return;

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_SHOW_MOBILE.getKey()))
            wMobile.get().setShown(true);
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CANCEL.getKey()) && wMobile.get().isShown())
            wMobile.get().setShown(false);

        inputMobileShown();
    }

    private void inputMobileShown() {
        if (wMobile.get() == null || !wMobile.get().isShown())
            return;

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_NEXT.getKey()))
            wMobile.get().nextScreen();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PREV.getKey()))
            wMobile.get().prevScreen();

        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_MOBILE_PHONEBOOK.getKey()))
            wMobile.get().openClosePhonebook();
    }
}
