package stateMachine;

public class Draft extends State {
    public Draft(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
        getTask().setState(new Open(getContext()));
    }

    @Override
    public void down(Object...param) {
    }

    @Override
    State copy() {
        Draft draft = new Draft(Draft.this.getContext());
        return null;
    }
}
