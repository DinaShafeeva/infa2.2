package stateMachine;

public class BackLog extends State {
    public BackLog(Proxy proxy) {
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
        BackLog backLog = new BackLog(BackLog.this.getContext());
        return backLog;
    }
}
