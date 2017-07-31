package org.byters.ldjam39.model.state;

import org.byters.ldjam39.model.WorldItemsEnum;

import java.util.ArrayList;

public class InventoryState extends ObjectStateBase {

    private ArrayList<WorldItemsEnum> data;

    public InventoryState() {
        super(ObjectStateEnum.INVENTORY);
    }

    @Override
    public void reset() {
        data = new ArrayList<WorldItemsEnum>();
    }

    public void add(WorldItemsEnum item) {
        data.add(item);
    }

    public boolean getItem(WorldItemsEnum item) {
        if (data.contains(item)) {
            data.remove(item);
            return true;
        }
        return false;
    }

    public boolean isContains(WorldItemsEnum item) {
        return data.contains(item);
    }
}
