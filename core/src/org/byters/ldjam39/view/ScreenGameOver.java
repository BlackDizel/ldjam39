package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.view.input.InputEnum;

public class ScreenGameOver implements IScreen {
    @Override
    public void draw(SpriteBatch batch) {
        //todo implement
    }

    @Override
    public void load(SpriteBatch batch) {
        ControllerWorldState.getInstance().reset();
        //todo implement
    }

    @Override
    public void update() {
        //todo implement
    }

    @Override
    public void input() {
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CONFIRM.getKey()))
            ControllerMain.getInstance().navigateScreen(new ScreenMenu());
    }

    @Override
    public void dispose() {
        //todo implement
    }
}
