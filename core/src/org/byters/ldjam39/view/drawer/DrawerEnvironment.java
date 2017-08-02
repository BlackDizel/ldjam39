package org.byters.ldjam39.view.drawer;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.model.GameEnvironment;
import org.byters.ldjam39.view.TextureEnum;

public class DrawerEnvironment {

    private Texture tBox;
    private GameEnvironment wEnvironment;

    public DrawerEnvironment(GameEnvironment environment) {
        wEnvironment = environment;
    }

    public void draw(SpriteBatch batch) {
        if (wEnvironment == null) return;

        for (int i = 0; i < wEnvironment.getBoxNum(); ++i)
            batch.draw(tBox, wEnvironment.getBoxX(i), wEnvironment.getBoxY(i));
    }

    public void dispose() {
        wEnvironment = null;
        tBox.dispose();
    }

    public void load() {
        tBox = new Texture(TextureEnum.TEXTURE_BOX.toString());
    }
}
