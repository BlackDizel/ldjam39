package org.byters.ldjam39.controller;

import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.model.state.*;

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
        data.add(new MobileBatteryState());
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

        if (inventory.getItem(WorldItemsEnum.CAT_FOOD_IN_MARKET)) {
            world.fillCatDish();
            //todo complete task
        }
    }

    public boolean isWorldContains(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || item == null) return false;
        return world.isContainsItem(item);
    }

    void buyCatFood() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;
        if (!inventory.isContains(WorldItemsEnum.CAT_FOOD_IN_MARKET)) return;

        if (inventory.isContains(WorldItemsEnum.MONEY)) {
            world.removeItem(WorldItemsEnum.SELLER);
            world.addItem(WorldItemsEnum.MARKET_DOOR);
        }
    }

    void getCatFood() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (!inventory.isContains(WorldItemsEnum.MONEY)
                || inventory.isContains(WorldItemsEnum.CAT_FOOD_IN_MARKET))
            return;

        if (world.tryGetItem(WorldItemsEnum.CAT_FOOD_IN_MARKET)) {
            inventory.add(WorldItemsEnum.CAT_FOOD_IN_MARKET);
            world.addItem(WorldItemsEnum.SELLER);
            world.removeItem(WorldItemsEnum.MARKET_DOOR);
        }
    }

    public void startTimer() {
        ((MobileBatteryState) getData(ObjectStateEnum.MOBILE_BATTERY_STATE)).setStartTimeMillis();
    }

    public float getCurrentBatteryState() {
        return ((MobileBatteryState) getData(ObjectStateEnum.MOBILE_BATTERY_STATE)).getCurrentStatePercent();
    }

    public boolean isBatteryEnd() {
        return getCurrentBatteryState() <= 0;
    }

    public boolean isAllTasksCheck() {
        //todo implement
        return false;
    }
}
