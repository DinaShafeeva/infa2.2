package stateMachine;

public class Interpretator {
    private StateMachine stateMachine;

    public Interpretator(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public String checkStatement(String statement) {
        String string = null;
        if (statement.startsWith("new task")) {
            string = create(statement);
        } else if (statement.startsWith("up")) {
            string = up(statement);
        } else if (statement.startsWith("down")){
            string = down(statement);
        } else if (statement.startsWith("copy")){
            string = copy(statement);
        }
        return string;
    }

    private String create(String string){
        String text = string.substring(string.indexOf('k' + 1));
        Task task = new Task(string);
        task.setText(text);
        return "New task created with id " + stateMachine.addTask(task);
    }

    private String up(String string){
        String text = string.substring(string.indexOf('p' + 2));
        stateMachine.getList().get((Integer.parseInt(text))).up();
        return "Up successfully";
    }

    private String down(String string){
        String text = string.substring(string.indexOf('n' + 2));
        stateMachine.getList().get((Integer.parseInt(text))).down();
        return "Down successfully";
    }

    private String copy(String string){
        String text = string.substring(string.indexOf('y' + 2));
        Proxy proxy = stateMachine.getList().get(Integer.parseInt(text)).copy();
        stateMachine.getList().add(proxy);
        return "Copied task";
    }
}
