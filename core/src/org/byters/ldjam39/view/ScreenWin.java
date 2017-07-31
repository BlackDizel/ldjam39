package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.engine.view.util.InputHelper;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.view.input.InputEnum;

public class ScreenWin implements IScreen {


    private Texture tWin;

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tWin, 0, 0);
    }

    @Override
    public void load(SpriteBatch batch) {

        ControllerWorldState.getInstance().reset();

        tWin = new Texture(Gdx.files.internal(TextureEnum.TEXTURE_WIN.toString()));
    }

    @Override
    public void update() {
        //todo implement
    }

    @Override
    public void input() {
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CONFIRM.getKey()))
            ControllerMain.getInstance().navigateScreen(new ScreenMenu());

        if (!Gdx.input.justTouched()) return;
        if (InputHelper.isContainsPointer(112, 34, 44, 12))
            ControllerMain.getInstance().navigateScreen(new ScreenMenu());
    }

    @Override
    public void dispose() {
        tWin.dispose();
    }
}
