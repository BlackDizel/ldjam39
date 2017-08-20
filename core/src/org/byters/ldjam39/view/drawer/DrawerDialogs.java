package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.DialogMessage;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.view.TextureEnum;

public class DrawerDialogs {

    private Player wPlayer;
    private BitmapFont font;
    private GlyphLayout layout;

    public DrawerDialogs(Player player) {
        this.wPlayer = player;
    }

    public void draw(SpriteBatch batch) {
        DialogMessage message = ControllerWorldState.getInstance().getMessageDialog();
        if (message == null
                || message.getMessage() == null
                || message.getMessage().isEmpty())
            return;


        layout.setText(font, message.getMessage());

        float x = message.isPlayer() ? wPlayer.getOriginX() - layout.width / 2 : message.getX();
        float y = message.isPlayer() ? wPlayer.getY() + wPlayer.getHeight() + 8 : message.getY();

        x = Math.max(x, ControllerCamera.getInstance().getCameraPositionX() - ControllerCamera.getInstance().getCameraWidth() / 2);
        x = Math.min(x, ControllerCamera.getInstance().getCameraPositionX() + ControllerCamera.getInstance().getCameraWidth() / 2 - layout.width);

        font.draw(batch, layout, x, y);
    }

    public void dispose() {
        font.dispose();
        wPlayer = null;
    }

    public void load() {
        font = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
        layout = new GlyphLayout();
    }
}
