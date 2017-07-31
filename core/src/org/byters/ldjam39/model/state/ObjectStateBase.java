package org.byters.ldjam39.model.state;

public abstract class ObjectStateBase {

    private ObjectStateEnum id;

    ObjectStateBase(ObjectStateEnum id) {
        this.id = id;
        reset();
    }

    public abstract void reset();

    public ObjectStateEnum getId() {
        return id;
    }
}
