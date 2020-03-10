package momento;

public class TextFactory implements Factory {
    @Override
    public Position create(Site site) {
        return new TextAdvertisement(site);
    }
}
