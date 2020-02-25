package stateMachine;

public class InTesting extends State {
    public InTesting(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
        getTask().setState(new Closed(getContext()));
    }

    @Override
    public void down(Object...param) {
        getTask().setState(new Open(getContext()));
        getTask().setText((String) param[0]);
    }

    @Override
    State copy() {
        InTesting inTesting = new InTesting(InTesting.this.getContext());
        return inTesting;
    }
}
