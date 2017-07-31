package org.byters.ldjam39.model;

public class DrawableObject {

    private String texturePath;
    private float x;
    private float y;
    private int width;
    private int height;

    public DrawableObject(String texturePath, float x, float y, int width, int height) {
        this.texturePath = texturePath;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getOriginX() {
        return x + width / 2;
    }

    public float getOriginY() {
        return y + height / 2;
    }
}
