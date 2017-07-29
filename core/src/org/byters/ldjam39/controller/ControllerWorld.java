package org.byters.ldjam39.controller;

import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerMain;

public class ControllerWorld {
    private static ControllerWorld instance;

    private ControllerWorld() {
    }

    public static ControllerWorld getInstance() {
        if (instance == null) instance = new ControllerWorld();
        return instance;
    }

    public float getPositionX(float x) {
        return x * ControllerMain.getInstance().getScale();
    }

    public float getPositionY(float y) {
        return y * ControllerMain.getInstance().getScale();
    }

    public float getPositionIgnoreCameraX(float positionX) {
        return ControllerCamera.getInstance().getCameraPositionX() + getPositionX(positionX);
    }

    public float getPositionIgnoreCameraY(float positionY) {
        return ControllerCamera.getInstance().getCameraPositionY() + getPositionY(positionY);
    }
}
