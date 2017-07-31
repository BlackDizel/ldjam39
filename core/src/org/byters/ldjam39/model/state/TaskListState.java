package org.byters.ldjam39.model.state;

import org.byters.ldjam39.model.TaskListEnum;

import java.util.ArrayList;

public class TaskListState extends ObjectStateBase {

    private ArrayList<TaskListEnum> listTaskCompleted;

    public TaskListState() {
        super(ObjectStateEnum.TASK_LIST_STATE);
    }

    @Override
    public void reset() {
        listTaskCompleted = new ArrayList<TaskListEnum>();
    }

    public void completeTask(TaskListEnum task) {
        listTaskCompleted.add(task);
    }

    public boolean isAllTasksComplete() {
        return listTaskCompleted.size() == TaskListEnum.values().length;
    }
}
