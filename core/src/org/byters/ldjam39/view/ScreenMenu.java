package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.model.PointInt;
import org.byters.engine.view.IScreen;
import org.byters.engine.view.util.InputHelper;
import org.byters.ldjam39.controller.ControllerWorldState;

public class ScreenMenu implements IScreen {

    private Texture tStart;
    private PointInt position;

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tStart, position.x, position.y);
    }

    @Override
    public void load(SpriteBatch batch) {
        tStart = new Texture(Gdx.files.internal(TextureEnum.BUTTON_START.toString()));
        position = new PointInt();
        position.x = (ControllerCamera.getInstance().getCameraWidth() - tStart.getWidth()) / 2;
        position.y = (ControllerCamera.getInstance().getCameraHeight() - tStart.getHeight()) / 2;
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {
        if (!Gdx.input.justTouched()) return;

        if (InputHelper.isContainsPointer(tStart, position.x, position.y)) {
            ControllerWorldState.getInstance().startTimer();
            ControllerMain.getInstance().navigateScreen(new ScreenGameHome());
        }

    }

    @Override
    public void dispose() {
        tStart.dispose();
    }
}
