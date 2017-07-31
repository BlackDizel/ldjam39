package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class DrawerLocation {
    private static final float MESSAGE_POSITION_Y = 108;
    private WeakReference<LocationInfoBase> wLocationInfo;

    private Texture tBackground;
    private BitmapFont font;

    private GlyphLayout layout;

    private ArrayList<Texture> listInteractedObject;

    public DrawerLocation(LocationInfoBase locationInfo) {
        wLocationInfo = new WeakReference<LocationInfoBase>(locationInfo);
    }

    public void load() {
        if (wLocationInfo.get() == null) return;
        font = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
        layout = new GlyphLayout();
        tBackground = new Texture(wLocationInfo.get().getBackground());

        listInteractedObject = new ArrayList<Texture>();
        for (int i = 0; i < wLocationInfo.get().getInteractedObjectsNum(); ++i) {
            String tItem = wLocationInfo.get().getInteractedObjectTexturePath(i);
            listInteractedObject.add(tItem == null || tItem.isEmpty() ? null : new Texture(tItem));
        }
    }

    public void dispose() {
        tBackground.dispose();
        font.dispose();
        for (int i = 0; i < listInteractedObject.size(); ++i)
            if (listInteractedObject.get(i) != null)
                listInteractedObject.get(i).dispose();
    }

    public void draw(SpriteBatch batch) {
        if (wLocationInfo.get() == null) return;
        batch.draw(tBackground, 0, 1);

        drawItems(batch);
        drawStringInfo(batch);
    }

    private void drawStringInfo(SpriteBatch batch) {
        if (wLocationInfo.get() == null) return;
        String message = wLocationInfo.get().getMessage();
        if (message == null || message.isEmpty()) return;

        layout.setText(font, message);

        font.draw(batch, layout
                , ControllerWorld.getInstance().getPositionIgnoreCameraX(-layout.width / 2),
                MESSAGE_POSITION_Y);
    }

    private void drawItems(SpriteBatch batch) {
        if (wLocationInfo.get() == null) return;

        for (int i = 0; i < wLocationInfo.get().getInteractedObjectsNum(); ++i) {
            if (!wLocationInfo.get().isDrawableObjectExist(i)) continue;

            Texture t = listInteractedObject.get(i);
            if (t == null) continue;

            batch.draw(t, wLocationInfo.get().getInteractedObjectPositionX(i),
                    wLocationInfo.get().getInteractedObjectPositionY(i));
        }
    }
}
