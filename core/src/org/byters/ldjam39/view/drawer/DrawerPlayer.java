package org.byters.ldjam39.view.drawer;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;

public class DrawerPlayer {

    private WeakReference<Player> wPlayer;
    private Texture tPlayer;

    public DrawerPlayer(Player player) {
        this.wPlayer = new WeakReference<Player>(player);
    }

    public void draw(SpriteBatch batch) {
        if (wPlayer.get()==null) return;
        batch.draw(tPlayer, ControllerWorld.getInstance().getPositionX(wPlayer.get().getX()),
                ControllerWorld.getInstance().getPositionY(wPlayer.get().getY()));
    }

    public void load() {
        tPlayer = new Texture(TextureEnum.TEXTURE_PLAYER.toString());
    }

    public void dispose() {
        tPlayer.dispose();
    }
}
