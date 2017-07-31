package org.byters.ldjam39.controller;

import org.byters.ldjam39.model.TaskListEnum;
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
        data.add(new TaskListState());
    }

    void addToInventory(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);

        if (world == null || inventory == null) return;

        if (world.tryGetItem(item))
            inventory.add(item);
    }

    void getWorms() {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);

        if (world == null || inventory == null) return;

        if (world.isContainsItem(WorldItemsEnum.WORMS)
                && !inventory.isContains(WorldItemsEnum.WORMS)
                && inventory.isContains(WorldItemsEnum.SHOVEL)) {
            inventory.add(WorldItemsEnum.WORMS);
            world.removeItem(WorldItemsEnum.WORMS);
        }
    }

    private ObjectStateBase getData(ObjectStateEnum id) {
        for (ObjectStateBase item : data)
            if (item.getId() == id)
                return item;
        return null;
    }

    public void fixBench() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (inventory.isContains(WorldItemsEnum.HAMMER) && world.isBenchBroken()) {
            world.fixBench();
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.FIX_BENCH);
        }
    }

    public void plantTree() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (inventory.isContains(WorldItemsEnum.FOREST_TREE)
                && world.isContainsItem(WorldItemsEnum.TREE_HOLE_IN_OUTDOOR)) {
            world.plantTree();
            inventory.removeItem(WorldItemsEnum.FOREST_TREE);
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.PLANT_TREE);
        }
    }

    public void getTree() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (inventory.isContains(WorldItemsEnum.SHOVEL)
                && !inventory.isContains(WorldItemsEnum.FOREST_TREE)) {
            world.removeItem(WorldItemsEnum.FOREST_TREE);
            inventory.add(WorldItemsEnum.FOREST_TREE);
        }
    }

    public void catchFish() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (inventory.isContains(WorldItemsEnum.WORMS)
                && inventory.isContains(WorldItemsEnum.FISHING_ROD)) {
            world.removeItem(WorldItemsEnum.POUND);
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.CATCH_FISH);
        }
    }

    void fillCatDish() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return;

        if (inventory.getItem(WorldItemsEnum.CAT_FOOD_IN_MARKET)) {
            world.fillCatDish();
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.CAT_FOOD);
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

    public boolean isAllTasksCompleted() {
        return ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).isAllTasksComplete();
    }
}
