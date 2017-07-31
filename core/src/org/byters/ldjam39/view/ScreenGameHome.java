package org.byters.ldjam39.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.model.LocationInfoBase;
import org.byters.ldjam39.model.LocationInfoHome;

public class ScreenGameHome extends ScreenGameBase {

    private LocationInfoHome locationInfo;

    @Override
    public void load(SpriteBatch batch) {
        locationInfo = new LocationInfoHome();
        super.load(batch);
    }

    @Override
    LocationInfoBase getLocationInfo() {
        return locationInfo;
    }
}
