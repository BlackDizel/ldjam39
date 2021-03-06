package org.byters.ldjam39.model.state;

import org.byters.ldjam39.model.WorldItemsEnum;

import java.util.ArrayList;

public class WorldState extends ObjectStateBase {

    private ArrayList<WorldItemsEnum> data;

    public WorldState() {
        super(ObjectStateEnum.WORLD);
    }

    @Override
    public void reset() {
        data = new ArrayList<WorldItemsEnum>();
        data.add(WorldItemsEnum.MONEY);
        data.add(WorldItemsEnum.HAMMER);
        data.add(WorldItemsEnum.FISHING_ROD);
        data.add(WorldItemsEnum.CAT_DISH_EMPTY);
        data.add(WorldItemsEnum.HOME_DOOR);
        data.add(WorldItemsEnum.SIGN_PARK);
        data.add(WorldItemsEnum.MARKET_DOOR);
        data.add(WorldItemsEnum.CAT_FOOD_IN_MARKET);
        data.add(WorldItemsEnum.FLOWERS_IN_MARKET);
        data.add(WorldItemsEnum.SHOVEL);
        data.add(WorldItemsEnum.BENCH_BROKEN);
        data.add(WorldItemsEnum.FOREST_PORTAL);
        data.add(WorldItemsEnum.WORMS);
        data.add(WorldItemsEnum.POUND);
        data.add(WorldItemsEnum.FOREST_TREE);
        data.add(WorldItemsEnum.TREE_HOLE_IN_OUTDOOR);
        data.add(WorldItemsEnum.MODAL_IMAGE_SELFIE_AVAILABLE);
        data.add(WorldItemsEnum.NANCY_CALL);
        data.add(WorldItemsEnum.NANCY);
        data.add(WorldItemsEnum.NANCY_SPRITE);
        data.add(WorldItemsEnum.GAME_START);
    }

    public boolean isContainsItem(WorldItemsEnum item) {
        return data.contains(item);
    }

    public boolean tryGetItem(WorldItemsEnum item) {
        if (data.contains(item)) {
            data.remove(item);
            return true;
        }
        return false;
    }

    public void fillCatDish() {
        if (data.contains(WorldItemsEnum.CAT_DISH_EMPTY)) {
            data.remove(WorldItemsEnum.CAT_DISH_EMPTY);
            data.add(WorldItemsEnum.CAT_DISH_FULL);
        }
    }

    public void addItem(WorldItemsEnum item) {
        if (data.contains(item)) return;
        data.add(item);
    }

    public void removeItem(WorldItemsEnum item) {
        data.remove(item);
    }

    public void fixBench() {
        if (data.contains(WorldItemsEnum.BENCH_FIXED))
            return;
        data.remove(WorldItemsEnum.BENCH_BROKEN);
        data.add(WorldItemsEnum.BENCH_FIXED);
    }

    public boolean isBenchBroken() {
        return data.contains(WorldItemsEnum.BENCH_BROKEN);
    }

    public void plantTree() {
        data.remove(WorldItemsEnum.TREE_HOLE_IN_OUTDOOR);
        data.add(WorldItemsEnum.TREE_IN_OUTDOOR);
    }
}
