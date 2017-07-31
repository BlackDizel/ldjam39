package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.StringEnum;
import org.byters.ldjam39.view.input.InputEnum;

public class ScreenGameOver implements IScreen {

    private BitmapFont font;
    private GlyphLayout layout;

    @Override
    public void draw(SpriteBatch batch) {
        font.draw(batch, layout
                , ControllerWorld.getInstance().getPositionIgnoreCameraX(-layout.width / 2),
                (ControllerCamera.getInstance().getCameraHeight() + layout.height) / 2);
    }

    @Override
    public void load(SpriteBatch batch) {
        ControllerWorldState.getInstance().reset();

        font = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
        layout = new GlyphLayout();
        layout.setText(font, StringEnum.GAME_OVER.toString());
    }

    @Override
    public void update() {
    }

    @Override
    public void input() {
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CONFIRM.getKey()))
            ControllerMain.getInstance().navigateScreen(new ScreenMenu());
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
