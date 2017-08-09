package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;

public class LocationInfoModalImageInfo {

    public static final int NO_VALUE = -1;
    private ArrayList<ModalImageInfo> data;
    private ArrayList<ModalImageInfo> itemsAvailable;

    public LocationInfoModalImageInfo(ArrayList<ModalImageInfo> data) {
        this.data = data;
        resetCache();
    }

    public void resetCache() {
        itemsAvailable = null;
        if (data == null) return;

        for (ModalImageInfo item : data)
            if (item.isAvailable()) {
                if (itemsAvailable == null) itemsAvailable = new ArrayList<ModalImageInfo>();
                itemsAvailable.add(item);
            }
    }

    public boolean isListImagesModalExist() {
        return itemsAvailable != null && itemsAvailable.size() > 0;
    }

    public int getListImagesModalSize() {
        return itemsAvailable == null ? 0 : itemsAvailable.size();
    }

    public TextureEnum getListImageModalTextureEnum(int pos) {
        return itemsAvailable == null || pos < 0 || pos >= itemsAvailable.size()
                ? null
                : itemsAvailable.get(pos).getTextureEnum();
    }

    public boolean isImageModalShow() {
        return getImageModalCurrentPosition() != NO_VALUE;
    }

    public int getImageModalCurrentPosition() {
        if (itemsAvailable == null) return NO_VALUE;
        for (int i = 0; i < itemsAvailable.size(); ++i)
            if (itemsAvailable.get(i).isShow()) return i;
        return NO_VALUE;
    }

    public void cancelImageShow() {
        int pos = getImageModalCurrentPosition();
        if (pos == NO_VALUE) return;

        itemsAvailable.get(pos).cancelShow();
        resetCache();
    }
}
