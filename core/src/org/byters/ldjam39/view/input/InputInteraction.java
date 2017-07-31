package org.byters.ldjam39.view.input;

import com.badlogic.gdx.Gdx;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;

import java.lang.ref.WeakReference;

public class InputInteraction {
    private WeakReference<LocationInfoBase> wLocationInfo;

    public InputInteraction(LocationInfoBase locationInfo) {
        wLocationInfo = new WeakReference<LocationInfoBase>(locationInfo);
    }

    public void input() {
        if (wLocationInfo.get() == null) return;
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_INTERACT.getKey()))
            wLocationInfo.get().interact();
    }
}
