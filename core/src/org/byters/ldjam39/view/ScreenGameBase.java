package org.byters.ldjam39.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.InteractionLocation;
import org.byters.ldjam39.controller.util.CollisionEnvironment;
import org.byters.ldjam39.model.GameEnvironment;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.drawer.DrawerEnvironment;
import org.byters.ldjam39.view.drawer.DrawerLocation;
import org.byters.ldjam39.view.drawer.DrawerMobile;
import org.byters.ldjam39.view.drawer.DrawerPlayer;
import org.byters.ldjam39.view.input.InputInteraction;
import org.byters.ldjam39.view.input.InputMobile;
import org.byters.ldjam39.view.input.InputPlayer;

public abstract class ScreenGameBase implements IScreen {

    private int playerPosInitX;
    private int playerPosInitY;

    private Player player;
    private GameEnvironment environment;
    private Mobile mobile;
    private DrawerMobile drawerMobile;
    private DrawerEnvironment drawerEnvironment;
    private DrawerLocation drawerLocation;
    private DrawerPlayer drawerPlayer;
    private CollisionEnvironment collisionEnvironment;
    private InputMobile inputMobile;
    private InputInteraction inputInteraction;
    private InputPlayer inputPlayer;
    private InteractionLocation interactionLocation;

    ScreenGameBase(int playerInitX, int playerInitY) {
        this.playerPosInitX = playerInitX;
        this.playerPosInitY = playerInitY;
    }

    abstract LocationInfoBase getLocationInfo();

    @Override
    public void draw(SpriteBatch batch) {
        drawerLocation.draw(batch);
        drawerEnvironment.draw(batch);
        drawerPlayer.draw(batch);
        drawerMobile.draw(batch);
    }

    @Override
    public void load(SpriteBatch batch) {
        getLocationInfo().load();

        player = new Player(playerPosInitX, playerPosInitY);
        mobile = new Mobile();
        environment = new GameEnvironment(getLocationInfo());
        collisionEnvironment = new CollisionEnvironment(environment);

        /*region drawers*/
        drawerEnvironment = new DrawerEnvironment(environment);
        drawerEnvironment.load();

        drawerPlayer = new DrawerPlayer(player);
        drawerPlayer.load();

        drawerMobile = new DrawerMobile(mobile);
        drawerMobile.load();

        drawerLocation = new DrawerLocation(getLocationInfo());
        drawerLocation.load();
        /*endregion*/

        /*region input*/
        inputMobile = new InputMobile(mobile);

        inputPlayer = new InputPlayer(player);
        inputPlayer.setCollisionEnvironment(collisionEnvironment);

        inputInteraction = new InputInteraction(getLocationInfo());
        /*endregion*/

        interactionLocation = new InteractionLocation(getLocationInfo());
    }

    @Override
    public void update() {
        ControllerCamera.getInstance().setPosition(player.getOriginX(),
                56, 0);

        getLocationInfo().updateInteractMessage(player.getOriginX());
        interactionLocation.checkInteraction();
    }

    @Override
    public void input() {
        inputPlayer.input();
        inputMobile.input();
        inputInteraction.input();
    }

    @Override
    public void dispose() {
        drawerPlayer.dispose();
        drawerEnvironment.dispose();
        drawerMobile.dispose();
        drawerLocation.dispose();
    }
}
