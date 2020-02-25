package stateMachine;

public abstract class State {
    private Proxy task;
    public abstract void up(Object...param);
    public abstract void down(Object...param);

    abstract State copy();

    public Proxy getContext() {
        return task;
    }

    Proxy getTask(){
        return task;
    }

    public State(Proxy proxy) {
        this.task = proxy;
    }
}
