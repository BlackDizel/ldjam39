package org.byters.ldjam39.controller;

import org.byters.engine.controller.ControllerCamera;

public class ControllerWorld {
    private static ControllerWorld instance;

    private ControllerWorld() {
    }

    public static ControllerWorld getInstance() {
        if (instance == null) instance = new ControllerWorld();
        return instance;
    }

    public float getPositionIgnoreCameraX(float positionX) {
        return ControllerCamera.getInstance().getCameraPositionX() + positionX;
    }

    public float getPositionIgnoreCameraY(float positionY) {
        return ControllerCamera.getInstance().getCameraPositionY() + positionY;
    }
}
