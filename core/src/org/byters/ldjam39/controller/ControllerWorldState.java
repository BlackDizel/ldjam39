package org.byters.ldjam39.controller;

import org.byters.ldjam39.model.DialogMessage;
import org.byters.ldjam39.model.StringEnum;
import org.byters.ldjam39.model.TaskListEnum;
import org.byters.ldjam39.model.WorldItemsEnum;
import org.byters.ldjam39.model.state.*;

import java.util.ArrayList;
import java.util.List;

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
        data.add(new DialogState());
    }

    boolean addToInventory(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);

        if (world == null || inventory == null) return false;

        if (world.tryGetItem(item)) {
            inventory.add(item);
            return true;
        }

        return false;
    }

    boolean getWorms() {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);

        if (world == null || inventory == null) return false;

        if (world.isContainsItem(WorldItemsEnum.WORMS)
                && !inventory.isContains(WorldItemsEnum.WORMS)
                && inventory.isContains(WorldItemsEnum.SHOVEL)) {
            inventory.add(WorldItemsEnum.WORMS);
            world.removeItem(WorldItemsEnum.WORMS);
            return true;
        }
        return false;
    }

    private ObjectStateBase getData(ObjectStateEnum id) {
        for (ObjectStateBase item : data)
            if (item.getId() == id)
                return item;
        return null;
    }

    boolean fixBench() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (inventory.isContains(WorldItemsEnum.HAMMER) && world.isBenchBroken()) {
            world.fixBench();
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.FIX_BENCH);
            return true;
        }
        return false;
    }

    boolean plantTree() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (inventory.isContains(WorldItemsEnum.FOREST_TREE)
                && world.isContainsItem(WorldItemsEnum.TREE_HOLE_IN_OUTDOOR)) {
            world.plantTree();
            inventory.removeItem(WorldItemsEnum.FOREST_TREE);
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.PLANT_TREE);
            return true;
        }
        return false;
    }

    boolean getTree() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (inventory.isContains(WorldItemsEnum.SHOVEL)
                && !inventory.isContains(WorldItemsEnum.FOREST_TREE)) {
            world.removeItem(WorldItemsEnum.FOREST_TREE);
            inventory.add(WorldItemsEnum.FOREST_TREE);
            return true;
        }

        return false;
    }

    boolean catchFish() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (inventory.isContains(WorldItemsEnum.WORMS)
                && inventory.isContains(WorldItemsEnum.FISHING_ROD)) {
            world.removeItem(WorldItemsEnum.POUND);
            world.addItem(WorldItemsEnum.MODAL_IMAGE_SELFIE_SHOW);
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.CATCH_FISH);
            return true;
        }

        return false;
    }

    boolean fillCatDish() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (inventory.getItem(WorldItemsEnum.CAT_FOOD_IN_MARKET)) {
            world.fillCatDish();
            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.CAT_FOOD);
            return true;
        }
        return false;
    }

    public boolean isWorldContains(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || item == null) return false;
        return world.isContainsItem(item);
    }

    boolean buyInMarket() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (!(inventory.isContains(WorldItemsEnum.CAT_FOOD_IN_MARKET)
                || inventory.isContains(WorldItemsEnum.FLOWERS_IN_MARKET)))
            return false;

        if (inventory.isContains(WorldItemsEnum.MONEY)) {
            world.removeItem(WorldItemsEnum.SELLER);
            world.addItem(WorldItemsEnum.MARKET_DOOR);

            ControllerWorldState.getInstance().resetDialogs();
            List<DialogMessage> listMessages = new ArrayList<DialogMessage>();
            listMessages.add(DialogMessage.newInstance(StringEnum.SUCCESS_BUY.toString(), 192, 68, 1100));
            ControllerWorldState.getInstance().setMessagesDialog(listMessages);

            return true;
        }
        return false;
    }

    boolean getFlowers() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (!inventory.isContains(WorldItemsEnum.MONEY)
                || inventory.isContains(WorldItemsEnum.FLOWERS_IN_MARKET))
            return false;

        if (world.tryGetItem(WorldItemsEnum.FLOWERS_IN_MARKET)) {
            inventory.add(WorldItemsEnum.FLOWERS_IN_MARKET);
            if (!world.isContainsItem(WorldItemsEnum.SELLER))
                world.addItem(WorldItemsEnum.SELLER);
            world.removeItem(WorldItemsEnum.MARKET_DOOR);
            return true;
        }
        return false;
    }


    boolean happyBirthdayNancy() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (world.isContainsItem(WorldItemsEnum.NANCY)
                && inventory.isContains(WorldItemsEnum.FLOWERS_IN_MARKET)) {

            world.removeItem(WorldItemsEnum.NANCY);
            inventory.removeItem(WorldItemsEnum.FLOWERS_IN_MARKET);

            ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).completeTask(TaskListEnum.NANCY_BD);

            ArrayList<DialogMessage> dialogMessages = new ArrayList<DialogMessage>();
            dialogMessages.add(DialogMessage.newInstancePlayer(StringEnum.SUCCESS_GIVE_GIFT_1.toString(), 2000));
            dialogMessages.add(DialogMessage.newInstance(StringEnum.SUCCESS_GIVE_GIFT_2.toString(), 240, 60, 2000));
            dialogMessages.add(DialogMessage.newInstance(StringEnum.SUCCESS_GIVE_GIFT_3.toString(), 240, 60, 2000));

            setMessagesDialog(dialogMessages);
            return true;
        }
        return false;
    }

    boolean getCatFood() {
        InventoryState inventory = (InventoryState) getData(ObjectStateEnum.INVENTORY);
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null || inventory == null) return false;

        if (!inventory.isContains(WorldItemsEnum.MONEY)
                || inventory.isContains(WorldItemsEnum.CAT_FOOD_IN_MARKET))
            return false;

        if (world.tryGetItem(WorldItemsEnum.CAT_FOOD_IN_MARKET)) {
            inventory.add(WorldItemsEnum.CAT_FOOD_IN_MARKET);
            if (!world.isContainsItem(WorldItemsEnum.SELLER))
                world.addItem(WorldItemsEnum.SELLER);
            world.removeItem(WorldItemsEnum.MARKET_DOOR);
            return true;
        }
        return false;
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

    public boolean isTaskCompleted(TaskListEnum task) {
        return ((TaskListState) getData(ObjectStateEnum.TASK_LIST_STATE)).isTaskCompleted(task);
    }

    void setMessageDialogPlayer(List<String> message) {
        ((DialogState) getData(ObjectStateEnum.DIALOG_STATE)).setMessagePlayer(message);
    }

    public void setMessagesDialog(List<DialogMessage> message) {
        ((DialogState) getData(ObjectStateEnum.DIALOG_STATE)).setMessages(message);
    }

    public DialogMessage getMessageDialog() {
        return ((DialogState) getData(ObjectStateEnum.DIALOG_STATE)).getCurrentMessage();
    }

    public void resetDialogs() {
        getData(ObjectStateEnum.DIALOG_STATE).reset();
    }

    public void removeWorldItem(WorldItemsEnum item) {
        WorldState world = (WorldState) getData(ObjectStateEnum.WORLD);
        if (world == null) return;
        world.removeItem(item);
    }
}
