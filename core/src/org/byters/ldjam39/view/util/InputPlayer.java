package org.byters.ldjam39.view.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.byters.ldjam39.controller.util.CollisionEnvironment;
import org.byters.ldjam39.model.Player;

import java.lang.ref.WeakReference;

public class InputPlayer {
    private WeakReference<Player> wPlayer;
    private WeakReference<CollisionEnvironment> wCollistionEnvironment;

    private Vector2 direction;

    public InputPlayer(Player player) {
        this.wPlayer = new WeakReference<Player>(player);
        direction = new Vector2();
    }

    public void input() {
        if (wPlayer.get() == null
                || wCollistionEnvironment.get() == null) return;

        direction.x = 0;
        direction.y = 0;

        boolean isRun = Gdx.input.isKeyPressed(InputEnum.KEY_RUN.getKey());

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_LEFT.getKey()))
            direction.x = -1;

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_RIGHT.getKey()))
            direction.x = 1;

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_UP.getKey()))
            direction.y = 1;

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_DOWN.getKey()))
            direction.y = -1;

        float len = direction.len();
        if (len == 0)
            wPlayer.get().stop();
        else {
            direction.x /= len;
            direction.y /= len;

            if (!wCollistionEnvironment.get().isCollide(
                    (int) wPlayer.get().calcX(direction, isRun),
                    (int) wPlayer.get().calcY(direction, isRun),
                    wPlayer.get().getWidth(),
                    wPlayer.get().getHeight()))
                wPlayer.get().move(direction, isRun);
        }
    }

    public void setCollisionEnvironment(CollisionEnvironment collisionEnvironment) {
        this.wCollistionEnvironment = new WeakReference<CollisionEnvironment>(collisionEnvironment);
    }
}
