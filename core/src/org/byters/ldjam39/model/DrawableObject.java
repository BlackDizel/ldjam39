package org.byters.ldjam39.model;

class DrawableObject {

    private String texturePath;
    private float x;
    private float y;
    private int width;
    private int height;

    DrawableObject(String texturePath, float x, float y, int width, int height) {
        this.texturePath = texturePath;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    String getTexturePath() {
        return texturePath;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    float getOriginX() {
        return x + width / 2;
    }

    float getOriginY() {
        return y + height / 2;
    }
}
