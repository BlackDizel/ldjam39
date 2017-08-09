package org.byters.ldjam39.view.input;

import com.badlogic.gdx.Gdx;
import org.byters.ldjam39.model.locationInfo.LocationInfoModalImageInfo;

public class InputModalImage {

    private final LocationInfoModalImageInfo imagesModal;

    public InputModalImage(LocationInfoModalImageInfo imagesModal) {
        this.imagesModal = imagesModal;
    }

    public void input() {
        if (imagesModal == null) return;
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_CANCEL.getKey()))
            imagesModal.cancelImageShow();
    }

    public boolean isBlockInput() {
        return imagesModal != null && imagesModal.isImageModalShow();
    }
}
