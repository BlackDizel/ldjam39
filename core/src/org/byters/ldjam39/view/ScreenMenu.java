package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.engine.view.util.InputHelper;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.view.input.InputEnum;

public class ScreenMenu implements IScreen {

    private Texture tStart;

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tStart, 0, 0);
    }

    @Override
    public void load(SpriteBatch batch) {
        tStart = new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MENU.toString()));
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CONFIRM.getKey())) {
            ScreenGameBase.loadMusic();
            ControllerMain.getInstance().navigateScreen(new ScreenGameHome());
        }

        if (!Gdx.input.justTouched()) return;

        if (InputHelper.isContainsPointer(74, 32, 46, 12)) {
            ControllerWorldState.getInstance().startTimer();
            {
                ScreenGameBase.loadMusic();
                ControllerMain.getInstance().navigateScreen(new ScreenGameHome());
            }
        }

        if (InputHelper.isContainsPointer(74, 18, 46, 12))
            Gdx.app.exit();
    }

    @Override
    public void dispose() {
        tStart.dispose();
    }
}
