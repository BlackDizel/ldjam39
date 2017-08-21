package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerMain;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;

public class DrawerLocation {
    private static final float MESSAGE_POSITION_Y = ControllerCamera.getInstance().getCameraHeight() - 10;
    private LocationInfoBase wLocationInfo;
    private Mobile mobile;

    private Texture tBackground;
    private Texture tBackgroundSky;
    private BitmapFont font;

    private GlyphLayout layout;

    private ArrayList<Texture> listInteractedObject;
    private ArrayList<Animation<TextureRegion>> listAnimation;
    private ArrayList<Texture> listAnimationTextures;

    public DrawerLocation(LocationInfoBase locationInfo, Mobile mobile) {
        wLocationInfo = locationInfo;
        this.mobile = mobile;
    }

    public void load() {
        if (wLocationInfo == null) return;
        font = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
        layout = new GlyphLayout();
        tBackground = new Texture(wLocationInfo.getBackground());
        tBackgroundSky = new Texture(TextureEnum.TEXTURE_BACKGROUND_SKY.toString());

        listInteractedObject = new ArrayList<Texture>();
        for (int i = 0; i < wLocationInfo.getInteractedObjectsNum(); ++i) {
            String tItem = wLocationInfo.getInteractedObjectTexturePath(i);
            listInteractedObject.add(tItem == null || tItem.isEmpty() ? null : new Texture(tItem));
        }

        initAnimation();
    }

    private void initAnimation() {
        listAnimationTextures = new ArrayList<Texture>();
        listAnimation = new ArrayList<Animation<TextureRegion>>();
        for (int i = 0; i < wLocationInfo.getAnimationsNum(); ++i) {

            int framesNum = wLocationInfo.getAnimationInfo(i).getFramesNum();

            TextureEnum texturePath = wLocationInfo.getAnimationInfo(i).getTexturePath();
            Texture texture = new Texture(Gdx.files.internal(texturePath.toString()));
            listAnimationTextures.add(texture);

            int frameWidth = texture.getWidth() / framesNum;
            int frameHeight = texture.getHeight();
            TextureRegion[][] frames = TextureRegion.split(texture, frameWidth, frameHeight);

            TextureRegion[] frameAnim = new TextureRegion[framesNum];
            for (int j = 0; j < framesNum; ++j)
                frameAnim[j] = frames[0][j];

            Animation<TextureRegion> animation = new Animation<TextureRegion>(0.2f, frameAnim);
            animation.setPlayMode(Animation.PlayMode.LOOP);
            listAnimation.add(animation);
        }
    }

    public void dispose() {
        wLocationInfo = null;
        tBackground.dispose();
        tBackgroundSky.dispose();
        font.dispose();
        for (int i = 0; i < listInteractedObject.size(); ++i)
            if (listInteractedObject.get(i) != null)
                listInteractedObject.get(i).dispose();

        for (int i = 0; i < listAnimationTextures.size(); ++i) {
            listAnimationTextures.get(i).dispose();
        }
    }

    public void draw(SpriteBatch batch) {
        if (wLocationInfo == null) return;
        batch.draw(tBackgroundSky, wLocationInfo.getSkyPosXFirst(), wLocationInfo.getSkyPosY());
        batch.draw(tBackgroundSky, wLocationInfo.getSkyPosXSecond(), wLocationInfo.getSkyPosY());
        batch.draw(tBackground, 0, 1);

        drawAnimations(batch);

        drawItems(batch);
        drawStringInfo(batch);
    }

    private TextureRegion getCurrentFrame(Animation<TextureRegion> animation) {
        return animation.getKeyFrame(ControllerMain.getInstance().getGameTime() / 1000f);
    }

    private void drawAnimations(SpriteBatch batch) {
        if (listAnimation == null) return;
        for (int i = 0; i < listAnimation.size(); ++i)
            batch.draw(getCurrentFrame(listAnimation.get(i)),
                    wLocationInfo.getAnimationInfo(i).getX(),
                    wLocationInfo.getAnimationInfo(i).getY());
    }

    private void drawStringInfo(SpriteBatch batch) {
        if (wLocationInfo == null || mobile == null) return;

        if (mobile.isShown()) return;
        String message = wLocationInfo.getMessage();
        if (message == null || message.isEmpty()) return;

        layout.setText(font, message);

        font.draw(batch, layout
                , ControllerWorld.getInstance().getPositionIgnoreCameraX(-layout.width / 2),
                MESSAGE_POSITION_Y);
    }

    private void drawItems(SpriteBatch batch) {
        if (wLocationInfo == null) return;

        for (int i = 0; i < wLocationInfo.getInteractedObjectsNum(); ++i) {
            if (!wLocationInfo.isDrawableObjectExist(i)) continue;

            Texture t = listInteractedObject.get(i);
            if (t == null) continue;

            batch.draw(t, wLocationInfo.getInteractedObjectPositionX(i),
                    wLocationInfo.getInteractedObjectPositionY(i));
        }
    }
}
