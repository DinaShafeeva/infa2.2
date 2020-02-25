package stateMachine;

public class Resolved extends State {
    public Resolved(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
        getTask().setState(new InTesting(getContext()));
        getTask().setTesterId((int)param[0]);
    }

    @Override
    public void down(Object...param) {
        getTask().setState(new InProgress(getContext()));
    }

    @Override
    State copy() {
        Resolved resolved = new Resolved(Resolved.this.getContext());
        return resolved;
    }
}
