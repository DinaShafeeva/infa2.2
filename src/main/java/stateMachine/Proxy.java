package stateMachine;

public interface Proxy {
    Proxy copy();

    int getDeveloperId();
    void setDeveloperId(int development);
    int getTesterId();
    void setTesterId(int testerId);
    String getText();
    void setText(String text);
    String getError();
    void setError(String error);
    int getId();
    void setId(int id);
    State getState();
    void setState(State state);

    void up();
    void down();
}
