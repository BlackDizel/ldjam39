package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.engine.view.util.InputHelper;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.view.input.InputEnum;

public class ScreenGameOver implements IScreen {

    private Texture tGameOver;

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tGameOver, 0, 0);
    }

    @Override
    public void load(SpriteBatch batch) {
        ControllerWorldState.getInstance().reset();
        tGameOver = new Texture(Gdx.files.internal(TextureEnum.TEXTURE_GAMEOVER.toString()));
    }

    @Override
    public void update() {
    }

    @Override
    public void input() {
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CONFIRM.getKey()))
            ControllerMain.getInstance().navigateScreen(new ScreenMenu());

        if (!Gdx.input.justTouched()) return;
        if (InputHelper.isContainsPointer(32, 30, 42, 14))
            ControllerMain.getInstance().navigateScreen(new ScreenMenu());
    }

    @Override
    public void dispose() {
        tGameOver.dispose();
    }
}
