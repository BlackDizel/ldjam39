package org.byters.ldjam39.view.input;

import com.badlogic.gdx.Gdx;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;

public class InputInteraction {
    private LocationInfoBase wLocationInfo;

    public InputInteraction(LocationInfoBase locationInfo) {
        wLocationInfo = locationInfo;
    }

    public void input() {
        if (wLocationInfo == null) return;
        if (Gdx.input.isKeyJustPressed(InputEnum.KEY_INTERACT.getKey()))
            wLocationInfo.interact();
    }
}
