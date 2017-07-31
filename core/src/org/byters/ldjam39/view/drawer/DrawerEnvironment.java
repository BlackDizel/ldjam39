package org.byters.ldjam39.view.drawer;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.GameEnvironment;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;

public class DrawerEnvironment {

    private Texture tBox;
    private WeakReference<GameEnvironment> wEnvironment;

    public DrawerEnvironment(GameEnvironment environment) {
        wEnvironment = new WeakReference<GameEnvironment>(environment);
    }

    public void draw(SpriteBatch batch) {
        if (wEnvironment.get() == null) return;

        for (int i = 0; i < wEnvironment.get().getBoxNum();++i)
            batch.draw(tBox, ControllerWorld.getInstance().getPositionX(wEnvironment.get().getBoxX(i)),
                    ControllerWorld.getInstance().getPositionY(wEnvironment.get().getBoxY(i)));
    }

    public void dispose() {
        tBox.dispose();
    }

    public void load() {
        tBox = new Texture(TextureEnum.TEXTURE_BOX.toString());
    }
}
