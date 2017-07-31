package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;

public class DrawerMobile {
    private static final float POSITION_X = 60;
    private static final float POSITION_Y_SHOWN = -300;
    private static final float POSITION_Y = -500;
    private WeakReference<Mobile> wMobile;

    private Texture tMobile;

    public DrawerMobile(Mobile mobile) {
        this.wMobile = new WeakReference<Mobile>(mobile);

    }

    public void draw(SpriteBatch batch) {
        if (wMobile.get() == null) return;
        batch.draw(tMobile, ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X),
                ControllerWorld.getInstance().getPositionIgnoreCameraY(wMobile.get().isShown() ? POSITION_Y_SHOWN : POSITION_Y));
    }

    public void load() {
        tMobile = new Texture(TextureEnum.TEXTURE_MOBILE.toString());
    }

    public void dispose() {
        tMobile.dispose();
    }
}
