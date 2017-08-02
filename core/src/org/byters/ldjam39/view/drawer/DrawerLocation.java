package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;

public class DrawerLocation {
    private static final float MESSAGE_POSITION_Y = ControllerCamera.getInstance().getCameraHeight() - 2;
    private LocationInfoBase wLocationInfo;

    private Texture tBackground;
    private BitmapFont font;

    private GlyphLayout layout;

    private ArrayList<Texture> listInteractedObject;

    public DrawerLocation(LocationInfoBase locationInfo) {
        wLocationInfo = locationInfo;
    }

    public void load() {
        if (wLocationInfo == null) return;
        font = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
        layout = new GlyphLayout();
        tBackground = new Texture(wLocationInfo.getBackground());

        listInteractedObject = new ArrayList<Texture>();
        for (int i = 0; i < wLocationInfo.getInteractedObjectsNum(); ++i) {
            String tItem = wLocationInfo.getInteractedObjectTexturePath(i);
            listInteractedObject.add(tItem == null || tItem.isEmpty() ? null : new Texture(tItem));
        }
    }

    public void dispose() {
        wLocationInfo = null;
        tBackground.dispose();
        font.dispose();
        for (int i = 0; i < listInteractedObject.size(); ++i)
            if (listInteractedObject.get(i) != null)
                listInteractedObject.get(i).dispose();
    }

    public void draw(SpriteBatch batch) {
        if (wLocationInfo == null) return;
        batch.draw(tBackground, 0, 1);

        drawItems(batch);
        drawStringInfo(batch);
    }

    private void drawStringInfo(SpriteBatch batch) {
        if (wLocationInfo == null) return;
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
