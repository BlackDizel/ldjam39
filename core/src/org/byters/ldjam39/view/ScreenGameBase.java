package org.byters.ldjam39.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.controller.InteractionLocation;
import org.byters.ldjam39.controller.util.CollisionEnvironment;
import org.byters.ldjam39.model.GameEnvironment;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.drawer.*;
import org.byters.ldjam39.view.input.InputInteraction;
import org.byters.ldjam39.view.input.InputMobile;
import org.byters.ldjam39.view.input.InputModalImage;
import org.byters.ldjam39.view.input.InputPlayer;

public abstract class ScreenGameBase implements IScreen {

    private static Music music;
    private int playerPosInitX;
    private int playerPosInitY;
    private Player player;
    private GameEnvironment environment;
    private Mobile mobile;

    private DrawerMobile drawerMobile;
    private DrawerEnvironment drawerEnvironment;
    private DrawerLocation drawerLocation;
    private DrawerPlayer drawerPlayer;
    private DrawerDialogs drawerDialogs;
    private DrawerModalImage drawerModalImage;

    private CollisionEnvironment collisionEnvironment;

    private InputMobile inputMobile;
    private InputInteraction inputInteraction;
    private InputPlayer inputPlayer;
    private InputModalImage inputModalImage;

    private InteractionLocation interactionLocation;

    ScreenGameBase(int playerInitX, int playerInitY) {
        this.playerPosInitX = playerInitX;
        this.playerPosInitY = playerInitY;
    }

    public static void loadMusic() {
        music = Gdx.audio.newMusic(Gdx.files.internal(TextureEnum.FILE_MUSIC.toString()));
        music.setLooping(true);
        music.play();
    }

    public static void disposeMusic() {
        music.dispose();
    }

    abstract LocationInfoBase getLocationInfo();

    @Override
    public void draw(SpriteBatch batch) {
        drawerLocation.draw(batch);
        drawerEnvironment.draw(batch);
        drawerPlayer.draw(batch);
        drawerDialogs.draw(batch);
        drawerMobile.draw(batch);
        drawerModalImage.draw(batch);
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

        drawerModalImage = new DrawerModalImage(getLocationInfo().getImagesModal(), player);
        drawerModalImage.load();
        /*endregion*/

        /*region input*/
        inputMobile = new InputMobile(mobile);

        inputPlayer = new InputPlayer(player);
        inputPlayer.setCollisionEnvironment(collisionEnvironment);

        inputInteraction = new InputInteraction(getLocationInfo());

        inputModalImage = new InputModalImage(getLocationInfo().getImagesModal());
        /*endregion*/

        drawerDialogs = new DrawerDialogs(player);
        drawerDialogs.load();

        interactionLocation = new InteractionLocation(getLocationInfo());
    }

    @Override
    public void update() {
        int halfCameraWidth = ControllerCamera.getInstance().getCameraWidth() / 2;
        float x = Math.min(Math.max(player.getOriginX(), halfCameraWidth), getLocationInfo().getRightBoundPositionX() - halfCameraWidth);
        ControllerCamera.getInstance().setPosition(x,
                ControllerCamera.getInstance().getCameraHeight() / 2, 0);

        getLocationInfo().update();
        getLocationInfo().updateInteractMessage(player.getOriginX());
        interactionLocation.checkInteraction();

        if (ControllerWorldState.getInstance().isBatteryEnd()) {
            disposeMusic();
            ControllerMain.getInstance().navigateScreen(new ScreenGameOver());
        }

        if (ControllerWorldState.getInstance().isAllTasksCompleted()) {
            disposeMusic();
            ControllerMain.getInstance().navigateScreen(new ScreenWin());
        }
    }

    @Override
    public void input() {
        inputModalImage.input();
        if (inputModalImage.isBlockInput())
            return;

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
        drawerDialogs.dispose();
        drawerModalImage.dispose();
        getLocationInfo().dispose();
    }
}
