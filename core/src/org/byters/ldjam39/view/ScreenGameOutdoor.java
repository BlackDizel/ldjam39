package org.byters.ldjam39.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.locationInfo.LocationInfoOutdoor;

public class ScreenGameOutdoor extends ScreenGameBase {
    private LocationInfoOutdoor locationInfoOutdoor;

    public ScreenGameOutdoor(int x, int y) {
        super(x, y);
    }

    @Override
    public void load(SpriteBatch batch) {
        locationInfoOutdoor = new LocationInfoOutdoor();
        super.load(batch);
    }

    @Override
    LocationInfoBase getLocationInfo() {
        return locationInfoOutdoor;
    }
}
