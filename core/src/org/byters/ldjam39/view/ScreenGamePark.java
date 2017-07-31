package org.byters.ldjam39.view;

import org.byters.ldjam39.model.locationInfo.LocationInfoBase;
import org.byters.ldjam39.model.locationInfo.LocationInfoMarket;
import org.byters.ldjam39.model.locationInfo.LocationInfoPark;

public class ScreenGamePark extends ScreenGameBase {

    private LocationInfoPark locationInfoPark;

    @Override
    LocationInfoBase getLocationInfo() {
        return locationInfoPark == null ? locationInfoPark = new LocationInfoPark()
                : locationInfoPark;
    }
}
