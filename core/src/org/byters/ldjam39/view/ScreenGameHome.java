package org.byters.ldjam39.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.locationInfo.LocationInfoHome;

public class ScreenGameHome extends ScreenGameBase {

    private LocationInfoHome locationInfo;

    public ScreenGameHome() {
        super(16, 12);
    }

    public ScreenGameHome(int x, int y) {
        super(x, y);
    }

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
