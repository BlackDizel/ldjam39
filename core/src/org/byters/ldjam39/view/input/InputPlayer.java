package org.byters.ldjam39.view.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.byters.ldjam39.controller.util.CollisionEnvironment;
import org.byters.ldjam39.model.Player;

public class InputPlayer {
    private Player wPlayer;
    private CollisionEnvironment wCollistionEnvironment;

    private Vector2 direction;

    public InputPlayer(Player player) {
        this.wPlayer = player;
        direction = new Vector2();
    }

    public void resetInput() {
        if (wPlayer == null) return;

        wPlayer.stop();
    }

    public void input() {
        if (wPlayer == null
                || wCollistionEnvironment == null) return;

        direction.x = 0;
        direction.y = 0;

        boolean isRun = false;// Gdx.input.isKeyPressed(InputEnum.KEY_RUN.getKey());

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_LEFT.getKey()))
            direction.x = -1;

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_RIGHT.getKey()))
            direction.x = 1;

       /* if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_UP.getKey()))
            direction.y = 1;

        if (Gdx.input.isKeyPressed(InputEnum.KEY_MOVE_DOWN.getKey()))
            direction.y = -1;
        */

        float len = direction.len();
        if (len == 0)
            wPlayer.stop();
        else {
            direction.x /= len;
            direction.y /= len;

            if (!wCollistionEnvironment.isCollide(
                    (int) wPlayer.calcX(direction, isRun),
                    (int) wPlayer.calcY(direction, isRun),
                    wPlayer.getWidth(),
                    wPlayer.getHeight()))
                wPlayer.move(direction, isRun);
        }
    }

    public void setCollisionEnvironment(CollisionEnvironment collisionEnvironment) {
        this.wCollistionEnvironment = collisionEnvironment;
    }
}
