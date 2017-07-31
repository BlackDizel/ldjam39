package org.byters.ldjam39.view;

import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.locationInfo.LocationInfoPark;

public class ScreenGamePark extends ScreenGameBase {

    private LocationInfoPark locationInfoPark;

    public ScreenGamePark(int playerInitX, int playerInitY) {
        super(playerInitX, playerInitY);
    }

    @Override
    LocationInfoBase getLocationInfo() {
        return locationInfoPark == null ? locationInfoPark = new LocationInfoPark()
                : locationInfoPark;
    }
}
