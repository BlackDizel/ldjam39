package org.byters.ldjam39.model;


import org.byters.engine.model.PointInt;

import java.util.ArrayList;

public class GameEnvironment {

    private ArrayList<PointInt> listBox;
    private PointInt boxSize;

    public GameEnvironment() {
        //todo simple box list for demonstration. I prefer store game data in json files
        listBox = new ArrayList<PointInt>();
        listBox.add(new PointInt(40, 30));
        listBox.add(new PointInt(60, 50));
        listBox.add(new PointInt(40, 60));

        boxSize = new PointInt(32, 32); //todo add check texture size
    }

    public int getBoxNum() {
        return listBox == null ? 0 : listBox.size();
    }

    public int getBoxX(int pos) {
        return listBox == null || pos < 0 || pos > listBox.size() ? 0 : listBox.get(pos).x;
    }

    public int getBoxY(int pos) {
        return listBox == null || pos < 0 || pos > listBox.size() ? 0 : listBox.get(pos).y;
    }

    public int getBoxWidth() {
        return boxSize.x;
    }

    public int getBoxHeigth() {
        return boxSize.y;
    }

    /**
     * @return num of colliders
     */
    public int getCollideObjectsNum() {
        return listBox.size(); //todo implement
    }

    /**
     * @param i * @return x pos of collider
     */
    public int getCollideObjectX(int i) {
        return listBox.get(i).x;//todo implement
    }

    /**
     * @param i
     * @return y pos of collider
     */
    public int getCollideObjectY(int i) {
        return listBox.get(i).y; //todo implement
    }

    /**
     * @param i
     * @return width of collider
     */
    public int getCollideObjectWidth(int i) {
        return boxSize.x; //todo implement
    }

    /**
     * @param i
     * @return height of collider
     */
    public int getCollideObjectHeight(int i) {
        return boxSize.y; //todo implement
    }
}
