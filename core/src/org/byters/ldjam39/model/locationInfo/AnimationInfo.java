package org.byters.ldjam39.model.locationInfo;

import org.byters.ldjam39.view.TextureEnum;

public class AnimationInfo {

    private final TextureEnum texturePath;
    private final int framesNum;
    private final float x;
    private final float y;

    public AnimationInfo(TextureEnum texturPath, int framesNum, float x, float y) {
        this.texturePath = texturPath;
        this.framesNum = framesNum;
        this.x = x;
        this.y = y;
    }

    public int getFramesNum() {
        return framesNum;
    }

    public TextureEnum getTexturePath() {
        return texturePath;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
