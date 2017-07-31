package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.StringEnum;

public class ScreenWin implements IScreen {


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
        layout.setText(font, StringEnum.GAME_WIN.toString());
    }

    @Override
    public void update() {
        //todo implement
    }

    @Override
    public void input() {
        //todo implement
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
