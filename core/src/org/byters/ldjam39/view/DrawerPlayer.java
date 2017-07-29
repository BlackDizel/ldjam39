package org.byters.ldjam39.view;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.Player;

import java.lang.ref.WeakReference;

class DrawerPlayer {

    private WeakReference<Player> wPlayer;
    private Texture tPlayer;

    DrawerPlayer(Player player) {
        this.wPlayer = new WeakReference<Player>(player);
    }

    void draw(SpriteBatch batch) {
        if (wPlayer.get()==null) return;
        batch.draw(tPlayer, ControllerWorld.getInstance().getPositionX(wPlayer.get().getX()),
                ControllerWorld.getInstance().getPositionY(wPlayer.get().getY()));
    }

    void load() {
        tPlayer = new Texture(TextureEnum.TEXTURE_PLAYER.toString());
    }

    void dispose() {
        tPlayer.dispose();
    }
}
