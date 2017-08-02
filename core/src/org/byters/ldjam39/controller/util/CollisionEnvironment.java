package org.byters.ldjam39.controller.util;

import com.badlogic.gdx.math.Rectangle;
import org.byters.ldjam39.model.GameEnvironment;

public class CollisionEnvironment {

    private GameEnvironment wEnvironment;
    private Rectangle rLeft, rRight;

    public CollisionEnvironment(GameEnvironment environment) {
        wEnvironment = environment;
        rLeft = new Rectangle();
        rRight = new Rectangle();
    }

    public boolean isCollide(int x, int y, int width, int height) {

        if (wEnvironment == null) return false;

        for (int i = 0; i < wEnvironment.getCollideObjectsNum(); ++i)
            if (isCollide(x, y, width, height,
                    wEnvironment.getCollideObjectX(i),
                    wEnvironment.getCollideObjectY(i),
                    wEnvironment.getCollideObjectWidth(i),
                    wEnvironment.getCollideObjectHeight(i)))
                return true;

        return false;
    }

    private boolean isCollide(int x1, int y1, int width1, int height1,
                              int x2, int y2, int width2, int height2) {

        rLeft.set(x1, y1, width1, height1);
        rRight.set(x2, y2, width2, height2);

        return rLeft.overlaps(rRight);
    }
}
