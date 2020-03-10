package momento;

import java.util.Deque;
import java.util.List;

public class Browser {
    private Site currentSite;
    private List<Site> allSites;
    private Position currentPosition;

    private Data data;

    Deque<Memento> backDeque;
    Deque<Memento> forwardDeque;

    public Browser(Site currentSite, List<Site> allSites, Position currentPosition) {
        this.currentSite = currentSite;
        this.allSites = allSites;
        this.currentPosition = currentPosition;
    }

    public void goTo(String name) {
        clearForwardHistory();
        backDeque.push(new Memento());
        this.currentSite = data.getSite(name);
    }
    private void clearForwardHistory() {
        this.forwardDeque.clear();
    }

    public void link(Site site) {
        clearForwardHistory();
        backDeque.push(new Memento());
        this.currentSite = site;
    }

    public void goToPosition(int position) {
        this.currentPosition = this.currentSite.getPositions().get(position);
        if (currentPosition != null)
            this.currentPosition.show(this);
    }

    public void back() {
        if (backDeque.isEmpty())
            throw new IllegalStateException("You can not go back");
        forwardDeque.push(new Memento());
        Memento memento = backDeque.pop();
        memento.restore();
    }

    public void forward() {
        if (forwardDeque.isEmpty())
            throw new IllegalStateException("You can not go forward");
        backDeque.push(new Memento());
        Memento memento = forwardDeque.pop();
        memento.restore();
    }

    public Site getCurrentSite() {
        return currentSite;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Memento createMemento(){
        return new Memento();
    }

    class Memento{
        private Site site;
        private Position position;

        public Memento() {
            this.site = currentSite;
            this.position = currentPosition;
        }

        private void restore() {
            currentSite = site;
            currentPosition = position;
        }

    }
}
