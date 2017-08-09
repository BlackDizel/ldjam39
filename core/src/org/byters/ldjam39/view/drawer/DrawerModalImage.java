package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.ldjam39.model.Player;
import org.byters.ldjam39.model.StringEnum;
import org.byters.ldjam39.model.locationInfo.LocationInfoModalImageInfo;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;

public class DrawerModalImage {

    private LocationInfoModalImageInfo locationInfoImagesModal;
    private Player player;

    private ArrayList<Texture> listTexture;
    private BitmapFont bitmapFont;

    public DrawerModalImage(LocationInfoModalImageInfo locationInfoBase, Player player) {
        this.locationInfoImagesModal = locationInfoBase;
        this.player = player;
    }

    public void load() {
        if (locationInfoImagesModal == null || !locationInfoImagesModal.isListImagesModalExist())
            return;

        listTexture = new ArrayList<Texture>();
        for (int i = 0; i < locationInfoImagesModal.getListImagesModalSize(); ++i) {
            String filename = locationInfoImagesModal.getListImageModalTextureEnum(i).toString();
            listTexture.add(new Texture(Gdx.files.internal(filename)));
        }
        bitmapFont = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
    }

    public void draw(SpriteBatch batch) {
        if (locationInfoImagesModal == null) return;
        int pos = locationInfoImagesModal.getImageModalCurrentPosition();
        if (pos == LocationInfoModalImageInfo.NO_VALUE)
            return;

        Texture texture = listTexture.get(pos);
        batch.draw(texture,
                player.getOriginX() - texture.getWidth() / 2 - ControllerCamera.getInstance().getCameraWidth() / 4,
                (ControllerCamera.getInstance().getCameraHeight() - texture.getHeight()) / 2);

        bitmapFont.draw(batch, StringEnum.CLOSE_IMAGE_MODAL.toString(),
                player.getOriginX() - ControllerCamera.getInstance().getCameraWidth() / 2.2f,
                ControllerCamera.getInstance().getCameraHeight() / 8);
    }

    public void dispose() {
        if (bitmapFont != null) bitmapFont.dispose();
        if (listTexture == null) return;
        for (Texture texture : listTexture)
            texture.dispose();
    }
}
