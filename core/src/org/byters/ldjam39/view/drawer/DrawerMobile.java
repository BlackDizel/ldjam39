package org.byters.ldjam39.view.drawer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ldjam39.controller.ControllerWorld;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.view.TextureEnum;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class DrawerMobile {
    private static final float POSITION_X = 32;
    private static final float POSITION_Y_SHOWN = -54;
    private static final float POSITION_Y = -126;
    private WeakReference<Mobile> wMobile;

    private ArrayList<Texture> listTextureMobileTask;
    private ArrayList<Texture> listTextureMobilePhonebook;

    public DrawerMobile(Mobile mobile) {
        this.wMobile = new WeakReference<Mobile>(mobile);

    }

    public void draw(SpriteBatch batch) {
        if (wMobile.get() == null) return;

        Texture texture = wMobile.get().isCurrentScreenPhonebook()
                ? listTextureMobilePhonebook.get(wMobile.get().getCurrentScreenIndex())
                : listTextureMobileTask.get(wMobile.get().getCurrentScreenIndex());

        batch.draw(texture, ControllerWorld.getInstance().getPositionIgnoreCameraX(POSITION_X),
                ControllerWorld.getInstance().getPositionIgnoreCameraY(wMobile.get().isShown() ? POSITION_Y_SHOWN : POSITION_Y));
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
    }

    public void dispose() {
        for (Texture item : listTextureMobileTask)
            item.dispose();

        for (Texture item : listTextureMobilePhonebook)
            item.dispose();
    }
}
