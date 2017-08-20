package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.byters.engine.controller.ControllerCamera;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.controller.ControllerWorldState;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.model.StringEnum;
import org.byters.ldjam39.model.TaskListEnum;
import org.byters.ldjam39.view.TextureEnum;

import java.util.ArrayList;

public class DrawerMobile {
    private static final float POSITION_X = 32;
    private static final float POSITION_Y_SHOWN = 0;
    private static final float POSITION_Y = -72;
    private static final float MAX_BATTERY_WIDTH = 5;
    private Mobile wMobile;

    private ArrayList<Texture> listTextureMobileTask;
    private ArrayList<Texture> listTextureMobilePhonebook;
    private ShapeRenderer shapeRenderer;

    private BitmapFont bitmapFont;

    public DrawerMobile(Mobile mobile) {
        this.wMobile = mobile;

    }

    public void draw(SpriteBatch batch) {
        if (wMobile == null) return;

        Texture texture = wMobile.isCurrentScreenPhonebook()
                ? listTextureMobilePhonebook.get(wMobile.getCurrentScreenIndex())
                : listTextureMobileTask.get(wMobile.getCurrentScreenIndex());

        batch.draw(texture, ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X),
                wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y);

        if (wMobile.isShown())
            bitmapFont.draw(batch, StringEnum.MOBILE_HELP.toString(),
                    ControllerCamera.getInstance().getCameraPositionX() - ControllerCamera.getInstance().getCameraWidth() / 2.2f,
                    ControllerCamera.getInstance().getCameraHeight() - 40);

        drawShapes(batch);
    }

    private void drawShapes(SpriteBatch batch) {
        batch.end();
        shapeRenderer.setProjectionMatrix(ControllerCamera.getInstance().getCameraProjection());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        drawBattery();
        drawTasksComplete();
        drawSelectedItem();

        shapeRenderer.end();
        batch.begin();
    }

    private void drawSelectedItem() {
        if (!wMobile.isShown() || !wMobile.isCurrentScreenPhonebook()) return;

        shapeRenderer.setColor(0, 1, 0, 1);

        float xStart = ControllerWorld.getInstance().getPositionIgnoreCameraX(40);
        float yStart = 50.5f - 10 * wMobile.getSelectedItem();
        shapeRenderer.rectLine(
                xStart, yStart, xStart + 44, yStart, 1);
    }

    private void drawTasksComplete() {
        if (!wMobile.isCurrentScreenTasks())
            return;
        shapeRenderer.setColor(0, 1, 0, 1);

        //todo refactor
        if (ControllerWorldState.getInstance().isTaskCompleted(TaskListEnum.CAT_FOOD)
                && wMobile.getCurrentScreenIndex() == 0)
            shapeRenderer.rect(
                    ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 8),
                    (wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 58,
                    2, 2);

        if (ControllerWorldState.getInstance().isTaskCompleted(TaskListEnum.NANCY_BD)
                && wMobile.getCurrentScreenIndex() == 0)
            shapeRenderer.rect(
                    ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 8),
                    (wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 49,
                    2, 2);

        if (ControllerWorldState.getInstance().isTaskCompleted(TaskListEnum.CATCH_FISH)
                && wMobile.getCurrentScreenIndex() == 0)
            shapeRenderer.rect(
                    ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 8),
                    (wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 34,
                    2, 2);


        if (ControllerWorldState.getInstance().isTaskCompleted(TaskListEnum.FIX_BENCH)
                && wMobile.getCurrentScreenIndex() == 0)
            shapeRenderer.rect(
                    ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 8),
                    (wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 19,
                    2, 2);

        if (ControllerWorldState.getInstance().isTaskCompleted(TaskListEnum.PLANT_TREE)
                && wMobile.getCurrentScreenIndex() == 1)
            shapeRenderer.rect(
                    ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 8),
                    (wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 58,
                    2, 2);
    }

    private void drawBattery() {

        float width = ControllerWorldState.getInstance().getCurrentBatteryState() * MAX_BATTERY_WIDTH;

        setColor(shapeRenderer, width);
        shapeRenderer.rect(ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X + 47 + MAX_BATTERY_WIDTH - width),
                (wMobile.isShown() ? POSITION_Y_SHOWN : POSITION_Y) + 74,
                width, 3);

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

        listTextureMobilePhonebook = new ArrayList<Texture>();
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK1.toString())));
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK2.toString())));
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK3.toString())));
        listTextureMobilePhonebook.add(new Texture(Gdx.files.internal(TextureEnum.TEXTURE_MOBILE_PHONEBOOK4.toString())));

        shapeRenderer = new ShapeRenderer();
        bitmapFont = new BitmapFont(Gdx.files.internal(TextureEnum.TEXTURE_FONT.toString()));
    }

    public void dispose() {
        wMobile = null;
        bitmapFont.dispose();
        for (Texture item : listTextureMobileTask)
            item.dispose();

        for (Texture item : listTextureMobilePhonebook)
            item.dispose();
    }
}
