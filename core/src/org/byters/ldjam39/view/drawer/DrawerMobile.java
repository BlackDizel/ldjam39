package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.byters.engine.controller.ControllerCamera;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class DrawerMobile {
    private static final float POSITION_X = 32;
    private static final float POSITION_Y_SHOWN = 0;
    private static final float POSITION_Y = -72;
    private static final float MAX_BATTERY_WIDTH = 5;
    private WeakReference<Mobile> wMobile;

    private ArrayList<Texture> listTextureMobileTask;
    private ArrayList<Texture> listTextureMobilePhonebook;
    private ShapeRenderer shapeRenderer;

    public DrawerMobile(Mobile mobile) {
        this.wMobile = new WeakReference<Mobile>(mobile);

    }

    public void draw(SpriteBatch batch) {
        if (wMobile.get() == null) return;

        Texture texture = wMobile.get().isCurrentScreenPhonebook()
                ? listTextureMobilePhonebook.get(wMobile.get().getCurrentScreenIndex())
                : listTextureMobileTask.get(wMobile.get().getCurrentScreenIndex());

        batch.draw(texture, ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X),
                wMobile.get().isShown() ? POSITION_Y_SHOWN : POSITION_Y);

        drawBattery(batch);
    }

    private void drawBattery(SpriteBatch batch) {
        batch.end();

        float width = ControllerWorldState.getInstance().getCurrentBatteryState() * MAX_BATTERY_WIDTH;

        shapeRenderer.setProjectionMatrix(ControllerCamera.getInstance().getCameraProjection());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        setColor(shapeRenderer, width);
        shapeRenderer.rect(ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 47 + MAX_BATTERY_WIDTH - width),
                (wMobile.get().isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 74,
                width, 3);
        shapeRenderer.end();

        batch.begin();
    }

    private void setColor(ShapeRenderer shapeRenderer, float width) {
        if (width > 4)
            shapeRenderer.setColor(0, 1, 0, 1);
        else if (width > 2)
            shapeRenderer.setColor(1, 0.56f, 0, 1);
        else shapeRenderer.setColor(1, 0, 0, 1);
    }

    public void load() {
        listTextureMobileTask = new ArrayList<Texture>();
        listTextureMobileTask.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_TASK1.toString())));
        listTextureMobileTask.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_TASK2.toString())));
        listTextureMobileTask.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_TASK3.toString())));

        listTextureMobilePhonebook = new ArrayList<Texture>();
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK1.toString())));
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK2.toString())));
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK3.toString())));
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK4.toString())));

        shapeRenderer = new ShapeRenderer();
    }

    public void dispose() {
        for (Texture item : listTextureMobileTask)
            item.dispose();

        for (Texture item : listTextureMobilePhonebook)
            item.dispose();
    }
}
