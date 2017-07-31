package org.byters.ldjam39.view;

import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.locationInfo.LocationInfoMarket;

public class ScreenGameMarket extends ScreenGameBase {

    private LocationInfoMarket locationInfoMarket;

    public ScreenGameMarket(int playerInitX, int playerInitY) {
        super(playerInitX, playerInitY);
    }

    @Override
    LocationInfoBase getLocationInfo() {
        return locationInfoMarket == null ? locationInfoMarket = new LocationInfoMarket()
                : locationInfoMarket;
    }
}
