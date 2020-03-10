package momento;

public class VideoFactory implements Factory {
    @Override
    public Position create(Site site) {
        return new VideoAdvertisement(site);
    }
}
