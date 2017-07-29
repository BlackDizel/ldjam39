package org.byters.ldjam39.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.util.CollisionEnvironment;
import org.byters.ldjam39.model.GameEnvironment;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.view.util.InputMobile;
import org.byters.ldjam39.view.util.InputPlayer;

public class ScreenGame implements IScreen {

    private InputPlayer inputPlayer;
    private DrawerPlayer drawerPlayer;
    private Player player;
    private GameEnvironment environment;
    private CollisionEnvironment collisionEnvironment;
    private DrawerEnvironment drawerEnvironment;

    private Mobile mobile;
    private DrawerMobile drawerMobile;
    private InputMobile inputMobile;

    @Override
    public void draw(SpriteBatch batch) {
        drawerPlayer.draw(batch);
        drawerEnvironment.draw(batch);
        drawerMobile.draw(batch);
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

        mobile = new Mobile();
        drawerMobile = new DrawerMobile(mobile);
        drawerMobile.load();
        inputMobile = new InputMobile(mobile);
    }

    @Override
    public void update() {
        ControllerCamera.getInstance().setPosition(ControllerWorld.getInstance().getPositionX(player.getX()),
                ControllerWorld.getInstance().getPositionY(player.getY()), 0);
    }

    @Override
    public void input() {
        inputPlayer.input();
        inputMobile.input();
    }

    @Override
    public void dispose() {
        drawerPlayer.dispose();
        drawerEnvironment.dispose();
        drawerMobile.dispose();
    }
}
