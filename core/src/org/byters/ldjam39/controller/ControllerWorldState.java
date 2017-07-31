package org.byters.ldjam39.controller;

import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.model.state.InventoryState;
import org.byters.ldjam39.model.state.ObjectStateBase;
import org.byters.ldjam39.model.state.ObjectStateEnum;
import org.byters.ldjam39.model.state.WorldState;

import java.util.ArrayList;

public class ControllerWorldState {

    private static ControllerWorldState instance;
    private ArrayList<ObjectStateBase> data;

    private ControllerWorldState() {
        reset();
    }

    public static ControllerWorldState getInstance() {
        if (instance == null) instance = new ControllerWorldState();
        return instance;
    }

    public void reset() {
        //todo move to json
        data = new ArrayList<ObjectStateBase>();
        data.add(new WorldState());
        data.add(new InventoryState());
    }

    void addToInventory(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);

        if (world == null || inventory == null) return;

        if (world.tryGetItem(item))
            inventory.add(item);
    }

    private ObjectStateBase getData(ObjectStateEnum id) {
        for (ObjectStateBase item : data)
            if (item.getId() == id)
                return item;
        return null;
    }

    void fillCatDish() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (inventory.getItem(WorldItemsEnum.INVENTORY_CAT_FOOD))
            world.fillCatDish();
    }

    public boolean isWorldContains(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || item == null) return false;
        return world.isContainsItem(item);
    }
}
