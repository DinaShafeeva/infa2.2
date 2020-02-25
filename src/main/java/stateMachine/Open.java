package stateMachine;

public class Open extends State {
    public Open(Proxy proxy) {
        super(proxy);
    }

    @Override
    public void up(Object...param) {
    }

    @Override
    public void down(Object...param) {
        getTask().setState(new BackLog(getContext()));
        getTask().setDeveloperId((Integer)param[0]);
    }

    @Override
    State copy() {
        return null;
    }
}
