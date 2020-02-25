package stateMachine;

public class Task implements Proxy{
    private State state;
    private int id;
    private Integer developerId;
    private int testerId;
    private String text;
    private String error;

    public Task(String text) {
        this.text = text;
    }

    public void down(){
        state.down();
    }

    public void up(){
        state.up();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Proxy copy() {
        Task task = new Task(Task.this.getText());
        task.setState(Task.this.getState().copy());
        task.setError(Task.this.getError());
        task.setTesterId(Task.this.getTesterId());
        task.setDeveloperId(Task.this.getDeveloperId());
        return task;
    }

    @Override
    public int getDeveloperId() {
        return developerId;
    }

    @Override
    public void setDeveloperId(int development) {
        this.developerId = development;
    }

    public int getTesterId() {
        return testerId;
    }

    public void setTesterId(int testerId) {
        this.testerId = testerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
