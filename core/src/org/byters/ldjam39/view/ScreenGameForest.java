package org.byters.ldjam39.view;

import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.locationInfo.LocationInfoForest;

public class ScreenGameForest extends ScreenGameBase {

    private LocationInfoForest locationInfoForest;

    public ScreenGameForest(int playerInitX, int playerInitY) {
        super(playerInitX, playerInitY);
    }

    @Override
    LocationInfoBase getLocationInfo() {
        return locationInfoForest == null
                ? locationInfoForest = new LocationInfoForest()
                : locationInfoForest;
    }
}
