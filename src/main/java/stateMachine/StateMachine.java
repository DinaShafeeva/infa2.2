package stateMachine;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    List<Proxy> list;

    public StateMachine(List<Task> list) {
        this.list = new ArrayList<>();
    }
    public String addTask(Task task){
        list.add(task);
        task.setId(list.indexOf(task));
        return list.indexOf(task) + "";
    }

    public List<Proxy> getList() {
        return list;
    }
}
