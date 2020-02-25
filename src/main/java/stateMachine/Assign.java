package stateMachine;

public class Assign extends State {
    public Assign(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
        getTask().setState(new InProgress(getContext()));
    }

    @Override
    public void down(Object...param) {
        getTask().setState(new Open(getContext()));
        getTask().setDeveloperId(0);
    }

    @Override
    State copy() {
        Assign assign = new Assign(Assign.this.getContext());
        return assign;
    }
}
