package org.byters.ldjam39.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.util.CollisionEnvironment;
import org.byters.ldjam39.model.GameEnvironment;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.view.util.InputPlayer;

public class ScreenGame implements IScreen {

    private InputPlayer inputPlayer;
    private DrawerPlayer drawerPlayer;
    private Player player;
    private GameEnvironment environment;
    private CollisionEnvironment collisionEnvironment;
    private DrawerEnvironment drawerEnvironment;

    @Override
    public void draw(SpriteBatch batch) {
        drawerPlayer.draw(batch);
        drawerEnvironment.draw(batch);
    }

    @Override
    public void load(SpriteBatch batch) {
        player = new Player();
        inputPlayer = new InputPlayer(player);

        environment = new GameEnvironment();
        collisionEnvironment = new CollisionEnvironment(environment);
        inputPlayer.setCollisionEnvironment(collisionEnvironment);

        drawerEnvironment = new DrawerEnvironment(environment);
        drawerEnvironment.load();

        drawerPlayer = new DrawerPlayer(player);
        drawerPlayer.load();
    }

    @Override
    public void update() {
        ControllerCamera.getInstance().setPosition(ControllerWorld.getInstance().getPositionX(player.getX()),
                ControllerWorld.getInstance().getPositionY(player.getY()), 0);
    }

    @Override
    public void input() {
        inputPlayer.input();
    }

    @Override
    public void dispose() {
        drawerPlayer.dispose();
        drawerEnvironment.dispose();
    }
}
