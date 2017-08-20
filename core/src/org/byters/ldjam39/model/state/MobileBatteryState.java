package org.byters.ldjam39.model.state;

public class MobileBatteryState extends ObjectStateBase {

    private static final int NO_VALUE = 0;

    private long timeMillis = 95000; //TODO IMPLEMENT
    private long startTimeMillis;

    public MobileBatteryState() {
        super(ObjectStateEnum.MOBILE_BATTERY_STATE);
        reset();
    }

    public void setStartTimeMillis() {
        this.startTimeMillis = System.currentTimeMillis();
    }

    @Override
    public void reset() {
        startTimeMillis = NO_VALUE;
    }

    public float getCurrentStatePercent() {
        if (startTimeMillis == NO_VALUE) return 100;

        long timeEnd = startTimeMillis + timeMillis;
        return Math.max((int) (timeEnd - System.currentTimeMillis()) / (float) timeMillis, 0);
    }
}
