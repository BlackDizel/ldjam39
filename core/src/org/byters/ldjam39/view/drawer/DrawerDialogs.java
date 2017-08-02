package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorldState;
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
        String message = ControllerWorldState.getInstance().getMessageDialog();
        if (message == null || message.isEmpty())
            return;

        layout.setText(font, message);
        font.draw(batch, layout, wPlayer.getOriginX() - layout.width / 2,
                wPlayer.getY() + wPlayer.getHeight() + 8);
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
