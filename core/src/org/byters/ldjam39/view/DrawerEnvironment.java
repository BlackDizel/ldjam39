package org.byters.ldjam39.view;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.GameEnvironment;

import java.lang.ref.WeakReference;

class DrawerEnvironment {

    private Texture tBox;
    private WeakReference<GameEnvironment> wEnvironment;

    DrawerEnvironment(GameEnvironment environment) {
        wEnvironment = new WeakReference<GameEnvironment>(environment);
    }

    void draw(SpriteBatch batch) {
        if (wEnvironment.get() == null) return;

        for (int i = 0; i < wEnvironment.get().getBoxNum();++i)
            batch.draw(tBox, ControllerWorld.getInstance().getPositionX(wEnvironment.get().getBoxX(i)),
                    ControllerWorld.getInstance().getPositionY(wEnvironment.get().getBoxY(i)));
    }

    void dispose() {
        tBox.dispose();
    }

    void load() {
        tBox = new Texture(TextureEnum.TEXTURE_BOX.toString());
    }
}
