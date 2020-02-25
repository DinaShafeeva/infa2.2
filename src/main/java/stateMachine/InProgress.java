package stateMachine;

public class InProgress extends State {
    public InProgress(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
        getTask().setState(new Resolved(getContext()));
    }

    @Override
    public void down(Object...param) {
    }

    @Override
    State copy() {
        InProgress inProgress = new InProgress(InProgress.this.getContext());
        return inProgress;
    }
}
