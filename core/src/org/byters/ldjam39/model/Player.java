package org.byters.ldjam39.model;

import com.badlogic.gdx.math.Vector2;

public class Player {

    private static final float SPEED_RUN = 2;
    private static final float SPEED_MOVE = 1;
    private float x, y;
    private PlayerStateEnum state;
    private Vector2 direction;

    private int width, height;

    public Player() {
        width = 18;
        height = 40;
        x = 16;
        y = 12;
        state = PlayerStateEnum.WAITING;
        direction = new Vector2(1, 0);
    }

    public boolean isWaiting() {
        return state == PlayerStateEnum.WAITING;
    }

    public boolean isMove() {
        return state == PlayerStateEnum.MOVE;
    }

    public boolean isRun() {
        return state == PlayerStateEnum.RUN;
    }

    public void getDirection(Vector2 result) {
        result.set(direction.x, direction.y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move(Vector2 direction, boolean isRun) {
        x = calcX(direction, isRun);
        y = calcY(direction, isRun);
        this.direction.set(direction.x, direction.y);
        this.state = isRun ? PlayerStateEnum.RUN : PlayerStateEnum.MOVE;
    }

    private float getSpeed(boolean isRun) {
        return isRun ? SPEED_RUN : SPEED_MOVE;
    }

    public void stop() {
        state = PlayerStateEnum.WAITING;
    }

    public float calcX(Vector2 direction, boolean isRun) {
        return x + direction.x * getSpeed(isRun);
    }

    public float calcY(Vector2 direction, boolean isRun) {
        return y + direction.y * getSpeed(isRun);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private enum PlayerStateEnum {WAITING, MOVE, RUN}
}
