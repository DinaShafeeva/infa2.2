package stateMachine;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ProxyImpl implements Proxy {

    private Proxy proxy;

    private static Logger logger =  Logger.getLogger(Proxy.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("logger.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public ProxyImpl(Proxy proxy) {
        this.proxy = proxy;
        logger.info("Proxy is initialized");
    }

    @Override
    public Proxy copy() {
        logger.info("Task's copy was created");
        return proxy.copy();
    }

    @Override
    public int getDeveloperId() {
        logger.info("Task's developer id is " + proxy.getDeveloperId());
        return proxy.getDeveloperId();
    }

    @Override
    public void setDeveloperId(int development) {
        proxy.setDeveloperId(development);
        logger.info("Task's developer id was setted");
    }

    @Override
    public int getTesterId() {
        logger.info("Task's tester id is " + proxy.getTesterId());
        return proxy.getTesterId();
    }

    @Override
    public void setTesterId(int testerId) {
        proxy.setTesterId(testerId);
        logger.info("Task's tester id was setted");
    }

    @Override
    public String getText() {
        logger.info("Task's text is " + proxy.getText());
        return proxy.getText();
    }

    @Override
    public void setText(String text) {
        proxy.setText(text);
        logger.info("Task's text was setted");
    }

    @Override
    public String getError() {
        logger.info("Task's error is " + proxy.getError());
        return proxy.getError();
    }

    @Override
    public void setError(String error) {
        proxy.setError(error);
        logger.info("Task's error was setted");
    }

    @Override
    public int getId() {
        logger.info("Task's id is " + proxy.getId());
        return proxy.getId();
    }

    @Override
    public void setId(int id) {
        proxy.setId(id);
        logger.info("Task's id was setted");
    }

    @Override
    public State getState() {
        logger.info("Task's state is " + proxy.getState());
        return proxy.getState();
    }

    @Override
    public void setState(State state) {
        proxy.setState(state);
        logger.info("Task's state was setted");
    }

    @Override
    public void up() {
        proxy.up();
        logger.info("Successful up");
    }

    @Override
    public void down() {
        proxy.down();
        logger.info("Successful down");
    }
}

