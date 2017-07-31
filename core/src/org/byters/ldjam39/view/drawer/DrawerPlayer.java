package org.byters.ldjam39.view.drawer;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import org.byters.engine.controller.ControllerMain;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;

public class DrawerPlayer {

    private static final int FRAMES_NUM_MOVE = 4;
    private static final float FRAME_DURATION_SECONDS = 0.2f;
    private WeakReference<Player> wPlayer;
    private Texture tPlayer;
    private Animation<TextureRegion> aPlayer;
    private Vector2 direction;

    public DrawerPlayer(Player player) {
        this.wPlayer = new WeakReference<Player>(player);
    }

    public void draw(SpriteBatch batch) {
        if (wPlayer.get() == null) return;

        TextureRegion texture = getCurrentFrame();
        batch.draw(texture,
                wPlayer.get().getX(), wPlayer.get().getY()
                , 0, 0,
                texture.getRegionWidth(), texture.getRegionHeight()
                , 1,1,
                0
        );

    }

    private TextureRegion getCurrentFrame() {
        TextureRegion result;
        if (wPlayer.get().isWaiting())
            result = aPlayer.getKeyFrame(0);
        else result = aPlayer.getKeyFrame(ControllerMain.getInstance().getGameTime() / 1000f);
        checkFlip(result);
        return result;
    }

    private void checkFlip(TextureRegion textureRegion) {
        wPlayer.get().getDirection(direction);
        if (direction.x < 0 && !textureRegion.isFlipX()
                || direction.x >= 0 && textureRegion.isFlipX())
            textureRegion.flip(true, false);
    }

    public void load() {
        direction = new Vector2();
        tPlayer = new Texture(TextureEnum.TEXTURE_PLAYER.toString());

        int frameWidth = tPlayer.getWidth() / FRAMES_NUM_MOVE;
        int frameHeight = tPlayer.getHeight();
        TextureRegion[][] frames = TextureRegion.split(tPlayer, frameWidth, frameHeight);
        TextureRegion[] framesMove = new TextureRegion[FRAMES_NUM_MOVE];
        for (int i = 0; i < FRAMES_NUM_MOVE; ++i)
            framesMove[i] = frames[0][i];

        aPlayer = new Animation<TextureRegion>(FRAME_DURATION_SECONDS, framesMove);
        aPlayer.setPlayMode(Animation.PlayMode.LOOP);

    }

    public void dispose() {
        tPlayer.dispose();
    }
}
