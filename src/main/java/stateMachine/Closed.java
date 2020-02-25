package stateMachine;

public class Closed extends State {
    public Closed(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
    }

    @Override
    public void down(Object...param) {
    }

    @Override
    State copy() {
        Closed closed = new Closed(Closed.this.getContext());
        return closed;
    }
}
